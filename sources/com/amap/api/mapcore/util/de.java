package com.amap.api.mapcore.util;

import android.opengl.GLES20;
import com.autonavi.base.amap.mapcore.gles.AMapNativeGLShaderManager;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class de {
    private d a;
    private g b;
    private c c;
    private e d;
    private e e;
    private a f;
    private b g;
    private long h;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a extends dd {
        String a;
        String b = "        precision highp float;\n        varying vec2 texture;\n        uniform sampler2D aTextureUnit0;\n        void main(){\n            vec4 tempColor = texture2D(aTextureUnit0, texture);\n            gl_FragColor = tempColor;\n        }";
        public int c;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;

        public a() {
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
    /* loaded from: classes10.dex */
    public static class b extends dd {
        String a = "precision highp float;\n        attribute vec3 aVertex;//顶点数组,三维坐标\n        attribute vec2 aTexture;\n        uniform mat4 aMVPMatrix;//mvp矩阵\n        varying vec2 texture;//\n        void main(){\n            gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n            texture = aTexture;\n        }";
        String b = "        precision highp float;\n        varying vec2 texture;//\n        uniform sampler2D aTextureUnit0;//纹理id\n        void main(){\n            gl_FragColor = texture2D(aTextureUnit0, texture);\n        }";
        public int c;
        public int g;
        public int h;

        public b() {
            if (a("precision highp float;\n        attribute vec3 aVertex;//顶点数组,三维坐标\n        attribute vec2 aTexture;\n        uniform mat4 aMVPMatrix;//mvp矩阵\n        varying vec2 texture;//\n        void main(){\n            gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n            texture = aTexture;\n        }", "        precision highp float;\n        varying vec2 texture;//\n        uniform sampler2D aTextureUnit0;//纹理id\n        void main(){\n            gl_FragColor = texture2D(aTextureUnit0, texture);\n        }")) {
                this.c = GLES20.glGetAttribLocation(this.d, "aVertex");
                this.h = GLES20.glGetAttribLocation(this.d, "aTexture");
                this.g = GLES20.glGetUniformLocation(this.d, "aMVPMatrix");
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class c extends dd {
        public int a;
        public int b;
        public int c;
        public int g;
        public int h;

        c(String str) {
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
    /* loaded from: classes10.dex */
    public static class d extends dd {
        public int a;
        public int b;
        public int c;
        public int g;
        public int h;

        d(String str) {
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
    /* loaded from: classes10.dex */
    public static class e extends dd {
        public int a;
        public int b;
        public int c;

        e(String str) {
            if (a(str)) {
                this.a = c("aMVPMatrix");
                this.c = c("aColor");
                this.b = b("aVertex");
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class f extends e {
        f(String str) {
            super(str);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class g extends dd {
        public int a;
        public int b;
        public int c;

        g(String str) {
            if (a(str)) {
                this.a = c("aMVP");
                this.b = b("aVertex");
                this.c = b("aTextureCoord");
            }
        }
    }

    public de() {
        this.h = 0L;
        this.h = AMapNativeGLShaderManager.nativeCreateGLShaderManager();
    }

    private synchronized dd c() {
        if (this.a == null) {
            this.a = new d("texture_normal.glsl");
        }
        return this.a;
    }

    private synchronized dd d() {
        if (this.b == null) {
            this.b = new g("texture.glsl");
        }
        return this.b;
    }

    private synchronized dd e() {
        if (this.c == null) {
            this.c = new c("texture_layer.glsl");
        }
        return this.c;
    }

    private synchronized dd f() {
        if (this.d == null) {
            this.d = new e("point.glsl");
        }
        return this.d;
    }

    private synchronized dd g() {
        if (this.e == null) {
            this.e = new f("point_2.glsl");
        }
        return this.e;
    }

    private synchronized a h() {
        if (this.f == null) {
            this.f = new a();
        }
        return this.f;
    }

    private synchronized dd i() {
        if (this.g == null) {
            this.g = new b();
        }
        return this.g;
    }

    public long a() {
        return this.h;
    }

    public synchronized void b() {
        d dVar = this.a;
        if (dVar != null) {
            dVar.b();
            this.a = null;
        }
        g gVar = this.b;
        if (gVar != null) {
            gVar.b();
            this.b = null;
        }
        c cVar = this.c;
        if (cVar != null) {
            cVar.b();
            this.c = null;
        }
        e eVar = this.d;
        if (eVar != null) {
            eVar.b();
            this.d = null;
        }
        e eVar2 = this.e;
        if (eVar2 != null) {
            eVar2.b();
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
