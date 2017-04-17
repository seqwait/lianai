package com.lianai.keywords.config;

public class ConfigException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -3405082437987686623L;

    public ConfigException() {
        super();
    }

    public ConfigException(String message) {
        super(message);
    }

    public ConfigException(Throwable cause) {
        super(cause);
    }

    public ConfigException(String message, Throwable cause) {
        super(message, cause);
    }

}
