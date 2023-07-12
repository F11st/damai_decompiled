package tb;

import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class s82 extends v92 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BRANCH_NAME_SEAT = "seat";
    public static final String DEFAULT_ERROR_INFO = "unknown";
    public static final String ORDER_SESSION_STATE_ERROR_CODE = "-4000";
    public static final String ORDER_SESSION_STATE_ERROR_MSG = "项目场次状态异常";
    public static final String SEAT_CALC_TICKET_API_CODE = "-4039";
    public static final String SEAT_CALC_TICKET_API_MSG = "算价接口请求异常";
    public static final String SEAT_DYNAMIC_API_CODE = "-4036";
    public static final String SEAT_DYNAMIC_API_MSG = "麒麟动态接口请求异常";
    public static final String SEAT_FIRST_PAY_AFTER_CHOOSE_ERROR_CODE = "-4032";
    public static final String SEAT_FIRST_PAY_AFTER_CHOOSE_ERROR_MSG = "先付后选补选座失败";
    public static final String SEAT_REGION_COLOR_DATA_ERROR_CODE = "-4012";
    public static final String SEAT_REGION_COLOR_DATA_ERROR_MSG = "看台颜色数据异常";
    public static final String SEAT_REGION_JPG_IMG_ERROR_CODE = "-4013";
    public static final String SEAT_REGION_JPG_IMG_ERROR_MSG = "JPG场馆图下载失败";
    public static final String SEAT_REGION_JPG_IMG_PARSE_ERROR_CODE = "-4015";
    public static final String SEAT_REGION_JPG_IMG_PARSE_ERROR_MSG = "JPG解码错误";
    public static final String SEAT_REGION_STATUS_DATA_ERROR_CODE = "-4011";
    public static final String SEAT_REGION_STATUS_DATA_ERROR_MSG = "看台状态数据异常";
    public static final String SEAT_REGION_SVG_IMG_DATA_ERROR_CODE = "-4018";
    public static final String SEAT_REGION_SVG_IMG_DATA_ERROR_MSG = "SVG图业务数据错误";
    public static final String SEAT_REGION_SVG_IMG_ERROR_CODE = "-4014";
    public static final String SEAT_REGION_SVG_IMG_ERROR_MSG = "SVG场馆图下载失败";
    public static final String SEAT_REGION_SVG_IMG_PARSE_ERROR_CODE = "-4016";
    public static final String SEAT_REGION_SVG_IMG_PARSE_ERROR_MSG = "SVG解析失败";
    public static final String SEAT_STATE_COMPRESS_MISMATCH = "-4035";
    public static final String SEAT_STATE_COMPRESS_MISMATCH_MSG = "动态压缩座位数量与状态数量不匹配";
    public static final String SEAT_STATIC_DATA_ERROR_CODE = "-4030";
    public static final String SEAT_STATIC_DATA_ERROR_MSG = "座位静态数据异常";
    public static final String SEAT_STATUS_DATA_ERROR_CODE = "-4031";
    public static final String SEAT_STATUS_DATA_ERROR_MSG = "座位状态数据异常";
    public static final String SVG_VIEW_DRAW_ERROR_CODE = "-4042";
    public static final String SVG_VIEW_DRAW_ERROR_MSG = "RegionSeatView绘制异常";

    public static String c(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "971365952")) {
            return (String) ipChange.ipc$dispatch("971365952", new Object[]{str, str2, str3, str4, str5});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("seat");
        sb.append(":jsondata={imgUrl:");
        sb.append(str);
        sb.append(",projectId:" + str4);
        sb.append(",performId:" + str5);
        sb.append(",appVersion:" + AppConfig.q());
        sb.append(",retCode:" + str2);
        sb.append(",retMsg:" + str3);
        sb.append("}");
        return sb.toString();
    }
}
