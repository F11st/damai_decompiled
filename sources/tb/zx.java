package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.manager.datasource.DXDataSourceLruManager;
import com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class zx implements IDXDataSourceManager {
    protected com.taobao.android.dinamicx.m a;
    private List<Object> b;
    private List<DXWidgetNode> c;
    protected DXDataSourceLruManager d;

    public zx(DXDataSourceLruManager dXDataSourceLruManager) {
        this.d = dXDataSourceLruManager;
    }

    private void g(DXTemplateWidgetNode dXTemplateWidgetNode) {
        if (this.a == null) {
            this.a = new com.taobao.android.dinamicx.m();
        }
        this.a.h(dXTemplateWidgetNode, true);
        if (TextUtils.isEmpty(dXTemplateWidgetNode.getSlotId())) {
            return;
        }
        dXTemplateWidgetNode.processContainsSlotIdTemplate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.taobao.android.dinamicx.widget.DXTemplateWidgetNode a(com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout r6, com.taobao.android.dinamicx.widget.DXWidgetNode r7, java.lang.Object r8, java.util.List<java.lang.Object> r9, int r10, com.taobao.analysis.v3.FalcoSpan r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.zx.a(com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode, java.lang.Object, java.util.List, int, com.taobao.analysis.v3.FalcoSpan, boolean):com.taobao.android.dinamicx.widget.DXTemplateWidgetNode");
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public void addAllItem(int i, Collection<DXWidgetNode> collection) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            dXDataSourceLruManager.addAllItem(i, collection);
            return;
        }
        List<DXWidgetNode> list = this.c;
        if (list != null) {
            list.addAll(i, collection);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public void addItem(DXWidgetNode dXWidgetNode) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            dXDataSourceLruManager.addItem(dXWidgetNode);
            return;
        }
        List<DXWidgetNode> list = this.c;
        if (list != null) {
            list.add(dXWidgetNode);
        }
    }

    public DXWidgetNode b(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, @NonNull Object obj, List<Object> list, List<DXWidgetNode> list2, int i, FalcoSpan falcoSpan) {
        return null;
    }

    public List<DXWidgetNode> c(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, @NonNull JSONObject jSONObject, List<Object> list, List<DXWidgetNode> list2, int i, int i2, FalcoSpan falcoSpan) {
        return null;
    }

    public ArrayList<DXWidgetNode> d(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, List<Object> list, List<DXWidgetNode> list2, int i, int i2, FalcoSpan falcoSpan) {
        throw null;
    }

    public List<Object> e() {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.a();
        }
        return this.b;
    }

    public List<DXWidgetNode> f() {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.b();
        }
        return this.c;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public DXWidgetNode getItem(int i) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.getItem(i);
        }
        List<DXWidgetNode> list = this.c;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public int getItemSize() {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.getItemSize();
        }
        List<DXWidgetNode> list = this.c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public int getRealCount() {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.getRealCount();
        }
        List<Object> list = this.b;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.b.size();
    }

    public void h(List<Object> list) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            dXDataSourceLruManager.d(list);
        } else {
            this.b = list;
        }
    }

    public void i(List<DXWidgetNode> list) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            dXDataSourceLruManager.e(list);
        } else {
            this.c = list;
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public int indexOfItem(DXWidgetNode dXWidgetNode) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.indexOfItem(dXWidgetNode);
        }
        List<DXWidgetNode> list = this.c;
        if (list == null) {
            return -1;
        }
        return list.indexOf(dXWidgetNode);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public boolean isItemsEmpty() {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.isItemsEmpty();
        }
        List<DXWidgetNode> list = this.c;
        if (list == null) {
            return true;
        }
        return list.isEmpty();
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public boolean isItemsNull() {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.isItemsNull();
        }
        return this.c == null;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public DXWidgetNode removeItem(int i) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            return dXDataSourceLruManager.removeItem(i);
        }
        List<DXWidgetNode> list = this.c;
        if (list == null) {
            return null;
        }
        return list.remove(i);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public void setItem(int i, DXWidgetNode dXWidgetNode) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            dXDataSourceLruManager.setItem(i, dXWidgetNode);
            return;
        }
        List<DXWidgetNode> list = this.c;
        if (list != null) {
            list.set(i, dXWidgetNode);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public void addItem(int i, DXWidgetNode dXWidgetNode) {
        DXDataSourceLruManager dXDataSourceLruManager = this.d;
        if (dXDataSourceLruManager != null) {
            dXDataSourceLruManager.addItem(i, dXWidgetNode);
            return;
        }
        List<DXWidgetNode> list = this.c;
        if (list != null) {
            list.add(i, dXWidgetNode);
        }
    }
}
