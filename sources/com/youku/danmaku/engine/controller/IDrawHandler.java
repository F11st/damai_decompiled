package com.youku.danmaku.engine.controller;

import android.graphics.Canvas;
import com.youku.danmaku.engine.controller.DrawHandler;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.parser.BaseDanmakuParser;
import com.youku.danmaku.engine.danmaku.renderer.IRenderer;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IDrawHandler {
    public static final int CLEAR_DANMAKUS_ON_SCREEN = 13;
    public static final int HIDE_DANMAKUS = 9;
    public static final long INDEFINITE_TIME = 10000000;
    public static final int NOTIFY_DISP_SIZE_CHANGED = 10;
    public static final int NOTIFY_RENDERING = 11;
    public static final int PAUSE = 7;
    public static final int PREPARE = 5;
    public static final int QUIT = 6;
    public static final int RESUME = 3;
    public static final int SEEK_POS = 4;
    public static final int SHOW_DANMAKUS = 8;
    public static final int START = 1;
    public static final int UPDATE = 2;
    public static final int UPDATE_IN_CURRENT_THREAD = 2;
    public static final int UPDATE_IN_NEW_THREAD = 1;
    public static final int UPDATE_USE_CHOREOGRAPHER = 0;
    public static final int UPDATE_WHEN_PAUSED = 12;

    void addDanmaku(BaseDanmaku baseDanmaku);

    void addDanmaku(List<BaseDanmaku> list);

    void clearDanmakusOnScreen();

    IRenderer.RenderingState draw(Canvas canvas);

    DanmakuContext getConfig();

    long getCurrentTime();

    IDanmakus getCurrentVisibleDanmakus();

    IRenderer.RenderingState getRenderingState();

    boolean hasDanmakusBySecond(long j);

    long hideDanmakus(boolean z);

    void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z);

    boolean isDanmakusVisible();

    boolean isPrepared();

    boolean isResume();

    boolean isStop();

    void notifyDispSizeChanged(int i, int i2);

    void pause();

    void prepare();

    void quit();

    void removeAllDanmakus();

    void removeAllLiveDanmakus();

    void resume();

    boolean screenHasData();

    void seekTo(Long l);

    void seekToNoTime(Long l);

    void setCallback(DrawHandler.Callback callback);

    void setConfig(DanmakuContext danmakuContext);

    void setParser(BaseDanmakuParser baseDanmakuParser);

    void showDanmakus(Long l);
}
