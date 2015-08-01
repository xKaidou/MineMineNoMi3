package MineMineNoMi3.Lists;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ListCreativeTabs 
{

	
	public static void init()
	{
		LanguageRegistry.instance().addStringLocalization("itemGroup.tab1", "en_US", "Devil Fruits");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tab2", "en_US", "Weapons");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tab3", "en_US", "Speical Techniques");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tab4", "en_US", "Miscellaneous");
	}
	
	public static CreativeTabs tab1 = new CreativeTabs("tab1") {
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return ListDevilFruits.MeraMeraNoMi;
	    }
	};
	
	public static CreativeTabs tab2 = new CreativeTabs("tab2") {
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return ListMisc.basicSword;
	    }
	};
	
	public static CreativeTabs tab3 = new CreativeTabs("tab3") {
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return ListMisc.Tekkai;
	    }
	};
	
	public static CreativeTabs tab4 = new CreativeTabs("tab4") {
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return ListMisc.Kairoseki;
	    }
	};

}
