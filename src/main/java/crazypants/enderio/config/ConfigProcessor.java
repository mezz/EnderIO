package crazypants.enderio.config;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class ConfigProcessor {

  private Class<?> configs;

  Map<String, Object> configValues = Maps.newHashMap();

  private Configuration configFile;

  private Set<String> sections = Sets.newHashSet();

  public ConfigProcessor(Class<?> configs, File configFile) {
    this.configs = configs;
    this.configFile = new Configuration(configFile);
  }

  public void process(boolean load) {
    if(load) {
      configFile.load();
    }

    try {
      for (Field f : configs.getDeclaredFields()) {
        processField(f);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    if(configFile.hasChanged()) {
      configFile.save();
    }
  }

  private void processField(Field f) throws Exception {
    Config cfg = f.getAnnotation(Config.class);
    if(cfg == null) {
      return;
    }
    Object value = f.get(null);
    Object newValue = getConfigValue(cfg, f, value);

    configValues.put(f.getName(), newValue);
    sections.add(cfg.section());
  }

  private Object getConfigValue(Config cfg, Field f, Object defVal) {
    Property prop = null;
    Object ret = null;
    if(defVal instanceof Boolean) {
      prop = configFile.get(cfg.section(), f.getName(), (Boolean) defVal);
      ret = prop.getBoolean();
    } else if(defVal instanceof Integer) {
      prop = configFile.get(cfg.section(), f.getName(), (Integer) defVal);
      ret = prop.getInt();
    } else if(defVal instanceof Double) {
      prop = configFile.get(cfg.section(), f.getName(), (Double) defVal);
      ret = prop.getDouble();
    } else if(defVal instanceof String) {
      prop = configFile.get(cfg.section(), f.getName(), (String) defVal);
      ret = prop.getString();
    } else if(defVal instanceof String[]) {
      prop = configFile.get(cfg.section(), f.getName(), (String[]) defVal);
      ret = prop.getStringList();
    }
    if(cfg.min() > Integer.MIN_VALUE) {
      prop.setMinValue((defVal instanceof Integer) ? (int) cfg.min() : cfg.min());
    }
    if(cfg.max() < Integer.MAX_VALUE) {
      prop.setMinValue((defVal instanceof Integer) ? (int) cfg.max() : cfg.max());
    }
    return ret;
  }

  public ImmutableSet<String> sections() {
    return ImmutableSet.copyOf(sections);
  }

  public ConfigCategory getCategory(String category) {
    return configFile.getCategory(category);
  }

  public void syncTo(Map<String, Object> values) {
    this.configValues = values;
    for (String s : configValues.keySet()) {
      try {
        Field f = configs.getDeclaredField(s);
        Object newVal = configValues.get(s);
        if(!f.get(null).equals(newVal)) {
          f.set(null, newVal);
        }
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
}
