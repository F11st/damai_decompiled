package com.youku.opengl.filter;

/* compiled from: Taobao */
/* renamed from: com.youku.opengl.filter.d */
/* loaded from: classes3.dex */
public class C8022d extends C8026h {
    protected float d;

    public void a(float f) {
        this.d = f;
        a(new Runnable() { // from class: com.youku.opengl.filter.YkGLGaussianBlurFilter$1
            @Override // java.lang.Runnable
            public void run() {
                C8022d.this.r();
            }
        });
    }

    @Override // com.youku.opengl.filter.C8020b
    public void c() {
        super.c();
        a(this.d);
    }

    @Override // com.youku.opengl.filter.C8026h
    public float p() {
        return this.d;
    }

    @Override // com.youku.opengl.filter.C8026h
    public float q() {
        return this.d;
    }
}
