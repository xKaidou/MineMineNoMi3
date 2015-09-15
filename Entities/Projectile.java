package MineMineNoMi3.Entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import MineMineNoMi3.Config;
import MineMineNoMi3.Helper;
import MineMineNoMi3.Utils.DatabaseEvents;
import MineMineNoMi3.Utils.DatabaseParticles;
import MineMineNoMi3.Utils.DatabaseStructures;
import MineMineNoMi3.Utils.AbilityAttribute;

public class Projectile extends EntityThrowable
{
	
	public int ticks, maxticks;
	public AbilityAttribute proj;
	
	public Projectile(World par1World)
	{
		super(par1World);
	}
	
	public Projectile(World par1World, EntityPlayer par3EntityPlayer)
	{
		super(par1World, par3EntityPlayer);
	}
	
	public Projectile(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
	}

	public Projectile(World par1World, EntityPlayer par3EntityPlayer, AbilityAttribute proj)
	{
		super(par1World, par3EntityPlayer);
		this.proj = proj;
		if(proj.getEntityTicks() < 0)
			this.ticks = proj.getEntityTicks() * -1;
		else
			this.ticks = proj.getEntityTicks();
		this.maxticks = ticks;
		if(this.proj != null && this.proj.getEntityAttr() != null)
		{
			for(int i = 0; i < this.proj.getEntityAttr().length; i++)
			{
				if(this.proj.getEntityAttr()[i].contains("speed_"))
				{
					int speed = Integer.parseInt(this.proj.getEntityAttr()[i].substring(6));
					this.motionX *= speed;
					this.motionY *= speed;
					this.motionZ *= speed;
				}
			}
		}
	}
	
	public AbilityAttribute getAbility()
	{
		return this.proj;
	}
	
	public void onEntityUpdate()
	{
		if(ticks <= 0)
		{
			ticks = maxticks;
			this.setDead();
		}
		else
			ticks--;		
	}

	public void onUpdate()
	{
		if(this.proj != null && this.proj.getEntityAttr() != null)
		{
			for(int i = 0; i < this.proj.getEntityAttr().length; i++)
			{	
				String attr = this.proj.getEntityAttr()[i];

				if(attr.equals("particles_smoke"))
					DatabaseParticles.renderSmoke(this);
				if(attr.equals("particles_vulcan"))
					DatabaseParticles.renderVulcan(this);
				if(attr.equals("particles_greenfire"))
					DatabaseParticles.renderGreenFire(this);
				if(attr.equals("particles_avalanche"))
					DatabaseParticles.renderAvalanche(this);
				if(attr.equals("particles_fire"))
					DatabaseParticles.renderFire(this);
			}
		}	
		super.onUpdate();
	}

	protected void onImpact(MovingObjectPosition hit)
	{
		if(this.proj != null)
		{
			if (hit.entityHit != null && hit.entityHit instanceof EntityLivingBase)
			{    
				EntityLivingBase entityHit = ((EntityLivingBase)hit.entityHit);
				
				/*if(!(this.proj.getEntitySideEffect() <= 0))
					entityHit.addPotionEffect(new PotionEffect(this.proj.getEntitySideEffect(), this.proj.getItemTicks()/2, this.proj.getEntityDmg()/10));*/
				
				for(int i = 0; i < this.proj.getEntityAttr().length; i++)
				{
					String attr = this.proj.getEntityAttr()[i];
						
					DatabaseEvents.event(attr, this);	
					DatabaseStructures.creo(attr, this);
				}
				
				hit.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.proj.getEntityDmg());
			}
			if (!this.worldObj.isRemote)
			{
				for(int i = 0; i < this.proj.getEntityAttr().length; i++)
				{
					String attr = this.proj.getEntityAttr()[i];
					
					DatabaseEvents.event(attr, this);
					DatabaseStructures.creo(attr, this);
						/*if(attr.equals("create_iceball"))
							DatabaseStructures.createIceBall(this);	
						if(attr.equals("create_firecross"))
							DatabaseStructures.createFireCross(this);	
						if(attr.equals("create_fireblock"))
							this.worldObj.setBlock(hit.blockX, hit.blockY + 1, hit.blockZ, Blocks.fire);							
						if(attr.equals("create_iceblock"))
							this.worldObj.setBlock(hit.blockX, hit.blockY + 1, hit.blockZ, Blocks.packed_ice);				
						if(attr.equals("create_lavablock"))
							this.worldObj.setBlock(hit.blockX, hit.blockY + 1, hit.blockZ, Blocks.flowing_lava);		
						if(attr.equals("event_teleport"))
							DatabaseEvents.eventTeleport(this);											
						
						if(attr.contains("destroy=_"))
						{
							int radius = Integer.parseInt(attr.substring(9));
							this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, radius, false, Config.allowGriefing_actual);
						}	
						
						if(attr.contains("destroy+_"))
						{
							int radius = Integer.parseInt(attr.substring(9));
							this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, radius, true, Config.allowGriefing_actual);
						}*/
				}

				this.setDead();
			}    
		}       
	}
	
	protected float getGravityVelocity()
	{
		return 0.001F;
	}
}