package tb;

import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.constants.LoginConstants;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ew0 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ew0 b;

    private ew0() {
    }

    public static ew0 f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1665564933")) {
            return (ew0) ipChange.ipc$dispatch("-1665564933", new Object[0]);
        }
        if (b == null) {
            synchronized (ew0.class) {
                b = new ew0();
            }
        }
        return b;
    }

    private C0525a.C0527b i(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "670348709")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("670348709", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("after_click", str);
        hashMap.put("page_source", str2);
        hashMap.put("isDialog", str3);
        return e("login", "legal_dialog", "pro_select", hashMap, Boolean.FALSE);
    }

    private C0525a.C0527b j(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340335939")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("340335939", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put(LoginConstants.LOGIN_TYPE, i + "");
        hashMap.put("loginTypeName", LoginManager.k().m());
        hashMap.put("status", str);
        return e("login", "login", "result", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2014225519") ? (C0525a.C0527b) ipChange.ipc$dispatch("-2014225519", new Object[]{this}) : b("login");
    }

    public C0525a.C0527b h(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1437761599")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1437761599", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        return e("login", "bottom", "item_" + i, hashMap, Boolean.FALSE);
    }

    public void k(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "428186599")) {
            ipChange.ipc$dispatch("428186599", new Object[]{this, str, str2, str3});
        } else {
            C0529c.e().x(f().i(str, str2, str3));
        }
    }

    public void l(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686702789")) {
            ipChange.ipc$dispatch("1686702789", new Object[]{this, Integer.valueOf(i), str});
        } else {
            C0529c.e().x(f().j(i, str));
        }
    }
}
