package crazypants.enderio.config;

import io.netty.buffer.ByteBuf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import lombok.SneakyThrows;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketConfigSync implements IMessage, IMessageHandler<PacketConfigSync, PacketConfigSync> {

  public PacketConfigSync() {
  }

  private Map<String, Object> configValues;

  public PacketConfigSync(ConfigProcessor toSync) {
    this.configValues = toSync.configValues;
  }

  @Override
  @SneakyThrows
  public void toBytes(ByteBuf buf) {
    ByteArrayOutputStream obj = new ByteArrayOutputStream();
    GZIPOutputStream gzip = new GZIPOutputStream(obj);
    ObjectOutputStream objStream = new ObjectOutputStream(gzip);
    objStream.writeObject(configValues);
    objStream.close();

    buf.writeShort(obj.size());
    buf.writeBytes(obj.toByteArray());
  }

  @SuppressWarnings("unchecked")
  @Override
  @SneakyThrows
  public void fromBytes(ByteBuf buf) {
    short len = buf.readShort();
    byte[] compressedBody = new byte[len];

    for (short i = 0; i < len; i++)
      compressedBody[i] = buf.readByte();

    ObjectInputStream obj = new ObjectInputStream(new GZIPInputStream(new ByteArrayInputStream(compressedBody)));
    configValues = (Map<String, Object>) obj.readObject();
    obj.close();
  }

  @Override
  public PacketConfigSync onMessage(PacketConfigSync message, MessageContext ctx) {
    if (ctx.side.isServer()) {
      return new PacketConfigSync(Configs.getProcessor());
    } else {
      Configs.getProcessor().syncTo(message.configValues);
      return null;
    }
  }
}
