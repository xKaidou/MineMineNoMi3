package MineMineNoMi3.Utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;
import MineMineNoMi3.MainExtendedPlayer;

public class CustomEventGainDoriki extends EntityEvent
{
	public EntityPlayer player;
	public MainExtendedPlayer props;
	
	public CustomEventGainDoriki(EntityPlayer entity) 
	{
		super(entity);
		this.player = entity;
		this.props = MainExtendedPlayer.get(entity);
	}

}
