package com.alibaba.gaiax.studio.third.socket.websocket.dispatcher;

import com.alibaba.gaiax.studio.third.socket.websocket.response.Response;
import java.util.ArrayDeque;
import java.util.Queue;
import tb.gf0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class a {
    private EngineThread a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0143a {
        private static Queue<C0143a> f = new ArrayDeque(10);
        boolean a;
        Response b;
        gf0 c;
        IResponseDispatcher d;
        ResponseDelivery e;

        C0143a() {
        }

        static C0143a a() {
            C0143a poll = f.poll();
            return poll == null ? new C0143a() : poll;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void b(C0143a c0143a) {
            f.offer(c0143a);
        }
    }

    public a() {
        EngineThread engineThread = new EngineThread();
        this.a = engineThread;
        engineThread.start();
    }

    public void a(Response response, IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery) {
        if (response == null || iResponseDispatcher == null || responseDelivery == null) {
            return;
        }
        C0143a a = C0143a.a();
        a.d = iResponseDispatcher;
        a.e = responseDelivery;
        a.a = false;
        a.b = response;
        a.c = null;
        this.a.add(a);
    }

    public void b(gf0 gf0Var, IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery) {
        if (gf0Var == null || iResponseDispatcher == null || responseDelivery == null) {
            return;
        }
        C0143a a = C0143a.a();
        a.d = iResponseDispatcher;
        a.e = responseDelivery;
        a.a = true;
        a.c = gf0Var;
        a.b = null;
        this.a.add(a);
    }
}
