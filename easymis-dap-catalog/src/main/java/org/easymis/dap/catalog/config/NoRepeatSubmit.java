package org.easymis.dap.catalog.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: NoRepeatSubmit
 * @Description: TODO(防止重复提交标记注解)
 * @author tanyujie
 * @date 2019年6月8日
 *
 */
@Target(ElementType.METHOD) // 作用到方法上
@Retention(RetentionPolicy.RUNTIME) // 运行时有效
public @interface NoRepeatSubmit {
}
