package com.drfh.thaumicstorage.common.items;

import com.drfh.thaumicstorage.Reference;
import com.drfh.thaumicstorage.init.TSItems;
import com.drfh.thaumicstorage.init.TorchHandler;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.FocusUpgradeType;
import thaumcraft.api.wands.ItemFocusBasic;
import thaumcraft.common.items.wands.ItemWand;

public class FocusTorch extends ItemFocusBasic
{
	public FocusTorch()
	{
		super("focus_torch",0xFFFD60);
	}

	public FocusTorch(String id,ResourceLocation texture,int renderColor)
	{
		super(id,texture,renderColor);
		//	maxStackSize=1;
		//	canRepair=false;
		//	this.setMaxDamage(0);
		//	foci.put(id, this);
	}

	public FocusTorch(String id,int renderColor)
	{
		this(id,new ResourceLocation(Reference.MOD_ID,"textures/items/focus_torch"),renderColor);
	}

	@Override
	public AspectList getVisCost(ItemStack focusstack)
	{
		return new AspectList().add(Aspect.AIR,1).add(Aspect.FIRE,1);
	}

	@Override
	public boolean isVisCostPerTick(ItemStack focusstack)
	{
		return true;
	}

	@Override
	public WandFocusAnimation getAnimation(ItemStack focusstack)
	{
		return WandFocusAnimation.WAVE;
	}

	@Override
	public EnumRarity getRarity(ItemStack focusstack)
	{
		return EnumRarity.COMMON;
	}	

	@Override
	public boolean canBePlacedInTurret()
	{
		return true;
	}

	@Override
	public FocusUpgradeType[] getPossibleUpgradesByRank(ItemStack focusstack, int rank)
	{
		return new FocusUpgradeType[]{FocusUpgradeType.extend,FocusUpgradeType.frugal};
	}

    @Override
	public boolean onFocusActivation(ItemStack i, World w, EntityLivingBase e, MovingObjectPosition mop, int tick)
	{
	//	Main.logger.info("onFocusActivation: "+tick);		
	//	if(tick<1)
	//		return false;
		if(w.isRemote)
		{
		//	Main.logger.info("onFocusActivation: Server Side(Do Nothing)");
			return false;
		}

		if(e instanceof EntityPlayer)
		{
			ItemStack 				focus=((ItemWand)i.getItem()).getFocusStack(i);
			double					dist=8;
			BlockPos				aim=null;
			MovingObjectPosition	objPos=null;

			if(focus!=null)
			{
				dist+=getUpgradeLevel(focus,FocusUpgradeType.extend)*6.0;
			}
			if(!e.isServerWorld())
				objPos=e.rayTrace(dist,1.0F);
			else
				objPos=mop;
			if(objPos!=null)
			{
				aim=objPos.getBlockPos();
			}
			if(aim!=null)
				return TorchHandler.onItemUse(new ItemStack(TSItems.torch_foci,1),(EntityPlayer)e,w,aim,objPos.sideHit,0.5F,0.5F,0.5F);
		}
		return false;
	}

	/*	@Override
	public void onPlayerStoppedUsingFocus(ItemStack wandstack, World world,	EntityPlayer player, int count)
	{
		//	setBlockReachDistance
	}
	 */
/*    @Override
 //   public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
	{
//		if(isSelected)
			Main.logger.info("onUpdate: YES");
		
	}

//	@SubscribeEvent
/*	@Override
    public void onUpdate(ItemStack itemstack, EntityPlayer player)
	{
		Main.logger.info("onUpdate: WAND");
	}
	/*	public void useItem(PlayerUseItemEvent event)
	{
		//	if (event.item.getItem())
		{
			//event.item.set
		}
	}

	@Override
	public boolean onFocusBlockStartBreak(ItemStack wandstack, BlockPos pos, EntityPlayer player)
	{
		Main.logger.info("onFocusBlockStartBreak: ");
		return false;
	}
*/
}