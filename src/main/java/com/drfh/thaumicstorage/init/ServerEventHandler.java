package com.drfh.thaumicstorage.init;

import com.drfh.thaumicstorage.Main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ServerEventHandler
{
	private int		count=0;
	
	@SubscribeEvent
	public void onPlayerLogin(ItemEvent event)
	{
		
	}
/*	
	@SubscribeEvent
	public void onLivingUpdateEvent(LivingUpdateEvent event)
	{
		// do something to player every update tick:
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			ItemStack heldItem = player.getHeldItem();
			
			count++;
			if(count>20)
			{
			//	Main.logger.info("onLivingUpdateEvent");
				count=0;
			}
		//	if (heldItem != null && heldItem.itemID == Item.arrow.itemID) {
		//		player.capabilities.allowFlying = true;
		//	}
		//	else {
		//		player.capabilities.allowFlying = player.capabilities.isCreativeMode ? true : false;
		//	}
		}
	}
*/
}
