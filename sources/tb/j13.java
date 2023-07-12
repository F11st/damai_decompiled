package tb;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class j13 implements IViewHolderProvider {
    private ay2 a;
    private int b = 0;
    private HashMap<String, Integer> c = new HashMap<>();
    private HashMap<Integer, String> d = new HashMap<>();
    private List<WeakReference<com.alibaba.android.ultron.vfw.web.c>> e = new ArrayList();

    public j13(ay2 ay2Var) {
        this.a = ay2Var;
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
        com.alibaba.android.ultron.vfw.web.c cVar = new com.alibaba.android.ultron.vfw.web.c(this.a, this.d.get(Integer.valueOf(i)));
        cVar.b(viewGroup);
        this.e.add(new WeakReference<>(cVar));
        return new RecyclerViewHolder(cVar.c(), cVar);
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public void destroy() {
        List<WeakReference<com.alibaba.android.ultron.vfw.web.c>> list = this.e;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (WeakReference<com.alibaba.android.ultron.vfw.web.c> weakReference : this.e) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().g();
            }
        }
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public int getItemViewType(IDMComponent iDMComponent) {
        if (iDMComponent == null || iDMComponent.getContainerInfo() == null) {
            return -1;
        }
        String string = iDMComponent.getContainerInfo().getString("url");
        if (TextUtils.isEmpty(string)) {
            return -1;
        }
        if (this.c.containsKey(string)) {
            return this.c.get(string).intValue();
        }
        int i = this.b + 1;
        this.b = i;
        this.c.put(string, Integer.valueOf(i));
        this.d.put(Integer.valueOf(this.b), string);
        return this.b;
    }
}
