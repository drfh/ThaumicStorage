package com.drfh.thaumicstorage.common.items;

import java.util.List;

import com.drfh.thaumicstorage.Main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EnergyItem extends Item
{
	int		fuelBurnTime=0;
	int		fuelLevel=0;

	public EnergyItem()
	{
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		fuelBurnTime=0;
	}

	public void setBurnTime(int level)
	{
		fuelBurnTime=level;
	}

	public int getBurnTime()
	{
		return fuelBurnTime;
	}

	public void setFuelLevel(int level)
	{
		int		max=this.getMaxDamage();
	//	NBTTagCompound	nbt=new NBTTagCompound();
		
		if(level>max)
			fuelLevel=max;
		else
			fuelLevel=level;
		
	//	nbt.setInteger("Damage",fuelLevel);
	}

	public int getFuelDamage()
	{
		return fuelLevel;
	}
	
	public boolean canRecharge()
	{
		return false;
	}
	
	public int rechargeFuel(ItemStack stack,int ammount)
	{
		NBTTagCompound	nbt;
		int		recharged=0;
		int		dam=0;
		
		if((nbt=stack.getTagCompound())==null)
		{
			nbt=new NBTTagCompound();
			nbt.setInteger("Damage",0);
		}
		dam=nbt.getInteger("Damage");
		fuelLevel=this.getMaxDamage()-dam;
		
		if(fuelLevel+ammount<this.getMaxDamage())
			recharged=ammount;
		else
			recharged=this.getMaxDamage()-fuelLevel;
		fuelLevel+=recharged;
		
		dam=this.getMaxDamage()-fuelLevel;
		nbt.setInteger("Damage",dam);
		stack.setItemDamage(dam);
		return recharged;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack)
	{
		ItemStack		copiedStack=itemStack.copy();
		EnergyItem		e_item=(EnergyItem)copiedStack.getItem();
		int				dam=0;
		NBTTagCompound	nbt;

		if((nbt=itemStack.getTagCompound())==null)
		{
			nbt=new NBTTagCompound();
			nbt.setInteger("Damage",0);
		}
		dam=nbt.getInteger("Damage")+this.getBurnTime();

		copiedStack.setItemDamage(dam);
		copiedStack.stackSize=1;
		copiedStack.setStackDisplayName("setStackDisplayName");

		nbt.setInteger("Damage",dam);
		copiedStack.setTagCompound(nbt);

		Main.logger.info("getContainerItem:");
		return copiedStack;
	}

	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		NBTTagCompound	nbt;

		if((nbt=stack.getTagCompound())==null)
		{
			Main.logger.info("onCreated:(NBT==NULL)");
			nbt=new NBTTagCompound();
			nbt.setInteger("Damage",0);
		}
/*		else
		{
			nbt.setInteger("Damage",stack.getMaxDamage()-fuelLevel);
		}
*/		super.onCreated(stack, worldIn, playerIn);
//		this.onUpdate(stack, worldIn, playerIn, itemSlot, isSelected);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, EntityPlayer play, List tooltip, boolean par4)
	{
		NBTTagCompound	nbt;
		int				dam=0;
		int				max=0;
		
		if((nbt=item.getTagCompound())==null)
		{
			nbt=new NBTTagCompound();
			nbt.setInteger("Damage",0);
		}
		dam=nbt.getInteger("Damage");
		max=this.getMaxDamage();
		
		super.addInformation(item,play,tooltip,par4);
		
		int		percent=100-(int)((dam*100.0f)/max);
		
		tooltip.add("Fuel Left: "+(max-dam)+"  "+percent+"%");
	}
}
