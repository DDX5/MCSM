package org.multicoder.mcsm.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.multicoder.mcsm.Mcsm;

@SuppressWarnings("all")
public record CameraSetC2SPacket(int Number) implements CustomPacketPayload
{

    public static final ResourceLocation ID = new ResourceLocation(Mcsm.MODID,"camera_set");

    public CameraSetC2SPacket(FriendlyByteBuf buf)
    {
        this(buf.readInt());
    }

    @Override
    public void write(FriendlyByteBuf friendlyByteBuf)
    {
        friendlyByteBuf.writeInt(Number());
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }
}
