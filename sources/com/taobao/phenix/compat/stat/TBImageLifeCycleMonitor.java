package com.taobao.phenix.compat.stat;

import com.taobao.phenix.lifecycle.IPhenixLifeCycle;
import java.util.Map;
import tb.bs1;
import tb.rm2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TBImageLifeCycleMonitor implements IPhenixLifeCycle {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class a {
        private static final TBImageLifeCycleMonitor a = new TBImageLifeCycleMonitor();
    }

    public static TBImageLifeCycleMonitor a() {
        return a.a;
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onCancel(final String str, final String str2, final Map<String, Object> map) {
        rm2.a(new Runnable() { // from class: com.taobao.phenix.compat.stat.TBImageLifeCycleMonitor.3
            @Override // java.lang.Runnable
            public void run() {
                bs1.b().onCancel(str, str2, map);
            }
        });
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onError(final String str, final String str2, final Map<String, Object> map) {
        rm2.a(new Runnable() { // from class: com.taobao.phenix.compat.stat.TBImageLifeCycleMonitor.2
            @Override // java.lang.Runnable
            public void run() {
                bs1.b().onError(str, str2, map);
            }
        });
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onEvent(final String str, final String str2, final Map<String, Object> map) {
        rm2.a(new Runnable() { // from class: com.taobao.phenix.compat.stat.TBImageLifeCycleMonitor.5
            @Override // java.lang.Runnable
            public void run() {
                bs1.b().onEvent(str, str2, map);
            }
        });
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onFinished(final String str, final String str2, final Map<String, Object> map) {
        rm2.a(new Runnable() { // from class: com.taobao.phenix.compat.stat.TBImageLifeCycleMonitor.4
            @Override // java.lang.Runnable
            public void run() {
                bs1.b().onFinished(str, str2, map);
            }
        });
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onRequest(final String str, final String str2, final Map<String, Object> map) {
        rm2.a(new Runnable() { // from class: com.taobao.phenix.compat.stat.TBImageLifeCycleMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                bs1.b().onRequest(str, str2, map);
            }
        });
    }
}
