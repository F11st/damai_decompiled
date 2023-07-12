package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.webkit.ValueCallback;
import com.alibaba.security.biometrics.service.common.ABDefaultConfig;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.ae;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class bb extends ax {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a extends bu {
        final ValueCallback<Object> a;

        public a(UCSubSetupTask uCSubSetupTask, bt btVar) {
            super(uCSubSetupTask, btVar);
            this.a = new bc(this);
        }

        @Override // com.uc.webview.export.internal.setup.bu
        protected final boolean a() {
            com.uc.webview.export.internal.uc.startup.b.a(298);
            Context context = (Context) this.f.getOption("CONTEXT");
            boolean z = !com.uc.webview.export.internal.utility.p.b((Boolean) bb.this.mOptions.get(UCCore.OPTION_USE_SDK_SETUP));
            if (z) {
                int i = ae.d.b;
                ae.b bVar = ae.b.CHECK_VERSION;
                ae a = ae.a();
                a.getClass();
                a(i, bVar, new ae.a(new bd(this, context), this.a), this.a);
            }
            int i2 = ae.d.b;
            ae.b bVar2 = ae.b.CHECK_OLD_KERNEL;
            ae a2 = ae.a();
            a2.getClass();
            a(i2, bVar2, new ae.a(new be(this, context, z), this.a), this.a);
            com.uc.webview.export.internal.uc.startup.b.a(299);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.uc.webview.export.internal.setup.bu
        public final void b() {
            com.uc.webview.export.internal.uc.startup.b.a(300);
            Context context = (Context) this.f.getOption("CONTEXT");
            Integer num = (Integer) this.f.getOption(UCCore.OPTION_VERIFY_POLICY);
            com.uc.webview.export.internal.uc.startup.b.a(302);
            com.uc.webview.export.internal.uc.startup.b.a(303);
            if (num != null && (num.intValue() & 8) != 0) {
                int i = ae.d.b;
                ae.b bVar = ae.b.CHECK_SO;
                ae a = ae.a();
                a.getClass();
                a(i, bVar, new ae.a(new bf(this, context, num), this.a), this.a);
            }
            com.uc.webview.export.internal.uc.startup.b.a(304);
            if (num != null && (num.intValue() & 32) != 0) {
                int i2 = ae.d.b;
                ae.b bVar2 = ae.b.CHECK_PAK;
                ae a2 = ae.a();
                a2.getClass();
                a(i2, bVar2, new ae.a(new bg(this, context, num), this.a), this.a);
            }
            com.uc.webview.export.internal.uc.startup.b.a(301);
        }
    }

    @Override // com.uc.webview.export.internal.setup.ax
    protected final bu a(bt btVar) {
        return new a(this, btVar);
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask, java.lang.Runnable
    public final void run() {
        com.uc.webview.export.internal.uc.startup.b.a(279);
        if (af.b() && getUCM() != null) {
            b(getUCM());
        } else {
            a(com.uc.webview.export.internal.utility.p.a((Context) this.mOptions.get("CONTEXT"), this.mOptions));
        }
        com.uc.webview.export.internal.uc.startup.b.a(ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE);
    }

    @Override // com.uc.webview.export.internal.setup.ax
    protected final void a(String str, Object obj) {
        if (com.uc.webview.export.internal.utility.p.a(str) || obj == null) {
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
