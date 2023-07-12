package com.youku.alixplayer.opensdk.ups.data;

import android.net.Uri;
import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class BitStream {
    private String drmType;
    private String mAudioLang;
    private Codec mCodec;
    private String mDrmKey;
    private String mDrmLicenseUri;
    private long mFileSize;
    private int mHeight;
    private String mHlsLogo;
    private String mHlsSubtitle;
    private boolean mIsLive;
    private int mLength;
    private String mLogo;
    private String mM3u8Text;
    private String mM3u8Url;
    private String mMediaType;
    private Quality mQuality;
    private List<StreamSegItem> mStreamSegList;
    private String mStreamType;
    private Map<String, String> mStringMap;
    private String mSubtitleLang;
    private int mWidth;

    public BitStream(String str, Quality quality, String str2, Codec codec, int i) {
        this(str, quality, str2, null, codec, i, 0L);
    }

    public String getAudioLang() {
        return this.mAudioLang;
    }

    public Codec getCodec() {
        return this.mCodec;
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

    public String getFileFormat() {
        if (this.mQuality != Quality.AUTO || TextUtils.isEmpty(this.mM3u8Text)) {
            String str = this.mM3u8Url;
            return (str == null || !"1".equals(Uri.parse(str).getQueryParameter("sm"))) ? "0" : "1";
        }
        return "1";
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getHlsLogo() {
        return this.mHlsLogo;
    }

    public String getHlsSubtitle() {
        return this.mHlsSubtitle;
    }

    public int getLength() {
        return this.mLength;
    }

    public String getLogo() {
        return this.mLogo;
    }

    public String getM3u8Text() {
        return this.mM3u8Text;
    }

    public String getM3u8Url() {
        return this.mM3u8Url;
    }

    public String getMediaType() {
        return this.mMediaType;
    }

    public Quality getQuality() {
        return this.mQuality;
    }

    public long getSize() {
        return this.mFileSize;
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

    public String getSubtitleLang() {
        return this.mSubtitleLang;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isLive() {
        return this.mIsLive;
    }

    public void putString(String str, String str2) {
        this.mStringMap.put(str, str2);
    }

    public void setAudioLang(String str) {
        this.mAudioLang = str;
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

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setHlsLogo(String str) {
        this.mHlsLogo = str;
    }

    public void setHlsSubtitle(String str) {
        this.mHlsSubtitle = str;
    }

    public void setIsLive(boolean z) {
        this.mIsLive = z;
    }

    public BitStream setM3u8Text(String str) {
        this.mM3u8Text = str;
        return this;
    }

    public void setM3u8Url(String str) {
        this.mM3u8Url = str;
    }

    public void setSize(long j) {
        this.mFileSize = j;
    }

    public void setStreamSegList(List<StreamSegItem> list) {
        this.mStreamSegList = list;
    }

    public void setSubtitleLang(String str) {
        this.mSubtitleLang = str;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(jn1.ARRAY_START_STR);
        stringBuffer.append("quality=");
        stringBuffer.append(this.mQuality);
        stringBuffer.append(",");
        stringBuffer.append("lang=");
        stringBuffer.append(this.mAudioLang);
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

    public BitStream(String str, Quality quality, String str2, String str3, Codec codec, int i, long j) {
        this.mStringMap = new ConcurrentHashMap();
        this.mLogo = str;
        this.mQuality = quality;
        this.mStreamType = str2;
        this.mMediaType = str3;
        this.mCodec = codec;
        this.mLength = i;
        this.mFileSize = j;
    }

    public String getString(String str, String str2) {
        String str3 = this.mStringMap.get(str);
        return str3 != null ? str3 : str2;
    }
}
