package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.al;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class dv extends al.AbstractRunnableC7597a {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f225a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.push.service.ba f226a;

    public dv(Context context) {
        this.a = context;
        this.f225a = context.getSharedPreferences("mipush_extra", 0);
        this.f226a = com.xiaomi.push.service.ba.a(context);
    }

    private List<hr> a(File file) {
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        dm m769a = dn.a().m769a();
        String a = m769a == null ? "" : m769a.a();
        FileLock fileLock = null;
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (dq.a) {
            try {
                File file2 = new File(this.a.getExternalFilesDir(null), "push_cdata.lock");
                C7594ab.m659a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    FileLock lock = randomAccessFile.getChannel().lock();
                    try {
                        fileInputStream = new FileInputStream(file);
                        while (fileInputStream.read(bArr) == 4) {
                            try {
                                int a2 = af.a(bArr);
                                byte[] bArr2 = new byte[a2];
                                if (fileInputStream.read(bArr2) != a2) {
                                    break;
                                }
                                byte[] a3 = C7632dp.a(a, bArr2);
                                if (a3 != null && a3.length != 0) {
                                    hr hrVar = new hr();
                                    it.a(hrVar, a3);
                                    arrayList.add(hrVar);
                                    a(hrVar);
                                }
                            } catch (Exception unused) {
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused2) {
                                    }
                                }
                                C7594ab.a(fileInputStream);
                                C7594ab.a(randomAccessFile);
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                                C7594ab.a(fileInputStream);
                                C7594ab.a(randomAccessFile);
                                throw th;
                            }
                        }
                        if (lock != null && lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException unused4) {
                            }
                        }
                        C7594ab.a(fileInputStream);
                    } catch (Exception unused5) {
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                    }
                } catch (Exception unused6) {
                    fileInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
            } catch (Exception unused7) {
                randomAccessFile = null;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                fileInputStream = null;
            }
            C7594ab.a(randomAccessFile);
        }
        return arrayList;
    }

    private void a() {
        SharedPreferences.Editor edit = this.f225a.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    private void a(hr hrVar) {
        if (hrVar.f488a != hl.AppInstallList || hrVar.f489a.startsWith("same_")) {
            return;
        }
        SharedPreferences.Editor edit = this.f225a.edit();
        edit.putLong("dc_job_result_time_4", hrVar.f487a);
        edit.putString("dc_job_result_4", bp.a(hrVar.f489a));
        edit.commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m774a() {
        if (bj.e(this.a)) {
            return false;
        }
        if ((bj.g(this.a) || bj.f(this.a)) && !c()) {
            return true;
        }
        return (bj.h(this.a) && !b()) || bj.i(this.a);
    }

    private boolean b() {
        if (this.f226a.a(ho.Upload3GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f225a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f226a.a(ho.Upload3GFrequency.a(), 432000)));
        }
        return false;
    }

    private boolean c() {
        if (this.f226a.a(ho.Upload4GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f225a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f226a.a(ho.Upload4GFrequency.a(), 259200)));
        }
        return false;
    }

    @Override // com.xiaomi.push.al.AbstractRunnableC7597a
    /* renamed from: a */
    public String mo706a() {
        return "1";
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.a.getExternalFilesDir(null), "push_cdata.data");
        if (!bj.d(this.a)) {
            if (file.length() > 1863680) {
                file.delete();
            }
        } else if (!m774a() && file.exists()) {
            List<hr> a = a(file);
            if (!ag.a(a)) {
                int size = a.size();
                if (size > 4000) {
                    a = a.subList(size - 4000, size);
                }
                ic icVar = new ic();
                icVar.a(a);
                byte[] a2 = C7594ab.a(it.a(icVar));
                ii iiVar = new ii("-1", false);
                iiVar.c(ht.DataCollection.f497a);
                iiVar.a(a2);
                dm m769a = dn.a().m769a();
                if (m769a != null) {
                    m769a.a(iiVar, hj.Notification, null);
                }
                a();
            }
            file.delete();
        }
    }
}
