package com.loc;

import android.content.Context;
import android.text.TextUtils;
import io.flutter.wpkbridge.WPKFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;
import tb.f53;
import tb.g53;
import tb.i53;
import tb.u43;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class bs {
    static boolean a = false;
    static int b = 20;
    private static int c = 20;
    private static WeakReference<u43> d;
    private static int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a extends ck {
        static int a = 1;
        static int b = 2;
        static int c = 3;
        private Context d;
        private d0 f;
        private int g;
        private List<d0> h;

        a(Context context, int i) {
            this.d = context;
            this.g = i;
        }

        a(Context context, int i, d0 d0Var) {
            this(context, i);
            this.f = d0Var;
        }

        a(Context context, int i, List<d0> list) {
            this(context, i);
            this.h = list;
        }

        @Override // com.loc.ck
        public final void a() {
            String str;
            String str2;
            d0 d0Var;
            Throwable th;
            ByteArrayOutputStream byteArrayOutputStream;
            int i = this.g;
            if (i == 1) {
                try {
                    if (this.d != null && this.f != null) {
                        synchronized (bs.class) {
                            Context context = this.d;
                            if (context != null && (d0Var = this.f) != null) {
                                bs.c(context, d0Var.b());
                                return;
                            }
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    str = WPKFactory.CONF_SERVER_TIME;
                    str2 = "as";
                }
            } else if (i != 2) {
                if (i == 3) {
                    try {
                        if (this.d == null) {
                            return;
                        }
                        u43 d = e0.d(bs.d);
                        e0.e(this.d, d, al.h, 1000, 307200, "2");
                        if (d.g == null) {
                            d.g = new f0(new j0(this.d, new g0(new k0(new n0()))));
                        }
                        d.h = 3600000;
                        if (TextUtils.isEmpty(d.i)) {
                            d.i = "cKey";
                        }
                        if (d.f == null) {
                            Context context2 = this.d;
                            d.f = new i53(context2, d.h, d.i, new f53(d.a, new g53(context2, bs.a, bs.c * 1024, bs.b * 1024, "staticUpdate", bs.e * 1024)));
                        }
                        b0.a(d);
                        return;
                    } catch (Throwable th3) {
                        an.m(th3, WPKFactory.CONF_SERVER_TIME, "usd");
                        return;
                    }
                }
                return;
            } else {
                try {
                    synchronized (bs.class) {
                        if (this.h != null && this.d != null) {
                            ByteArrayOutputStream byteArrayOutputStream2 = null;
                            byte[] bArr = new byte[0];
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            try {
                                for (d0 d0Var2 : this.h) {
                                    if (d0Var2 != null) {
                                        byteArrayOutputStream.write(d0Var2.b());
                                    }
                                }
                                bArr = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable th5) {
                                    th = th5;
                                    th.printStackTrace();
                                    bs.c(this.d, bArr);
                                    return;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    an.m(th, WPKFactory.CONF_SERVER_TIME, "aStB");
                                    if (byteArrayOutputStream2 != null) {
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Throwable th7) {
                                            th = th7;
                                            th.printStackTrace();
                                            bs.c(this.d, bArr);
                                            return;
                                        }
                                    }
                                    bs.c(this.d, bArr);
                                    return;
                                } catch (Throwable th8) {
                                    if (byteArrayOutputStream2 != null) {
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Throwable th9) {
                                            th9.printStackTrace();
                                        }
                                    }
                                    throw th8;
                                }
                            }
                            bs.c(this.d, bArr);
                            return;
                        }
                        return;
                    }
                } catch (Throwable th10) {
                    th = th10;
                    str = WPKFactory.CONF_SERVER_TIME;
                    str2 = "apb";
                }
            }
            an.m(th, str, str2);
        }
    }

    public static void b(Context context) {
        o0.f().d(new a(context, a.c));
    }

    static /* synthetic */ void c(Context context, byte[] bArr) throws IOException {
        u43 d2 = e0.d(d);
        e0.e(context, d2, al.h, 1000, 307200, "2");
        if (d2.e == null) {
            d2.e = new n();
        }
        Random random = new Random();
        try {
            b0.c(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, d2);
        } catch (Throwable th) {
            an.m(th, WPKFactory.CONF_SERVER_TIME, "wts");
        }
    }

    public static synchronized void d(d0 d0Var, Context context) {
        synchronized (bs.class) {
            o0.f().d(new a(context, a.a, d0Var));
        }
    }

    public static synchronized void e(List<d0> list, Context context) {
        synchronized (bs.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        o0.f().d(new a(context, a.b, list));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void f(boolean z, int i) {
        synchronized (bs.class) {
            a = z;
            e = Math.max(0, i);
        }
    }

    public static synchronized void h(List<d0> list, Context context) {
        synchronized (bs.class) {
            try {
                List<d0> p = y.p();
                if (p != null && p.size() > 0) {
                    list.addAll(p);
                }
            } catch (Throwable unused) {
            }
            e(list, context);
        }
    }
}
