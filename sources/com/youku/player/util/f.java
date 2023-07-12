package com.youku.player.util;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class f {
    public static final f a = new f();
    private a b;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface a {
        void a(String str);

        void a(String str, String str2);
    }

    public static f a() {
        return a;
    }

    public void a(String str) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public void a(String str, String str2) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }
}
