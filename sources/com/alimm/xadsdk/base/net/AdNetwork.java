package com.alimm.xadsdk.base.net;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AdNetwork {
    public static final int DEFAULT_TIME_OUT = 10000;
    public static final String METHOD_GET = "GET";
    private static final String TAG = "AdNetwork";
    private AdNetworkOptions mNetworkOptions;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class Builder {
        private AdNetworkOptions options = new AdNetworkOptions();

        public Builder autoRedirect(boolean z) {
            this.options.setAutoRedirect(z);
            return this;
        }

        public AdNetwork build() {
            AdNetwork adNetwork = new AdNetwork();
            adNetwork.setOptions(this.options);
            return adNetwork;
        }

        public Builder connectTimeout(int i) {
            this.options.setConnectTimeout(i);
            return this;
        }

        public Builder header(String str, String str2) {
            this.options.addHeader(str, str2);
            return this;
        }

        public Builder headers(Map<String, String> map) {
            this.options.setHeaders(map);
            return this;
        }

        public Builder method(String str) {
            this.options.setMethod(str);
            return this;
        }

        public Builder params(Map<String, String> map) {
            this.options.setParams(map);
            return this;
        }

        public Builder readTimeout(int i) {
            this.options.setReadTimeout(i);
            return this;
        }

        public Builder retryTimes(int i) {
            this.options.setRetryTimes(i);
            return this;
        }

        public Builder setCharset(String str) {
            this.options.setCharset(str);
            return this;
        }

        public Builder setJsonData(String str) {
            this.options.setJsonBody(str);
            return this;
        }

        public Builder url(String str) {
            this.options.setUrl(str);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOptions(AdNetworkOptions adNetworkOptions) {
        this.mNetworkOptions = adNetworkOptions;
    }

    public void asyncCall(INetAdapter iNetAdapter, INetCallback iNetCallback) {
        AdNetworkOptions adNetworkOptions = this.mNetworkOptions;
        if (adNetworkOptions == null || iNetAdapter == null) {
            return;
        }
        iNetAdapter.asyncCall(adNetworkOptions, iNetCallback);
    }
}
