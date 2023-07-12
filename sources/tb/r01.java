package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.utils.Logger;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class r01 implements SystemConfigMgr.IKVChangeListener {
    public static final String TAG_HTTPS_HOST_PORT = "utanalytics_https_host";
    public static r01 b;
    private String a = "https://h-adashx.ut.taobao.com/upload";

    r01() {
        try {
            Context j = Variables.n().j();
            if (j != null) {
                c(u6.f(j, TAG_HTTPS_HOST_PORT));
                c(we2.a(j, TAG_HTTPS_HOST_PORT));
            }
            c(SystemConfigMgr.i().h(TAG_HTTPS_HOST_PORT));
            SystemConfigMgr.i().l(TAG_HTTPS_HOST_PORT, this);
        } catch (Throwable unused) {
        }
    }

    public static synchronized r01 b() {
        r01 r01Var;
        synchronized (r01.class) {
            if (b == null) {
                b = new r01();
            }
            r01Var = b;
        }
        return r01Var;
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a = "https://" + str + "/upload";
    }

    public String a() {
        Logger.f("", "mHttpsUrl", this.a);
        return this.a;
    }

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        c(str2);
    }
}
