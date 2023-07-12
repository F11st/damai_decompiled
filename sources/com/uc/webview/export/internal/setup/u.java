package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.setup.af;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class u implements ValueCallback<l> {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar) {
        this.a = oVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        Stack stack;
        Stack stack2;
        l lVar2;
        l lVar3;
        ValueCallback valueCallback;
        ValueCallback valueCallback2;
        UCSetupException uCSetupException;
        Stack stack3;
        UCSetupException uCSetupException2;
        l b;
        Stack stack4;
        List list;
        List list2;
        l lVar4 = lVar;
        ValueCallback<UCSetupException> valueCallback3 = SDKFactory.n;
        if (valueCallback3 != null) {
            valueCallback3.onReceiveValue(lVar4.getException());
        }
        if (lVar4.getException() != null) {
            this.a.j = lVar4.getException();
            this.a.k = lVar4;
        }
        if (com.uc.webview.export.internal.utility.m.b()) {
            com.uc.webview.export.internal.utility.m.d(this.a.getContext());
        }
        Integer num = (Integer) this.a.mOptions.get(UCCore.OPTION_DELETE_CORE_POLICY);
        if (num != null && num.intValue() != 0 && (lVar4 instanceof ax) && ((lVar4.getException().errCode() == 1008 && (num.intValue() & 1) != 0) || ((lVar4.getException().errCode() == 1011 && (num.intValue() & 8) != 0) || ((lVar4.getException().errCode() == 3007 && (num.intValue() & 2) != 0) || ((lVar4.getException().errCode() == 3005 && (num.intValue() & 16) != 0) || ((lVar4.getException().errCode() == 4005 && (num.intValue() & 4) != 0) || (num.intValue() & 32) != 0)))))) {
            list = this.a.n;
            if (list == null) {
                this.a.n = new ArrayList();
            }
            list2 = this.a.n;
            list2.add((ax) lVar4);
        }
        StringBuilder sb = new StringBuilder("mExceptionCB mExceptionTasks: ");
        stack = o.d;
        sb.append(stack);
        Log.d("SdkSetupTask", sb.toString());
        stack2 = o.d;
        if (stack2.size() <= 0) {
            lVar2 = this.a.e;
            if (lVar2 != null) {
                lVar3 = this.a.e;
                valueCallback = this.a.p;
                valueCallback2 = this.a.q;
                ((l) ((l) ((l) lVar3.setParent(this.a)).onEvent("success", valueCallback)).onEvent("exception", valueCallback2)).start();
                o.f(this.a);
            } else {
                this.a.setException(lVar4.getException());
            }
        } else {
            stack3 = o.d;
            if (((UCSetupTask) stack3.pop()) == null) {
                uCSetupException2 = this.a.j;
                Log.w("SdkSetupTask", "init exception, fallback to system webview", uCSetupException2);
                b = this.a.b((l) new ba());
                b.start();
            } else {
                stack4 = o.d;
                ((UCSetupTask) stack4.pop()).start();
            }
        }
        af.a aVar = af.a.INIT_EXCEPTION;
        uCSetupException = this.a.j;
        af.a(aVar, uCSetupException);
    }
}
