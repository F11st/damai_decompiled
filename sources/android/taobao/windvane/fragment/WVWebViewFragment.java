package android.taobao.windvane.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.WVWebChromeClient;
import android.taobao.windvane.webview.WVWebView;
import android.taobao.windvane.webview.WVWebViewClient;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVWebViewFragment extends Fragment {
    private static String TAG = WVWebViewFragment.class.getSimpleName();
    public static String URL = "url";
    private Activity activity;
    private WVWebView mWebView = null;
    private WVWebViewClient mWebclient = null;
    private WVWebChromeClient mChromeClient = null;
    private String url = null;

    @Deprecated
    public WVWebViewFragment() {
    }

    public WebView getWebView() {
        if (this.mWebView == null) {
            Context context = this.activity;
            if (context == null) {
                context = getActivity();
            }
            if (context == null) {
                return null;
            }
            this.mWebView = new WVWebView(context);
            setWebViewClient(this.mWebclient);
            setWebchormeClient(this.mChromeClient);
            this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        return this.mWebView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        WVWebView wVWebView = this.mWebView;
        if (wVWebView != null) {
            wVWebView.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    public boolean onBackPressed() {
        if (getWebView() == null || !getWebView().canGoBack()) {
            return false;
        }
        getWebView().goBack();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.url = arguments.getString(URL);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        WVWebView wVWebView;
        getWebView();
        String str = this.url;
        if (str != null && (wVWebView = this.mWebView) != null) {
            wVWebView.loadUrl(str);
        } else {
            TaoLog.d(TAG, "image urls is null");
        }
        return this.mWebView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        WVWebView wVWebView = this.mWebView;
        if (wVWebView != null) {
            wVWebView.setVisibility(8);
            this.mWebView.removeAllViews();
            if (this.mWebView.getParent() != null) {
                ((ViewGroup) this.mWebView.getParent()).removeView(this.mWebView);
            }
            this.mWebView.loadUrl("about:blank");
            this.mWebView.destroy();
            this.mWebView = null;
        }
        this.activity = null;
        try {
            super.onDestroy();
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        WVWebView wVWebView = this.mWebView;
        if (wVWebView != null) {
            wVWebView.onPause();
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        WVWebView wVWebView = this.mWebView;
        if (wVWebView != null) {
            wVWebView.onResume();
        }
        super.onResume();
    }

    public void setWebViewClient(WVWebViewClient wVWebViewClient) {
        if (wVWebViewClient != null) {
            this.mWebclient = wVWebViewClient;
            WVWebView wVWebView = this.mWebView;
            if (wVWebView != null) {
                wVWebView.setWebViewClient(wVWebViewClient);
            }
        }
    }

    public void setWebchormeClient(WVWebChromeClient wVWebChromeClient) {
        if (wVWebChromeClient != null) {
            this.mChromeClient = wVWebChromeClient;
            WVWebView wVWebView = this.mWebView;
            if (wVWebView != null) {
                wVWebView.setWebChromeClient(wVWebChromeClient);
            }
        }
    }

    public WVWebViewFragment(Activity activity) {
        this.activity = activity;
    }
}
