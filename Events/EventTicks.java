package MineMineNoMi3.Events;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import MineMineNoMi3.Main;
import MineMineNoMi3.MainExtendedPlayer;
import MineMineNoMi3.MainKeys;
import MineMineNoMi3.Packets.PacketSync;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class EventTicks 
{
	
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event) 
	{
		EntityPlayer player = event.player;
		MainExtendedPlayer props = MainExtendedPlayer.get(player);
		
		if (event.phase == Phase.START) 
		{	
			if(player != null && player instanceof EntityPlayer)
			{
				if(player.isInsideOfMaterial(Material.water) && !player.capabilities.isCreativeMode)
				{
					if (!props.getUsedFruit().equals("N/A"))
						player.motionY -= 5;	

					if(props.getRace().equals("Fishman") && props.getUsedFruit().equals("N/A"))
					{
						player.setAir(300);
						
						if ((player.motionX >= 5.0D) || (player.motionZ >= 5.0D))
						{
							player.motionX /= 1.2D;
							player.motionZ /= 1.2D;
						}
						else
						{
							player.motionX *= 1.2D;
							player.motionZ *= 1.2D;
						}
					}	
				}	
			}
		}
	}
	
}
