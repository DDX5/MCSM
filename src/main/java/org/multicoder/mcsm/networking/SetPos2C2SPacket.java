package org.multicoder.mcsm.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.multicoder.mcsm.Mcsm;

@SuppressWarnings("all")
public record SetPos2C2SPacket() implements CustomPacketPayload
{
    public static final ResourceLocation ID = new ResourceLocation(Mcsm.MODID,"structure_pos2");

    public SetPos2C2SPacket(FriendlyByteBuf byteBuf) {this();}

    @Override
    public void write(FriendlyByteBuf friendlyByteBuf) {}

    @Override
    public ResourceLocation id() {return ID;}
}
