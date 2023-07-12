package com.youku.android.player;

import android.content.Context;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.Keep;
import com.youku.alixplayer.config.FeatureManager;
import com.youku.android.utils.ApsConfigUtils;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class OprPlayer {
    private long mNativePlayerContext = 0;
    private int mEngineId = -1;
    private int mLayerId = -1;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface E_TYPE_DECODER {
        public static final int E_TYPE_DECODER_HW = 1;
        public static final int E_TYPE_DECODER_SW = 0;
    }

    static {
        System.loadLibrary(FeatureManager.FEATURE_KEY_OPR);
    }

    private native int nativeAddFilter(long j, int i, int i2);

    private native Object nativeGetSurface(int i, int i2);

    private native int nativeInitPlayer(Object obj, Object obj2);

    private native int nativePausePlayer(int i, int i2);

    private native int nativeReleasePlayer(int i, int i2);

    private native int nativeRemoveFilter(long j, int i, int i2);

    private native int nativeRenderPlayer(OprPlayerBuffer oprPlayerBuffer, int i, int i2);

    private native int nativeResumePlayer(int i, int i2);

    private native int nativeScreenShot(int i, int i2, String str);

    private native int nativeSetSurface(Object obj, int i, int i2, int i3, int i4);

    private native int nativeSetSurfaceSize(int i, int i2, int i3, int i4);

    private void testAps() {
        String config = ApsConfigUtils.getInstance().getConfig("mNs", "mKey", "mDefaultVal");
        Log.d("OprPlayer", "aps config: " + config);
    }

    public int ScreenShot(String str) {
        return nativeScreenShot(this.mEngineId, this.mLayerId, str);
    }

    public int addFilter(long j) {
        return nativeAddFilter(j, this.mEngineId, this.mLayerId);
    }

    public Surface getSurface() {
        return (Surface) nativeGetSurface(this.mEngineId, this.mLayerId);
    }

    public int initPlayer(Context context, Surface surface, int i, int i2, int i3, int i4) {
        Object weakReference = new WeakReference(this);
        OprDecoderInfo oprDecoderInfo = new OprDecoderInfo();
        oprDecoderInfo.width = i;
        oprDecoderInfo.height = i2;
        oprDecoderInfo.decoderType = i3;
        oprDecoderInfo.videoSourceType = i4;
        oprDecoderInfo.surface = surface;
        int nativeInitPlayer = nativeInitPlayer(weakReference, oprDecoderInfo);
        this.mEngineId = oprDecoderInfo.engineId;
        this.mLayerId = oprDecoderInfo.layerId;
        return nativeInitPlayer;
    }

    public int pausePlayer() {
        return nativePausePlayer(this.mEngineId, this.mLayerId);
    }

    public int releasePlayer() {
        return nativeReleasePlayer(this.mEngineId, this.mLayerId);
    }

    public int removeFilter(long j) {
        return nativeRemoveFilter(j, this.mEngineId, this.mLayerId);
    }

    public int renderPlayer(OprPlayerBuffer oprPlayerBuffer) {
        return nativeRenderPlayer(oprPlayerBuffer, this.mEngineId, this.mLayerId);
    }

    public int resumePlayer() {
        return nativeResumePlayer(this.mEngineId, this.mLayerId);
    }

    public int setSurface(Surface surface, int i, int i2) {
        return nativeSetSurface(surface, i, i2, this.mEngineId, this.mLayerId);
    }

    public int setSurfaceSize(int i, int i2) {
        return nativeSetSurfaceSize(i, i2, this.mEngineId, this.mLayerId);
    }
}
