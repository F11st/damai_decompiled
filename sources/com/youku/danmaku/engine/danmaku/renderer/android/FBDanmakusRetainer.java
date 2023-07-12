package com.youku.danmaku.engine.danmaku.renderer.android;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDanmakuIterator;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.Danmakus;
import com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer;
import com.youku.danmaku.engine.danmaku.util.DanmakuUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class FBDanmakusRetainer extends FTDanmakusRetainer {
    private Danmakus mVisibleDanmakus = new Danmakus(2);

    @Override // com.youku.danmaku.engine.danmaku.renderer.android.RLDanmakusRetainer, com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
    public void clear() {
        this.mCancelFixingFlag = true;
        this.mVisibleDanmakus.clear();
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.android.RLDanmakusRetainer, com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
    public void fix(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, DanmakusRetainer.Verifier verifier) {
        boolean z;
        int i;
        BaseDanmaku baseDanmaku2;
        BaseDanmaku baseDanmaku3;
        boolean z2;
        BaseDanmaku baseDanmaku4;
        if (baseDanmaku.isOutside()) {
            return;
        }
        boolean isShown = baseDanmaku.isShown();
        float top = baseDanmaku.getTop();
        boolean z3 = true;
        int i2 = 0;
        boolean z4 = (baseDanmaku.isShown() || this.mVisibleDanmakus.isEmpty()) ? false : true;
        if (top < getDispTopEdge(baseDanmaku, iDisplayer)) {
            top = iDisplayer.getHeight() - baseDanmaku.paintHeight;
        }
        BaseDanmaku baseDanmaku5 = null;
        if (isShown) {
            z3 = z4;
            z = false;
        } else {
            this.mCancelFixingFlag = false;
            IDanmakuIterator it = this.mVisibleDanmakus.iterator();
            float f = top;
            BaseDanmaku baseDanmaku6 = null;
            int i3 = 0;
            while (!this.mCancelFixingFlag && it.hasNext()) {
                i = i3 + 1;
                baseDanmaku2 = it.next();
                if (baseDanmaku2 == baseDanmaku) {
                    baseDanmaku2 = baseDanmaku6;
                    baseDanmaku3 = null;
                    z2 = false;
                    break;
                }
                if (baseDanmaku6 != null) {
                    baseDanmaku4 = baseDanmaku6;
                } else if (baseDanmaku2.getBottom() != iDisplayer.getHeight()) {
                    break;
                } else {
                    baseDanmaku4 = baseDanmaku2;
                }
                if (f < getDispTopEdge(baseDanmaku, iDisplayer)) {
                    baseDanmaku3 = null;
                    baseDanmaku2 = baseDanmaku4;
                    break;
                }
                baseDanmaku3 = baseDanmaku2;
                z4 = DanmakuUtils.willHitInDuration(iDisplayer, baseDanmaku2, baseDanmaku, baseDanmaku.getDuration(), baseDanmaku.getTimer().currMillisecond);
                if (!z4) {
                    z2 = z4;
                    baseDanmaku2 = baseDanmaku4;
                    break;
                }
                f = baseDanmaku3.getTop() - baseDanmaku.paintHeight;
                i3 = i;
                baseDanmaku6 = baseDanmaku4;
            }
            i = i3;
            baseDanmaku2 = baseDanmaku6;
            baseDanmaku3 = null;
            z2 = z4;
            boolean isOutVerticalEdge = isOutVerticalEdge(false, baseDanmaku, iDisplayer, f, baseDanmaku2, null);
            if (isOutVerticalEdge) {
                i2 = i;
                baseDanmaku5 = baseDanmaku3;
                z = isOutVerticalEdge;
                top = iDisplayer.getHeight() - baseDanmaku.paintHeight;
            } else if (f >= getDispTopEdge(baseDanmaku, iDisplayer)) {
                z = isOutVerticalEdge;
                top = f;
                i2 = i;
                baseDanmaku5 = baseDanmaku3;
                z3 = false;
            } else {
                z = isOutVerticalEdge;
                z3 = z2;
                top = f;
                i2 = i;
                baseDanmaku5 = baseDanmaku3;
            }
        }
        if (verifier == null || !verifier.skipLayout(baseDanmaku, top, i2, z3)) {
            if (z) {
                clear();
            }
            baseDanmaku.layout(iDisplayer, baseDanmaku.getLeft(), top);
            if (isShown) {
                return;
            }
            this.mVisibleDanmakus.removeItem(baseDanmaku5);
            this.mVisibleDanmakus.addItem(baseDanmaku);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.android.FTDanmakusRetainer, com.youku.danmaku.engine.danmaku.renderer.android.RLDanmakusRetainer
    protected boolean isOutVerticalEdge(boolean z, BaseDanmaku baseDanmaku, IDisplayer iDisplayer, float f, BaseDanmaku baseDanmaku2, BaseDanmaku baseDanmaku3) {
        return f < getDispTopEdge(baseDanmaku, iDisplayer) || !(baseDanmaku2 == null || baseDanmaku2.getBottom() == ((float) iDisplayer.getHeight()));
    }
}
