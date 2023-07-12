package tb;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import com.alibaba.android.ultron.vfw.R$id;
import com.alibaba.android.ultron.vfw.downgrade.IDowngradeSupport;
import com.alibaba.android.ultron.vfw.event.ComponentLifecycleCallback;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class cy2 {
    public static final int EMPTY_VIEW_TYPE = -1;
    private yi1 d;
    private ay2 e;
    private ComponentLifecycleCallback g;
    private HashMap<String, IViewHolderProvider> a = new HashMap<>();
    private Map<IViewHolderProvider, Set<Integer>> b = new HashMap();
    private Map<IViewHolderProvider, Integer> c = new HashMap();
    private Set<Integer> f = new HashSet();

    public cy2(ay2 ay2Var) {
        this.e = ay2Var;
        h();
    }

    private Boolean e(IDMComponent iDMComponent) {
        ArrayMap<String, Object> extMap = iDMComponent.getExtMap();
        if (extMap == null) {
            return Boolean.FALSE;
        }
        Object obj = extMap.get(IDowngradeSupport.KEY_DOWNGRADE_STATE);
        if (obj != null && (obj instanceof Boolean)) {
            return (Boolean) obj;
        }
        return Boolean.FALSE;
    }

    private IViewHolderProvider g(int i) {
        for (IViewHolderProvider iViewHolderProvider : this.b.keySet()) {
            if (this.b.get(iViewHolderProvider).contains(Integer.valueOf(i))) {
                return iViewHolderProvider;
            }
        }
        return null;
    }

    private void h() {
        a(r10.DB_NAME, new n90(this.e));
        yi1 yi1Var = new yi1(this.e);
        this.d = yi1Var;
        a("native", yi1Var);
        IViewHolderProvider j13Var = new j13(this.e);
        a("weex", j13Var);
        a("h5", j13Var);
    }

    private void j(IViewHolderProvider iViewHolderProvider, int i) {
        Set<Integer> set = this.b.get(iViewHolderProvider);
        if (set == null) {
            HashSet hashSet = new HashSet();
            hashSet.add(Integer.valueOf(i));
            this.b.put(iViewHolderProvider, hashSet);
            return;
        }
        set.add(Integer.valueOf(i));
    }

    public void a(String str, IViewHolderProvider iViewHolderProvider) {
        this.a.put(str, iViewHolderProvider);
        Map<IViewHolderProvider, Integer> map = this.c;
        map.put(iViewHolderProvider, Integer.valueOf(map.size() * 1000));
    }

    public void b(RecyclerViewHolder recyclerViewHolder, IDMComponent iDMComponent) {
        if (iDMComponent == null) {
            return;
        }
        if (iDMComponent.getStatus() == 0) {
            recyclerViewHolder.itemView.setVisibility(8);
            View view = recyclerViewHolder.itemView;
            int i = R$id.view_holder_origin_height;
            if (view.getTag(i) == null) {
                if (recyclerViewHolder.itemView.getLayoutParams() != null) {
                    View view2 = recyclerViewHolder.itemView;
                    view2.setTag(i, Integer.valueOf(view2.getLayoutParams().height));
                } else {
                    recyclerViewHolder.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    recyclerViewHolder.itemView.setTag(i, -2);
                }
            }
            recyclerViewHolder.itemView.getLayoutParams().height = 0;
            return;
        }
        recyclerViewHolder.itemView.setVisibility(0);
        Object tag = recyclerViewHolder.itemView.getTag(R$id.view_holder_origin_height);
        if (recyclerViewHolder.itemView.getLayoutParams() != null && (tag instanceof Integer)) {
            recyclerViewHolder.itemView.getLayoutParams().height = ((Integer) tag).intValue();
        }
        if (e(iDMComponent).booleanValue()) {
            this.d.bindData(recyclerViewHolder, iDMComponent);
        } else {
            IViewHolderProvider iViewHolderProvider = this.a.get(iDMComponent.getContainerType());
            if (iViewHolderProvider != null) {
                iViewHolderProvider.bindData(recyclerViewHolder, iDMComponent);
            }
        }
        ComponentLifecycleCallback componentLifecycleCallback = this.g;
        if (componentLifecycleCallback != null) {
            componentLifecycleCallback.onBindData(recyclerViewHolder, iDMComponent, null);
        }
    }

    public RecyclerViewHolder c(ViewGroup viewGroup, int i) {
        DXTemplateItem f;
        DXTemplateItem f2;
        IDowngradeSupport iDowngradeSupport = (IDowngradeSupport) this.e.getService(IDowngradeSupport.class);
        IViewHolderProvider g = g(i);
        int intValue = i - this.c.get(g).intValue();
        if (g != null) {
            if (this.f.contains(Integer.valueOf(i)) && iDowngradeSupport != null && (f2 = ((n90) g).f(intValue)) != null) {
                return iDowngradeSupport.downgradeViewHolder(viewGroup, tl2.b(f2));
            }
            RecyclerViewHolder createViewHolder = g.createViewHolder(viewGroup, intValue);
            if (createViewHolder.b()) {
                this.f.add(Integer.valueOf(i));
                if (iDowngradeSupport != null && (f = ((n90) g).f(intValue)) != null) {
                    return iDowngradeSupport.downgradeViewHolder(viewGroup, tl2.b(f));
                }
            }
            return createViewHolder;
        }
        View a = ny2.a(this.e.l());
        ComponentLifecycleCallback componentLifecycleCallback = this.g;
        if (componentLifecycleCallback != null) {
            componentLifecycleCallback.onCreateViewHolder(viewGroup, i, null);
        }
        return new RecyclerViewHolder(a);
    }

    public void d() {
        HashMap<String, IViewHolderProvider> hashMap = this.a;
        if (hashMap == null) {
            return;
        }
        for (IViewHolderProvider iViewHolderProvider : hashMap.values()) {
            if (iViewHolderProvider != null) {
                iViewHolderProvider.destroy();
            }
        }
    }

    public int f(IDMComponent iDMComponent) {
        if (iDMComponent == null || TextUtils.isEmpty(iDMComponent.getType()) || TextUtils.isEmpty(iDMComponent.getContainerType())) {
            return -1;
        }
        IViewHolderProvider iViewHolderProvider = this.a.get(iDMComponent.getContainerType());
        if (iViewHolderProvider == null) {
            return -1;
        }
        int itemViewType = iViewHolderProvider.getItemViewType(iDMComponent) + this.c.get(iViewHolderProvider).intValue();
        j(iViewHolderProvider, itemViewType);
        return itemViewType;
    }

    public void i(String str, IViewHolderCreator iViewHolderCreator) {
        this.d.b(str, iViewHolderCreator);
    }

    public void k(ComponentLifecycleCallback componentLifecycleCallback) {
        this.g = componentLifecycleCallback;
    }
}
