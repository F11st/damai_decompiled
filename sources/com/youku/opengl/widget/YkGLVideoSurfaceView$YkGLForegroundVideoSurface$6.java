package com.youku.opengl.widget;

import com.youku.opengl.widget.C8040l;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$6 implements Runnable {
    final /* synthetic */ C8040l.C8041a this$1;
    final /* synthetic */ float val$height;
    final /* synthetic */ float val$width;
    final /* synthetic */ float val$x;
    final /* synthetic */ float val$y;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$6(C8040l.C8041a c8041a, float f, float f2, float f3, float f4) {
        this.this$1 = c8041a;
        this.val$x = f;
        this.val$y = f2;
        this.val$width = f3;
        this.val$height = f4;
    }

    @Override // java.lang.Runnable
    public void run() {
        C8042m c8042m;
        c8042m = this.this$1.c;
        c8042m.a(this.val$x, this.val$y, this.val$width, this.val$height);
    }
}
