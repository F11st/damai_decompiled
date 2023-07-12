package tb;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXIExpression;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class zp0 {
    @NotNull
    public static final C10031a Companion = new C10031a(null);
    @NotNull
    public static final String KEY_LOTTIE_ANIMATOR = "lottieAnimator";
    @NotNull
    public static final String KEY_PROP_ANIMATOR_SET = "propAnimatorSet";
    @NotNull
    public static final String KEY_STATE = "state";
    @NotNull
    public static final String KEY_TRIGGER = "trigger";
    @NotNull
    public static final String KEY_TYPE = "type";
    @NotNull
    private final String a;
    @NotNull
    private final GXIExpression b;

    /* compiled from: Taobao */
    /* renamed from: tb.zp0$a */
    /* loaded from: classes6.dex */
    public static final class C10031a {
        private C10031a() {
        }

        public /* synthetic */ C10031a(k50 k50Var) {
            this();
        }

        @Nullable
        public final zp0 a(@Nullable String str, @NotNull JSONObject jSONObject) {
            Object a;
            GXIExpression a2;
            b41.i(jSONObject, "data");
            String string = jSONObject.getString("type");
            if (string == null) {
                return null;
            }
            xq0 xq0Var = xq0.INSTANCE;
            GXIExpression a3 = xq0Var.a(str, string);
            String obj = (a3 == null || (a = GXIExpression.C3398a.a(a3, null, 1, null)) == null) ? null : a.toString();
            if (obj == null || (a2 = xq0Var.a(str, jSONObject)) == null) {
                return null;
            }
            return new zp0(obj, a2);
        }
    }

    public zp0(@NotNull String str, @NotNull GXIExpression gXIExpression) {
        b41.i(str, "type");
        b41.i(gXIExpression, C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
        this.a = str;
        this.b = gXIExpression;
    }

    @NotNull
    public final GXIExpression a() {
        return this.b;
    }

    @NotNull
    public final String b() {
        return this.a;
    }
}
