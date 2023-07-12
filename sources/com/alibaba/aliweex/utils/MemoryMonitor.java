package com.alibaba.aliweex.utils;

import android.text.TextUtils;
import android.util.Log;
import com.ali.watchmem.core.IJavaLowMemoryListener;
import com.ali.watchmem.core.INativeLowMemoryListener;
import com.ali.watchmem.core.WatchmemJavaMemoryManager;
import com.ali.watchmem.core.WatchmemNativeMemoryManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.k4;
import tb.wv;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MemoryMonitor {
    private static MemoryStatus a;
    private static MemoryStatus b;
    private static String c;
    private static Map<String, MemoryListener> d;
    private static boolean e;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface MemoryListener {
        void onChange(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    enum MemoryStatus {
        NORMAL("good"),
        HIGH("normal"),
        DANGEROUS("dangerous"),
        CRITICAL("fatal");
        
        String status;

        MemoryStatus(String str) {
            this.status = str;
        }

        boolean dangerous() {
            return equals(DANGEROUS);
        }

        boolean fatal() {
            return equals(CRITICAL);
        }

        boolean good() {
            return equals(NORMAL);
        }

        boolean normal() {
            return equals(HIGH);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.utils.MemoryMonitor$a */
    /* loaded from: classes15.dex */
    static class C3101a implements INativeLowMemoryListener {
        C3101a() {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.utils.MemoryMonitor$b */
    /* loaded from: classes15.dex */
    static class C3102b implements IJavaLowMemoryListener {
        C3102b() {
        }
    }

    static {
        MemoryStatus memoryStatus = MemoryStatus.NORMAL;
        a = memoryStatus;
        b = memoryStatus;
        c = "MemoryMonitor";
        String str = memoryStatus.status;
        d = new ConcurrentHashMap();
        e = true;
    }

    public static void a(String str, MemoryListener memoryListener) {
        if (TextUtils.isEmpty(str) || memoryListener == null) {
            return;
        }
        d.put(str, memoryListener);
    }

    public static String b() {
        k4.C9333e f;
        if (e) {
            try {
                k4 d2 = k4.d();
                if (d2 == null || (f = d2.f()) == null) {
                    return "unknown";
                }
                int i = f.a;
                if (i != -1) {
                    return i != 0 ? i != 2 ? wv.PARAM_LEVEL_MEDIUM : "low_end" : "high_end";
                }
                return "unknown";
            } catch (Throwable unused) {
                e = false;
                return "unknown";
            }
        }
        return "unknown";
    }

    public static String c() {
        if (a.good() && b.good()) {
            return MemoryStatus.NORMAL.status;
        }
        if (!a.fatal() && !b.fatal()) {
            if (!a.dangerous() && !b.dangerous()) {
                if (!a.normal() && !b.normal()) {
                    return MemoryStatus.NORMAL.status;
                }
                return MemoryStatus.HIGH.status;
            }
            return MemoryStatus.DANGEROUS.status;
        }
        return MemoryStatus.CRITICAL.status;
    }

    public static void d() {
        try {
            WatchmemNativeMemoryManager.instance().addNativeLowMemoryListener(new C3101a());
            WatchmemJavaMemoryManager.instance().addJavaLowMemoryListener(new C3102b());
        } catch (Throwable th) {
            Log.e(c, th.getMessage());
        }
    }

    public static void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.remove(str);
    }
}
