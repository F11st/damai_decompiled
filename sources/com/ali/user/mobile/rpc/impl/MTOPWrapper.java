package com.ali.user.mobile.rpc.impl;

import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.dataprovider.IntOrangeResult;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.callback.RpcRequestCallbackWithCode;
import com.ali.user.mobile.exception.RpcException;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.filter.FilterManager;
import com.ali.user.mobile.utils.ResourceUtil;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.youku.alixplayer.opensdk.statistics.StaticsUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class MTOPWrapper {
    private static MTOPWrapper INSTANCE = null;
    private static final int MTOP_BIZ_CODE = 94;
    private static final String TAG = "login.MTOPWrapperImpl";

    private MTOPWrapper() {
    }

    private MtopRequest buildMtopRequest(RpcRequest rpcRequest) {
        if (rpcRequest != null) {
            try {
                MtopRequest mtopRequest = new MtopRequest();
                mtopRequest.setApiName(rpcRequest.API_NAME);
                mtopRequest.setVersion(rpcRequest.VERSION);
                mtopRequest.setNeedEcode(rpcRequest.NEED_ECODE);
                mtopRequest.setNeedSession(rpcRequest.NEED_SESSION);
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < rpcRequest.paramNames.size(); i++) {
                    if (rpcRequest.paramNames.get(i) != null && rpcRequest.paramValues.get(i) != null) {
                        jSONObject.put(rpcRequest.paramNames.get(i), rpcRequest.paramValues.get(i).toString());
                    }
                }
                mtopRequest.setData(jSONObject.toString());
                return mtopRequest;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private <T extends RpcResponse<?>> T getBizData(MtopResponse mtopResponse, Class<T> cls) {
        try {
            JSONObject dataJsonObject = mtopResponse.getDataJsonObject();
            if (dataJsonObject != null) {
                return (T) JSON.parseObject(dataJsonObject.toString(), cls);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized MTOPWrapper getInstance() {
        MTOPWrapper mTOPWrapper;
        synchronized (MTOPWrapper.class) {
            if (INSTANCE == null) {
                synchronized (MTOPWrapper.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new MTOPWrapper();
                    }
                }
            }
            mTOPWrapper = INSTANCE;
        }
        return mTOPWrapper;
    }

    private void mtopRequestCommitTrack(RpcRequest rpcRequest) {
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "mtopRpc_commit", "", rpcRequest.API_NAME, properties);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mtopRequestFailTrack(RpcRequest rpcRequest, MtopResponse mtopResponse) {
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        if (mtopResponse != null && !TextUtils.isEmpty(mtopResponse.getRetCode()) && !mtopResponse.getRetCode().startsWith("FAIL_SYS") && !mtopResponse.getRetCode().startsWith("ANDROID_SYS")) {
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "mtopRpc_success", "", rpcRequest.API_NAME, properties);
        } else {
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "mtopRpc_failure", mtopResponse == null ? StaticsUtil.PLAY_CODE_100 : mtopResponse.getRetCode(), rpcRequest.API_NAME, properties);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mtopRequestSuccessTrack(RpcRequest rpcRequest) {
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "mtopRpc_success", "", rpcRequest.API_NAME, properties);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rpcFailRecord(MtopResponse mtopResponse) {
        try {
            Properties properties = new Properties();
            properties.setProperty("api", mtopResponse.getApi() + "");
            properties.setProperty("errorCode", mtopResponse.getRetCode() + "");
            properties.setProperty("errorMsg", mtopResponse.getRetMsg() + "");
            try {
                properties.setProperty("traceid", mtopResponse.getHeaderFields().get("x-eagleeye-id").get(0) + "");
            } catch (Exception unused) {
            }
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "rpcResult", properties);
        } catch (Throwable unused2) {
        }
    }

    public <T extends RpcResponse<?>> T post(RpcRequest rpcRequest, Class<T> cls) {
        return (T) post(rpcRequest, cls, null);
    }

    public <T extends RpcResponse<?>> T processMtopResponse(MtopResponse mtopResponse, Class<T> cls) {
        if (mtopResponse == null || !mtopResponse.isApiSuccess()) {
            if (mtopResponse != null) {
                if (!mtopResponse.isNetworkError()) {
                    if (!mtopResponse.isApiLockedResult()) {
                        if (!mtopResponse.is41XResult()) {
                            if (!mtopResponse.isExpiredRequest()) {
                                if (!mtopResponse.isIllegelSign()) {
                                    if (!mtopResponse.isSystemError()) {
                                        if (!mtopResponse.isMtopSdkError()) {
                                            if (!mtopResponse.isSessionInvalid()) {
                                                return (T) getBizData(mtopResponse, cls);
                                            }
                                            throw new RpcException(407, ResourceUtil.getStringById("aliuser_network_error"), mtopResponse.getRetCode());
                                        }
                                        throw new RpcException(406, ResourceUtil.getStringById("aliuser_network_error"), mtopResponse.getRetCode());
                                    }
                                    throw new RpcException(406, ResourceUtil.getStringById("aliuser_network_error"), mtopResponse.getRetCode());
                                }
                                throw new RpcException(403, ResourceUtil.getStringById("aliuser_network_error"), mtopResponse.getRetCode());
                            }
                            throw new RpcException(402, ResourceUtil.getStringById("aliuser_network_error"), mtopResponse.getRetCode());
                        }
                        throw new RpcException(401, ResourceUtil.getStringById("aliuser_network_error"), mtopResponse.getRetCode());
                    }
                    throw new RpcException(400, ResourceUtil.getStringById("aliuser_network_error"), mtopResponse.getRetCode());
                }
                throw new RpcException(7, ResourceUtil.getStringById("aliuser_network_error"), mtopResponse.getRetCode());
            }
            return null;
        }
        return (T) getBizData(mtopResponse, cls);
    }

    public <T extends RpcResponse<?>> void remoteBusiness(RpcRequest rpcRequest, Class<T> cls, String str, RpcRequestCallback rpcRequestCallback) {
        if (rpcRequest == null || rpcRequestCallback == null) {
            return;
        }
        remoteBusiness(rpcRequest, cls, str, rpcRequestCallback, null);
    }

    public <T extends RpcResponse<?>> T post(RpcRequest rpcRequest, Class<T> cls, String str) {
        MtopResponse mtopResponse;
        try {
            mtopRequestCommitTrack(rpcRequest);
            MtopBuilder retryTime = Mtop.instance(DataProviderFactory.getApplicationContext()).build(buildMtopRequest(rpcRequest), DataProviderFactory.getDataProvider().getTTID()).reqMethod(MethodEnum.POST).setBizId(94).setConnectionTimeoutMilliSecond(LoginSwitch.LOGOUT_POST_DEFAULT).setSocketTimeoutMilliSecond(LoginSwitch.LOGOUT_POST_DEFAULT).retryTime(1);
            if (!TextUtils.isEmpty(str)) {
                retryTime.setReqUserId(str);
            }
            IntOrangeResult mtopTimeOutMilliSecond = DataProviderFactory.getOrangeConfig().getMtopTimeOutMilliSecond();
            if (mtopTimeOutMilliSecond.orangeExist) {
                retryTime.setConnectionTimeoutMilliSecond(mtopTimeOutMilliSecond.value).setSocketTimeoutMilliSecond(mtopTimeOutMilliSecond.value);
            }
            Map<String, String> additionalHeaders = DataProviderFactory.getDataProvider().getAdditionalHeaders();
            if (additionalHeaders == null) {
                additionalHeaders = new HashMap<>();
            }
            if (LoginSwitch.getSwitch("baxia_switch", "true")) {
                additionalHeaders.put("login_sdk_version", AppInfo.getInstance().getSdkVersion().replace("android_", ""));
            }
            retryTime.headers(additionalHeaders);
            String str2 = rpcRequest.onlineDomain;
            if (str2 == null) {
                str2 = DataProviderFactory.getDataProvider().getOnlineDomain();
            }
            String str3 = rpcRequest.preDomain;
            if (str3 == null) {
                str3 = DataProviderFactory.getDataProvider().getPreDomain();
            }
            String str4 = rpcRequest.dailyDomain;
            if (str4 == null) {
                str4 = DataProviderFactory.getDataProvider().getDailyDomain();
            }
            retryTime.setCustomDomain(str2, str3, str4);
            long currentTimeMillis = System.currentTimeMillis();
            mtopResponse = retryTime.syncRequest();
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                TLogAdapter.d(TAG, "receive MtopResponse" + mtopResponse + ",time=" + (currentTimeMillis2 - currentTimeMillis));
                if (mtopResponse != null && mtopResponse.isApiSuccess()) {
                    mtopRequestSuccessTrack(rpcRequest);
                } else {
                    mtopRequestFailTrack(rpcRequest, mtopResponse);
                }
            } catch (Exception e) {
                e = e;
                TLogAdapter.e(TAG, "MtopResponse error", e);
                e.printStackTrace();
                if (mtopResponse == null) {
                }
                TLogAdapter.e(TAG, "MtopResponse response=null");
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            mtopResponse = null;
        }
        if (mtopResponse == null && cls != null) {
            if (!mtopResponse.isApiSuccess()) {
                rpcFailRecord(mtopResponse);
            }
            return (T) processMtopResponse(mtopResponse, cls);
        }
        TLogAdapter.e(TAG, "MtopResponse response=null");
        return null;
    }

    public <T extends RpcResponse<?>> void remoteBusiness(RpcRequest rpcRequest, Class<T> cls, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        if (rpcRequest == null || rpcRequestCallbackWithCode == null) {
            return;
        }
        remoteBusiness(rpcRequest, cls, null, null, rpcRequestCallbackWithCode);
    }

    private <T extends RpcResponse<?>> void remoteBusiness(final RpcRequest rpcRequest, final Class<T> cls, String str, final RpcRequestCallback rpcRequestCallback, final RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        try {
            mtopRequestCommitTrack(rpcRequest);
            MtopBusiness build = MtopBusiness.build(buildMtopRequest(rpcRequest), DataProviderFactory.getDataProvider().getTTID());
            Map<String, String> additionalHeaders = DataProviderFactory.getDataProvider().getAdditionalHeaders();
            if (additionalHeaders == null) {
                additionalHeaders = new HashMap<>();
            }
            if (LoginSwitch.getSwitch("baxia_switch", "true")) {
                additionalHeaders.put("login_sdk_version", AppInfo.getInstance().getSdkVersion().replace("android_", ""));
            }
            build.headers(additionalHeaders);
            if (!TextUtils.isEmpty(str)) {
                build.setReqUserId(str);
            }
            build.reqMethod(MethodEnum.POST);
            String str2 = rpcRequest.onlineDomain;
            if (str2 == null) {
                str2 = DataProviderFactory.getDataProvider().getOnlineDomain();
            }
            String str3 = rpcRequest.preDomain;
            if (str3 == null) {
                str3 = DataProviderFactory.getDataProvider().getPreDomain();
            }
            String str4 = rpcRequest.dailyDomain;
            if (str4 == null) {
                str4 = DataProviderFactory.getDataProvider().getDailyDomain();
            }
            build.setCustomDomain(str2, str3, str4);
            IntOrangeResult mtopTimeOutMilliSecond = DataProviderFactory.getOrangeConfig().getMtopTimeOutMilliSecond();
            if (mtopTimeOutMilliSecond.orangeExist) {
                build.setConnectionTimeoutMilliSecond(mtopTimeOutMilliSecond.value);
                build.setSocketTimeoutMilliSecond(mtopTimeOutMilliSecond.value);
            } else {
                build.setConnectionTimeoutMilliSecond(rpcRequest.connectionTimeoutMilliSecond);
                build.setSocketTimeoutMilliSecond(rpcRequest.socketTimeoutMilliSecond);
            }
            build.showLoginUI(rpcRequest.SHOW_LOGIN_UI);
            build.addListener((MtopListener) new IRemoteBaseListener() { // from class: com.ali.user.mobile.rpc.impl.MTOPWrapper.1
                @Override // com.taobao.tao.remotebusiness.IRemoteListener
                public void onError(int i, MtopResponse mtopResponse, Object obj) {
                    TLogAdapter.e(MTOPWrapper.TAG, "onError() called with: requestType = [" + i + "], response = [" + mtopResponse + "], requestContext = [" + obj + jn1.ARRAY_END_STR);
                    String retCode = mtopResponse != null ? mtopResponse.getRetCode() : "-1";
                    try {
                        RpcResponse processMtopResponse = MTOPWrapper.this.processMtopResponse(mtopResponse, cls);
                        FilterManager.getInstance().afterRpc(rpcRequest.getAfterFilters(), processMtopResponse);
                        RpcRequestCallback rpcRequestCallback2 = rpcRequestCallback;
                        if (rpcRequestCallback2 != null) {
                            rpcRequestCallback2.onError(processMtopResponse);
                        } else {
                            RpcRequestCallbackWithCode rpcRequestCallbackWithCode2 = rpcRequestCallbackWithCode;
                            if (rpcRequestCallbackWithCode2 != null) {
                                rpcRequestCallbackWithCode2.onError(retCode, processMtopResponse);
                            }
                        }
                        MTOPWrapper.this.rpcFailRecord(mtopResponse);
                        MTOPWrapper.this.mtopRequestFailTrack(rpcRequest, mtopResponse);
                    } catch (RpcException e) {
                        RpcResponse rpcResponse = new RpcResponse();
                        rpcResponse.code = e.getCode();
                        rpcResponse.message = ResourceUtil.getStringById("aliuser_network_error");
                        FilterManager.getInstance().afterRpc(rpcRequest.getAfterFilters(), rpcResponse);
                        RpcRequestCallback rpcRequestCallback3 = rpcRequestCallback;
                        if (rpcRequestCallback3 != null) {
                            rpcRequestCallback3.onSystemError(null);
                        } else {
                            RpcRequestCallbackWithCode rpcRequestCallbackWithCode3 = rpcRequestCallbackWithCode;
                            if (rpcRequestCallbackWithCode3 != null) {
                                rpcRequestCallbackWithCode3.onSystemError(retCode, null);
                            }
                        }
                        MTOPWrapper.this.mtopRequestFailTrack(rpcRequest, mtopResponse);
                    }
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteListener
                public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                    TLogAdapter.i(MTOPWrapper.TAG, "onSuccess() called with: requestType = [" + i + "], response = [" + mtopResponse + "], pojo = [" + baseOutDo + "], requestContext = [" + obj + jn1.ARRAY_END_STR);
                    RpcResponse processMtopResponse = MTOPWrapper.this.processMtopResponse(mtopResponse, cls);
                    FilterManager.getInstance().afterRpc(rpcRequest.getAfterFilters(), processMtopResponse);
                    RpcRequestCallback rpcRequestCallback2 = rpcRequestCallback;
                    if (rpcRequestCallback2 != null) {
                        rpcRequestCallback2.onSuccess(processMtopResponse);
                    } else {
                        RpcRequestCallbackWithCode rpcRequestCallbackWithCode2 = rpcRequestCallbackWithCode;
                        if (rpcRequestCallbackWithCode2 != null) {
                            rpcRequestCallbackWithCode2.onSuccess(processMtopResponse);
                        }
                    }
                    MTOPWrapper.this.mtopRequestSuccessTrack(rpcRequest);
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
                public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                    TLogAdapter.e(MTOPWrapper.TAG, "onSystemError() called with: requestType = [" + i + "], response = [" + mtopResponse + "], requestContext = [" + obj + jn1.ARRAY_END_STR);
                    String retCode = mtopResponse != null ? mtopResponse.getRetCode() : "-1";
                    try {
                        RpcResponse processMtopResponse = MTOPWrapper.this.processMtopResponse(mtopResponse, cls);
                        FilterManager.getInstance().afterRpc(rpcRequest.getAfterFilters(), processMtopResponse);
                        RpcRequestCallback rpcRequestCallback2 = rpcRequestCallback;
                        if (rpcRequestCallback2 != null) {
                            rpcRequestCallback2.onSystemError(processMtopResponse);
                        } else {
                            RpcRequestCallbackWithCode rpcRequestCallbackWithCode2 = rpcRequestCallbackWithCode;
                            if (rpcRequestCallbackWithCode2 != null) {
                                rpcRequestCallbackWithCode2.onSystemError(retCode, processMtopResponse);
                            }
                        }
                        MTOPWrapper.this.rpcFailRecord(mtopResponse);
                        MTOPWrapper.this.mtopRequestFailTrack(rpcRequest, mtopResponse);
                    } catch (RpcException e) {
                        RpcResponse rpcResponse = new RpcResponse();
                        rpcResponse.code = e.getCode();
                        rpcResponse.message = ResourceUtil.getStringById("aliuser_network_error");
                        FilterManager.getInstance().afterRpc(rpcRequest.getAfterFilters(), rpcResponse);
                        RpcRequestCallback rpcRequestCallback3 = rpcRequestCallback;
                        if (rpcRequestCallback3 != null) {
                            rpcRequestCallback3.onSystemError(null);
                        } else {
                            RpcRequestCallbackWithCode rpcRequestCallbackWithCode3 = rpcRequestCallbackWithCode;
                            if (rpcRequestCallbackWithCode3 != null) {
                                rpcRequestCallbackWithCode3.onSystemError(retCode, null);
                            }
                        }
                        MTOPWrapper.this.mtopRequestFailTrack(rpcRequest, mtopResponse);
                    }
                }
            });
            build.startRequest();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
