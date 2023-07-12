package android.taobao.windvane.webview;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.taobao.windvane.util.TaoLog;
import android.webkit.WebView;
import com.youku.uplayer.AliMediaPlayer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVTweakWebCoreHandler {
    static Handler sProxyHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class WebCoreProxyHandler extends Handler {
        final Handler handler;

        public WebCoreProxyHandler(Handler handler) {
            super(handler.getLooper());
            this.handler = handler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (TaoLog.getLogStatus()) {
                    TaoLog.d("WebCoreProxyHandler", "handle message: " + message.what);
                }
                this.handler.handleMessage(message);
            } catch (Throwable th) {
                TaoLog.e("WebCoreProxyHandler", "handleMessage exception: " + th);
            }
        }
    }

    public static void tryTweakWebCoreHandler() {
        if (Build.VERSION.SDK_INT == 15) {
            String brand = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND();
            if ("SAMSUNG".equalsIgnoreCase(brand)) {
                return;
            }
            if (TaoLog.getLogStatus()) {
                TaoLog.w("TweakWebCoreHandler", "BRAND: " + brand);
            }
            tweakWebCoreHandler();
        }
    }

    private static void tweakWebCoreHandler() {
        if (sProxyHandler != null) {
            return;
        }
        try {
            Field declaredField = Class.forName("android.webkit.WebViewCore").getDeclaredField("sWebCoreHandler");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Method declaredMethod = Handler.class.getDeclaredMethod("getIMessenger", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(obj, null);
            sProxyHandler = new WebCoreProxyHandler((Handler) obj);
            if (invoke != null) {
                Field declaredField2 = Handler.class.getDeclaredField("mMessenger");
                declaredField2.setAccessible(true);
                declaredField2.set(sProxyHandler, invoke);
            }
            declaredField.set(null, sProxyHandler);
            if (TaoLog.getLogStatus()) {
                TaoLog.d("TweakWebCoreHandler", "sWebCoreHandler: " + obj);
            }
        } catch (Throwable th) {
            TaoLog.e("TweakWebCoreHandler", "tweakWebCoreHandler exception: " + th);
        }
        if (sProxyHandler == null) {
            sProxyHandler = new Handler();
        }
    }

    public static void tweakWebCoredump(WebView webView) {
        try {
            Field declaredField = Class.forName("android.webkit.WebView").getDeclaredField("mProvider");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(webView);
            Class<?> cls = Class.forName("android.webkit.WebViewClassic");
            cls.cast(obj);
            Field declaredField2 = cls.getDeclaredField("mWebViewCore");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Class<?> cls2 = Class.forName("android.webkit.WebViewCore");
            Class<?> cls3 = Integer.TYPE;
            Method declaredMethod = cls2.getDeclaredMethod("sendMessage", cls3, cls3, cls3);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj2, Integer.valueOf((int) AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT), 1, 0);
            declaredMethod.invoke(obj2, Integer.valueOf((int) AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_DOWNLOAD_SPEED_CALC_COUNT), 1, 0);
            Method declaredMethod2 = cls.getDeclaredMethod("nativeDumpDisplayTree", String.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(obj, webView.getUrl());
        } catch (Throwable th) {
            TaoLog.e("TweakWebCoreHandler", "tweakWebCoreHandler exception: " + th);
        }
    }
}
