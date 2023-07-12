package com.youku.opengl.widget;

import android.view.TextureView;
import com.youku.opengl.widget.C8040l;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$2 implements Runnable {
    final /* synthetic */ C8040l.C8041a this$1;
    final /* synthetic */ TextureView.SurfaceTextureListener val$listener;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$2(C8040l.C8041a c8041a, TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.this$1 = c8041a;
        this.val$listener = surfaceTextureListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.d.a(this.val$listener);
    }
}
