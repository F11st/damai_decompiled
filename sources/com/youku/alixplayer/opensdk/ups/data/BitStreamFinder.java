package com.youku.alixplayer.opensdk.ups.data;

import com.alibaba.fastjson.JSONObject;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class BitStreamFinder {
    private static final double QUALITY_WEIGHT_MAX_GAP = Double.MAX_VALUE;
    private List<BitStream> mBitStreams;
    private boolean mIsWifi;
    private List<Quality> mQualitys;
    private JSONObject mStreamExt;
    private Map<Quality, Double> mWeights;

    public BitStreamFinder(YoukuVideoInfo youkuVideoInfo, boolean z) {
        if (youkuVideoInfo != null) {
            List<BitStream> bitStreamList = youkuVideoInfo.getBitStreamList();
            this.mBitStreams = bitStreamList;
            if (bitStreamList != null && !bitStreamList.isEmpty()) {
                if (youkuVideoInfo.getUpsVideoInfo() != null && youkuVideoInfo.getUpsVideoInfo().getVideo() != null) {
                    this.mStreamExt = youkuVideoInfo.getUpsVideoInfo().getVideo().stream_ext;
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
                return;
            }
            throw new IllegalArgumentException("bitStreams is null");
        }
        throw new IllegalArgumentException("videoInfo is null");
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
                    if (str != null && !str.equals(bitStream2.getAudioLang())) {
                    }
                    return bitStream2;
                }
                continue;
            } else if (isDisplay(bitStream2.getStreamType(), bitStream2.getAudioLang()) && (str == null || str.equals(bitStream2.getAudioLang()))) {
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

    public BitStream findFirstBitStream() {
        return this.mBitStreams.get(0);
    }
}
