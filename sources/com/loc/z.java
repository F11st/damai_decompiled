package com.loc;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import cn.damai.commonbusiness.discover.bean.GridBean;
import java.lang.ref.WeakReference;
import java.util.List;
import tb.t33;
import tb.v33;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class z {
    public static final String a = v1.v("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
    private static z e;
    private List<String> b;
    private String c;
    private final Context d;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class a extends Handler {
        private final WeakReference<z> a;

        a(Looper looper, z zVar) {
            super(looper);
            this.a = new WeakReference<>(zVar);
        }

        a(z zVar) {
            this.a = new WeakReference<>(zVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            z zVar = this.a.get();
            if (zVar == null || message == null || (obj = message.obj) == null) {
                return;
            }
            zVar.e((String) obj, message.what);
        }
    }

    private z(Context context) {
        this.d = context.getApplicationContext();
        if (Looper.myLooper() == null) {
            new a(Looper.getMainLooper(), this);
        } else {
            new a(this);
        }
    }

    public static z b(Context context) {
        if (e == null) {
            synchronized (z.class) {
                if (e == null) {
                    e = new z(context);
                }
            }
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(final String str, final int i) {
        ContentResolver contentResolver;
        String str2;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread() { // from class: com.loc.z.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    ContentResolver contentResolver2;
                    String str3;
                    String h = v33.h(str);
                    if (TextUtils.isEmpty(h)) {
                        return;
                    }
                    if ((i & 1) > 0) {
                        try {
                            if (Build.VERSION.SDK_INT < 23) {
                                contentResolver2 = z.this.d.getContentResolver();
                                str3 = z.this.c;
                            } else if (Settings.System.canWrite(z.this.d)) {
                                contentResolver2 = z.this.d.getContentResolver();
                                str3 = z.this.c;
                            }
                            Settings.System.putString(contentResolver2, str3, h);
                        } catch (Exception unused) {
                        }
                    }
                    if ((i & 16) > 0) {
                        t33.b(z.this.d, z.this.c, h);
                    }
                    if ((i & 256) > 0) {
                        SharedPreferences.Editor edit = z.this.d.getSharedPreferences(z.a, 0).edit();
                        edit.putString(z.this.c, h);
                        if (Build.VERSION.SDK_INT >= 9) {
                            edit.apply();
                        } else {
                            edit.commit();
                        }
                    }
                }
            }.start();
            return;
        }
        String h = v33.h(str);
        if (!TextUtils.isEmpty(h)) {
            if ((i & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        contentResolver = this.d.getContentResolver();
                        str2 = this.c;
                    } else {
                        contentResolver = this.d.getContentResolver();
                        str2 = this.c;
                    }
                    Settings.System.putString(contentResolver, str2, h);
                } catch (Exception unused) {
                }
            }
            if ((i & 16) > 0) {
                t33.b(this.d, this.c, h);
            }
            if ((i & 256) > 0) {
                SharedPreferences.Editor edit = this.d.getSharedPreferences(a, 0).edit();
                edit.putString(this.c, h);
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                    return;
                }
                edit.commit();
            }
        }
    }

    public final void d(String str) {
        this.c = str;
    }

    public final void g(String str) {
        List<String> list = this.b;
        if (list != null) {
            list.clear();
            this.b.add(str);
        }
        e(str, GridBean.TYPE_VIDEO_UNDER_REVIEW);
    }
}
