package MineMineNoMi3.Utils;

import java.awt.Color;

import MineMineNoMi3.Entities.Models.ModelBall;
import MineMineNoMi3.Entities.Models.ModelBird;
import MineMineNoMi3.Entities.Models.ModelCube;
import MineMineNoMi3.Entities.Models.ModelGhost;
import MineMineNoMi3.Entities.Models.ModelHeart;
import MineMineNoMi3.Entities.Models.ModelX;
import net.minecraft.client.model.ModelBase;

public class AbilityAttribute 
{
	
	public static AbilityAttribute TODOROKI			= new AbilityAttribute(300	, 30	, 10	, "85E4FF"		, new ModelCube()	, new double[] {10, 3, 3}		, new String[] {"event_destroy_7"}	, true);
	
	public static AbilityAttribute MEROMEROMELLOW	= new AbilityAttribute(150	, 15	, 60	, "C26BD1"		, new ModelHeart()	, new double[] {7, 7, 7}		, null	, true);
	public static AbilityAttribute SLAVEARROW		= new AbilityAttribute(60	, 5		, 60	, "C26BD1"		, new ModelCube()	, new double[] {3, .3, .3}		, null	, true);
	public static AbilityAttribute PISTOLKISS		= new AbilityAttribute(100	, 10	, 60	, "C26BD1"		, new ModelHeart()	, new double[] {3, 3, 3}		, null);
	
	public static AbilityAttribute BIND				= new AbilityAttribute(100	, 5		, 60	, "ADADAD"		, new ModelBall()	, new double[] {3, 3, 3}		, null);
	public static AbilityAttribute AWASEBAORI		= new AbilityAttribute(100	, 10	, 60	, "ADADAD"		, new ModelBall()	, new double[] {3, 3, 3}		, null	, true);
	
	public static AbilityAttribute SPIDER			= new AbilityAttribute(150	, 10	, 10	, "ADADAD"		, new ModelCube()	, new double[] {.3, .3, .3}		, null	, true);
	public static AbilityAttribute SPARCLAW			= new AbilityAttribute(150	, 20	, 10	, "ADADAD"		, new ModelCube()	, new double[] {1.5, 0.4, 6}	, null);
	public static AbilityAttribute SPIRALHOLLOW		= new AbilityAttribute(200	, 20	, 10	, "ADADAD"		, new ModelCube()	, new double[] {10, 3, 3}		, null);
	
	public static AbilityAttribute NEGATIVEHOLLOW	= new AbilityAttribute(150	, 20	, 60	, "F0F0F0"		, new ModelGhost()	, new double[] {5, 5, 5}		, null);
	public static AbilityAttribute MINIHOLLOW		= new AbilityAttribute(100	, 5		, 60	, "F0F0F0"		, new ModelGhost()	, new double[] {3, 3, 3}		, null	, true);
	public static AbilityAttribute TOKUHOLLOW		= new AbilityAttribute(250	, 30	, 60	, "F0F0F0"		, new ModelGhost()	, new double[] {8, 8, 8}		, new String[] {"event_destroy_4"});
	
	public static AbilityAttribute PARASITE			= new AbilityAttribute(100	, 10	, 60	, "F0F0F0"		, new ModelCube()	, new double[] {7, .3, .3}		, new String[] {"speed_4"});
	public static AbilityAttribute SORANOMICHI		= new AbilityAttribute(20	, 0		, 0		, null			, null				, null							, new String[] {"event_janpu_1.6"});
	public static AbilityAttribute OVERHEAT			= new AbilityAttribute(300	, 20	, 60	, "F0F0F0"		, new ModelCube()	, new double[] {3, .3, .3}		, new String[] {"event_destroy_2"}	, true);
	public static AbilityAttribute TAMAITO			= new AbilityAttribute(100	, 5		, 60	, "F0F0F0"		, new ModelCube()	, new double[] {2, .3, .3}		, new String[] {"speed_4"}		, true);
	
	public static AbilityAttribute SAGARINORYUSEI	= new AbilityAttribute(300	, 0		, 0		, null			, null				, null							, new String[] {"create_meteor"});
	public static AbilityAttribute SAGARINORYUSEI2	= new AbilityAttribute(0	, 30	, 100	, "4D3333"		, new ModelCube()	, new double[] {40, 40, 40}		, new String[] {"event_destroy_10"});
	public static AbilityAttribute JURYOKU			= new AbilityAttribute(200	, 0		, 0		, null			, null				, null							, new String[] {"create_gravityhole"});
	public static AbilityAttribute MOKO				= new AbilityAttribute(200	, 20	, 60	, null			, null				, null							, new String[] {"event_destroy_4"}	, true);
	
	public static AbilityAttribute KAMAKURA			= new AbilityAttribute(200	, 0		, 0		, null			, null				, null							, new String[] {"create_kamakura"});
	public static AbilityAttribute YUKIRABI			= new AbilityAttribute(100	, 5		, 60	, "F0F0F0"		, new ModelCube()	, new double[] {.5, .5, .5}		, null	, true);
	public static AbilityAttribute KAMAKURAJUSSOSHI	= new AbilityAttribute(250	, 0		, 0		, null			, null				, null							, new String[] {"create_kamakura2"});
	public static AbilityAttribute MANNENYUKI		= new AbilityAttribute(500	, 0		, 0		, null			, null				, null							, new String[] {"morph_mannenyuki"});
	public static AbilityAttribute TABIRAYUKI		= new AbilityAttribute(0	, 0		, 0		, null			, null				, null							, new String[] {"sword_10"});
	public static AbilityAttribute FUBUKI			= new AbilityAttribute(250	, 0		, 0		, null			, null				, null							, new String[] {"create_snowstorm"});
	
	public static AbilityAttribute GASROBE			= new AbilityAttribute(200	, 10	, 10	, "CF79D4"		, new ModelCube()	, new double[] {10, 3, 3}		, null	, true);
	public static AbilityAttribute GASTILLE			= new AbilityAttribute(100	, 5		, 60	, "CF79D4"		, new ModelCube()	, new double[] {.3, .3, .3}		, null	, true);
	public static AbilityAttribute GASTANET			= new AbilityAttribute(150	, 0		, 0		, null			, null				, null							, new String[] {"event_destroy_5"});
	public static AbilityAttribute BLUESWORD		= new AbilityAttribute(0	, 0		, 0		, null			, null				, null							, new String[] {"sword_10"});
	public static AbilityAttribute KARAKUNI			= new AbilityAttribute(500	, 0		, 0		, null			, null				, null							, new String[] {"create_emptyland"});
	public static AbilityAttribute SHINOKUNI		= new AbilityAttribute(500	, 0		, 0		, null			, null				, null							, new String[] {"morph_shinokuni"});
	
	public static AbilityAttribute HYDRA			= new AbilityAttribute(200	, 30	, 10	, "8E38C7"		, new ModelCube()	, new double[] {10, 3, 3}		, null);
	public static AbilityAttribute CHLOROBALL		= new AbilityAttribute(200	, 20	, 60	, "8E38C7"		, new ModelBall()	, new double[] {3, 3, 3}		, new String[] {"event_destroy_2"});
	
	public static AbilityAttribute DORUDORUARTSMORI	= new AbilityAttribute(100	, 15	, 60	, "EDEDED"		, new ModelCube()	, new double[] {5, .5, .5}		, null	, true);
	public static AbilityAttribute DORUDORUARTSKEN	= new AbilityAttribute(0	, 0		, 0		, null			, null				, null							, new String[] {"sword_13"});
	public static AbilityAttribute CANDLEWALL		= new AbilityAttribute(200	, 0		, 0		, null			, null				, null							, new String[] {"create_candlewall"});
	public static AbilityAttribute CANDLEHOUSE		= new AbilityAttribute(400	, 0		, 0		, null			, null				, null							, new String[] {"create_candlehouse"});
	
	public static AbilityAttribute DAIFUNKA			= new AbilityAttribute(100	, 25	, 60	, "DE291F"		, new ModelCube()	, new double[] {4, 3, 3}		, new String[] {"particles_vulcan", "create_lavablock"});
	public static AbilityAttribute MEIGO			= new AbilityAttribute(200	, 40	, 10	, "DE291F"		, new ModelCube()	, new double[] {10, 3, 3}		, new String[] {"particles_vulcan", "on_hit_proj_fire"});
	public static AbilityAttribute RYUSEIKAZAN		= new AbilityAttribute(250	, 10	, 60	, "DE291F"		, new ModelCube()	, new double[] {4, 3, 3}		, new String[] {"create_lavablock"}	, true);
	public static AbilityAttribute KAZANBAKUHATSU	= new AbilityAttribute(250	, 0		, 0		, null			, null				, null							, new String[] {"create_lavalake"});
	
	public static AbilityAttribute DESERTSPADA		= new AbilityAttribute(150	, 0		, 0		, null			, null				, null							, new String[] {"create_desertspada"});
	public static AbilityAttribute SABLES			= new AbilityAttribute(80	, 0		, 0		, null			, null				, null							, new String[] {"event_launch_5"});
	public static AbilityAttribute BARJAN			= new AbilityAttribute(100	, 10	, 60	, "F5CF5D"		, new ModelCube()	, new double[] {1.5, 0.4, 6}	, null);
	public static AbilityAttribute GROUNDDEATH		= new AbilityAttribute(300	, 0		, 0		, null			, null				, null							, new String[] {"create_grounddeath"});
	
	public static AbilityAttribute BRICKBAT			= new AbilityAttribute(100	, 5		, 60	, "471F34"		, new ModelCube()	, new double[] {.5, .5, .5}		, null		, true);
	public static AbilityAttribute DOPPELMAN		= new AbilityAttribute(400	, 0		, 0		, null			, null				, null							, new String[] {"create_doppelman"});
	public static AbilityAttribute KAGEKAKUMEI		= new AbilityAttribute(400	, 0		, 0		, null			, null				, null							, new String[] {"event_eatshadows"});
	public static AbilityAttribute SHADOWSASGARD	= new AbilityAttribute(150	, 5		, 60	, "471F34"		, new ModelCube()	, new double[] {3, 3, 3}		, new String[] {"morph_shadowsasgard"});
	
	public static AbilityAttribute KAISHIN			= new AbilityAttribute(200	, 50	, 10	, null			, null				, null							, new String[] {"event_destroy_6", "speed_6"});	
	public static AbilityAttribute KABUTOWARI		= new AbilityAttribute(150	, 0		, 0		, null			, null				, null							, new String[] {"event_destroy_6"});
	public static AbilityAttribute SHIMAYURASHI		= new AbilityAttribute(150	, 20	, 60	, null			, null				, null							, new String[] {"event_destroy_4"}	, true);
	
	public static AbilityAttribute NOSEFANCYCANNON	= new AbilityAttribute(150	, 10	, 60	, "692614"		, new ModelCube()	, new double[] {3, .3, .3}		, new String[] {"event_destroy_3", "speed_3"});
	public static AbilityAttribute KICKBOMB			= new AbilityAttribute(150	, 0		, 0		, null			, null				, null							, new String[] {"event_destroy_6"});
	
	public static AbilityAttribute PADHO			= new AbilityAttribute(100	, 0		, 0		, null			, null				, null							, new String[] {"event_launch_10"});
	public static AbilityAttribute URSUSSHOCK		= new AbilityAttribute(250	, 20	, 60	, "C9E8F5"		, new ModelCube()	, new double[] {4, 4, 4}		, new String[] {"event_destroy_10"});
	
	public static AbilityAttribute WHITEOUT			= new AbilityAttribute(150	, 10	, 60	, null			, null				, null							, new String[] {"particles_smoke"});
	public static AbilityAttribute WHITESNAKE		= new AbilityAttribute(150	, 5		, 60	, null			, null				, null							, new String[] {"particles_smoke"});
	public static AbilityAttribute WHITELAUNCHER	= new AbilityAttribute(250	, 0		, 100	, null			, null				, null							, new String[] {"particles_smoke", "event_teleport", "speed_6"});
	
	public static AbilityAttribute ELTHOR			= new AbilityAttribute(250	, 0		, 0		, null			, null				, null							, new String[] {"create_elthor"});
	public static AbilityAttribute VOLTVARI			= new AbilityAttribute(80	, 10	, 60	, "85E4FF"		, new ModelBall()	, new double[] {3, 3, 3}		, null);
	public static AbilityAttribute RAIGO			= new AbilityAttribute(300	, 40	, 60	, "5F94A3"		, new ModelBall()	, new double[] {20, 20, 20}		, new String[] {"event_destroy_4", "speed_3"});
	public static AbilityAttribute KARI				= new AbilityAttribute(150	, 0		, 0		, null			, null				, null							, new String[] {"event_destroy_6"});
	public static AbilityAttribute SANGO			= new AbilityAttribute(400	, 40	, 60	, "85E4FF"		, new ModelCube()	, new double[] {10, 3, 3}		, null);
	
	public static AbilityAttribute ROOM				= new AbilityAttribute(200	, 0		, 0		, null			, null				, null							, new String[] {"create_room"});
	public static AbilityAttribute COUNTERSHOCK		= new AbilityAttribute(150	, 45	, 10	, null			, null				, null							, new String[] {"event_destroy_4"});
	public static AbilityAttribute MES				= new AbilityAttribute(150	, 30	, 0		, null			, null				, null							, new String[] {"on_hit_action_mes"});
	public static AbilityAttribute GAMMAKNIFE		= new AbilityAttribute(600	, 40	, 60	, "C9E8F5"		, new ModelCube()	, new double[] {1.5, 1, 6}		, null);
	
	public static AbilityAttribute NORONOROBEAM		= new AbilityAttribute(80	, 10	, 60	, "F0A1E4"		, new ModelBall()	, new double[] {3, 3, 3}		, null);
	
	public static AbilityAttribute SKATTING			= new AbilityAttribute(100	, 0		, 0		, null			, null				, null							, new String[] {"on_hit_action_skatting"});
	public static AbilityAttribute SHISHANOTE		= new AbilityAttribute(150	, 10	, 60	, null			, null				, null							, new String[] {"event_destroy_3"});
	
	public static AbilityAttribute GOMUGOMUNOPISTOL	= new AbilityAttribute(80	, 15	, 60	, "E8D59E"		, new ModelCube()	, new double[] {1.5, 1, 1}		, null);
	public static AbilityAttribute GOMUGOMUNOGATLIN	= new AbilityAttribute(200	, 15	, 5		, "E8D59E"		, new ModelCube()	, new double[] {1.5, 1, 1}		, null		, true);
	public static AbilityAttribute GOMUGOMUNOBAZOOK	= new AbilityAttribute(80	, 30	, 60	, "E8D59E"		, new ModelCube()	, new double[] {1.5, 1, 1}		, null);
	public static AbilityAttribute GEARSECOND		= new AbilityAttribute(200	, 0		, 0		, null			, null				, null							, new String[] {"event_gearsecond"});
	public static AbilityAttribute GEARTHIRD		= new AbilityAttribute(400	, 0		, 0		, null			, null				, null							, new String[] {"event_gearthird"});
	
	public static AbilityAttribute YATANOKAGAMI		= new AbilityAttribute(100	, 0		, 100	, "FFFF00"		, new ModelCube()	, new double[] {5, .5, .5}		, new String[] {"event_teleport", "speed_10"});
	public static AbilityAttribute YASAKANI			= new AbilityAttribute(60	, 5		, 60	, "FFFF00"		, new ModelCube()	, new double[] {5, .5, .5}		, new String[] {"event_destroy_3", "speed_3"}		, true);
	public static AbilityAttribute AMANOMURAKUMO	= new AbilityAttribute(0	, 0		, 0		, null			, null				, null							, new String[] {"sword_13"});
	public static AbilityAttribute AMATERASU		= new AbilityAttribute(400	, 20	, 60	, "FFFF00"		, new ModelCube()	, new double[] {5, .5, .5}		, new String[] {"event_destroy_4", "speed_6"});

	public static AbilityAttribute SPRINGHOPPER		= new AbilityAttribute(200	, 2		, 0		, null			, null				, null							, null);
	public static AbilityAttribute SPRINGDEATHKNOCK	= new AbilityAttribute(100	, 15	, 10	, "E6F0DC"		, new ModelCube()	, new double[] {10, 3, 3}		, null);
	
	public static AbilityAttribute ICEBLOCKPARTISAN	= new AbilityAttribute(100	, 10	, 60	, "00FFFF"		, new ModelCube()	, new double[] {5, .5, .5}		, new String[] {"particles_avalanche", "create_iceblock"}	, true);
	public static AbilityAttribute ICEBALL			= new AbilityAttribute(150	, 5		, 60	, "00FFFF"		, new ModelBall()	, new double[] {5, 5, 5}		, new String[] {"create_iceball"});
	public static AbilityAttribute ICEAGE			= new AbilityAttribute(400	, 0		, 0		, null			, null				, null							, new String[] {"create_iceage"});
	public static AbilityAttribute ICEBLOCKPHEASANT	= new AbilityAttribute(500	, 35	, 60	, "00FFFF"		, new ModelBird()	, new double[] {12, 12, 12}		, new String[] {"particles_avalanche"});
	public static AbilityAttribute ICESABER			= new AbilityAttribute(0	, 0		, 0		, null			, null				, null							, new String[] {"sword_10"});
	public static AbilityAttribute ICETIMECAPSULE	= new AbilityAttribute(400	, 0		, 0		, null			, null				, null							, new String[] {"create_icetime"});
	
	public static AbilityAttribute HIKEN 			= new AbilityAttribute(200	, 20	, 60	, "FF0000"		, new ModelCube()	, new double[] {3, 1, 1}		, new String[] {"event_destroywithfire_2", "particles_vulcan", "create_fireblock"});
	public static AbilityAttribute HIGAN		 	= new AbilityAttribute(60	, 5		, 60	, "FF0000"		, new ModelCube()	, new double[] {.3, .3, .3}		, new String[] {"particles_fire", "create_fireblock"}	, true);
	public static AbilityAttribute DAIENKAIENTEI 	= new AbilityAttribute(500	, 40	, 60	, "FF0000"		, new ModelBall()	, new double[] {10, 10, 10}		, new String[] {"event_destroywithfire_8", "particles_vulcan", "create_fireblock"});
	public static AbilityAttribute HIDARUMA			= new AbilityAttribute(150	, 5		, 60	, null			, null				, null							, new String[] {"particles_greenfire", "event_potion_blazeIt"});
	public static AbilityAttribute KAGERO 			= new AbilityAttribute(150	, 5		, 60	, "FF0000"		, new ModelCube()	, new double[] {3, 1, 1}		, new String[] {"particles_fire", "create_firecross"});
	public static AbilityAttribute ENJOMO 			= new AbilityAttribute(400	, 0		, 00	, null			, null				, null							, new String[] {"create_firefence"});
	
	public static AbilityAttribute OPEOPESLASH		= new AbilityAttribute(80	, 15	, 60	, "D2E2F7"		, new ModelCube()	, new double[] {1.5, 0.4, 4}	, null);
	public static AbilityAttribute SHIGAN			= new AbilityAttribute(150	, 25	, 3		, "E8D59E"		, new ModelCube()	, new double[] {5, 1, 1}		, null);
	public static AbilityAttribute RANKYAKU			= new AbilityAttribute(150	, 20	, 60	, "69E3FF"		, new ModelCube()	, new double[] {1.5, 0.4, 6}	, new String[] {"event_destroy_2"});
	public static AbilityAttribute AXEDIAL			= new AbilityAttribute(0	, 15	, 60	, "9EBDDE"		, new ModelX()		, new double[] {3, 3, 3}		, null);

	private int item_ticks, entity_ticks, entity_dmg;
	private Color entity_color;
	private double[] entity_scale;
	private ModelBase entity_model;
	private String[] entity_attrs;
	private boolean entity_self;
	
	public AbilityAttribute(int par1, int par2, int par3, String par6, ModelBase par7, double[] par8, String[] par9)
	{		
		this.item_ticks = par1;
		this.entity_dmg = par2;
		this.entity_ticks = par3;
		if(par6 != null)
			this.entity_color = Color.decode("#"+par6);
		this.entity_model = par7;
		this.entity_scale = par8;
		this.entity_attrs = par9 != null ? par9 : new String[] {""};
	}
	
	public AbilityAttribute(int par1, int par2, int par3, String par6, ModelBase par7, double[] par8, String[] par9, boolean par10)
	{
		this.item_ticks = par1;
		this.entity_dmg = par2;
		this.entity_ticks = par3;
		if(par6 != null)
			this.entity_color = Color.decode("#"+par6);
		this.entity_model = par7;
		this.entity_scale = par8;
		this.entity_attrs = par9 != null ? par9 : new String[] {""};
		this.entity_self = par10;
	}
	
	public int getItemTicks()
	{return item_ticks;}
	public int getEntityTicks()
	{return entity_ticks;}
	public int getEntityDmg()
	{return entity_dmg;}
	public Color getEntityColor()
	{return entity_color;}
	public ModelBase getEntityModel()
	{return entity_model;}
	public double[] getEntityScale()
	{return entity_scale;}
	public String[] getEntityAttr()
	{return entity_attrs;}
	public boolean getEntityRepeat()
	{return entity_self;}
	
}
