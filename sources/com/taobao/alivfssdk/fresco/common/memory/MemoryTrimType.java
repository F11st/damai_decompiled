package com.taobao.alivfssdk.fresco.common.memory;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum MemoryTrimType {
    OnCloseToDalvikHeapLimit(0.5d),
    OnSystemLowMemoryWhileAppInForeground(0.5d),
    OnSystemLowMemoryWhileAppInBackground(1.0d),
    OnAppBackgrounded(1.0d);
    
    private final double mSuggestedTrimRatio;

    MemoryTrimType(double d) {
        this.mSuggestedTrimRatio = d;
    }

    public double getSuggestedTrimRatio() {
        return this.mSuggestedTrimRatio;
    }
}
