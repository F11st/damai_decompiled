package com.youku.opengl.filter;

import android.opengl.GLES20;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class h extends g {
    @Override // com.youku.opengl.filter.c, com.youku.opengl.filter.b
    public void a() {
        super.a();
        r();
    }

    @Override // com.youku.opengl.filter.c, com.youku.opengl.filter.b
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
        b bVar = m().get(0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(bVar.l(), "texelWidthOffset");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(bVar.l(), "texelHeightOffset");
        bVar.a(glGetUniformLocation, q / j());
        bVar.a(glGetUniformLocation2, 0.0f);
        float p = p();
        b bVar2 = m().get(1);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(bVar2.l(), "texelWidthOffset");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(bVar2.l(), "texelHeightOffset");
        bVar2.a(glGetUniformLocation3, 0.0f);
        bVar2.a(glGetUniformLocation4, p / k());
    }
}
