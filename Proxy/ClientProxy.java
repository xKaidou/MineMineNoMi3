package MineMineNoMi3.Proxy;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
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
import MineMineNoMi3.Entities.Render.RenderZoan;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	
	public void tick()
	{
			
	}
	
	public void render()
	{	
		for(int i = 0; i < Helper.abilities.size(); i++)
			MinecraftForgeClient.registerItemRenderer(Helper.abilities.get(i), new RenderAbility());	
		
		RenderingRegistry.registerEntityRenderingHandler(Projectile.class, new RenderProjectile());	
		RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new RenderZoan());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMarine.class, new RenderMobType(new ModelMarine(), "marine"));
		RenderingRegistry.registerEntityRenderingHandler(EntityPirate.class, new RenderMobType(new ModelPirate(), "pirate"));	

	}
	
}
