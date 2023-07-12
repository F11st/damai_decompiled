package com.youku.opengl.widget;

import com.youku.opengl.widget.C8040l;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$5 implements Runnable {
    final /* synthetic */ C8040l.C8041a this$1;
    final /* synthetic */ int[] val$wh;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$5(C8040l.C8041a c8041a, int[] iArr) {
        this.this$1 = c8041a;
        this.val$wh = iArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        C8034h c8034h;
        this.this$1.d.b(this.val$wh);
        c8034h = this.this$1.e;
        c8034h.e();
    }
}
