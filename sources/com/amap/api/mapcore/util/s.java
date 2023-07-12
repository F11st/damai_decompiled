package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class s {
    private int a = -1;
    private int b = -1;
    private int c = -1;
    private int d = 0;
    private Bitmap e = null;
    private Bitmap f = null;
    private Bitmap g = null;

    public void a(Context context) {
        Bitmap bitmap = this.e;
        if (bitmap == null || bitmap.isRecycled()) {
            this.e = eq.a(context, "amap_sdk_lineTexture.png");
        }
        Bitmap bitmap2 = this.f;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            this.f = eq.a(context, "amap_sdk_lineDashTexture_square.png");
        }
        Bitmap bitmap3 = this.g;
        if (bitmap3 == null || bitmap3.isRecycled()) {
            this.g = eq.a(context, "amap_sdk_lineDashTexture_circle.png");
        }
        this.a = eq.a(this.e);
        this.b = eq.a(this.f, true);
        this.c = eq.a(this.g, true);
        this.d = eq.a(512, 1024);
    }

    public float b() {
        return 1.0f;
    }

    public int c() {
        return this.d;
    }

    public void d() {
        GLES20.glDeleteTextures(4, new int[]{this.a, this.b, this.c, this.d}, 0);
    }

    public void e() {
        Bitmap bitmap = this.f;
        if (bitmap != null && !bitmap.isRecycled()) {
            eq.b(this.f);
            this.f = null;
        }
        Bitmap bitmap2 = this.g;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            eq.b(this.g);
            this.g = null;
        }
        Bitmap bitmap3 = this.e;
        if (bitmap3 == null || bitmap3.isRecycled()) {
            return;
        }
        eq.b(this.e);
        this.e = null;
    }

    public int a() {
        return this.a;
    }

    public int a(int i) {
        if (i == 0) {
            return this.b;
        }
        if (i == 1) {
            return this.c;
        }
        return -1;
    }
}
