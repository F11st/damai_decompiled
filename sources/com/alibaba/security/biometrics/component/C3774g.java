package com.alibaba.security.biometrics.component;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.logic.C3775a;
import com.alibaba.security.biometrics.logic.a.C3776a;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.d.C3812i;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.biometrics.component.g */
/* loaded from: classes8.dex */
public class C3774g extends AbstractC3768a {
    private final BroadcastReceiver d = new BroadcastReceiver() { // from class: com.alibaba.security.biometrics.component.g.1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            C3776a c3776a;
            if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction()) || (c3776a = ((C3775a) C3772e.a(C3775a.class)).d) == null) {
                return;
            }
            c3776a.h();
        }
    };

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        C3812i.a(activity).a(this.d, new IntentFilter("android.intent.action.SCREEN_OFF"));
        return super.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean c() {
        C3812i.a(this.c).a(this.d);
        return super.c();
    }
}
