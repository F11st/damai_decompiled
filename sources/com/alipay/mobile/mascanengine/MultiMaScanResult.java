package com.alipay.mobile.mascanengine;

import com.alipay.mobile.bqcscanservice.BQCScanResult;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MultiMaScanResult extends BQCScanResult {
    public boolean candidate;
    public int classicFrameCount;
    public int frameCount;
    public int frameType = ScanFrameType.FRAME_TYPE_CAMERA;
    public MaScanResult[] maScanResults;
    public String readerParams;
    public String recognizedPerformance;
    public boolean rsBinarized;
    public int rsBinarizedCount;
    public long rsInitTime;
    public String totalEngineCpuTime;
    public String totalEngineTime;
    public String totalScanTime;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class ScanFrameType {
        public static int FRAME_TYPE_CAMERA = 0;
        public static int FRAME_TYPE_VIEW = 1;
    }
}
