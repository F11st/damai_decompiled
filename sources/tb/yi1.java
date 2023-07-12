package tb;

import android.util.Pair;
import android.view.ViewGroup;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class yi1 implements IViewHolderProvider {
    private ay2 a;
    private int b = 0;
    private Map<String, Pair<IViewHolderCreator, Integer>> c = new HashMap();
    private Map<Integer, String> d = new HashMap();

    public yi1(ay2 ay2Var) {
        this.a = ay2Var;
    }

    private RecyclerViewHolder a(ViewGroup viewGroup, String str) {
        if (str == null) {
            return new RecyclerViewHolder(ny2.a(this.a.l()), null);
        }
        j1 create = ((IViewHolderCreator) this.c.get(str).first).create(this.a);
        create.b(viewGroup);
        return new RecyclerViewHolder(create.c(), create);
    }

    public void b(String str, IViewHolderCreator iViewHolderCreator) {
        int intValue;
        if (!this.c.containsKey(str)) {
            intValue = this.b;
            this.b = intValue + 1;
            this.c.put(str, new Pair<>(iViewHolderCreator, Integer.valueOf(intValue)));
        } else {
            intValue = ((Integer) this.c.get(str).second).intValue();
        }
        this.d.put(Integer.valueOf(intValue), str);
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public void bindData(RecyclerViewHolder recyclerViewHolder, IDMComponent iDMComponent) {
        j1 c = recyclerViewHolder.c();
        if (c != null) {
            c.a(iDMComponent);
        }
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public RecyclerViewHolder createViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, this.d.get(Integer.valueOf(i)));
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public void destroy() {
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public int getItemViewType(IDMComponent iDMComponent) {
        if (this.c.containsKey(iDMComponent.getType())) {
            return ((Integer) this.c.get(iDMComponent.getType()).second).intValue();
        }
        return -1;
    }
}
