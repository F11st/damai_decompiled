package tb;

import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class oy {
    public static final int FAILURE = 1;
    public static final int FINISH = 0;
    public static final int INTERRUPT = 2;
    private int a = 0;
    private JSONObject b = null;

    /* compiled from: Taobao */
    /* renamed from: tb.oy$a */
    /* loaded from: classes11.dex */
    public static class C9535a {
        public int a;
        public String b;

        public C9535a(int i, String str) {
            this.a = i;
            this.b = str;
        }

        public String toString() {
            return "DXAtomicEventError{errorCode=" + this.a + ", errorMsg='" + this.b + "'}";
        }
    }

    public static oy a(int i, String str) {
        oy oyVar = new oy();
        oyVar.a = 1;
        new C9535a(i, str);
        return oyVar;
    }

    public static oy b(ky kyVar) {
        oy oyVar = new oy();
        oyVar.a = 1;
        new C9535a(kyVar.a, kyVar.b);
        return oyVar;
    }

    public static oy c(JSONObject jSONObject) {
        oy oyVar = new oy();
        oyVar.a = 0;
        oyVar.b = jSONObject;
        return oyVar;
    }

    public static oy d(int i, String str) {
        oy oyVar = new oy();
        oyVar.a = 2;
        new C9535a(i, str);
        return oyVar;
    }

    public static oy e(C9392l c9392l) {
        if (c9392l == null) {
            return b(ky.EVENT_CHAIN_ERROR_ABILITY_EXEC_RESULT_IS_NULL);
        }
        if (c9392l.b()) {
            C9327k c9327k = (C9327k) c9392l;
            if (c9392l.c()) {
                return d(c9327k.a().a(), c9327k.a().b());
            }
            return a(c9327k.a().a(), c9327k.a().b());
        }
        return c(((C9488o) c9392l).a());
    }

    public JSONObject f() {
        return this.b;
    }

    public int g() {
        return this.a;
    }
}
