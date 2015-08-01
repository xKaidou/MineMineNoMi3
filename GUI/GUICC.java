package MineMineNoMi3.GUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import MineMineNoMi3.Helper;
import MineMineNoMi3.Main;
import MineMineNoMi3.MainExtendedPlayer;
import MineMineNoMi3.Lists.ListMisc;
import MineMineNoMi3.Packets.PacketPlayer;
import MineMineNoMi3.Packets.PacketSync;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUICC extends GuiScreen
{
	private ResourceLocation texture = new ResourceLocation("mineminenomi", "textures/gui/gui_blank.png");
	private EntityPlayer player;
	private ItemStack helm, boots, chestplate, leggings;
	private int page = 0;
	
	public GUICC(EntityPlayer player)
	{
		this.player = player;
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
		//System.out.println(mc.fontRenderer.FONT_HEIGHT);
		
		if(this.page == 0)
			mc.fontRenderer.drawStringWithShadow("Choose a faction ", posX + 20, posY + 59, Helper.hexToInt("FFFFFF"));
		if(this.page == 1)	
			mc.fontRenderer.drawStringWithShadow("Choose a race ", posX + 20, posY + 59, Helper.hexToInt("FFFFFF"));
		if(this.page == 2)	
			mc.fontRenderer.drawStringWithShadow("Choose a job ", posX + 20, posY + 59, Helper.hexToInt("FFFFFF"));
		
		if(props.getFaction().equals("Pirate"))
			mc.fontRenderer.drawStringWithShadow("Pirate", posX + 250, posY + 59, Helper.hexToInt("FF0000"));
		if(props.getFaction().equals("Marine"))
			mc.fontRenderer.drawStringWithShadow("Marine", posX + 250, posY + 59, Helper.hexToInt("00C3FF"));
		if(props.getFaction().equals("Bounty Hunter"))
			mc.fontRenderer.drawStringWithShadow("Bounty Hunter", posX + 250, posY + 59, Helper.hexToInt("09FF00"));
		
		if(props.getRace().equals("Human"))
			mc.fontRenderer.drawStringWithShadow("Human", posX + 250, posY + 79, Helper.hexToInt("FFDD00"));
		if(props.getRace().equals("Cyborg"))
			mc.fontRenderer.drawStringWithShadow("Cyborg", posX + 250, posY + 79, Helper.hexToInt("8400FF"));
		if(props.getRace().equals("Fishman"))
			mc.fontRenderer.drawStringWithShadow("Fishman", posX + 250, posY + 79, Helper.hexToInt("4D6DFF"));
		
		if(props.getJob().equals("Swordsman"))
			mc.fontRenderer.drawStringWithShadow("Swordsman", posX + 250, posY + 99, Helper.hexToInt("A7ED93"));
		if(props.getJob().equals("Medic"))
			mc.fontRenderer.drawStringWithShadow("Medic", posX + 250, posY +99, Helper.hexToInt("ED93AA"));
		if(props.getJob().equals("Sniper"))
			mc.fontRenderer.drawStringWithShadow("Sniper", posX + 250, posY + 99, Helper.hexToInt("FF9100"));
				
		
		Helper.renderModelInGUI(posX+190, posY+200, 67, 16, 0, this.player);

		super.drawScreen(x, y, f);
	}
	
	public void initGui()
	{
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;

		this.buttonList.add(new GuiButton(100, posX + 70, posY + 190, 40, 20, "Next >"));
		
		this.buttonList.add(new GuiButton(101, posX + 10, posY + 190, 40, 20, "< Prev"));
		
		this.buttonList.add(new GuiButton(102, posX + 42, posY + 215, 40, 20, "Finish"));
		
		if(this.page == 0)
		{
			this.buttonList.add(new GuiButton(0, posX + 10, posY + 160, 100, 20, "Marine"));
			this.buttonList.add(new GuiButton(1, posX + 10, posY + 80, 100, 20, "Pirate"));
			this.buttonList.add(new GuiButton(2, posX + 10, posY + 120, 100, 20, "Bounty Hunter"));
		}
		if(this.page == 1)
		{
			this.buttonList.add(new GuiButton(4, posX + 10, posY + 160, 100, 20, "Fishman"));
			this.buttonList.add(new GuiButton(5, posX + 10, posY + 80, 100, 20, "Human"));
			this.buttonList.add(new GuiButton(6, posX + 10, posY + 120, 100, 20, "Cyborg"));		
		}
		if(this.page == 2)
		{
			this.buttonList.add(new GuiButton(8, posX + 10, posY + 160, 100, 20, "Sniper"));
			this.buttonList.add(new GuiButton(9, posX + 10, posY + 80, 100, 20, "Swordsman"));
			this.buttonList.add(new GuiButton(10, posX + 10, posY + 120, 100, 20, "Medic"));
		}
		
		this.helm = this.player.inventory.armorInventory[3];
		this.chestplate = this.player.inventory.armorInventory[2];
		this.leggings = this.player.inventory.armorInventory[1];
		this.boots = this.player.inventory.armorInventory[0];
	}
	
	public void onGuiClosed()
	{
		this.player.inventory.armorInventory[3] = this.helm;
		this.player.inventory.armorInventory[2] = this.chestplate;
		this.player.inventory.armorInventory[1] = this.leggings;
		this.player.inventory.armorInventory[0] = this.boots;
	}
	
	public void updateScreen()
	{
		if(this.page == 0)
			((GuiButton)this.buttonList.get(1)).visible = false;
		if(this.page == 2)
			((GuiButton)this.buttonList.get(0)).visible = false;
		if(this.page != 2)
			((GuiButton)this.buttonList.get(2)).visible = false;
	}
	
	public void actionPerformed(GuiButton button)
	{
		MainExtendedPlayer props = MainExtendedPlayer.get(this.player);
		
		switch (button.id)
		{
		case 102:
			if(!props.getRace().equals("N/A") && !props.getFaction().equals("N/A") && !props.getJob().equals("N/A"))
			{
				this.mc.displayGuiScreen((GuiScreen)null);
				Main.network.sendToServer(new PacketSync(props));
				Main.network.sendToServer(new PacketPlayer("delete_book"));
			}
			break;
		case 100:
			if(this.page < 2)
				this.page++;
			this.player.inventory.armorInventory[3] = this.helm;
			this.player.inventory.armorInventory[2] = this.chestplate;
			this.player.inventory.armorInventory[1] = this.leggings;
			this.player.inventory.armorInventory[0] = this.boots;
			this.mc.displayGuiScreen((GuiScreen)this);
			break;
		case 101:
			if(this.page > 0)
				this.page--;
			this.player.inventory.armorInventory[3] = this.helm;
			this.player.inventory.armorInventory[2] = this.chestplate;
			this.player.inventory.armorInventory[1] = this.leggings;
			this.player.inventory.armorInventory[0] = this.boots;
			this.mc.displayGuiScreen((GuiScreen)this);
			break;
		case 0:
			this.player.inventory.armorInventory[3] = new ItemStack(ListMisc.MarineHelm);
			this.player.inventory.armorInventory[2] = new ItemStack(ListMisc.MarineChestplate);
			this.player.inventory.armorInventory[1] = new ItemStack(ListMisc.MarineLeggings);
			this.player.inventory.armorInventory[0] = new ItemStack(ListMisc.MarineBoots);
			props.setFaction("Marine");
			break;
		case 1:
			this.player.inventory.armorInventory[3] = null;
			this.player.inventory.armorInventory[2] = new ItemStack(ListMisc.PirateChestplate);
			this.player.inventory.armorInventory[1] = new ItemStack(ListMisc.PirateLeggings);
			this.player.inventory.armorInventory[0] = new ItemStack(ListMisc.PirateBoots);
			props.setFaction("Pirate");
			break;
		case 2:
			for(int i = 0; i < this.player.inventory.armorInventory.length; i++)
				this.player.inventory.armorInventory[i] = null;
			props.setFaction("Bounty Hunter");
			break;
			
		case 4:
			props.setRace("Fishman");
			break;
			
		case 5:
			props.setRace("Human");
			break;
			
		case 6:
			props.setRace("Cyborg");
			break;
			
		case 8:
			props.setJob("Sniper");
			break;
			
		case 9:
			props.setJob("Swordsman");
			break;
			
		case 10:
			props.setJob("Medic");
			break;
		}
	}
	
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
