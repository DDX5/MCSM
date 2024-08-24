package org.multicoder.mcsm.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.multicoder.mcsm.Mcsm;

@SuppressWarnings("all")
public record CameraPrevC2SPacket() implements CustomPacketPayload
{
    public static final ResourceLocation ID = new ResourceLocation(Mcsm.MODID,"camera_prev");

    public CameraPrevC2SPacket(FriendlyByteBuf buf)
    {
        this();
    }

    @Override
    public void write(FriendlyByteBuf friendlyByteBuf)
    {

    }

    @Override
    public ResourceLocation id() {
        return ID;
    }
}
