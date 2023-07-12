package android.taobao.windvane.jsbridge;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.taobao.windvane.extra.performance2.IPerformance;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVWebView;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class WVApiPlugin {
    public static final int REQUEST_MULTI_PICK_PHOTO = 4003;
    public static final int REQUEST_PICK_PHONE = 4003;
    public static final int REQUEST_PICK_PHOTO = 4002;
    public static final int REQUEST_TAKE_PHOTO = 4001;
    protected boolean isAlive = true;
    protected Context mContext;
    protected IWVWebView mWebView;
    protected Object paramObj;
    protected IPerformance performance;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean execute(String str, String str2, WVCallBackContext wVCallBackContext);

    public boolean executeSafe(String str, String str2, WVCallBackContext wVCallBackContext) {
        try {
            return execute(str, str2, wVCallBackContext);
        } catch (Throwable th) {
            TaoLog.e("WVJsBridge", th.getMessage());
            return false;
        }
    }

    public Context getContext() {
        Context context = this.mContext;
        return context instanceof MutableContextWrapper ? ((MutableContextWrapper) context).getBaseContext() : context;
    }

    public void initialize(Context context, IWVWebView iWVWebView) {
        this.mContext = context;
        this.mWebView = iWVWebView;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onDestroy() {
        this.isAlive = false;
    }

    public void onPause() {
        this.isAlive = false;
    }

    public void onResume() {
        this.isAlive = true;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    @Deprecated
    public void initialize(Context context, WVWebView wVWebView) {
        initialize(context, wVWebView, null);
    }

    @Deprecated
    public void initialize(Context context, IWVWebView iWVWebView, Object obj) {
        initialize(context, iWVWebView);
    }

    public void initialize(Context context, IWVWebView iWVWebView, Object obj, String str) {
        initialize(context, iWVWebView, obj);
    }

    public void initialize(Context context, IPerformance iPerformance, IWVWebView iWVWebView, Object obj, String str) {
        this.paramObj = obj;
        this.performance = iPerformance;
        initialize(context, iWVWebView, obj, str);
    }
}
