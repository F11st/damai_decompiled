package com.youku.opengl.widget;

import com.youku.opengl.a.C8013a;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.youku.opengl.widget.i */
/* loaded from: classes3.dex */
public class C8035i extends AbstractC8031e {
    private final ArrayList<AbstractC8031e> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final AbstractC8031e abstractC8031e) {
        a(new Runnable() { // from class: com.youku.opengl.widget.YkGLRendererGroup$1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList;
                abstractC8031e.a(false);
                arrayList = C8035i.this.e;
                arrayList.add(abstractC8031e);
                if (C8013a.b) {
                    C8013a.a("YkGLRendererGroup", "addRenderer() - added renderer:" + abstractC8031e);
                }
                AbstractC8031e abstractC8031e2 = abstractC8031e;
                C8035i c8035i = C8035i.this;
                abstractC8031e2.onSurfaceCreated(c8035i.c, c8035i.d);
                AbstractC8031e abstractC8031e3 = abstractC8031e;
                C8035i c8035i2 = C8035i.this;
                GL10 gl10 = c8035i2.c;
                int[] iArr = c8035i2.b;
                abstractC8031e3.onSurfaceChanged(gl10, iArr[0], iArr[1]);
            }
        });
    }

    @Override // com.youku.opengl.widget.AbstractC8031e, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        super.onDrawFrame(gl10);
        b();
        for (int i = 0; i < this.e.size(); i++) {
            if (C8013a.b) {
                C8013a.a("YkGLRendererGroup", "onDrawFrame() - calling " + i);
            }
            this.e.get(i).onDrawFrame(gl10);
            if (C8013a.b) {
                C8013a.a("YkGLRendererGroup", "onDrawFrame() - called " + i);
            }
        }
        c();
    }

    @Override // com.youku.opengl.widget.AbstractC8031e, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        super.onSurfaceChanged(gl10, i, i2);
        for (int i3 = 0; i3 < this.e.size(); i3++) {
            if (C8013a.b) {
                C8013a.a("YkGLRendererGroup", "onSurfaceChanged() - calling " + i3);
            }
            this.e.get(i3).onSurfaceChanged(gl10, i, i2);
            if (C8013a.b) {
                C8013a.a("YkGLRendererGroup", "onSurfaceChanged() - called " + i3);
            }
        }
    }

    @Override // com.youku.opengl.widget.AbstractC8031e, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        super.onSurfaceCreated(gl10, eGLConfig);
        for (int i = 0; i < this.e.size(); i++) {
            if (C8013a.b) {
                C8013a.a("YkGLRendererGroup", "onSurfaceCreated() - calling " + i);
            }
            this.e.get(i).onSurfaceCreated(gl10, eGLConfig);
            if (C8013a.b) {
                C8013a.a("YkGLRendererGroup", "onSurfaceCreated() - called " + i);
            }
        }
    }
}
