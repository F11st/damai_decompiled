package com.youku.alixplayer.opensdk.statistics.data;

import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.statistics.PlayTimeTrack;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.vpm.constants.TableField;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ExtrasPlayerInfo extends ExtraMap {
    public ExtrasPlayerInfo(Track track, PlayVideoInfo playVideoInfo) {
        put("isIntercept", playVideoInfo.getString("isIntercept"));
        put("liveUrlReplace", track.getString("liveUrlReplace"));
        put("usePIP", track.getString("usePIP"));
        put("isPIP", track.getString("isPIP"));
        put("useAudioHbr", track.getString("useAudioHbr"));
        put("isAudioHbr", track.getString("isAudioHbr"));
        put("audioHbrError", track.getString("audioHbrError"));
        put("background_mode", track.getString("background_mode"));
        put("retryCount", track.getString("retryCount"));
        put("timeShift", playVideoInfo.getString("timeShift"));
        put(TableField.PLAY_FROM, track.getString(TableField.PLAY_FROM));
        PlayTimeTrack playTimeTrack = track.getPlayTimeTrack();
        if (playTimeTrack != null) {
            for (Map.Entry<String, Long> entry : playTimeTrack.getTimestamps().entrySet()) {
                String key = entry.getKey();
                Long value = entry.getValue();
                if (value != null) {
                    put(key, value + "");
                }
            }
            for (Map.Entry<String, Long> entry2 : playTimeTrack.getPlayerCoreTimestamp().entrySet()) {
                String key2 = entry2.getKey();
                Long value2 = entry2.getValue();
                if (value2 != null) {
                    put(key2, value2 + "");
                }
            }
        }
    }
}
