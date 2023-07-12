package android.taobao.windvane.extra.uc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.taobao.windvane.util.TaoLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVUCWebViewFragment extends Fragment {
    private static String TAG = WVUCWebViewFragment.class.getSimpleName();
    public static String URL = "url";
    private Activity activity;
    protected WVUCWebView mWebView = null;
    private WVUCWebViewClient mWebclient = null;
    private WVUCWebChromeClient mChromeClient = null;
    private String url = null;

    @Deprecated
    public WVUCWebViewFragment() {
    }

    public WVUCWebView getWebView() {
        if (this.mWebView == null) {
            Context context = this.activity;
            if (context == null) {
                context = getActivity();
            }
            if (context == null) {
                return null;
            }
            this.mWebView = new WVUCWebView(context);
            setWebViewClient(this.mWebclient);
            setWebchormeClient(this.mChromeClient);
            this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        return this.mWebView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        WVUCWebView wVUCWebView = this.mWebView;
        if (wVUCWebView != null) {
            wVUCWebView.onActivityResult(i, i2, intent);
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
        WVUCWebView wVUCWebView;
        getWebView();
        String str = this.url;
        if (str != null && (wVUCWebView = this.mWebView) != null) {
            wVUCWebView.loadUrl(str);
        } else {
            TaoLog.d(TAG, "image urls is null");
        }
        return this.mWebView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        WVUCWebView wVUCWebView = this.mWebView;
        if (wVUCWebView != null) {
            wVUCWebView.setVisibility(8);
            this.mWebView.removeAllViews();
            if (this.mWebView.getParent() != null) {
                ((ViewGroup) this.mWebView.getParent()).removeView(this.mWebView);
            }
            this.mWebView.destroy();
            this.mWebView = null;
        }
        this.activity = null;
        try {
            super.onDestroy();
        } catch (Exception e) {
            TaoLog.e(TAG, e.getMessage());
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
        WVUCWebView wVUCWebView = this.mWebView;
        if (wVUCWebView != null) {
            wVUCWebView.onPause();
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        WVUCWebView wVUCWebView = this.mWebView;
        if (wVUCWebView != null) {
            wVUCWebView.onResume();
        }
        super.onResume();
    }

    public void setWebViewClient(WVUCWebViewClient wVUCWebViewClient) {
        if (wVUCWebViewClient != null) {
            this.mWebclient = wVUCWebViewClient;
            WVUCWebView wVUCWebView = this.mWebView;
            if (wVUCWebView != null) {
                wVUCWebView.setWebViewClient(wVUCWebViewClient);
            }
        }
    }

    public void setWebchormeClient(WVUCWebChromeClient wVUCWebChromeClient) {
        if (wVUCWebChromeClient != null) {
            this.mChromeClient = wVUCWebChromeClient;
            WVUCWebView wVUCWebView = this.mWebView;
            if (wVUCWebView != null) {
                wVUCWebView.setWebChromeClient(wVUCWebChromeClient);
            }
        }
    }

    public WVUCWebViewFragment(Activity activity) {
        this.activity = activity;
    }
}
