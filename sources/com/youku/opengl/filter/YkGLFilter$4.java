package com.youku.opengl.filter;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLFilter$4 implements Runnable {
    final /* synthetic */ b this$0;
    final /* synthetic */ float[] val$arrayValue;
    final /* synthetic */ int val$location;

    YkGLFilter$4(b bVar, int i, float[] fArr) {
        this.this$0 = bVar;
        this.val$location = i;
        this.val$arrayValue = fArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.d();
        GLES20.glUniform3fv(this.val$location, 1, FloatBuffer.wrap(this.val$arrayValue));
    }
}
