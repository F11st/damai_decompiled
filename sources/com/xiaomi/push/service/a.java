package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a {
    private static volatile a a;

    /* renamed from: a  reason: collision with other field name */
    private Context f865a;
    private volatile String e;
    private volatile String f;

    /* renamed from: a  reason: collision with other field name */
    private final Object f866a = new Object();
    private final Object b = new Object();

    /* renamed from: a  reason: collision with other field name */
    private final String f867a = "mipush_region";

    /* renamed from: b  reason: collision with other field name */
    private final String f868b = "mipush_country_code";
    private final String c = "mipush_region.lock";
    private final String d = "mipush_country_code.lock";

    public a(Context context) {
        this.f865a = context;
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    private String a(Context context, String str, String str2, Object obj) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        File file = new File(context.getFilesDir(), str);
        FileLock fileLock2 = null;
        if (!file.exists()) {
            com.xiaomi.channel.commonutils.logger.b.m586a("No ready file to get data from " + str);
            return null;
        }
        synchronized (obj) {
            try {
                File file2 = new File(context.getFilesDir(), str2);
                com.xiaomi.push.ab.m659a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                } catch (Exception e) {
                    e = e;
                    fileLock = null;
                } catch (Throwable th) {
                    th = th;
                    if (fileLock2 != null) {
                        try {
                            fileLock2.release();
                        } catch (IOException e2) {
                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                        }
                    }
                    com.xiaomi.push.ab.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                randomAccessFile = null;
                fileLock = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
            }
            try {
                try {
                    String a2 = com.xiaomi.push.ab.a(file);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                        }
                    }
                    com.xiaomi.push.ab.a(randomAccessFile);
                    return a2;
                } catch (Throwable th3) {
                    th = th3;
                    fileLock2 = fileLock;
                    if (fileLock2 != null && fileLock2.isValid()) {
                        fileLock2.release();
                    }
                    com.xiaomi.push.ab.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e6) {
                        com.xiaomi.channel.commonutils.logger.b.a(e6);
                    }
                }
                com.xiaomi.push.ab.a(randomAccessFile);
                return null;
            }
        }
    }

    private void a(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        synchronized (obj) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(context.getFilesDir(), str3);
                    com.xiaomi.push.ab.m659a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (Exception e) {
                    e = e;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = null;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e2) {
                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                        }
                    }
                    com.xiaomi.push.ab.a(randomAccessFile);
                    throw th;
                }
                try {
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        com.xiaomi.push.ab.a(new File(context.getFilesDir(), str2), str);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e3) {
                                com.xiaomi.channel.commonutils.logger.b.a(e3);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileLock != null && fileLock.isValid()) {
                            fileLock.release();
                        }
                        com.xiaomi.push.ab.a(randomAccessFile);
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                            com.xiaomi.channel.commonutils.logger.b.a(e5);
                        }
                    }
                    com.xiaomi.push.ab.a(randomAccessFile);
                }
                com.xiaomi.push.ab.a(randomAccessFile);
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = a(this.f865a, "mipush_region", "mipush_region.lock", this.f866a);
        }
        return this.e;
    }

    public void a(String str) {
        if (TextUtils.equals(str, this.e)) {
            return;
        }
        this.e = str;
        a(this.f865a, this.e, "mipush_region", "mipush_region.lock", this.f866a);
    }

    public String b() {
        if (TextUtils.isEmpty(this.f)) {
            this.f = a(this.f865a, "mipush_country_code", "mipush_country_code.lock", this.b);
        }
        return this.f;
    }

    public void b(String str) {
        if (TextUtils.equals(str, this.f)) {
            return;
        }
        this.f = str;
        a(this.f865a, this.f, "mipush_country_code", "mipush_country_code.lock", this.b);
    }
}
