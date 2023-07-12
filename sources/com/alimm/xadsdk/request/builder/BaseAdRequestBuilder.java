package com.alimm.xadsdk.request.builder;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.base.net.AdNetwork;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.base.utils.Utils;
import com.alimm.xadsdk.info.GlobalInfoManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class BaseAdRequestBuilder implements IRequestBuilder {
    public static final String LICENSE_CIBN = "CIBN";
    public static final String LICENSE_WASU = "WASU";
    private static final String NEW_OFFICIAL_CIBN_AD_DOMAIN = "valf.atm.cp31.ott.cibntv.net";
    private static final String NEW_OFFICIAL_WASU_AD_DOMAIN = "valfatm.cp12.wasu.tv";
    private static final String NEW_OFFICIAL_YOUKU_AD_DOMAIN = "mc.atm.youku.com";
    private static final String OFFICIAL_YOUKU_AD_DOMAIN = "iyes.youku.com";
    private static final String TAG = "BaseAdRequestBuilder";
    private static final String TEST_YOUKU_AD_DOMAIN = "pre.iyes.youku.com";

    private HashMap<String, String> getCommonParams() {
        HashMap<String, String> hashMap = new HashMap<>(32);
        hashMap.put(IRequestConst.TIME_STAMP, String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("pid", GlobalInfoManager.getInstance().getPid());
        if (!TextUtils.isEmpty(GlobalInfoManager.getInstance().getMacAddress())) {
            hashMap.put("mac", GlobalInfoManager.getInstance().getMacAddress());
        }
        hashMap.put(IRequestConst.IM, GlobalInfoManager.getInstance().getImei());
        hashMap.put(IRequestConst.AVS, GlobalInfoManager.getInstance().getAppVersion());
        hashMap.put(IRequestConst.SVER, GlobalInfoManager.getInstance().getAdSdkVersion());
        if (!TextUtils.isEmpty(GlobalInfoManager.getInstance().getNetworkOperatorName())) {
            hashMap.put(IRequestConst.ISP, GlobalInfoManager.getInstance().getNetworkOperatorName());
        }
        hashMap.put("site", GlobalInfoManager.getInstance().getPublisherId());
        hashMap.put(IRequestConst.WINTYPE, "mdevice");
        hashMap.put(IRequestConst.AW, "a");
        hashMap.put(IRequestConst.BT, GlobalInfoManager.getInstance().getDeviceType());
        hashMap.put(IRequestConst.BD, Build.getBRAND());
        hashMap.put("net", String.valueOf(Utils.getNetworkType(AdSdkManager.getInstance().getAppContext())));
        hashMap.put(IRequestConst.MDL, Build.getMODEL());
        hashMap.put("dvw", String.valueOf(GlobalInfoManager.getInstance().getScreenWidth()));
        hashMap.put("dvh", String.valueOf(GlobalInfoManager.getInstance().getScreenHeight()));
        hashMap.put("os", GlobalInfoManager.getInstance().getOsType());
        hashMap.put(IRequestConst.OSV, Build.VERSION.getRELEASE());
        hashMap.put("aid", GlobalInfoManager.getInstance().getAndroidId());
        hashMap.put(IRequestConst.VS, "1.0");
        hashMap.put("aaid", GlobalInfoManager.getInstance().getAdvertisingId());
        hashMap.put("ua", Utils.getDefaultUserAgent());
        hashMap.put("utdid", GlobalInfoManager.getInstance().getUtdid());
        hashMap.put(IRequestConst.OAID, GlobalInfoManager.getInstance().getOaid());
        hashMap.put(IRequestConst.WT, String.valueOf(GlobalInfoManager.getInstance().getAppStartType()));
        String stoken = GlobalInfoManager.getInstance().getStoken();
        if (stoken != null) {
            hashMap.put(IRequestConst.STOKEN, stoken);
        }
        String previewAdAssetId = GlobalInfoManager.getInstance().getPreviewAdAssetId();
        if (!TextUtils.isEmpty(previewAdAssetId)) {
            hashMap.put(IRequestConst.ADEXT, previewAdAssetId);
        }
        if (1 == AdSdkManager.getInstance().getConfig().getDeviceType()) {
            hashMap.put(IRequestConst.LICENSE, GlobalInfoManager.getInstance().getLicense());
            hashMap.put("uuid", GlobalInfoManager.getInstance().getUuid());
            hashMap.put(IRequestConst.BOX, GlobalInfoManager.getInstance().getOttSystemType());
            hashMap.put(IRequestConst.PN, GlobalInfoManager.getInstance().getPackageName());
        }
        if (AdSdkManager.getInstance().getConfig().isThirdPartyApp()) {
            hashMap.put(IRequestConst.ATOKEN, GlobalInfoManager.getInstance().getAToken() == null ? "" : GlobalInfoManager.getInstance().getAToken());
            hashMap.put("client_id", AdSdkManager.getInstance().getConfig().getClientId() == null ? "" : AdSdkManager.getInstance().getConfig().getClientId());
            hashMap.put("ccode", AdSdkManager.getInstance().getConfig().getCCode() != null ? AdSdkManager.getInstance().getConfig().getCCode() : "");
        }
        return hashMap;
    }

    protected void addQueryParams(@NonNull RequestInfo requestInfo, @NonNull Map<String, String> map) {
    }

    @Override // com.alimm.xadsdk.request.builder.IRequestBuilder
    public AdNetwork buildRequest(@NonNull RequestInfo requestInfo, boolean z) {
        AdNetwork.Builder builder = new AdNetwork.Builder();
        setRequestHeader(builder, requestInfo);
        setRequestUrl(builder, requestInfo, z);
        setRequestControlParams(builder, requestInfo);
        return builder.build();
    }

    protected String getNewUrlDomain(boolean z) {
        return AdSdkManager.getInstance().getConfig().getDeviceType() == 1 ? TextUtils.equals(AdSdkManager.getInstance().getConfig().getLicense(), LICENSE_WASU) ? NEW_OFFICIAL_WASU_AD_DOMAIN : NEW_OFFICIAL_CIBN_AD_DOMAIN : NEW_OFFICIAL_YOUKU_AD_DOMAIN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getProtocol() {
        return AdSdkManager.getInstance().getConfig().isUseHttps() ? "https://" : "http://";
    }

    @NonNull
    protected abstract String getRequestUrl(boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public String getUrlDomain(boolean z) {
        return AdSdkManager.getInstance().getConfig().getDeviceType() == 1 ? TextUtils.equals(AdSdkManager.getInstance().getConfig().getLicense(), LICENSE_WASU) ? NEW_OFFICIAL_WASU_AD_DOMAIN : NEW_OFFICIAL_CIBN_AD_DOMAIN : z ? TEST_YOUKU_AD_DOMAIN : OFFICIAL_YOUKU_AD_DOMAIN;
    }

    protected void setRequestControlParams(AdNetwork.Builder builder, RequestInfo requestInfo) {
        builder.method(requestInfo.isUsePostMethod() ? "POST" : "GET");
        builder.autoRedirect(true);
        builder.connectTimeout(requestInfo.getTimeout());
        builder.readTimeout(requestInfo.getTimeout());
        builder.retryTimes(requestInfo.getRetryTimes());
    }

    protected void setRequestHeader(AdNetwork.Builder builder, @NonNull RequestInfo requestInfo) {
        StringBuilder sb = new StringBuilder();
        String clientCookie = GlobalInfoManager.getInstance().getClientCookie();
        if (!TextUtils.isEmpty(clientCookie)) {
            sb.append(clientCookie);
        }
        String cookie = Utils.getCookie(requestInfo.getContext());
        if (!TextUtils.isEmpty(cookie)) {
            if (!TextUtils.isEmpty(sb)) {
                sb.append(";");
            }
            sb.append(cookie);
        }
        if (!TextUtils.isEmpty(sb)) {
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "setRequestHeader: cookie = " + ((Object) sb));
            }
            builder.header(IRequestConst.COOKIE, sb.toString());
        }
        builder.header(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
        String userAgent = GlobalInfoManager.getInstance().getUserAgent();
        if (!TextUtils.isEmpty(userAgent)) {
            builder.header(IRequestConst.USER_AGENT, userAgent);
        }
        builder.header("Content-Type", requestInfo.isUsePostMethod() ? IRequestConst.CONTENT_TYPE_POST : IRequestConst.CONTENT_TYPE_JSON);
    }

    protected void setRequestUrl(AdNetwork.Builder builder, @NonNull RequestInfo requestInfo, boolean z) {
        builder.url(getRequestUrl(z));
        HashMap<String, String> commonParams = getCommonParams();
        addQueryParams(requestInfo, commonParams);
        builder.params(commonParams);
    }
}
