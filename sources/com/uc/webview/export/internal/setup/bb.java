package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.webkit.ValueCallback;
import com.alibaba.security.biometrics.service.common.ABDefaultConfig;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.C7257ae;
import com.uc.webview.export.internal.uc.startup.C7302b;
import com.uc.webview.export.internal.utility.C7349p;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class bb extends ax {

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.setup.bb$a */
    /* loaded from: classes11.dex */
    class C7269a extends bu {
        final ValueCallback<Object> a;

        public C7269a(UCSubSetupTask uCSubSetupTask, bt btVar) {
            super(uCSubSetupTask, btVar);
            this.a = new bc(this);
        }

        @Override // com.uc.webview.export.internal.setup.bu
        protected final boolean a() {
            C7302b.a(298);
            Context context = (Context) this.f.getOption("CONTEXT");
            boolean z = !C7349p.b((Boolean) bb.this.mOptions.get(UCCore.OPTION_USE_SDK_SETUP));
            if (z) {
                int i = C7257ae.C7261d.b;
                C7257ae.EnumC7259b enumC7259b = C7257ae.EnumC7259b.CHECK_VERSION;
                C7257ae a = C7257ae.a();
                a.getClass();
                a(i, enumC7259b, new C7257ae.CallableC7258a(new bd(this, context), this.a), this.a);
            }
            int i2 = C7257ae.C7261d.b;
            C7257ae.EnumC7259b enumC7259b2 = C7257ae.EnumC7259b.CHECK_OLD_KERNEL;
            C7257ae a2 = C7257ae.a();
            a2.getClass();
            a(i2, enumC7259b2, new C7257ae.CallableC7258a(new be(this, context, z), this.a), this.a);
            C7302b.a(299);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.uc.webview.export.internal.setup.bu
        public final void b() {
            C7302b.a(300);
            Context context = (Context) this.f.getOption("CONTEXT");
            Integer num = (Integer) this.f.getOption(UCCore.OPTION_VERIFY_POLICY);
            C7302b.a(302);
            C7302b.a(303);
            if (num != null && (num.intValue() & 8) != 0) {
                int i = C7257ae.C7261d.b;
                C7257ae.EnumC7259b enumC7259b = C7257ae.EnumC7259b.CHECK_SO;
                C7257ae a = C7257ae.a();
                a.getClass();
                a(i, enumC7259b, new C7257ae.CallableC7258a(new bf(this, context, num), this.a), this.a);
            }
            C7302b.a(304);
            if (num != null && (num.intValue() & 32) != 0) {
                int i2 = C7257ae.C7261d.b;
                C7257ae.EnumC7259b enumC7259b2 = C7257ae.EnumC7259b.CHECK_PAK;
                C7257ae a2 = C7257ae.a();
                a2.getClass();
                a(i2, enumC7259b2, new C7257ae.CallableC7258a(new bg(this, context, num), this.a), this.a);
            }
            C7302b.a(301);
        }
    }

    @Override // com.uc.webview.export.internal.setup.ax
    protected final bu a(bt btVar) {
        return new C7269a(this, btVar);
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask, java.lang.Runnable
    public final void run() {
        C7302b.a(279);
        if (af.b() && getUCM() != null) {
            b(getUCM());
        } else {
            a(C7349p.a((Context) this.mOptions.get("CONTEXT"), this.mOptions));
        }
        C7302b.a(ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE);
    }

    @Override // com.uc.webview.export.internal.setup.ax
    protected final void a(String str, Object obj) {
        if (C7349p.a(str) || obj == null) {
            return;
        }
        try {
            if (((Boolean) ((UCCore.Callable) obj).call(str)).booleanValue()) {
                return;
            }
            throw new UCSetupException(4031, "inject failed.");
        } catch (Exception e) {
            throw new UCSetupException(4031, e);
        }
    }
}
