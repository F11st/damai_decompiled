package com.youku.live.dago.liveplayback.widget.preload;

import android.content.Context;
import android.media.ImageReader;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.util.DebugHelp;
import com.youku.live.livesdk.util.LivePerfUtils;
import com.youku.live.livesdk.wkit.utils.SdkChannel;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SurfaceProvider {
    private static transient /* synthetic */ IpChange $ipChange;
    private static SurfaceProvider instance;
    private ImageReader mImageReader;
    private Surface mSurface;

    public static SurfaceProvider getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1857087487")) {
            return (SurfaceProvider) ipChange.ipc$dispatch("1857087487", new Object[0]);
        }
        synchronized (SurfaceProvider.class) {
            if (instance == null) {
                instance = new SurfaceProvider();
            }
        }
        return instance;
    }

    public void destroySurface(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1605453276")) {
            ipChange.ipc$dispatch("-1605453276", new Object[]{this, context});
        } else if (SdkChannel.isLaifeng(context) && LivePerfUtils.enableNotDestroySurfaceInLaifeng()) {
        } else {
            forceDestroySurface();
        }
    }

    public void forceDestroySurface() {
        ImageReader imageReader;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "489652725")) {
            ipChange.ipc$dispatch("489652725", new Object[]{this});
            return;
        }
        if (Build.VERSION.SDK_INT >= 19 && (imageReader = this.mImageReader) != null) {
            imageReader.close();
            this.mImageReader = null;
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
    }

    @NonNull
    @RequiresApi(api = 19)
    public Surface getSurface() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1759207390")) {
            return (Surface) ipChange.ipc$dispatch("-1759207390", new Object[]{this});
        }
        Surface surface = this.mSurface;
        if (surface == null || !surface.isValid()) {
            if (this.mSurface != null || this.mImageReader != null) {
                forceDestroySurface();
            }
            ImageReader newInstance = ImageReader.newInstance(100, 100, 35, 2);
            this.mImageReader = newInstance;
            newInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.youku.live.dago.liveplayback.widget.preload.SurfaceProvider.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.media.ImageReader.OnImageAvailableListener
                public void onImageAvailable(ImageReader imageReader) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1768612329")) {
                        ipChange2.ipc$dispatch("-1768612329", new Object[]{this, imageReader});
                    } else if (DebugHelp.isDebugBuild()) {
                        Log.d("ImageReader", "OnImageAvailableListener");
                    }
                }
            }, null);
            this.mSurface = this.mImageReader.getSurface();
        }
        return this.mSurface;
    }
}
