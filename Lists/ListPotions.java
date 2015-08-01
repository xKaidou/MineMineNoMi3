package MineMineNoMi3.Lists;

import java.lang.reflect.Field;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.potion.Potion;
import MineMineNoMi3.MainEnchantment;
import MineMineNoMi3.MainPotion;
import MineMineNoMi3.Utils.EnumToolMaterials;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ListPotions 
{

    public static Potion meramera, hiehie, pikapika, sukesuke, gomugomu, noronoro, banebane, gorogoro, opeope, mokumoku, nikyunikyu, bomubomu, guragura, kagekage
    			, sunasuna, magumagu, dorudoru, dokudoku, baribari, gasugasu, yukiyuki, jikijiki, ushiushi1, toritori1, yamiyami, itoito, toritori2, nekoneko, horohoro
    			, manemane, supasupa, hanahana, oriori, goegoe, meromero, kilokilo, horuhoru;
	
	public static Enchantment dialImpact, dialFlash, dialAxe, kairoseki;
	
	public static void init()
	{
		meramera 	= new MainPotion(30, false, 0).setIconIndex(0, 0).setPotionName("potion.meramera");
		hiehie 		= new MainPotion(31, false, 0).setIconIndex(0, 0).setPotionName("potion.hiehie");
		pikapika 	= new MainPotion(32, false, 0).setIconIndex(0, 0).setPotionName("potion.pikapika");
		sukesuke 	= new MainPotion(33, false, 0).setIconIndex(0, 0).setPotionName("potion.sukesuke");
		gomugomu 	= new MainPotion(34, false, 0).setIconIndex(0, 0).setPotionName("potion.gomugomu");
		noronoro 	= new MainPotion(35, false, 0).setIconIndex(0, 0).setPotionName("potion.noronoro");
		banebane 	= new MainPotion(36, false, 0).setIconIndex(0, 0).setPotionName("potion.banebane");
		gorogoro 	= new MainPotion(37, false, 0).setIconIndex(0, 0).setPotionName("potion.gorogoro");
		opeope 		= new MainPotion(38, false, 0).setIconIndex(0, 0).setPotionName("potion.opeope");
		mokumoku 	= new MainPotion(39, false, 0).setIconIndex(0, 0).setPotionName("potion.mokumoku");
		nikyunikyu 	= new MainPotion(40, false, 0).setIconIndex(0, 0).setPotionName("potion.nikyunikyu");
		bomubomu 	= new MainPotion(41, false, 0).setIconIndex(0, 0).setPotionName("potion.bomubomu");
		guragura 	= new MainPotion(42, false, 0).setIconIndex(0, 0).setPotionName("potion.guragura"); 
		kagekage 	= new MainPotion(43, false, 0).setIconIndex(0, 0).setPotionName("potion.kagekage");
		sunasuna 	= new MainPotion(44, false, 0).setIconIndex(0, 0).setPotionName("potion.sunasuna");
		magumagu 	= new MainPotion(45, false, 0).setIconIndex(0, 0).setPotionName("potion.magumagu");
		dorudoru 	= new MainPotion(46, false, 0).setIconIndex(0, 0).setPotionName("potion.dorudoru");
		dokudoku 	= new MainPotion(47, false, 0).setIconIndex(0, 0).setPotionName("potion.dokudoku"); 
		baribari 	= new MainPotion(48, false, 0).setIconIndex(0, 0).setPotionName("potion.baribari");
		gasugasu 	= new MainPotion(49, false, 0).setIconIndex(0, 0).setPotionName("potion.gasugasu");
		yukiyuki 	= new MainPotion(50, false, 0).setIconIndex(0, 0).setPotionName("potion.yukiyuki");
		jikijiki 	= new MainPotion(51, false, 0).setIconIndex(0, 0).setPotionName("potion.jikijiki");
		ushiushi1 	= new MainPotion(52, false, 0).setIconIndex(0, 0).setPotionName("potion.ushiushi");
		toritori1 	= new MainPotion(53, false, 0).setIconIndex(0, 0).setPotionName("potion.toritori");
		yamiyami 	= new MainPotion(54, false, 0).setIconIndex(0, 0).setPotionName("potion.yamiyami");
		itoito  	= new MainPotion(55, false, 0).setIconIndex(0, 0).setPotionName("potion.itoito");
		toritori2 	= new MainPotion(56, false, 0).setIconIndex(0, 0).setPotionName("potion.toritori");
		nekoneko 	= new MainPotion(57, false, 0).setIconIndex(0, 0).setPotionName("potion.nekoneko");
		horohoro 	= new MainPotion(58, false, 0).setIconIndex(0, 0).setPotionName("potion.horohoro");
		supasupa 	= new MainPotion(59, false, 0).setIconIndex(0, 0).setPotionName("potion.supasupa");
		meromero 	= new MainPotion(60, false, 0).setIconIndex(0, 0).setPotionName("potion.meromero");
		oriori 		= new MainPotion(61, false, 0).setIconIndex(0, 0).setPotionName("potion.oriori");
		goegoe 		= new MainPotion(62, false, 0).setIconIndex(0, 0).setPotionName("potion.goegoe");
		hanahana 	= new MainPotion(63, false, 0).setIconIndex(0, 0).setPotionName("potion.hanahana");
		kilokilo 	= new MainPotion(64, false, 0).setIconIndex(0, 0).setPotionName("potion.kilokilo");
		horuhoru 	= new MainPotion(65, false, 0).setIconIndex(0, 0).setPotionName("potion.horuhoru");

		LanguageRegistry.instance().addStringLocalization("potion.meramera", "Mera Mera no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.hiehie", "Hie Hie no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.pikapika", "Pika Pika no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.sukesuke", "Suke Suke no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.gomugomu", "Gomu Gomu no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.noronoro", "Noro Noro no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.banebane", "Bane Bane no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.gorogoro", "Goro Goro no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.opeope", "Ope Ope no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.mokumoku", "Moku Moku no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.nikyunikyu", "Nikyu Nikyu no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.bomubomu", "Bomu Bomu no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.guragura", "Gura Gura no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.kagekage", "Kage Kage no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.sunasuna", "Suna Suna no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.magumagu", "Magu Magu no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.dorudoru", "Doru Doru no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.dokudoku", "Doku Doku no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.baribari", "Bari Bari no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.gasugasu", "Gasu Gasu no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.yukiyuki", "Yuki Yuki no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.jikijiki", "Geshu Geshu no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.ushiushi", "Ushi Ushi no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.toritori", "Tori Tori no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.yamiyami", "Yami Yami no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.itoito", "Ito Ito no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.horohoro", "Horo Horo no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.manemane", "Mane Mane no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.supasupa", "Supa Supa no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.meromero", "Mero Mero no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.oriori", "Ori Ori no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.goegoe", "Goe Goe no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.hanahana", "Hana Hana no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.horuhoru", "Horu Horu no Mi");
		LanguageRegistry.instance().addStringLocalization("potion.kilokilo", "Kilo Kilo no Mi");
		
		dialImpact 	= new MainEnchantment(145	, 4	, EnumToolMaterials.impactDial	, "Impact"		, 1);
		dialFlash	= new MainEnchantment(146	, 4	, EnumToolMaterials.flashDial	, "Flash"		, 1);
		dialAxe 	= new MainEnchantment(147	, 4	, EnumToolMaterials.axeDial		, "Axe"			, 1);
		kairoseki 	= new MainEnchantment(148	, 4	, EnumToolMaterials.kairoseki	, "Kairoseki"	, 1);	
		
		LanguageRegistry.instance().addStringLocalization("enchantment.Impact", "Impact Dial");
		LanguageRegistry.instance().addStringLocalization("enchantment.Flash", "Flash Dial");
		LanguageRegistry.instance().addStringLocalization("enchantment.Axe", "Axe Dial");
		LanguageRegistry.instance().addStringLocalization("enchantment.Kairoseki", "Kairoseki");
	}
	
	public static void expandPotions()
	{
		Potion[] potionTypes = null;

		for (Field f : Potion.class.getDeclaredFields()) 
		{
			f.setAccessible(true);
			try 
			{
				if ((f.getName().equals("potionTypes")) || (f.getName().equals("field_76425_a")))
				{
					Field modfield = Field.class.getDeclaredField("modifiers");
					modfield.setAccessible(true);
					modfield.setInt(f, f.getModifiers() & 0xFFFFFFEF);
	
					potionTypes = (Potion[])f.get(null);
					Potion[] newPotionTypes = new Potion[256];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
	
					f.set(null, newPotionTypes);
		        }
			} 
			catch (Exception e) 
			{
				System.err.println("[Mine Mine no Mi] Severe error, please report this to the mod author");
				System.err.println(e);
			}
		}
	}
}