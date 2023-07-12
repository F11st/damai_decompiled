package com.youku.danmaku.engine.danmaku.model;

import android.os.Looper;
import com.youku.danmaku.engine.danmaku.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DanmakuRenderModel {
    public final List<BaseDanmaku> mHighLevelList = new ArrayList();
    public final List<BaseDanmaku> mNormalLevelList = new ArrayList();
    public final List<BaseDanmaku> mScreenDanmakuList = new ArrayList();
    public final List<BaseDanmaku> mTempList = new ArrayList();
    public long mCurrentMillisecond = 0;
    public boolean mClearRetainerFlag = false;

    public void clear(int i) {
        if (Log.isDebug() && Looper.getMainLooper().getThread() != Thread.currentThread()) {
            Log.d("ModelClear", "thread name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId());
            Log.d("ModelClear", android.util.Log.getStackTraceString(new Throwable()));
        }
        if (i == 0) {
            synchronized (this.mScreenDanmakuList) {
                this.mScreenDanmakuList.clear();
            }
        }
        synchronized (this.mHighLevelList) {
            this.mHighLevelList.clear();
        }
        synchronized (this.mNormalLevelList) {
            this.mNormalLevelList.clear();
        }
    }

    public boolean hasDanmakuData() {
        return (this.mNormalLevelList.isEmpty() && this.mHighLevelList.isEmpty()) ? false : true;
    }

    public boolean hasDanmakuToDraw() {
        return (this.mScreenDanmakuList.isEmpty() && this.mNormalLevelList.isEmpty() && this.mHighLevelList.isEmpty()) ? false : true;
    }

    public boolean hasDanmakusBySecond() {
        synchronized (this.mNormalLevelList) {
            if (!this.mNormalLevelList.isEmpty()) {
                for (BaseDanmaku baseDanmaku : this.mNormalLevelList) {
                    if (baseDanmaku != null && !baseDanmaku.isFiltered()) {
                        return true;
                    }
                }
            }
            synchronized (this.mHighLevelList) {
                if (!this.mHighLevelList.isEmpty()) {
                    for (BaseDanmaku baseDanmaku2 : this.mHighLevelList) {
                        if (baseDanmaku2 != null && !baseDanmaku2.isFiltered()) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
    }

    public boolean hasNormalHighLevelDanmaku() {
        if (this.mHighLevelList.size() <= 0) {
            return false;
        }
        for (BaseDanmaku baseDanmaku : this.mHighLevelList) {
            if (baseDanmaku != null && baseDanmaku.duration != null && baseDanmaku.getType() == 1 && baseDanmaku.priority >= 1) {
                return true;
            }
        }
        return false;
    }

    public boolean screenHasData() {
        if (this.mScreenDanmakuList.isEmpty()) {
            return false;
        }
        synchronized (this.mScreenDanmakuList) {
            for (BaseDanmaku baseDanmaku : this.mScreenDanmakuList) {
                if (!baseDanmaku.isFiltered() && baseDanmaku.isShown()) {
                    return true;
                }
            }
            return false;
        }
    }
}
