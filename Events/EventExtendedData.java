package MineMineNoMi3.Events;

import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import MineMineNoMi3.Config;
import MineMineNoMi3.Helper;
import MineMineNoMi3.Main;
import MineMineNoMi3.MainExtendedEntity;
import MineMineNoMi3.MainExtendedPlayer;
import MineMineNoMi3.Packets.PacketSync;
import MineMineNoMi3.Proxy.CommonProxy;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventExtendedData
{
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer && MainExtendedPlayer.get((EntityPlayer) event.entity) == null)
			MainExtendedPlayer.register((EntityPlayer) event.entity);

		if (event.entity instanceof EntityLivingBase && MainExtendedEntity.get((EntityLivingBase) event.entity) == null)
			MainExtendedEntity.register((EntityLivingBase) event.entity);
	}
	
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if (event.entity instanceof EntityPlayer && !event.entity.worldObj.isRemote)
			if(Config.allowDebugMode_actual)
				Helper.sendText((EntityPlayer) event.entity, "Debug Mode is ON");	
		
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityLivingBase)
			MainExtendedEntity.get((EntityLivingBase) event.entity);
	}
}


