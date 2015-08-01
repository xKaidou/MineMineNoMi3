package MineMineNoMi3.Lists;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import MineMineNoMi3.Helper;
import MineMineNoMi3.Main;
import MineMineNoMi3.Entities.Projectile;
import MineMineNoMi3.Entities.Groups.Marines.EntityMarine;
import MineMineNoMi3.Entities.Groups.Models.ModelMarine;
import MineMineNoMi3.Entities.Groups.Models.ModelPirate;
import MineMineNoMi3.Entities.Groups.Pirates.EntityPirate;
import MineMineNoMi3.Entities.Render.RenderMobType;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ListEntities
{ 

	public static void init()
	{
		addENTITY("Marine", EntityMarine.class, 0x94D5F7, 0x0000FF);
		addENTITY("Pirate", EntityPirate.class, 0xC9C9C9, 0xCC3134);
		
		EntityRegistry.registerModEntity(Projectile.class, "Proj", 1, Main.instance , 64, 10, true);
	}

	private static void addENTITY(String name, Class<? extends Entity> entity)
	{
		addENTITY(name, entity, -1, -1);
	}
	
	private static void addENTITY(String name, Class<? extends Entity> entity, int color1, int color2)
	{
		if(color1 != -1 && color2 != -1)
			EntityRegistry.registerGlobalEntityID(entity, name, EntityRegistry.findGlobalUniqueEntityId(), color1, color2);
		else
			EntityRegistry.registerGlobalEntityID(entity, name, EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity."+name+".name", "en_US", name);			
	}
}
