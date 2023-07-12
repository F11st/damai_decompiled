package com.youku.alixplayer.opensdk.statistics;

import com.youku.alixplayer.opensdk.PlayVideoInfo;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface ITrack {
    PlayVideoInfo getPlayVideoInfo();

    String getString(String str);

    boolean isDataReady();

    boolean isRealVideoCompletion();

    boolean isRealVideoStarted();

    void putString(String str, String str2);
}
