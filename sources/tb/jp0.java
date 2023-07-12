package tb;

import android.annotation.TargetApi;
import java.util.List;

/* compiled from: Taobao */
@TargetApi(11)
/* loaded from: classes2.dex */
public class jp0 {
    public static st1 a(List<st1> list, int i) {
        st1 st1Var;
        if (i >= 0 && i <= list.size() - 1) {
            return list.get(i);
        }
        st1 st1Var2 = new st1();
        if (i < 0) {
            st1Var = list.get(0);
        } else {
            i = (i - list.size()) + 1;
            st1Var = list.get(list.size() - 1);
        }
        st1Var2.a = st1Var.a + (st1Var.b() * i);
        st1Var2.b = st1Var.b;
        st1Var2.c = st1Var.c + (st1Var.b() * i);
        st1Var2.d = st1Var.d;
        st1Var2.e = st1Var.e + (st1Var.b() * i);
        st1Var2.f = st1Var.f;
        st1Var2.g = st1Var.g + (i * st1Var.b());
        st1Var2.h = st1Var.h;
        return st1Var2;
    }
}
