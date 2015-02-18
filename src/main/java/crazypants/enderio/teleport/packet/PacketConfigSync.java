package crazypants.enderio.teleport.packet;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import crazypants.enderio.config.Configs;

public class PacketConfigSync implements IMessage, IMessageHandler<PacketConfigSync, IMessage> {

  @Override
  public void toBytes(ByteBuf buf) {
    buf.writeBoolean(Configs.travelAnchorEnabled);
    buf.writeInt(Configs.travelAnchorMaxDistance);
    buf.writeBoolean(Configs.travelStaffEnabled);
    buf.writeBoolean(Configs.travelStaffBlinkEnabled);
    buf.writeBoolean(Configs.travelStaffBlinkThroughSolidBlocksEnabled);
    buf.writeBoolean(Configs.travelStaffBlinkThroughClearBlocksEnabled);
    buf.writeInt(Configs.travelStaffBlinkPauseTicks);
    buf.writeInt(Configs.travelStaffMaxDistance);
    buf.writeInt(Configs.travelStaffMaxBlinkDistance);
    buf.writeFloat(Configs.travelStaffPowerPerBlockRF);
  }

  @Override
  public void fromBytes(ByteBuf data) {
    Configs.travelAnchorEnabled = data.readBoolean();
    Configs.travelAnchorMaxDistance = data.readInt();
    Configs.travelStaffEnabled = data.readBoolean();
    Configs.travelStaffBlinkEnabled = data.readBoolean();
    Configs.travelStaffBlinkThroughSolidBlocksEnabled = data.readBoolean();
    Configs.travelStaffBlinkThroughClearBlocksEnabled = data.readBoolean();
    Configs.travelStaffBlinkPauseTicks = data.readInt();
    Configs.travelStaffMaxDistance = data.readInt();
    Configs.travelStaffMaxBlinkDistance = data.readInt();
    Configs.travelStaffPowerPerBlockRF = data.readFloat();
  }

  @Override
  public IMessage onMessage(PacketConfigSync message, MessageContext ctx) {
    return null;
  }
}
