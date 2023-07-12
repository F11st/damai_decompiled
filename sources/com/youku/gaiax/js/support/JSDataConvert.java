package com.youku.gaiax.js.support;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.js.api.IGaiaXCallback;
import com.youku.gaiax.js.api.IGaiaXPromise;
import com.youku.gaiax.js.support.Types;
import com.youku.gaiax.quickjs.JSBoolean;
import com.youku.gaiax.quickjs.JSContext;
import com.youku.gaiax.quickjs.JSNumber;
import com.youku.gaiax.quickjs.JSObject;
import com.youku.gaiax.quickjs.JSString;
import com.youku.gaiax.quickjs.JSUndefined;
import com.youku.gaiax.quickjs.JSValue;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¨\u0006\u0012"}, d2 = {"Lcom/youku/gaiax/js/support/JSDataConvert;", "", "value", "", "getDataTypeByValue", "type", "data", "getDataValueByType", "Lcom/youku/gaiax/quickjs/JSContext;", "jsContext", "result", "Lcom/youku/gaiax/quickjs/JSValue;", "convertToJSValue", "Ljava/lang/reflect/Type;", "valueType", "convertToJavaValue", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class JSDataConvert {
    @NotNull
    public static final JSDataConvert INSTANCE = new JSDataConvert();

    private JSDataConvert() {
    }

    @NotNull
    public final JSValue convertToJSValue(@NotNull JSContext jSContext, @Nullable Object obj) {
        b41.i(jSContext, "jsContext");
        if (obj == null) {
            JSUndefined createJSUndefined = jSContext.createJSUndefined();
            b41.h(createJSUndefined, "jsContext.createJSUndefined()");
            return createJSUndefined;
        } else if (obj instanceof JSONObject) {
            JSObject createJSJsonObject = jSContext.createJSJsonObject(((JSONObject) obj).toJSONString());
            b41.h(createJSJsonObject, "jsContext.createJSJsonOb…ct(result.toJSONString())");
            return createJSJsonObject;
        } else if (obj instanceof String) {
            JSString createJSString = jSContext.createJSString((String) obj);
            b41.h(createJSString, "jsContext.createJSString(result)");
            return createJSString;
        } else if (obj instanceof Integer) {
            JSNumber createJSNumber = jSContext.createJSNumber(((Number) obj).intValue());
            b41.h(createJSNumber, "jsContext.createJSNumber(result)");
            return createJSNumber;
        } else if (obj instanceof Double) {
            JSNumber createJSNumber2 = jSContext.createJSNumber(((Number) obj).doubleValue());
            b41.h(createJSNumber2, "jsContext.createJSNumber(result)");
            return createJSNumber2;
        } else if (obj instanceof Float) {
            JSNumber createJSNumber3 = jSContext.createJSNumber(((Number) obj).floatValue());
            b41.h(createJSNumber3, "jsContext.createJSNumber(result.toDouble())");
            return createJSNumber3;
        } else if (obj instanceof Long) {
            JSNumber createJSNumber4 = jSContext.createJSNumber(((Number) obj).longValue());
            b41.h(createJSNumber4, "jsContext.createJSNumber(result)");
            return createJSNumber4;
        } else if (obj instanceof Boolean) {
            JSBoolean createJSBoolean = jSContext.createJSBoolean(((Boolean) obj).booleanValue());
            b41.h(createJSBoolean, "jsContext.createJSBoolean(result)");
            return createJSBoolean;
        } else {
            JSUndefined createJSUndefined2 = jSContext.createJSUndefined();
            b41.h(createJSUndefined2, "jsContext.createJSUndefined()");
            return createJSUndefined2;
        }
    }

    @Nullable
    public final Object convertToJavaValue(@NotNull Type type, @Nullable Object obj) {
        b41.i(type, "valueType");
        if (obj == null) {
            return null;
        }
        if (b41.d(type, JSONObject.class)) {
            return JSON.parseObject(obj.toString());
        }
        if (b41.d(type, String.class)) {
            return obj.toString();
        }
        if (b41.d(type, Integer.TYPE)) {
            return Integer.valueOf(Integer.parseInt(obj.toString()));
        }
        if (b41.d(type, Double.TYPE)) {
            return Double.valueOf(Double.parseDouble(obj.toString()));
        }
        if (b41.d(type, Float.TYPE)) {
            return Float.valueOf(Float.parseFloat(obj.toString()));
        }
        if (b41.d(type, Long.TYPE)) {
            return Long.valueOf(Long.parseLong(obj.toString()));
        }
        if (b41.d(type, Boolean.TYPE)) {
            return Boolean.valueOf(Boolean.parseBoolean(obj.toString()));
        }
        if (b41.d(type, IGaiaXCallback.class)) {
            return (IGaiaXCallback) obj;
        }
        if (b41.d(type, IGaiaXPromise.class)) {
            return (IGaiaXPromise) obj;
        }
        if (type instanceof Types.ParameterizedTypeImpl) {
            Types.ParameterizedTypeImpl parameterizedTypeImpl = (Types.ParameterizedTypeImpl) type;
            if (b41.d(parameterizedTypeImpl.getRawType(), Map.class)) {
                Type[] typeArr = parameterizedTypeImpl.typeArguments;
                Type type2 = typeArr[0];
                Type type3 = typeArr[1];
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                JSONObject parseObject = JSON.parseObject(obj.toString());
                Set<String> keySet = parseObject.keySet();
                b41.h(keySet, "valueJsonObj.keys");
                for (String str : keySet) {
                    JSDataConvert jSDataConvert = INSTANCE;
                    b41.h(type2, "targetType");
                    Object convertToJavaValue = jSDataConvert.convertToJavaValue(type2, str);
                    if (convertToJavaValue != null) {
                        b41.h(type3, "targetValueType");
                        linkedHashMap.put(convertToJavaValue, jSDataConvert.convertToJavaValue(type3, parseObject.get(str)));
                    }
                }
                return linkedHashMap;
            } else if (b41.d(parameterizedTypeImpl.getRawType(), List.class)) {
                Type type4 = parameterizedTypeImpl.typeArguments[0];
                ArrayList arrayList = new ArrayList();
                JSONArray parseArray = JSON.parseArray(obj.toString());
                b41.h(parseArray, "parseArray(value.toString())");
                for (Object obj2 : parseArray) {
                    JSDataConvert jSDataConvert2 = INSTANCE;
                    b41.h(type4, "targetType");
                    arrayList.add(jSDataConvert2.convertToJavaValue(type4, obj2));
                }
                return arrayList;
            } else {
                return obj;
            }
        }
        return obj;
    }

    @NotNull
    public final String getDataTypeByValue(@NotNull Object obj) {
        b41.i(obj, "value");
        return obj instanceof JSONObject ? "JSONObject" : obj instanceof String ? "String" : obj instanceof Integer ? "Int" : obj instanceof Double ? "Double" : obj instanceof Float ? "Float" : obj instanceof Long ? "Long" : obj instanceof Boolean ? "Boolean" : "Any";
    }

    @Nullable
    public final Object getDataValueByType(@NotNull String str, @Nullable Object obj) {
        b41.i(str, "type");
        if (obj == null) {
            return null;
        }
        switch (str.hashCode()) {
            case -1808118735:
                if (str.equals("String")) {
                    return obj.toString();
                }
                break;
            case 73679:
                if (str.equals("Int")) {
                    return Integer.valueOf(Integer.parseInt(obj.toString()));
                }
                break;
            case 2374300:
                if (str.equals("Long")) {
                    return Long.valueOf(Long.parseLong(obj.toString()));
                }
                break;
            case 67973692:
                if (str.equals("Float")) {
                    return Float.valueOf(Float.parseFloat(obj.toString()));
                }
                break;
            case 1729365000:
                if (str.equals("Boolean")) {
                    return Boolean.valueOf(Boolean.parseBoolean(obj.toString()));
                }
                break;
            case 1752376903:
                if (str.equals("JSONObject")) {
                    return JSON.parseObject(obj.toString());
                }
                break;
            case 2052876273:
                if (str.equals("Double")) {
                    return Double.valueOf(Double.parseDouble(obj.toString()));
                }
                break;
        }
        return obj.toString();
    }
}
