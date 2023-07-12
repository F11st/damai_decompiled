package com.alibaba.security.biometrics.logic.view.b;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.alibaba.security.biometrics.camera.InterfaceC3764c;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.common.a.InterfaceC3798a;
import com.youku.alixplayer.MsgID;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.biometrics.logic.view.b.a */
/* loaded from: classes8.dex */
public final class C3780a implements GLSurfaceView.Renderer {
    private static final String d = "CameraRender";
    private static final float[] e = {1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};
    private static final float[] f = {1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final String s = "attribute vec4 avVertex;                                              \nattribute vec4 avVertexCoordinate;                                    \nuniform mat4 umTransformMatrix;                                       \nvarying vec2 vvTextureCoordinate;                                     \nvoid main() {                                                         \n    vvTextureCoordinate= (umTransformMatrix * avVertexCoordinate).xy; \n    gl_Position = avVertex;                                           \n}                                                                     \n";
    private static final String t = "#extension GL_OES_EGL_image_external : require                       \nprecision mediump float;                                             \nuniform samplerExternalOES usTextureOes;                             \nvarying vec2 vvTextureCoordinate;                                    \nvoid main() {                                                        \n    vec4 vCameraColor = texture2D(usTextureOes, vvTextureCoordinate);\n    gl_FragColor = vCameraColor;                                     \n}                                                                    \n";
    public int a;
    public InterfaceC3798a b;
    public SurfaceTexture c;
    private final Context g;
    private final InterfaceC3764c h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private float[] p = new float[16];
    private FloatBuffer q;
    private FloatBuffer r;

    public C3780a(Context context, InterfaceC3764c interfaceC3764c, ALBiometricsParams aLBiometricsParams) {
        this.g = context;
        this.h = interfaceC3764c;
        if (aLBiometricsParams.isBeautyOpen) {
            try {
                this.b = (InterfaceC3798a) Class.forName("com.alibaba.security.plugin.beauty.BeautyRenderManager").newInstance();
            } catch (Throwable unused) {
            }
        }
    }

    private void a() {
        float[] fArr = e;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.q = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        float[] fArr2 = f;
        FloatBuffer put = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr2);
        this.r = put;
        put.position(0);
        this.i = GLES20.glCreateProgram();
        int a = a(35633, s);
        this.j = a;
        GLES20.glAttachShader(this.i, a);
        int a2 = a(35632, t);
        this.k = a2;
        GLES20.glAttachShader(this.i, a2);
        GLES20.glLinkProgram(this.i);
    }

    private void b() {
        SurfaceTexture surfaceTexture = this.c;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
            this.c.getTransformMatrix(this.p);
        }
        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.i);
        this.l = GLES20.glGetAttribLocation(this.i, "avVertex");
        this.o = GLES20.glGetAttribLocation(this.i, "avVertexCoordinate");
        this.m = GLES20.glGetUniformLocation(this.i, "umTransformMatrix");
        this.n = GLES20.glGetUniformLocation(this.i, "usTextureOes");
        GLES20.glVertexAttribPointer(this.l, 2, 5126, false, 8, (Buffer) this.q);
        GLES20.glVertexAttribPointer(this.o, 2, 5126, false, 8, (Buffer) this.r);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.a);
        GLES20.glUniform1i(this.n, 0);
        GLES20.glUniformMatrix4fv(this.m, 1, false, this.p, 0);
        GLES20.glEnableVertexAttribArray(this.l);
        GLES20.glEnableVertexAttribArray(this.o);
        GLES20.glDrawArrays(4, 0, 6);
        GLES20.glDisableVertexAttribArray(this.l);
        GLES20.glDisableVertexAttribArray(this.o);
    }

    private void c() {
        SurfaceTexture surfaceTexture = this.c;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.c = null;
        }
        this.a = -1;
        InterfaceC3798a interfaceC3798a = this.b;
        if (interfaceC3798a != null) {
            interfaceC3798a.a();
        }
    }

    private static int d() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, MsgID.MEDIA_INFO_VIDEO_START_RECOVER, 9729.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        GLES20.glBindTexture(36197, 0);
        return iArr[0];
    }

    private SurfaceTexture e() {
        return this.c;
    }

    private void f() {
        InterfaceC3798a interfaceC3798a = this.b;
        if (interfaceC3798a != null) {
            interfaceC3798a.a(this.h.h(), this.p);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        SurfaceTexture surfaceTexture = this.c;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
            this.c.getTransformMatrix(this.p);
        }
        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.i);
        this.l = GLES20.glGetAttribLocation(this.i, "avVertex");
        this.o = GLES20.glGetAttribLocation(this.i, "avVertexCoordinate");
        this.m = GLES20.glGetUniformLocation(this.i, "umTransformMatrix");
        this.n = GLES20.glGetUniformLocation(this.i, "usTextureOes");
        GLES20.glVertexAttribPointer(this.l, 2, 5126, false, 8, (Buffer) this.q);
        GLES20.glVertexAttribPointer(this.o, 2, 5126, false, 8, (Buffer) this.r);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.a);
        GLES20.glUniform1i(this.n, 0);
        GLES20.glUniformMatrix4fv(this.m, 1, false, this.p, 0);
        GLES20.glEnableVertexAttribArray(this.l);
        GLES20.glEnableVertexAttribArray(this.o);
        GLES20.glDrawArrays(4, 0, 6);
        GLES20.glDisableVertexAttribArray(this.l);
        GLES20.glDisableVertexAttribArray(this.o);
        InterfaceC3798a interfaceC3798a = this.b;
        if (interfaceC3798a != null) {
            interfaceC3798a.a(this.h.h(), this.p);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        InterfaceC3798a interfaceC3798a = this.b;
        if (interfaceC3798a != null) {
            interfaceC3798a.a(i, i2);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        InterfaceC3798a interfaceC3798a;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, MsgID.MEDIA_INFO_VIDEO_START_RECOVER, 9729.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        GLES20.glBindTexture(36197, 0);
        this.a = iArr[0];
        this.c = new SurfaceTexture(this.a);
        float[] fArr = e;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.q = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        float[] fArr2 = f;
        FloatBuffer put = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr2);
        this.r = put;
        put.position(0);
        this.i = GLES20.glCreateProgram();
        int a = a(35633, s);
        this.j = a;
        GLES20.glAttachShader(this.i, a);
        int a2 = a(35632, t);
        this.k = a2;
        GLES20.glAttachShader(this.i, a2);
        GLES20.glLinkProgram(this.i);
        Point g = this.h.g();
        if (g == null || (interfaceC3798a = this.b) == null) {
            return;
        }
        interfaceC3798a.a(this.g, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(g), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(g), this.h.i(), this.a);
    }

    private static int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
        if (r2 != null) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075 A[Catch: IOException -> 0x007e, TryCatch #9 {IOException -> 0x007e, blocks: (B:40:0x0070, B:42:0x0075, B:44:0x007a), top: B:53:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007a A[Catch: IOException -> 0x007e, TRY_LEAVE, TryCatch #9 {IOException -> 0x007e, blocks: (B:40:0x0070, B:42:0x0075, B:44:0x007a), top: B:53:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r4, int r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            android.content.res.Resources r4 = r4.getResources()     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L50
            java.io.InputStream r4 = r4.openRawResource(r5)     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L50
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L48
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L48
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
        L18:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L4a
            if (r1 == 0) goto L33
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L4a
            r3.<init>()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L4a
            r3.append(r1)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L4a
            java.lang.String r1 = "\n"
            r3.append(r1)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L4a
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L4a
            r0.append(r1)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L4a
            goto L18
        L33:
            if (r4 == 0) goto L38
            r4.close()     // Catch: java.io.IOException -> L65
        L38:
            r5.close()     // Catch: java.io.IOException -> L65
            goto L61
        L3c:
            r0 = move-exception
            goto L46
        L3e:
            r0 = move-exception
            r2 = r1
            goto L46
        L41:
            r2 = r1
            goto L4a
        L43:
            r0 = move-exception
            r5 = r1
            r2 = r5
        L46:
            r1 = r4
            goto L6e
        L48:
            r5 = r1
            r2 = r5
        L4a:
            r1 = r4
            goto L52
        L4c:
            r0 = move-exception
            r5 = r1
            r2 = r5
            goto L6e
        L50:
            r5 = r1
            r2 = r5
        L52:
            com.alibaba.security.common.c.C3800a.b()     // Catch: java.lang.Throwable -> L6d
            if (r1 == 0) goto L5a
            r1.close()     // Catch: java.io.IOException -> L65
        L5a:
            if (r5 == 0) goto L5f
            r5.close()     // Catch: java.io.IOException -> L65
        L5f:
            if (r2 == 0) goto L68
        L61:
            r2.close()     // Catch: java.io.IOException -> L65
            goto L68
        L65:
            com.alibaba.security.common.c.C3800a.b()
        L68:
            java.lang.String r4 = r0.toString()
            return r4
        L6d:
            r0 = move-exception
        L6e:
            if (r1 == 0) goto L73
            r1.close()     // Catch: java.io.IOException -> L7e
        L73:
            if (r5 == 0) goto L78
            r5.close()     // Catch: java.io.IOException -> L7e
        L78:
            if (r2 == 0) goto L81
            r2.close()     // Catch: java.io.IOException -> L7e
            goto L81
        L7e:
            com.alibaba.security.common.c.C3800a.b()
        L81:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.logic.view.b.C3780a.a(android.content.Context, int):java.lang.String");
    }
}
