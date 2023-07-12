package com.youku.opengl.widget;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.view.TextureView;
import com.ali.user.mobile.login.model.LoginConstant;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class n implements d {
    private a a;
    private SurfaceTexture c;
    private TextureView.SurfaceTextureListener d;
    private volatile int f;
    private volatile int g;
    private volatile long h;
    private volatile int i;
    private boolean j;
    private boolean k;
    private com.youku.media.b m;
    private com.youku.media.b n;
    private int o;
    private int p;
    private int b = -1;
    private final int[] e = {1280, LoginConstant.RESULT_WINDWANE_CLOSEW};
    private final int[] l = {0, 0};
    private String q = "YkGLVideoTextureHolder";

    public n(a aVar) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLVideoTextureHolder", "YkGLVideoTextureHolder() - renderScheduler:" + aVar);
        }
        this.a = aVar;
    }

    static /* synthetic */ int f(n nVar) {
        int i = nVar.f;
        nVar.f = i + 1;
        return i;
    }

    static /* synthetic */ int g(n nVar) {
        int i = nVar.g;
        nVar.g = i + 1;
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
        com.youku.opengl.a.a.b(this.q, "createSurfaceTexture()");
        this.b = com.youku.opengl.a.e.a(36197);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.b);
        this.c = surfaceTexture;
        int[] iArr = this.e;
        surfaceTexture.setDefaultBufferSize(iArr[0], iArr[1]);
        this.c.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.youku.opengl.widget.n.2
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                synchronized (n.this) {
                    n.this.j = true;
                    if (com.youku.opengl.a.a.b) {
                        com.youku.opengl.a.a.a(n.this.q, "onFrameAvailable() - updated");
                    }
                    com.youku.media.b bVar = n.this.m;
                    if (bVar != null) {
                        n.this.o = bVar.c();
                    }
                }
                if (com.youku.opengl.a.a.b) {
                    String str = n.this.q;
                    com.youku.opengl.a.a.a(str, "onFrameAvailable() - mVideoFramePts:" + n.this.o);
                }
                n.this.a.requestRender();
                n.f(n.this);
                n.g(n.this);
                if (n.this.h == 0) {
                    n.this.h = SystemClock.elapsedRealtime();
                }
                long elapsedRealtime = SystemClock.elapsedRealtime() - n.this.h;
                if (elapsedRealtime > 1000) {
                    n.this.h = SystemClock.elapsedRealtime();
                    n nVar = n.this;
                    nVar.i = (int) ((nVar.g * 1000) / elapsedRealtime);
                    n.this.g = 0;
                }
            }
        });
    }

    @Override // com.youku.opengl.widget.c
    public void a() {
        com.youku.opengl.a.a.b(this.q, "surfaceCreated()");
        if (this.c == null) {
            p();
            l();
        }
    }

    @Override // com.youku.opengl.widget.c
    public void a(int i, int i2) {
        String str = this.q;
        com.youku.opengl.a.a.b(str, "surfaceChanged() - width:" + i + " height:" + i2);
        int[] iArr = this.e;
        iArr[0] = i;
        iArr[1] = i2;
        m();
    }

    public void a(TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.d = surfaceTextureListener;
        l();
    }

    public void a(com.youku.media.b bVar) {
        this.m = bVar;
        if (bVar == null) {
            this.n = null;
            this.p = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        this.q = "YkGLVideoTextureHolder" + str;
    }

    @Override // com.youku.opengl.widget.d
    public void a(float[] fArr) {
        SurfaceTexture surfaceTexture = this.c;
        if (surfaceTexture != null) {
            float[] fArr2 = new float[16];
            surfaceTexture.getTransformMatrix(fArr2);
            Matrix.multiplyMM(fArr, 0, fArr2, 0, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f}, 0);
        }
    }

    @Override // com.youku.opengl.widget.d
    public void a(int[] iArr) {
        if (iArr == null || iArr.length != 2) {
            return;
        }
        int[] iArr2 = this.l;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
    }

    @Override // com.youku.opengl.widget.d
    public void b(int[] iArr) {
        if (com.youku.opengl.a.a.b) {
            String str = this.q;
            com.youku.opengl.a.a.a(str, "setImageSizeWh() - wh:" + Arrays.toString(iArr));
        }
        if (iArr == null || iArr.length != 2) {
            return;
        }
        int[] iArr2 = this.l;
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
    }

    @Override // com.youku.opengl.widget.d
    public synchronized boolean b() {
        if (com.youku.opengl.a.a.b) {
            String str = this.q;
            com.youku.opengl.a.a.a(str, "checkIfImageUpdated() - updated:" + this.j);
        }
        return this.j;
    }

    @Override // com.youku.opengl.widget.d
    public int c() {
        if (this.c == null) {
            p();
            l();
        }
        if (this.c != null) {
            synchronized (this) {
                this.p = this.o;
                this.j = false;
                if (com.youku.opengl.a.a.b) {
                    com.youku.opengl.a.a.a(this.q, "loadTexture() - clear updated");
                }
            }
            try {
                this.c.updateTexImage();
                if (com.youku.opengl.a.a.b) {
                    String str = this.q;
                    com.youku.opengl.a.a.a(str, "loadTexture() - updateTexImage, pts:" + this.p);
                }
                this.k = true;
                n();
            } catch (Exception e) {
                String str2 = this.q;
                com.youku.opengl.a.a.b(str2, "loadTexture() - caught exception:" + e);
                e.printStackTrace();
            }
        }
        return this.b;
    }

    @Override // com.youku.opengl.widget.d
    public boolean d() {
        return this.k;
    }

    @Override // com.youku.opengl.widget.d
    public void e() {
        this.k = false;
    }

    @Override // com.youku.opengl.widget.d
    public int f() {
        return this.b;
    }

    @Override // com.youku.opengl.widget.d
    public void g() {
        String str;
        String str2;
        if (this.b == -1 || this.c == null) {
            str = this.q;
            str2 = "updateDefaultTexBufferSize() - no texture";
        } else {
            GLES20.glActiveTexture(33984);
            com.youku.opengl.a.e.a("glActiveTexture");
            GLES20.glBindTexture(36197, this.b);
            com.youku.opengl.a.e.a("glBindTexture");
            int[] iArr = new int[2];
            GLES20.glGetIntegerv(3386, iArr, 0);
            if (com.youku.opengl.a.a.b) {
                String str3 = this.q;
                com.youku.opengl.a.a.a(str3, "updateDefaultTexBufferSize() - view port dims:" + Arrays.toString(iArr));
            }
            int[] iArr2 = new int[2];
            GLES20.glGetIntegerv(3379, iArr2, 0);
            if (iArr2[1] == 0) {
                iArr2[1] = iArr2[0];
            }
            if (com.youku.opengl.a.a.b) {
                String str4 = this.q;
                com.youku.opengl.a.a.a(str4, "updateDefaultTexBufferSize() - max texture size:" + Arrays.toString(iArr2));
            }
            int min = Math.min(iArr[0], iArr2[0]);
            int min2 = Math.min(iArr[1], iArr2[1]);
            if (com.youku.opengl.a.a.b) {
                String str5 = this.q;
                com.youku.opengl.a.a.a(str5, "updateDefaultTexBufferSize() - widthLimit:" + min + " heightLimit:" + min2);
            }
            if (min != 0 && min2 != 0) {
                int[] iArr3 = this.l;
                int i = iArr3[0];
                int i2 = iArr3[1];
                if (com.youku.opengl.a.a.b) {
                    String str6 = this.q;
                    com.youku.opengl.a.a.a(str6, "updateDefaultTexBufferSize() - width:" + i + " height:" + i2);
                }
                if (i == 0 || i > min || i2 == 0 || i2 > min2) {
                    return;
                }
                this.c.setDefaultBufferSize(i, i2);
                com.youku.opengl.a.e.a("setDefaultBufferSize");
                com.youku.opengl.a.a.a(this.q, "updateDefaultTexBufferSize() - done");
                return;
            }
            str = this.q;
            str2 = "updateDefaultTexBufferSize() - failed to get width limit and height limit";
        }
        com.youku.opengl.a.a.c(str, str2);
    }

    public com.youku.media.b h() {
        if (this.m != null && this.n == null) {
            this.n = new com.youku.media.b() { // from class: com.youku.opengl.widget.n.1
                @Override // com.youku.media.b
                public int c() {
                    return n.this.p;
                }
            };
        }
        return this.n;
    }

    public void i() {
        com.youku.opengl.a.a.b(this.q, "releaseSurfaceTexture()");
        if (this.c != null) {
            if (!o()) {
                this.c.release();
            }
            this.c = null;
            com.youku.opengl.a.a.b(this.q, "releaseSurfaceTexture() - released");
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
