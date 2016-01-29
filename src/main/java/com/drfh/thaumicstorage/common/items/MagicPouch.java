package com.drfh.thaumicstorage.common.items;

import com.drfh.thaumicstorage.Main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class MagicPouch extends Item
{
/*	public MagicPouch(int par1)
	{
		super(par1);
		// ItemStacks that store an NBT Tag Compound are limited to stack size of 1
		setMaxStackSize(1);
		// you'll want to set a creative tab as well, so you can get your item
		setCreativeTab(CreativeTabs.tabMisc);
	}

	// Without this method, your inventory will NOT work!!!
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1; // return any value greater than zero
	}
   
    	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
		if (!world.isRemote)
		{
			// If player not sneaking, open the inventory gui
			if (!player.isSneaking()) {
				player.openGui(InventoryItemMain.instance, InventoryItemMain.GUI_ITEM_INV, world, 0, 0, 0);
			}
			
			// Otherwise, stealthily place some diamonds in there for a nice surprise next time you open it up :)
			else {
				new InventoryItem(player.getHeldItem()).setInventorySlotContents(0, new ItemStack(Item.diamond,4));
			}
		}
		
		return itemstack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon("inventoryitemmod:" + this.getUnlocalizedName().substring(5));
	}
	
	
	@Override
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
