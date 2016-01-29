package com.drfh.thaumicstorage.common.tileEntity.gui;

import com.drfh.thaumicstorage.Main;
import com.drfh.thaumicstorage.client.ContainerTiny;
import com.drfh.thaumicstorage.client.GuiTiny;
import com.drfh.thaumicstorage.common.items.MagicPouch;
import com.drfh.thaumicstorage.common.tileEntity.TileEntityTiny;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world,int x, int y, int z)
	{
		TileEntity tileEntity;
		
		Main.logger.info("getServerGuiElement: "+id);
		switch(id)
		{
			case 0:
				tileEntity = world.getTileEntity(new BlockPos(x,y,z));
				if(tileEntity instanceof TileEntityTiny)
					return new ContainerTiny(player.inventory, (TileEntityTiny) tileEntity);
			case 1:
				tileEntity=((MagicPouch)player.getHeldItem().getItem()).createNewTileEntity(world,0);
				if(tileEntity instanceof TileEntityTiny)
					return new ContainerTiny(player.inventory, (TileEntityTiny) tileEntity);
		}
		return null;
	}

	//returns an instance of the Gui you made earlier
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world,int x, int y, int z)
	{
		TileEntity tileEntity;
		
		Main.logger.info("getClientGuiElement: "+id);
		switch(id)
		{
			case 0:
				tileEntity = world.getTileEntity(new BlockPos(x,y,z));
				if(tileEntity instanceof TileEntityTiny)
					return new GuiTiny(player.inventory, (TileEntityTiny) tileEntity);
			case 1:
				tileEntity=((MagicPouch)player.getHeldItem().getItem()).createNewTileEntity(world,0);
				if(tileEntity instanceof TileEntityTiny)
					return new GuiTiny(player.inventory, (TileEntityTiny) tileEntity);
		}
		return null;
	}
}
