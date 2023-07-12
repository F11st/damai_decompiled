package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.slide.compare.ICompare;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class da1 {
    private String a;
    private String b;
    private ICompare c;
    private boolean d = false;

    public da1(@NonNull String str, @Nullable String str2, @NonNull ICompare iCompare) {
        au1.c(str, "key is empty");
        au1.e(iCompare, "compare is null");
        this.a = str;
        this.b = str2;
        this.c = iCompare;
    }

    public ICompare a() {
        return this.c;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public boolean d() {
        return this.d;
    }

    public da1 e(boolean z) {
        this.d = z;
        return this;
    }

    public String toString() {
        return String.format("%s='%s' type:'%s'", this.a, this.b, this.c.getClass().getSimpleName());
    }
}
