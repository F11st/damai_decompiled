package tb;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class jl {
    private final DataSetObservable a = new DataSetObservable();

    public abstract int a();

    public abstract IPagerIndicator b(Context context);

    public abstract IPagerTitleView c(Context context, int i);

    public float d(Context context, int i) {
        return 1.0f;
    }

    public final void e() {
        this.a.notifyChanged();
    }

    public final void f(DataSetObserver dataSetObserver) {
        this.a.registerObserver(dataSetObserver);
    }

    public final void g(DataSetObserver dataSetObserver) {
        this.a.unregisterObserver(dataSetObserver);
    }
}
