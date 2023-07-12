package com.alibaba.security.biometrics.c.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.jni.VersionKey;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class a implements b {
    private static final String ba = "ABLogRecorder";
    public static a d;
    protected ALBiometricsEventListener a;
    protected HandlerThread b;
    private Bundle bb;
    protected Handler c;
    protected long e;
    protected long f;
    protected long g;
    protected long h;
    protected long i;
    protected long j;

    private a() {
        HandlerThread handlerThread = new HandlerThread(ba);
        this.b = handlerThread;
        handlerThread.start();
        this.c = new Handler(this.b.getLooper());
    }

    public static a b() {
        if (d == null) {
            d = new a();
        }
        return d;
    }

    public static void c() {
        HandlerThread handlerThread;
        try {
            a aVar = d;
            if (aVar != null && (handlerThread = aVar.b) != null) {
                handlerThread.getLooper().quit();
            }
            d = null;
        } catch (Throwable unused) {
        }
    }

    public final Bundle a() {
        if (this.bb == null) {
            this.bb = new Bundle();
        }
        return this.bb;
    }

    private void b(String str, Bundle bundle) {
        if (a() == null || !a().containsKey(str)) {
            return;
        }
        bundle.putString(str, a().getString(str));
    }

    private void c(String str, Bundle bundle) {
        try {
            if ("10001".equals(str)) {
                this.e = System.currentTimeMillis();
            } else if ("10002".equals(str)) {
                bundle.putString("time_key", "time_nav");
                bundle.putLong("time_time", System.currentTimeMillis() - this.e);
                this.e = System.currentTimeMillis();
            } else if ("10003".equals(str)) {
                this.f = System.currentTimeMillis();
            } else if ("10033".equals(str)) {
                bundle.putString("time_key", "time_liveness");
                bundle.putLong("time_time", System.currentTimeMillis() - this.f);
                this.f = System.currentTimeMillis();
            } else if ("10031".equals(str)) {
                bundle.putString("time_key", "time_liveness");
                bundle.putLong("time_time", System.currentTimeMillis() - this.f);
            } else if ("10041".equals(str)) {
                this.j = System.currentTimeMillis();
            } else if ("10042".equals(str)) {
                bundle.putString("time_key", "time_result");
                bundle.putLong("time_time", System.currentTimeMillis() - this.j);
                this.j = System.currentTimeMillis();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(ALBiometricsEventListener aLBiometricsEventListener) {
        this.a = aLBiometricsEventListener;
    }

    public final void a(Throwable th) {
        Bundle bundle = new Bundle();
        bundle.putString("stack", a(th, " "));
        a("10099", bundle);
        th.printStackTrace();
    }

    public final void a(String str, Bundle bundle) {
        if (this.a != null) {
            try {
                final Bundle bundle2 = new Bundle();
                bundle2.putString("code", str);
                bundle2.putString("eventId", str);
                if ("10000".equals(str)) {
                    b("vol_s", bundle2);
                } else if ("10003".equals(str)) {
                    b("cam_w", bundle2);
                    b("cam_h", bundle2);
                    b("cam_a", bundle2);
                    b("vol_s", bundle2);
                    b("nav", bundle2);
                    b("act_c", bundle2);
                    b("act_1", bundle2);
                    b("act_2", bundle2);
                    b("act_3", bundle2);
                    b("act_4", bundle2);
                    b("act_5", bundle2);
                    b("retry_m", bundle2);
                    b("fail_m", bundle2);
                    b("aju_to", bundle2);
                    b("act_to", bundle2);
                    b("act_th", bundle2);
                    b("act_wr_th", bundle2);
                    b("min_face_th", bundle2);
                    b("gblur_th", bundle2);
                    b("mblur_th", bundle2);
                    b("qua_th", bundle2);
                    b("no_face_th", bundle2);
                    b("gra", bundle2);
                } else if ("10001".equals(str)) {
                    b("gra", bundle2);
                } else if ("10002".equals(str)) {
                    b("gra", bundle2);
                } else if ("10007".equals(str)) {
                    b("hint_c", bundle2);
                    b("gra", bundle2);
                } else if ("10008".equals(str)) {
                    b("snd_c", bundle2);
                    b("gra", bundle2);
                } else if ("10011".equals(str)) {
                    b("err_tt", bundle2);
                } else if ("10012".equals(str)) {
                    b("retry_tt", bundle2);
                } else if ("10013".equals(str)) {
                    b("confirm", bundle2);
                } else if ("10025".equals(str)) {
                    b("vol_s", bundle2);
                } else if (!"10026".equals(str)) {
                    if ("10027".equals(str)) {
                        b("confirm", bundle2);
                    } else if (!"10028".equals(str) && !"10029".equals(str) && !"10030".equals(str)) {
                        if ("10031".equals(str)) {
                            b("succ", bundle2);
                            b("reason", bundle2);
                            b("vol_s", bundle2);
                        } else if ("10099".equals(str)) {
                            bundle2.putString("flsdkversion", VersionKey.FL_SDK_VERSION);
                            bundle2.putString("rpsdkversion", VersionKey.RP_SDK_VERSION);
                        }
                    }
                }
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
                c(str, bundle2);
                this.c.post(new Runnable() { // from class: com.alibaba.security.biometrics.c.b.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            ALBiometricsEventListener aLBiometricsEventListener = a.this.a;
                            if (aLBiometricsEventListener != null) {
                                aLBiometricsEventListener.onOldLogRecord(bundle2);
                            }
                        } catch (Exception unused) {
                            com.alibaba.security.common.c.a.b();
                        } catch (Throwable unused2) {
                            com.alibaba.security.common.c.a.b();
                        }
                    }
                });
            } catch (Exception unused) {
                com.alibaba.security.common.c.a.b();
            } catch (Throwable unused2) {
                com.alibaba.security.common.c.a.b();
            }
        }
    }

    private static String a(Throwable th, String str) {
        if (th == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(th.getMessage());
        sb.append(str);
        if (th.getStackTrace() != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                sb.append(stackTraceElement);
                sb.append(str);
            }
        }
        return sb.toString();
    }
}
