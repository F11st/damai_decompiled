package com.taobao.android.dinamicx.widget.recycler.manager.datasource;

import androidx.collection.LruCache;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXDataSourceLruManager implements IDXDataSourceManager {
    private DXRecyclerLruCache a;
    private LruKeepPredicate b;
    private List<Object> c;
    private final int d;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class DXRecyclerLruCache extends LruCache<Integer, DXWidgetNode> {
        protected final Map<Integer, DXWidgetNode> a;
        protected final LruKeepPredicate b;

        public DXRecyclerLruCache(int i, LruKeepPredicate lruKeepPredicate) {
            super(i);
            this.a = new HashMap();
            this.b = lruKeepPredicate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.collection.LruCache
        /* renamed from: a */
        public void entryRemoved(boolean z, Integer num, DXWidgetNode dXWidgetNode, DXWidgetNode dXWidgetNode2) {
            if (z) {
                b(num, dXWidgetNode);
            }
        }

        protected void b(Integer num, DXWidgetNode dXWidgetNode) {
            LruKeepPredicate lruKeepPredicate;
            int i;
            if (dXWidgetNode == null || (lruKeepPredicate = this.b) == null || !lruKeepPredicate.shouldKeepWidget(num, dXWidgetNode)) {
                return;
            }
            Iterator<Map.Entry<Integer, DXWidgetNode>> it = snapshot().entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                Map.Entry<Integer, DXWidgetNode> next = it.next();
                i = next.getKey().intValue();
                if (!this.b.shouldKeepWidget(Integer.valueOf(i), next.getValue())) {
                    break;
                }
            }
            if (i != -1) {
                remove(Integer.valueOf(i));
                put(num, dXWidgetNode);
                return;
            }
            this.a.put(num, dXWidgetNode);
        }

        public DXWidgetNode c(Integer num, DXWidgetNode dXWidgetNode) {
            DXWidgetNode put = put(num, dXWidgetNode);
            if (!this.a.isEmpty()) {
                resize(maxSize() + this.a.size());
                for (Map.Entry<Integer, DXWidgetNode> entry : this.a.entrySet()) {
                    put(entry.getKey(), entry.getValue());
                }
                this.a.clear();
            }
            return put;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface LruKeepPredicate {
        boolean shouldKeepWidget(Integer num, DXWidgetNode dXWidgetNode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.manager.datasource.DXDataSourceLruManager$a */
    /* loaded from: classes11.dex */
    public class C6516a implements LruKeepPredicate {
        C6516a(DXDataSourceLruManager dXDataSourceLruManager) {
        }

        @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.DXDataSourceLruManager.LruKeepPredicate
        public boolean shouldKeepWidget(Integer num, DXWidgetNode dXWidgetNode) {
            return (dXWidgetNode instanceof DXTemplateWidgetNode) && ((DXTemplateWidgetNode) dXWidgetNode).isKeepInRecyclerLru();
        }
    }

    public DXDataSourceLruManager(int i) {
        this.d = i;
    }

    public List<Object> a() {
        return this.c;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public void addAllItem(int i, Collection<DXWidgetNode> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        for (DXWidgetNode dXWidgetNode : collection) {
            setItem(i, dXWidgetNode);
            i++;
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public void addItem(int i, DXWidgetNode dXWidgetNode) {
        setItem(i, dXWidgetNode);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public void addItem(DXWidgetNode dXWidgetNode) {
    }

    public List<DXWidgetNode> b() {
        if (this.a == null) {
            return null;
        }
        return new ArrayList(this.a.snapshot().values());
    }

    protected LruKeepPredicate c() {
        if (this.b == null) {
            this.b = new C6516a(this);
        }
        return this.b;
    }

    public void d(List<Object> list) {
        this.c = list;
    }

    public void e(List<DXWidgetNode> list) {
        if (list == null) {
            return;
        }
        this.a = new DXRecyclerLruCache(Math.max(this.d, list.size()), c());
        for (int i = 0; i < list.size(); i++) {
            this.a.c(Integer.valueOf(i), list.get(i));
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public DXWidgetNode getItem(int i) {
        DXRecyclerLruCache dXRecyclerLruCache = this.a;
        if (dXRecyclerLruCache == null) {
            return null;
        }
        return dXRecyclerLruCache.get(Integer.valueOf(i));
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public int getItemSize() {
        DXRecyclerLruCache dXRecyclerLruCache = this.a;
        if (dXRecyclerLruCache == null) {
            return 0;
        }
        return dXRecyclerLruCache.size();
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public int getRealCount() {
        List<Object> list = this.c;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.c.size();
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public int indexOfItem(DXWidgetNode dXWidgetNode) {
        DXRecyclerLruCache dXRecyclerLruCache;
        if (dXWidgetNode == null || (dXRecyclerLruCache = this.a) == null) {
            return -1;
        }
        for (Map.Entry<Integer, DXWidgetNode> entry : dXRecyclerLruCache.snapshot().entrySet()) {
            if (entry != null && entry.getValue() == dXWidgetNode) {
                return entry.getKey().intValue();
            }
        }
        return -1;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public boolean isItemsEmpty() {
        DXRecyclerLruCache dXRecyclerLruCache = this.a;
        return dXRecyclerLruCache == null || dXRecyclerLruCache.size() <= 0;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public boolean isItemsNull() {
        return this.a == null;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public DXWidgetNode removeItem(int i) {
        DXRecyclerLruCache dXRecyclerLruCache = this.a;
        if (dXRecyclerLruCache == null) {
            return null;
        }
        return dXRecyclerLruCache.remove(Integer.valueOf(i));
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public void setItem(int i, DXWidgetNode dXWidgetNode) {
        DXRecyclerLruCache dXRecyclerLruCache = this.a;
        if (dXRecyclerLruCache == null) {
            return;
        }
        dXRecyclerLruCache.c(Integer.valueOf(i), dXWidgetNode);
    }
}
