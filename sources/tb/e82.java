package tb;

import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class e82 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BRANCH_NAME = "search";
    public static final String SEARCH_ERROR_CODE = "-1301";
    public static final String SEARCH_ERROR_MSG = "搜索失败";
    public static final String SEARCH_HOT_WORD_ERROR_CODE = "-1300";
    public static final String SEARCH_HOT_WORD_ERROR_MSG = "热搜词加载失败";

    public static String a(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1634639897")) {
            return (String) ipChange.ipc$dispatch("-1634639897", new Object[]{str, str2, str3, str4});
        }
        StringBuilder sb = new StringBuilder();
        sb.delete(0, sb.length());
        sb.append("search");
        sb.append(":jsondata={apiName:");
        sb.append(str);
        sb.append(", retCode:");
        sb.append(str2);
        sb.append("，retMsg:");
        sb.append("App版本(" + AppConfig.r() + jn1.BRACKET_END_STR + str3);
        sb.append(", cityId:");
        sb.append(str4);
        sb.append("}");
        return sb.toString();
    }

    public static String b(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1354243912")) {
            return (String) ipChange.ipc$dispatch("1354243912", new Object[]{str, str2, str3, str4, str5});
        }
        StringBuilder sb = new StringBuilder();
        sb.delete(0, sb.length());
        sb.append("search");
        sb.append(":jsondata={apiName:");
        sb.append(str);
        sb.append("，retCode:");
        sb.append(str2);
        sb.append(", retMsg:");
        sb.append("App版本(" + AppConfig.r() + jn1.BRACKET_END_STR + str3);
        sb.append(", cityId:");
        sb.append(str4);
        sb.append(", keyWord:");
        sb.append(str5);
        sb.append("}");
        return sb.toString();
    }
}
