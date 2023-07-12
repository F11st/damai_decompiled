package cn.damai.solid.bean;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SoRecord implements Serializable {
    public final String soLibName;
    public volatile boolean isSystemLoaded = false;
    public volatile boolean isSkipAppSystemLoad = false;

    public SoRecord(String str) {
        this.soLibName = str;
    }
}
