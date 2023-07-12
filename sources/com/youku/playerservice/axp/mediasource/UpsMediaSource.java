package com.youku.playerservice.axp.mediasource;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.taobao.weex.common.Constants;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Source;
import com.youku.alixplayer.util.NativeMap;
import com.youku.arch.solid.SolidServer;
import com.youku.arch.solid.Status;
import com.youku.arch.solid.lifecycle.SolidRequest;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.player.init.PlayerSuperSolutionMananger;
import com.youku.playerservice.axp.cache.CacheManager;
import com.youku.playerservice.axp.definition.FirstSliceCode;
import com.youku.playerservice.axp.dof.DoFConfigManager;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.item.VodItem;
import com.youku.playerservice.axp.p2p.P2pManager;
import com.youku.playerservice.axp.p2p.PcdnType;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.playinfo.Point;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.PlaylistUtil;
import com.youku.playerservice.axp.utils.SystemUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playerservice.axp.utils.Utils;
import com.youku.upsplayer.module.Fs;
import com.youku.upsplayer.module.PreVideoSegs;
import com.youku.vpm.constants.TableField;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class UpsMediaSource extends AxpMediaSource {
    private static final String TAG = "UpsMediaSource";

    public UpsMediaSource(Context context, PlayInfo playInfo) {
        super(context, playInfo);
    }

    private boolean buildDofHeader(NativeMap nativeMap, BitStream bitStream, PlayInfoUpsResponse playInfoUpsResponse) {
        String str;
        String str2;
        String config = ConfigFetcher.getInstance().getConfig("fvv_config", "spe_stream_max_buffer_size", "-1");
        if (!"-1".equalsIgnoreCase(config)) {
            nativeMap.put("spe_stream_max_buffer_size", config);
            Logger.d(TAG, "builder 6dof header [spe_stream_max_buffer_size] = [" + config + jn1.ARRAY_END_STR);
        }
        boolean z = false;
        if (bitStream.getQuality() != Quality.AUTO) {
            String dofConfigFile = bitStream.getDofConfigFile();
            if (!TextUtils.isEmpty(dofConfigFile)) {
                bitStream.putString("hasDof", "1");
                String filePath = DoFConfigManager.getFilePath(this.mContext, dofConfigFile);
                if (TextUtils.isEmpty(filePath) || !new File(filePath).exists()) {
                    z = true;
                } else {
                    bitStream.putString(dofConfigFile, filePath);
                    nativeMap.put("sixdof_cfg_path", filePath);
                }
            }
            return !z;
        }
        for (BitStream bitStream2 : playInfoUpsResponse.getBitStreamList()) {
            String dofConfigFile2 = bitStream2.getDofConfigFile();
            if (!TextUtils.isEmpty(dofConfigFile2)) {
                String filePath2 = DoFConfigManager.getFilePath(this.mContext, dofConfigFile2);
                bitStream.putString("hasDof", "1");
                if (TextUtils.isEmpty(filePath2) || !new File(filePath2).exists()) {
                    z = true;
                } else {
                    bitStream.putString(dofConfigFile2, filePath2);
                    if (bitStream2.getStreamType().contains("hls5hd_6dof_")) {
                        nativeMap.put("sixdof_hd_config", filePath2);
                        nativeMap.put("sixdof_hd_width", bitStream2.getWidth() + "");
                        str = bitStream2.getHeight() + "";
                        str2 = "sixdof_hd_height";
                    } else if (bitStream2.getStreamType().contains("hls5hd2_6dof_")) {
                        nativeMap.put("sixdof_hd2_config", filePath2);
                        nativeMap.put("sixdof_hd2_width", bitStream2.getWidth() + "");
                        str = bitStream2.getHeight() + "";
                        str2 = "sixdof_hd2_height";
                    }
                    nativeMap.put(str2, str);
                }
            }
        }
        return !z;
    }

    private void buildFsSlice(Period period, BitStream bitStream, PlayInfoUpsResponse playInfoUpsResponse, long j, String str, String str2, boolean z) {
        PlayInfo playInfo;
        String str3;
        PlayInfo playInfo2;
        String str4;
        if ("1".equals(str) && Constants.Value.PLAY.equals(str2)) {
            Fs fs = bitStream.getFs();
            if (fs == null) {
                if (bitStream.getFsError() != null) {
                    playInfo = this.mPlayInfo;
                    str3 = bitStream.getFsError().code;
                } else {
                    playInfo = this.mPlayInfo;
                    str3 = FirstSliceCode.FS_NULL;
                }
                playInfo.putString(TableField.USE_FIRST_SLICE, str3);
                return;
            }
            if (Math.abs(j - fs.slice_pos) > Integer.parseInt(ConfigFetcher.getInstance().getConfig("axp_fs_slice_config", "history_position_gap_slice", "15")) * 1000) {
                playInfo2 = this.mPlayInfo;
                str4 = "-2";
            } else if (z) {
                playInfo2 = this.mPlayInfo;
                str4 = "-1";
            } else if (!playInfoUpsResponse.hasVideoFeature(Point.FVV_TIPS)) {
                if (fs.slice_pos == 0) {
                    this.mPlayInfo.putString(TableField.USE_FIRST_SLICE, "0");
                } else {
                    this.mPlayInfo.putString(TableField.USE_FIRST_SLICE, "1");
                }
                if (ApsUtil.enableVodSliceDown()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(CacheManager.SLICE_ID, fs.sequence_num + "");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(fs.slice_url);
                    String preloadKey = CacheManager.getInstance().getPreloadKey();
                    String sessionId = this.mPlayInfo.getPlayParams().getSessionId();
                    TLogUtil.flowLog(sessionId, "首分片网络预下载 slice_id=" + fs.sequence_num + " url=" + fs.slice_url);
                    CacheManager.getInstance().preloadMediaSourceWithUrls(preloadKey, this.mContext, arrayList, hashMap, null);
                }
                String drmKey = bitStream.getDrmKey();
                if (!"copyrightDRM".equalsIgnoreCase(fs.drm_type)) {
                    drmKey = "NULL";
                }
                period.addHeader("start ts parameters", PlaylistUtil.constructTsParams(fs.slice_pos, fs.sequence_num.longValue(), fs.slice_size, fs.slice_duration / 1000, fs.discontinue_num.longValue(), fs.stream_type, bitStream.getDuration() * 1000, drmKey));
                period.addHeader("player_source", "5");
                period.addSource(new Source(fs.slice_url, fs.slice_duration / 1000.0d));
                period.setMediaType(0);
            } else {
                playInfo2 = this.mPlayInfo;
                str4 = FirstSliceCode.FVV;
            }
            playInfo2.putString(TableField.USE_FIRST_SLICE, str4);
        }
    }

    private void buildPlayerSource(NativeMap nativeMap, BitStream bitStream, PlayInfo playInfo) {
        int i = 10;
        if (bitStream.getQuality() != Quality.HD3_HBR && bitStream.getQuality() != Quality.AUTO) {
            i = 0;
        }
        if ("5".equals(this.mPlayerConfig.getString(TableField.PLAYER_SOURCE))) {
            nativeMap.put("player_source", "8");
        }
        if (i > 0) {
            nativeMap.put("player_source", i + "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.youku.alixplayer.model.Period buildPlaylistByBitStream(com.youku.playerservice.axp.item.BitStream r22, boolean r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 1089
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.mediasource.UpsMediaSource.buildPlaylistByBitStream(com.youku.playerservice.axp.item.BitStream, boolean, java.lang.String):com.youku.alixplayer.model.Period");
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "1.0.0";
        }
    }

    private void setSuperResolutionParamsForHeader(NativeMap nativeMap, boolean z, BitStream bitStream, PlayParams playParams) {
        String str;
        if (Utils.isYoukuOrHuaweiBaipai(this.mContext) && ApsUtil.enableAxpSuperResolution() && z) {
            boolean supportSRDeivce = supportSRDeivce(this.mContext);
            boolean supportSuperResolutionCurrentQuality = supportSuperResolutionCurrentQuality(bitStream);
            boolean superResolutionFilesIsExists = superResolutionFilesIsExists();
            boolean z2 = true;
            String str2 = "-1";
            if (playParams != null && playParams.getString("superResolution") != null && playParams.getString("superResolution").equals("-1")) {
                z2 = false;
            }
            if (supportSRDeivce && supportSuperResolutionCurrentQuality && superResolutionFilesIsExists && z2) {
                str2 = "1";
            }
            String str3 = "";
            if (str2.equals("1")) {
                String path = this.mContext.getFilesDir().getPath();
                str3 = path + "/solid-" + getVersionName(this.mContext);
                str = path + "/YKSRConfig/YKSRFiles";
            } else {
                str = "";
            }
            nativeMap.put("cvfilter_run_mode", str2);
            nativeMap.put("cvfilter_so_path", str3);
            nativeMap.put("cvfilter_config_path", str);
        }
    }

    public static boolean supportSRDeivce(Context context) {
        String cpuName = Utils.getCpuName(context);
        String hiAiVersion = SystemUtil.getHiAiVersion();
        return (cpuName.equals("kirin9000") || cpuName.equals("kirin9000E") || cpuName.equals("kirin990") || cpuName.equals("kirin990E")) ? hiAiVersion.compareTo("100.320.010.045") >= 0 : cpuName.equals("kirin980") && hiAiVersion.compareTo("100.210.010.010") >= 0;
    }

    private void switchDataSource(Period period) {
        for (int i = 0; i < this.mPlayList.getPeriodList().size(); i++) {
            if (((Period) this.mPlayList.getPeriodList().get(i)).getType() == 0) {
                changePeriod(i, period);
            }
        }
        String sessionId = this.mPlayInfo.getPlayParams().getSessionId();
        TLogUtil.flowLog(sessionId, "切换播放地址 ups");
        printPlaylist(sessionId, this.mPlayList);
    }

    public Period buildPreVideo() {
        PreVideoSegs preVideoSegs;
        PlayInfo playInfo = this.mPlayInfo;
        if (playInfo == null || playInfo.getPlayInfoResponse() == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo() == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getPreVideoStream() == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getPreVideoStream().stream == null || this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getPreVideoStream().stream.length <= 0 || (preVideoSegs = this.mPlayInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getPreVideoStream().stream[0].segs[0]) == null || TextUtils.isEmpty(preVideoSegs.cdn_url)) {
            return null;
        }
        Period period = new Period();
        period.setType(2);
        period.setStartTime(0L);
        String appendUrlParams = appendUrlParams(preVideoSegs.cdn_url.trim(), "ykVideoShowType=3");
        if (Utils.isYoukuOrHuaweiBaipai(this.mContext)) {
            appendUrlParams = P2pManager.getInstance(this.mContext.getApplicationContext()).getPcdnUrl(this.mContext, PcdnType.VOD, appendUrlParams, null).finalUrl;
        }
        if (!TextUtils.isEmpty(appendUrlParams)) {
            period.addSource(new Source(appendUrlParams));
        }
        if (period.getSourceList().size() == 0) {
            return null;
        }
        return period;
    }

    @Override // com.youku.playerservice.axp.mediasource.AxpMediaSource, com.youku.playerservice.axp.mediasource.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public String getSourceKey() {
        PlayInfo playInfo = this.mPlayInfo;
        return playInfo != null ? playInfo.getPlayId() : "";
    }

    @Override // com.youku.playerservice.axp.mediasource.AxpMediaSource, com.youku.playerservice.axp.mediasource.BaseMediaSource, com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public void preparePlaylist() {
        super.preparePlaylist();
        Period buildPlaylistByAdInfo = buildPlaylistByAdInfo();
        if (buildPlaylistByAdInfo != null) {
            this.mPlayList.addPeriod(buildPlaylistByAdInfo);
        }
        Period buildPreVideo = buildPreVideo();
        if (buildPreVideo != null) {
            this.mPlayList.addPeriod(buildPreVideo);
        }
        Period buildPlaylistByBitStream = buildPlaylistByBitStream(((VodItem) this.mPlayInfo.getPlayItem()).getBitStream(), (buildPlaylistByAdInfo == null && buildPreVideo == null) ? false : true, Constants.Value.PLAY);
        if (buildPlaylistByBitStream == null) {
            notifyPlaylistFailed();
            return;
        }
        this.mPlayList.addPeriod(buildPlaylistByBitStream);
        String sessionId = this.mPlayInfo.getPlayParams().getSessionId();
        TLogUtil.flowLog(sessionId, "设置播放地址 ups");
        printPlaylist(sessionId, this.mPlayList);
        notifyPlaylistPrepared(this.mPlayList);
    }

    boolean superResolutionConfigFilesIsExists() {
        PlayerSuperSolutionMananger.getInstance();
        return PlayerSuperSolutionMananger.isSRConfigFilesReady();
    }

    boolean superResolutionFilesIsExists() {
        return superResolutionConfigFilesIsExists() && superResolutionSOFilesIsExists();
    }

    boolean superResolutionSOFilesIsExists() {
        try {
            SolidRequest solidRequest = new SolidRequest();
            solidRequest.name = "SuperResolution";
            return SolidServer.checkSoGroupStatus(solidRequest) == Status.DOWNLOADED;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean supportSuperResolutionCurrentQuality(BitStream bitStream) {
        Quality quality = bitStream.getQuality();
        return quality == Quality.HD || quality == Quality.SD || quality == Quality.HD3GP;
    }

    public int switchDataSource(VodItem vodItem, long j) {
        if (this.mPlayList == null) {
            TLogUtil.flowLog(vodItem.getPlayParams().getSessionId(), "切换清晰度的时候没有Playlist");
            return 404;
        }
        BitStream bitStream = vodItem.getBitStream();
        String drmKey = bitStream.getDrmKey();
        Period buildPlaylistByBitStream = buildPlaylistByBitStream(bitStream, false, "switch");
        buildPlaylistByBitStream.setStartTime(j);
        buildPlaylistByBitStream.setDrmKey(drmKey);
        switchDataSource(buildPlaylistByBitStream);
        return 0;
    }
}
