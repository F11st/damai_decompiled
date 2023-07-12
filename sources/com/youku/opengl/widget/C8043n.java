package com.youku.opengl.widget;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.view.TextureView;
import com.ali.user.mobile.login.model.LoginConstant;
import com.youku.media.InterfaceC7968b;
import com.youku.opengl.a.C8013a;
import com.youku.opengl.a.C8018e;
import java.util.Arrays;

/* compiled from: Taobao */
/* renamed from: com.youku.opengl.widget.n */
/* loaded from: classes3.dex */
public class C8043n implements InterfaceC8030d {
    private InterfaceC8027a a;
    private SurfaceTexture c;
    private TextureView.SurfaceTextureListener d;
    private volatile int f;
    private volatile int g;
    private volatile long h;
    private volatile int i;
    private boolean j;
    private boolean k;
    private InterfaceC7968b m;
    private InterfaceC7968b n;
    private int o;
    private int p;
    private int b = -1;
    private final int[] e = {1280, LoginConstant.RESULT_WINDWANE_CLOSEW};
    private final int[] l = {0, 0};
    private String q = "YkGLVideoTextureHolder";

    public C8043n(InterfaceC8027a interfaceC8027a) {
        if (C8013a.b) {
            C8013a.a("YkGLVideoTextureHolder", "YkGLVideoTextureHolder() - renderScheduler:" + interfaceC8027a);
        }
        this.a = interfaceC8027a;
    }

    static /* synthetic */ int f(C8043n c8043n) {
        int i = c8043n.f;
        c8043n.f = i + 1;
        return i;
    }

    static /* synthetic */ int g(C8043n c8043n) {
        int i = c8043n.g;
        c8043n.g = i + 1;
        return i;
    }

    private void l() {
        SurfaceTexture surfaceTexture;
        TextureView.SurfaceTextureListener surfaceTextureListener = this.d;
        if (surfaceTextureListener == null || (surfaceTexture = this.c) == null) {
            return;
        }
        int[] iArr = this.e;
        surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, iArr[0], iArr[1]);
    }

    private void m() {
        SurfaceTexture surfaceTexture;
        TextureView.SurfaceTextureListener surfaceTextureListener = this.d;
        if (surfaceTextureListener == null || (surfaceTexture = this.c) == null) {
            return;
        }
        int[] iArr = this.e;
        surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, iArr[0], iArr[1]);
    }

    private void n() {
        SurfaceTexture surfaceTexture;
        TextureView.SurfaceTextureListener surfaceTextureListener = this.d;
        if (surfaceTextureListener == null || (surfaceTexture = this.c) == null) {
            return;
        }
        surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
    }

    private boolean o() {
        SurfaceTexture surfaceTexture;
        TextureView.SurfaceTextureListener surfaceTextureListener = this.d;
        if (surfaceTextureListener == null || (surfaceTexture = this.c) == null) {
            return false;
        }
        return surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
    }

    private void p() {
        C8013a.b(this.q, "createSurfaceTexture()");
        this.b = C8018e.a(36197);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.b);
        this.c = surfaceTexture;
        int[] iArr = this.e;
        surfaceTexture.setDefaultBufferSize(iArr[0], iArr[1]);
        this.c.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.youku.opengl.widget.n.2
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                synchronized (C8043n.this) {
                    C8043n.this.j = true;
                    if (C8013a.b) {
                        C8013a.a(C8043n.this.q, "onFrameAvailable() - updated");
                    }
                    InterfaceC7968b interfaceC7968b = C8043n.this.m;
                    if (interfaceC7968b != null) {
                        C8043n.this.o = interfaceC7968b.c();
                    }
                }
                if (C8013a.b) {
                    String str = C8043n.this.q;
                    C8013a.a(str, "onFrameAvailable() - mVideoFramePts:" + C8043n.this.o);
                }
                C8043n.this.a.requestRender();
                C8043n.f(C8043n.this);
                C8043n.g(C8043n.this);
                if (C8043n.this.h == 0) {
                    C8043n.this.h = SystemClock.elapsedRealtime();
                }
                long elapsedRealtime = SystemClock.elapsedRealtime() - C8043n.this.h;
                if (elapsedRealtime > 1000) {
                    C8043n.this.h = SystemClock.elapsedRealtime();
                    C8043n c8043n = C8043n.this;
                    c8043n.i = (int) ((c8043n.g * 1000) / elapsedRealtime);
                    C8043n.this.g = 0;
                }
            }
        });
    }

    @Override // com.youku.opengl.widget.InterfaceC8029c
    public void a() {
        C8013a.b(this.q, "surfaceCreated()");
        if (this.c == null) {
            p();
            l();
        }
    }

    @Override // com.youku.opengl.widget.InterfaceC8029c
    public void a(int i, int i2) {
        String str = this.q;
        C8013a.b(str, "surfaceChanged() - width:" + i + " height:" + i2);
        int[] iArr = this.e;
        iArr[0] = i;
        iArr[1] = i2;
        m();
    }

    public void a(TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.d = surfaceTextureListener;
        l();
    }

    public void a(InterfaceC7968b interfaceC7968b) {
        this.m = interfaceC7968b;
        if (interfaceC7968b == null) {
            this.n = null;
            this.p = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        this.q = "YkGLVideoTextureHolder" + str;
    }

    @Override // com.youku.opengl.widget.InterfaceC8030d
    public void a(float[] fArr) {
        SurfaceTexture surfaceTexture = this.c;
        if (surfaceTexture != null) {
            float[] fArr2 = new float[16];
            surfaceTexture.getTransformMatrix(fArr2);
            Matrix.multiplyMM(fArr, 0, fArr2, 0, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f}, 0);
        }
    }

    @Override // com.youku.opengl.widget.InterfaceC8030d
    public void a(int[] iArr) {
        if (iArr == null || iArr.length != 2) {
            return;
        }
        int[] iArr2 = this.l;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
    }

    @Override // com.youku.opengl.widget.InterfaceC8030d
    public void b(int[] iArr) {
        if (C8013a.b) {
            String str = this.q;
            C8013a.a(str, "setImageSizeWh() - wh:" + Arrays.toString(iArr));
        }
        if (iArr == null || iArr.length != 2) {
            return;
        }
        int[] iArr2 = this.l;
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
    }

    @Override // com.youku.opengl.widget.InterfaceC8030d
    public synchronized boolean b() {
        if (C8013a.b) {
            String str = this.q;
            C8013a.a(str, "checkIfImageUpdated() - updated:" + this.j);
        }
        return this.j;
    }

    @Override // com.youku.opengl.widget.InterfaceC8030d
    public int c() {
        if (this.c == null) {
            p();
            l();
        }
        if (this.c != null) {
            synchronized (this) {
                this.p = this.o;
                this.j = false;
                if (C8013a.b) {
                    C8013a.a(this.q, "loadTexture() - clear updated");
                }
            }
            try {
                this.c.updateTexImage();
                if (C8013a.b) {
                    String str = this.q;
                    C8013a.a(str, "loadTexture() - updateTexImage, pts:" + this.p);
                }
                this.k = true;
                n();
            } catch (Exception e) {
                String str2 = this.q;
                C8013a.b(str2, "loadTexture() - caught exception:" + e);
                e.printStackTrace();
            }
        }
        return this.b;
    }

    @Override // com.youku.opengl.widget.InterfaceC8030d
    public boolean d() {
        return this.k;
    }

    @Override // com.youku.opengl.widget.InterfaceC8030d
    public void e() {
        this.k = false;
    }

    @Override // com.youku.opengl.widget.InterfaceC8030d
    public int f() {
        return this.b;
    }

    @Override // com.youku.opengl.widget.InterfaceC8030d
    public void g() {
        String str;
        String str2;
        if (this.b == -1 || this.c == null) {
            str = this.q;
            str2 = "updateDefaultTexBufferSize() - no texture";
        } else {
            GLES20.glActiveTexture(33984);
            C8018e.a("glActiveTexture");
            GLES20.glBindTexture(36197, this.b);
            C8018e.a("glBindTexture");
            int[] iArr = new int[2];
            GLES20.glGetIntegerv(3386, iArr, 0);
            if (C8013a.b) {
                String str3 = this.q;
                C8013a.a(str3, "updateDefaultTexBufferSize() - view port dims:" + Arrays.toString(iArr));
            }
            int[] iArr2 = new int[2];
            GLES20.glGetIntegerv(3379, iArr2, 0);
            if (iArr2[1] == 0) {
                iArr2[1] = iArr2[0];
            }
            if (C8013a.b) {
                String str4 = this.q;
                C8013a.a(str4, "updateDefaultTexBufferSize() - max texture size:" + Arrays.toString(iArr2));
            }
            int min = Math.min(iArr[0], iArr2[0]);
            int min2 = Math.min(iArr[1], iArr2[1]);
            if (C8013a.b) {
                String str5 = this.q;
                C8013a.a(str5, "updateDefaultTexBufferSize() - widthLimit:" + min + " heightLimit:" + min2);
            }
            if (min != 0 && min2 != 0) {
                int[] iArr3 = this.l;
                int i = iArr3[0];
                int i2 = iArr3[1];
                if (C8013a.b) {
                    String str6 = this.q;
                    C8013a.a(str6, "updateDefaultTexBufferSize() - width:" + i + " height:" + i2);
                }
                if (i == 0 || i > min || i2 == 0 || i2 > min2) {
                    return;
                }
                this.c.setDefaultBufferSize(i, i2);
                C8018e.a("setDefaultBufferSize");
                C8013a.a(this.q, "updateDefaultTexBufferSize() - done");
                return;
            }
            str = this.q;
            str2 = "updateDefaultTexBufferSize() - failed to get width limit and height limit";
        }
        C8013a.c(str, str2);
    }

    public InterfaceC7968b h() {
        if (this.m != null && this.n == null) {
            this.n = new InterfaceC7968b() { // from class: com.youku.opengl.widget.n.1
                @Override // com.youku.media.InterfaceC7968b
                public int c() {
                    return C8043n.this.p;
                }
            };
        }
        return this.n;
    }

    public void i() {
        C8013a.b(this.q, "releaseSurfaceTexture()");
        if (this.c != null) {
            if (!o()) {
                this.c.release();
            }
            this.c = null;
            C8013a.b(this.q, "releaseSurfaceTexture() - released");
        }
    }

    public int j() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f;
    }
}
