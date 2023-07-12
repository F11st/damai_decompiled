package com.youku.playerservice.axp.item;

import android.net.Uri;
import android.text.TextUtils;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.playerservice.axp.item.PlayItem;
import com.youku.playerservice.axp.playparams.PlayParams;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class LiveItem extends PlayItem {
    private Codec mCodec;
    private boolean mEnablePursue;
    private LivePlayControl mLivePlayControl;
    private String mMasterText;
    private String mPlayUrl;
    private Quality mQuality;
    private String mStreamType;
    private String mTimeUrl;

    public LiveItem(PlayParams playParams, String str) {
        super(playParams);
        this.mQuality = Quality.UNKNOWN;
        this.mPlayUrl = str;
    }

    public LiveItem(PlayParams playParams, String str, String str2, SliceItem sliceItem) {
        super(playParams);
        this.mQuality = Quality.UNKNOWN;
        this.mPlayUrl = str;
        this.mMasterText = str2;
        this.sliceItem = sliceItem;
    }

    public static boolean compareUrl(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Uri parse = Uri.parse(str);
            Uri parse2 = Uri.parse(str2);
            String path = parse.getPath();
            String path2 = parse2.getPath();
            if (path != null && path.indexOf(46) != -1) {
                path = path.substring(0, path.lastIndexOf(46));
            }
            if (path2 != null && path2.indexOf(46) != -1) {
                path2 = path2.substring(0, path2.lastIndexOf(46));
            }
            return (TextUtils.isEmpty(path) || TextUtils.isEmpty(path2) || !path.equals(path2)) ? false : true;
        }
        return false;
    }

    public Codec getCodec() {
        return this.mCodec;
    }

    public boolean getEnablePursue() {
        return this.mEnablePursue;
    }

    public LivePlayControl getLivePlayControl() {
        return this.mLivePlayControl;
    }

    public String getMasterText() {
        return this.mMasterText;
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public String getPlayUrl() {
        return this.mPlayUrl;
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public Quality getQuality() {
        return this.mQuality;
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public String getStreamType() {
        return this.mStreamType;
    }

    public String getTimeUrl() {
        return this.mTimeUrl;
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public String getVideoFormat() {
        return this.mQuality.getLiveDescription();
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public PlayItem.Result match(PlayItem playItem) {
        if (!(playItem instanceof LiveItem)) {
            PlayItem.Result result = new PlayItem.Result(false);
            result.putValue("code", "1");
            result.putValue("note", "item不是一种类型");
            return new PlayItem.Result(false);
        }
        String str = this.mPlayUrl;
        String playUrl = playItem.getPlayUrl();
        boolean compareUrl = compareUrl(str, playUrl);
        PlayItem.Result result2 = new PlayItem.Result(compareUrl);
        if (!compareUrl) {
            result2.putValue("code", "2");
            result2.putValue("note", "地址不匹配");
        }
        result2.putValue(PlayItem.Result.FIRST_URL, str);
        result2.putValue(PlayItem.Result.SECOND_URL, playUrl);
        return result2;
    }

    public void setCodec(Codec codec) {
        this.mCodec = codec;
    }

    public void setEnablePursue(boolean z) {
        this.mEnablePursue = z;
    }

    public void setLivePlayControl(LivePlayControl livePlayControl) {
        this.mLivePlayControl = livePlayControl;
    }

    public void setQuality(Quality quality) {
        this.mQuality = quality;
    }

    public void setStreamType(String str) {
        this.mStreamType = str;
    }

    public void setTimeUrl(String str) {
        this.mTimeUrl = str;
    }
}
