package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ib0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static HashMap<String, String> a = new HashMap<>();
    private static HashMap<String, String> b = new HashMap<>();
    private static String[] c = {"P-10000-11-16-013", "P-10000-11-16-014", "P-10000-11-17-016", "P-10000-11-17-017", "P-10000-11-17-018", "P-10000-11-17-019", "P-10000-11-17-020", "P-10000-11-17-021", "FAIL_SYS_REQUEST_QUEUED"};
    public static String[] d = {"B-00203-200-031", "B-00203-200-005", "F-10003-11-16-001"};
    public static String[] e = {"F-10012-01-16-001"};

    static {
        a.clear();
        a.put("F-10003-11-16-001", "手慢了，票票被抢光了");
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = c;
            if (i2 >= strArr.length) {
                break;
            }
            a.put(strArr[i2], "抱歉，当前排队人数太多啦，实在挤不进去了，请稍后再进行尝试");
            i2++;
        }
        b.clear();
        b.put("F-10003-11-16-001", "手慢了，票票被抢光了");
        while (true) {
            String[] strArr2 = c;
            if (i >= strArr2.length) {
                return;
            }
            b.put(strArr2[i], "亲，同一时间下单人数过多，建议您稍后再试");
            i++;
        }
    }

    public static String a(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "736505813") ? (String) ipChange.ipc$dispatch("736505813", new Object[]{str}) : (!TextUtils.isEmpty(str) && a.containsKey(str)) ? a.get(str) : "";
    }

    public static String b(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1833176939") ? (String) ipChange.ipc$dispatch("1833176939", new Object[]{str}) : (!TextUtils.isEmpty(str) && b.containsKey(str)) ? b.get(str) : "";
    }
}
