package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class so2 {
    private qo2 a;
    private boolean b;

    public so2() {
        this.b = false;
        qo2 qo2Var = new qo2();
        this.a = qo2Var;
        qo2Var.e("v6-adashx.ut.taobao.com");
        this.a.h(1);
        try {
            Context j = Variables.n().j();
            String f = u6.f(j, "utanalytics_tnet_host_port_ipv6");
            if (!TextUtils.isEmpty(f)) {
                this.b = true;
            }
            b(f);
            String a = we2.a(j, "utanalytics_tnet_host_port_ipv6");
            if (!TextUtils.isEmpty(a)) {
                this.b = true;
            }
            b(a);
        } catch (Throwable unused) {
        }
    }

    private synchronized void b(String str) {
        String trim;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (indexOf = (trim = str.trim()).indexOf(":")) != -1) {
            String substring = trim.substring(0, indexOf);
            int parseInt = Integer.parseInt(trim.substring(indexOf + 1, trim.length()));
            if (!TextUtils.isEmpty(substring) && parseInt > 0) {
                this.a.e(substring);
                this.a.f(parseInt);
            }
        }
    }

    public qo2 a() {
        if (this.b) {
            return this.a;
        }
        if (ro2.a().e()) {
            return null;
        }
        return this.a;
    }
}
