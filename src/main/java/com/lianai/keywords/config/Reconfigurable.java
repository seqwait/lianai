package com.lianai.keywords.config;

/**
 * 可重新配置对象
 * 
 * @author RUIZ
 */
public interface Reconfigurable {

    /**
     * 返回别名
     * 
     * @return
     */
    public String getAlias();

    /**
     * 应用配置
     * 
     * @param config
     */
    public void apply(ConfigWrapper config);

}
