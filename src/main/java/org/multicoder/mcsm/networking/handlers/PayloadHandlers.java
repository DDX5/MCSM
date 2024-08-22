package org.multicoder.mcsm.networking.handlers;


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
}
