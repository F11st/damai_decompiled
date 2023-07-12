package com.amap.api.mapcore.util;

import com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.AMapException;
import com.taobao.dp.http.ResCode;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class fw {
    private static String[] a = {"com.amap.api.trace", "com.amap.api.trace.core"};

    public static void a(String str, String str2) throws ft {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                a(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"), str2);
                return;
            }
            if (jSONObject.has("status") && jSONObject.has("infocode")) {
                String string = jSONObject.getString("status");
                int i = jSONObject.getInt("infocode");
                if ("1".equals(string)) {
                    return;
                }
                String string2 = jSONObject.getString("info");
                if ("0".equals(string)) {
                    a(i, string2, str2);
                }
            }
        } catch (JSONException unused) {
            throw new ft("协议解析错误 - ProtocolException");
        }
    }

    protected static void a(int i, String str, String str2) throws ft {
        if (i != 0) {
            switch (i) {
                case 10000:
                    return;
                case 10001:
                    throw new ft(AMapException.AMAP_INVALID_USER_KEY);
                case 10002:
                    throw new ft(AMapException.AMAP_SERVICE_NOT_AVAILBALE);
                case 10003:
                    throw new ft(AMapException.AMAP_DAILY_QUERY_OVER_LIMIT);
                case 10004:
                    throw new ft(AMapException.AMAP_ACCESS_TOO_FREQUENT);
                case 10005:
                    throw new ft(AMapException.AMAP_INVALID_USER_IP);
                case 10006:
                    throw new ft(AMapException.AMAP_INVALID_USER_DOMAIN);
                case ResCode.ENVIRONMENT_CHANGED /* 10007 */:
                    throw new ft("用户签名未通过");
                case 10008:
                    throw new ft(AMapException.AMAP_INVALID_USER_SCODE);
                case 10009:
                    throw new ft(AMapException.AMAP_USERKEY_PLAT_NOMATCH);
                case 10010:
                    throw new ft(AMapException.AMAP_IP_QUERY_OVER_LIMIT);
                case 10011:
                    throw new ft(AMapException.AMAP_NOT_SUPPORT_HTTPS);
                case 10012:
                    throw new ft(AMapException.AMAP_INSUFFICIENT_PRIVILEGES);
                case 10013:
                    throw new ft(AMapException.AMAP_USER_KEY_RECYCLED);
                default:
                    switch (i) {
                        case 20000:
                            throw new ft(AMapException.AMAP_SERVICE_INVALID_PARAMS);
                        case 20001:
                            throw new ft(AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS);
                        case BaseBioNavigatorActivity.n /* 20002 */:
                            throw new ft(AMapException.AMAP_SERVICE_ILLEGAL_REQUEST);
                        case BaseBioNavigatorActivity.o /* 20003 */:
                            throw new ft(AMapException.AMAP_SERVICE_UNKNOWN_ERROR);
                        default:
                            switch (i) {
                                case 30000:
                                    throw new ft(AMapException.AMAP_ENGINE_RESPONSE_ERROR);
                                case 30001:
                                    throw new ft(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR);
                                case com.taobao.android.dinamicx.e.DXError_EngineInitException /* 30002 */:
                                    throw new ft(AMapException.AMAP_ENGINE_CONNECT_TIMEOUT);
                                case com.taobao.android.dinamicx.e.DXError_EngineSizeException /* 30003 */:
                                    throw new ft(AMapException.AMAP_ENGINE_RETURN_TIMEOUT);
                                default:
                                    throw new ft(str);
                            }
                    }
            }
        }
    }

    public static int a(List<LatLng> list) {
        int i = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        int i2 = 0;
        while (i < list.size() - 1) {
            LatLng latLng = list.get(i);
            i++;
            LatLng latLng2 = list.get(i);
            if (latLng == null || latLng2 == null) {
                break;
            }
            i2 = (int) (i2 + AMapUtils.calculateLineDistance(latLng, latLng2));
        }
        return i2;
    }
}
