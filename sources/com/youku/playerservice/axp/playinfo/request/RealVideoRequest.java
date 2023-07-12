package com.youku.playerservice.axp.playinfo.request;

import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playparams.PlayParams;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class RealVideoRequest implements IPlayInfoRequest {
    private IPlayInfoRequest.Callback mCallback;
    private volatile boolean mIsCancel;
    private PlayParams mPlayParams;
    private IPlayInfoRequest.State mState = IPlayInfoRequest.State.IDLE;
    private UpsRequest mUpsRequest;

    public RealVideoRequest(PlayerConfig playerConfig) {
        this.mUpsRequest = new UpsRequest(playerConfig);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void cancel() {
        this.mIsCancel = true;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public List<PlayInfoResponse> getPlayInfoResponses() {
        return null;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public PlayParams getPlayParams() {
        return this.mPlayParams;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public IPlayInfoRequest.State getState() {
        return this.mState;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void request(PlayParams playParams) {
        if (this.mIsCancel) {
            return;
        }
        this.mState = IPlayInfoRequest.State.RUNNING;
        this.mPlayParams = playParams;
        this.mUpsRequest.setRequestCallback(new IPlayInfoRequest.Callback() { // from class: com.youku.playerservice.axp.playinfo.request.RealVideoRequest.1
            @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest.Callback
            public void onFinished(PlayParams playParams2, List<PlayInfoResponse> list) {
                RealVideoRequest.this.mState = IPlayInfoRequest.State.FINISHED;
                if (RealVideoRequest.this.mCallback != null) {
                    RealVideoRequest.this.mCallback.onFinished(playParams2, list);
                }
            }
        });
        playParams.getPlayIdParams().setDisableAd(true);
        playParams.getPlayIdParams().setDisableBfAd(true);
        playParams.getPlayIdParams().setDisableH265(true);
        this.mUpsRequest.request(playParams);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void setRequestCallback(IPlayInfoRequest.Callback callback) {
        this.mCallback = callback;
    }
}
