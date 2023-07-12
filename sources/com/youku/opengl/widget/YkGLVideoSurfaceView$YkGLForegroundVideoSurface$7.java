package com.youku.opengl.widget;

import com.youku.opengl.widget.l;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$7 implements Runnable {
    final /* synthetic */ l.a this$1;
    final /* synthetic */ int val$renderType;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$7(l.a aVar, int i) {
        this.this$1 = aVar;
        this.val$renderType = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVar;
        hVar = this.this$1.e;
        hVar.a(this.val$renderType);
    }
}
