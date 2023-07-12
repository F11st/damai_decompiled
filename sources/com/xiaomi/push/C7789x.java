package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.x */
/* loaded from: classes11.dex */
public final class C7789x {
    private static final Set<String> a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    private Context f1006a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f1007a;

    /* renamed from: a  reason: collision with other field name */
    private String f1008a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f1009a;

    private C7789x(Context context) {
        this.f1006a = context;
    }

    public static C7789x a(Context context, File file) {
        AbstractC7535b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        Set<String> set = a;
        if (set.add(str)) {
            C7789x c7789x = new C7789x(context);
            c7789x.f1008a = str;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                c7789x.f1007a = randomAccessFile;
                c7789x.f1009a = randomAccessFile.getChannel().lock();
                AbstractC7535b.c("Locked: " + str + " :" + c7789x.f1009a);
                if (c7789x.f1009a == null) {
                    RandomAccessFile randomAccessFile2 = c7789x.f1007a;
                    if (randomAccessFile2 != null) {
                        C7594ab.a(randomAccessFile2);
                    }
                    set.remove(c7789x.f1008a);
                }
                return c7789x;
            } catch (Throwable th) {
                if (c7789x.f1009a == null) {
                    RandomAccessFile randomAccessFile3 = c7789x.f1007a;
                    if (randomAccessFile3 != null) {
                        C7594ab.a(randomAccessFile3);
                    }
                    a.remove(c7789x.f1008a);
                }
                throw th;
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        AbstractC7535b.c("unLock: " + this.f1009a);
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
            C7594ab.a(randomAccessFile);
        }
        a.remove(this.f1008a);
    }
}
