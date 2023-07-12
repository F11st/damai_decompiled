package tb;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class v43 {
    public i43 a;
    public Context b;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        private static final v43 a = new v43((byte) 0);

        public static /* synthetic */ v43 a() {
            return a;
        }
    }

    private v43() {
        this.b = com.efs.sdk.base.a.d.a.a().c;
    }

    /* synthetic */ v43(byte b) {
        this();
    }

    public final String a() {
        return this.a.c("net", "disconnected").toString();
    }
}
