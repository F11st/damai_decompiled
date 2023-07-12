package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class xv1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String[] a(long j) {
        StringBuilder sb;
        String sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "842335269")) {
            return (String[]) ipChange.ipc$dispatch("842335269", new Object[]{Long.valueOf(j)});
        }
        long j2 = j / 86400;
        long j3 = (j / 3600) % 24;
        long j4 = (j / 60) % 60;
        long j5 = j % 60;
        if (j2 == 0) {
            sb2 = "";
        } else {
            if (j2 < 10) {
                sb = new StringBuilder();
                sb.append("0");
            } else {
                sb = new StringBuilder();
                sb.append("");
            }
            sb.append(j2);
            sb2 = sb.toString();
        }
        if (j3 < 10) {
            sb3 = new StringBuilder();
            sb3.append("0");
        } else {
            sb3 = new StringBuilder();
            sb3.append("");
        }
        sb3.append(j3);
        String sb5 = sb3.toString();
        if (j4 < 10) {
            sb4 = new StringBuilder();
            sb4.append("0");
        } else {
            sb4 = new StringBuilder();
            sb4.append("");
        }
        sb4.append(j4);
        String sb6 = sb4.toString();
        if (j5 < 10) {
            str = "0" + j5;
        } else {
            str = "" + j5;
        }
        return new String[]{sb2, sb5, sb6, str};
    }
}
