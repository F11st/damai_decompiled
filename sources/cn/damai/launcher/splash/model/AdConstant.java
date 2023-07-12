package cn.damai.launcher.splash.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class AdConstant {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CODE_AD_FILE_2_DRAWABLE_FAIL = 4;
    public static final int CODE_AD_IMG_DOWNLOAD_FAIL = 3;
    public static final int CODE_AD_IMG_DOWNLOAD_TIME_OUT_PRESET = 5;
    public static final int CODE_AD_MTOP_REQUEST_FAIL = 2;
    public static final int CODE_AD_MTOP_TIME_OUT_PRESET = 6;
    public static final int CODE_AD_NONE_CONFIG = 1;
    public static final String CODE_UNKOWN = "-1";
    public static final String MSG_AD_IMG_DOWNLOAD_TIME_OUT_PRESET = "广告文件下载超过限定时长";
    public static final String MSG_AD_IMG_FILE_UN_VALID = "广告文件异常";
    public static final String MSG_AD_MTOP_TIME_OUT_PRESET = "广告mtop请求超过限定时长";
    public static final int TIMEOUT_DOWNLOAD_SPLASH_IMAGE = 2000;
    public static final int TIMEOUT_QUERY_SPLASH = 1000;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface CodeAd {
    }

    public static String code2String(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "436636915")) {
            return (String) ipChange.ipc$dispatch("436636915", new Object[]{Integer.valueOf(i)});
        }
        switch (i) {
            case 1:
                return "CODE_AD_NONE_CONFIG";
            case 2:
                return "CODE_AD_MTOP_REQUEST_FAIL";
            case 3:
                return "CODE_AD_IMG_DOWNLOAD_FAIL";
            case 4:
                return "CODE_AD_FILE_2_DRAWABLE_FAIL";
            case 5:
                return "CODE_AD_IMG_DOWNLOAD_TIME_OUT_PRESET";
            case 6:
                return "CODE_AD_MTOP_TIME_OUT_PRESET";
            default:
                return "";
        }
    }

    public static boolean isCodeNeedClearCache(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1373806603") ? ((Boolean) ipChange.ipc$dispatch("1373806603", new Object[]{Integer.valueOf(i)})).booleanValue() : i == 1 || i == 2 || i == 3 || i == 4;
    }
}
