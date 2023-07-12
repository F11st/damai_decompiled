package com.youku.android.barrage.view;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface OprViewCallback {
    void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2);

    boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture);

    void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2);

    void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture);

    void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3);

    void surfaceCreated(SurfaceHolder surfaceHolder);

    void surfaceDestroyed(SurfaceHolder surfaceHolder);
}
