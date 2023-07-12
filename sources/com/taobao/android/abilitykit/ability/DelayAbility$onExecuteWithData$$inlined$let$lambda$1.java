package com.taobao.android.abilitykit.ability;

import com.taobao.android.abilitykit.AKIAbilityCallback;
import kotlin.Metadata;
import tb.o;
import tb.q;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/wt2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes8.dex */
final class DelayAbility$onExecuteWithData$$inlined$let$lambda$1 implements Runnable {
    final /* synthetic */ q $akAbilityRuntimeContext$inlined;
    final /* synthetic */ AKIAbilityCallback $akiAbilityCallback$inlined;

    DelayAbility$onExecuteWithData$$inlined$let$lambda$1(q qVar, AKIAbilityCallback aKIAbilityCallback) {
        this.$akAbilityRuntimeContext$inlined = qVar;
        this.$akiAbilityCallback$inlined = aKIAbilityCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AKIAbilityCallback aKIAbilityCallback = this.$akiAbilityCallback$inlined;
        if (aKIAbilityCallback != null) {
            aKIAbilityCallback.callback("onComplete", new o());
        }
    }
}
