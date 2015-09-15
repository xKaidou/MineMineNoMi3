package MineMineNoMi3;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config 
{
	public static boolean allowQuests_actual;
	public static final boolean allowQuests_default = true;
	
	public static boolean resetStats_actual;
	public static final boolean resetStats_default = true;

	public static boolean allowGriefing_actual;
	public static final boolean allowGriefing_default = true;
	
	public static boolean allowDebugMode_actual;
	public static boolean allowDebugMode_default = false;
	
	public static boolean allowLogiaFly_actual;
	public static boolean allowLogiaFly_default = false;

	public static boolean allowMilkRemove_actual;
	public static final boolean allowMilkRemove_default = true;

	public static void initConfig(File configFile) 
	{
		Configuration config = new Configuration(configFile);
		
		config.load();	

		allowQuests_actual = 	config.get("Mine Mine no Mi Config", "Allow Quests"				, allowQuests_default).getBoolean(true);
		resetStats_actual = 	config.get("Mine Mine no Mi Config", "Reset Stats After Death"	, resetStats_default).getBoolean(true);
		allowLogiaFly_actual =	config.get("Mine Mine no Mi Config", "Allow Logia Fly"			, allowLogiaFly_default).getBoolean(false);
		allowDebugMode_actual = config.get("Mine Mine no Mi Config", "Allow Dev Mode"			, allowDebugMode_default).getBoolean(false);
		allowGriefing_actual = 	config.get("Mine Mine no Mi Config", "Allow Griefing"			, allowGriefing_default).getBoolean(true);	
		allowMilkRemove_actual= config.get("Mine Mine no Mi Config", "Allow Milk Removing"		, allowMilkRemove_default).getBoolean(true);
		
		config.save();		
	}
}
