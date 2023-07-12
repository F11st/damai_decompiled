package com.alibaba.android.vlayout;

import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.layout.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tb.hg;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class DelegateAdapter extends VirtualLayoutAdapter<RecyclerView.ViewHolder> {
    private long[] cantorReverse;
    @NonNull
    private final List<Pair<AdapterDataObserver, Adapter>> mAdapters;
    private final boolean mHasConsistItemType;
    private int mIndex;
    private final SparseArray<Pair<AdapterDataObserver, Adapter>> mIndexAry;
    @Nullable
    private AtomicInteger mIndexGen;
    private SparseArray<Adapter> mItemTypeAry;
    private int mTotal;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static abstract class Adapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
        protected void onBindViewHolderWithOffset(VH vh, int i, int i2) {
        }

        protected void onBindViewHolderWithOffset(VH vh, int i, int i2, List<Object> list) {
            onBindViewHolderWithOffset(vh, i, i2);
        }

        public abstract com.alibaba.android.vlayout.a onCreateLayoutHelper();
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public DelegateAdapter(VirtualLayoutManager virtualLayoutManager) {
        this(virtualLayoutManager, false, false);
    }

    public static Adapter<? extends RecyclerView.ViewHolder> simpleAdapter(@NonNull View view) {
        return new a(view);
    }

    public void addAdapter(int i, @Nullable Adapter adapter) {
        addAdapters(i, Collections.singletonList(adapter));
    }

    public void addAdapters(int i, @Nullable List<Adapter> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (i < 0) {
            i = 0;
        }
        if (i > this.mAdapters.size()) {
            i = this.mAdapters.size();
        }
        ArrayList arrayList = new ArrayList();
        for (Pair<AdapterDataObserver, Adapter> pair : this.mAdapters) {
            arrayList.add((Adapter) pair.second);
        }
        for (Adapter adapter : list) {
            arrayList.add(i, adapter);
            i++;
        }
        setAdapters(arrayList);
    }

    public void clear() {
        this.mTotal = 0;
        this.mIndex = 0;
        AtomicInteger atomicInteger = this.mIndexGen;
        if (atomicInteger != null) {
            atomicInteger.set(0);
        }
        this.mLayoutManager.setLayoutHelpers(null);
        for (Pair<AdapterDataObserver, Adapter> pair : this.mAdapters) {
            ((Adapter) pair.second).unregisterAdapterDataObserver((RecyclerView.AdapterDataObserver) pair.first);
        }
        this.mItemTypeAry.clear();
        this.mAdapters.clear();
        this.mIndexAry.clear();
    }

    public Adapter findAdapterByIndex(int i) {
        return (Adapter) this.mIndexAry.get(i).second;
    }

    @Nullable
    public Pair<AdapterDataObserver, Adapter> findAdapterByPosition(int i) {
        int size = this.mAdapters.size();
        if (size == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = size - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) / 2;
            Pair<AdapterDataObserver, Adapter> pair = this.mAdapters.get(i4);
            int itemCount = (((AdapterDataObserver) pair.first).a + ((Adapter) pair.second).getItemCount()) - 1;
            Object obj = pair.first;
            if (((AdapterDataObserver) obj).a > i) {
                i3 = i4 - 1;
            } else if (itemCount < i) {
                i2 = i4 + 1;
            } else if (((AdapterDataObserver) obj).a <= i && itemCount >= i) {
                return pair;
            }
        }
        return null;
    }

    public int findAdapterPositionByIndex(int i) {
        Pair<AdapterDataObserver, Adapter> pair = this.mIndexAry.get(i);
        if (pair == null) {
            return -1;
        }
        return this.mAdapters.indexOf(pair);
    }

    public int findOffsetPosition(int i) {
        Pair<AdapterDataObserver, Adapter> findAdapterByPosition = findAdapterByPosition(i);
        if (findAdapterByPosition == null) {
            return -1;
        }
        return i - ((AdapterDataObserver) findAdapterByPosition.first).a;
    }

    public int getAdaptersCount() {
        List<Pair<AdapterDataObserver, Adapter>> list = this.mAdapters;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mTotal;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        Pair<AdapterDataObserver, Adapter> findAdapterByPosition = findAdapterByPosition(i);
        if (findAdapterByPosition == null) {
            return -1L;
        }
        long itemId = ((Adapter) findAdapterByPosition.second).getItemId(i - ((AdapterDataObserver) findAdapterByPosition.first).a);
        if (itemId < 0) {
            return -1L;
        }
        return hg.a(((AdapterDataObserver) findAdapterByPosition.first).b, itemId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        Pair<AdapterDataObserver, Adapter> findAdapterByPosition = findAdapterByPosition(i);
        if (findAdapterByPosition == null) {
            return -1;
        }
        int itemViewType = ((Adapter) findAdapterByPosition.second).getItemViewType(i - ((AdapterDataObserver) findAdapterByPosition.first).a);
        if (itemViewType < 0) {
            return itemViewType;
        }
        if (this.mHasConsistItemType) {
            this.mItemTypeAry.put(itemViewType, findAdapterByPosition.second);
            return itemViewType;
        }
        return (int) hg.a(itemViewType, ((AdapterDataObserver) findAdapterByPosition.first).b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Pair<AdapterDataObserver, Adapter> findAdapterByPosition = findAdapterByPosition(i);
        if (findAdapterByPosition == null) {
            return;
        }
        ((Adapter) findAdapterByPosition.second).onBindViewHolder(viewHolder, i - ((AdapterDataObserver) findAdapterByPosition.first).a);
        ((Adapter) findAdapterByPosition.second).onBindViewHolderWithOffset(viewHolder, i - ((AdapterDataObserver) findAdapterByPosition.first).a, i);
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder] */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.mHasConsistItemType) {
            Adapter adapter = this.mItemTypeAry.get(i);
            if (adapter != null) {
                return adapter.onCreateViewHolder(viewGroup, i);
            }
            return null;
        }
        hg.b(i, this.cantorReverse);
        long[] jArr = this.cantorReverse;
        int i2 = (int) jArr[1];
        int i3 = (int) jArr[0];
        Adapter findAdapterByIndex = findAdapterByIndex(i2);
        if (findAdapterByIndex == null) {
            return null;
        }
        return findAdapterByIndex.onCreateViewHolder(viewGroup, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        Pair<AdapterDataObserver, Adapter> findAdapterByPosition;
        super.onViewAttachedToWindow(viewHolder);
        int position = viewHolder.getPosition();
        if (position < 0 || (findAdapterByPosition = findAdapterByPosition(position)) == null) {
            return;
        }
        ((Adapter) findAdapterByPosition.second).onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        Pair<AdapterDataObserver, Adapter> findAdapterByPosition;
        super.onViewDetachedFromWindow(viewHolder);
        int position = viewHolder.getPosition();
        if (position < 0 || (findAdapterByPosition = findAdapterByPosition(position)) == null) {
            return;
        }
        ((Adapter) findAdapterByPosition.second).onViewDetachedFromWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        Pair<AdapterDataObserver, Adapter> findAdapterByPosition;
        super.onViewRecycled(viewHolder);
        int position = viewHolder.getPosition();
        if (position < 0 || (findAdapterByPosition = findAdapterByPosition(position)) == null) {
            return;
        }
        ((Adapter) findAdapterByPosition.second).onViewRecycled(viewHolder);
    }

    public void removeAdapter(int i) {
        if (i < 0 || i >= this.mAdapters.size()) {
            return;
        }
        removeAdapter((Adapter) this.mAdapters.get(i).second);
    }

    public void removeAdapters(@Nullable List<Adapter> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        LinkedList linkedList = new LinkedList(super.getLayoutHelpers());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Adapter adapter = list.get(i);
            Iterator<Pair<AdapterDataObserver, Adapter>> it = this.mAdapters.iterator();
            while (true) {
                if (it.hasNext()) {
                    Pair<AdapterDataObserver, Adapter> next = it.next();
                    Adapter adapter2 = (Adapter) next.second;
                    if (adapter2.equals(adapter)) {
                        adapter2.unregisterAdapterDataObserver((RecyclerView.AdapterDataObserver) next.first);
                        int findAdapterPositionByIndex = findAdapterPositionByIndex(((AdapterDataObserver) next.first).b);
                        if (findAdapterPositionByIndex >= 0 && findAdapterPositionByIndex < linkedList.size()) {
                            linkedList.remove(findAdapterPositionByIndex);
                        }
                        it.remove();
                    }
                }
            }
        }
        List<Adapter> arrayList = new ArrayList<>();
        for (Pair<AdapterDataObserver, Adapter> pair : this.mAdapters) {
            arrayList.add(pair.second);
        }
        setAdapters(arrayList);
    }

    public void removeFirstAdapter() {
        List<Pair<AdapterDataObserver, Adapter>> list = this.mAdapters;
        if (list == null || list.isEmpty()) {
            return;
        }
        removeAdapter((Adapter) this.mAdapters.get(0).second);
    }

    public void removeLastAdapter() {
        List<Pair<AdapterDataObserver, Adapter>> list = this.mAdapters;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<Pair<AdapterDataObserver, Adapter>> list2 = this.mAdapters;
        removeAdapter((Adapter) list2.get(list2.size() - 1).second);
    }

    public void setAdapters(@Nullable List<Adapter> list) {
        int incrementAndGet;
        clear();
        if (list == null) {
            list = Collections.emptyList();
        }
        LinkedList linkedList = new LinkedList();
        this.mTotal = 0;
        boolean z = true;
        for (Adapter adapter : list) {
            int i = this.mTotal;
            AtomicInteger atomicInteger = this.mIndexGen;
            if (atomicInteger == null) {
                incrementAndGet = this.mIndex;
                this.mIndex = incrementAndGet + 1;
            } else {
                incrementAndGet = atomicInteger.incrementAndGet();
            }
            AdapterDataObserver adapterDataObserver = new AdapterDataObserver(i, incrementAndGet);
            adapter.registerAdapterDataObserver(adapterDataObserver);
            z = z && adapter.hasStableIds();
            com.alibaba.android.vlayout.a onCreateLayoutHelper = adapter.onCreateLayoutHelper();
            onCreateLayoutHelper.setItemCount(adapter.getItemCount());
            this.mTotal += onCreateLayoutHelper.getItemCount();
            linkedList.add(onCreateLayoutHelper);
            Pair<AdapterDataObserver, Adapter> create = Pair.create(adapterDataObserver, adapter);
            this.mIndexAry.put(adapterDataObserver.b, create);
            this.mAdapters.add(create);
        }
        if (!hasObservers()) {
            super.setHasStableIds(z);
        }
        super.setLayoutHelpers(linkedList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
    }

    @Override // com.alibaba.android.vlayout.VirtualLayoutAdapter
    @Deprecated
    public void setLayoutHelpers(List<com.alibaba.android.vlayout.a> list) {
        throw new UnsupportedOperationException("DelegateAdapter doesn't support setLayoutHelpers directly");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class AdapterDataObserver extends RecyclerView.AdapterDataObserver {
        int a;
        int b;

        public AdapterDataObserver(int i, int i2) {
            this.b = -1;
            this.a = i;
            this.b = i2;
        }

        private boolean a() {
            int findAdapterPositionByIndex;
            int i = this.b;
            if (i >= 0 && (findAdapterPositionByIndex = DelegateAdapter.this.findAdapterPositionByIndex(i)) >= 0) {
                Pair pair = (Pair) DelegateAdapter.this.mAdapters.get(findAdapterPositionByIndex);
                LinkedList linkedList = new LinkedList(DelegateAdapter.this.getLayoutHelpers());
                com.alibaba.android.vlayout.a aVar = (com.alibaba.android.vlayout.a) linkedList.get(findAdapterPositionByIndex);
                if (aVar.getItemCount() != ((Adapter) pair.second).getItemCount()) {
                    aVar.setItemCount(((Adapter) pair.second).getItemCount());
                    DelegateAdapter.this.mTotal = this.a + ((Adapter) pair.second).getItemCount();
                    for (int i2 = findAdapterPositionByIndex + 1; i2 < DelegateAdapter.this.mAdapters.size(); i2++) {
                        Pair pair2 = (Pair) DelegateAdapter.this.mAdapters.get(i2);
                        ((AdapterDataObserver) pair2.first).a = DelegateAdapter.this.mTotal;
                        DelegateAdapter.this.mTotal += ((Adapter) pair2.second).getItemCount();
                    }
                    DelegateAdapter.super.setLayoutHelpers(linkedList);
                }
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            if (a()) {
                DelegateAdapter.this.notifyDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            if (a()) {
                DelegateAdapter.this.notifyItemRangeChanged(this.a + i, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            if (a()) {
                DelegateAdapter.this.notifyItemRangeInserted(this.a + i, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            if (a()) {
                DelegateAdapter delegateAdapter = DelegateAdapter.this;
                int i4 = this.a;
                delegateAdapter.notifyItemMoved(i + i4, i4 + i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            if (a()) {
                DelegateAdapter.this.notifyItemRangeRemoved(this.a + i, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            if (a()) {
                DelegateAdapter.this.notifyItemRangeChanged(this.a + i, i2, obj);
            }
        }
    }

    public DelegateAdapter(VirtualLayoutManager virtualLayoutManager, boolean z) {
        this(virtualLayoutManager, z, false);
    }

    public static Adapter<? extends RecyclerView.ViewHolder> simpleAdapter(@NonNull View view, @NonNull com.alibaba.android.vlayout.a aVar) {
        return new a(view, aVar);
    }

    public void addAdapter(@Nullable Adapter adapter) {
        addAdapters(Collections.singletonList(adapter));
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    static class a extends Adapter<RecyclerView.ViewHolder> {
        private View a;
        private com.alibaba.android.vlayout.a b;

        public a(@NonNull View view, @NonNull com.alibaba.android.vlayout.a aVar) {
            this.a = view;
            this.b = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        }

        @Override // com.alibaba.android.vlayout.DelegateAdapter.Adapter
        public com.alibaba.android.vlayout.a onCreateLayoutHelper() {
            return this.b;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new b(this.a);
        }

        public a(@NonNull View view) {
            this(view, new h());
        }
    }

    DelegateAdapter(VirtualLayoutManager virtualLayoutManager, boolean z, boolean z2) {
        super(virtualLayoutManager);
        this.mIndex = 0;
        this.mItemTypeAry = new SparseArray<>();
        this.mAdapters = new ArrayList();
        this.mTotal = 0;
        this.mIndexAry = new SparseArray<>();
        this.cantorReverse = new long[2];
        if (z2) {
            this.mIndexGen = new AtomicInteger(0);
        }
        this.mHasConsistItemType = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        Pair<AdapterDataObserver, Adapter> findAdapterByPosition = findAdapterByPosition(i);
        if (findAdapterByPosition == null) {
            return;
        }
        ((Adapter) findAdapterByPosition.second).onBindViewHolder(viewHolder, i - ((AdapterDataObserver) findAdapterByPosition.first).a, list);
        ((Adapter) findAdapterByPosition.second).onBindViewHolderWithOffset(viewHolder, i - ((AdapterDataObserver) findAdapterByPosition.first).a, i, list);
    }

    public void removeAdapter(@Nullable Adapter adapter) {
        if (adapter == null) {
            return;
        }
        removeAdapters(Collections.singletonList(adapter));
    }

    public void addAdapters(@Nullable List<Adapter> list) {
        addAdapters(this.mAdapters.size(), list);
    }
}
