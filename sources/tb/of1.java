package tb;

import com.alibaba.appmonitor.offline.TempEventMgr;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class of1 {
    private static of1 b;
    public List<nf1> a;

    private of1(int i) {
        this.a = new ArrayList(i);
    }

    public static of1 c() {
        if (b == null) {
            b = new of1(3);
        }
        return b;
    }

    public void a(nf1 nf1Var) {
        if (this.a.contains(nf1Var)) {
            this.a.remove(nf1Var);
        }
        this.a.add(nf1Var);
    }

    public nf1 b(String str, String str2) {
        List<nf1> list;
        if (str == null || str2 == null || (list = this.a) == null) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            nf1 nf1Var = this.a.get(i);
            if (nf1Var != null && nf1Var.getModule().equals(str) && nf1Var.c().equals(str2)) {
                return nf1Var;
            }
        }
        nf1 u = TempEventMgr.t().u(str, str2);
        if (u != null) {
            this.a.add(u);
        }
        return u;
    }
}
