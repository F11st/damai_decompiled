package com.alibaba.security.biometrics.component;

import android.app.Activity;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;

/* compiled from: Taobao */
@f(a = 8)
/* loaded from: classes8.dex */
public class c extends a {
    protected com.alibaba.security.biometrics.c.a.b d;

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        super.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
        this.d = new com.alibaba.security.biometrics.c.a.c(activity);
        return false;
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean a() {
        if (this.d.a(this.b.supportX86)) {
            return false;
        }
        ((com.alibaba.security.biometrics.logic.a) e.a(com.alibaba.security.biometrics.logic.a.class)).a(this.d.a(), "EnvironmentComponent", null);
        return true;
    }
}
