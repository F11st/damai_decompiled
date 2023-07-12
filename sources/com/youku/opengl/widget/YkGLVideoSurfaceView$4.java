package com.youku.opengl.widget;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$4 implements Runnable {
    final /* synthetic */ l this$0;
    final /* synthetic */ int[] val$wh;

    YkGLVideoSurfaceView$4(l lVar, int[] iArr) {
        this.this$0 = lVar;
        this.val$wh = iArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        h hVar;
        nVar = this.this$0.b;
        nVar.b(this.val$wh);
        hVar = this.this$0.d;
        hVar.e();
    }
}
