package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.sync.ITnetHostPortStrategy;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class po2 implements ITnetHostPortStrategy {
    private qo2 a;
    private int b = 0;

    public po2() {
        try {
            qo2 qo2Var = new qo2();
            this.a = qo2Var;
            qo2Var.e("s-adashx.ut.taobao.com");
            this.a.h(2);
            a(u6.f(Variables.n().j(), vo2.TAG_STATIC_TNET_HOST_PORT));
            a(we2.a(Variables.n().j(), vo2.TAG_STATIC_TNET_HOST_PORT));
        } catch (Throwable unused) {
        }
    }

    private void a(String str) {
        String trim;
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = (trim = str.trim()).indexOf(":")) == -1) {
            return;
        }
        String substring = trim.substring(0, indexOf);
        int parseInt = Integer.parseInt(trim.substring(indexOf + 1, trim.length()));
        if (TextUtils.isEmpty(substring) || parseInt <= 0) {
            return;
        }
        this.a.e(substring);
        this.a.f(parseInt);
    }

    @Override // com.alibaba.analytics.core.sync.ITnetHostPortStrategy
    public qo2 getTnetHostPort() {
        if (this.b >= w52.d().e()) {
            return null;
        }
        return this.a;
    }

    @Override // com.alibaba.analytics.core.sync.ITnetHostPortStrategy
    public void response(tc tcVar) {
        if (tcVar.a()) {
            this.b = 0;
        } else {
            this.b++;
        }
    }
}
