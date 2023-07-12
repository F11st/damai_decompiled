package com.youku.opengl.widget;

import android.opengl.GLES20;
import android.os.SystemClock;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.uc.crashsdk.export.LogType;
import com.youku.media.InterfaceC7967a;
import com.youku.media.InterfaceC7968b;
import com.youku.opengl.a.C8013a;
import com.youku.opengl.a.C8018e;
import com.youku.opengl.filter.C8020b;
import com.youku.opengl.widget.C8036j;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Locale;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.youku.opengl.widget.m */
/* loaded from: classes3.dex */
public class C8042m extends C8020b implements C8036j.InterfaceC8037a {
    private static final float[] d = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] e = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private long A;
    private FloatBuffer f;
    private final FloatBuffer g;
    private InterfaceC7967a h;
    private InterfaceC7968b i;
    private InterfaceC7968b j;
    private int k;
    private final int l;
    private final C8036j m;
    private long n;
    private volatile int o;
    private volatile long p;
    private volatile int q;
    private boolean r;
    private boolean s;
    private C8033g t;
    private InterfaceC8030d u;
    private boolean v;
    private final C8020b w;
    private float[] x;
    private long y;
    private long z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8042m() {
        super(1);
        this.k = -1;
        this.l = 5;
        C8036j c8036j = new C8036j(5);
        this.m = c8036j;
        this.n = -1L;
        this.v = false;
        this.w = new C8020b();
        float[] fArr = d;
        this.x = fArr;
        this.y = -1L;
        this.z = -1L;
        this.A = -1L;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f = asFloatBuffer;
        asFloatBuffer.put(this.x).position(0);
        float[] fArr2 = e;
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.g = asFloatBuffer2;
        asFloatBuffer2.put(fArr2).position(0);
        c8036j.a(this);
    }

    private void a(int i, long j, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glBindFramebuffer(36160, this.m.c());
        int j2 = j();
        int k = k();
        C8036j.C8038b e2 = this.m.e();
        int i2 = e2.a;
        GLES20.glBindTexture(3553, i2);
        GLES20.glTexImage2D(3553, 0, 6408, j(), k(), 0, 6408, 5121, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        GLES20.glViewport(0, 0, j2, k);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(LogType.UNEXP_RESTART);
        GLES20.glUseProgram(this.w.l());
        this.w.a(i, floatBuffer, floatBuffer2);
        e2.b = j;
        if (C8013a.b) {
            C8013a.a("YkGLVideoSyncFilter", "getNearestFrame cacheTexture() - onAddVideoFrame " + j);
        }
        this.m.a(e2);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private void a(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.y;
        if (j3 >= 0) {
            C8013a.a("YkGLVideoSyncFilter", String.format(Locale.getDefault(), "getNearestFrame System:[%d] Master:[%d] Sync:[%d]", Long.valueOf(currentTimeMillis - j3), Long.valueOf(j - this.A), Long.valueOf(j2 - this.z)));
        }
        this.y = currentTimeMillis;
        this.A = j;
        this.z = j2;
    }

    private boolean b(long j) {
        if (this.h == null) {
            return true;
        }
        if (j < 0) {
            j = 0;
        }
        C8036j.C8038b f = this.m.f();
        if (f == null || j - f.b <= 120 || this.m.d() > 0) {
            return false;
        }
        this.h.a();
        this.v = true;
        return false;
    }

    private void m() {
        this.t.a(new C8032f("foreground_rendering_started"));
    }

    private void n() {
        this.t.a(new C8032f("foreground_rendering_stopped"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f, float f2, float f3, float f4) {
        this.x = C8018e.a(f, f2, f3, f4);
        if (C8013a.b) {
            C8013a.a("YkGLVideoSyncFilter", "setRenderArea() - new cube:" + C8018e.a("cube:", this.x, 2));
        }
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(this.x.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f = asFloatBuffer;
        asFloatBuffer.put(this.x).position(0);
    }

    @Override // com.youku.opengl.filter.C8020b
    public void a(int i, int i2) {
        super.a(i, i2);
        this.w.a(i, i2);
    }

    @Override // com.youku.opengl.filter.C8020b
    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        InterfaceC7968b interfaceC7968b;
        long j;
        if (this.h == null || (interfaceC7968b = this.j) == null || this.v) {
            return;
        }
        long c = interfaceC7968b.c();
        int i2 = this.k;
        long j2 = c - i2;
        if (j2 >= 0 && i2 > 0) {
            C8036j.C8038b a = this.m.a(j2);
            boolean z = false;
            if (a != null) {
                j = Math.abs(a.b - j2);
                if (C8013a.b && j >= 0) {
                    C8013a.a("YkGLVideoSyncFilter", "getNearestFrame mVideoReferencePts:[" + j2 + "] textureFrame.pts:[" + a.b + "] textureFrame.id:[" + a.a + "] queue:[" + this.m.d() + "] diff:[" + (a.b - j2) + jn1.ARRAY_END_STR);
                    a(c, a.b);
                }
                GLES20.glBlendEquationSeparate(32774, 32774);
                GLES20.glBlendFuncSeparate(1, 771, 1, 771);
                GLES20.glEnable(3042);
                GLES20.glDisable(2929);
                GLES20.glDisable(2884);
                super.a(a.a, floatBuffer, floatBuffer2);
                GLES20.glDisable(3042);
                if (!this.r) {
                    this.r = true;
                    m();
                }
                if (this.p == 0) {
                    this.p = SystemClock.elapsedRealtime();
                }
                this.o++;
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.p;
                if (elapsedRealtime > 1000) {
                    this.p = SystemClock.elapsedRealtime();
                    this.q = (int) ((this.o * 1000) / elapsedRealtime);
                    this.o = 0;
                }
            } else {
                if (C8013a.b) {
                    C8013a.a("YkGLVideoSyncFilter", "no cached frame, mVideoReferencePts:[" + j2 + "] ");
                }
                j = 0;
            }
            b(j2);
            if (!this.s) {
                if (a == null || (this.m.d() == 0 && j >= 80)) {
                    z = true;
                }
                C8013a.a("YkGLVideoSyncFilter", "onDraw() - videoFrame:" + a + " queue size:" + this.m.d() + " absDiff:" + j);
                if (z) {
                    this.s = true;
                    n();
                }
            }
        }
        InterfaceC8030d interfaceC8030d = this.u;
        if (interfaceC8030d == null || !interfaceC8030d.d()) {
            return;
        }
        long c2 = this.i.c();
        if (this.n != c2 && c2 >= 0) {
            a(i, c2, this.f, this.g);
            this.h.a(c2);
            this.n = c2;
        } else if (C8013a.b) {
            StringBuilder sb = new StringBuilder();
            sb.append("onDraw() - decoding pts equals last:");
            sb.append(c2 == this.n ? BQCCameraParam.VALUE_YES : "no");
            sb.append(" current decoding pts:");
            sb.append(c2);
            sb.append(" last decoding pts:");
            sb.append(this.n);
            C8013a.a("YkGLVideoSyncFilter", sb.toString());
        }
    }

    @Override // com.youku.opengl.widget.C8036j.InterfaceC8037a
    public void a(long j) {
        InterfaceC7967a interfaceC7967a = this.h;
        if (interfaceC7967a != null) {
            interfaceC7967a.b();
            C8013a.a("YkGLVideoSyncFilter", "onFrameDequeue() - notified");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(InterfaceC7967a interfaceC7967a) {
        if (C8013a.b) {
            C8013a.a("YkGLVideoSyncFilter", "setVideoPlayer() - videoPlayer:" + interfaceC7967a);
        }
        this.h = interfaceC7967a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(InterfaceC7968b interfaceC7968b) {
        if (C8013a.b) {
            C8013a.a("YkGLVideoSyncFilter", "setTexturePtsProvider() - ptsProvider:" + interfaceC7968b);
        }
        this.i = interfaceC7968b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C8033g c8033g) {
        this.t = c8033g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        if (C8013a.b) {
            C8013a.a("YkGLVideoSyncFilter", "startRenderAt() - atPrimaryVideoPts:" + i);
        }
        this.k = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(InterfaceC7968b interfaceC7968b) {
        if (C8013a.b) {
            C8013a.a("YkGLVideoSyncFilter", "setPrimaryVideoPtsProvider() - provider:" + interfaceC7968b);
        }
        this.j = interfaceC7968b;
    }

    @Override // com.youku.opengl.filter.C8020b
    public void c() {
        super.c();
        C8034h c8034h = this.c;
        if (c8034h != null) {
            this.u = c8034h.d();
        }
        this.w.d();
        this.m.a();
    }

    @Override // com.youku.opengl.filter.C8020b
    public void f() {
        super.f();
        this.u = null;
        this.w.e();
        this.m.b();
    }
}
