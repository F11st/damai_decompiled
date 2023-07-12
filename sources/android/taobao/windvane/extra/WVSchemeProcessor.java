package android.taobao.windvane.extra;

import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.WVSchemeIntercepterInterface;
import android.text.TextUtils;
import anet.channel.strategy.a;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVSchemeProcessor implements WVSchemeIntercepterInterface {
    @Override // android.taobao.windvane.webview.WVSchemeIntercepterInterface
    public String dealUrlScheme(String str) {
        try {
            if (!TextUtils.isEmpty(str) && !str.startsWith("javascript:") && !str.equals("about:blank")) {
                String formalizeUrl = a.a().getFormalizeUrl(str);
                return TextUtils.isEmpty(formalizeUrl) ? str : formalizeUrl;
            }
            return str;
        } catch (Throwable unused) {
            TaoLog.e("WVSchemeProcessor", "Can not dealUrlScheme : " + str);
            return str.startsWith(WVUtils.URL_SEPARATOR) ? str.replaceFirst(WVUtils.URL_SEPARATOR, "http://") : str;
        }
    }
}
