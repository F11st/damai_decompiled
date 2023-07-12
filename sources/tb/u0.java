package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.abilitykit.AKIAbilityCallback;
import java.lang.ref.SoftReference;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.C8226x;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class u0 {
    public static final u0 INSTANCE = new u0();
    private static SoftReference<C9192h> a;

    private u0() {
    }

    @JvmStatic
    @Nullable
    public static final C9392l<?> a(@NotNull String str, @NotNull JSONObject jSONObject, @Nullable C9586q c9586q, @Nullable AKIAbilityCallback aKIAbilityCallback, boolean z) {
        C9192h c;
        Map m;
        b41.j(str, "type");
        b41.j(jSONObject, "params");
        if (c9586q == null || (c = c9586q.a()) == null) {
            c = c();
        }
        m = C8226x.m(hq2.a("type", str), hq2.a("params", jSONObject), hq2.a("isMainThread", Boolean.valueOf(z)));
        if (m != null) {
            return c.a(new JSONObject(m), c9586q, aKIAbilityCallback);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
    }

    @JvmStatic
    @Nullable
    public static /* bridge */ /* synthetic */ C9392l b(String str, JSONObject jSONObject, C9586q c9586q, AKIAbilityCallback aKIAbilityCallback, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            c9586q = null;
        }
        if ((i & 8) != 0) {
            aKIAbilityCallback = null;
        }
        if ((i & 16) != 0) {
            z = true;
        }
        return a(str, jSONObject, c9586q, aKIAbilityCallback, z);
    }

    @JvmStatic
    private static final C9192h c() {
        C9192h c9192h;
        SoftReference<C9192h> softReference = a;
        if (softReference == null || (c9192h = softReference.get()) == null) {
            C9192h c9192h2 = new C9192h(new C9587q0("AbilityKit", "AbilityKit"), null);
            a = new SoftReference<>(c9192h2);
            return c9192h2;
        }
        return c9192h;
    }
}
