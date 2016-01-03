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
	private int		fuelMaxLevel;
	private int		fuelLeft;
	private int		fuelBurnTime;
	
	public EnergyItem()
	{
		super();
		fuelMaxLevel=0;
		fuelLeft=0;
		fuelBurnTime=0;
	//	Main.logger.info("new EnergyItem()");
	}

	public void setMaxFuelLevel(int level)
	{
		fuelMaxLevel=level;
		this.setMaxDamage(level);
	}

	public int getMaxFuelLevel()
	{
		return fuelMaxLevel;
	}

	public void setFuelLeft(int level)
	{
		fuelLeft=level;
		//	this.setDamage(itemStack,level);
	}

	public int getFuelLeft()
	{
		return fuelLeft;
	}

	public void setBurnTime(int level)
	{
		fuelBurnTime=level;
	}

	public int getBurnTime()
	{
		//	Main.logger.info("getBurnTime");
		/*	if(fuelLeft<0)
			return 0;
		if(fuelLeft<10)
			return fuelLeft;
		 */	return fuelBurnTime;
	}

	public int addFuel(int add)
	{
		if(fuelLeft+add>fuelMaxLevel)
		{
			add=fuelMaxLevel-fuelLeft;
		}
		fuelLeft+=add;
		return add;
	}

	public int removeFuel(int dec)
	{
		if(fuelLeft<dec)
		{
		//	Main.logger.info("removeFuel: "+dec+" is more than fuelLeft: "+fuelLeft);
			//	System.out.printf("removeFuel: %d is more than fuelLeft: %d\n",dec,fuelLeft);
			dec=fuelLeft;
		}
		fuelLeft-=dec;
		return dec;
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
		//	Main.logger.info("getContainerItem:(NBT==NULL)");
			nbt=new NBTTagCompound();
			nbt.setInteger("Damage",0);
		}
		Main.logger.info("getContainerItem:(NBT) "+nbt);
		dam=nbt.getInteger("Damage")+this.getBurnTime();
		
		
		copiedStack.setItemDamage(dam);
		copiedStack.stackSize=1;
		
		Main.logger.info("getContainerItem:(original) "+((EnergyItem)itemStack.getItem()).getFuelLeft());
		Main.logger.info("getContainerItem:(dam)  "+dam+"  (left)  "+e_item.getFuelLeft());

		nbt.setInteger("Damage",dam);
		copiedStack.setTagCompound(nbt);

		return copiedStack;
	}

	@Override
    public Item setMaxDamage(int maxDamageIn)
    {
		return super.setMaxDamage(maxDamageIn);
    }
	
	@Override
	public int getMaxDamage()
	{
		//	Main.logger.info("getMaxDamage: "+fuelMaxLevel);
		if(fuelMaxLevel>0)
			return fuelMaxLevel;
		return 0;
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
		Main.logger.info("onCreated:(NBT) "+nbt);
		
		super.onCreated(stack, worldIn, playerIn);
	}

	/*	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int metadata, boolean bool)
	{
		if(stack.getTagCompound() == null)
		{
			Main.logger.info("onUpdate: "+stack.getDisplayName()+"  "+((EnergyItem)stack.getItem()).getFuelLeft());
		//	stack.setTagCompound(new NBTTagCompound());
		}
	}
	 */
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		Main.logger.info("onItemUse: "+stack.getDisplayName());
		return false;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		Main.logger.info("getMaxItemUseDuration: "+stack.getDisplayName());
		return 0;
	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		Main.logger.info("onItemUseFirst: "+stack.getDisplayName()+"  "+((EnergyItem)stack.getItem()).getFuelLeft());
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, EntityPlayer play, List tooltip, boolean par4)
	{
		NBTTagCompound	nbt;
		int				dam=0;
		
		if((nbt=item.getTagCompound())==null)
		{
		//	Main.logger.info("addInformation:(NBT==NULL)");
			nbt=new NBTTagCompound();
			nbt.setInteger("Damage",0);
		}
	//	Main.logger.info("addInformation:(NBT) "+nbt);
		dam=nbt.getInteger("Damage")+this.getBurnTime();
		super.addInformation(item,play,tooltip,par4);
		tooltip.add("Fuel Max: "+this.getMaxDamage()+"  Fuel Left: "+dam);
	}
}
