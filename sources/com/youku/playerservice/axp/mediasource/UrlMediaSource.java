package com.youku.playerservice.axp.mediasource;

import android.content.Context;
import android.text.TextUtils;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Source;
import com.youku.alixplayer.util.NativeMap;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.utils.Logger;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class UrlMediaSource extends AxpMediaSource {
    private static final String TAG = "UrlMediaSource";
    private Context mContext;
    private PlayInfo mPlayInfo;
    private PlayerConfig mPlayerConfig;

    public UrlMediaSource(Context context, PlayInfo playInfo) {
        super(context, playInfo);
        this.mContext = context;
        this.mPlayInfo = playInfo;
        this.mPlayerConfig = playInfo.getPlayerConfig();
    }

    @Override // com.youku.playerservice.axp.mediasource.AxpMediaSource, com.youku.playerservice.axp.mediasource.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public String getSourceKey() {
        PlayInfo playInfo = this.mPlayInfo;
        return playInfo != null ? playInfo.getPlayItem().getPlayUrl() : "";
    }

    @Override // com.youku.playerservice.axp.mediasource.AxpMediaSource, com.youku.playerservice.axp.mediasource.BaseMediaSource, com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public void preparePlaylist() {
        if (this.mPlayInfo == null) {
            notifyPlaylistFailed();
            return;
        }
        Period period = new Period();
        NativeMap nativeMap = new NativeMap();
        nativeMap.put("datasource_live_type", "0");
        String string = this.mPlayerConfig.getString("hardwareDecode");
        if (!TextUtils.isEmpty(string)) {
            nativeMap.put("source force hardware decode", string);
        }
        String sourceKey = getSourceKey();
        if (!sourceKey.startsWith("http")) {
            nativeMap.put("datasource_local_type", "1");
            nativeMap.put("player_source", "1");
        }
        String string2 = this.mPlayerConfig.getString("uplayer_buffertime_before_play");
        if (!TextUtils.isEmpty(string2)) {
            nativeMap.put("uplayer_buffertime_before_play", string2);
        }
        String string3 = this.mPlayerConfig.getString("uplayer_buffertime_playing");
        if (!TextUtils.isEmpty(string3)) {
            nativeMap.put("uplayer_buffertime_playing", string3);
        }
        String string4 = this.mPlayerConfig.getString("downloader_http_header");
        Logger.d(TAG, "preparePlaylist token : " + string4);
        if (!TextUtils.isEmpty(string4)) {
            nativeMap.put("downloader_http_header", string4);
        }
        long startTime = this.mPlayInfo.getPlayParams().getStartTime();
        if (startTime < 0) {
            startTime = 0;
        }
        period.setStartTime(startTime);
        period.setHeader(nativeMap);
        period.setMixedCodec(false);
        period.addSource(new Source(sourceKey));
        super.preparePlaylist();
        this.mPlayList.addPeriod(period);
        notifyPlaylistPrepared(this.mPlayList);
    }
}
