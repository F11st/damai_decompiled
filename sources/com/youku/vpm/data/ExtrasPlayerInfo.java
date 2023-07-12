package com.youku.vpm.data;

import com.ali.user.open.core.util.ParamsConstants;
import com.youku.vpm.IVpmInfo;
import com.youku.vpm.PlayTimeTrack;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.framework.Table;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.track.Track;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ExtrasPlayerInfo extends ExtraMap {
    public static final String EXTRAS_PLAYER_INFO = "extras_player_info";
    private static final String[] timestamps = {"onePlay"};

    public ExtrasPlayerInfo(Track track, String str) {
        super(str);
        PlayTimeTrack playTimeTrack;
        Map<String, String> dimensions;
        IVpmInfo vpmInfo = track.getVpmInfo();
        Table table = track.getTable(TableId.ONEPLAY);
        if (table != null && (dimensions = table.getDimensions()) != null && dimensions.containsKey("isUseDownloader")) {
            put("isUseDownloader", dimensions.get("isUseDownloader"));
        }
        put("isIntercept", vpmInfo.getString("isIntercept", null));
        put("liveUrlReplace", track.getString("liveUrlReplace"));
        put("usePIP", track.getString("usePIP"));
        put("isPIP", track.getString("isPIP"));
        put("useAudioHbr", track.getString("useAudioHbr"));
        put("isAudioHbr", track.getString("isAudioHbr"));
        put("audioHbrError", track.getString("audioHbrError"));
        put("background_mode", track.getString("background_mode"));
        put("retryCount", track.getString("retryCount"));
        put("timeShift", vpmInfo.getString("timeShift", null));
        put(TableField.PLAY_FROM, track.getString(TableField.PLAY_FROM));
        put("stopFrom", track.getString("stopFrom"));
        put("hbrHit", vpmInfo.getString("hbrHit", null));
        put("hasFastTsUrl", vpmInfo.getString("hasFastTsUrl", null));
        put("hasFastUrl", vpmInfo.getString("hasFastUrl", null));
        put("fastUrlType", vpmInfo.getString("fastUrlType", null));
        put("clientTimeMillis", System.currentTimeMillis() + "");
        put("preloadType", vpmInfo.getString("preloadType", null));
        put(ParamsConstants.Key.PARAM_TRACE_ID, vpmInfo.getString(ParamsConstants.Key.PARAM_TRACE_ID, null));
        put("requestId", vpmInfo.getString("requestId", null));
        put("fastTsUrlRetry", vpmInfo.getString("fastTsUrlRetry", null));
        put("fastTsStreamType", vpmInfo.getString("fastTsStreamType", null));
        put("openType", vpmInfo.getString("openType", null));
        put("pagePlayMode", vpmInfo.getString("pagePlayMode", null));
        put("fastUrlError", vpmInfo.getString("fastUrlError", null));
        if (!contains(timestamps) || (playTimeTrack = track.getPlayTimeTrack()) == null) {
            return;
        }
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
