package com.youku.danmaku.engine.controller;

import android.graphics.Rect;
import android.view.View;
import com.youku.danmaku.engine.controller.DrawHandler;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.parser.BaseDanmakuParser;
import com.youku.danmaku.plugin.DanmakuDataEngine;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IDanmakuView {
    public static final int THREAD_TYPE_HIGH_PRIORITY = 2;
    public static final int THREAD_TYPE_LOW_PRIORITY = 3;
    public static final int THREAD_TYPE_MAIN_THREAD = 1;
    public static final int THREAD_TYPE_NORMAL_PRIORITY = 0;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnDanmakuClickListener {
        void onDanmakuClick(BaseDanmaku baseDanmaku);

        void onDanmakuClick(IDanmakus iDanmakus);
    }

    boolean addDanmaku(BaseDanmaku baseDanmaku);

    boolean addDanmakuList(List<BaseDanmaku> list);

    void clearDanmakusOnScreen();

    void enableDanmakuDrawingCache(boolean z);

    Rect getClipRect();

    DanmakuContext getConfig();

    IDanmakus getCurrentClickDanmakus(float f, float f2);

    long getCurrentTime();

    IDanmakus getCurrentVisibleDanmakus();

    DanmakuDataEngine getDanmakuDataEngine();

    int getDrawHandlerVisible();

    int getHeight();

    List<Integer> getMSValueList();

    OnDanmakuClickListener getOnDanmakuClickListener();

    View getView();

    int getWidth();

    boolean hasDanmakusBySecond(long j);

    void hide();

    long hideAndPauseDrawTask();

    void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z);

    void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z, int i);

    boolean isDanmakuDrawingCacheEnabled();

    boolean isDanmakuVisible();

    boolean isDrawing();

    boolean isHardwareAccelerated();

    boolean isPaused();

    boolean isPrepared();

    boolean isResume();

    boolean isShown();

    void pause();

    void prepare(BaseDanmakuParser baseDanmakuParser, DanmakuContext danmakuContext);

    void release();

    void removeAllDanmakus();

    void removeAllLiveDanmakus();

    void resume();

    boolean screenHasData();

    void seekTo(Long l);

    void seekToNoTime(Long l);

    void setCallback(DrawHandler.Callback callback);

    void setClipRect(Rect rect);

    void setDrawingThreadType(int i);

    void setOnDanmakuClickListener(OnDanmakuClickListener onDanmakuClickListener);

    void setVisibility(int i);

    void show();

    void showAndResumeDrawTask(Long l);

    void showFPS(boolean z);

    void start();

    void start(long j);

    void stop();

    void toggle();
}
