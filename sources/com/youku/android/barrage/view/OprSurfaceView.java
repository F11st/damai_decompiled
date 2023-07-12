package com.youku.android.barrage.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class OprSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private OprViewCallback mCallback;

    public OprSurfaceView(Context context) {
        super(context);
        this.mCallback = null;
        initView();
    }

    public OprSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCallback = null;
        initView();
    }

    public OprSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCallback = null;
        initView();
    }

    public OprSurfaceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mCallback = null;
        initView();
    }

    private void initView() {
        setZOrderOnTop(true);
        setZOrderMediaOverlay(true);
        getHolder().setFormat(-2);
        getHolder().addCallback(this);
    }

    public void setupCallback(OprViewCallback oprViewCallback) {
        this.mCallback = oprViewCallback;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        OprViewCallback oprViewCallback = this.mCallback;
        if (oprViewCallback != null) {
            oprViewCallback.surfaceChanged(surfaceHolder, i, i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        OprViewCallback oprViewCallback = this.mCallback;
        if (oprViewCallback != null) {
            oprViewCallback.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        OprViewCallback oprViewCallback = this.mCallback;
        if (oprViewCallback != null) {
            oprViewCallback.surfaceDestroyed(surfaceHolder);
        }
    }
}
