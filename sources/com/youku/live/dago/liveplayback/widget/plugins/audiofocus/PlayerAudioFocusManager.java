package com.youku.live.dago.liveplayback.widget.plugins.audiofocus;

import android.content.Context;
import android.media.AudioManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.opensdk.IPlayer;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.tinywindow.TinyWindowManager;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PlayerAudioFocusManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String TAG = "PlayerAudioFocusManager";
    private AudioManager mAudioManager;
    private Context mContext;
    private IPlayerContainer mPlayerContainer;
    private boolean mIsAudioFocusLoss = false;
    private AudioManager.OnAudioFocusChangeListener mAudioFocusChange = new AudioManager.OnAudioFocusChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.audiofocus.PlayerAudioFocusManager.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1434470056")) {
                ipChange.ipc$dispatch("1434470056", new Object[]{this, Integer.valueOf(i)});
            } else if (i == -3) {
                Logger.d(PlayerAudioFocusManager.TAG, "AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
            } else if (i == -2) {
                Logger.d(PlayerAudioFocusManager.TAG, "AUDIOFOCUS_LOSS_TRANSIENT");
                if (PlayerAudioFocusManager.this.mPlayerContainer == null || PlayerAudioFocusManager.this.mPlayerContainer.getPlayer().getCurrentState() != IAlixPlayer.State.STATE_VIDEO_STARTED) {
                    return;
                }
                PlayerAudioFocusManager.this.mIsAudioFocusLoss = true;
                PlayerAudioFocusManager.this.stop();
            } else if (i != -1) {
                if (i != 1) {
                    return;
                }
                Logger.d(PlayerAudioFocusManager.TAG, "AUDIOFOCUS_GAIN");
            } else {
                Logger.d(PlayerAudioFocusManager.TAG, "AUDIOFOCUS_LOSS");
                if (PlayerAudioFocusManager.this.mPlayerContainer == null || PlayerAudioFocusManager.this.mPlayerContainer.getPlayer().getCurrentState() != IAlixPlayer.State.STATE_VIDEO_STARTED) {
                    return;
                }
                PlayerAudioFocusManager.this.mIsAudioFocusLoss = true;
                PlayerAudioFocusManager.this.stop();
            }
        }
    };

    public PlayerAudioFocusManager(Context context) {
        this.mContext = context;
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-34076547")) {
            ipChange.ipc$dispatch("-34076547", new Object[]{this});
            return;
        }
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            TLogUtil.playLog("失去音频焦点停止播放", iPlayerContainer.getPlayer());
            if (TinyWindowManager.getInstance().isInTinyWindowMode()) {
                return;
            }
            if (this.mPlayerContainer.getPlayer().getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                this.mPlayerContainer.getPlayer().stop();
            }
            for (IPlayer iPlayer : this.mPlayerContainer.getMultiPlayer().getPlayers()) {
                if (iPlayer.getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                    iPlayer.stop();
                }
            }
        }
    }

    public void abandonAudioFocus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-394115820")) {
            ipChange.ipc$dispatch("-394115820", new Object[]{this});
            return;
        }
        this.mPlayerContainer = null;
        this.mAudioManager.abandonAudioFocus(this.mAudioFocusChange);
    }

    public boolean isAudioFocusLoss() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1305032116") ? ((Boolean) ipChange.ipc$dispatch("1305032116", new Object[]{this})).booleanValue() : this.mIsAudioFocusLoss;
    }

    public void requestAudioFocus(IPlayerContainer iPlayerContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1227483407")) {
            ipChange.ipc$dispatch("-1227483407", new Object[]{this, iPlayerContainer});
            return;
        }
        this.mPlayerContainer = iPlayerContainer;
        this.mAudioManager.requestAudioFocus(this.mAudioFocusChange, 3, 1);
    }

    public void setAudioFocusLoss(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "278039344")) {
            ipChange.ipc$dispatch("278039344", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsAudioFocusLoss = z;
        }
    }
}
