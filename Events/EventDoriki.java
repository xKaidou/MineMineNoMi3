package MineMineNoMi3.Events;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import MineMineNoMi3.Helper;
import MineMineNoMi3.Main;
import MineMineNoMi3.MainExtendedPlayer;
import MineMineNoMi3.Entities.Base.EntityMarineBase;
import MineMineNoMi3.Lists.ListMisc;
import MineMineNoMi3.Packets.PacketSync;
import MineMineNoMi3.Utils.CustomEventGainDoriki;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventDoriki 
{

	@SubscribeEvent
	public void onPlayerDeath(LivingAttackEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer && event.entityLiving.getHealth() - event.ammount <= 0)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			MainExtendedPlayer props = MainExtendedPlayer.get(player);			
			props.resetStats();				
		}
	}
	
	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event)
	{
	    if(event.source.getEntity() instanceof EntityPlayer)
	    { 
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			MainExtendedPlayer props = MainExtendedPlayer.get(player);		
			EntityLivingBase target = event.entityLiving;
			
			IAttributeInstance attrAtk = target.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage);
			IAttributeInstance attrHP = target.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth);
			
			if(props.getDoriki() < Helper.MAX_DORIKI && attrAtk != null && attrHP != null)
			{
				double i = attrAtk.getAttributeValue();
				double j = attrHP.getAttributeValue();
				int rng = player.worldObj.rand.nextInt(3)+1;
				int haki_rng = player.worldObj.rand.nextInt(199)+1;
				
				if(target instanceof EntityPlayer)
				{
					MainExtendedPlayer targetprops = MainExtendedPlayer.get((EntityPlayer) target);
					
					props.addDoriki((targetprops.getDoriki()/3)+rng);
					props.addBelly(targetprops.getBelly());
					if(props.getFaction().equals("Pirate") && targetprops.getFaction().equals("Pirate"))
						props.addBounty(targetprops.getBounty()/2);
				}
				else
				{
					if(props.getFaction().equals("Marine") && target instanceof EntityMarineBase)
						return;	
					
					if((int)Math.round(((i + j)/10)/Math.PI)+rng > 0)
						props.addDoriki((int)Math.round(((i + j)/10)/Math.PI)+rng);
				}
				
				if(props.getDoriki() >= 500 && !player.inventory.hasItem(ListMisc.Soru))
					player.inventory.addItemStackToInventory(new ItemStack(ListMisc.Soru));
					
				if(props.getDoriki() >= 1000 && !player.inventory.hasItem(ListMisc.Tekkai))
					player.inventory.addItemStackToInventory(new ItemStack(ListMisc.Tekkai));	
					
				if(props.getDoriki() >= 2500 && !player.inventory.hasItem(ListMisc.Shigan))
					player.inventory.addItemStackToInventory(new ItemStack(ListMisc.Shigan));	
					
				if(props.getDoriki() >= 3000 && !player.inventory.hasItem(ListMisc.Geppo))
					player.inventory.addItemStackToInventory(new ItemStack(ListMisc.Geppo));
					
				if(props.getDoriki() >= 4000 && !player.inventory.hasItem(ListMisc.Kamie))
					player.inventory.addItemStackToInventory(new ItemStack(ListMisc.Kamie));
					
				if(props.getDoriki() >= 5500 && !player.inventory.hasItem(ListMisc.Rankyaku))
					player.inventory.addItemStackToInventory(new ItemStack(ListMisc.Rankyaku));
				
				Main.network.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			}
	    }
	}
	
	@SubscribeEvent
	public void onEnterWorld(EntityJoinWorldEvent event)
	{
		if(event.entity instanceof EntityPlayer)
		{			
			if(FMLCommonHandler.instance().getEffectiveSide().isClient())
				return;
			
			EntityPlayer player = (EntityPlayer)event.entity;
			MainExtendedPlayer props = MainExtendedPlayer.get(player);
			
			for(int i = 0; i < MinecraftServer.getServer().worldServers.length; i++)
				Main.network.sendToDimension(new PacketSync(props), i);
		}
	}
	
	@SubscribeEvent
	public void onDorikiGained(CustomEventGainDoriki event)
	{
		if(event.props.getDoriki() >= 500 && !event.player.inventory.hasItem(ListMisc.Soru))
			event.player.inventory.addItemStackToInventory(new ItemStack(ListMisc.Soru));
		if(event.props.getDoriki() < 500 && event.player.inventory.hasItem(ListMisc.Soru))
			event.player.inventory.consumeInventoryItem(ListMisc.Soru);
			
		if(event.props.getDoriki() >= 1000 && !event.player.inventory.hasItem(ListMisc.Tekkai))
			event.player.inventory.addItemStackToInventory(new ItemStack(ListMisc.Tekkai));	
		if(event.props.getDoriki() < 1000 && event.player.inventory.hasItem(ListMisc.Tekkai))
			event.player.inventory.consumeInventoryItem(ListMisc.Tekkai);		
		
		if(event.props.getDoriki() >= 2500 && !event.player.inventory.hasItem(ListMisc.Shigan))
			event.player.inventory.addItemStackToInventory(new ItemStack(ListMisc.Shigan));	
		if(event.props.getDoriki() < 2500 && event.player.inventory.hasItem(ListMisc.Shigan))
			event.player.inventory.consumeInventoryItem(ListMisc.Shigan);
			
		if(event.props.getDoriki() >= 3000 && !event.player.inventory.hasItem(ListMisc.Geppo))
			event.player.inventory.addItemStackToInventory(new ItemStack(ListMisc.Geppo));
		if(event.props.getDoriki() < 3000 && event.player.inventory.hasItem(ListMisc.Geppo))
			event.player.inventory.consumeInventoryItem(ListMisc.Geppo);
			
		if(event.props.getDoriki() >= 4000 && !event.player.inventory.hasItem(ListMisc.Kamie))
			event.player.inventory.addItemStackToInventory(new ItemStack(ListMisc.Kamie));
		if(event.props.getDoriki() < 4000 && event.player.inventory.hasItem(ListMisc.Kamie))
			event.player.inventory.consumeInventoryItem(ListMisc.Kamie);	
		
		if(event.props.getDoriki() >= 5500 && !event.player.inventory.hasItem(ListMisc.Rankyaku))
			event.player.inventory.addItemStackToInventory(new ItemStack(ListMisc.Rankyaku));
		if(event.props.getDoriki() < 5500 && event.player.inventory.hasItem(ListMisc.Rankyaku))
			event.player.inventory.consumeInventoryItem(ListMisc.Rankyaku);
	}
	
}
