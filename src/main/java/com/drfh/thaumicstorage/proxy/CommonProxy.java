package com.drfh.thaumicstorage.proxy;

import com.drfh.thaumicstorage.Main;
import com.drfh.thaumicstorage.Reference;
import com.drfh.thaumicstorage.TSFuelHandler;
import com.drfh.thaumicstorage.init.SmeltingHandler;
import com.drfh.thaumicstorage.init.SmeltingRecipes;
import com.drfh.thaumicstorage.init.TSBlocks;
import com.drfh.thaumicstorage.init.TSItems;
import com.drfh.thaumicstorage.init.Thaumonomicon;
import com.drfh.thaumicstorage.init.TorchHandler;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class CommonProxy
{
	private static NBTTagCompound	UpdateInfo;
	
	public void preInit(FMLPreInitializationEvent e)
	{
		UpdateInfo = new NBTTagCompound();
		UpdateInfo.setString("curseProjectName","thaumicstorage");
		UpdateInfo.setString("curseFilenameParser", "ThaumicStorage-[].jar");
		
		FMLInterModComms.sendRuntimeMessage(Reference.MOD_ID, "VersionChecker","addCurseCheck",UpdateInfo);
		FMLInterModComms.sendRuntimeMessage(Reference.MOD_ID,"VersionChecker","addVersionCheck",Reference.version_check_url);
		
		TSItems.init();
		TSItems.register();
		TSBlocks.init();
		TSBlocks.register();
		MinecraftForge.EVENT_BUS.register(new TorchHandler());
		
		addEventAndSpecialEventBus(new SmeltingHandler());
	}
	
	public void init(FMLInitializationEvent e)
	{
//		NetworkRegistry.instance().registerGuiHandler(this, new CommonProxy());
		
		GameRegistry.registerFuelHandler(new TSFuelHandler());

		GameRegistry.addSmelting(new ItemStack(TSItems.arcane_coal),new ItemStack(TSItems.arcane_coal),0);
		GameRegistry.addSmelting(new ItemStack(TSItems.arcane_coal_block),new ItemStack(TSItems.arcane_coal_block),0);
	}
	
	public void postInit(FMLPostInitializationEvent e)
	{
		SmeltingRecipes.init();
		Thaumonomicon.setup();
	}
	
	private static void addEventAndSpecialEventBus(Object o) {
		MinecraftForge.EVENT_BUS.register(o);
		FMLCommonHandler.instance().bus().register(o);
		Main.logger.info("Registered event handler: " + o.getClass());
	}
}
