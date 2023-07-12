package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.al;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class dt extends al.a {
    protected int a;

    /* renamed from: a  reason: collision with other field name */
    protected Context f224a;

    public dt(Context context, int i) {
        this.a = i;
        this.f224a = context;
    }

    public static void a(Context context, hr hrVar) {
        dm m769a = dn.a().m769a();
        String a = m769a == null ? "" : m769a.a();
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(hrVar.a())) {
            return;
        }
        a(context, hrVar, a);
    }

    private static void a(Context context, hr hrVar, String str) {
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        byte[] b = dp.b(str, it.a(hrVar));
        if (b == null || b.length == 0) {
            return;
        }
        synchronized (dq.a) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                    ab.m659a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        FileLock lock = randomAccessFile.getChannel().lock();
                        try {
                            File file2 = new File(context.getExternalFilesDir(null), "push_cdata.data");
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2, true));
                            try {
                                bufferedOutputStream.write(af.a(b.length));
                                bufferedOutputStream.write(b);
                                bufferedOutputStream.flush();
                                file2.setLastModified(0L);
                                if (lock != null && lock.isValid()) {
                                    try {
                                        lock.release();
                                    } catch (IOException unused) {
                                    }
                                }
                                ab.a(bufferedOutputStream);
                            } catch (IOException e) {
                                e = e;
                                fileLock = lock;
                                try {
                                    e.printStackTrace();
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    ab.a(bufferedOutputStream);
                                    ab.a(randomAccessFile);
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException unused3) {
                                        }
                                    }
                                    ab.a(bufferedOutputStream);
                                    ab.a(randomAccessFile);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileLock = lock;
                                if (fileLock != null) {
                                    fileLock.release();
                                }
                                ab.a(bufferedOutputStream);
                                ab.a(randomAccessFile);
                                throw th;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            bufferedOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedOutputStream = null;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bufferedOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = null;
                    }
                } catch (IOException e4) {
                    e = e4;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                }
                ab.a(randomAccessFile);
            } catch (Throwable th6) {
                throw th6;
            }
        }
    }

    private String c() {
        return "dc_job_result_time_" + mo706a();
    }

    private String d() {
        return "dc_job_result_" + mo706a();
    }

    public abstract hl a();

    /* renamed from: a  reason: collision with other method in class */
    protected boolean m771a() {
        return dp.a(this.f224a, String.valueOf(mo706a()), this.a);
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    protected boolean m772b() {
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    protected boolean m773c() {
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        String b = b();
        if (TextUtils.isEmpty(b)) {
            return;
        }
        if (m771a()) {
            com.xiaomi.channel.commonutils.logger.b.m586a("DC run job mutual: " + mo706a());
            return;
        }
        dm m769a = dn.a().m769a();
        String a = m769a == null ? "" : m769a.a();
        if (!TextUtils.isEmpty(a) && m772b()) {
            if (m773c()) {
                SharedPreferences sharedPreferences = this.f224a.getSharedPreferences("mipush_extra", 0);
                if (bp.a(b).equals(sharedPreferences.getString(d(), null))) {
                    long j = sharedPreferences.getLong(c(), 0L);
                    int a2 = com.xiaomi.push.service.ba.a(this.f224a).a(ho.DCJobUploadRepeatedInterval.a(), 604800);
                    if ((System.currentTimeMillis() - j) / 1000 < this.a) {
                        return;
                    }
                    if ((System.currentTimeMillis() - j) / 1000 < a2) {
                        b = "same_" + j;
                    }
                }
            }
            hr hrVar = new hr();
            hrVar.a(b);
            hrVar.a(System.currentTimeMillis());
            hrVar.a(a());
            a(this.f224a, hrVar, a);
        }
    }
}
