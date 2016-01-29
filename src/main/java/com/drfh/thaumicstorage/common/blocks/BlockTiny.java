package com.drfh.thaumicstorage.common.blocks;

import java.util.Random;

import com.drfh.thaumicstorage.Main;
import com.drfh.thaumicstorage.common.tileEntity.TileEntityTiny;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;


public class BlockTiny extends BlockContainer
{

	public BlockTiny(Material material)
	{
		super(material);
		setUnlocalizedName("tiny_block");
		setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(2.0F);
		this.setResistance(6.0F);
		this.translucent=false;
		this.setLightLevel(1.0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(soundTypeMetal);
	}

/*	public BlockTiny()
	{
		super(Material.wood);
		setHardness(2.0F);
		setResistance(5.0F);
		//	setBlockName("blockTiny");
		setCreativeTab(CreativeTabs.tabDecorations);
	}
*/

	@Override
	public boolean isOpaqueCube()
	{
		return true;
	}
	
	@Override
	public boolean isFullCube()
	{
		return true;
	}
	
	public TileEntity createNewTileEntity(World world, int meta)
	{
		TileEntityTiny		tile=new TileEntityTiny();
		tile.setWorldObj(world);
		return tile;//super.createNewTileEntity(world,meta);
	}

    @Override
	public int getRenderType()
    {
        return 3;
    }
    
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		TileEntity tileEntity = world.getTileEntity(pos);
		if (tileEntity == null || player.isSneaking())
		{
			return false;
		}
		//code to open gui explained later
		player.openGui(Main.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		dropItems(world, pos.getX(), pos.getY(), pos.getZ());
		super.breakBlock(world, pos,state);
	}

	private void dropItems(World world, int x, int y, int z)
	{
		Random rand = new Random();

		TileEntity tileEntity = world.getTileEntity(new BlockPos(x,y,z));
		if (!(tileEntity instanceof IInventory))
		{
			return;
		}
		IInventory inventory = (IInventory) tileEntity;

		for (int i = 0; i < inventory.getSizeInventory(); i++)
		{
			ItemStack item = inventory.getStackInSlot(i);

			if (item != null && item.stackSize > 0)
			{
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;

				EntityItem entityItem = new EntityItem(world,x + rx, y + ry, z + rz,new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

				if (item.hasTagCompound())
				{
					entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
				}

				float factor = 0.05F;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
				entityItem.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entityItem);
				item.stackSize = 0;
			}
		}
	}
}
