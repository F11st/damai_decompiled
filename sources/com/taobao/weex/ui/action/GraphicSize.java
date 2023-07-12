package com.taobao.weex.ui.action;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GraphicSize {
    private float mHeight;
    private float mWidth;

    public GraphicSize(float f, float f2) {
        this.mWidth = f;
        this.mHeight = f2;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public void setHeight(float f) {
        this.mHeight = f;
    }

    public void setWidth(float f) {
        this.mWidth = f;
    }

    public void update(float f, float f2) {
        this.mWidth = f;
        this.mHeight = f2;
    }
}
