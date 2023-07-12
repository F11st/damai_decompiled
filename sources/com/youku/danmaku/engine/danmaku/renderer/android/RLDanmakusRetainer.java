package com.youku.danmaku.engine.danmaku.renderer.android;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.Danmakus;
import com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer;
import com.youku.danmaku.engine.danmaku.util.DanmakuUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class RLDanmakusRetainer implements DanmakusRetainer.IDanmakusRetainer {
    private RetainerConsumer mConsumer = new RetainerConsumer();
    private Danmakus mVisibleDanmakus = new Danmakus(1);
    boolean mCancelFixingFlag = false;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    protected class RetainerConsumer extends IDanmakus.Consumer<BaseDanmaku, DanmakusRetainer.RetainerState> {
        IDisplayer disp;
        int lines = 0;
        BaseDanmaku insertItem = null;
        BaseDanmaku firstItem = null;
        BaseDanmaku lastItem = null;
        BaseDanmaku minRightRow = null;
        BaseDanmaku drawItem = null;
        boolean overwriteInsert = false;
        boolean shown = false;
        boolean willHit = false;

        protected RetainerConsumer() {
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
        public void before() {
            this.lines = 0;
            this.minRightRow = null;
            this.lastItem = null;
            this.firstItem = null;
            this.insertItem = null;
            this.willHit = false;
            this.shown = false;
            this.overwriteInsert = false;
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
        public int accept(BaseDanmaku baseDanmaku) {
            if (RLDanmakusRetainer.this.mCancelFixingFlag) {
                return 1;
            }
            this.lines++;
            BaseDanmaku baseDanmaku2 = this.drawItem;
            if (baseDanmaku == baseDanmaku2) {
                this.insertItem = baseDanmaku;
                this.lastItem = null;
                this.shown = true;
                this.willHit = false;
                return 1;
            }
            if (this.firstItem == null) {
                this.firstItem = baseDanmaku;
            }
            if (baseDanmaku2.paintHeight + baseDanmaku.getTop() > this.disp.getHeight()) {
                this.overwriteInsert = true;
                return 1;
            }
            BaseDanmaku baseDanmaku3 = this.minRightRow;
            if (baseDanmaku3 == null) {
                this.minRightRow = baseDanmaku;
            } else if (baseDanmaku3.getRight() >= baseDanmaku.getRight()) {
                this.minRightRow = baseDanmaku;
            }
            IDisplayer iDisplayer = this.disp;
            BaseDanmaku baseDanmaku4 = this.drawItem;
            boolean willHitInDuration = DanmakuUtils.willHitInDuration(iDisplayer, baseDanmaku, baseDanmaku4, baseDanmaku4.getDuration(), this.drawItem.getTimer().currMillisecond);
            this.willHit = willHitInDuration;
            if (!willHitInDuration) {
                this.insertItem = baseDanmaku;
                return 1;
            }
            this.lastItem = baseDanmaku;
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
        public DanmakusRetainer.RetainerState result() {
            DanmakusRetainer.RetainerState retainerState = new DanmakusRetainer.RetainerState();
            retainerState.lines = this.lines;
            retainerState.firstItem = this.firstItem;
            retainerState.insertItem = this.insertItem;
            retainerState.lastItem = this.lastItem;
            retainerState.minRightRow = this.minRightRow;
            retainerState.overwriteInsert = this.overwriteInsert;
            retainerState.shown = this.shown;
            retainerState.willHit = this.willHit;
            return retainerState;
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
    public void clear() {
        this.mCancelFixingFlag = true;
        this.mVisibleDanmakus.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00df  */
    @Override // com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void fix(com.youku.danmaku.engine.danmaku.model.BaseDanmaku r21, com.youku.danmaku.engine.danmaku.model.IDisplayer r22, com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.Verifier r23) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.danmaku.engine.danmaku.renderer.android.RLDanmakusRetainer.fix(com.youku.danmaku.engine.danmaku.model.BaseDanmaku, com.youku.danmaku.engine.danmaku.model.IDisplayer, com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer$Verifier):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getDispTopEdge(BaseDanmaku baseDanmaku, IDisplayer iDisplayer) {
        return 0.0f;
    }

    protected boolean isOutVerticalEdge(boolean z, BaseDanmaku baseDanmaku, IDisplayer iDisplayer, float f, BaseDanmaku baseDanmaku2, BaseDanmaku baseDanmaku3) {
        return f < getDispTopEdge(baseDanmaku, iDisplayer) || (baseDanmaku2 != null && baseDanmaku2.getTop() > getDispTopEdge(baseDanmaku, iDisplayer)) || f + baseDanmaku.paintHeight > ((float) iDisplayer.getHeight());
    }
}
