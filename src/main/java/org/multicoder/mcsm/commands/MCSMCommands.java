package org.multicoder.mcsm.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.multicoder.mcsm.util.NBTUtility;



public class MCSMCommands
{

    public static void RegisterCommands(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("mcsm").then(Commands.literal("structure").then(Commands.literal("save").then(Commands.argument("name", StringArgumentType.string()).executes(MCSMCommands::Save))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcsm").then(Commands.literal("structure").then(Commands.literal("select").then(Commands.argument("name", StringArgumentType.string()).executes(MCSMCommands::Select))))).createBuilder().build();
    }

    private static int Select(CommandContext<CommandSourceStack> context) throws CommandSyntaxException
    {
        ServerPlayer player = context.getSource().getPlayerOrException();
        String name = StringArgumentType.getString(context,"name");
        player.getPersistentData().putString("Selected",name);
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
        player.getPersistentData().putString("Selected",name);
        player.getPersistentData().putLong("pos1",0L);
        player.getPersistentData().putLong("pos2",0L);
        player.sendSystemMessage(Component.literal("Structure " + name + " Saved And Selected"));
        return 0;
    }
}
