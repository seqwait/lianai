package com.lianai.keywords.config;

public abstract class AbstractReconfigurable implements Reconfigurable {

    private String alias;

    private ReconfigurableHolder reconfigurableHolder;

    @Override
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
        if (null != reconfigurableHolder) {
            reconfigurableHolder.register(this);
        }
    }

    public void setReconfigurableHolder(
            ReconfigurableHolder reconfigurableHolder) {
        this.reconfigurableHolder = reconfigurableHolder;
        if (null != alias) {
            reconfigurableHolder.register(this);
        }
    }

}
