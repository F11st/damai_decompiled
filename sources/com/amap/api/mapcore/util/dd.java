package com.amap.api.mapcore.util;

import android.opengl.GLES20;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class dd {
    private boolean a;
    public int d;
    public int e;
    public int f;

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(String str, String str2) {
        int b = b(str, str2);
        this.d = b;
        return b != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(String str) {
        return GLES20.glGetAttribLocation(this.d, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(String str) {
        return GLES20.glGetUniformLocation(this.d, str);
    }

    public int d(String str) {
        String str2 = "amap_sdk_shaders/" + str;
        String a = dr.a(str2);
        if (a != null) {
            int indexOf = a.indexOf(36);
            if (indexOf >= 0 && a.charAt(indexOf + 1) == '$') {
                return b(a.substring(0, indexOf), a.substring(indexOf + 2));
            }
            throw new IllegalArgumentException("not a shader file " + str2);
        }
        throw new IllegalArgumentException("shader file not found: " + str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(String str) {
        int d = d(str);
        this.d = d;
        return d != 0;
    }

    public int b(String str, String str2) {
        this.e = a(35633, str);
        this.f = a(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, this.e);
        GLES20.glAttachShader(glCreateProgram, this.f);
        GLES20.glLinkProgram(glCreateProgram);
        return glCreateProgram;
    }

    public boolean c() {
        return this.a;
    }

    public void a() {
        GLES20.glUseProgram(this.d);
    }

    public int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    public void b() {
        int i = this.d;
        if (i >= 0) {
            GLES20.glDeleteProgram(i);
        }
        int i2 = this.e;
        if (i2 >= 0) {
            GLES20.glDeleteShader(i2);
        }
        int i3 = this.f;
        if (i3 >= 0) {
            GLES20.glDeleteShader(i3);
        }
        this.a = true;
    }
}
