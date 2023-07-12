package tb;

import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import androidx.annotation.CallSuper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class gs0 extends Drawable {
    @NotNull
    private final Path a;
    private float b;
    private int c;
    private boolean d;

    public gs0(@NotNull Path path) {
        b41.i(path, "shadowPath");
        this.a = path;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Path c() {
        return this.a;
    }

    public void d() {
    }

    public abstract void e(float f, int i, boolean z);

    @CallSuper
    public void f(float f) {
        this.b = f;
        e(f, this.c, this.d);
    }

    @CallSuper
    public void g(int i) {
        this.c = i;
        e(this.b, i, this.d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @CallSuper
    public void h(boolean z) {
        this.d = z;
        e(this.b, this.c, z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
