package com.youku.playerservice.axp.playinfo.request;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.middlewareservice.provider.videodownload.DownloadManagerProviderProxy;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.item.CacheBitStream;
import com.youku.playerservice.axp.item.Codec;
import com.youku.playerservice.axp.item.MediaMap;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.item.StreamSegItem;
import com.youku.playerservice.axp.playinfo.CacheUpsInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.playparams.PlayIdParams;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.thread.CacheWorkThread;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.service.download.DownloadInfo;
import com.youku.service.download.DownloadInfoOuter;
import com.youku.service.download.SubtitleInfo;
import com.youku.upsplayer.module.Stream;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.util.YoukuUtil;
import com.youku.vip.info.VipUserService;
import com.youku.xadsdk.playerad.model.PlayerVideoInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class CacheRequest implements IPlayInfoRequest {
    public static final String TAG = "CacheRequest";
    protected IPlayInfoRequest.Callback mCallback;
    protected Context mContext;
    protected volatile boolean mIsCancel;
    protected PlayParams mPlayParams;
    protected PlayerConfig mPlayerConfig;
    private List<PlayInfoResponse> mResponses;
    private IPlayInfoRequest.State mState = IPlayInfoRequest.State.IDLE;
    private volatile boolean mRequestDone = false;
    protected final Handler mHandler = new Handler(CacheWorkThread.getLooper());

    public CacheRequest(Context context, PlayerConfig playerConfig) {
        this.mContext = context;
        this.mPlayerConfig = playerConfig;
        this.mPlayerConfig = playerConfig;
    }

    private int constructBitStream(DownloadInfoOuter downloadInfoOuter, VideoInfo videoInfo, PlayInfoUpsResponse playInfoUpsResponse) {
        Quality qualityByCode;
        Codec codec;
        int i;
        String language;
        PlayDefinition.PlayFormat playFormat;
        String str;
        String streamType = downloadInfoOuter.getStreamType();
        MediaMap.MediaFormat media = MediaMap.getMedia(streamType);
        Stream stream = getStream(videoInfo, streamType);
        if (media == null || stream == null) {
            qualityByCode = Quality.getQualityByCode(downloadInfoOuter.getFormat());
            codec = downloadInfoOuter.isH265() ? Codec.H265 : Codec.H264;
            i = downloadInfoOuter.seconds * 1000;
            language = downloadInfoOuter.getLanguage();
        } else {
            qualityByCode = media.getQuality();
            codec = media.getCodec();
            i = stream.milliseconds_video;
            language = stream.audio_lang;
        }
        CacheBitStream cacheBitStream = new CacheBitStream(qualityByCode, streamType, codec, i);
        cacheBitStream.setDownloadType(CacheBitStream.DownloadType.FINISH);
        cacheBitStream.setLangCode(language);
        cacheBitStream.putString("downloadType", downloadInfoOuter.getDownloadType() + "");
        playInfoUpsResponse.getPlayParams().putString("downloadType", downloadInfoOuter.getDownloadType() + "");
        if (this.mPlayParams.getPlayIdParams().getRequestQuality() != qualityByCode) {
            TLogUtil.flowLog(this.mPlayParams.getSessionId(), "起播清晰度与缓存清晰度不同，优先使用缓存清晰度 " + qualityByCode);
            this.mPlayParams.getPlayIdParams().setRequestQuality(qualityByCode);
            this.mPlayParams.getPlayIdParams().setLanguageCode(language);
        }
        playInfoUpsResponse.setCacheInfo(new CacheUpsInfo(cacheBitStream, videoInfo, downloadInfoOuter));
        if (LiveManager.StreamConfig.FORMAT_HLS.equals(downloadInfoOuter.getFile_format())) {
            String m3u8Uri = downloadInfoOuter.getM3u8Uri();
            if (downloadInfoOuter.getDownloadType() == 1) {
                if (TextUtils.isEmpty(m3u8Uri)) {
                    return 51001;
                }
                if ("1".equals(ConfigFetcher.getInstance().getConfig("player_switch", "enable_pcdn_check", "1"))) {
                    String PCDNCheckCompletion = DownloadManagerProviderProxy.PCDNCheckCompletion(playInfoUpsResponse.getPlayId(), 1);
                    int parseInt = TextUtils.isEmpty(PCDNCheckCompletion) ? 0 : TextUtils.isDigitsOnly(PCDNCheckCompletion) ? Integer.parseInt(PCDNCheckCompletion) : 1;
                    int i2 = parseInt & 2;
                    if ((parseInt & 8) != 0) {
                        return 51003;
                    }
                    if (i2 != 0) {
                        return 51002;
                    }
                }
            } else if (!new File(m3u8Uri).exists() && !DownloadManagerProviderProxy.playfix(downloadInfoOuter, 2)) {
                return 50005;
            } else {
                if (!new File(m3u8Uri).exists()) {
                    TLogUtil.playLog("CacheRequest playlist修复后还是为空");
                    return 50003;
                }
            }
            cacheBitStream.setM3u8Url(m3u8Uri);
            playFormat = PlayDefinition.PlayFormat.HLS;
        } else if (downloadInfoOuter.getSegInfos() == null || downloadInfoOuter.getSegInfos().isEmpty()) {
            return 50003;
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = downloadInfoOuter.getSegInfos().iterator();
            while (it.hasNext()) {
                DownloadInfo.SegInfo segInfo = (DownloadInfo.SegInfo) it.next();
                long j = (long) (segInfo.seconds * 1000.0d);
                if (downloadInfoOuter.getDownloadType() == 1) {
                    str = segInfo.url;
                } else {
                    str = downloadInfoOuter.getSavePath() + segInfo.id;
                }
                StreamSegItem streamSegItem = new StreamSegItem(str, (int) j);
                streamSegItem.setAd(segInfo.isAd ? 1 : 0);
                streamSegItem.setFileSize(segInfo.size);
                arrayList.add(streamSegItem);
            }
            cacheBitStream.setStreamSegList(arrayList);
            playFormat = PlayDefinition.PlayFormat.MP4;
        }
        cacheBitStream.setPlayFormat(playFormat);
        constructSubtitle(downloadInfoOuter, cacheBitStream);
        String playId = this.mPlayParams.getPlayIdParams().getPlayId();
        if ("copyrightDRM".equalsIgnoreCase(downloadInfoOuter.drm_type)) {
            if (TextUtils.isEmpty(DownloadManagerProviderProxy.getCacheDRMKey(this.mContext, playId)) && YoukuUtil.hasInternet()) {
                TLogUtil.playLog("CacheRequest drmKey为空，开始进行修复");
                if (!DownloadManagerProviderProxy.playfix(downloadInfoOuter, 1)) {
                    return 50006;
                }
            }
            String cacheDRMKey = DownloadManagerProviderProxy.getCacheDRMKey(this.mContext, playId);
            if (TextUtils.isEmpty(cacheDRMKey)) {
                TLogUtil.playLog("CacheRequest drmKey修复后还是为空");
                return 50004;
            }
            cacheBitStream.setDrmKey(cacheDRMKey);
            cacheBitStream.setDrmType(downloadInfoOuter.drm_type);
        }
        return 0;
    }

    private void constructSubtitle(DownloadInfoOuter downloadInfoOuter, BitStream bitStream) {
        SubtitleInfo subtitleInfo;
        bitStream.putString("enableSubtitle", downloadInfoOuter.isShowSubtitle() ? "1" : "0");
        if (downloadInfoOuter.subtitlesList == null || downloadInfoOuter.subtitlesList.size() <= 0) {
            return;
        }
        SubtitleInfo subtitleInfo2 = (SubtitleInfo) downloadInfoOuter.subtitlesList.get(0);
        if (subtitleInfo2 != null) {
            File file = new File(subtitleInfo2.getSavePath());
            if (!file.exists()) {
                TLogUtil.playLog("字幕0文件不存在，进行修复");
                this.mPlayParams.putString("subtitleFail", "0号字幕修复");
                if (YoukuUtil.hasInternet()) {
                    if (!DownloadManagerProviderProxy.playfix(downloadInfoOuter, 3)) {
                        TLogUtil.playLog("字幕0文件不存在，修复失败");
                        this.mPlayParams.putString("subtitleFail", "0号字幕修复失败");
                    }
                }
            }
            bitStream.putString("firstSubtitleUrl", file.getAbsolutePath());
        }
        if (downloadInfoOuter.subtitlesList.size() < 2 || (subtitleInfo = (SubtitleInfo) downloadInfoOuter.subtitlesList.get(1)) == null) {
            return;
        }
        File file2 = new File(subtitleInfo.getSavePath());
        if (file2.exists()) {
            bitStream.putString("secondSubtitleUrl", file2.getAbsolutePath());
        } else {
            TLogUtil.playLog("字幕1文件不存在");
        }
    }

    private PlayerVideoInfo createPlayerVideoInfo(Context context, PlayParams playParams) {
        PlayerVideoInfo playerVideoInfo = new PlayerVideoInfo();
        playerVideoInfo.setVip(VipUserService.getInstance().isVip());
        playerVideoInfo.setQuality("auto");
        playerVideoInfo.setVideoMode(0);
        playerVideoInfo.setIsOffline(true);
        playerVideoInfo.setVideoId(playParams.getPlayIdParams().getPlayId());
        playerVideoInfo.setStreamType(0);
        return playerVideoInfo;
    }

    private Stream getStream(VideoInfo videoInfo, String str) {
        Stream[] stream;
        if (videoInfo == null || videoInfo.getStream() == null) {
            return null;
        }
        for (Stream stream2 : videoInfo.getStream()) {
            if (str != null && str.equals(stream2.stream_type)) {
                return stream2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handle() {
        /*
            r6 = this;
            boolean r0 = r6.mIsCancel
            if (r0 == 0) goto L5
            return
        L5:
            com.youku.playerservice.axp.playparams.PlayParams r0 = r6.mPlayParams
            com.youku.playerservice.axp.playparams.PlayIdParams r0 = r0.getPlayIdParams()
            java.lang.String r0 = r0.getPlayId()
            com.youku.service.download.DownloadInfoOuter r0 = com.youku.middlewareservice.provider.videodownload.DownloadManagerProviderProxy.getDownloadInfoOuter(r0)
            com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse r1 = new com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse
            android.content.Context r2 = r6.mContext
            com.youku.playerservice.axp.playparams.PlayParams r3 = r6.mPlayParams
            r1.<init>(r2, r3)
            com.youku.playerservice.axp.axpinterface.PlayDefinition$PlayInfoType r2 = com.youku.playerservice.axp.axpinterface.PlayDefinition.PlayInfoType.LOCAL
            r1.setInfoType(r2)
            if (r0 != 0) goto L3a
            com.youku.playerservice.axp.playinfo.PlayInfoError r0 = new com.youku.playerservice.axp.playinfo.PlayInfoError
            r0.<init>()
            r2 = 50002(0xc352, float:7.0068E-41)
            r0.setErrorCode(r2)
            com.youku.playerservice.axp.playinfo.PlayInfoError r0 = new com.youku.playerservice.axp.playinfo.PlayInfoError
            r0.<init>()
        L33:
            r1.setError(r0)
            r6.reportResult(r1)
            return
        L3a:
            java.lang.String r2 = "downloadInfo"
            r1.setProperties(r2, r0)
            java.lang.String r2 = r0.getDownloadVersionName()
            long r3 = r0.getCreateTime()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            com.youku.playerservice.axp.playparams.PlayParams r4 = r6.mPlayParams
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            java.lang.String r3 = ""
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.String r5 = "downloadCreateTime"
            r4.putString(r5, r3)
            com.youku.playerservice.axp.playparams.PlayParams r3 = r6.mPlayParams
            java.lang.String r4 = "downloadVersionName"
            r3.putString(r4, r2)
            java.lang.String r2 = r0.getUpsSnapshot()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r4 = "cacheUpsError"
            r5 = 0
            if (r3 != 0) goto Laa
            java.lang.Class<com.youku.upsplayer.ParseResult$UpsResult> r3 = com.youku.upsplayer.ParseResult.UpsResult.class
            java.lang.Object r2 = com.alibaba.fastjson.JSON.parseObject(r2, r3)     // Catch: java.lang.Exception -> L94
            com.youku.upsplayer.ParseResult$UpsResult r2 = (com.youku.upsplayer.ParseResult.UpsResult) r2     // Catch: java.lang.Exception -> L94
            com.youku.upsplayer.module.VideoInfo r3 = new com.youku.upsplayer.module.VideoInfo     // Catch: java.lang.Exception -> L94
            r3.<init>()     // Catch: java.lang.Exception -> L94
            r2.apply(r3)     // Catch: java.lang.Exception -> L94
            com.alibaba.fastjson.JSONArray r2 = r3.getStreamJson()     // Catch: java.lang.Exception -> L94
            com.youku.upsplayer.module.Stream[] r2 = com.youku.upsplayer.ParseResult.parseStream(r2)     // Catch: java.lang.Exception -> L94
            r3.setStream(r2)     // Catch: java.lang.Exception -> L94
            r5 = r3
            goto Lb1
        L94:
            r2 = move-exception
            r2.printStackTrace()
            com.youku.playerservice.axp.playparams.PlayParams r3 = r6.mPlayParams
            java.lang.String r3 = r3.getSessionId()
            java.lang.String r2 = r2.getMessage()
            com.youku.playerservice.axp.utils.TLogUtil.flowLog(r3, r2)
            com.youku.playerservice.axp.playparams.PlayParams r2 = r6.mPlayParams
            java.lang.String r3 = "2"
            goto Lae
        Laa:
            com.youku.playerservice.axp.playparams.PlayParams r2 = r6.mPlayParams
            java.lang.String r3 = "1"
        Lae:
            r2.putString(r4, r3)
        Lb1:
            int r0 = r6.constructBitStream(r0, r5, r1)
            if (r0 == 0) goto Lc6
            com.youku.playerservice.axp.playinfo.PlayInfoError r2 = new com.youku.playerservice.axp.playinfo.PlayInfoError
            r2.<init>()
            r2.setErrorCode(r0)
            com.youku.playerservice.axp.playinfo.PlayInfoError r0 = new com.youku.playerservice.axp.playinfo.PlayInfoError
            r0.<init>()
            goto L33
        Lc6:
            com.youku.vip.info.VipUserService r0 = com.youku.vip.info.VipUserService.getInstance()
            r2 = 100000(0x186a0, float:1.4013E-40)
            java.lang.String r3 = "10002"
            boolean r0 = r0.isPower(r2, r3)
            if (r0 == 0) goto Ld9
            r6.reportResult(r1)
            goto Lf5
        Ld9:
            android.content.Context r0 = r6.mContext
            com.youku.playerservice.axp.playparams.PlayParams r2 = r6.mPlayParams
            com.youku.xadsdk.playerad.model.PlayerVideoInfo r0 = r6.createPlayerVideoInfo(r0, r2)
            com.youku.playerservice.axp.playinfo.request.CacheRequest$2 r2 = new com.youku.playerservice.axp.playinfo.request.CacheRequest$2
            r2.<init>()
            com.youku.xadsdk.playerad.PlayerAdManager.getPreAd(r0, r2)
            android.os.Handler r0 = r6.mHandler
            com.youku.playerservice.axp.playinfo.request.CacheRequest$3 r2 = new com.youku.playerservice.axp.playinfo.request.CacheRequest$3
            r2.<init>()
            r3 = 300(0x12c, double:1.48E-321)
            r0.postDelayed(r2, r3)
        Lf5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.playinfo.request.CacheRequest.handle():void");
    }

    public static boolean hasCacheData(PlayParams playParams) {
        boolean z;
        PlayIdParams playIdParams = playParams.getPlayIdParams();
        boolean isDownLoaded = isDownLoaded(playIdParams);
        if (isDownLoaded || !playIdParams.isLocalPlay()) {
            z = false;
        } else {
            TLogUtil.flowLog(playParams.getSessionId(), "没有downloadInfo，但业务方仍然调用离线播放");
            z = true;
        }
        if (!isDownLoaded || playIdParams.isLocalPlay()) {
            return z;
        }
        TLogUtil.flowLog(playParams.getSessionId(), "播放器检查到有缓存视频，进行缓存播放");
        return true;
    }

    private static boolean isDownLoaded(PlayIdParams playIdParams) {
        String playId = playIdParams.getPlayId();
        String languageCode = playIdParams.getLanguageCode();
        DownloadInfoOuter downloadInfoOuter = DownloadManagerProviderProxy.getDownloadInfoOuter(playId);
        return downloadInfoOuter != null && downloadInfoOuter.getState() == 1 && ("default".equals(downloadInfoOuter.getLanguage()) || "default".equals(languageCode) || "".equals(languageCode) || "null".equals(languageCode) || languageCode == null || TextUtils.equals(languageCode, downloadInfoOuter.getLanguage()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNotifyOnce(PlayInfoResponse playInfoResponse) {
        if (this.mRequestDone) {
            return;
        }
        this.mRequestDone = true;
        reportResult(playInfoResponse);
    }

    private void reportResult(final PlayInfoResponse playInfoResponse) {
        this.mState = IPlayInfoRequest.State.FINISHED;
        this.mHandler.post(new Runnable() { // from class: com.youku.playerservice.axp.playinfo.request.CacheRequest.4
            @Override // java.lang.Runnable
            public void run() {
                CacheRequest cacheRequest = CacheRequest.this;
                if (cacheRequest.mCallback != null) {
                    cacheRequest.mResponses = new ArrayList();
                    CacheRequest.this.mResponses.add(playInfoResponse);
                    CacheRequest cacheRequest2 = CacheRequest.this;
                    cacheRequest2.mCallback.onFinished(cacheRequest2.mPlayParams, cacheRequest2.mResponses);
                }
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void cancel() {
        this.mIsCancel = true;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public List<PlayInfoResponse> getPlayInfoResponses() {
        return this.mResponses;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public PlayParams getPlayParams() {
        return this.mPlayParams;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public IPlayInfoRequest.State getState() {
        return this.mState;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void request(PlayParams playParams) {
        this.mState = IPlayInfoRequest.State.RUNNING;
        this.mPlayParams = playParams;
        this.mHandler.post(new Runnable() { // from class: com.youku.playerservice.axp.playinfo.request.CacheRequest.1
            @Override // java.lang.Runnable
            public void run() {
                CacheRequest.this.handle();
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void setRequestCallback(IPlayInfoRequest.Callback callback) {
        this.mCallback = callback;
    }
}
