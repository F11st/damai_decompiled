package com.youku.opengl.widget;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$6 implements Runnable {
    final /* synthetic */ l this$0;
    final /* synthetic */ float val$alpha;
    final /* synthetic */ float val$blue;
    final /* synthetic */ float val$green;
    final /* synthetic */ float val$red;

    YkGLVideoSurfaceView$6(l lVar, float f, float f2, float f3, float f4) {
        this.this$0 = lVar;
        this.val$red = f;
        this.val$green = f2;
        this.val$blue = f3;
        this.val$alpha = f4;
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVar;
        hVar = this.this$0.d;
        hVar.a(this.val$red, this.val$green, this.val$blue, this.val$alpha);
    }
}
