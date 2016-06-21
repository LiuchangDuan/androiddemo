package com.example.filebrower;

import java.io.File;

/**
 * Created by Administrator on 2016/6/21.
 */
public class EFile {

    private File file;

    public EFile (File f) {
        file = f;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {

        if (getFile() == null) {
            return "";
        }

        return String.format("[%s]%s",
                getFile().isDirectory() ? "DIR" : "File", getFile().getName());
    }

}
