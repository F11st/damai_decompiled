package com.alibaba.aliweex.adapter.module.audio;

import androidx.annotation.Nullable;
import com.taobao.weex.bridge.JSCallback;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
interface IWXAudio {
    public static final String CAN_PLAY_TYPE_MAYBE = "maybe";
    public static final String CAN_PLAY_TYPE_NONE = "";
    public static final String CAN_PLAY_TYPE_PROBABLY = "probably";
    public static final String KEY_AUTOPLAY = "autoplay";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_ENDED = "ended";
    public static final String KEY_ERR_CODE = "code";
    public static final String KEY_ERR_MESSAGE = "message";
    public static final String KEY_ID = "id";
    public static final String KEY_LOOP = "loop";
    public static final String KEY_PAUSED = "paused";
    public static final String KEY_STATUS = "status";
    public static final String KEY_URL = "url";
    public static final String KEY_VALUE = "value";
    public static final String KEY_VOLUME = "volume";
    public static final String MEDIA_ERR_ABORTED = "1";
    public static final String MEDIA_ERR_DECODE = "3";
    public static final String MEDIA_ERR_NETWORK = "2";
    public static final String MEDIA_ERR_OTHER = "5";
    public static final String MEDIA_ERR_SRC_NOT_SUPPORTED = "4";
    public static final int MEDIA_STATUS_ENDED = 5;
    public static final int MEDIA_STATUS_ERROR = 6;
    public static final int MEDIA_STATUS_INIT = 1;
    public static final int MEDIA_STATUS_PAUSE = 4;
    public static final int MEDIA_STATUS_PLAYING = 3;
    public static final int MEDIA_STATUS_READY = 2;

    String canPlayType(String str);

    void load(Map<String, String> map, @Nullable JSCallback jSCallback);

    void pause(Long l);

    void play(Long l);

    void seek(Long l, int i);

    void setVolume(float f);

    void stop(Long l);
}
