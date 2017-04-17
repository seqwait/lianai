package com.lianai.keywords.config;

/**
 * 配置持有者
 * 
 * @author RUIZ
 */
public interface ConfigWrapper {

    /**
     * 获取配置
     * 
     * @param key
     * @return
     */
    public String getProperty(String key);

    /**
     * 获取长整形配置
     * 
     * @param key
     * @param defaultValue
     * @return
     */
    public long getLong(String key, long defaultValue);

    /**
     * 获取整形配置
     * 
     * @param key
     * @param defaultValue
     * @return
     */
    public int getInt(String key, int defaultValue);

    /**
     * 获取字节配置
     * 
     * @param key
     * @param defaultValue
     * @return
     */
    public byte getByte(String key, byte defaultValue);

    /**
     * 获取布尔值配置
     * 
     * @param key
     * @param defaultValue
     * @return
     */
    public boolean getBoolean(String key, boolean defaultValue);

    /**
     * 刷新配置
     * 
     * @throws ConfigException
     */
    public void refresh() throws ConfigException;

}
