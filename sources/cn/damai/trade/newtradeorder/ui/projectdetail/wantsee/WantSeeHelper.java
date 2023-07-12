package cn.damai.trade.newtradeorder.ui.projectdetail.wantsee;

import android.text.TextUtils;
import androidx.core.util.Pair;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectWantSeeBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class WantSeeHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private static WantSeeHelper a;

    WantSeeHelper() {
    }

    public static WantSeeHelper b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1989413203")) {
            return (WantSeeHelper) ipChange.ipc$dispatch("1989413203", new Object[0]);
        }
        if (a == null) {
            synchronized (WantSeeHelper.class) {
                if (a == null) {
                    a = new WantSeeHelper();
                }
            }
        }
        return a;
    }

    public static Pair<String, String> d(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2131976812")) {
            return (Pair) ipChange.ipc$dispatch("2131976812", new Object[]{Long.valueOf(j)});
        }
        if (j <= 99999) {
            return new Pair<>(String.valueOf(j), "人");
        }
        if (j < 100000000) {
            return new Pair<>(String.valueOf(((int) ((((float) j) / 10000.0f) * 10.0f)) / 10.0f), "万人");
        }
        return new Pair<>(String.valueOf(((int) ((((float) j) / 1.0E8f) * 10.0f)) / 10.0f), "亿人");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void e(final android.widget.TextView r7, final java.lang.String r8) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.trade.newtradeorder.ui.projectdetail.wantsee.WantSeeHelper.$ipChange
            java.lang.String r1 = "-848188064"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L17
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r7
            r2[r3] = r8
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            java.lang.Object r0 = r7.getTag()
            if (r0 != 0) goto L49
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r7.setTag(r0)
            boolean r0 = tb.wh2.h(r8)
            if (r0 == 0) goto L42
            r0 = -1
            long r0 = tb.jm1.k(r8, r0)
            r5 = 0
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 <= 0) goto L42
            cn.damai.trade.newtradeorder.ui.projectdetail.wantsee.WantSeeHelper$1 r2 = new cn.damai.trade.newtradeorder.ui.projectdetail.wantsee.WantSeeHelper$1
            r2.<init>()
            r0 = 150(0x96, double:7.4E-322)
            r7.postDelayed(r2, r0)
            goto L43
        L42:
            r3 = 0
        L43:
            if (r3 != 0) goto L4c
            r7.setText(r8)
            goto L4c
        L49:
            r7.setText(r8)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.trade.newtradeorder.ui.projectdetail.wantsee.WantSeeHelper.e(android.widget.TextView, java.lang.String):void");
    }

    public String a(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1813308914")) {
            return (String) ipChange.ipc$dispatch("1813308914", new Object[]{this, Long.valueOf(j)});
        }
        if (j < 10000) {
            return String.valueOf(j);
        }
        if (j < 100000) {
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.setMinimumFractionDigits(1);
            decimalFormat.setMaximumFractionDigits(1);
            decimalFormat.setGroupingSize(0);
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
            return decimalFormat.format(j / 10000.0d) + "万";
        } else if (j < 1000000) {
            DecimalFormat decimalFormat2 = new DecimalFormat();
            decimalFormat2.setMinimumFractionDigits(1);
            decimalFormat2.setMaximumFractionDigits(1);
            decimalFormat2.setGroupingSize(0);
            decimalFormat2.setRoundingMode(RoundingMode.FLOOR);
            return decimalFormat2.format(j / 10000.0d) + "万";
        } else if (j < 10000000) {
            DecimalFormat decimalFormat3 = new DecimalFormat();
            decimalFormat3.setMinimumFractionDigits(0);
            decimalFormat3.setMaximumFractionDigits(0);
            decimalFormat3.setGroupingSize(0);
            decimalFormat3.setRoundingMode(RoundingMode.FLOOR);
            return decimalFormat3.format(j / 10000.0d) + "万";
        } else {
            return "999万";
        }
    }

    public boolean c(ProjectWantSeeBean projectWantSeeBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1804913043")) {
            return ((Boolean) ipChange.ipc$dispatch("1804913043", new Object[]{this, projectWantSeeBean})).booleanValue();
        }
        if (projectWantSeeBean == null) {
            return false;
        }
        return projectWantSeeBean.isShowWant() && !TextUtils.isEmpty(projectWantSeeBean.getWantNumStr());
    }
}
