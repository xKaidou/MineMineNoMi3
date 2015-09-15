package MineMineNoMi3.Items;

import java.awt.Color;
import java.util.List;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.server.FMLServerHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import MineMineNoMi3.Helper;
import MineMineNoMi3.Main;
import MineMineNoMi3.MainExtendedPlayer;
import MineMineNoMi3.MainFood;
import MineMineNoMi3.MainKeys;
import MineMineNoMi3.GUI.GUIAbilities;
import MineMineNoMi3.Lists.ListCreativeTabs;
import MineMineNoMi3.Packets.PacketSync;
import MineMineNoMi3.Utils.EnumFruitType;
import MineMineNoMi3.Utils.ja_JPSupport;

public class AkumaNoMi extends MainFood
{

	public EnumFruitType type;
	public Item ability1, ability2, ability3, ability4;
	public Item[] abilities;
	
	public AkumaNoMi(EnumFruitType type, Item[] abilities)
	{
		this.maxStackSize = 1;
		this.type = type;
		this.abilities = abilities;
		this.setCreativeTab(ListCreativeTabs.tab1);
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) 
	{
		System.out.println(MainExtendedPlayer.get(player).getUsedFruit());
		if(MainKeys.isShiftKeyDown() && this.abilities.length > 4)
			player.openGui(Main.instance, 3, world, 0, 0, 0);
		else
			player.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
		return itemStack;
	}
	
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player) 
	{
		MainExtendedPlayer props = MainExtendedPlayer.get(player);
		
		if(!props.getUsedFruit().equals("N/A") && !player.capabilities.isCreativeMode)
			player.attackEntityFrom(DamageSource.wither, Float.POSITIVE_INFINITY);
		if(props.getUsedFruit().equals("N/A"))
			props.setUsedFruit(this.getUnlocalizedName().substring(5).replace("nomi", "").replace(":", "").replace("model", ""));	
		
		if(this.type == EnumFruitType.LOGIA)
			props.setIsLogia(true);
		
		if(this.ability1 != null)
			player.inventory.addItemStackToInventory(new ItemStack(this.ability1));
		else
			if(this.abilities[0] != null)
				player.inventory.addItemStackToInventory(new ItemStack(this.abilities[0]));
		if(this.ability2 != null)
			player.inventory.addItemStackToInventory(new ItemStack(this.ability2));
		else
			if(this.abilities[1] != null)
				player.inventory.addItemStackToInventory(new ItemStack(this.abilities[1]));
		if(this.ability3 != null)
			player.inventory.addItemStackToInventory(new ItemStack(this.ability3));
		else
			if(this.abilities[2] != null)
				player.inventory.addItemStackToInventory(new ItemStack(this.abilities[2]));
		if(this.ability4 != null)
			player.inventory.addItemStackToInventory(new ItemStack(this.ability4));
		else
			if(this.abilities[3] != null)
				player.inventory.addItemStackToInventory(new ItemStack(this.abilities[3]));
		
		itemStack.stackSize--;
		return null;
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	{
		if(Minecraft.getMinecraft().gameSettings.language.equals("ja_JP"))
			list.add(ja_JPSupport.fromKanjiToHiragana(this.getItemStackDisplayName(new ItemStack(this))));
		for(int i = 0; i < this.abilities.length; i++)
		{
			if(this.abilities[i] != null)
			{
				if(Minecraft.getMinecraft().gameSettings.language.equals("ja_JP"))
					list.add(this.abilities[i].getItemStackDisplayName(new ItemStack(abilities[i])) + EnumChatFormatting.GOLD + "[" + ja_JPSupport.fromKanjiToHiragana(this.abilities[i].getItemStackDisplayName(new ItemStack(abilities[i])) + EnumChatFormatting.GOLD + "]"));
				else
					list.add(this.abilities[i].getItemStackDisplayName(new ItemStack(abilities[i])));
			}
		}
			
	  	list.add("");
	  	list.add(type.getColor() + type.getName());
	}
}
