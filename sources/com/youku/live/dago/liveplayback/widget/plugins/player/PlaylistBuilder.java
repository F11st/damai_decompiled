package com.youku.live.dago.liveplayback.widget.plugins.player;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.device.UTDevice;
import com.youku.alixplayer.model.LivePeriod;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Source;
import com.youku.alixplayer.opensdk.FileFormat;
import com.youku.alixplayer.opensdk.IPlaylistBuilder;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.live.LiveInfo;
import com.youku.alixplayer.opensdk.ups.data.BitStream;
import com.youku.alixplayer.opensdk.ups.data.Codec;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplayer.opensdk.ups.data.StreamSegItem;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.alixplayer.util.NativeMap;
import com.youku.android.liveservice.bean.BizType;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.android.liveservice.utils.DrmManager;
import com.youku.live.dago.liveplayback.ConfigUtils;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.plugin.p2p.P2pManager;
import com.youku.live.plugin.p2p.PcdnType;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PlaylistBuilder implements IPlaylistBuilder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private PlayerConfig mPlayerConfig;

    public PlaylistBuilder(Context context, PlayerConfig playerConfig) {
        this.mContext = context;
        this.mPlayerConfig = playerConfig;
    }

    private String appendUrlParams(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1359613030")) {
            return (String) ipChange.ipc$dispatch("-1359613030", new Object[]{this, str, str2});
        }
        if (str.contains("http://") || str.contains("https://")) {
            if (str.contains("?")) {
                return str + "&" + str2;
            }
            return str + "?" + str2;
        }
        return str;
    }

    private static boolean enablePursue(Context context, BizType bizType) {
        String[] split;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1949418449")) {
            return ((Boolean) ipChange.ipc$dispatch("-1949418449", new Object[]{context, bizType})).booleanValue();
        }
        String apsConfig = Utils.getApsConfig(context, "live_mediasource_config", "enable_pursue", "");
        if (!TextUtils.isEmpty(apsConfig) && (split = apsConfig.split(",")) != null) {
            for (String str : split) {
                boolean equalsIgnoreCase = str.equalsIgnoreCase(bizType.getValue());
                boolean equalsIgnoreCase2 = str.equalsIgnoreCase(bizType.getDescription());
                if (equalsIgnoreCase || equalsIgnoreCase2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.youku.alixplayer.opensdk.IPlaylistBuilder
    public Period buildPlaylistByBitStream(PlayVideoInfo playVideoInfo, BitStream bitStream, int i) throws RuntimeException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1966061846")) {
            return (Period) ipChange.ipc$dispatch("-1966061846", new Object[]{this, playVideoInfo, bitStream, Integer.valueOf(i)});
        }
        NativeMap nativeMap = new NativeMap();
        nativeMap.put("datasource_live_type", "0");
        nativeMap.put("resolution_level", String.valueOf(bitStream.getQuality()));
        nativeMap.put("source codec type", bitStream.getCodec() == Codec.H265 ? "2" : "1");
        nativeMap.put("source force hardware decode", this.mPlayerConfig.isUseHardwareDecode() ? "1" : "0");
        nativeMap.put("utdid_str", UTDevice.getUtdid(this.mContext));
        if (bitStream.getDrmKey() != null) {
            nativeMap.put("source drm key", bitStream.getDrmKey());
        }
        if (bitStream.getDrmType() != null) {
            nativeMap.put("source drm type", bitStream.getDrmType());
        }
        if (bitStream.getDrmLicenseUri() != null) {
            nativeMap.put("drm_license_url", bitStream.getDrmLicenseUri());
        }
        Quality quality = bitStream.getQuality();
        String m3u8Text = bitStream.getM3u8Text();
        String m3u8Url = bitStream.getM3u8Url();
        Period period = new Period();
        period.setHeader(nativeMap);
        period.setType(0);
        if (quality == Quality.AUTO) {
            period.setStartTime(i);
            period.addSource(new Source(m3u8Text, bitStream.getLength() / 1000.0f));
            return period;
        }
        if ("1".equals(bitStream.getFileFormat())) {
            period.setStartTime(i);
            period.addSource(new Source(m3u8Url, bitStream.getLength() / 1000.0f));
        } else {
            List<StreamSegItem> streamSegList = bitStream.getStreamSegList();
            period.setMixedCodec(false);
            period.setStartTime(i);
            for (int i2 = 0; streamSegList != null && i2 < streamSegList.size(); i2++) {
                StreamSegItem streamSegItem = streamSegList.get(i2);
                period.addSource(new Source(streamSegItem.getCDNUrl(), streamSegItem.getVideoLength()));
            }
        }
        return period;
    }

    @Override // com.youku.alixplayer.opensdk.IPlaylistBuilder
    public Period buildPlaylistByLiveInfo(PlayVideoInfo playVideoInfo, LiveInfo liveInfo) throws RuntimeException {
        String str;
        String str2;
        BypassPlayInfo bypassPlayInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-391112176")) {
            return (Period) ipChange.ipc$dispatch("-391112176", new Object[]{this, playVideoInfo, liveInfo});
        }
        LivePeriod livePeriod = new LivePeriod();
        NativeMap nativeMap = new NativeMap();
        nativeMap.put("datasource_live_type", "1");
        if (ConfigUtils.enableNoSurfacePlay() && (((bypassPlayInfo = liveInfo.bypassPlayInfo) != null && bypassPlayInfo.h265 == 1 && !TextUtils.isEmpty(bypassPlayInfo.h265PlayUrl)) || this.mPlayerConfig.isUseHardwareDecode())) {
            nativeMap.put("no_need_surface", "1");
        }
        if (ConfigUtils.enableInteractSEI(playVideoInfo.getVid())) {
            nativeMap.put("enable get laifeng live sei info", "1");
            nativeMap.put("get_sei_interval_ms", String.valueOf(ConfigUtils.getSEIInterval()));
        } else if (ConfigUtils.enableDelaySEI(playVideoInfo.getVid())) {
            nativeMap.put("enable get edu live sei info", "1");
        }
        nativeMap.put("utdid_str", UTDevice.getUtdid(this.mContext));
        String monitor = playVideoInfo.getMonitor("seidecode", "0");
        if (monitor != null && monitor.equals("1")) {
            nativeMap.put("enable mcu exchange image", "1");
        }
        if (liveInfo.getQuality() != null) {
            if (liveInfo.bypassPlayInfo.drmType != 0) {
                String str3 = DrmManager.getR1() + "," + liveInfo.bypassPlayInfo.encryptRServer + "," + liveInfo.bypassPlayInfo.copyrightKey;
                livePeriod.setDrmKey(str3);
                nativeMap.put("source drm key", str3);
                nativeMap.put("source drm type", "copyrightDRM");
            }
            boolean z = liveInfo.getQuality().h265 == 1 || liveInfo.getQuality().h265 == 2;
            String str4 = this.mPlayerConfig.isUseHardwareDecode() ? "1" : "0";
            if ("HW".equals(Utils.getApsConfig("live_player_config", "decode_mode", "SW"))) {
                str4 = "1";
            }
            String str5 = "2";
            if ("1".equals(playVideoInfo.getString("timeShift"))) {
                String string = playVideoInfo.getString("timeShiftPoint");
                if (z && !TextUtils.isEmpty(liveInfo.getQuality().h265TSUrl)) {
                    str2 = appendUrlParams(liveInfo.getQuality().h265TSUrl, "lhs_start=" + string);
                    str = str2;
                    str4 = "1";
                } else {
                    if (!TextUtils.isEmpty(liveInfo.getQuality().h264TSUrl)) {
                        str = appendUrlParams(liveInfo.getQuality().h264TSUrl, "lhs_start=" + string);
                        str5 = "1";
                    }
                    str5 = "1";
                    str = null;
                }
            } else if (z && !TextUtils.isEmpty(liveInfo.getQuality().h265PlayUrl)) {
                str2 = liveInfo.getQuality().h265PlayUrl;
                str = str2;
                str4 = "1";
            } else {
                if (!TextUtils.isEmpty(liveInfo.getQuality().h264PlayUrl)) {
                    str = liveInfo.getQuality().h264PlayUrl;
                    str5 = "1";
                }
                str5 = "1";
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                TLogUtil.playLog("url is null");
                return null;
            }
            nativeMap.put("source codec type", str5);
            nativeMap.put("source force hardware decode", str4);
            FileFormat fileFormat = liveInfo.getFileFormat();
            if (fileFormat == FileFormat.RTP) {
                nativeMap.put("datasource_live_type", "3");
            } else if (fileFormat == FileFormat.LHLS) {
                nativeMap.put("datasource_live_type", "4");
            } else if (fileFormat == FileFormat.ARTP) {
                nativeMap.put("artp_so_path", this.mContext.getApplicationInfo().nativeLibraryDir);
            }
            VideoInfo videoInfo = liveInfo.videoInfo;
            if (videoInfo != null && enablePursue(this.mContext, videoInfo.getBizType())) {
                nativeMap.put("pursue_video_frame_type", "1");
            } else {
                nativeMap.put("pursue_video_frame_type", "0");
            }
            if (Utils.isYoukuOrHuaweiBaipai(this.mContext) && (fileFormat == FileFormat.HLS || fileFormat == FileFormat.LHLS)) {
                P2pManager.Result pcdnUrl = P2pManager.getInstance(this.mContext.getApplicationContext()).getPcdnUrl(this.mContext, PcdnType.LIVE, str);
                if ("10000".equals(pcdnUrl.errorCode)) {
                    if (!TextUtils.isEmpty(pcdnUrl.finalUrl)) {
                        str = pcdnUrl.finalUrl;
                    }
                } else {
                    TLogUtil.playLog("p2pCode=" + pcdnUrl.errorCode);
                }
                playVideoInfo.putString("p2pCode", pcdnUrl.errorCode);
            }
            livePeriod.addSource(new Source(str));
            livePeriod.setHeader(nativeMap);
        } else {
            String url = liveInfo.getUrl();
            Logger.d("PlaylistBuilde", "laifeng:playurl=" + url);
            if (liveInfo.getFileFormat() == FileFormat.RTP) {
                nativeMap.put("datasource_live_type", "3");
            } else if (liveInfo.getFileFormat() == FileFormat.ARTP) {
                nativeMap.put("artp_so_path", this.mContext.getApplicationInfo().nativeLibraryDir);
            }
            nativeMap.put("player_source", "3");
            if (TextUtils.isEmpty(url)) {
                TLogUtil.playLog("url is null");
                return null;
            }
            livePeriod.addSource(new Source(url));
            livePeriod.setHeader(nativeMap);
        }
        return livePeriod;
    }
}
