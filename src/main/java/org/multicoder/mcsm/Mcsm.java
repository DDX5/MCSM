package org.multicoder.mcsm;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.multicoder.mcsm.commands.MCSMCommands;
import org.slf4j.Logger;

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
    public static class ModEvents {
        @SubscribeEvent
        public static void RegisterCommands(RegisterCommandsEvent event) {

            LOGGER.info("Registering All Commands");
            MCSMCommands.RegisterCommands(event.getDispatcher());
        }
    }
}
