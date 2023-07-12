package org.android.spdy;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
enum SslMod {
    SLIGHT_SLL_NOT_ENCRYT(0),
    SLIGHT_SSL_0_RTT(1);
    
    private int code;

    SslMod(int i) {
        this.code = i;
    }

    int getint() {
        return this.code;
    }
}
