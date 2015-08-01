package MineMineNoMi3;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;

public class MainFood extends ItemFood
{
	public MainFood()
	{
		super(0, 0, false);
		this.setAlwaysEdible();
	}	
	
	public void registerIcons(IIconRegister reg)
	{
		this.itemIcon = reg.registerIcon("mineminenomi:old/" + this.getUnlocalizedName().substring(5));
	} 	
}
