package com.youku.opengl.filter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.youku.opengl.a.C8013a;
import java.nio.FloatBuffer;

/* compiled from: Taobao */
/* renamed from: com.youku.opengl.filter.a */
/* loaded from: classes3.dex */
public class C8019a extends C8020b {
    private int d;
    private final float[] e;

    public C8019a() {
        super(1, "uniform mat4 mvpMatrix;\n\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = mvpMatrix * position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}\n", "precision highp float;\n\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    vec4 maskRGBA = texture2D(inputImageTexture, vec2(textureCoordinate.x + 0.5, textureCoordinate.y));\n    float maskY = 0.299 * maskRGBA.r + 0.587 * maskRGBA.g + 0.114 * maskRGBA.b;\n\n    vec4 fragmentColor = texture2D(inputImageTexture, textureCoordinate);\n    fragmentColor.rgb = fragmentColor.rgb * maskY;\n    fragmentColor.a = maskY;\n\n    gl_FragColor = fragmentColor;\n}\n");
        this.e = new float[16];
    }

    @Override // com.youku.opengl.filter.C8020b
    public void a() {
        super.a();
        C8013a.a("YkGLAlphaMaskSbsVideoFilter", "onInit()");
        this.d = GLES20.glGetUniformLocation(l(), "mvpMatrix");
        float[] fArr = new float[16];
        float[] fArr2 = new float[16];
        Matrix.frustumM(fArr, 0, -1.0f, 0.0f, -1.0f, 1.0f, 3.0f, 7.0f);
        Matrix.setLookAtM(fArr2, 0, 0.0f, 0.0f, 3.0001f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        Matrix.multiplyMM(this.e, 0, fArr, 0, fArr2, 0);
    }

    @Override // com.youku.opengl.filter.C8020b
    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (i == -1) {
            C8013a.a("YkGLAlphaMaskSbsVideoFilter", "onDraw() - invalid texture, do nothing");
            return;
        }
        super.a(i, floatBuffer, floatBuffer2);
        GLES20.glDisableVertexAttribArray(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.opengl.filter.C8020b
    public void b() {
        super.b();
        GLES20.glUniformMatrix4fv(this.d, 1, false, this.e, 0);
    }
}
