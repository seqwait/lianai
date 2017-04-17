package com.lianai.keywords.config;

/**
 * 可重新配置对象持有者
 * 
 * @author RUIZ
 */
public interface ReconfigurableHolder {

    /**
     * 应用配置
     * 
     * @param alias
     *            可重新配置对象别名
     * @param config
     */
    public void apply(String alias, ConfigWrapper config);

    /**
     * 注册可配置对象
     * 
     * @param reconfigurable
     */
    public void register(Reconfigurable reconfigurable);

}
