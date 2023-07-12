package com.youku.opengl.widget;

import android.opengl.GLSurfaceView;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes13.dex */
public abstract class e implements GLSurfaceView.Renderer {
    protected GL10 c;
    protected EGLConfig d;
    private a e;
    private final LinkedList<Runnable> f = new LinkedList<>();
    private final LinkedList<Runnable> g = new LinkedList<>();
    protected boolean a = true;
    protected final int[] b = {0, 0};

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.e = aVar;
    }

    private void a(LinkedList<Runnable> linkedList) {
        LinkedList linkedList2;
        synchronized (linkedList) {
            linkedList2 = (LinkedList) linkedList.clone();
            linkedList.clear();
        }
        while (!linkedList2.isEmpty()) {
            ((Runnable) linkedList2.poll()).run();
        }
    }

    void a() {
        com.youku.opengl.a.a.a("YkGLAbstractRenderer", "requestRender()");
        this.e.requestRender();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Runnable runnable) {
        synchronized (this.f) {
            this.f.add(runnable);
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        this.a = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        a(this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Runnable runnable) {
        synchronized (this.g) {
            this.g.add(runnable);
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        a(this.g);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLAbstractRenderer", "onDrawFrame() - gl:" + gl10);
        }
        this.c = gl10;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLAbstractRenderer", "onSurfaceChanged() - gl:" + gl10 + " width:" + i + " height:" + i2);
        }
        this.c = gl10;
        int[] iArr = this.b;
        iArr[0] = i;
        iArr[1] = i2;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLAbstractRenderer", "onSurfaceCreated() - gl:" + gl10 + " config:" + eGLConfig);
        }
        this.c = gl10;
        this.d = eGLConfig;
    }
}
