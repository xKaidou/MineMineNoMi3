package MineMineNoMi3;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class MainItem extends Item
{
	public MainItem() 
	{
		super();
	}
	
	public void registerIcons(IIconRegister reg)
	{
		this.itemIcon = reg.registerIcon("mineminenomi:old/" + this.getUnlocalizedName().substring(5));	
	} 	
}
