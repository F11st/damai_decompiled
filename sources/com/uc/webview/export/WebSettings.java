package com.uc.webview.export;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.ReflectionUtil;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public abstract class WebSettings {
    public static final int COOKIE_TYPE_HYBRID = 4;
    public static final int COOKIE_TYPE_SYSTEM = 1;
    public static final int COOKIE_TYPE_UC = 2;
    public static final int COOKIE_TYPE_UC_ENCRYPT = 3;
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    @Deprecated
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    public static final int MENU_ITEM_NONE = 0;
    public static final int MENU_ITEM_PROCESS_TEXT = 4;
    public static final int MENU_ITEM_SHARE = 1;
    public static final int MENU_ITEM_WEB_SEARCH = 2;
    public static final int MIXED_CONTENT_ALWAYS_ALLOW = 0;
    public static final int MIXED_CONTENT_COMPATIBILITY_MODE = 2;
    public static final int MIXED_CONTENT_NEVER_ALLOW = 1;
    public android.webkit.WebSettings mSettings = null;
    private String a = "";

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS,
        TEXT_AUTOSIZING
    }

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(150),
        LARGEST(200);
        
        public int value;

        TextSize(int i) {
            this.value = i;
        }
    }

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);
        
        int a;

        ZoomDensity(int i) {
            this.a = i;
        }

        public final int getValue() {
            return this.a;
        }
    }

    public static String getDefaultUserAgent(Context context) {
        return SDKFactory.d(context);
    }

    @TargetApi(11)
    public boolean getAllowContentAccess() {
        return Build.VERSION.SDK_INT >= 11 && this.mSettings.getAllowContentAccess();
    }

    public boolean getAllowFileAccess() {
        return this.mSettings.getAllowFileAccess();
    }

    public boolean getAllowFileAccessFromFileURLs() {
        Boolean bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "getAllowFileAccessFromFileURLs");
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean getAllowUniversalAccessFromFileURLs() {
        Boolean bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "getAllowUniversalAccessFromFileURLs");
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public synchronized boolean getBlockNetworkImage() {
        return this.mSettings.getBlockNetworkImage();
    }

    public synchronized boolean getBlockNetworkLoads() {
        return this.mSettings.getBlockNetworkLoads();
    }

    public boolean getBuiltInZoomControls() {
        return this.mSettings.getBuiltInZoomControls();
    }

    public int getCacheMode() {
        return this.mSettings.getCacheMode();
    }

    public synchronized String getCursiveFontFamily() {
        return this.mSettings.getCursiveFontFamily();
    }

    public synchronized boolean getDatabaseEnabled() {
        return this.mSettings.getDatabaseEnabled();
    }

    public synchronized int getDefaultFixedFontSize() {
        return this.mSettings.getDefaultFixedFontSize();
    }

    public synchronized int getDefaultFontSize() {
        return this.mSettings.getDefaultFontSize();
    }

    public synchronized String getDefaultTextEncodingName() {
        return this.mSettings.getDefaultTextEncodingName();
    }

    @TargetApi(24)
    public int getDisabledActionModeMenuItems() {
        Integer num;
        if (Build.VERSION.SDK_INT < 24 || (num = (Integer) ReflectionUtil.invokeNoThrow(this.mSettings, "getDisabledActionModeMenuItems")) == null) {
            return 0;
        }
        return num.intValue();
    }

    @TargetApi(11)
    public boolean getDisplayZoomControls() {
        if (Build.VERSION.SDK_INT >= 11) {
            return this.mSettings.getDisplayZoomControls();
        }
        return false;
    }

    public synchronized boolean getDomStorageEnabled() {
        return this.mSettings.getDomStorageEnabled();
    }

    public synchronized String getFantasyFontFamily() {
        return this.mSettings.getFantasyFontFamily();
    }

    public synchronized String getFixedFontFamily() {
        return this.mSettings.getFixedFontFamily();
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.mSettings.getJavaScriptCanOpenWindowsAutomatically();
    }

    public synchronized boolean getJavaScriptEnabled() {
        return this.mSettings.getJavaScriptEnabled();
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        return LayoutAlgorithm.valueOf(this.mSettings.getLayoutAlgorithm().name());
    }

    public boolean getLoadWithOverviewMode() {
        return this.mSettings.getLoadWithOverviewMode();
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        return this.mSettings.getLoadsImagesAutomatically();
    }

    public boolean getMediaPlaybackRequiresUserGesture() {
        Boolean bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "getMediaPlaybackRequiresUserGesture");
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public synchronized int getMinimumFontSize() {
        return this.mSettings.getMinimumFontSize();
    }

    public synchronized int getMinimumLogicalFontSize() {
        return this.mSettings.getMinimumLogicalFontSize();
    }

    public int getMixedContentMode() {
        Integer num;
        if (Build.VERSION.SDK_INT < 21 || (num = (Integer) ReflectionUtil.invokeNoThrow(this.mSettings, "getMixedContentMode")) == null) {
            return 0;
        }
        return num.intValue();
    }

    @TargetApi(23)
    public boolean getOffscreenPreRaster() {
        Boolean bool;
        if (Build.VERSION.SDK_INT < 23 || (bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "getOffscreenPreRaster")) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public synchronized String getPreCacheScope() {
        return this.a;
    }

    public synchronized String getSansSerifFontFamily() {
        return this.mSettings.getSansSerifFontFamily();
    }

    public boolean getSaveFormData() {
        return this.mSettings.getSaveFormData();
    }

    @Deprecated
    public boolean getSavePassword() {
        Boolean bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "getSavePassword");
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public synchronized String getSerifFontFamily() {
        return this.mSettings.getSerifFontFamily();
    }

    public synchronized String getStandardFontFamily() {
        return this.mSettings.getStandardFontFamily();
    }

    @TargetApi(14)
    public synchronized int getTextZoom() {
        if (Build.VERSION.SDK_INT >= 14) {
            return this.mSettings.getTextZoom();
        }
        return 0;
    }

    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        Boolean bool = (Boolean) ReflectionUtil.invokeNoThrow(this.mSettings, "getUseWebViewBackgroundForOverscrollBackground");
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public synchronized boolean getUseWideViewPort() {
        return this.mSettings.getUseWideViewPort();
    }

    public synchronized String getUserAgentString() {
        return this.mSettings.getUserAgentString();
    }

    @TargetApi(11)
    public void setAllowContentAccess(boolean z) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.mSettings.setAllowContentAccess(z);
        }
    }

    public void setAllowFileAccess(boolean z) {
        this.mSettings.setAllowFileAccess(z);
    }

    public void setAllowFileAccessFromFileURLs(boolean z) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setAllowFileAccessFromFileURLs", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }

    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setAllowUniversalAccessFromFileURLs", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }

    public synchronized void setAppCacheEnabled(boolean z) {
        this.mSettings.setAppCacheEnabled(z);
    }

    @Deprecated
    public synchronized void setAppCacheMaxSize(long j) {
        Log.w("WebSettings", "setAppCacheMaxSize Deprecated");
    }

    public synchronized void setAppCachePath(String str) {
        this.mSettings.setAppCachePath(str);
    }

    public synchronized void setBlockNetworkImage(boolean z) {
        this.mSettings.setBlockNetworkImage(z);
    }

    public synchronized void setBlockNetworkLoads(boolean z) {
        this.mSettings.setBlockNetworkLoads(z);
    }

    public void setBuiltInZoomControls(boolean z) {
        this.mSettings.setBuiltInZoomControls(z);
    }

    public void setCacheMode(int i) {
        this.mSettings.setCacheMode(i);
    }

    public synchronized void setCursiveFontFamily(String str) {
        this.mSettings.setCursiveFontFamily(str);
    }

    public synchronized void setDatabaseEnabled(boolean z) {
        this.mSettings.setDatabaseEnabled(z);
    }

    public synchronized void setDatabasePath(String str) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setDatabasePath", new Class[]{String.class}, new Object[]{str});
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        this.mSettings.setDefaultFixedFontSize(i);
    }

    public synchronized void setDefaultFontSize(int i) {
        this.mSettings.setDefaultFontSize(i);
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        this.mSettings.setDefaultTextEncodingName(str);
    }

    @TargetApi(24)
    public void setDisabledActionModeMenuItems(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            ReflectionUtil.invokeNoThrow(this.mSettings, "setDisabledActionModeMenuItems", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
        }
    }

    @TargetApi(11)
    public void setDisplayZoomControls(boolean z) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.mSettings.setDisplayZoomControls(z);
        }
    }

    public synchronized void setDomStorageEnabled(boolean z) {
        this.mSettings.setDomStorageEnabled(z);
    }

    public synchronized void setFantasyFontFamily(String str) {
        this.mSettings.setFantasyFontFamily(str);
    }

    public synchronized void setFixedFontFamily(String str) {
        this.mSettings.setFixedFontFamily(str);
    }

    public synchronized void setGeolocationDatabasePath(String str) {
        this.mSettings.setGeolocationDatabasePath(str);
    }

    public synchronized void setGeolocationEnabled(boolean z) {
        this.mSettings.setGeolocationEnabled(z);
    }

    public void setHighPriWpkBid(String str) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setHighPriWpkBid", new Class[]{String.class}, new Object[]{str});
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        this.mSettings.setJavaScriptCanOpenWindowsAutomatically(z);
    }

    public synchronized void setJavaScriptEnabled(boolean z) {
        this.mSettings.setJavaScriptEnabled(z);
    }

    public synchronized void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        this.mSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
    }

    public void setLoadWithOverviewMode(boolean z) {
        this.mSettings.setLoadWithOverviewMode(z);
    }

    public synchronized void setLoadsImagesAutomatically(boolean z) {
        this.mSettings.setLoadsImagesAutomatically(z);
    }

    public void setLowPriWpkBid(String str) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setLowPriWpkBid", new Class[]{String.class}, new Object[]{str});
    }

    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setMediaPlaybackRequiresUserGesture", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }

    public synchronized void setMinimumFontSize(int i) {
        this.mSettings.setMinimumFontSize(i);
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        this.mSettings.setMinimumLogicalFontSize(i);
    }

    public void setMixedContentMode(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            ReflectionUtil.invokeNoThrow(this.mSettings, "setMixedContentMode", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
        }
    }

    public void setNeedInitialFocus(boolean z) {
        this.mSettings.setNeedInitialFocus(z);
    }

    @TargetApi(23)
    public void setOffscreenPreRaster(boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            ReflectionUtil.invokeNoThrow(this.mSettings, "setOffscreenPreRaster", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
        }
    }

    public synchronized void setPreCacheScope(String str) {
        this.a = str;
    }

    @Deprecated
    public synchronized void setRenderPriority(RenderPriority renderPriority) {
        Log.w("WebSettings", "setRenderPriority Deprecated");
    }

    public synchronized void setSansSerifFontFamily(String str) {
        this.mSettings.setSansSerifFontFamily(str);
    }

    public void setSaveFormData(boolean z) {
        this.mSettings.setSaveFormData(z);
    }

    @Deprecated
    public void setSavePassword(boolean z) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setSavePassword", new Class[]{Boolean.class}, new Object[]{Boolean.valueOf(z)});
    }

    public synchronized void setSerifFontFamily(String str) {
        this.mSettings.setSerifFontFamily(str);
    }

    public synchronized void setStandardFontFamily(String str) {
        this.mSettings.setStandardFontFamily(str);
    }

    public synchronized void setSupportMultipleWindows(boolean z) {
        this.mSettings.setSupportMultipleWindows(z);
    }

    public void setSupportZoom(boolean z) {
        this.mSettings.setSupportZoom(z);
    }

    @TargetApi(14)
    public synchronized void setTextZoom(int i) {
    }

    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
        ReflectionUtil.invokeNoThrow(this.mSettings, "setUseWebViewBackgroundForOverscrollBackground", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }

    public synchronized void setUseWideViewPort(boolean z) {
        this.mSettings.setUseWideViewPort(z);
    }

    public synchronized void setUserAgentString(String str) {
        this.mSettings.setUserAgentString(str);
    }

    public synchronized boolean supportMultipleWindows() {
        return this.mSettings.supportMultipleWindows();
    }

    public boolean supportZoom() {
        return this.mSettings.supportZoom();
    }
}
