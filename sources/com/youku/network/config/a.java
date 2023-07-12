package com.youku.network.config;

import cn.damai.seatdecoder.common.bean.BaseDecodeResult;
import java.util.HashMap;
import mtopsdk.mtop.util.ErrorConstant;
import tb.e11;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class a {
    public static HashMap<String, Integer> a = new HashMap<>(24);
    public static HashMap<String, Integer> b;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>(64);
        b = hashMap;
        hashMap.put("FAIL_SYS_API_STOP_SERVICE", -4001);
        b.put("FAIL_SYS_SM_ODD_REQUEST", -4002);
        b.put("FAIL_SYS_API_NOT_FOUNDED", -4003);
        b.put("FAIL_SYS_SESSION_EXPIRED", -4004);
        b.put("FAIL_SYS_SYSTEM_BUSY_ERROR", -4005);
        b.put("FAIL_SYS_SERVLET_ASYNC_START_FAIL", -4006);
        b.put(e11.FAIL_SYS_FLOWLIMIT, -4007);
        b.put("FAIL_SYS_API_UNAUTHORIZED", -4008);
        b.put("FAIL_SYS_PROTOPARAM_MISSED", -4009);
        b.put("FAIL_SYS_PROTOVER_MISSED", -4010);
        b.put("FAIL_SYS_REQUEST_EXPIRED", -4011);
        b.put("FAIL_SYS_ILEGEL_SIGN", -4012);
        b.put("FAIL_SYS_INVALID_HTTP_METHOD", -4013);
        b.put("FAIL_SYS_BADARGUMENT_T", -4014);
        b.put("FAIL_SYS_UNKNOWN_APP", -4015);
        b.put("FAIL_SYS_INTERNAL_FAULT", -4016);
        b.put(e11.FAIL_SYS_TRAFFIC_LIMIT, -4017);
        b.put("FAIL_SYS_BIZPARAM_TYPE_ERROR", -4018);
        b.put("FAIL_SYS_BIZPARAM_MISSED", -4019);
        b.put("FAIL_SYS_TOPAUTHPARAM_MISSED", -4020);
        b.put("FAIL_SYS_TOPAUTH_FAILED", -4021);
        b.put("FAIL_SYS_TOPAUTH_ACCESSTOKENEXPIRED_ERROR", -4022);
        b.put("FAIL_SYS_TOPAUTH_TRAFFICLIMIT_ERROR", -4023);
        b.put("FAIL_SYS_TOPUNAUTHAPI_ERROR", -4024);
        b.put("FAIL_SYS_TOPAUTH_FAULT", -4025);
        b.put("FAIL_SYS_RETMISSED_ERROR", -4026);
        b.put("FAIL_SYS_PARAMINVALID_ERROR", -4027);
        b.put("SYSTEM_ERROR", -4028);
        b.put("FAIL_SYS_UNAUTHORIZED_ENTRANCE", -4029);
        b.put("FAIL_SYS_SESSION_ERROR", -4030);
        b.put("FAIL_SYS_MT_ODD_REQUEST", -4031);
        b.put("FAIL_SYS_EXPIRED_REQUEST", -4032);
        b.put("FAIL_SYS_PORTOCOLPARAM_INVALID", Integer.valueOf((int) BaseDecodeResult.DECODE_DECOMPRESS_ERROR));
        b.put("FAIL_SYS_INVALID_PROTOCOLVERSION", -4034);
        b.put("FAIL_SYS_ILLEGAL_ARGUMENT_TTID", -4035);
        b.put("FAIL_SYS_PARAM_MISSING", -4036);
        b.put("FAIL_SYS_PARAM_FORMAT_ERROR", Integer.valueOf((int) BaseDecodeResult.DECODE_SERIALIZE_ERROR));
        b.put("FAIL_SYS_ILLEGAL_ARGUMENT_TTID", -4038);
        b.put(ErrorConstant.ERRCODE_FAIL_SYS_ILLEGAL_ACCESS_TOKEN, -4039);
        b.put("FAIL_SYS_ACCESS_TOKEN_STOP_SERVICE", -4040);
        b.put("FAIL_SYS_ACCESS_TOKEN_INTERNAL_FAULT", -4041);
        b.put("FAIL_SYS_ACCESS_TOKEN_TRAFFIC_LIMIT", -4042);
        b.put(ErrorConstant.ERRCODE_FAIL_SYS_ACCESS_TOKEN_EXPIRED, -4043);
        b.put("FAIL_SYS_ACCESS_TOKEN_PARAM_INVALID", -4044);
        b.put("FAIL_SYS_ACCESS_TOKEN_UNKNOWN_ERROR", -4045);
        b.put("FAIL_SYS_SERVICE_NOT_EXIST", -4046);
        b.put(e11.FAIL_SYS_SERVICE_TIMEOUT, -4047);
        b.put(e11.FAIL_SYS_SERVICE_FAULT, -4048);
        b.put("FAIL_SYS_HTTP_QUERYIP_ERROR", -4049);
        b.put("FAIL_SYS_HTTP_REQUESTSUBMIT_FAILED", -4050);
        b.put("FAIL_SYS_HTTP_INVOKE_ERROR", -4051);
        b.put(e11.FAIL_SYS_HTTP_RESPONSE_TIMEOUT, -4052);
        b.put(e11.FAIL_SYS_HTTP_CONNECT_TIMEOUT, -4053);
        b.put("UNKNOWN_FAIL_CODE", -4054);
        b.put("FAIL_SYS_HSF_THROWN_EXCEPTION", -4055);
        b.put("FAIL_SYS_SERVICE_INNER_FAULT", -4056);
        b.put("FAIL_SYS_HTTP_RESULT_FIELDMISSED", -4057);
        b.put("FAIL_SYS_SERVICE_INNER_FAULT", -4058);
        a.put("ANDROID_SYS_NO_NETWORK", -4059);
        a.put("ANDROID_SYS_NETWORK_ERROR", -4060);
        a.put(ErrorConstant.ERRCODE_JSONDATA_BLANK, -4061);
        a.put(ErrorConstant.ERRCODE_JSONDATA_PARSE_ERROR, -4062);
        a.put(ErrorConstant.ERRCODE_MTOPSDK_INIT_ERROR, -4063);
        a.put(ErrorConstant.ERRCODE_MTOPCONTEXT_INIT_ERROR, -4064);
        a.put(ErrorConstant.ERRCODE_GENERATE_MTOP_SIGN_ERROR, -4065);
        a.put(ErrorConstant.ERRCODE_NETWORK_REQUEST_CONVERT_ERROR, -4066);
        a.put("ANDROID_SYS_API_FLOW_LIMIT_LOCKED", -4067);
        a.put(ErrorConstant.ERRCODE_API_41X_ANTI_ATTACK, -4068);
        a.put(ErrorConstant.ERRCODE_MTOP_APICALL_ASYNC_TIMEOUT, -4069);
        a.put(ErrorConstant.ERRCODE_INIT_MTOP_ISIGN_ERROR, -4070);
        a.put(ErrorConstant.ERRCODE_MTOP_MISS_CALL_FACTORY, -4071);
        a.put(ErrorConstant.ERRCODE_ANDROID_SYS_LOGIN_FAIL, -4072);
        a.put(ErrorConstant.ERRCODE_ANDROID_SYS_LOGIN_CANCEL, -4073);
        a.put(ErrorConstant.ERRCODE_ILLEGAL_JSPARAM_ERROR, -4074);
        a.put(ErrorConstant.ERRCODE_PARSE_JSPARAM_ERROR, -4075);
        a.put("MTOP_UNKNOW_ERROR", -4076);
    }

    public static int a(String str) {
        Integer num = b.get(str);
        if (num == null) {
            num = a.get(str);
        }
        if (num == null) {
            return -4076;
        }
        return num.intValue();
    }

    public static boolean b(String str) {
        return "SUCCESS".equals(str);
    }
}
