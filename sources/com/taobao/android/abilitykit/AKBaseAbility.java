package com.taobao.android.abilitykit;

import com.alibaba.ability.MegaUtils;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoAbilitySpan;
import tb.C9292j;
import tb.C9327k;
import tb.C9392l;
import tb.C9428m;
import tb.C9586q;
import tb.C9636r;
import tb.l61;
import tb.y6;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class AKBaseAbility<T extends C9586q> {
    public static final String CALLBACK_FAILURE = "failure";
    public static final String CALLBACK_SUCCESS = "success";
    private FalcoAbilitySpan a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.abilitykit.AKBaseAbility$a */
    /* loaded from: classes8.dex */
    public class C6295a implements AKIAbilityCallback {
        final /* synthetic */ AKIAbilityCallback a;
        final /* synthetic */ C9586q b;
        final /* synthetic */ C9636r c;

        C6295a(AKBaseAbility aKBaseAbility, AKIAbilityCallback aKIAbilityCallback, C9586q c9586q, C9636r c9636r) {
            this.a = aKIAbilityCallback;
            this.b = c9586q;
            this.c = c9636r;
        }

        @Override // com.taobao.android.abilitykit.AKIAbilityCallback
        public void callback(String str, C9392l c9392l) {
            AKIAbilityCallback aKIAbilityCallback = this.a;
            if (aKIAbilityCallback != null) {
                aKIAbilityCallback.callback(str, c9392l);
            }
            if (c9392l instanceof C9327k) {
                y6.a(this.b, this.c, (C9327k) c9392l);
            }
        }
    }

    public C9392l a(JSONObject jSONObject, T t, AKIAbilityCallback aKIAbilityCallback) {
        if (jSONObject == null) {
            C9327k c9327k = new C9327k(new C9292j(10002, "NULL"), true);
            y6.a(t, null, c9327k);
            return c9327k;
        }
        return b(new C9636r(jSONObject), t, aKIAbilityCallback);
    }

    public C9392l b(final C9636r c9636r, final T t, AKIAbilityCallback aKIAbilityCallback) {
        final C6295a c6295a = new C6295a(this, aKIAbilityCallback, t, c9636r);
        if (l61.b(c9636r != null ? c9636r.b() : null, "isMainThread", true)) {
            C9392l c = c(c9636r, t, c6295a);
            if (c instanceof C9327k) {
                y6.a(t, c9636r, (C9327k) c);
            }
            return c;
        }
        MegaUtils.e(new Runnable() { // from class: com.taobao.android.abilitykit.AKBaseAbility.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                final C9392l c2 = AKBaseAbility.this.c(c9636r, t, c6295a);
                if (c2 == null || (c2 instanceof C9428m)) {
                    return;
                }
                MegaUtils.d(new Runnable() { // from class: com.taobao.android.abilitykit.AKBaseAbility.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c6295a.callback("_onResult", c2);
                    }
                }, 0L);
            }
        });
        return new C9428m();
    }

    protected abstract C9392l c(C9636r c9636r, T t, AKIAbilityCallback aKIAbilityCallback);

    public void d(FalcoAbilitySpan falcoAbilitySpan) {
        this.a = falcoAbilitySpan;
    }

    public boolean e() {
        return true;
    }
}
