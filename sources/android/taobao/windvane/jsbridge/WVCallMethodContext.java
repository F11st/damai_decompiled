package android.taobao.windvane.jsbridge;

import android.taobao.windvane.webview.IWVWebView;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVCallMethodContext {
    public Object classinstance;
    public IJsApiFailedCallBack failedCallBack;
    public Method method;
    public String methodName;
    public String objectName;
    public String params;
    public IJsApiSucceedCallBack succeedCallBack;
    public String token;
    public IWVWebView webview;
}
