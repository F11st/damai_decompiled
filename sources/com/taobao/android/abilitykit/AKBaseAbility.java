package com.taobao.android.abilitykit;

import com.alibaba.ability.MegaUtils;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoAbilitySpan;
import tb.j;
import tb.k;
import tb.l;
import tb.l61;
import tb.m;
import tb.q;
import tb.r;
import tb.y6;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class AKBaseAbility<T extends q> {
    public static final String CALLBACK_FAILURE = "failure";
    public static final String CALLBACK_SUCCESS = "success";
    private FalcoAbilitySpan a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements AKIAbilityCallback {
        final /* synthetic */ AKIAbilityCallback a;
        final /* synthetic */ q b;
        final /* synthetic */ r c;

        a(AKBaseAbility aKBaseAbility, AKIAbilityCallback aKIAbilityCallback, q qVar, r rVar) {
            this.a = aKIAbilityCallback;
            this.b = qVar;
            this.c = rVar;
        }

        @Override // com.taobao.android.abilitykit.AKIAbilityCallback
        public void callback(String str, l lVar) {
            AKIAbilityCallback aKIAbilityCallback = this.a;
            if (aKIAbilityCallback != null) {
                aKIAbilityCallback.callback(str, lVar);
            }
            if (lVar instanceof k) {
                y6.a(this.b, this.c, (k) lVar);
            }
        }
    }

    public l a(JSONObject jSONObject, T t, AKIAbilityCallback aKIAbilityCallback) {
        if (jSONObject == null) {
            k kVar = new k(new j(10002, "NULL"), true);
            y6.a(t, null, kVar);
            return kVar;
        }
        return b(new r(jSONObject), t, aKIAbilityCallback);
    }

    public l b(final r rVar, final T t, AKIAbilityCallback aKIAbilityCallback) {
        final a aVar = new a(this, aKIAbilityCallback, t, rVar);
        if (l61.b(rVar != null ? rVar.b() : null, "isMainThread", true)) {
            l c = c(rVar, t, aVar);
            if (c instanceof k) {
                y6.a(t, rVar, (k) c);
            }
            return c;
        }
        MegaUtils.e(new Runnable() { // from class: com.taobao.android.abilitykit.AKBaseAbility.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                final l c2 = AKBaseAbility.this.c(rVar, t, aVar);
                if (c2 == null || (c2 instanceof m)) {
                    return;
                }
                MegaUtils.d(new Runnable() { // from class: com.taobao.android.abilitykit.AKBaseAbility.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.callback("_onResult", c2);
                    }
                }, 0L);
            }
        });
        return new m();
    }

    protected abstract l c(r rVar, T t, AKIAbilityCallback aKIAbilityCallback);

    public void d(FalcoAbilitySpan falcoAbilitySpan) {
        this.a = falcoAbilitySpan;
    }

    public boolean e() {
        return true;
    }
}
