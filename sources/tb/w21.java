package tb;

import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class w21 {
    public C9613qq a;
    public id2 b;
    public URL c;
    public File d;
    public File e;

    public w21(id2 id2Var) {
        this.b = id2Var;
        this.a = new C9613qq(id2Var);
    }

    public int a() {
        long j = this.b.e.b;
        if (0 == j || j == this.d.length()) {
            return !td1.c(this.b.e.c, this.d.getAbsolutePath()) ? -15 : -14;
        }
        return -18;
    }

    public long b() {
        if (this.d.exists()) {
            long length = this.d.length();
            long j = this.b.e.b;
            if (0 == j || length < j) {
                return length;
            }
            this.d.delete();
            return 0L;
        }
        return 0L;
    }

    public RandomAccessFile c() throws FileNotFoundException {
        return new RandomAccessFile(this.d, "rw");
    }

    public boolean d() {
        if (this.e.exists()) {
            long j = this.b.e.b;
            if ((0 == j || j == this.e.length()) && td1.c(this.b.e.c, this.e.getAbsolutePath())) {
                return true;
            }
        }
        return false;
    }

    public boolean e() {
        l41 l41Var = this.b.e;
        if (!(0 == l41Var.b && TextUtils.isEmpty(l41Var.c)) && this.d.exists()) {
            long j = this.b.e.b;
            return (0 == j || j == this.d.length()) && td1.c(this.b.e.c, this.d.getAbsolutePath());
        }
        return false;
    }

    public boolean f(long j, int i) {
        if (200 == i || 206 == i) {
            if (j > 0) {
                if (206 == i) {
                    j += this.d.length();
                } else if (200 != i) {
                    j = 0;
                }
                if (j != 0) {
                    long j2 = this.b.e.b;
                    if (j2 != 0 && j != j2) {
                        return false;
                    }
                }
                l41 l41Var = this.b.e;
                if (0 == l41Var.b) {
                    l41Var.b = j;
                    return true;
                }
                return true;
            }
            return true;
        }
        return false;
    }

    public void g() throws MalformedURLException {
        if (this.c == null) {
            this.c = new URL(this.b.e.a);
            this.e = new File(this.b.g, TextUtils.isEmpty(this.b.e.d) ? new File(this.c.getFile()).getName() : this.b.e.d);
            id2 id2Var = this.b;
            File file = new File(id2Var.g, td1.b(id2Var.e.a));
            this.d = file;
            if (!file.getParentFile().exists()) {
                this.d.getParentFile().mkdirs();
            }
            if (!this.d.getParentFile().canWrite()) {
                this.d.getParentFile().setWritable(true);
            }
            id2 id2Var2 = this.b;
            if (id2Var2.f.m || !TextUtils.isEmpty(id2Var2.e.c)) {
                return;
            }
            this.e.delete();
            this.d.delete();
        }
    }
}
