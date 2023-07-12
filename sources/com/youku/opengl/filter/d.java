package com.youku.opengl.filter;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class d extends h {
    protected float d;

    public void a(float f) {
        this.d = f;
        a(new Runnable() { // from class: com.youku.opengl.filter.YkGLGaussianBlurFilter$1
            @Override // java.lang.Runnable
            public void run() {
                d.this.r();
            }
        });
    }

    @Override // com.youku.opengl.filter.b
    public void c() {
        super.c();
        a(this.d);
    }

    @Override // com.youku.opengl.filter.h
    public float p() {
        return this.d;
    }

    @Override // com.youku.opengl.filter.h
    public float q() {
        return this.d;
    }
}
