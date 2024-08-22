package org.multicoder.mcsm;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;
import org.multicoder.mcsm.commands.MCSMCommands;
import org.multicoder.mcsm.networking.*;
import org.multicoder.mcsm.networking.handlers.PayloadHandlers;
import org.slf4j.Logger;

@SuppressWarnings("all")
@Mod(Mcsm.MODID)
public class Mcsm
{
    public static final String MODID = "mcsm";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Mcsm(IEventBus modEventBus)
    {
        LOGGER.info("Starting MCSM");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ModForgeEvents {
        @SubscribeEvent
        public static void RegisterCommands(RegisterCommandsEvent event) {

            LOGGER.info("Registering All Commands");
            MCSMCommands.RegisterCommands(event.getDispatcher());
        }
    }
    @Mod.EventBusSubscriber(modid = MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents
    {
        @SubscribeEvent
        public static void RegisterPayloads(RegisterPayloadHandlerEvent event)
        {
            IPayloadRegistrar registrar = event.registrar("mcsm");
            registrar.play(StructureNorthC2SPacket.ID,StructureNorthC2SPacket::new,handler -> handler.server(PayloadHandlers.getInstance()::HandleData));
            registrar.play(StructureEastC2SPacket.ID,StructureEastC2SPacket::new,handler -> handler.server(PayloadHandlers.getInstance()::HandleData));
            registrar.play(StructureSouthC2SPacket.ID,StructureSouthC2SPacket::new,handler -> handler.server(PayloadHandlers.getInstance()::HandleData));
            registrar.play(StructureWestC2SPacket.ID,StructureWestC2SPacket::new,handler -> handler.server(PayloadHandlers.getInstance()::HandleData));
            registrar.play(StructureUpC2SPacket.ID,StructureUpC2SPacket::new,handler -> handler.server(PayloadHandlers.getInstance()::HandleData));
            registrar.play(StructureDownC2SPacket.ID,StructureDownC2SPacket::new,handler -> handler.server(PayloadHandlers.getInstance()::HandleData));
        }
    }

}
