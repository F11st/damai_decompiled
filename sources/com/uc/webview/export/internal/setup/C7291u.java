package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.setup.af;
import com.uc.webview.export.internal.utility.C7343m;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.u */
/* loaded from: classes11.dex */
public final class C7291u implements ValueCallback<AbstractC7282l> {
    final /* synthetic */ C7285o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7291u(C7285o c7285o) {
        this.a = c7285o;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        Stack stack;
        Stack stack2;
        AbstractC7282l abstractC7282l2;
        AbstractC7282l abstractC7282l3;
        ValueCallback valueCallback;
        ValueCallback valueCallback2;
        UCSetupException uCSetupException;
        Stack stack3;
        UCSetupException uCSetupException2;
        AbstractC7282l b;
        Stack stack4;
        List list;
        List list2;
        AbstractC7282l abstractC7282l4 = abstractC7282l;
        ValueCallback<UCSetupException> valueCallback3 = SDKFactory.n;
        if (valueCallback3 != null) {
            valueCallback3.onReceiveValue(abstractC7282l4.getException());
        }
        if (abstractC7282l4.getException() != null) {
            this.a.j = abstractC7282l4.getException();
            this.a.k = abstractC7282l4;
        }
        if (C7343m.b()) {
            C7343m.d(this.a.getContext());
        }
        Integer num = (Integer) this.a.mOptions.get(UCCore.OPTION_DELETE_CORE_POLICY);
        if (num != null && num.intValue() != 0 && (abstractC7282l4 instanceof ax) && ((abstractC7282l4.getException().errCode() == 1008 && (num.intValue() & 1) != 0) || ((abstractC7282l4.getException().errCode() == 1011 && (num.intValue() & 8) != 0) || ((abstractC7282l4.getException().errCode() == 3007 && (num.intValue() & 2) != 0) || ((abstractC7282l4.getException().errCode() == 3005 && (num.intValue() & 16) != 0) || ((abstractC7282l4.getException().errCode() == 4005 && (num.intValue() & 4) != 0) || (num.intValue() & 32) != 0)))))) {
            list = this.a.n;
            if (list == null) {
                this.a.n = new ArrayList();
            }
            list2 = this.a.n;
            list2.add((ax) abstractC7282l4);
        }
        StringBuilder sb = new StringBuilder("mExceptionCB mExceptionTasks: ");
        stack = C7285o.d;
        sb.append(stack);
        Log.d("SdkSetupTask", sb.toString());
        stack2 = C7285o.d;
        if (stack2.size() <= 0) {
            abstractC7282l2 = this.a.e;
            if (abstractC7282l2 != null) {
                abstractC7282l3 = this.a.e;
                valueCallback = this.a.p;
                valueCallback2 = this.a.q;
                ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) abstractC7282l3.setParent(this.a)).onEvent("success", valueCallback)).onEvent("exception", valueCallback2)).start();
                C7285o.f(this.a);
            } else {
                this.a.setException(abstractC7282l4.getException());
            }
        } else {
            stack3 = C7285o.d;
            if (((UCSetupTask) stack3.pop()) == null) {
                uCSetupException2 = this.a.j;
                Log.w("SdkSetupTask", "init exception, fallback to system webview", uCSetupException2);
                b = this.a.b((AbstractC7282l) new ba());
                b.start();
            } else {
                stack4 = C7285o.d;
                ((UCSetupTask) stack4.pop()).start();
            }
        }
        af.EnumC7264a enumC7264a = af.EnumC7264a.INIT_EXCEPTION;
        uCSetupException = this.a.j;
        af.a(enumC7264a, uCSetupException);
    }
}
