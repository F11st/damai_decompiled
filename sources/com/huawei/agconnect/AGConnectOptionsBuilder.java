package com.huawei.agconnect;

import android.content.Context;
import com.huawei.agconnect.config.a.C5472b;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import com.huawei.agconnect.core.service.auth.OnTokenListener;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class AGConnectOptionsBuilder {
    private static final String API_KEY_PATH = "/client/api_key";
    private static final String APP_ID_PATH = "/client/app_id";
    private static final String CLIENT_ID_PATH = "/client/client_id";
    private static final String CLIENT_SECRET_PATH = "/client/client_secret";
    private static final String CP_ID_PATH = "/client/cp_id";
    private static final String PRODUCT_ID_PATH = "/client/product_id";
    private InputStream inputStream;
    private String packageName;
    private AGCRoutePolicy routePolicy = AGCRoutePolicy.UNKNOWN;
    private final Map<String, String> customConfigMap = new HashMap();
    private final List<Service> customServices = new ArrayList();

    public AGConnectOptions build(Context context) {
        return new C5472b(context, this.packageName, this.routePolicy, this.inputStream, this.customConfigMap, this.customServices, null);
    }

    public AGConnectOptions build(Context context, String str) {
        return new C5472b(context, this.packageName, this.routePolicy, this.inputStream, this.customConfigMap, this.customServices, str);
    }

    public AGConnectOptionsBuilder setApiKey(String str) {
        this.customConfigMap.put(API_KEY_PATH, str);
        return this;
    }

    public AGConnectOptionsBuilder setAppId(String str) {
        this.customConfigMap.put(APP_ID_PATH, str);
        return this;
    }

    public AGConnectOptionsBuilder setCPId(String str) {
        this.customConfigMap.put(CP_ID_PATH, str);
        return this;
    }

    public AGConnectOptionsBuilder setClientId(String str) {
        this.customConfigMap.put(CLIENT_ID_PATH, str);
        return this;
    }

    public AGConnectOptionsBuilder setClientSecret(String str) {
        this.customConfigMap.put(CLIENT_SECRET_PATH, str);
        return this;
    }

    public AGConnectOptionsBuilder setCustomAuthProvider(final CustomAuthProvider customAuthProvider) {
        if (customAuthProvider != null) {
            this.customServices.add(Service.builder(AuthProvider.class, new AuthProvider() { // from class: com.huawei.agconnect.AGConnectOptionsBuilder.2
                @Override // com.huawei.agconnect.core.service.auth.AuthProvider
                public void addTokenListener(OnTokenListener onTokenListener) {
                }

                @Override // com.huawei.agconnect.core.service.auth.AuthProvider
                public Task<Token> getTokens() {
                    return customAuthProvider.getTokens(false);
                }

                @Override // com.huawei.agconnect.core.service.auth.AuthProvider
                public Task<Token> getTokens(boolean z) {
                    return customAuthProvider.getTokens(z);
                }

                @Override // com.huawei.agconnect.core.service.auth.AuthProvider
                public String getUid() {
                    return "";
                }

                @Override // com.huawei.agconnect.core.service.auth.AuthProvider
                public void removeTokenListener(OnTokenListener onTokenListener) {
                }
            }).build());
        }
        return this;
    }

    public AGConnectOptionsBuilder setCustomCredentialProvider(final CustomCredentialsProvider customCredentialsProvider) {
        if (customCredentialsProvider != null) {
            this.customServices.add(Service.builder(CredentialsProvider.class, new CredentialsProvider() { // from class: com.huawei.agconnect.AGConnectOptionsBuilder.1
                @Override // com.huawei.agconnect.core.service.auth.CredentialsProvider
                public Task<Token> getTokens() {
                    return customCredentialsProvider.getTokens(false);
                }

                @Override // com.huawei.agconnect.core.service.auth.CredentialsProvider
                public Task<Token> getTokens(boolean z) {
                    return customCredentialsProvider.getTokens(z);
                }
            }).build());
        }
        return this;
    }

    public AGConnectOptionsBuilder setCustomValue(String str, String str2) {
        this.customConfigMap.put(str, str2);
        return this;
    }

    public AGConnectOptionsBuilder setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        return this;
    }

    public AGConnectOptionsBuilder setPackageName(String str) {
        this.packageName = str;
        return this;
    }

    public AGConnectOptionsBuilder setProductId(String str) {
        this.customConfigMap.put(PRODUCT_ID_PATH, str);
        return this;
    }

    public AGConnectOptionsBuilder setRoutePolicy(AGCRoutePolicy aGCRoutePolicy) {
        this.routePolicy = aGCRoutePolicy;
        return this;
    }
}
