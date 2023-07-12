package com.youku.danmaku.engine.controller;

import com.youku.danmaku.engine.danmaku.model.AbsDisplayer;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.GlobalFlagValues;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.parser.BaseDanmakuParser;
import com.youku.danmaku.engine.danmaku.renderer.IRenderer;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IDrawTask {
    public static final int PLAY_STATE_PAUSE = 2;
    public static final int PLAY_STATE_PLAYING = 1;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface TaskListener {
        void onDanmakuAdd(BaseDanmaku baseDanmaku);

        void onDanmakuConfigChanged();

        void onDanmakuShown(BaseDanmaku baseDanmaku);

        void onDanmakusDrawingFinished();

        void ready();
    }

    void addDanmaku(BaseDanmaku baseDanmaku);

    void addDanmakuList(List<BaseDanmaku> list, long j, GlobalFlagValues globalFlagValues, DanmakuTimer danmakuTimer);

    void clearDanmakusOnScreen(long j);

    IRenderer.RenderingState draw(AbsDisplayer absDisplayer);

    IDanmakus getVisibleDanmakusOnTime(long j);

    boolean hasDanmakusBySecond(long j);

    void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z);

    void onPlayStateChanged(int i);

    void prepare();

    void quit();

    void removeAllDanmakus();

    void removeAllLiveDanmakus();

    void requestClear();

    void requestClearRetainer();

    void requestHide();

    void reset(int i);

    boolean screenHasData();

    void seek(long j, int i);

    void setParser(BaseDanmakuParser baseDanmakuParser);

    void start();
}
