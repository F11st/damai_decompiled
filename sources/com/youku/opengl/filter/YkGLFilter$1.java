package com.youku.opengl.filter;

import android.opengl.GLES20;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLFilter$1 implements Runnable {
    final /* synthetic */ C8020b this$0;
    final /* synthetic */ int val$intValue;
    final /* synthetic */ int val$location;

    YkGLFilter$1(C8020b c8020b, int i, int i2) {
        this.this$0 = c8020b;
        this.val$location = i;
        this.val$intValue = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.d();
        GLES20.glUniform1i(this.val$location, this.val$intValue);
    }
}
