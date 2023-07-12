package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import io.flutter.wpkbridge.WPKFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class dm {
    static boolean a = false;
    static int b = 20;
    private static int c = 20;
    private static WeakReference<dh> d;
    private static int e;

    public static synchronized void a(dl dlVar, Context context) {
        synchronized (dm.class) {
            ed.a().b(new C4427a(context, C4427a.a, dlVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.dm$a */
    /* loaded from: classes10.dex */
    public static class C4427a extends ee {
        static int a = 1;
        static int b = 2;
        static int c = 3;
        private Context d;
        private dl f;
        private int g;
        private List<dl> h;

        C4427a(Context context, int i) {
            this.d = context;
            this.g = i;
        }

        @Override // com.amap.api.col.s.ee
        public final void a() {
            dl dlVar;
            Throwable th;
            ByteArrayOutputStream byteArrayOutputStream;
            int i = this.g;
            if (i == 1) {
                try {
                    if (this.d != null && this.f != null) {
                        synchronized (dm.class) {
                            Context context = this.d;
                            if (context != null && (dlVar = this.f) != null) {
                                dm.a(context, dlVar.a());
                            }
                        }
                    }
                } catch (Throwable th2) {
                    cl.c(th2, WPKFactory.CONF_SERVER_TIME, "as");
                }
            } else if (i != 2) {
                if (i == 3) {
                    try {
                        if (this.d == null) {
                            return;
                        }
                        dh a2 = dn.a(dm.d);
                        dn.a(this.d, a2, cj.h, 1000, 307200, "2");
                        if (a2.g == null) {
                            a2.g = new Cdo(new ds(this.d, new C4428dp(new dt(new dv()))));
                        }
                        a2.h = 3600000;
                        if (TextUtils.isEmpty(a2.i)) {
                            a2.i = "cKey";
                        }
                        if (a2.f == null) {
                            Context context2 = this.d;
                            a2.f = new dz(context2, a2.h, a2.i, new dw(a2.a, new dx(context2, dm.a, dm.c * 1024, dm.b * 1024, "staticUpdate", dm.e * 1024)));
                        }
                        di.a(a2);
                    } catch (Throwable th3) {
                        cl.c(th3, WPKFactory.CONF_SERVER_TIME, "usd");
                    }
                }
            } else {
                try {
                    synchronized (dm.class) {
                        if (this.h != null && this.d != null) {
                            ByteArrayOutputStream byteArrayOutputStream2 = null;
                            byte[] bArr = new byte[0];
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            try {
                                for (dl dlVar2 : this.h) {
                                    if (dlVar2 != null) {
                                        byteArrayOutputStream.write(dlVar2.a());
                                    }
                                }
                                bArr = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable th5) {
                                    th = th5;
                                    th.printStackTrace();
                                    dm.a(this.d, bArr);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    cl.c(th, WPKFactory.CONF_SERVER_TIME, "aStB");
                                    if (byteArrayOutputStream2 != null) {
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Throwable th7) {
                                            th = th7;
                                            th.printStackTrace();
                                            dm.a(this.d, bArr);
                                        }
                                    }
                                    dm.a(this.d, bArr);
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
                            dm.a(this.d, bArr);
                        }
                    }
                } catch (Throwable th10) {
                    cl.c(th10, WPKFactory.CONF_SERVER_TIME, "apb");
                }
            }
        }

        C4427a(Context context, int i, List<dl> list) {
            this(context, i);
            this.h = list;
        }

        C4427a(Context context, int i, dl dlVar) {
            this(context, i);
            this.f = dlVar;
        }
    }

    public static synchronized void a(List<dl> list, Context context) {
        synchronized (dm.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        ed.a().b(new C4427a(context, C4427a.b, list));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void a(Context context) {
        ed.a().b(new C4427a(context, C4427a.c));
    }

    static /* synthetic */ void a(Context context, byte[] bArr) throws IOException {
        dh a2 = dn.a(d);
        dn.a(context, a2, cj.h, 1000, 307200, "2");
        if (a2.e == null) {
            a2.e = new cp();
        }
        Random random = new Random();
        try {
            di.a(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, a2);
        } catch (Throwable th) {
            cl.c(th, WPKFactory.CONF_SERVER_TIME, "wts");
        }
    }
}
