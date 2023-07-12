package com.alibaba.ability.hub;

import com.alibaba.ability.callback.IOnCallbackListener;
import com.alibaba.ability.env.IAbilityContext;
import java.util.Map;
import kotlin.Metadata;
import tb.C9637r0;
import tb.hf0;
import tb.jg0;
import tb.qj0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/wt2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes9.dex */
final class AbilityHubAdapter$asyncCall$1 implements Runnable {
    final /* synthetic */ String $api;
    final /* synthetic */ IOnCallbackListener $callback;
    final /* synthetic */ IAbilityContext $context;
    final /* synthetic */ String $name;
    final /* synthetic */ Map $params;
    final /* synthetic */ C9637r0 this$0;

    AbilityHubAdapter$asyncCall$1(C9637r0 c9637r0, String str, String str2, IAbilityContext iAbilityContext, Map map, IOnCallbackListener iOnCallbackListener) {
        this.this$0 = c9637r0;
        this.$name = str;
        this.$api = str2;
        this.$context = iAbilityContext;
        this.$params = map;
        this.$callback = iOnCallbackListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        jg0 a = this.this$0.a(this.$name, this.$api, this.$context, this.$params, this.$callback);
        if (a != null) {
            if (a instanceof hf0) {
                this.$callback.onErrorCallback((hf0) a);
            } else if (a instanceof qj0) {
                this.$callback.onCallback((qj0) a);
            }
        }
    }
}
