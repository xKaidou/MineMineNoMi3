package MineMineNoMi3;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config 
{
	public static boolean allowQuests_actual;
	public static final boolean allowQuests_default = true;
	
	public static boolean resetStats_actual;
	public static final boolean resetStats_default = true;

	public static boolean allowSounds_actual;
	public static final boolean allowSounds_default = false;
	
	public static boolean allow3D_actual; 
	public static final boolean allow3D_default = false;
	
	public static boolean allowGriefing_actual;
	public static final boolean allowGriefing_default = true;
	
	public static boolean allowDebugMode_actual;
	public static boolean allowDebugMode_default = false;
	
	public static boolean allowLogiaFly_actual;
	public static boolean allowLogiaFly_default = false;

	public static boolean RPallowed_actual;
	public static final boolean RPallowed_default = false;

	public static void initConfig(File configFile) 
	{
		Configuration config = new Configuration(configFile);
		
		config.load();	

		allowQuests_actual = 	config.get("Mine Mine no Mi Config", "Allow Quests"				, allowQuests_default).getBoolean(true);
		resetStats_actual = 	config.get("Mine Mine no Mi Config", "Reset Stats After Death"	, resetStats_default).getBoolean(true);
		allowSounds_actual = 	config.get("Mine Mine no Mi Config", "Allow Sounds"				, allowSounds_default).getBoolean(false);
		allow3D_actual = 		config.get("Mine Mine no Mi Config", "Allow 3D Rendering"		, allow3D_default).getBoolean(false);
		allowLogiaFly_actual =	config.get("Mine Mine no Mi Config", "Allow Logia Fly"			, allowLogiaFly_default).getBoolean(false);
		allowDebugMode_actual = config.get("Mine Mine no Mi Config", "Allow Debug Mode"			, allowDebugMode_default).getBoolean(false);
		allowGriefing_actual = 	config.get("Mine Mine no Mi Config", "Allow Griefing"			, allowGriefing_default).getBoolean(true);		
		
		config.save();		
	}
}
