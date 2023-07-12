package com.youku.opengl.widget;

import com.youku.opengl.widget.C8040l;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$7 implements Runnable {
    final /* synthetic */ C8040l.C8041a this$1;
    final /* synthetic */ int val$renderType;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$7(C8040l.C8041a c8041a, int i) {
        this.this$1 = c8041a;
        this.val$renderType = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        C8034h c8034h;
        c8034h = this.this$1.e;
        c8034h.a(this.val$renderType);
    }
}
