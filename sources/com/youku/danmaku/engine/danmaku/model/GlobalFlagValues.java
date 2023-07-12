package com.youku.danmaku.engine.danmaku.model;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GlobalFlagValues {
    public int MEASURE_RESET_FLAG = 0;
    public int VISIBLE_RESET_FLAG = 0;
    public int FILTER_RESET_FLAG = 0;
    public int FIRST_SHOWN_RESET_FLAG = 0;

    public void resetAll() {
        this.VISIBLE_RESET_FLAG = 0;
        this.MEASURE_RESET_FLAG = 0;
        this.FILTER_RESET_FLAG = 0;
        this.FIRST_SHOWN_RESET_FLAG = 0;
    }

    public void updateFilterFlag() {
        this.FILTER_RESET_FLAG++;
    }

    public void updateFirstShownFlag() {
        this.FIRST_SHOWN_RESET_FLAG++;
    }

    public void updateMeasureFlag() {
        this.MEASURE_RESET_FLAG++;
    }

    public void updateVisibleFlag() {
        this.VISIBLE_RESET_FLAG++;
    }
}
