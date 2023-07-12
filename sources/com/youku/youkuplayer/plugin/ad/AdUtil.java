package com.youku.youkuplayer.plugin.ad;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.business.playerad.PlayerAdManager;
import com.alimm.xadsdk.business.playerad.model.PlayerVideoInfo;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Source;
import com.youku.alixplayer.util.NativeMap;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.upsplayer.module.VideoInfo;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AdUtil {
    public static Period getAdPeriod(List<BidInfo> list, int i) {
        Period period = new Period();
        period.setType(1);
        period.setMixedCodec(true);
        NativeMap nativeMap = new NativeMap();
        nativeMap.put("player_source", "1");
        period.setHeader(nativeMap);
        while (i < list.size()) {
            BidInfo bidInfo = list.get(i);
            if (bidInfo != null && !TextUtils.isEmpty(bidInfo.getCreativeUrl())) {
                period.addSource(new Source((!TextUtils.isEmpty(bidInfo.getCreativePath()) ? bidInfo.getCreativePath() : bidInfo.getCreativeUrl()).trim(), bidInfo.getDuration()));
            }
            i++;
        }
        return period;
    }

    public static PlayerVideoInfo getAdRequestParams(Context context, PlayInfo playInfo) {
        PlayerVideoInfo playerVideoInfo = new PlayerVideoInfo();
        playerVideoInfo.setVideoMode(0);
        playerVideoInfo.setIsOffline(false);
        String playId = playInfo.getPlayId();
        playerVideoInfo.setVideoId(playId);
        playerVideoInfo.setShowId("");
        playerVideoInfo.setLiveId(playId);
        playerVideoInfo.setStreamType(1);
        if (playInfo.getPlayType() == PlayDefinition.PlayType.VOD) {
            playerVideoInfo.setSessionId(playInfo.getPlayParams().getSessionId());
            VideoInfo videoInfo = playInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo();
            if (videoInfo != null) {
                videoInfo.getVideo();
                videoInfo.getController();
            }
        } else {
            PlayDefinition.PlayType playType = PlayDefinition.PlayType.LIVE;
        }
        return playerVideoInfo;
    }

    public static Map<String, String> getPreAdParameter(Context context, PlayInfo playInfo) {
        return PlayerAdManager.getAdRequestParams(context, 7);
    }
}
