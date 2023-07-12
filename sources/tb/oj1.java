package tb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class oj1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String MAIPIAO_SERVICE_ERROR_FRIENDLY = "请稍后重试哦~";
    public static final String MTOP_HEAD_COORDINATES_CONFIG = "mtop_coordinates_list";
    public static final String MTOP_HEAD_COORDINATES_NAME = "dm_mtop_head_coordinates";
    public static final String NO_NET_ERROR = "网络竟然崩溃了";
    public static final String NO_NET_FRIENDLY = "网络不太顺畅哦，请稍后再试吧";
    public static final String SERVICE_ERROR = "服务竟然出错了";
    public static final String SERVICE_ERROR_FRIENDLY = "麦麦开小差了，请稍后重试哦";
    public static final String SYS_LIMIT = "抱歉，当前排队的人数太多啦，请稍后再试哦";
    public static final String SYS_SOLODOUT = "亲，来晚了一步，票被抢光啦";
    private static HashMap<String, String> a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put(e11.FAIL_SYS_TRAFFIC_LIMIT, "抱歉，当前排队的人数太多啦，请稍后再试哦");
        a.put("MAPIE98015", "亲，来晚了一步，票被抢光啦");
        a.put("FAIL_BIZ_PARAM_ERROR", "麦麦开小差了，请稍后重试哦");
        new JSONArray();
    }

    public static String a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-404898020")) {
            return (String) ipChange.ipc$dispatch("-404898020", new Object[]{str, str2});
        }
        if (!TextUtils.isEmpty(str)) {
            if (a.containsKey(str)) {
                return a.get(str);
            }
            return (TextUtils.isEmpty(str2) || "服务竟然出错了".equals(str2)) ? "麦麦开小差了，请稍后重试哦" : "网络竟然崩溃了".endsWith(str2) ? "网络不太顺畅哦，请稍后再试吧" : str2;
        }
        return "麦麦开小差了，请稍后重试哦";
    }
}
