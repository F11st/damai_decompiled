package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.abilitykit.AKIAbilityCallback;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class vu extends com.taobao.android.dinamicx.expression.parser.a {
    public static final long DX_PARSER_ABILITYHUB = -8392059985777200873L;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements AKIAbilityCallback {
        a(vu vuVar) {
        }

        @Override // com.taobao.android.abilitykit.AKIAbilityCallback
        public void callback(String str, l lVar) {
        }
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        DinamicXEngine e;
        com.taobao.android.dinamicx.eventchain.b o;
        h j;
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject(0);
        com.taobao.android.dinamicx.d engineContext = dXRuntimeContext.getEngineContext();
        if (engineContext != null && (e = engineContext.e()) != null && (o = e.o()) != null && (j = o.j()) != null && objArr != null && objArr.length >= 1 && (objArr[0] instanceof String)) {
            String str = (String) objArr[0];
            if (objArr.length > 1 && (objArr[1] instanceof JSONObject)) {
                jSONObject = (JSONObject) objArr[1];
            } else {
                jSONObject = new JSONObject(0);
            }
            JSONObject jSONObject3 = new JSONObject(2);
            jSONObject3.put("type", (Object) str);
            jSONObject3.put("params", (Object) jSONObject);
            z10 z10Var = new z10();
            z10Var.e(dXRuntimeContext.getContext());
            z10Var.g(dXRuntimeContext.getNativeView());
            z10Var.d(j);
            z10Var.i(dXRuntimeContext.getRootView());
            z10Var.j(dXRuntimeContext.getWidgetNode());
            l a2 = j.a(jSONObject3, z10Var, new a(this));
            if (a2 instanceof o) {
                return a2.a();
            }
        }
        return jSONObject2;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "abilityHub";
    }
}
