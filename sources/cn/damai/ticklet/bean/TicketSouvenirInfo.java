package cn.damai.ticklet.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TicketSouvenirInfo {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String CLOSED = "0";
    private static final String EXCHANGED = "2";
    private static final String NORMAL = "1";
    public String collectMethodNote;
    public String exchangeSiteStatus;
    public String funcNote;
    public String funcTitle;
    public String methodTitle;
    public String openTime;
    public String status;
    public String timeTitle;
    public String topNote;

    private boolean is(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-354444683")) {
            return ((Boolean) ipChange.ipc$dispatch("-354444683", new Object[]{this, str})).booleanValue();
        }
        if (TextUtils.isEmpty(this.status)) {
            return false;
        }
        return this.status.contentEquals(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
        if (r0.equals("2") != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getStateText() {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.ticklet.bean.TicketSouvenirInfo.$ipChange
            java.lang.String r1 = "1936702615"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L17
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r5
            java.lang.Object r0 = r0.ipc$dispatch(r1, r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        L17:
            java.lang.String r0 = r5.status
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L22
            java.lang.String r0 = ""
            return r0
        L22:
            java.lang.String r0 = r5.status
            r1 = -1
            int r2 = r0.hashCode()
            switch(r2) {
                case 48: goto L40;
                case 49: goto L36;
                case 50: goto L2d;
                default: goto L2c;
            }
        L2c:
            goto L4a
        L2d:
            java.lang.String r2 = "2"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L4a
            goto L4b
        L36:
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L4a
            r3 = 1
            goto L4b
        L40:
            java.lang.String r2 = "0"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L4a
            r3 = 2
            goto L4b
        L4a:
            r3 = -1
        L4b:
            if (r3 == 0) goto L4f
            r0 = 0
            return r0
        L4f:
            java.lang.String r0 = "暂无可换"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.ticklet.bean.TicketSouvenirInfo.getStateText():java.lang.String");
    }

    public boolean isClosedState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1608975678") ? ((Boolean) ipChange.ipc$dispatch("-1608975678", new Object[]{this})).booleanValue() : is("0");
    }

    public boolean isNormalState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1965020355") ? ((Boolean) ipChange.ipc$dispatch("-1965020355", new Object[]{this})).booleanValue() : is("1");
    }
}
