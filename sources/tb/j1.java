package tb;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.ultron.common.model.IDMComponent;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class j1 {
    protected ay2 a;
    protected View b;

    public j1(ay2 ay2Var) {
        this.a = ay2Var;
    }

    public final void a(IDMComponent iDMComponent) {
        d(iDMComponent);
    }

    public final View b(@Nullable ViewGroup viewGroup) {
        View e = e(viewGroup);
        this.b = e;
        return e;
    }

    public final View c() {
        return this.b;
    }

    protected abstract void d(@NonNull IDMComponent iDMComponent);

    protected abstract View e(@Nullable ViewGroup viewGroup);
}
