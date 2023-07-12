package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.utils.Logger;
import com.ta.audid.Constants;
import com.taobao.weex.annotation.JSMethod;
import com.ut.device.UTDevice;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class w52 implements SystemConfigMgr.IKVChangeListener {
    private static w52 h;
    private int a = 3;
    private int b = 0;
    private int c = 0;
    private int d = 10000;
    private int e = 2;
    private int f = 2;
    private int g = 2;

    private w52() {
    }

    private int c(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static synchronized w52 d() {
        w52 w52Var;
        synchronized (w52.class) {
            if (h == null) {
                h = new w52();
            }
            w52Var = h;
        }
        return w52Var;
    }

    private void i(String str) {
        if (TextUtils.isEmpty(str)) {
            this.b = 0;
            this.c = 0;
            return;
        }
        String[] split = str.split(JSMethod.NOT_SET);
        if (split.length < 2) {
            this.b = 0;
            this.c = 0;
            return;
        }
        this.b = c(split[0], 0);
        this.c = c(split[1], 0);
    }

    public int a() {
        return this.f;
    }

    public int b() {
        return this.g;
    }

    public int e() {
        return this.e;
    }

    public void f() {
        String utdid = UTDevice.getUtdid(Variables.n().j());
        if (utdid != null && !utdid.equals(Constants.UTDID_INVALID)) {
            this.d = Math.abs(yh2.d(utdid)) % 10000;
        } else {
            this.d = 0;
        }
        Logger.f("SampleSipListener", "sipRandomNumber", Integer.valueOf(this.d));
        i(SystemConfigMgr.i().h("amdc_sip_sample"));
        this.e = c(SystemConfigMgr.i().h("sip_fail_count"), 2);
        this.f = c(SystemConfigMgr.i().h("amdc_sip_fail_count"), 2);
        this.g = c(SystemConfigMgr.i().h("amdc_sip_fail_count_all"), 2);
        this.a = c(SystemConfigMgr.i().h("upload_count"), 3);
        com.alibaba.analytics.core.sync.f.i().e(this.a);
        SystemConfigMgr.i().l("amdc_sip_sample", this);
        SystemConfigMgr.i().l("sip_fail_count", this);
        SystemConfigMgr.i().l("amdc_sip_fail_count", this);
        SystemConfigMgr.i().l("amdc_sip_fail_count_all", this);
        SystemConfigMgr.i().l("upload_count", this);
    }

    public boolean g() {
        return this.d < this.c;
    }

    public boolean h() {
        return this.d < this.b;
    }

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        Logger.f("TnetSipHostPortMgr", "key", str, "value", str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if ("amdc_sip_sample".equalsIgnoreCase(str)) {
            i(str2);
        }
        if ("sip_fail_count".equalsIgnoreCase(str)) {
            this.e = c(str2, 2);
        }
        if ("amdc_sip_fail_count".equalsIgnoreCase(str)) {
            this.f = c(str2, 2);
        }
        if ("amdc_sip_fail_count_all".equalsIgnoreCase(str)) {
            this.g = c(str2, 2);
        }
        if ("upload_count".equalsIgnoreCase(str)) {
            this.a = c(str2, 3);
            com.alibaba.analytics.core.sync.f.i().e(this.a);
        }
    }
}
