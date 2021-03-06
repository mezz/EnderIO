package crazypants.enderio.machine.obelisk.inhibitor;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import net.minecraft.inventory.Container;
import crazypants.enderio.machine.gui.GuiPoweredMachineBase;
import crazypants.render.ColorUtil;
import crazypants.render.RenderUtil;
import crazypants.util.Lang;

public class GuiInhibitorObelisk extends GuiPoweredMachineBase<TileInhibitorObelisk> {

  public GuiInhibitorObelisk(TileInhibitorObelisk machine, Container container) {
    super(machine, container);
  }

  @Override
  protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    RenderUtil.bindTexture("enderio:textures/gui/inhibitor.png");
    int sx = (width - xSize) / 2;
    int sy = (height - ySize) / 2;

    drawTexturedModalRect(sx, sy, 0, 0, xSize, ySize);

    super.drawGuiContainerBackgroundLayer(par1, par2, par3);

    int range = (int) getTileEntity().getRange();
    drawCenteredString(fontRendererObj, Lang.localize("gui.spawnGurad.range") + " " + range, getGuiLeft() + sx / 2 + 9, getGuiTop() + 68,
        ColorUtil.getRGB(Color.white));
  }
}
