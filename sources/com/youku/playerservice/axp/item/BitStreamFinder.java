package com.youku.playerservice.axp.item;

import com.alibaba.fastjson.JSONObject;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.item.MediaMap;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class BitStreamFinder {
    private static final double QUALITY_WEIGHT_MAX_GAP = Double.MAX_VALUE;
    private List<BitStream> mBitStreams;
    private boolean mIsWifi;
    private List<Quality> mQualitys;
    private JSONObject mStreamExt;
    private final String[] mStreamTypes = {"3gphd", "3gphd_", "3gphdv3", "flvhd", "mp4hd", "mp4hd2", "mp4hd2_hfr60", "mp4hd3", "mp4hd3_hfr60", "mp5hd", "mp5hd2", "mp5hd2_hfr60", "mp5hd3", "mp5hd3_hfr60"};
    private Map<Quality, Double> mWeights;

    public BitStreamFinder(PlayInfoUpsResponse playInfoUpsResponse, boolean z) {
        if (playInfoUpsResponse == null) {
            throw new IllegalArgumentException("response is null");
        }
        List<BitStream> bitStreamList = playInfoUpsResponse.getBitStreamList();
        this.mBitStreams = bitStreamList;
        if (bitStreamList == null || bitStreamList.isEmpty()) {
            throw new IllegalArgumentException("bitStreams is null");
        }
        if (playInfoUpsResponse.getUpsInfo() != null && playInfoUpsResponse.getUpsInfo().getVideoInfo() != null && playInfoUpsResponse.getUpsInfo().getVideoInfo().getVideo() != null) {
            this.mStreamExt = playInfoUpsResponse.getUpsInfo().getVideoInfo().getVideo().stream_ext;
        }
        this.mIsWifi = z;
        ArrayList arrayList = new ArrayList(MediaMap.getBitStreamOrderList());
        this.mQualitys = arrayList;
        if (this.mIsWifi) {
            Collections.reverse(arrayList);
        }
        this.mWeights = new LinkedHashMap();
        for (int i = 0; i < this.mQualitys.size(); i++) {
            double pow = Math.pow(2.0d, i);
            this.mWeights.put(this.mQualitys.get(i), Double.valueOf(pow));
        }
    }

    private Double getWeight(Quality quality) {
        Double d = this.mWeights.get(quality);
        return d == null ? Double.valueOf((double) QUALITY_WEIGHT_MAX_GAP) : d;
    }

    private boolean isDisplay(String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3 = this.mStreamExt;
        if (jSONObject3 == null || (jSONObject = jSONObject3.getJSONObject(str2)) == null || (jSONObject2 = jSONObject.getJSONObject(str)) == null) {
            return true;
        }
        return (this.mIsWifi && "2".equals(jSONObject2.getString("display"))) ? false : true;
    }

    public BitStream findBitStream(Quality quality, String str) {
        double doubleValue = getWeight(quality).doubleValue();
        BitStream bitStream = null;
        double d = QUALITY_WEIGHT_MAX_GAP;
        for (BitStream bitStream2 : this.mBitStreams) {
            if (quality == Quality.SOUND) {
                if (bitStream2.getQuality() == quality) {
                    if (str != null && !str.equals(bitStream2.getLangCode())) {
                    }
                    return bitStream2;
                }
                continue;
            } else if (isDisplay(bitStream2.getStreamType(), bitStream2.getLangCode()) && (str == null || str.equals(bitStream2.getLangCode()))) {
                if (bitStream2.getQuality() == quality) {
                    return bitStream2;
                }
                double abs = Math.abs(getWeight(bitStream2.getQuality()).doubleValue() - doubleValue);
                if (abs < d) {
                    bitStream = bitStream2;
                    d = abs;
                }
            }
        }
        return bitStream;
    }

    public BitStream findBitStream(String str, String str2) {
        Quality quality = Quality.SD;
        Codec codec = Codec.H264;
        MediaMap.MediaFormat media = MediaMap.getMedia(str);
        if (media != null) {
            quality = media.getQuality();
            codec = media.getCodec();
        }
        double d = QUALITY_WEIGHT_MAX_GAP;
        double doubleValue = getWeight(quality).doubleValue();
        BitStream bitStream = null;
        for (BitStream bitStream2 : this.mBitStreams) {
            if (quality == Quality.SOUND) {
                if (bitStream2.getQuality() == quality) {
                    if (str2 != null && !str2.equals(bitStream2.getLangCode())) {
                    }
                    return bitStream2;
                }
                continue;
            } else if (isDisplay(bitStream2.getStreamType(), bitStream2.getLangCode()) && (str2 == null || str2.equals(bitStream2.getLangCode()))) {
                if ((codec != bitStream2.getCodec() || bitStream2.getQuality() != Quality.AUTO) && !str.equals(bitStream2.getStreamType())) {
                    if (PlayDefinition.PlayFormat.HLS == bitStream2.getPlayFormat() && codec == bitStream2.getCodec() && Arrays.asList(this.mStreamTypes).contains(bitStream2.getStreamType())) {
                        double abs = Math.abs(getWeight(bitStream2.getQuality()).doubleValue() - doubleValue);
                        if (abs < d) {
                            bitStream = bitStream2;
                            d = abs;
                        }
                    }
                }
                return bitStream2;
            }
        }
        return bitStream;
    }

    public BitStream findFirstBitStream() {
        return this.mBitStreams.get(0);
    }
}
