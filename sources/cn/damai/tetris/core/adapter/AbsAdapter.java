package cn.damai.tetris.core.adapter;

import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.core.holder.BaseViewHolder;
import cn.damai.tetris.core.holder.IViewHolderFactory;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class AbsAdapter<A extends BaseViewHolder, T> extends RecyclerView.Adapter<A> {
    private static transient /* synthetic */ IpChange $ipChange;
    protected ja a;
    protected IViewHolderFactory b;

    public AbsAdapter(ja jaVar, IViewHolderFactory iViewHolderFactory) {
        this.a = jaVar;
        this.b = iViewHolderFactory;
    }

    public abstract void a(T t);

    public abstract void b(T t);

    public abstract void c(RecyclerView.Adapter<A> adapter);
}
