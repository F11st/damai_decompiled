package tb;

import android.content.Context;
import android.net.Uri;
import android.taobao.windvane.extra.uc.WVUCWebChromeClient;
import android.webkit.ValueCallback;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebView;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bl2 extends WVUCWebChromeClient {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl2(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebChromeClient, com.uc.webview.export.WebChromeClient
    public boolean onShowFileChooser(@Nullable WebView webView, @Nullable ValueCallback<Uri[]> valueCallback, @Nullable WebChromeClient.FileChooserParams fileChooserParams) {
        return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebChromeClient, com.uc.webview.export.WebChromeClient
    public void openFileChooser(@Nullable ValueCallback<Uri> valueCallback) {
        super.openFileChooser(valueCallback);
    }
}
