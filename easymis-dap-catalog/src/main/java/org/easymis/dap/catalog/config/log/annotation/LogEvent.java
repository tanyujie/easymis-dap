package org.easymis.dap.catalog.config.log.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, ElementType.TYPE})
public @interface LogEvent {
    ModuleType module() default ModuleType.DEFAULT; // 日志所属的模块
    EventType event() default EventType.DEFAULT; // 日志事件类型
    String desc() default  ""; // 描述信息
}
