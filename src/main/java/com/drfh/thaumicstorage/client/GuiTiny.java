package com.drfh.thaumicstorage.client;

import org.lwjgl.opengl.GL11;

import com.drfh.thaumicstorage.Main;
import com.drfh.thaumicstorage.Reference;
import com.drfh.thaumicstorage.common.tileEntity.TileEntityTiny;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiTiny extends GuiContainer
{
	public GuiTiny(InventoryPlayer player,TileEntityTiny tile)
	{
		//the container is instanciated and passed to the superclass for handling
		super(new ContainerTiny(player, tile));
		
		Main.logger.info("GuiTiny: "+tile);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2)
	{
		//draw text and stuff here
		//the parameters for drawString are: string, x, y, color
		fontRendererObj.drawString("Tiny", 8, 6, 4210752);
		//draws "Inventory" or your regional equivalent
		fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, 130, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,int par3)
	{
		ResourceLocation	resource=new ResourceLocation(Reference.MOD_ID,"textures/gui/container/generic_54.png");
		//draw your Gui here, only thing you need to change is the path
	//	ITextureObject	texture = mc.renderEngine.getTexture(resource);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(resource);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

}
