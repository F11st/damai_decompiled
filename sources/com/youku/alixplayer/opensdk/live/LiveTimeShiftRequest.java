package com.youku.alixplayer.opensdk.live;

import android.content.Context;
import com.youku.alixplayer.opensdk.IVideoRequest;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class LiveTimeShiftRequest implements IVideoRequest {
    public static final String TAG = "LiveTimeShiftRequest";
    protected IVideoRequest.Callback mCallback;
    protected Context mContext;
    protected volatile boolean mIsCancel;
    protected PlayerConfig mPlayerConfig;
    protected IVideoRequest.State mState = IVideoRequest.State.IDLE;

    public LiveTimeShiftRequest(Context context, PlayerConfig playerConfig) {
        this.mContext = context;
        this.mPlayerConfig = playerConfig;
    }

    private void reportError(IVideoRequest.Callback callback, VideoRequestError videoRequestError) {
        if (callback == null || this.mIsCancel) {
            return;
        }
        callback.onFailure(videoRequestError);
    }

    private void reportSuccess(IVideoRequest.Callback callback, LiveInfo liveInfo, List<LiveInfo> list) {
        if (callback == null || this.mIsCancel) {
            return;
        }
        callback.onSuccess(liveInfo, list);
    }

    @Override // com.youku.alixplayer.opensdk.IVideoRequest
    public void cancel() {
        this.mIsCancel = true;
    }

    public IVideoRequest.State getState() {
        return this.mState;
    }

    @Override // com.youku.alixplayer.opensdk.IVideoRequest
    public void request(PlayVideoInfo playVideoInfo, Map map) {
        TLogUtil.playLog("request live shift liveId=" + playVideoInfo.getLiveId());
        this.mState = IVideoRequest.State.DOING;
        this.mState = IVideoRequest.State.FINISH;
        LiveInfo liveInfo = (LiveInfo) playVideoInfo.getTag("liveInfo");
        ArrayList arrayList = new ArrayList();
        if (liveInfo != null) {
            reportSuccess(this.mCallback, liveInfo, arrayList);
            return;
        }
        VideoRequestError videoRequestError = new VideoRequestError(playVideoInfo);
        videoRequestError.setErrorCode(28001);
        videoRequestError.setErrorMsg("liveInfo为空");
        reportError(this.mCallback, videoRequestError);
    }

    @Override // com.youku.alixplayer.opensdk.IVideoRequest
    public void setVideoRequestListener(IVideoRequest.Callback callback) {
        this.mCallback = callback;
    }
}
