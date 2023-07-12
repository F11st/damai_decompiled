package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.ae;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bh extends ax {
    @Override // com.uc.webview.export.internal.setup.ax
    protected final bu a(bt btVar) {
        return new a(this, btVar);
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask, java.lang.Runnable
    public void run() {
        com.uc.webview.export.internal.uc.startup.b.a(281);
        if (af.b() && getUCM() != null) {
            b(getUCM());
        } else {
            a(com.uc.webview.export.internal.utility.p.b((Context) this.mOptions.get("CONTEXT"), this.mOptions));
        }
        com.uc.webview.export.internal.uc.startup.b.a(282);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a extends bu {
        int a;
        boolean b;
        final ValueCallback<Object> c;

        public a(UCSubSetupTask uCSubSetupTask, bt btVar) {
            super(uCSubSetupTask, btVar);
            this.a = 0;
            this.c = new bi(this);
            Integer num = (Integer) this.f.getOption(UCCore.OPTION_VERIFY_POLICY);
            if (num != null) {
                this.a = num.intValue();
            }
            this.b = !com.uc.webview.export.internal.utility.p.b((Boolean) this.f.getOption(UCCore.OPTION_USE_SDK_SETUP));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void c(a aVar) {
            int i = ae.d.b;
            if ((aVar.a & 32) != 0) {
                int i2 = ae.d.b;
                ae.b bVar = ae.b.CHECK_PAK;
                ae a = ae.a();
                a.getClass();
                aVar.a(i2, bVar, new ae.a(new bp(aVar), aVar.c), aVar.c);
            }
        }

        @Override // com.uc.webview.export.internal.setup.bu
        protected final boolean a() {
            com.uc.webview.export.internal.uc.startup.b.a(298);
            this.f.getOption("CONTEXT");
            this.f.getOption(UCCore.OPTION_VERIFY_POLICY);
            if ((this.a & 4) != 0) {
                int i = ae.d.b;
                ae.b bVar = ae.b.VERIFY_CORE_JAR;
                ae a = ae.a();
                a.getClass();
                a(i, bVar, new ae.a(new bj(this), this.c), this.c);
                com.uc.webview.export.internal.uc.startup.b.a(299);
                return true;
            }
            com.uc.webview.export.internal.uc.startup.b.a(299);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.uc.webview.export.internal.setup.bu
        public final void b() {
            com.uc.webview.export.internal.uc.startup.b.a(300);
            com.uc.webview.export.internal.uc.startup.b.a(302);
            int i = ae.d.b;
            ae.b bVar = ae.b.CHECK_OLD_KERNEL;
            ae a = ae.a();
            a.getClass();
            a(i, bVar, new ae.a(new bk(this), this.c), this.c);
            com.uc.webview.export.internal.uc.startup.b.a(303);
            if ((this.a & 1) != 0) {
                int i2 = ae.d.b;
                ae.b bVar2 = ae.b.VERIFY_SDK_SHELL;
                ae a2 = ae.a();
                a2.getClass();
                a(i2, bVar2, new ae.a(new bl(this), this.c), this.c);
            }
            com.uc.webview.export.internal.uc.startup.b.a(304);
            int i3 = ae.d.b;
            ae.b bVar3 = ae.b.LOAD_SDK_SHELL;
            ae a3 = ae.a();
            a3.getClass();
            a(i3, bVar3, new ae.a(new bm(this), this.c), this.c);
            com.uc.webview.export.internal.uc.startup.b.a(301);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(a aVar) {
            if (!com.uc.webview.export.internal.utility.p.b((Boolean) aVar.f.getOption(UCCore.OPTION_USE_SDK_SETUP))) {
                int i = ae.d.b;
                int i2 = ae.d.b;
                ae.b bVar = ae.b.CHECK_VERSION;
                ae a = ae.a();
                a.getClass();
                aVar.a(i2, bVar, new ae.a(new bn(aVar), aVar.c), aVar.c);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void b(a aVar) {
            int i = ae.d.b;
            if ((aVar.a & 8) != 0) {
                int i2 = ae.d.b;
                ae.b bVar = ae.b.CHECK_SO;
                ae a = ae.a();
                a.getClass();
                aVar.a(i2, bVar, new ae.a(new bo(aVar), aVar.c), aVar.c);
            }
        }
    }
}
