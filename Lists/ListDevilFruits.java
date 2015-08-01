package MineMineNoMi3.Lists;

import net.minecraft.item.Item;
import MineMineNoMi3.Helper;
import MineMineNoMi3.Items.Ability;
import MineMineNoMi3.Items.AkumaNoMi;
import MineMineNoMi3.Utils.EnumAbility;
import MineMineNoMi3.Utils.EnumFruitType;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ListDevilFruits 
{
	//				  Devil Fruit		1st Ability			 2nd Ability			3rd Ability			4th Ability				5th Ability			6th Ability
	
	public static Item MeraMeraNoMi		, Hiken				, Higan					, DaiEnkaiEntei		, Hidaruma				, Kagero			, Kyokaen;	
	public static Item HieHieNoMi		, IceBlockPartisan	, IceAge				, IceBall			, IceBlockPheasant		, IceSaber			, IceTimeCapsule;
	public static Item BaneBaneNoMi		, SpringHopper		, SpringDeathKnock		, SpringSnipe;	
	public static Item PikaPikaNoMi		, YataNoKagami		, YasakaniNoMagatama	, AmaNoMurakumo		, Amaterasu;
	
	public static Item GomuGomuNoMi		, GomuGomuNoPistol	, GomuGomuNoGatling		, GomuGomuNoRocket	, GomuGomuNoBazooka		, GomuGomuNoMuchi	, GomuGomuNoFusen;
	public static Item SukeSukeNoMi		, Skatting			, ShishaNoTe;
	public static Item OpeOpeNoMi		, Room				, Mes					, CounterShock		, GammaKnife			, Scan				, Sterben;
	public static Item NoroNoroNoMi		, NoroNoroBeam;
	
	public static Item GoroGoroNoMi		, ElThor			, VoltVari				, Raigo				, Kari					, Sango;
	public static Item MokuMokuNoMi		, WhiteSnake		, WhiteOut				, WhiteLauncher;
	public static Item NikyuNikyuNoMi	, PadHo				, UrsusShock			, Hanpatsu;
	public static Item BomuBomuNoMi		, NoseFancyCannon	, KickBomb;
	
	public static Item GuraGuraNoMi		, Kaishin			, Kabutowari			, ShimaYurashi;	
	public static Item KageKageNoMi		, BrickBat			, Doppelman				, KageKakumei		, ShadowsAsgard			, TsunoTokage;	
	public static Item SunaSunaNoMi		, DesertSpada		, Sables				, Barjan			, GroundDeath			, DesertGrandeEspada;	
	public static Item MaguMaguNoMi		, DaiFunka			, Meigo					, RyuseiKazan		, KazanBakuhatsu;	

	public static Item DoruDoruNoMi		, DoruDoruArtsMori	, DoruDoruArtsKen		, CandleWall		, CandleHouse;	
	public static Item DokuDokuNoMi		, Hydra				, ChloroBall			, VenomDemon;
	public static Item BariBariNoMi		, BarrierCrash;
	public static Item GasuGasuNoMi		, GasRobe			, Gastille				, Gastanet			, BlueSword;	
	
	public static Item YukiYukiNoMi		, Kamakura			, YukiRabi;	
	public static Item JikiJikiNoMi		, SagariNoRyusei	, Juryoku				, Moko;	
	public static Item YamiYamiNoMi		, Kurouzu			, BlackHole				, Liberation		, DarkMatter;
	public static Item ItoItoNoMi		, Parasite			, SoraNoMichi			, Overheat;
	
	public static Item HoroHoroNoMi		, NegativeHollow	, MiniHollow			, TokuHollow;
	public static Item SupaSupaNoMi		, Spider			, SparClaw				, SpiralHollow;	
	public static Item OriOriNoMi		, Bind				, AwaseBaori;
	public static Item MeroMeroNoMi		, MeroMeroMellow	, SlaveArrow			, PistolKiss;	
	
	public static Item GoeGoeNoMi		, Todoroki;	
	public static Item KiloKiloNoMi		, KiloPress			, KiloGuillotine;	
	public static Item HanaHanaNoMi		, CienFleurWing		, DosFleurClutch;
	public static Item HoruHoruNoMi		, ChiyuHormone		, TensionHormone		, EnergyHormone;
	
	public static Item BetaBetaNoMi		, BetaBetaChain		, BetoLauncher			, BetaBettonLauncher;
	public static Item IshiIshiNoMi		, Pulpostone 		, Charlestone;
	public static Item PamuPamuNoMi		, MetPunc			, JiraiPunc				, PuncBala			, PuncRockFest;
	
	public static void init()
	{
		MaguMaguNoMi = new AkumaNoMi(ListPotions.magumagu, EnumFruitType.LOGIA,
				DaiFunka = new Ability(EnumAbility.DAIFUNKA),
				Meigo = new Ability(EnumAbility.MEIGO),
				RyuseiKazan = new Ability(EnumAbility.RYUSEIKAZAN),
				KazanBakuhatsu = new Ability(EnumAbility.KAZANBAKUHATSU));
		addITEM(MaguMaguNoMi,"Magu Magu no Mi", true);
		addITEM(DaiFunka, "Dai Funka");
		addITEM(Meigo, "Meigo");
		addITEM(RyuseiKazan, "Ryusei Kazan");
		addITEM(KazanBakuhatsu, "Kazan Bakuhatsu");	
		
		SunaSunaNoMi = new AkumaNoMi(ListPotions.sunasuna, EnumFruitType.LOGIA,
				DesertSpada = new Ability(EnumAbility.DESERTSPADA),
				Sables = new Ability(EnumAbility.SABLES),
				Barjan = new Ability(EnumAbility.BARJAN),
				GroundDeath = new Ability(EnumAbility.GROUNDDEATH));
		addITEM(SunaSunaNoMi,"Suna Suna no Mi", true);
		addITEM(DesertSpada, "Desert Spada");
		addITEM(Sables, "Sables");
		addITEM(Barjan, "Barjan");
		addITEM(GroundDeath, "Ground Death");		
		
		KageKageNoMi = new AkumaNoMi(ListPotions.kagekage, EnumFruitType.PARAMECIA,
				BrickBat = new Ability(EnumAbility.BRICKBAT),
				Doppelman = new Ability(EnumAbility.DOPPELMAN), 
				KageKakumei = new Ability(EnumAbility.KAGEKAKUMEI), 
				ShadowsAsgard = new Ability(EnumAbility.SHADOWSASGARD));
		addITEM(KageKageNoMi, "Kage Kage no Mi", false);
		addITEM(BrickBat, "Brick Bat");
		addITEM(Doppelman, "Doppelman");
		addITEM(KageKakumei, "Kage Kakumei");
		addITEM(ShadowsAsgard, "Shadow's Asgard");
		
		GuraGuraNoMi = new AkumaNoMi(ListPotions.guragura, EnumFruitType.PARAMECIA,
				Kaishin = new Ability(EnumAbility.KAISHIN),
				Kabutowari = new Ability(EnumAbility.KABUTOWARI), 
				ShimaYurashi = new Ability(EnumAbility.SHIMAYURASHI), null);
		addITEM(GuraGuraNoMi, "Gura Gura no Mi", false);
		addITEM(Kaishin, "Kaishin");
		addITEM(Kabutowari, "Kabutowari");
		addITEM(ShimaYurashi, "Shima Yurashi");
		
		BomuBomuNoMi = new AkumaNoMi(ListPotions.bomubomu, EnumFruitType.PARAMECIA,
				NoseFancyCannon = new Ability(EnumAbility.NOSEFANCYCANNON),
				KickBomb = new Ability(EnumAbility.KICKBOMB), null, null);
		addITEM(BomuBomuNoMi, "Bomu Bomu no Mi", false);
		addITEM(NoseFancyCannon, "Nose Fancy Cannon");
		addITEM(KickBomb, "Kick Bomb");
		
		NikyuNikyuNoMi = new AkumaNoMi(ListPotions.nikyunikyu, EnumFruitType.PARAMECIA,
				PadHo = new Ability(EnumAbility.PADHO),
				UrsusShock = new Ability(EnumAbility.URSUSSHOCK), null, null);
		addITEM(NikyuNikyuNoMi, "Nikyu Nikyu no Mi", false);
		addITEM(PadHo, "Pad Ho");
		addITEM(UrsusShock, "Ursus Shock");
		
		MokuMokuNoMi = new AkumaNoMi(ListPotions.mokumoku, EnumFruitType.LOGIA,
				WhiteOut = new Ability(EnumAbility.WHITEOUT),
				WhiteSnake = new Ability(EnumAbility.WHITESNAKE),
				WhiteLauncher = new Ability(EnumAbility.WHITELAUNCHER), null);
		addITEM(MokuMokuNoMi, "Moku Moku no Mi", true);
		addITEM(WhiteOut, "White Out");
		addITEM(WhiteSnake, "White Snake");
		addITEM(WhiteLauncher, "White Launcher");
		
		GoroGoroNoMi = new AkumaNoMi(ListPotions.gorogoro, EnumFruitType.LOGIA,
				ElThor = new Ability(EnumAbility.ELTHOR),
				VoltVari = new Ability(EnumAbility.VOLTVARI),
				Raigo = new Ability(EnumAbility.RAIGO), null);
		addITEM(GoroGoroNoMi, "Goro Goro no Mi", true);
		addITEM(ElThor, "El Thor");
		addITEM(VoltVari, "Volt Vari");
		addITEM(Raigo, "Raigo");
		
		OpeOpeNoMi = new AkumaNoMi(ListPotions.opeope, EnumFruitType.PARAMECIA, 
				Room = new Ability(EnumAbility.ROOM), 
				CounterShock = new Ability(EnumAbility.COUNTERSHOCK), 
				Mes = new Ability(EnumAbility.MES),
				GammaKnife = new Ability(EnumAbility.GAMMAKNIFE));
		addITEM(OpeOpeNoMi,"Ope Ope no Mi", false);
		addITEM(Room,"Room");
		addITEM(CounterShock,"Counter Shock");
		addITEM(Mes,"Mes");
		addITEM(GammaKnife, "Gamma Knife");
		
		NoroNoroNoMi = new AkumaNoMi(ListPotions.noronoro, EnumFruitType.PARAMECIA, 
				NoroNoroBeam = new Ability(EnumAbility.NORONOROBEAM), null, null, null);
		addITEM(NoroNoroNoMi,"Noro Noro no Mi", false);
		addITEM(NoroNoroBeam,"Noro Noro Beam");
		
		SukeSukeNoMi = new AkumaNoMi(ListPotions.sukesuke, EnumFruitType.PARAMECIA, 
				Skatting = new Ability(EnumAbility.SKATTING), 
				ShishaNoTe = new Ability(EnumAbility.SHISHANOTE), null, null);
		addITEM(SukeSukeNoMi,"Suke Suke no Mi", false);
		addITEM(Skatting,"Skatting");
		addITEM(ShishaNoTe,"Shisha no Te");
		
		GomuGomuNoMi = new AkumaNoMi(ListPotions.gomugomu, EnumFruitType.PARAMECIA, 
				GomuGomuNoPistol = new Ability(EnumAbility.GOMUGOMUNOPISTOL), 
				GomuGomuNoRocket = new Ability(EnumAbility.GOMUGOMUNOROCKET), 
				GomuGomuNoGatling = new Ability(EnumAbility.GOMUGOMUNOGATLIN), 
				GomuGomuNoBazooka = new Ability(EnumAbility.GOMUGOMUNOBAZOOK));
		addITEM(GomuGomuNoMi,"Gomu Gomu no Mi", false);
		addITEM(GomuGomuNoPistol,"Gomu Gomu no Pistol");
		addITEM(GomuGomuNoGatling,"Gomu Gomu no Gatling");
		addITEM(GomuGomuNoRocket,"Gomu Gomu no Rocket");
		addITEM(GomuGomuNoBazooka,"Gomu Gomu no Bazooka");
		
		PikaPikaNoMi = new AkumaNoMi(ListPotions.pikapika, EnumFruitType.LOGIA, 
				YataNoKagami = new Ability(EnumAbility.YATANOKAGAMI), 
				YasakaniNoMagatama = new Ability(EnumAbility.YASAKANI),
				AmaNoMurakumo = new Ability(EnumAbility.AMANOMURAKUMO),
				Amaterasu = new Ability(EnumAbility.AMATERASU));
		addITEM(PikaPikaNoMi,"Pika Pika no Mi", true);
		addITEM(YataNoKagami,"Yata no Kagami");
		addITEM(YasakaniNoMagatama,"Yasakani no Magatama");
		addITEM(AmaNoMurakumo,"Ama no Murakumo");
		addITEM(Amaterasu,"Amaterasu");		
			
		BaneBaneNoMi = new AkumaNoMi(ListPotions.banebane, EnumFruitType.PARAMECIA, 
				SpringHopper = new Ability(EnumAbility.SPRINGHOPPER), 
				SpringDeathKnock = new Ability(EnumAbility.SPRINGDEATHKNOCK), null, null);
		addITEM(BaneBaneNoMi, "Bane Bane no Mi", false);
		addITEM(SpringHopper, "Spring Hopper");
		addITEM(SpringDeathKnock, "Spring Death Knock");	
		
		HieHieNoMi = new AkumaNoMi(ListPotions.hiehie, EnumFruitType.LOGIA, 
				IceBlockPartisan = new Ability(EnumAbility.ICEBLOCKPARTISAN), 
				IceAge = new Ability(EnumAbility.ICEAGE), 
				IceBall = new Ability(EnumAbility.ICEBALL),
				IceBlockPheasant = new Ability(EnumAbility.ICEBLOCKPHEASANT));
		addITEM(HieHieNoMi,"Hie Hie no Mi", true);
		addITEM(IceBlockPartisan,"Ice Block : Partisan");
		addITEM(IceAge,"Ice Age");
		addITEM(IceBall,"Ice Ball");
		addITEM(IceBlockPheasant,"Ice Block : Pheasant");	
		
		MeraMeraNoMi = new AkumaNoMi(ListPotions.meramera, EnumFruitType.LOGIA, 
				Hiken = new Ability(EnumAbility.HIKEN), 
				Higan = new Ability(EnumAbility.HIGAN), 
				DaiEnkaiEntei = new Ability(EnumAbility.DAIENKAIENTEI), 
				Hidaruma = new Ability(EnumAbility.HIDARUMA));
		addITEM(MeraMeraNoMi,"Mera Mera no Mi", true);
		addITEM(Hiken, "Hiken");
		addITEM(Higan, "Higan");
		addITEM(DaiEnkaiEntei, "Dai Enkai : Entei");
		addITEM(Hidaruma, "Hidaruma");		
		
	}

	private static void addITEM(Item item, String localizedName, boolean isLogia)
	{	
		if(isLogia)
			Helper.logias.add(item);	
		Helper.devilfruits.add(item);	
		String truename = localizedName.replaceAll("\\s+","").replaceAll(",", "").replaceAll(":", "").toLowerCase();
		item.setUnlocalizedName(truename);
		GameRegistry.registerItem(item, truename);
		LanguageRegistry.addName(item, localizedName);
	}
	
	private static void addITEM(Item item, String localizedName)
	{	
		Helper.abilities.add(item);	
		String truename = localizedName.replaceAll("\\s+","").replaceAll(",", "").replaceAll(":", "").toLowerCase();
		item.setUnlocalizedName(truename);
		GameRegistry.registerItem(item, truename);
		LanguageRegistry.addName(item, localizedName);
	}
	
}
