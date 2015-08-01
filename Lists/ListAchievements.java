package MineMineNoMi3.Lists;

import MineMineNoMi3.Helper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ListAchievements 
{
	public static AchievementPage MMnMAchievementPage;
	public static Achievement firstDevilFruit;
	
	public static void init()
	{
		firstDevilFruit = new Achievement("achievement.firstDevilFruit", "firstDevilFruit", 0, 0, ListDevilFruits.MeraMeraNoMi, (Achievement)null);
		LanguageRegistry.instance().addStringLocalization("achievement.firstDevilFruit", "First Devil Fruit");
		LanguageRegistry.instance().addStringLocalization("achievement.firstDevilFruit.desc", "Easter Egg !!");	
		
		MMnMAchievementPage = new AchievementPage("Mine Mine no Mi", new Achievement[] { firstDevilFruit });
		AchievementPage.registerAchievementPage(MMnMAchievementPage);
	}
	
}
