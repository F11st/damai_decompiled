package com.youku.opengl.widget;

import android.opengl.GLSurfaceView;
import android.view.TextureView;
import androidx.core.internal.view.SupportMenu;
import com.youku.media.InterfaceC7968b;
import com.youku.opengl.a.C8013a;
import com.youku.opengl.filter.C8019a;
import com.youku.opengl.filter.C8020b;
import com.youku.opengl.filter.C8021c;
import com.youku.opengl.filter.C8023e;

/* compiled from: Taobao */
/* renamed from: com.youku.opengl.widget.l */
/* loaded from: classes3.dex */
public class C8040l extends GLSurfaceView implements InterfaceC8027a {
    private C8035i a;
    private C8043n b;
    private C8020b c;
    private C8034h d;
    private InterfaceC7968b e;
    private C8041a f;
    private C8039k g;
    private final C8033g h;

    /* compiled from: Taobao */
    /* renamed from: com.youku.opengl.widget.l$a */
    /* loaded from: classes13.dex */
    public class C8041a {
        private C8020b b;
        private C8042m c;
        private C8043n d;
        private C8034h e;
        private C8039k f;

        private C8041a() {
            C8021c c8021c;
            C8013a.a("YkGLFgVideoSurface", "YkGLForegroundVideoSurface()");
            C8043n c8043n = new C8043n(C8040l.this);
            this.d = c8043n;
            c8043n.a("-front");
            C8042m c8042m = new C8042m();
            this.c = c8042m;
            c8042m.a(C8040l.this.h);
            if (C8013a.b) {
                c8021c = a();
            } else {
                C8021c c8021c2 = new C8021c();
                c8021c2.a(new C8023e());
                c8021c2.a(this.c);
                c8021c = c8021c2;
            }
            this.b = c8021c;
            C8034h c8034h = new C8034h(C8040l.this, this.d, this.b);
            this.e = c8034h;
            c8034h.a(1.0f, 1.0f, 1.0f, 0.0f);
            C8040l.this.a.a(this.e);
        }

        private C8020b a() {
            C8021c c8021c = new C8021c();
            c8021c.a(new C8023e());
            C8039k c8039k = new C8039k();
            this.f = c8039k;
            c8039k.c(SupportMenu.CATEGORY_MASK);
            this.f.b(30);
            this.f.a(0.0f, 0.3f);
            this.f.a(this.d);
            c8021c.a(this.f);
            c8021c.a(this.c);
            return c8021c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized C8041a a(boolean z) {
        if (this.f == null && z) {
            this.f = new C8041a();
        }
        return this.f;
    }

    private void a(Runnable runnable) {
        this.a.a(runnable);
    }

    private void b(Runnable runnable) {
        this.a.b(runnable);
    }

    private C8020b getDebugSyncFilter() {
        C8021c c8021c = new C8021c();
        c8021c.a(new C8023e());
        C8039k c8039k = new C8039k();
        this.g = c8039k;
        c8039k.c(-1);
        this.g.b(30);
        this.g.a(0.0f, 0.4f);
        this.g.a(this.e);
        this.g.a(this.b);
        c8021c.a(this.g);
        return c8021c;
    }

    public int getDecodingFps() {
        return this.b.j();
    }

    public int getDrawFps() {
        return this.d.f();
    }

    public C8041a getForegroundVideoSurface() {
        return a(true);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C8013a.a("YkGLVideoSurfaceView", "onDetachedFromWindow()");
        this.b.i();
        this.c.e();
        C8041a a = a(false);
        if (a != null) {
            a.d.i();
            a.b.e();
        }
    }

    public void setFilter(final C8020b c8020b) {
        if (C8013a.b) {
            C8013a.a("YkGLVideoSurfaceView", "setImageFilter() - filter:" + c8020b);
        }
        a(new Runnable() { // from class: com.youku.opengl.widget.YkGLVideoSurfaceView$1
            @Override // java.lang.Runnable
            public void run() {
                C8034h c8034h;
                C8020b c8020b2;
                C8021c c8021c = new C8021c();
                c8021c.a(new C8023e());
                c8021c.a(c8020b);
                C8040l.this.c = c8021c;
                c8034h = C8040l.this.d;
                c8020b2 = C8040l.this.c;
                c8034h.a(c8020b2);
            }
        });
        if (c8020b instanceof C8019a) {
            C8013a.a("YkGLVideoSurfaceView", "setFilter() - set z-order on top");
            setZOrderOnTop(true);
            getHolder().setFormat(-2);
        }
    }

    public void setRenderType(final int i) {
        if (C8013a.b) {
            C8013a.a("YkGLVideoSurfaceView", "setRenderType() - renderType:" + i);
        }
        a(new Runnable() { // from class: com.youku.opengl.widget.YkGLVideoSurfaceView$5
            @Override // java.lang.Runnable
            public void run() {
                C8034h c8034h;
                c8034h = C8040l.this.d;
                c8034h.a(i);
            }
        });
    }

    public void setSurfaceTextureListener(final TextureView.SurfaceTextureListener surfaceTextureListener) {
        if (C8013a.b) {
            C8013a.a("YkGLVideoSurfaceView", "setSurfaceTextureListener() - listener:" + surfaceTextureListener);
        }
        a(new Runnable() { // from class: com.youku.opengl.widget.YkGLVideoSurfaceView$3
            @Override // java.lang.Runnable
            public void run() {
                C8043n c8043n;
                c8043n = C8040l.this.b;
                c8043n.a(surfaceTextureListener);
            }
        });
    }

    public void setVideoPtsProvider(final InterfaceC7968b interfaceC7968b) {
        if (C8013a.b) {
            C8013a.a("YkGLVideoSurfaceView", "setVideoPtsProvider() - provider:" + interfaceC7968b);
        }
        b(new Runnable() { // from class: com.youku.opengl.widget.YkGLVideoSurfaceView$2
            /* JADX WARN: Code restructure failed: missing block: B:7:0x0036, code lost:
                r1 = r1.c;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r3 = this;
                    com.youku.opengl.widget.l r0 = com.youku.opengl.widget.C8040l.this
                    com.youku.media.b r1 = r2
                    com.youku.opengl.widget.C8040l.a(r0, r1)
                    com.youku.opengl.widget.l r0 = com.youku.opengl.widget.C8040l.this
                    com.youku.opengl.widget.n r0 = com.youku.opengl.widget.C8040l.c(r0)
                    com.youku.media.b r1 = r2
                    r0.a(r1)
                    com.youku.opengl.widget.l r0 = com.youku.opengl.widget.C8040l.this
                    com.youku.opengl.widget.n r0 = com.youku.opengl.widget.C8040l.c(r0)
                    com.youku.media.b r0 = r0.h()
                    com.youku.opengl.widget.l r1 = com.youku.opengl.widget.C8040l.this
                    com.youku.opengl.widget.k r1 = com.youku.opengl.widget.C8040l.d(r1)
                    if (r1 == 0) goto L2d
                    com.youku.opengl.widget.l r1 = com.youku.opengl.widget.C8040l.this
                    com.youku.opengl.widget.k r1 = com.youku.opengl.widget.C8040l.d(r1)
                    r1.a(r0)
                L2d:
                    com.youku.opengl.widget.l r1 = com.youku.opengl.widget.C8040l.this
                    r2 = 0
                    com.youku.opengl.widget.l$a r1 = com.youku.opengl.widget.C8040l.a(r1, r2)
                    if (r1 == 0) goto L3f
                    com.youku.opengl.widget.m r1 = com.youku.opengl.widget.C8040l.C8041a.a(r1)
                    if (r1 == 0) goto L3f
                    r1.b(r0)
                L3f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.youku.opengl.widget.YkGLVideoSurfaceView$2.run():void");
            }
        });
    }
}
