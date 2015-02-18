package crazypants.enderio.config;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import crazypants.enderio.EnderIO;
import crazypants.util.Lang;

@SuppressWarnings({ "rawtypes" })
public class GuiConfigFactoryEIO extends GuiConfig {

  public GuiConfigFactoryEIO(GuiScreen parentScreen)
  {
    super(parentScreen, getConfigElements(parentScreen), EnderIO.MODID, false, false, Lang.localize("config.title", true));
  }

  private static List<IConfigElement> getConfigElements(GuiScreen parent)
  {
    List<IConfigElement> list = new ArrayList<IConfigElement>();
    String prefix = Lang.prefix + "config.";
    
    for (String section : Configs.getProcessor().sections()) {
      list.add(new ConfigElement<ConfigCategory>(Configs.getProcessor().getCategory(section.toLowerCase()).setLanguageKey(prefix + section.toLowerCase().replace(" ", "_"))));
    }
    
    return list;
  }
}
