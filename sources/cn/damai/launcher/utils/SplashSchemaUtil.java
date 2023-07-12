package cn.damai.launcher.utils;

import android.net.Uri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SplashSchemaUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_SPECIAL_MODE = "specialMode";

    public static boolean a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-466647508")) {
            return ((Boolean) ipChange.ipc$dispatch("-466647508", new Object[]{str})).booleanValue();
        }
        if (str != null) {
            try {
                if ("true".equalsIgnoreCase(Uri.parse(str).getQueryParameter(KEY_SPECIAL_MODE))) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
