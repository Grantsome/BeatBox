package com.grantsome.beatbox;

import android.support.v4.app.Fragment;

/**
 * Created by tom on 2017/3/31.
 */

public class BeatBoxActivity extends SuperFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }



}
