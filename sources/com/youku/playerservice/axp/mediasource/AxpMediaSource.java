package com.youku.playerservice.axp.mediasource;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.xadsdk.base.model.BidInfo;
import com.youku.alixplayer.IPlaylist;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Playlist;
import com.youku.alixplayer.model.Source;
import com.youku.alixplayer.util.NativeMap;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.mediasource.BaseMediaSource;
import com.youku.playerservice.axp.p2p.P2pManager;
import com.youku.playerservice.axp.p2p.PcdnType;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playerservice.axp.utils.Utils;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AxpMediaSource extends BaseMediaSource {
    protected Context mContext;
    protected PlayInfo mPlayInfo;
    protected PlayerConfig mPlayerConfig;

    public AxpMediaSource(Context context, PlayInfo playInfo) {
        this.mContext = context;
        this.mPlayInfo = playInfo;
        this.mPlayerConfig = playInfo.getPlayerConfig();
    }

    public String appendUrlParams(String str, String str2) {
        if (str.contains("http://") || str.contains("https://")) {
            if (str.contains("?")) {
                return str + "&" + str2;
            }
            return str + "?" + str2;
        }
        return str;
    }

    public Period buildPlaylistByAdInfo() {
        String appendUrlParams;
        List<BidInfo> bitInfoByAdType = this.mPlayInfo.getBitInfoByAdType(7);
        if (bitInfoByAdType == null || bitInfoByAdType.size() <= 0) {
            return null;
        }
        Period period = new Period();
        period.setType(1);
        period.setMixedCodec(true);
        NativeMap nativeMap = new NativeMap();
        nativeMap.put("player_source", "1");
        period.setHeader(nativeMap);
        for (BidInfo bidInfo : bitInfoByAdType) {
            if (bidInfo != null && !TextUtils.isEmpty(bidInfo.getCreativeUrl())) {
                if (TextUtils.isEmpty(bidInfo.getCreativePath())) {
                    appendUrlParams = appendUrlParams(bidInfo.getCreativeUrl().trim(), "ykVideoShowType=2");
                    if (Utils.isYoukuOrHuaweiBaipai(this.mContext)) {
                        P2pManager.Result pcdnUrl = P2pManager.getInstance(this.mContext.getApplicationContext()).getPcdnUrl(this.mContext, PcdnType.VOD, appendUrlParams, null);
                        if ("10000".equals(pcdnUrl.errorCode)) {
                            appendUrlParams = pcdnUrl.finalUrl;
                        } else {
                            TLogUtil.playLog("ad p2pCode=" + pcdnUrl.errorCode);
                        }
                    }
                } else {
                    appendUrlParams = bidInfo.getCreativePath().trim();
                }
                if (TextUtils.isEmpty(appendUrlParams)) {
                    TLogUtil.flowLog(this.mPlayInfo.getPlayParams().getSessionId(), "广告url为空");
                } else {
                    period.addSource(new Source(appendUrlParams, bidInfo.getDuration()));
                }
            }
        }
        return period;
    }

    @Override // com.youku.playerservice.axp.mediasource.BaseMediaSource
    public PlayInfo getPlayInfo() {
        return this.mPlayInfo;
    }

    @Override // com.youku.playerservice.axp.mediasource.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public String getSourceKey() {
        return null;
    }

    public void notifyError(int i) {
        BaseMediaSource.OnMediaSourceListener onMediaSourceListener = this.mOnMediaSourceListener;
        if (onMediaSourceListener != null) {
            onMediaSourceListener.onPlaylistFailed(i);
        }
    }

    @Override // com.youku.playerservice.axp.mediasource.BaseMediaSource, com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public void preparePlaylist() {
        this.mPlayList = new Playlist();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void printPlaylist(String str, IPlaylist iPlaylist) {
        List periodList = iPlaylist.getPeriodList();
        for (int i = 0; i < periodList.size(); i++) {
            Period period = (Period) periodList.get(i);
            TLogUtil.flowLog(str, "period index=" + i + " type=" + period.getType() + StringUtils.LF);
            StringBuilder sb = new StringBuilder();
            sb.append("header:");
            sb.append(period.getAllHeaders());
            sb.append(StringUtils.LF);
            TLogUtil.flowLog(str, sb.toString());
            List<Source> sourceList = period.getSourceList();
            for (int i2 = 0; i2 < sourceList.size(); i2++) {
                TLogUtil.flowLog(str, "source index=" + i2 + " " + sourceList.get(i2) + StringUtils.LF);
            }
        }
    }

    @Override // com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSourceExt
    public boolean useRaphaelPlayer() {
        return false;
    }
}
