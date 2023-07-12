package com.youku.alixplayer.opensdk.statistics.framework;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class Measure {
    private String key;
    private String pkey;
    private double value;

    public Measure(String str) {
        this(str, str, -1.0d);
    }

    public String getKey() {
        return this.key;
    }

    public String getPkey() {
        return this.pkey;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double d) {
        this.value = d;
    }

    public Measure(String str, String str2) {
        this(str, str2, -1.0d);
    }

    public Measure(String str, String str2, double d) {
        this.key = str;
        this.pkey = str2;
        this.value = d;
    }
}
