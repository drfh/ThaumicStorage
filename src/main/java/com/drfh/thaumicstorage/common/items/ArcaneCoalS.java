package com.drfh.thaumicstorage.common.items;

import java.util.List;

import com.drfh.thaumicstorage.Main;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aura.AuraHelper;

public class ArcaneCoalS extends ArcaneCoal // implements ICrafting
{
	static	int		delay;

	public ArcaneCoalS()
	{
		super();
		delay=0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}

	@Override
	public boolean canRecharge()
	{
		return true;
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
	{
		if(stack.getItem() instanceof ArcaneCoalS)
		{
			ArcaneCoalS		item=(ArcaneCoalS)stack.getItem();

			if(delay++<18)
				return;
			delay=0;

			if(item.canRecharge())
			{
				//	Main.logger.info("onUpdate: "+stack.getItemDamage()+"  "+stack.getMaxDamage());
				if(stack.getItemDamage()>0)  //item.getBurnTime())
				{
				//	int		auraOrder=AuraHelper.getAura(entityIn.getEntityWorld(),entityIn.getPosition(),Aspect.ORDER);
					int		auraFire=AuraHelper.getAura(entityIn.getEntityWorld(),entityIn.getPosition(),Aspect.FIRE);

					if(auraFire>0)//&&auraOrder>0)
					{
						int		recharged=0;

					//	Main.logger.info("onUpdate: auraOrder: "+auraOrder);
					//	Main.logger.info("onUpdate: auraFire: "+auraFire);
					//	AuraHelper.drainAuraAvailable(entityIn.getEntityWorld(),entityIn.getPosition(),Aspect.ORDER,1);
						AuraHelper.drainAuraAvailable(entityIn.getEntityWorld(),entityIn.getPosition(),Aspect.FIRE,1);

						recharged=this.rechargeFuel(stack,item.getBurnTime()*3);
					}
				}
			}
		}
	}
	
/*	@Override
	public ItemStack getContainerItem(ItemStack itemStack)
	{
		ItemStack 	newStack=super.getContainerItem(itemStack);
		
		
		newStack=;
		return newStack;
	}
*/
	/*
	@Override
	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem)
	{
	//	Main.logger.info("onEntityItemUpdate: "+entityItem);
		return true;
	}
	
	public void updateCraftingInventory(Container containerToSend, List<ItemStack> itemsList)
	{
		Main.logger.info("updateCraftingInventory: ");
	}

	public void sendSlotContents(Container containerToSend, int slotInd, ItemStack stack)
	{
		Main.logger.info("sendSlotContents: ");
	}

	public void sendProgressBarUpdate(Container containerIn, int varToUpdate, int newValue)
	{
		Main.logger.info("sendProgressBarUpdate: ");
	}

	public void sendAllWindowProperties(Container p_175173_1_, IInventory p_175173_2_)
	{

	}
*/
}
