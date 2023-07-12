package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.abilitykit.AKIAbilityCallback;
import com.taobao.android.dinamicx.C6367d;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.eventchain.C6372b;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class vu extends AbstractC6375a {
    public static final long DX_PARSER_ABILITYHUB = -8392059985777200873L;

    /* compiled from: Taobao */
    /* renamed from: tb.vu$a */
    /* loaded from: classes11.dex */
    class C9828a implements AKIAbilityCallback {
        C9828a(vu vuVar) {
        }

        @Override // com.taobao.android.abilitykit.AKIAbilityCallback
        public void callback(String str, C9392l c9392l) {
        }
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        DinamicXEngine e;
        C6372b o;
        C9192h j;
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject(0);
        C6367d engineContext = dXRuntimeContext.getEngineContext();
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
            C9392l a = j.a(jSONObject3, z10Var, new C9828a(this));
            if (a instanceof C9488o) {
                return a.a();
            }
        }
        return jSONObject2;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "abilityHub";
    }
}
