package com.alibaba.aliweex.bundle;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.alibaba.aliweex.bundle.WeexPageContract;
import com.taobao.weex.WXSDKInstance;
import tb.ev2;
import tb.fv2;
import tb.zz2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class e implements Handler.Callback, WeexPageContract.IUrlValidate {
    public static final int SHOW_TIP_VIEW = 18;
    private Activity a;
    private Handler b = new Handler(this);
    private boolean c;
    private fv2 d;

    public e(Activity activity) {
        this.a = activity;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IUrlValidate
    public void checkUrlValidate(String str) {
        if (ev2.h(str)) {
            this.c = true;
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IUrlValidate
    public Handler getHandler() {
        return this.b;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        fv2 fv2Var;
        if (message.what != 18 || (fv2Var = this.d) == null) {
            return false;
        }
        fv2Var.f(null, "检测到该网址为外部网站，外部网站打开可能存在安全隐患，请注意保护您的个人隐私", zz2.a(this.a));
        return true;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IUrlValidate
    public void onWXViewCreated(WXSDKInstance wXSDKInstance, View view) {
        if (this.d == null) {
            this.d = new fv2(wXSDKInstance.getContext(), view);
        }
        if (this.c) {
            this.b.sendEmptyMessage(18);
        }
    }
}
