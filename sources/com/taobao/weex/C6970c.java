package com.taobao.weex;

import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXPerformance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.common.WXResponse;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.tools.LogDetail;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.wz2;

/* compiled from: Taobao */
/* renamed from: com.taobao.weex.c */
/* loaded from: classes11.dex */
public class C6970c implements IWXHttpAdapter.OnHttpListener {
    private WXRenderStrategy flag;
    private WXSDKInstance instance;
    private boolean isInstanceReady;
    public boolean isPreDownLoadMode;
    private boolean isResponseHasWait;
    private String jsonInitData;
    private WXInstanceApm mApmForInstance;
    private String mBundleUrl;
    private LogDetail mLogDetail;
    private WXResponse mResponse;
    private IWXUserTrackAdapter mUserTrackAdapter;
    private WXPerformance mWXPerformance;
    private Map<String, Object> options;
    private String pageName;
    private long startRequestTime;
    private int traceId;

    public C6970c(WXSDKInstance wXSDKInstance) {
        this.isPreDownLoadMode = false;
        this.isInstanceReady = false;
        this.isResponseHasWait = false;
        if (wXSDKInstance != null) {
            this.mLogDetail = wXSDKInstance.mTimeCalculator.createLogDetail("downloadBundleJS");
        }
        this.instance = wXSDKInstance;
        this.traceId = wz2.d();
        this.mWXPerformance = wXSDKInstance.getWXPerformance();
        this.mApmForInstance = wXSDKInstance.getApmForInstance();
        this.mUserTrackAdapter = WXSDKManager.v().t();
        if (wz2.b()) {
            wz2.C9890a c = wz2.c("downloadBundleJS", wXSDKInstance.getInstanceId(), -1);
            c.f = wXSDKInstance.getInstanceId();
            c.b = "Network";
            c.c = "B";
            c.d = this.traceId;
            c.a();
        }
    }

    private void didHttpFinish(WXResponse wXResponse) {
        String errorCode;
        if (wXResponse != null && wXResponse.originalData != null && TextUtils.equals("200", wXResponse.statusCode)) {
            this.mApmForInstance.r(WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_END);
            onSuccess(wXResponse);
            errorCode = "0";
        } else {
            WXErrorCode wXErrorCode = WXErrorCode.WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR;
            if (TextUtils.equals(wXErrorCode.getErrorCode(), wXResponse.statusCode)) {
                WXLogUtils.e("user intercept: WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR");
                errorCode = wXErrorCode.getErrorCode();
                WXSDKInstance wXSDKInstance = this.instance;
                wXSDKInstance.onRenderError(errorCode, "|response.errorMsg==" + wXResponse.errorMsg + "|instance bundleUrl = \n" + this.instance.getBundleUrl() + "|instance requestUrl = \n" + Uri.decode(WXSDKInstance.requestUrl));
                onFail(wXResponse);
            } else if (wXResponse.originalData != null && TextUtils.equals("-206", wXResponse.statusCode)) {
                WXLogUtils.e("user intercept: WX_DEGRAD_ERR_NETWORK_CHECK_CONTENT_LENGTH_FAILED");
                WXErrorCode wXErrorCode2 = WXErrorCode.WX_DEGRAD_ERR_NETWORK_CHECK_CONTENT_LENGTH_FAILED;
                String errorCode2 = wXErrorCode2.getErrorCode();
                WXSDKInstance wXSDKInstance2 = this.instance;
                wXSDKInstance2.onRenderError(errorCode2, wXErrorCode2.getErrorCode() + "|response.errorMsg==" + wXResponse.errorMsg);
                onFail(wXResponse);
                errorCode = errorCode2;
            } else {
                errorCode = WXErrorCode.WX_DEGRAD_ERR_NETWORK_BUNDLE_DOWNLOAD_FAILED.getErrorCode();
                this.instance.onRenderError(errorCode, wXResponse.errorMsg);
                onFail(wXResponse);
            }
        }
        if ("0".equals(errorCode)) {
            return;
        }
        this.mApmForInstance.e(WXInstanceApm.KEY_PROPERTIES_ERROR_CODE, errorCode);
    }

    private boolean isNet(String str) {
        return "network".equals(str) || "2g".equals(str) || "3g".equals(str) || "4g".equals(str) || "wifi".equals(str) || "other".equals(str) || "unknown".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WXSDKInstance getInstance() {
        return this.instance;
    }

    public void onFail(WXResponse wXResponse) {
    }

    @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
    public void onHeadersReceived(int i, Map<String, List<String>> map) {
        Map<String, List<String>> map2;
        WXSDKInstance wXSDKInstance = this.instance;
        if (wXSDKInstance != null && wXSDKInstance.getWXStatisticsListener() != null) {
            this.instance.getWXStatisticsListener().onHeadersReceived();
            this.instance.onHttpStart();
        }
        WXSDKInstance wXSDKInstance2 = this.instance;
        if (wXSDKInstance2 == null || (map2 = wXSDKInstance2.responseHeaders) == null || map == null) {
            return;
        }
        map2.putAll(map);
    }

    @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
    public void onHttpFinish(WXResponse wXResponse) {
        Map<String, Object> map;
        byte[] bArr;
        byte[] bArr2;
        LogDetail logDetail = this.mLogDetail;
        if (logDetail != null) {
            logDetail.taskEnd();
        }
        WXSDKInstance wXSDKInstance = this.instance;
        if (wXSDKInstance != null && wXSDKInstance.getWXStatisticsListener() != null) {
            this.instance.getWXStatisticsListener().onHttpFinish();
        }
        if (wz2.b()) {
            wz2.C9890a c = wz2.c("downloadBundleJS", this.instance.getInstanceId(), -1);
            c.d = this.traceId;
            c.b = "Network";
            c.c = ExifInterface.LONGITUDE_EAST;
            HashMap hashMap = new HashMap();
            c.q = hashMap;
            if (wXResponse != null && (bArr2 = wXResponse.originalData) != null) {
                hashMap.put("BundleSize", Integer.valueOf(bArr2.length));
            }
            c.a();
        }
        this.mWXPerformance.networkTime = System.currentTimeMillis() - this.startRequestTime;
        if (wXResponse != null && (map = wXResponse.extendParams) != null) {
            this.mApmForInstance.F(map);
            Object obj = wXResponse.extendParams.get("actualNetworkTime");
            this.mWXPerformance.actualNetworkTime = obj instanceof Long ? ((Long) obj).longValue() : 0L;
            Object obj2 = wXResponse.extendParams.get("pureNetworkTime");
            this.mWXPerformance.pureNetworkTime = obj2 instanceof Long ? ((Long) obj2).longValue() : 0L;
            Object obj3 = wXResponse.extendParams.get("connectionType");
            this.mWXPerformance.connectionType = obj3 instanceof String ? (String) obj3 : "";
            Object obj4 = wXResponse.extendParams.get("packageSpendTime");
            this.mWXPerformance.packageSpendTime = obj4 instanceof Long ? ((Long) obj4).longValue() : 0L;
            Object obj5 = wXResponse.extendParams.get("syncTaskTime");
            this.mWXPerformance.syncTaskTime = obj5 instanceof Long ? ((Long) obj5).longValue() : 0L;
            Object obj6 = wXResponse.extendParams.get("requestType");
            this.mWXPerformance.requestType = obj6 instanceof String ? (String) obj6 : "none";
            Object obj7 = wXResponse.extendParams.get(WXPerformance.Dimension.cacheType.toString());
            if (obj7 instanceof String) {
                this.mWXPerformance.cacheType = (String) obj7;
            }
            Object obj8 = wXResponse.extendParams.get("zCacheInfo");
            WXPerformance wXPerformance = this.mWXPerformance;
            wXPerformance.zCacheInfo = obj8 instanceof String ? (String) obj8 : "";
            if (isNet(wXPerformance.requestType) && this.mUserTrackAdapter != null) {
                WXPerformance wXPerformance2 = new WXPerformance(this.instance.getInstanceId());
                if (!TextUtils.isEmpty(this.mBundleUrl)) {
                    try {
                        wXPerformance2.args = Uri.parse(this.mBundleUrl).buildUpon().clearQuery().toString();
                    } catch (Exception unused) {
                        wXPerformance2.args = this.pageName;
                    }
                }
                if (!"200".equals(wXResponse.statusCode)) {
                    wXPerformance2.errCode = WXErrorCode.WX_ERR_JSBUNDLE_DOWNLOAD.getErrorCode();
                    wXPerformance2.appendErrMsg(wXResponse.errorCode);
                    wXPerformance2.appendErrMsg("|");
                    wXPerformance2.appendErrMsg(wXResponse.errorMsg);
                } else if ("200".equals(wXResponse.statusCode) && ((bArr = wXResponse.originalData) == null || bArr.length <= 0)) {
                    wXPerformance2.errCode = WXErrorCode.WX_ERR_JSBUNDLE_DOWNLOAD.getErrorCode();
                    wXPerformance2.appendErrMsg(wXResponse.statusCode);
                    wXPerformance2.appendErrMsg("|template is null!");
                } else {
                    wXPerformance2.errCode = WXErrorCode.WX_SUCCESS.getErrorCode();
                }
                IWXUserTrackAdapter iWXUserTrackAdapter = this.mUserTrackAdapter;
                if (iWXUserTrackAdapter != null) {
                    iWXUserTrackAdapter.commit(this.instance.getContext(), null, IWXUserTrackAdapter.JS_DOWNLOAD, wXPerformance2, null);
                }
            }
        }
        if (this.isPreDownLoadMode) {
            if (this.isInstanceReady) {
                WXLogUtils.d("test->", "DownLoad didHttpFinish on http");
                didHttpFinish(wXResponse);
                return;
            }
            WXLogUtils.d("test->", "DownLoad end before activity created");
            this.mResponse = wXResponse;
            this.isResponseHasWait = true;
            return;
        }
        didHttpFinish(wXResponse);
    }

    @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
    public void onHttpResponseProgress(int i) {
        this.instance.getApmForInstance().j.put(WXInstanceApm.VALUE_BUNDLE_LOAD_LENGTH, Integer.valueOf(i));
    }

    @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
    public void onHttpStart() {
        WXSDKInstance wXSDKInstance = this.instance;
        if (wXSDKInstance == null || wXSDKInstance.getWXStatisticsListener() == null) {
            return;
        }
        this.instance.getWXStatisticsListener().onHttpStart();
        LogDetail logDetail = this.mLogDetail;
        if (logDetail != null) {
            logDetail.taskStart();
        }
    }

    @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
    public void onHttpUploadProgress(int i) {
    }

    public void onInstanceReady() {
        if (this.isPreDownLoadMode) {
            this.isInstanceReady = true;
            if (this.isResponseHasWait) {
                WXLogUtils.d("test->", "preDownLoad didHttpFinish on ready");
                didHttpFinish(this.mResponse);
            }
        }
    }

    public void onSuccess(WXResponse wXResponse) {
        if (this.flag == WXRenderStrategy.DATA_RENDER_BINARY) {
            this.instance.render(this.pageName, wXResponse.originalData, this.options, this.jsonInitData);
            return;
        }
        this.instance.render(this.pageName, new String(wXResponse.originalData), this.options, this.jsonInitData, this.flag);
    }

    public void setSDKInstance(WXSDKInstance wXSDKInstance) {
        this.instance = wXSDKInstance;
    }

    public C6970c(WXSDKInstance wXSDKInstance, String str) {
        this(wXSDKInstance);
        this.startRequestTime = System.currentTimeMillis();
        this.mBundleUrl = str;
    }

    public C6970c(WXSDKInstance wXSDKInstance, String str, Map<String, Object> map, String str2, WXRenderStrategy wXRenderStrategy, long j) {
        this(wXSDKInstance);
        this.pageName = str;
        this.options = map;
        this.jsonInitData = str2;
        this.flag = wXRenderStrategy;
        this.startRequestTime = j;
        this.mBundleUrl = wXSDKInstance.getBundleUrl();
    }
}
