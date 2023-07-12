package com.uc.webview.export.extension;

import android.webkit.ValueCallback;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Api;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class UCClient {
    public static final int FORM_PROMPT_TYPE_COVER = 1;
    public static final int FORM_PROMPT_TYPE_SAVE = 0;
    public static final int WEBVIEW_EVENT_TYPE_AUDIO_DATA_USED = 105;
    public static final int WEBVIEW_EVENT_TYPE_BASE_COLOR_EMPTY_SCREEN = 16;
    public static final int WEBVIEW_EVENT_TYPE_BLOCK_WINDOW = 0;
    public static final int WEBVIEW_EVENT_TYPE_CREATE_ISOLATE_STATIC_WEBVIEW = 109;
    public static final int WEBVIEW_EVENT_TYPE_DESTORY_NON_ISOLATE_STATIC_WEBVIEW = 108;
    public static final int WEBVIEW_EVENT_TYPE_EMPTY_SCREEN = 9;
    public static final int WEBVIEW_EVENT_TYPE_EMPTY_SCREEN_INFO = 15;
    public static final int WEBVIEW_EVENT_TYPE_FIRST_PAINT = 17;
    public static final int WEBVIEW_EVENT_TYPE_GETJS_URL = 22;
    public static final int WEBVIEW_EVENT_TYPE_HIDE_SOFTKEYBOARD = 1;
    public static final int WEBVIEW_EVENT_TYPE_LINKID_NOTIFICATION = 20;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_OTHER_TRIGGER = 11;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_STATUS_START = 4;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_STATUS_T0 = 5;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_STATUS_T1 = 6;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_STATUS_T2 = 7;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_STATUS_T2_PAINT = 13;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_STATUS_T2_TRACE = 14;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_STATUS_T3 = 8;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_USER_TRIGGER = 10;
    public static final int WEBVIEW_EVENT_TYPE_MEDIA_MESSAGE_STATS = 103;
    public static final int WEBVIEW_EVENT_TYPE_NETWORK_IP_RESOLVED = 12;
    public static final int WEBVIEW_EVENT_TYPE_NO_MATCH_IMG_DECODER = 21;
    public static final int WEBVIEW_EVENT_TYPE_ON_GPU_PROCESS_READY = 110;
    public static final int WEBVIEW_EVENT_TYPE_ON_RENDER_PROCESS_READY = 107;
    public static final int WEBVIEW_EVENT_TYPE_SHARE_VIDEO = 2;
    public static final int WEBVIEW_EVENT_TYPE_SHOW_VIDEO_GESTURE_GUIDE = 3;
    public static final int WEBVIEW_EVENT_TYPE_VIDEO_DATA_USED = 104;
    public static final int WEBVIEW_EVENT_TYPE_VIDEO_ENTER_FULLSCREEN = 101;
    public static final int WEBVIEW_EVENT_TYPE_VIDEO_EXIT_FULLSCREEN = 102;
    public static final int WEBVIEW_EVENT_TYPE_WEBGL_ERROR_STATE = 19;
    public static final int WEBVIEW_EVENT_TYPE_WEBGL_JS_ERROR = 18;
    public static final int WEBVIEW_EVENT_TYPE_WEB_PAGE_USES_WEBGL = 106;
    public static final int WIFI_POLICY_CONTINUE = 0;
    public static final int WIFI_POLICY_INTERRUP = 1;
    public static final int WIFI_POLICY_USE_FOXY_SERVER = 2;

    /* compiled from: Taobao */
    @Api
    @Deprecated
    /* loaded from: classes11.dex */
    public static class MoveCursorToTextInputResult {
        public boolean mCanMoveToNext;
        public boolean mCanMoveToPrevious;
        public boolean mSuccess;
    }

    public String getCachedFilePath(String str) {
        return null;
    }

    public IEmbedView getEmbedView(EmbedViewConfig embedViewConfig, IEmbedViewContainer iEmbedViewContainer) {
        return null;
    }

    public void onCheckSelfPermission(String str, ValueCallback<Boolean> valueCallback) {
    }

    public boolean onCheckSelfPermission(String str) {
        return false;
    }

    public void onCoreFault(Map<String, String> map, ValueCallback<Boolean> valueCallback) {
        valueCallback.onReceiveValue(Boolean.FALSE);
    }

    public void onEndEditingTextField(String str) {
    }

    @Deprecated
    public void onFirstLayoutFinished(boolean z, String str) {
    }

    public void onFirstVisuallyNonEmptyDraw() {
    }

    public void onGeneralPermissionsShowPrompt(Map<String, String> map, ValueCallback<Map<String, String>> valueCallback) {
    }

    public void onGpuProcessGone(String str) {
    }

    @Deprecated
    public void onMoveCursorToTextInput(MoveCursorToTextInputResult moveCursorToTextInputResult) {
    }

    public void onReceivedDispatchResponse(HashMap<String, String> hashMap) {
    }

    public void onResourceDidFinishLoading(String str, long j) {
    }

    public void onSaveFormDataPrompt(int i, ValueCallback<Boolean> valueCallback) {
    }

    public void onWebViewEvent(WebView webView, int i, Object obj) {
    }

    public boolean onWillInterceptResponse(HashMap<String, String> hashMap) {
        return false;
    }

    @Deprecated
    public WebResourceRequest onWillSendRequest(WebResourceRequest webResourceRequest) {
        return null;
    }

    public String populateErrorPage(WebView webView, String str, int i, String str2) {
        return null;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str, int i) {
        return false;
    }

    public boolean showMediaPlayerMobileNetworkWarning(ValueCallback<Boolean> valueCallback) {
        return false;
    }
}
