package com.youku.tinywindow;

import android.app.Activity;
import android.view.ViewGroup;
import com.youku.alixplayer.AlixPlayer;
import com.youku.alixplayer.opensdk.IPlayerContainer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TinyWindowConfig {
    public static final int PLAYER_TYPE_LIVE = 1;
    public static final int PLAYER_TYPE_VOD = 0;
    private boolean isSurportMute = true;
    private boolean isSurportPause = false;
    private Activity mActivity;
    private IPlayerContainer mLivePlayer;
    private String mPlayerId;
    private ViewGroup mPlayerRootContainer;
    private int mPlayerType;
    private ViewGroup mPlayerView;
    private int mPlayerViewHeight;
    private int mPlayerViewWidth;
    private TINYWINDOW_TYPE mType;
    private AlixPlayer mVodPlayer;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum TINYWINDOW_TYPE {
        SYSTEMPIP,
        FLOATINGWINDOW
    }

    public TinyWindowConfig(Activity activity, TINYWINDOW_TYPE tinywindow_type) {
        this.mType = TINYWINDOW_TYPE.SYSTEMPIP;
        this.mActivity = activity;
        this.mType = tinywindow_type;
    }

    private void initFloatingWindowSize(int i, int i2) {
        if ((i * 1.0f) / i2 > 1.0f) {
            int round = Math.round(TinyWindowUtils.getScreenWidth(this.mActivity) / 2);
            this.mPlayerViewWidth = round;
            if (round % 2 == 1) {
                this.mPlayerViewWidth = round - 1;
            }
            int round2 = Math.round((this.mPlayerViewWidth * 9) / 16);
            this.mPlayerViewHeight = round2;
            if (round2 % 2 == 1) {
                this.mPlayerViewHeight = round2 - 1;
                return;
            }
            return;
        }
        int round3 = Math.round((TinyWindowUtils.getScreenWidth(this.mActivity) * 2) / 5);
        this.mPlayerViewWidth = round3;
        if (round3 % 2 == 1) {
            this.mPlayerViewWidth = round3 - 1;
        }
        int round4 = Math.round((this.mPlayerViewWidth * 16) / 9);
        this.mPlayerViewHeight = round4;
        if (round4 % 2 == 1) {
            this.mPlayerViewHeight = round4 - 1;
        }
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public IPlayerContainer getLivePlayer() {
        return this.mLivePlayer;
    }

    public String getPlayerId() {
        return this.mPlayerId;
    }

    public ViewGroup getPlayerRootContainer() {
        return this.mPlayerRootContainer;
    }

    public int getPlayerType() {
        return this.mPlayerType;
    }

    public ViewGroup getPlayerView() {
        return this.mPlayerView;
    }

    public int getPlayerViewHeight() {
        return this.mPlayerViewHeight;
    }

    public int getPlayerViewWidth() {
        return this.mPlayerViewWidth;
    }

    public TINYWINDOW_TYPE getType() {
        return this.mType;
    }

    public AlixPlayer getVodPlayer() {
        return this.mVodPlayer;
    }

    public boolean isSurportMute() {
        return this.isSurportMute;
    }

    public boolean isSurportPause() {
        return this.isSurportPause;
    }

    public void setLivePlayer(IPlayerContainer iPlayerContainer) {
        this.mLivePlayer = iPlayerContainer;
        initFloatingWindowSize(iPlayerContainer.getPlayer().getVideoWidth(), iPlayerContainer.getPlayer().getVideoHeight());
    }

    public void setPlayerId(String str) {
        this.mPlayerId = str;
    }

    public void setPlayerRootContainer(ViewGroup viewGroup) {
        this.mPlayerRootContainer = viewGroup;
    }

    public void setPlayerType(int i) {
        this.mPlayerType = i;
    }

    public void setPlayerView(ViewGroup viewGroup) {
        this.mPlayerView = viewGroup;
    }

    public void setSurportMute(boolean z) {
        this.isSurportMute = z;
    }

    public void setSurportPause(boolean z) {
        this.isSurportPause = z;
    }

    public void setVodPlayer(AlixPlayer alixPlayer) {
        this.mVodPlayer = alixPlayer;
        initFloatingWindowSize(alixPlayer.getVideoWidth(), alixPlayer.getVideoHeight());
    }
}
