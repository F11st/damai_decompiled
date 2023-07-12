package com.youku.danmaku.engine.ui.widget;

import android.graphics.RectF;
import android.view.MotionEvent;
import com.youku.danmaku.engine.controller.IDanmakuView;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDanmakuIterator;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.android.Danmakus;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DanmakuTouchHelper {
    private IDanmakuView danmakuView;
    private RectF mDanmakuBounds = new RectF();

    private DanmakuTouchHelper(IDanmakuView iDanmakuView) {
        this.danmakuView = iDanmakuView;
    }

    private BaseDanmaku fetchLatestOne(IDanmakus iDanmakus) {
        if (iDanmakus.isEmpty()) {
            return null;
        }
        return iDanmakus.last();
    }

    public static synchronized DanmakuTouchHelper instance(IDanmakuView iDanmakuView) {
        DanmakuTouchHelper danmakuTouchHelper;
        synchronized (DanmakuTouchHelper.class) {
            danmakuTouchHelper = new DanmakuTouchHelper(iDanmakuView);
        }
        return danmakuTouchHelper;
    }

    private void performClick(IDanmakus iDanmakus) {
        if (this.danmakuView.getOnDanmakuClickListener() != null) {
            this.danmakuView.getOnDanmakuClickListener().onDanmakuClick(iDanmakus);
        }
    }

    private void performClickWithlatest(BaseDanmaku baseDanmaku) {
        if (this.danmakuView.getOnDanmakuClickListener() != null) {
            this.danmakuView.getOnDanmakuClickListener().onDanmakuClick(baseDanmaku);
        }
    }

    private IDanmakus touchHitDanmaku(float f, float f2) {
        Danmakus danmakus = new Danmakus();
        this.mDanmakuBounds.setEmpty();
        IDanmakus currentVisibleDanmakus = this.danmakuView.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            IDanmakuIterator it = currentVisibleDanmakus.iterator();
            while (it.hasNext()) {
                BaseDanmaku next = it.next();
                if (next != null) {
                    this.mDanmakuBounds.set(next.getLeft(), next.getTop(), next.getRight(), next.getBottom());
                    if (this.mDanmakuBounds.contains(f, f2)) {
                        danmakus.addItem(next);
                    }
                }
            }
        }
        return danmakus;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        IDanmakus iDanmakus = touchHitDanmaku(motionEvent.getX(), motionEvent.getY());
        BaseDanmaku baseDanmaku = null;
        if (iDanmakus != null && !iDanmakus.isEmpty()) {
            performClick(iDanmakus);
            baseDanmaku = fetchLatestOne(iDanmakus);
        }
        if (baseDanmaku != null) {
            performClickWithlatest(baseDanmaku);
            return false;
        }
        return false;
    }
}
