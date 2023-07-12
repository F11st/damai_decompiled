package com.youku.android.audio;

import android.util.Log;
import androidx.annotation.Keep;
import com.youku.alixplayer.config.FeatureManager;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
@Keep
/* loaded from: classes7.dex */
public class OprAudio {
    private static final String TAG = "OprAudio";
    private long mNativeAudioContext = 0;

    static {
        System.loadLibrary(FeatureManager.FEATURE_KEY_OPR);
    }

    private native int nativeAddAudioFilter(long j);

    private native void nativeCloseAudio();

    private native void nativeFlushAudio();

    private native int nativeGetAudioRenderInfo();

    private native int nativeGetLatency();

    private native boolean nativeGetMute();

    private native float nativeGetVolume();

    private native int nativeOpenAudio(Object obj, Object obj2);

    private native void nativePauseAudio();

    private native int nativeRemoveAudioFilter(long j);

    private native int nativeRenderAudio(Object obj);

    private native void nativeResumeAudio();

    private native int nativeSetAudioParameter(long j);

    private native void nativeSetMute(boolean z);

    private native void nativeSetVolume();

    public int AddFilter(long j) {
        Log.d(TAG, "AddFilter");
        return nativeAddAudioFilter(j);
    }

    public void CloseAudio() {
        Log.d(TAG, "CloseAudio");
        nativeCloseAudio();
    }

    public void FlushAudio() {
        Log.d(TAG, "FlushAudio");
        nativeFlushAudio();
    }

    public int GetLatency() {
        Log.d(TAG, "GetLatency");
        return nativeGetLatency();
    }

    public boolean GetMute() {
        Log.d(TAG, "GetMute");
        return nativeGetMute();
    }

    public int GetRenderInfo() {
        Log.d(TAG, "GetRenderInfo");
        return nativeGetAudioRenderInfo();
    }

    public float GetVolume() {
        Log.d(TAG, "GetVolume");
        return nativeGetVolume();
    }

    public int OpenAudio(OprAudioInfo oprAudioInfo) {
        Log.d(TAG, "OpenAudio");
        return nativeOpenAudio(new WeakReference(this), oprAudioInfo);
    }

    public void PauseAudio() {
        Log.d(TAG, "PauseAudio");
        nativePauseAudio();
    }

    public int RemoveFilter(long j) {
        Log.d(TAG, "RemoveFilter");
        return nativeRemoveAudioFilter(j);
    }

    public int RenderAudio(OprAudioBuffer oprAudioBuffer) {
        Log.d(TAG, "RenderAudio");
        return nativeRenderAudio(oprAudioBuffer);
    }

    public void ResumeAudio() {
        Log.d(TAG, "ResumeAudio");
        nativeResumeAudio();
    }

    public void SetMute(boolean z) {
        Log.d(TAG, "SetMute");
        nativeSetMute(z);
    }

    public int SetParameter(long j) {
        Log.d(TAG, "SetParameter");
        return nativeSetAudioParameter(j);
    }

    public void SetVolume(float f) {
        Log.d(TAG, "SetVolume");
        nativeSetVolume();
    }
}
