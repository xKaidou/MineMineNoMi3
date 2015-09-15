package MineMineNoMi3.Commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import MineMineNoMi3.Helper;
import MineMineNoMi3.Main;
import MineMineNoMi3.MainExtendedPlayer;
import MineMineNoMi3.Packets.PacketSync;
import MineMineNoMi3.Utils.EventGainDoriki;

public class CommandBounty extends CommandBase
{		
	public String getCommandName()
	{
		return "bounty";
	}
	
    public boolean canCommandSenderUseCommand(ICommandSender cmd)
    {
    	return true;
    }

	public void processCommand(ICommandSender cmd, String[] str)
	{
		if(str.length >= 2)
		{
			EntityPlayer player = null;
			MainExtendedPlayer props = null;
			
			if(str.length == 2)
			{
				player = this.getCommandSenderAsPlayer(cmd);	
				props = MainExtendedPlayer.get(player);
			}
			if(str.length == 3)
			{
				player = MinecraftServer.getServer().getConfigurationManager().func_152612_a(str[2]);	
				props = MainExtendedPlayer.get(player);
			}

			if(str[0].equals("+"))
			{
				if(Integer.decode(str[1]) + props.getDoriki() <= Helper.MAX_BOUNTY)
				{
					props.addBounty(Integer.decode(str[1]));
					Main.network.sendTo(new PacketSync(props), (EntityPlayerMP)player);
				}
				else
				{
					props.setBounty(Helper.MAX_BOUNTY);
					Main.network.sendTo(new PacketSync(props), (EntityPlayerMP)player);
				}
			}
			else if(str[0].equals("-"))
			{
				if(props.getDoriki() - Integer.decode(str[1]) <= 0)
				{
					props.setBounty(0);
					Main.network.sendTo(new PacketSync(props), (EntityPlayerMP)player);
				}
				else
				{
					props.decBounty(Integer.decode(str[1]));
					Main.network.sendTo(new PacketSync(props), (EntityPlayerMP)player);
				}			
			}
			else if(str[0].equals("="))
			{
				if(str[1].equals("INF"))
				{
					props.setBounty(Helper.MAX_BOUNTY);
					Main.network.sendTo(new PacketSync(props), (EntityPlayerMP)player);				
				}
				else if(Integer.decode(str[1]) <= Helper.MAX_BOUNTY)
				{
					props.setBounty(Integer.decode(str[1]));
					Main.network.sendTo(new PacketSync(props), (EntityPlayerMP)player);
				}	
			}
		}
	}
	  
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/bounty <+/-/=> <amount> [player]";
	}
}
