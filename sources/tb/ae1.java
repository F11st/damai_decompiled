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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ae1 extends AKBaseAbility<q> {
    private final IAbility b;
    private final String c;
    private final String d;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a implements IOnCallbackListener {
        final /* synthetic */ AKIAbilityCallback b;

        a(AKIAbilityCallback aKIAbilityCallback) {
            this.b = aKIAbilityCallback;
        }

        @Override // com.alibaba.ability.callback.IOnCallbackListener
        public void onCallback(@NotNull qj0 qj0Var) {
            b41.j(qj0Var, "result");
            AKIAbilityCallback aKIAbilityCallback = this.b;
            String b = qj0Var.b();
            Map<String, Object> a = qj0Var.a();
            aKIAbilityCallback.callback(b, new o(a != null ? new JSONObject(a) : null));
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
            aKIAbilityCallback.callback(AKBaseAbility.CALLBACK_FAILURE, new n(jSONObject));
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
    protected l<?> c(@Nullable r rVar, @NotNull q qVar, @NotNull AKIAbilityCallback aKIAbilityCallback) {
        Map<String, ? extends Object> i;
        jg0 hf0Var;
        r0 e;
        b41.j(qVar, "akCtx");
        b41.j(aKIAbilityCallback, WXBridgeManager.METHOD_CALLBACK);
        h a2 = qVar.a();
        b41.e(a2, "akCtx.abilityEngine");
        q0 f = a2.f();
        Context c = qVar.c();
        if (c != null) {
            f.setContextRef(new WeakReference<>(c));
        }
        p0 p0Var = new p0(f);
        p0Var.setUserContext(qVar);
        y yVar = (y) (!(qVar instanceof y) ? null : qVar);
        IAbilityContext withInvokeView = p0Var.withInvokeView(yVar != null ? yVar.f() : null);
        if (rVar == null || (i = rVar.c()) == null) {
            i = kotlin.collections.x.i();
        }
        Map<String, ? extends Object> map = i;
        a aVar = new a(aKIAbilityCallback);
        if (this.c != null) {
            h a3 = qVar.a();
            if (a3 == null || (e = a3.e()) == null || (hf0Var = e.a(this.c, this.d, withInvokeView, map, aVar)) == null) {
                hf0Var = new hf0("400", "NoEngine", null, 4, null);
            }
        } else {
            IAbility iAbility = this.b;
            if (iAbility == null || (hf0Var = iAbility.execute(this.d, withInvokeView, map, new o0(aVar))) == null) {
                hf0Var = new hf0("400", "NoMegability", null, 4, null);
            }
        }
        Map<String, Object> a4 = hf0Var.a();
        JSONObject jSONObject = a4 != null ? new JSONObject(a4) : null;
        if (hf0Var instanceof qj0) {
            return new o(jSONObject);
        }
        if (hf0Var instanceof hf0) {
            hf0 hf0Var2 = (hf0) hf0Var;
            String b = hf0Var2.b();
            String c2 = hf0Var2.c();
            JSONObject jSONObject2 = new JSONObject(2);
            jSONObject2.put("code", (Object) b);
            jSONObject2.put("msg", (Object) c2);
            return new k(new j(10000, jSONObject2.toJSONString()));
        }
        return new m(jSONObject);
    }
}
