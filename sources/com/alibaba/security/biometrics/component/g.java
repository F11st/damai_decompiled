package com.alibaba.security.biometrics.component;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.d.i;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class g extends a {
    private final BroadcastReceiver d = new BroadcastReceiver() { // from class: com.alibaba.security.biometrics.component.g.1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            com.alibaba.security.biometrics.logic.a.a aVar;
            if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction()) || (aVar = ((com.alibaba.security.biometrics.logic.a) e.a(com.alibaba.security.biometrics.logic.a.class)).d) == null) {
                return;
            }
            aVar.h();
        }
    };

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        i.a(activity).a(this.d, new IntentFilter("android.intent.action.SCREEN_OFF"));
        return super.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean c() {
        i.a(this.c).a(this.d);
        return super.c();
    }
}
