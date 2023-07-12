package android.taobao.windvane.debug;

import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.service.WVWebViewClientFilter;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVPageFinishJSRender {
    private static String jsContent;
    private static boolean renderJs;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class WVDevelopToolWebViewClientFilter extends WVWebViewClientFilter {
        @Override // android.taobao.windvane.service.WVWebViewClientFilter
        public void onPageFinished(IWVWebView iWVWebView, String str) {
            if (WVPageFinishJSRender.renderJs && !TextUtils.isEmpty(WVPageFinishJSRender.jsContent) && (iWVWebView instanceof IWVWebView)) {
                iWVWebView.evaluateJavascript(WVPageFinishJSRender.jsContent);
            }
        }
    }

    static {
        WVEventService.getInstance().addEventListener(new WVDevelopToolWebViewClientFilter(), WVEventService.WV_BACKWARD_EVENT);
    }

    public static void clearJsRender() {
        renderJs = false;
        jsContent = null;
    }

    public static boolean isRenderJs() {
        return renderJs;
    }

    public static void setJsContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        renderJs = true;
        jsContent = str;
    }
}
