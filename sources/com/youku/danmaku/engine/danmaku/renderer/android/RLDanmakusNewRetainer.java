package com.youku.danmaku.engine.danmaku.renderer.android;

import android.util.SparseArray;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuEngineContext;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku;
import com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer;
import com.youku.danmaku.engine.danmaku.util.DanmakuUtils;
import com.youku.danmaku.engine.danmaku.util.Log;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;
import java.util.Arrays;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class RLDanmakusNewRetainer implements DanmakusRetainer.IDanmakusRetainer {
    private IDanmakuSettingPlugin mDanmakuSettingPlugin;
    private boolean mCancelFixingFlag = false;
    private final SparseArray<BaseDanmaku> mVisibleDanmakus = new SparseArray<>();
    private float mVideoSpeed = 1.0f;
    private float mSpeedFactor = 1.0f;
    private final SparseArray<Float> mLineSpeedArray = new SparseArray<>();
    private Random mSpeedFactorRandom = new Random();

    /* JADX INFO: Access modifiers changed from: package-private */
    public RLDanmakusNewRetainer(IDanmakuSettingPlugin iDanmakuSettingPlugin) {
        this.mDanmakuSettingPlugin = iDanmakuSettingPlugin;
    }

    private int assignRowForDanmakuInfo(BaseDanmaku baseDanmaku) {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null) {
            return iDanmakuSettingPlugin.assignRowForDanmakuInfo(baseDanmaku);
        }
        return -1;
    }

    private boolean checkFix(IDisplayer iDisplayer, BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2, DanmakusRetainer.FixResult fixResult, int i, float f) {
        if (baseDanmaku == null) {
            setResult(fixResult, i, f * i);
            return true;
        }
        boolean willHitInUniformSpeed = DanmakuUtils.willHitInUniformSpeed(iDisplayer, baseDanmaku, baseDanmaku2, baseDanmaku2.getTimer().currMillisecond);
        fixResult.mWillHit = willHitInUniformSpeed;
        if (willHitInUniformSpeed) {
            return false;
        }
        setResult(fixResult, i, f * i);
        return true;
    }

    private DanmakusRetainer.FixResult fixDrawItem(BaseDanmaku baseDanmaku, IDisplayer iDisplayer) {
        String str;
        DanmakusRetainer.FixResult fixResult = new DanmakusRetainer.FixResult();
        if (this.mCancelFixingFlag) {
            return fixResult;
        }
        float lineHeight = getLineHeight() + getLineSpace();
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        int lineCount = iDanmakuSettingPlugin != null ? iDanmakuSettingPlugin.getLineCount() : getLineCount();
        boolean z = false;
        int i = 0;
        while (true) {
            String str2 = "RLDanmakusRetainer";
            boolean z2 = true;
            if (i < this.mVisibleDanmakus.size()) {
                if (baseDanmaku == this.mVisibleDanmakus.get(i)) {
                    fixResult.mLine = i;
                    fixResult.mTopPos = i * lineHeight;
                    if (i < lineCount) {
                        fixResult.mWillHit = false;
                        fixResult.shown = true;
                        fixResult.mIsOutOfVerticalEdge = false;
                    } else {
                        fixResult.mWillHit = true;
                        fixResult.shown = false;
                        fixResult.mIsOutOfVerticalEdge = true;
                    }
                    if (Log.isDebug()) {
                        Log.d("RLDanmakusRetainer", "mVisibleDanmakus has danmaku, maxLine=" + lineCount + ", line=" + i + ", text=" + ((Object) baseDanmaku.text) + ", top=" + fixResult.mTopPos + ", drawItem.top=" + baseDanmaku.getTop() + ", WillHit=" + fixResult.mWillHit + ", shown=" + fixResult.shown + ", IsOutOfVerticalEdge=" + fixResult.mIsOutOfVerticalEdge);
                    }
                    return fixResult;
                }
                i++;
            } else {
                BaseDanmaku baseDanmaku2 = null;
                if (baseDanmaku.mAssignRow) {
                    int assignRowForDanmakuInfo = assignRowForDanmakuInfo(baseDanmaku);
                    if (assignRowForDanmakuInfo >= 0 && assignRowForDanmakuInfo < lineCount) {
                        BaseDanmaku baseDanmaku3 = this.mVisibleDanmakus.get(assignRowForDanmakuInfo, null);
                        if (baseDanmaku3 == baseDanmaku) {
                            fixResult.mLine = assignRowForDanmakuInfo;
                            fixResult.mIsOutOfVerticalEdge = false;
                            fixResult.mTopPos = assignRowForDanmakuInfo * lineHeight;
                            fixResult.mWillHit = false;
                            fixResult.shown = true;
                            return fixResult;
                        }
                        z = checkFix(iDisplayer, baseDanmaku3, baseDanmaku, fixResult, assignRowForDanmakuInfo, lineHeight);
                    } else {
                        baseDanmaku.isFilter = true;
                    }
                } else {
                    if (Log.isDebug()) {
                        Log.d("RLDanmakusRetainer", "fixDrawItem begin, maxLine=" + lineCount);
                    }
                    boolean z3 = false;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= lineCount) {
                            break;
                        }
                        BaseDanmaku baseDanmaku4 = this.mVisibleDanmakus.get(i2, baseDanmaku2);
                        if (baseDanmaku4 == baseDanmaku) {
                            fixResult.mLine = i2;
                            fixResult.mIsOutOfVerticalEdge = z;
                            fixResult.mTopPos = i2 * lineHeight;
                            fixResult.mWillHit = z;
                            fixResult.shown = z2;
                            break;
                        }
                        int i3 = i2;
                        String str3 = str2;
                        z3 = checkFix(iDisplayer, baseDanmaku4, baseDanmaku, fixResult, i3, lineHeight);
                        if (!z3) {
                            i2 = i3 + 1;
                            str2 = str3;
                            baseDanmaku2 = null;
                            z2 = true;
                            z = false;
                        } else if (Log.isDebug()) {
                            if (baseDanmaku4 != null) {
                                float[] rectAtTime = baseDanmaku4.getRectAtTime(iDisplayer, baseDanmaku.getTimer().currMillisecond);
                                str = ", reference text=" + ((Object) baseDanmaku4.text) + ", reference top=" + baseDanmaku4.getTop() + ", reference left=" + baseDanmaku4.getLeft() + ", rectArr=" + Arrays.toString(rectAtTime);
                            } else {
                                str = ", reference=null";
                            }
                            Log.d(str3, "fixDrawItem, maxLine=" + lineCount + ", line=" + i3 + ", canDraw=true, text=" + ((Object) baseDanmaku.text) + ", top=" + baseDanmaku.getTop() + ", left=" + baseDanmaku.getLeft() + ", danmaku.show=" + baseDanmaku.isShown() + ", fixResult.show=" + fixResult.shown + str);
                        }
                    }
                    z = z3;
                }
                if (z) {
                    Float f = this.mLineSpeedArray.get(fixResult.mLine, null);
                    if (f != null) {
                        ((R2LDanmaku) baseDanmaku).setStepAndCalculateDuration(f.floatValue());
                    } else {
                        float speed = getSpeed();
                        ((R2LDanmaku) baseDanmaku).setStepAndCalculateDuration(speed);
                        this.mLineSpeedArray.put(fixResult.mLine, Float.valueOf(speed));
                    }
                }
                return fixResult;
            }
        }
    }

    private int getLineCount() {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null) {
            return iDanmakuSettingPlugin.getLineCount();
        }
        return 2;
    }

    private float getLineHeight() {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null) {
            return iDanmakuSettingPlugin.getLineHeight();
        }
        return 24.0f * DanmakuEngineContext.getDensity();
    }

    private float getLineSpace() {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null) {
            return iDanmakuSettingPlugin.getLineSpace();
        }
        return 6.0f * DanmakuEngineContext.getDensity();
    }

    private float getSpeed() {
        return ((getUniformSpeed() * (((this.mSpeedFactorRandom.nextInt(115) % 31) + 85) / 100.0f)) / this.mSpeedFactor) * this.mVideoSpeed;
    }

    private float getUniformSpeed() {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null) {
            return iDanmakuSettingPlugin.getUniformSpeed();
        }
        return 0.275f;
    }

    private void setResult(DanmakusRetainer.FixResult fixResult, int i, float f) {
        fixResult.mLine = i;
        fixResult.mWillHit = false;
        fixResult.mIsOutOfVerticalEdge = false;
        fixResult.mTopPos = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0059 A[LOOP:0: B:18:0x0059->B:27:0x009f, LOOP_START, PHI: r3 
      PHI: (r3v1 int) = (r3v0 int), (r3v2 int) binds: [B:17:0x0057, B:27:0x009f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a2 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void changeSpeed(float r7, float r8) {
        /*
            r6 = this;
            float r0 = r6.mVideoSpeed
            float r1 = r6.mSpeedFactor
            r2 = 1
            r3 = 0
            int r4 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r4 == 0) goto Ld
            r6.mVideoSpeed = r7
            goto L17
        Ld:
            int r4 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r4 == 0) goto L16
            r6.mSpeedFactor = r8
            r2 = 0
            r4 = 1
            goto L18
        L16:
            r2 = 0
        L17:
            r4 = 0
        L18:
            if (r2 != 0) goto L1d
            if (r4 != 0) goto L1d
            return
        L1d:
            boolean r4 = com.youku.danmaku.engine.danmaku.util.Log.isDebug()
            if (r4 == 0) goto L51
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "videoSpeed="
            r4.append(r5)
            r4.append(r7)
            java.lang.String r7 = ", speedFactor="
            r4.append(r7)
            r4.append(r8)
            java.lang.String r7 = ", lastVideoSpeed="
            r4.append(r7)
            r4.append(r0)
            java.lang.String r7 = ", lastSpeedFactor="
            r4.append(r7)
            r4.append(r1)
            java.lang.String r7 = r4.toString()
            java.lang.String r4 = "changeSpeed"
            com.youku.danmaku.engine.danmaku.util.Log.d(r4, r7)
        L51:
            android.util.SparseArray<java.lang.Float> r7 = r6.mLineSpeedArray
            int r7 = r7.size()
            if (r7 <= 0) goto La2
        L59:
            android.util.SparseArray<java.lang.Float> r7 = r6.mLineSpeedArray
            int r7 = r7.size()
            if (r3 >= r7) goto La2
            android.util.SparseArray<java.lang.Float> r7 = r6.mLineSpeedArray
            int r7 = r7.keyAt(r3)
            android.util.SparseArray<java.lang.Float> r4 = r6.mLineSpeedArray
            java.lang.Object r4 = r4.get(r7)
            java.lang.Float r4 = (java.lang.Float) r4
            if (r4 == 0) goto L92
            if (r2 == 0) goto L81
            float r4 = r4.floatValue()
            float r4 = r4 / r0
            float r5 = r6.mVideoSpeed
            float r4 = r4 * r5
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            goto L8c
        L81:
            float r4 = r4.floatValue()
            float r4 = r4 * r1
            float r4 = r4 / r8
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
        L8c:
            android.util.SparseArray<java.lang.Float> r5 = r6.mLineSpeedArray
            r5.put(r7, r4)
            goto L9f
        L92:
            android.util.SparseArray<java.lang.Float> r4 = r6.mLineSpeedArray
            float r5 = r6.getSpeed()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r4.put(r7, r5)
        L9f:
            int r3 = r3 + 1
            goto L59
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.danmaku.engine.danmaku.renderer.android.RLDanmakusNewRetainer.changeSpeed(float, float):void");
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
    public void clear() {
        this.mCancelFixingFlag = true;
        this.mVisibleDanmakus.clear();
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
    public void fix(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, DanmakusRetainer.Verifier verifier) {
        boolean z;
        int i;
        int i2;
        if (baseDanmaku.isOutside()) {
            return;
        }
        float dispTopEdge = getDispTopEdge(baseDanmaku, iDisplayer);
        boolean isShown = baseDanmaku.isShown();
        int i3 = 0;
        boolean z2 = !isShown && this.mVisibleDanmakus.size() > 0;
        if (isShown) {
            z = z2;
            i = 0;
        } else {
            this.mCancelFixingFlag = false;
            DanmakusRetainer.FixResult fixDrawItem = fixDrawItem(baseDanmaku, iDisplayer);
            if (fixDrawItem != null) {
                int i4 = fixDrawItem.mLine;
                boolean z3 = fixDrawItem.mIsOutOfVerticalEdge;
                float f = fixDrawItem.mTopPos;
                boolean z4 = fixDrawItem.mWillHit;
                boolean z5 = fixDrawItem.shown;
                i3 = z3 ? 1 : 0;
                dispTopEdge = f;
                isShown = z5;
                z = z4;
                i2 = i4;
            } else {
                z = z2;
                i2 = 0;
            }
            if (baseDanmaku.isOutside()) {
                if (Log.isDebug()) {
                    Log.e("RLDanmakusRetainer", "\nisOutside\ndrawItem.time=" + baseDanmaku.time + "\ndrawItem.duration=" + baseDanmaku.getDuration());
                    return;
                }
                return;
            }
            int i5 = i2;
            i = i3;
            i3 = i5;
        }
        if (verifier == null || !verifier.skipLayout(baseDanmaku, dispTopEdge, i3, z)) {
            if (i != 0) {
                if (Log.isDebug()) {
                    Log.d("RLDanmakusRetainer", "isOutOfVerticalEdge: text=" + ((Object) baseDanmaku.text));
                    return;
                }
                return;
            }
            baseDanmaku.layout(iDisplayer, baseDanmaku.getLeft(), dispTopEdge);
            if (isShown) {
                return;
            }
            if (Log.isDebug()) {
                Log.e("RLDanmakusRetainer", "end show\ntext: " + ((Object) baseDanmaku.text) + "\nlines: " + i3 + "\nwillHit：" + z + "\ntop：" + baseDanmaku.getTop() + "\nleft: " + baseDanmaku.getLeft() + "\ntopPos：" + dispTopEdge + "\nmLineSpeedArray: " + this.mLineSpeedArray.toString());
            }
            baseDanmaku.setDanmakuLine(i3);
            this.mVisibleDanmakus.put(i3, baseDanmaku);
        }
    }

    protected float getDispTopEdge(BaseDanmaku baseDanmaku, IDisplayer iDisplayer) {
        return 0.0f;
    }

    protected boolean isOutVerticalEdge(boolean z, BaseDanmaku baseDanmaku, IDisplayer iDisplayer, float f, BaseDanmaku baseDanmaku2, BaseDanmaku baseDanmaku3) {
        return f < getDispTopEdge(baseDanmaku, iDisplayer) || f + baseDanmaku.paintHeight > ((float) iDisplayer.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showVisibleDanmakuLog() {
        for (int i = 0; i < this.mVisibleDanmakus.size(); i++) {
            BaseDanmaku baseDanmaku = this.mVisibleDanmakus.get(i);
            if (baseDanmaku != null) {
                Log.d("RLDanmakusRetainer", "showScreen, showVisibleDanmakuLog: line=" + i + ", line=" + baseDanmaku.getDanmakuLine() + ", text=" + ((Object) baseDanmaku.text) + ", top=" + baseDanmaku.getTop() + ", left=" + baseDanmaku.getLeft());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void changeSpeed(R2LDanmaku r2LDanmaku) {
        int top = (int) (r2LDanmaku.getTop() / (getLineHeight() + getLineSpace()));
        Float f = this.mLineSpeedArray.get(top);
        float floatValue = f != null ? f.floatValue() : 0.0f;
        if (floatValue <= 0.0f) {
            floatValue = getSpeed();
            this.mLineSpeedArray.put(top, Float.valueOf(floatValue));
        }
        r2LDanmaku.setSpeedAndChangeDuration(floatValue);
    }
}
