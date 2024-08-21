package org.multicoder.mcsm.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.LongTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.multicoder.mcsm.util.NBTUtility;

public class MCSMCommands
{

    public static void RegisterCommands(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("mcsm").then(Commands.literal("structure").then(Commands.literal("pos1").executes(MCSMCommands::Pos1)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcsm").then(Commands.literal("structure").then(Commands.literal("pos2").executes(MCSMCommands::Pos2)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcsm").then(Commands.literal("structure").then(Commands.literal("save").then(Commands.argument("name", StringArgumentType.string()).executes(MCSMCommands::Save))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcsm").then(Commands.literal("north").then(Commands.argument("name", StringArgumentType.string()).executes(MCSMCommands::MoveNorth)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcsm").then(Commands.literal("east").then(Commands.argument("name", StringArgumentType.string()).executes(MCSMCommands::MoveEast)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcsm").then(Commands.literal("south").then(Commands.argument("name", StringArgumentType.string()).executes(MCSMCommands::MoveSouth)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcsm").then(Commands.literal("west").then(Commands.argument("name", StringArgumentType.string()).executes(MCSMCommands::MoveWest)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcsm").then(Commands.literal("up").then(Commands.argument("name", StringArgumentType.string()).executes(MCSMCommands::MoveUp)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcsm").then(Commands.literal("down").then(Commands.argument("name", StringArgumentType.string()).executes(MCSMCommands::MoveDown)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcsm").then(Commands.literal("camera").then(Commands.argument("number", IntegerArgumentType.integer(0,9)).then(Commands.literal("set").executes(MCSMCommands::SetCamera))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcsm").then(Commands.literal("camera").then(Commands.argument("number", IntegerArgumentType.integer(0,9)).then(Commands.literal("go").executes(MCSMCommands::MoveToCam))))).createBuilder().build();
    }

    private static int SetCamera(CommandContext<CommandSourceStack> context) throws CommandSyntaxException
    {
        ServerPlayer player = context.getSource().getPlayerOrException();
        int Index = IntegerArgumentType.getInteger(context,"number");
        String Key = "Camera" + Index;
        long BlockPos = player.blockPosition().asLong();
        float XRot = player.getXRot();
        float YRot = player.getYRot();
        CompoundTag NBT = new CompoundTag();
        NBT.putLong("pos",BlockPos);
        NBT.putFloat("pitch",XRot);
        NBT.putFloat("yaw",YRot);
        player.getPersistentData().put(Key,NBT);
        return 0;
    }

    private static int MoveToCam(CommandContext<CommandSourceStack> context) throws CommandSyntaxException
    {
        ServerPlayer player = context.getSource().getPlayerOrException();
        int Index = IntegerArgumentType.getInteger(context,"number");
        String Key = "Camera" + Index;
        CompoundTag NBT = player.getPersistentData().getCompound(Key);
        BlockPos pos = BlockPos.of(NBT.getLong("pos"));
        float Pitch = NBT.getFloat("pitch");
        float Yaw = NBT.getFloat("yaw");
        player.teleportTo(context.getSource().getLevel(),pos.getX(),pos.getY(),pos.getZ(),Yaw,Pitch);
        return 0;
    }

    private static int MoveNorth(CommandContext<CommandSourceStack> context) throws CommandSyntaxException
    {
        ServerPlayer player = context.getSource().getPlayerOrException();
        ServerLevel level = context.getSource().getLevel();
        String name = StringArgumentType.getString(context,"name");
        NBTUtility.StructureNorth(level,player,name);
        return 0;
    }
    private static int MoveEast(CommandContext<CommandSourceStack> context) throws CommandSyntaxException
    {
        ServerPlayer player = context.getSource().getPlayerOrException();
        ServerLevel level = context.getSource().getLevel();
        String name = StringArgumentType.getString(context,"name");
        NBTUtility.StructureEast(level,player,name);
        return 0;
    }
    private static int MoveSouth(CommandContext<CommandSourceStack> context) throws CommandSyntaxException
    {
        ServerPlayer player = context.getSource().getPlayerOrException();
        ServerLevel level = context.getSource().getLevel();
        String name = StringArgumentType.getString(context,"name");
        NBTUtility.StructureSouth(level,player,name);
        return 0;
    }
    private static int MoveWest(CommandContext<CommandSourceStack> context) throws CommandSyntaxException
    {
        ServerPlayer player = context.getSource().getPlayerOrException();
        ServerLevel level = context.getSource().getLevel();
        String name = StringArgumentType.getString(context,"name");
        NBTUtility.StructureWest(level,player,name);
        return 0;
    }
    private static int MoveUp(CommandContext<CommandSourceStack> context) throws CommandSyntaxException
    {
        ServerPlayer player = context.getSource().getPlayerOrException();
        ServerLevel level = context.getSource().getLevel();
        String name = StringArgumentType.getString(context,"name");
        NBTUtility.StructureUp(level,player,name);
        return 0;
    }
    private static int MoveDown(CommandContext<CommandSourceStack> context) throws CommandSyntaxException
    {
        ServerPlayer player = context.getSource().getPlayerOrException();
        ServerLevel level = context.getSource().getLevel();
        String name = StringArgumentType.getString(context,"name");
        NBTUtility.StructureDown(level,player,name);
        return 0;
    }

    private static int Save(CommandContext<CommandSourceStack> context) throws CommandSyntaxException
    {
        ServerPlayer player = context.getSource().getPlayerOrException();
        ServerLevel level = context.getSource().getLevel();
        BlockPos Pos1 = BlockPos.of(player.getPersistentData().getLong("pos1"));
        BlockPos Pos2 = BlockPos.of(player.getPersistentData().getLong("pos2"));
        String name = StringArgumentType.getString(context,"name");
        NBTUtility.SaveStructure(Pos1,Pos2,level,player,name);
        player.sendSystemMessage(Component.literal("Structure " + name + " Saved"));
        return 0;
    }

    private static int Pos2(CommandContext<CommandSourceStack> context) throws CommandSyntaxException
    {
        ServerPlayer player = context.getSource().getPlayerOrException();
        BlockPos Position = player.blockPosition().below();
        player.getPersistentData().put("pos2", LongTag.valueOf(Position.asLong()));
        player.sendSystemMessage(Component.literal("Position 2 Set"));
        return 0;
    }

    private static int Pos1(CommandContext<CommandSourceStack> context) throws CommandSyntaxException
    {
        ServerPlayer player = context.getSource().getPlayerOrException();
        BlockPos Position = player.blockPosition().below();
        player.getPersistentData().put("pos1", LongTag.valueOf(Position.asLong()));
        player.sendSystemMessage(Component.literal("Position 1 Set"));
        return 0;
    }
}
