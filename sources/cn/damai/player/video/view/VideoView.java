package cn.damai.player.video.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.decor.BaseVideoUiFacade;
import cn.damai.player.video.decor.NonNullUiFacade;
import cn.damai.player.video.listener.VideoListener;
import cn.damai.videoplayer.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.youkuplayer.IYoukuPlayer;
import com.youku.youkuplayer.YoukuPlayer;
import com.youku.youkuplayer.data.PlayParam;
import tb.bt;
import tb.mu0;
import tb.ws;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class VideoView extends ResizeFrameLayout implements ApiPlayer {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isMute;
    private VideoInfo mInfo;
    private MainThreadVideoListener mMainEventDispatcher;
    private IYoukuPlayer mPlayer;
    private NonNullUiFacade mUiFacade;
    private VideoListener mVideoListener;

    public VideoView(@NonNull Context context) {
        this(context, null);
    }

    private void removeDecorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "96555762")) {
            ipChange.ipc$dispatch("96555762", new Object[]{this});
            return;
        }
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() == R$id.id_video_decor) {
                view = childAt;
            }
        }
        if (view != null) {
            removeView(view);
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public int getDuration() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-283407263") ? ((Integer) ipChange.ipc$dispatch("-283407263", new Object[]{this})).intValue() : this.mPlayer.getDuration();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public VideoInfo getPlayInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1923803000") ? (VideoInfo) ipChange.ipc$dispatch("-1923803000", new Object[]{this}) : this.mInfo;
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public String getSessionId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2049854313") ? (String) ipChange.ipc$dispatch("2049854313", new Object[]{this}) : this.mPlayer.getSessionId();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void idle(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-22797584")) {
            ipChange.ipc$dispatch("-22797584", new Object[]{this, videoInfo});
            return;
        }
        this.mUiFacade.videoIdle(videoInfo);
        this.mPlayer.pause();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isMute() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-295337965") ? ((Boolean) ipChange.ipc$dispatch("-295337965", new Object[]{this})).booleanValue() : this.isMute;
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isPaused() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-629449698") ? ((Boolean) ipChange.ipc$dispatch("-629449698", new Object[]{this})).booleanValue() : this.mPlayer.isPaused();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isPlaying() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-81021352") ? ((Boolean) ipChange.ipc$dispatch("-81021352", new Object[]{this})).booleanValue() : this.mPlayer.isStarted();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void mute(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1940315621")) {
            ipChange.ipc$dispatch("-1940315621", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isMute = z;
        this.mPlayer.setMuted(z);
        this.mUiFacade.updateMute(z);
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1533728702")) {
            ipChange.ipc$dispatch("-1533728702", new Object[]{this});
        } else {
            this.mPlayer.pause();
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void play(VideoInfo videoInfo) {
        PlayParam playVideoInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1441237904")) {
            ipChange.ipc$dispatch("1441237904", new Object[]{this, videoInfo});
        } else if (videoInfo == null || (playVideoInfo = videoInfo.toPlayVideoInfo()) == null) {
        } else {
            this.mInfo = videoInfo;
            this.mUiFacade.videoIdle(videoInfo);
            try {
                this.mPlayer.playVideo(playVideoInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2138508241")) {
            ipChange.ipc$dispatch("2138508241", new Object[]{this});
        } else {
            this.mPlayer.release();
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void setListener(VideoListener videoListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1655554890")) {
            ipChange.ipc$dispatch("-1655554890", new Object[]{this, videoListener});
            return;
        }
        this.mVideoListener = videoListener;
        this.mMainEventDispatcher.j(videoListener);
        this.mUiFacade.setOpListener(this.mVideoListener);
    }

    public void setUiFacade(BaseVideoUiFacade baseVideoUiFacade) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-486930798")) {
            ipChange.ipc$dispatch("-486930798", new Object[]{this, baseVideoUiFacade});
            return;
        }
        this.mUiFacade.setReal(baseVideoUiFacade);
        removeDecorView();
        View view = this.mUiFacade.getView();
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            view.setId(R$id.id_video_decor);
            addView(view, -1, -1);
        }
        this.mUiFacade.updateMute(this.isMute);
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1490623914")) {
            ipChange.ipc$dispatch("-1490623914", new Object[]{this});
        } else {
            this.mPlayer.start();
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1211638096")) {
            ipChange.ipc$dispatch("1211638096", new Object[]{this});
        } else {
            this.mPlayer.stop();
        }
    }

    public VideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mUiFacade = new NonNullUiFacade(this);
        IYoukuPlayer create = YoukuPlayer.create(mu0.a(), new ws().a(), null);
        this.mPlayer = create;
        create.setWaterMarkImageView(new bt(context));
        MainThreadVideoListener mainThreadVideoListener = new MainThreadVideoListener(this, this.mUiFacade);
        this.mMainEventDispatcher = mainThreadVideoListener;
        this.mPlayer.addPlayerEventListener(mainThreadVideoListener);
        addView(this.mPlayer.getView(), -1, -1);
        mute(true);
    }
}
