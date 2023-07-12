package com.youku.opengl.widget;

import com.youku.opengl.widget.l;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$8 implements Runnable {
    final /* synthetic */ l.a this$1;
    final /* synthetic */ float val$alpha;
    final /* synthetic */ float val$blue;
    final /* synthetic */ float val$green;
    final /* synthetic */ float val$red;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$8(l.a aVar, float f, float f2, float f3, float f4) {
        this.this$1 = aVar;
        this.val$red = f;
        this.val$green = f2;
        this.val$blue = f3;
        this.val$alpha = f4;
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVar;
        hVar = this.this$1.e;
        hVar.a(this.val$red, this.val$green, this.val$blue, this.val$alpha);
    }
}
