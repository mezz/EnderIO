package crazypants.enderio.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.minecraftforge.common.config.Configuration;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Config {

  String section() default Configuration.CATEGORY_GENERAL;

  String comment() default "";

  double min() default Integer.MIN_VALUE;

  double max() default Integer.MAX_VALUE;
}
