package com.youku.danmaku.engine.danmaku.model.style;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.android.AndroidDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class BaseExtraStyle {
    protected final Context mContext;
    protected final DanmakuContext mDanmakuContext;
    protected final Resources mRes;

    public BaseExtraStyle(Context context, DanmakuContext danmakuContext) {
        this.mContext = context;
        this.mDanmakuContext = danmakuContext;
        this.mRes = context.getResources();
    }

    public abstract void drawDanmaku(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, boolean z, AndroidDisplayer.DisplayConfig displayConfig);

    public int getTopPadding() {
        return 0;
    }

    public boolean isAniImage() {
        return false;
    }

    public boolean isHighLikeDanmaku() {
        return false;
    }

    public abstract void onMeasure(BaseDanmaku baseDanmaku, BaseCacheStuffer.Proxy proxy, boolean z, AndroidDisplayer.DisplayConfig displayConfig);

    public abstract void releaseResource(BaseDanmaku baseDanmaku);

    public abstract void setDrawable(Drawable drawable);
}
