package com.youku.player.util;

import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class Watchdog {

    /* compiled from: Taobao */
    /* renamed from: com.youku.player.util.Watchdog$1  reason: invalid class name */
    /* loaded from: classes13.dex */
    class AnonymousClass1 extends HashMap<String, String> {
        final /* synthetic */ Throwable val$t;

        AnonymousClass1(Throwable th) {
            this.val$t = th;
            put("message", th.getMessage());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface QueryCallback {
        @Keep
        void onResult(String str, Map<String, String> map);
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum StreamQulity {
        P540,
        P720,
        P1080,
        P2160
    }

    private native void _query(QueryCallback queryCallback);
}
