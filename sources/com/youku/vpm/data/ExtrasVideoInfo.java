package com.youku.vpm.data;

import com.youku.vpm.IVpmFullInfo;
import com.youku.vpm.IVpmInfo;
import com.youku.vpm.track.Track;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ExtrasVideoInfo extends ExtraMap {
    public static final String EXTRAS_VIDEO_INFO = "extras_video_info";

    public ExtrasVideoInfo(Track track, String str) {
        super(str);
        IVpmInfo vpmInfo = track.getVpmInfo();
        IVpmFullInfo vpmFullInfo = track.getVpmFullInfo();
        put("playAbility", track.getDimFromInfo("playAbility", null));
        put("apsOpen265", track.getPlayer().getString("apsOpen265", null));
        put("disableH265", vpmInfo.getString("disableH265", null));
        put("h265ToH264", vpmInfo.getString("h265ToH264", null));
        put("isUseH265", vpmInfo.getString("isUseH265", null));
        put("downloadVersionName", vpmInfo.getString("downloadVersionName", null));
        put("downloadCreateTime", vpmInfo.getString("downloadCreateTime", null));
        put("cacheUpsError", vpmInfo.getString("cacheUpsError", null));
        if (vpmFullInfo != null) {
            put("features", vpmFullInfo.getString("features", null));
            put("hasSei", vpmFullInfo.getString("hasSei", null));
            put("hasCacheUpsVideoInfo", vpmFullInfo.getString("hasCacheUpsVideoInfo", null));
            put("isDataCache", vpmFullInfo.getString("isDataCache", null));
        }
    }
}
