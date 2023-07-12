package cn.damai.discover.content.ui.viewholder.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.player.DMVideoPlayer;
import cn.damai.player.controller.muteonly.DMVideoPlayerMuteOnlyController;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ContentVideoView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMVideoPlayerMuteOnlyController mController;
    private DMVideoPlayer mPlayer;
    private VideoInfo mVideoInfo;

    public ContentVideoView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1276644796")) {
            ipChange.ipc$dispatch("1276644796", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.widget_content_video, (ViewGroup) this, true);
        DMVideoPlayer dMVideoPlayer = (DMVideoPlayer) findViewById(R$id.player_content_detail);
        this.mPlayer = dMVideoPlayer;
        dMVideoPlayer.setBackgroundColor(-16777216);
        DMVideoPlayerMuteOnlyController dMVideoPlayerMuteOnlyController = new DMVideoPlayerMuteOnlyController(context);
        this.mController = dMVideoPlayerMuteOnlyController;
        dMVideoPlayerMuteOnlyController.setLoopOnWifi(true);
        this.mController.setAutoReport(true);
        this.mController.setSpmData("content", "top");
        this.mPlayer.setController(this.mController);
    }

    public void autoPlayMuted() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-40013434")) {
            ipChange.ipc$dispatch("-40013434", new Object[]{this});
        } else if (this.mPlayer != null) {
            this.mController.setPlayerMute(true);
            this.mPlayer.autoPlay();
        }
    }

    public DMVideoPlayer getPlayer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1361004408") ? (DMVideoPlayer) ipChange.ipc$dispatch("-1361004408", new Object[]{this}) : this.mPlayer;
    }

    public void pausePlayer(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1975791389")) {
            ipChange.ipc$dispatch("1975791389", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        DMVideoPlayer dMVideoPlayer = this.mPlayer;
        if (dMVideoPlayer != null) {
            dMVideoPlayer.pause(z);
        }
    }

    public void releasePlayer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480066918")) {
            ipChange.ipc$dispatch("480066918", new Object[]{this});
            return;
        }
        DMVideoPlayer dMVideoPlayer = this.mPlayer;
        if (dMVideoPlayer != null) {
            dMVideoPlayer.release();
            this.mPlayer = null;
        }
    }

    public void setDataSource(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1107787929")) {
            ipChange.ipc$dispatch("1107787929", new Object[]{this, videoInfo});
        } else {
            this.mVideoInfo = videoInfo;
        }
    }

    public void setPlayerClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2091084202")) {
            ipChange.ipc$dispatch("-2091084202", new Object[]{this, onClickListener});
            return;
        }
        DMVideoPlayerMuteOnlyController dMVideoPlayerMuteOnlyController = this.mController;
        if (dMVideoPlayerMuteOnlyController != null) {
            dMVideoPlayerMuteOnlyController.setVideoCoverClickListener(onClickListener);
        }
    }

    public void setPlayerSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-50109686")) {
            ipChange.ipc$dispatch("-50109686", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        DMVideoPlayer dMVideoPlayer = this.mPlayer;
        if (dMVideoPlayer != null) {
            dMVideoPlayer.setVideoPlayerSize(i, i2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
            layoutParams.gravity = 17;
            this.mPlayer.setLayoutParams(layoutParams);
        }
    }

    public void setupPlayer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1879861744")) {
            ipChange.ipc$dispatch("1879861744", new Object[]{this});
            return;
        }
        this.mPlayer.setVideoData(this.mVideoInfo);
        this.mController.setVideoCoverImage(this.mVideoInfo.getPicUrl());
    }

    public void startPlayer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-368954965")) {
            ipChange.ipc$dispatch("-368954965", new Object[]{this});
            return;
        }
        DMVideoPlayer dMVideoPlayer = this.mPlayer;
        if (dMVideoPlayer != null) {
            if (dMVideoPlayer.isPause()) {
                this.mPlayer.start();
            } else {
                this.mPlayer.play();
            }
        }
    }

    public ContentVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ContentVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public ContentVideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
    }
}
