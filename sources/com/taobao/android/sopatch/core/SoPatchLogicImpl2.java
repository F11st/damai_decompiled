package com.taobao.android.sopatch.core;

import android.os.SystemClock;
import android.text.TextUtils;
import com.taobao.android.sopatch.download.FileDownloader;
import com.taobao.tao.log.statistics.TLogEventConst;
import java.io.File;
import java.util.List;
import tb.eu0;
import tb.fe2;
import tb.ge2;
import tb.he2;
import tb.ie2;
import tb.je2;
import tb.le2;
import tb.me2;
import tb.ob1;
import tb.oe2;
import tb.oi0;
import tb.pc1;
import tb.pe2;
import tb.qe2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SoPatchLogicImpl2 implements SoPatchLogic {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sopatch.core.SoPatchLogicImpl2$a */
    /* loaded from: classes11.dex */
    public class C6633a implements FileDownloader.Callback {
        final /* synthetic */ Runnable a;

        C6633a(SoPatchLogicImpl2 soPatchLogicImpl2, Runnable runnable) {
            this.a = runnable;
        }

        @Override // com.taobao.android.sopatch.download.FileDownloader.Callback
        public void onFail() {
        }

        @Override // com.taobao.android.sopatch.download.FileDownloader.Callback
        public void onSuccess() {
            eu0.d().c().execute(this.a);
        }
    }

    private boolean c(ge2 ge2Var) {
        return TextUtils.equals(ge2Var.a(), eu0.d().a());
    }

    private boolean d(pe2 pe2Var) {
        List<me2> b = pe2Var.b();
        if (b == null || b.size() == 0) {
            return false;
        }
        for (me2 me2Var : b) {
            if (!oe2.a(me2Var)) {
                return false;
            }
        }
        return true;
    }

    private void e(final ge2 ge2Var, final pe2 pe2Var, final long j) {
        qe2.b(pe2Var, new C6633a(this, new Runnable() { // from class: com.taobao.android.sopatch.core.SoPatchLogicImpl2.1
            @Override // java.lang.Runnable
            public void run() {
                File e = oi0.e(pe2Var);
                if (e != null && TextUtils.equals(pe2Var.c(), pc1.a(e))) {
                    SoPatchLogicImpl2.this.f(ge2Var, pe2Var, j);
                    return;
                }
                le2.a(false, ge2Var.e(), "download", SystemClock.uptimeMillis() - j, -1, pe2Var.g(), pe2Var.d());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ge2 ge2Var, pe2 pe2Var, long j) {
        pe2Var.e(qe2.d(pe2Var));
        if (d(pe2Var)) {
            le2.a(true, ge2Var.e(), "download", SystemClock.uptimeMillis() - j, 0, pe2Var.g(), pe2Var.d());
            ie2 b = he2.b(pe2Var, "remote");
            if (b.f() > 0) {
                je2.c().d(b);
                le2.a(true, ge2Var.e(), "install", 0L, 0, b.toString(), pe2Var.d());
            } else {
                le2.a(false, ge2Var.e(), "install", 0L, -1, b.toString(), pe2Var.d());
            }
            ob1.b("SoPatchLogicImpl", TLogEventConst.PARAM_UPLOAD_STAGE, "remote", "so patch ready", b.toString());
        } else {
            le2.a(false, ge2Var.e(), "download", SystemClock.uptimeMillis() - j, -1, pe2Var.g(), pe2Var.d());
        }
        fe2.a(ge2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ge2 ge2Var) {
        String str = "remote";
        if (ge2Var == null) {
            le2.a(false, "", "revupdate", 0L, -1, "格式出错", 0L);
            ob1.b("SoPatchLogicImpl", "exception", "remote", "configure == null");
        } else if (!c(ge2Var)) {
            oi0.a();
            ob1.b("SoPatchLogicImpl", "exception", "remote", "checkAppVersionValid");
        } else {
            List<pe2> b = ge2Var.b();
            if (b != null && b.size() != 0) {
                for (pe2 pe2Var : b) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    String str2 = str;
                    le2.a(true, ge2Var.e(), "revupdate", 0L, 0, pe2Var.g(), pe2Var.d());
                    if (qe2.a(pe2Var)) {
                        ob1.b("SoPatchLogicImpl", TLogEventConst.PARAM_UPLOAD_STAGE, str2, "zip file valid");
                        f(ge2Var, pe2Var, uptimeMillis);
                    } else {
                        ob1.a("SoPatchLogicImpl", "exception", str2, "zip file invalid");
                        e(ge2Var, pe2Var, uptimeMillis);
                    }
                    str = str2;
                }
                return;
            }
            le2.a(false, ge2Var.e(), "revupdate", 0L, -1, "无patch", 0L);
            ob1.b("SoPatchLogicImpl", "exception", "remote", "no zip file");
        }
    }

    private boolean h(pe2 pe2Var) {
        List<me2> b = pe2Var.b();
        return b == null || b.size() == 0;
    }

    @Override // com.taobao.android.sopatch.core.SoPatchLogic
    public void loadLocalPatch(ge2 ge2Var) {
        String str = "local";
        if (ge2Var == null) {
            le2.a(false, "", "revupdate", 0L, -1, "格式出错", 0L);
            ob1.b("SoPatchLogicImpl", "exception", "local", "configure == null");
        } else if (!c(ge2Var)) {
            oi0.a();
            ob1.b("SoPatchLogicImpl", "exception", "local", "checkAppVersionValid");
        } else {
            List<pe2> b = ge2Var.b();
            if (b != null && b.size() != 0) {
                for (pe2 pe2Var : b) {
                    String str2 = str;
                    le2.a(true, ge2Var.e(), "revupdate", 0L, 0, pe2Var.g(), pe2Var.d());
                    if (h(pe2Var)) {
                        pe2Var.e(qe2.d(pe2Var));
                    }
                    if (d(pe2Var)) {
                        le2.a(true, ge2Var.e(), "download", 0L, 0, pe2Var.g(), pe2Var.d());
                        ie2 b2 = he2.b(pe2Var, ge2Var.e());
                        if (b2.f() > 0) {
                            je2.c().d(b2);
                            le2.a(true, ge2Var.e(), "install", 0L, 0, b2.toString(), pe2Var.d());
                        } else {
                            le2.a(false, ge2Var.e(), "install", 0L, -1, b2.toString(), pe2Var.d());
                        }
                        ob1.b("SoPatchLogicImpl", TLogEventConst.PARAM_UPLOAD_STAGE, str2, "so patch ready", b2.toString());
                    } else {
                        le2.a(false, ge2Var.e(), "download", 0L, -1, pe2Var.g(), pe2Var.d());
                    }
                    str = str2;
                }
                ob1.b("SoPatchLogicImpl", "finished loadLocalPatch");
                return;
            }
            le2.a(false, ge2Var.e(), "revupdate", 0L, -1, "无patch", 0L);
            ob1.b("SoPatchLogicImpl", "exception", "local", "no zip file");
        }
    }

    @Override // com.taobao.android.sopatch.core.SoPatchLogic
    public void loadRemotePatch(final ge2 ge2Var) {
        eu0.d().c().execute(new Runnable() { // from class: com.taobao.android.sopatch.core.SoPatchLogicImpl2.3
            @Override // java.lang.Runnable
            public void run() {
                SoPatchLogicImpl2.this.g(ge2Var);
                ob1.b("SoPatchLogicImpl", "finished loadRemotePatch");
            }
        });
    }
}
