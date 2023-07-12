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
    /* loaded from: classes11.dex */
    class a implements AbsDispatcher.ListenerCaller<INetworkStageListener> {
        final /* synthetic */ int a;

        a(NetworkStageDispatcher networkStageDispatcher, int i) {
            this.a = i;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(INetworkStageListener iNetworkStageListener) {
            iNetworkStageListener.onNetworkStage(this.a);
        }
    }

    public void f(int i) {
        c(new a(this, i));
    }
}
