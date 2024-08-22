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
    //      Camera
    public static final String KEY_CAMERA_1_SET = "key.mcsm.camera.cam_1.set";
    public static final String KEY_CAMERA_2_SET = "key.mcsm.camera.cam_2.set";
    public static final String KEY_CAMERA_3_SET = "key.mcsm.camera.cam_3.set";
    public static final String KEY_CAMERA_4_SET = "key.mcsm.camera.cam_4.set";
    public static final String KEY_CAMERA_5_SET = "key.mcsm.camera.cam_5.set";
    public static final String KEY_CAMERA_6_SET = "key.mcsm.camera.cam_6.set";
    public static final String KEY_CAMERA_7_SET = "key.mcsm.camera.cam_7.set";
    public static final String KEY_CAMERA_8_SET = "key.mcsm.camera.cam_8.set";
    public static final String KEY_CAMERA_9_SET = "key.mcsm.camera.cam_9.set";

    public static final String KEY_CAMERA_1_GO = "key.mcsm.camera.cam_1.go";
    public static final String KEY_CAMERA_2_GO = "key.mcsm.camera.cam_2.go";
    public static final String KEY_CAMERA_3_GO = "key.mcsm.camera.cam_3.go";
    public static final String KEY_CAMERA_4_GO = "key.mcsm.camera.cam_4.go";
    public static final String KEY_CAMERA_5_GO = "key.mcsm.camera.cam_5.go";
    public static final String KEY_CAMERA_6_GO = "key.mcsm.camera.cam_6.go";
    public static final String KEY_CAMERA_7_GO = "key.mcsm.camera.cam_7.go";
    public static final String KEY_CAMERA_8_GO = "key.mcsm.camera.cam_8.go";
    public static final String KEY_CAMERA_9_GO = "key.mcsm.camera.cam_9.go";

    //  Key Mappings
    //      Structure
    public static final KeyMapping STRUCTURE_NORTH = new KeyMapping(KEY_STRUCTURE_NORTH, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UP,CATEGORY_STRUCTURE);
    public static final KeyMapping STRUCTURE_EAST = new KeyMapping(KEY_STRUCTURE_EAST, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT,CATEGORY_STRUCTURE);
    public static final KeyMapping STRUCTURE_SOUTH = new KeyMapping(KEY_STRUCTURE_SOUTH, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_DOWN,CATEGORY_STRUCTURE);
    public static final KeyMapping STRUCTURE_WEST = new KeyMapping(KEY_STRUCTURE_WEST, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_LEFT,CATEGORY_STRUCTURE);
    public static final KeyMapping STRUCTURE_UP = new KeyMapping(KEY_STRUCTURE_UP, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_PAGE_UP,CATEGORY_STRUCTURE);
    public static final KeyMapping STRUCTURE_DOWN = new KeyMapping(KEY_STRUCTURE_DOWN, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_PAGE_DOWN,CATEGORY_STRUCTURE);
    //      Camera
    public static final KeyMapping CAM_1_SET = new KeyMapping(KEY_CAMERA_1_SET, KeyConflictContext.IN_GAME, KeyModifier.ALT, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_1,CATEGORY_CAMERA);
    public static final KeyMapping CAM_2_SET = new KeyMapping(KEY_CAMERA_2_SET, KeyConflictContext.IN_GAME, KeyModifier.ALT, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_2,CATEGORY_CAMERA);
    public static final KeyMapping CAM_3_SET = new KeyMapping(KEY_CAMERA_3_SET, KeyConflictContext.IN_GAME, KeyModifier.ALT, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_3,CATEGORY_CAMERA);
    public static final KeyMapping CAM_4_SET = new KeyMapping(KEY_CAMERA_4_SET, KeyConflictContext.IN_GAME, KeyModifier.ALT, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_4,CATEGORY_CAMERA);
    public static final KeyMapping CAM_5_SET = new KeyMapping(KEY_CAMERA_5_SET, KeyConflictContext.IN_GAME, KeyModifier.ALT, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_5,CATEGORY_CAMERA);
    public static final KeyMapping CAM_6_SET = new KeyMapping(KEY_CAMERA_6_SET, KeyConflictContext.IN_GAME, KeyModifier.ALT, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_6,CATEGORY_CAMERA);
    public static final KeyMapping CAM_7_SET = new KeyMapping(KEY_CAMERA_7_SET, KeyConflictContext.IN_GAME, KeyModifier.ALT, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_7,CATEGORY_CAMERA);
    public static final KeyMapping CAM_8_SET = new KeyMapping(KEY_CAMERA_8_SET, KeyConflictContext.IN_GAME, KeyModifier.ALT, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_8,CATEGORY_CAMERA);
    public static final KeyMapping CAM_9_SET = new KeyMapping(KEY_CAMERA_9_SET, KeyConflictContext.IN_GAME, KeyModifier.ALT, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_9,CATEGORY_CAMERA);

    public static final KeyMapping CAM_1_GO = new KeyMapping(KEY_CAMERA_1_GO, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_1,CATEGORY_CAMERA);
    public static final KeyMapping CAM_2_GO = new KeyMapping(KEY_CAMERA_2_GO, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_2,CATEGORY_CAMERA);
    public static final KeyMapping CAM_3_GO = new KeyMapping(KEY_CAMERA_3_GO, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_3,CATEGORY_CAMERA);
    public static final KeyMapping CAM_4_GO = new KeyMapping(KEY_CAMERA_4_GO, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_4,CATEGORY_CAMERA);
    public static final KeyMapping CAM_5_GO = new KeyMapping(KEY_CAMERA_5_GO, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_5,CATEGORY_CAMERA);
    public static final KeyMapping CAM_6_GO = new KeyMapping(KEY_CAMERA_6_GO, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_6,CATEGORY_CAMERA);
    public static final KeyMapping CAM_7_GO = new KeyMapping(KEY_CAMERA_7_GO, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_7,CATEGORY_CAMERA);
    public static final KeyMapping CAM_8_GO = new KeyMapping(KEY_CAMERA_8_GO, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_8,CATEGORY_CAMERA);
    public static final KeyMapping CAM_9_GO = new KeyMapping(KEY_CAMERA_9_GO, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_9,CATEGORY_CAMERA);

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

        event.register(CAM_1_SET);
        event.register(CAM_2_SET);
        event.register(CAM_3_SET);
        event.register(CAM_4_SET);
        event.register(CAM_5_SET);
        event.register(CAM_6_SET);
        event.register(CAM_7_SET);
        event.register(CAM_8_SET);
        event.register(CAM_9_SET);

        event.register(CAM_1_GO);
        event.register(CAM_2_GO);
        event.register(CAM_3_GO);
        event.register(CAM_4_GO);
        event.register(CAM_5_GO);
        event.register(CAM_6_GO);
        event.register(CAM_7_GO);
        event.register(CAM_8_GO);
        event.register(CAM_9_GO);
    }
    @Mod.EventBusSubscriber(modid = Mcsm.MODID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
    public static class ClientSideEvents
    {
        @SubscribeEvent
        public static void KeyPressed(InputEvent.Key keyEvent)
        {
            if(STRUCTURE_NORTH.consumeClick())
            {
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
            }
        }
    }
}
