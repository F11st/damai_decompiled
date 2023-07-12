package com.youku.alixplayer.opensdk.statistics.framework;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class Dimension {
    private String key;
    private String pkey;
    private String value;

    public Dimension(String str) {
        this(str, str, null);
    }

    public String getKey() {
        return this.key;
    }

    public String getPkey() {
        return this.pkey;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public Dimension(String str, String str2) {
        this(str, str2, null);
    }

    public Dimension(String str, String str2, String str3) {
        this.key = str;
        this.pkey = str2;
        this.value = str3;
    }
}
