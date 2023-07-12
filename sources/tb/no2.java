package tb;

import com.alibaba.analytics.core.sync.ITnetHostPortStrategy;
import com.alibaba.analytics.utils.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class no2 implements ITnetHostPortStrategy {
    private kd2 a;

    public no2() {
        this.a = null;
        try {
            this.a = new kd2();
        } catch (Throwable unused) {
            Logger.g();
            this.a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        kd2 kd2Var = this.a;
        if (kd2Var != null) {
            return kd2Var.b();
        }
        return 0;
    }

    @Override // com.alibaba.analytics.core.sync.ITnetHostPortStrategy
    public qo2 getTnetHostPort() {
        kd2 kd2Var = this.a;
        if (kd2Var != null) {
            return kd2Var.d();
        }
        return null;
    }

    @Override // com.alibaba.analytics.core.sync.ITnetHostPortStrategy
    public void response(tc tcVar) {
        kd2 kd2Var = this.a;
        if (kd2Var != null) {
            kd2Var.g(tcVar.a());
        }
    }
}
