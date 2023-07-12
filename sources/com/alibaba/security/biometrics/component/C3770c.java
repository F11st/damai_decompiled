package com.alibaba.security.biometrics.component;

import android.app.Activity;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.c.a.C3748c;
import com.alibaba.security.biometrics.c.a.InterfaceC3747b;
import com.alibaba.security.biometrics.logic.C3775a;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;

/* compiled from: Taobao */
@InterfaceC3773f(a = 8)
/* renamed from: com.alibaba.security.biometrics.component.c */
/* loaded from: classes8.dex */
public class C3770c extends AbstractC3768a {
    protected InterfaceC3747b d;

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        super.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
        this.d = new C3748c(activity);
        return false;
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean a() {
        if (this.d.a(this.b.supportX86)) {
            return false;
        }
        ((C3775a) C3772e.a(C3775a.class)).a(this.d.a(), "EnvironmentComponent", null);
        return true;
    }
}
