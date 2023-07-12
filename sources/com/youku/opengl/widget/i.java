package com.youku.opengl.widget;

import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class i extends e {
    private final ArrayList<e> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final e eVar) {
        a(new Runnable() { // from class: com.youku.opengl.widget.YkGLRendererGroup$1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList;
                eVar.a(false);
                arrayList = i.this.e;
                arrayList.add(eVar);
                if (com.youku.opengl.a.a.b) {
                    com.youku.opengl.a.a.a("YkGLRendererGroup", "addRenderer() - added renderer:" + eVar);
                }
                e eVar2 = eVar;
                i iVar = i.this;
                eVar2.onSurfaceCreated(iVar.c, iVar.d);
                e eVar3 = eVar;
                i iVar2 = i.this;
                GL10 gl10 = iVar2.c;
                int[] iArr = iVar2.b;
                eVar3.onSurfaceChanged(gl10, iArr[0], iArr[1]);
            }
        });
    }

    @Override // com.youku.opengl.widget.e, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        super.onDrawFrame(gl10);
        b();
        for (int i = 0; i < this.e.size(); i++) {
            if (com.youku.opengl.a.a.b) {
                com.youku.opengl.a.a.a("YkGLRendererGroup", "onDrawFrame() - calling " + i);
            }
            this.e.get(i).onDrawFrame(gl10);
            if (com.youku.opengl.a.a.b) {
                com.youku.opengl.a.a.a("YkGLRendererGroup", "onDrawFrame() - called " + i);
            }
        }
        c();
    }

    @Override // com.youku.opengl.widget.e, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        super.onSurfaceChanged(gl10, i, i2);
        for (int i3 = 0; i3 < this.e.size(); i3++) {
            if (com.youku.opengl.a.a.b) {
                com.youku.opengl.a.a.a("YkGLRendererGroup", "onSurfaceChanged() - calling " + i3);
            }
            this.e.get(i3).onSurfaceChanged(gl10, i, i2);
            if (com.youku.opengl.a.a.b) {
                com.youku.opengl.a.a.a("YkGLRendererGroup", "onSurfaceChanged() - called " + i3);
            }
        }
    }

    @Override // com.youku.opengl.widget.e, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        super.onSurfaceCreated(gl10, eGLConfig);
        for (int i = 0; i < this.e.size(); i++) {
            if (com.youku.opengl.a.a.b) {
                com.youku.opengl.a.a.a("YkGLRendererGroup", "onSurfaceCreated() - calling " + i);
            }
            this.e.get(i).onSurfaceCreated(gl10, eGLConfig);
            if (com.youku.opengl.a.a.b) {
                com.youku.opengl.a.a.a("YkGLRendererGroup", "onSurfaceCreated() - called " + i);
            }
        }
    }
}
