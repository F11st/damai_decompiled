package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXBuiltinProvider;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprDxMethodProxy;
import com.taobao.android.dinamicx.expression.expr_v2.DXJSMethodProxy;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class zy {
    private static xu g = new xu();
    private static ox h = new ox();
    private static ax i = new ax();
    private static uv j = new uv();
    private static zw k = new zw();
    private static jw l = new jw();
    private static zv m = new zv();
    private static cx n = new cx();
    private static kw o = new kw();
    private boolean a = false;
    private boolean b = true;
    private sy c = new sy();
    private final ArrayList<az> d = new ArrayList<>();
    private final Stack<az> e = new Stack<>();
    private boolean f = false;

    private az b(az azVar, az azVar2) {
        if (azVar.A() && azVar2.A()) {
            return j(azVar.b() + azVar2.b());
        }
        if (azVar.v()) {
            azVar = j(azVar.b());
        }
        if (azVar2.v()) {
            azVar2 = j(azVar2.b());
        }
        return az.N(azVar.toString() + azVar2.toString());
    }

    private az c(az azVar, az azVar2, hy hyVar, DXRuntimeContext dXRuntimeContext, com.taobao.android.dinamicx.expression.parser.a aVar) {
        az[] azVarArr = {azVar, azVar2};
        ez ezVar = new ez();
        ezVar.b(hyVar);
        try {
            return aVar.call(dXRuntimeContext, null, 2, azVarArr, ezVar);
        } catch (Throwable th) {
            az.L();
            throw new IllegalArgumentException("FunctionError: " + th.getMessage(), th);
        }
    }

    private az d(az azVar, az azVar2) {
        if (!azVar.A() && !azVar2.A()) {
            throw new IllegalStateException("Can't do " + azVar + " / " + azVar2);
        }
        return j(azVar.b() / azVar2.b());
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private tb.az e(com.taobao.android.dinamicx.DXRuntimeContext r6, tb.az r7, tb.az r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.zy.e(com.taobao.android.dinamicx.DXRuntimeContext, tb.az, tb.az, boolean):tb.az");
    }

    private az f(az azVar, az azVar2) {
        if (!azVar.A() && !azVar2.A()) {
            throw new IllegalStateException("Can't do " + azVar + " * " + azVar2);
        }
        return j(azVar.b() * azVar2.b());
    }

    private az g(az azVar, az azVar2) {
        if (!azVar.A() && !azVar2.A()) {
            throw new IllegalStateException("Can't do " + azVar + " - " + azVar2);
        }
        return j(azVar.e() - azVar2.e());
    }

    private az h(JSONArray jSONArray, int i2) {
        Object obj = jSONArray.get(i2);
        if (obj == null) {
            return az.O();
        }
        return az.d(obj);
    }

    private az i(JSONObject jSONObject, String str) {
        Object obj = jSONObject.get(str);
        if (obj == null) {
            return az.O();
        }
        return az.d(obj);
    }

    private az j(double d) {
        long round = Math.round(d);
        if (round == d) {
            return az.J(round);
        }
        return az.H(d);
    }

    private boolean k(DXRuntimeContext dXRuntimeContext) {
        return dXRuntimeContext.getEngineContext().h();
    }

    private az l(int i2) {
        az azVar = this.d.get(i2);
        if (azVar == null) {
            azVar = this.c.c(i2);
            this.d.set(i2, azVar);
        }
        if (azVar != null) {
            return azVar;
        }
        throw new IllegalArgumentException("Invalid const: " + i2);
    }

    private boolean p(az azVar, az azVar2) {
        if (azVar2.q() == azVar.q()) {
            switch (azVar2.q()) {
                case 0:
                case 1:
                    return true;
                case 2:
                    if (azVar2.m() == azVar.m()) {
                        return true;
                    }
                    break;
                case 3:
                    if (Double.compare(azVar2.k(), azVar.k()) == 0) {
                        return true;
                    }
                    break;
                case 4:
                    if (azVar2.i() == azVar.i()) {
                        return true;
                    }
                    break;
                case 5:
                    return azVar2.p().equals(azVar.p());
                case 6:
                case 7:
                case 8:
                case 9:
                    return azVar2.C(azVar);
                default:
                    throw new IllegalArgumentException("invalid type");
            }
        }
        return false;
    }

    public void a(byte[] bArr, int i2) {
        this.f = true;
        this.c.g(bArr, i2);
        int d = this.c.d();
        this.d.clear();
        this.d.ensureCapacity(d);
        for (int i3 = 0; i3 < d; i3++) {
            this.d.add(null);
        }
    }

    public az m(DXRuntimeContext dXRuntimeContext, hy hyVar, int i2, Map<String, az> map, DXJSMethodProxy dXJSMethodProxy, DXExprDxMethodProxy dXExprDxMethodProxy, DXBuiltinProvider dXBuiltinProvider) {
        if (this.f) {
            try {
                n(dXRuntimeContext, hyVar, this.c.b(), this.c.f(i2), this.c.e(i2), map, dXJSMethodProxy, dXExprDxMethodProxy, dXBuiltinProvider);
                if (this.e.size() != 0) {
                    if (this.e.size() <= 1) {
                        return this.e.pop();
                    }
                    throw new IllegalStateException("invalid stack size. vm error");
                }
                throw new IllegalStateException("expression has no return value");
            } catch (Throwable th) {
                this.e.clear();
                throw th;
            }
        }
        throw new IllegalStateException("run before decode");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x0716, code lost:
        if (r21.e.pop().c() != false) goto L320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x0755, code lost:
        if (r21.e.pop().c() == false) goto L320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x0757, code lost:
        r3 = (r1 - r17) - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x075d, code lost:
        r3 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x075e, code lost:
        r15 = r3;
        r8 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0254, code lost:
        if (r21.b != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void n(com.taobao.android.dinamicx.DXRuntimeContext r22, tb.hy r23, byte[] r24, int r25, int r26, java.util.Map<java.lang.String, tb.az> r27, com.taobao.android.dinamicx.expression.expr_v2.DXJSMethodProxy r28, com.taobao.android.dinamicx.expression.expr_v2.DXExprDxMethodProxy r29, com.taobao.android.dinamicx.expression.expr_v2.DXBuiltinProvider r30) {
        /*
            Method dump skipped, instructions count: 3054
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.zy.n(com.taobao.android.dinamicx.DXRuntimeContext, tb.hy, byte[], int, int, java.util.Map, com.taobao.android.dinamicx.expression.expr_v2.DXJSMethodProxy, com.taobao.android.dinamicx.expression.expr_v2.DXExprDxMethodProxy, com.taobao.android.dinamicx.expression.expr_v2.DXBuiltinProvider):void");
    }

    public void o(uy uyVar) {
    }

    public String toString() {
        return "DXExprVM{mConst=" + this.d + ", mVarStack=" + this.e + '}';
    }
}
