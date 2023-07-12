package com.youku.usercenter.passport;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ApiGenerator {
    public static final String API_VERSION_COMMON = "1.0.0";
    public static final String HAVANA_REFRESH_COOKIE = "mtop.taobao.havana.mlogin.youkuLegacy.refreshCookie";
    public static final String HAVANA_VERIFY_COOKIE = "mtop.taobao.havana.mlogin.youkuLegacy.verifyCookie";
    private static IPassportApi sMtopApi;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    interface IPassportApi {
        String getConfigApi();

        String getExtendCookieApi();

        String getLogoutApi();

        String getVerifyCookieApi();
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static class MtopApi implements IPassportApi {
        private static final String API_CONFIG = "mtop.youku.sdkservice.globalConfig";
        private static final String API_EXTEND_COOKIE = "mtop.youku.sdkservice.refreshCookie";
        private static final String API_LOGOUT = "mtop.youku.sdkservice.logout";
        private static final String API_VERIFY_COOKIE = "mtop.youku.sdkservice.verifyCookie";

        private MtopApi() {
        }

        @Override // com.youku.usercenter.passport.ApiGenerator.IPassportApi
        public String getConfigApi() {
            return API_CONFIG;
        }

        @Override // com.youku.usercenter.passport.ApiGenerator.IPassportApi
        public String getExtendCookieApi() {
            return API_EXTEND_COOKIE;
        }

        @Override // com.youku.usercenter.passport.ApiGenerator.IPassportApi
        public String getLogoutApi() {
            return API_LOGOUT;
        }

        @Override // com.youku.usercenter.passport.ApiGenerator.IPassportApi
        public String getVerifyCookieApi() {
            return API_VERIFY_COOKIE;
        }
    }

    public static IPassportApi create() {
        if (sMtopApi == null) {
            sMtopApi = new MtopApi();
        }
        return sMtopApi;
    }
}
