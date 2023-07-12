package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class gz0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BUSINESS_NAME_HOMEPAGE = "homepage";
    public static final String HOMEPAGE_BANNER_IMAGE_CODE = "-1002";
    public static final String HOMEPAGE_BANNER_IMAGE_MSG = "首页banner图加载失败";
    public static final String HOMEPAGE_BANNER_SCHEMA_CODE = "-1001";
    public static final String HOMEPAGE_BANNER_SCHEMA_MSG = "首页banner点击无法跳转";
    public static final String HOMEPAGE_CHANNEL_FEED_FAIL_CODE = "-1005";
    public static final String HOMEPAGE_CHANNEL_FEED_FAIL_MSG = "首页为你推荐Feed接口加载失败";
    public static final String HOMEPAGE_CHANNEL_IMAGE_CODE = "-1004";
    public static final String HOMEPAGE_CHANNEL_IMAGE_MSG = "首页channel图加载失败";
    public static final String HOMEPAGE_CHANNEL_SCHEMA_CODE = "-1003";
    public static final String HOMEPAGE_CHANNEL_SCHEMA_MSG = "首页channel点击无法跳转";
    public static final String HOMEPAGE_GUESS_TEMPLATE_INFO_FAILURE_CODE = "-10984";
    public static final String HOMEPAGE_GUESS_TEMPLATE_INFO_FAILURE_MSG = "服务端没有在globalSection下发模板信息";
    public static final String HOMEPAGE_NO_DATA_CODE = "-1000";
    public static final String HOMEPAGE_NO_DATA_MSG = "首页不显示（首屏接口)";
    public static final String HOME_BOTTOM_TAB_FEN_WEI_FAIL_CODE = "-1011";
    public static final String HOME_BOTTOM_TAB_FEN_WEI_FAIL_MSG = "首页底部TAB氛围接口下发数据不匹配";
    public static final String HOME_LOTTIE_BITMAP_LOAD_FAIL_CODE = "-1100";
    public static final String HOME_LOTTIE_BITMAP_LOAD_FAIL_MSG = "精选氛围图片加载失败";
    public static final String HOME_LOTTIE_ZIP_DECOMPRESS_FAIL = "-1101";
    public static final String HOME_LOTTIE_ZIP_DECOMPRESS_FAIL_MSG = "zipUrl下载解压失败";
    public static final String NEW_HOME_ATMOSPHERE_DISPLAYED_FAIL_CODE = "-1018";
    public static final String NEW_HOME_ATMOSPHERE_DISPLAYED_FAIL_MSG = "新首页氛围展示失败";
    public static final String SPLASH_ADS_CLICK_FAIL_CODE = "-1008";
    public static final String SPLASH_ADS_CLICK_FAIL_MSG = "开机页广告点击跳转失败";
    public static final String SPLASH_ADS_DOWNLOAD_FAIL_CODE = "-1007";
    public static final String SPLASH_ADS_DOWNLOAD_FAIL_MSG = "开机页广告图片下载失败";
    public static final String SPLASH_ADS_QUERY_FAIL_CODE = "-1006";
    public static final String SPLASH_ADS_QUERY_FAIL_MSG = "开机页广告接口解析失败";
    private static boolean a;

    public static String a(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-352848287")) {
            return (String) ipChange.ipc$dispatch("-352848287", new Object[]{str, str2, str3, str4});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("homepage");
        sb.append(":jsondata={apiName: ");
        sb.append(str);
        sb.append(", retCode:");
        sb.append(str2);
        sb.append(", retMsg:");
        sb.append(str3);
        sb.append(", cityId:");
        sb.append(str4);
        sb.append("}");
        b23.a(sb.toString(), HOMEPAGE_CHANNEL_FEED_FAIL_CODE, HOMEPAGE_CHANNEL_FEED_FAIL_MSG);
        return sb.toString();
    }

    public static void b(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-874688923")) {
            ipChange.ipc$dispatch("-874688923", new Object[]{str, str2});
        } else if (a) {
        } else {
            a = true;
            b23.a("homepage:jsondata={retCode:-1100, retMsg:" + str + ", lottieUrl:" + str2 + ", cityId:" + z20.c() + "}", "-1100", HOME_LOTTIE_BITMAP_LOAD_FAIL_MSG);
        }
    }

    public static void c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2038409097")) {
            ipChange.ipc$dispatch("-2038409097", new Object[]{str});
            return;
        }
        b23.a("homepage:jsondata={retCode:-1011, retMsg:" + str + ", cityId:" + z20.c() + "}", "-1011", HOME_BOTTOM_TAB_FEN_WEI_FAIL_MSG);
    }

    public static String d(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-272774188")) {
            return (String) ipChange.ipc$dispatch("-272774188", new Object[]{str, str2, str3, str4});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("homepage");
        sb.append(":jsondata={apiName: ");
        sb.append(str);
        sb.append(", retCode:");
        sb.append(str2);
        sb.append(", retMsg:");
        sb.append(str3);
        sb.append(", cityId:");
        sb.append(str4);
        sb.append("}");
        b23.a(sb.toString(), "-1000", "首页不显示（首屏接口)");
        return sb.toString();
    }

    public static void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1290337919")) {
            ipChange.ipc$dispatch("1290337919", new Object[]{str, str2});
            return;
        }
        b23.a("homepage:jsondata={retCode:" + HOME_LOTTIE_ZIP_DECOMPRESS_FAIL + ", retMsg:" + str2 + ", zipUrl:" + str + ", cityId:" + z20.c() + "}", HOME_LOTTIE_ZIP_DECOMPRESS_FAIL, HOME_LOTTIE_ZIP_DECOMPRESS_FAIL_MSG);
    }
}
