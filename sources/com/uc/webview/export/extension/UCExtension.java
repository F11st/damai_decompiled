package com.uc.webview.export.extension;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.interfaces.IUCExtension;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class UCExtension {
    public static final int CORE_STATUS_CHILD_PROCESS_INFO = 2;
    public static final int CORE_STATUS_PROCESS_MODE = 1;
    public static final int EXTEND_INPUT_TYPE_DIGIT = 16777216;
    public static final int EXTEND_INPUT_TYPE_IDCARD = 33554432;
    public static final int EXTEND_INPUT_TYPE_MASK = -16777216;
    public static final int LAYOUT_STYLE_ADAPT_SCREEN = 2;
    public static final int LAYOUT_STYLE_MOBILE_OPTIMUM = 4;
    public static final int LAYOUT_STYLE_ZOOM_OPTIMUM = 1;
    public static final String MOVE_CURSOR_KEY_NEXT_ENABLE = "next_enable";
    public static final String MOVE_CURSOR_KEY_PREVIOUS_ENABLE = "previous_enable";
    public static final String MOVE_CURSOR_KEY_SUCCEED = "succeed";
    public static final int TYPE_PAGE_STORAGE_ALL = 2;
    public static final int TYPE_PAGE_STORAGE_MHTML = 3;
    public static final int TYPE_PAGE_STORAGE_ONLY_HTML = 0;
    public static final int TYPE_PAGE_STORAGE_TEXT = 1;
    private IUCExtension a;

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public interface InjectJSProvider {
        public static final int TYPE_HEAD_START = 1;
        public static final int TYPE_HEAD_START_NODES = 16;

        String getJS(int i);
    }

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public interface OnSoftKeyboardListener {
        boolean displaySoftKeyboard(String str, int i, ValueCallback<String> valueCallback);

        boolean hideSoftKeyboard();

        boolean onFinishComposingText();
    }

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public static class TextSelectionClient {
        public boolean needCustomMenu() {
            return false;
        }

        public boolean onSearchClicked(String str) {
            return false;
        }

        public boolean onShareClicked(String str) {
            return false;
        }

        public void onUpdateMenuPosition(Point point, Point point2, Rect rect, Rect rect2) {
        }

        public boolean shouldShowSearchItem() {
            return false;
        }

        public boolean shouldShowShareItem() {
            return false;
        }

        public void showSelectionMenu(boolean z) {
        }
    }

    public UCExtension(IWebView iWebView) {
        this.a = iWebView.getUCExtension();
    }

    public void getCoreStatus(int i, ValueCallback<Object> valueCallback) {
        this.a.getCoreStatus(i, valueCallback);
    }

    public boolean getCurrentPageSnapshot(Rect rect, Rect rect2, Bitmap bitmap, boolean z, int i) {
        return this.a.getCurrentPageSnapshot(rect, rect2, bitmap, z, i);
    }

    public void getStartupPerformanceStatistics(ValueCallback<String> valueCallback) {
        if (((Boolean) this.a.invoke(26, new Object[]{valueCallback})) != null || valueCallback == null) {
            return;
        }
        valueCallback.onReceiveValue(null);
    }

    public UCSettings getUCSettings() {
        return this.a.getUCSettings();
    }

    @Deprecated
    public boolean ignoreTouchEvent() {
        Log.w("UCExtension", "ignoreTouchEvent Deprecated");
        return false;
    }

    public boolean injectJavascriptNativeCallback(long j, long j2) {
        Object invoke = this.a.invoke(24, new Object[]{Long.valueOf(j), Long.valueOf(j2)});
        if (invoke == null) {
            return false;
        }
        return ((Boolean) invoke).booleanValue();
    }

    public boolean isLoadFromCachedPage() {
        Boolean bool = (Boolean) this.a.invoke(4, null);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public void setClient(UCClient uCClient) {
        this.a.setClient(uCClient);
    }

    public void setInjectJSProvider(InjectJSProvider injectJSProvider, int i) {
        this.a.setInjectJSProvider(injectJSProvider, i);
    }

    public void setIsPreRender(boolean z) {
        this.a.setIsPreRender(z);
    }

    public void setSoftKeyboardListener(OnSoftKeyboardListener onSoftKeyboardListener) {
        this.a.setSoftKeyboardListener(onSoftKeyboardListener);
    }

    @Deprecated
    public void setTextSelectionClient(TextSelectionClient textSelectionClient) {
        this.a.setTextSelectionClient(textSelectionClient);
    }
}
