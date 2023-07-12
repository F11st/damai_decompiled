package com.youku.alixplayer.opensdk.ups;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.taobao.weex.annotation.JSMethod;
import com.youku.alixplayer.opensdk.AlixVideoItem;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.drm.DrmType;
import com.youku.alixplayer.opensdk.ups.data.BitStream;
import com.youku.alixplayer.opensdk.ups.data.Codec;
import com.youku.alixplayer.opensdk.ups.data.MediaMap;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplayer.opensdk.ups.data.StreamSegItem;
import com.youku.alixplayer.opensdk.utils.ListUtils;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.upsplayer.module.AudioLang;
import com.youku.upsplayer.module.Segs;
import com.youku.upsplayer.module.Show;
import com.youku.upsplayer.module.Stream;
import com.youku.upsplayer.module.StreamExt;
import com.youku.upsplayer.module.Video;
import com.youku.upsplayer.module.VideoInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class UpsVideoInfo extends YoukuVideoInfo {
    public static final String TAG = "UpsVideoInfo";
    private String dolbyStreamType;
    private Map<String, List<AlixVideoItem>> mAlixVideoItems;
    private List<BitStream> mBitStreamList;
    private String mDRMR1;
    private int mDuration;
    private List<BitStream> mH264BitStreamList;
    private boolean mIsPanorama;
    private DrmType mRespDrmType;
    private String mShowId;
    private VideoInfo mUpsVideoInfo;
    private String mVid;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.alixplayer.opensdk.ups.UpsVideoInfo$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$alixplayer$opensdk$drm$DrmType;

        static {
            int[] iArr = new int[DrmType.values().length];
            $SwitchMap$com$youku$alixplayer$opensdk$drm$DrmType = iArr;
            try {
                iArr[DrmType.COPYRIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$opensdk$drm$DrmType[DrmType.CHINA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$opensdk$drm$DrmType[DrmType.WIDEVINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$opensdk$drm$DrmType[DrmType.WV_CBCS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$opensdk$drm$DrmType[DrmType.WV_CENC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public UpsVideoInfo(PlayVideoInfo playVideoInfo) {
        super(playVideoInfo);
        this.mBitStreamList = new ArrayList();
        this.mH264BitStreamList = new ArrayList();
        this.mRespDrmType = DrmType.DEFAULT;
    }

    private void constructBasicInfo(Video video, Show show) {
        if (video != null) {
            this.mVid = video.encodeid;
            String[] strArr = video.type;
            if (strArr != null) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if ("panorama".equals(strArr[i])) {
                        this.mIsPanorama = true;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            this.mShowId = video.encodeid;
        }
        if (show != null) {
            this.mShowId = show.encodeid;
        }
    }

    private void constructBitStreamList() {
        boolean z;
        String str;
        MediaMap.MediaFormat media;
        Stream[] streamArr;
        int i;
        int i2;
        ArrayList arrayList;
        Stream[] streamArr2;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i3;
        int i4;
        Segs[] segsArr;
        int i5;
        String str2;
        UpsVideoInfo upsVideoInfo = this;
        VideoInfo videoInfo = upsVideoInfo.mUpsVideoInfo;
        if (videoInfo == null || videoInfo.getStream() == null || upsVideoInfo.mUpsVideoInfo.getStream().length <= 0) {
            return;
        }
        upsVideoInfo.mBitStreamList.clear();
        upsVideoInfo.mH264BitStreamList.clear();
        Stream[] stream = upsVideoInfo.mUpsVideoInfo.getStream();
        ArrayList<BitStream> arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        int length = stream.length;
        int i6 = 0;
        while (i6 < length) {
            Stream stream2 = stream[i6];
            if (upsVideoInfo.isValid(stream2) && (((str = stream2.media_type) == null || !"audio".equals(str)) && (media = MediaMap.getMedia(stream2.stream_type)) != null)) {
                if (Quality.DOLBY == media.getQuality()) {
                    upsVideoInfo.dolbyStreamType = media.getStreamType();
                    Logger.d("YoukuVideoInfo", "dolbyStreamType:" + upsVideoInfo.dolbyStreamType);
                }
                BitStream bitStream = new BitStream(stream2.logo, media.getQuality(), stream2.stream_type, stream2.media_type, media.getCodec(), Math.max(stream2.milliseconds_audio, stream2.milliseconds_video), stream2.size);
                bitStream.setWidth(stream2.width);
                bitStream.setHeight(stream2.height);
                bitStream.setM3u8Url(stream2.m3u8_url);
                bitStream.setAudioLang(stream2.audio_lang);
                StreamExt streamExt = stream2.stream_ext;
                if (streamExt != null) {
                    bitStream.setSubtitleLang(streamExt.subtitle_lang);
                    bitStream.setHlsSubtitle(stream2.stream_ext.hls_subtitle);
                    bitStream.setHlsLogo(stream2.stream_ext.hls_logo);
                    bitStream.setDrmLicenseUri(stream2.stream_ext.uri);
                }
                upsVideoInfo.mDuration = bitStream.getLength();
                ArrayList arrayList6 = new ArrayList();
                Segs[] segsArr2 = stream2.segs;
                if (segsArr2 != null) {
                    int length2 = segsArr2.length;
                    int i7 = 0;
                    while (i7 < length2) {
                        Segs segs = segsArr2[i7];
                        if (segs == null || ((str2 = segs.cdn_url) == null && segs.rtmp_url == null)) {
                            streamArr2 = stream;
                            arrayList2 = arrayList4;
                            arrayList3 = arrayList5;
                            i3 = length;
                            i4 = i6;
                            segsArr = segsArr2;
                            i5 = length2;
                        } else {
                            segsArr = segsArr2;
                            i5 = length2;
                            streamArr2 = stream;
                            arrayList2 = arrayList4;
                            i3 = length;
                            arrayList3 = arrayList5;
                            i4 = i6;
                            StreamSegItem streamSegItem = new StreamSegItem(segs.fileid, segs.size, segs.total_milliseconds_video, segs.total_milliseconds_audio, str2, segs.rtmp_url, segs.ad);
                            streamSegItem.setCDNBackup(segs.cdn_backup);
                            arrayList6.add(streamSegItem);
                        }
                        i7++;
                        segsArr2 = segsArr;
                        length2 = i5;
                        stream = streamArr2;
                        arrayList4 = arrayList2;
                        length = i3;
                        arrayList5 = arrayList3;
                        i6 = i4;
                    }
                }
                streamArr = stream;
                ArrayList arrayList7 = arrayList4;
                ArrayList arrayList8 = arrayList5;
                i = length;
                i2 = i6;
                bitStream.setStreamSegList(arrayList6);
                String str3 = stream2.stream_type;
                if (str3 != null && str3.startsWith("cmaf")) {
                    bitStream.putString("fmp4_in_hls", "1");
                }
                upsVideoInfo = this;
                upsVideoInfo.constructDrm(stream2, bitStream);
                if (bitStream.getCodec() == Codec.AV1) {
                    arrayList = arrayList8;
                    arrayList.add(bitStream);
                    arrayList4 = arrayList7;
                } else {
                    arrayList = arrayList8;
                    if (bitStream.getCodec() == Codec.H265) {
                        arrayList4 = arrayList7;
                        arrayList4.add(bitStream);
                    } else {
                        arrayList4 = arrayList7;
                        upsVideoInfo.mH264BitStreamList.add(bitStream);
                    }
                }
            } else {
                streamArr = stream;
                arrayList = arrayList5;
                i = length;
                i2 = i6;
            }
            i6 = i2 + 1;
            arrayList5 = arrayList;
            stream = streamArr;
            length = i;
        }
        ArrayList<BitStream> arrayList9 = new ArrayList();
        for (BitStream bitStream2 : arrayList4) {
            upsVideoInfo.mBitStreamList.add(bitStream2);
            arrayList9.add(bitStream2);
        }
        if (ListUtils.isEmpty(upsVideoInfo.mH264BitStreamList)) {
            return;
        }
        for (BitStream bitStream3 : upsVideoInfo.mH264BitStreamList) {
            if (!ListUtils.isEmpty(arrayList9)) {
                for (BitStream bitStream4 : arrayList9) {
                    if (bitStream3.getQuality() == bitStream4.getQuality() && bitStream3.getAudioLang().equals(bitStream4.getAudioLang())) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (!z) {
                upsVideoInfo.mBitStreamList.add(bitStream3);
            }
        }
    }

    private void constructDrm(Stream stream, BitStream bitStream) {
        if (stream.stream_ext != null) {
            DrmType drmByStr = DrmType.getDrmByStr(stream.drm_type);
            this.mRespDrmType = drmByStr;
            int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$opensdk$drm$DrmType[drmByStr.ordinal()];
            if (i == 1) {
                Logger.d("", "是自研drm视频");
                if (!TextUtils.isEmpty(stream.encryptR_server) && !TextUtils.isEmpty(stream.stream_ext.copyright_key)) {
                    String str = this.mDRMR1;
                    Logger.d(TAG, "R1:" + str + ",encryptR_server:" + stream.encryptR_server + ",copyright_key:" + stream.stream_ext.copyright_key);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(",");
                    sb.append(stream.encryptR_server);
                    sb.append(",");
                    sb.append(stream.stream_ext.copyright_key);
                    bitStream.setDrmKey(sb.toString());
                }
            } else if (i == 2) {
                Logger.d(TAG, "是商业drm视频");
                String str2 = stream.stream_ext.chinaDrmExtInf;
                bitStream.setDrmKey("drm_key_irdeto:" + str2);
                bitStream.putString("skipCnt", stream.stream_ext.skipCnt + "");
            } else if (i == 3 || i == 4 || i == 5) {
                Logger.d(TAG, "WidevineDRM");
                bitStream.putString("fmp4_in_hls", "1");
                if (!TextUtils.isEmpty(stream.encryptR_server) && !TextUtils.isEmpty(stream.stream_ext.copyright_key)) {
                    String str3 = this.mDRMR1;
                    Logger.d(TAG, "R1:" + str3 + ",encryptR_server:" + stream.encryptR_server + ",copyright_key:" + stream.stream_ext.copyright_key);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str3);
                    sb2.append(",");
                    sb2.append(stream.encryptR_server);
                    sb2.append(",");
                    sb2.append(stream.stream_ext.copyright_key);
                    bitStream.setDrmKey(sb2.toString());
                }
            }
            bitStream.setDrmType(stream.drm_type);
        }
    }

    private void constructQualityList(Video video) {
        AlixVideoItem alixVideoItem;
        this.mAlixVideoItems = new LinkedHashMap();
        if (video == null) {
            TLogUtil.playLog("video为空，无法构建清晰度列表");
            return;
        }
        for (Map.Entry<String, List<String>> entry : video.getStreamTypes().entrySet()) {
            String key = entry.getKey();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : entry.getValue()) {
                MediaMap.MediaFormat media = MediaMap.getMedia(str);
                if (media != null) {
                    Quality quality = media.getQuality();
                    if (!linkedHashMap.containsKey(quality)) {
                        String streamExtProperty = video.getStreamExtProperty(key, str, "size");
                        video.getStreamExtProperty(key, str, "display");
                        String streamExtProperty2 = video.getStreamExtProperty(key, str, "fps");
                        String streamExtProperty3 = video.getStreamExtProperty(key, str, "resolu");
                        BitStream bitStream = getBitStream(quality, key);
                        if (bitStream != null) {
                            alixVideoItem = new AlixVideoItem(bitStream);
                        } else {
                            alixVideoItem = new AlixVideoItem(quality, key, str);
                        }
                        if (streamExtProperty != null && TextUtils.isDigitsOnly(streamExtProperty)) {
                            alixVideoItem.setStreamSize(Long.valueOf(streamExtProperty).longValue());
                        }
                        if (bitStream == null) {
                            alixVideoItem.setCanPlay(false);
                        } else {
                            alixVideoItem.setCanPlay(true);
                        }
                        if (streamExtProperty2 != null && TextUtils.isDigitsOnly(streamExtProperty2)) {
                            alixVideoItem.setFps(Integer.valueOf(streamExtProperty2).intValue());
                        }
                        if (streamExtProperty3 != null && TextUtils.isDigitsOnly(streamExtProperty3)) {
                            alixVideoItem.setResolu(Integer.valueOf(streamExtProperty3).intValue());
                        }
                        linkedHashMap.put(quality, alixVideoItem);
                    }
                }
            }
            if (linkedHashMap.containsKey(Quality.HD2_HDR_HFR)) {
                linkedHashMap.remove(Quality.HD2_HDR);
            }
            if (linkedHashMap.containsKey(Quality.HD3_HDR_HFR)) {
                linkedHashMap.remove(Quality.HD3_HDR);
            }
            if (linkedHashMap.containsKey(Quality.HD4K_HDR_HFR)) {
                linkedHashMap.remove(Quality.HD4K);
            }
            this.mAlixVideoItems.put(key, new ArrayList(linkedHashMap.values()));
        }
    }

    private String getBitStreamKey(BitStream bitStream) {
        return bitStream.getAudioLang() + JSMethod.NOT_SET + bitStream.getQuality();
    }

    private boolean isValid(Stream stream) {
        if (stream != null) {
            String str = null;
            String str2 = stream.m3u8_url;
            if (str2 != null) {
                try {
                    str = Uri.parse(str2).getQueryParameter("sm");
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if ("1".equals(str)) {
                return true;
            }
            Segs[] segsArr = stream.segs;
            return segsArr != null && segsArr.length > 0;
        }
        return false;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public String getAdString() {
        return this.mPlayVideoInfo.getString("adJson");
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public List<AlixVideoItem> getAlixVideoItems(String str) {
        if (this.mAlixVideoItems != null) {
            if (TextUtils.isEmpty(str)) {
                for (List<AlixVideoItem> list : this.mAlixVideoItems.values()) {
                    if (list != null) {
                        return list;
                    }
                }
                return null;
            }
            return this.mAlixVideoItems.get(str);
        }
        return null;
    }

    public BitStream getBitStream(Quality quality, String str) {
        for (BitStream bitStream : this.mBitStreamList) {
            if (bitStream.getQuality() == quality && (str == null || str.equals(bitStream.getAudioLang()))) {
                return bitStream;
            }
        }
        return null;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public List<BitStream> getBitStreamList() {
        return this.mBitStreamList;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public String getDolbyStreamType() {
        return this.dolbyStreamType;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public int getDuration() {
        return this.mDuration;
    }

    public AudioLang[] getLangList() {
        VideoInfo videoInfo = this.mUpsVideoInfo;
        if (videoInfo == null || videoInfo.getDvd() == null) {
            return null;
        }
        return this.mUpsVideoInfo.getDvd().audiolang;
    }

    public int getPreviewDuration() {
        VideoInfo videoInfo = this.mUpsVideoInfo;
        if (videoInfo == null || videoInfo.getTrial() == null) {
            return 0;
        }
        return Integer.valueOf(this.mUpsVideoInfo.getTrial().time).intValue() * 1000;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public String getPsid() {
        if (getUpsVideoInfo() == null || getUpsVideoInfo().getUps() == null) {
            return null;
        }
        return getUpsVideoInfo().getUps().psid;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public String getShowId() {
        return this.mShowId;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public VideoInfo getUpsVideoInfo() {
        return this.mUpsVideoInfo;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public String getVid() {
        return this.mVid;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public String getVideoType() {
        VideoInfo videoInfo = this.mUpsVideoInfo;
        if (videoInfo == null || videoInfo.getVideo() == null) {
            return null;
        }
        return this.mUpsVideoInfo.getVideo().ctype;
    }

    public boolean hasMaster() {
        VideoInfo videoInfo = this.mUpsVideoInfo;
        return (videoInfo == null || videoInfo.getMaster() == null || this.mUpsVideoInfo.getMaster().length <= 0) ? false : true;
    }

    public boolean isPanorama() {
        return this.mIsPanorama;
    }

    public boolean isPreview() {
        VideoInfo videoInfo = this.mUpsVideoInfo;
        return (videoInfo == null || videoInfo.getTrial() == null) ? false : true;
    }

    public void setDRMR1(String str) {
        this.mDRMR1 = str;
    }

    public void setUpsVideoInfo(Context context, VideoInfo videoInfo) {
        this.mUpsVideoInfo = videoInfo;
        constructBasicInfo(videoInfo.getVideo(), videoInfo.getShow());
        constructBitStreamList();
        constructQualityList(videoInfo.getVideo());
    }

    public Map<String, List<AlixVideoItem>> getAlixVideoItems() {
        return this.mAlixVideoItems;
    }
}
