package org.multicoder.mcsm.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class NBTUtility
{
    public static void SaveStructure(BlockPos pos1, BlockPos pos2, Level level, ServerPlayer player,String Name)
    {
        Stream<BlockPos> Positions = BlockPos.betweenClosedStream(pos1,pos2);
        CompoundTag Structure = new CompoundTag();
        ListTag Blocks = new ListTag();
        Positions.forEach(pos ->
        {
            CompoundTag NBT = new CompoundTag();
            NBT.putLong("Position",pos.asLong());
            CompoundTag State = NbtUtils.writeBlockState(level.getBlockState(pos));
            NBT.put("State",State);
            Blocks.add(NBT);
        });
        Structure.put("Structure",Blocks);
        player.getPersistentData().put(Name,Structure);
    }

    public static void StructureNorth(Level level, ServerPlayer player, String Name)
    {
        CompoundTag Structure = player.getPersistentData().getCompound(Name);
        Map<BlockPos,BlockState> blocks = new HashMap<>();
        Map<BlockPos,BlockState> blocksud = new HashMap<>();
        Structure.getList("Structure", ListTag.TAG_COMPOUND).forEach(tag ->
        {
            CompoundTag T = (CompoundTag) tag;
            BlockPos position = BlockPos.of(T.getLong("Position"));
            BlockState State = NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(),T.getCompound("State"));
            blocks.put(position,State);
        });
        blocks.forEach((pos, state) -> level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState()));
        blocks.forEach((pos, state) ->
        {
            level.setBlockAndUpdate(pos.north(),state);
            blocksud.put(pos.north(),state);
        });
        ListTag UpdatedStructureTag = new ListTag();
        blocksud.forEach((pos,state) ->
        {
            CompoundTag NBT = new CompoundTag();
            NBT.putLong("Position",pos.asLong());
            NBT.put("State",NbtUtils.writeBlockState(state));
            UpdatedStructureTag.add(NBT);
        });
        Structure.put("Structure",UpdatedStructureTag);
        player.getPersistentData().put(Name,Structure);
    }
    public static void StructureEast(Level level, ServerPlayer player, String Name)
    {
        CompoundTag Structure = player.getPersistentData().getCompound(Name);
        Map<BlockPos,BlockState> blocks = new HashMap<>();
        Map<BlockPos,BlockState> blocksud = new HashMap<>();
        Structure.getList("Structure", ListTag.TAG_COMPOUND).forEach(tag ->
        {
            CompoundTag T = (CompoundTag) tag;
            BlockPos position = BlockPos.of(T.getLong("Position"));
            BlockState State = NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(),T.getCompound("State"));
            blocks.put(position,State);
        });
        blocks.forEach((pos, state) -> level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState()));
        blocks.forEach((pos, state) ->
        {
            level.setBlockAndUpdate(pos.east(),state);
            blocksud.put(pos.east(),state);
        });
        ListTag UpdatedStructureTag = new ListTag();
        blocksud.forEach((pos,state) ->
        {
            CompoundTag NBT = new CompoundTag();
            NBT.putLong("Position",pos.asLong());
            NBT.put("State",NbtUtils.writeBlockState(state));
            UpdatedStructureTag.add(NBT);
        });
        Structure.put("Structure",UpdatedStructureTag);
        player.getPersistentData().put(Name,Structure);
    }
    public static void StructureSouth(Level level, ServerPlayer player, String Name)
    {
        CompoundTag Structure = player.getPersistentData().getCompound(Name);
        Map<BlockPos,BlockState> blocks = new HashMap<>();
        Map<BlockPos,BlockState> blocksud = new HashMap<>();
        Structure.getList("Structure", ListTag.TAG_COMPOUND).forEach(tag ->
        {
            CompoundTag T = (CompoundTag) tag;
            BlockPos position = BlockPos.of(T.getLong("Position"));
            BlockState State = NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(),T.getCompound("State"));
            blocks.put(position,State);
        });
        blocks.forEach((pos, state) -> level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState()));
        blocks.forEach((pos, state) ->
        {
            level.setBlockAndUpdate(pos.south(),state);
            blocksud.put(pos.south(),state);
        });
        ListTag UpdatedStructureTag = new ListTag();
        blocksud.forEach((pos,state) ->
        {
            CompoundTag NBT = new CompoundTag();
            NBT.putLong("Position",pos.asLong());
            NBT.put("State",NbtUtils.writeBlockState(state));
            UpdatedStructureTag.add(NBT);
        });
        Structure.put("Structure",UpdatedStructureTag);
        player.getPersistentData().put(Name,Structure);
    }
    public static void StructureWest(Level level, ServerPlayer player, String Name)
    {
        CompoundTag Structure = player.getPersistentData().getCompound(Name);
        Map<BlockPos,BlockState> blocks = new HashMap<>();
        Map<BlockPos,BlockState> blocksud = new HashMap<>();
        Structure.getList("Structure", ListTag.TAG_COMPOUND).forEach(tag ->
        {
            CompoundTag T = (CompoundTag) tag;
            BlockPos position = BlockPos.of(T.getLong("Position"));
            BlockState State = NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(),T.getCompound("State"));
            blocks.put(position,State);
        });
        blocks.forEach((pos, state) -> level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState()));
        blocks.forEach((pos, state) ->
        {
            level.setBlockAndUpdate(pos.west(),state);
            blocksud.put(pos.west(),state);
        });
        ListTag UpdatedStructureTag = new ListTag();
        blocksud.forEach((pos,state) ->
        {
            CompoundTag NBT = new CompoundTag();
            NBT.putLong("Position",pos.asLong());
            NBT.put("State",NbtUtils.writeBlockState(state));
            UpdatedStructureTag.add(NBT);
        });
        Structure.put("Structure",UpdatedStructureTag);
        player.getPersistentData().put(Name,Structure);
    }
    public static void StructureUp(Level level, ServerPlayer player, String Name)
    {
        CompoundTag Structure = player.getPersistentData().getCompound(Name);
        Map<BlockPos,BlockState> blocks = new HashMap<>();
        Map<BlockPos,BlockState> blocksud = new HashMap<>();
        Structure.getList("Structure", ListTag.TAG_COMPOUND).forEach(tag ->
        {
            CompoundTag T = (CompoundTag) tag;
            BlockPos position = BlockPos.of(T.getLong("Position"));
            BlockState State = NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(),T.getCompound("State"));
            blocks.put(position,State);
        });
        blocks.forEach((pos, state) -> level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState()));
        blocks.forEach((pos, state) ->
        {
            level.setBlockAndUpdate(pos.above(),state);
            blocksud.put(pos.above(),state);
        });
        ListTag UpdatedStructureTag = new ListTag();
        blocksud.forEach((pos,state) ->
        {
            CompoundTag NBT = new CompoundTag();
            NBT.putLong("Position",pos.asLong());
            NBT.put("State",NbtUtils.writeBlockState(state));
            UpdatedStructureTag.add(NBT);
        });
        Structure.put("Structure",UpdatedStructureTag);
        player.getPersistentData().put(Name,Structure);
    }
    public static void StructureDown(Level level, ServerPlayer player, String Name)
    {
        CompoundTag Structure = player.getPersistentData().getCompound(Name);
        Map<BlockPos,BlockState> blocks = new HashMap<>();
        Map<BlockPos,BlockState> blocksud = new HashMap<>();
        Structure.getList("Structure", ListTag.TAG_COMPOUND).forEach(tag ->
        {
            CompoundTag T = (CompoundTag) tag;
            BlockPos position = BlockPos.of(T.getLong("Position"));
            BlockState State = NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(),T.getCompound("State"));
            blocks.put(position,State);
        });
        blocks.forEach((pos, state) -> level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState()));
        blocks.forEach((pos, state) ->
        {
            level.setBlockAndUpdate(pos.below(),state);
            blocksud.put(pos.below(),state);
        });
        ListTag UpdatedStructureTag = new ListTag();
        blocksud.forEach((pos,state) ->
        {
            CompoundTag NBT = new CompoundTag();
            NBT.putLong("Position",pos.asLong());
            NBT.put("State",NbtUtils.writeBlockState(state));
            UpdatedStructureTag.add(NBT);
        });
        Structure.put("Structure",UpdatedStructureTag);
        player.getPersistentData().put(Name,Structure);
    }
}
