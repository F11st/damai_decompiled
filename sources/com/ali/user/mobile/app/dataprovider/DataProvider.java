package com.ali.user.mobile.app.dataprovider;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.log.LoggerProxy;
import com.ali.user.mobile.model.RegType;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.service.StorageService;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.session.SessionManager;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DataProvider implements IDataProvider {
    protected String TTID;
    protected String alipaySsoDesKey;
    protected String appKey;
    protected String appName;
    protected Context context;
    protected String deviceId;
    protected String eaDeviceId;
    protected boolean enableElder;
    protected boolean forbidRefreshCookieInAutologin;
    protected String guideAppName;
    protected String guideBackground;
    protected String guideCloseResource;
    protected String guidePwdLoginResource;
    private String mAccountBindBizType;
    protected ImageLoader mImageLoader;
    protected LoggerProxy mLoggerProxy;
    protected String mResultActivityPath;
    protected boolean refreshCookieDegrade;
    protected String sdkCustomUtdid;
    protected String version;
    protected int checkBoxDrawable = -1;
    protected int btnDrawable = -1;
    protected int cancelBtnDrawable = -1;
    protected int btnTextColor = -1;
    protected int cancelBtnTextColor = -1;
    protected int smsLength = 6;
    protected boolean isTaobaoApp = false;
    protected boolean isYoukuApps = false;
    protected boolean showHistoryFragment = true;
    protected boolean needAlipaySsoGuide = false;
    protected boolean needTaobaoSsoGuide = false;
    protected boolean needPwdGuide = true;
    protected boolean needAccsLogin = false;
    protected boolean needEnterPriseRegister = true;
    protected int maxHistoryAccount = 3;
    protected int maxSessionSize = 20;
    protected boolean saveHistoryWithoutSalt = false;
    protected int envType = 3;
    protected int site = 0;
    protected boolean isRemoveSessionWhenLogout = true;
    protected String regFrom = "TB";
    protected String regType = RegType.NATIVE_REG;
    protected boolean regPwdCheck = false;
    protected boolean regEmailCheck = false;
    protected boolean isForbidLoginFromBackground = false;
    protected boolean enableAlipaySSO = true;
    protected Locale language = Locale.SIMPLIFIED_CHINESE;
    protected boolean supportFaceLogin = false;
    protected boolean supportFingerprintLogin = false;
    protected boolean supportMobileLogin = true;
    protected boolean supportTwoStepMobileLogin = false;
    protected boolean supportPwdLogin = true;
    protected boolean supportOneKeyRegister = true;
    protected boolean supportOneKeyLogin = true;
    protected boolean supportTwoStepMobileRegister = true;
    protected boolean useRegionFragment = false;
    protected boolean enableMobilePwdLogin = false;
    protected boolean showHeadCountry = true;
    protected int orientation = 1;
    protected boolean enableAuthService = false;
    protected boolean enableVoiceMsg = false;
    protected boolean registerSidToMtop = true;
    protected int loginStyle = -1;
    protected int toolbarBack = -1;
    protected boolean mGetAppInfoFromServer = false;
    protected boolean checkCookieValid = false;
    protected boolean alwaysSMSLoginPriority = false;
    protected boolean alwaysPwdLoginPriority = false;
    protected boolean isNeedUpdateUTAccount = true;
    protected boolean isRecommendPageFirst = false;

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean alwaysPwdLoginPriority() {
        return this.alwaysPwdLoginPriority;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean alwaysSMSLoginPriority() {
        return this.alwaysSMSLoginPriority;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean enableAlipaySSO() {
        return this.enableAlipaySSO;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean enableElder() {
        return this.enableElder;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean enableMobilePwdLogin() {
        return this.enableMobilePwdLogin;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean enableNumAuthService() {
        return this.enableAuthService;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean enableRegEmailCheck() {
        return this.regEmailCheck;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean enableRegPwdCheck() {
        return this.regPwdCheck;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getAccountBindBizType() {
        return this.mAccountBindBizType;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public Map<String, String> getAdditionalHeaders() {
        return null;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getAlipaySsoDesKey() {
        return this.alipaySsoDesKey;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean getAppInfoFromServer() {
        return this.mGetAppInfoFromServer;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getAppName() {
        return this.appName;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
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

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getAuthSDKInfo() {
        return "";
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public int getBtnDrawable() {
        return this.btnDrawable;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public int getBtnTextColor() {
        return this.btnTextColor;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public int getCancelBtnDrawable() {
        return this.cancelBtnDrawable;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public int getCancelBtnTextColor() {
        return this.cancelBtnTextColor;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public int getCheckBoxDrawable() {
        return this.checkBoxDrawable;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public Context getContext() {
        return this.context;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public Map<String, String> getCurrentAccount() {
        return new HashMap();
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public Locale getCurrentLanguage() {
        return this.language;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public RegionInfo getCurrentRegion() {
        RegionInfo regionInfo = new RegionInfo();
        regionInfo.name = "中国大陆";
        regionInfo.code = "+86";
        regionInfo.domain = "CN";
        regionInfo.checkPattern = "^(86){0,1}1\\d{10}$";
        return regionInfo;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public int getCurrentSite() {
        return this.site;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getDailyDomain() {
        return "";
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getDeviceId() {
        return this.deviceId;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getEaDeviceId() {
        return this.eaDeviceId;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public int getEnvType() {
        return this.envType;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public Map<String, String> getExternalData() {
        return null;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getGuideAppName() {
        return this.guideAppName;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getGuideBackground() {
        return this.guideBackground;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getGuideCloseResource() {
        return this.guideCloseResource;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getGuidePwdLoginResource() {
        return this.guidePwdLoginResource;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public ImageLoader getImageLoader() {
        return this.mImageLoader;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public LoggerProxy getLoggerProxy() {
        return this.mLoggerProxy;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public int getLoginStyle() {
        return this.loginStyle;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public int getMaxHistoryAccount() {
        IntOrangeResult maxHistorySize = DataProviderFactory.getOrangeConfig().getMaxHistorySize();
        return maxHistorySize.orangeExist ? maxHistorySize.value : this.maxHistoryAccount;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public int getMaxSessionSize() {
        IntOrangeResult maxSessionSize = DataProviderFactory.getOrangeConfig().getMaxSessionSize();
        return maxSessionSize.orangeExist ? maxSessionSize.value : this.maxSessionSize;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getOceanAppkey() {
        return null;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getOnlineDomain() {
        return "";
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public int getOrientation() {
        return this.orientation;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getPreDomain() {
        return "";
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getRegFrom() {
        return this.regFrom;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getRegType() {
        return this.regType;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public Map<String, String> getRegisterExternalData(String str) {
        return null;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getResultActivityPath() {
        if (TextUtils.isEmpty(this.mResultActivityPath)) {
            try {
                this.mResultActivityPath = DataProviderFactory.getApplicationContext().getPackageName() + ".ResultActivity";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this.mResultActivityPath;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getSessionDailyDomain() {
        return null;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getSessionOnlineDomain() {
        return null;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getSessionPreDomain() {
        return null;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public int getSite() {
        return this.site;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public int getSmsLength() {
        return this.smsLength;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getTTID() {
        return this.TTID;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public int getToolbarBackIcon() {
        return this.toolbarBack;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public String getUtdid() {
        return this.sdkCustomUtdid;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isAccountProfileExist() {
        return true;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isCheckCookieValid() {
        return this.checkCookieValid;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isEnableVoiceMsg() {
        return this.enableVoiceMsg;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isForbidLoginFromBackground() {
        return this.isForbidLoginFromBackground;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isNeedAlipaySsoGuide() {
        return this.needAlipaySsoGuide;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isNeedPwdGuide() {
        return this.needPwdGuide;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isNeedTaobaoSsoGuide() {
        return this.needTaobaoSsoGuide;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isNeedUpdateUTAccount() {
        BooleanOrangeResult isNeedUpdateUTAccount = DataProviderFactory.getOrangeConfig().isNeedUpdateUTAccount();
        return isNeedUpdateUTAccount.orangeExist ? isNeedUpdateUTAccount.value : this.isNeedUpdateUTAccount;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isRecommendPageFirst() {
        return this.isRecommendPageFirst;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isRefreshCookiesDegrade() {
        return this.refreshCookieDegrade;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isRemoveSessionWhenLogout() {
        return this.isRemoveSessionWhenLogout;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isSaveHistoryWithoutSalt() {
        BooleanOrangeResult isSaveHistoryWithoutSalt = DataProviderFactory.getOrangeConfig().isSaveHistoryWithoutSalt();
        return isSaveHistoryWithoutSalt.orangeExist ? isSaveHistoryWithoutSalt.value : this.saveHistoryWithoutSalt;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isShowHistoryFragment() {
        BooleanOrangeResult supportHistotyLoginPage = DataProviderFactory.getOrangeConfig().supportHistotyLoginPage();
        return supportHistotyLoginPage.orangeExist ? supportHistotyLoginPage.value : this.showHistoryFragment;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isSmsLoginPriority() {
        return false;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isSupportFingerprintLogin() {
        return false;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isTaobaoApp() {
        return this.isTaobaoApp;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isYoukuApps() {
        return this.isYoukuApps;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean needAccsLogin() {
        return this.needAccsLogin;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean needEnterPriseRegister() {
        BooleanOrangeResult needEnterPriseRegister = DataProviderFactory.getOrangeConfig().needEnterPriseRegister();
        return needEnterPriseRegister.orangeExist ? needEnterPriseRegister.value : this.needEnterPriseRegister;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean registerSidToMtop() {
        BooleanOrangeResult registerSidToMtop = DataProviderFactory.getOrangeConfig().registerSidToMtop();
        return registerSidToMtop.orangeExist ? registerSidToMtop.value : this.registerSidToMtop;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setAccountBindBizType(String str) {
        this.mAccountBindBizType = str;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setAlipaySSOEnable(boolean z) {
        this.enableAlipaySSO = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setAlipaySsoDesKey(String str) {
        this.alipaySsoDesKey = str;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setAlwaysPwdLoginPriority(boolean z) {
        this.alwaysPwdLoginPriority = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setAlwaysSMSLoginPriority(boolean z) {
        this.alwaysSMSLoginPriority = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setAppInfoFromServer(boolean z) {
        this.mGetAppInfoFromServer = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setAppName(String str) {
        this.appName = str;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setAppkey(String str) {
        this.appKey = str;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setBtnDrawable(int i) {
        this.btnDrawable = i;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setBtnTextColor(int i) {
        this.btnTextColor = i;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setCancelBtnDrawable(int i) {
        this.cancelBtnDrawable = i;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setCancelBtnTextColor(int i) {
        this.cancelBtnTextColor = i;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setCheckBoxDrawable(int i) {
        this.checkBoxDrawable = i;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setCheckCookieValid(boolean z) {
        this.checkCookieValid = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setContext(Context context) {
        this.context = context;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setEaDeviceId(String str) {
        this.eaDeviceId = str;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setEnableElder(boolean z) {
        this.enableElder = z;
    }

    public void setEnableMobilePwdLogin(boolean z) {
        this.enableMobilePwdLogin = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setEnableVoiceMsg(boolean z) {
        this.enableVoiceMsg = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setEnvType(int i) {
        this.envType = i;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setGuideAppName(String str) {
        this.guideAppName = str;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setGuideBackground(String str) {
        this.guideBackground = str;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setGuideCloseResource(String str) {
        this.guideCloseResource = str;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setGuildePwdLoginResource(String str) {
        this.guidePwdLoginResource = str;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setImageLoader(ImageLoader imageLoader) {
        this.mImageLoader = imageLoader;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setIsTaobaoApp(boolean z) {
        this.isTaobaoApp = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setIsYoukuApp(boolean z) {
        this.isYoukuApps = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setLanguage(Locale locale) {
        this.language = locale;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setLoggerProxy(LoggerProxy loggerProxy) {
        this.mLoggerProxy = loggerProxy;
    }

    public void setLoginStyle(int i) {
        this.loginStyle = i;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setMaxHistoryAccount(int i) {
        this.maxHistoryAccount = i;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setMaxSessionSize(int i) {
        this.maxSessionSize = i;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setNeedAlipaySsoGuide(boolean z) {
        this.needAlipaySsoGuide = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setNeedCleanSessonCookie(boolean z) {
        SessionManager.isNeedCleanSessionCookie = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setNeedPwdGuide(boolean z) {
        this.needPwdGuide = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setNeedTaobaoSsoGuide(boolean z) {
        this.needTaobaoSsoGuide = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setNeedUpdateUTAccount(boolean z) {
        this.isNeedUpdateUTAccount = z;
    }

    public void setOrientation(int i) {
        this.orientation = i;
    }

    public void setRegEmailCheck(boolean z) {
        this.regEmailCheck = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setRegFrom(String str) {
        this.regFrom = str;
    }

    public void setRegPwdCheck(boolean z) {
        this.regPwdCheck = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setRegType(String str) {
        this.regType = str;
    }

    public void setRegisterSidToMtop(boolean z) {
        this.registerSidToMtop = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setRemoveSessionWhenLogout(boolean z) {
        this.isRemoveSessionWhenLogout = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setResultActivityPath(String str) {
        this.mResultActivityPath = str;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setSaveHistoryWithoutSalt(boolean z) {
        this.saveHistoryWithoutSalt = z;
    }

    public void setShowHeadCountry(boolean z) {
        this.showHeadCountry = z;
    }

    public void setShowHistoryFragment(boolean z) {
        this.showHistoryFragment = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setSite(int i) {
        this.site = i;
    }

    public void setSmsLength(int i) {
        this.smsLength = i;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setTTID(String str) {
        this.TTID = str;
    }

    public void setUseRegionFragment(boolean z) {
        this.useRegionFragment = z;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public void setUtdid(String str) {
        this.sdkCustomUtdid = str;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean showHeadCountry() {
        return this.showHeadCountry;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean supportFaceLogin() {
        return this.supportFaceLogin;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean supportMobileLogin() {
        return this.supportMobileLogin;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean supportOneKeyLogin() {
        return this.supportOneKeyLogin;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean supportOneKeyRegister() {
        return this.supportOneKeyRegister;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean supportPwdLogin() {
        return this.supportPwdLogin;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean supportRecommendLogin() {
        return LoginSwitch.isInABTestRegion(LoginSwitch.RECOMMEND_LOGIN_PERCENT, -1);
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean supportTwoStepMobileLogin() {
        return this.supportTwoStepMobileLogin;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean supportTwoStepMobileRegister() {
        return this.supportTwoStepMobileRegister;
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean useNewLoginStrategy() {
        return LoginSwitch.isInABTestRegion(LoginSwitch.LOGIN_STRATEGY, -1);
    }

    @Override // com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean useRegionFragment() {
        return this.useRegionFragment;
    }
}
