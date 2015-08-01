package MineMineNoMi3.Events;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import MineMineNoMi3.Helper;
import MineMineNoMi3.Main;
import MineMineNoMi3.MainExtendedPlayer;
import MineMineNoMi3.Entities.Base.ILogia;
import MineMineNoMi3.Items.Haki;
import MineMineNoMi3.Lists.ListMisc;
import MineMineNoMi3.Lists.ListPotions;
import MineMineNoMi3.Packets.PacketSync;
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

			for(int i = 100; i <= 200; i++)
				for(int j = 200; j > 100; j--)
					if(i!=j && player.isPotionActive(i) && player.isPotionActive(j) && !player.capabilities.isCreativeMode)
						player.attackEntityFrom(DamageSource.wither, Float.POSITIVE_INFINITY);	
			
			if(player.isPotionActive(ListPotions.gomugomu) || player.isPotionActive(ListPotions.banebane) || props.isLogia() || 
					(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == ListMisc.Geppo))
				player.fallDistance = 0;
			
			int extraHP = (int)Math.pow( Math.log(props.getDoriki()+1) , 2);

			if(extraHP < 20)
				extraHP = 20;
			else
			{
				player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(extraHP);
				float NEW_HEALTH = (float)player.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();
				extraHP = (int) NEW_HEALTH;
			}			
		}
	}
	
	@SubscribeEvent
	public void onPlayerDrinkMilk(PlayerInteractEvent event)
	{
		if(event.action.RIGHT_CLICK_AIR != null && event.entityPlayer != null && event.entityPlayer.inventory.getCurrentItem() != null && event.entityPlayer.inventory.getCurrentItem().getItem()==Items.milk_bucket && !event.world.isRemote)
		{
			MainExtendedPlayer props = MainExtendedPlayer.get(event.entityPlayer);
			
			for(int i=0; i < Helper.abilities.size(); i++)
				event.entityPlayer.inventory.consumeInventoryItem(Helper.abilities.get(i));			
			for(int j=100; j < 256; j++)
				event.entityPlayer.removePotionEffect(j);	
		}
	}
	
	@SubscribeEvent
	public void onAttackEvent(LivingAttackEvent event)
	{
		if(event.source.getSourceOfDamage() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.source.getSourceOfDamage();
			MainExtendedPlayer props = MainExtendedPlayer.get(player);
			ItemStack heldItem = player.getCurrentEquippedItem();
			
			boolean flag1 = heldItem != null && heldItem.getItem() instanceof ItemSword && EnchantmentHelper.getEnchantmentLevel(ListPotions.kairoseki.effectId, heldItem) > 0;
			boolean flag2 = heldItem != null && heldItem.getItem() instanceof Haki && ((Haki)heldItem.getItem()).type.equals("busoshoku") && heldItem.stackTagCompound != null && heldItem.stackTagCompound.getBoolean("use");
			
			if(event.entityLiving instanceof ILogia)
				if(!flag1 || !flag2)
					event.setCanceled(true);

			if(event.entityLiving instanceof EntityPlayer && MainExtendedPlayer.get((EntityPlayer)event.entityLiving).isLogia())			
				if(!flag1 || !flag2)						
					event.setCanceled(true);			
		}
		
		if(event.entityLiving instanceof EntityPlayer && (event.source.equals(DamageSource.lava) || event.source.equals(DamageSource.inFire) || event.source.equals(DamageSource.onFire)))
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			
			if(player.isPotionActive(ListPotions.magumagu) || player.isPotionActive(ListPotions.magumagu))
			{
				event.setCanceled(true);
				player.fireResistance = (int)Float.POSITIVE_INFINITY;
			}
		}

	}
	
}
