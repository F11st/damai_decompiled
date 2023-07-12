package com.taobao.weex.utils;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.taobao.weex.bridge.WXJSObject;
import tb.jn1;
import tb.w13;
import tb.x13;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXWsonJSONSwitch {
    public static boolean USE_WSON = true;
    public static final String WSON_OFF = "wson_off";

    public static final byte[] convertJSONToWsonIfUseWson(byte[] bArr) {
        if (USE_WSON) {
            if (bArr == null) {
                return null;
            }
            String str = new String(bArr);
            if (str.startsWith(jn1.ARRAY_START_STR)) {
                return x13.a(JSON.parseArray(str));
            }
            return x13.a(JSON.parse(str));
        }
        return bArr;
    }

    public static final Object convertWXJSObjectDataToJSON(WXJSObject wXJSObject) {
        if (wXJSObject.type == 4) {
            return JSON.parse(w13.i((byte[]) wXJSObject.data).toString());
        }
        return JSON.parse(wXJSObject.data.toString());
    }

    @NonNull
    public static String fromObjectToJSONString(WXJSObject wXJSObject) {
        Object i;
        if (wXJSObject != null && wXJSObject.type == 4 && (i = w13.i((byte[]) wXJSObject.data)) != null) {
            return i.toString();
        }
        return WXJsonUtils.fromObjectToJSONString(wXJSObject, false);
    }

    public static final Object parseWsonOrJSON(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            if (USE_WSON) {
                return w13.i(bArr);
            }
            return JSON.parse(new String(bArr, "UTF-8"));
        } catch (Exception e) {
            WXLogUtils.e("WXSwitch", e);
            if (USE_WSON) {
                return JSON.parse(new String(bArr));
            }
            return w13.i(bArr);
        }
    }

    public static final WXJSObject toWsonOrJsonWXJSObject(Object obj) {
        if (obj == null) {
            return new WXJSObject(null);
        }
        if (obj.getClass() == WXJSObject.class) {
            return (WXJSObject) obj;
        }
        if (USE_WSON) {
            return new WXJSObject(4, w13.j(obj));
        }
        return new WXJSObject(3, WXJsonUtils.fromObjectToJSONString(obj));
    }
}
