package com.youku.alixplayer.opensdk.statistics.data;

import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.statistics.Track;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ExtrasNetm3sInfo extends ExtraMap {
    public ExtrasNetm3sInfo(Track track, PlayVideoInfo playVideoInfo) {
        put("wifiInfo", playVideoInfo.getString("wifiInfo", null));
    }
}
