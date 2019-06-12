package org.easymis.dap.catalog.config.log.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志开关量
 * 
 * @ClassName: LogEnable
 * @Description: TODO(日志开关量)
 * @author lenovo-t
 * @date 2019年6月11日
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface LogEnable {
	/**
	 * 如果为true，则类下面的LogEvent启作用，否则忽略
	 * 
	 * @return
	 */
	boolean logEnable() default true;
}
