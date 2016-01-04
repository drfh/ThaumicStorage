package com.drfh.thaumicstorage.init;

import com.drfh.thaumicstorage.common.items.ArcaneTorchDispenser;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
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
		if(!targetBlockAcceptsTorches(event))
			return;
		
		if(AuraHelper.getAura(event.world,event.pos,Aspect.AIR)>0&&AuraHelper.getAura(event.world,event.pos,Aspect.AIR)>0)
		{
			AuraHelper.drainAuraAvailable(event.world, event.pos, Aspect.AIR,1);
			AuraHelper.drainAuraAvailable(event.world, event.pos, Aspect.FIRE,1);
			//	Maybe take some more randomly to express inefficiency.
		}
		
		ItemStack	torchStack=new ItemStack(Blocks.torch,1);

		processingEvent=true;
		useItem(event,torchStack);

		event.entityPlayer.openContainer.detectAndSendChanges();
		processingEvent=false;
		event.setCanceled(true);
	}

	private void useItem(PlayerInteractEvent event, ItemStack torchStack)
	{
		((EntityPlayerMP) event.entityPlayer).theItemInWorldManager
		.activateBlockOrUseItem(event.entityPlayer, event.world, torchStack, event.pos,
				event.face, 0.5f, 0.5f, 0.5f);
	}

	private boolean targetBlockAcceptsTorches(PlayerInteractEvent event)
	{
		Block	block=event.world.getBlockState(event.pos).getBlock();
		return block.canPlaceTorchOnTop(event.world, event.pos);

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
