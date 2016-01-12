package com.drfh.thaumicstorage.init;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class TSGUIHandler implements IGuiHandler
{
	public void registerRenderers() {}

	@Override
	public Object getServerGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z)
	{
		// Hooray, no 'magic' numbers - we know exactly which Gui this refers to
		if (guiId == 0)//InventoryItemMain.GUI_ITEM_INV)
		{
			// Use the player's held item to create the inventory
		//	return new ContainerItem(player, player.inventory, new TSInventoryItem(player.getHeldItem()));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z)
	{
		if (guiId == 0)//InventoryItemMain.GUI_ITEM_INV)
		{
			// We have to cast the new container as our custom class
			// and pass in currently held item for the inventory
		//	return new GuiItemInventory((ContainerItem) new ContainerItem(player, player.inventory, new TSInventoryItem(player.getHeldItem())));
		}
		return null;
	}
}