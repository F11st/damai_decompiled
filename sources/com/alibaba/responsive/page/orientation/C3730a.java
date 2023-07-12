package com.alibaba.responsive.page.orientation;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.alibaba.responsive.page.orientation.OrientationListener;
import tb.b80;
import tb.cp1;
import tb.w22;
import tb.xe2;

/* compiled from: Taobao */
/* renamed from: com.alibaba.responsive.page.orientation.a */
/* loaded from: classes8.dex */
public class C3730a {
    private Activity a;
    private OrientationListener b;
    private Handler c = new Handler();
    private ContentObserver d = new C3731a(this.c);
    OrientationListener.OrientationChangeCallback e = new C3732b();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.responsive.page.orientation.a$a */
    /* loaded from: classes8.dex */
    class C3731a extends ContentObserver {
        C3731a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            int i = OrientationListener.d;
            if (C3730a.this.b == null || C3730a.this.a.isFinishing()) {
                return;
            }
            int requestedOrientation = C3730a.this.a.getRequestedOrientation();
            if (requestedOrientation != 0) {
                if (requestedOrientation != 1) {
                    switch (requestedOrientation) {
                        case 8:
                            i = OrientationListener.f;
                            break;
                        case 9:
                            i = OrientationListener.g;
                            break;
                    }
                    C3730a.this.b.c(i);
                }
                i = OrientationListener.d;
                C3730a.this.b.c(i);
            }
            i = OrientationListener.e;
            C3730a.this.b.c(i);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.responsive.page.orientation.a$b */
    /* loaded from: classes8.dex */
    class C3732b implements OrientationListener.OrientationChangeCallback {
        C3732b() {
        }

        @Override // com.alibaba.responsive.page.orientation.OrientationListener.OrientationChangeCallback
        public void land() {
            int requestedOrientation;
            if (C3730a.this.f() || (requestedOrientation = C3730a.this.a.getRequestedOrientation()) == 0) {
                return;
            }
            if (requestedOrientation == 8 || requestedOrientation == 6) {
                cp1.b(C3730a.this.a, 0);
                return;
            }
            C3730a c3730a = C3730a.this;
            if (c3730a.e(c3730a.a)) {
                cp1.b(C3730a.this.a, 0);
            } else {
                C3730a.this.h();
            }
        }

        @Override // com.alibaba.responsive.page.orientation.OrientationListener.OrientationChangeCallback
        public void port() {
            try {
                if (C3730a.this.f()) {
                    return;
                }
                int requestedOrientation = C3730a.this.a.getRequestedOrientation();
                if (requestedOrientation != 1) {
                    if (requestedOrientation == 9) {
                        cp1.b(C3730a.this.a, 1);
                    } else {
                        C3730a c3730a = C3730a.this;
                        if (c3730a.e(c3730a.a)) {
                            cp1.b(C3730a.this.a, 1);
                        } else {
                            C3730a.this.h();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.alibaba.responsive.page.orientation.OrientationListener.OrientationChangeCallback
        public void reverseLand() {
            int requestedOrientation;
            if (C3730a.this.f() || (requestedOrientation = C3730a.this.a.getRequestedOrientation()) == 8) {
                return;
            }
            if (requestedOrientation == 0 || requestedOrientation == 6) {
                cp1.b(C3730a.this.a, 8);
                return;
            }
            C3730a c3730a = C3730a.this;
            if (c3730a.e(c3730a.a)) {
                cp1.b(C3730a.this.a, 8);
            } else {
                C3730a.this.h();
            }
        }

        @Override // com.alibaba.responsive.page.orientation.OrientationListener.OrientationChangeCallback
        public void reversePort() {
        }
    }

    public C3730a(Activity activity) {
        this.a = activity;
        OrientationListener orientationListener = new OrientationListener(activity, this.e);
        this.b = orientationListener;
        orientationListener.b();
        this.a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return b80.g(this.a) && w22.d().c(this.a) <= xe2.c();
    }

    public void g() {
        OrientationListener orientationListener = this.b;
        if (orientationListener != null) {
            orientationListener.a();
        }
        this.c.removeCallbacksAndMessages(null);
        this.a.getContentResolver().unregisterContentObserver(this.d);
    }

    public void h() {
    }
}
