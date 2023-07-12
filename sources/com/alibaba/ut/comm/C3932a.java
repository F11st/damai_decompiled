package com.alibaba.ut.comm;

import android.app.Activity;
import com.alibaba.ut.IWebView;
import com.alibaba.ut.comm.ActivityLifecycleCB;
import java.util.HashMap;
import tb.ly2;
import tb.mb1;

/* compiled from: Taobao */
/* renamed from: com.alibaba.ut.comm.a */
/* loaded from: classes8.dex */
public class C3932a implements ActivityLifecycleCB.ActivityResumedCallBack {
    public static C3932a b = new C3932a();
    private HashMap<String, Boolean> a = new HashMap<>();

    public static C3932a a() {
        return b;
    }

    public void b() {
        ActivityLifecycleCB.d().c(this);
    }

    @Override // com.alibaba.ut.comm.ActivityLifecycleCB.ActivityResumedCallBack
    public void onActivityResumed(Activity activity) {
        IWebView a = ly2.a(activity);
        if (!this.a.containsKey(Integer.valueOf(activity.hashCode()))) {
            if (a != null) {
                a.addJavascriptInterface(new JsBridge(a), "UT4Aplus");
                mb1.h("hook success:", a);
            } else {
                mb1.e("TAG", "cannot found webview");
            }
        }
        HashMap<String, Boolean> hashMap = this.a;
        hashMap.put(activity.hashCode() + "", Boolean.TRUE);
    }
}
