package com.alibaba.security.biometrics.camera;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import com.alibaba.security.common.e.InterfaceC3827b;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.biometrics.camera.c */
/* loaded from: classes8.dex */
public interface InterfaceC3764c {

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.camera.c$a */
    /* loaded from: classes8.dex */
    public interface InterfaceC3765a {
        void a();

        void a(int i, String str);

        void a(byte[] bArr, int i, int i2, int i3);
    }

    void a(SurfaceTexture surfaceTexture);

    void a(InterfaceC3765a interfaceC3765a);

    void a(InterfaceC3827b interfaceC3827b, boolean z);

    void d();

    String f();

    Point g();

    byte[] h();

    int i();

    boolean j();

    boolean k();

    void l();

    String m();

    String n();
}
