package com.youku.alixplayer.model;

import android.util.Log;
import androidx.annotation.Keep;
import com.youku.alixplayer.util.SystemSoLoader;

/* compiled from: Taobao */
@Keep
/* loaded from: classes.dex */
public class RenderExt {
    private static final String TAG = "RenderExt";
    private int mBufferLength;
    private int mHeight;
    private long mPts;
    private long mSlice_start_time;
    private long mTbn;
    private int mWidth;

    static {
        SystemSoLoader.load("alixplayer");
    }

    public int getBufferLength() {
        return this.mBufferLength;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public long getPts() {
        return this.mPts;
    }

    public long getSlice_start_timen() {
        return this.mSlice_start_time;
    }

    public long getTbn() {
        return this.mTbn;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setBufferLength(int i) {
        this.mBufferLength = i;
        Log.d(TAG, "setBufferLength = " + i);
    }

    public void setHeight(int i) {
        this.mHeight = i;
        Log.d(TAG, "setHeight = " + i);
    }

    public void setPts(long j) {
        this.mPts = j;
        Log.d(TAG, "setPts = " + j);
    }

    public void setSlice_start_time(long j) {
        this.mSlice_start_time = j;
        Log.d(TAG, "setSlice_start_time = " + j);
    }

    public void setTbn(long j) {
        this.mTbn = j;
        Log.d(TAG, "setTbn = " + j);
    }

    public void setWidth(int i) {
        this.mWidth = i;
        Log.d(TAG, "setWidth = " + i);
    }
}
