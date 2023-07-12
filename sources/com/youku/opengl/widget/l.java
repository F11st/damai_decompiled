package com.youku.opengl.widget;

import android.opengl.GLSurfaceView;
import android.view.TextureView;
import androidx.core.internal.view.SupportMenu;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class l extends GLSurfaceView implements com.youku.opengl.widget.a {
    private i a;
    private n b;
    private com.youku.opengl.filter.b c;
    private h d;
    private com.youku.media.b e;
    private a f;
    private k g;
    private final g h;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public class a {
        private com.youku.opengl.filter.b b;
        private m c;
        private n d;
        private h e;
        private k f;

        private a() {
            com.youku.opengl.filter.c cVar;
            com.youku.opengl.a.a.a("YkGLFgVideoSurface", "YkGLForegroundVideoSurface()");
            n nVar = new n(l.this);
            this.d = nVar;
            nVar.a("-front");
            m mVar = new m();
            this.c = mVar;
            mVar.a(l.this.h);
            if (com.youku.opengl.a.a.b) {
                cVar = a();
            } else {
                com.youku.opengl.filter.c cVar2 = new com.youku.opengl.filter.c();
                cVar2.a(new com.youku.opengl.filter.e());
                cVar2.a(this.c);
                cVar = cVar2;
            }
            this.b = cVar;
            h hVar = new h(l.this, this.d, this.b);
            this.e = hVar;
            hVar.a(1.0f, 1.0f, 1.0f, 0.0f);
            l.this.a.a(this.e);
        }

        private com.youku.opengl.filter.b a() {
            com.youku.opengl.filter.c cVar = new com.youku.opengl.filter.c();
            cVar.a(new com.youku.opengl.filter.e());
            k kVar = new k();
            this.f = kVar;
            kVar.c(SupportMenu.CATEGORY_MASK);
            this.f.b(30);
            this.f.a(0.0f, 0.3f);
            this.f.a(this.d);
            cVar.a(this.f);
            cVar.a(this.c);
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized a a(boolean z) {
        if (this.f == null && z) {
            this.f = new a();
        }
        return this.f;
    }

    private void a(Runnable runnable) {
        this.a.a(runnable);
    }

    private void b(Runnable runnable) {
        this.a.b(runnable);
    }

    private com.youku.opengl.filter.b getDebugSyncFilter() {
        com.youku.opengl.filter.c cVar = new com.youku.opengl.filter.c();
        cVar.a(new com.youku.opengl.filter.e());
        k kVar = new k();
        this.g = kVar;
        kVar.c(-1);
        this.g.b(30);
        this.g.a(0.0f, 0.4f);
        this.g.a(this.e);
        this.g.a(this.b);
        cVar.a(this.g);
        return cVar;
    }

    public int getDecodingFps() {
        return this.b.j();
    }

    public int getDrawFps() {
        return this.d.f();
    }

    public a getForegroundVideoSurface() {
        return a(true);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.youku.opengl.a.a.a("YkGLVideoSurfaceView", "onDetachedFromWindow()");
        this.b.i();
        this.c.e();
        a a2 = a(false);
        if (a2 != null) {
            a2.d.i();
            a2.b.e();
        }
    }

    public void setFilter(final com.youku.opengl.filter.b bVar) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLVideoSurfaceView", "setImageFilter() - filter:" + bVar);
        }
        a(new Runnable() { // from class: com.youku.opengl.widget.YkGLVideoSurfaceView$1
            @Override // java.lang.Runnable
            public void run() {
                h hVar;
                com.youku.opengl.filter.b bVar2;
                com.youku.opengl.filter.c cVar = new com.youku.opengl.filter.c();
                cVar.a(new com.youku.opengl.filter.e());
                cVar.a(bVar);
                l.this.c = cVar;
                hVar = l.this.d;
                bVar2 = l.this.c;
                hVar.a(bVar2);
            }
        });
        if (bVar instanceof com.youku.opengl.filter.a) {
            com.youku.opengl.a.a.a("YkGLVideoSurfaceView", "setFilter() - set z-order on top");
            setZOrderOnTop(true);
            getHolder().setFormat(-2);
        }
    }

    public void setRenderType(final int i) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLVideoSurfaceView", "setRenderType() - renderType:" + i);
        }
        a(new Runnable() { // from class: com.youku.opengl.widget.YkGLVideoSurfaceView$5
            @Override // java.lang.Runnable
            public void run() {
                h hVar;
                hVar = l.this.d;
                hVar.a(i);
            }
        });
    }

    public void setSurfaceTextureListener(final TextureView.SurfaceTextureListener surfaceTextureListener) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLVideoSurfaceView", "setSurfaceTextureListener() - listener:" + surfaceTextureListener);
        }
        a(new Runnable() { // from class: com.youku.opengl.widget.YkGLVideoSurfaceView$3
            @Override // java.lang.Runnable
            public void run() {
                n nVar;
                nVar = l.this.b;
                nVar.a(surfaceTextureListener);
            }
        });
    }

    public void setVideoPtsProvider(final com.youku.media.b bVar) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLVideoSurfaceView", "setVideoPtsProvider() - provider:" + bVar);
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
                    com.youku.opengl.widget.l r0 = com.youku.opengl.widget.l.this
                    com.youku.media.b r1 = r2
                    com.youku.opengl.widget.l.a(r0, r1)
                    com.youku.opengl.widget.l r0 = com.youku.opengl.widget.l.this
                    com.youku.opengl.widget.n r0 = com.youku.opengl.widget.l.c(r0)
                    com.youku.media.b r1 = r2
                    r0.a(r1)
                    com.youku.opengl.widget.l r0 = com.youku.opengl.widget.l.this
                    com.youku.opengl.widget.n r0 = com.youku.opengl.widget.l.c(r0)
                    com.youku.media.b r0 = r0.h()
                    com.youku.opengl.widget.l r1 = com.youku.opengl.widget.l.this
                    com.youku.opengl.widget.k r1 = com.youku.opengl.widget.l.d(r1)
                    if (r1 == 0) goto L2d
                    com.youku.opengl.widget.l r1 = com.youku.opengl.widget.l.this
                    com.youku.opengl.widget.k r1 = com.youku.opengl.widget.l.d(r1)
                    r1.a(r0)
                L2d:
                    com.youku.opengl.widget.l r1 = com.youku.opengl.widget.l.this
                    r2 = 0
                    com.youku.opengl.widget.l$a r1 = com.youku.opengl.widget.l.a(r1, r2)
                    if (r1 == 0) goto L3f
                    com.youku.opengl.widget.m r1 = com.youku.opengl.widget.l.a.a(r1)
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
