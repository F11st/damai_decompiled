package com.taobao.weex.ui.module;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXLocaleModule extends WXModule {
    private String getLanguageImpl() {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    private String getLanguageTags() {
        Resources resources;
        Configuration configuration;
        Application application = WXEnvironment.getApplication();
        if (application == null || (resources = application.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return configuration.getLocales().toLanguageTags();
        }
        Locale locale = configuration.locale;
        return locale != null ? toLanguageTag(locale) : "";
    }

    private String toLanguageTag(Locale locale) {
        if (Build.VERSION.SDK_INT >= 21) {
            return locale.toLanguageTag();
        }
        StringBuilder sb = new StringBuilder();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        sb.append(language);
        if (!TextUtils.isEmpty(country)) {
            sb.append("-");
            sb.append(country);
        }
        return sb.toString();
    }

    @JSMethod(uiThread = false)
    public void getLanguage(JSCallback jSCallback) {
        jSCallback.invoke(getLanguageImpl());
    }

    @JSMethod(uiThread = false)
    public String getLanguageSync() {
        return getLanguageImpl();
    }

    @JSMethod(uiThread = false)
    public List<String> getLanguages() {
        return Arrays.asList(getLanguageTags().split(","));
    }

    @JSMethod(uiThread = false)
    public void getLanguages(JSCallback jSCallback) {
        jSCallback.invoke(getLanguageTags().split(","));
    }
}
