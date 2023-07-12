package com.youku.opengl.filter;

import android.graphics.PointF;
import android.opengl.GLES20;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLFilter$7 implements Runnable {
    final /* synthetic */ C8020b this$0;
    final /* synthetic */ int val$location;
    final /* synthetic */ PointF val$point;

    YkGLFilter$7(C8020b c8020b, PointF pointF, int i) {
        this.this$0 = c8020b;
        this.val$point = pointF;
        this.val$location = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.d();
        PointF pointF = this.val$point;
        GLES20.glUniform2fv(this.val$location, 1, new float[]{pointF.x, pointF.y}, 0);
    }
}
