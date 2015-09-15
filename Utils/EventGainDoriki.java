package MineMineNoMi3.Utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;
import MineMineNoMi3.MainExtendedPlayer;

public class EventGainDoriki extends EntityEvent
{
	public EntityPlayer player;
	public MainExtendedPlayer props;
	
	public EventGainDoriki(EntityPlayer entity) 
	{
		super(entity);
		this.player = entity;
		this.props = MainExtendedPlayer.get(entity);
	}

}
