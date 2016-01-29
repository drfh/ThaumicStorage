package com.drfh.thaumicstorage.proxy;

import com.drfh.thaumicstorage.Main;
import com.drfh.thaumicstorage.common.tileEntity.TileEntityTiny;
import com.drfh.thaumicstorage.common.tileEntity.gui.GuiHandler;
import com.drfh.thaumicstorage.init.TSBlocks;
import com.drfh.thaumicstorage.init.TSItems;

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
		TSBlocks.registerRenders();
		TSItems.registerRenders();
	//	GameRegistry.registerTileEntity(TileEntityTiny.class,"containerTiny");
	//	WandTriggerRegistry.onItemUseFirst()
	}

	@Override
	public void postInit(FMLPostInitializationEvent e)
	{
		super.postInit(e);
	}
}
