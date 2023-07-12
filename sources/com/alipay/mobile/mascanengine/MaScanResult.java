package com.alipay.mobile.mascanengine;

import android.graphics.Rect;
import com.alipay.mobile.bqcscanservice.BQCScanResult;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MaScanResult extends BQCScanResult {
    public int bitErrors;
    public String charset;
    public float codeProportion;
    public char ecLevel;
    public float errPercent;
    public long qrSize;
    public byte[] rawData;
    public String recognizedPerformance;
    public Rect rect;
    public int strategy;
    public String text;
    public String totalEngineCpuTime;
    public String totalEngineTime;
    public String totalScanTime;
    public MaScanType type;
    public String typeName;
    public int version;
}
