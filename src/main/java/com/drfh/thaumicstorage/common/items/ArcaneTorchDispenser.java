package com.drfh.thaumicstorage.common.items;

import java.util.List;

import com.drfh.thaumicstorage.Main;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArcaneTorchDispenser extends Item
{
	public ArcaneTorchDispenser()
	{
		super();
		//	this.setMaxStackSize(1);
		//	this.setMaxDamage(64);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		Main.logger.info("ArcaneTorchDispenser onItemUse:(stack) "+stack);
		Block block = world.getBlockState(pos).getBlock();
		Main.logger.info("ArcaneTorchDispenser onItemUse:(block) "+block);
		Main.logger.info("ArcaneTorchDispenser onItemUse:(pos) "+hitX+"  "+hitY+"  "+hitZ);

		if(block.canPlaceTorchOnTop(world, pos))
		{
			Main.logger.info("ArcaneTorchDispenser block.canPlaceTorchOnTop: YES");
/*			ItemBlock		ib=new ItemBlock(Blocks.torch);

			/*	InventoryPlayer inventory = playerIn.inventory;
			int mainInventoryTorchSlotIndex = getTorchSlotIndex(inventory.mainInventory);

//			if (mainInventoryTorchSlotIndex == -1)
//				return false;
 

//			ib.placeBlockAt(new ItemStack(Blocks.torch,1), playerIn, worldIn, pos, side, hitX, hitX, hitX, null);
//			ib.setTileEntityNBT(world, pos,new ItemStack(Blocks.torch), player);
//			ib.block.onBlockPlacedBy(world, pos, state, player, stack);
//			return super.onItemUse(,playerIn,worldIn,pos,side,hitX,hitY,hitZ);
			((EntityPlayerMP) playerIn).theItemInWorldManager
				.activateBlockOrUseItem(playerIn, worldIn,new ItemStack(new ItemBlock(Blocks.dirt)),
				pos,
				side, hitX, hitY, hitZ);//		playerIn.theItemInWorldManager
			 */
		}
		return super.onItemUse(stack,player,world,pos,side,hitX,hitY,hitZ);
	}

	private int getTorchSlotIndex(ItemStack[] itemStacks)
	{
		for (int index = 0; index < itemStacks.length; index++)
		{
			if (itemStacks[index] != null && itemStacks[index].getItem() == net.minecraft.item.Item
					.getItemFromBlock(Blocks.torch))
				return index;
		}
		return -1;
	}
	/*	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		Main.logger.info("ArcaneTorchDispenser onItemRightClick:()");

/*		((EntityPlayerMP) playerIn).theItemInWorldManager
		.activateBlockOrUseItem(playerIn, worldIn, itemStackIn,
				pos,
				face, 0.5f, 0.5f, 0.5f);//		playerIn.theItemInWorldManager
		return itemStackIn;
	}
*/
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	//	return stack.isItemEnchanted();
	}

	@Override
	public boolean hasContainerItem()
	{
		return true;
	}
	 
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, EntityPlayer play, List l, boolean par4)
	{
		//	Main.logger.info("ArcaneTorchDispenser addInformation:(NBT==NULL)");
		//	super.addInformation(item,play,l,par4);
	}
}

