package com.youku.opengl.widget;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$4 implements Runnable {
    final /* synthetic */ C8040l this$0;
    final /* synthetic */ int[] val$wh;

    YkGLVideoSurfaceView$4(C8040l c8040l, int[] iArr) {
        this.this$0 = c8040l;
        this.val$wh = iArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        C8043n c8043n;
        C8034h c8034h;
        c8043n = this.this$0.b;
        c8043n.b(this.val$wh);
        c8034h = this.this$0.d;
        c8034h.e();
    }
}
