package com.youku.android.barrage.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class OprTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private OprViewCallback mCallback;

    public OprTextureView(Context context) {
        super(context);
        this.mCallback = null;
        initView();
    }

    public OprTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCallback = null;
        initView();
    }

    public OprTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCallback = null;
        initView();
    }

    public OprTextureView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mCallback = null;
        initView();
    }

    private void initView() {
        setSurfaceTextureListener(this);
        setOpaque(false);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        OprViewCallback oprViewCallback = this.mCallback;
        if (oprViewCallback != null) {
            oprViewCallback.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        OprViewCallback oprViewCallback = this.mCallback;
        if (oprViewCallback != null) {
            oprViewCallback.onSurfaceTextureDestroyed(surfaceTexture);
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        OprViewCallback oprViewCallback = this.mCallback;
        if (oprViewCallback != null) {
            oprViewCallback.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        OprViewCallback oprViewCallback = this.mCallback;
        if (oprViewCallback != null) {
            oprViewCallback.onSurfaceTextureUpdated(surfaceTexture);
        }
    }

    public void setupCallback(OprViewCallback oprViewCallback) {
        this.mCallback = oprViewCallback;
    }
}
