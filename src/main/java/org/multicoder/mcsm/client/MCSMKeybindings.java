package org.multicoder.mcsm.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.client.settings.KeyModifier;
import net.neoforged.neoforge.network.PacketDistributor;
import org.lwjgl.glfw.GLFW;
import org.multicoder.mcsm.Mcsm;
import org.multicoder.mcsm.networking.*;

@SuppressWarnings("all")
@Mod.EventBusSubscriber(modid = Mcsm.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class MCSMKeybindings
{
    //  Categories
    public static final String CATEGORY_STRUCTURE = "key.category.mcsm.structure";
    public static final String CATEGORY_CAMERA = "key.category.mcsm.camera";

    //  Keys
    //      Structure
    public static final String KEY_STRUCTURE_NORTH = "key.mcsm.structure.north";
    public static final String KEY_STRUCTURE_EAST = "key.mcsm.structure.east";
    public static final String KEY_STRUCTURE_SOUTH = "key.mcsm.structure.south";
    public static final String KEY_STRUCTURE_WEST = "key.mcsm.structure.west";
    public static final String KEY_STRUCTURE_UP = "key.mcsm.structure.up";
    public static final String KEY_STRUCTURE_DOWN = "key.mcsm.structure.down";
    public static final String KEY_STRUCTURE_POS1 = "key.mcsm.structure.pos1";
    public static final String KEY_STRUCTURE_POS2 = "key.mcsm.structure.pos2";
    //      Camera
    public static final String KEY_CAMERA_SET = "key.mcsm.camera.cam.set";
    public static final String KEY_CAMERA_NEXT = "key.mcsm.camera.cam.next";
    public static final String KEY_CAMERA_PREV = "key.mcsm.camera.cam.prev";
    public static final String KEY_CAMERA_GO = "key.mcsm.camera.cam.go";

    //  Key Mappings
    //      Structure
    public static final KeyMapping STRUCTURE_NORTH = new KeyMapping(KEY_STRUCTURE_NORTH, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UP,CATEGORY_STRUCTURE);
    public static final KeyMapping STRUCTURE_EAST = new KeyMapping(KEY_STRUCTURE_EAST, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT,CATEGORY_STRUCTURE);
    public static final KeyMapping STRUCTURE_SOUTH = new KeyMapping(KEY_STRUCTURE_SOUTH, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_DOWN,CATEGORY_STRUCTURE);
    public static final KeyMapping STRUCTURE_WEST = new KeyMapping(KEY_STRUCTURE_WEST, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_LEFT,CATEGORY_STRUCTURE);
    public static final KeyMapping STRUCTURE_UP = new KeyMapping(KEY_STRUCTURE_UP, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_PAGE_UP,CATEGORY_STRUCTURE);
    public static final KeyMapping STRUCTURE_DOWN = new KeyMapping(KEY_STRUCTURE_DOWN, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_PAGE_DOWN,CATEGORY_STRUCTURE);

    public static final KeyMapping STRUCTURE_POS1 = new KeyMapping(KEY_STRUCTURE_POS1, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_LEFT_BRACKET,CATEGORY_STRUCTURE);
    public static final KeyMapping STRUCTURE_POS2 = new KeyMapping(KEY_STRUCTURE_POS2, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_BRACKET,CATEGORY_STRUCTURE);

    //      Camera
    public static final KeyMapping CAM_SET = new KeyMapping(KEY_CAMERA_SET, KeyConflictContext.IN_GAME, KeyModifier.SHIFT, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_K, CATEGORY_CAMERA);
    public static final KeyMapping CAM_PREV = new KeyMapping(KEY_CAMERA_PREV, KeyConflictContext.IN_GAME,KeyModifier.SHIFT, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_H, CATEGORY_CAMERA);
    public static final KeyMapping CAM_NEXT = new KeyMapping(KEY_CAMERA_NEXT, KeyConflictContext.IN_GAME,KeyModifier.SHIFT, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_J, CATEGORY_CAMERA);
    public static final KeyMapping CAM_GO = new KeyMapping(KEY_CAMERA_GO, KeyConflictContext.IN_GAME,KeyModifier.SHIFT, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_L, CATEGORY_CAMERA);

    @SubscribeEvent
    public static void RegisterKeyBinding(RegisterKeyMappingsEvent event)
    {
        Mcsm.LOGGER.info("Adding Keybindings");
        event.register(STRUCTURE_NORTH);
        event.register(STRUCTURE_EAST);
        event.register(STRUCTURE_SOUTH);
        event.register(STRUCTURE_WEST);
        event.register(STRUCTURE_UP);
        event.register(STRUCTURE_DOWN);
        event.register(STRUCTURE_POS1);
        event.register(STRUCTURE_POS2);
        event.register(CAM_SET);
        event.register(CAM_GO);
        event.register(CAM_NEXT);
        event.register(CAM_PREV);
    }
    @Mod.EventBusSubscriber(modid = Mcsm.MODID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
    public static class ClientSideEvents
    {
        @SubscribeEvent
        public static void KeyPressed(InputEvent.Key keyEvent)
        {
            if(STRUCTURE_NORTH.consumeClick()) {
                PacketDistributor.SERVER.noArg().send(new StructureNorthC2SPacket());
            } else if (STRUCTURE_EAST.consumeClick()) {
                PacketDistributor.SERVER.noArg().send(new StructureEastC2SPacket());
            } else if (STRUCTURE_SOUTH.consumeClick()) {
                PacketDistributor.SERVER.noArg().send(new StructureSouthC2SPacket());
            } else if (STRUCTURE_WEST.consumeClick()) {
                PacketDistributor.SERVER.noArg().send(new StructureWestC2SPacket());
            } else if (STRUCTURE_UP.consumeClick()) {
                PacketDistributor.SERVER.noArg().send(new StructureUpC2SPacket());
            } else if (STRUCTURE_DOWN.consumeClick()) {
                PacketDistributor.SERVER.noArg().send(new StructureDownC2SPacket());
            } else if (STRUCTURE_POS1.consumeClick()) {
                PacketDistributor.SERVER.noArg().send(new SetPos1C2SPacket());
            } else if (STRUCTURE_POS2.consumeClick()) {
                PacketDistributor.SERVER.noArg().send(new SetPos2C2SPacket());
            } else if (CAM_SET.consumeClick()) {
                PacketDistributor.SERVER.noArg().send(new CameraSetC2SPacket());
            } else if (CAM_GO.consumeClick()) {
                PacketDistributor.SERVER.noArg().send(new CameraGoC2SPacket());
            } else if (CAM_NEXT.consumeClick()) {
                PacketDistributor.SERVER.noArg().send(new CameraNextC2SPacket());
            } else if (CAM_PREV.consumeClick()) {
                PacketDistributor.SERVER.noArg().send(new CameraPrevC2SPacket());
            }
        }
    }
}
