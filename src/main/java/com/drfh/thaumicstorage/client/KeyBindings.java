package com.drfh.thaumicstorage.client;

import org.lwjgl.input.Keyboard;

import com.drfh.thaumicstorage.Reference;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBindings
{
    // Declare two KeyBindings, ping and pong
    public static KeyBinding	openTSGUI;

    public static void init()
    {
    	openTSGUI = new KeyBinding("key.pong", Keyboard.KEY_U, "key.categories."+Reference.MOD_ID);

        // Register both KeyBindings to the ClientRegistry
        ClientRegistry.registerKeyBinding(openTSGUI);
    }

}