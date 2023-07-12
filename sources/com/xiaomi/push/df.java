package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.accs.common.Constants;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.ao;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class df {
    private static volatile df a;

    /* renamed from: a  reason: collision with other field name */
    private Context f198a;

    /* renamed from: a  reason: collision with other field name */
    private final ConcurrentLinkedQueue<C7630b> f199a;

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.df$a */
    /* loaded from: classes11.dex */
    class C7629a extends C7630b {
        C7629a() {
            super();
        }

        @Override // com.xiaomi.push.df.C7630b, com.xiaomi.push.ao.AbstractC7600b
        public void b() {
            df.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.df$b */
    /* loaded from: classes11.dex */
    public class C7630b extends ao.AbstractC7600b {
        long a = System.currentTimeMillis();

        /* JADX INFO: Access modifiers changed from: package-private */
        public C7630b() {
        }

        public boolean a() {
            return true;
        }

        @Override // com.xiaomi.push.ao.AbstractC7600b
        public void b() {
        }

        /* renamed from: b  reason: collision with other method in class */
        final boolean m764b() {
            return System.currentTimeMillis() - this.a > 172800000;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.df$c */
    /* loaded from: classes11.dex */
    class C7631c extends C7630b {
        int a;

        /* renamed from: a  reason: collision with other field name */
        File f201a;

        /* renamed from: a  reason: collision with other field name */
        String f202a;

        /* renamed from: a  reason: collision with other field name */
        boolean f203a;
        String b;

        /* renamed from: b  reason: collision with other field name */
        boolean f204b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C7631c(String str, String str2, File file, boolean z) {
            super();
            this.f202a = str;
            this.b = str2;
            this.f201a = file;
            this.f204b = z;
        }

        private boolean c() {
            int i;
            int i2 = 0;
            SharedPreferences sharedPreferences = df.this.f198a.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong("time");
                i = jSONObject.getInt(Constants.KEY_TIMES);
            } catch (JSONException unused) {
                i = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= 86400000) {
                currentTimeMillis = System.currentTimeMillis();
            } else if (i > 10) {
                return false;
            } else {
                i2 = i;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put(Constants.KEY_TIMES, i2 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e) {
                AbstractC7535b.c("JSONException on put " + e.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.df.C7630b
        public boolean a() {
            return bj.e(df.this.f198a) || (this.f204b && bj.b(df.this.f198a));
        }

        @Override // com.xiaomi.push.df.C7630b, com.xiaomi.push.ao.AbstractC7600b
        public void b() {
            try {
                if (c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", com.xiaomi.push.service.bv.m1206a());
                    hashMap.put("token", this.b);
                    hashMap.put("net", bj.m693a(df.this.f198a));
                    bj.a(this.f202a, hashMap, this.f201a, "file");
                }
                this.f203a = true;
            } catch (IOException unused) {
            }
        }

        @Override // com.xiaomi.push.ao.AbstractC7600b
        /* renamed from: c  reason: collision with other method in class */
        public void mo765c() {
            if (!this.f203a) {
                int i = this.a + 1;
                this.a = i;
                if (i < 3) {
                    df.this.f199a.add(this);
                }
            }
            if (this.f203a || this.a >= 3) {
                this.f201a.delete();
            }
            df.this.a((1 << this.a) * 1000);
        }
    }

    private df(Context context) {
        ConcurrentLinkedQueue<C7630b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f199a = concurrentLinkedQueue;
        this.f198a = context;
        concurrentLinkedQueue.add(new C7629a());
        b(0L);
    }

    public static df a(Context context) {
        if (a == null) {
            synchronized (df.class) {
                if (a == null) {
                    a = new df(context);
                }
            }
        }
        a.f198a = context;
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        C7630b peek = this.f199a.peek();
        if (peek == null || !peek.a()) {
            return;
        }
        b(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (C7595ad.b() || C7595ad.m660a()) {
            return;
        }
        try {
            File file = new File(this.f198a.getExternalFilesDir(null) + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    private void b(long j) {
        if (this.f199a.isEmpty()) {
            return;
        }
        gz.a(new dh(this), j);
    }

    private void c() {
        while (!this.f199a.isEmpty()) {
            C7630b peek = this.f199a.peek();
            if (peek != null) {
                if (!peek.m764b() && this.f199a.size() <= 6) {
                    return;
                }
                AbstractC7535b.c("remove Expired task");
                this.f199a.remove(peek);
            }
        }
    }

    public void a() {
        c();
        a(0L);
    }

    public void a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.f199a.add(new dg(this, i, date, date2, str, str2, z));
        b(0L);
    }
}
