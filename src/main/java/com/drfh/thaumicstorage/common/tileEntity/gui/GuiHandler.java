package com.drfh.thaumicstorage.common.tileEntity.gui;

import com.drfh.thaumicstorage.client.ContainerTiny;
import com.drfh.thaumicstorage.client.GuiTiny;

import TileEntityTiny.TileEntityTiny;
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
		switch(id)
		{
			case 0:
				TileEntity tileEntity = world.getTileEntity(new BlockPos(x,y,z));
				if(tileEntity instanceof TileEntityTiny)
					return new ContainerTiny(player.inventory, (TileEntityTiny) tileEntity);
		}
		return null;
	}

	//returns an instance of the Gui you made earlier
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world,int x, int y, int z)
	{
		switch(id)
		{
			case 0:
				TileEntity tileEntity = world.getTileEntity(new BlockPos(x,y,z));
				if(tileEntity instanceof TileEntityTiny)
					return new GuiTiny(player.inventory, (TileEntityTiny) tileEntity);
		}
		return null;
	}
}
