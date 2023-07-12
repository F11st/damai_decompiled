package com.youku.alixplayer.opensdk.statistics;

import android.text.TextUtils;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.param.CustomParams;
import com.youku.alixplayer.opensdk.statistics.track.AdErrorTrack;
import com.youku.alixplayer.opensdk.statistics.track.AdImpairmentTrack;
import com.youku.alixplayer.opensdk.statistics.track.AdPlayTrack;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AdTrack {
    private AdErrorTrack mAdErrorTrack;
    private AdImpairmentTrack mAdImpairmentTrack;
    private AdPlayTrack mAdPlayTrack;
    private long mEndPreAdTime;
    private long mStartPreAdTime;
    private Track mTrack;
    private String mAdType = "无广告";
    private IAlixPlayer.State mState = IAlixPlayer.State.STATE_IDLE;

    public AdTrack(Track track) {
        this.mTrack = track;
        this.mAdPlayTrack = new AdPlayTrack(track);
        this.mAdErrorTrack = new AdErrorTrack(track);
    }

    private int getAdTypeByArg(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 2;
        }
        return i == 3 ? 1 : 3;
    }

    private long getCurrentTime() {
        return System.nanoTime() / 1000000;
    }

    private boolean isAdPlayError(int i) {
        return i == 2005 || i == 2205 || i == 1110 || i == 2200 || (i == 1006 && isAdShowing()) || ((i == 2201 && isMidAdShowing()) || ((i == 1002 && (isAdShowing() || isMidAdShowing())) || ((i == 1008 && (isAdShowing() || isMidAdShowing())) || (i == 2004 && (isAdShowing() || isMidAdShowing())))));
    }

    public String getAdType() {
        return this.mAdType;
    }

    public int getAdTypeForVpm() {
        if (isPreAdShowing()) {
            return 0;
        }
        if (isPostAdShowing()) {
            return 1;
        }
        isMidAdShowing();
        return 2;
    }

    public long getEndPreAdTime() {
        return this.mEndPreAdTime;
    }

    public boolean isAdShowing() {
        IAlixPlayer.State state = this.mState;
        return state == IAlixPlayer.State.STATE_PRE_AD_STARTED || state == IAlixPlayer.State.STATE_PRE_AD_PAUSED || state == IAlixPlayer.State.STATE_MID_AD_STARTED || state == IAlixPlayer.State.STATE_MID_AD_PAUSED || state == IAlixPlayer.State.STATE_POST_AD_STARTED || state == IAlixPlayer.State.STATE_POST_AD_PAUSED;
    }

    public boolean isMidAdShowing() {
        IAlixPlayer.State state = this.mState;
        return state == IAlixPlayer.State.STATE_MID_AD_STARTED || state == IAlixPlayer.State.STATE_MID_AD_PAUSED;
    }

    public boolean isPostAdShowing() {
        IAlixPlayer.State state = this.mState;
        return state == IAlixPlayer.State.STATE_POST_AD_STARTED || state == IAlixPlayer.State.STATE_POST_AD_PAUSED;
    }

    public boolean isPreAdShowing() {
        IAlixPlayer.State state = this.mState;
        return state == IAlixPlayer.State.STATE_PRE_AD_STARTED || state == IAlixPlayer.State.STATE_PRE_AD_PAUSED;
    }

    public void onEndLoading() {
        AdImpairmentTrack adImpairmentTrack = this.mAdImpairmentTrack;
        if (adImpairmentTrack != null) {
            adImpairmentTrack.commit();
        }
    }

    public boolean onError(int i, int i2, Object obj, PlayVideoInfo playVideoInfo, YoukuVideoInfo youkuVideoInfo) {
        if (playVideoInfo == null || youkuVideoInfo == null || !isAdPlayError(i)) {
            return false;
        }
        this.mAdErrorTrack.commit(getAdTypeForVpm(), i2, youkuVideoInfo);
        return true;
    }

    public void onMidAdStart(int i, YoukuVideoInfo youkuVideoInfo) {
        this.mAdPlayTrack.commit(2, i);
    }

    public void onPreAdEnd(int i) {
        this.mEndPreAdTime = getCurrentTime();
    }

    public void onPreAdStart(int i) {
        this.mAdType = "视频";
        if (this.mStartPreAdTime == 0) {
            this.mStartPreAdTime = getCurrentTime();
        }
        this.mAdPlayTrack.commit(0, i);
    }

    public void onRealVideoStart() {
        this.mState = IAlixPlayer.State.STATE_VIDEO_STARTED;
    }

    public void onStartLoading(int i) {
        this.mAdImpairmentTrack = new AdImpairmentTrack(this.mTrack, getAdTypeByArg(i));
    }

    public void onStartPlayPostAD(int i) {
        this.mAdPlayTrack.commit(1, i);
    }

    public void onVideoSliceStart(int i, int i2, Object obj) {
        if (this.mAdPlayTrack == null) {
            return;
        }
        String value = new CustomParams(String.valueOf(obj)).getValue("url");
        if (TextUtils.isEmpty(value)) {
            return;
        }
        if (value.contains("/ad/") || value.contains("ccode=0902")) {
            this.mAdPlayTrack.commit(3, i);
        }
    }
}
