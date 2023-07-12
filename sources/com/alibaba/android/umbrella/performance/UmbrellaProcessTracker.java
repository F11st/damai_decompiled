package com.alibaba.android.umbrella.performance;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alibaba.android.umbrella.performance.a;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.jt2;
import tb.kt2;
import tb.lt2;

/* compiled from: Taobao */
@Keep
/* loaded from: classes15.dex */
public class UmbrellaProcessTracker {
    private static Handler trackHandler;
    private static HandlerThread trackHandlerThread = new HandlerThread("Umbrella-Performance-Trace-thread");
    private static ConcurrentHashMap<String, Long> sPageList = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            com.alibaba.android.umbrella.performance.a aVar = (com.alibaba.android.umbrella.performance.a) message.obj;
            int i = aVar.a;
            if (i == 3) {
                b.h(aVar);
            } else if (i == 4) {
                b.i(aVar);
            } else if (i == 1) {
                b.j(aVar);
            } else if (i == 2) {
                b.g(aVar);
            } else if (i == 5) {
                b.e(aVar);
            } else if (i == 7) {
                b.k(aVar);
            } else if (i == 6) {
                b.a(aVar);
            }
        }
    }

    public static void addAbTestInfo(String str, String str2, String str3) {
        if (lt2.a(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !isContainBiz(str)) {
            return;
        }
        sendProcessEvent(new a.b(str).n(6).b(str2).a(str3).j());
    }

    public static void addArgs(String str, Map<String, String> map) {
        if (lt2.a(str) || map == null || map.size() < 1 || !isContainBiz(str)) {
            return;
        }
        sendProcessEvent(new a.b(str).n(2).i(map).j());
    }

    public static void addProcess(String str, jt2 jt2Var, long j) {
        if (lt2.a(str) || jt2Var == null || !isContainBiz(str)) {
            return;
        }
        sendProcessEvent(new a.b(str).n(3).o(jt2Var).l(j).j());
    }

    public static void addSubProcess(String str, jt2 jt2Var, String str2, long j) {
        if (lt2.a(str) || jt2Var == null || TextUtils.isEmpty(str2) || !isContainBiz(str)) {
            return;
        }
        sendProcessEvent(new a.b(str).n(4).o(jt2Var).m(str2).l(j).j());
    }

    public static void commit(String str) {
        if (lt2.a(str) || !isContainBiz(str)) {
            return;
        }
        removeBiz(str);
        sendProcessEvent(new a.b(str, 0L).n(5).j());
    }

    private static void init() {
        trackHandlerThread.start();
        trackHandler = new a(trackHandlerThread.getLooper());
    }

    private static boolean isContainBiz(String str) {
        if (sPageList.containsKey(str)) {
            if (System.currentTimeMillis() - sPageList.get(str).longValue() < 20000) {
                return true;
            }
            removeBiz(str);
            return false;
        }
        return false;
    }

    private static void recordBiz(String str) {
        sPageList.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static void register(String str) {
        if (lt2.a(str)) {
            return;
        }
        if ((kt2.D() && kt2.o()) || kt2.u(str)) {
            if (trackHandlerThread.getState() == Thread.State.NEW) {
                init();
            }
            recordBiz(str);
            sendProcessEvent(new a.b(str).n(1).j());
        }
    }

    private static void removeBiz(String str) {
        sPageList.remove(str);
    }

    private static void sendProcessEvent(com.alibaba.android.umbrella.performance.a aVar) {
        Handler handler = trackHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = aVar;
            trackHandler.sendMessage(obtainMessage);
        }
    }

    public static void setChildBizName(String str, String str2) {
        if (lt2.a(str) || TextUtils.isEmpty(str2) || !isContainBiz(str)) {
            return;
        }
        sendProcessEvent(new a.b(str).n(7).k(str2).j());
    }

    public static void addArgs(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str2, str3);
        addArgs(str, hashMap);
    }
}
