package MineMineNoMi3.Utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import MineMineNoMi3.Config;
import MineMineNoMi3.Lists.ListMisc;

public class DatabaseEvents 
{
	public static void event(String cmd, Entity entity)
	{
		String cmd2 = cmd.substring("event_".length());
		
		// ONLY EntityThrowable
		
		if(entity instanceof EntityThrowable)
		{	
			if(cmd2.contains("destroy_"))
			{
				int radius = Integer.parseInt(cmd2.substring("destroy_".length()));
				entity.worldObj.newExplosion(entity, entity.posX, entity.posY, entity.posZ, radius, false, Config.allowGriefing_actual);
			}
			
			if(cmd2.contains("destroywithfire_"))
			{
				int radius = Integer.parseInt(cmd2.substring("destroywithfire_".length()));
				entity.worldObj.newExplosion(entity, entity.posX, entity.posY, entity.posZ, radius, true, Config.allowGriefing_actual);
			}
			
			if(cmd2.equals("teleport"))
			{
				EntityThrowable e = (EntityThrowable) entity;
				
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
		}
		
		// ONLY EntityLivingBase
		
		if(entity instanceof EntityLivingBase)
		{
			if(cmd2.contains("destroy_") && entity instanceof EntityPlayer)
			{
				int radius = Integer.parseInt(cmd2.substring("destroy_".length()));
				entity.worldObj.newExplosion(entity, entity.posX, entity.posY, entity.posZ, radius, false, Config.allowGriefing_actual);
			}
				
			if(cmd2.contains("janpu_"))
			{
				double power = Double.parseDouble(cmd2.substring("janpu_".length()));
				entity.motionY += Double.parseDouble(cmd2.substring("janpu_".length()));;
			}
			
			if(cmd2.contains("potion_"))
			{
				int id = Integer.parseInt(cmd2.substring("potion_".length(), "potion_".length() + 2));
				int duration = Integer.parseInt(cmd2.substring("potion_".length() + 3, "potion_".length() + 7));
				int power = Integer.parseInt(cmd2.substring("potion_".length() + 8, cmd2.length()));
				((EntityLivingBase)entity).addPotionEffect(new PotionEffect(id, duration, power));
			}
			
			if(cmd2.equals("gearsecond"))
			{
				
			}
			
			if(cmd2.equals("gearthird"))
			{
				
			}
			
			if(cmd2.contains("launch_"))
			{
				int power = Integer.parseInt(cmd2.substring("launch_".length()));
				entity.motionY += power/2;
				int dir = entity.worldObj.rand.nextInt(4);
				if(dir==1)
					entity.motionX += power;
				else if(dir==2)
					entity.motionX -= power; 
				else if(dir==3)
					entity.motionZ += power;
				else if(dir==4)  
					entity.motionZ -= power;					
			}
			
			if(cmd2.equals("eatshadows"))
			{
				EntityPlayer kageUser = (EntityPlayer) entity;
				if(kageUser.inventory.hasItemStack(new ItemStack(ListMisc.Shadow)))
				{
					IInventory inventory = kageUser.inventory;
					for(int i = 0; i < inventory.getSizeInventory(); i++)
					{
						if(inventory.getStackInSlot(i) != null)
						{
							ItemStack itemStack = inventory.getStackInSlot(i);
							if(itemStack.getItem() != null && itemStack.getItem() == ListMisc.Shadow)
							{
								kageUser.addPotionEffect(new PotionEffect(Potion.damageBoost.id, itemStack.stackSize * 10, (int) Math.sqrt(itemStack.stackSize)));
								kageUser.addPotionEffect(new PotionEffect(Potion.resistance.id, itemStack.stackSize * 10, (int) Math.sqrt(itemStack.stackSize) / 4));
								inventory.setInventorySlotContents(i, null);
							}
						}
					}
				}			
			}
		}
		
	}
}
