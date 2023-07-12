package cn.damai.launcher.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.b23;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SplashXFlushHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BUSINESS_NAME_HOMEPAGE = "homepage";
    public static final String BUSINESS_NAME_MONITORPOINT = "homepage_splash";
    public static final String SPLASH_ADS_CLICK_API_NAME = "app.splash.click";
    public static final String SPLASH_ADS_CLICK_FAIL_CODE = "-1008";
    public static final String SPLASH_ADS_CLICK_FAIL_MSG = "开机页广告点击跳转失败";
    public static final String SPLASH_ADS_DOWNLOAD_API_NAME = "app.splash.download";
    public static final String SPLASH_ADS_DOWNLOAD_FAIL_CODE = "-1007";
    public static final String SPLASH_ADS_DOWNLOAD_FAIL_MSG = "开机页广告图片下载失败";
    public static final String SPLASH_ADS_QUERY_FAIL_CODE = "-1006";
    public static final String SPLASH_ADS_QUERY_FAIL_MSG = "开机页广告接口解析失败";
    public static final String SPLASH_GUIDE_RETRY_TIME_CODE0 = "-1010";
    public static final String SPLASH_GUIDE_RETRY_TIME_CODE1 = "-1011";
    public static final String SPLASH_GUIDE_RETRY_TIME_CODE2 = "-1012";
    public static final String SPLASH_GUIDE_RETRY_TIME_CODE3 = "-1013";
    public static final String SPLASH_GUIDE_RETRY_TIME_CODE4 = "-1014";
    public static final String SPLASH_GUIDE_RETRY_TIME_MSG = "引导页请求";
    public static final String START_LOCATION_FAIL_CODE = "-1020";
    public static final String START_LOCATION_FAIL_MSG = "定位失败，errCode查高德文档";

    public static void a(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2008249980")) {
            ipChange.ipc$dispatch("2008249980", new Object[]{str, str2, str3});
            return;
        }
        try {
            b23.a("homepage:jsondata={apiName: " + SPLASH_ADS_CLICK_API_NAME + ", retMsg:" + str + ", schema:" + str3 + ", cityId:" + str2 + "}", "-1008", "开机页广告点击跳转失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1189968196")) {
            ipChange.ipc$dispatch("-1189968196", new Object[]{str, str2, str3, str4});
            return;
        }
        try {
            b23.c(b23.a, BUSINESS_NAME_MONITORPOINT, "homepage:jsondata={apiName: " + SPLASH_ADS_DOWNLOAD_API_NAME + ", retCode:" + str + ", retMsg:" + str2 + ", pic:" + str4 + ", cityId:" + str3 + "}", "-1007", "开机页广告图片下载失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1015597390")) {
            ipChange.ipc$dispatch("1015597390", new Object[]{Integer.valueOf(i)});
            return;
        }
        try {
            b23.a("homepage:jsondata={apiName: startLocation, retMsg:" + i + ", tips:retMsg查高德文档, cityId:" + z20.c() + "}", START_LOCATION_FAIL_CODE, START_LOCATION_FAIL_MSG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1174872124")) {
            ipChange.ipc$dispatch("1174872124", new Object[]{str, str2, str3, str4, str5});
            return;
        }
        try {
            b23.a("homepage:jsondata={apiName: " + str + ", retCode:" + str2 + ", retMsg:" + str3 + ", data:" + str4 + ", cityId:" + str5 + "}", "-1006", "开机页广告接口解析失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
