package com.youku.player.util;

import android.util.Log;

/* compiled from: Taobao */
/* renamed from: com.youku.player.util.b */
/* loaded from: classes13.dex */
public class C8060b {
    private InterfaceC8062b a = new InterfaceC8062b() { // from class: com.youku.player.util.b.1
        @Override // com.youku.player.util.C8060b.InterfaceC8062b
        public int a(String str, String str2) {
            return Log.d(str, str2);
        }

        @Override // com.youku.player.util.C8060b.InterfaceC8062b
        public int a(String str, String str2, Throwable th) {
            return Log.d(str, str2, th);
        }

        @Override // com.youku.player.util.C8060b.InterfaceC8062b
        public int b(String str, String str2) {
            return Log.e(str, str2);
        }

        @Override // com.youku.player.util.C8060b.InterfaceC8062b
        public int b(String str, String str2, Throwable th) {
            return Log.e(str, str2, th);
        }
    };

    /* compiled from: Taobao */
    /* renamed from: com.youku.player.util.b$a */
    /* loaded from: classes13.dex */
    private static class C8061a {
        private static final C8060b a = new C8060b();
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.player.util.b$b */
    /* loaded from: classes13.dex */
    public interface InterfaceC8062b {
        int a(String str, String str2);

        int a(String str, String str2, Throwable th);

        int b(String str, String str2);

        int b(String str, String str2, Throwable th);
    }

    C8060b() {
    }

    public static C8060b a() {
        return C8061a.a;
    }

    public InterfaceC8062b b() {
        return this.a;
    }
}
