package com.youku.android.player;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class OprSurfaceWrap extends Surface {
    private static final String TAG = "OprSurfaceWrap";
    private int mEngineId;
    private Handler mHandler;
    private int mHeight;
    private int mLayerId;
    private boolean mSurfaceFlag;
    private int mWidth;

    public OprSurfaceWrap(SurfaceTexture surfaceTexture) {
        super(surfaceTexture);
        this.mEngineId = 0;
        this.mLayerId = -1;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mSurfaceFlag = true;
        if (Build.VERSION.SDK_INT < 21) {
            surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.youku.android.player.OprSurfaceWrap.2
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    if (!OprSurfaceWrap.this.mSurfaceFlag) {
                        Log.w(OprSurfaceWrap.TAG, "aliplayer not running, do not call notifyFrameAvailable");
                        return;
                    }
                    OprSurfaceWrap oprSurfaceWrap = OprSurfaceWrap.this;
                    oprSurfaceWrap.notifyFrameAvailable(oprSurfaceWrap.mWidth, OprSurfaceWrap.this.mHeight, OprSurfaceWrap.this.mEngineId, OprSurfaceWrap.this.mLayerId);
                }
            });
            return;
        }
        HandlerThread handlerThread = new HandlerThread(TAG, 0);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.youku.android.player.OprSurfaceWrap.1
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                if (!OprSurfaceWrap.this.mSurfaceFlag) {
                    Log.w(OprSurfaceWrap.TAG, "aliplayer not running, do not call notifyFrameAvailable");
                    return;
                }
                OprSurfaceWrap oprSurfaceWrap = OprSurfaceWrap.this;
                oprSurfaceWrap.notifyFrameAvailable(oprSurfaceWrap.mWidth, OprSurfaceWrap.this.mHeight, OprSurfaceWrap.this.mEngineId, OprSurfaceWrap.this.mLayerId);
            }
        }, this.mHandler);
    }

    public void SetHeight(int i) {
        this.mHeight = i;
    }

    public void SetOprSurfaceFlag(boolean z) {
        this.mSurfaceFlag = z;
    }

    public void SetRenderCtx(int i, int i2) {
        this.mEngineId = i;
        this.mLayerId = i2;
    }

    public void SetWidth(int i) {
        this.mWidth = i;
    }

    public native void nativeNotifyFrameAvailable(int i, int i2, int i3, int i4);

    public void notifyFrameAvailable(int i, int i2, int i3, int i4) {
        nativeNotifyFrameAvailable(i, i2, i3, i4);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        if (this.mHandler == null || Looper.getMainLooper() == this.mHandler.getLooper()) {
            return;
        }
        this.mHandler.getLooper().quit();
    }
}
