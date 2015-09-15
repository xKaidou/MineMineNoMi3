package MineMineNoMi3.Events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import MineMineNoMi3.MainExtendedPlayer;
import MineMineNoMi3.Lists.ListMisc;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventJobs 
{

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
	    if (event.entity instanceof EntityPlayer && !event.entity.worldObj.isRemote)
	    {
	    	EntityPlayer player = (EntityPlayer)event.entity;
	    	MainExtendedPlayer props = MainExtendedPlayer.get(player);

	    	if(props.getRace().equals("N/A") && props.getFaction().equals("N/A") && props.getJob().equals("N/A") && !player.inventory.hasItem(ListMisc.CharacterCreator))
	    		player.inventory.addItemStackToInventory(new ItemStack(ListMisc.CharacterCreator, 1));
	    }
	}
	
	@SubscribeEvent
	public void onEntityUpdateEvent(LivingEvent.LivingUpdateEvent event)
	{	
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			MainExtendedPlayer props = MainExtendedPlayer.get(player);
			ItemStack heldItem = player.getCurrentEquippedItem();

			if(heldItem != null)
			{	
				if(props.getJob().equals("Swordsman") && heldItem.getItem() instanceof ItemSword)
					player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 2, 0));
				
				/*if(props.getJob().equals("Sniper") && heldItem.getItemUseAction() == EnumAction.bow)
				{
					if(!heldItem.isItemEnchanted())
						heldItem.addEnchantment(Enchantment.power, 1);					
				}*/
		
			}
		}
	}

}
