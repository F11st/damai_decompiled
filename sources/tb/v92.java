package tb;

import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class v92 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BRANCH_NAME_SEAT = "seat";
    public static final String DEFAULT_ERROR_INFO = "unknown";
    public static final String SEAT_REGION_STATIC_DATA_ERROR_CODE = "-4010";
    public static final String SEAT_REGION_STATIC_DATA_ERROR_MSG = "看台静态数据异常";
    public static final String SEAT_REGION_STATIC_DATA_HAS_MISSING_CODE = "-4017";
    public static final String SEAT_REGION_STATIC_DATA_HAS_MISSING_MSG = "看台数据有缺失";
    public static final String SEAT_STATIC_DATA_PARSE_ERROR_CODE = "-4033";
    public static final String SEAT_STATIC_DATA_PARSE_ERROR_MSG = "座位数据解压失败";
    public static final String SEAT_STATIC_DATA_SERIALIZE_ERROR_CODE = "-4037";
    public static final String SEAT_STATIC_DATA_SERIALIZE_ERROR_MSG = "座位静态数据反序列化异常";
    public static final String SEAT_STATIC_DATA_VALIDATE_ERROR_CODE = "-4038";
    public static final String SEAT_STATIC_DATA_VALIDATE_ERROR_MSG = "座位静态数据校验失败";
    public static final String SEAT_SVG_DECRYPT_FAIL_CODE = "-4034";
    public static final String SEAT_SVG_DECRYPT_KEY_MD5_DIFF_MSG = "SafeKey解密的Key_Md5值与原始Key_Md5值不匹配";
    public static final String SEAT_SVG_DECRYPT_MD5_DIFF_MSG = "解密SVG_Md5值与原图Md5值不匹配";
    public static final String SEAT_SVG_NORMAL_PREFIX = "普通选座SVG解密异常";
    public static final String SEAT_SVG_PAY_FIRST_PREFIX = "先付选座SVG解密异常";

    public static String a(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1670948680")) {
            return (String) ipChange.ipc$dispatch("1670948680", new Object[]{str, str2, str3, str4, str5});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("seat");
        sb.append(":jsondata={apiName:");
        sb.append(str);
        sb.append(",projectId:" + str4);
        sb.append(",performId:" + str5);
        sb.append(",appVersion:" + AppConfig.q());
        sb.append(",retCode:" + str2);
        sb.append(",retMsg:" + str3);
        sb.append("}");
        return sb.toString();
    }

    public static String b(String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "69079670")) {
            return (String) ipChange.ipc$dispatch("69079670", new Object[]{str, map});
        }
        if (map == null) {
            map = new HashMap<>();
        }
        return str + ":jsondata=" + m61.e(map);
    }
}
