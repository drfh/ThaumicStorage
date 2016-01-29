package com.drfh.thaumicstorage.init;

import com.drfh.thaumicstorage.Main;
import com.drfh.thaumicstorage.common.items.ArcaneTorchDispenser;
import com.drfh.thaumicstorage.common.items.FocusTorch;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aura.AuraHelper;


public class TorchHandler
{
	private static final int NOTORCHESFOUND = -1;
	private boolean processingEvent = false;
	public static TorchHandler	th;

	public static boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		Block		block=world.getBlockState(pos).getBlock();
		EnumFacing	faceT=side;

		if(world.isRemote)
			return false;
		if(!targetBlockAcceptsTorches(world,pos))
			if(targetBlockIsGrass(block))
			{
				faceT=EnumFacing.UP;
				pos=pos.down();
				if(!targetBlockAcceptsTorches(world,pos))
					return false;
			}
			else
				return false;

		ItemStack			torchStack=null;
		InventoryPlayer		inventory=playerIn.inventory;
		Item				torch;
		
		int	mainInventoryTorchSlotIndex = getTorchSlotIndex(inventory.mainInventory);
//		int	mainInventoryTorchSlotIndex = playerIn.inventory.getInventorySlotContainItem(Item.getItemFromBlock(Blocks.torch));
		if(mainInventoryTorchSlotIndex!=NOTORCHESFOUND)
		{
			torchStack=inventory.mainInventory[mainInventoryTorchSlotIndex];
		}
		
		torch=net.minecraft.item.Item.getItemFromBlock(Blocks.torch);
		if(torchStack==null && stack!=null)
		{
			if(stack.getItem() == torch)
				torchStack=stack;
			else if(stack.getItem() == TSItems.torch_foci)
				torchStack=new ItemStack(Blocks.torch,1);
		}

		if(torchStack == null)
		{
			if(AuraHelper.getAura(world,pos,Aspect.AIR)>0&&AuraHelper.getAura(world,pos,Aspect.AIR)>0)
			{
				AuraHelper.drainAuraAvailable(world,pos,Aspect.AIR,1);
				AuraHelper.drainAuraAvailable(world,pos,Aspect.FIRE,1);
				//	Maybe take some more randomly to express inefficiency.

				torchStack=new ItemStack(Blocks.torch,1);
			}
		}

		playerIn.openContainer.detectAndSendChanges();
		if(torchStack != null)
		{
			boolean	placed=torchStack.onItemUse(playerIn, world, pos, faceT, hitX, hitY, hitZ);
			
			playerIn.openContainer.detectAndSendChanges();
			
			//	Weird 0 quantity itemStack bug
			if(mainInventoryTorchSlotIndex!=NOTORCHESFOUND)
			{
				if(inventory.mainInventory[mainInventoryTorchSlotIndex].stackSize==0)
					inventory.mainInventory[mainInventoryTorchSlotIndex]=null;
			}
			
			playerIn.openContainer.detectAndSendChanges();
			return placed;
		}
		return false;
	}

	private static boolean targetBlockAcceptsTorches(World world,BlockPos pos)
	{
		Block	block=world.getBlockState(pos).getBlock();
		return block.canPlaceTorchOnTop(world, pos);
	}

	private static boolean targetBlockIsGrass(Block block)
	{
		return (block.isEqualTo(block,Blocks.grass))||(block.isEqualTo(block,Blocks.tallgrass));
	}

	private static boolean eventNotRelevant(PlayerInteractEvent event)
	{
		return event.isCanceled() || event.world.isRemote || event.action != PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK;
	}

	private static boolean notHoldingDispenser(ItemStack itemInHand)
	{
		return itemInHand == null || !(itemInHand.getItem() instanceof ArcaneTorchDispenser);
	}

	private static boolean notHoldingWand(ItemStack itemInHand)
	{
		return itemInHand == null || !(itemInHand.getItem() instanceof FocusTorch);
	}

	private static int getTorchSlotIndex(ItemStack[] itemStacks)
	{
		for (int index = 0; index < itemStacks.length; index++)
		{
			if (itemStacks[index] != null && itemStacks[index].getItem() == net.minecraft.item.Item.getItemFromBlock(Blocks.torch))
				return index;
		}
		return NOTORCHESFOUND;
	}

}
