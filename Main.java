package MineMineNoMi3;

import java.io.File;

import MineMineNoMi3.Commands.CommandDoriki;
import MineMineNoMi3.GUI.GUIHandler;
import MineMineNoMi3.Lists.ListAchievements;
import MineMineNoMi3.Lists.ListCreativeTabs;
import MineMineNoMi3.Lists.ListDevilFruits;
import MineMineNoMi3.Lists.ListEntities;
import MineMineNoMi3.Lists.ListForge;
import MineMineNoMi3.Lists.ListMisc;
import MineMineNoMi3.Lists.ListPotions;
import MineMineNoMi3.Lists.ListRecipes;
import MineMineNoMi3.Packets.PacketPipeline;
import MineMineNoMi3.Proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = "mineminenomi", name = "Mine Mine no Mi", version = "0.3.0")

public class Main 
{

	@Instance("mineminenomi")
	public static Main instance;	
	@SidedProxy(clientSide = "MineMineNoMi3.Proxy.ClientProxy", serverSide = "MineMineNoMi3.Proxy.CommonProxy")
	public static CommonProxy proxy;
	public static final PacketPipeline network = new PacketPipeline();
	public static GUIHandler guiHandler = new GUIHandler();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{	
		ListPotions.expandPotions();
		Config.initConfig(new File(event.getModConfigurationDirectory(), "mineminenomi3.cfg"));
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		network.initialise();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, guiHandler);
		
		proxy.render();
		proxy.tick();
		
		ListPotions.init();
		ListEntities.init();
		ListMisc.init();
		ListDevilFruits.init();
		ListCreativeTabs.init();
		ListRecipes.init();
		ListAchievements.init();
		ListForge.init();	
	}
	
	@EventHandler
	public void postLoad(FMLPostInitializationEvent evt) 
	{
	    network.postInitialise();
	}	
	
	@EventHandler
	public void serverInit(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandDoriki());
	}
	
}
