package com.taobao.monitor.impl.trace;

import com.taobao.monitor.impl.trace.AbsDispatcher;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class NetworkStageDispatcher extends AbsDispatcher<INetworkStageListener> {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface INetworkStageListener {
        void onNetworkStage(int i);
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.trace.NetworkStageDispatcher$a */
    /* loaded from: classes11.dex */
    class C6796a implements AbsDispatcher.ListenerCaller<INetworkStageListener> {
        final /* synthetic */ int a;

        C6796a(NetworkStageDispatcher networkStageDispatcher, int i) {
            this.a = i;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(INetworkStageListener iNetworkStageListener) {
            iNetworkStageListener.onNetworkStage(this.a);
        }
    }

    public void f(int i) {
        c(new C6796a(this, i));
    }
}
