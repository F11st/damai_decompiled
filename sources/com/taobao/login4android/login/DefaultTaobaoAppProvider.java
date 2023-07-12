package com.taobao.login4android.login;

import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProvider;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.service.StorageService;
import com.taobao.login4android.config.LoginSwitch;

/* loaded from: classes11.dex */
public class DefaultTaobaoAppProvider extends DataProvider {
    @Override // com.ali.user.mobile.app.dataprovider.DataProvider, com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean enableAlipaySSO() {
        return LoginSwitch.getSwitch(LoginSwitch.ALIPAY_SSO_SWITCH, "true") && this.enableAlipaySSO;
    }

    @Override // com.ali.user.mobile.app.dataprovider.DataProvider, com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean enableNumAuthService() {
        return this.enableAuthService && LoginSwitch.getSwitch(LoginSwitch.SUPPORT_NUM_AUTH, "true");
    }

    @Override // com.ali.user.mobile.app.dataprovider.DataProvider, com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getAppkey() {
        if (TextUtils.isEmpty(this.appKey)) {
            int envType = getEnvType();
            if (envType != 0 && envType != 1) {
                this.appKey = ((StorageService) ServiceFactory.getService(StorageService.class)).getAppKey(0);
            } else {
                this.appKey = ((StorageService) ServiceFactory.getService(StorageService.class)).getAppKey(2);
            }
        }
        return this.appKey;
    }

    @Override // com.ali.user.mobile.app.dataprovider.DataProvider, com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getDeviceId() {
        String deviceId = ((RpcService) ServiceFactory.getService(RpcService.class)).getDeviceId();
        this.deviceId = deviceId;
        return deviceId;
    }

    @Override // com.ali.user.mobile.app.dataprovider.DataProvider, com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isForbidLoginFromBackground() {
        return LoginSwitch.getSwitch(LoginSwitch.FORBID_LOGIN_FROM_BACKGROUND, "false");
    }

    @Override // com.ali.user.mobile.app.dataprovider.DataProvider, com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isRefreshCookiesDegrade() {
        if (this.site == 0) {
            return LoginSwitch.getSwitch(LoginSwitch.REFRESH_COOKIE_DEGRADE_SWITCH, "false");
        }
        return false;
    }

    @Override // com.ali.user.mobile.app.dataprovider.DataProvider, com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isSupportFingerprintLogin() {
        return this.supportFingerprintLogin && LoginSwitch.getSwitch(LoginSwitch.SUPPORT_FINGERPRINT_LOGIN, "true");
    }

    @Override // com.ali.user.mobile.app.dataprovider.DataProvider, com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isTaobaoApp() {
        return this.isTaobaoApp;
    }

    @Override // com.ali.user.mobile.app.dataprovider.DataProvider, com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean needAccsLogin() {
        return LoginSwitch.getSwitch(LoginSwitch.ACCS_LOGIN_SWITCH, "false");
    }

    @Override // com.ali.user.mobile.app.dataprovider.DataProvider, com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean supportFaceLogin() {
        return LoginSwitch.getSwitch(LoginSwitch.SUPPORT_FACE_LOGIN, "true") && this.supportFaceLogin;
    }

    @Override // com.ali.user.mobile.app.dataprovider.DataProvider, com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean supportOneKeyLogin() {
        return LoginSwitch.isInABTestRegion(LoginSwitch.ONEKEY_LOGIN_PERCENT, -1);
    }

    @Override // com.ali.user.mobile.app.dataprovider.DataProvider, com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean supportOneKeyRegister() {
        return LoginSwitch.isInABTestRegion(LoginSwitch.ONEKEY_REGISTER_PERCENT, -1);
    }
}
