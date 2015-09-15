package MineMineNoMi3.Lists;

import net.minecraft.item.Item;
import MineMineNoMi3.Helper;
import MineMineNoMi3.Items.Ability;
import MineMineNoMi3.Items.AkumaNoMi;
import MineMineNoMi3.Utils.AbilityAttribute;
import MineMineNoMi3.Utils.AbilityAttribute;
import MineMineNoMi3.Utils.EnumFruitType;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ListDevilFruits 
{
	//				  Devil Fruit			1st Ability			 	2nd Ability				3rd Ability			4th Ability				5th Ability			6th Ability
	
	public static Item MeraMeraNoMi			, Hiken					, Higan					, DaiEnkaiEntei		, Hidaruma				, Kagero			, Enjomo;	
	public static Item HieHieNoMi			, IceBlockPartisan		, IceAge				, IceBall			, IceBlockPheasant		, IceSaber			, IceTimeCapsule;
	public static Item BaneBaneNoMi			, SpringHopper			, SpringDeathKnock		, SpringSnipe;	
	public static Item PikaPikaNoMi			, YataNoKagami			, YasakaniNoMagatama	, AmaNoMurakumo		, Amaterasu;
	
	public static Item GomuGomuNoMi			, GomuGomuNoPistol		, GomuGomuNoGatling		, GearSecond		, GearThird				, GomuGomuNoBazooka	, GomuGomuNoFusen;
	public static Item SukeSukeNoMi			, Skatting				, ShishaNoTe;
	public static Item OpeOpeNoMi			, Room					, Mes					, CounterShock		, GammaKnife			, Scan				, Sterben;
	public static Item NoroNoroNoMi			, NoroNoroBeam;	
	
	public static Item GoroGoroNoMi			, ElThor				, VoltVari				, Raigo				, Kari					, Sango;
	public static Item MokuMokuNoMi			, WhiteSnake			, WhiteOut				, WhiteLauncher;
	public static Item NikyuNikyuNoMi		, PadHo					, UrsusShock			, Hanpatsu;
	public static Item BomuBomuNoMi			, NoseFancyCannon		, KickBomb;
	
	public static Item GuraGuraNoMi			, Kaishin				, Kabutowari			, ShimaYurashi;	
	public static Item KageKageNoMi			, BrickBat				, Doppelman				, KageKakumei		, ShadowsAsgard			, TsunoTokage;	
	public static Item SunaSunaNoMi			, DesertSpada			, Sables				, Barjan			, GroundDeath			, DesertGrandeEspada;	
	public static Item MaguMaguNoMi			, DaiFunka				, Meigo					, RyuseiKazan		, KazanBakuhatsu;	

	public static Item DoruDoruNoMi			, DoruDoruArtsMori		, DoruDoruArtsKen		, CandleWall		, CandleHouse;	
	public static Item DokuDokuNoMi			, Hydra					, ChloroBall			, VenomDemon;
	public static Item BariBariNoMi			, BarrierCrash;
	public static Item GasuGasuNoMi			, GasRobe				, Gastille				, Gastanet			, BlueSword				, Karakuni			, Shinokuni;	
	
	public static Item YukiYukiNoMi			, Kamakura				, YukiRabi				, KamakuraJussoshi	, MannenYuki			, TabiraYuki		, Fubuki;	
	public static Item JikiJikiNoMi			, SagariNoRyusei		, Juryoku				, Moko;	
	public static Item YamiYamiNoMi			, Kurouzu				, BlackHole				, Liberation		, DarkMatter;
	public static Item ItoItoNoMi			, Parasite				, SoraNoMichi			, Overheat			, Tamaito				, Torikago;
	
	public static Item HoroHoroNoMi			, NegativeHollow		, MiniHollow			, TokuHollow;
	public static Item SupaSupaNoMi			, Spider				, SparClaw				, SpiralHollow;	
	public static Item OriOriNoMi			, Bind					, AwaseBaori;
	public static Item MeroMeroNoMi			, MeroMeroMellow		, SlaveArrow			, PistolKiss;	
	
	public static Item GoeGoeNoMi			, Todoroki;	
	public static Item KiloKiloNoMi			, KiloPress				, KiloGuillotine;	
	public static Item HanaHanaNoMi			, CienFleurWing			, DosFleurClutch;
	public static Item HoruHoruNoMi			, ChiyuHormone			, TensionHormone		, EnergyHormone;
	
	public static Item BetaBetaNoMi			, BetaBetaChain			, BetoLauncher			, BetaBettonLauncher;
	public static Item IshiIshiNoMi			, Pulpostone 			, Charlestone;
	public static Item PamuPamuNoMi			, MetPunc				, JiraiPunc				, PuncBala			, PuncRockFest;
	public static Item UshiUshiNoMiBison	, FiddleBanff			, HighJump;
	
	public static void init()
	{
		UshiUshiNoMiBison = new AkumaNoMi(EnumFruitType.ZOAN,
				new Item[] {null, null, null, null});
		addITEM(UshiUshiNoMiBison, "Ushi Ushi no Mi : Model Bison", false);

		GoeGoeNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA,
				new Item[] {Todoroki = new Ability(AbilityAttribute.TODOROKI), null, null, null});
		addITEM(GoeGoeNoMi, "Goe Goe no Mi", false);
		addITEM(Todoroki, "Todoroki");
		
		MeroMeroNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA,
				new Item[] {MeroMeroMellow = new Ability(AbilityAttribute.MEROMEROMELLOW),
				SlaveArrow = new Ability(AbilityAttribute.SLAVEARROW),
				PistolKiss = new Ability(AbilityAttribute.PISTOLKISS), null});
		addITEM(MeroMeroNoMi, "Mero Mero no Mi", false);
		addITEM(MeroMeroMellow, "Mero Mero Mellow");
		addITEM(SlaveArrow, "Slave Arrow");	
		addITEM(PistolKiss, "Pistol Kiss");			
		
		OriOriNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA,
				new Item[] {Bind = new Ability(AbilityAttribute.BIND),
				AwaseBaori = new Ability(AbilityAttribute.AWASEBAORI), null, null});
		addITEM(OriOriNoMi, "Ori Ori no Mi", false);
		addITEM(Bind, "Bind");
		addITEM(AwaseBaori, "Awase Baori");	
		
		SupaSupaNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA,
				new Item[] {Spider = new Ability(AbilityAttribute.SPIDER),
				SparClaw = new Ability(AbilityAttribute.SPARCLAW),
				SpiralHollow = new Ability(AbilityAttribute.SPIRALHOLLOW), null});
		addITEM(SupaSupaNoMi, "Supa Supa no Mi", false);
		addITEM(Spider, "Spider");
		addITEM(SparClaw, "Spar Claw");	
		addITEM(SpiralHollow, "Spiral Hollow");		
		
		HoroHoroNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA,
				new Item[] {NegativeHollow = new Ability(AbilityAttribute.NEGATIVEHOLLOW),
				MiniHollow = new Ability(AbilityAttribute.MINIHOLLOW),
				TokuHollow = new Ability(AbilityAttribute.TOKUHOLLOW), null});
		addITEM(HoroHoroNoMi, "Horo Horo no Mi", false);
		addITEM(NegativeHollow, "Negative Hollow");
		addITEM(MiniHollow, "Mini Hollow");	
		addITEM(TokuHollow, "Toku Hollow");	
		
		ItoItoNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA,
				new Item[] {Parasite = new Ability(AbilityAttribute.PARASITE),
				SoraNoMichi = new Ability(AbilityAttribute.SORANOMICHI),
				Overheat = new Ability(AbilityAttribute.OVERHEAT),
				Tamaito = new Ability(AbilityAttribute.TAMAITO)});
		addITEM(ItoItoNoMi, "Ito Ito no Mi", false);
		addITEM(Parasite, "Parasite");
		addITEM(Overheat, "Overheat");	
		addITEM(SoraNoMichi, "Sora no Michi");	
		addITEM(Tamaito, "Tamaito");
		
		JikiJikiNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA,
				new Item[] {SagariNoRyusei = new Ability(AbilityAttribute.SAGARINORYUSEI),
				Juryoku = new Ability(AbilityAttribute.JURYOKU),
				Moko = new Ability(AbilityAttribute.MOKO), null});
		addITEM(JikiJikiNoMi, "Jiki Jiki no Mi", false);
		addITEM(SagariNoRyusei, "Sagari no Ryusei");
		addITEM(Juryoku, "Juryoku");	
		addITEM(Moko, "Moko");	
		
		YukiYukiNoMi = new AkumaNoMi(EnumFruitType.LOGIA,
				new Item[] {Kamakura = new Ability(AbilityAttribute.KAMAKURA),
				YukiRabi = new Ability(AbilityAttribute.YUKIRABI),
				KamakuraJussoshi = new Ability(AbilityAttribute.KAMAKURAJUSSOSHI),
				MannenYuki = new Ability(AbilityAttribute.MANNENYUKI),
				TabiraYuki = new Ability(AbilityAttribute.TABIRAYUKI),
				Fubuki = new Ability(AbilityAttribute.FUBUKI)});
		addITEM(YukiYukiNoMi, "Yuki Yuki no Mi", true);
		addITEM(Kamakura, "Kamakura");
		addITEM(YukiRabi, "Yuki Rabi");	
		addITEM(KamakuraJussoshi, "Kamakura Jussoshi");
		addITEM(MannenYuki, "Mannen Yuki");	
		addITEM(TabiraYuki, "Tabira Yuki");
		addITEM(Fubuki, "Fubuki");	
		
		GasuGasuNoMi = new AkumaNoMi(EnumFruitType.LOGIA,
				new Item[] {GasRobe = new Ability(AbilityAttribute.GASROBE),
				Gastille = new Ability(AbilityAttribute.GASTILLE),
				Gastanet = new Ability(AbilityAttribute.GASTANET),
				BlueSword = new Ability(AbilityAttribute.BLUESWORD),
				Karakuni = new Ability(AbilityAttribute.KARAKUNI),
				Shinokuni = new Ability(AbilityAttribute.SHINOKUNI)});
		addITEM(GasuGasuNoMi, "Gasu Gasu no Mi", true);
		addITEM(GasRobe, "Gas Robe");
		addITEM(Gastille, "Gastille");	
		addITEM(Gastanet, "Gastanet");
		addITEM(BlueSword, "Blue Sword");	
		addITEM(Karakuni, "Karakuni");
		addITEM(Shinokuni, "Shinokuni");	
		
		DokuDokuNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA,
				new Item[] {Hydra = new Ability(AbilityAttribute.HYDRA),
				ChloroBall = new Ability(AbilityAttribute.CHLOROBALL), null, null});
		addITEM(DokuDokuNoMi, "Doku Doku no Mi", false);
		addITEM(Hydra, "Hydra");
		addITEM(ChloroBall, "Chloro Ball");	
		
		DoruDoruNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA,
				new Item[] {DoruDoruArtsMori = new Ability(AbilityAttribute.DORUDORUARTSMORI),
				DoruDoruArtsKen = new Ability(AbilityAttribute.DORUDORUARTSKEN),
				CandleWall = new Ability(AbilityAttribute.CANDLEWALL),
				CandleHouse = new Ability(AbilityAttribute.CANDLEHOUSE)});
		addITEM(DoruDoruNoMi, "Doru Doru no Mi", false);
		addITEM(DoruDoruArtsMori, "Doru Doru Arts : Mori");
		addITEM(DoruDoruArtsKen, "Doru Doru Arts : Ken");
		addITEM(CandleWall, "Candle Wall");
		addITEM(CandleHouse, "Candle House");	
		
		MaguMaguNoMi = new AkumaNoMi(EnumFruitType.LOGIA,
				new Item[] {DaiFunka = new Ability(AbilityAttribute.DAIFUNKA),
				Meigo = new Ability(AbilityAttribute.MEIGO),
				RyuseiKazan = new Ability(AbilityAttribute.RYUSEIKAZAN),
				KazanBakuhatsu = new Ability(AbilityAttribute.KAZANBAKUHATSU)});
		addITEM(MaguMaguNoMi,"Magu Magu no Mi", true);
		addITEM(DaiFunka, "Dai Funka");
		addITEM(Meigo, "Meigo");
		addITEM(RyuseiKazan, "Ryusei Kazan");
		addITEM(KazanBakuhatsu, "Kazan Bakuhatsu");	
		
		SunaSunaNoMi = new AkumaNoMi(EnumFruitType.LOGIA,
				new Item[] {DesertSpada = new Ability(AbilityAttribute.DESERTSPADA),
				Sables = new Ability(AbilityAttribute.SABLES),
				Barjan = new Ability(AbilityAttribute.BARJAN),
				GroundDeath = new Ability(AbilityAttribute.GROUNDDEATH)});
		addITEM(SunaSunaNoMi,"Suna Suna no Mi", true);
		addITEM(DesertSpada, "Desert Spada");
		addITEM(Sables, "Sables");
		addITEM(Barjan, "Barjan");
		addITEM(GroundDeath, "Ground Death");		
		
		KageKageNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA,
				new Item[] {BrickBat = new Ability(AbilityAttribute.BRICKBAT),
				Doppelman = new Ability(AbilityAttribute.DOPPELMAN), 
				KageKakumei = new Ability(AbilityAttribute.KAGEKAKUMEI), 
				ShadowsAsgard = new Ability(AbilityAttribute.SHADOWSASGARD)});
		addITEM(KageKageNoMi, "Kage Kage no Mi", false);
		addITEM(BrickBat, "Brick Bat");
		addITEM(Doppelman, "Doppelman");
		addITEM(KageKakumei, "Kage Kakumei");
		addITEM(ShadowsAsgard, "Shadow's Asgard");
		
		GuraGuraNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA,
				new Item[] {Kaishin = new Ability(AbilityAttribute.KAISHIN),
				Kabutowari = new Ability(AbilityAttribute.KABUTOWARI), 
				ShimaYurashi = new Ability(AbilityAttribute.SHIMAYURASHI), null});
		addITEM(GuraGuraNoMi, "Gura Gura no Mi", false);
		addITEM(Kaishin, "Kaishin");
		addITEM(Kabutowari, "Kabutowari");
		addITEM(ShimaYurashi, "Shima Yurashi");
		
		BomuBomuNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA,
				new Item[] {NoseFancyCannon = new Ability(AbilityAttribute.NOSEFANCYCANNON),
				KickBomb = new Ability(AbilityAttribute.KICKBOMB), null, null});
		addITEM(BomuBomuNoMi, "Bomu Bomu no Mi", false);
		addITEM(NoseFancyCannon, "Nose Fancy Cannon");
		addITEM(KickBomb, "Kick Bomb");
		
		NikyuNikyuNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA,
				new Item[] {PadHo = new Ability(AbilityAttribute.PADHO),
				UrsusShock = new Ability(AbilityAttribute.URSUSSHOCK), null, null});
		addITEM(NikyuNikyuNoMi, "Nikyu Nikyu no Mi", false);
		addITEM(PadHo, "Pad Ho");
		addITEM(UrsusShock, "Ursus Shock");
		
		MokuMokuNoMi = new AkumaNoMi(EnumFruitType.LOGIA,
				new Item[] {WhiteOut = new Ability(AbilityAttribute.WHITEOUT),
				WhiteSnake = new Ability(AbilityAttribute.WHITESNAKE),
				WhiteLauncher = new Ability(AbilityAttribute.WHITELAUNCHER), null});
		addITEM(MokuMokuNoMi, "Moku Moku no Mi", true);
		addITEM(WhiteOut, "White Out");
		addITEM(WhiteSnake, "White Snake");
		addITEM(WhiteLauncher, "White Launcher");
		
		GoroGoroNoMi = new AkumaNoMi(EnumFruitType.LOGIA,
				new Item[] {ElThor = new Ability(AbilityAttribute.ELTHOR),
				VoltVari = new Ability(AbilityAttribute.VOLTVARI),
				Raigo = new Ability(AbilityAttribute.RAIGO),
				Kari = new Ability(AbilityAttribute.KARI),
				Sango = new Ability(AbilityAttribute.SANGO)});
		addITEM(GoroGoroNoMi, "Goro Goro no Mi", true);
		addITEM(ElThor, "El Thor");
		addITEM(VoltVari, "Volt Vari");
		addITEM(Raigo, "Raigo");
		addITEM(Kari, "Kari");
		addITEM(Sango, "Sango");
		
		OpeOpeNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, 
				new Item[] {Room = new Ability(AbilityAttribute.ROOM), 
				CounterShock = new Ability(AbilityAttribute.COUNTERSHOCK), 
				Mes = new Ability(AbilityAttribute.MES),
				GammaKnife = new Ability(AbilityAttribute.GAMMAKNIFE)});
		addITEM(OpeOpeNoMi,"Ope Ope no Mi", false);
		addITEM(Room,"Room");
		addITEM(CounterShock,"Counter Shock");
		addITEM(Mes,"Mes");
		addITEM(GammaKnife, "Gamma Knife");
		
		NoroNoroNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, 
				new Item[] {NoroNoroBeam = new Ability(AbilityAttribute.NORONOROBEAM), null, null, null});
		addITEM(NoroNoroNoMi,"Noro Noro no Mi", false);
		addITEM(NoroNoroBeam,"Noro Noro Beam");
		
		SukeSukeNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, 
				new Item[] {Skatting = new Ability(AbilityAttribute.SKATTING), 
				ShishaNoTe = new Ability(AbilityAttribute.SHISHANOTE), null, null});
		addITEM(SukeSukeNoMi,"Suke Suke no Mi", false);
		addITEM(Skatting,"Skatting");
		addITEM(ShishaNoTe,"Shisha no Te");
		
		GomuGomuNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, 
				new Item[] {GomuGomuNoPistol = new Ability(AbilityAttribute.GOMUGOMUNOPISTOL), 
				GearSecond = new Ability(AbilityAttribute.GEARSECOND), 
				GearThird = new Ability(AbilityAttribute.GEARTHIRD),
				GomuGomuNoGatling = new Ability(AbilityAttribute.GOMUGOMUNOGATLIN),
				GomuGomuNoBazooka = new Ability(AbilityAttribute.GOMUGOMUNOBAZOOK)});
		addITEM(GomuGomuNoMi,"Gomu Gomu no Mi", false);
		addITEM(GomuGomuNoPistol,"Gomu Gomu no Pistol");
		addITEM(GearSecond,"Gear Second");
		addITEM(GearThird,"Gear Third");
		addITEM(GomuGomuNoBazooka,"Gomu Gomu no Bazooka");
		
		PikaPikaNoMi = new AkumaNoMi(EnumFruitType.LOGIA, 
				new Item[] {YataNoKagami = new Ability(AbilityAttribute.YATANOKAGAMI), 
				YasakaniNoMagatama = new Ability(AbilityAttribute.YASAKANI),
				AmaNoMurakumo = new Ability(AbilityAttribute.AMANOMURAKUMO),
				Amaterasu = new Ability(AbilityAttribute.AMATERASU)});
		addITEM(PikaPikaNoMi,"Pika Pika no Mi", true);
		addITEM(YataNoKagami,"Yata no Kagami");
		addITEM(YasakaniNoMagatama,"Yasakani no Magatama");
		addITEM(AmaNoMurakumo,"Ama no Murakumo");
		addITEM(Amaterasu,"Amaterasu");		
			
		BaneBaneNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, 
				new Item[] {SpringHopper = new Ability(AbilityAttribute.SPRINGHOPPER), 
				SpringDeathKnock = new Ability(AbilityAttribute.SPRINGDEATHKNOCK), null, null});
		addITEM(BaneBaneNoMi, "Bane Bane no Mi", false);
		addITEM(SpringHopper, "Spring Hopper");
		addITEM(SpringDeathKnock, "Spring Death Knock");
		
		HieHieNoMi = new AkumaNoMi(EnumFruitType.LOGIA, 
				new Item[] {IceBlockPartisan = new Ability(AbilityAttribute.ICEBLOCKPARTISAN), 
				IceAge = new Ability(AbilityAttribute.ICEAGE), 
				IceBall = new Ability(AbilityAttribute.ICEBALL),
				IceBlockPheasant = new Ability(AbilityAttribute.ICEBLOCKPHEASANT),
				IceSaber = new Ability(AbilityAttribute.ICESABER),
				IceTimeCapsule = new Ability(AbilityAttribute.ICETIMECAPSULE)});
		addITEM(HieHieNoMi,"Hie Hie no Mi", true);
		addITEM(IceBlockPartisan,"Ice Block : Partisan");
		addITEM(IceAge,"Ice Age");
		addITEM(IceBall,"Ice Ball");
		addITEM(IceBlockPheasant,"Ice Block : Pheasant");	
		addITEM(IceSaber,"Ice Saber");
		addITEM(IceTimeCapsule,"Ice Time Capsule");
		
		MeraMeraNoMi = new AkumaNoMi(EnumFruitType.LOGIA, 
				new Item[] {Hiken = new Ability(AbilityAttribute.HIKEN), 
				Higan = new Ability(AbilityAttribute.HIGAN), 
				DaiEnkaiEntei = new Ability(AbilityAttribute.DAIENKAIENTEI), 
				Hidaruma = new Ability(AbilityAttribute.HIDARUMA),
				Kagero = new Ability(AbilityAttribute.KAGERO),
				Enjomo  = new Ability(AbilityAttribute.ENJOMO)});
		addITEM(MeraMeraNoMi,"Mera Mera no Mi", true);
		addITEM(Hiken, "Hiken");
		addITEM(Higan, "Higan");
		addITEM(DaiEnkaiEntei, "Dai Enkai : Entei");
		addITEM(Hidaruma, "Hidaruma");
		addITEM(Kagero, "Jujika");
		addITEM(Enjomo , "Enjomo");		
		
	}

	public static void addITEM(Item item, String localizedName, boolean isLogia)
	{	
		if(isLogia)
			Helper.logias.add(item);	
		Helper.devilfruits.add(item);	
		String truename = localizedName.replaceAll("\\s+","").replaceAll(",", "").replaceAll(":", "").toLowerCase().replace("model", "");
		item.setUnlocalizedName(truename);
		GameRegistry.registerItem(item, truename);
		LanguageRegistry.addName(item, localizedName);
	}
	
	public static void addITEM(Item item, String localizedName)
	{	
		Helper.abilities.add(item);	
		String truename = localizedName.replaceAll("\\s+","").replaceAll(",", "").replaceAll(":", "").toLowerCase();
		item.setUnlocalizedName(truename);
		GameRegistry.registerItem(item, truename);
		LanguageRegistry.addName(item, localizedName);
	}
	
}
