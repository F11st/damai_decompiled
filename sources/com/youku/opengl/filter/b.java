package com.youku.opengl.filter;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class b {
    protected String a;
    protected int b;
    protected com.youku.opengl.widget.h c;
    private final Queue<Runnable> d;
    private final String e;
    private final String f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;

    public b() {
        this(1, "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public b(int i) {
        this(i, "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public b(int i, String str, String str2) {
        this.d = new LinkedList();
        String simpleName = getClass().getSimpleName();
        this.a = simpleName;
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a(simpleName, "constructor() - samplerType:" + i + "\nvertexShader:\n" + str + "\nfragmentShader:\n" + str2);
        }
        this.b = i;
        this.e = str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.b == 0 ? "#extension GL_OES_EGL_image_external : require\n\nuniform samplerExternalOES inputImageTexture;\n" : "uniform sampler2D inputImageTexture;\n");
        sb.append(str2);
        this.f = sb.toString();
    }

    private final void m() {
        a();
        c();
    }

    public void a() {
        com.youku.opengl.a.a.a(this.a, "onInit()");
        int a = com.youku.opengl.a.e.a(this.e, this.f);
        this.g = a;
        this.h = GLES20.glGetAttribLocation(a, "position");
        this.j = GLES20.glGetAttribLocation(this.g, "inputTextureCoordinate");
        this.i = GLES20.glGetUniformLocation(this.g, "inputImageTexture");
        this.m = true;
    }

    protected void a(int i) {
        if (i != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(g(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final int i, final float f) {
        a(new Runnable() { // from class: com.youku.opengl.filter.YkGLFilter$2
            @Override // java.lang.Runnable
            public void run() {
                b.this.d();
                GLES20.glUniform1f(i, f);
            }
        });
    }

    public void a(int i, int i2) {
        if (com.youku.opengl.a.a.b) {
            String str = this.a;
            com.youku.opengl.a.a.a(str, "onOutputSizeChanged() - width:" + i + " height:" + i2);
        }
        this.k = i;
        this.l = i2;
    }

    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (i == -1) {
            com.youku.opengl.a.a.a(this.a, "onDraw() - invalid texture, do nothing");
        } else if (!this.m) {
            com.youku.opengl.a.a.b(this.a, "onDraw() - not initialized, do nothing!!!");
        } else {
            if (com.youku.opengl.a.a.b) {
                String str = this.a;
                com.youku.opengl.a.a.a(str, "onDraw() - textureId:" + i + " cubeBuffer:" + floatBuffer + " textureBuffer:" + floatBuffer2);
            }
            h();
            a(i);
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.h, 2, 5126, false, 0, (Buffer) floatBuffer);
            GLES20.glEnableVertexAttribArray(this.h);
            floatBuffer2.position(0);
            GLES20.glVertexAttribPointer(this.j, 2, 5126, false, 0, (Buffer) floatBuffer2);
            GLES20.glEnableVertexAttribArray(this.j);
            GLES20.glUniform1i(this.i, 0);
            b();
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.h);
            GLES20.glDisableVertexAttribArray(this.j);
        }
    }

    public void a(com.youku.opengl.widget.h hVar) {
        this.c = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Runnable runnable) {
        synchronized (this.d) {
            this.d.add(runnable);
        }
    }

    public void a(float[] fArr) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        com.youku.opengl.a.a.a(this.a, "onPreGLDraw()");
    }

    public void c() {
    }

    public void d() {
        if (com.youku.opengl.a.a.b) {
            String str = this.a;
            com.youku.opengl.a.a.a(str, "initIfNeeded() - mIsInitialized:" + this.m);
        }
        if (this.m) {
            return;
        }
        m();
    }

    public final void e() {
        com.youku.opengl.a.a.a(this.a, "destroy()");
        this.m = false;
        this.c = null;
        GLES20.glDeleteProgram(this.g);
        f();
    }

    public void f() {
    }

    protected int g() {
        return this.b == 0 ? 36197 : 3553;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        synchronized (this.d) {
            while (!this.d.isEmpty()) {
                this.d.poll().run();
            }
        }
    }

    public boolean i() {
        return this.m;
    }

    public int j() {
        return this.k;
    }

    public int k() {
        return this.l;
    }

    public int l() {
        return this.g;
    }
}
