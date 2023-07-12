package tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.analyze.GXAnalyze;
import com.alibaba.gaiax.template.GXIExpression;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import java.math.BigDecimal;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class yp0 implements GXIExpression {
    @NotNull
    public static final C9995b Companion = new C9995b(null);
    @NotNull
    private static final GXAnalyze b;
    @NotNull
    private final Object a;

    /* compiled from: Taobao */
    /* renamed from: tb.yp0$a */
    /* loaded from: classes6.dex */
    public static final class C9994a implements GXAnalyze.IComputeExtend {
        C9994a() {
        }

        @Override // com.alibaba.gaiax.analyze.GXAnalyze.IComputeExtend
        public long computeFunctionExpression(@NotNull String str, @NotNull long[] jArr) {
            Long execute;
            b41.i(str, "functionName");
            b41.i(jArr, "params");
            GXRegisterCenter.GXIExtensionFunctionExpression k = GXRegisterCenter.Companion.a().k();
            if (k == null || (execute = k.execute(str, jArr)) == null) {
                if (b41.d(str, "size") && jArr.length == 1) {
                    return yp0.Companion.d(jArr);
                }
                if (b41.d(str, "env") && jArr.length == 1) {
                    return yp0.Companion.c(jArr);
                }
                return 0L;
            }
            return execute.longValue();
        }

        @Override // com.alibaba.gaiax.analyze.GXAnalyze.IComputeExtend
        public long computeValueExpression(@NotNull String str, @Nullable Object obj) {
            b41.i(str, "valuePath");
            if (b41.d(str, "$$")) {
                if (obj instanceof JSONArray) {
                    return GXAnalyze.Companion.createValueArray(obj);
                }
                if (obj instanceof JSONObject) {
                    return GXAnalyze.Companion.createValueMap(obj);
                }
            }
            if (obj instanceof JSONObject) {
                Object c = yq0.c((JSON) obj, str);
                if (c instanceof JSONArray) {
                    return GXAnalyze.Companion.createValueArray(c);
                }
                if (c instanceof JSONObject) {
                    return GXAnalyze.Companion.createValueMap(c);
                }
                if (c instanceof Boolean) {
                    return GXAnalyze.Companion.createValueBool(((Boolean) c).booleanValue());
                }
                if (c instanceof String) {
                    return GXAnalyze.Companion.createValueString((String) c);
                }
                if (c instanceof Integer) {
                    return GXAnalyze.Companion.createValueLong(((Number) c).intValue());
                }
                if (c instanceof Float) {
                    return GXAnalyze.Companion.createValueFloat64(((Number) c).floatValue());
                }
                if (c instanceof Double) {
                    return GXAnalyze.Companion.createValueFloat64((float) ((Number) c).doubleValue());
                }
                if (c instanceof BigDecimal) {
                    return GXAnalyze.Companion.createValueFloat64(((BigDecimal) c).floatValue());
                }
                if (c instanceof Long) {
                    return GXAnalyze.Companion.createValueLong(((Number) c).longValue());
                }
                if (c == null) {
                    return GXAnalyze.Companion.createValueNull();
                }
                throw new IllegalArgumentException(b41.r("Not recognize value = ", c));
            }
            return 0L;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.yp0$b */
    /* loaded from: classes6.dex */
    public static final class C9995b {
        private C9995b() {
        }

        public /* synthetic */ C9995b(k50 k50Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long c(long[] jArr) {
            boolean q;
            boolean q2;
            GXAnalyze.Companion companion = GXAnalyze.Companion;
            ts0 h = companion.h(jArr[0]);
            if (h instanceof ks0) {
                String b = ((ks0) h).b();
                q = C8604o.q("isAndroid", b, true);
                if (q) {
                    return companion.createValueBool(true);
                }
                q2 = C8604o.q("isiOS", b, true);
                if (q2) {
                    return companion.createValueBool(false);
                }
                return 0L;
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long d(long[] jArr) {
            GXAnalyze.Companion companion = GXAnalyze.Companion;
            ts0 h = companion.h(jArr[0]);
            if (h instanceof ks0) {
                String b = ((ks0) h).b();
                if (b == null) {
                    return 0L;
                }
                return companion.createValueFloat64(b.length());
            }
            if (h instanceof nr0) {
                Object a = ((nr0) h).a();
                JSONObject jSONObject = a instanceof JSONObject ? (JSONObject) a : null;
                if (jSONObject == null) {
                    return 0L;
                }
                return companion.createValueFloat64(jSONObject.size());
            } else if (h instanceof aq0) {
                Object a2 = ((aq0) h).a();
                JSONArray jSONArray = a2 instanceof JSONArray ? (JSONArray) a2 : null;
                if (jSONArray == null) {
                    return 0L;
                }
                return companion.createValueFloat64(jSONArray.size());
            } else {
                return companion.createValueFloat64(0.0f);
            }
        }
    }

    static {
        GXAnalyze gXAnalyze = new GXAnalyze();
        b = gXAnalyze;
        gXAnalyze.initComputeExtend(new C9994a());
    }

    public yp0(@NotNull Object obj) {
        b41.i(obj, DXTraceUtil.TYPE_EXPRESSION_STRING);
        this.a = obj;
    }

    @Override // com.alibaba.gaiax.template.GXIExpression
    @NotNull
    public Object expression() {
        return this.a;
    }

    @Override // com.alibaba.gaiax.template.GXIExpression
    @Nullable
    public Object value(@Nullable JSON json) {
        return b.getResult(this.a, json);
    }
}
