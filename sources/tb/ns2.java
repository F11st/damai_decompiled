package tb;

import android.text.TextUtils;
import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ns2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean a;

    /* compiled from: Taobao */
    /* renamed from: tb.ns2$b */
    /* loaded from: classes4.dex */
    private static class C9483b {
        private static final ns2 a = new ns2();
    }

    public static ns2 a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-750495027") ? (ns2) ipChange.ipc$dispatch("-750495027", new Object[0]) : C9483b.a;
    }

    private void b(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1292794065")) {
            ipChange.ipc$dispatch("-1292794065", new Object[]{this, str, str2});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        C0529c.e().E(str, z20.i());
        C0529c.e().A(ml.g().f(str, str2, null), xb1.CUSTOM_LOGIN, "login");
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1602376519")) {
            ipChange.ipc$dispatch("1602376519", new Object[]{this});
        } else if (this.a) {
        } else {
            this.a = true;
            String r = z20.r();
            String F = z20.F();
            if (TextUtils.isEmpty(F)) {
                return;
            }
            String a = v20.a(F);
            if (TextUtils.isEmpty(a) || !a.contains("|")) {
                return;
            }
            String[] split = a.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
            if (split.length > 1) {
                b(r, split[1]);
            }
        }
    }

    private ns2() {
        this.a = false;
    }
}
