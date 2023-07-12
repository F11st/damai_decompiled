package cn.damai.player.video.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.decor.BaseVideoUiFacade;
import cn.damai.player.video.listener.VideoListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class FadeVideoView extends ResizeFrameLayout implements ApiPlayer {
    private static transient /* synthetic */ IpChange $ipChange;
    private BaseVideoUiFacade mFacade;
    private VideoInfo mVideoInfo;

    public FadeVideoView(@NonNull Context context) {
        this(context, null);
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public int getDuration() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1669585021")) {
            return ((Integer) ipChange.ipc$dispatch("1669585021", new Object[]{this})).intValue();
        }
        return -1;
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public VideoInfo getPlayInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1586352404") ? (VideoInfo) ipChange.ipc$dispatch("-1586352404", new Object[]{this}) : this.mVideoInfo;
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public String getSessionId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1203877755")) {
            return (String) ipChange.ipc$dispatch("-1203877755", new Object[]{this});
        }
        return null;
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void idle(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1515902036")) {
            ipChange.ipc$dispatch("1515902036", new Object[]{this, videoInfo});
        } else if (videoInfo == null) {
        } else {
            this.mVideoInfo = videoInfo;
            this.mFacade.videoIdle(videoInfo);
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isMute() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2004020617")) {
            return ((Boolean) ipChange.ipc$dispatch("-2004020617", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isPaused() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1995971198")) {
            return ((Boolean) ipChange.ipc$dispatch("-1995971198", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isPlaying() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "506485108")) {
            return ((Boolean) ipChange.ipc$dispatch("506485108", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void mute(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1468248887")) {
            ipChange.ipc$dispatch("1468248887", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1874835806")) {
            ipChange.ipc$dispatch("1874835806", new Object[]{this});
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void play(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1315029772")) {
            ipChange.ipc$dispatch("-1315029772", new Object[]{this, videoInfo});
        } else if (videoInfo == null) {
        } else {
            this.mVideoInfo = videoInfo;
            this.mFacade.videoIdle(videoInfo);
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "708953581")) {
            ipChange.ipc$dispatch("708953581", new Object[]{this});
        }
    }

    public void setFacade(BaseVideoUiFacade baseVideoUiFacade) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1600119550")) {
            ipChange.ipc$dispatch("-1600119550", new Object[]{this, baseVideoUiFacade});
            return;
        }
        this.mFacade = baseVideoUiFacade;
        removeAllViews();
        View view = this.mFacade.getView();
        this.mFacade.showMute(false);
        addView(view, -1, -1);
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void setListener(VideoListener videoListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1200506926")) {
            ipChange.ipc$dispatch("-1200506926", new Object[]{this, videoListener});
        } else {
            this.mFacade.setOpListener(videoListener);
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1917940594")) {
            ipChange.ipc$dispatch("1917940594", new Object[]{this});
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-618070860")) {
            ipChange.ipc$dispatch("-618070860", new Object[]{this});
        }
    }

    public FadeVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FadeVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
