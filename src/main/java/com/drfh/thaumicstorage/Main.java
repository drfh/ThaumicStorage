package com.drfh.thaumicstorage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.drfh.thaumicstorage.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, dependencies=Reference.deps)

public class Main {

	@SidedProxy(modId=Reference.MOD_ID, clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
	public static CommonProxy	proxy;

	public static Logger			logger = LogManager.getLogger("ThaumicStorage");
	@Instance(Reference.MOD_ID)
	public static Main				instance;
	public static TSCreativeTab		tscreative = new TSCreativeTab("tabCreativeTS");
	
	private static int modGuiIndex = 0;
	public static final int GUI_ITEM_INV = modGuiIndex++;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		proxy.postInit(e);
	}
}
