package MineMineNoMi3.Items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import MineMineNoMi3.MainExtendedPlayer;
import MineMineNoMi3.MainFood;
import MineMineNoMi3.Lists.ListCreativeTabs;
import MineMineNoMi3.Utils.EnumFruitType;

public class AkumaNoMi extends MainFood
{

	public EnumFruitType type;
	private Potion effect;
	private Item ability1, ability2, ability3, ability4;
	
	public AkumaNoMi(Potion effect, EnumFruitType type, Item ability1, Item ability2, Item ability3, Item ability4)
	{
		this.maxStackSize = 1;
		this.effect = effect;
		this.type = type;
		this.ability1 = ability1;
		this.ability2 = ability2;
		this.ability3 = ability3;
		this.ability4 = ability4;
		this.setCreativeTab(ListCreativeTabs.tab1);
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) 
	{
		player.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
		return itemStack;
	}
	
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player) 
	{
		MainExtendedPlayer props = MainExtendedPlayer.get(player);
		props.setUsedFruit(this.effect.getName().substring(7).toString());	
		if(this.type == EnumFruitType.LOGIA)
			props.setIsLogia(true);
		player.addPotionEffect(new PotionEffect(this.effect.id, (int)Float.POSITIVE_INFINITY));
		if(this.ability1 != null)
			player.inventory.addItemStackToInventory(new ItemStack(this.ability1));
		if(this.ability2 != null)
			player.inventory.addItemStackToInventory(new ItemStack(this.ability2));
		if(this.ability3 != null)
			player.inventory.addItemStackToInventory(new ItemStack(this.ability3));
		if(this.ability4 != null)
			player.inventory.addItemStackToInventory(new ItemStack(this.ability4));
		itemStack.stackSize--;
		return null;
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	{
		if(this.ability1 != null)
			list.add(this.ability1.getItemStackDisplayName(new ItemStack(ability1)));  
		if(this.ability2 != null)
			list.add(this.ability2.getItemStackDisplayName(new ItemStack(ability2)));  
		if(this.ability3 != null)
			list.add(this.ability3.getItemStackDisplayName(new ItemStack(ability3)));  
		if(this.ability4 != null)
			list.add(this.ability4.getItemStackDisplayName(new ItemStack(ability4)));  
	  	list.add("");
	  	list.add(type.getColor() + type.getName());
	}
}
