package com.alibaba.security.biometrics.logic;

import android.app.Activity;
import android.view.KeyEvent;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.component.AbstractC3768a;
import com.alibaba.security.biometrics.component.InterfaceC3773f;
import com.alibaba.security.biometrics.logic.a.C3776a;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;

/* compiled from: Taobao */
@InterfaceC3773f
/* renamed from: com.alibaba.security.biometrics.logic.a */
/* loaded from: classes8.dex */
public class C3775a extends AbstractC3768a {
    public C3776a d;

    private void d() {
        ALBiometricsActivityParentView aLBiometricsActivityParentView;
        C3776a c3776a = this.d;
        if (c3776a == null || (aLBiometricsActivityParentView = c3776a.d) == null) {
            return;
        }
        aLBiometricsActivityParentView.e();
    }

    private void e() {
        C3776a c3776a = this.d;
        if (c3776a != null) {
            c3776a.h();
        }
    }

    private void f() {
        C3776a c3776a = this.d;
        if (c3776a != null) {
            c3776a.c = 0;
        }
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        this.b = aLBiometricsParams;
        C3776a c3776a = new C3776a(activity);
        this.d = c3776a;
        c3776a.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
        return false;
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean b() {
        C3776a c3776a = this.d;
        if (c3776a != null) {
            c3776a.b();
            return false;
        }
        return false;
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean c() {
        C3776a c3776a = this.d;
        if (c3776a != null) {
            c3776a.c();
            return false;
        }
        return false;
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final void a(ALBiometricsActivityParentView aLBiometricsActivityParentView) {
        C3776a c3776a = this.d;
        if (c3776a != null) {
            c3776a.a(aLBiometricsActivityParentView);
        }
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean a() {
        C3776a c3776a = this.d;
        if (c3776a != null) {
            c3776a.a();
            return false;
        }
        return false;
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean a(int i, KeyEvent keyEvent) {
        C3776a c3776a = this.d;
        if (c3776a != null) {
            c3776a.a(i, keyEvent);
            return true;
        }
        return true;
    }

    public final void a(int i, String str, String str2) {
        C3776a c3776a = this.d;
        if (c3776a != null) {
            c3776a.a(i, str, str2);
        }
    }

    private void a(int i, int[] iArr) {
        C3776a c3776a = this.d;
        if (c3776a == null || i != 1010) {
            return;
        }
        if ((iArr.length > 0 ? iArr[0] : -1) != 0) {
            C3776a.f();
        } else {
            c3776a.b(false);
        }
    }
}
