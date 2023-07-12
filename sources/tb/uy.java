package tb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.StageType;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXBuiltinProvider;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprDxMethodProxy;
import com.taobao.android.dinamicx.expression.expr_v2.DXJSMethodProxy;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class uy {
    private static final Map<String, az> b = new HashMap();
    private final ConcurrentHashMap<String, zy> a = new ConcurrentHashMap<>();

    /* compiled from: Taobao */
    /* renamed from: tb.uy$a */
    /* loaded from: classes11.dex */
    public static class C9793a {
        public final boolean a;
        public final String b;
        public final az c;

        public C9793a(boolean z, String str, az azVar) {
            this.a = z;
            this.b = str;
            this.c = azVar;
        }

        public String toString() {
            return "EngineResult{success=" + this.a + ", errorMsg='" + this.b + "', result=" + this.c + '}';
        }
    }

    static {
        d("parseInt", new mq1());
        d("parseFloat", new lq1());
        d("substring", new ni2());
        d("slice", new w7());
        d("length", new sw());
        nd1 nd1Var = new nd1();
        e("Math", "abs", new tp0(nd1Var, "abs"));
        e("Math", "ceil", new tp0(nd1Var, "ceil"));
        e("Math", "exp", new tp0(nd1Var, "exp"));
        e("Math", "floor", new tp0(nd1Var, "floor"));
        e("Math", "max", new tp0(nd1Var, "max"));
        e("Math", "min", new tp0(nd1Var, "min"));
        e("Math", "round", new tp0(nd1Var, "round"));
        u41 u41Var = new u41();
        e("JSON", StageType.PARSE, new tp0(u41Var, StageType.PARSE));
        e("JSON", "stringify", new tp0(u41Var, "stringify"));
        d("comboEventHandler", new vt());
    }

    public static az c(String str) {
        return b.get(str);
    }

    public static void d(String str, IDXFunction iDXFunction) {
        b.put(str, az.I(iDXFunction));
    }

    public static void e(String str, String str2, IDXFunction iDXFunction) {
        Map<String, az> map = b;
        az azVar = map.get(str);
        if (azVar == null) {
            azVar = az.G(new bz());
            map.put(str, azVar);
        }
        if (azVar.u()) {
            azVar.j().b(str2, az.I(iDXFunction));
            return;
        }
        throw new IllegalStateException("objectName is not a builtin obj");
    }

    public boolean a(String str) {
        return !TextUtils.isEmpty(str) && this.a.containsKey(str);
    }

    public C9793a b(String str, byte[] bArr, int i) {
        this.a.remove(str);
        zy zyVar = new zy();
        zyVar.o(this);
        try {
            zyVar.a(bArr, i);
            this.a.put(str, zyVar);
            return new C9793a(true, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return new C9793a(false, th.getMessage(), null);
        }
    }

    public C9793a f(DXRuntimeContext dXRuntimeContext, hy hyVar, String str, int i, Object obj, Object obj2, Integer num, Map<String, az> map, DXJSMethodProxy dXJSMethodProxy, DXExprDxMethodProxy dXExprDxMethodProxy, DXBuiltinProvider dXBuiltinProvider) {
        zy zyVar = this.a.get(str);
        if (zyVar == null) {
            return new C9793a(false, "template engine not exist: " + str, null);
        }
        try {
            HashMap hashMap = new HashMap();
            if (obj != null && (obj instanceof JSONObject)) {
                hashMap.put("data", az.M((JSONObject) obj));
            } else if (obj != null && dXRuntimeContext.supportDataProxy()) {
                hashMap.put("data", az.K(obj));
            }
            if (obj2 != null && (obj2 instanceof JSONObject)) {
                hashMap.put("dataSource", az.M((JSONObject) obj2));
            } else if (obj2 != null && dXRuntimeContext.supportDataProxy()) {
                hashMap.put("dataSource", az.K(obj2));
            }
            if (dXRuntimeContext.getSubData() instanceof JSONObject) {
                hashMap.put(m80.SUBDATA_PREFIX, az.M((JSONObject) dXRuntimeContext.getSubData()));
            } else if (dXRuntimeContext.getSubData() != null && dXRuntimeContext.supportDataProxy() && (dXRuntimeContext.getSubData() instanceof Object)) {
                hashMap.put(m80.SUBDATA_PREFIX, az.K(dXRuntimeContext.getSubData()));
            }
            if (num != null) {
                hashMap.put("i", az.J(num.intValue()));
            }
            if (map != null) {
                hashMap.putAll(map);
            }
            return new C9793a(true, null, zyVar.m(dXRuntimeContext, hyVar, i, hashMap, dXJSMethodProxy, dXExprDxMethodProxy, dXBuiltinProvider));
        } catch (Throwable th) {
            ry.b(th);
            return new C9793a(false, th.getMessage(), null);
        }
    }
}
