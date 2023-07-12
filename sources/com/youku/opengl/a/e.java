package com.youku.opengl.a;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build;
import com.youku.alixplayer.MsgID;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class e {
    public static int a(int i) {
        if (a.b) {
            a.a("YkGLUtils", "makeTextureId() - textureTarget:" + i);
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        a("glGenTextures");
        int i2 = iArr[0];
        if (a.b) {
            a.a("YkGLUtils", "makeTextureId() - texture name:" + i2);
        }
        GLES20.glBindTexture(i, i2);
        a("glBindTexture");
        GLES20.glTexParameterf(i, 10241, 9729.0f);
        GLES20.glTexParameterf(i, MsgID.MEDIA_INFO_VIDEO_START_RECOVER, 9729.0f);
        GLES20.glTexParameteri(i, 10242, 33071);
        GLES20.glTexParameteri(i, 10243, 33071);
        return i2;
    }

    public static int a(Bitmap bitmap, int i, boolean z) {
        if (i == -1) {
            i = a(3553);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            GLES20.glBindTexture(3553, i);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
        }
        if (z) {
            bitmap.recycle();
        }
        return i;
    }

    public static int a(String str, int i) {
        if (a.b) {
            a.a("YkGLUtils", "loadShader() - strSource:\n" + str + "\ntype:" + i);
        }
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i);
        a("glCreateShader");
        GLES20.glShaderSource(glCreateShader, str);
        a("glShaderSource");
        GLES20.glCompileShader(glCreateShader);
        a("glCompileShader");
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            a.b("YkGLUtils", "loadShader() - failed, error:" + GLES20.glGetShaderInfoLog(glCreateShader));
            new Throwable().printStackTrace();
            return 0;
        }
        return glCreateShader;
    }

    public static int a(String str, String str2) {
        String str3;
        int[] iArr = new int[1];
        int a = a(str, 35633);
        a("loadShader vertex");
        if (a == 0) {
            str3 = "Vertex Shader Failed";
        } else {
            int a2 = a(str2, 35632);
            a("loadShader fragment");
            if (a2 == 0) {
                str3 = "Fragment Shader Failed";
            } else {
                int glCreateProgram = GLES20.glCreateProgram();
                a("glCreateProgram");
                GLES20.glAttachShader(glCreateProgram, a);
                a("glAttachShader vertex");
                GLES20.glAttachShader(glCreateProgram, a2);
                a("glAttachShader fragment");
                GLES20.glLinkProgram(glCreateProgram);
                a("glLinkProgram");
                GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] > 0) {
                    GLES20.glDeleteShader(a);
                    GLES20.glDeleteShader(a2);
                    a("glDeleteShader");
                    return glCreateProgram;
                }
                str3 = "Linking Failed";
            }
        }
        a.c("YkGLUtils", str3);
        return 0;
    }

    public static String a(String str, float[] fArr, int i) {
        StringBuilder sb = new StringBuilder(str);
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (i2 % i == 0) {
                sb.append(StringUtils.LF);
            }
            sb.append(String.format(" %02.1ff", Float.valueOf(fArr[i2])));
        }
        return sb.toString();
    }

    public static void a(String str) {
        int eglGetError;
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            a.c("YkGLUtils", str + ": glGetError: 0x" + Integer.toHexString(glGetError));
            new Throwable().printStackTrace();
        }
        if (Build.VERSION.SDK_INT < 17 || (eglGetError = EGL14.eglGetError()) == 12288) {
            return;
        }
        a.c("YkGLUtils", str + ": eglGetError: 0x" + Integer.toHexString(eglGetError));
        new Throwable().printStackTrace();
    }

    public static float[] a(float f, float f2, float f3, float f4) {
        float f5 = (f * 2.0f) - 1.0f;
        float f6 = ((f + f3) * 2.0f) - 1.0f;
        float f7 = ((f4 + f2) * 2.0f) - 1.0f;
        float f8 = (f2 * 2.0f) - 1.0f;
        return new float[]{f5, f8, f6, f8, f5, f7, f6, f7};
    }
}
