package com.youku.playerservice.axp.playinfo;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.weex.common.Constants;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.playerservice.axp.item.Codec;
import com.youku.playerservice.axp.item.HdrType;
import com.youku.playerservice.axp.item.MediaMap;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.upsplayer.module.SimpleVideoInfo;
import com.youku.upsplayer.module.Video;
import com.youku.upsplayer.module.VideoInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class NetUpsInfo {
    private String mCacheKey;
    private String mDrmR1;
    private String mLangCode;
    private String mQGetErrorCode;
    private String mQGetErrorMsg;
    private String mRaw;
    private SimpleVideoInfo mSimpleVideoInfo;
    private VideoInfo mVideoInfo;

    public NetUpsInfo(SimpleVideoInfo simpleVideoInfo) {
        this.mVideoInfo = null;
        this.mSimpleVideoInfo = simpleVideoInfo;
    }

    public NetUpsInfo(@NonNull VideoInfo videoInfo) {
        this.mVideoInfo = videoInfo;
        this.mSimpleVideoInfo = null;
        pretreatmentMainStreamInfo(videoInfo);
    }

    private boolean enableAutoUpsStreamType() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("ups_player_config", "enable_ups_stream_type", "1"));
    }

    private Codec parseCodec(String str) {
        return "H265".equalsIgnoreCase(str) ? Codec.H265 : "AV1".equalsIgnoreCase(str) ? Codec.AV1 : Codec.H264;
    }

    private HdrType parseColorSpace(String str) {
        return "_sdr".equalsIgnoreCase(str) ? HdrType.YK_HDR : "_pwsdr".equalsIgnoreCase(str) ? HdrType.PW_HDR : "_hdr".equalsIgnoreCase(str) ? HdrType.HDR_10 : HdrType.NO_HDR;
    }

    private Quality parseQuality(String str) {
        try {
            return Quality.getQualityByUpsCode(Integer.parseInt(str));
        } catch (Exception unused) {
            return Quality.UNKNOWN;
        }
    }

    private void pretreatmentMainStreamInfo(VideoInfo videoInfo) {
        String str;
        long currentTimeMillis;
        String str2;
        if (!enableAutoUpsStreamType() || videoInfo == null || videoInfo.getController() == null || !videoInfo.getController().getStream_config()) {
            str = "config is false,use local config~";
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            Video video = videoInfo.getVideo();
            if (video != null) {
                Map<String, List<String>> streamTypes = video.getStreamTypes();
                StringBuilder sb = new StringBuilder();
                sb.append("get streamTypes count is : ");
                sb.append(streamTypes == null ? 0 : streamTypes.size());
                Logger.d("PretreatmentStreamInfo", sb.toString());
                Iterator<Map.Entry<String, List<String>>> it = streamTypes.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, List<String>> next = it.next();
                    String key = next.getKey();
                    List<String> value = next.getValue();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("get langCode streamTypes list count is : ");
                    sb2.append(value == null ? 0 : value.size());
                    Logger.d("PretreatmentStreamInfo", sb2.toString());
                    Iterator<String> it2 = value.iterator();
                    while (it2.hasNext()) {
                        String next2 = it2.next();
                        if (TextUtils.isEmpty(next2)) {
                            str2 = "streamType is NULL~";
                        } else if (isStreamExt(video, key, next2)) {
                            String streamExtProperty = video.getStreamExtProperty(key, next2, "mediatype");
                            String streamExtProperty2 = video.getStreamExtProperty(key, next2, "codec");
                            String streamExtProperty3 = video.getStreamExtProperty(key, next2, Constants.Name.QUALITY);
                            String streamExtProperty4 = video.getStreamExtProperty(key, next2, "colorspace");
                            String streamExtProperty5 = video.getStreamExtProperty(key, next2, "bitdepth");
                            String streamExtProperty6 = video.getStreamExtProperty(key, next2, IRequestConst.VR);
                            String streamExtProperty7 = video.getStreamExtProperty(key, next2, "audioeffect");
                            Iterator<Map.Entry<String, List<String>>> it3 = it;
                            String streamExtProperty8 = video.getStreamExtProperty(key, next2, "vip");
                            Video video2 = video;
                            StringBuilder sb3 = new StringBuilder();
                            Iterator<String> it4 = it2;
                            sb3.append("get streamType info streamType = ");
                            sb3.append(next2);
                            sb3.append(", mediatype = ");
                            if (TextUtils.isEmpty(streamExtProperty)) {
                                streamExtProperty = "";
                            }
                            sb3.append(streamExtProperty);
                            sb3.append(", codec = ");
                            sb3.append(!TextUtils.isEmpty(streamExtProperty2) ? streamExtProperty2 : "");
                            sb3.append(", quality = ");
                            sb3.append(!TextUtils.isEmpty(streamExtProperty3) ? streamExtProperty3 : "");
                            sb3.append(", colorspace = ");
                            sb3.append(!TextUtils.isEmpty(streamExtProperty4) ? streamExtProperty4 : "");
                            sb3.append(", bitdepth = ");
                            sb3.append(!TextUtils.isEmpty(streamExtProperty5) ? streamExtProperty5 : "");
                            sb3.append(", vr = ");
                            if (TextUtils.isEmpty(streamExtProperty6)) {
                                streamExtProperty6 = "";
                            }
                            sb3.append(streamExtProperty6);
                            sb3.append(", audioeffect = ");
                            if (TextUtils.isEmpty(streamExtProperty7)) {
                                streamExtProperty7 = "";
                            }
                            sb3.append(streamExtProperty7);
                            sb3.append(", vip = ");
                            if (TextUtils.isEmpty(streamExtProperty8)) {
                                streamExtProperty8 = "";
                            }
                            sb3.append(streamExtProperty8);
                            Logger.d("PretreatmentStreamInfo", sb3.toString());
                            MediaMap.addCoverFormat(new MediaMap.MediaFormat(next2, parseQuality(streamExtProperty3), parseCodec(streamExtProperty2), parseColorSpace(streamExtProperty4), Integer.parseInt(streamExtProperty5)));
                            it = it3;
                            video = video2;
                            it2 = it4;
                        } else {
                            str2 = "isStreamExt is NULL,不参与清晰度映射更新,langCode=[" + key + "],streamType=[" + next2 + jn1.ARRAY_END_STR;
                        }
                        Logger.d("PretreatmentStreamInfo", str2);
                    }
                }
            }
            str = "PretreatmentStreamInfo time consuming is:" + (currentTimeMillis - currentTimeMillis2) + "  ,time begin is:" + currentTimeMillis2 + "  ,time end is:" + System.currentTimeMillis();
        }
        Logger.d("PretreatmentStreamInfo", str);
    }

    public String getCacheKey() {
        return this.mCacheKey;
    }

    public String getDrmR1() {
        return this.mDrmR1;
    }

    public String getLangCode() {
        return this.mLangCode;
    }

    public String getQGetErrorCode() {
        return this.mQGetErrorCode;
    }

    public String getQGetErrorMsg() {
        return this.mQGetErrorMsg;
    }

    public String getRaw() {
        return this.mRaw;
    }

    public SimpleVideoInfo getSimpleVideoInfo() {
        return this.mSimpleVideoInfo;
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public boolean isStreamExt(Video video, String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        return (video == null || str2 == null || str == null || (jSONObject = video.stream_ext) == null || (jSONObject2 = jSONObject.getJSONObject(str)) == null || jSONObject2.getJSONObject(str2) == null) ? false : true;
    }

    public void setCacheKey(String str) {
        this.mCacheKey = str;
    }

    public void setDrmR1(String str) {
        this.mDrmR1 = str;
    }

    public void setLangCode(String str) {
        this.mLangCode = str;
    }

    public void setQGetErrorCode(String str) {
        this.mQGetErrorCode = str;
    }

    public void setQGetErrorMsg(String str) {
        this.mQGetErrorMsg = str;
    }

    public void setRaw(String str) {
        this.mRaw = str;
    }
}
