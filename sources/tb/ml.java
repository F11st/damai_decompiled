package tb;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.util.C0241c;
import cn.damai.common.AppConfig;
import cn.damai.common.user.C0528b;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.device.UTDevice;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ml extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ml b;

    public static ml g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1602090379")) {
            return (ml) ipChange.ipc$dispatch("-1602090379", new Object[0]);
        }
        if (b == null) {
            b = new ml();
        }
        return b;
    }

    public Map<String, String> f(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "151686371")) {
            return (Map) ipChange.ipc$dispatch("151686371", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("tel", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("usercode", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("titlelabel", str3);
        }
        return hashMap;
    }

    public Map<String, String> h(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1781584567")) {
            return (Map) ipChange.ipc$dispatch("1781584567", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            hashMap.put("contentlabel", str2 + "^" + str3);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("titlelabel", str);
        }
        return hashMap;
    }

    public Map<String, String> i(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1865962290")) {
            return (Map) ipChange.ipc$dispatch("-1865962290", new Object[]{this, context, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Ostype", "android");
        hashMap.put("utdid", UTDevice.getUtdid(context));
        hashMap.put("model", Build.getMODEL());
        hashMap.put("version", AppConfig.q());
        hashMap.put("deviceid", C0241c.c(context));
        hashMap.put(AgooConstants.MESSAGE_FLAG, str2);
        hashMap.put("type", str);
        hashMap.put("errorCode", str3);
        return hashMap;
    }
}
