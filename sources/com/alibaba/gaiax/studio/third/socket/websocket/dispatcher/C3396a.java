package com.alibaba.gaiax.studio.third.socket.websocket.dispatcher;

import com.alibaba.gaiax.studio.third.socket.websocket.response.Response;
import java.util.ArrayDeque;
import java.util.Queue;
import tb.gf0;

/* compiled from: Taobao */
/* renamed from: com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.a */
/* loaded from: classes6.dex */
public class C3396a {
    private EngineThread a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.a$a */
    /* loaded from: classes6.dex */
    public static class C3397a {
        private static Queue<C3397a> f = new ArrayDeque(10);
        boolean a;
        Response b;
        gf0 c;
        IResponseDispatcher d;
        ResponseDelivery e;

        C3397a() {
        }

        static C3397a a() {
            C3397a poll = f.poll();
            return poll == null ? new C3397a() : poll;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void b(C3397a c3397a) {
            f.offer(c3397a);
        }
    }

    public C3396a() {
        EngineThread engineThread = new EngineThread();
        this.a = engineThread;
        engineThread.start();
    }

    public void a(Response response, IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery) {
        if (response == null || iResponseDispatcher == null || responseDelivery == null) {
            return;
        }
        C3397a a = C3397a.a();
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
        C3397a a = C3397a.a();
        a.d = iResponseDispatcher;
        a.e = responseDelivery;
        a.a = true;
        a.c = gf0Var;
        a.b = null;
        this.a.add(a);
    }
}
