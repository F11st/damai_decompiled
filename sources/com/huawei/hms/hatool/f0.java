package com.huawei.hms.hatool;

import android.taobao.windvane.util.ConfigStorage;
import com.taobao.weex.annotation.JSMethod;
import java.util.Calendar;
import java.util.UUID;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class f0 {
    public long a = ConfigStorage.DEFAULT_SMALL_MAX_AGE;
    public volatile boolean b = false;
    public a c = null;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a {
        public String a = UUID.randomUUID().toString().replace("-", "");
        public boolean b = true;
        public long c;

        public a(long j) {
            this.a += JSMethod.NOT_SET + j;
            this.c = j;
            f0.this.b = false;
        }

        public void a(long j) {
            if (f0.this.b) {
                f0.this.b = false;
                b(j);
            } else if (b(this.c, j) || a(this.c, j)) {
                b(j);
            } else {
                this.c = j;
                this.b = false;
            }
        }

        public final boolean a(long j, long j2) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j2);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        public final void b(long j) {
            y.c("hmsSdk", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.a = uuid;
            this.a = uuid.replace("-", "");
            this.a += JSMethod.NOT_SET + j;
            this.c = j;
            this.b = true;
        }

        public final boolean b(long j, long j2) {
            return j2 - j >= f0.this.a;
        }
    }

    public String a() {
        a aVar = this.c;
        if (aVar == null) {
            y.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
            return "";
        }
        return aVar.a;
    }

    public void a(long j) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(j);
            return;
        }
        y.c("hmsSdk", "Session is first flush");
        this.c = new a(j);
    }

    public boolean b() {
        a aVar = this.c;
        if (aVar == null) {
            y.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
            return false;
        }
        return aVar.b;
    }
}
