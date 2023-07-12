package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class l91 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static ArrayList<Long> a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-355617037")) {
            return (ArrayList) ipChange.ipc$dispatch("-355617037", new Object[]{str, str2});
        }
        if (str != null && str.length() != 0) {
            String[] split = str.split(str2);
            ArrayList<Long> arrayList = new ArrayList<>();
            for (String str3 : split) {
                arrayList.add(Long.valueOf(Long.valueOf(str3).longValue()));
            }
            return arrayList;
        }
        return new ArrayList<>();
    }

    public static ArrayList<String> b(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-590142402")) {
            return (ArrayList) ipChange.ipc$dispatch("-590142402", new Object[]{str, str2});
        }
        String[] split = str.split(str2);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str3 : split) {
            arrayList.add(str3);
        }
        return arrayList;
    }
}
