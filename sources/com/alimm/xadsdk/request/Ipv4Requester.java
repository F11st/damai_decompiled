package com.alimm.xadsdk.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alimm.xadsdk.AdSdkConfig;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.base.core.AdThreadPoolExecutor;
import com.alimm.xadsdk.base.net.AdNetResponse;
import com.alimm.xadsdk.base.net.AdNetwork;
import com.alimm.xadsdk.base.net.INetCallback;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.info.GlobalInfoManager;
import com.alimm.xadsdk.request.builder.BaseAdRequestBuilder;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Ipv4Requester {
    private static final String CIBN_IPV4_URL = "apiv4-iyes.cp12.ott.cibntv.net";
    private static final String IPV4_URL = "apiv4-iyes.youku.com";
    private static final String PATH = "/reflect/ip";
    private static final String TAG = "Ipv4Requester";
    private static final String WASU_IPV4_URL = "apiv4-iyes.cp12.wasu.tv";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class IpInfo implements Serializable {
        public String IP;
        public boolean IsIPv6;

        IpInfo() {
        }

        public String toString() {
            return "{IpInfo:IP=" + this.IP + ", IsIPv6=" + this.IsIPv6 + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getIpv4() {
        AdNetwork.Builder autoRedirect = new AdNetwork.Builder().url(getRequestUrl()).method("GET").connectTimeout(10000).readTimeout(10000).retryTimes(0).autoRedirect(true);
        autoRedirect.header(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
        autoRedirect.build().asyncCall(AdSdkManager.getInstance().getConfig().getRequestConfig().getNetAdapter(), new INetCallback() { // from class: com.alimm.xadsdk.request.Ipv4Requester.2
            @Override // com.alimm.xadsdk.base.net.INetCallback
            public void onFailed(int i, String str) {
                if (LogUtils.DEBUG) {
                    LogUtils.w(Ipv4Requester.TAG, "getIpV4: onFailed, errorCode = " + i + "; msg = " + str);
                }
            }

            @Override // com.alimm.xadsdk.base.net.INetCallback
            public void onSuccess(AdNetResponse adNetResponse) {
                IpInfo parseIpInfo;
                if (LogUtils.DEBUG) {
                    LogUtils.d(Ipv4Requester.TAG, "getIpv4Async: + onSuccess.");
                }
                if (adNetResponse == null || !adNetResponse.isCallSucceed() || adNetResponse.getResponseCode() != 200 || (parseIpInfo = Ipv4Requester.parseIpInfo(adNetResponse)) == null || TextUtils.isEmpty(parseIpInfo.IP)) {
                    return;
                }
                GlobalInfoManager.getInstance().setIpV4(parseIpInfo.IP);
            }
        });
    }

    public static void getIpv4Async() {
        AdThreadPoolExecutor.post(new Runnable() { // from class: com.alimm.xadsdk.request.Ipv4Requester.1
            @Override // java.lang.Runnable
            public void run() {
                Ipv4Requester.getIpv4();
            }
        });
    }

    private static String getRequestUrl() {
        AdSdkConfig config = AdSdkManager.getInstance().getConfig();
        String str = config.isUseHttps() ? "https://" : "http://";
        String str2 = config.getDeviceType() == 1 ? TextUtils.equals(config.getLicense(), BaseAdRequestBuilder.LICENSE_WASU) ? WASU_IPV4_URL : CIBN_IPV4_URL : IPV4_URL;
        return str + str2 + PATH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IpInfo parseIpInfo(@NonNull AdNetResponse adNetResponse) {
        byte[] bytes = adNetResponse.getBytes();
        if (bytes == null) {
            return null;
        }
        try {
            return (IpInfo) JSON.parseObject(bytes, IpInfo.class, new Feature[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
