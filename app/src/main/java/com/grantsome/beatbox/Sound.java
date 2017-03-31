package com.grantsome.beatbox;

/**
 * Created by tom on 2017/3/31.
 */

public class Sound {

    private String mAssetsPath;

    private String mName;

    private Integer mInteger;

    public Sound(String assetsPath){
        mAssetsPath = assetsPath;
        String[] components = assetsPath.split("/");
        String fileName = components[components.length-1];
        mName = fileName.replace(".wav","");
    }

    public String getAssetsPath() {
        return mAssetsPath;
    }

    public String getName() {
        return mName;
    }

    public Integer getInteger() {
        return mInteger;
    }

    public void setInteger(Integer integer) {
        mInteger = integer;
    }

}
