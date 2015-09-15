package MineMineNoMi3.Packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import MineMineNoMi3.Main;
import MineMineNoMi3.MainExtendedPlayer;
import MineMineNoMi3.Entities.Projectile;
import MineMineNoMi3.Lists.ListMisc;
import MineMineNoMi3.Utils.AbilityAttribute;
import cpw.mods.fml.common.network.ByteBufUtils;

public class PacketPlayer extends AbstractPacket
{
	private String cmd;

	public PacketPlayer(){}

	public PacketPlayer(String cmd)
	{
		this.cmd = cmd;
	}

	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		ByteBufUtils.writeUTF8String(buffer, this.cmd);
	}

	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		this.cmd = ByteBufUtils.readUTF8String(buffer);
	}

	public void handleClientSide(EntityPlayer player)
	{
		if(this.cmd.contains("projectile_"))
		{
			String cmd = this.cmd.substring(11);
			
			if(cmd.equals("daienkaientei"))
				player.worldObj.spawnEntityInWorld(new Projectile(player.worldObj, player, AbilityAttribute.DAIENKAIENTEI));
		}
	}

	public void handleServerSide(EntityPlayer player)
	{		
		if(this.cmd.equals("delete_book"))
			player.inventory.consumeInventoryItem(ListMisc.CharacterCreator);
		
		if(this.cmd.equals("forcesync"))
			Main.network.sendTo(new PacketSync(MainExtendedPlayer.get(player)), (EntityPlayerMP) player);
		
		if(this.cmd.contains("projectile_"))
		{
			String cmd = this.cmd.substring(11);
			
			if(cmd.equals("daienkaientei"))
				player.worldObj.spawnEntityInWorld(new Projectile(player.worldObj, player, AbilityAttribute.DAIENKAIENTEI));			
		}
		
	}
}