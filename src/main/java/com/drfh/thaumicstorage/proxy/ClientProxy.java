package com.drfh.thaumicstorage.proxy;

import com.drfh.thaumicstorage.Main;
import com.drfh.thaumicstorage.common.tileEntity.gui.GuiHandler;
import com.drfh.thaumicstorage.init.TSBlocks;
import com.drfh.thaumicstorage.init.TSItems;

import TileEntityTiny.TileEntityTiny;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent e)
	{
		super.preInit(e);
	}

	@Override
	public void init(FMLInitializationEvent e)
	{
		super.init(e);
		TSItems.registerRenders();
		TSBlocks.registerRenders();

		GameRegistry.registerTileEntity(TileEntityTiny.class,"containerTiny");
	}

	@Override
	public void postInit(FMLPostInitializationEvent e)
	{
		super.postInit(e);
	}
}
