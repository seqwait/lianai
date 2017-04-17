package com.lianai.keywords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.lianai.keywords.config.AbstractReconfigurable;
import com.lianai.keywords.config.ConfigWrapper;

public abstract class AbstractMatcher extends AbstractReconfigurable implements
        Matcher {

    private String filePath;

    private String fileEncoding = "UTF-8";

    private char defaultCover = '*';

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFileEncoding(String fileEncoding) {
        this.fileEncoding = fileEncoding;
    }

    public void setDefaultCover(char defaultCover) {
        this.defaultCover = defaultCover;
    }

    protected Collection<String> loadKeywords() {
        return loadKeywords(filePath, fileEncoding);
    }

    protected Collection<String> loadKeywords(ConfigWrapper config) {
        String filePath = config.getProperty("filePath");
        if (null == filePath) {
            filePath = this.filePath;
        }
        String fileEncoding = config.getProperty("fileEncoding");
        if (null == fileEncoding) {
            fileEncoding = this.fileEncoding;
        }
        return loadKeywords(filePath, fileEncoding);
    }

    protected Collection<String> loadKeywords(String filePath,
            String fileEncoding) {
        Set<String> keywords = new HashSet<String>();
        File file = new File(filePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), fileEncoding));
            String line;
            while (null != (line = reader.readLine())) {
                line.toCharArray();
                keywords.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return keywords;
    }

    @Override
    public String cover(String target) {
        return cover(target, defaultCover);
    }

    public abstract void init();

}
