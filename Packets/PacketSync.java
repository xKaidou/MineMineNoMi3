package MineMineNoMi3.Packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import MineMineNoMi3.MainExtendedPlayer;
import cpw.mods.fml.common.network.ByteBufUtils;

public class PacketSync extends AbstractPacket
{
	private NBTTagCompound data;

	public PacketSync(){}
  
	public PacketSync(MainExtendedPlayer info)
	{
		this.data = new NBTTagCompound();
		info.saveNBTData(this.data);
	}

	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		ByteBufUtils.writeTag(buffer, this.data);
	}

	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		this.data = ByteBufUtils.readTag(buffer);
	}

	public void handleClientSide(EntityPlayer player)
	{
		MainExtendedPlayer.get(player).loadNBTData(this.data);
	}

	public void handleServerSide(EntityPlayer player)
	{
		MainExtendedPlayer.get(player).loadNBTData(this.data);
	}
}