package tb;

import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class y13 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BRANCH_DRAMA = "drama_home";
    public static final String BRANCH_MUSIC = "music_festival";
    public static final String BRANCH_WEB = "web_fragment";
    public static final String BRANCH_WEB_URL_APPEND_ERROR_CODE = "-4700";
    public static final String BRANCH_WEB_URL_APPEND_ERROR_MSG = "url拼接异常";
    public static final String DRAMA_HOME_API_ERROR_CODE = "-4600";
    public static final String DRAMA_HOME_API_ERROR_MSG = "话剧音乐剧组件化接口异常";
    public static final String MUSIC_FESTIVAL_API_ERROR_CODE = "-4500";
    public static final String MUSIC_FESTIVAL_API_ERROR_MSG = "音乐节首页组件化接口异常";

    public static String a(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "688480970")) {
            return (String) ipChange.ipc$dispatch("688480970", new Object[]{str, str2, str3, str4});
        }
        return str + ":jsondata={apiName:" + str2 + ",appVersion:" + AppConfig.q() + ",retCode:" + str3 + ",retMsg:" + str4 + "}";
    }

    public static void b(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-118219071")) {
            ipChange.ipc$dispatch("-118219071", new Object[]{str, str2, str3});
        } else {
            b23.a(a(BRANCH_WEB, str, str2, str3), BRANCH_WEB_URL_APPEND_ERROR_CODE, BRANCH_WEB_URL_APPEND_ERROR_MSG);
        }
    }

    public static void c(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1852348990")) {
            ipChange.ipc$dispatch("1852348990", new Object[]{str, str2, str3});
        } else {
            b23.a(a(BRANCH_DRAMA, str, str2, str3), DRAMA_HOME_API_ERROR_CODE, DRAMA_HOME_API_ERROR_MSG);
        }
    }

    public static void d(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1051702983")) {
            ipChange.ipc$dispatch("1051702983", new Object[]{str, str2, str3});
        } else {
            b23.a(a("music_festival", str, str2, str3), MUSIC_FESTIVAL_API_ERROR_CODE, MUSIC_FESTIVAL_API_ERROR_MSG);
        }
    }
}
