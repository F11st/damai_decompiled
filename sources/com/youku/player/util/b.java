package com.youku.player.util;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class b {
    private InterfaceC0398b a = new InterfaceC0398b() { // from class: com.youku.player.util.b.1
        @Override // com.youku.player.util.b.InterfaceC0398b
        public int a(String str, String str2) {
            return Log.d(str, str2);
        }

        @Override // com.youku.player.util.b.InterfaceC0398b
        public int a(String str, String str2, Throwable th) {
            return Log.d(str, str2, th);
        }

        @Override // com.youku.player.util.b.InterfaceC0398b
        public int b(String str, String str2) {
            return Log.e(str, str2);
        }

        @Override // com.youku.player.util.b.InterfaceC0398b
        public int b(String str, String str2, Throwable th) {
            return Log.e(str, str2, th);
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    private static class a {
        private static final b a = new b();
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.player.util.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0398b {
        int a(String str, String str2);

        int a(String str, String str2, Throwable th);

        int b(String str, String str2);

        int b(String str, String str2, Throwable th);
    }

    b() {
    }

    public static b a() {
        return a.a;
    }

    public InterfaceC0398b b() {
        return this.a;
    }
}
