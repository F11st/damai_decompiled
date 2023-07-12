package tb;

import android.content.Context;
import androidx.annotation.NonNull;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.alibaba.android.bindingx.core.internal.AbstractC3210a;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ic extends AbstractC3210a implements PlatformManager.ScrollListener {
    private int q;
    private int r;
    private int s;
    private int t;

    public ic(Context context, PlatformManager platformManager, Object... objArr) {
        super(context, platformManager, objArr);
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
    }

    private boolean l(int i, int i2) {
        if (i == i2) {
            return true;
        }
        if (i <= 0 || i2 <= 0) {
            return i < 0 && i2 < 0;
        }
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityPause() {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityResume() {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onCreate(@NonNull String str, @NonNull String str2) {
        PlatformManager.IScrollFactory f = this.h.f();
        if (f == null) {
            return false;
        }
        f.addScrollListenerWith(str, this);
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractC3210a, com.alibaba.android.bindingx.core.IEventHandler
    public boolean onDisable(@NonNull String str, @NonNull String str2) {
        PlatformManager.IScrollFactory f = this.h.f();
        if (f == null) {
            return false;
        }
        f.removeScrollListenerWith(str, this);
        return super.onDisable(str, str2);
    }

    @Override // com.alibaba.android.bindingx.core.PlatformManager.ScrollListener
    public void onScrollEnd(float f, float f2) {
        super.i("scrollEnd", f, f2, 0.0d, 0.0d, 0.0d, 0.0d, new Object[0]);
    }

    @Override // com.alibaba.android.bindingx.core.PlatformManager.ScrollListener
    public void onScrollStart() {
        super.i("scrollStart", 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, new Object[0]);
    }

    @Override // com.alibaba.android.bindingx.core.PlatformManager.ScrollListener
    public void onScrolled(float f, float f2) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = (int) (f - this.n);
        int i6 = (int) (f2 - this.o);
        this.n = (int) f;
        this.o = (int) f2;
        if (i5 == 0 && i6 == 0) {
            return;
        }
        boolean z2 = true;
        if (l(i6, this.t)) {
            z = false;
        } else {
            this.r = this.o;
            z = true;
        }
        if (l(i5, this.s)) {
            z2 = z;
        } else {
            this.q = this.n;
        }
        int i7 = this.n;
        int i8 = i7 - this.q;
        int i9 = this.o;
        int i10 = i9 - this.r;
        this.s = i5;
        this.t = i6;
        if (z2) {
            i2 = i6;
            i4 = i5;
            i = i10;
            i3 = i8;
            super.i("turn", i7, i9, i5, i6, i8, i10, new Object[0]);
        } else {
            i = i10;
            i2 = i6;
            i3 = i8;
            i4 = i5;
        }
        super.j(this.n, this.o, i4, i2, i3, i);
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onStart(@NonNull String str, @NonNull String str2) {
    }
}
