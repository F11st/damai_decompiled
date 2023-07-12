package tb;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class z13 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String a = "damai-android";
    public static String b = "failureMonitor";

    public static void a(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1518736236")) {
            ipChange.ipc$dispatch("1518736236", new Object[]{str, str2, str3});
        } else if (AppInfoProviderProxy.isDebuggable()) {
        } else {
            try {
                AppMonitor.Alarm.commitFail(a, b, str, str2, str3);
                c(a, b, str, str2, str3, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String b(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "993275361")) {
            return (String) ipChange.ipc$dispatch("993275361", new Object[]{str, str2, str3, str4, str5});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.BLOCK_START_STR);
        if (!TextUtils.isEmpty(str)) {
            sb.append(" api:" + str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(", apiName:" + str2);
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append(AVFSCacheConstants.COMMA_SEP + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(", retCode:" + str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(", retMsg:" + str4);
        }
        sb.append(" }");
        return sb.toString();
    }

    private static void c(String str, String str2, String str3, String str4, String str5, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-144521175")) {
            ipChange.ipc$dispatch("-144521175", new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z)});
            return;
        }
        try {
            xi2.a(str, str2, str3, str4, str5, z);
        } catch (Exception unused) {
        }
    }
}
