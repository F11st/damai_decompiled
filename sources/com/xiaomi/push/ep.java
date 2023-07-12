package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ep extends es {
    private int a;
    private Bitmap b;
    private Bitmap c;

    public ep(Context context, String str) {
        super(context, str);
        this.a = 16777216;
    }

    @Override // com.xiaomi.push.es
    public ep a(Bitmap bitmap) {
        if (m871b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || 184 > bitmap.getHeight() || bitmap.getHeight() > 1678) {
                com.xiaomi.channel.commonutils.logger.b.m586a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            } else {
                this.b = bitmap;
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.eq
    /* renamed from: a */
    public ep mo863a(String str) {
        if (m871b() && !TextUtils.isEmpty(str)) {
            try {
                this.a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m586a("parse banner notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.es, android.app.Notification.Builder
    /* renamed from: a */
    public es setLargeIcon(Bitmap bitmap) {
        return this;
    }

    @Override // com.xiaomi.push.es
    /* renamed from: a */
    protected String mo868a() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.es, com.xiaomi.push.eq
    /* renamed from: a  reason: collision with other method in class */
    public void mo861a() {
        RemoteViews m867a;
        Bitmap bitmap;
        if (!m871b() || this.b == null) {
            m870b();
            return;
        }
        super.mo861a();
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a = a(resources, "bg", "id", packageName);
        if (m.a(a()) >= 10) {
            m867a = m867a();
            bitmap = a(this.b, 30.0f);
        } else {
            m867a = m867a();
            bitmap = this.b;
        }
        m867a.setImageViewBitmap(a, bitmap);
        int a2 = a(resources, RemoteMessageConst.Notification.ICON, "id", packageName);
        if (this.c != null) {
            m867a().setImageViewBitmap(a2, this.c);
        } else {
            a(a2);
        }
        int a3 = a(resources, "title", "id", packageName);
        m867a().setTextViewText(a3, ((es) this).f310a);
        Map<String, String> map = ((es) this).f313a;
        if (map != null && this.a == 16777216) {
            mo863a(map.get("notification_image_text_color"));
        }
        RemoteViews m867a2 = m867a();
        int i = this.a;
        m867a2.setTextColor(a3, (i == 16777216 || !m869a(i)) ? -1 : -16777216);
        setCustomContentView(m867a());
        Bundle bundle = new Bundle();
        bundle.putBoolean("miui.customHeight", true);
        addExtras(bundle);
    }

    @Override // com.xiaomi.push.es
    /* renamed from: a  reason: collision with other method in class */
    protected boolean mo862a() {
        if (m.m1118a()) {
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            return (a(a().getResources(), "bg", "id", a().getPackageName()) == 0 || a(resources, RemoteMessageConst.Notification.ICON, "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || m.a(a()) < 9) ? false : true;
        }
        return false;
    }

    public ep b(Bitmap bitmap) {
        if (m871b() && bitmap != null) {
            this.c = bitmap;
        }
        return this;
    }

    @Override // com.xiaomi.push.es
    protected String b() {
        return null;
    }
}
