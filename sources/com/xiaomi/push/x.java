package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class x {
    private static final Set<String> a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    private Context f1006a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f1007a;

    /* renamed from: a  reason: collision with other field name */
    private String f1008a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f1009a;

    private x(Context context) {
        this.f1006a = context;
    }

    public static x a(Context context, File file) {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        Set<String> set = a;
        if (set.add(str)) {
            x xVar = new x(context);
            xVar.f1008a = str;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                xVar.f1007a = randomAccessFile;
                xVar.f1009a = randomAccessFile.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + xVar.f1009a);
                if (xVar.f1009a == null) {
                    RandomAccessFile randomAccessFile2 = xVar.f1007a;
                    if (randomAccessFile2 != null) {
                        ab.a(randomAccessFile2);
                    }
                    set.remove(xVar.f1008a);
                }
                return xVar;
            } catch (Throwable th) {
                if (xVar.f1009a == null) {
                    RandomAccessFile randomAccessFile3 = xVar.f1007a;
                    if (randomAccessFile3 != null) {
                        ab.a(randomAccessFile3);
                    }
                    a.remove(xVar.f1008a);
                }
                throw th;
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f1009a);
        FileLock fileLock = this.f1009a;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f1009a.release();
            } catch (IOException unused) {
            }
            this.f1009a = null;
        }
        RandomAccessFile randomAccessFile = this.f1007a;
        if (randomAccessFile != null) {
            ab.a(randomAccessFile);
        }
        a.remove(this.f1008a);
    }
}
