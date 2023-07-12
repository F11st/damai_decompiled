package com.taobao.weex.ui.module;

import androidx.annotation.RestrictTo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.dom.binding.JSONUtils;
import com.taobao.weex.ui.action.ActionAddRule;
import com.taobao.weex.ui.action.ActionGetComponentRect;
import com.taobao.weex.ui.action.ActionGetLayoutDirection;
import com.taobao.weex.ui.action.ActionInvokeMethod;
import com.taobao.weex.ui.action.GraphicActionBatchBegin;
import com.taobao.weex.ui.action.GraphicActionBatchEnd;
import com.taobao.weex.ui.action.GraphicActionScrollToElement;
import com.taobao.weex.ui.action.UpdateComponentDataAction;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes11.dex */
public class WXDomModule extends WXModule {
    public static final String UPDATE_COMPONENT_DATA = "updateComponentData";
    public static final String WXDOM = "dom";
    public static final String SCROLL_TO_ELEMENT = "scrollToElement";
    public static final String ADD_RULE = "addRule";
    public static final String GET_COMPONENT_RECT = "getComponentRect";
    public static final String INVOKE_METHOD = "invokeMethod";
    public static final String GET_COMPONENT_DIRECTION = "getLayoutDirection";
    public static final String BATCH_BEGIN = "beginBatchMark";
    public static final String BATCH_END = "endBatchMark";
    public static final String[] METHODS = {SCROLL_TO_ELEMENT, ADD_RULE, GET_COMPONENT_RECT, INVOKE_METHOD, GET_COMPONENT_DIRECTION, BATCH_BEGIN, BATCH_END};

    public WXDomModule(WXSDKInstance wXSDKInstance) {
        this.mWXSDKInstance = wXSDKInstance;
    }

    public void callDomMethod(JSONObject jSONObject, long... jArr) {
        if (jSONObject == null) {
            return;
        }
        callDomMethod((String) jSONObject.get("method"), (JSONArray) jSONObject.get("args"), jArr);
    }

    public void invokeMethod(String str, String str2, JSONArray jSONArray) {
        if (str == null || str2 == null) {
            return;
        }
        new ActionInvokeMethod(this.mWXSDKInstance.getInstanceId(), str, str2, jSONArray).executeAction();
    }

    public Object callDomMethod(String str, JSONArray jSONArray, long... jArr) {
        if (str == null) {
            return null;
        }
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1390247284:
                    if (str.equals(BATCH_END)) {
                        c = 7;
                        break;
                    }
                    break;
                case -1148630211:
                    if (str.equals(ADD_RULE)) {
                        c = 2;
                        break;
                    }
                    break;
                case -748746828:
                    if (str.equals(SCROLL_TO_ELEMENT)) {
                        c = 1;
                        break;
                    }
                    break;
                case -658126983:
                    if (str.equals(INVOKE_METHOD)) {
                        c = 4;
                        break;
                    }
                    break;
                case -276465026:
                    if (str.equals(BATCH_BEGIN)) {
                        c = 6;
                        break;
                    }
                    break;
                case 588570827:
                    if (str.equals(GET_COMPONENT_RECT)) {
                        c = 3;
                        break;
                    }
                    break;
                case 1653342206:
                    if (str.equals(UPDATE_COMPONENT_DATA)) {
                        c = 5;
                        break;
                    }
                    break;
                case 1875897663:
                    if (str.equals(GET_COMPONENT_DIRECTION)) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (jSONArray != null) {
                        new ActionGetLayoutDirection(this.mWXSDKInstance, jSONArray.getString(0), jSONArray.getString(1)).executeActionOnRender();
                        break;
                    } else {
                        return null;
                    }
                case 1:
                    if (jSONArray != null) {
                        new GraphicActionScrollToElement(this.mWXSDKInstance, jSONArray.size() >= 1 ? jSONArray.getString(0) : null, jSONArray.size() >= 2 ? jSONArray.getJSONObject(1) : null).executeActionOnRender();
                        break;
                    } else {
                        return null;
                    }
                case 2:
                    if (jSONArray != null) {
                        new ActionAddRule(this.mWXSDKInstance.getInstanceId(), jSONArray.getString(0), jSONArray.getJSONObject(1)).executeAction();
                        break;
                    } else {
                        return null;
                    }
                case 3:
                    if (jSONArray != null) {
                        new ActionGetComponentRect(this.mWXSDKInstance, jSONArray.getString(0), jSONArray.getString(1)).executeActionOnRender();
                        break;
                    } else {
                        return null;
                    }
                case 4:
                    if (jSONArray != null) {
                        new ActionInvokeMethod(this.mWXSDKInstance.getInstanceId(), jSONArray.getString(0), jSONArray.getString(1), jSONArray.getJSONArray(2)).executeAction();
                        break;
                    } else {
                        return null;
                    }
                case 5:
                    if (jSONArray != null && jSONArray.size() >= 3) {
                        new UpdateComponentDataAction(this.mWXSDKInstance, jSONArray.getString(0), JSONUtils.toJSON(jSONArray.get(1)), jSONArray.getString(2)).executeAction();
                        break;
                    }
                    return null;
                case 6:
                    if (jSONArray != null) {
                        new GraphicActionBatchBegin(this.mWXSDKInstance, jSONArray.size() >= 1 ? jSONArray.getString(0) : null).executeActionOnRender();
                        break;
                    } else {
                        return null;
                    }
                case 7:
                    new GraphicActionBatchEnd(this.mWXSDKInstance, jSONArray.size() >= 1 ? jSONArray.getString(0) : null).executeActionOnRender();
                    break;
                default:
                    WXLogUtils.e("Unknown dom action.");
                    break;
            }
        } catch (ClassCastException unused) {
            WXLogUtils.e("Dom module call arguments format error!!");
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            WXLogUtils.e("Dom module call miss arguments.");
        }
        return null;
    }
}
