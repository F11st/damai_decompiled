package com.youku.gaiax.impl.register;

import android.os.SystemClock;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.analyze.GXAnalyze;
import com.alibaba.gaiax.template.GXIExpression;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.impl.GaiaXExpression;
import com.youku.gaiax.impl.GaiaXProxy;
import java.math.BigDecimal;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.aq0;
import tb.b41;
import tb.k50;
import tb.ks0;
import tb.nr0;
import tb.ts0;
import tb.xq0;
import tb.yq0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J$\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionExpression;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionExpression;", "", "value", "Lcom/alibaba/gaiax/template/GXIExpression;", "create", "", "isTrue", "", "expVersion", "key", "<init>", "()V", "Companion", "GXAnalyzeWrapper", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXExtensionExpression implements GXRegisterCenter.GXIExtensionExpression {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static int expressionCount;
    private static long expressionV2Time;
    @NotNull
    private static final Lazy<GXExtensionExpression> instance$delegate;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionExpression$Companion;", "", "Lcom/youku/gaiax/impl/register/GXExtensionExpression;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/gaiax/impl/register/GXExtensionExpression;", "instance", "", "expressionV2Time", "J", "getExpressionV2Time", "()J", "setExpressionV2Time", "(J)V", "", "expressionCount", "I", "getExpressionCount", "()I", "setExpressionCount", "(I)V", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        public final int getExpressionCount() {
            return GXExtensionExpression.expressionCount;
        }

        public final long getExpressionV2Time() {
            return GXExtensionExpression.expressionV2Time;
        }

        @NotNull
        public final GXExtensionExpression getInstance() {
            return (GXExtensionExpression) GXExtensionExpression.instance$delegate.getValue();
        }

        public final void setExpressionCount(int i) {
            GXExtensionExpression.expressionCount = i;
        }

        public final void setExpressionV2Time(long j) {
            GXExtensionExpression.expressionV2Time = j;
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionExpression$GXAnalyzeWrapper;", "Lcom/alibaba/gaiax/template/GXIExpression;", "", DXTraceUtil.TYPE_EXPRESSION_STRING, "Lcom/alibaba/fastjson/JSON;", "templateData", "value", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GXAnalyzeWrapper implements GXIExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private static final GXAnalyze analyze;
        @NotNull
        private final Object expression;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionExpression$GXAnalyzeWrapper$Companion;", "", "value", "", "createByAny", "Lcom/alibaba/gaiax/analyze/GXAnalyze;", "analyze", "Lcom/alibaba/gaiax/analyze/GXAnalyze;", "getAnalyze", "()Lcom/alibaba/gaiax/analyze/GXAnalyze;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final long createByAny(Object obj) {
                if (obj instanceof JSONArray) {
                    return GXAnalyze.Companion.createValueArray(obj);
                }
                if (obj instanceof JSONObject) {
                    return GXAnalyze.Companion.createValueMap(obj);
                }
                if (obj instanceof Boolean) {
                    return GXAnalyze.Companion.createValueBool(((Boolean) obj).booleanValue());
                }
                if (obj instanceof String) {
                    return GXAnalyze.Companion.createValueString((String) obj);
                }
                if (obj instanceof Integer) {
                    return GXAnalyze.Companion.createValueFloat64(((Number) obj).intValue());
                }
                if (obj instanceof Float) {
                    return GXAnalyze.Companion.createValueFloat64(((Number) obj).floatValue());
                }
                if (obj instanceof Double) {
                    return GXAnalyze.Companion.createValueFloat64((float) ((Number) obj).doubleValue());
                }
                if (obj instanceof BigDecimal) {
                    return GXAnalyze.Companion.createValueFloat64(((BigDecimal) obj).floatValue());
                }
                if (obj == null) {
                    return GXAnalyze.Companion.createValueNull();
                }
                throw new IllegalArgumentException(b41.r("Not recognize value = ", obj));
            }

            @NotNull
            public final GXAnalyze getAnalyze() {
                return GXAnalyzeWrapper.analyze;
            }
        }

        static {
            GXAnalyze gXAnalyze = new GXAnalyze();
            analyze = gXAnalyze;
            gXAnalyze.initComputeExtend(new GXAnalyze.IComputeExtend() { // from class: com.youku.gaiax.impl.register.GXExtensionExpression.GXAnalyzeWrapper.Companion.1
                @Override // com.alibaba.gaiax.analyze.GXAnalyze.IComputeExtend
                public long computeFunctionExpression(@NotNull String str, @NotNull long[] jArr) {
                    String b;
                    IProxyFeatures features;
                    Object envExpressionResult;
                    b41.i(str, "functionName");
                    b41.i(jArr, "params");
                    if (b41.d(str, "size") && jArr.length == 1) {
                        GXAnalyze.Companion companion = GXAnalyze.Companion;
                        ts0 h = companion.h(jArr[0]);
                        if (h instanceof ks0) {
                            String b2 = ((ks0) h).b();
                            if (b2 == null) {
                                return 0L;
                            }
                            return companion.createValueFloat64(b2.length());
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
                            return 0L;
                        }
                    } else if (b41.d(str, "env") && jArr.length == 1) {
                        ts0 h2 = GXAnalyze.Companion.h(jArr[0]);
                        if (!(h2 instanceof ks0) || (b = ((ks0) h2).b()) == null || (features = GaiaXProxy.Companion.getInstance().getFeatures()) == null || (envExpressionResult = features.getEnvExpressionResult(b)) == null) {
                            return 0L;
                        }
                        return GXAnalyzeWrapper.Companion.createByAny(envExpressionResult);
                    } else {
                        return 0L;
                    }
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
                        return GXAnalyzeWrapper.Companion.createByAny(yq0.c((JSON) obj, str));
                    }
                    return 0L;
                }
            });
        }

        public GXAnalyzeWrapper(@NotNull Object obj) {
            b41.i(obj, DXTraceUtil.TYPE_EXPRESSION_STRING);
            this.expression = obj;
        }

        @Override // com.alibaba.gaiax.template.GXIExpression
        @NotNull
        public Object expression() {
            return this.expression;
        }

        @Override // com.alibaba.gaiax.template.GXIExpression
        @Nullable
        public Object value(@Nullable JSON json) {
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            Object result = analyze.getResult(this.expression, json);
            long elapsedRealtimeNanos2 = SystemClock.elapsedRealtimeNanos();
            Companion companion = GXExtensionExpression.Companion;
            companion.setExpressionV2Time((elapsedRealtimeNanos2 - elapsedRealtimeNanos) + companion.getExpressionV2Time());
            companion.setExpressionCount(companion.getExpressionCount() + 1);
            return result;
        }
    }

    static {
        Lazy<GXExtensionExpression> b;
        b = b.b(new Function0<GXExtensionExpression>() { // from class: com.youku.gaiax.impl.register.GXExtensionExpression$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXExtensionExpression invoke() {
                return new GXExtensionExpression();
            }
        });
        instance$delegate = b;
    }

    @NotNull
    public final GXIExpression create(@NotNull Object obj) {
        b41.i(obj, "value");
        return create(null, null, obj);
    }

    public final boolean isTrue(@Nullable Object obj) {
        return isTrue(null, null, obj);
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionExpression
    @NotNull
    public GXIExpression create(@Nullable String str, @Nullable String str2, @NotNull Object obj) {
        b41.i(obj, "value");
        if (b41.d(str, "V2")) {
            return new GXAnalyzeWrapper(obj);
        }
        if (b41.d(str2, "fit-content")) {
            String str3 = b41.d(xq0.INSTANCE.c(str, obj), Boolean.TRUE) ? "true" : "false";
            GaiaXExpression create = GaiaXExpression.Companion.create(str3);
            create.setExpression(str3);
            return create;
        }
        GaiaXExpression create2 = GaiaXExpression.Companion.create(obj);
        create2.setExpression(obj);
        return create2;
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionExpression
    public boolean isTrue(@Nullable String str, @Nullable String str2, @Nullable Object obj) {
        if (b41.d(str, "V2")) {
            return b41.d(Boolean.TRUE, obj);
        }
        return GaiaXExpression.Companion.isCondition(obj);
    }
}
