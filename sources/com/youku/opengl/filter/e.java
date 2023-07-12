package com.youku.opengl.filter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.FloatBuffer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class e extends b {
    private float[] d;
    private int e;

    public e() {
        super(0, "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureMatrix * inputTextureCoordinate).xy;\n}", "varying highp vec2 textureCoordinate;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        float[] fArr = new float[16];
        this.d = fArr;
        this.e = -1;
        Matrix.setIdentityM(fArr, 0);
    }

    @Override // com.youku.opengl.filter.b
    public void a() {
        super.a();
        this.e = GLES20.glGetUniformLocation(l(), "textureMatrix");
    }

    @Override // com.youku.opengl.filter.b
    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (i == -1) {
            com.youku.opengl.a.a.a(this.a, "onDraw() - invalid texture, do nothing");
            return;
        }
        int i2 = this.e;
        if (i2 >= 0) {
            GLES20.glUniformMatrix4fv(i2, 1, false, this.d, 0);
        }
        super.a(i, floatBuffer, floatBuffer2);
    }

    @Override // com.youku.opengl.filter.b
    public void a(float[] fArr) {
        super.a(fArr);
        if (fArr == null || fArr.length != 16) {
            return;
        }
        System.arraycopy(fArr, 0, this.d, 0, 16);
    }
}
