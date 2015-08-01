package MineMineNoMi3.Lists;

import net.minecraftforge.common.MinecraftForge;
import MineMineNoMi3.MainKeys;
import MineMineNoMi3.MainWorldGen;
import MineMineNoMi3.Events.EventDevilFruits;
import MineMineNoMi3.Events.EventDoriki;
import MineMineNoMi3.Events.EventDrops;
import MineMineNoMi3.Events.EventEnchantments;
import MineMineNoMi3.Events.EventExtendedData;
import MineMineNoMi3.Events.EventHaki;
import MineMineNoMi3.Events.EventJobs;
import MineMineNoMi3.Events.EventTicks;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class ListForge 
{
	public static void init()
	{
		
		MinecraftForge.EVENT_BUS.register(new EventExtendedData());
		MinecraftForge.EVENT_BUS.register(new EventDevilFruits());
		MinecraftForge.EVENT_BUS.register(new EventEnchantments());
		MinecraftForge.EVENT_BUS.register(new EventDoriki());
		MinecraftForge.EVENT_BUS.register(new EventDrops());
		MinecraftForge.EVENT_BUS.register(new EventHaki());
		MinecraftForge.EVENT_BUS.register(new EventJobs());
		
		GameRegistry.registerWorldGenerator(new MainWorldGen(), 1);
		
		FMLCommonHandler.instance().bus().register(new EventTicks());
		
		if(FMLCommonHandler.instance().getEffectiveSide().isClient())
		{
			FMLCommonHandler.instance().bus().register(new MainKeys());
			MainKeys.init();
		}
		
	}
}
