package org.multicoder.mcsm.networking.handlers;


import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import org.multicoder.mcsm.networking.*;
import org.multicoder.mcsm.util.NBTUtility;

@SuppressWarnings("all")
public class PayloadHandlers
{
    private static final PayloadHandlers INSTANCE = new PayloadHandlers();

    public static PayloadHandlers getInstance()
    {
        return INSTANCE;
    }

    public void HandleData(final StructureNorthC2SPacket packet, final PlayPayloadContext context)
    {
        ServerPlayer player = (ServerPlayer) context.player().get();
        String name = player.getPersistentData().getString("Selected");
        ServerLevel level = (ServerLevel) context.level().get();
        NBTUtility.StructureNorth(level,player,name);
    }
    public void HandleData(final StructureEastC2SPacket packet, final PlayPayloadContext context)
    {
        ServerPlayer player = (ServerPlayer) context.player().get();
        String name = player.getPersistentData().getString("Selected");
        ServerLevel level = (ServerLevel) context.level().get();
        NBTUtility.StructureEast(level,player,name);
    }
    public void HandleData(final StructureSouthC2SPacket packet, final PlayPayloadContext context)
    {
        ServerPlayer player = (ServerPlayer) context.player().get();
        String name = player.getPersistentData().getString("Selected");
        ServerLevel level = (ServerLevel) context.level().get();
        NBTUtility.StructureSouth(level,player,name);
    }
    public void HandleData(final StructureWestC2SPacket packet, final PlayPayloadContext context)
    {
        ServerPlayer player = (ServerPlayer) context.player().get();
        String name = player.getPersistentData().getString("Selected");
        ServerLevel level = (ServerLevel) context.level().get();
        NBTUtility.StructureWest(level,player,name);
    }
    public void HandleData(final StructureUpC2SPacket packet, final PlayPayloadContext context)
    {
        ServerPlayer player = (ServerPlayer) context.player().get();
        String name = player.getPersistentData().getString("Selected");
        ServerLevel level = (ServerLevel) context.level().get();
        NBTUtility.StructureUp(level,player,name);
    }
    public void HandleData(final StructureDownC2SPacket packet, final PlayPayloadContext context)
    {
        ServerPlayer player = (ServerPlayer) context.player().get();
        String name = player.getPersistentData().getString("Selected");
        ServerLevel level = (ServerLevel) context.level().get();
        NBTUtility.StructureDown(level,player,name);
    }
    public void HandleData(final SetPos1C2SPacket packet, final PlayPayloadContext context)
    {
        ServerPlayer player = (ServerPlayer) context.player().get();
        player.getPersistentData().putLong("pos1",player.blockPosition().below().asLong());
    }
    public void HandleData(final SetPos2C2SPacket packet, final PlayPayloadContext context)
    {
        ServerPlayer player = (ServerPlayer) context.player().get();
        player.getPersistentData().putLong("pos2",player.blockPosition().below().asLong());
    }
    public void HandleData(final CameraSetC2SPacket packet, final PlayPayloadContext context)
    {
        ServerPlayer player = (ServerPlayer) context.player().get();
        int Index = packet.Number();
        String Key = "Camera" + Index;
        long BlockPos = player.blockPosition().asLong();
        float XRot = player.getXRot();
        float YRot = player.getYRot();
        CompoundTag NBT = new CompoundTag();
        NBT.putLong("pos",BlockPos);
        NBT.putFloat("pitch",XRot);
        NBT.putFloat("yaw",YRot);
        player.getPersistentData().put(Key,NBT);
    }
    public void HandleData(final CameraGoC2SPacket packet, final PlayPayloadContext context)
    {
        ServerPlayer player = (ServerPlayer) context.player().get();
        int Index = packet.Number();
        String Key = "Camera" + Index;
        CompoundTag NBT = player.getPersistentData().getCompound(Key);
        BlockPos position = BlockPos.of(NBT.getLong("pos"));
        float Pitch = NBT.getFloat("pitch");
        float Yaw = NBT.getFloat("yaw");
        player.teleportTo((ServerLevel) context.level().get(),position.getX(),position.getY(),position.getZ(),Yaw,Pitch);
    }
}
