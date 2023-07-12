package com.alibaba.gaiax.analyze;

import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.aq0;
import tb.b41;
import tb.dr0;
import tb.k50;
import tb.kq0;
import tb.ks0;
import tb.lr0;
import tb.nr0;
import tb.ts0;
import tb.wr0;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002J#\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0082 J\u0011\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0001H\u0082 J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001R\u001c\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/alibaba/gaiax/analyze/GXAnalyze;", "", "Lcom/alibaba/fastjson/JSONArray;", DXTraceUtil.TYPE_EXPRESSION_STRING, "data", "getJsonArrayResult", "Lcom/alibaba/fastjson/JSONObject;", "getJsonResult", "self", "", "", "getResultNative", "Ltb/wt2;", "initNative", "Lcom/alibaba/gaiax/analyze/GXAnalyze$IComputeExtend;", "computeExtend", "initComputeExtend", "getResult", "pointer", "J", "getPointer", "()J", "Lcom/alibaba/gaiax/analyze/GXAnalyze$IComputeExtend;", "getComputeExtend", "()Lcom/alibaba/gaiax/analyze/GXAnalyze$IComputeExtend;", "setComputeExtend", "(Lcom/alibaba/gaiax/analyze/GXAnalyze$IComputeExtend;)V", "<init>", "()V", "Companion", "IComputeExtend", "GaiaX-Analyze"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public final class GXAnalyze {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int TYPE_ARRAY;
    private static final int TYPE_BOOLEAN;
    private static final int TYPE_EXCEPTION;
    private static final int TYPE_FLOAT = 0;
    private static final int TYPE_LONG;
    private static final int TYPE_MAP;
    private static final int TYPE_NULL;
    private static final int TYPE_OBJECT;
    private static final int TYPE_STRING;
    private static final int TYPE_VALUE;
    @Nullable
    private IComputeExtend computeExtend;
    private final long pointer;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086 J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0086 J\u0011\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0086 J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0086 J\u0013\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086 J\u0013\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086 J\u0011\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0086 J\u0011\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0086 J\u0011\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0006H\u0086 J\u0011\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0086 J\u0013\u0010\u0012\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0086 J\u0013\u0010\u0013\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0086 J\t\u0010\u0014\u001a\u00020\u0002H\u0086 J\u0011\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0086 J\u0011\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0086 ¨\u0006\u001a"}, d2 = {"Lcom/alibaba/gaiax/analyze/GXAnalyze$Companion;", "", "", "value", "", "getValueTag", "", "getValueString", "", "getValueBoolean", "", "getValueFloat", "getValueArray", "getValueMap", "getValueLong", "createValueFloat64", "createValueString", "createValueBool", "createValueArray", "createValueMap", "createValueNull", "createValueLong", "Ltb/wt2;", "releaseGXValue", "<init>", "()V", "GaiaX-Analyze"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        public final int a() {
            return GXAnalyze.TYPE_ARRAY;
        }

        public final int b() {
            return GXAnalyze.TYPE_BOOLEAN;
        }

        public final int c() {
            return GXAnalyze.TYPE_FLOAT;
        }

        public final native long createValueArray(@Nullable Object obj);

        public final native long createValueBool(boolean z);

        public final native long createValueFloat64(float f);

        public final native long createValueLong(long j);

        public final native long createValueMap(@Nullable Object obj);

        public final native long createValueNull();

        public final native long createValueString(@NotNull String str);

        public final int d() {
            return GXAnalyze.TYPE_LONG;
        }

        public final int e() {
            return GXAnalyze.TYPE_MAP;
        }

        public final int f() {
            return GXAnalyze.TYPE_NULL;
        }

        public final int g() {
            return GXAnalyze.TYPE_STRING;
        }

        @Nullable
        public final native Object getValueArray(long j);

        public final native boolean getValueBoolean(long j);

        public final native float getValueFloat(long j);

        public final native long getValueLong(long j);

        @Nullable
        public final native Object getValueMap(long j);

        @NotNull
        public final native String getValueString(long j);

        public final native int getValueTag(long j);

        @Nullable
        public final ts0 h(long j) {
            ts0 lr0Var;
            try {
                if (j != 0) {
                    int valueTag = getValueTag(j);
                    if (valueTag == f()) {
                        lr0Var = new wr0();
                    } else if (valueTag == g()) {
                        lr0Var = new ks0(getValueString(j));
                    } else if (valueTag == a()) {
                        lr0Var = new aq0(getValueArray(j));
                    } else if (valueTag == e()) {
                        lr0Var = new nr0(getValueMap(j));
                    } else if (valueTag == b()) {
                        lr0Var = new kq0(getValueBoolean(j));
                    } else if (valueTag == c()) {
                        lr0Var = new dr0(getValueFloat(j));
                    } else {
                        lr0Var = valueTag == d() ? new lr0(getValueLong(j)) : null;
                    }
                    releaseGXValue(j);
                    return lr0Var;
                }
                throw new IllegalStateException("Can't wrap null pointer as GXValue".toString());
            } catch (Exception unused) {
                return null;
            }
        }

        public final native void releaseGXValue(long j);
    }

    /* compiled from: Taobao */
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¨\u0006\u000b"}, d2 = {"Lcom/alibaba/gaiax/analyze/GXAnalyze$IComputeExtend;", "", "", "valuePath", "source", "", "computeValueExpression", "functionName", "", "params", "computeFunctionExpression", "GaiaX-Analyze"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public interface IComputeExtend {
        long computeFunctionExpression(@NotNull String str, @NotNull long[] jArr);

        long computeValueExpression(@NotNull String str, @Nullable Object obj);
    }

    static {
        System.loadLibrary("GXAnalyzeAndroid");
        TYPE_BOOLEAN = 1;
        TYPE_NULL = 2;
        TYPE_VALUE = 3;
        TYPE_STRING = 4;
        TYPE_OBJECT = 5;
        TYPE_ARRAY = 6;
        TYPE_MAP = 7;
        TYPE_LONG = 8;
        TYPE_EXCEPTION = 9;
    }

    public GXAnalyze() {
        initNative(this);
    }

    private final Object getJsonArrayResult(JSONArray jSONArray, Object obj) {
        JSONArray jSONArray2 = new JSONArray();
        for (Object obj2 : jSONArray) {
            b41.h(obj2, AdvanceSetting.NETWORK_TYPE);
            jSONArray2.add(getResult(obj2, obj));
        }
        return jSONArray2;
    }

    private final Object getJsonResult(JSONObject jSONObject, Object obj) {
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            b41.h(value, "it.value");
            jSONObject2.put((JSONObject) key, (String) getResult(value, obj));
        }
        return jSONObject2;
    }

    private final native long getResultNative(Object obj, String str, Object obj2);

    private final native void initNative(Object obj);

    @Nullable
    public final IComputeExtend getComputeExtend() {
        return this.computeExtend;
    }

    public final long getPointer() {
        return this.pointer;
    }

    @Nullable
    public final Object getResult(@NotNull Object obj, @Nullable Object obj2) {
        CharSequence M0;
        CharSequence M02;
        b41.i(obj, DXTraceUtil.TYPE_EXPRESSION_STRING);
        if (obj instanceof String) {
            String str = (String) obj;
            M0 = StringsKt__StringsKt.M0(str);
            if (b41.d(M0.toString(), "$$")) {
                return obj2;
            }
            M02 = StringsKt__StringsKt.M0(str);
            if (b41.d(M02.toString(), "")) {
                return null;
            }
            ts0 h = Companion.h(getResultNative(this, str, obj2));
            if (h == null) {
                return null;
            }
            return h.a();
        } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Boolean)) {
            return obj;
        } else {
            if (obj instanceof JSONObject) {
                return getJsonResult((JSONObject) obj, obj2);
            }
            if (obj instanceof JSONArray) {
                return getJsonArrayResult((JSONArray) obj, obj2);
            }
            return null;
        }
    }

    public final void initComputeExtend(@NotNull IComputeExtend iComputeExtend) {
        b41.i(iComputeExtend, "computeExtend");
        this.computeExtend = iComputeExtend;
    }

    public final void setComputeExtend(@Nullable IComputeExtend iComputeExtend) {
        this.computeExtend = iComputeExtend;
    }
}
