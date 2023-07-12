package com.amap.api.mapcore.util;

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

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class gq {
    public static final String a = gn.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
    private static gq f;
    private List<String> b;
    private String c;
    private final Context d;
    private final Handler e;

    private gq(Context context) {
        this.d = context.getApplicationContext();
        if (Looper.myLooper() == null) {
            this.e = new a(Looper.getMainLooper(), this);
        } else {
            this.e = new a(this);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class a extends Handler {
        private final WeakReference<gq> a;

        a(gq gqVar) {
            this.a = new WeakReference<>(gqVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            gq gqVar = this.a.get();
            if (gqVar == null || message == null || (obj = message.obj) == null) {
                return;
            }
            gqVar.a((String) obj, message.what);
        }

        a(Looper looper, gq gqVar) {
            super(looper);
            this.a = new WeakReference<>(gqVar);
        }
    }

    public void b(String str) {
        List<String> list = this.b;
        if (list != null) {
            list.clear();
            this.b.add(str);
        }
        a(str, GridBean.TYPE_VIDEO_UNDER_REVIEW);
    }

    public static gq a(Context context) {
        if (f == null) {
            synchronized (gq.class) {
                if (f == null) {
                    f = new gq(context);
                }
            }
        }
        return f;
    }

    public void a(String str) {
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(final String str, final int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread() { // from class: com.amap.api.mapcore.util.gq.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    String b = gw.b(str);
                    if (TextUtils.isEmpty(b)) {
                        return;
                    }
                    if ((i & 1) > 0) {
                        try {
                            if (Build.VERSION.SDK_INT >= 23) {
                                Settings.System.putString(gq.this.d.getContentResolver(), gq.this.c, b);
                            } else {
                                Settings.System.putString(gq.this.d.getContentResolver(), gq.this.c, b);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if ((i & 16) > 0) {
                        gs.a(gq.this.d, gq.this.c, b);
                    }
                    if ((i & 256) > 0) {
                        SharedPreferences.Editor edit = gq.this.d.getSharedPreferences(gq.a, 0).edit();
                        edit.putString(gq.this.c, b);
                        if (Build.VERSION.SDK_INT >= 9) {
                            edit.apply();
                        } else {
                            edit.commit();
                        }
                    }
                }
            }.start();
        } else {
            String b = gw.b(str);
            if (!TextUtils.isEmpty(b)) {
                if ((i & 1) > 0) {
                    try {
                        if (Build.VERSION.SDK_INT >= 23) {
                            Settings.System.putString(this.d.getContentResolver(), this.c, b);
                        } else {
                            Settings.System.putString(this.d.getContentResolver(), this.c, b);
                        }
                    } catch (Exception unused) {
                    }
                }
                if ((i & 16) > 0) {
                    gs.a(this.d, this.c, b);
                }
                if ((i & 256) > 0) {
                    SharedPreferences.Editor edit = this.d.getSharedPreferences(a, 0).edit();
                    edit.putString(this.c, b);
                    if (Build.VERSION.SDK_INT >= 9) {
                        edit.apply();
                    } else {
                        edit.commit();
                    }
                }
            }
        }
    }
}
