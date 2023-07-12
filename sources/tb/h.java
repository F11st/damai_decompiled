package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.abilitykit.AKBaseAbility;
import com.taobao.android.abilitykit.AKIAbilityCallback;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class h {
    private g a;
    private JSONObject b;
    private q0 c;
    r0 d;

    public h() {
        this(null);
    }

    public l a(@NonNull JSONObject jSONObject, @Nullable q qVar, @Nullable AKIAbilityCallback aKIAbilityCallback) {
        if (jSONObject == null) {
            k kVar = new k(new j(10002, "NULL"), true);
            y6.a(qVar, null, kVar);
            return kVar;
        }
        return b(new r(jSONObject), qVar, aKIAbilityCallback);
    }

    public l b(r rVar, q qVar, AKIAbilityCallback aKIAbilityCallback) {
        if (qVar == null) {
            qVar = new q();
        }
        qVar.d(this);
        String a = rVar.a();
        if (a != null) {
            try {
                AKBaseAbility<q> a2 = this.a.a(a);
                if (a2 != null) {
                    return a2.b(rVar, qVar, aKIAbilityCallback);
                }
            } catch (Throwable th) {
                k kVar = new k(new j(10000, "type " + a + ", exp=" + th.getMessage()));
                y6.a(qVar, rVar, kVar);
                return kVar;
            }
        }
        k kVar2 = new k(new j(10002, "TypeNotFound：" + a));
        y6.a(qVar, rVar, kVar2);
        return kVar2;
    }

    public AKBaseAbility<q> c(String str) {
        return this.a.a(str);
    }

    public JSONObject d() {
        return this.b;
    }

    @NonNull
    public r0 e() {
        if (this.d == null) {
            q0 f = f();
            f.a(this);
            this.d = new r0(f);
        }
        return this.d;
    }

    @NotNull
    public q0 f() {
        if (this.c == null) {
            this.c = new q0("AbilityKit", "AbilityKit");
        }
        return this.c;
    }

    public void g() {
        this.b.clear();
    }

    public void h(q0 q0Var) {
        if (this.c == null) {
            this.c = q0Var;
        }
    }

    public h(@NonNull q0 q0Var, @Nullable i iVar) {
        this(iVar);
        this.c = q0Var;
    }

    public h(i iVar) {
        this.d = null;
        this.a = new g();
        this.b = new JSONObject();
        new HashMap();
        new t0();
    }
}
