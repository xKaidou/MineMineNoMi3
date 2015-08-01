package MineMineNoMi3.Proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import MineMineNoMi3.Helper;
import MineMineNoMi3.Entities.Projectile;
import MineMineNoMi3.Entities.Groups.Marines.EntityMarine;
import MineMineNoMi3.Entities.Groups.Models.ModelMarine;
import MineMineNoMi3.Entities.Groups.Models.ModelPirate;
import MineMineNoMi3.Entities.Groups.Pirates.EntityPirate;
import MineMineNoMi3.Entities.Render.RenderAbility;
import MineMineNoMi3.Entities.Render.RenderMobType;
import MineMineNoMi3.Entities.Render.RenderProjectile;
import MineMineNoMi3.Items.Ability;
import MineMineNoMi3.Lists.ListDevilFruits;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	
	public void tick()
	{
			
	}
	
	public void render()
	{	
		//for(int i = 0; i < Helper.abilities.size(); i++)
			//MinecraftForgeClient.registerItemRenderer(ListDevilFruits.Hiken, new RenderAbility());
		RenderingRegistry.registerEntityRenderingHandler(Projectile.class, new RenderProjectile());	
	
		RenderingRegistry.registerEntityRenderingHandler(EntityMarine.class, new RenderMobType(new ModelMarine(), "marine"));
		RenderingRegistry.registerEntityRenderingHandler(EntityPirate.class, new RenderMobType(new ModelPirate(), "pirate"));
	}
	
}
