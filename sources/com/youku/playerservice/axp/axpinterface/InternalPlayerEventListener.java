package com.youku.playerservice.axp.axpinterface;

import androidx.annotation.NonNull;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface InternalPlayerEventListener {

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum ADType {
        PRE_AD(1),
        PRE_VIPAD(2),
        MID_AD(3),
        POST_AD(4);
        
        private int mValue;

        ADType(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    void onAdCountDown(int i);

    void onAdEnd(ADType aDType, int i);

    void onAdStart(ADType aDType, int i);

    void onComplete();

    void onEndLoading();

    void onError(int i);

    void onInfo(int i, int i2, int i3, Object obj);

    void onNotify(String str, Map<String, Object> map);

    void onPause();

    void onPositionChange(int i);

    void onPrepared();

    void onPreviewChange(Object obj);

    void onPreviewEnd();

    void onQualityChangeFinish(boolean z, Object obj);

    void onRealVideoStart();

    void onRelease();

    void onScreenShotError(int i);

    void onScreenShotFinished();

    void onScreenShotProgress(int i);

    void onScreenShotVideoEncoderMode(int i);

    void onSeekFinish(boolean z, @NonNull Map<String, String> map);

    void onStart();

    void onStartLoading();

    void onStop();

    void onVideoSizeChanged(int i, int i2);
}
