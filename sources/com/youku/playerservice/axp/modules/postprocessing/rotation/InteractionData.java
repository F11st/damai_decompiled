package com.youku.playerservice.axp.modules.postprocessing.rotation;

import java.util.LinkedHashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class InteractionData {
    public static final double END_TIME = -1.0d;
    public LinkedHashMap<Integer, String> data = new LinkedHashMap<>();
    public double endTime;
    public double startTime;

    public void put(Integer num, String str) {
        this.data.put(num, str);
    }

    public void setTime(double d, double d2) {
        setTime(d, d2, 0.0d);
    }

    public void setTime(double d, double d2, double d3) {
        this.startTime = d - d3;
        this.endTime = d2 - d3;
    }
}
