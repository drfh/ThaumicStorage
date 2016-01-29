package com.drfh.thaumicstorage.common.event;

import com.drfh.thaumicstorage.Main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import thaumcraft.api.wands.IWandTriggerManager;

public class WandOverride implements IWandTriggerManager {

	@Override
	public boolean performTrigger(World world, ItemStack wand, EntityPlayer player, BlockPos pos, EnumFacing side,int event)
	{
		Main.logger.info("performTrigger: ");
		return false;
	}

}
