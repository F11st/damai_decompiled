package tb;

import android.text.TextUtils;
import cn.damai.common.user.C0528b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class xb1 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CUSTOM_LOGIN = "logininfo";
    public static final String LOGIN_BINDTEL_PAGE = "bindtel";
    public static final String LOGIN_CODECHECK_PAGE = "codecheck";
    public static final String LOGIN_FASTLOGIN_PAGE = "fastlogin";
    public static final String LOGIN_FINDPWD = "findpassword";
    public static final String LOGIN_PAGE = "login";
    public static final String REGISTER_PAGE = "register";

    /* compiled from: Taobao */
    /* renamed from: tb.xb1$b */
    /* loaded from: classes5.dex */
    private static class C9917b {
        private static final xb1 a = new xb1();
    }

    public static final xb1 g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-198388379") ? (xb1) ipChange.ipc$dispatch("-198388379", new Object[0]) : C9917b.a;
    }

    public Map<String, String> f(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1511479057")) {
            return (Map) ipChange.ipc$dispatch("-1511479057", new Object[]{this, str, str2, str3});
        }
        if (str2 == null || str == null) {
            return null;
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

    private xb1() {
    }
}
