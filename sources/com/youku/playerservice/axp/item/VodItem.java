package com.youku.playerservice.axp.item;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.item.PlayItem;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.vpm.constants.TableField;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class VodItem extends PlayItem {
    public static final String TAG = "VodItem";
    private final BitStream mBitStream;

    public VodItem(PlayParams playParams, JSONObject jSONObject) {
        super(playParams);
        int intValue = jSONObject.getIntValue("codec");
        String string = jSONObject.getString(TableField.STREAM_TYPE);
        int intValue2 = jSONObject.getIntValue("duration");
        JSONArray jSONArray = jSONObject.getJSONArray("list");
        String string2 = jSONObject.getString("wifiDomain");
        String string3 = jSONObject.getString("cellularDomain");
        int intValue3 = jSONObject.getIntValue("width");
        int intValue4 = jSONObject.getIntValue("height");
        String string4 = jSONObject.getString("langCode");
        string4 = TextUtils.isEmpty(string4) ? "default" : string4;
        BitStream bitStream = new BitStream(MediaMap.getQualityByStreamType(string), string, Codec.getCodecByValue(intValue), intValue2);
        bitStream.setLangCode(string4);
        if (jSONArray != null && jSONArray.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                arrayList.add(new StreamSegItem(jSONObject2.getString("url"), jSONObject2.getIntValue("duration")));
            }
            bitStream.setStreamSegList(arrayList);
        }
        bitStream.setWifiDomain(string2);
        bitStream.setCellularDomain(string3);
        bitStream.setWidth(intValue3);
        bitStream.setHeight(intValue4);
        bitStream.setPlayFormat(PlayDefinition.PlayFormat.MP4);
        this.mBitStream = bitStream;
    }

    public VodItem(PlayParams playParams, BitStream bitStream) {
        super(playParams);
        this.mBitStream = bitStream;
    }

    public VodItem(PlayParams playParams, String str) {
        super(playParams);
        BitStream bitStream = new BitStream(Quality.UNKNOWN, "mp4hd", Codec.H264, 0);
        this.mBitStream = bitStream;
        bitStream.setM3u8Url(str);
    }

    public BitStream getBitStream() {
        return this.mBitStream;
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public String getCellularDomain() {
        BitStream bitStream = this.mBitStream;
        return bitStream != null ? bitStream.getCellularDomain() : super.getCellularDomain();
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public int getDuration() {
        return this.mBitStream.getDuration();
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public String getLangCode() {
        BitStream bitStream = this.mBitStream;
        return bitStream != null ? bitStream.getLangCode() : super.getLangCode();
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public PlayDefinition.PlayFormat getPlayFormat() {
        BitStream bitStream = this.mBitStream;
        return bitStream != null ? bitStream.getPlayFormat() : this.mPlayFormat;
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public Quality getQuality() {
        BitStream bitStream = this.mBitStream;
        return bitStream != null ? bitStream.getQuality() : super.getQuality();
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public SliceItem getSliceItem() {
        BitStream bitStream = this.mBitStream;
        return bitStream != null ? bitStream.getSliceItem() : super.getSliceItem();
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public String getStreamType() {
        BitStream bitStream = this.mBitStream;
        return bitStream != null ? bitStream.getStreamType() : super.getStreamType();
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public String getVideoFormat() {
        BitStream bitStream = this.mBitStream;
        return bitStream != null ? bitStream.getQuality().getDescriptionForUps() : super.getVideoFormat();
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public String getWifiDomain() {
        BitStream bitStream = this.mBitStream;
        return bitStream != null ? bitStream.getWifiDomain() : super.getWifiDomain();
    }

    public boolean isCache() {
        BitStream bitStream = this.mBitStream;
        return bitStream != null && (bitStream instanceof CacheBitStream);
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public PlayItem.Result match(PlayItem playItem) {
        if (playItem instanceof VodItem) {
            return new PlayItem.Result(true);
        }
        PlayItem.Result result = new PlayItem.Result(false);
        result.putValue("code", "1");
        result.putValue("note", "item不是一种类型");
        return new PlayItem.Result(false);
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public void setPlayFormat(PlayDefinition.PlayFormat playFormat) {
        this.mBitStream.setPlayFormat(playFormat);
    }

    public String toString() {
        return "VodItem{mPlayFormat=" + this.mPlayFormat + ", mDuration=" + this.mBitStream.getDuration() + ", mQuality=" + getQuality() + '}';
    }
}
