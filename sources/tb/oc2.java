package tb;

import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class oc2 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DISCOUNT_TICKET_PAGE = "discount";
    private static oc2 b;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
        if (r5.equals("pinpai") == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String f(java.lang.String r5) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = tb.oc2.$ipChange
            java.lang.String r1 = "-369028029"
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
                case -988144925: goto L41;
                case -703049414: goto L36;
                case 50511102: goto L2d;
                default: goto L2b;
            }
        L2b:
            r3 = -1
            goto L4a
        L2d:
            boolean r1 = r5.equals(r2)
            if (r1 != 0) goto L34
            goto L2b
        L34:
            r3 = 2
            goto L4a
        L36:
            java.lang.String r1 = "zhekou"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L3f
            goto L2b
        L3f:
            r3 = 1
            goto L4a
        L41:
            java.lang.String r1 = "pinpai"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L4a
            goto L2b
        L4a:
            switch(r3) {
                case 0: goto L52;
                case 1: goto L4f;
                case 2: goto L4e;
                default: goto L4d;
            }
        L4d:
            return r5
        L4e:
            return r2
        L4f:
            java.lang.String r5 = "discount"
            return r5
        L52:
            java.lang.String r5 = "category_brand"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.oc2.f(java.lang.String):java.lang.String");
    }

    public static oc2 h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1440029157")) {
            return (oc2) ipChange.ipc$dispatch("-1440029157", new Object[0]);
        }
        if (b == null) {
            b = new oc2();
        }
        return b;
    }

    public C0525a.C0527b g(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1545393535") ? (C0525a.C0527b) ipChange.ipc$dispatch("1545393535", new Object[]{this, str}) : new C0525a.C0527b().i(f(str));
    }
}
