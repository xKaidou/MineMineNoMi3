package MineMineNoMi3.GUI;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import MineMineNoMi3.Config;
import MineMineNoMi3.Helper;
import MineMineNoMi3.MainExtendedPlayer;
import cpw.mods.fml.common.registry.GameRegistry;

public class GUIPlayer extends GuiScreen
{
	private ResourceLocation texture = new ResourceLocation("mineminenomi", "textures/gui/gui_blank.png");
	private EntityPlayer player;
	private RenderItem renderItem;

	public GUIPlayer(EntityPlayer player)
	{
		this.player = player;
		this.renderItem = new RenderItem();
	}

	public void drawScreen(int x, int y, float f)
	{
		drawDefaultBackground();
    
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		MainExtendedPlayer props = MainExtendedPlayer.get(this.player);
    
		Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
    
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;
		drawTexturedModalRect(posX, posY + 50, 0, 0, 256, 256);

		int i = (this.width / 2) - 115;
		int j = (this.height / 2) - 65;
		int color = 16777215;		
		String text_doriki, text_faction, text_belly, text_race, text_bounty, text_job;
		boolean flag = Config.allowDebugMode_actual;		

		if(flag)
		{
			text_doriki = Helper.makeFabulous("DORIKI: " + props.getDoriki());
			text_faction = Helper.makeFabulous("ALLIANCE: " + props.getDoriki());
			text_belly = Helper.makeFabulous("BELLY: " + props.getBelly());
			text_race = Helper.makeFabulous("RACE: " + props.getRace());
			text_bounty = Helper.makeFabulous("BOUNTY: " + props.getBounty());
			text_job = Helper.makeFabulous("JOB: " + props.getJob());
		}
		else
		{
			text_doriki = EnumChatFormatting.RED + "" + EnumChatFormatting.BOLD + "DORIKI: " + EnumChatFormatting.RESET + props.getDoriki();
			text_faction = EnumChatFormatting.BLUE + "" + EnumChatFormatting.BOLD + "ALLIANCE: " + EnumChatFormatting.RESET + props.getFaction();
			text_belly = EnumChatFormatting.GOLD + "" + EnumChatFormatting.BOLD + "BELLY: " + EnumChatFormatting.RESET + props.getBelly();
			text_race = EnumChatFormatting.GREEN + "" + EnumChatFormatting.BOLD + "RACE: " + EnumChatFormatting.RESET + props.getRace();
			text_bounty = EnumChatFormatting.DARK_AQUA + "" + EnumChatFormatting.BOLD + "BOUNTY: " + EnumChatFormatting.RESET + props.getBounty();
			text_job = EnumChatFormatting.DARK_PURPLE + ""+EnumChatFormatting.BOLD + "JOB: " + EnumChatFormatting.RESET + props.getJob();
		}
	
		mc.fontRenderer.drawStringWithShadow(text_doriki, i, j, color);
		mc.fontRenderer.drawStringWithShadow(text_faction, i, j + 20, color);
		mc.fontRenderer.drawStringWithShadow(text_belly, i, j + 80, color);
		mc.fontRenderer.drawStringWithShadow(text_race, i, j + 40, color);
		mc.fontRenderer.drawStringWithShadow(text_job, i, j + 60, color);
		if(props.getFaction().equals("Pirate"))
			mc.fontRenderer.drawStringWithShadow(text_bounty, i, j + 100, color);	
		
		if(!props.getUsedFruit().equals("N/A") && !props.getUsedFruit().equals("null"))
		{
			String model = "";
			if(props.getUsedFruit().equals("ushiushibison"))
				model = "bison";
			
			ItemStack df = new ItemStack(GameRegistry.findItem("mineminenomi", props.getUsedFruit().replace(model, "")+"nomi"+model));
			mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + df.getDisplayName(), i + 17, j + 134, color);
			this.renderItem.renderItemIntoGUI(this.fontRendererObj, this.mc.renderEngine, df, i - 5, j + 130);
		}

		Helper.renderModelInGUI(posX + 190, posY + 200 , 67, 16, 0, this.player);
    
		super.drawScreen(x, y, f);
	}

	public boolean doesGuiPauseGame()
	{
		return false;
	}

}
