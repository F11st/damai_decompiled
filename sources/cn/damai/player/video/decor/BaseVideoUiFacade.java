package cn.damai.player.video.decor;

import android.view.View;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.listener.VideoOperateListener;
import cn.damai.player.video.view.ApiPlayer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public abstract class BaseVideoUiFacade implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    protected ApiPlayer mApiPlayer;
    protected VideoOperateListener mOperateListener;

    public BaseVideoUiFacade(ApiPlayer apiPlayer) {
        this.mApiPlayer = apiPlayer;
    }

    public abstract View getView();

    public void setOpListener(VideoOperateListener videoOperateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1749968545")) {
            ipChange.ipc$dispatch("1749968545", new Object[]{this, videoOperateListener});
        } else {
            this.mOperateListener = videoOperateListener;
        }
    }

    public abstract void showMute(boolean z);

    public abstract void updateMute(boolean z);

    public abstract void videoComplete();

    public abstract void videoEndLoading();

    public abstract void videoError(int i, String str);

    public abstract void videoIdle(VideoInfo videoInfo);

    public abstract void videoLoading();

    public abstract void videoPause();

    public abstract void videoPlaying();

    public abstract void videoStart();
}
