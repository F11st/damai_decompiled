package com.ali.user.open.ucc.util;

import android.text.TextUtils;
import com.ali.user.open.core.device.DeviceInfo;
import com.ali.user.open.core.model.RpcResponse;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class Utils {
    public static int buidErrorCode(RpcResponse rpcResponse, int i) {
        return rpcResponse != null ? rpcResponse.code : i;
    }

    public static String buidErrorMessage(RpcResponse rpcResponse, String str) {
        return rpcResponse == null ? str : TextUtils.isEmpty(rpcResponse.message) ? "亲，您的手机网络不太顺畅喔~" : rpcResponse.message;
    }

    public static Map<String, String> convertJsonStrToMap(String str) {
        try {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Object> entry : JSON.parseObject(str).entrySet()) {
                hashMap.put(entry.getKey(), (String) entry.getValue());
            }
            return hashMap;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String convertMapToJsonStr(Map map) {
        if (map != null && !map.isEmpty()) {
            try {
                return JSON.toJSONString(map);
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static String generateTraceId(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str + DeviceInfo.deviceId + (System.currentTimeMillis() / 1000);
    }
}
