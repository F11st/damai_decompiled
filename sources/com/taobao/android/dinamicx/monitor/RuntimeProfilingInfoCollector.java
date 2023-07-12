package com.taobao.android.dinamicx.monitor;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.util.Set;
import tb.uf0;
import tb.vf0;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class RuntimeProfilingInfoCollector {
    private static RuntimeProfilingInfoCollector c;
    private Set<ICollector> a;
    private Set<EventChainCollector> b;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface EventChainCollector {
        void onCollectChainNodeInfo(uf0 uf0Var, vf0 vf0Var);

        void onCollectChainStartInfo(uf0 uf0Var);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface ICollector {
        void onCollectErrorInfo(e eVar, boolean z);

        void onCollectPerformanceInfo(int i, String str, String str2, String str3, DXTemplateItem dXTemplateItem, double d);
    }

    private RuntimeProfilingInfoCollector() {
    }

    @NonNull
    public static RuntimeProfilingInfoCollector c() {
        if (c == null) {
            synchronized (RuntimeProfilingInfoCollector.class) {
                if (c == null) {
                    c = new RuntimeProfilingInfoCollector();
                }
            }
        }
        return c;
    }

    public void a(@NonNull e eVar, boolean z) {
        Set<ICollector> set = this.a;
        if (set == null) {
            return;
        }
        for (ICollector iCollector : set) {
            try {
                iCollector.onCollectErrorInfo(eVar, z);
            } catch (Throwable unused) {
            }
        }
    }

    public void b(int i, String str, String str2, String str3, DXTemplateItem dXTemplateItem, double d) {
        Set<ICollector> set = this.a;
        if (set == null) {
            return;
        }
        for (ICollector iCollector : set) {
            try {
                iCollector.onCollectPerformanceInfo(i, str, str2, str3, dXTemplateItem, d);
            } catch (Throwable unused) {
            }
        }
    }

    public void d(uf0 uf0Var, vf0 vf0Var) {
        Set<EventChainCollector> set = this.b;
        if (set == null) {
            return;
        }
        for (EventChainCollector eventChainCollector : set) {
            try {
                eventChainCollector.onCollectChainNodeInfo(uf0Var, vf0Var);
            } catch (Throwable unused) {
            }
        }
    }

    public void e(uf0 uf0Var) {
        Set<EventChainCollector> set = this.b;
        if (set == null) {
            return;
        }
        for (EventChainCollector eventChainCollector : set) {
            try {
                eventChainCollector.onCollectChainStartInfo(uf0Var);
            } catch (Throwable unused) {
            }
        }
    }
}
