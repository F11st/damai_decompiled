package com.tencent.open.log;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.text.SimpleDateFormat;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.log.d */
/* loaded from: classes11.dex */
public class C7102d {

    /* compiled from: Taobao */
    /* renamed from: com.tencent.open.log.d$a */
    /* loaded from: classes11.dex */
    public static final class C7103a {
        public static final boolean a(int i, int i2) {
            return i2 == (i & i2);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.tencent.open.log.d$b */
    /* loaded from: classes11.dex */
    public static final class C7104b {
        public static boolean a() {
            String externalStorageState = Environment.getExternalStorageState();
            return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
        }

        public static C7105c b() {
            if (a()) {
                return C7105c.b(Environment.getExternalStorageDirectory());
            }
            return null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.tencent.open.log.d$c */
    /* loaded from: classes11.dex */
    public static class C7105c {
        private File a;
        private long b;
        private long c;

        public File a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }

        public long c() {
            return this.c;
        }

        public String toString() {
            return String.format("[%s : %d / %d]", a().getAbsolutePath(), Long.valueOf(c()), Long.valueOf(b()));
        }

        public void a(File file) {
            this.a = file;
        }

        public void b(long j) {
            this.c = j;
        }

        public static C7105c b(File file) {
            StatFs statFs;
            C7105c c7105c = new C7105c();
            c7105c.a(file);
            long blockSize = new StatFs(file.getAbsolutePath()).getBlockSize();
            c7105c.a(statFs.getBlockCount() * blockSize);
            c7105c.b(statFs.getAvailableBlocks() * blockSize);
            return c7105c;
        }

        public void a(long j) {
            this.b = j;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.tencent.open.log.d$d */
    /* loaded from: classes11.dex */
    public static final class C7106d {
        @SuppressLint({"SimpleDateFormat"})
        public static SimpleDateFormat a(String str) {
            return new SimpleDateFormat(str);
        }
    }

    public static boolean a(String str) {
        return str.contains(Constants.PARAM_ACCESS_TOKEN) || str.contains("pay_token") || str.contains("pfkey") || str.contains(Constants.PARAM_EXPIRES_IN) || str.contains("openid") || str.contains("proxy_code") || str.contains("proxy_expires_in");
    }

    public static Bundle b(Bundle bundle) {
        if (a(bundle)) {
            Bundle bundle2 = new Bundle(bundle);
            bundle2.remove(Constants.PARAM_ACCESS_TOKEN);
            bundle2.remove("pay_token");
            bundle2.remove("pfkey");
            bundle2.remove(Constants.PARAM_EXPIRES_IN);
            bundle2.remove("openid");
            bundle2.remove("proxy_code");
            bundle2.remove("proxy_expires_in");
            return bundle2;
        }
        return bundle;
    }

    public static boolean a(Bundle bundle) {
        return bundle.containsKey(Constants.PARAM_ACCESS_TOKEN) || bundle.containsKey("pay_token") || bundle.containsKey("pfkey") || bundle.containsKey(Constants.PARAM_EXPIRES_IN) || bundle.containsKey("openid") || bundle.containsKey("proxy_code") || bundle.containsKey("proxy_expires_in");
    }
}
