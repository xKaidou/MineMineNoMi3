package MineMineNoMi3.Utils;

import java.awt.Color;

import net.minecraft.client.model.ModelBase;
import MineMineNoMi3.Entities.Models.ModelBall;
import MineMineNoMi3.Entities.Models.ModelBird;
import MineMineNoMi3.Entities.Models.ModelCube;
import MineMineNoMi3.Entities.Models.ModelX;

public enum EnumAbility 
{
	//				I.TICKS E.DMG  E.TICKS E.EXPLO	SIDE	E.COLOR			E.MODEL			    E.SIZES	{X, Y, Z}				 E.ATTRS
	
	DAIFUNKA		(100	, 25	, 60	, 0		, 0		, "DE291F"		, new ModelCube()	, new double[] {1, .7, .7}		, new String[] {"create_lavablock"}),
	MEIGO			(200	, 40	, 3		, 0		, 0		, "DE291F"		, new ModelCube()	, new double[] {15, 1, 1}		, new String[] {"on_hit_proj_fire"}),
	RYUSEIKAZAN		(250	, 10	, 60	, 0		, 0		, "DE291F"		, new ModelCube()	, new double[] {1, .7, .7}		, new String[] {"create_lavablock"}	, true),
	KAZANBAKUHATSU	(250	, 0		, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_lavalake"}),
	
	DESERTSPADA		(150	, 0		, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_desertspada"}),
	SABLES			(80		, 0		, 0		, 0		, 0		, null			, null				, null							, new String[] {"on_hit_action_launch_5"}),
	BARJAN			(100	, 10	, 60	, 0		, 17	, "F5CF5D"		, new ModelCube()	, new double[] {1.5, 0.4, 6}	, null),
	GROUNDDEATH		(300	, 0		, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_grounddeath"}),
	
	BRICKBAT		(100	, 5		, 60	, 0		, 0		, "471F34"		, new ModelCube()	, new double[] {.5, .5, .5}		, null		, true),
	DOPPELMAN		(400	, 0		, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_doppelman"}),
	KAGEKAKUMEI		(400	, 0		, 0		, 0		, 0		, null			, null				, null							, new String[] {"event_eatshadows"}),
	SHADOWSASGARD	(150	, 5		, 60	, 0		, 0		, "471F34"		, new ModelCube()	, new double[] {3, 3, 3}		, new String[] {"morph_shadowsasgard"}),
	
	KAISHIN			(200	, 50	, 10	, 6		, 0		, null			, null				, null							, new String[] {"speed_6"}),	
	KABUTOWARI		(150	, 0		, 0		, 0		, -11	, null			, null				, null							, new String[] {"destroy_-6"}),
	SHIMAYURASHI	(150	, 20	, 60	, 0		, -11	, null			, null				, null							, new String[] {"on_hit_proj_launch_7", "destroy_4"}	, true),
	
	NOSEFANCYCANNON	(150	, 10	, 60	, 3		, -11	, "692614"		, new ModelCube()	, new double[] {3, .3, .3}		, new String[] {"speed_3"}),
	KICKBOMB		(150	, 0		, 0		, 0		, -11	, null			, null				, null							, new String[] {"destroy_-6"}),
	
	PADHO			(100	, 0		, 0		, 0		, 0		, null			, null				, null							, new String[] {"on_hit_action_launch_10"}),
	URSUSSHOCK		(250	, 20	, 60	, 5		, -11	, "C9E8F5"		, new ModelCube()	, new double[] {15, 15, 15}		, null),
	
	WHITEOUT		(150	, 10	, 60	, 0		, 0		, null			, null				, null							, new String[] {"particles_smoke"}),
	WHITESNAKE		(150	, 5		, 60	, 0		, 0		, null			, null				, null							, new String[] {"particles_smoke", "on_hit_proj_bind"}),
	WHITELAUNCHER	(250	, 0		, 100	, 0		, 0		, null			, null				, null							, new String[] {"particles_smoke", "event_teleport", "speed_6"}),
	
	ELTHOR			(250	, 0		, 0		, 8		, 0		, null			, null				, null							, new String[] {"create_elthor"}),
	VOLTVARI		(80		, 10	, 60	, 0		, 0		, "85E4FF"		, new ModelBall()	, new double[] {3, 3, 3}		, new String[] {}),
	RAIGO			(300	, 40	, 60	, 5		, 0		, "5F94A3"		, new ModelBall()	, new double[] {20, 20, 20}		, null),
	
	ROOM			(200	, 0		, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_room"}),
	COUNTERSHOCK	(150	, 45	, 2		, -2	, 0		, null			, null				, null							, null),
	MES				(150	, 30	, 0		, 0		, 0		, null			, null				, null							, new String[] {"on_hit_action_mes"}),
	GAMMAKNIFE		(600	, 40	, 3		, 0		, 0		, "C9E8F5"		, new ModelCube()	, new double[] {1.5, 1, 6}		, null),
	
	NORONOROBEAM	(80		, 10	, 60	, 0		, 2		, "F0A1E4"		, new ModelBall()	, new double[] {3, 3, 3}		, null),
	
	SKATTING		(100	, 0		, 0		, 0		, -14	, null			, null				, null							, new String[] {"on_hit_action_skatting"}),
	SHISHANOTE		(150	, 10	, 60	, 3		, 0		, null			, null				, null							, null),
	
	GOMUGOMUNOPISTOL(80		, 15	, 60	, 0		, 0		, "E8D59E"		, new ModelCube()	, new double[] {1.5, 1, 1}		, null),
	GOMUGOMUNOGATLIN(200	, 15	, 5		, 0		, 0		, "E8D59E"		, new ModelCube()	, new double[] {1.5, 1, 1}		, null		, true),
	GOMUGOMUNOROCKET(100	, 5		, 60	, 0		, 0		, "E8D59E"		, new ModelCube()	, new double[] {1.5, 1, 1}		, null),
	GOMUGOMUNOBAZOOK(80		, 30	, 60	, 0		, 0		, "E8D59E"		, new ModelCube()	, new double[] {1.5, 1, 1}		, null),
	
	YATANOKAGAMI	(100	, 0		, 100	, 0		, -3	, "FFFF00"		, new ModelCube()	, new double[] {5, .5, .5}		, new String[] {"event_teleport", "speed_10"}),
	YASAKANI		(60		, 5		, 60	, 1		, 0		, "FFFF00"		, new ModelCube()	, new double[] {5, .5, .5}		, null		, true),
	AMANOMURAKUMO	(0		, 4		, 0		, 0		, 0		, null			, null				, null							, new String[] {"sword_13"}),
	AMATERASU		(400	, 20	, 60	, 3		, -11	, "FFFF00"		, new ModelCube()	, new double[] {5, .5, .5}		, new String[] {"speed_6"}),

	SPRINGHOPPER	(100	, 2		, 0		, 0		, -8	, null			, null				, null							, null),
	SPRINGDEATHKNOCK(100	, 15	, 5		, 0		, 0		, "E6F0DC"		, new ModelCube()	, new double[] {10, 3, 3}		, null),
	
	ICEBLOCKPARTISAN(100	, 10	, 60	, 0		, 0		, "00FFFF"		, new ModelCube()	, new double[] {5, .5, .5}		, new String[] {"particles_avalanche", "create_iceblock"}	, true),
	ICEBALL			(150	, 5		, 60	, 0		, 2		, "00FFFF"		, new ModelBall()	, new double[] {5, 5, 5}		, new String[] {"create_iceball"}),
	ICEAGE			(400	, 0		, 0		, 0		, 0		, null			, null				, null							, new String[] {"create_iceage"}),
	ICEBLOCKPHEASANT(500	, 35	, 60	, 0		, 0		, "00FFFF"		, new ModelBird()	, new double[] {12, 12, 12}		, new String[] {"particles_avalanche"}),
	
	HIKEN			(200	, 10	, 60	, 2		, -11	, "FF0000"		, new ModelCube()	, new double[] {3, 1, 1}		, new String[] {"particles_vulcan", "create_fireblock"}),
	HIGAN			(60		, 4		, 60	, 0		, 0		, "FF0000"		, new ModelCube()	, new double[] {.3, .3, .3}		, new String[] {"particles_fire", "create_fireblock"}	, true),
	DAIENKAIENTEI	(500	, 20	, 60	, 8		, -11	, "FF0000"		, new ModelBall()	, new double[] {10, 10, 10}		, new String[] {"particles_vulcan"}),
	HIDARUMA		(150	, 1		, 60	, 0		, 0		, null			, null				, null							, new String[] {"particles_greenfire", "on_hit_proj_fire"}),
	
	OPEOPESLASH		(80		, 15	, 60	, 0		, 0		, "D2E2F7"		, new ModelCube()	, new double[] {1.5, 0.4, 4}	, null),
	SHIGAN			(150	, 25	, 3		, 0		, 0 	, "E8D59E"		, new ModelCube()	, new double[] {5, 1, 1}		, null),
	RANKYAKU		(150	, 20	, 60	, 0		, 0		, "69E3FF"		, new ModelCube()	, new double[] {1.5, 0.4, 6}	, new String[] {"destroy_2"}),
	AXEDIAL			(0		, 15	, 60	, 0		, 0		, "9EBDDE"		, new ModelX()		, new double[] {3, 3, 3}		, null);
	
	private int item_ticks, entity_ticks, entity_dmg, entity_explosion, entity_sideeffect;
	private Color entity_color;
	private double[] entity_scale;
	private ModelBase entity_model;
	private String[] entity_attrs;
	private boolean entity_self;

	private EnumAbility(int par1, int par2, int par3, int par4, int par5, String par6, ModelBase par7, double[] par8, String[] par9)
	{		
		this.item_ticks = par1;
		this.entity_dmg = par2;
		this.entity_ticks = par3;
		this.entity_explosion = par4;
		this.entity_sideeffect = par5;
		if(par6 != null)
			this.entity_color = Color.decode("#"+par6);
		this.entity_model = par7;
		this.entity_scale = par8;
		this.entity_attrs = par9;
	}
	
	private EnumAbility(int par1, int par2, int par3, int par4, int par5, String par6, ModelBase par7, double[] par8, String[] par9, boolean par10)
	{
		this.item_ticks = par1;
		this.entity_dmg = par2;
		this.entity_ticks = par3;
		this.entity_explosion = par4;
		this.entity_sideeffect = par5;
		if(par6 != null)
			this.entity_color = Color.decode("#"+par6);
		this.entity_model = par7;
		this.entity_scale = par8;
		this.entity_attrs = par9;
		this.entity_self = par10;
	}
	
	public int getItemTicks()
	{return item_ticks;}
	public int getEntityTicks()
	{return entity_ticks;}
	public int getEntityDmg()
	{return entity_dmg;}
	public int getEntityExplosion()
	{return entity_explosion;}
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
