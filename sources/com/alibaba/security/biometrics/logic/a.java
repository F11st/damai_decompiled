package com.alibaba.security.biometrics.logic;

import android.app.Activity;
import android.view.KeyEvent;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.component.f;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;

/* compiled from: Taobao */
@f
/* loaded from: classes8.dex */
public class a extends com.alibaba.security.biometrics.component.a {
    public com.alibaba.security.biometrics.logic.a.a d;

    private void d() {
        ALBiometricsActivityParentView aLBiometricsActivityParentView;
        com.alibaba.security.biometrics.logic.a.a aVar = this.d;
        if (aVar == null || (aLBiometricsActivityParentView = aVar.d) == null) {
            return;
        }
        aLBiometricsActivityParentView.e();
    }

    private void e() {
        com.alibaba.security.biometrics.logic.a.a aVar = this.d;
        if (aVar != null) {
            aVar.h();
        }
    }

    private void f() {
        com.alibaba.security.biometrics.logic.a.a aVar = this.d;
        if (aVar != null) {
            aVar.c = 0;
        }
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        this.b = aLBiometricsParams;
        com.alibaba.security.biometrics.logic.a.a aVar = new com.alibaba.security.biometrics.logic.a.a(activity);
        this.d = aVar;
        aVar.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
        return false;
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean b() {
        com.alibaba.security.biometrics.logic.a.a aVar = this.d;
        if (aVar != null) {
            aVar.b();
            return false;
        }
        return false;
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean c() {
        com.alibaba.security.biometrics.logic.a.a aVar = this.d;
        if (aVar != null) {
            aVar.c();
            return false;
        }
        return false;
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final void a(ALBiometricsActivityParentView aLBiometricsActivityParentView) {
        com.alibaba.security.biometrics.logic.a.a aVar = this.d;
        if (aVar != null) {
            aVar.a(aLBiometricsActivityParentView);
        }
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean a() {
        com.alibaba.security.biometrics.logic.a.a aVar = this.d;
        if (aVar != null) {
            aVar.a();
            return false;
        }
        return false;
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean a(int i, KeyEvent keyEvent) {
        com.alibaba.security.biometrics.logic.a.a aVar = this.d;
        if (aVar != null) {
            aVar.a(i, keyEvent);
            return true;
        }
        return true;
    }

    public final void a(int i, String str, String str2) {
        com.alibaba.security.biometrics.logic.a.a aVar = this.d;
        if (aVar != null) {
            aVar.a(i, str, str2);
        }
    }

    private void a(int i, int[] iArr) {
        com.alibaba.security.biometrics.logic.a.a aVar = this.d;
        if (aVar == null || i != 1010) {
            return;
        }
        if ((iArr.length > 0 ? iArr[0] : -1) != 0) {
            com.alibaba.security.biometrics.logic.a.a.f();
        } else {
            aVar.b(false);
        }
    }
}
