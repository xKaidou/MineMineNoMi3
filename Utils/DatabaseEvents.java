package MineMineNoMi3.Utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import MineMineNoMi3.Lists.ListMisc;

public class DatabaseEvents 
{
	
	public static void eventEatShadows(EntityPlayer player)
	{
		if(player.inventory.hasItemStack(new ItemStack(ListMisc.Shadow)))
		{
			IInventory inventory = player.inventory;
			for(int i = 0; i < inventory.getSizeInventory(); i++)
			{
				if(inventory.getStackInSlot(i) != null)
				{
					ItemStack itemStack = inventory.getStackInSlot(i);
					if(itemStack.getItem() != null && itemStack.getItem() == ListMisc.Shadow)
					{
						player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, itemStack.stackSize * 10, (int) Math.sqrt(itemStack.stackSize)));
						player.addPotionEffect(new PotionEffect(Potion.resistance.id, itemStack.stackSize * 10, (int) Math.sqrt(itemStack.stackSize) / 4));
						inventory.setInventorySlotContents(i, null);
					}
				}
			}
		}
	}
	
	public static void eventTeleport(EntityThrowable e)
	{
		if(e.getThrower() != null && e.getThrower() instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = (EntityPlayerMP)e.getThrower();
			EnderTeleportEvent event = new EnderTeleportEvent(player, e.posX, e.posY, e.posZ, 0.0F);
			if(!MinecraftForge.EVENT_BUS.post(event))
			{				
				if (e.getThrower().isRiding())
					e.getThrower().mountEntity((Entity)null);
				e.getThrower().setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
			}
        }
	}
	
	public static void eventThor(EntityPlayer player, int explosion)
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
