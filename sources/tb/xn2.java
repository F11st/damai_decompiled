package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class xn2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BUSINESS_NAME_TICKLET = "ticklet";
    public static final String TICKLET_CONTACT_INTERFACE_ADD_API = "添加观演人";
    public static final String TICKLET_CONTACT_INTERFACE_ERROR_CODE = "-5810";
    public static final String TICKLET_CONTACT_INTERFACE_ERROR_MSG = "观演人接口失败";
    public static final String TICKLET_CONTACT_INTERFACE_LIST_API = "观演人列表";
    public static final String TICKLET_CREAT_TABLE_ERROR_CODE = "-5927";
    public static final String TICKLET_CREAT_TABLE_ERROR_MSG = "判断表不存在后创建表失败";
    public static final String TICKLET_DB_CREAT_TABLE_ERROR_CODE = "-5901";
    public static final String TICKLET_DB_CREAT_TABLE_ERROR_MSG = "数据库创建表失败";
    public static final String TICKLET_DB_DELET_TABLE_ERROR_CODE = "-5922";
    public static final String TICKLET_DB_DELET_TABLE_ERROR_MSG = "数据库删除表失败";
    public static final String TICKLET_DB_DETAIL_PERFORM_INFO_ERROR_CODE = "-5905";
    public static final String TICKLET_DB_DETAIL_PERFORM_INFO_ERROR_MSG = "场次详情场次信息读取失败";
    public static final String TICKLET_DB_DETAIL_PERFORM_TO_RECEIVE_ERROR_CODE = "-5906";
    public static final String TICKLET_DB_DETAIL_PERFORM_TO_RECEIVE_ERROR_MSG = "场次列表待接收票删除失败";
    public static final String TICKLET_DB_DETAIL_TICKETS_INFO_ERROR_CODE = "-5910";
    public static final String TICKLET_DB_DETAIL_TICKETS_INFO_ERROR_MSG = "场次详情票列表读取失败";
    public static final String TICKLET_DB_HOME_HINT_ERROR_CODE = "-5921";
    public static final String TICKLET_DB_HOME_HINT_ERROR_MSG = "首页top获取失败";
    public static final String TICKLET_DB_INIT_ERROR_CODE = "-5900";
    public static final String TICKLET_DB_INIT_ERROR_MSG = "数据库初始化失败";
    public static final String TICKLET_DB_PERFORM_DELETE_READ_ERROR_CODE = "-5919";
    public static final String TICKLET_DB_PERFORM_DELETE_READ_ERROR_MSG = "历史删除场次失败";
    public static final String TICKLET_DB_PERFORM_NO_START_ERROR_CODE = "-5904";
    public static final String TICKLET_DB_PERFORM_NO_START_ERROR_MSG = "场次列表未使用读取失败";
    public static final String TICKLET_DB_PERFORM_SAVE_UPDATE_ERROR_CODE = "-5902";
    public static final String TICKLET_DB_PERFORM_SAVE_UPDATE_ERROR_MSG = "预加载或场次列表插入更新失败";
    public static final String TICKLET_DB_PERFORM_TO_RECEIVE_ERROR_CODE = "-5903";
    public static final String TICKLET_DB_PERFORM_TO_RECEIVE_ERROR_MSG = "场次列表待接收读取失败";
    public static final String TICKLET_DB_TICKET_CARD_READ_ERROR_CODE = "-5912";
    public static final String TICKLET_DB_TICKET_CARD_READ_ERROR_MSG = "票详情取身份证票读取失败";
    public static final String TICKLET_DB_TICKET_DELETE_HISTORY_ERROR_CODE = "-5920";
    public static final String TICKLET_DB_TICKET_DELETE_HISTORY_ERROR_MSG = "历史删除票失败";
    public static final String TICKLET_DB_TICKET_DELETE_TO_RECEIVE_ERROR_CODE = "-5915";
    public static final String TICKLET_DB_TICKET_DELETE_TO_RECEIVE_ERROR_MSG = "票详情删除待接收票失败";
    public static final String TICKLET_DB_TICKET_SAVE_UPDATE_ERROR_CODE = "-5911";
    public static final String TICKLET_DB_TICKET_SAVE_UPDATE_INFO_ERROR_MSG = "票列表数据插入更新失败";
    public static final String TICKLET_DB_TICKET_STATIC_READ_ERROR_CODE = "-5914";
    public static final String TICKLET_DB_TICKET_STATIC_READ_ERROR_MSG = "票详情点击放大静态二维码票读取失败";
    public static final String TICKLET_DB_TICKET_ZOOM_READ_ERROR_CODE = "-5913";
    public static final String TICKLET_DB_TICKET_ZOOM_READ_ERROR_MSG = "票详情点击放大动态二维码票读取失败";
    public static final String TICKLET_DB_VERSION_ACCS_ERROR_CODE = "-5926";
    public static final String TICKLET_DB_VERSION_ACCS_ERROR_MSG = "ACCS更新票状态失败,票号:";
    public static final String TICKLET_DB_VERSION_UPGRADE_ERROR_CODE = "-5923";
    public static final String TICKLET_DB_VERSION_UPGRADE_ERROR_MSG = "数据库版本升级失败";
    public static final String TICKLET_EXCHANGE_LIST_API = "取票点列表";
    public static final String TICKLET_EXCHANGE_LIST_NETWORK_ERROR_CODE = "-5400";
    public static final String TICKLET_EXCHANGE_LIST_NETWORK_ERROR_MSG = "取票点列表接口失败";
    public static final String TICKLET_EXCHANGE_RENDER_API = "取票点列表渲染失败";
    public static final String TICKLET_EXCHANGE_RENDER_ERROR_CODE = "-5401";
    public static final String TICKLET_EXCHANGE_RENDER_ERROR_MSG = "取票点列表渲染失败";
    public static final String TICKLET_FLOAT_BRING_DATA_ERROR_MSG = "取票凭证浮层数据获取失败";
    public static final String TICKLET_FLOAT_DETAIL_NETWORK_ERROR_MSG = "场次详情";
    public static final String TICKLET_FLOAT_GESTURE_NETWORK_ERROR_MSG = "手势验票";
    public static final String TICKLET_FLOAT_NETWORK_ERROR_CODE = "-5200";
    public static final String TICKLET_FLOAT_NETWORK_ERROR_MSG = "取票凭证浮层接口失败";
    public static final String TICKLET_FLOAT_NETWORK_ERROR_MSG_LIST = "取票凭证浮层接口失败-来自场次列表";
    public static final String TICKLET_FLOAT_NETWORK_ERROR_MSG_NOT_LIST = "取票凭证浮层接口失败-非场次列表";
    public static final String TICKLET_FLOAT_RENDER_CODE_MSG = "漂浮层渲染失败";
    public static final String TICKLET_FLOAT_RENDER_DYNAMIC_CODE_MSG = "动态电子票二维码渲染失败";
    public static final String TICKLET_FLOAT_RENDER_DYNAMIC_ERROR_CODE = "-5202";
    public static final String TICKLET_FLOAT_RENDER_ERROR_CODE = "-5201";
    public static final String TICKLET_FLOAT_RENDER_GESTURE_ERROR_CODE = "-5205";
    public static final String TICKLET_FLOAT_RENDER_GESTURE_MSG = "手势验票渲染失败";
    public static final String TICKLET_FLOAT_RENDER_STATIC_ERROR_CODE = "-5203";
    public static final String TICKLET_NFT_RECEIVE_ERROR_CODE = "-5600";
    public static final String TICKLET_NFT_RECEIVE_ERROR_MSG = "NFT票-NFT领取接口-领取失败";
    public static final String TICKLET_NFT_RECEIVE_SOURCE_ERROR_CODE = "-5601";
    public static final String TICKLET_NFT_RECEIVE_SOURCE_ERROR_MSG = "NFT票-NFT领取接口-资源错误";
    public static final String TICKLET_NFT_RECEIVE_STATE_ERROR_CODE = "-5602";
    public static final String TICKLET_NFT_RECEIVE_STATE_ERROR_MSG = "NFT票-NFT领取接口-状态不一致";
    public static final String TICKLET_PERFORM_DETAIL_CODE_POINT = "member_detail_code_fail";
    public static final String TICKLET_PERFORM_DETAIL_HISTORY_RENDER_FAIL = "票夹历史场次详情渲染失败";
    public static final String TICKLET_PERFORM_DETAIL_NETWORK_ERROR_CODE = "-5100";
    public static final String TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG = "票夹场次详情接口失败";
    public static final String TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG_DETAIL = "场次详情";
    public static final String TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG_FACE_BIND = "人脸绑定";
    public static final String TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG_FACE_BIND_FAIL = "绑定接口成功,但绑定失败";
    public static final String TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG_FACE_GET = "人脸采集";
    public static final String TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG_FACE_GET_FAIL = "人脸采集失败";
    public static final String TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG_FACE_UNBIND = "人脸解绑";
    public static final String TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG_FACE_UNBIND_FAIL = "解绑接口成功,但解绑失败";
    public static final String TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG_FORGET_CARD = "忘带身份证";
    public static final String TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG_HISTORY_DETAIL = "历史场次详情";
    public static final String TICKLET_PERFORM_DETAIL_RENDER_BIND_FAIL_MSG = "人脸绑定数据data null";
    public static final String TICKLET_PERFORM_DETAIL_RENDER_DATA_FAIL_MSG = "票详情接口成功但是返回data数据为null";
    public static final String TICKLET_PERFORM_DETAIL_RENDER_DYNAMIC_CODE_DRAW_FAIL = "动态二维码绘制失败";
    public static final String TICKLET_PERFORM_DETAIL_RENDER_DYNAMIC_CODE_MSG = "动态电子票二维码渲染失败";
    public static final String TICKLET_PERFORM_DETAIL_RENDER_DYNAMIC_CODE_NULL = "voucherCode为null";
    public static final String TICKLET_PERFORM_DETAIL_RENDER_DYNAMIC_ERROR_CODE = "-5102";
    public static final String TICKLET_PERFORM_DETAIL_RENDER_ERROR_CODE = "-5101";
    public static final String TICKLET_PERFORM_DETAIL_RENDER_FAIL = "票夹场次详情渲染失败";
    public static final String TICKLET_PERFORM_DETAIL_RENDER_FAIL_MSG = "票夹场次详情渲染失败";
    public static final String TICKLET_PERFORM_DETAIL_RENDER_IMEI_CODE_MSG = "串码票-票码为空";
    public static final String TICKLET_PERFORM_DETAIL_RENDER_IMEI_ERROR_CODE = "-5104";
    public static final String TICKLET_PERFORM_DETAIL_RENDER_POINT = "member_detail_render_fail";
    public static final String TICKLET_PERFORM_DETAIL_RENDER_STATIC_CODE_MSG = "静态二维码加载失败";
    public static final String TICKLET_PERFORM_DETAIL_RENDER_STATIC_ERROR_CODE = "-5103";
    public static final String TICKLET_PERFORM_DETAIL_RENDER_TICKLET_LIST_FAIL_MSG = "票详情接口返回票列表数据为null";
    public static final String TICKLET_PERFORM_DETAIL_RENDER_UNBIND_FAIL_MSG = "人脸解绑数据data null";
    public static final String TICKLET_PERFORM_DETAIL_REQUEST_POINT = "member_detail_request";
    public static final String TICKLET_PERFORM_DETAIL_STATIC_CODE_POINT = "member_detail_static_code";
    public static final String TICKLET_PERFORM_FACE_COMPARE_CODE = "-5105";
    public static final String TICKLET_PERFORM_FACE_COMPARE_FAIL = "人脸比对失败";
    public static final String TICKLET_PERFORM_FACE_GET_QR_CODE = "-5106";
    public static final String TICKLET_PERFORM_FACE_QR_FAIL = "比对人脸获取二维码失败";
    public static final String TICKLET_PERFORM_FLOAT_RENDER_DYNAMIC_CODE_DRAW_FAIL = "动态二维码绘制失败";
    public static final String TICKLET_PERFORM_FLOAT_RENDER_DYNAMIC_CODE_NULL = "voucherCode为null";
    public static final String TICKLET_PERFORM_FLOAT_RENDER_IMEI_CODE_MSG = "串码票-票码为空";
    public static final String TICKLET_PERFORM_FLOAT_RENDER_IMEI_ERROR_CODE = "-5204";
    public static final String TICKLET_PERFORM_FLOAT_RENDER_STATIC_CODE_MSG = "静态二维码加载失败";
    public static final String TICKLET_PERFORM_LIST_NETWORK_ERROR_CODE = "-5000";
    public static final String TICKLET_PERFORM_LIST_NETWORK_ERROR_MSG = "票夹场次列表接口失败";
    public static final String TICKLET_PERFORM_LIST_NETWORK_ERROR_MSG_FOLLOW_RELATION = "关注接口";
    public static final String TICKLET_PERFORM_LIST_NETWORK_ERROR_MSG_HISTORY_PERFORMS = "历史场次接口";
    public static final String TICKLET_PERFORM_LIST_NETWORK_ERROR_MSG_PERFORM = "场次列表";
    public static final String TICKLET_PERFORM_LIST_NETWORK_ERROR_MSG_TRIBE_JOIN = "进群接口";
    public static final String TICKLET_PERFORM_LIST_POINT = "member_list";
    public static final String TICKLET_PERFORM_MSG_FACE_COMPARE = "人脸比对";
    public static final String TICKLET_PERFORM_MSG_FACE_QR = "比对人脸获取二维码";
    public static final String TICKLET_PERFORM_NOTE_INTERFACE_API = "观演内容";
    public static final String TICKLET_PERFORM_NOTE_INTERFACE_ERROR_CODE = "-5820";
    public static final String TICKLET_PERFORM_NOTE_INTERFACE_ERROR_MSG = "观演须知接口失败";
    public static final String TICKLET_PRELOAD_ACCS_DB_ERROR_CODE = "-5501";
    public static final String TICKLET_PRELOAD_ACCS_DB_ERROR_MSG = "预加载-accs更新表失败";
    public static final String TICKLET_PRELOAD_NETWORK_ERROR_CODE = "-5500";
    public static final String TICKLET_PRELOAD_NETWORK_ERROR_MSG = "预加载接口";
    public static final String TICKLET_SOUVENIR_DETAIL_API = "纪念票详情";
    public static final String TICKLET_SOUVENIR_DETAIL_ERROR_CODE = "-5800";
    public static final String TICKLET_SOUVENIR_DETAIL_ERROR_MSG = "纪念票接口失败";
    public static final String TICKLET_TOCOMMENT_LIST_NETWORK_ERROR_CODE = "-5830";
    public static final String TICKLET_TOCOMMENT_LIST_NETWORK_ERROR_MSG = "票夹待评价列表加载失败";
    public static final String TICKLET_VENUE_LIST_ERROR_CODE = "-5980";
    public static final String TICKLET_VENUE_LIST_ERROR_MSG = "取票点列表或停车场或交通点滑动显示问题";
    public static final String TICKLET_VENUE_POI_SEARCH_API = "场馆周边POI搜索";
    public static final String TICKLET_VENUE_POI_SEARCH_API_NAME = "AMap.PoiSearch";
    public static final String TICKLET_VENUE_POI_SEARCH_ERROR_CODE = "-5402";
    public static final String TICKLET_VENUE_POI_SEARCH_ERROR_MSG = "票详情-场馆POI检索失败";

    public static void a(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1990306915")) {
            ipChange.ipc$dispatch("-1990306915", new Object[]{str, str2, str3, str4});
        } else if ("FAIL_SYS_SESSION_EXPIRED".equals(str3)) {
        } else {
            b23.c("damai-android", str, str2, str3, str4);
        }
    }

    public static void b(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1085045840")) {
            ipChange.ipc$dispatch("-1085045840", new Object[]{str, str2});
        } else {
            b23.e("damai-android", str, str2);
        }
    }

    public static void c(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "501317606")) {
            ipChange.ipc$dispatch("501317606", new Object[]{str, str2, str3});
        } else {
            b23.g(str, str2, str3);
        }
    }

    public static void d(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "667865649")) {
            ipChange.ipc$dispatch("667865649", new Object[]{str, str2, str3, str4});
        } else if ("FAIL_SYS_SESSION_EXPIRED".equals(str3)) {
        } else {
            b23.a(str, str2, str4);
        }
    }

    public static String e(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-74886413")) {
            return (String) ipChange.ipc$dispatch("-74886413", new Object[]{str, str2, str3});
        }
        return "ticklet:jsondata={apiName: " + str + ", retCode: " + str2 + ", retMsg: " + str3 + ", loginKey: " + z20.q() + "}";
    }

    public static String f(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-263259425")) {
            return (String) ipChange.ipc$dispatch("-263259425", new Object[]{str, str2, str3, str4, str5});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ticklet");
        sb.append(":jsondata={");
        if (!TextUtils.isEmpty(str)) {
            sb.append(" api:" + str);
        }
        if (!TextUtils.isEmpty(z20.E())) {
            sb.append(", userCode:" + z20.E());
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(", apiName:" + str2);
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append(AVFSCacheConstants.COMMA_SEP + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(", retCode:" + str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(", retMsg:" + str4);
        }
        sb.append(" }");
        return sb.toString();
    }

    public static void g(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-60206869")) {
            ipChange.ipc$dispatch("-60206869", new Object[]{str, str2, str3});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ticklet");
        sb.append(", userCode:" + z20.E());
        sb.append(":jsondata={retCode: ");
        sb.append(str);
        sb.append(", retMsg:");
        sb.append(str2);
        sb.append("}");
        if (!xh2.c(str3)) {
            str2 = str3;
        }
        b23.a(sb.toString(), str, str2);
    }

    public static void h(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-197143894")) {
            ipChange.ipc$dispatch("-197143894", new Object[]{str, str2, str3});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ticklet");
        sb.append(":jsondata={");
        if (!TextUtils.isEmpty(str2)) {
            sb.append(" api:" + str2);
        }
        if (!TextUtils.isEmpty(z20.E())) {
            sb.append(", userCode:" + z20.E());
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(", retCode:" + str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(", retMsg:" + str2);
        }
        sb.append(" }");
        if (!xh2.c(str3)) {
            str2 = str3;
        }
        b23.g(sb.toString(), str, str2);
    }

    public static String i(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1127439546")) {
            return (String) ipChange.ipc$dispatch("-1127439546", new Object[]{str, str2, str3, str4, str5});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ticklet");
        sb.append(":jsondata={");
        if (!TextUtils.isEmpty(str)) {
            sb.append("api: ");
            sb.append(str);
        }
        if (!TextUtils.isEmpty(z20.E())) {
            sb.append(", userCode: ");
            sb.append(z20.E());
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(", apiName: ");
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(", retCode: ");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(", retMsg: ");
            sb.append(str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append(", performId: ");
            sb.append(str5);
        }
        sb.append("}");
        return sb.toString();
    }

    public static String j(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-70471647")) {
            return (String) ipChange.ipc$dispatch("-70471647", new Object[]{str, str2, str3});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ticklet");
        sb.append(":jsondata={");
        sb.append(" api:场馆周边POI搜索");
        if (!TextUtils.isEmpty(z20.E())) {
            sb.append(", userCode:" + z20.E());
        }
        sb.append(", apiName:AMap.PoiSearch");
        if (!TextUtils.isEmpty(str3)) {
            sb.append(AVFSCacheConstants.COMMA_SEP + str3);
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(", retCode:" + str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(", retMsg:" + str2);
        }
        sb.append(" }");
        return sb.toString();
    }
}
