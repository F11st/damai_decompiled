package com.youku.vpm;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IPlayTimeTrack {
    public static final String CLICK = "clickTs";
    public static final String ERROR = "errorTs";
    public static final String PAUSE = "pauseTs";
    public static final String PLAY = "playTs";
    public static final String PLAYLIST_END = "playlistEndTs";
    public static final String PLAYLIST_START = "playlistStartTs";
    public static final String PREPARE = "playerPrepareTs";
    public static final String PREPARED = "playerPreparedTs";
    public static final String REAL_AD_START = "adStartTs";
    public static final String REAL_VIDEO_START = "realVideoStartTs";
    public static final String REQUEST_END = "requestEndTs";
    public static final String REQUEST_START = "requestStartTs";
    public static final String SET_DISPLAY = "setDisplayTs";
    public static final String STOP = "stopTs";

    void finish();

    long getTimestamp(String str);

    Map<String, Long> getTimestamps();

    void putTimestamp(String str, long j);

    Map<String, Double> toMap();
}
