package com.ali.user.mobile.app.dataprovider;

import android.content.Context;
import com.ali.user.mobile.log.LoggerProxy;
import com.ali.user.mobile.model.RegionInfo;
import java.util.Locale;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface IDataProvider {
    boolean alwaysPwdLoginPriority();

    boolean alwaysSMSLoginPriority();

    boolean enableAlipaySSO();

    boolean enableElder();

    boolean enableMobilePwdLogin();

    boolean enableNumAuthService();

    boolean enableRegEmailCheck();

    boolean enableRegPwdCheck();

    String getAccountBindBizType();

    Map<String, String> getAdditionalHeaders();

    String getAlipaySsoDesKey();

    boolean getAppInfoFromServer();

    String getAppName();

    String getAppkey();

    String getAuthSDKInfo();

    int getBtnDrawable();

    int getBtnTextColor();

    int getCancelBtnDrawable();

    int getCancelBtnTextColor();

    int getCheckBoxDrawable();

    Context getContext();

    Map<String, String> getCurrentAccount();

    Locale getCurrentLanguage();

    RegionInfo getCurrentRegion();

    int getCurrentSite();

    String getDailyDomain();

    String getDeviceId();

    String getEaDeviceId();

    int getEnvType();

    Map<String, String> getExternalData();

    String getGuideAppName();

    String getGuideBackground();

    String getGuideCloseResource();

    String getGuidePwdLoginResource();

    ImageLoader getImageLoader();

    LoggerProxy getLoggerProxy();

    int getLoginStyle();

    int getMaxHistoryAccount();

    int getMaxSessionSize();

    String getOceanAppkey();

    String getOnlineDomain();

    int getOrientation();

    String getPreDomain();

    String getRegFrom();

    String getRegType();

    Map<String, String> getRegisterExternalData(String str);

    String getResultActivityPath();

    String getSessionDailyDomain();

    String getSessionOnlineDomain();

    String getSessionPreDomain();

    int getSite();

    int getSmsLength();

    String getTTID();

    int getToolbarBackIcon();

    String getUtdid();

    boolean isAccountProfileExist();

    boolean isCheckCookieValid();

    boolean isEnableVoiceMsg();

    boolean isForbidLoginFromBackground();

    boolean isNeedAlipaySsoGuide();

    boolean isNeedPwdGuide();

    boolean isNeedTaobaoSsoGuide();

    boolean isNeedUpdateUTAccount();

    boolean isRecommendPageFirst();

    boolean isRefreshCookiesDegrade();

    boolean isRemoveSessionWhenLogout();

    boolean isSaveHistoryWithoutSalt();

    boolean isShowHistoryFragment();

    boolean isSmsLoginPriority();

    boolean isSupportFingerprintLogin();

    boolean isTaobaoApp();

    boolean isYoukuApps();

    boolean needAccsLogin();

    boolean needEnterPriseRegister();

    boolean registerSidToMtop();

    void setAccountBindBizType(String str);

    void setAlipaySSOEnable(boolean z);

    void setAlipaySsoDesKey(String str);

    void setAlwaysPwdLoginPriority(boolean z);

    void setAlwaysSMSLoginPriority(boolean z);

    void setAppInfoFromServer(boolean z);

    void setAppName(String str);

    void setAppkey(String str);

    void setBtnDrawable(int i);

    void setBtnTextColor(int i);

    void setCancelBtnDrawable(int i);

    void setCancelBtnTextColor(int i);

    void setCheckBoxDrawable(int i);

    void setCheckCookieValid(boolean z);

    void setContext(Context context);

    void setDeviceId(String str);

    void setEaDeviceId(String str);

    void setEnableElder(boolean z);

    void setEnableVoiceMsg(boolean z);

    void setEnvType(int i);

    void setGuideAppName(String str);

    void setGuideBackground(String str);

    void setGuideCloseResource(String str);

    void setGuildePwdLoginResource(String str);

    void setImageLoader(ImageLoader imageLoader);

    void setIsTaobaoApp(boolean z);

    void setIsYoukuApp(boolean z);

    void setLanguage(Locale locale);

    void setLoggerProxy(LoggerProxy loggerProxy);

    void setMaxHistoryAccount(int i);

    void setMaxSessionSize(int i);

    void setNeedAlipaySsoGuide(boolean z);

    void setNeedCleanSessonCookie(boolean z);

    void setNeedPwdGuide(boolean z);

    void setNeedTaobaoSsoGuide(boolean z);

    void setNeedUpdateUTAccount(boolean z);

    void setRegFrom(String str);

    void setRegType(String str);

    void setRemoveSessionWhenLogout(boolean z);

    void setResultActivityPath(String str);

    void setSaveHistoryWithoutSalt(boolean z);

    void setSite(int i);

    void setTTID(String str);

    void setUtdid(String str);

    boolean showHeadCountry();

    boolean supportFaceLogin();

    boolean supportMobileLogin();

    boolean supportOneKeyLogin();

    boolean supportOneKeyRegister();

    boolean supportPwdLogin();

    boolean supportRecommendLogin();

    boolean supportTwoStepMobileLogin();

    boolean supportTwoStepMobileRegister();

    boolean useNewLoginStrategy();

    boolean useRegionFragment();
}
