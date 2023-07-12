package tb;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class re1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1148994176")) {
            return (String) ipChange.ipc$dispatch("-1148994176", new Object[]{context});
        }
        try {
            return b(context).getString("message_notice_content", "");
        } catch (Exception e) {
            cb1.b("MessageNoticeUtil", e.getMessage());
            return "";
        }
    }

    private static SharedPreferences b(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1817827579") ? (SharedPreferences) ipChange.ipc$dispatch("1817827579", new Object[]{context}) : context.getSharedPreferences("messageNotice", 0);
    }

    public static boolean c(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-341323788")) {
            return ((Boolean) ipChange.ipc$dispatch("-341323788", new Object[]{context, str, str2})).booleanValue();
        }
        try {
            return a(context).equals(String.format("%1$s%2$s", str, str2));
        } catch (Exception e) {
            cb1.b("MessageNoticeUtil", e.getMessage());
            return false;
        }
    }

    public static void d(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2050540739")) {
            ipChange.ipc$dispatch("-2050540739", new Object[]{context, str, str2});
            return;
        }
        try {
            SharedPreferences.Editor edit = b(context).edit();
            edit.putString("message_notice_content", String.format("%1$s%2$s", str, str2));
            edit.commit();
        } catch (Exception e) {
            cb1.b("MessageNoticeUtil", e.getMessage());
        }
    }
}
