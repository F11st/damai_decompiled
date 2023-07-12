package com.youku.playerservice.axp.item;

import android.net.Uri;
import com.alibaba.fastjson.JSONObject;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.upsplayer.module.Fs;
import com.youku.upsplayer.module.FsError;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class BitStream {
    private String drmType;
    private String mCellularDomain;
    private Codec mCodec;
    private String mDofAngleRange;
    private String mDofConfigFile;
    private String mDrmKey;
    private String mDrmLicenseUri;
    private int mDuration;
    private long mFileSize;
    private Fs mFs;
    private FsError mFsError;
    private int mHeight;
    private String mHlsLogo;
    private JSONObject mHlsPlayConf;
    private String mHlsSubtitle;
    private String mLangCode;
    private String mLogo;
    private String mM3u8Url;
    private PlayDefinition.PlayFormat mPlayFormat;
    private Quality mQuality;
    private SliceItem mSliceItem;
    private List<StreamSegItem> mStreamSegList;
    private String mStreamType;
    private Map<String, String> mStringMap = new ConcurrentHashMap();
    private String mSubtitleLang;
    private int mVrType;
    private int mWidth;
    private String mWifiDomain;

    public BitStream(Quality quality, String str, Codec codec, int i) {
        this.mQuality = quality;
        this.mStreamType = str;
        this.mCodec = codec;
        this.mDuration = i;
        if (str.startsWith("cmaf") || str.startsWith("cmfv")) {
            this.mStringMap.put("fmp4_in_hls", "1");
        }
    }

    public String getCellularDomain() {
        return this.mCellularDomain;
    }

    public Codec getCodec() {
        return this.mCodec;
    }

    public String getDofAngleRange() {
        return this.mDofAngleRange;
    }

    public String getDofConfigFile() {
        return this.mDofConfigFile;
    }

    public String getDrmKey() {
        return this.mDrmKey;
    }

    public String getDrmLicenseUri() {
        return this.mDrmLicenseUri;
    }

    public String getDrmType() {
        return this.drmType;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public long getFileSize() {
        return this.mFileSize;
    }

    public Fs getFs() {
        return this.mFs;
    }

    public FsError getFsError() {
        return this.mFsError;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getHlsLogo() {
        return this.mHlsLogo;
    }

    public JSONObject getHlsPlayConf() {
        return this.mHlsPlayConf;
    }

    public String getHlsSubtitle() {
        return this.mHlsSubtitle;
    }

    public String getLangCode() {
        return this.mLangCode;
    }

    public String getLogo() {
        return this.mLogo;
    }

    public String getM3u8Url() {
        return this.mM3u8Url;
    }

    public PlayDefinition.PlayFormat getPlayFormat() {
        PlayDefinition.PlayFormat playFormat = this.mPlayFormat;
        if (playFormat == null || playFormat == PlayDefinition.PlayFormat.UNKNOWN) {
            if (this.mQuality == Quality.AUTO) {
                return PlayDefinition.PlayFormat.HLS;
            }
            String str = this.mM3u8Url;
            if (str != null) {
                if (!str.contains("#EXT-X-STREAM-INF") && !"1".equals(Uri.parse(this.mM3u8Url).getQueryParameter("sm"))) {
                    return PlayDefinition.PlayFormat.getPlayFormatByUrl(this.mM3u8Url);
                }
                return PlayDefinition.PlayFormat.HLS;
            }
            return PlayDefinition.PlayFormat.MP4;
        }
        return playFormat;
    }

    public Quality getQuality() {
        return this.mQuality;
    }

    public SliceItem getSliceItem() {
        return this.mSliceItem;
    }

    public List<StreamSegItem> getStreamSegList() {
        return this.mStreamSegList;
    }

    public String getStreamType() {
        return this.mStreamType;
    }

    public String getString(String str) {
        return this.mStringMap.get(str);
    }

    public String getString(String str, String str2) {
        String str3 = this.mStringMap.get(str);
        return str3 != null ? str3 : str2;
    }

    public String getSubtitleLang() {
        return this.mSubtitleLang;
    }

    public int getVrType() {
        return this.mVrType;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public String getWifiDomain() {
        return this.mWifiDomain;
    }

    public boolean onlyHasSliceItem() {
        return this.mSliceItem != null && this.mM3u8Url == null && this.mStreamSegList == null;
    }

    public void putString(String str, String str2) {
        this.mStringMap.put(str, str2);
    }

    public void setCellularDomain(String str) {
        this.mCellularDomain = str;
    }

    public void setDofAngleRange(String str) {
        this.mDofAngleRange = str;
    }

    public void setDofConfigFile(String str) {
        this.mDofConfigFile = str;
    }

    public void setDrmKey(String str) {
        this.mDrmKey = str;
    }

    public void setDrmLicenseUri(String str) {
        this.mDrmLicenseUri = str;
    }

    public void setDrmType(String str) {
        this.drmType = str;
    }

    public void setFileSize(long j) {
        this.mFileSize = j;
    }

    public void setFs(Fs fs) {
        this.mFs = fs;
    }

    public void setFsError(FsError fsError) {
        this.mFsError = fsError;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setHlsLogo(String str) {
        this.mHlsLogo = str;
    }

    public void setHlsPlayConf(JSONObject jSONObject) {
        this.mHlsPlayConf = jSONObject;
    }

    public void setHlsSubtitle(String str) {
        this.mHlsSubtitle = str;
    }

    public void setLangCode(String str) {
        this.mLangCode = str;
    }

    public void setLogo(String str) {
        this.mLogo = str;
    }

    public BitStream setM3u8Url(String str) {
        this.mM3u8Url = str;
        return this;
    }

    public void setPlayFormat(PlayDefinition.PlayFormat playFormat) {
        this.mPlayFormat = playFormat;
    }

    public void setSliceItem(SliceItem sliceItem) {
        this.mSliceItem = sliceItem;
    }

    public void setStreamSegList(List<StreamSegItem> list) {
        this.mStreamSegList = list;
    }

    public void setSubtitleLang(String str) {
        this.mSubtitleLang = str;
    }

    public void setVrType(int i) {
        this.mVrType = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void setWifiDomain(String str) {
        this.mWifiDomain = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(jn1.ARRAY_START_STR);
        stringBuffer.append("quality=");
        stringBuffer.append(this.mQuality);
        stringBuffer.append(",");
        stringBuffer.append("lang=");
        stringBuffer.append(this.mLangCode);
        stringBuffer.append(",");
        stringBuffer.append("videoCodec=");
        stringBuffer.append(this.mCodec);
        stringBuffer.append(",");
        stringBuffer.append("streamType=");
        stringBuffer.append(this.mStreamType);
        stringBuffer.append(",");
        stringBuffer.append(jn1.ARRAY_END_STR);
        return stringBuffer.toString();
    }
}
