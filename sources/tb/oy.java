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
    /* loaded from: classes11.dex */
    public static class a {
        public int a;
        public String b;

        public a(int i, String str) {
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
        new a(i, str);
        return oyVar;
    }

    public static oy b(ky kyVar) {
        oy oyVar = new oy();
        oyVar.a = 1;
        new a(kyVar.a, kyVar.b);
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
        new a(i, str);
        return oyVar;
    }

    public static oy e(l lVar) {
        if (lVar == null) {
            return b(ky.EVENT_CHAIN_ERROR_ABILITY_EXEC_RESULT_IS_NULL);
        }
        if (lVar.b()) {
            k kVar = (k) lVar;
            if (lVar.c()) {
                return d(kVar.a().a(), kVar.a().b());
            }
            return a(kVar.a().a(), kVar.a().b());
        }
        return c(((o) lVar).a());
    }

    public JSONObject f() {
        return this.b;
    }

    public int g() {
        return this.a;
    }
}
