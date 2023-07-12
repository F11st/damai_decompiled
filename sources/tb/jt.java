package tb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.AbstractC6362a;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class jt extends AbstractC6362a {
    public static final long DX_EVENT_BINDINGX = 1454898448112604731L;

    void a(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || jSONObject == null) {
            return;
        }
        int length = objArr.length;
        HashMap hashMap = null;
        if (objArr.length >= 2) {
            JSONArray jSONArray = new JSONArray();
            if (objArr[0] instanceof String) {
                if (!TextUtils.isEmpty((String) objArr[0])) {
                    jSONArray.add(objArr[0]);
                }
            } else if (objArr[0] instanceof JSONArray) {
                jSONArray.addAll((JSONArray) objArr[0]);
            } else if (objArr[0] != null) {
                jSONArray.add(objArr[0]);
            }
            jSONObject.put("spec", (Object) jSONArray);
            String str = (String) objArr[1];
            if ("start".equalsIgnoreCase(str)) {
                jSONObject.put("action", "start");
            } else if ("stop".equalsIgnoreCase(str)) {
                jSONObject.put("action", "stop");
            }
        }
        for (int i = 2; i < length; i += 2) {
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            int i2 = i + 1;
            if (i2 >= length) {
                break;
            }
            hashMap.put((String) objArr[i], objArr[i2]);
        }
        if (hashMap != null) {
            jSONObject.put("args", (Object) hashMap);
        }
    }

    @Override // com.taobao.android.dinamicx.AbstractC6362a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "bindingX";
    }

    @Override // com.taobao.android.dinamicx.IDXEventHandler
    public void handleEvent(hy hyVar, Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        DXRootView rootView = dXRuntimeContext.getRootView();
        if (rootView == null || objArr == null || objArr.length == 0) {
            return;
        }
        DXWidgetNode widgetNode = dXRuntimeContext.getWidgetNode();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", (Object) "BNDX");
        JSONObject jSONObject2 = new JSONObject();
        a(jSONObject2, objArr);
        jSONObject2.put("widget", (Object) widgetNode);
        jSONObject.put("params", (Object) jSONObject2);
        if (dXRuntimeContext.getEngineContext() != null) {
            dXRuntimeContext.getEngineContext().k(rootView, jSONObject);
        }
    }
}
