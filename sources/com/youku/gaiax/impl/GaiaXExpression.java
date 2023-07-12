package com.youku.gaiax.impl;

import android.os.SystemClock;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXIExpression;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.sequences.C8576d;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.C8604o;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jn1;
import tb.k50;
import tb.m80;
import tb.rz0;
import tb.yq0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00102\u00020\u0001:\u0014\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#B\t\b\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0016\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u0082\u0001\u0013$%&'()*+,-./0123456¨\u00067"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/gaiax/template/GXIExpression;", "", DXTraceUtil.TYPE_EXPRESSION_STRING, "Lcom/alibaba/fastjson/JSON;", "templateData", "value", "rawJson", "desireData", "Ljava/lang/Object;", "getExpression", "()Ljava/lang/Object;", "setExpression", "(Ljava/lang/Object;)V", "<init>", "()V", "Companion", "GBool", "GEnv", "GEval", "GFloat", "GInt", "GJsonArrayObj", "GJsonObj", "GNull", "GScroll", "GSize", "GString", "GTernaryValue1", "GTernaryValue2", "GTernaryValue3", "GText", "GTextValue", "GValue", "Self", "Undefined", "Lcom/youku/gaiax/impl/GaiaXExpression$Undefined;", "Lcom/youku/gaiax/impl/GaiaXExpression$Self;", "Lcom/youku/gaiax/impl/GaiaXExpression$GEval;", "Lcom/youku/gaiax/impl/GaiaXExpression$GEnv;", "Lcom/youku/gaiax/impl/GaiaXExpression$GScroll;", "Lcom/youku/gaiax/impl/GaiaXExpression$GSize;", "Lcom/youku/gaiax/impl/GaiaXExpression$GJsonObj;", "Lcom/youku/gaiax/impl/GaiaXExpression$GJsonArrayObj;", "Lcom/youku/gaiax/impl/GaiaXExpression$GBool;", "Lcom/youku/gaiax/impl/GaiaXExpression$GString;", "Lcom/youku/gaiax/impl/GaiaXExpression$GFloat;", "Lcom/youku/gaiax/impl/GaiaXExpression$GInt;", "Lcom/youku/gaiax/impl/GaiaXExpression$GNull;", "Lcom/youku/gaiax/impl/GaiaXExpression$GText;", "Lcom/youku/gaiax/impl/GaiaXExpression$GValue;", "Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue1;", "Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue2;", "Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue3;", "Lcom/youku/gaiax/impl/GaiaXExpression$GTextValue;", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class GaiaXExpression implements GXIExpression {
    private static int expressionV1Count;
    private static long expressionV1Time;
    @Nullable
    private Object expression;
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final Pattern valueFullRegex = Pattern.compile("^\\$\\{(.*?)\\}$");
    private static final Pattern valueRegex = Pattern.compile("\\$\\{(.*?)\\}");

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b#\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0001R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R'\u0010\u001a\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0006@\u0006¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR'\u0010 \u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0006@\u0006¢\u0006\u0012\n\u0004\b \u0010\u001b\u0012\u0004\b\"\u0010\u001f\u001a\u0004\b!\u0010\u001d¨\u0006$"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$Companion;", "", "", "condition", "", "isFitContentCondition", "isCondition", DXTraceUtil.TYPE_EXPRESSION_STRING, "Lcom/youku/gaiax/impl/GaiaXExpression;", "create", "", "expressionV1Time", "J", "getExpressionV1Time", "()J", "setExpressionV1Time", "(J)V", "", "expressionV1Count", "I", "getExpressionV1Count", "()I", "setExpressionV1Count", "(I)V", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "valueFullRegex", "Ljava/util/regex/Pattern;", "getValueFullRegex", "()Ljava/util/regex/Pattern;", "getValueFullRegex$annotations", "()V", "valueRegex", "getValueRegex", "getValueRegex$annotations", "<init>", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        public static /* synthetic */ void getValueFullRegex$annotations() {
        }

        public static /* synthetic */ void getValueRegex$annotations() {
        }

        @NotNull
        public final GaiaXExpression create(@NotNull Object obj) {
            GaiaXExpression gFloat;
            CharSequence M0;
            b41.i(obj, DXTraceUtil.TYPE_EXPRESSION_STRING);
            if (obj instanceof JSON) {
                GJsonObj.Companion companion = GJsonObj.Companion;
                if (companion.isExpression(obj)) {
                    return companion.create((JSONObject) obj);
                }
                GJsonArrayObj.Companion companion2 = GJsonArrayObj.Companion;
                return companion2.isExpression(obj) ? companion2.create((JSONArray) obj) : Undefined.INSTANCE;
            } else if (obj instanceof String) {
                M0 = StringsKt__StringsKt.M0((String) obj);
                String obj2 = M0.toString();
                Self self = Self.INSTANCE;
                if (self.isExpression(obj2)) {
                    return self;
                }
                GNull.Companion companion3 = GNull.Companion;
                if (companion3.isExpression(obj2)) {
                    return companion3.create();
                }
                GBool.Companion companion4 = GBool.Companion;
                if (companion4.isExpression(obj2)) {
                    return companion4.create(obj2);
                }
                GInt.Companion companion5 = GInt.Companion;
                if (companion5.isExpression(obj2)) {
                    return companion5.create(obj2);
                }
                GFloat.Companion companion6 = GFloat.Companion;
                if (companion6.isExpression(obj2)) {
                    return companion6.create(obj2);
                }
                GString.Companion companion7 = GString.Companion;
                if (companion7.isExpression(obj2)) {
                    return companion7.create(obj2);
                }
                GEval.Companion companion8 = GEval.Companion;
                if (companion8.isExpression(obj2)) {
                    return companion8.create(obj2);
                }
                GEnv.Companion companion9 = GEnv.Companion;
                if (companion9.isExpression(obj2)) {
                    return companion9.create(obj2);
                }
                GScroll.Companion companion10 = GScroll.Companion;
                if (companion10.isExpression(obj2)) {
                    return companion10.create(obj2);
                }
                GSize.Companion companion11 = GSize.Companion;
                if (companion11.isExpression(obj2)) {
                    return companion11.create(obj2);
                }
                GTextValue.Companion companion12 = GTextValue.Companion;
                if (companion12.isExpression(obj2)) {
                    return companion12.create(obj2);
                }
                GValue.Companion companion13 = GValue.Companion;
                if (companion13.isExpression(obj2)) {
                    return companion13.create(obj2);
                }
                GTernaryValue3.Companion companion14 = GTernaryValue3.Companion;
                if (companion14.isExpression(obj2)) {
                    return companion14.create(obj2);
                }
                GTernaryValue1.Companion companion15 = GTernaryValue1.Companion;
                if (companion15.isExpression(obj2)) {
                    return companion15.create(obj2);
                }
                GTernaryValue2.Companion companion16 = GTernaryValue2.Companion;
                if (companion16.isExpression(obj2)) {
                    return companion16.create(obj2);
                }
                GText.Companion companion17 = GText.Companion;
                return companion17.isExpression(obj2) ? companion17.create(obj2) : b41.d(obj, StringUtils.LF) ? companion17.create(StringUtils.LF) : Undefined.INSTANCE;
            } else {
                if (obj instanceof Boolean) {
                    gFloat = new GBool(((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    gFloat = new GInt(((Number) obj).intValue());
                } else if (!(obj instanceof Float)) {
                    return Undefined.INSTANCE;
                } else {
                    gFloat = new GFloat(((Number) obj).floatValue());
                }
                return gFloat;
            }
        }

        public final int getExpressionV1Count() {
            return GaiaXExpression.expressionV1Count;
        }

        public final long getExpressionV1Time() {
            return GaiaXExpression.expressionV1Time;
        }

        public final Pattern getValueFullRegex() {
            return GaiaXExpression.valueFullRegex;
        }

        public final Pattern getValueRegex() {
            return GaiaXExpression.valueRegex;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
            if ((((java.lang.Number) r5).floatValue() == 0.0f) == false) goto L5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x006f, code lost:
            if ((!r3) != false) goto L5;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean isCondition(@org.jetbrains.annotations.Nullable java.lang.Object r5) {
            /*
                r4 = this;
                boolean r0 = r5 instanceof java.lang.Boolean
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L10
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                boolean r0 = tb.b41.d(r5, r0)
                if (r0 == 0) goto L10
            Le:
                r1 = 1
                goto L81
            L10:
                boolean r0 = r5 instanceof java.lang.Number
                r3 = 0
                if (r0 == 0) goto L26
                r0 = r5
                java.lang.Number r0 = (java.lang.Number) r0
                float r0 = r0.floatValue()
                int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r0 != 0) goto L22
                r0 = 1
                goto L23
            L22:
                r0 = 0
            L23:
                if (r0 != 0) goto L26
                goto Le
            L26:
                java.lang.String r0 = "0"
                boolean r0 = tb.b41.d(r5, r0)
                if (r0 != 0) goto L81
                java.lang.String r0 = "false"
                boolean r0 = tb.b41.d(r5, r0)
                if (r0 != 0) goto L81
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                boolean r0 = tb.b41.d(r5, r0)
                if (r0 != 0) goto L81
                java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
                boolean r0 = tb.b41.d(r5, r0)
                if (r0 != 0) goto L81
                java.lang.Float r0 = java.lang.Float.valueOf(r3)
                boolean r0 = tb.b41.d(r5, r0)
                if (r0 == 0) goto L53
                goto L81
            L53:
                java.lang.String r0 = "1"
                boolean r0 = tb.b41.d(r5, r0)
                if (r0 != 0) goto Le
                java.lang.String r0 = "true"
                boolean r0 = tb.b41.d(r5, r0)
                if (r0 != 0) goto Le
                boolean r0 = r5 instanceof java.lang.String
                if (r0 == 0) goto L72
                r3 = r5
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                boolean r3 = kotlin.text.C8596g.s(r3)
                r3 = r3 ^ r2
                if (r3 == 0) goto L72
                goto Le
            L72:
                if (r0 == 0) goto L7e
                r0 = r5
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = kotlin.text.C8596g.s(r0)
                if (r0 == 0) goto L7e
                return r1
            L7e:
                if (r5 == 0) goto L81
                goto Le
            L81:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.youku.gaiax.impl.GaiaXExpression.Companion.isCondition(java.lang.Object):boolean");
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean isFitContentCondition(@org.jetbrains.annotations.NotNull java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r0 = "condition"
                tb.b41.i(r3, r0)
                int r0 = r3.hashCode()
                r1 = 0
                switch(r0) {
                    case 48: goto L34;
                    case 49: goto L29;
                    case 47602: goto L26;
                    case 48563: goto L1d;
                    case 3569038: goto L14;
                    case 97196323: goto Le;
                    default: goto Ld;
                }
            Ld:
                goto L37
            Le:
                java.lang.String r0 = "false"
            L10:
                r3.equals(r0)
                goto L37
            L14:
                java.lang.String r0 = "true"
                boolean r3 = r3.equals(r0)
                if (r3 != 0) goto L32
                goto L37
            L1d:
                java.lang.String r0 = "1.0"
                boolean r3 = r3.equals(r0)
                if (r3 != 0) goto L32
                goto L37
            L26:
                java.lang.String r0 = "0.0"
                goto L10
            L29:
                java.lang.String r0 = "1"
                boolean r3 = r3.equals(r0)
                if (r3 != 0) goto L32
                goto L37
            L32:
                r1 = 1
                goto L37
            L34:
                java.lang.String r0 = "0"
                goto L10
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.youku.gaiax.impl.GaiaXExpression.Companion.isFitContentCondition(java.lang.String):boolean");
        }

        public final void setExpressionV1Count(int i) {
            GaiaXExpression.expressionV1Count = i;
        }

        public final void setExpressionV1Time(long j) {
            GaiaXExpression.expressionV1Time = j;
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\n\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GBool;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "", "component1", "value", rz0.ARG_COPY, "", "hashCode", "other", "equals", "Z", "getValue", "()Z", "<init>", "(Z)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GBool extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        private final boolean value;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GBool$Companion;", "", "", "value", "Lcom/youku/gaiax/impl/GaiaXExpression$GBool;", "create", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            @NotNull
            public final GBool create(@NotNull String str) {
                b41.i(str, "value");
                return new GBool(Boolean.parseBoolean(str));
            }

            public final boolean isExpression(@NotNull String str) {
                b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return b41.d(str, "true") || b41.d(str, "false");
            }
        }

        public GBool(boolean z) {
            super(null);
            this.value = z;
        }

        public static /* synthetic */ GBool copy$default(GBool gBool, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = gBool.value;
            }
            return gBool.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        @NotNull
        public final GBool copy(boolean z) {
            return new GBool(z);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            return Boolean.valueOf(this.value);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GBool) && this.value == ((GBool) obj).value;
        }

        public final boolean getValue() {
            return this.value;
        }

        public int hashCode() {
            boolean z = this.value;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "GBool(value=" + this.value + ')';
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\t\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GEnv;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "component1", "value", rz0.ARG_COPY, "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GEnv extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String value;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GEnv$Companion;", "", "", "value", "", "isExpression", "Lcom/youku/gaiax/impl/GaiaXExpression$GEnv;", "create", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            @NotNull
            public final GEnv create(@NotNull String str) {
                b41.i(str, "value");
                String substring = str.substring(4, str.length() - 1);
                b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return new GEnv(substring);
            }

            public final boolean isExpression(@NotNull String str) {
                boolean F;
                boolean p;
                b41.i(str, "value");
                F = C8604o.F(str, "env(", false, 2, null);
                if (F) {
                    p = C8604o.p(str, jn1.BRACKET_END_STR, false, 2, null);
                    return p;
                }
                return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GEnv(@NotNull String str) {
            super(null);
            b41.i(str, "value");
            this.value = str;
        }

        public static /* synthetic */ GEnv copy$default(GEnv gEnv, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gEnv.value;
            }
            return gEnv.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.value;
        }

        @NotNull
        public final GEnv copy(@NotNull String str) {
            b41.i(str, "value");
            return new GEnv(str);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            IProxyFeatures features = GaiaXProxy.Companion.getInstance().getFeatures();
            if (features == null) {
                return null;
            }
            return features.getEnvExpressionResult(this.value);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GEnv) && b41.d(this.value, ((GEnv) obj).value);
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "GEnv(value='" + this.value + "')";
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0001\u0012\u0006\u0010\u0018\u001a\u00020\u0001¢\u0006\u0004\b&\u0010'J\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\t\u0010\u0013\u001a\u00020\u0011HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0001HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u0001HÆ\u0001J\t\u0010\u001b\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÖ\u0003R\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0017\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u0018\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\"\u001a\u0004\b%\u0010$¨\u0006)"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GEval;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "", "left", "right", "mod", "doubleOr", "doubleAnd", "lessThan", "lessThanOrEqual", "greaterThanOrEqual", "greaterThan", "notEqual", "equal", "Lcom/alibaba/fastjson/JSON;", "rawJson", "desireData", "", "toString", "component1", "component2", "component3", "operate", "leftValue", "rightValue", rz0.ARG_COPY, "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getOperate", "()Ljava/lang/String;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "getLeftValue", "()Lcom/youku/gaiax/impl/GaiaXExpression;", "getRightValue", "<init>", "(Ljava/lang/String;Lcom/youku/gaiax/impl/GaiaXExpression;Lcom/youku/gaiax/impl/GaiaXExpression;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GEval extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final GaiaXExpression leftValue;
        @NotNull
        private final String operate;
        @NotNull
        private final GaiaXExpression rightValue;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GEval$Companion;", "", "", "operate", "realValue", "Lcom/youku/gaiax/impl/GaiaXExpression$GEval;", "createEval", "value", "", "isExpression", "create", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            private final GEval createEval(String str, String str2) {
                List t0;
                t0 = StringsKt__StringsKt.t0(str2, new String[]{str}, false, 0, 6, null);
                if (t0.size() == 2) {
                    Companion companion = GaiaXExpression.Companion;
                    return new GEval(str, companion.create((String) t0.get(0)), companion.create((String) t0.get(1)));
                }
                return null;
            }

            @NotNull
            public final GEval create(@NotNull String str) {
                b41.i(str, "value");
                String substring = str.substring(5, str.length() - 1);
                b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                GEval createEval = createEval(jn1.EQUAL2, substring);
                if (createEval == null && (createEval = createEval(jn1.GE, substring)) == null && (createEval = createEval(jn1.G, substring)) == null && (createEval = createEval(jn1.LE, substring)) == null && (createEval = createEval(jn1.L, substring)) == null && (createEval = createEval(jn1.NOT_EQUAL2, substring)) == null && (createEval = createEval(jn1.OR, substring)) == null && (createEval = createEval(jn1.AND, substring)) == null) {
                    GEval createEval2 = createEval("%", substring);
                    if (createEval2 == null) {
                        Undefined undefined = Undefined.INSTANCE;
                        return new GEval("", undefined, undefined);
                    }
                    return createEval2;
                }
                return createEval;
            }

            public final boolean isExpression(@NotNull String str) {
                boolean F;
                boolean p;
                b41.i(str, "value");
                F = C8604o.F(str, "eval(", false, 2, null);
                if (F) {
                    p = C8604o.p(str, jn1.BRACKET_END_STR, false, 2, null);
                    return p;
                }
                return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GEval(@NotNull String str, @NotNull GaiaXExpression gaiaXExpression, @NotNull GaiaXExpression gaiaXExpression2) {
            super(null);
            b41.i(str, "operate");
            b41.i(gaiaXExpression, "leftValue");
            b41.i(gaiaXExpression2, "rightValue");
            this.operate = str;
            this.leftValue = gaiaXExpression;
            this.rightValue = gaiaXExpression2;
        }

        public static /* synthetic */ GEval copy$default(GEval gEval, String str, GaiaXExpression gaiaXExpression, GaiaXExpression gaiaXExpression2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gEval.operate;
            }
            if ((i & 2) != 0) {
                gaiaXExpression = gEval.leftValue;
            }
            if ((i & 4) != 0) {
                gaiaXExpression2 = gEval.rightValue;
            }
            return gEval.copy(str, gaiaXExpression, gaiaXExpression2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) == false) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
            if (((java.lang.Boolean) r7).booleanValue() != false) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0060, code lost:
            if ((((java.lang.Number) r6).floatValue() == 0.0f) == false) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x007a, code lost:
            if (((java.lang.Boolean) r7).booleanValue() != false) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0098, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) == false) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x00d1, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) == false) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final java.lang.Object doubleAnd(java.lang.Object r6, java.lang.Object r7) {
            /*
                Method dump skipped, instructions count: 216
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.youku.gaiax.impl.GaiaXExpression.GEval.doubleAnd(java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) == false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
            if (((java.lang.Boolean) r7).booleanValue() == false) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0067, code lost:
            if (((java.lang.Boolean) r7).booleanValue() == false) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0085, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) == false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x00c4, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) == false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x00ca, code lost:
            if ((r7 instanceof java.lang.String) != false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x00ec, code lost:
            if ((((java.lang.Number) r6).floatValue() == 0.0f) == false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x00f2, code lost:
            if ((r6 instanceof java.lang.String) != false) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final java.lang.Object doubleOr(java.lang.Object r6, java.lang.Object r7) {
            /*
                Method dump skipped, instructions count: 251
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.youku.gaiax.impl.GaiaXExpression.GEval.doubleOr(java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
            if (((java.lang.Number) r6).floatValue() == ((java.lang.Number) r7).floatValue()) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
            if ((((java.lang.Number) r6).floatValue() == 0.0f) != false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x006f, code lost:
            if ((((java.lang.Number) r6).floatValue() == 0.0f) != false) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x008e, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) != false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00a5, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) != false) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00aa, code lost:
            if (r7 == null) goto L6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final java.lang.Object equal(java.lang.Object r6, java.lang.Object r7) {
            /*
                r5 = this;
                boolean r0 = r6 instanceof java.lang.String
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L10
                boolean r0 = r7 instanceof java.lang.String
                if (r0 == 0) goto L10
                boolean r1 = tb.b41.d(r6, r7)
                goto Lac
            L10:
                boolean r0 = r6 instanceof java.lang.Number
                if (r0 == 0) goto L2d
                boolean r3 = r7 instanceof java.lang.Number
                if (r3 == 0) goto L2d
                java.lang.Number r6 = (java.lang.Number) r6
                float r6 = r6.floatValue()
                java.lang.Number r7 = (java.lang.Number) r7
                float r7 = r7.floatValue()
                int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
                if (r6 != 0) goto L2a
                goto Lac
            L2a:
                r1 = 0
                goto Lac
            L2d:
                boolean r3 = r6 instanceof java.lang.Boolean
                if (r3 == 0) goto L3b
                boolean r4 = r7 instanceof java.lang.Boolean
                if (r4 == 0) goto L3b
                boolean r1 = tb.b41.d(r6, r7)
                goto Lac
            L3b:
                r4 = 0
                if (r0 == 0) goto L72
                boolean r0 = r7 instanceof java.lang.Boolean
                if (r0 == 0) goto L72
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                boolean r0 = tb.b41.d(r7, r0)
                if (r0 == 0) goto L5a
                r0 = r6
                java.lang.Number r0 = (java.lang.Number) r0
                float r0 = r0.floatValue()
                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r0 != 0) goto L57
                r0 = 1
                goto L58
            L57:
                r0 = 0
            L58:
                if (r0 == 0) goto Lac
            L5a:
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                boolean r7 = tb.b41.d(r7, r0)
                if (r7 == 0) goto L2a
                java.lang.Number r6 = (java.lang.Number) r6
                float r6 = r6.floatValue()
                int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r6 != 0) goto L6e
                r6 = 1
                goto L6f
            L6e:
                r6 = 0
            L6f:
                if (r6 == 0) goto L2a
                goto Lac
            L72:
                if (r3 == 0) goto La8
                boolean r0 = r7 instanceof java.lang.Number
                if (r0 == 0) goto La8
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                boolean r0 = tb.b41.d(r6, r0)
                if (r0 == 0) goto L90
                r0 = r7
                java.lang.Number r0 = (java.lang.Number) r0
                float r0 = r0.floatValue()
                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r0 != 0) goto L8d
                r0 = 1
                goto L8e
            L8d:
                r0 = 0
            L8e:
                if (r0 == 0) goto Lac
            L90:
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                boolean r6 = tb.b41.d(r6, r0)
                if (r6 == 0) goto L2a
                java.lang.Number r7 = (java.lang.Number) r7
                float r6 = r7.floatValue()
                int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r6 != 0) goto La4
                r6 = 1
                goto La5
            La4:
                r6 = 0
            La5:
                if (r6 == 0) goto L2a
                goto Lac
            La8:
                if (r6 != 0) goto L2a
                if (r7 != 0) goto L2a
            Lac:
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.youku.gaiax.impl.GaiaXExpression.GEval.equal(java.lang.Object, java.lang.Object):java.lang.Object");
        }

        private final Object greaterThan(Object obj, Object obj2) {
            boolean z = false;
            if ((obj instanceof Number) && (obj2 instanceof Number) && ((Number) obj).floatValue() > ((Number) obj2).floatValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        private final Object greaterThanOrEqual(Object obj, Object obj2) {
            boolean z = false;
            if ((obj instanceof Number) && (obj2 instanceof Number) && ((Number) obj).floatValue() >= ((Number) obj2).floatValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        private final Object lessThan(Object obj, Object obj2) {
            boolean z = false;
            if ((obj instanceof Number) && (obj2 instanceof Number) && ((Number) obj).floatValue() < ((Number) obj2).floatValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        private final Object lessThanOrEqual(Object obj, Object obj2) {
            boolean z = false;
            if ((obj instanceof Number) && (obj2 instanceof Number) && ((Number) obj).floatValue() <= ((Number) obj2).floatValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        private final Object mod(Object obj, Object obj2) {
            if ((obj instanceof Number) && (obj2 instanceof Number)) {
                return ((obj instanceof Integer) && (obj2 instanceof Integer)) ? Integer.valueOf(((Number) obj).intValue() % ((Number) obj2).intValue()) : ((obj instanceof Float) && (obj2 instanceof Float)) ? Float.valueOf(((Number) obj).floatValue() % ((Number) obj2).floatValue()) : Float.valueOf(((Number) obj).floatValue() % ((Number) obj2).floatValue());
            }
            return Boolean.FALSE;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
            if ((((java.lang.Number) r6).floatValue() == ((java.lang.Number) r7).floatValue()) == false) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
            if (tb.b41.d(r6, r7) == false) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0060, code lost:
            if ((((java.lang.Number) r6).floatValue() == 0.0f) == false) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0077, code lost:
            if ((((java.lang.Number) r6).floatValue() == 0.0f) == false) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0096, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00ad, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) == false) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
            if (tb.b41.d(r6, r7) == false) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final java.lang.Object notEqual(java.lang.Object r6, java.lang.Object r7) {
            /*
                r5 = this;
                boolean r0 = r6 instanceof java.lang.String
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L15
                boolean r0 = r7 instanceof java.lang.String
                if (r0 == 0) goto L15
                boolean r6 = tb.b41.d(r6, r7)
                if (r6 != 0) goto L12
                goto Laf
            L12:
                r1 = 0
                goto Laf
            L15:
                boolean r0 = r6 instanceof java.lang.Number
                if (r0 == 0) goto L34
                boolean r3 = r7 instanceof java.lang.Number
                if (r3 == 0) goto L34
                java.lang.Number r6 = (java.lang.Number) r6
                float r6 = r6.floatValue()
                java.lang.Number r7 = (java.lang.Number) r7
                float r7 = r7.floatValue()
                int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
                if (r6 != 0) goto L2f
                r6 = 1
                goto L30
            L2f:
                r6 = 0
            L30:
                if (r6 != 0) goto L12
                goto Laf
            L34:
                boolean r3 = r6 instanceof java.lang.Boolean
                if (r3 == 0) goto L43
                boolean r4 = r7 instanceof java.lang.Boolean
                if (r4 == 0) goto L43
                boolean r6 = tb.b41.d(r6, r7)
                if (r6 != 0) goto L12
                goto Laf
            L43:
                r4 = 0
                if (r0 == 0) goto L7a
                boolean r0 = r7 instanceof java.lang.Boolean
                if (r0 == 0) goto L7a
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                boolean r0 = tb.b41.d(r7, r0)
                if (r0 == 0) goto L62
                r0 = r6
                java.lang.Number r0 = (java.lang.Number) r0
                float r0 = r0.floatValue()
                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r0 != 0) goto L5f
                r0 = 1
                goto L60
            L5f:
                r0 = 0
            L60:
                if (r0 != 0) goto Laf
            L62:
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                boolean r7 = tb.b41.d(r7, r0)
                if (r7 == 0) goto L12
                java.lang.Number r6 = (java.lang.Number) r6
                float r6 = r6.floatValue()
                int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r6 != 0) goto L76
                r6 = 1
                goto L77
            L76:
                r6 = 0
            L77:
                if (r6 != 0) goto L12
                goto Laf
            L7a:
                if (r3 == 0) goto L12
                boolean r0 = r7 instanceof java.lang.Number
                if (r0 == 0) goto L12
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                boolean r0 = tb.b41.d(r6, r0)
                if (r0 == 0) goto L98
                r0 = r7
                java.lang.Number r0 = (java.lang.Number) r0
                float r0 = r0.floatValue()
                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r0 != 0) goto L95
                r0 = 1
                goto L96
            L95:
                r0 = 0
            L96:
                if (r0 != 0) goto Laf
            L98:
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                boolean r6 = tb.b41.d(r6, r0)
                if (r6 == 0) goto L12
                java.lang.Number r7 = (java.lang.Number) r7
                float r6 = r7.floatValue()
                int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r6 != 0) goto Lac
                r6 = 1
                goto Lad
            Lac:
                r6 = 0
            Lad:
                if (r6 != 0) goto L12
            Laf:
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.youku.gaiax.impl.GaiaXExpression.GEval.notEqual(java.lang.Object, java.lang.Object):java.lang.Object");
        }

        @NotNull
        public final String component1() {
            return this.operate;
        }

        @NotNull
        public final GaiaXExpression component2() {
            return this.leftValue;
        }

        @NotNull
        public final GaiaXExpression component3() {
            return this.rightValue;
        }

        @NotNull
        public final GEval copy(@NotNull String str, @NotNull GaiaXExpression gaiaXExpression, @NotNull GaiaXExpression gaiaXExpression2) {
            b41.i(str, "operate");
            b41.i(gaiaXExpression, "leftValue");
            b41.i(gaiaXExpression2, "rightValue");
            return new GEval(str, gaiaXExpression, gaiaXExpression2);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            Object desireData = this.leftValue.desireData(json);
            Object desireData2 = this.rightValue.desireData(json);
            String str = this.operate;
            int hashCode = str.hashCode();
            if (hashCode != 37) {
                if (hashCode != 60) {
                    if (hashCode != 62) {
                        if (hashCode != 1084) {
                            if (hashCode != 1216) {
                                if (hashCode != 1921) {
                                    if (hashCode != 1952) {
                                        if (hashCode != 1983) {
                                            if (hashCode == 3968 && str.equals(jn1.OR)) {
                                                return doubleOr(desireData, desireData2);
                                            }
                                        } else if (str.equals(jn1.GE)) {
                                            return greaterThanOrEqual(desireData, desireData2);
                                        }
                                    } else if (str.equals(jn1.EQUAL2)) {
                                        return equal(desireData, desireData2);
                                    }
                                } else if (str.equals(jn1.LE)) {
                                    return lessThanOrEqual(desireData, desireData2);
                                }
                            } else if (str.equals(jn1.AND)) {
                                return doubleAnd(desireData, desireData2);
                            }
                        } else if (str.equals(jn1.NOT_EQUAL2)) {
                            return notEqual(desireData, desireData2);
                        }
                    } else if (str.equals(jn1.G)) {
                        return greaterThan(desireData, desireData2);
                    }
                } else if (str.equals(jn1.L)) {
                    return lessThan(desireData, desireData2);
                }
            } else if (str.equals("%")) {
                return mod(desireData, desireData2);
            }
            return Boolean.FALSE;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GEval) {
                GEval gEval = (GEval) obj;
                return b41.d(this.operate, gEval.operate) && b41.d(this.leftValue, gEval.leftValue) && b41.d(this.rightValue, gEval.rightValue);
            }
            return false;
        }

        @NotNull
        public final GaiaXExpression getLeftValue() {
            return this.leftValue;
        }

        @NotNull
        public final String getOperate() {
            return this.operate;
        }

        @NotNull
        public final GaiaXExpression getRightValue() {
            return this.rightValue;
        }

        public int hashCode() {
            return (((this.operate.hashCode() * 31) + this.leftValue.hashCode()) * 31) + this.rightValue.hashCode();
        }

        @NotNull
        public String toString() {
            return "GEval(operate='" + this.operate + "', leftValue=" + this.leftValue + ", rightValue=" + this.rightValue + ')';
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\n\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GFloat;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "", "component1", "value", rz0.ARG_COPY, "", "hashCode", "other", "", "equals", UTConstant.Args.UT_SUCCESS_F, "getValue", "()F", "<init>", "(F)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GFloat extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        private final float value;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GFloat$Companion;", "", "", "value", "Lcom/youku/gaiax/impl/GaiaXExpression$GFloat;", "create", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            @NotNull
            public final GFloat create(@NotNull String str) {
                b41.i(str, "value");
                return new GFloat(Float.parseFloat(str));
            }

            public final boolean isExpression(@NotNull String str) {
                b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                try {
                    return b41.d(String.valueOf(Float.parseFloat(str)), str);
                } catch (Exception unused) {
                    return false;
                }
            }
        }

        public GFloat(float f) {
            super(null);
            this.value = f;
        }

        public static /* synthetic */ GFloat copy$default(GFloat gFloat, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = gFloat.value;
            }
            return gFloat.copy(f);
        }

        public final float component1() {
            return this.value;
        }

        @NotNull
        public final GFloat copy(float f) {
            return new GFloat(f);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            return Float.valueOf(this.value);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GFloat) && b41.d(Float.valueOf(this.value), Float.valueOf(((GFloat) obj).value));
        }

        public final float getValue() {
            return this.value;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.value);
        }

        @NotNull
        public String toString() {
            return "GFloat(value=" + this.value + ')';
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\t\u0010\f\u001a\u00020\bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\n\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GInt;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "", "component1", "value", rz0.ARG_COPY, "hashCode", "other", "", "equals", "I", "getValue", "()I", "<init>", "(I)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GInt extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        private final int value;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GInt$Companion;", "", "", "value", "Lcom/youku/gaiax/impl/GaiaXExpression$GInt;", "create", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            @NotNull
            public final GInt create(@NotNull String str) {
                b41.i(str, "value");
                return new GInt(Integer.parseInt(str));
            }

            public final boolean isExpression(@NotNull String str) {
                b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                try {
                    return b41.d(String.valueOf(Integer.parseInt(str)), str);
                } catch (Exception unused) {
                    return false;
                }
            }
        }

        public GInt(int i) {
            super(null);
            this.value = i;
        }

        public static /* synthetic */ GInt copy$default(GInt gInt, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = gInt.value;
            }
            return gInt.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        @NotNull
        public final GInt copy(int i) {
            return new GInt(i);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            return Integer.valueOf(this.value);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GInt) && this.value == ((GInt) obj).value;
        }

        public final int getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value;
        }

        @NotNull
        public String toString() {
            return "GInt(value=" + this.value + ')';
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\n\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GJsonArrayObj;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "Lcom/alibaba/fastjson/JSONArray;", "component1", "value", rz0.ARG_COPY, "", "hashCode", "other", "", "equals", "Lcom/alibaba/fastjson/JSONArray;", "getValue", "()Lcom/alibaba/fastjson/JSONArray;", "<init>", "(Lcom/alibaba/fastjson/JSONArray;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GJsonArrayObj extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final JSONArray value;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GJsonArrayObj$Companion;", "", "Lcom/alibaba/fastjson/JSONArray;", "value", "Lcom/youku/gaiax/impl/GaiaXExpression$GJsonArrayObj;", "create", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            @NotNull
            public final GJsonArrayObj create(@NotNull JSONArray jSONArray) {
                b41.i(jSONArray, "value");
                JSONArray jSONArray2 = new JSONArray();
                for (Object obj : jSONArray) {
                    if (obj != null) {
                        jSONArray2.add(GaiaXExpression.Companion.create(obj));
                    }
                }
                return new GJsonArrayObj(jSONArray2);
            }

            public final boolean isExpression(@NotNull Object obj) {
                b41.i(obj, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return obj instanceof JSONArray;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GJsonArrayObj(@NotNull JSONArray jSONArray) {
            super(null);
            b41.i(jSONArray, "value");
            this.value = jSONArray;
        }

        public static /* synthetic */ GJsonArrayObj copy$default(GJsonArrayObj gJsonArrayObj, JSONArray jSONArray, int i, Object obj) {
            if ((i & 1) != 0) {
                jSONArray = gJsonArrayObj.value;
            }
            return gJsonArrayObj.copy(jSONArray);
        }

        @NotNull
        public final JSONArray component1() {
            return this.value;
        }

        @NotNull
        public final GJsonArrayObj copy(@NotNull JSONArray jSONArray) {
            b41.i(jSONArray, "value");
            return new GJsonArrayObj(jSONArray);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            JSONArray jSONArray = new JSONArray();
            if (!this.value.isEmpty()) {
                for (Object obj : this.value) {
                    if (obj != null && (obj instanceof GaiaXExpression)) {
                        jSONArray.add(((GaiaXExpression) obj).desireData(json));
                    }
                }
            }
            return jSONArray;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GJsonArrayObj) && b41.d(this.value, ((GJsonArrayObj) obj).value);
        }

        @NotNull
        public final JSONArray getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "GJsonArrayObj(value=" + this.value + ')';
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\n\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GJsonObj;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "Lcom/alibaba/fastjson/JSONObject;", "component1", "value", rz0.ARG_COPY, "", "hashCode", "other", "", "equals", "Lcom/alibaba/fastjson/JSONObject;", "getValue", "()Lcom/alibaba/fastjson/JSONObject;", "<init>", "(Lcom/alibaba/fastjson/JSONObject;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GJsonObj extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final JSONObject value;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GJsonObj$Companion;", "", "Lcom/alibaba/fastjson/JSONObject;", "value", "Lcom/youku/gaiax/impl/GaiaXExpression$GJsonObj;", "create", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            @NotNull
            public final GJsonObj create(@NotNull JSONObject jSONObject) {
                b41.i(jSONObject, "value");
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        if (!(entry.getValue() instanceof Integer) && !(entry.getValue() instanceof Boolean)) {
                            String key = entry.getKey();
                            Companion companion = GaiaXExpression.Companion;
                            Object value = entry.getValue();
                            b41.h(value, "it.value");
                            jSONObject2.put((JSONObject) key, (String) companion.create(value));
                        } else {
                            jSONObject2.put((JSONObject) entry.getKey(), (String) entry.getValue());
                        }
                    }
                }
                return new GJsonObj(jSONObject2);
            }

            public final boolean isExpression(@NotNull Object obj) {
                b41.i(obj, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return obj instanceof JSONObject;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GJsonObj(@NotNull JSONObject jSONObject) {
            super(null);
            b41.i(jSONObject, "value");
            this.value = jSONObject;
        }

        public static /* synthetic */ GJsonObj copy$default(GJsonObj gJsonObj, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                jSONObject = gJsonObj.value;
            }
            return gJsonObj.copy(jSONObject);
        }

        @NotNull
        public final JSONObject component1() {
            return this.value;
        }

        @NotNull
        public final GJsonObj copy(@NotNull JSONObject jSONObject) {
            b41.i(jSONObject, "value");
            return new GJsonObj(jSONObject);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            JSONObject jSONObject = new JSONObject();
            if (!this.value.isEmpty()) {
                for (Map.Entry<String, Object> entry : this.value.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        if (entry.getValue() instanceof GaiaXExpression) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            Objects.requireNonNull(value, "null cannot be cast to non-null type com.youku.gaiax.impl.GaiaXExpression");
                            jSONObject.put((JSONObject) key, (String) ((GaiaXExpression) value).desireData(json));
                        } else {
                            jSONObject.put((JSONObject) entry.getKey(), (String) entry.getValue());
                        }
                    }
                }
            }
            return jSONObject;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GJsonObj) && b41.d(this.value, ((GJsonObj) obj).value);
        }

        @NotNull
        public final JSONObject getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "GJsonObj(value=" + this.value + ')';
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GNull;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "<init>", "()V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GNull extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GNull$Companion;", "", "Lcom/youku/gaiax/impl/GaiaXExpression$GNull;", "create", "", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            @NotNull
            public final GNull create() {
                return new GNull();
            }

            public final boolean isExpression(@NotNull String str) {
                b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return b41.d(str, "null");
            }
        }

        public GNull() {
            super(null);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            return null;
        }

        @NotNull
        public String toString() {
            return "GNull()";
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\t\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GScroll;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "component1", "value", rz0.ARG_COPY, "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GScroll extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String value;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GScroll$Companion;", "", "", "value", "", "isExpression", "Lcom/youku/gaiax/impl/GaiaXExpression$GScroll;", "create", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            @NotNull
            public final GScroll create(@NotNull String str) {
                b41.i(str, "value");
                String substring = str.substring(7, str.length() - 1);
                b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return new GScroll(substring);
            }

            public final boolean isExpression(@NotNull String str) {
                boolean F;
                boolean p;
                b41.i(str, "value");
                F = C8604o.F(str, "scroll(", false, 2, null);
                if (F) {
                    p = C8604o.p(str, jn1.BRACKET_END_STR, false, 2, null);
                    return p;
                }
                return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GScroll(@NotNull String str) {
            super(null);
            b41.i(str, "value");
            this.value = str;
        }

        public static /* synthetic */ GScroll copy$default(GScroll gScroll, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gScroll.value;
            }
            return gScroll.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.value;
        }

        @NotNull
        public final GScroll copy(@NotNull String str) {
            b41.i(str, "value");
            return new GScroll(str);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @NotNull
        public Object desireData(@Nullable JSON json) {
            return Integer.valueOf(json == null ? -1 : yq0.d(json, GaiaXKey.GAIAX_SCROLL_POSITION));
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GScroll) && b41.d(this.value, ((GScroll) obj).value);
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "GScroll(value='" + this.value + "')";
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0001HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u0001HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\t\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GSize;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "component1", "value", rz0.ARG_COPY, "", "hashCode", "other", "", "equals", "Lcom/youku/gaiax/impl/GaiaXExpression;", "getValue", "()Lcom/youku/gaiax/impl/GaiaXExpression;", "<init>", "(Lcom/youku/gaiax/impl/GaiaXExpression;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GSize extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final GaiaXExpression value;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GSize$Companion;", "", "", "value", "", "isExpression", "Lcom/youku/gaiax/impl/GaiaXExpression$GSize;", "create", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            @NotNull
            public final GSize create(@NotNull String str) {
                b41.i(str, "value");
                String substring = str.substring(5, str.length() - 1);
                b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return new GSize(GaiaXExpression.Companion.create(substring));
            }

            public final boolean isExpression(@NotNull String str) {
                boolean F;
                boolean p;
                b41.i(str, "value");
                F = C8604o.F(str, "size(", false, 2, null);
                if (F) {
                    p = C8604o.p(str, jn1.BRACKET_END_STR, false, 2, null);
                    return p;
                }
                return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GSize(@NotNull GaiaXExpression gaiaXExpression) {
            super(null);
            b41.i(gaiaXExpression, "value");
            this.value = gaiaXExpression;
        }

        public static /* synthetic */ GSize copy$default(GSize gSize, GaiaXExpression gaiaXExpression, int i, Object obj) {
            if ((i & 1) != 0) {
                gaiaXExpression = gSize.value;
            }
            return gSize.copy(gaiaXExpression);
        }

        @NotNull
        public final GaiaXExpression component1() {
            return this.value;
        }

        @NotNull
        public final GSize copy(@NotNull GaiaXExpression gaiaXExpression) {
            b41.i(gaiaXExpression, "value");
            return new GSize(gaiaXExpression);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            int size;
            Object desireData = this.value.desireData(json);
            if (desireData instanceof String) {
                size = ((String) desireData).length();
            } else if (desireData instanceof JSONArray) {
                size = ((JSONArray) desireData).size();
            } else {
                size = desireData instanceof JSONObject ? ((JSONObject) desireData).size() : 0;
            }
            return Integer.valueOf(size);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GSize) && b41.d(this.value, ((GSize) obj).value);
        }

        @NotNull
        public final GaiaXExpression getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "GSize(value=" + this.value + ')';
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\t\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GString;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "component1", "value", rz0.ARG_COPY, "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GString extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String value;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GString$Companion;", "", "", "value", "Lcom/youku/gaiax/impl/GaiaXExpression$GString;", "create", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            @NotNull
            public final GString create(@NotNull String str) {
                b41.i(str, "value");
                String substring = str.substring(1, str.length() - 1);
                b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return new GString(substring);
            }

            public final boolean isExpression(@NotNull String str) {
                boolean F;
                boolean p;
                boolean K;
                b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                F = C8604o.F(str, "'", false, 2, null);
                if (F) {
                    p = C8604o.p(str, "'", false, 2, null);
                    if (p) {
                        K = StringsKt__StringsKt.K(str, " + ", false, 2, null);
                        return !K;
                    }
                    return false;
                }
                return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GString(@NotNull String str) {
            super(null);
            b41.i(str, "value");
            this.value = str;
        }

        public static /* synthetic */ GString copy$default(GString gString, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gString.value;
            }
            return gString.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.value;
        }

        @NotNull
        public final GString copy(@NotNull String str) {
            b41.i(str, "value");
            return new GString(str);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            return this.value;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GString) && b41.d(this.value, ((GString) obj).value);
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "GString(value='" + this.value + "')";
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\u0006\u0010\f\u001a\u00020\u0001\u0012\u0006\u0010\r\u001a\u00020\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0001HÆ\u0003J\t\u0010\t\u001a\u00020\u0001HÆ\u0003J\t\u0010\n\u001a\u00020\u0001HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u0001HÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\u000b\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0019\u0010\r\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue1;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "component1", "component2", "component3", "condition", "trueBranch", "falseBranch", rz0.ARG_COPY, "", "hashCode", "other", "", "equals", "Lcom/youku/gaiax/impl/GaiaXExpression;", "getCondition", "()Lcom/youku/gaiax/impl/GaiaXExpression;", "getTrueBranch", "getFalseBranch", "<init>", "(Lcom/youku/gaiax/impl/GaiaXExpression;Lcom/youku/gaiax/impl/GaiaXExpression;Lcom/youku/gaiax/impl/GaiaXExpression;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GTernaryValue1 extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final GaiaXExpression condition;
        @NotNull
        private final GaiaXExpression falseBranch;
        @NotNull
        private final GaiaXExpression trueBranch;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue1$Companion;", "", "", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExp", "isExp2", "getExpressionValue", "conditionValue", "trueValue", "falseValue", "Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue1;", "create", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            private final String conditionValue(String str) {
                List t0;
                t0 = StringsKt__StringsKt.t0(str, new String[]{" ? "}, false, 0, 6, null);
                return t0.isEmpty() ^ true ? (String) t0.get(0) : "";
            }

            private final String falseValue(String str) {
                List t0;
                List t02;
                List t03;
                t0 = StringsKt__StringsKt.t0(str, new String[]{" ? "}, false, 0, 6, null);
                if (t0.size() >= 2) {
                    t02 = StringsKt__StringsKt.t0((CharSequence) t0.get(1), new String[]{" : "}, false, 0, 6, null);
                    if (t02.size() == 2) {
                        return (String) t02.get(1);
                    }
                    if (t02.size() > 2) {
                        t03 = StringsKt__StringsKt.t0((CharSequence) t0.get(1), new String[]{" : "}, false, 0, 6, null);
                        return t03.size() == 2 ? (String) t03.get(1) : "";
                    }
                    return "";
                }
                return "";
            }

            private final String getExpressionValue(String str) {
                int Z;
                int f0;
                Z = StringsKt__StringsKt.Z(str, jn1.BLOCK_START_STR, 0, false, 6, null);
                f0 = StringsKt__StringsKt.f0(str, "}", 0, false, 6, null);
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String substring = str.substring(Z + 1, f0);
                b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }

            private final boolean isExp(String str) {
                boolean K;
                boolean F;
                boolean p;
                boolean K2;
                boolean K3;
                boolean K4;
                K = StringsKt__StringsKt.K(str, "${", false, 2, null);
                if (K) {
                    F = C8604o.F(str, "@{", false, 2, null);
                    if (F) {
                        p = C8604o.p(str, "}", false, 2, null);
                        if (p) {
                            K2 = StringsKt__StringsKt.K(str, " ? ", false, 2, null);
                            if (K2) {
                                K3 = StringsKt__StringsKt.K(str, " : ", false, 2, null);
                                if (K3) {
                                    K4 = StringsKt__StringsKt.K(str, " ?: ", false, 2, null);
                                    return !K4;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }

            private final boolean isExp2(String str) {
                boolean F;
                boolean p;
                boolean K;
                boolean K2;
                boolean K3;
                F = C8604o.F(str, "@{", false, 2, null);
                if (F) {
                    p = C8604o.p(str, "}", false, 2, null);
                    if (p) {
                        K = StringsKt__StringsKt.K(str, " ? ", false, 2, null);
                        if (K) {
                            K2 = StringsKt__StringsKt.K(str, " : ", false, 2, null);
                            if (K2) {
                                K3 = StringsKt__StringsKt.K(str, " ?: ", false, 2, null);
                                return !K3;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }

            private final String trueValue(String str) {
                List t0;
                List t02;
                List t03;
                t0 = StringsKt__StringsKt.t0(str, new String[]{" ? "}, false, 0, 6, null);
                if (t0.size() == 2) {
                    t02 = StringsKt__StringsKt.t0((CharSequence) t0.get(1), new String[]{" : "}, false, 0, 6, null);
                    if (t02.size() == 2) {
                        return (String) t02.get(0);
                    }
                    if (t02.size() > 2) {
                        t03 = StringsKt__StringsKt.t0((CharSequence) t0.get(1), new String[]{" : "}, false, 0, 6, null);
                        return t03.size() == 2 ? (String) t03.get(0) : "";
                    }
                    return "";
                }
                return "";
            }

            @NotNull
            public final GTernaryValue1 create(@NotNull String str) {
                b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                String expressionValue = getExpressionValue(str);
                Companion companion = GaiaXExpression.Companion;
                return new GTernaryValue1(companion.create(conditionValue(expressionValue)), companion.create(trueValue(expressionValue)), companion.create(falseValue(expressionValue)));
            }

            public final boolean isExpression(@NotNull String str) {
                b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return isExp(str) || isExp2(str);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GTernaryValue1(@NotNull GaiaXExpression gaiaXExpression, @NotNull GaiaXExpression gaiaXExpression2, @NotNull GaiaXExpression gaiaXExpression3) {
            super(null);
            b41.i(gaiaXExpression, "condition");
            b41.i(gaiaXExpression2, "trueBranch");
            b41.i(gaiaXExpression3, "falseBranch");
            this.condition = gaiaXExpression;
            this.trueBranch = gaiaXExpression2;
            this.falseBranch = gaiaXExpression3;
        }

        public static /* synthetic */ GTernaryValue1 copy$default(GTernaryValue1 gTernaryValue1, GaiaXExpression gaiaXExpression, GaiaXExpression gaiaXExpression2, GaiaXExpression gaiaXExpression3, int i, Object obj) {
            if ((i & 1) != 0) {
                gaiaXExpression = gTernaryValue1.condition;
            }
            if ((i & 2) != 0) {
                gaiaXExpression2 = gTernaryValue1.trueBranch;
            }
            if ((i & 4) != 0) {
                gaiaXExpression3 = gTernaryValue1.falseBranch;
            }
            return gTernaryValue1.copy(gaiaXExpression, gaiaXExpression2, gaiaXExpression3);
        }

        @NotNull
        public final GaiaXExpression component1() {
            return this.condition;
        }

        @NotNull
        public final GaiaXExpression component2() {
            return this.trueBranch;
        }

        @NotNull
        public final GaiaXExpression component3() {
            return this.falseBranch;
        }

        @NotNull
        public final GTernaryValue1 copy(@NotNull GaiaXExpression gaiaXExpression, @NotNull GaiaXExpression gaiaXExpression2, @NotNull GaiaXExpression gaiaXExpression3) {
            b41.i(gaiaXExpression, "condition");
            b41.i(gaiaXExpression2, "trueBranch");
            b41.i(gaiaXExpression3, "falseBranch");
            return new GTernaryValue1(gaiaXExpression, gaiaXExpression2, gaiaXExpression3);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            if (GaiaXExpression.Companion.isCondition(this.condition.desireData(json))) {
                return this.trueBranch.desireData(json);
            }
            return this.falseBranch.desireData(json);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GTernaryValue1) {
                GTernaryValue1 gTernaryValue1 = (GTernaryValue1) obj;
                return b41.d(this.condition, gTernaryValue1.condition) && b41.d(this.trueBranch, gTernaryValue1.trueBranch) && b41.d(this.falseBranch, gTernaryValue1.falseBranch);
            }
            return false;
        }

        @NotNull
        public final GaiaXExpression getCondition() {
            return this.condition;
        }

        @NotNull
        public final GaiaXExpression getFalseBranch() {
            return this.falseBranch;
        }

        @NotNull
        public final GaiaXExpression getTrueBranch() {
            return this.trueBranch;
        }

        public int hashCode() {
            return (((this.condition.hashCode() * 31) + this.trueBranch.hashCode()) * 31) + this.falseBranch.hashCode();
        }

        @NotNull
        public String toString() {
            return "GTernaryValue1(condition=" + this.condition + ", trueBranch=" + this.trueBranch + ", falseBranch=" + this.falseBranch + ')';
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0001HÆ\u0003J\t\u0010\t\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u0001HÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\n\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u000b\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue2;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "component1", "component2", "conditionAndTrueBranch", "falseBranch", rz0.ARG_COPY, "", "hashCode", "other", "", "equals", "Lcom/youku/gaiax/impl/GaiaXExpression;", "getConditionAndTrueBranch", "()Lcom/youku/gaiax/impl/GaiaXExpression;", "getFalseBranch", "<init>", "(Lcom/youku/gaiax/impl/GaiaXExpression;Lcom/youku/gaiax/impl/GaiaXExpression;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GTernaryValue2 extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final GaiaXExpression conditionAndTrueBranch;
        @NotNull
        private final GaiaXExpression falseBranch;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue2$Companion;", "", "", DXTraceUtil.TYPE_EXPRESSION_STRING, "getExpressionValue", "trueValue", "falseValue", "", "isExp", "isExp2", "Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue2;", "create", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            private final String falseValue(String str) {
                List t0;
                t0 = StringsKt__StringsKt.t0(str, new String[]{" ?: "}, false, 0, 6, null);
                return t0.size() == 2 ? (String) t0.get(1) : "";
            }

            private final String getExpressionValue(String str) {
                int Z;
                int f0;
                Z = StringsKt__StringsKt.Z(str, jn1.BLOCK_START_STR, 0, false, 6, null);
                f0 = StringsKt__StringsKt.f0(str, "}", 0, false, 6, null);
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String substring = str.substring(Z + 1, f0);
                b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }

            private final boolean isExp(String str) {
                boolean K;
                boolean F;
                boolean p;
                boolean K2;
                K = StringsKt__StringsKt.K(str, "${", false, 2, null);
                if (K) {
                    F = C8604o.F(str, "@{", false, 2, null);
                    if (F) {
                        p = C8604o.p(str, "}", false, 2, null);
                        if (p) {
                            K2 = StringsKt__StringsKt.K(str, " ?: ", false, 2, null);
                            return K2;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }

            private final boolean isExp2(String str) {
                boolean F;
                boolean p;
                boolean K;
                F = C8604o.F(str, "@{", false, 2, null);
                if (F) {
                    p = C8604o.p(str, "}", false, 2, null);
                    if (p) {
                        K = StringsKt__StringsKt.K(str, " ?: ", false, 2, null);
                        return K;
                    }
                    return false;
                }
                return false;
            }

            private final String trueValue(String str) {
                List t0;
                t0 = StringsKt__StringsKt.t0(str, new String[]{" ?: "}, false, 0, 6, null);
                return t0.size() == 2 ? (String) t0.get(0) : "";
            }

            @NotNull
            public final GTernaryValue2 create(@NotNull String str) {
                b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                String expressionValue = getExpressionValue(str);
                Companion companion = GaiaXExpression.Companion;
                return new GTernaryValue2(companion.create(trueValue(expressionValue)), companion.create(falseValue(expressionValue)));
            }

            public final boolean isExpression(@NotNull String str) {
                b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return isExp(str) || isExp2(str);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GTernaryValue2(@NotNull GaiaXExpression gaiaXExpression, @NotNull GaiaXExpression gaiaXExpression2) {
            super(null);
            b41.i(gaiaXExpression, "conditionAndTrueBranch");
            b41.i(gaiaXExpression2, "falseBranch");
            this.conditionAndTrueBranch = gaiaXExpression;
            this.falseBranch = gaiaXExpression2;
        }

        public static /* synthetic */ GTernaryValue2 copy$default(GTernaryValue2 gTernaryValue2, GaiaXExpression gaiaXExpression, GaiaXExpression gaiaXExpression2, int i, Object obj) {
            if ((i & 1) != 0) {
                gaiaXExpression = gTernaryValue2.conditionAndTrueBranch;
            }
            if ((i & 2) != 0) {
                gaiaXExpression2 = gTernaryValue2.falseBranch;
            }
            return gTernaryValue2.copy(gaiaXExpression, gaiaXExpression2);
        }

        @NotNull
        public final GaiaXExpression component1() {
            return this.conditionAndTrueBranch;
        }

        @NotNull
        public final GaiaXExpression component2() {
            return this.falseBranch;
        }

        @NotNull
        public final GTernaryValue2 copy(@NotNull GaiaXExpression gaiaXExpression, @NotNull GaiaXExpression gaiaXExpression2) {
            b41.i(gaiaXExpression, "conditionAndTrueBranch");
            b41.i(gaiaXExpression2, "falseBranch");
            return new GTernaryValue2(gaiaXExpression, gaiaXExpression2);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            Object desireData = this.conditionAndTrueBranch.desireData(json);
            return GaiaXExpression.Companion.isCondition(desireData) ? desireData : this.falseBranch.desireData(json);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GTernaryValue2) {
                GTernaryValue2 gTernaryValue2 = (GTernaryValue2) obj;
                return b41.d(this.conditionAndTrueBranch, gTernaryValue2.conditionAndTrueBranch) && b41.d(this.falseBranch, gTernaryValue2.falseBranch);
            }
            return false;
        }

        @NotNull
        public final GaiaXExpression getConditionAndTrueBranch() {
            return this.conditionAndTrueBranch;
        }

        @NotNull
        public final GaiaXExpression getFalseBranch() {
            return this.falseBranch;
        }

        public int hashCode() {
            return (this.conditionAndTrueBranch.hashCode() * 31) + this.falseBranch.hashCode();
        }

        @NotNull
        public String toString() {
            return "GTernaryValue2(conditionAndTrueBranch=" + this.conditionAndTrueBranch + ", falseBranch=" + this.falseBranch + ')';
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB#\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0001HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0001HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\u000b\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue3;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "component1", "component2", "component3", "value", "trueBranch", "falseBranch", rz0.ARG_COPY, "", "hashCode", "other", "", "equals", "Lcom/youku/gaiax/impl/GaiaXExpression;", "getValue", "()Lcom/youku/gaiax/impl/GaiaXExpression;", "getTrueBranch", "getFalseBranch", "<init>", "(Lcom/youku/gaiax/impl/GaiaXExpression;Lcom/youku/gaiax/impl/GaiaXExpression;Lcom/youku/gaiax/impl/GaiaXExpression;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GTernaryValue3 extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private static final Regex regex = new Regex("@\\{(.*)\\}");
        @Nullable
        private final GaiaXExpression falseBranch;
        @Nullable
        private final GaiaXExpression trueBranch;
        @NotNull
        private final GaiaXExpression value;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\"\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002R\u001c\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue3$Companion;", "", "", "expressionSpace", "Lkotlin/Pair;", "splitBranch", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExp", "isExp2", "isExp3", "Lcom/youku/gaiax/impl/GaiaXExpression;", "create", "isExpression", "Lkotlin/text/Regex;", "regex", "Lkotlin/text/Regex;", "getRegex$annotations", "()V", "<init>", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            private static /* synthetic */ void getRegex$annotations() {
            }

            private final boolean isExp(String str) {
                boolean K;
                boolean F;
                boolean p;
                boolean K2;
                boolean K3;
                boolean K4;
                K = StringsKt__StringsKt.K(str, "${", false, 2, null);
                if (K) {
                    F = C8604o.F(str, "@{", false, 2, null);
                    if (F) {
                        p = C8604o.p(str, "}", false, 2, null);
                        if (p) {
                            K2 = StringsKt__StringsKt.K(str, " ? ", false, 2, null);
                            if (K2) {
                                K3 = StringsKt__StringsKt.K(str, " : ", false, 2, null);
                                if (K3) {
                                    K4 = StringsKt__StringsKt.K(str, " ?: ", false, 2, null);
                                    return !K4;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }

            private final boolean isExp2(String str) {
                boolean F;
                boolean p;
                boolean K;
                boolean K2;
                boolean K3;
                F = C8604o.F(str, "@{", false, 2, null);
                if (F) {
                    p = C8604o.p(str, "}", false, 2, null);
                    if (p) {
                        K = StringsKt__StringsKt.K(str, " ? ", false, 2, null);
                        if (K) {
                            K2 = StringsKt__StringsKt.K(str, " : ", false, 2, null);
                            if (K2) {
                                K3 = StringsKt__StringsKt.K(str, " ?: ", false, 2, null);
                                return !K3;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }

            private final boolean isExp3(String str) {
                List t0;
                t0 = StringsKt__StringsKt.t0(str, new String[]{"@{"}, false, 0, 6, null);
                return t0.size() > 2;
            }

            private final Pair<String, String> splitBranch(String str) {
                int Z;
                int Z2;
                int Z3;
                List t0;
                int length = str.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = b41.k(str.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                String obj = str.subSequence(i, length + 1).toString();
                Z = StringsKt__StringsKt.Z(obj, "@{", 0, false, 6, null);
                if (Z == -1) {
                    t0 = StringsKt__StringsKt.t0(obj, new String[]{" : "}, false, 0, 6, null);
                    Object[] array = t0.toArray(new String[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    String[] strArr = (String[]) array;
                    return new Pair<>(strArr[0], strArr[1]);
                }
                Z2 = StringsKt__StringsKt.Z(obj, " : ", 0, false, 6, null);
                if (Z2 < Z) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
                    String substring = obj.substring(0, Z2);
                    b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    String substring2 = obj.substring(Z2 + 2);
                    b41.h(substring2, "(this as java.lang.String).substring(startIndex)");
                    return new Pair<>(substring, substring2);
                }
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
                String substring3 = obj.substring(Z);
                b41.h(substring3, "(this as java.lang.String).substring(startIndex)");
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= substring3.length()) {
                        i2 = -1;
                        break;
                    }
                    if ('@' == substring3.charAt(i2) || '$' == substring3.charAt(i2)) {
                        i3++;
                        i2++;
                    }
                    if ('}' == substring3.charAt(i2)) {
                        i3--;
                    }
                    if (i3 == 0) {
                        break;
                    }
                    i2++;
                }
                if (i2 != -1) {
                    int i4 = i2 + 1;
                    Z3 = StringsKt__StringsKt.Z(substring3, " : ", i4, false, 4, null);
                    if (Z3 != -1) {
                        String substring4 = substring3.substring(0, i4);
                        b41.h(substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        String substring5 = substring3.substring(Z3 + 2, substring3.length());
                        b41.h(substring5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        return new Pair<>(substring4, substring5);
                    }
                }
                return null;
            }

            @NotNull
            public final GaiaXExpression create(@NotNull String str) {
                int m;
                int Z;
                int Z2;
                String first;
                String second;
                b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                Sequence findAll$default = Regex.findAll$default(GTernaryValue3.regex, str, 0, 2, null);
                m = SequencesKt___SequencesKt.m(findAll$default);
                if (m > 0 && ((MatchResult) C8576d.r(findAll$default)).getGroupValues().size() > 1) {
                    String str2 = ((MatchResult) C8576d.r(findAll$default)).getGroupValues().get(1);
                    Z = StringsKt__StringsKt.Z(str2, " ? ", 0, false, 6, null);
                    if (Z != -1) {
                        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                        String substring = str2.substring(0, Z);
                        b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        Companion companion = GaiaXExpression.Companion;
                        GaiaXExpression create = companion.create(substring);
                        Z2 = StringsKt__StringsKt.Z(str2, " : ", 0, false, 6, null);
                        if (Z2 != -1) {
                            String substring2 = str2.substring(Z + 3);
                            b41.h(substring2, "(this as java.lang.String).substring(startIndex)");
                            Pair<String, String> splitBranch = splitBranch(substring2);
                            String str3 = "";
                            if (splitBranch == null || (first = splitBranch.getFirst()) == null) {
                                first = "";
                            }
                            GaiaXExpression create2 = companion.create(first);
                            if (splitBranch != null && (second = splitBranch.getSecond()) != null) {
                                str3 = second;
                            }
                            return new GTernaryValue3(create, create2, companion.create(str3));
                        }
                        return companion.create(create);
                    }
                    return GaiaXExpression.Companion.create(str2);
                }
                return GaiaXExpression.Companion.create(str);
            }

            public final boolean isExpression(@NotNull String str) {
                b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return (isExp(str) || isExp2(str)) && isExp3(str);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GTernaryValue3(@NotNull GaiaXExpression gaiaXExpression, @Nullable GaiaXExpression gaiaXExpression2, @Nullable GaiaXExpression gaiaXExpression3) {
            super(null);
            b41.i(gaiaXExpression, "value");
            this.value = gaiaXExpression;
            this.trueBranch = gaiaXExpression2;
            this.falseBranch = gaiaXExpression3;
        }

        public static /* synthetic */ GTernaryValue3 copy$default(GTernaryValue3 gTernaryValue3, GaiaXExpression gaiaXExpression, GaiaXExpression gaiaXExpression2, GaiaXExpression gaiaXExpression3, int i, Object obj) {
            if ((i & 1) != 0) {
                gaiaXExpression = gTernaryValue3.value;
            }
            if ((i & 2) != 0) {
                gaiaXExpression2 = gTernaryValue3.trueBranch;
            }
            if ((i & 4) != 0) {
                gaiaXExpression3 = gTernaryValue3.falseBranch;
            }
            return gTernaryValue3.copy(gaiaXExpression, gaiaXExpression2, gaiaXExpression3);
        }

        @NotNull
        public final GaiaXExpression component1() {
            return this.value;
        }

        @Nullable
        public final GaiaXExpression component2() {
            return this.trueBranch;
        }

        @Nullable
        public final GaiaXExpression component3() {
            return this.falseBranch;
        }

        @NotNull
        public final GTernaryValue3 copy(@NotNull GaiaXExpression gaiaXExpression, @Nullable GaiaXExpression gaiaXExpression2, @Nullable GaiaXExpression gaiaXExpression3) {
            b41.i(gaiaXExpression, "value");
            return new GTernaryValue3(gaiaXExpression, gaiaXExpression2, gaiaXExpression3);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            if (this.falseBranch != null && this.trueBranch != null) {
                if (GaiaXExpression.Companion.isCondition(this.value.desireData(json))) {
                    return this.trueBranch.desireData(json);
                }
                return this.falseBranch.desireData(json);
            }
            return this.value.desireData(json);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GTernaryValue3) {
                GTernaryValue3 gTernaryValue3 = (GTernaryValue3) obj;
                return b41.d(this.value, gTernaryValue3.value) && b41.d(this.trueBranch, gTernaryValue3.trueBranch) && b41.d(this.falseBranch, gTernaryValue3.falseBranch);
            }
            return false;
        }

        @Nullable
        public final GaiaXExpression getFalseBranch() {
            return this.falseBranch;
        }

        @Nullable
        public final GaiaXExpression getTrueBranch() {
            return this.trueBranch;
        }

        @NotNull
        public final GaiaXExpression getValue() {
            return this.value;
        }

        public int hashCode() {
            int hashCode = this.value.hashCode() * 31;
            GaiaXExpression gaiaXExpression = this.trueBranch;
            int hashCode2 = (hashCode + (gaiaXExpression == null ? 0 : gaiaXExpression.hashCode())) * 31;
            GaiaXExpression gaiaXExpression2 = this.falseBranch;
            return hashCode2 + (gaiaXExpression2 != null ? gaiaXExpression2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "GTernaryValue3(value=" + this.value + ", trueBranch=" + this.trueBranch + ", falseBranch=" + this.falseBranch + ')';
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\t\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GText;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "component1", "value", rz0.ARG_COPY, "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GText extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String value;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GText$Companion;", "", "", "value", "Lcom/youku/gaiax/impl/GaiaXExpression$GText;", "create", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            @NotNull
            public final GText create(@NotNull String str) {
                b41.i(str, "value");
                return new GText(str);
            }

            public final boolean isExpression(@NotNull String str) {
                b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return str.length() > 0;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GText(@NotNull String str) {
            super(null);
            b41.i(str, "value");
            this.value = str;
        }

        public static /* synthetic */ GText copy$default(GText gText, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gText.value;
            }
            return gText.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.value;
        }

        @NotNull
        public final GText copy(@NotNull String str) {
            b41.i(str, "value");
            return new GText(str);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            if (b41.d(this.value, "null")) {
                return null;
            }
            return this.value;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GText) && b41.d(this.value, ((GText) obj).value);
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "GText(value='" + this.value + "')";
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\bHÆ\u0003J\u0019\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\bHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GTextValue;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "", "component1", "values", rz0.ARG_COPY, "", "hashCode", "other", "", "equals", "Ljava/util/List;", "getValues", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GTextValue extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final List<GaiaXExpression> values;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GTextValue$Companion;", "", "", DXTraceUtil.TYPE_EXPRESSION_STRING, "Lcom/youku/gaiax/impl/GaiaXExpression$GTextValue;", "create", "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            @NotNull
            public final GTextValue create(@NotNull String str) {
                List<String> t0;
                b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                GTextValue gTextValue = new GTextValue(null, 1, null);
                t0 = StringsKt__StringsKt.t0(str, new String[]{" + "}, false, 0, 6, null);
                for (String str2 : t0) {
                    gTextValue.getValues().add(GaiaXExpression.Companion.create(str2));
                }
                return gTextValue;
            }

            public final boolean isExpression(@NotNull String str) {
                boolean F;
                boolean K;
                b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                F = C8604o.F(str, m80.DINAMIC_PREFIX_AT, false, 2, null);
                if (F) {
                    return false;
                }
                K = StringsKt__StringsKt.K(str, " + ", false, 2, null);
                return K;
            }
        }

        public GTextValue() {
            this(null, 1, null);
        }

        public /* synthetic */ GTextValue(List list, int i, k50 k50Var) {
            this((i & 1) != 0 ? new ArrayList() : list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GTextValue copy$default(GTextValue gTextValue, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = gTextValue.values;
            }
            return gTextValue.copy(list);
        }

        @NotNull
        public final List<GaiaXExpression> component1() {
            return this.values;
        }

        @NotNull
        public final GTextValue copy(@NotNull List<GaiaXExpression> list) {
            b41.i(list, "values");
            return new GTextValue(list);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            StringBuilder sb = new StringBuilder();
            for (GaiaXExpression gaiaXExpression : this.values) {
                Object desireData = gaiaXExpression.desireData(json);
                if (desireData != null) {
                    sb.append(desireData);
                }
            }
            return sb.toString();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GTextValue) && b41.d(this.values, ((GTextValue) obj).values);
        }

        @NotNull
        public final List<GaiaXExpression> getValues() {
            return this.values;
        }

        public int hashCode() {
            return this.values.hashCode();
        }

        @NotNull
        public String toString() {
            return "GTextValue(values=" + this.values + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GTextValue(@NotNull List<GaiaXExpression> list) {
            super(null);
            b41.i(list, "values");
            this.values = list;
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\nH\u0016J\t\u0010\f\u001a\u00020\nHÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\r\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GValue;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", DXTraceUtil.TYPE_EXPRESSION_STRING, "target", "Ltb/wt2;", "setData", "", "toString", "component1", "value", rz0.ARG_COPY, "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GValue extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String value;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GValue$Companion;", "", "", DXTraceUtil.TYPE_EXPRESSION_STRING, "Lcom/youku/gaiax/impl/GaiaXExpression$GValue;", "create", "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            @NotNull
            public final GValue create(@NotNull String str) {
                b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                Matcher matcher = GaiaXExpression.Companion.getValueRegex().matcher(str);
                if (matcher.find()) {
                    String group = matcher.group(1);
                    b41.h(group, "matcher.group(1)");
                    return new GValue(group);
                }
                return new GValue("");
            }

            public final boolean isExpression(@NotNull String str) {
                b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                Companion companion = GaiaXExpression.Companion;
                if (companion.getValueFullRegex().matcher(str).find()) {
                    Matcher matcher = companion.getValueRegex().matcher(str);
                    int i = 0;
                    while (matcher.find() && (i = i + 1) < 2) {
                    }
                    if (i == 1) {
                        return true;
                    }
                }
                return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GValue(@NotNull String str) {
            super(null);
            b41.i(str, "value");
            this.value = str;
        }

        public static /* synthetic */ GValue copy$default(GValue gValue, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gValue.value;
            }
            return gValue.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.value;
        }

        @NotNull
        public final GValue copy(@NotNull String str) {
            b41.i(str, "value");
            return new GValue(str);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            if (json == null) {
                return null;
            }
            return yq0.c(json, this.value);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GValue) && b41.d(this.value, ((GValue) obj).value);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression, com.alibaba.gaiax.template.GXIExpression
        @NotNull
        public Object expression() {
            return this.value;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public final void setData(@Nullable JSON json, @NotNull Object obj) {
            b41.i(obj, "target");
            if (json == null) {
                return;
            }
            yq0.j(json, this.value, obj);
        }

        @NotNull
        public String toString() {
            return "GValue(value='" + this.value + "')";
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$Self;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "", "toString", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Self extends GaiaXExpression {
        @NotNull
        public static final Self INSTANCE = new Self();

        private Self() {
            super(null);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            return json;
        }

        public final boolean isExpression(@NotNull String str) {
            b41.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
            return b41.d("$$", str);
        }

        @NotNull
        public String toString() {
            return "Self()";
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$Undefined;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Undefined extends GaiaXExpression {
        @NotNull
        public static final Undefined INSTANCE = new Undefined();

        private Undefined() {
            super(null);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            return null;
        }

        @NotNull
        public String toString() {
            return "Undefined()";
        }
    }

    private GaiaXExpression() {
    }

    public /* synthetic */ GaiaXExpression(k50 k50Var) {
        this();
    }

    public static /* synthetic */ Object desireData$default(GaiaXExpression gaiaXExpression, JSON json, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                json = null;
            }
            return gaiaXExpression.desireData(json);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: desireData");
    }

    @Nullable
    public abstract Object desireData(@Nullable JSON json);

    @Override // com.alibaba.gaiax.template.GXIExpression
    @NotNull
    public Object expression() {
        Object obj = this.expression;
        return obj == null ? "" : obj;
    }

    @Nullable
    public final Object getExpression() {
        return this.expression;
    }

    public final void setExpression(@Nullable Object obj) {
        this.expression = obj;
    }

    @Override // com.alibaba.gaiax.template.GXIExpression
    @Nullable
    public Object value(@Nullable JSON json) {
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        Object desireData = desireData(json);
        expressionV1Time = (SystemClock.elapsedRealtimeNanos() - elapsedRealtimeNanos) + expressionV1Time;
        expressionV1Count++;
        return desireData;
    }
}
