package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.abilitykit.AKBaseAbility;
import com.taobao.android.abilitykit.AKIAbilityCallback;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* renamed from: tb.h */
/* loaded from: classes8.dex */
public class C9192h {
    private C9151g a;
    private JSONObject b;
    private C9587q0 c;
    C9637r0 d;

    public C9192h() {
        this(null);
    }

    public C9392l a(@NonNull JSONObject jSONObject, @Nullable C9586q c9586q, @Nullable AKIAbilityCallback aKIAbilityCallback) {
        if (jSONObject == null) {
            C9327k c9327k = new C9327k(new C9292j(10002, "NULL"), true);
            y6.a(c9586q, null, c9327k);
            return c9327k;
        }
        return b(new C9636r(jSONObject), c9586q, aKIAbilityCallback);
    }

    public C9392l b(C9636r c9636r, C9586q c9586q, AKIAbilityCallback aKIAbilityCallback) {
        if (c9586q == null) {
            c9586q = new C9586q();
        }
        c9586q.d(this);
        String a = c9636r.a();
        if (a != null) {
            try {
                AKBaseAbility<C9586q> a2 = this.a.a(a);
                if (a2 != null) {
                    return a2.b(c9636r, c9586q, aKIAbilityCallback);
                }
            } catch (Throwable th) {
                C9327k c9327k = new C9327k(new C9292j(10000, "type " + a + ", exp=" + th.getMessage()));
                y6.a(c9586q, c9636r, c9327k);
                return c9327k;
            }
        }
        C9327k c9327k2 = new C9327k(new C9292j(10002, "TypeNotFound：" + a));
        y6.a(c9586q, c9636r, c9327k2);
        return c9327k2;
    }

    public AKBaseAbility<C9586q> c(String str) {
        return this.a.a(str);
    }

    public JSONObject d() {
        return this.b;
    }

    @NonNull
    public C9637r0 e() {
        if (this.d == null) {
            C9587q0 f = f();
            f.a(this);
            this.d = new C9637r0(f);
        }
        return this.d;
    }

    @NotNull
    public C9587q0 f() {
        if (this.c == null) {
            this.c = new C9587q0("AbilityKit", "AbilityKit");
        }
        return this.c;
    }

    public void g() {
        this.b.clear();
    }

    public void h(C9587q0 c9587q0) {
        if (this.c == null) {
            this.c = c9587q0;
        }
    }

    public C9192h(@NonNull C9587q0 c9587q0, @Nullable C9247i c9247i) {
        this(c9247i);
        this.c = c9587q0;
    }

    public C9192h(C9247i c9247i) {
        this.d = null;
        this.a = new C9151g();
        this.b = new JSONObject();
        new HashMap();
        new t0();
    }
}
