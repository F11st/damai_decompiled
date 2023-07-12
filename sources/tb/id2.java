package tb;

import android.text.TextUtils;
import java.io.File;
import java.net.URL;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class id2 {
    public boolean a;
    public int b;
    public String c;
    public String d;
    public l41 e;
    public jq1 f;
    public String g;
    public a h = new a(this);

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a {
        private int a;
        private int b;

        public a(id2 id2Var) {
        }

        public void a(boolean z) {
            if (z) {
                this.a++;
            } else {
                this.b++;
            }
        }
    }

    public String a() {
        if (!TextUtils.isEmpty(this.e.d)) {
            return this.e.d;
        }
        try {
            return new File(new URL(this.e.a).getFile()).getName();
        } catch (Throwable unused) {
            return this.e.a;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof id2) {
            id2 id2Var = (id2) obj;
            l41 l41Var = this.e;
            if (l41Var == null ? id2Var.e == null : l41Var.equals(id2Var.e)) {
                String str = this.g;
                String str2 = id2Var.g;
                if (str != null) {
                    if (str.equals(str2)) {
                        return true;
                    }
                } else if (str2 == null) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        l41 l41Var = this.e;
        int hashCode = (l41Var != null ? l41Var.hashCode() : 0) * 31;
        String str = this.g;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return super.toString() + "@Task{success=" + this.a + ", errorCode=" + this.b + ", errorMsg='" + this.c + "', item=" + this.e + ", storeDir='" + this.g + "'}";
    }
}
