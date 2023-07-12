package org.android.spdy;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SpdyStreamContext {
    public Spdycb callBack;
    public Object streamContext;
    public int streamId;

    SpdyStreamContext(Object obj) {
        this.streamContext = obj;
        this.callBack = null;
        this.streamId = -1;
    }

    static int getContext(Object obj) {
        if (obj == null || !(obj instanceof Integer)) {
            return 0;
        }
        return ((Integer) obj).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpdyStreamContext(Object obj, Spdycb spdycb) {
        this.streamContext = obj;
        this.callBack = spdycb;
    }
}
