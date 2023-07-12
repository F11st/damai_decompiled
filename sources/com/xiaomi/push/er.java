package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class er extends es {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private PendingIntent f305a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private Bitmap f306b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private CharSequence f307c;

    public er(Context context, int i, String str) {
        super(context, i, str);
        this.a = 16777216;
        this.b = 16777216;
        this.c = 16777216;
    }

    private Drawable a(int i, int i2, int i3, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i3);
        return shapeDrawable;
    }

    private void a(RemoteViews remoteViews, int i, int i2, int i3, boolean z) {
        int a = a(6.0f);
        remoteViews.setViewPadding(i, a, 0, a, 0);
        int i4 = z ? -1 : -16777216;
        remoteViews.setTextColor(i2, i4);
        remoteViews.setTextColor(i3, i4);
    }

    @Override // com.xiaomi.push.es
    public er a(Bitmap bitmap) {
        if (m871b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || bitmap.getHeight() < 177 || bitmap.getHeight() > 207) {
                AbstractC7535b.m586a("colorful notification bg image resolution error, must [984*177, 984*207]");
            } else {
                this.f306b = bitmap;
            }
        }
        return this;
    }

    public er a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (m871b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f307c = charSequence;
            this.f305a = pendingIntent;
        }
        return this;
    }

    @Override // com.xiaomi.push.eq
    /* renamed from: a */
    public er mo863a(String str) {
        if (m871b() && !TextUtils.isEmpty(str)) {
            try {
                this.b = Color.parseColor(str);
            } catch (Exception unused) {
                AbstractC7535b.m586a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.es
    /* renamed from: a */
    protected String mo868a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.es, com.xiaomi.push.eq
    /* renamed from: a */
    public void mo861a() {
        RemoteViews m867a;
        Bitmap bitmap;
        boolean z;
        RemoteViews m867a2;
        RemoteViews m867a3;
        Drawable a;
        if (!m871b()) {
            m870b();
            return;
        }
        super.mo861a();
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a2 = a(resources, RemoteMessageConst.Notification.ICON, "id", packageName);
        if (((es) this).f308a == null) {
            a(a2);
        } else {
            m867a().setImageViewBitmap(a2, ((es) this).f308a);
        }
        int a3 = a(resources, "title", "id", packageName);
        int a4 = a(resources, "content", "id", packageName);
        m867a().setTextViewText(a3, ((es) this).f310a);
        m867a().setTextViewText(a4, ((es) this).f315b);
        if (!TextUtils.isEmpty(this.f307c)) {
            int a5 = a(resources, "buttonContainer", "id", packageName);
            int a6 = a(resources, BaseCellItem.TYPE_BUTTON, "id", packageName);
            int a7 = a(resources, "buttonBg", "id", packageName);
            m867a().setViewVisibility(a5, 0);
            m867a().setTextViewText(a6, this.f307c);
            m867a().setOnClickPendingIntent(a5, this.f305a);
            if (this.b != 16777216) {
                int a8 = a(70.0f);
                int a9 = a(29.0f);
                m867a().setImageViewBitmap(a7, com.xiaomi.push.service.al.a(a(this.b, a8, a9, a9 / 2.0f)));
                m867a().setTextColor(a6, m869a(this.b) ? -1 : -16777216);
            }
        }
        int a10 = a(resources, "bg", "id", packageName);
        int a11 = a(resources, "container", "id", packageName);
        if (this.a != 16777216) {
            if (C7688m.a(a()) >= 10) {
                m867a3 = m867a();
                a = a(this.a, 984, 192, 30.0f);
            } else {
                m867a3 = m867a();
                a = a(this.a, 984, 192, 0.0f);
            }
            m867a3.setImageViewBitmap(a10, com.xiaomi.push.service.al.a(a));
            m867a2 = m867a();
            z = m869a(this.a);
        } else if (this.f306b == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                m867a().setViewVisibility(a2, 8);
                m867a().setViewVisibility(a10, 8);
                try {
                    bk.a((Object) this, "setStyle", C7786v.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    AbstractC7535b.m586a("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(m867a());
        } else {
            if (C7688m.a(a()) >= 10) {
                m867a = m867a();
                bitmap = a(this.f306b, 30.0f);
            } else {
                m867a = m867a();
                bitmap = this.f306b;
            }
            m867a.setImageViewBitmap(a10, bitmap);
            Map<String, String> map = ((es) this).f313a;
            if (map != null && this.c == 16777216) {
                c(map.get("notification_image_text_color"));
            }
            int i = this.c;
            z = i == 16777216 || !m869a(i);
            m867a2 = m867a();
        }
        a(m867a2, a11, a3, a4, z);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("miui.customHeight", true);
        addExtras(bundle2);
        setCustomContentView(m867a());
    }

    @Override // com.xiaomi.push.es
    /* renamed from: a */
    protected boolean mo862a() {
        if (C7688m.m1118a()) {
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            return (a(resources, RemoteMessageConst.Notification.ICON, "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || a(resources, "content", "id", packageName) == 0) ? false : true;
        }
        return false;
    }

    public er b(String str) {
        if (m871b() && !TextUtils.isEmpty(str)) {
            try {
                this.a = Color.parseColor(str);
            } catch (Exception unused) {
                AbstractC7535b.m586a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.es
    protected String b() {
        return "notification_colorful_copy";
    }

    public er c(String str) {
        if (m871b() && !TextUtils.isEmpty(str)) {
            try {
                this.c = Color.parseColor(str);
            } catch (Exception unused) {
                AbstractC7535b.m586a("parse colorful notification image text color error");
            }
        }
        return this;
    }
}
