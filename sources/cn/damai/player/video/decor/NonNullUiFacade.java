package cn.damai.player.video.decor;

import android.view.View;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.listener.VideoOperateListener;
import cn.damai.player.video.view.VideoView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class NonNullUiFacade extends BaseVideoUiFacade {
    private static transient /* synthetic */ IpChange $ipChange;
    private BaseVideoUiFacade real;

    public NonNullUiFacade(VideoView videoView) {
        super(videoView);
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public View getView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1462043421")) {
            return (View) ipChange.ipc$dispatch("-1462043421", new Object[]{this});
        }
        BaseVideoUiFacade baseVideoUiFacade = this.real;
        if (baseVideoUiFacade != null) {
            return baseVideoUiFacade.getView();
        }
        return null;
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void setOpListener(VideoOperateListener videoOperateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "171627819")) {
            ipChange.ipc$dispatch("171627819", new Object[]{this, videoOperateListener});
            return;
        }
        super.setOpListener(videoOperateListener);
        BaseVideoUiFacade baseVideoUiFacade = this.real;
        if (baseVideoUiFacade != null) {
            baseVideoUiFacade.setOpListener(this.mOperateListener);
        }
    }

    public void setReal(BaseVideoUiFacade baseVideoUiFacade) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1790887998")) {
            ipChange.ipc$dispatch("1790887998", new Object[]{this, baseVideoUiFacade});
            return;
        }
        this.real = baseVideoUiFacade;
        setOpListener(this.mOperateListener);
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void showMute(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1278751836")) {
            ipChange.ipc$dispatch("1278751836", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        BaseVideoUiFacade baseVideoUiFacade = this.real;
        if (baseVideoUiFacade != null) {
            baseVideoUiFacade.showMute(z);
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void updateMute(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "651229288")) {
            ipChange.ipc$dispatch("651229288", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        BaseVideoUiFacade baseVideoUiFacade = this.real;
        if (baseVideoUiFacade != null) {
            baseVideoUiFacade.updateMute(z);
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-62935224")) {
            ipChange.ipc$dispatch("-62935224", new Object[]{this});
            return;
        }
        BaseVideoUiFacade baseVideoUiFacade = this.real;
        if (baseVideoUiFacade != null) {
            baseVideoUiFacade.videoComplete();
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoEndLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "62222496")) {
            ipChange.ipc$dispatch("62222496", new Object[]{this});
            return;
        }
        BaseVideoUiFacade baseVideoUiFacade = this.real;
        if (baseVideoUiFacade != null) {
            baseVideoUiFacade.videoEndLoading();
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoError(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1467498452")) {
            ipChange.ipc$dispatch("-1467498452", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        BaseVideoUiFacade baseVideoUiFacade = this.real;
        if (baseVideoUiFacade != null) {
            baseVideoUiFacade.videoError(i, str);
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoIdle(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1094866431")) {
            ipChange.ipc$dispatch("1094866431", new Object[]{this, videoInfo});
            return;
        }
        BaseVideoUiFacade baseVideoUiFacade = this.real;
        if (baseVideoUiFacade != null) {
            baseVideoUiFacade.videoIdle(videoInfo);
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1962197107")) {
            ipChange.ipc$dispatch("-1962197107", new Object[]{this});
            return;
        }
        BaseVideoUiFacade baseVideoUiFacade = this.real;
        if (baseVideoUiFacade != null) {
            baseVideoUiFacade.videoLoading();
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1525919123")) {
            ipChange.ipc$dispatch("1525919123", new Object[]{this});
            return;
        }
        BaseVideoUiFacade baseVideoUiFacade = this.real;
        if (baseVideoUiFacade != null) {
            baseVideoUiFacade.videoPause();
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoPlaying() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-163146917")) {
            ipChange.ipc$dispatch("-163146917", new Object[]{this});
            return;
        }
        BaseVideoUiFacade baseVideoUiFacade = this.real;
        if (baseVideoUiFacade != null) {
            baseVideoUiFacade.videoPlaying();
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1569023911")) {
            ipChange.ipc$dispatch("1569023911", new Object[]{this});
            return;
        }
        BaseVideoUiFacade baseVideoUiFacade = this.real;
        if (baseVideoUiFacade != null) {
            baseVideoUiFacade.videoStart();
        }
    }
}
