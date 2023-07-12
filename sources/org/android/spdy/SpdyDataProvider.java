package org.android.spdy;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SpdyDataProvider {
    byte[] data;
    public boolean finished;
    Map<String, String> postBody;

    public SpdyDataProvider(byte[] bArr) {
        this.finished = true;
        this.data = bArr;
        this.postBody = null;
    }

    public SpdyDataProvider(Map<String, String> map) {
        this.finished = true;
        this.data = null;
        this.postBody = map;
    }
}
