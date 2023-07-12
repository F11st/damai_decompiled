package cn.damai.security;

import android.util.Log;
import com.alibaba.wireless.security.jaq.JAQException;
import com.alibaba.wireless.security.jaq.SecurityInit;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class AliSecurityHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private static boolean a;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface JAQResultListener {
        void onCancel();

        void onFailed(String str, String str2);

        void onSuccess(String str);
    }

    public static boolean a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1152510827")) {
            return ((Boolean) ipChange.ipc$dispatch("1152510827", new Object[0])).booleanValue();
        }
        try {
            int Initialize = SecurityInit.Initialize(mu0.a());
            if (Initialize == 0) {
                a = true;
            } else {
                a = false;
            }
            Log.i("AliSecurityHelper", "initAliSecurity:============start code===============" + Initialize);
        } catch (JAQException e) {
            Log.i("AliSecurityHelper", "initAliSecurity:============start===============" + e.getErrorCode());
            e.printStackTrace();
            a = false;
        }
        return a;
    }
}
