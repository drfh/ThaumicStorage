package com.drfh.thaumicstorage.init;

import com.drfh.thaumicstorage.Main;
import com.drfh.thaumicstorage.common.items.ArcaneTorchDispenser;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aura.AuraHelper;

public class TorchHandler
{
	private static final int NOTORCHESFOUND = -1;
	private boolean processingEvent = false;

	@SubscribeEvent
	public void playerInteractEventHandler(PlayerInteractEvent event)
	{

		if(processingEvent|eventNotRelevant(event))
			return;

		ItemStack	itemInHand=event.entityPlayer.inventory.getCurrentItem();
		
		if(notHoldingDispenser(itemInHand))
			return;
		
		BlockPos	pos=event.pos;
		Block		block=event.world.getBlockState(pos).getBlock();
		EnumFacing	face=event.face;
		
		if(!targetBlockAcceptsTorches(event,pos))
			if(targetBlockIsGrass(block))
			{
				face=EnumFacing.UP;
				pos=pos.down();
				if(!targetBlockAcceptsTorches(event,pos))
					return;
			}
			else
				return;
		
		InventoryPlayer		inventory = event.entityPlayer.inventory;
		int					mainInventoryTorchSlotIndex = getTorchSlotIndex(inventory.mainInventory);
		ItemStack			torchStack;
		
		processingEvent=true;
		if(mainInventoryTorchSlotIndex!=NOTORCHESFOUND)
		{
			torchStack=inventory.mainInventory[mainInventoryTorchSlotIndex];
			
		//	Main.logger.info("mainInventoryTorchSlotIndex: "+mainInventoryTorchSlotIndex);
			((EntityPlayerMP) event.entityPlayer).theItemInWorldManager
				.activateBlockOrUseItem(event.entityPlayer, event.world, torchStack, pos,face, 0.5f, 0.5f, 0.5f);
			
			if(torchStack.stackSize<0)
				inventory.mainInventory[mainInventoryTorchSlotIndex] = null;
			event.entityPlayer.openContainer.detectAndSendChanges();
		}
		else if(AuraHelper.getAura(event.world,event.pos,Aspect.AIR)>0&&AuraHelper.getAura(event.world,event.pos,Aspect.AIR)>0)
		{
			AuraHelper.drainAuraAvailable(event.world,event.pos,Aspect.AIR,1);
			AuraHelper.drainAuraAvailable(event.world,event.pos,Aspect.FIRE,1);
			//	Maybe take some more randomly to express inefficiency.

			torchStack=new ItemStack(Blocks.torch,1);
			
			((EntityPlayerMP) event.entityPlayer).theItemInWorldManager
			.activateBlockOrUseItem(event.entityPlayer, event.world, torchStack, pos,
			face, 0.5f, 0.5f, 0.5f);
		}
			
		processingEvent=false;
		event.setCanceled(true);
	}

	private void useItem(PlayerInteractEvent event,BlockPos pos,ItemStack torchStack)
	{
	}

	private boolean targetBlockAcceptsTorches(PlayerInteractEvent event,BlockPos pos)
	{
		Block	block=event.world.getBlockState(pos).getBlock();
		return block.canPlaceTorchOnTop(event.world, pos);
	}

	private boolean targetBlockIsGrass(Block block)
	{
		return (block.isEqualTo(block,Blocks.grass))||(block.isEqualTo(block,Blocks.tallgrass));
	}

	private boolean eventNotRelevant(PlayerInteractEvent event)
	{
		return event.isCanceled() || event.world.isRemote || event.action != PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK;
	}


	private boolean notHoldingDispenser(ItemStack itemInHand)
	{
		return itemInHand == null || !(itemInHand.getItem() instanceof ArcaneTorchDispenser);
	}


	private int getTorchSlotIndex(ItemStack[] itemStacks)
	{
		for (int index = 0; index < itemStacks.length; index++)
		{
			if (itemStacks[index] != null && itemStacks[index].getItem() == net.minecraft.item.Item
					.getItemFromBlock(Blocks.torch))
				return index;
		}
		return NOTORCHESFOUND;
	}

}
