package tb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.HashMap;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class t42 {
    @NotNull
    private HashMap<String, Boolean> a = new HashMap<>();
    @NotNull
    private HashMap<String, Bitmap> b = new HashMap<>();
    @NotNull
    private HashMap<String, String> c = new HashMap<>();
    @NotNull
    private HashMap<String, TextPaint> d = new HashMap<>();
    @NotNull
    private HashMap<String, StaticLayout> e = new HashMap<>();
    @NotNull
    private HashMap<String, Function2<Canvas, Integer, Boolean>> f = new HashMap<>();
    private boolean g;

    @NotNull
    public final HashMap<String, Function2<Canvas, Integer, Boolean>> a() {
        return this.f;
    }

    @NotNull
    public final HashMap<String, Boolean> b() {
        return this.a;
    }

    @NotNull
    public final HashMap<String, Bitmap> c() {
        return this.b;
    }

    @NotNull
    public final HashMap<String, StaticLayout> d() {
        return this.e;
    }

    @NotNull
    public final HashMap<String, String> e() {
        return this.c;
    }

    @NotNull
    public final HashMap<String, TextPaint> f() {
        return this.d;
    }

    public final boolean g() {
        return this.g;
    }

    public final void h(@NotNull Bitmap bitmap, @NotNull String str) {
        b41.j(bitmap, "bitmap");
        b41.j(str, "forKey");
        this.b.put(str, bitmap);
    }

    public final void i(boolean z) {
        this.g = z;
    }
}
