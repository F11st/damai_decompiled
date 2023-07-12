package com.alibaba.gaiax.template;

import android.content.res.AssetManager;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.taobao.weex.common.Constants;
import com.taobao.weex.devtools.inspector.elements.W3CStyleConstants;
import com.taobao.weex.utils.TypefaceUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.collections.C8214m;
import kotlin.jvm.functions.Function0;
import kotlin.text.C8604o;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.dq0;
import tb.ds0;
import tb.hr0;
import tb.hs0;
import tb.ir0;
import tb.jn1;
import tb.k50;
import tb.lq0;
import tb.lz1;
import tb.mq0;
import tb.oq0;
import tb.pr0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class GXStyleConvert {
    @NotNull
    public static final C3399a Companion = new C3399a(null);
    @NotNull
    private static final Lazy<GXStyleConvert> a;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.template.GXStyleConvert$a */
    /* loaded from: classes6.dex */
    public static final class C3399a {
        private C3399a() {
        }

        public /* synthetic */ C3399a(k50 k50Var) {
            this();
        }

        @NotNull
        public final GXStyleConvert a() {
            return (GXStyleConvert) GXStyleConvert.a.getValue();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.template.GXStyleConvert$b */
    /* loaded from: classes6.dex */
    public /* synthetic */ class C3400b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GradientDrawable.Orientation.values().length];
            iArr[GradientDrawable.Orientation.TOP_BOTTOM.ordinal()] = 1;
            iArr[GradientDrawable.Orientation.BOTTOM_TOP.ordinal()] = 2;
            iArr[GradientDrawable.Orientation.LEFT_RIGHT.ordinal()] = 3;
            iArr[GradientDrawable.Orientation.RIGHT_LEFT.ordinal()] = 4;
            iArr[GradientDrawable.Orientation.TL_BR.ordinal()] = 5;
            iArr[GradientDrawable.Orientation.TR_BL.ordinal()] = 6;
            iArr[GradientDrawable.Orientation.BR_TL.ordinal()] = 7;
            iArr[GradientDrawable.Orientation.BL_TR.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        Lazy<GXStyleConvert> b;
        b = C8177b.b(new Function0<GXStyleConvert>() { // from class: com.alibaba.gaiax.template.GXStyleConvert$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXStyleConvert invoke() {
                return new GXStyleConvert();
            }
        });
        a = b;
    }

    @Nullable
    public final Boolean A(@NotNull String str) {
        b41.i(str, "target");
        if (b41.d(str, "visible")) {
            return Boolean.FALSE;
        }
        if (b41.d(str, "hidden")) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Nullable
    public final lz1<hs0> B(@NotNull JSONObject jSONObject) {
        lz1<hs0> lz1Var;
        b41.i(jSONObject, "cssJson");
        lz1<hs0> b = oq0.INSTANCE.b(jSONObject.getString("edge-insets"));
        String string = jSONObject.getString(Constants.Name.PADDING);
        if (string == null) {
            lz1Var = null;
        } else {
            hs0 d = hs0.Companion.d(string);
            lz1Var = new lz1<>(d, d, d, d);
        }
        String string2 = jSONObject.getString(W3CStyleConstants.PADDING_LEFT);
        if (string2 != null) {
            if (lz1Var == null) {
                hs0.C9232f c9232f = hs0.C9232f.INSTANCE;
                lz1Var = new lz1<>(c9232f, c9232f, c9232f, c9232f);
            }
            lz1Var.g(hs0.Companion.d(string2));
        }
        String string3 = jSONObject.getString(W3CStyleConstants.PADDING_RIGHT);
        if (string3 != null) {
            if (lz1Var == null) {
                hs0.C9232f c9232f2 = hs0.C9232f.INSTANCE;
                lz1Var = new lz1<>(c9232f2, c9232f2, c9232f2, c9232f2);
            }
            lz1Var.f(hs0.Companion.d(string3));
        }
        String string4 = jSONObject.getString(W3CStyleConstants.PADDING_TOP);
        if (string4 != null) {
            if (lz1Var == null) {
                hs0.C9232f c9232f3 = hs0.C9232f.INSTANCE;
                lz1Var = new lz1<>(c9232f3, c9232f3, c9232f3, c9232f3);
            }
            lz1Var.h(hs0.Companion.d(string4));
        }
        String string5 = jSONObject.getString(W3CStyleConstants.PADDING_BOTTOM);
        if (string5 != null) {
            if (lz1Var == null) {
                hs0.C9232f c9232f4 = hs0.C9232f.INSTANCE;
                lz1Var = new lz1<>(c9232f4, c9232f4, c9232f4, c9232f4);
            }
            lz1Var.e(hs0.Companion.d(string5));
        }
        if (b != null) {
            if (lz1Var == null) {
                hs0.C9232f c9232f5 = hs0.C9232f.INSTANCE;
                lz1Var = new lz1<>(c9232f5, c9232f5, c9232f5, c9232f5);
            }
            if (!(b.c() instanceof hs0.C9232f)) {
                lz1Var.g(b.c());
            }
            if (!(b.b() instanceof hs0.C9232f)) {
                lz1Var.f(b.b());
            }
            if (!(b.d() instanceof hs0.C9232f)) {
                lz1Var.h(b.d());
            }
            if (!(b.a() instanceof hs0.C9232f)) {
                lz1Var.e(b.a());
            }
        }
        return lz1Var;
    }

    public final void C(@NotNull AssetManager assetManager) {
        b41.i(assetManager, "<set-?>");
    }

    @Nullable
    public final Integer D(@NotNull String str) {
        b41.i(str, "target");
        if (b41.d(str, "line-through")) {
            return 16;
        }
        return b41.d(str, "underline") ? 8 : null;
    }

    @Nullable
    public final dq0 b(@NotNull String str) {
        b41.i(str, "target");
        return dq0.Companion.a(str);
    }

    @Nullable
    public final mq0 c(@NotNull String str) {
        b41.i(str, "target");
        return mq0.Companion.a(str);
    }

    @Nullable
    public final hr0 d(@NotNull String str) {
        boolean F;
        b41.i(str, "target");
        F = C8604o.F(str, "linear-gradient", false, 2, null);
        if (F) {
            List<String> u = u(str);
            return new hr0(t(u), v(u));
        }
        mq0 a2 = mq0.Companion.a(str);
        if (a2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        return new hr0(GradientDrawable.Orientation.LEFT_RIGHT, arrayList);
    }

    @Nullable
    public final mq0 e(@NotNull String str) {
        b41.i(str, "target");
        return mq0.Companion.a(str);
    }

    @Nullable
    public final ds0 f(@NotNull JSONObject jSONObject) {
        ds0 ds0Var;
        b41.i(jSONObject, "css");
        String string = jSONObject.getString("border-radius");
        if (string == null) {
            ds0Var = null;
        } else {
            hs0 d = hs0.Companion.d(string);
            ds0Var = new ds0(d, d, d, d);
        }
        String string2 = jSONObject.getString("border-top-left-radius");
        if (string2 != null) {
            if (ds0Var == null) {
                ds0Var = new ds0(null, null, null, null);
            }
            ds0Var.h(hs0.Companion.d(string2));
        }
        String string3 = jSONObject.getString("border-top-right-radius");
        if (string3 != null) {
            if (ds0Var == null) {
                ds0Var = new ds0(null, null, null, null);
            }
            ds0Var.i(hs0.Companion.d(string3));
        }
        String string4 = jSONObject.getString("border-bottom-left-radius");
        if (string4 != null) {
            if (ds0Var == null) {
                ds0Var = new ds0(null, null, null, null);
            }
            ds0Var.f(hs0.Companion.d(string4));
        }
        String string5 = jSONObject.getString("border-bottom-right-radius");
        if (string5 != null) {
            if (ds0Var == null) {
                ds0Var = new ds0(null, null, null, null);
            }
            ds0Var.g(hs0.Companion.d(string5));
        }
        return ds0Var;
    }

    @NotNull
    public final hs0 g(@NotNull String str) {
        b41.i(str, "target");
        return hs0.Companion.d(str);
    }

    @Nullable
    public final lq0 h(@NotNull String str) {
        List t0;
        b41.i(str, "target");
        t0 = StringsKt__StringsKt.t0(str, new String[]{" "}, false, 0, 6, null);
        if (t0.size() == 5) {
            hs0.C9228b c9228b = hs0.Companion;
            hs0 d = c9228b.d((String) t0.get(0));
            hs0 d2 = c9228b.d((String) t0.get(1));
            hs0 d3 = c9228b.d((String) t0.get(2));
            hs0 d4 = c9228b.d((String) t0.get(3));
            mq0.C9449a c9449a = mq0.Companion;
            mq0 a2 = c9449a.a((String) t0.get(4));
            if (a2 == null) {
                a2 = c9449a.c();
            }
            return new lq0(d, d2, d3, d4, a2);
        }
        return null;
    }

    @Nullable
    public final Shader i(float f, float f2, @NotNull GradientDrawable.Orientation orientation, @NotNull int[] iArr) {
        b41.i(orientation, "direction");
        b41.i(iArr, "colors");
        switch (C3400b.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                return new ir0(0.0f, 0.0f, 0.0f, f2, iArr, null, Shader.TileMode.CLAMP);
            case 2:
                return new ir0(0.0f, f2, 0.0f, 0.0f, iArr, null, Shader.TileMode.CLAMP);
            case 3:
                return new ir0(0.0f, 0.0f, f, 0.0f, iArr, null, Shader.TileMode.CLAMP);
            case 4:
                return new ir0(f, 0.0f, 0.0f, 0.0f, iArr, null, Shader.TileMode.CLAMP);
            case 5:
                return new ir0(0.0f, 0.0f, f, f2, iArr, null, Shader.TileMode.CLAMP);
            case 6:
                return new ir0(f, 0.0f, 0.0f, f2, iArr, null, Shader.TileMode.CLAMP);
            case 7:
                return new ir0(f, f2, 0.0f, 0.0f, iArr, null, Shader.TileMode.CLAMP);
            case 8:
                return new ir0(0.0f, f2, f, 0.0f, iArr, null, Shader.TileMode.CLAMP);
            default:
                return null;
        }
    }

    @Nullable
    public final Integer j(@NotNull String str) {
        b41.i(str, "target");
        if (b41.d(str, "none")) {
            return 8;
        }
        return b41.d(str, Constants.Name.FLEX) ? 0 : null;
    }

    public final boolean k(@NotNull String str) {
        b41.i(str, "target");
        return Boolean.parseBoolean(str);
    }

    @NotNull
    public final hs0 l(@NotNull String str) {
        b41.i(str, "target");
        return hs0.Companion.d(str);
    }

    @Nullable
    public final mq0 m(@NotNull String str) {
        b41.i(str, "target");
        return mq0.Companion.a(str);
    }

    @Nullable
    public final Typeface n(@NotNull String str) {
        Object convert;
        b41.i(str, Constants.Name.FONT_FAMILY);
        GXRegisterCenter.GXIExtensionStaticProperty q = GXRegisterCenter.Companion.a().q();
        if (q != null && (convert = q.convert(new GXRegisterCenter.GXIExtensionStaticProperty.C3332a(TypefaceUtil.FONT_CACHE_DIR_NAME, str))) != null) {
            Typeface typeface = convert instanceof Typeface ? (Typeface) convert : null;
            if (typeface != null) {
                return typeface;
            }
        }
        return null;
    }

    @NotNull
    public final hs0 o(@NotNull String str) {
        b41.i(str, "target");
        return hs0.Companion.d(str);
    }

    public final int p(@NotNull String str) {
        b41.i(str, "target");
        return Integer.parseInt(str);
    }

    @Nullable
    public final Integer q(@NotNull String str) {
        b41.i(str, "target");
        int hashCode = str.hashCode();
        if (hashCode != -1364013995) {
            if (hashCode != 3317767) {
                if (hashCode == 108511772 && str.equals("right")) {
                    return 5;
                }
            } else if (str.equals("left")) {
                return 3;
            }
        } else if (str.equals("center")) {
            return 17;
        }
        return null;
    }

    @Nullable
    public final TextUtils.TruncateAt r(@NotNull String str) {
        Object convert;
        b41.i(str, "target");
        int hashCode = str.hashCode();
        if (hashCode != -1074341483) {
            if (hashCode != 3056464) {
                if (hashCode == 188702929 && str.equals(Constants.Name.ELLIPSIS)) {
                    return TextUtils.TruncateAt.END;
                }
            } else if (str.equals("clip")) {
                GXRegisterCenter.GXIExtensionStaticProperty q = GXRegisterCenter.Companion.a().q();
                if (q == null || (convert = q.convert(new GXRegisterCenter.GXIExtensionStaticProperty.C3332a("text-overflow", "clip"))) == null) {
                    return null;
                }
                return (TextUtils.TruncateAt) convert;
            }
        } else if (str.equals("middle")) {
            return TextUtils.TruncateAt.MIDDLE;
        }
        return TextUtils.TruncateAt.END;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r2.equals("700") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
        if (r2.equals("600") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
        if (r2.equals("500") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
        if (r2.equals("400") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
        if (r2.equals("300") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
        if (r2.equals("200") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004f, code lost:
        if (r2.equals(org.android.agoo.message.MessageService.MSG_DB_COMPLETE) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
        if (r2.equals("normal") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0064, code lost:
        if (r2.equals(tb.wv.PARAM_LEVEL_MEDIUM) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
        return android.graphics.Typeface.DEFAULT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        return android.graphics.Typeface.DEFAULT_BOLD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r2.equals(com.taobao.weex.common.Constants.Value.BOLD) == false) goto L29;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Typeface s(@org.jetbrains.annotations.Nullable java.lang.String r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L6a
            int r0 = r2.hashCode()
            switch(r0) {
                case -1078030475: goto L5e;
                case -1039745817: goto L52;
                case 48625: goto L49;
                case 49586: goto L40;
                case 50547: goto L37;
                case 51508: goto L2e;
                case 52469: goto L25;
                case 53430: goto L1c;
                case 54391: goto L13;
                case 3029637: goto La;
                default: goto L9;
            }
        L9:
            goto L6a
        La:
            java.lang.String r0 = "bold"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L67
            goto L6a
        L13:
            java.lang.String r0 = "700"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L67
            goto L6a
        L1c:
            java.lang.String r0 = "600"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L67
            goto L6a
        L25:
            java.lang.String r0 = "500"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L67
            goto L6a
        L2e:
            java.lang.String r0 = "400"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L5b
            goto L6a
        L37:
            java.lang.String r0 = "300"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L5b
            goto L6a
        L40:
            java.lang.String r0 = "200"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L5b
            goto L6a
        L49:
            java.lang.String r0 = "100"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L5b
            goto L6a
        L52:
            java.lang.String r0 = "normal"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L5b
            goto L6a
        L5b:
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT
            goto L6b
        L5e:
            java.lang.String r0 = "medium"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L67
            goto L6a
        L67:
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT_BOLD
            goto L6b
        L6a:
            r2 = 0
        L6b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.gaiax.template.GXStyleConvert.s(java.lang.String):android.graphics.Typeface");
    }

    @NotNull
    public final GradientDrawable.Orientation t(@NotNull List<String> list) {
        b41.i(list, "linear");
        if (!list.isEmpty()) {
            String str = list.get(0);
            switch (str.hashCode()) {
                case -2080783504:
                    if (str.equals("to bottom")) {
                        return GradientDrawable.Orientation.TOP_BOTTOM;
                    }
                    break;
                case -1849920841:
                    if (str.equals("to bottom left")) {
                        return GradientDrawable.Orientation.TR_BL;
                    }
                    break;
                case -1507310228:
                    if (str.equals("to bottom right")) {
                        return GradientDrawable.Orientation.TL_BR;
                    }
                    break;
                case -1486250643:
                    if (str.equals("tobottomleft")) {
                        return GradientDrawable.Orientation.TR_BL;
                    }
                    break;
                case -1359525897:
                    if (str.equals("to top left")) {
                        return GradientDrawable.Orientation.BR_TL;
                    }
                    break;
                case -1352032154:
                    if (str.equals("tobottom")) {
                        return GradientDrawable.Orientation.TOP_BOTTOM;
                    }
                    break;
                case -1213049204:
                    if (str.equals("to left")) {
                        return GradientDrawable.Orientation.RIGHT_LEFT;
                    }
                    break;
                case -1137407871:
                    if (str.equals("toright")) {
                        return GradientDrawable.Orientation.LEFT_RIGHT;
                    }
                    break;
                case -1033506462:
                    if (str.equals("totopright")) {
                        return GradientDrawable.Orientation.BL_TR;
                    }
                    break;
                case -870406608:
                    if (str.equals("to top")) {
                        return GradientDrawable.Orientation.BOTTOM_TOP;
                    }
                    break;
                case -868157182:
                    if (str.equals("toleft")) {
                        return GradientDrawable.Orientation.RIGHT_LEFT;
                    }
                    break;
                case -172068863:
                    if (str.equals("totopleft")) {
                        return GradientDrawable.Orientation.BR_TL;
                    }
                    break;
                case 110550266:
                    if (str.equals("totop")) {
                        return GradientDrawable.Orientation.BOTTOM_TOP;
                    }
                    break;
                case 810031148:
                    if (str.equals("to top right")) {
                        return GradientDrawable.Orientation.BL_TR;
                    }
                    break;
                case 1055841335:
                    if (str.equals("to right")) {
                        return GradientDrawable.Orientation.LEFT_RIGHT;
                    }
                    break;
                case 1176531318:
                    if (str.equals("tobottomright")) {
                        return GradientDrawable.Orientation.TL_BR;
                    }
                    break;
            }
            return GradientDrawable.Orientation.TOP_BOTTOM;
        }
        return GradientDrawable.Orientation.TOP_BOTTOM;
    }

    @NotNull
    public final List<String> u(@NotNull String str) {
        int Z;
        int f0;
        boolean K;
        boolean K2;
        List<String> t0;
        CharSequence M0;
        List t02;
        CharSequence M02;
        boolean p;
        List t03;
        CharSequence M03;
        boolean p2;
        b41.i(str, "linear");
        ArrayList arrayList = new ArrayList();
        try {
            Z = StringsKt__StringsKt.Z(str, jn1.BRACKET_START_STR, 0, false, 6, null);
            f0 = StringsKt__StringsKt.f0(str, jn1.BRACKET_END_STR, 0, false, 6, null);
            String substring = str.substring(Z + 1, f0);
            b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            K = StringsKt__StringsKt.K(substring, "rgba", false, 2, null);
            if (K) {
                t03 = StringsKt__StringsKt.t0(substring, new String[]{"rgba"}, false, 0, 6, null);
                int i = 0;
                for (Object obj : t03) {
                    int i2 = i + 1;
                    if (i < 0) {
                        C8214m.p();
                    }
                    String str2 = (String) obj;
                    if (str2 != null) {
                        M03 = StringsKt__StringsKt.M0(str2);
                        String obj2 = M03.toString();
                        p2 = C8604o.p(obj2, ",", false, 2, null);
                        if (p2) {
                            obj2 = obj2.substring(0, obj2.length() - 1);
                            b41.h(obj2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        }
                        if (i > 0) {
                            arrayList.add(b41.r("rgba", obj2));
                        } else {
                            arrayList.add(obj2);
                        }
                        i = i2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
            } else {
                K2 = StringsKt__StringsKt.K(substring, "rgb", false, 2, null);
                if (K2) {
                    t02 = StringsKt__StringsKt.t0(substring, new String[]{"rgb"}, false, 0, 6, null);
                    int i3 = 0;
                    for (Object obj3 : t02) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            C8214m.p();
                        }
                        String str3 = (String) obj3;
                        if (str3 != null) {
                            M02 = StringsKt__StringsKt.M0(str3);
                            String obj4 = M02.toString();
                            p = C8604o.p(obj4, ",", false, 2, null);
                            if (p) {
                                obj4 = obj4.substring(0, obj4.length() - 1);
                                b41.h(obj4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            }
                            if (i3 > 0) {
                                arrayList.add(b41.r("rgb", obj4));
                            } else {
                                arrayList.add(obj4);
                            }
                            i3 = i4;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                    }
                } else {
                    t0 = StringsKt__StringsKt.t0(substring, new String[]{","}, false, 0, 6, null);
                    for (String str4 : t0) {
                        if (str4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        M0 = StringsKt__StringsKt.M0(str4);
                        arrayList.add(M0.toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @NotNull
    public final List<mq0> v(@NotNull List<String> list) {
        boolean F;
        b41.i(list, "linear");
        ArrayList<String> arrayList = new ArrayList();
        for (String str : list) {
            F = C8604o.F(str, "to", false, 2, null);
            if (!F) {
                arrayList.add(str);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : arrayList) {
            mq0 a2 = mq0.Companion.a(str2);
            if (a2 != null) {
                arrayList2.add(a2);
            } else {
                throw new IllegalArgumentException("linearColor create color error");
            }
        }
        return arrayList2;
    }

    @Nullable
    public final Integer w(@NotNull String str) {
        b41.i(str, "target");
        if (b41.d(str, "true")) {
            return 4;
        }
        return b41.d(str, "false") ? 0 : null;
    }

    public final void x(@NotNull AssetManager assetManager) {
        b41.i(assetManager, "assetManager");
        C(assetManager);
    }

    @Nullable
    public final pr0 y(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "css");
        if (jSONObject.containsKey("mode")) {
            String string = jSONObject.getString("mode");
            if (string == null) {
                string = "scaleToFill";
            }
            String string2 = jSONObject.getString("mode-type");
            if (string2 == null) {
                string2 = "scale";
            }
            return new pr0(string2, string);
        }
        return null;
    }

    public final float z(@NotNull String str) {
        b41.i(str, "target");
        return Float.parseFloat(str);
    }
}
