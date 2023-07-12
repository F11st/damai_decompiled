package com.uc.webview.export;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.uc.webview.export.annotations.Api;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class WebViewFragment extends Fragment {
    private WebView a;
    private boolean b;

    public WebView getWebView() {
        if (this.b) {
            return this.a;
        }
        return null;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        WebView webView = this.a;
        if (webView != null) {
            webView.destroy();
        }
        WebView webView2 = new WebView(getActivity());
        this.a = webView2;
        this.b = true;
        return webView2;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        WebView webView = this.a;
        if (webView != null) {
            webView.destroy();
            this.a = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.b = false;
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.a.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        this.a.onResume();
        super.onResume();
    }
}
