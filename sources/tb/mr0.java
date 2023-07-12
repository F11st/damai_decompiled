package tb;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.template.animation.GXIAnimation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class mr0 implements GXIAnimation {
    @NotNull
    public static final C9450a Companion = new C9450a(null);
    @NotNull
    private static final String KEY_LOOP = "loop";
    @NotNull
    private static final String KEY_LOOP_COUNT = "loopCount";
    @NotNull
    private static final String KEY_URL = "url";
    @NotNull
    private static final String KEY_VALUE = "value";
    @Nullable
    private String gxLocalUri;
    @Nullable
    private String gxRemoteUri;
    private int loopCount;

    /* compiled from: Taobao */
    /* renamed from: tb.mr0$a */
    /* loaded from: classes6.dex */
    public static final class C9450a {
        private C9450a() {
        }

        public /* synthetic */ C9450a(k50 k50Var) {
            this();
        }

        @Nullable
        public final mr0 a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            String string = jSONObject.getString("value");
            String string2 = jSONObject.getString("url");
            if (string == null && string2 == null) {
                return null;
            }
            GXRegisterCenter.GXIExtensionLottieAnimation m = GXRegisterCenter.Companion.a().m();
            mr0 create = m == null ? null : m.create();
            if (create == null) {
                return null;
            }
            if (string != null) {
                create.setGxLocalUri(string);
            }
            if (string2 != null) {
                create.setGxRemoteUri(string2);
            }
            if (jSONObject.containsKey("loop")) {
                Boolean bool = jSONObject.getBoolean("loop");
                b41.h(bool, "data.getBoolean(KEY_LOOP)");
                if (bool.booleanValue()) {
                    create.setLoopCount(Integer.MAX_VALUE);
                    return create;
                }
            }
            if (jSONObject.containsKey(mr0.KEY_LOOP_COUNT)) {
                create.setLoopCount(jSONObject.getIntValue(mr0.KEY_LOOP_COUNT));
            }
            return create;
        }
    }

    @Nullable
    public final String getGxLocalUri() {
        return this.gxLocalUri;
    }

    @Nullable
    public final String getGxRemoteUri() {
        return this.gxRemoteUri;
    }

    public final int getLoopCount() {
        return this.loopCount;
    }

    public void playAnimation(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull JSONObject jSONObject, @NotNull JSONObject jSONObject2) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "gxNode");
        b41.i(jSONObject, "gxAnimationExpression");
        b41.i(jSONObject2, "gxAnimationValue");
    }

    public final void setGxLocalUri(@Nullable String str) {
        this.gxLocalUri = str;
    }

    public final void setGxRemoteUri(@Nullable String str) {
        this.gxRemoteUri = str;
    }

    public final void setLoopCount(int i) {
        this.loopCount = i;
    }
}
