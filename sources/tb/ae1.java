package tb;

import android.content.Context;
import com.alibaba.ability.IAbility;
import com.alibaba.ability.callback.IOnCallbackListener;
import com.alibaba.ability.env.IAbilityContext;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.abilitykit.AKBaseAbility;
import com.taobao.android.abilitykit.AKIAbilityCallback;
import com.taobao.weex.bridge.WXBridgeManager;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.collections.C8226x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ae1 extends AKBaseAbility<C9586q> {
    private final IAbility b;
    private final String c;
    private final String d;

    /* compiled from: Taobao */
    /* renamed from: tb.ae1$a */
    /* loaded from: classes8.dex */
    public static final class C8909a implements IOnCallbackListener {
        final /* synthetic */ AKIAbilityCallback b;

        C8909a(AKIAbilityCallback aKIAbilityCallback) {
            this.b = aKIAbilityCallback;
        }

        @Override // com.alibaba.ability.callback.IOnCallbackListener
        public void onCallback(@NotNull qj0 qj0Var) {
            b41.j(qj0Var, "result");
            AKIAbilityCallback aKIAbilityCallback = this.b;
            String b = qj0Var.b();
            Map<String, Object> a = qj0Var.a();
            aKIAbilityCallback.callback(b, new C9488o(a != null ? new JSONObject(a) : null));
        }

        @Override // com.alibaba.ability.callback.IOnCallbackListener
        public void onErrorCallback(@NotNull hf0 hf0Var) {
            b41.j(hf0Var, "ret");
            AKIAbilityCallback aKIAbilityCallback = this.b;
            String b = hf0Var.b();
            String c = hf0Var.c();
            JSONObject jSONObject = new JSONObject(2);
            jSONObject.put("code", (Object) b);
            jSONObject.put("msg", (Object) c);
            aKIAbilityCallback.callback(AKBaseAbility.CALLBACK_FAILURE, new C9455n(jSONObject));
        }

        @Override // com.alibaba.ability.callback.IOnCallbackListener
        public void ongoingCallback(@NotNull kg0 kg0Var) {
            b41.j(kg0Var, "result");
            throw null;
        }
    }

    public ae1(@Nullable IAbility iAbility, @Nullable String str, @NotNull String str2) {
        b41.j(str2, "megaApi");
        this.b = iAbility;
        this.c = str;
        this.d = str2;
    }

    @Override // com.taobao.android.abilitykit.AKBaseAbility
    @NotNull
    protected C9392l<?> c(@Nullable C9636r c9636r, @NotNull C9586q c9586q, @NotNull AKIAbilityCallback aKIAbilityCallback) {
        Map<String, ? extends Object> i;
        jg0 hf0Var;
        C9637r0 e;
        b41.j(c9586q, "akCtx");
        b41.j(aKIAbilityCallback, WXBridgeManager.METHOD_CALLBACK);
        C9192h a = c9586q.a();
        b41.e(a, "akCtx.abilityEngine");
        C9587q0 f = a.f();
        Context c = c9586q.c();
        if (c != null) {
            f.setContextRef(new WeakReference<>(c));
        }
        C9541p0 c9541p0 = new C9541p0(f);
        c9541p0.setUserContext(c9586q);
        C9940y c9940y = (C9940y) (!(c9586q instanceof C9940y) ? null : c9586q);
        IAbilityContext withInvokeView = c9541p0.withInvokeView(c9940y != null ? c9940y.f() : null);
        if (c9636r == null || (i = c9636r.c()) == null) {
            i = C8226x.i();
        }
        Map<String, ? extends Object> map = i;
        C8909a c8909a = new C8909a(aKIAbilityCallback);
        if (this.c != null) {
            C9192h a2 = c9586q.a();
            if (a2 == null || (e = a2.e()) == null || (hf0Var = e.a(this.c, this.d, withInvokeView, map, c8909a)) == null) {
                hf0Var = new hf0("400", "NoEngine", null, 4, null);
            }
        } else {
            IAbility iAbility = this.b;
            if (iAbility == null || (hf0Var = iAbility.execute(this.d, withInvokeView, map, new C9489o0(c8909a))) == null) {
                hf0Var = new hf0("400", "NoMegability", null, 4, null);
            }
        }
        Map<String, Object> a3 = hf0Var.a();
        JSONObject jSONObject = a3 != null ? new JSONObject(a3) : null;
        if (hf0Var instanceof qj0) {
            return new C9488o(jSONObject);
        }
        if (hf0Var instanceof hf0) {
            hf0 hf0Var2 = (hf0) hf0Var;
            String b = hf0Var2.b();
            String c2 = hf0Var2.c();
            JSONObject jSONObject2 = new JSONObject(2);
            jSONObject2.put("code", (Object) b);
            jSONObject2.put("msg", (Object) c2);
            return new C9327k(new C9292j(10000, jSONObject2.toJSONString()));
        }
        return new C9428m(jSONObject);
    }
}
