package com.drfh.thaumicstorage.init;

import com.drfh.thaumicstorage.Main;
import com.drfh.thaumicstorage.common.items.EnergyItem;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;


public class SmeltingHandler
{
/*	@SubscribeEvent
	public void ItemSmeltedEvent(ItemSmeltedEvent event)
	{
		Item	item=event.smelting.getItem();
		
		Main.logger.info("ItemSmeltedEvent: "+item);
		if(item instanceof EnergyItem)
		{
			Main.logger.info("ItemSmeltedEvent: instanceof EnergyItem");
			if(((EnergyItem)item).canRecharge())
			{
				Main.logger.info("ItemSmeltedEvent: canRecharge");
			//	((EnergyItem)item).rechargeFuel(10);
			//	this.ItemSmeltedEvent(event.player,event.smelting);
			}
		}
	}
	
	@SubscribeEvent
	public void ItemSmeltedEvent(ItemSmeltedEvent event, ItemStack crafting)
	{
		Main.logger.info("*******************");
	//	super(player);
		if(crafting.getItem() instanceof EnergyItem)
		{
		//	()crafting.rechargeFuel
		}
	//	return crafting;
	}
	/*		public void onSmelting(ItemSmeltedEvent event)
	{
		if(event.smelting.getItem() == TSItems.arcane_coal)
		{
			;//	event.player.addStat(AchievementHandler.cobaltachiev15, 1);
		}
	}
*/
}
