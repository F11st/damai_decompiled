package tb;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class jc1 {
    private final int a;
    private final int b;
    private final String c;
    private final String d;
    @Nullable
    private Bitmap e;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public jc1(int i, int i2, String str, String str2, String str3) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
    }

    @Nullable
    public Bitmap a() {
        return this.e;
    }

    public String b() {
        return this.d;
    }

    public int c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public int e() {
        return this.a;
    }

    public void f(@Nullable Bitmap bitmap) {
        this.e = bitmap;
    }
}
