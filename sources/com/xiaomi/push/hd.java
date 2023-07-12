package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class hd implements XMPushService.n {
    private static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private int f454a;

    /* renamed from: a  reason: collision with other field name */
    private Context f455a;
    private boolean b;

    public hd(Context context) {
        this.f455a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f455a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.b = com.xiaomi.push.service.ba.a(context).a(ho.TinyDataUploadSwitch.a(), true);
        int a2 = com.xiaomi.push.service.ba.a(context).a(ho.TinyDataUploadFrequency.a(), 7200);
        this.f454a = a2;
        this.f454a = Math.max(60, a2);
    }

    public static void a(boolean z) {
        a = z;
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f455a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f454a);
    }

    private boolean a(hh hhVar) {
        if (!bj.b(this.f455a) || hhVar == null || TextUtils.isEmpty(a(this.f455a.getPackageName())) || !new File(this.f455a.getFilesDir(), "tiny_data.data").exists() || a) {
            return false;
        }
        return !com.xiaomi.push.service.ba.a(this.f455a).a(ho.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || j.m1093a(this.f455a) || j.m1095b(this.f455a);
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a  reason: collision with other method in class */
    public void mo951a() {
        hh a2 = hg.a(this.f455a).a();
        if (hi.a(this.f455a) && a2 != null) {
            hf.a(this.f455a, a2, com.xiaomi.push.service.ca.f956a);
            com.xiaomi.push.service.ca.a();
            com.xiaomi.channel.commonutils.logger.b.c("coord data upload");
        }
        a(this.f455a);
        if (this.b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m586a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            if (a(a2)) {
                a = true;
                he.a(this.f455a, a2);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m586a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
        }
    }
}
