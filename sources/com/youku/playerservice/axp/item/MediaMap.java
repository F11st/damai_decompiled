package com.youku.playerservice.axp.item;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class MediaMap {
    public static final int VR_TYPE_EAC = 1;
    public static final int VR_TYPE_NORMAL = 0;
    public static final int VR_TYPE_NUO = 2;
    private static final List<Quality> mBitStreamOrderList;
    private static final Quality[] mQualityOrderList;
    protected static Map<String, MediaFormat> sMediaMap;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class MediaFormat {
        private int bitDepth;
        @Deprecated
        public boolean h265;
        private HdrType hdrType;
        private Quality quality;
        private String streamType;
        private Codec videoCodec;
        @Deprecated
        public int vrType;

        private MediaFormat(String str, Quality quality) {
            this(str, quality, Codec.H264, HdrType.NO_HDR);
        }

        private MediaFormat(String str, Quality quality, Codec codec) {
            this(str, quality, codec, HdrType.NO_HDR);
        }

        public MediaFormat(String str, Quality quality, Codec codec, HdrType hdrType) {
            this(str, quality, codec, hdrType, 8);
        }

        public MediaFormat(String str, Quality quality, Codec codec, HdrType hdrType, int i) {
            this.bitDepth = 8;
            this.streamType = str;
            this.quality = quality;
            this.videoCodec = codec;
            this.hdrType = hdrType;
            this.bitDepth = i;
        }

        public int getBitDepth() {
            return this.bitDepth;
        }

        public Codec getCodec() {
            return this.videoCodec;
        }

        public HdrType getHdrType() {
            return this.hdrType;
        }

        public Quality getQuality() {
            return this.quality;
        }

        public String getStreamType() {
            return this.streamType;
        }

        public MediaFormat setVrType(int i) {
            this.vrType = i;
            return this;
        }

        public String toString() {
            return this.streamType + " quality=" + this.quality + " videoCodec=" + this.videoCodec + " hdrType=" + this.hdrType;
        }
    }

    static {
        init();
        mQualityOrderList = new Quality[]{Quality.AUTO, Quality.HD3GP, Quality.SD, Quality.SD_HDR, Quality.HD, Quality.HD_HDR, Quality.HD2, Quality.HD2_HDR, Quality.HD2_HDR_HFR, Quality.HD2_PW_HDR, Quality.HD2_PW_HDR_HFR, Quality.HD3, Quality.HD3_HDR, Quality.HD3_HDR_HFR, Quality.HD3_PW_HDR, Quality.HD3_PW_HDR_HFR, Quality.DOLBY, Quality.HD4K, Quality.HD4K_HDR, Quality.HD4K_HDR_HFR, Quality.HD4K_PW_HDR, Quality.HD4K_PW_HDR_HFR, Quality.HD3_HBR};
        mBitStreamOrderList = new ArrayList<Quality>() { // from class: com.youku.playerservice.axp.item.MediaMap.1
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

    public static void addCoverFormat(MediaFormat mediaFormat) {
        if (sMediaMap == null || mediaFormat == null || TextUtils.isEmpty(mediaFormat.streamType)) {
            return;
        }
        sMediaMap.put(mediaFormat.streamType, mediaFormat);
    }

    public static List<Quality> getBitStreamOrderList() {
        return mBitStreamOrderList;
    }

    public static String getDolbyStreamType() {
        return "mp4hd3v2sdr_atmos";
    }

    public static MediaFormat getFormatByStreamType(String str) {
        MediaFormat mediaFormat;
        Map<String, MediaFormat> map = sMediaMap;
        if (map == null || (mediaFormat = map.get(str)) == null) {
            return null;
        }
        return mediaFormat;
    }

    public static MediaFormat getMedia(String str) {
        return sMediaMap.get(str);
    }

    public static List<MediaFormat> getMediaList() {
        ArrayList arrayList = new ArrayList();
        Quality quality = Quality.AUTO;
        arrayList.add(new MediaFormat("auto", quality));
        Quality quality2 = Quality.HD3GP;
        arrayList.add(new MediaFormat("3gphd", quality2));
        Quality quality3 = Quality.SD;
        arrayList.add(new MediaFormat("flvhd", quality3));
        Quality quality4 = Quality.HD;
        arrayList.add(new MediaFormat("mp4hd", quality4));
        Quality quality5 = Quality.HD2;
        arrayList.add(new MediaFormat("mp4hd2", quality5));
        arrayList.add(new MediaFormat("mp4hd2_hfr60", quality5));
        Quality quality6 = Quality.HD3;
        arrayList.add(new MediaFormat("mp4hd3", quality6));
        arrayList.add(new MediaFormat("mp4hd3_hfr60", quality6));
        Quality quality7 = Quality.DOLBY;
        arrayList.add(new MediaFormat("mp4hd3v2sdr_dolby", quality7));
        arrayList.add(new MediaFormat("mp4hd3v2sdr_atmos", quality7));
        arrayList.add(new MediaFormat("mp4hd3v3sdr_dolby", quality7));
        arrayList.add(new MediaFormat("mp4hd3v3sdr_atmos", quality7));
        Codec codec = Codec.H265;
        arrayList.add(new MediaFormat("mp5sd", quality3, codec));
        arrayList.add(new MediaFormat("mp5hd", quality4, codec));
        arrayList.add(new MediaFormat("mp5hd2", quality5, codec));
        HdrType hdrType = HdrType.NO_HDR;
        arrayList.add(new MediaFormat("mp5hd2_hfr60", quality5, codec, hdrType));
        arrayList.add(new MediaFormat("mp5hd3", quality6, codec));
        arrayList.add(new MediaFormat("mp5hd3_hfr60", quality6, codec, hdrType));
        arrayList.add(new MediaFormat("mp5hd3v2vision_atmos", quality7, codec));
        arrayList.add(new MediaFormat("mp5hd3v2vision_dolby", quality7, codec));
        arrayList.add(new MediaFormat("mp5hd3v2hdr_dolby", quality7, codec));
        arrayList.add(new MediaFormat("mp5hd3v2hdr_atmos", quality7, codec));
        arrayList.add(new MediaFormat("audio", Quality.SOUND));
        Codec codec2 = Codec.H264;
        arrayList.add(new MediaFormat("mp4sdeac", quality3, codec2).setVrType(1));
        arrayList.add(new MediaFormat("mp5sdeac", quality3, codec).setVrType(1));
        arrayList.add(new MediaFormat("mp4hdeac", quality4, codec2).setVrType(1));
        arrayList.add(new MediaFormat("mp5hdeac", quality4, codec).setVrType(1));
        arrayList.add(new MediaFormat("mp4hd2v2eac", quality5, codec2).setVrType(1));
        arrayList.add(new MediaFormat("mp5hd2eac", quality5, codec).setVrType(1));
        arrayList.add(new MediaFormat("mp4hd3v2eac", quality6, codec2).setVrType(1));
        arrayList.add(new MediaFormat("mp5hd3eac", quality6, codec).setVrType(1));
        arrayList.add(new MediaFormat("mp4sdnuo", quality3, codec2).setVrType(2));
        arrayList.add(new MediaFormat("mp5sdnuo", quality3, codec).setVrType(2));
        arrayList.add(new MediaFormat("mp4hdnuo", quality4, codec2).setVrType(2));
        arrayList.add(new MediaFormat("mp5hdnuo", quality4, codec).setVrType(2));
        arrayList.add(new MediaFormat("mp4hd2v2nuo", quality5, codec2).setVrType(2));
        arrayList.add(new MediaFormat("mp5hd2nuo", quality5, codec).setVrType(2));
        arrayList.add(new MediaFormat("mp4hd3v2nuo", quality6, codec2).setVrType(2));
        arrayList.add(new MediaFormat("mp5hd3nuo", quality6, codec).setVrType(2));
        Quality quality8 = Quality.SD_HDR;
        HdrType hdrType2 = HdrType.YK_HDR;
        arrayList.add(new MediaFormat("hls4sd_sdr", quality8, codec2, hdrType2));
        Quality quality9 = Quality.HD_HDR;
        arrayList.add(new MediaFormat("hls4hd_sdr", quality9, codec2, hdrType2));
        Quality quality10 = Quality.HD2_HDR;
        arrayList.add(new MediaFormat("hls4hd2_sdr", quality10, codec2, hdrType2));
        Quality quality11 = Quality.HD2_HDR_HFR;
        arrayList.add(new MediaFormat("hls4hd2_sdr_hfr", quality11, codec2, hdrType2));
        Quality quality12 = Quality.HD3_HDR;
        arrayList.add(new MediaFormat("hls4hd3_sdr", quality12, codec2, hdrType2));
        Quality quality13 = Quality.HD3_HDR_HFR;
        arrayList.add(new MediaFormat("hls4hd3_sdr_hfr", quality13, codec2, hdrType2));
        Quality quality14 = Quality.HD4K_HDR;
        arrayList.add(new MediaFormat("hls4hd4_sdr", quality14, codec2, hdrType2));
        Quality quality15 = Quality.HD4K_HDR_HFR;
        arrayList.add(new MediaFormat("hls4hd4_sdr_hfr", quality15, codec2, hdrType2));
        arrayList.add(new MediaFormat("hls5sd_sdr", quality8, codec, hdrType2));
        arrayList.add(new MediaFormat("hls5hd_sdr", quality9, codec, hdrType2));
        arrayList.add(new MediaFormat("hls5hd2_sdr", quality10, codec, hdrType2));
        arrayList.add(new MediaFormat("hls5hd2_sdr_hfr", quality11, codec, hdrType2));
        arrayList.add(new MediaFormat("hls5hd3_sdr", quality12, codec, hdrType2));
        arrayList.add(new MediaFormat("hls5hd3_sdr_hfr", quality13, codec, hdrType2));
        arrayList.add(new MediaFormat("hls5hd4_sdr", quality14, codec, hdrType2));
        arrayList.add(new MediaFormat("hls5hd4_sdr_hfr", quality15, codec, hdrType2));
        Quality quality16 = Quality.HD2_PW_HDR;
        HdrType hdrType3 = HdrType.PW_HDR;
        arrayList.add(new MediaFormat("hls4hd2_pwsdr", quality16, codec2, hdrType3));
        Quality quality17 = Quality.HD2_PW_HDR_HFR;
        arrayList.add(new MediaFormat("hls4hd2_pwsdr_hfr", quality17, codec2, hdrType3));
        Quality quality18 = Quality.HD3_PW_HDR;
        arrayList.add(new MediaFormat("hls4hd3_pwsdr", quality18, codec2, hdrType3));
        Quality quality19 = Quality.HD3_PW_HDR_HFR;
        arrayList.add(new MediaFormat("hls4hd3_pwsdr_hfr", quality19, codec2, hdrType3));
        arrayList.add(new MediaFormat("hls5hd2_pwsdr", quality16, codec, hdrType3));
        arrayList.add(new MediaFormat("hls5hd2_pwsdr_hfr", quality17, codec, hdrType3));
        arrayList.add(new MediaFormat("hls5hd3_pwsdr", quality18, codec, hdrType3));
        arrayList.add(new MediaFormat("hls5hd3_pwsdr_hfr", quality19, codec, hdrType3));
        arrayList.add(new MediaFormat("hls5hd4_pwsdr", Quality.HD4K_PW_HDR, codec, hdrType3));
        arrayList.add(new MediaFormat("hls5hd4_pwsdr_hfr", Quality.HD4K_PW_HDR_HFR, codec, hdrType3));
        arrayList.add(new MediaFormat("cmaf4ld", quality2));
        arrayList.add(new MediaFormat("cmaf4sd", quality3));
        arrayList.add(new MediaFormat("cmaf4hd", quality4));
        arrayList.add(new MediaFormat("cmaf4hd2", quality5));
        arrayList.add(new MediaFormat("cmaf4hd3", quality6));
        arrayList.add(new MediaFormat("cmaf5ld", quality2, codec));
        arrayList.add(new MediaFormat("cmaf5sd", quality3, codec));
        arrayList.add(new MediaFormat("cmaf5hd", quality4, codec));
        arrayList.add(new MediaFormat("cmaf5hd2", quality5, codec));
        arrayList.add(new MediaFormat("cmaf5hd3", quality6, codec));
        Quality quality20 = Quality.HD4K;
        arrayList.add(new MediaFormat("mp5hd4", quality20, codec));
        arrayList.add(new MediaFormat("mp5hd4v3", quality20, codec));
        Quality quality21 = Quality.HD3_HBR;
        arrayList.add(new MediaFormat("hls4hd4_sdr_hfr120_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("hls4hd4_sdr_hfr_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("hls4hd4_sdr_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("hls4qd3_sdr_hfr120_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("hls4qd3_sdr_hfr_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("hls4qd3_sdr_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("hls4hd3_sdr_hfr120_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("hls4hd3_sdr_hfr_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("hls4hd3_sdr_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("cmaf4hd4_sdr_hfr120_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("cmaf4hd4_sdr_hfr_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("cmaf4hd4_sdr_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("cmaf4qd3_sdr_hfr120_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("cmaf4qd3_sdr_hfr_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("cmaf4qd3_sdr_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("cmaf4hd3_sdr_hfr120_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("cmaf4hd3_sdr_hfr_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("cmaf4hd3_sdr_hbr_cingo", quality21, codec2));
        arrayList.add(new MediaFormat("hls5hd4_hfr120_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd4_hfr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd4_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5qd3_hfr120_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5qd3_hfr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5qd3_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd3_hfr120_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd3_hfr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd3_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd4_hfr120_hbr_bit10", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd4_hfr_hbr_bit10", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd4_hbr_bit10", quality21, codec));
        arrayList.add(new MediaFormat("hls5qd3_hfr120_hbr_bit10", quality21, codec));
        arrayList.add(new MediaFormat("hls5qd3_hfr_hbr_bit10", quality21, codec));
        arrayList.add(new MediaFormat("hls5qd3_hbr_bit10", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd3_hfr120_hbr_bit10", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd3_hfr_hbr_bit10", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd3_hbr_bit10", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd3_pwsdr_hfr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd3_pwsdr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd4_hdr_hfr120_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd4_hdr_hfr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd4_hdr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5qd3_hdr_hfr120_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5qd3_hdr_hfr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5qd3_hdr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd3_hdr_hfr120_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd3_hdr_hfr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd3_hdr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd4_hdr_hfr120_hbr_cingo", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd4_hdr_hfr_hbr_cingo", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd4_hdr_hbr_cingo", quality21, codec));
        arrayList.add(new MediaFormat("hls5qd3_hdr_hfr120_hbr_cingo", quality21, codec));
        arrayList.add(new MediaFormat("hls5qd3_hdr_hfr_hbr_cingo", quality21, codec));
        arrayList.add(new MediaFormat("hls5qd3_hdr_hbr_cingo", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd3_hdr_hfr120_hbr_cingo", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd3_hdr_hfr_hbr_cingo", quality21, codec));
        arrayList.add(new MediaFormat("hls5hd3_hdr_hbr_cingo", quality21, codec));
        arrayList.add(new MediaFormat("cmaf5hd4_hdr_hfr120_hbr", quality21, codec));
        arrayList.add(new MediaFormat("cmaf5hd4_hdr_hfr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("cmaf5hd4_hdr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("cmaf5qd3_hdr_hfr120_hbr", quality21, codec));
        arrayList.add(new MediaFormat("cmaf5qd3_hdr_hfr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("cmaf5qd3_hdr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("cmaf5hd3_hdr_hfr120_hbr", quality21, codec));
        arrayList.add(new MediaFormat("cmaf5hd3_hdr_hfr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("cmaf5hd3_hdr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("cmaf5hd3_hfr120_hbr", quality21, codec));
        arrayList.add(new MediaFormat("cmaf5hd3_hfr_hbr", quality21, codec));
        arrayList.add(new MediaFormat("cmaf5hd3_hbr", quality21, codec));
        Codec codec3 = Codec.AV1;
        arrayList.add(new MediaFormat("mpav1ld", quality2, codec3, hdrType));
        arrayList.add(new MediaFormat("mpav1sd", quality3, codec3, hdrType));
        arrayList.add(new MediaFormat("mpav1hd", quality4, codec3, hdrType));
        arrayList.add(new MediaFormat("mpav1hd2", quality5, codec3, hdrType));
        arrayList.add(new MediaFormat("mpav1hd3", quality6, codec3, hdrType));
        arrayList.add(new MediaFormat("mpav1hd4", quality20, codec3, hdrType));
        arrayList.add(new MediaFormat("mp4_6dof_4k", quality5, codec, hdrType));
        arrayList.add(new MediaFormat("mp4_6dof_4k_hq", quality5, codec, hdrType));
        arrayList.add(new MediaFormat("mp4_6dof_6k", quality5, codec, hdrType));
        arrayList.add(new MediaFormat("mp4_6dof_6k_hq", quality5, codec, hdrType));
        arrayList.add(new MediaFormat("mp5_6dof_4k", quality5, codec, hdrType));
        arrayList.add(new MediaFormat("mp5_6dof_4k_hq", quality5, codec, hdrType));
        arrayList.add(new MediaFormat("mp5_6dof_6k", quality5, codec, hdrType));
        arrayList.add(new MediaFormat("mp5_6dof_6k_hq", quality5, codec, hdrType));
        arrayList.add(new MediaFormat("dof_auto", quality, codec, hdrType));
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

    public static Quality getQualityByStreamType(String str) {
        MediaFormat formatByStreamType = getFormatByStreamType(str);
        return formatByStreamType != null ? formatByStreamType.getQuality() : Quality.UNKNOWN;
    }

    protected static void init() {
        if (sMediaMap == null) {
            sMediaMap = new HashMap(10);
            for (MediaFormat mediaFormat : getMediaList()) {
                sMediaMap.put(mediaFormat.streamType, mediaFormat);
            }
        }
    }
}
