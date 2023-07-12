package tb;

import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.NetworkStageDispatcher;
import com.taobao.network.lifecycle.IMtopLifecycle;
import com.taobao.network.lifecycle.INetworkLifecycle;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class tj1 implements IMtopLifecycle, INetworkLifecycle {
    private NetworkStageDispatcher a = null;

    public tj1() {
        a();
    }

    private void a() {
        IDispatcher b = ca0.b(b0.NETWORK_STAGE_DISPATCHER);
        if (b instanceof NetworkStageDispatcher) {
            this.a = (NetworkStageDispatcher) b;
        }
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onCancel(String str, Map<String, Object> map) {
        if (ca0.c(this.a)) {
            return;
        }
        this.a.f(3);
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onError(String str, Map<String, Object> map) {
        if (ca0.c(this.a)) {
            return;
        }
        this.a.f(2);
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onEvent(String str, String str2, Map<String, Object> map) {
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onFinished(String str, Map<String, Object> map) {
        if (ca0.c(this.a)) {
            return;
        }
        this.a.f(1);
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopCancel(String str, Map<String, Object> map) {
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopError(String str, Map<String, Object> map) {
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopEvent(String str, String str2, Map<String, Object> map) {
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopFinished(String str, Map<String, Object> map) {
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopRequest(String str, String str2, Map<String, Object> map) {
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onRequest(String str, String str2, Map<String, Object> map) {
        if (ca0.c(this.a)) {
            return;
        }
        this.a.f(0);
    }

    @Override // com.taobao.network.lifecycle.INetworkLifecycle
    public void onValidRequest(String str, String str2, Map<String, Object> map) {
    }
}
