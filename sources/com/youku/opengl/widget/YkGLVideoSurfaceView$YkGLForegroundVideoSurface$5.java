package com.youku.opengl.widget;

import com.youku.opengl.widget.l;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$5 implements Runnable {
    final /* synthetic */ l.a this$1;
    final /* synthetic */ int[] val$wh;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$5(l.a aVar, int[] iArr) {
        this.this$1 = aVar;
        this.val$wh = iArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVar;
        this.this$1.d.b(this.val$wh);
        hVar = this.this$1.e;
        hVar.e();
    }
}
