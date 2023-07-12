package com.efs.sdk.base;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.efs.sdk.base.a.c.a.C4783c;
import com.efs.sdk.base.a.d.C4786a;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.f33;
import tb.w63;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class EfsReporter {
    private static C4786a a;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class Builder {
        private static Map<String, EfsReporter> b = new ConcurrentHashMap();
        private static boolean c = true;
        private f33 a;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public interface IPublicParams {
            Map<String, String> getRecordHeaders();
        }

        public Builder(@NonNull Context context, @NonNull String str, @NonNull String str2) {
            Context b2 = b(context);
            if (TextUtils.isEmpty(str)) {
                throw new RuntimeException("EfsReporter init, appid is empty");
            }
            if (TextUtils.isEmpty(str2)) {
                throw new RuntimeException("EfsReporter init, secret is empty");
            }
            f33 f33Var = new f33();
            this.a = f33Var;
            f33Var.c = b2;
            f33Var.a = str;
            f33Var.b = str2;
        }

        private static Context b(Context context) {
            if (context == null) {
                w63.c(Constants.TAG, "context can not be null!", null);
                throw null;
            } else if (!c || (context instanceof Application) || ((context = context.getApplicationContext()) != null && (context instanceof Application))) {
                return context;
            } else {
                w63.c(Constants.TAG, "Can not get Application context from given context!", null);
                throw new IllegalArgumentException("Can not get Application context from given context!");
            }
        }

        private void c(String str) {
            f33 c2 = b.get(str).c();
            if (!c2.c.equals(e().c)) {
                throw new RuntimeException("efs-core: duplicate init, but application context is different");
            } else if (!TextUtils.isEmpty(c2.b) && !c2.b.equals(e().b)) {
                throw new RuntimeException("efs-core: duplicate init, but secret is different");
            } else if (c2.j != e().j) {
                throw new RuntimeException("efs-core: duplicate init, but intl setting is different");
            } else {
                if (!TextUtils.isEmpty(e().i) && !e().i.equals(c2.i)) {
                    w63.b("efs.reporter.builder", "efs-core: duplicate init, but  uid is different", null);
                }
                if (e().b() == null || e().b().size() <= 0) {
                    return;
                }
                c2.c(e().b());
            }
        }

        public EfsReporter a() {
            String str = e().a;
            if (!b.containsKey(str)) {
                synchronized (EfsReporter.class) {
                    if (!b.containsKey(str)) {
                        EfsReporter efsReporter = new EfsReporter(this);
                        b.put(str, efsReporter);
                        return efsReporter;
                    }
                }
            }
            w63.b("efs.reporter.builder", "efs-core: duplicate init", null);
            c(str);
            return b.get(str);
        }

        public Builder d(boolean z) {
            this.a.f = z;
            return this;
        }

        public f33 e() {
            return this.a;
        }

        public Builder f(boolean z) {
            this.a.j = z;
            return this;
        }

        public Builder g(boolean z) {
            this.a.h = z;
            return this;
        }

        public Builder h(String str) {
            this.a.i = str;
            return this;
        }
    }

    private EfsReporter(Builder builder) {
        a = new C4786a(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public f33 c() {
        return C4786a.a();
    }

    public Map<String, Object> b() {
        return new HashMap(C4783c.a().e.f);
    }

    public void d(ILogProtocol iLogProtocol) {
        a.b(iLogProtocol);
    }
}
