package com.huawei.hms.hatool;

import android.taobao.windvane.util.ConfigStorage;
import com.taobao.weex.annotation.JSMethod;
import java.util.Calendar;
import java.util.UUID;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.f0 */
/* loaded from: classes10.dex */
public class C5618f0 {
    public long a = ConfigStorage.DEFAULT_SMALL_MAX_AGE;
    public volatile boolean b = false;
    public C5619a c = null;

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.hatool.f0$a */
    /* loaded from: classes10.dex */
    public class C5619a {
        public String a = UUID.randomUUID().toString().replace("-", "");
        public boolean b = true;
        public long c;

        public C5619a(long j) {
            this.a += JSMethod.NOT_SET + j;
            this.c = j;
            C5618f0.this.b = false;
        }

        public void a(long j) {
            if (C5618f0.this.b) {
                C5618f0.this.b = false;
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
            C5653y.c("hmsSdk", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.a = uuid;
            this.a = uuid.replace("-", "");
            this.a += JSMethod.NOT_SET + j;
            this.c = j;
            this.b = true;
        }

        public final boolean b(long j, long j2) {
            return j2 - j >= C5618f0.this.a;
        }
    }

    public String a() {
        C5619a c5619a = this.c;
        if (c5619a == null) {
            C5653y.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
            return "";
        }
        return c5619a.a;
    }

    public void a(long j) {
        C5619a c5619a = this.c;
        if (c5619a != null) {
            c5619a.a(j);
            return;
        }
        C5653y.c("hmsSdk", "Session is first flush");
        this.c = new C5619a(j);
    }

    public boolean b() {
        C5619a c5619a = this.c;
        if (c5619a == null) {
            C5653y.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
            return false;
        }
        return c5619a.b;
    }
}
