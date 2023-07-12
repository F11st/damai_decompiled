package tb;

import android.text.TextUtils;
import com.taobao.android.sopatch.core.SoPatchLogic;
import com.taobao.android.sopatch.core.SoPatchLogicImpl2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ke2 {
    private SoPatchLogic a = new SoPatchLogicImpl2();
    private ge2 b;
    private ge2 c;

    private ge2 a(String str) {
        String c = pc1.c(str);
        ob1.b("SoPatchLauncher", "remote md5", c);
        ge2 ge2Var = this.c;
        if (ge2Var == null) {
            ob1.b("SoPatchLauncher", "configure == null");
            ge2Var = this.b;
        }
        if (!TextUtils.isEmpty(c) && (ge2Var == null || !TextUtils.equals(ge2Var.d(), c))) {
            je2.c().a();
            ge2Var = new jh2().transfer(str);
            if (ge2Var != null) {
                ge2Var.g(c);
            } else {
                ob1.b("SoPatchLauncher", " new configure == null");
            }
            fe2.a(ge2Var);
        }
        return ge2Var;
    }

    public void b(String str) {
        ob1.b("SoPatchLauncher", "update  so patch data", str);
        ge2 a = a(str);
        if (a == null || a == this.c) {
            return;
        }
        ob1.b("SoPatchLauncher", "receiver from remote");
        a.h("remote");
        this.c = a;
        this.a.loadRemotePatch(a);
    }
}
