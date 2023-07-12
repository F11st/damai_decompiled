package com.youku.alixplayer.opensdk.ups.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class MediaMap {
    private static final List<Quality> mBitStreamOrderList;
    private static final Quality[] mQualityOrderList;
    protected static Map<String, MediaFormat> sMediaMap;

    static {
        init();
        mQualityOrderList = new Quality[]{Quality.AUTO, Quality.HD3GP, Quality.SD, Quality.SD_HDR, Quality.HD, Quality.HD_HDR, Quality.HD2, Quality.HD2_HDR, Quality.HD2_HDR_HFR, Quality.HD2_PW_HDR, Quality.HD2_PW_HDR_HFR, Quality.HD3, Quality.HD3_HDR, Quality.HD3_HDR_HFR, Quality.HD3_PW_HDR, Quality.HD3_PW_HDR_HFR, Quality.DOLBY, Quality.HD4K, Quality.HD4K_HDR, Quality.HD4K_HDR_HFR, Quality.HD4K_PW_HDR, Quality.HD4K_PW_HDR_HFR, Quality.HD3_HBR};
        mBitStreamOrderList = new ArrayList<Quality>() { // from class: com.youku.alixplayer.opensdk.ups.data.MediaMap.1
            {
                add(Quality.HD3GP);
                add(Quality.SD);
                add(Quality.SD_HDR);
                add(Quality.HD);
                add(Quality.HD_HDR);
                add(Quality.AUTO);
                add(Quality.HD2);
                add(Quality.HD2_HDR);
                add(Quality.HD2_HDR_HFR);
                add(Quality.HD2_PW_HDR);
                add(Quality.HD2_PW_HDR_HFR);
                add(Quality.HD3);
                add(Quality.HD3_HDR);
                add(Quality.HD3_HDR_HFR);
                add(Quality.HD3_PW_HDR);
                add(Quality.HD3_PW_HDR_HFR);
                add(Quality.DOLBY);
                add(Quality.HD4K);
                add(Quality.HD4K_HDR);
                add(Quality.HD4K_HDR_HFR);
                add(Quality.HD4K_PW_HDR);
                add(Quality.HD4K_PW_HDR_HFR);
                add(Quality.HD3_HBR);
            }
        };
    }

    public static List<Quality> getBitStreamOrderList() {
        return mBitStreamOrderList;
    }

    public static String getDolbyStreamType() {
        return "mp4hd3v2sdr_atmos";
    }

    public static Quality getFormatByStreamType(String str) {
        MediaFormat mediaFormat;
        Map<String, MediaFormat> map = sMediaMap;
        if (map != null && (mediaFormat = map.get(str)) != null) {
            return mediaFormat.format;
        }
        return Quality.UNKNOWN;
    }

    public static MediaFormat getMedia(String str) {
        return sMediaMap.get(str);
    }

    public static List<MediaFormat> getMediaList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MediaFormat("auto", Quality.AUTO));
        Quality quality = Quality.HD3GP;
        arrayList.add(new MediaFormat("3gphd", quality));
        Quality quality2 = Quality.SD;
        arrayList.add(new MediaFormat("flvhd", quality2));
        Quality quality3 = Quality.HD;
        arrayList.add(new MediaFormat("mp4hd", quality3));
        Quality quality4 = Quality.HD2;
        arrayList.add(new MediaFormat("mp4hd2", quality4));
        arrayList.add(new MediaFormat("mp4hd2_hfr60", quality4));
        Quality quality5 = Quality.HD3;
        arrayList.add(new MediaFormat("mp4hd3", quality5));
        arrayList.add(new MediaFormat("mp4hd3_hfr60", quality5));
        Quality quality6 = Quality.DOLBY;
        arrayList.add(new MediaFormat("mp4hd3v2sdr_dolby", quality6));
        arrayList.add(new MediaFormat("mp4hd3v2sdr_atmos", quality6));
        arrayList.add(new MediaFormat("mp4hd3v3sdr_dolby", quality6));
        arrayList.add(new MediaFormat("mp4hd3v3sdr_atmos", quality6));
        Codec codec = Codec.H265;
        arrayList.add(new MediaFormat("mp5sd", quality2, codec));
        arrayList.add(new MediaFormat("mp5hd", quality3, codec));
        arrayList.add(new MediaFormat("mp5hd2", quality4, codec));
        HdrType hdrType = HdrType.NO_HDR;
        arrayList.add(new MediaFormat("mp5hd2_hfr60", quality4, codec, hdrType));
        arrayList.add(new MediaFormat("mp5hd3", quality5, codec));
        arrayList.add(new MediaFormat("mp5hd3_hfr60", quality5, codec, hdrType));
        arrayList.add(new MediaFormat("mp5hd3v2vision_atmos", quality6, codec));
        arrayList.add(new MediaFormat("mp5hd3v2vision_dolby", quality6, codec));
        arrayList.add(new MediaFormat("mp5hd3v2hdr_dolby", quality6, codec));
        arrayList.add(new MediaFormat("mp5hd3v2hdr_atmos", quality6, codec));
        arrayList.add(new MediaFormat("audio", Quality.SOUND));
        Quality quality7 = Quality.SD_HDR;
        Codec codec2 = Codec.H264;
        HdrType hdrType2 = HdrType.YK_HDR;
        arrayList.add(new MediaFormat("hls4sd_sdr", quality7, codec2, hdrType2));
        Quality quality8 = Quality.HD_HDR;
        arrayList.add(new MediaFormat("hls4hd_sdr", quality8, codec2, hdrType2));
        Quality quality9 = Quality.HD2_HDR;
        arrayList.add(new MediaFormat("hls4hd2_sdr", quality9, codec2, hdrType2));
        Quality quality10 = Quality.HD2_HDR_HFR;
        arrayList.add(new MediaFormat("hls4hd2_sdr_hfr", quality10, codec2, hdrType2));
        Quality quality11 = Quality.HD3_HDR;
        arrayList.add(new MediaFormat("hls4hd3_sdr", quality11, codec2, hdrType2));
        Quality quality12 = Quality.HD3_HDR_HFR;
        arrayList.add(new MediaFormat("hls4hd3_sdr_hfr", quality12, codec2, hdrType2));
        Quality quality13 = Quality.HD4K_HDR;
        arrayList.add(new MediaFormat("hls4hd4_sdr", quality13, codec2, hdrType2));
        Quality quality14 = Quality.HD4K_HDR_HFR;
        arrayList.add(new MediaFormat("hls4hd4_sdr_hfr", quality14, codec2, hdrType2));
        arrayList.add(new MediaFormat("hls5sd_sdr", quality7, codec, hdrType2));
        arrayList.add(new MediaFormat("hls5hd_sdr", quality8, codec, hdrType2));
        arrayList.add(new MediaFormat("hls5hd2_sdr", quality9, codec, hdrType2));
        arrayList.add(new MediaFormat("hls5hd2_sdr_hfr", quality10, codec, hdrType2));
        arrayList.add(new MediaFormat("hls5hd3_sdr", quality11, codec, hdrType2));
        arrayList.add(new MediaFormat("hls5hd3_sdr_hfr", quality12, codec, hdrType2));
        arrayList.add(new MediaFormat("hls5hd4_sdr", quality13, codec, hdrType2));
        arrayList.add(new MediaFormat("hls5hd4_sdr_hfr", quality14, codec, hdrType2));
        Quality quality15 = Quality.HD2_PW_HDR;
        HdrType hdrType3 = HdrType.PW_HDR;
        arrayList.add(new MediaFormat("hls4hd2_pwsdr", quality15, codec2, hdrType3));
        Quality quality16 = Quality.HD2_PW_HDR_HFR;
        arrayList.add(new MediaFormat("hls4hd2_pwsdr_hfr", quality16, codec2, hdrType3));
        Quality quality17 = Quality.HD3_PW_HDR;
        arrayList.add(new MediaFormat("hls4hd3_pwsdr", quality17, codec2, hdrType3));
        Quality quality18 = Quality.HD3_PW_HDR_HFR;
        arrayList.add(new MediaFormat("hls4hd3_pwsdr_hfr", quality18, codec2, hdrType3));
        arrayList.add(new MediaFormat("hls5hd2_pwsdr", quality15, codec, hdrType3));
        arrayList.add(new MediaFormat("hls5hd2_pwsdr_hfr", quality16, codec, hdrType3));
        arrayList.add(new MediaFormat("hls5hd3_pwsdr", quality17, codec, hdrType3));
        arrayList.add(new MediaFormat("hls5hd3_pwsdr_hfr", quality18, codec, hdrType3));
        arrayList.add(new MediaFormat("hls5hd4_pwsdr", Quality.HD4K_PW_HDR, codec, hdrType3));
        arrayList.add(new MediaFormat("hls5hd4_pwsdr_hfr", Quality.HD4K_PW_HDR_HFR, codec, hdrType3));
        arrayList.add(new MediaFormat("cmaf4ld", quality));
        arrayList.add(new MediaFormat("cmaf4sd", quality2));
        arrayList.add(new MediaFormat("cmaf4hd", quality3));
        arrayList.add(new MediaFormat("cmaf4hd2", quality4));
        arrayList.add(new MediaFormat("cmaf4hd3", quality5));
        arrayList.add(new MediaFormat("cmaf5ld", quality, codec));
        arrayList.add(new MediaFormat("cmaf5sd", quality2, codec));
        arrayList.add(new MediaFormat("cmaf5hd", quality3, codec));
        arrayList.add(new MediaFormat("cmaf5hd2", quality4, codec));
        arrayList.add(new MediaFormat("cmaf5hd3", quality5, codec));
        Quality quality19 = Quality.HD4K;
        arrayList.add(new MediaFormat("mp5hd4", quality19, codec));
        arrayList.add(new MediaFormat("mp5hd4v3", quality19, codec));
        Quality quality20 = Quality.HD3_HBR;
        arrayList.add(new MediaFormat("hls5hd3_hbr", quality20, codec, hdrType));
        arrayList.add(new MediaFormat("hls5hd3_hfr_hbr", quality20, codec, hdrType));
        arrayList.add(new MediaFormat("hls5hd3_pwsdr_hbr", quality20, codec, hdrType3));
        arrayList.add(new MediaFormat("hls5hd3_pwsdr_hfr_hbr", quality20, codec, hdrType3));
        arrayList.add(new MediaFormat("cmaf5hd3_hbr", quality20, codec, hdrType2));
        arrayList.add(new MediaFormat("cmaf5hd3_hfr_hbr", quality20, codec, hdrType2));
        arrayList.add(new MediaFormat("hls5qd3_hbr", quality20, codec, hdrType));
        arrayList.add(new MediaFormat("hls5qd3_hfr_hbr", quality20, codec, hdrType));
        arrayList.add(new MediaFormat("hls5hd4_hbr", quality20, codec, hdrType));
        arrayList.add(new MediaFormat("hls5hd4_hfr_hbr", quality20, codec, hdrType));
        HdrType hdrType4 = HdrType.HDR_10;
        arrayList.add(new MediaFormat("hls5hd4_hdr_hbr", quality20, codec, hdrType4));
        arrayList.add(new MediaFormat("hls5hd4_hdr_hfr_hbr", quality20, codec, hdrType4));
        arrayList.add(new MediaFormat("hls5hd3_hfr120_hbr", quality20, codec, hdrType));
        arrayList.add(new MediaFormat("cmaf5hd3_hfr120_hbr", quality20, codec, hdrType2));
        Codec codec3 = Codec.AV1;
        arrayList.add(new MediaFormat("mpav1ld", quality, codec3, hdrType));
        arrayList.add(new MediaFormat("mpav1sd", quality2, codec3, hdrType));
        arrayList.add(new MediaFormat("mpav1hd", quality3, codec3, hdrType));
        arrayList.add(new MediaFormat("mpav1hd2", quality4, codec3, hdrType));
        arrayList.add(new MediaFormat("mpav1hd3", quality5, codec3, hdrType));
        arrayList.add(new MediaFormat("mpav1hd4", quality19, codec3, hdrType));
        return arrayList;
    }

    public static int getOrderByQuality(Quality quality) {
        int i = 0;
        while (true) {
            Quality[] qualityArr = mQualityOrderList;
            if (i >= qualityArr.length) {
                return Integer.MAX_VALUE;
            }
            if (quality == qualityArr[i]) {
                return i;
            }
            i++;
        }
    }

    protected static void init() {
        if (sMediaMap == null) {
            sMediaMap = new HashMap(10);
            for (MediaFormat mediaFormat : getMediaList()) {
                sMediaMap.put(mediaFormat.streamType, mediaFormat);
            }
        }
    }

    public static boolean supporth265() {
        return false;
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class MediaFormat {
        private Quality format;
        private HdrType hdrType;
        private String streamType;
        private Codec videoCodec;

        public Codec getCodec() {
            return this.videoCodec;
        }

        public HdrType getHdrType() {
            return this.hdrType;
        }

        public Quality getQuality() {
            return this.format;
        }

        public String getStreamType() {
            return this.streamType;
        }

        public String toString() {
            return this.streamType + " format=" + this.format + " videoCodec=" + getCodec();
        }

        private MediaFormat(String str, Quality quality) {
            this(str, quality, Codec.H264, HdrType.NO_HDR);
        }

        private MediaFormat(String str, Quality quality, Codec codec) {
            this(str, quality, codec, HdrType.NO_HDR);
        }

        private MediaFormat(String str, Quality quality, Codec codec, HdrType hdrType) {
            this.streamType = str;
            this.format = quality;
            this.videoCodec = codec;
            this.hdrType = hdrType;
        }
    }
}
