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
/* loaded from: classes8.dex */
public class a {
    private Activity a;
    private OrientationListener b;
    private Handler c = new Handler();
    private ContentObserver d = new C0161a(this.c);
    OrientationListener.OrientationChangeCallback e = new b();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.responsive.page.orientation.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    class C0161a extends ContentObserver {
        C0161a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            int i = OrientationListener.d;
            if (a.this.b == null || a.this.a.isFinishing()) {
                return;
            }
            int requestedOrientation = a.this.a.getRequestedOrientation();
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
                    a.this.b.c(i);
                }
                i = OrientationListener.d;
                a.this.b.c(i);
            }
            i = OrientationListener.e;
            a.this.b.c(i);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    class b implements OrientationListener.OrientationChangeCallback {
        b() {
        }

        @Override // com.alibaba.responsive.page.orientation.OrientationListener.OrientationChangeCallback
        public void land() {
            int requestedOrientation;
            if (a.this.f() || (requestedOrientation = a.this.a.getRequestedOrientation()) == 0) {
                return;
            }
            if (requestedOrientation == 8 || requestedOrientation == 6) {
                cp1.b(a.this.a, 0);
                return;
            }
            a aVar = a.this;
            if (aVar.e(aVar.a)) {
                cp1.b(a.this.a, 0);
            } else {
                a.this.h();
            }
        }

        @Override // com.alibaba.responsive.page.orientation.OrientationListener.OrientationChangeCallback
        public void port() {
            try {
                if (a.this.f()) {
                    return;
                }
                int requestedOrientation = a.this.a.getRequestedOrientation();
                if (requestedOrientation != 1) {
                    if (requestedOrientation == 9) {
                        cp1.b(a.this.a, 1);
                    } else {
                        a aVar = a.this;
                        if (aVar.e(aVar.a)) {
                            cp1.b(a.this.a, 1);
                        } else {
                            a.this.h();
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
            if (a.this.f() || (requestedOrientation = a.this.a.getRequestedOrientation()) == 8) {
                return;
            }
            if (requestedOrientation == 0 || requestedOrientation == 6) {
                cp1.b(a.this.a, 8);
                return;
            }
            a aVar = a.this;
            if (aVar.e(aVar.a)) {
                cp1.b(a.this.a, 8);
            } else {
                a.this.h();
            }
        }

        @Override // com.alibaba.responsive.page.orientation.OrientationListener.OrientationChangeCallback
        public void reversePort() {
        }
    }

    public a(Activity activity) {
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
