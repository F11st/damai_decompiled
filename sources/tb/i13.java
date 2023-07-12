package tb;

import android.content.Context;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVWebView;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebSettings;
import cn.damai.commonbusiness.poplayer.view.h5.PopLayerWebView;
import cn.damai.commonbusiness.poplayer.view.h5.plugin.PopLayerWVPlugin;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class i13 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Map<ConsoleMessage.MessageLevel, Character> WEBCONSOLE_LOGCAT_MAP;

    static {
        HashMap hashMap = new HashMap();
        WEBCONSOLE_LOGCAT_MAP = hashMap;
        hashMap.put(ConsoleMessage.MessageLevel.TIP, 'v');
        hashMap.put(ConsoleMessage.MessageLevel.LOG, 'i');
        hashMap.put(ConsoleMessage.MessageLevel.WARNING, 'w');
        hashMap.put(ConsoleMessage.MessageLevel.ERROR, 'e');
        hashMap.put(ConsoleMessage.MessageLevel.DEBUG, 'd');
    }

    public static void a(Context context, PopLayerWebView popLayerWebView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1335355683")) {
            ipChange.ipc$dispatch("1335355683", new Object[]{context, popLayerWebView});
            return;
        }
        IWVWebView webView = popLayerWebView.getWebView();
        if (webView instanceof WVWebView) {
            WVWebView wVWebView = (WVWebView) webView;
            wVWebView.setBackgroundColor(1);
            WebSettings settings = wVWebView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setSavePassword(false);
            wVWebView.addJsObject("WVPopLayer", new PopLayerWVPlugin(popLayerWebView));
            View view = new View(context);
            view.setBackgroundColor(1);
            wVWebView.getWvUIModel().setErrorView(view);
        } else if (popLayerWebView.getWebView() instanceof WVUCWebView) {
            WVUCWebView wVUCWebView = (WVUCWebView) webView;
            wVUCWebView.setBackgroundColor(0);
            com.uc.webview.export.WebSettings settings2 = wVUCWebView.getSettings();
            settings2.setJavaScriptEnabled(true);
            settings2.setSavePassword(false);
            wVUCWebView.addJsObject("WVPopLayer", new PopLayerWVPlugin(popLayerWebView));
            View view2 = new View(context);
            view2.setBackgroundColor(1);
            wVUCWebView.getWvUIModel().setErrorView(view2);
            popLayerWebView.setUseCacheMark(false);
        }
    }
}
