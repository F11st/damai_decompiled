package tb;

import android.text.TextUtils;
import android.view.View;
import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class bh extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static bh b = null;
    public static String c = "category";
    public static String d = "category";

    public static void f(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1053783500")) {
            ipChange.ipc$dispatch("-1053783500", new Object[]{str, str2, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("titlelabel", str2);
        bh m = m();
        cn.damai.common.user.c.e().x(m.e(str, "top", "tab_item_" + i, hashMap, Boolean.TRUE));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r5.equals("pinpai") == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String g(java.lang.String r5) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = tb.bh.$ipChange
            java.lang.String r1 = "-2109897967"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L17
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r5
            java.lang.Object r5 = r0.ipc$dispatch(r1, r2)
            java.lang.String r5 = (java.lang.String) r5
            return r5
        L17:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L1e
            return r5
        L1e:
            r5.hashCode()
            r0 = -1
            int r1 = r5.hashCode()
            java.lang.String r2 = "category"
            switch(r1) {
                case -988144925: goto L42;
                case -703049414: goto L36;
                case 50511102: goto L2d;
                default: goto L2b;
            }
        L2b:
            r3 = -1
            goto L4c
        L2d:
            boolean r1 = r5.equals(r2)
            if (r1 != 0) goto L34
            goto L2b
        L34:
            r3 = 2
            goto L4c
        L36:
            java.lang.String r1 = "zhekou"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L40
            goto L2b
        L40:
            r3 = 1
            goto L4c
        L42:
            java.lang.String r1 = "pinpai"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L4c
            goto L2b
        L4c:
            switch(r3) {
                case 0: goto L54;
                case 1: goto L51;
                case 2: goto L50;
                default: goto L4f;
            }
        L4f:
            return r5
        L50:
            return r2
        L51:
            java.lang.String r5 = "discount"
            return r5
        L54:
            java.lang.String r5 = "category_brand"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.bh.g(java.lang.String):java.lang.String");
    }

    public static bh m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2001398363")) {
            return (bh) ipChange.ipc$dispatch("2001398363", new Object[0]);
        }
        if (b == null) {
            b = new bh();
        }
        return b;
    }

    public a.b h(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1351023631") ? (a.b) ipChange.ipc$dispatch("-1351023631", new Object[]{this, str}) : new a.b().i(g(str));
    }

    public a.b i(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831598381")) {
            return (a.b) ipChange.ipc$dispatch("-1831598381", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        hashMap.put("city", str2);
        return e(g(c), "select", "citysbtn", hashMap, Boolean.FALSE);
    }

    public a.b j(int i, int i2, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "759069689")) {
            return (a.b) ipChange.ipc$dispatch("759069689", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        hashMap.put("physical_city", str2);
        return e(g(c), "citys_" + i, "filter_city_" + i2, hashMap, Boolean.FALSE);
    }

    public a.b k(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "578684310")) {
            return (a.b) ipChange.ipc$dispatch("578684310", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        hashMap.put("time_type", str2);
        return e(g(c), "select", "timerange", hashMap, Boolean.FALSE);
    }

    public a.b l(int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064321395")) {
            return (a.b) ipChange.ipc$dispatch("-1064321395", new Object[]{this, Integer.valueOf(i), str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        hashMap.put("time_type", str2);
        hashMap.put("time_name", str3);
        String g = g(c);
        return e(g, "selectbtn", "timerange_" + i, hashMap, Boolean.FALSE);
    }

    public a.b n(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1259141950")) {
            return (a.b) ipChange.ipc$dispatch("1259141950", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        String g = g(c);
        return e(g, "categoryselect", "categoryselect_" + i, hashMap, Boolean.FALSE);
    }

    public a.b o(int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1833821059")) {
            return (a.b) ipChange.ipc$dispatch("-1833821059", new Object[]{this, Integer.valueOf(i), str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        hashMap.put("sorttype_name", str2);
        hashMap.put("sorttype_id", str3);
        String g = g(c);
        return e(g, "selectbtn", "sorttype_" + i, hashMap, Boolean.FALSE);
    }

    public a.b p(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-662020600") ? (a.b) ipChange.ipc$dispatch("-662020600", new Object[]{this, str}) : new a.b().i(g(str));
    }

    public a.b q() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-445969153") ? (a.b) ipChange.ipc$dispatch("-445969153", new Object[]{this}) : e(g(c), "top", "search", null, Boolean.TRUE);
    }

    public a.b r(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1408986193")) {
            return (a.b) ipChange.ipc$dispatch("-1408986193", new Object[]{this, Integer.valueOf(i), str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("item_id", str2);
        }
        String g = g(c);
        return e(g, "xiannv_mustsee", "item_" + i, hashMap, Boolean.TRUE);
    }

    public void s(View view, int i, String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-735709803")) {
            ipChange.ipc$dispatch("-735709803", new Object[]{this, view, Integer.valueOf(i), str, str2, str3, str4});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("item_id", str2);
        }
        hashMap.put("card_type", str3);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("alg", str4);
        }
        cn.damai.common.user.c e = cn.damai.common.user.c.e();
        e.G(view, "item_" + i, "categorylist", g(c), hashMap);
    }
}
