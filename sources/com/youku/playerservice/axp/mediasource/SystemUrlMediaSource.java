package com.youku.playerservice.axp.mediasource;

import android.content.Context;
import android.text.TextUtils;
import com.youku.alixplayer.IPlaylist;
import com.youku.alixplayer.instances.System.model.SystemPeriod;
import com.youku.alixplayer.instances.System.model.SystemPlayList;
import com.youku.alixplayer.instances.System.model.SystemSource;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.TLogUtil;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SystemUrlMediaSource extends BaseMediaSource {
    private static final String TAG = "SystemUrlMediaSource";
    private Context mContext;
    private PlayInfo mPlayInfo;
    private PlayerConfig mPlayerConfig;
    private String mUrl;

    public SystemUrlMediaSource(Context context, PlayInfo playInfo) {
        this.mContext = context;
        this.mPlayInfo = playInfo;
        this.mPlayerConfig = playInfo.getPlayerConfig();
    }

    @Override // com.youku.playerservice.axp.mediasource.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public String getSourceKey() {
        PlayInfo playInfo = this.mPlayInfo;
        return (playInfo == null || playInfo.getPlayItem() == null) ? "" : this.mPlayInfo.getPlayItem().getPlayUrl();
    }

    @Override // com.youku.playerservice.axp.mediasource.BaseMediaSource, com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public void preparePlaylist() {
        if (this.mPlayInfo == null) {
            notifyPlaylistFailed();
            return;
        }
        SystemPeriod systemPeriod = new SystemPeriod();
        this.mUrl = getSourceKey();
        HashMap hashMap = new HashMap();
        hashMap.put("datasource_live_type", "0");
        PlayerConfig playerConfig = this.mPlayerConfig;
        if (playerConfig != null) {
            String string = playerConfig.getString("hardwareDecode");
            if (!TextUtils.isEmpty(string)) {
                hashMap.put("source force hardware decode", string);
            }
            if (!this.mUrl.startsWith("http")) {
                hashMap.put("datasource_local_type", "1");
                hashMap.put("player_source", "1");
            }
            String string2 = this.mPlayerConfig.getString("uplayer_buffertime_before_play");
            if (!TextUtils.isEmpty(string2)) {
                hashMap.put("uplayer_buffertime_before_play", string2);
            }
            String string3 = this.mPlayerConfig.getString("uplayer_buffertime_playing");
            if (!TextUtils.isEmpty(string3)) {
                hashMap.put("uplayer_buffertime_playing", string3);
            }
            String string4 = this.mPlayerConfig.getString("downloader_http_header");
            Logger.d(TAG, "preparePlaylist token : " + string4);
            if (!TextUtils.isEmpty(string4)) {
                hashMap.put("downloader_http_header", string4);
            }
        }
        if (this.mPlayInfo.getPlayParams() != null) {
            long startTime = this.mPlayInfo.getPlayParams().getStartTime();
            if (startTime < 0) {
                startTime = 0;
            }
            systemPeriod.setStartTime(startTime);
        }
        systemPeriod.setHeader(hashMap);
        systemPeriod.setMixedCodec(false);
        systemPeriod.addSource(new SystemSource(this.mUrl));
        this.mPlayList = new SystemPlayList();
        super.preparePlaylist();
        IPlaylist iPlaylist = this.mPlayList;
        if (iPlaylist != null) {
            iPlaylist.addPeriod(systemPeriod);
            if (this.mPlayInfo.getPlayParams() != null) {
                printPlaylist(this.mPlayInfo.getPlayParams().getSessionId(), this.mPlayList);
            }
            notifyPlaylistPrepared(this.mPlayList);
        }
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
}
