package com.drfh.thaumicstorage.common.items;

import com.drfh.thaumicstorage.Main;
import com.drfh.thaumicstorage.common.tileEntity.TileEntityTiny;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MagicPouch extends Item implements ITileEntityProvider
{
	public MagicPouch()
	{
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		TileEntityTiny		tile=new TileEntityTiny();
		tile.setWorldObj(world);
		return tile;//super.createNewTileEntity(world,meta);
	}

	// Without this method, your inventory will NOT work!!!
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 1; // return any value greater than zero
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
		if (!world.isRemote) // On server
		{
			// If player not sneaking, open the inventory gui
			if (!player.isSneaking())
			{
				Main.logger.info("onItemRightClick: onServer");
				player.openGui(Main.instance, 1, world,player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
			}
		}
		else	//	On client
		{
			Main.logger.info("onItemRightClick: onClient");
			player.openGui(Main.instance, 1, world,player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
		}
		return itemstack;
	}

	/*	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == Main.GUI_ITEM_INV)
		{
			// Use the player's held item to create the inventory
			return new ContainerItem(player, player.inventory, new InventoryItem(player.getHeldItem()));
		}
		return null;
	}
	 */
}
