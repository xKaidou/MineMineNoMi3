package MineMineNoMi3;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class MainEnchantment extends Enchantment
{
	int max;

	public MainEnchantment(int id, int i, String name, int max)
	{
		super(id, i, EnumHelper.addEnchantmentType(name.replaceAll("\\s+","").toLowerCase().replace("dial", "")));	
		String unlocalizedName = name.replaceAll("\\s+","").toLowerCase().replace("dial", "");	
		super.setName(unlocalizedName);
		LanguageRegistry.instance().addStringLocalization("enchantment."+unlocalizedName, name);
		this.max = max;
	}

	public int getMinEnchantability(int par1)
	{
		return 10 + 20 * (par1 - 1);
	}

	public int getMaxEnchantability(int par1)
	{
		return super.getMinEnchantability(par1) + 50;
	}

	public int getMaxLevel()
	{
		return this.max;
	}

	public boolean canApply(ItemStack stack)
	{
		if ((stack.getItem() instanceof ItemSword))
			return true;
		return false;
	}

	public boolean canApplyAtEnchantingTable(ItemStack stack)
	{
		return false;
	}

	public boolean isAllowedOnBooks()
	{
		return false;
	}
}
