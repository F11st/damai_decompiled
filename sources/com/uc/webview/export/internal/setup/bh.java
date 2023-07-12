package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.C7257ae;
import com.uc.webview.export.internal.uc.startup.C7302b;
import com.uc.webview.export.internal.utility.C7349p;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bh extends ax {
    @Override // com.uc.webview.export.internal.setup.ax
    protected final bu a(bt btVar) {
        return new C7270a(this, btVar);
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask, java.lang.Runnable
    public void run() {
        C7302b.a(281);
        if (af.b() && getUCM() != null) {
            b(getUCM());
        } else {
            a(C7349p.b((Context) this.mOptions.get("CONTEXT"), this.mOptions));
        }
        C7302b.a(282);
    }

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.setup.bh$a */
    /* loaded from: classes11.dex */
    class C7270a extends bu {
        int a;
        boolean b;
        final ValueCallback<Object> c;

        public C7270a(UCSubSetupTask uCSubSetupTask, bt btVar) {
            super(uCSubSetupTask, btVar);
            this.a = 0;
            this.c = new bi(this);
            Integer num = (Integer) this.f.getOption(UCCore.OPTION_VERIFY_POLICY);
            if (num != null) {
                this.a = num.intValue();
            }
            this.b = !C7349p.b((Boolean) this.f.getOption(UCCore.OPTION_USE_SDK_SETUP));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void c(C7270a c7270a) {
            int i = C7257ae.C7261d.b;
            if ((c7270a.a & 32) != 0) {
                int i2 = C7257ae.C7261d.b;
                C7257ae.EnumC7259b enumC7259b = C7257ae.EnumC7259b.CHECK_PAK;
                C7257ae a = C7257ae.a();
                a.getClass();
                c7270a.a(i2, enumC7259b, new C7257ae.CallableC7258a(new bp(c7270a), c7270a.c), c7270a.c);
            }
        }

        @Override // com.uc.webview.export.internal.setup.bu
        protected final boolean a() {
            C7302b.a(298);
            this.f.getOption("CONTEXT");
            this.f.getOption(UCCore.OPTION_VERIFY_POLICY);
            if ((this.a & 4) != 0) {
                int i = C7257ae.C7261d.b;
                C7257ae.EnumC7259b enumC7259b = C7257ae.EnumC7259b.VERIFY_CORE_JAR;
                C7257ae a = C7257ae.a();
                a.getClass();
                a(i, enumC7259b, new C7257ae.CallableC7258a(new bj(this), this.c), this.c);
                C7302b.a(299);
                return true;
            }
            C7302b.a(299);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.uc.webview.export.internal.setup.bu
        public final void b() {
            C7302b.a(300);
            C7302b.a(302);
            int i = C7257ae.C7261d.b;
            C7257ae.EnumC7259b enumC7259b = C7257ae.EnumC7259b.CHECK_OLD_KERNEL;
            C7257ae a = C7257ae.a();
            a.getClass();
            a(i, enumC7259b, new C7257ae.CallableC7258a(new bk(this), this.c), this.c);
            C7302b.a(303);
            if ((this.a & 1) != 0) {
                int i2 = C7257ae.C7261d.b;
                C7257ae.EnumC7259b enumC7259b2 = C7257ae.EnumC7259b.VERIFY_SDK_SHELL;
                C7257ae a2 = C7257ae.a();
                a2.getClass();
                a(i2, enumC7259b2, new C7257ae.CallableC7258a(new bl(this), this.c), this.c);
            }
            C7302b.a(304);
            int i3 = C7257ae.C7261d.b;
            C7257ae.EnumC7259b enumC7259b3 = C7257ae.EnumC7259b.LOAD_SDK_SHELL;
            C7257ae a3 = C7257ae.a();
            a3.getClass();
            a(i3, enumC7259b3, new C7257ae.CallableC7258a(new CallableC7271bm(this), this.c), this.c);
            C7302b.a(301);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(C7270a c7270a) {
            if (!C7349p.b((Boolean) c7270a.f.getOption(UCCore.OPTION_USE_SDK_SETUP))) {
                int i = C7257ae.C7261d.b;
                int i2 = C7257ae.C7261d.b;
                C7257ae.EnumC7259b enumC7259b = C7257ae.EnumC7259b.CHECK_VERSION;
                C7257ae a = C7257ae.a();
                a.getClass();
                c7270a.a(i2, enumC7259b, new C7257ae.CallableC7258a(new bn(c7270a), c7270a.c), c7270a.c);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void b(C7270a c7270a) {
            int i = C7257ae.C7261d.b;
            if ((c7270a.a & 8) != 0) {
                int i2 = C7257ae.C7261d.b;
                C7257ae.EnumC7259b enumC7259b = C7257ae.EnumC7259b.CHECK_SO;
                C7257ae a = C7257ae.a();
                a.getClass();
                c7270a.a(i2, enumC7259b, new C7257ae.CallableC7258a(new bo(c7270a), c7270a.c), c7270a.c);
            }
        }
    }
}
