package MineMineNoMi3.Events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import MineMineNoMi3.Helper;
import MineMineNoMi3.Items.Ability;
import MineMineNoMi3.Items.Haki;
import MineMineNoMi3.Items.Rokushiki;
import MineMineNoMi3.Lists.ListMisc;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventDrops
{

	@SubscribeEvent	
	public void onTossedItem(ItemTossEvent event)
	{		
		Item item = event.entityItem.getEntityItem().getItem();
		
		if(item instanceof Ability || item instanceof Rokushiki || item instanceof Haki)
		{
			event.setCanceled(true);			
			if(event.player instanceof EntityPlayer)
				event.player.inventory.addItemStackToInventory(new ItemStack(item));
		}
	}
	
	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{	
			EntityPlayer player = ((EntityPlayer)event.entityLiving);
			
			for(int i=0; i < Helper.abilities.size(); i++)
				player.inventory.consumeInventoryItem(Helper.abilities.get(i));

			player.inventory.consumeInventoryItem(ListMisc.CharacterCreator);
			
			player.inventory.consumeInventoryItem(ListMisc.Soru);	
			player.inventory.consumeInventoryItem(ListMisc.Tekkai);	
			player.inventory.consumeInventoryItem(ListMisc.Geppo);	
			player.inventory.consumeInventoryItem(ListMisc.Shigan);	
			player.inventory.consumeInventoryItem(ListMisc.Kamie);	
			player.inventory.consumeInventoryItem(ListMisc.Rankyaku);	
			
			player.inventory.consumeInventoryItem(ListMisc.BusoshokuHaki);	
			player.inventory.consumeInventoryItem(ListMisc.KenbunshokuHaki);	
			player.inventory.consumeInventoryItem(ListMisc.HaoshokuHaki);	
		}
	}
}
