package com.alimm.xadsdk.request;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.base.model.AdInfo;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.base.model.SeatInfo;
import com.alimm.xadsdk.base.net.AdNetResponse;
import com.alimm.xadsdk.base.net.INetAdapter;
import com.alimm.xadsdk.base.net.INetCallback;
import com.alimm.xadsdk.base.net.NetRequestCallback;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.base.utils.Utils;
import com.alimm.xadsdk.info.GlobalInfoManager;
import com.alimm.xadsdk.request.builder.PasterAdRequestBuilder;
import com.alimm.xadsdk.request.builder.RequestInfo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AdRequestManager {
    private static final int EVENT_NET_REQUEST_FINISHED = 0;
    private static final int RESPONSE_CODE_SUCCEED = 200;
    private static final String TAG = "AdRequestManager";
    private INetAdapter mAdapter;
    private final Handler mHandler;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class AdRequestCallback implements INetCallback {
        private RequestParams mRequestParams;

        AdRequestCallback(RequestParams requestParams) {
            this.mRequestParams = requestParams;
        }

        @Override // com.alimm.xadsdk.base.net.INetCallback
        public void onFailed(int i, String str) {
            AdNetResponse adNetResponse = new AdNetResponse(i, str, i, null);
            adNetResponse.setCallSucceed(false);
            this.mRequestParams.setAdResponse(adNetResponse);
            if (this.mRequestParams.isMainThreadCallback) {
                Message.obtain(AdRequestManager.this.mHandler, 0, this.mRequestParams).sendToTarget();
            } else {
                AdRequestManager.this.handleNetRequestFinished(this.mRequestParams);
            }
        }

        @Override // com.alimm.xadsdk.base.net.INetCallback
        public void onSuccess(AdNetResponse adNetResponse) {
            this.mRequestParams.setAdResponse(adNetResponse);
            AdRequestManager.this.parseObject(this.mRequestParams);
            if (this.mRequestParams.isMainThreadCallback) {
                Message.obtain(AdRequestManager.this.mHandler, 0, this.mRequestParams).sendToTarget();
            } else {
                AdRequestManager.this.handleNetRequestFinished(this.mRequestParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class RequestParams {
        private static AtomicLong sUniqueIdGenerator = new AtomicLong(0);
        private NetRequestCallback callback;
        private Class clazz;
        private String content;
        private boolean isMainThreadCallback;
        private boolean needAddCookie;
        private Object parseObject;
        private long id = sUniqueIdGenerator.getAndIncrement();
        private AdNetResponse adResponse = null;

        RequestParams(Class cls, boolean z, NetRequestCallback netRequestCallback, boolean z2) {
            this.clazz = cls;
            this.needAddCookie = z;
            this.callback = netRequestCallback;
            this.isMainThreadCallback = z2;
        }

        void setAdResponse(AdNetResponse adNetResponse) {
            this.adResponse = adNetResponse;
        }

        public String toString() {
            return "{RequestParams:id=" + this.id + ", clazz = " + this.clazz + ", needAddCookie = " + this.needAddCookie + ", callback = " + this.callback + ", adResponse = " + this.adResponse + "}";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    private static class SingletonHolder {
        static final AdRequestManager INSTANCE = new AdRequestManager();

        private SingletonHolder() {
        }
    }

    private AdRequestManager() {
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.alimm.xadsdk.request.AdRequestManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 0) {
                    return;
                }
                AdRequestManager.this.handleNetRequestFinished((RequestParams) message.obj);
            }
        };
        this.mAdapter = AdSdkManager.getInstance().getConfig().getRequestConfig().getNetAdapter();
    }

    private void addExtendInfo(AdInfo adInfo) {
        if (adInfo == null || adInfo.getSeatList() == null) {
            return;
        }
        for (SeatInfo seatInfo : adInfo.getSeatList()) {
            if (seatInfo.getBidList() != null) {
                for (BidInfo bidInfo : seatInfo.getBidList()) {
                    bidInfo.putExtend("reqid", adInfo.getRequestId());
                }
            }
        }
    }

    public static AdRequestManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static Map<String, String> getVideoBannerAdQueryParams() {
        return RequestUtils.getAdQueryParams(2002, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNetRequestFinished(RequestParams requestParams) {
        if (requestParams == null || requestParams.callback == null || requestParams.adResponse == null) {
            if (LogUtils.DEBUG) {
                LogUtils.i(TAG, "handleNetRequestFinished finish because response is null.");
            }
            onRequestFailed(requestParams);
        } else if (requestParams.adResponse.isCallSucceed() && requestParams.adResponse.getResponseCode() == 200) {
            onRequestSucceed(requestParams);
        } else {
            onRequestFailed(requestParams);
        }
    }

    private void onRequestFailed(RequestParams requestParams) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "onRequestFailed: requestParams = " + requestParams);
        }
        if (requestParams == null || requestParams.callback == null) {
            return;
        }
        try {
            requestParams.callback.onFailed(requestParams.adResponse.getErrorCode(), requestParams.adResponse.getErrorMsg());
        } catch (Exception e) {
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "onRequestFailed: exception.", e);
            }
            requestParams.callback.onFailed(999, "");
        }
    }

    private void onRequestSucceed(@NonNull RequestParams requestParams) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "onRequestSucceed: requestParams = " + requestParams);
        }
        if (requestParams.callback != null) {
            if (requestParams.parseObject == null || requestParams.content == null) {
                requestParams.callback.onFailed(-202, "");
                return;
            }
            if (requestParams.needAddCookie) {
                storeCookie(requestParams.adResponse);
            }
            addExtendInfo(requestParams.parseObject instanceof AdInfo ? (AdInfo) requestParams.parseObject : null);
            requestParams.callback.onSuccess(requestParams.parseObject, requestParams.adResponse, requestParams.content);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseObject(@NonNull RequestParams requestParams) {
        if (requestParams.adResponse == null || requestParams.clazz == null || !requestParams.adResponse.isCallSucceed() || requestParams.adResponse.getResponseCode() != 200) {
            return;
        }
        requestParams.content = null;
        requestParams.parseObject = null;
        try {
            requestParams.content = new String(requestParams.adResponse.getBytes(), "UTF-8");
        } catch (Throwable th) {
            LogUtils.w(TAG, "parseObject error new string.", th);
            requestParams.content = null;
        }
        if (requestParams.content == null) {
            LogUtils.i(TAG, "parseObject, return because content is null.");
            return;
        }
        try {
            requestParams.parseObject = JSON.parseObject(requestParams.content, (Class<Object>) requestParams.clazz, Feature.IgnoreNotMatch);
        } catch (Exception e) {
            LogUtils.w(TAG, "parseObject error parse.", e);
        }
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "parseObject: " + requestParams.parseObject);
        }
    }

    private void storeCookie(AdNetResponse adNetResponse) {
        if (adNetResponse == null || adNetResponse.getResponseCode() != 200) {
            return;
        }
        List<String> cookies = adNetResponse.getCookies();
        StringBuilder sb = new StringBuilder();
        if (cookies != null && !cookies.isEmpty()) {
            for (String str : cookies) {
                if (LogUtils.DEBUG) {
                    LogUtils.d(TAG, "storeCookie: cookie = " + str);
                }
                sb.append(str);
                sb.append(";");
            }
        }
        if (TextUtils.isEmpty(sb.toString())) {
            return;
        }
        Utils.setCookie(AdSdkManager.getInstance().getAppContext(), sb.toString());
    }

    public String getIpV4() {
        return GlobalInfoManager.getInstance().getIpV4();
    }

    public Map<String, String> getUpsAdQueryParams(Map<String, String> map) {
        return RequestUtils.getAdQueryParams(7, map);
    }

    public void request(int i, RequestInfo requestInfo, NetRequestCallback netRequestCallback) {
        PasterAdRequestBuilder pasterAdRequestBuilder = (i == 7 || i == 9) ? new PasterAdRequestBuilder() : null;
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "request: adType = " + i + ",reqInfo = " + requestInfo + ",clazz = " + AdInfo.class + ", requestBuilder = " + pasterAdRequestBuilder + ", mAdapter = " + this.mAdapter + ", netCallBack = " + netRequestCallback);
        }
        if (this.mAdapter == null || pasterAdRequestBuilder == null) {
            return;
        }
        pasterAdRequestBuilder.buildRequest(requestInfo, AdSdkManager.getInstance().getConfig().isDebugMode()).asyncCall(this.mAdapter, new AdRequestCallback(new RequestParams(AdInfo.class, requestInfo.isNeedAddCookie(), netRequestCallback, requestInfo.isMainThreadCallback())));
    }
}
