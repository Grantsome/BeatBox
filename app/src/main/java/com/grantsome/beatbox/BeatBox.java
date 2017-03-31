package com.grantsome.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tom on 2017/3/31.
 */

public class BeatBox {

    private static final String TAG = "BeatBox";

    private static final String SOUNDS_FOLDER = "sample_sounds";

    private AssetManager mAssetManager;

    private List<Sound> mSoundList = new ArrayList<>();

    private SoundPool mSoundPool;

    private static final int MAX_SOUND = 5;

    public BeatBox(Context context){
        mAssetManager = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUND, AudioManager.STREAM_MUSIC,0);
        loadSounds();
    }

    private void load(Sound sound) throws Exception{
        Log.i(TAG,"First");
        AssetFileDescriptor assetFileDescriptor = mAssetManager.openFd(sound.getAssetsPath());
        Log.i(TAG,"Second");
        int soundId = mSoundPool.load(assetFileDescriptor,1);
        Log.i(TAG,"Third");
        sound.setInteger(soundId);
    }

    public void play(Sound sound){
        Integer integer = sound.getInteger();
        if(integer==null){
            return;
        }
        mSoundPool.play(integer,1.0f,1.0f,1,0,1.0f);
    }

    public void release(){
        mSoundPool.release();
    }

    private void loadSounds(){

        String[] soundNames;

        try{
            soundNames = mAssetManager.list(SOUNDS_FOLDER);
            Log.i(TAG,"Found " + soundNames.length + " sounds");
        }catch (IOException e){
            Log.e(TAG,"Could not list assets",e);
            return;
        }

        for(String fileName :soundNames){
            try {
                String assetsPath = SOUNDS_FOLDER + "/" + fileName;
                Sound sound = new Sound(assetsPath);
                load(sound);
                mSoundList.add(sound);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<Sound> getSoundList(){
        return mSoundList;
    }



}
