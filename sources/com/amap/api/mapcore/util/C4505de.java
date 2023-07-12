package com.amap.api.mapcore.util;

import android.opengl.GLES20;
import com.autonavi.base.amap.mapcore.gles.AMapNativeGLShaderManager;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.de */
/* loaded from: classes10.dex */
public class C4505de {
    private C4509d a;
    private C4512g b;
    private C4508c c;
    private C4510e d;
    private C4510e e;
    private C4506a f;
    private C4507b g;
    private long h;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.de$a */
    /* loaded from: classes10.dex */
    public static class C4506a extends dd {
        String a;
        String b = "        precision highp float;\n        varying vec2 texture;\n        uniform sampler2D aTextureUnit0;\n        void main(){\n            vec4 tempColor = texture2D(aTextureUnit0, texture);\n            gl_FragColor = tempColor;\n        }";
        public int c;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;

        public C4506a() {
            String str = "precision highp float;\n        attribute vec4 aVertex;\n        attribute vec2 aTexture;\n        uniform vec4 aMapAttribute;\n        uniform mat4 aMVPMatrix;\n        uniform mat4 aProjection;\n        uniform vec3 aInstanceOffset[" + at.a + "];\n        varying vec2 texture;\n        mat4 rotationMatrix(vec3 axis, float angle)\n        {\n           axis = normalize(axis);\n           float s = sin(angle);\n           float c = cos(angle);\n           float oc = 1.0 - c;\n           return mat4(oc * axis.x * axis.x + c,           oc * axis.x * axis.y - axis.z * s,  oc * axis.z * axis.x + axis.y * s,  0.0,\n                 oc * axis.x * axis.y + axis.z * s,  oc * axis.y * axis.y + c,           oc * axis.y * axis.z - axis.x * s,  0.0,\n                 oc * axis.z * axis.x - axis.y * s,  oc * axis.y * axis.z + axis.x * s,  oc * axis.z * axis.z + c,           0.0,\n                 0.0,                                0.0,                                0.0,                                1.0);\n        }\n        void main(){\n            int instance = int(aVertex.w);\n            vec3 offset_value = aInstanceOffset[instance];\n            mat4 marker_rotate_mat4 = rotationMatrix(vec3(0,0,1.0), offset_value.z * 0.01745);\n            float map_rotate = -aMapAttribute.z * 0.01745;\n            float map_tilt = aMapAttribute.w * 0.01745;\n            //tilt旋转矩阵\n            mat4 map_tilt_mat4 = rotationMatrix(vec3(1,0,0), map_tilt);\n            //bearing旋转矩阵\n            mat4 map_rotate_mat4 = rotationMatrix(vec3(0,0,1), map_rotate);\n                 \n            //旋转图片\n            vec4 pos_1 = marker_rotate_mat4 * vec4(aVertex.xy * aMapAttribute.xy, 0,1);\n                  \n            //让marker站立，tilt旋转之后z轴值有可能不是0\n            vec4 pos_2 =  map_tilt_mat4 * pos_1;\n                  \n            //旋转 bearing\n            vec4 pos_3 =  map_rotate_mat4 * pos_2;\n            gl_Position = aProjection * aMVPMatrix * vec4(pos_3.xy + offset_value.xy, pos_3.z, 1.0);\n            texture = aTexture;\n        }";
            this.a = str;
            if (a(str, "        precision highp float;\n        varying vec2 texture;\n        uniform sampler2D aTextureUnit0;\n        void main(){\n            vec4 tempColor = texture2D(aTextureUnit0, texture);\n            gl_FragColor = tempColor;\n        }")) {
                this.g = c("aMVPMatrix");
                this.k = c("aProjection");
                this.i = c("aInstanceOffset");
                this.j = c("aMapAttribute");
                this.c = b("aVertex");
                this.h = b("aTexture");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.de$b */
    /* loaded from: classes10.dex */
    public static class C4507b extends dd {
        String a = "precision highp float;\n        attribute vec3 aVertex;//顶点数组,三维坐标\n        attribute vec2 aTexture;\n        uniform mat4 aMVPMatrix;//mvp矩阵\n        varying vec2 texture;//\n        void main(){\n            gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n            texture = aTexture;\n        }";
        String b = "        precision highp float;\n        varying vec2 texture;//\n        uniform sampler2D aTextureUnit0;//纹理id\n        void main(){\n            gl_FragColor = texture2D(aTextureUnit0, texture);\n        }";
        public int c;
        public int g;
        public int h;

        public C4507b() {
            if (a("precision highp float;\n        attribute vec3 aVertex;//顶点数组,三维坐标\n        attribute vec2 aTexture;\n        uniform mat4 aMVPMatrix;//mvp矩阵\n        varying vec2 texture;//\n        void main(){\n            gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n            texture = aTexture;\n        }", "        precision highp float;\n        varying vec2 texture;//\n        uniform sampler2D aTextureUnit0;//纹理id\n        void main(){\n            gl_FragColor = texture2D(aTextureUnit0, texture);\n        }")) {
                this.c = GLES20.glGetAttribLocation(this.d, "aVertex");
                this.h = GLES20.glGetAttribLocation(this.d, "aTexture");
                this.g = GLES20.glGetUniformLocation(this.d, "aMVPMatrix");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.de$c */
    /* loaded from: classes10.dex */
    public static class C4508c extends dd {
        public int a;
        public int b;
        public int c;
        public int g;
        public int h;

        C4508c(String str) {
            if (a(str)) {
                this.a = c("aMVP");
                this.b = b("aVertex");
                this.c = b("aTextureCoord");
                this.g = c("aTransform");
                this.h = c("aColor");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.de$d */
    /* loaded from: classes10.dex */
    public static class C4509d extends dd {
        public int a;
        public int b;
        public int c;
        public int g;
        public int h;

        C4509d(String str) {
            if (a(str)) {
                this.a = c("aMVP");
                dy.a("getUniform");
                this.h = c("aMapBearing");
                this.b = b("aVertex");
                this.c = b("aTextureCoord");
                this.g = b("aBearingTiltAlpha");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.de$e */
    /* loaded from: classes10.dex */
    public static class C4510e extends dd {
        public int a;
        public int b;
        public int c;

        C4510e(String str) {
            if (a(str)) {
                this.a = c("aMVPMatrix");
                this.c = c("aColor");
                this.b = b("aVertex");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.de$f */
    /* loaded from: classes10.dex */
    public static class C4511f extends C4510e {
        C4511f(String str) {
            super(str);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.de$g */
    /* loaded from: classes10.dex */
    public static class C4512g extends dd {
        public int a;
        public int b;
        public int c;

        C4512g(String str) {
            if (a(str)) {
                this.a = c("aMVP");
                this.b = b("aVertex");
                this.c = b("aTextureCoord");
            }
        }
    }

    public C4505de() {
        this.h = 0L;
        this.h = AMapNativeGLShaderManager.nativeCreateGLShaderManager();
    }

    private synchronized dd c() {
        if (this.a == null) {
            this.a = new C4509d("texture_normal.glsl");
        }
        return this.a;
    }

    private synchronized dd d() {
        if (this.b == null) {
            this.b = new C4512g("texture.glsl");
        }
        return this.b;
    }

    private synchronized dd e() {
        if (this.c == null) {
            this.c = new C4508c("texture_layer.glsl");
        }
        return this.c;
    }

    private synchronized dd f() {
        if (this.d == null) {
            this.d = new C4510e("point.glsl");
        }
        return this.d;
    }

    private synchronized dd g() {
        if (this.e == null) {
            this.e = new C4511f("point_2.glsl");
        }
        return this.e;
    }

    private synchronized C4506a h() {
        if (this.f == null) {
            this.f = new C4506a();
        }
        return this.f;
    }

    private synchronized dd i() {
        if (this.g == null) {
            this.g = new C4507b();
        }
        return this.g;
    }

    public long a() {
        return this.h;
    }

    public synchronized void b() {
        C4509d c4509d = this.a;
        if (c4509d != null) {
            c4509d.b();
            this.a = null;
        }
        C4512g c4512g = this.b;
        if (c4512g != null) {
            c4512g.b();
            this.b = null;
        }
        C4508c c4508c = this.c;
        if (c4508c != null) {
            c4508c.b();
            this.c = null;
        }
        C4510e c4510e = this.d;
        if (c4510e != null) {
            c4510e.b();
            this.d = null;
        }
        C4510e c4510e2 = this.e;
        if (c4510e2 != null) {
            c4510e2.b();
            this.e = null;
        }
        long j = this.h;
        if (j != 0) {
            AMapNativeGLShaderManager.nativeDestroyGLShaderManager(j);
            this.h = 0L;
        }
    }

    public dd a(int i) {
        switch (i) {
            case 0:
                return d();
            case 1:
                return c();
            case 2:
                return e();
            case 3:
                return f();
            case 4:
                return h();
            case 5:
                return i();
            case 6:
                return g();
            default:
                return null;
        }
    }
}
