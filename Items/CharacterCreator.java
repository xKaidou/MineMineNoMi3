package MineMineNoMi3.Items;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import MineMineNoMi3.Main;
import MineMineNoMi3.MainItem;

public class CharacterCreator extends MainItem
{
	
	public ItemStack onItemRightClick(ItemStack itemStasck, World world, EntityPlayer player) 
	{
		FMLNetworkHandler.openGui(player, Main.instance, 2, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		return itemStasck;		  
	}
	
}
