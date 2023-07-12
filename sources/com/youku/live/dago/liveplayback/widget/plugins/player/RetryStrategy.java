package com.youku.live.dago.liveplayback.widget.plugins.player;

import android.os.Message;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.interceptor.Chain;
import com.youku.alixplayer.opensdk.interceptor.Interceptor;
import com.youku.alixplayer.opensdk.utils.TLogUtil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class RetryStrategy implements OnVideoStreamListener, Interceptor {
    private static transient /* synthetic */ IpChange $ipChange;
    private IPlayerContainer mPlayerContainer;
    private int mRetryCount = 1;

    public RetryStrategy(IPlayerContainer iPlayerContainer) {
        this.mPlayerContainer = iPlayerContainer;
        iPlayerContainer.addInterceptor(this);
    }

    private boolean needRetry(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1510192000")) {
            return ((Boolean) ipChange.ipc$dispatch("1510192000", new Object[]{this, message})).booleanValue();
        }
        int i = message.arg1;
        return i != 30010 && i != 31910 && i > 30000 && i < 33203;
    }

    @Override // com.youku.alixplayer.opensdk.interceptor.Interceptor
    public void intercept(Chain<Object> chain) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1075563792")) {
            ipChange.ipc$dispatch("-1075563792", new Object[]{this, chain});
            return;
        }
        if (chain.getAction() == 3) {
            Message message = (Message) chain.getParam();
            if (this.mRetryCount > 0 && needRetry(message)) {
                this.mRetryCount--;
                TLogUtil.playLog("满足重试条件，进行重试", this.mPlayerContainer.getPlayer());
                this.mPlayerContainer.getPlayer().replay();
                return;
            }
        }
        chain.proceed();
    }

    @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
    public void onDataFail(VideoRequestError videoRequestError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "812011394")) {
            ipChange.ipc$dispatch("812011394", new Object[]{this, videoRequestError});
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
    public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1227345665")) {
            ipChange.ipc$dispatch("1227345665", new Object[]{this, youkuVideoInfo});
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
    public void onNewRequest(PlayVideoInfo playVideoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-685739974")) {
            ipChange.ipc$dispatch("-685739974", new Object[]{this, playVideoInfo});
        } else {
            this.mRetryCount = 1;
        }
    }
}
