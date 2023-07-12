package com.youku.opengl.widget;

import android.view.TextureView;
import com.youku.opengl.widget.l;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$2 implements Runnable {
    final /* synthetic */ l.a this$1;
    final /* synthetic */ TextureView.SurfaceTextureListener val$listener;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$2(l.a aVar, TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.this$1 = aVar;
        this.val$listener = surfaceTextureListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.d.a(this.val$listener);
    }
}
