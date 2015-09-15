package MineMineNoMi3.Utils;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import MineMineNoMi3.Helper;
import MineMineNoMi3.Entities.Projectile;
import MineMineNoMi3.Lists.ListMisc;

public class DatabaseStructures 
{	

	public static void creo(String cmd, Entity entity)
	{
		String cmd2 = cmd.substring("create_".length());
		
		// ONLY EntityThrowable
		
		if(entity instanceof EntityThrowable)
		{	
			if(cmd2.equals("fireblock"))
				entity.worldObj.setBlock((int)entity.posX, (int)entity.posY, (int)entity.posZ, Blocks.fire);	
			
			if(cmd2.equals("iceblock"))
				entity.worldObj.setBlock((int)entity.posX, (int)entity.posY, (int)entity.posZ, Blocks.packed_ice);	
			
			if(cmd2.equals("lavablock"))
				entity.worldObj.setBlock((int)entity.posX, (int)entity.posY, (int)entity.posZ, Blocks.flowing_lava);	
			
			if(cmd2.equals("iceball"))
				creoSphere(Blocks.packed_ice, entity, 6, new PotionEffect[] {new PotionEffect(Potion.moveSlowdown.id, 500, 10)});
			
		}
		
		// ONLY EntityLivingBase
		
		if(entity instanceof EntityLivingBase)
		{	
			if(cmd2.equals("iceage"))
				creoAoE(0, Blocks.packed_ice, entity, new int[] {25, 10, 25}, new PotionEffect[] {new PotionEffect(Potion.moveSlowdown.id, 500, 10)});
		}
		
	}
			
	private static void creoSphere(final Block b, final Entity e, int d, PotionEffect[] p)
	{	
		if(p != null && e instanceof EntityLivingBase)
			for(int i = 0; i < p.length; i++)
				((EntityLivingBase)e).addPotionEffect(p[i]);
		
		UtilSphere.generate((int)e.posX, (int)e.posY, (int)e.posZ, d, new UtilISphere()
		{
			public void call(int x, int y, int z)
			{
				if(e.worldObj.getBlock(x, y, z) != Blocks.bedrock && e.worldObj.getBlock(x, y, z) != ListMisc.Ope
						&& e.worldObj.getBlock(x, y, z) != ListMisc.OpeMid)
					e.worldObj.setBlock(x, y, z, b);
			}
		});			
	}
	
	private static void creoAoE(int type, final Block b, final Entity e, int[] d, PotionEffect[] p)
	{
		if(type == 0)
		{
			int x = (int)e.posX;
		    int y = (int)(e.posY - 1.0D);
		    int z = (int)e.posZ;

		    for (int i = d[0] * (-1); i < d[0]; i++) 
		    	for (int j = d[1] * (-1); j < d[1]; j++) 
		    		for (int k = d[2] * (-1); k < d[2]; k++)		
						if(!e.worldObj.isAirBlock(x + i, y + j, z + k) && e.worldObj.getBlock(x + i, y + j, z + k) != Blocks.bedrock
								&& e.worldObj.getBlock(x + i, y + j, z + k) != ListMisc.Ope && e.worldObj.getBlock(x + i, y + j, z + k) != ListMisc.OpeMid)
							e.worldObj.setBlock(x + i, y + j, z + k, b);
		    AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox((double)e.posX, (double)e.posY, (double)e.posZ, (double)(e.posX + 1), (double)(e.posY + 1), (double)(e.posZ + 1)).expand((d[0] + d[2])/2, (d[0] + d[2])/2, (d[0] + d[2])/2);
		    aabb.maxY = (double)e.worldObj.getHeight();
		    List<EntityLivingBase> list = e.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, aabb);
		    list.remove(e);
		    Iterator<EntityLivingBase> iterator = list.iterator();							 
		    EntityLivingBase entity;
		    while(iterator.hasNext())
		    {
		    	entity = (EntityLivingBase)iterator.next();
				if(p != null && entity instanceof EntityLivingBase)
					for(int i = 0; i < p.length; i++)
						entity.addPotionEffect(p[i]);
		    }			
		}
		if(type == 1)
		{
			
		}
	}
	
	
	
	
	
	public static void test(EntityPlayer e)
	{
		if(!e.worldObj.isRemote)
		{			
			int d0 = 20;
		    AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double)e.posX, (double)e.posY, (double)e.posZ, (double)(e.posX + 1), (double)(e.posY + 1), (double)(e.posZ + 1)).expand(d0, d0, d0);
		    axisalignedbb.maxY = e.worldObj.getHeight();
		    List<EntityLivingBase> list = e.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
		    list.remove(e);
		    Iterator<EntityLivingBase> iterator = list.iterator();							 
		    while(iterator.hasNext())
		    {
		    	final EntityLivingBase entity = (EntityLivingBase)iterator.next();
		    	final int x = (int) entity.posX;
		    	final int y = (int) entity.posY;
		    	final int z = (int) entity.posZ;
		    	
		    	for(int i = -3; i < 3; i++)
		    	{
					UtilSphere.generate(x, y, z, i, new UtilISphere()
					{
					    public void call(int x, int y, int z)
					    {  
					    	for(int j = -3; j < 3; j++)
					    	{
						    	for(int k = 0; k < 15; k++)
						    	{
					    			entity.worldObj.setBlock(x, y - k, z, Blocks.air);
						    	}
					    	}
					    }
					});
		    	}
		    }
		}
	}

	public static void createGravityhole(EntityPlayer e)
	{
		if(!e.worldObj.isRemote)
		{			
			int d0 = 20;
		    AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double)e.posX, (double)e.posY, (double)e.posZ, (double)(e.posX + 1), (double)(e.posY + 1), (double)(e.posZ + 1)).expand(d0, d0, d0);
		    axisalignedbb.maxY = e.worldObj.getHeight();
		    List<EntityLivingBase> list = e.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
		    list.remove(e);
		    Iterator<EntityLivingBase> iterator = list.iterator();							 
		    EntityLivingBase entity;
		    while(iterator.hasNext())
		    {
		    	entity = (EntityLivingBase)iterator.next();
		    	int x = (int) entity.posX;
		    	int y = (int) entity.posY;
		    	int z = (int) entity.posZ;
		    		    	
		    	for(int i = -2; i <= 2; i++)
		    		for(int j = 0; j <= 20; j++)
		    			for(int k = -2; k <= 2; k++)
	    	    		if(e.worldObj.getBlock(x + i, y - j, z + k) != Blocks.bedrock && e.worldObj.getBlock(x + i, y - j, z + k) != ListMisc.Ope &&
	    	    		e.worldObj.getBlock(x + i, y - j, z + k) != ListMisc.OpeMid)
		    				entity.worldObj.setBlock(x + i, y - j, z + k, Blocks.air);
		    }
		}		
	}
	
	public static void createMeteor(EntityPlayer e)
	{
		Projectile sag = new Projectile(e.worldObj, e, AbilityAttribute.SAGARINORYUSEI2);   
	 	sag.setLocationAndAngles(e.posX, e.posY + 100, e.posZ, 0.0F, 0.0F);
	 	sag.motionX = 0;
	 	sag.motionZ = 0;
	 	sag.motionY -= 4;
	 	e.worldObj.spawnEntityInWorld(sag);		
	}
	
	public static void createIcetime(EntityPlayer e)
	{
		if(!e.worldObj.isRemote)
		{			
			int d0 = 30;
		    AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double)e.posX, (double)e.posY, (double)e.posZ, (double)(e.posX + 1), (double)(e.posY + 1), (double)(e.posZ + 1)).expand(d0, d0, d0);
		    axisalignedbb.maxY = e.worldObj.getHeight();
		    List<EntityLivingBase> list = e.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
		    list.remove(e);
		    Iterator<EntityLivingBase> iterator = list.iterator();							 
		    EntityLivingBase entity;
		    while(iterator.hasNext())
		    {
		    	entity = (EntityLivingBase)iterator.next();
		    	int x = (int) entity.posX;
		    	int y = (int) entity.posY;
		    	int z = (int) entity.posZ;
		    		    	
		    	for(int i = -2; i <= 2; i++)
		    		for(int j = 0; j <= 4; j++)
		    			for(int k = -2; k <= 2; k++)
		    	    		if(e.worldObj.getBlock(x + i, y + j, z + k) == Blocks.air || e.worldObj.getBlock(x + i, y + j, z + k) == Blocks.grass || e.worldObj.getBlock(x + i, y + j, z + k) == Blocks.water || 
		    				e.worldObj.getBlock(x + i, y + j, z + k) == Blocks.lava || e.worldObj.getBlock(x + i, y + j, z + k) == Blocks.ladder || e.worldObj.getBlock(x + i, y + j, z + k) == Blocks.skull || 
		    				e.worldObj.getBlock(x + i, y + j, z + k) == Blocks.carpet || e.worldObj.getBlock(x + i, y + j, z + k) == Blocks.snow_layer)
		    					entity.worldObj.setBlock(x + i, y + j, z + k, Blocks.packed_ice);
		    }
		}
	}

	public static void createEmptyland(EntityPlayer e)
	{
		if(!e.worldObj.isRemote)
		{			
			int d0 = 30;
		    AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double)e.posX, (double)e.posY, (double)e.posZ, (double)(e.posX + 1), (double)(e.posY + 1), (double)(e.posZ + 1)).expand(d0, d0, d0);
		    axisalignedbb.maxY = e.worldObj.getHeight();
		    List<EntityLivingBase> list = e.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
		    list.remove(e);
		    Iterator<EntityLivingBase> iterator = list.iterator();							 
		    EntityLivingBase entity;
		    while(iterator.hasNext())
		    {
		    	entity = (EntityLivingBase)iterator.next();

		    	entity.addPotionEffect(new PotionEffect(Potion.confusion.id, 300, 2));
		    	entity.addPotionEffect(new PotionEffect(Potion.hunger.id, 300, 2));
		    	entity.addPotionEffect(new PotionEffect(Potion.weakness.id, 300, 2));
		    	entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 300, 5));
		    }
		}		
	}

	public static void createSnowstorm(final EntityPlayer e)
	{
		if(!e.worldObj.isRemote)
		{
			int x = (int)e.posX;
			int z = (int)e.posZ;
			int y = (int)e.posY;

			UtilSphere.generate(x, y, z, 18, new UtilISphere()
		    {
		    	public void call(int x, int y, int z)
		    	{  
	    			for(int i = -3; i <= 3; i++)
			    		if(e.worldObj.isAirBlock(x, y + i, z) && (e.worldObj.getBlock(x, (y - 1) + i, z) != Blocks.snow_layer && e.worldObj.getBlock(x, (y - 1) + i, z) != Blocks.air || e.worldObj.getBlock(x, (y - 1) + i, z) == Blocks.grass))
			    			e.worldObj.setBlock(x, y + i, z, Blocks.snow_layer);
	    			int d0 = 12;
	    		    AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double)e.posX, (double)e.posY, (double)e.posZ, (double)(e.posX + 1), (double)(e.posY + 1), (double)(e.posZ + 1)).expand(d0, d0, d0);
	    		    axisalignedbb.maxY = e.worldObj.getHeight();
	    		    List<EntityLivingBase> list = e.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
	    		    list.remove(e);
	    		    Iterator<EntityLivingBase> iterator = list.iterator();							 
	    		    EntityLivingBase entity;
	    		    while(iterator.hasNext())
	    		    {
	    		    	entity = (EntityLivingBase)iterator.next();
	    		    	entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 4));
	    		    	entity.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 100, 4));
	    		    }		    			
		    	}		
		    });	
		}		
	}
	
	public static void createCandlehouse(EntityPlayer e)
	{
		int X = (int) e.posX;
		int Y = (int) e.posY;
		int Z = (int) e.posZ;
		for(int y=0;y<=3;y++)
		{
			for(int x=0;x<1;x++)
				for(int z=0;z<10;z++)
					e.worldObj.setBlock((X+3)-x, Y+y, (Z+5)-z, Blocks.clay);
			for(int x=0;x<1;x++)
				for(int z=0;z<10;z++)
					e.worldObj.setBlock((X-3)-x, Y+y, (Z+5)-z, Blocks.clay);
			for(int x=0;x<10;x++)
				for(int z=0;z<1;z++)
					e.worldObj.setBlock((X+5)-x, Y+y, (Z-3)-z, Blocks.clay);
			for(int x=0;x<10;x++)
				for(int z=0;z<1;z++)
					e.worldObj.setBlock((X+5)-x, Y+y, (Z+3)-z, Blocks.clay);
		}
		for(int x=0;x<10;x++)
			for(int y=0;y<1;y++)
				for(int z=0;z<10;z++)
			  		e.worldObj.setBlock((X+5)-x, (Y+4)+y, (Z+5)-z, Blocks.clay);	
	}
	
	public static void createCandlewall(EntityPlayer e)
	{
		int direction = MathHelper.floor_double(e.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;
		int X = (int) e.posX;
		int Y = (int) e.posY;
		int Z = (int) e.posZ;
		for(int y=0;y<=3;y++)
		{
			if (direction == 1)
				for(int x=0;x<=1;x++)
					for(int z=0;z<5;z++)
						e.worldObj.setBlock((X-2)-x, Y+y, (Z+2)-z, Blocks.clay);
			  
			else if (direction == 2)  
				for(int x=0;x<5;x++)
					for(int z=0;z<=1;z++)
						e.worldObj.setBlock((X-2)+x, Y+y, (Z-2)-z, Blocks.clay);
			
			else if (direction == 3)
				for(int x=0;x<=1;x++)
					for(int z=0;z<5;z++)
						e.worldObj.setBlock((X+2)+x, Y+y, (Z+2)-z, Blocks.clay);	  
			else  
				for(int x=0;x<5;x++)
					for(int z=0;z<=1;z++)
						e.worldObj.setBlock((X-2)+x, Y+y, (Z+2)-z, Blocks.clay);
		}
	}
	
	public static void createKamakura2(final EntityPlayer e)
	{
		int x = (int)e.posX;
	    int z = (int)e.posZ;
	    int y = (int)e.posY;
		
	    UtilSphere.generate(x, y, z, 8, new UtilISphere()
	    {
	    	public void call(int x, int y, int z)
	    	{  
	    		if(e.worldObj.getBlock(x, y, z) == Blocks.air || e.worldObj.getBlock(x, y, z) == Blocks.grass || e.worldObj.getBlock(x, y, z) == Blocks.water || 
	    				e.worldObj.getBlock(x, y, z) == Blocks.lava || e.worldObj.getBlock(x, y, z) == Blocks.ladder || e.worldObj.getBlock(x, y, z) == Blocks.skull || 
	    				e.worldObj.getBlock(x, y, z) == Blocks.carpet || e.worldObj.getBlock(x, y, z) == Blocks.snow_layer)
	    			e.worldObj.setBlock(x, y, z, Blocks.snow);
	    	}
	    });
	}
	
	public static void createKamakura(final EntityPlayer e)
	{
		int x = (int)e.posX;
	    int z = (int)e.posZ;
	    int y = (int)e.posY;
		
	    UtilSphere.generate(x, y, z, 3, new UtilISphere()
	    {
	    	public void call(int x, int y, int z)
	    	{  
	    		if(e.worldObj.getBlock(x, y, z) == Blocks.air || e.worldObj.getBlock(x, y, z) == Blocks.grass || e.worldObj.getBlock(x, y, z) == Blocks.water || 
	    				e.worldObj.getBlock(x, y, z) == Blocks.lava || e.worldObj.getBlock(x, y, z) == Blocks.ladder || e.worldObj.getBlock(x, y, z) == Blocks.skull || 
	    				e.worldObj.getBlock(x, y, z) == Blocks.carpet || e.worldObj.getBlock(x, y, z) == Blocks.snow_layer)
	    			e.worldObj.setBlock(x, y, z, Blocks.snow);
	    	}
	    });
	}
	
	public static void createFireFence(final EntityLivingBase e)
	{
		if(!e.worldObj.isRemote)
		{
			int x = (int)e.posX;
			int z = (int)e.posZ;
			int y = (int)e.posY;

			UtilSphere.generate(x, y, z, 12, new UtilISphere()
		    {
		    	public void call(int x, int y, int z)
		    	{  
	    			for(int i = -3; i <= 3; i++)
	    			{
			    		if(e.worldObj.isAirBlock(x, y + i, z))
			    		{
			    				e.worldObj.setBlock(x, y + i, z, Blocks.fire);
			    		    int d0 = 12;
			    		    AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double)e.posX, (double)e.posY, (double)e.posZ, (double)(e.posX + 1), (double)(e.posY + 1), (double)(e.posZ + 1)).expand(d0, d0, d0);
			    		    axisalignedbb.maxY = e.worldObj.getHeight();
			    		    List<EntityLivingBase> list = e.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
			    		    list.remove(e);
			    		    Iterator<EntityLivingBase> iterator = list.iterator();							 
			    		    EntityLivingBase entity;
			    		    while(iterator.hasNext())
			    		    {
			    		    	entity = (EntityLivingBase)iterator.next();
			    		    	entity.setFire(20);
			    		    }		    			
			    		}
	    			}
		    	}		
		    });	
		}
	}
	
	public static void createFireCross(Entity e)
	{	
		int x = (int)e.posX;
		int y = (int)e.posY;
		int z = (int)e.posZ;
			
		for(int j = -2; j <= 2; j++)
		{
			for(int i = -5; i <= 5; i++)
				if(e.worldObj.isAirBlock(x + i, y + j, z))
					e.worldObj.setBlock(x + i, y + j, z, Blocks.fire);
				
			for(int i = -5; i <= 5; i++)
				if(e.worldObj.isAirBlock(x, y + j, z + i))
					e.worldObj.setBlock(x, y + j, z + i, Blocks.fire);
		}
	}
	
	public static void createLavaLake(EntityPlayer player)
	{
		if(!player.worldObj.isRemote)
		{
			int X = (int)player.posX;
		    int Z = (int)player.posZ;
		    int Y = (int)(player.posY - 1);
		    Block replacement = player.worldObj.getBlock(X, Y, Z);

		    for (int i = -7; i < 7; i++) 
		    {
		    	for (int k = -7; k < 7; k++) 
		    	{
		    		for (int j = 0; j <= 2; j++) 
		    		{	        	
		    			if(player.worldObj.getBlock(X + i, Y + j, Z + k) != Blocks.bedrock && player.worldObj.getBlock(X + i, Y + j, Z + k) != ListMisc.Ope 
		    					&& player.worldObj.getBlock(X + i, Y + j, Z + k) != ListMisc.OpeMid)		
		    			{
		    				player.worldObj.setBlock(X, Y - j, Z, replacement);
		    				player.worldObj.setBlock(X + i, Y - j, Z + k, Blocks.lava);   	
		    			}
		    		}
		        }
		    }
		}			
	}
	
	public static void createGroundDeath(EntityPlayer e)
	{
		if(!e.worldObj.isRemote)
		{			
			int d0 = 30;
		    AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double)e.posX, (double)e.posY, (double)e.posZ, (double)(e.posX + 1), (double)(e.posY + 1), (double)(e.posZ + 1)).expand(d0, d0, d0);
		    axisalignedbb.maxY = e.worldObj.getHeight();
		    List<EntityLivingBase> list = e.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
		    list.remove(e);
		    Iterator<EntityLivingBase> iterator = list.iterator();							 
		    EntityLivingBase entity;
		    while(iterator.hasNext())
		    {
		    	entity = (EntityLivingBase)iterator.next();
		    	int x = (int) entity.posX;
		    	int y = (int) entity.posY;
		    	int z = (int) entity.posZ;
		    		    	
		    	for(int i = -2; i <= 2; i++)
		    		for(int j = 0; j <= 4; j++)
		    			for(int k = -2; k <= 2; k++)
		    	    		if(e.worldObj.getBlock(x + i, y + j, z + k) == Blocks.air || e.worldObj.getBlock(x + i, y + j, z + k) == Blocks.grass || e.worldObj.getBlock(x + i, y + j, z + k) == Blocks.water || 
		    				e.worldObj.getBlock(x + i, y + j, z + k) == Blocks.lava || e.worldObj.getBlock(x + i, y + j, z + k) == Blocks.ladder || e.worldObj.getBlock(x + i, y + j, z + k) == Blocks.skull || 
		    				e.worldObj.getBlock(x + i, y + j, z + k) == Blocks.carpet || e.worldObj.getBlock(x + i, y + j, z + k) == Blocks.snow_layer)
		    					entity.worldObj.setBlock(x + i, y + j, z + k, Blocks.sand);
		    }
		}		
	}
	
	public static void createDesertSpada(EntityPlayer player)
	{
		if(!player.worldObj.isRemote)
		{
			int X = (int)player.posX;
		    int Z = (int)player.posZ;
		    int Y = (int)(player.posY + 2);
		    Block replacement = player.worldObj.getBlock(X, Y - 3, Z);

		    for (int i = -5; i < 5; i++) 
		    {
		    	for (int k = -5; k < 5; k++) 
		    	{
		    		for (int j = 0; j <= 2; j++) 
		    		{	        	
		    			if(player.worldObj.getBlock(X + i, Y+j, Z + k) != Blocks.bedrock && player.worldObj.getBlock(X + i, Y+j, Z + k) != ListMisc.Ope 
		    					&& player.worldObj.getBlock(X + i, Y+j, Z + k) != ListMisc.OpeMid)
		    			{
		    				player.worldObj.setBlock(X, (Y - 3) - j, Z, replacement);
		    				player.worldObj.setBlock(X + i, Y + j, Z + k, Blocks.sand);
		    				player.worldObj.setBlock(X + i, (Y - 5) + j, Z + k, Blocks.air);
		    				player.worldObj.setBlock(X, Y + j, Z, Blocks.air);
		    			}    	  
		    		}
		        }
		    }
		}
	}
	
	public static void createRoom(final EntityLivingBase entity)
	{
		if(!entity.worldObj.isRemote)
		{
			int X = (int)entity.posX;
			int Z = (int)entity.posZ;
			int Y = (int)(entity.posY - 1.0D);
			
			entity.worldObj.setBlock(X, Y, Z, ListMisc.OpeMid);
			
			UtilSphere.generate(X, Y, Z, 15, new UtilISphere()
		    {
		    	public void call(int x, int y, int z)
		    	{  
		    		if(entity.worldObj.getBlock(x, y, z) == Blocks.air || entity.worldObj.getBlock(x, y, z) == Blocks.grass || entity.worldObj.getBlock(x, y, z) == Blocks.water || 
		    				entity.worldObj.getBlock(x, y, z) == Blocks.lava || entity.worldObj.getBlock(x, y, z) == Blocks.ladder || entity.worldObj.getBlock(x, y, z) == Blocks.skull || 
		    				entity.worldObj.getBlock(x, y, z) == Blocks.carpet || entity.worldObj.getBlock(x, y, z) == Blocks.snow_layer)
		    			entity.worldObj.setBlock(x, y, z, ListMisc.Ope);
		    	}
		    });	
		}
	}
	
	public static void createIceBall(final Entity entity)
	{
		int X = (int)entity.posX;
	    int Z = (int)entity.posZ;
	    int Y = (int)(entity.posY - 1.0D);
		
	    UtilSphere.generate(X, Y, Z, 6, new UtilISphere()
	    {
	    	public void call(int x, int y, int z)
	    	{  
	    		if(entity.worldObj.getBlock(x, y, z) == Blocks.air || entity.worldObj.getBlock(x, y, z) == Blocks.grass || entity.worldObj.getBlock(x, y, z) == Blocks.water || 
	    				entity.worldObj.getBlock(x, y, z) == Blocks.lava || entity.worldObj.getBlock(x, y, z) == Blocks.ladder || entity.worldObj.getBlock(x, y, z) == Blocks.skull || 
	    				entity.worldObj.getBlock(x, y, z) == Blocks.carpet || entity.worldObj.getBlock(x, y, z) == Blocks.snow_layer)
	    			entity.worldObj.setBlock(x, y, z, Blocks.packed_ice);
	    	}
	    });
	}
	
	public static void createIceAge(EntityPlayer player)
	{
		int X = (int)player.posX;
	    int Z = (int)player.posZ;
	    int Y = (int)(player.posY - 1.0D);

	    for (int i = -20; i < 20; i++) 
	    	for (int j = -10; j < 10; j++) 
	    		for (int k = -20; k < 20; k++)         	
	    			if (!player.worldObj.isAirBlock(X + i, Y + j, Z + k) || !player.worldObj.isAirBlock(X + i, Y + j, Z + k) || !player.worldObj.isAirBlock(X + i, Y + j, Z + k))
	    				if(player.worldObj.getBlock(X + i, Y + j, Z + k) != Blocks.bedrock && player.worldObj.getBlock(X + i, Y + j, Z + k) != ListMisc.Ope && player.worldObj.getBlock(X + i, Y + j, Z + k) != ListMisc.OpeMid)
	    					player.worldObj.setBlock(X + i, Y + j, Z + k, Blocks.packed_ice);
	    int d0 = 20;
	    AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox((double)player.posX, (double)player.posY, (double)player.posZ, (double)(player.posX + 1), (double)(player.posY + 1), (double)(player.posZ + 1)).expand(d0, d0, d0);
	    aabb.maxY = (double)player.worldObj.getHeight();
	    List<EntityLivingBase> list = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, aabb);
	    list.remove(player);
	    Iterator<EntityLivingBase> iterator = list.iterator();							 
	    EntityLivingBase entity;
	    while(iterator.hasNext())
	    {
	    	entity = (EntityLivingBase)iterator.next();
	    	entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 5));
	    	entity.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 200, 5));
	    }		
	}
	
	public static void createThor(EntityPlayer player, int explosion)
	{
		float f = 1.0F;
		float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
		float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
		double d = player.prevPosX + (player.posX - player.prevPosX) * (double)f;
		double d1 = (player.prevPosY + (player.posY - player.prevPosY) * (double)f + 1.6200000000000001D) - (double)player.yOffset;
		double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double)f;
		Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
		float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
		float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);	      
		float f5 = -MathHelper.cos(-f1 * 0.01745329F);
		float f6 = MathHelper.sin(-f1 * 0.01745329F);
		float f7 = f4 * f5;
		float f9 = f3 * f5;
		double d3 = 5000D;
		Vec3 vec3 = vec3d.addVector((double)f7 * d3, (double)f6 * d3, (double)f9 * d3);
		MovingObjectPosition movingobjectposition = player.worldObj.rayTraceBlocks(vec3d, vec3, false);	
		if (movingobjectposition == null) 
			return;
		
		int i = movingobjectposition.blockX;
		int j = movingobjectposition.blockY;
		int k = movingobjectposition.blockZ;	      

		if(!player.worldObj.isRemote)      		 
			player.worldObj.newExplosion(new EntityLightningBolt(player.worldObj, i, j, k), i, j, k, explosion, true, true);
		player.worldObj.spawnEntityInWorld(new EntityLightningBolt(player.worldObj, i, j, k));
		player.worldObj.spawnEntityInWorld(new EntityLightningBolt(player.worldObj, i+1, j, k));
		player.worldObj.spawnEntityInWorld(new EntityLightningBolt(player.worldObj, i, j, k+1));
		player.worldObj.spawnEntityInWorld(new EntityLightningBolt(player.worldObj, i-1, j, k));
		player.worldObj.spawnEntityInWorld(new EntityLightningBolt(player.worldObj, i, j, k-1));
	}
}
