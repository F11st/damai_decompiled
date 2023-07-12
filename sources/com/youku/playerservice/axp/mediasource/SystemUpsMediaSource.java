package com.youku.playerservice.axp.mediasource;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alimm.xadsdk.base.model.BidInfo;
import com.youku.alixplayer.IPlaylist;
import com.youku.alixplayer.instances.System.model.SystemPeriod;
import com.youku.alixplayer.instances.System.model.SystemPlayList;
import com.youku.alixplayer.instances.System.model.SystemSource;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.item.VodItem;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.upsplayer.module.PreVideoSegs;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SystemUpsMediaSource extends BaseMediaSource {
    protected Context mContext;
    protected PlayInfo mPlayInfo;
    protected PlayerConfig mPlayerConfig;

    public SystemUpsMediaSource(Context context, PlayInfo playInfo) {
        this.mContext = context;
        this.mPlayInfo = playInfo;
        this.mPlayerConfig = playInfo.getPlayerConfig();
    }

    private void switchDataSource(SystemPeriod systemPeriod) {
        for (int i = 0; i < this.mPlayList.getPeriodList().size(); i++) {
            if (((SystemPeriod) this.mPlayList.getPeriodList().get(i)).getType() == 0) {
                changePeriod(i, systemPeriod);
            }
        }
        String sessionId = this.mPlayInfo.getPlayParams().getSessionId();
        TLogUtil.flowLog(sessionId, "切换播放地址 ups");
        printPlaylist(sessionId, this.mPlayList);
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

    public SystemPeriod buildPlaylistByAdInfo() {
        List<BidInfo> bitInfoByAdType = this.mPlayInfo.getBitInfoByAdType(7);
        if (bitInfoByAdType == null || bitInfoByAdType.size() <= 0) {
            return null;
        }
        SystemPeriod systemPeriod = new SystemPeriod();
        systemPeriod.setType(1);
        systemPeriod.setMixedCodec(true);
        HashMap hashMap = new HashMap();
        hashMap.put("player_source", "1");
        systemPeriod.setHeader(hashMap);
        for (BidInfo bidInfo : bitInfoByAdType) {
            if (bidInfo != null && !TextUtils.isEmpty(bidInfo.getCreativeUrl())) {
                String trim = !TextUtils.isEmpty(bidInfo.getCreativePath()) ? bidInfo.getCreativePath().trim() : appendUrlParams(bidInfo.getCreativeUrl().trim(), "ykVideoShowType=2");
                if (TextUtils.isEmpty(trim)) {
                    TLogUtil.flowLog(this.mPlayInfo.getPlayParams().getSessionId(), "广告url为空");
                } else {
                    systemPeriod.addSource(new SystemSource(trim, bidInfo.getDuration()));
                }
            }
        }
        return systemPeriod;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.youku.alixplayer.instances.System.model.SystemPeriod buildPlaylistByBitStream(com.youku.playerservice.axp.item.BitStream r13) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.mediasource.SystemUpsMediaSource.buildPlaylistByBitStream(com.youku.playerservice.axp.item.BitStream):com.youku.alixplayer.instances.System.model.SystemPeriod");
    }

    public SystemPeriod buildPreVideo() {
        PreVideoSegs preVideoSegs;
        PlayInfo playInfo = this.mPlayInfo;
        if (playInfo == null || playInfo.getPlayInfoResponse() == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo() == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getPreVideoStream() == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getPreVideoStream().stream == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getPreVideoStream().stream.length <= 0 || (preVideoSegs = this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getPreVideoStream().stream[0].segs[0]) == null || TextUtils.isEmpty(preVideoSegs.cdn_url)) {
            return null;
        }
        SystemPeriod systemPeriod = new SystemPeriod();
        systemPeriod.setType(2);
        systemPeriod.setStartTime(0L);
        systemPeriod.addSource(new SystemSource(appendUrlParams(preVideoSegs.cdn_url.trim(), "ykVideoShowType=3")));
        return systemPeriod;
    }

    @Override // com.youku.playerservice.axp.mediasource.BaseMediaSource
    public PlayInfo getPlayInfo() {
        return this.mPlayInfo;
    }

    @Override // com.youku.playerservice.axp.mediasource.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public String getSourceKey() {
        PlayInfo playInfo = this.mPlayInfo;
        return playInfo != null ? playInfo.getPlayId() : "";
    }

    @Override // com.youku.playerservice.axp.mediasource.BaseMediaSource, com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public void preparePlaylist() {
        VodItem vodItem = (VodItem) this.mPlayInfo.getPlayItem();
        Log.d("AndroidXPlayer", "preparePlaylist: vod item: " + vodItem);
        BitStream bitStream = vodItem.getBitStream();
        Log.d("AndroidXPlayer", "preparePlaylist: bit stream: " + bitStream);
        SystemPeriod buildPlaylistByBitStream = buildPlaylistByBitStream(bitStream);
        Log.d("AndroidXPlayer", "preparePlaylist: period: " + buildPlaylistByBitStream);
        if (buildPlaylistByBitStream == null) {
            Log.e("AndroidXPlayer", "preparePlaylist prepare failed!");
            notifyPlaylistFailed();
            return;
        }
        this.mPlayList = new SystemPlayList();
        SystemPeriod buildPlaylistByAdInfo = buildPlaylistByAdInfo();
        if (buildPlaylistByAdInfo != null) {
            this.mPlayList.addPeriod(buildPlaylistByAdInfo);
        }
        SystemPeriod buildPreVideo = buildPreVideo();
        if (buildPreVideo != null) {
            this.mPlayList.addPeriod(buildPreVideo);
        }
        this.mPlayList.addPeriod(buildPlaylistByBitStream);
        String sessionId = this.mPlayInfo.getPlayParams().getSessionId();
        TLogUtil.flowLog(sessionId, "设置播放地址 ups");
        printPlaylist(sessionId, this.mPlayList);
        notifyPlaylistPrepared(this.mPlayList);
    }

    protected void printPlaylist(String str, IPlaylist iPlaylist) {
        List periodList = iPlaylist.getPeriodList();
        for (int i = 0; i < periodList.size(); i++) {
            SystemPeriod systemPeriod = (SystemPeriod) periodList.get(i);
            TLogUtil.flowLog(str, "period index=" + i + " type=" + systemPeriod.getType() + StringUtils.LF);
            StringBuilder sb = new StringBuilder();
            sb.append("header:");
            sb.append(systemPeriod.getAllHeaders());
            sb.append(StringUtils.LF);
            TLogUtil.flowLog(str, sb.toString());
            List<SystemSource> sourceList = systemPeriod.getSourceList();
            for (int i2 = 0; i2 < sourceList.size(); i2++) {
                TLogUtil.flowLog(str, "source index=" + i2 + " " + sourceList.get(i2) + StringUtils.LF);
            }
        }
    }

    public int switchDataSource(VodItem vodItem, long j) {
        if (this.mPlayList == null) {
            TLogUtil.flowLog(vodItem.getPlayParams().getSessionId(), "切换清晰度的时候没有Playlist");
            return 404;
        }
        BitStream bitStream = vodItem.getBitStream();
        String drmKey = bitStream.getDrmKey();
        SystemPeriod buildPlaylistByBitStream = buildPlaylistByBitStream(bitStream);
        buildPlaylistByBitStream.setStartTime(j);
        buildPlaylistByBitStream.setDrmKey(drmKey);
        switchDataSource(buildPlaylistByBitStream);
        return 0;
    }

    @Override // com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSourceExt
    public boolean useRaphaelPlayer() {
        return false;
    }
}
