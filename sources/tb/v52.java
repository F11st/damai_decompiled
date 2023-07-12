package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.utils.Logger;
import com.ta.audid.Constants;
import com.ta.utdid2.device.UTDevice;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
class v52 implements SystemConfigMgr.IKVChangeListener {
    private int a = 0;

    public v52() {
        b(SystemConfigMgr.i().h("sample_ipv6"));
    }

    private void b(String str) {
        Logger.f("SampleIpv6Listener", "parseConfig value", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.a = Integer.parseInt(str);
        } catch (Exception unused) {
            this.a = 0;
        }
    }

    public boolean a() {
        String utdid = UTDevice.getUtdid(Variables.n().j());
        if (utdid == null || utdid.equals(Constants.UTDID_INVALID)) {
            return false;
        }
        int abs = Math.abs(yh2.d(utdid));
        Logger.f("SampleIpv6Listener", "hashcode", Integer.valueOf(abs), "sample", Integer.valueOf(this.a));
        return abs % 10000 < this.a;
    }

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        b(str2);
    }
}
