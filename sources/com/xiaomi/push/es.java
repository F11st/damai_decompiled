package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class es extends eq {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    protected Bitmap f308a;

    /* renamed from: a  reason: collision with other field name */
    private RemoteViews f309a;

    /* renamed from: a  reason: collision with other field name */
    protected CharSequence f310a;

    /* renamed from: a  reason: collision with other field name */
    private String f311a;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<Notification.Action> f312a;

    /* renamed from: a  reason: collision with other field name */
    protected Map<String, String> f313a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f314a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    protected CharSequence f315b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f316b;

    public es(Context context, int i, String str) {
        super(context);
        this.f312a = new ArrayList<>();
        this.b = 0;
        this.f311a = str;
        this.a = i;
        m864c();
    }

    public es(Context context, String str) {
        this(context, 0, str);
    }

    private Bitmap a() {
        return com.xiaomi.push.service.al.a(C7667h.m940a(a(), this.f311a));
    }

    private String c() {
        boolean e = e();
        this.f316b = e;
        return e ? b() : mo868a();
    }

    /* renamed from: c  reason: collision with other method in class */
    private void m864c() {
        int a = a(a().getResources(), c(), "layout", a().getPackageName());
        if (a == 0) {
            AbstractC7535b.m586a("create RemoteViews failed, no such layout resource was found");
            return;
        }
        this.f309a = new RemoteViews(a().getPackageName(), a);
        this.f314a = mo862a();
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m865c() {
        Map<String, String> map = this.f313a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    private void d() {
        super.setContentTitle(this.f310a);
        super.setContentText(this.f315b);
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m866d() {
        return (TextUtils.isEmpty(b()) || TextUtils.isEmpty(this.f311a)) ? false : true;
    }

    private boolean e() {
        return m866d() && f();
    }

    private boolean f() {
        List<StatusBarNotification> m1189b;
        if (Build.VERSION.SDK_INT >= 20 && (m1189b = com.xiaomi.push.service.ax.a(a(), this.f311a).m1189b()) != null && !m1189b.isEmpty()) {
            for (StatusBarNotification statusBarNotification : m1189b) {
                if (statusBarNotification.getId() == this.a) {
                    Notification notification = statusBarNotification.getNotification();
                    if (notification == null) {
                        return false;
                    }
                    return !notification.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(float f) {
        return (int) ((f * a().getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap a(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final RemoteViews m867a() {
        return this.f309a;
    }

    @Override // com.xiaomi.push.eq
    public eq a(Map<String, String> map) {
        this.f313a = map;
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public es addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        addAction(new Notification.Action(i, charSequence, pendingIntent));
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public es addAction(Notification.Action action) {
        if (action != null) {
            this.f312a.add(action);
        }
        int i = this.b;
        this.b = i + 1;
        a(i, action);
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public es setLargeIcon(Bitmap bitmap) {
        this.f308a = bitmap;
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public es setContentTitle(CharSequence charSequence) {
        this.f310a = charSequence;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    protected abstract String mo868a();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.eq
    /* renamed from: a */
    public void mo861a() {
        super.mo861a();
        Bundle bundle = new Bundle();
        if (m866d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f316b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", a("large_icon"));
        if (this.f312a.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f312a.size()];
            this.f312a.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (m865c() || !com.xiaomi.push.service.ay.m1191a(a().getContentResolver())) {
            d();
        } else {
            bundle.putCharSequence("mipush.customTitle", this.f310a);
            bundle.putCharSequence("mipush.customContent", this.f315b);
        }
        addExtras(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        Bitmap a = a();
        if (a != null) {
            m867a().setImageViewBitmap(i, a);
            return;
        }
        int b = C7667h.b(a(), this.f311a);
        if (b != 0) {
            m867a().setImageViewResource(i, b);
        }
    }

    protected void a(int i, Notification.Action action) {
    }

    /* renamed from: a */
    protected abstract boolean mo862a();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a  reason: collision with other method in class */
    public final boolean m869a(int i) {
        return ((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d) < 192.0d;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: b */
    public es setContentText(CharSequence charSequence) {
        this.f315b = charSequence;
        return this;
    }

    protected abstract String b();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b  reason: collision with other method in class */
    public final void m870b() {
        super.setContentTitle(this.f310a);
        super.setContentText(this.f315b);
        Bitmap bitmap = this.f308a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b  reason: collision with other method in class */
    public final boolean m871b() {
        return this.f314a;
    }
}
