package org.android.spdy;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public enum SslVersion {
    SLIGHT_VERSION_V1(0);
    
    private int code;

    SslVersion(int i) {
        this.code = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getint() {
        return this.code;
    }
}
