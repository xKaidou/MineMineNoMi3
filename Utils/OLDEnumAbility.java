package MineMineNoMi3.Utils;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.model.ModelBase;
import MineMineNoMi3.Entities.Models.ModelBall;
import MineMineNoMi3.Entities.Models.ModelBird;
import MineMineNoMi3.Entities.Models.ModelCube;
import MineMineNoMi3.Entities.Models.ModelGhost;
import MineMineNoMi3.Entities.Models.ModelHeart;
import MineMineNoMi3.Entities.Models.ModelX;

public enum OLDEnumAbility 
{
	//				I.TICKS E.DMG  E.TICKS	SIDE	E.COLOR			E.MODEL			    E.SIZES	{X, Y, Z}				 E.ATTRS
	
	TODOROKI		(300	, 30	, 10	, -11	, "85E4FF"		, new ModelCube()	, new double[] {10, 3, 3}		, new String[] {"event_destroy_7"}	, true),
	
	MEROMEROMELLOW	(150	, 15	, 60	, 2		, "C26BD1"		, new ModelHeart()	, new double[] {7, 7, 7}		, null	, true),
	SLAVEARROW		(60		, 5		, 60	, 2		, "C26BD1"		, new ModelCube()	, new double[] {3, .3, .3}		, null	, true),
	PISTOLKISS		(100	, 10	, 60	, 2		, "C26BD1"		, new ModelHeart()	, new double[] {3, 3, 3}		, null),
	
	BIND			(100	, 5		, 60	, 2		, "ADADAD"		, new ModelBall()	, new double[] {3, 3, 3}		, null),
	AWASEBAORI		(100	, 10	, 60	, 0		, "ADADAD"		, new ModelBall()	, new double[] {3, 3, 3}		, null	, true),
	
	SPIDER			(150	, 10	, 10	, 0		, "ADADAD"		, new ModelCube()	, new double[] {.3, .3, .3}		, null	, true),
	SPARCLAW		(150	, 20	, 10	, 0		, "ADADAD"		, new ModelCube()	, new double[] {1.5, 0.4, 6}	, null),
	SPIRALHOLLOW	(200	, 20	, 10	, 0		, "ADADAD"		, new ModelCube()	, new double[] {10, 3, 3}		, null),
	
	NEGATIVEHOLLOW	(150	, 20	, 60	, 2		, "F0F0F0"		, new ModelGhost()	, new double[] {5, 5, 5}		, null),
	MINIHOLLOW		(100	, 5		, 60	, 0		, "F0F0F0"		, new ModelGhost()	, new double[] {3, 3, 3}		, null	, true),
	TOKUHOLLOW		(250	, 30	, 60	, 0		, "F0F0F0"		, new ModelGhost()	, new double[] {8, 8, 8}		, new String[] {"event_destroy_4"}),
	
	PARASITE		(100	, 10	, 60	, 2		, "F0F0F0"		, new ModelCube()	, new double[] {7, .3, .3}		, new String[] {"speed_4"}),
	SORANOMICHI		(20		, 0		, 0		, 0		, null			, null				, null							, new String[] {"event_janpu_1.6"}),
	OVERHEAT		(300	, 20	, 60	, 0		, "F0F0F0"		, new ModelCube()	, new double[] {3, .3, .3}		, new String[] {"event_destroy_2"}	, true),
	TAMAITO			(100	, 5		, 60	, 0		, "F0F0F0"		, new ModelCube()	, new double[] {2, .3, .3}		, new String[] {"speed_4"}		, true),
	
	SAGARINORYUSEI	(300	, 0		, 0		, -11	, null			, null				, null							, new String[] {"create_meteor"}),
	SAGARINORYUSEI2	(0		, 30	, 100	, 0		, "4D3333"		, new ModelCube()	, new double[] {40, 40, 40}		, new String[] {"event_destroy_10"}),
	JURYOKU			(200	, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_gravityhole"}),
	MOKO			(200	, 20	, 60	, -11	, null			, null				, null							, new String[] {"event_destroy_4"}	, true),
	
	KAMAKURA		(200	, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_kamakura"}),
	YUKIRABI		(100	, 5		, 60	, 0		, "F0F0F0"		, new ModelCube()	, new double[] {.5, .5, .5}		, null	, true),
	KAMAKURAJUSSOSHI(250	, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_kamakura2"}),
	MANNENYUKI		(500	, 0		, 0		, 0		, null			, null				, null							, new String[] {"morph_mannenyuki"}),
	TABIRAYUKI		(0		, 0		, 0		, 0		, null			, null				, null							, new String[] {"sword_10"}),
	FUBUKI			(250	, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_snowstorm"}),
	
	GASROBE			(200	, 10	, 10	, 0		, "CF79D4"		, new ModelCube()	, new double[] {10, 3, 3}		, null	, true),
	GASTILLE		(100	, 5		, 60	, 0		, "CF79D4"		, new ModelCube()	, new double[] {.3, .3, .3}		, null	, true),
	GASTANET		(150	, 0		, 0		, -11	, null			, null				, null							, new String[] {"event_destroy_5"}),
	BLUESWORD		(0		, 0		, 0		, 0		, null			, null				, null							, new String[] {"sword_10"}),
	KARAKUNI		(500	, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_emptyland"}),
	SHINOKUNI		(500	, 0		, 0		, 0		, null			, null				, null							, new String[] {"morph_shinokuni"}),
	
	HYDRA			(200	, 30	, 10	, 19	, "8E38C7"		, new ModelCube()	, new double[] {10, 3, 3}		, null),
	CHLOROBALL		(200	, 20	, 60	, 19	, "8E38C7"		, new ModelBall()	, new double[] {3, 3, 3}		, new String[] {"destroy=_2"}),
	
	DORUDORUARTSMORI(100	, 15	, 60	, 0		, "EDEDED"		, new ModelCube()	, new double[] {5, .5, .5}		, null	, true),
	DORUDORUARTSKEN	(0		, 0		, 0		, 0		, null			, null				, null							, new String[] {"sword_13"}),
	CANDLEWALL		(200	, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_candlewall"}),
	CANDLEHOUSE		(400	, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_candlehouse"}),
	
	DAIFUNKA		(100	, 25	, 60	, 0		, "DE291F"		, new ModelCube()	, new double[] {4, 3, 3}		, new String[] {"particles_vulcan", "create_lavablock"}),
	MEIGO			(200	, 40	, 10	, 0		, "DE291F"		, new ModelCube()	, new double[] {10, 3, 3}		, new String[] {"particles_vulcan", "on_hit_proj_fire"}),
	RYUSEIKAZAN		(250	, 10	, 60	, 0		, "DE291F"		, new ModelCube()	, new double[] {4, 3, 3}		, new String[] {"create_lavablock"}	, true),
	KAZANBAKUHATSU	(250	, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_lavalake"}),
	
	DESERTSPADA		(150	, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_desertspada"}),
	SABLES			(80		, 0		, 0		, 0		, null			, null				, null							, new String[] {"event_launch_5"}),
	BARJAN			(100	, 10	, 60	, 17	, "F5CF5D"		, new ModelCube()	, new double[] {1.5, 0.4, 6}	, null),
	GROUNDDEATH		(300	, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_grounddeath"}),
	
	BRICKBAT		(100	, 5		, 60	, 0		, "471F34"		, new ModelCube()	, new double[] {.5, .5, .5}		, null		, true),
	DOPPELMAN		(400	, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_doppelman"}),
	KAGEKAKUMEI		(400	, 0		, 0		, 0		, null			, null				, null							, new String[] {"event_eatshadows"}),
	SHADOWSASGARD	(150	, 5		, 60	, 0		, "471F34"		, new ModelCube()	, new double[] {3, 3, 3}		, new String[] {"morph_shadowsasgard"}),
	
	KAISHIN			(200	, 50	, 10	, 0		, null			, null				, null							, new String[] {"event_destroy_6", "speed_6"}),	
	KABUTOWARI		(150	, 0		, 0		, -11	, null			, null				, null							, new String[] {"event_destroy_6"}),
	SHIMAYURASHI	(150	, 20	, 60	, -11	, null			, null				, null							, new String[] {"event_destroy_4"}	, true),
	
	NOSEFANCYCANNON	(150	, 10	, 60	, -11	, "692614"		, new ModelCube()	, new double[] {3, .3, .3}		, new String[] {"event_destroy_3", "speed_3"}),
	KICKBOMB		(150	, 0		, 0		, -11	, null			, null				, null							, new String[] {"event_destroy_6"}),
	
	PADHO			(100	, 0		, 0		, 0		, null			, null				, null							, new String[] {"event_launch_10"}),
	URSUSSHOCK		(250	, 20	, 60	, -11	, "C9E8F5"		, new ModelCube()	, new double[] {4, 4, 4}		, new String[] {"event_destroy_10"}),
	
	WHITEOUT		(150	, 10	, 60	, 0		, null			, null				, null							, new String[] {"particles_smoke"}),
	WHITESNAKE		(150	, 5		, 60	, 2		, null			, null				, null							, new String[] {"particles_smoke"}),
	WHITELAUNCHER	(250	, 0		, 100	, 0		, null			, null				, null							, new String[] {"particles_smoke", "event_teleport", "speed_6"}),
	
	ELTHOR			(250	, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_elthor"}),
	VOLTVARI		(80		, 10	, 60	, 0		, "85E4FF"		, new ModelBall()	, new double[] {3, 3, 3}		, null),
	RAIGO			(300	, 40	, 60	, 0		, "5F94A3"		, new ModelBall()	, new double[] {20, 20, 20}		, new String[] {"event_destroy_4", "speed_3"}),
	KARI			(150	, 0		, 0		, -11	, null			, null				, null							, new String[] {"event_destroy_6"}),
	SANGO			(400	, 40	, 60	, 0		, "85E4FF"		, new ModelCube()	, new double[] {10, 3, 3}		, null),
	
	ROOM			(200	, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_room"}),
	COUNTERSHOCK	(150	, 45	, 10	, 0		, null			, null				, null							, new String[] {"event_destroy_4"}),
	MES				(150	, 30	, 0		, 0		, null			, null				, null							, new String[] {"on_hit_action_mes"}),
	GAMMAKNIFE		(600	, 40	, 60	, 0		, "C9E8F5"		, new ModelCube()	, new double[] {1.5, 1, 6}		, null),
	
	NORONOROBEAM	(80		, 10	, 60	, 2		, "F0A1E4"		, new ModelBall()	, new double[] {3, 3, 3}		, null),
	
	SKATTING		(100	, 0		, 0		, -14	, null			, null				, null							, new String[] {"on_hit_action_skatting"}),
	SHISHANOTE		(150	, 10	, 60	, 0		, null			, null				, null							, new String[] {"event_destroy_3"}),
	
	GOMUGOMUNOPISTOL(80		, 15	, 60	, 0		, "E8D59E"		, new ModelCube()	, new double[] {1.5, 1, 1}		, null),
	GOMUGOMUNOGATLIN(200	, 15	, 5		, 0		, "E8D59E"		, new ModelCube()	, new double[] {1.5, 1, 1}		, null		, true),
	GOMUGOMUNOBAZOOK(80		, 30	, 60	, 0		, "E8D59E"		, new ModelCube()	, new double[] {1.5, 1, 1}		, null),
	GEARSECOND		(200	, 0		, 0		, 0		, null			, null				, null							, new String[] {"event_gearsecond"}),
	GEARTHIRD		(400	, 0		, 0		, 0		, null			, null				, null							, new String[] {"event_gearthird"}),
	
	YATANOKAGAMI	(100	, 0		, 100	, -3	, "FFFF00"		, new ModelCube()	, new double[] {5, .5, .5}		, new String[] {"event_teleport", "speed_10"}),
	YASAKANI		(60		, 5		, 60	, 0		, "FFFF00"		, new ModelCube()	, new double[] {5, .5, .5}		, new String[] {"event_destroy_3", "speed_3"}		, true),
	AMANOMURAKUMO	(0		, 0		, 0		, 0		, null			, null				, null							, new String[] {"sword_13"}),
	AMATERASU		(400	, 20	, 60	, -11	, "FFFF00"		, new ModelCube()	, new double[] {5, .5, .5}		, new String[] {"event_destroy_4", "speed_6"}),

	SPRINGHOPPER	(200	, 2		, 0		, -8	, null			, null				, null							, null),
	SPRINGDEATHKNOCK(100	, 15	, 10	, 0		, "E6F0DC"		, new ModelCube()	, new double[] {10, 3, 3}		, null),
	
	ICEBLOCKPARTISAN(100	, 10	, 60	, 0		, "00FFFF"		, new ModelCube()	, new double[] {5, .5, .5}		, new String[] {"particles_avalanche", "create_iceblock"}	, true),
	ICEBALL			(150	, 5		, 60	, 0		, "00FFFF"		, new ModelBall()	, new double[] {5, 5, 5}		, new String[] {"create_iceball"}),
	ICEAGE			(400	, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_iceage"}),
	ICEBLOCKPHEASANT(500	, 35	, 60	, 0		, "00FFFF"		, new ModelBird()	, new double[] {12, 12, 12}		, new String[] {"particles_avalanche"}),
	ICESABER		(0		, 0		, 0		, 0		, null			, null				, null							, new String[] {"sword_10"}),
	ICETIMECAPSULE	(400	, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_icetime"}),
	
	HIKEN			(200	, 20	, 60	, -11	, "FF0000"		, new ModelCube()	, new double[] {3, 1, 1}		, new String[] {"event_destroywithfire_2", "particles_vulcan", "create_fireblock"}),
	HIGAN			(60		, 5		, 60	, 0		, "FF0000"		, new ModelCube()	, new double[] {.3, .3, .3}		, new String[] {"particles_fire", "create_fireblock"}	, true),
	DAIENKAIENTEI	(500	, 40	, 60	, -11	, "FF0000"		, new ModelBall()	, new double[] {10, 10, 10}		, new String[] {"event_destroywithfire_8", "particles_vulcan", "create_fireblock"}),
	HIDARUMA		(150	, 5		, 60	, 0		, null			, null				, null							, new String[] {"particles_greenfire", "on_hit_proj_fire"}),
	KAGERO			(150	, 5		, 60	, 0		, "FF0000"		, new ModelCube()	, new double[] {3, 1, 1}		, new String[] {"particles_fire", "create_firecross"}),
	ENJOMO			(400	, 0		, 00	, 0		, null			, null				, null							, new String[] {"create_firefence"}),	
	
	OPEOPESLASH		(80		, 15	, 60	, 0		, "D2E2F7"		, new ModelCube()	, new double[] {1.5, 0.4, 4}	, null),
	SHIGAN			(150	, 25	, 3		, 0 	, "E8D59E"		, new ModelCube()	, new double[] {5, 1, 1}		, null),
	RANKYAKU		(150	, 20	, 60	, 0		, "69E3FF"		, new ModelCube()	, new double[] {1.5, 0.4, 6}	, new String[] {"event_destroy_2"}),
	AXEDIAL			(0		, 15	, 60	, 0		, "9EBDDE"		, new ModelX()		, new double[] {3, 3, 3}		, null);
	
	private int item_ticks, entity_ticks, entity_dmg, entity_sideeffect;
	private Color entity_color;
	private double[] entity_scale;
	private ModelBase entity_model;
	private String[] entity_attrs;
	private boolean entity_self;
	
	private OLDEnumAbility(int par1, int par2, int par3, int par5, String par6, ModelBase par7, double[] par8, String[] par9)
	{		
		this.item_ticks = par1;
		this.entity_dmg = par2;
		this.entity_ticks = par3;
		this.entity_sideeffect = par5;
		if(par6 != null)
			this.entity_color = Color.decode("#"+par6);
		this.entity_model = par7;
		this.entity_scale = par8;
		this.entity_attrs = par9 != null ? par9 : new String[] {""};
	}
	
	private OLDEnumAbility(int par1, int par2, int par3, int par5, String par6, ModelBase par7, double[] par8, String[] par9, boolean par10)
	{
		this.item_ticks = par1;
		this.entity_dmg = par2;
		this.entity_ticks = par3;
		this.entity_sideeffect = par5;
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
	public int getEntitySideEffect()
	{return entity_sideeffect;}
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
