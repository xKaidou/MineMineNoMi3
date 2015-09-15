package MineMineNoMi3.Events;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import MineMineNoMi3.Config;
import MineMineNoMi3.Helper;
import MineMineNoMi3.Main;
import MineMineNoMi3.MainExtendedPlayer;
import MineMineNoMi3.Items.Haki;
import MineMineNoMi3.Lists.ListEffects;
import MineMineNoMi3.Lists.ListMisc;
import MineMineNoMi3.Packets.PacketSync;
import MineMineNoMi3.Utils.IOnePieceMob;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventDevilFruits 
{
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
		{	
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			MainExtendedPlayer props = MainExtendedPlayer.get(player);
			
			if(props.getUsedFruit().equals("gomugomu") || props.getUsedFruit().equals("banebane") || props.isLogia() || 
					(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == ListMisc.Geppo))
				player.fallDistance = 0;
		}
	}
	
	@SubscribeEvent
	public void onPlayerDrinkMilk(PlayerInteractEvent event)
	{
		if(Config.allowMilkRemove_actual && event.action.RIGHT_CLICK_AIR != null && event.entityPlayer != null && event.entityPlayer.inventory.getCurrentItem() != null 
				&& event.entityPlayer.inventory.getCurrentItem().getItem() == Items.milk_bucket && !event.world.isRemote)
		{
			MainExtendedPlayer props = MainExtendedPlayer.get(event.entityPlayer);
			
			for(int i = 0; i < Helper.abilities.size(); i++)
				event.entityPlayer.inventory.consumeInventoryItem(Helper.abilities.get(i));
			
			props.setUsedFruit("N/A");
			props.setIsLogia(false);
			
			Main.network.sendTo(new PacketSync(props), (EntityPlayerMP) event.entityPlayer);
		}
	}
	
	@SubscribeEvent
	public void onAttackEvent(LivingAttackEvent event)
	{
		
		if(event.source.getSourceOfDamage() instanceof EntityLivingBase)
		{			
			boolean flag1 = event.entityLiving instanceof IOnePieceMob && ((IOnePieceMob)event.entityLiving).hasHaki();
			
			if(event.entityLiving instanceof IOnePieceMob && ((IOnePieceMob)event.entityLiving).isLogia())
				if(!flag1)
					event.setCanceled(true);
			
			if(event.entityLiving instanceof EntityPlayer && MainExtendedPlayer.get((EntityPlayer)event.entityLiving).isLogia())
				if(!flag1)
					event.setCanceled(true);	
		}
		
		if(event.source.getSourceOfDamage() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.source.getSourceOfDamage();
			MainExtendedPlayer props = MainExtendedPlayer.get(player);
			ItemStack heldItem = player.getCurrentEquippedItem();
				
			boolean flag1 = heldItem != null && heldItem.getItem() instanceof ItemSword && EnchantmentHelper.getEnchantmentLevel(ListEffects.kairoseki.effectId, heldItem) > 0;
			boolean flag2 = heldItem != null && heldItem.getItem() instanceof Haki && ((Haki)heldItem.getItem()).type.equals("busoshoku") && heldItem.stackTagCompound != null && heldItem.stackTagCompound.getBoolean("use");

			if(event.entityLiving instanceof IOnePieceMob && ((IOnePieceMob)event.entityLiving).isLogia())	
				if(!flag1 || !flag2)
					event.setCanceled(true);
	
			if(event.entityLiving instanceof EntityPlayer && MainExtendedPlayer.get((EntityPlayer)event.entityLiving).isLogia())			
				if(!flag1 || !flag2)						
					event.setCanceled(true);			
		}
		
		if(event.source.getSourceOfDamage() instanceof EntityArrow)
		{
			EntityLivingBase living = (EntityLivingBase)event.entityLiving;

			if(living instanceof EntityPlayer && MainExtendedPlayer.get((EntityPlayer) living).isLogia())
				event.setCanceled(true);	
			
			if(living instanceof EntityPlayer && MainExtendedPlayer.get((EntityPlayer) living).getUsedFruit().equals("gomugomu"))
				event.setCanceled(true);
		}
		
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			MainExtendedPlayer props = MainExtendedPlayer.get(player);
			
			if(props.getUsedFruit().equals("meramera") && (event.source.equals(DamageSource.inFire) || event.source.equals(DamageSource.onFire)))
			{
				player.extinguish();
				event.setCanceled(true);
			}
			if(props.getUsedFruit().equals("magumagu") && (event.source.equals(DamageSource.inFire) || event.source.equals(DamageSource.onFire) || event.source.equals(DamageSource.lava)))
			{
				player.extinguish();
				event.setCanceled(true);
			}
		}
	}
	
}
