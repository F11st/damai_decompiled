package com.youku.alixplayer.opensdk.statistics;

import android.os.Bundle;
import com.youku.alixplayer.opensdk.utils.Callable;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface IPlayerTrack {
    void addPlayerTrackInfoListener(OnPlayerTrackListener onPlayerTrackListener);

    PlayTimeTrack getPlayTimeTrack();

    ITrack getTrack();

    void onAction(String str, Bundle bundle);

    void putString(String str, String str2);

    void putTimestamp(String str, long j);

    void removePlayerTrackInfoListener(OnPlayerTrackListener onPlayerTrackListener);

    void setDynamicProperties(Callable<String> callable);
}
