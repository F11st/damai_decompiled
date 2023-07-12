package com.taobao.weex.dom.binding;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.utils.WXLogUtils;
import tb.jn1;
import tb.pq1;
import tb.zo2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ELUtils {
    public static final String BINDING = "@binding";
    public static final String COMPONENT_PROPS = "@componentProps";
    public static final String[] EXCLUDES_BINDING = {"clickEventParams"};
    public static final String IS_COMPONENT_ROOT = "@isComponentRoot";

    public static Object bindingBlock(Object obj) {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.containsKey(BINDING)) {
                Object obj2 = jSONObject.get(BINDING);
                if (!(obj2 instanceof zo2)) {
                    jSONObject.put(BINDING, (Object) pq1.g(obj2.toString()));
                }
            }
            for (String str : jSONObject.keySet()) {
                if ((jSONObject.get(str) instanceof JSONObject) && ((JSONObject) jSONObject.get(str)).containsKey(BINDING)) {
                    JSONObject jSONObject2 = (JSONObject) jSONObject.get(str);
                    Object obj3 = jSONObject2.get(BINDING);
                    if (!(obj3 instanceof zo2)) {
                        jSONObject2.put(BINDING, (Object) pq1.g(obj3.toString()));
                    }
                }
            }
            return obj;
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            for (int i = 0; i < jSONArray.size(); i++) {
                bindingBlock(jSONArray.get(i));
            }
            return obj;
        } else if (obj instanceof String) {
            String obj4 = obj.toString();
            if (obj4.startsWith(jn1.BLOCK_START_STR)) {
                return bindingBlock(JSON.parseObject(obj4));
            }
            return obj4.startsWith(jn1.ARRAY_START_STR) ? bindingBlock(JSON.parseArray(obj4)) : obj;
        } else {
            return obj;
        }
    }

    public static boolean isBinding(Object obj) {
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).containsKey(BINDING);
        } else if (!(obj instanceof JSONArray)) {
            return (obj instanceof String) && ((String) obj).indexOf(BINDING) >= 0;
        } else {
            JSONArray jSONArray = (JSONArray) obj;
            for (int i = 0; i < jSONArray.size(); i++) {
                if (isBinding(jSONArray.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    public static Object vforBlock(Object obj) {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.containsKey(WXStatement.WX_FOR_LIST)) {
                Object obj2 = jSONObject.get(WXStatement.WX_FOR_LIST);
                if (!(obj2 instanceof zo2)) {
                    jSONObject.put(WXStatement.WX_FOR_LIST, (Object) pq1.g(obj2.toString()));
                }
            }
        } else if (obj instanceof String) {
            return vforBlock(JSON.parseObject(obj.toString()));
        } else {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e("weex", "weex vfor is illegal " + obj);
            }
        }
        return obj;
    }
}
