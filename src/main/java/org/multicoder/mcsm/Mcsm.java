package org.multicoder.mcsm;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.multicoder.mcsm.commands.MCSMCommands;
import org.slf4j.Logger;

@Mod(Mcsm.MODID)
public class Mcsm {
    public static final String MODID = "mcsm";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Mcsm(IEventBus modEventBus, ModContainer modContainer)
    {
        LOGGER.info("Starting MCSM");
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME)
    public static class ModEvents {
        @SubscribeEvent
        public static void RegisterCommands(RegisterCommandsEvent event) {

            LOGGER.info("Registering All Commands");
            MCSMCommands.RegisterCommands(event.getDispatcher());
        }
    }
}
