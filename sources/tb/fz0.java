package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class fz0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BUSINESS_NAME_HOMEPAGE = "homepage";
    public static final String HOMEPAGE_BANNER_IMAGE_CODE = "-1002";
    public static final String HOMEPAGE_BANNER_IMAGE_MSG = "首页banner图加载失败";
    public static final String HOMEPAGE_BANNER_SCHEMA_CODE = "-1001";
    public static final String HOMEPAGE_BANNER_SCHEMA_MSG = "首页banner点击无法跳转";
    public static final String HOMEPAGE_CHANNEL_IMAGE_CODE = "-1004";
    public static final String HOMEPAGE_CHANNEL_IMAGE_MSG = "首页channel图加载失败";
    public static final String HOMEPAGE_CHANNEL_SCHEMA_CODE = "-1003";
    public static final String HOMEPAGE_CHANNEL_SCHEMA_MSG = "首页channel点击无法跳转";
    public static final String HOMEPAGE_GUESS_TEMPLATE_INFO_FAILURE_CODE = "-10984";
    public static final String HOMEPAGE_GUESS_TEMPLATE_INFO_FAILURE_MSG = "服务端没有在globalSection下发模板信息";
    public static final String HOMEPAGE_NO_DATA_CODE = "-1000";
    public static final String HOMEPAGE_NO_DATA_MSG = "首页不显示（首屏接口)";

    public static String a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "53198805")) {
            return (String) ipChange.ipc$dispatch("53198805", new Object[0]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("homepage");
        sb.append(":jsondata={retCode:");
        sb.append("-1001");
        sb.append(", retMsg:");
        sb.append("首页banner点击无法跳转");
        sb.append(", cityId:");
        sb.append(z20.c());
        sb.append(", actionUrl:");
        sb.append("");
        sb.append("}");
        b23.a(sb.toString(), "-1001", "首页banner点击无法跳转");
        return sb.toString();
    }
}
