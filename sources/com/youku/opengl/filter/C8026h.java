package com.youku.opengl.filter;

import android.opengl.GLES20;

/* compiled from: Taobao */
/* renamed from: com.youku.opengl.filter.h */
/* loaded from: classes3.dex */
public class C8026h extends C8025g {
    @Override // com.youku.opengl.filter.C8021c, com.youku.opengl.filter.C8020b
    public void a() {
        super.a();
        r();
    }

    @Override // com.youku.opengl.filter.C8021c, com.youku.opengl.filter.C8020b
    public void a(int i, int i2) {
        super.a(i, i2);
        r();
    }

    public float p() {
        return 1.0f;
    }

    public float q() {
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        float q = q();
        C8020b c8020b = m().get(0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(c8020b.l(), "texelWidthOffset");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(c8020b.l(), "texelHeightOffset");
        c8020b.a(glGetUniformLocation, q / j());
        c8020b.a(glGetUniformLocation2, 0.0f);
        float p = p();
        C8020b c8020b2 = m().get(1);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(c8020b2.l(), "texelWidthOffset");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(c8020b2.l(), "texelHeightOffset");
        c8020b2.a(glGetUniformLocation3, 0.0f);
        c8020b2.a(glGetUniformLocation4, p / k());
    }
}
