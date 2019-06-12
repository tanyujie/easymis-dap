package org.easymis.dap.catalog.config.log.annotation;

/**
 * 事情类型
 * 
 * @ClassName: EventType
 * @Description: TODO(事情类型)
 * @author lenovo-t
 * @date 2019年6月11日
 *
 */
public enum EventType {
    DEFAULT("1", "default"), ADD("2", "add"), UPDATE("3", "update"), DELETE_SINGLE("4", "delete-single"),
    LOGIN("10","login"),LOGIN_OUT("11","login_out");

    private EventType(String index, String name){
        this.name = name;
        this.event = index;
    }
    private String event;
    private String name;
    public String getEvent(){
        return this.event;
    }

    public String getName() {
        return name;
    }
}
