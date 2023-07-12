package com.youku.upsplayer;

import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.upsplayer.request.NetworkParameter;
import com.youku.upsplayer.request.PlayVideoInfo;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IUpsInfoRequest {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface IUpsInfoRequestCallback {
        void onFailure(UpsRequestError upsRequestError);

        void onSuccess(VideoInfo videoInfo, ConnectStat connectStat);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class UpsRequestError {
        private int mErrorCode;
        private String mErrorMsg;
        private RequestData mRequestData;

        public UpsRequestError(int i, String str, RequestData requestData) {
            this.mErrorCode = i;
            this.mErrorMsg = str;
            this.mRequestData = requestData;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public String getErrorMsg() {
            return this.mErrorMsg;
        }

        public RequestData getRequestData() {
            return this.mRequestData;
        }
    }

    void request(PlayVideoInfo playVideoInfo, Map<String, String> map, Map<String, String> map2, NetworkParameter networkParameter, IUpsInfoRequestCallback iUpsInfoRequestCallback);
}
