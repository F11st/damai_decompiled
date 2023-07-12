package tb;

import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.constants.LoginConstants;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class wb1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static boolean a;

    public void a(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-636948285")) {
            ipChange.ipc$dispatch("-636948285", new Object[]{this, str, str2, str3, str4, str5});
            return;
        }
        if (!a) {
            a = true;
            p3.c("damai_login", "damai_login_stat", null, DimensionSet.create().addDimension("errorCode").addDimension("errorMsg").addDimension(LoginConstants.LOGIN_FROM).addDimension(LoginConstants.LOGIN_TYPE).addDimension("loginResult"));
        }
        DimensionValueSet create = DimensionValueSet.create();
        create.setValue("errorCode", str3);
        create.setValue("errorMsg", str4);
        create.setValue(LoginConstants.LOGIN_FROM, str);
        create.setValue(LoginConstants.LOGIN_TYPE, str2);
        create.setValue("loginResult", str5);
        p3.b("damai_login", "damai_login_stat", create, null);
    }
}
