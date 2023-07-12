package com.ali.user.open.core.config;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ali.user.open.core.WebViewProxy;
import com.ali.user.open.core.callback.DataProvider;
import com.ali.user.open.core.callback.ThemeProvider;
import com.ali.user.open.core.context.KernelContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ConfigManager {
    public static boolean DEBUG;
    public static String LOGOUT_URLS;
    public static String POSTFIX_OF_SECURITY_JPG_USER_SET;
    public String dailyDomain;
    private Environment env;
    public boolean handleWebviewDir;
    protected Class mNavHelper;
    private String mUccDataProviderClass;
    public Class mUccHelper;
    public String onlineDomain;
    public String preDomain;
    Map<String, Object> scanParams;
    public String sessionDailyDomain;
    public String sessionOnlineDomain;
    public String sessionPreDomain;
    private static final ConfigManager SINGLETON_INSTANCE = new ConfigManager();
    public static String ICBU_LOGIN_HOST_DAILY = "https://passport.daily.alibaba.com/oauth.htm?appName=icbu-oauth&appEntrance=";
    public static String ICBU_LOGIN_HOST = "https://passport.alibaba.com/oauth.htm?appName=icbu-oauth&appEntrance=";
    public static String LOGIN_HOST = "https://havanalogin.taobao.com/taobao_oauth_common.htm?appName=taobao-oauth-common&appEntrance=sdk-common&needTopToken=true&topTokenAppName=";
    public static String LOGIN_URLS = "((https|http)://)login.(m|wapa|waptest).(taobao|tmall).com/(login/){0,1}login.htm(.*);((https|http)://)login.tmall.com(.*);((https|http)://)login.taobao.com/member/login.jhtml(.*);(http|https)://login.(taobao|tmall).com/login/(.*);http://login.m.taobao.com/minisdk/login.htm;https://oauth.m.taobao.com/authorize;((https|http)://)login.m.taobao.com/msg_login.htm(.*)";
    public static String DAMAI_LOGIN_URLS = "((https|http)://)(m|market.wapa|market.waptest).(?:taobao.com|damai.cn)/(damai|app/damai/damai-msite)/minilogin/index.html(.*)";
    public static String bindTitle = "";
    public static int APP_KEY_INDEX = 0;
    public static int DAILY_APP_KEY_INDEX = 0;
    public static String POSTFIX_OF_SECURITY_JPG = "";
    public static String qrCodeLoginUrl = "http://login.m.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin";
    private int maxHistoryAccount = 1;
    private boolean saveHistoryWithSalt = true;
    private DataProvider mLoginEntrenceCallback = null;
    public boolean isMultiProcessEnable = false;
    public boolean useNewMtopInstanceId = true;
    private ThemeProvider mThemeDataProvider = null;
    private List<String> mH5OnlyBindSites = new ArrayList();
    private Locale language = Locale.SIMPLIFIED_CHINESE;
    private boolean registerSidToMtopDefault = false;
    private WebViewOption mWebViewOption = WebViewOption.UC;
    private boolean isMiniProgram = false;

    private ConfigManager() {
    }

    public static int getAppKeyIndex() {
        if (getInstance().getEnvironment() != null && getInstance().getEnvironment().equals(Environment.TEST)) {
            return DAILY_APP_KEY_INDEX;
        }
        return APP_KEY_INDEX;
    }

    public static ConfigManager getInstance() {
        return SINGLETON_INSTANCE;
    }

    public static void setAppKeyIndex(int i) {
        APP_KEY_INDEX = i;
    }

    public void addH5OnlyBindSites(String str) {
        this.mH5OnlyBindSites.add(str);
    }

    public String getBindTitle() {
        return bindTitle;
    }

    public Locale getCurrentLanguage() {
        return this.language;
    }

    public Environment getEnvironment() {
        return this.env;
    }

    public DataProvider getLoginEntrenceCallback() {
        return this.mLoginEntrenceCallback;
    }

    public int getMaxHistoryAccount() {
        return this.maxHistoryAccount;
    }

    public Class getNavHelper() {
        return this.mNavHelper;
    }

    public ThemeProvider getThemeDataProvider() {
        return this.mThemeDataProvider;
    }

    public String getUccDataProviderClass() {
        if (!TextUtils.isEmpty(this.mUccDataProviderClass)) {
            return this.mUccDataProviderClass;
        }
        try {
            return KernelContext.getApplicationContext().getSharedPreferences("ucc_sdk", 0).getString("ucc_dataprovider", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public WebViewOption getWebViewOption() {
        return this.mWebViewOption;
    }

    public void init() {
        if (this.env == null) {
            this.env = Environment.ONLINE;
        }
        int ordinal = this.env.ordinal();
        LOGIN_HOST = new String[]{"https://havanalogin.taobao.com/taobao_oauth_common.htm?appName=taobao-oauth-common&appEntrance=sdk-common&needTopToken=true&topTokenAppName=", "https://havanalogin.taobao.com/taobao_oauth_common.htm?appName=taobao-oauth-common&appEntrance=sdk-common&needTopToken=true&topTokenAppName=", "http://passport.daily.alibaba.com/taobao_oauth_common.htm?appName=taobao-oauth-common&appEntrance=sdk-common&needTopToken=true&topTokenAppName=", "http://passport.daily.alibaba.com/taobao_oauth_common.htm?appName=taobao-oauth-common&appEntrance=sdk-common&needTopToken=true&topTokenAppName="}[ordinal];
        LOGOUT_URLS = new String[]{"((https|http)://)login.m.taobao.com/logout.htm(.*)", "((https|http)://)login.wapa.taobao.com/logout.htm(.*)", "((https|http)://)login.waptest.taobao.com/logout.htm(.*)", "((https|http)://)login.waptest.tbsandbox.com/logout.htm(.*)"}[ordinal];
        qrCodeLoginUrl = new String[]{"http://login.m.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin", "http://login.wapa.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin", "http://login.waptest.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin", "http://login.waptest.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin"}[ordinal];
        String str = POSTFIX_OF_SECURITY_JPG_USER_SET;
        if (str == null) {
            POSTFIX_OF_SECURITY_JPG = new String[]{"", "", "", ""}[ordinal];
        } else {
            POSTFIX_OF_SECURITY_JPG = str;
        }
    }

    public boolean isH5OnlyBindSites(String str) {
        return this.mH5OnlyBindSites.contains(str);
    }

    public boolean isMiniProgram() {
        return this.isMiniProgram;
    }

    public boolean isRegisterSidToMtopDefault() {
        return this.registerSidToMtopDefault;
    }

    public boolean isSaveHistoryWithSalt() {
        return this.saveHistoryWithSalt;
    }

    public void setBindTitle(String str) {
        bindTitle = str;
    }

    public void setDailyDomain(String str) {
        this.dailyDomain = str;
    }

    public void setEnvironment(Environment environment) {
        this.env = environment;
        init();
    }

    public void setLanguage(Locale locale) {
        this.language = locale;
    }

    public void setLoginEntrenceCallback(DataProvider dataProvider) {
        this.mLoginEntrenceCallback = dataProvider;
    }

    public void setMaxHistoryAccount(int i) {
        this.maxHistoryAccount = i;
    }

    public void setMiniProgram(boolean z) {
        this.isMiniProgram = z;
    }

    public void setNavHelper(Class cls) {
        this.mNavHelper = cls;
    }

    public void setOnlineDomain(String str) {
        this.onlineDomain = str;
    }

    public void setPreDomain(String str) {
        this.preDomain = str;
    }

    public void setRegisterSidToMtopDefault(boolean z) {
        this.registerSidToMtopDefault = z;
    }

    public void setSaveHistoryWithSalt(boolean z) {
        this.saveHistoryWithSalt = z;
    }

    public void setSessionDailyDomain(String str) {
        this.sessionDailyDomain = str;
    }

    public void setSessionOnlineDomain(String str) {
        this.sessionOnlineDomain = str;
    }

    public void setSessionPreDomain(String str) {
        this.sessionPreDomain = str;
    }

    public void setThemeDataProvider(ThemeProvider themeProvider) {
        this.mThemeDataProvider = themeProvider;
    }

    public void setUccDataProviderClass(String str) {
        this.mUccDataProviderClass = str;
        try {
            SharedPreferences.Editor edit = KernelContext.getApplicationContext().getSharedPreferences("ucc_sdk", 0).edit();
            edit.putString("ucc_dataprovider", this.mUccDataProviderClass);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public void setWebViewOption(WebViewOption webViewOption) {
        this.mWebViewOption = webViewOption;
    }

    public void setWebViewProxy(WebViewProxy webViewProxy) {
        KernelContext.mWebViewProxy = webViewProxy;
    }

    public static void setAppKeyIndex(int i, int i2) {
        APP_KEY_INDEX = i;
        DAILY_APP_KEY_INDEX = i2;
    }
}
