package com.youku.danmaku.engine.danmaku.renderer.android;

import android.util.SparseArray;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuEngineContext;
import com.youku.danmaku.engine.danmaku.model.IDanmakuIterator;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.Danmakus;
import com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku;
import com.youku.danmaku.engine.danmaku.model.style.BaseExtraStyle;
import com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer;
import com.youku.danmaku.engine.danmaku.util.DanmakuUtils;
import com.youku.danmaku.engine.danmaku.util.Log;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class RLDanmakusLineRetainer implements DanmakusRetainer.IDanmakusRetainer {
    private final IDanmakuSettingPlugin mDanmakuSettingPlugin;
    private RetainerConsumer mConsumer = new RetainerConsumer();
    private Danmakus mVisibleDanmakus = new Danmakus(1);
    private boolean mCancelFixingFlag = false;
    private float mVideoSpeed = 1.0f;
    private float mSpeedFactor = 1.0f;
    private final SparseArray<Float> mLineSpeedArray = new SparseArray<>();
    private Random mSpeedFactorRandom = new Random();

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    protected class RetainerConsumer extends IDanmakus.Consumer<BaseDanmaku, DanmakusRetainer.RetainerState> {
        IDisplayer disp;
        BaseDanmaku minBotttom;
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
            BaseDanmaku baseDanmaku = this.drawItem;
            if (baseDanmaku == null || !baseDanmaku.mAssignRow) {
                return;
            }
            this.lines = RLDanmakusLineRetainer.this.assignRowForDanmakuInfo(baseDanmaku);
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
        public int accept(BaseDanmaku baseDanmaku) {
            if (RLDanmakusLineRetainer.this.mCancelFixingFlag) {
                return 1;
            }
            this.lines = (int) (baseDanmaku.getTop() / (RLDanmakusLineRetainer.this.getLineHeight() + RLDanmakusLineRetainer.this.getLineSpace()));
            BaseDanmaku baseDanmaku2 = this.drawItem;
            if (baseDanmaku == baseDanmaku2) {
                if (Log.isDebug()) {
                    Log.e("RLDanmakusRetainer", "drawItem already in mVisibleDanmakus, text: " + ((Object) this.drawItem.text));
                }
                this.insertItem = baseDanmaku;
                this.lastItem = null;
                this.shown = true;
                this.willHit = false;
                return 1;
            }
            if (this.firstItem == null) {
                this.firstItem = baseDanmaku;
            }
            if (baseDanmaku2.mAssignRow) {
                int assignRowForDanmakuInfo = RLDanmakusLineRetainer.this.assignRowForDanmakuInfo(baseDanmaku2);
                if (assignRowForDanmakuInfo != -1) {
                    if (baseDanmaku.getTop() + baseDanmaku.paintHeight <= this.disp.getHeight()) {
                        float top = this.drawItem.paintHeight + baseDanmaku.getTop();
                        BaseExtraStyle baseExtraStyle = this.drawItem.mExtraStyle;
                        if (top + (baseExtraStyle != null ? baseExtraStyle.getTopPadding() : 0.0f) > this.disp.getHeight()) {
                            this.overwriteInsert = true;
                            this.lines = assignRowForDanmakuInfo;
                            this.lastItem = baseDanmaku;
                            return 1;
                        }
                    }
                    if (assignRowForDanmakuInfo == this.lines) {
                        IDisplayer iDisplayer = this.disp;
                        BaseDanmaku baseDanmaku3 = this.drawItem;
                        boolean willHitInUniformSpeed = DanmakuUtils.willHitInUniformSpeed(iDisplayer, baseDanmaku, baseDanmaku3, baseDanmaku3.getTimer().currMillisecond);
                        this.willHit = willHitInUniformSpeed;
                        if (!willHitInUniformSpeed) {
                            this.insertItem = baseDanmaku;
                            return 1;
                        }
                    }
                }
                return 0;
            }
            if (baseDanmaku.getTop() + baseDanmaku.paintHeight <= this.disp.getHeight()) {
                float top2 = this.drawItem.paintHeight + baseDanmaku.getTop();
                BaseExtraStyle baseExtraStyle2 = this.drawItem.mExtraStyle;
                if (top2 + (baseExtraStyle2 != null ? baseExtraStyle2.getTopPadding() : 0.0f) > this.disp.getHeight()) {
                    if (Log.isDebug()) {
                        Log.d("RLDanmakusRetainer", "accept overwriteInsert, top=" + baseDanmaku.getTop() + ", item.text=" + ((Object) baseDanmaku.text) + ", item.lines=" + this.lines + ", drawItem.text=" + ((Object) this.drawItem.text) + ", drawItem.height=" + this.drawItem.paintHeight);
                    }
                    this.overwriteInsert = true;
                    return 1;
                }
            } else if (Log.isDebug()) {
                Log.d("RLDanmakusRetainer", "item overwriteInsert, top=" + baseDanmaku.getTop() + ", item.text=" + ((Object) baseDanmaku.text) + ", item.lines=" + this.lines + ", drawItem.text=" + ((Object) this.drawItem.text) + ", drawItem.height=" + this.drawItem.paintHeight);
            }
            IDisplayer iDisplayer2 = this.disp;
            BaseDanmaku baseDanmaku4 = this.drawItem;
            boolean willHitInUniformSpeed2 = DanmakuUtils.willHitInUniformSpeed(iDisplayer2, baseDanmaku, baseDanmaku4, baseDanmaku4.getTimer().currMillisecond);
            this.willHit = willHitInUniformSpeed2;
            if (!willHitInUniformSpeed2) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public RLDanmakusLineRetainer(IDanmakuSettingPlugin iDanmakuSettingPlugin) {
        this.mDanmakuSettingPlugin = iDanmakuSettingPlugin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int assignRowForDanmakuInfo(BaseDanmaku baseDanmaku) {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null) {
            return iDanmakuSettingPlugin.assignRowForDanmakuInfo(baseDanmaku);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getLineHeight() {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null) {
            return iDanmakuSettingPlugin.getLineHeight();
        }
        return 24.0f * DanmakuEngineContext.getDensity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getLineSpace() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.youku.danmaku.engine.danmaku.renderer.android.RLDanmakusLineRetainer.changeSpeed(float, float):void");
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
    public void clear() {
        this.mCancelFixingFlag = true;
        this.mVisibleDanmakus.clear();
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
    public void fix(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, DanmakusRetainer.Verifier verifier) {
        BaseDanmaku baseDanmaku2;
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        BaseDanmaku baseDanmaku3;
        BaseDanmaku baseDanmaku4;
        BaseDanmaku baseDanmaku5;
        boolean z5;
        float dispTopEdge;
        int i2;
        boolean z6;
        boolean z7;
        int i3;
        float top;
        BaseDanmaku baseDanmaku6;
        boolean z8;
        BaseDanmaku baseDanmaku7;
        int i4;
        boolean z9;
        String str;
        if (baseDanmaku.isOutside()) {
            return;
        }
        float dispTopEdge2 = getDispTopEdge(baseDanmaku, iDisplayer);
        boolean isShown = baseDanmaku.isShown();
        int i5 = 0;
        boolean z10 = (isShown || this.mVisibleDanmakus.isEmpty()) ? false : true;
        if (isShown) {
            baseDanmaku2 = null;
            z = false;
        } else {
            this.mCancelFixingFlag = false;
            RetainerConsumer retainerConsumer = this.mConsumer;
            retainerConsumer.disp = iDisplayer;
            retainerConsumer.drawItem = baseDanmaku;
            this.mVisibleDanmakus.forEachSync(retainerConsumer);
            DanmakusRetainer.RetainerState result = this.mConsumer.result();
            if (result != null) {
                int i6 = result.lines;
                baseDanmaku3 = result.insertItem;
                BaseDanmaku baseDanmaku8 = result.firstItem;
                BaseDanmaku baseDanmaku9 = result.lastItem;
                boolean z11 = result.overwriteInsert;
                z2 = result.shown;
                z3 = result.willHit;
                if (Log.isDebug()) {
                    if (this.mVisibleDanmakus.isEmpty()) {
                        str = "is empty";
                    } else {
                        str = this.mVisibleDanmakus.items.size() + "个";
                    }
                    Log.e("RLDanmakusRetainer", result.log() + "\ndrawItem: " + ((Object) baseDanmaku.text) + "\ndrawItem.getLeft()=" + baseDanmaku.getLeft() + "\ndrawItem.getTop()=" + baseDanmaku.getTop() + "\nmVisibleDanmakus count: " + str);
                }
                i = i6;
                z4 = z11;
                baseDanmaku5 = baseDanmaku9;
                baseDanmaku4 = baseDanmaku8;
            } else {
                z2 = isShown;
                z3 = z10;
                i = 0;
                z4 = false;
                baseDanmaku3 = null;
                baseDanmaku4 = null;
                baseDanmaku5 = null;
            }
            if (!baseDanmaku.mAssignRow) {
                z5 = false;
                if (baseDanmaku3 != null) {
                    if (Log.isDebug()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("\ninsertItem: ");
                        sb.append((Object) baseDanmaku3.text);
                        sb.append("\ninsertItem.getLeft()=");
                        sb.append(baseDanmaku3.getLeft());
                        sb.append("\ninsertItem.getTop()=");
                        sb.append(baseDanmaku3.getTop());
                        sb.append("\nisShown=");
                        sb.append(baseDanmaku3.isShown());
                        sb.append("\ncurrentTime=");
                        baseDanmaku7 = baseDanmaku4;
                        sb.append(baseDanmaku3.getTimer().currMillisecond);
                        sb.append("\ntime=");
                        sb.append(baseDanmaku3.time);
                        Log.e("RLDanmakusRetainer", sb.toString());
                    } else {
                        baseDanmaku7 = baseDanmaku4;
                    }
                    if (baseDanmaku5 != null) {
                        dispTopEdge = baseDanmaku5.getBottom();
                    } else {
                        dispTopEdge = baseDanmaku3.getTop();
                    }
                    i2 = i;
                    if (baseDanmaku3 != baseDanmaku) {
                        baseDanmaku6 = baseDanmaku3;
                        top = dispTopEdge;
                        baseDanmaku4 = baseDanmaku7;
                        z7 = true;
                        i3 = -1;
                    } else {
                        baseDanmaku4 = baseDanmaku7;
                        z7 = true;
                        i3 = -1;
                        baseDanmaku6 = null;
                        z6 = z3;
                        z8 = z2;
                        top = dispTopEdge;
                    }
                } else {
                    BaseDanmaku baseDanmaku10 = baseDanmaku4;
                    if (!z4 || baseDanmaku5 == null) {
                        if (baseDanmaku5 == null || baseDanmaku10 == null) {
                            baseDanmaku4 = baseDanmaku10;
                        } else {
                            baseDanmaku4 = baseDanmaku10;
                            if (baseDanmaku4 == baseDanmaku5 && baseDanmaku4.getTop() > 0.0f) {
                                dispTopEdge = getDispTopEdge(baseDanmaku, iDisplayer);
                                z8 = z2;
                                z7 = true;
                                i3 = -1;
                                i2 = 0;
                                baseDanmaku6 = null;
                                z6 = false;
                                top = dispTopEdge;
                            }
                        }
                        if (baseDanmaku5 != null) {
                            dispTopEdge = baseDanmaku5.getBottom();
                            i2 = i + 1;
                            z8 = z2;
                            z7 = true;
                            i3 = -1;
                            baseDanmaku6 = null;
                            z6 = false;
                            top = dispTopEdge;
                        } else if (baseDanmaku4 != null) {
                            i2 = i;
                            top = baseDanmaku4.getTop();
                            baseDanmaku6 = baseDanmaku4;
                            z6 = z3;
                            z7 = true;
                            i3 = -1;
                            z8 = false;
                        } else {
                            dispTopEdge = getDispTopEdge(baseDanmaku, iDisplayer);
                            i2 = i;
                            z6 = z3;
                            z7 = true;
                            i3 = -1;
                            baseDanmaku6 = null;
                            z8 = z2;
                            top = dispTopEdge;
                        }
                    } else {
                        i2 = i;
                        top = baseDanmaku5.getTop();
                        baseDanmaku4 = baseDanmaku10;
                        z7 = false;
                        i3 = -1;
                        baseDanmaku6 = null;
                    }
                }
                z6 = z3;
                z8 = false;
            } else if (baseDanmaku3 != null) {
                if (baseDanmaku5 != null) {
                    dispTopEdge = baseDanmaku5.getTop();
                } else {
                    dispTopEdge = baseDanmaku3.getTop();
                }
                i2 = i;
                if (baseDanmaku3 != baseDanmaku) {
                    baseDanmaku6 = baseDanmaku3;
                    top = dispTopEdge;
                    z6 = z3;
                    z7 = false;
                    i3 = -1;
                    z5 = false;
                    z8 = false;
                } else {
                    z6 = z3;
                    z7 = true;
                    i3 = -1;
                    z5 = false;
                    baseDanmaku6 = null;
                    z8 = z2;
                    top = dispTopEdge;
                }
            } else {
                int assignRowForDanmakuInfo = assignRowForDanmakuInfo(baseDanmaku);
                if (assignRowForDanmakuInfo == -1) {
                    baseDanmaku.isFilter = true;
                    baseDanmaku.setVisibility(false);
                    return;
                } else if (z4 && baseDanmaku5 != null) {
                    baseDanmaku.isFilter = true;
                    baseDanmaku.setVisibility(false);
                    return;
                } else {
                    z5 = false;
                    i2 = assignRowForDanmakuInfo;
                    top = (getLineHeight() + getLineSpace()) * assignRowForDanmakuInfo;
                    z6 = z3;
                    z7 = true;
                    i3 = -1;
                    z8 = false;
                    baseDanmaku6 = null;
                }
            }
            if (i2 != i3) {
                boolean isOutVerticalEdge = z7 ? isOutVerticalEdge(z4, baseDanmaku, iDisplayer, top, baseDanmaku4, baseDanmaku5) : false;
                if (isOutVerticalEdge) {
                    top = getDispTopEdge(baseDanmaku, iDisplayer);
                    i4 = 1;
                    z9 = true;
                } else {
                    i4 = i2;
                    z9 = z6;
                }
                if (top != getDispTopEdge(baseDanmaku, iDisplayer)) {
                    z5 = z8;
                }
                if (!z5 && !isOutVerticalEdge && !z9) {
                    Float f = this.mLineSpeedArray.get(i4);
                    if (f != null) {
                        ((R2LDanmaku) baseDanmaku).setStepAndCalculateDuration(f.floatValue());
                    } else {
                        float speed = getSpeed();
                        ((R2LDanmaku) baseDanmaku).setStepAndCalculateDuration(speed);
                        this.mLineSpeedArray.put(i4, Float.valueOf(speed));
                    }
                }
                z10 = z9;
                i2 = i4;
                isShown = z5;
                z5 = isOutVerticalEdge;
                dispTopEdge2 = top;
            } else {
                dispTopEdge2 = top;
                isShown = z8;
                z10 = z6;
            }
            if (baseDanmaku.isOutside()) {
                if (Log.isDebug()) {
                    Log.e("RLDanmakusRetainer", "\nisOutside\ndrawItem.time=" + baseDanmaku.time + "\ndrawItem.duration=" + baseDanmaku.getDuration());
                    return;
                }
                return;
            }
            if (Log.isDebug()) {
                Log.e("RLDanmakusRetainer", "\nend show\nisOutOfVerticalEdge: " + z5 + "\nlines: " + i2 + "\ntext: " + ((Object) baseDanmaku.text) + "\nshown: " + isShown + "\nwillHit：" + z10 + "\ntopPos：" + dispTopEdge2 + "\nfactor: " + this.mSpeedFactor + "\nmLineSpeedArray: " + this.mLineSpeedArray.toString());
            }
            z = z5;
            baseDanmaku2 = baseDanmaku6;
            i5 = i2;
        }
        if (verifier == null || !verifier.skipLayout(baseDanmaku, dispTopEdge2, i5, z10)) {
            if (z) {
                if (Log.isDebug()) {
                    Log.d("RLDanmakusRetainer", "text=" + ((Object) baseDanmaku.text));
                    return;
                }
                return;
            }
            baseDanmaku.layout(iDisplayer, baseDanmaku.getLeft(), dispTopEdge2);
            if (isShown) {
                return;
            }
            baseDanmaku.setDanmakuLine(i5);
            this.mVisibleDanmakus.removeItem(baseDanmaku2);
            this.mVisibleDanmakus.addItem(baseDanmaku);
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
        IDanmakuIterator it = this.mVisibleDanmakus.iterator();
        while (it.hasNext()) {
            BaseDanmaku next = it.next();
            if (next != null) {
                Log.d("RLDanmakusRetainer", "showScreen, showVisibleDanmakuLog: line=" + next.getDanmakuLine() + ", text=" + ((Object) next.text) + ", top=" + next.getTop() + ", left=" + next.getLeft());
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
