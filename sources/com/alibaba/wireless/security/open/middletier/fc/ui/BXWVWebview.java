package com.alibaba.wireless.security.open.middletier.fc.ui;

import android.content.Context;
import android.os.Build;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview;
import com.uc.webview.export.DownloadListener;
import com.uc.webview.export.WebView;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BXWVWebview extends WVUCWebView implements IBXWebview {
    IUrlVerifyCallback a;

    public BXWVWebview(Context context, String str) {
        super(context);
        this.a = null;
        getSettings().setTextZoom(100);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview
    public void bxDestroy() {
        setVisibility(8);
        removeAllViews();
        coreDestroy();
    }

    @Override // com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview
    public void bxLoadUrl(String str) {
        loadUrl(str);
    }

    @Override // com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview
    public void bxSetUp(Context context, IUrlVerifyCallback iUrlVerifyCallback, final IBXWebview.IBXDownloadService iBXDownloadService) {
        this.a = iUrlVerifyCallback;
        setWebViewClient(new WVUCWebViewClient(context) { // from class: com.alibaba.wireless.security.open.middletier.fc.ui.BXWVWebview.1
            @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                IUrlVerifyCallback iUrlVerifyCallback2 = BXWVWebview.this.a;
                if (iUrlVerifyCallback2 == null || !iUrlVerifyCallback2.shouldOverrideUrlLoading(str)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                return true;
            }
        });
        if (iBXDownloadService != null) {
            setDownloadListener(new DownloadListener(this) { // from class: com.alibaba.wireless.security.open.middletier.fc.ui.BXWVWebview.2
                @Override // com.uc.webview.export.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    iBXDownloadService.startDownload(str, str3);
                }
            });
        }
    }
}
