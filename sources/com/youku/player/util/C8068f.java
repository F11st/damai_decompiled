package com.youku.player.util;

/* compiled from: Taobao */
/* renamed from: com.youku.player.util.f */
/* loaded from: classes13.dex */
public class C8068f {
    public static final C8068f a = new C8068f();
    private InterfaceC8069a b;

    /* compiled from: Taobao */
    /* renamed from: com.youku.player.util.f$a */
    /* loaded from: classes13.dex */
    public interface InterfaceC8069a {
        void a(String str);

        void a(String str, String str2);
    }

    public static C8068f a() {
        return a;
    }

    public void a(String str) {
        InterfaceC8069a interfaceC8069a = this.b;
        if (interfaceC8069a != null) {
            interfaceC8069a.a(str);
        }
    }

    public void a(String str, String str2) {
        InterfaceC8069a interfaceC8069a = this.b;
        if (interfaceC8069a != null) {
            interfaceC8069a.a(str, str2);
        }
    }
}
