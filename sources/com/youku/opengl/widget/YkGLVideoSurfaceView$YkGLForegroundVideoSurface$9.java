package com.youku.opengl.widget;

import com.youku.opengl.widget.C8040l;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$9 implements Runnable {
    final /* synthetic */ C8040l.C8041a this$1;
    final /* synthetic */ int val$atBackgroundVideoPts;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$9(C8040l.C8041a c8041a, int i) {
        this.this$1 = c8041a;
        this.val$atBackgroundVideoPts = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        C8042m c8042m;
        c8042m = this.this$1.c;
        c8042m.b(this.val$atBackgroundVideoPts);
    }
}
