package tb;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class o00 {
    public abstract boolean a(DXRecyclerLayout dXRecyclerLayout, @NonNull JSONObject jSONObject, FalcoSpan falcoSpan);

    public abstract boolean b(DXRecyclerLayout dXRecyclerLayout, @NonNull JSONObject jSONObject);

    public DXWidgetNode c(DXRecyclerLayout dXRecyclerLayout, @NonNull Object obj, List<DXWidgetNode> list, int i, FalcoSpan falcoSpan) {
        return dXRecyclerLayout.generateItemWithData(obj, list, i, falcoSpan);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<DXWidgetNode> d(DXRecyclerLayout dXRecyclerLayout, List<Object> list, List<DXWidgetNode> list2, int i, int i2, FalcoSpan falcoSpan) {
        return dXRecyclerLayout.generateWidgetNodeByData(list, list2, i, i2, falcoSpan);
    }

    public List<Object> e(DXRecyclerLayout dXRecyclerLayout) {
        return dXRecyclerLayout.getDataSource();
    }

    public IDXDataSourceManager f(DXRecyclerLayout dXRecyclerLayout) {
        return dXRecyclerLayout.getDataSourceManager();
    }

    public ArrayList<DXWidgetNode> g(DXRecyclerLayout dXRecyclerLayout) {
        return dXRecyclerLayout.getOriginWidgetNodes();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DXTemplateWidgetNode h(DXWidgetNode dXWidgetNode) {
        return q00.b(dXWidgetNode);
    }

    public abstract boolean i(DXRecyclerLayout dXRecyclerLayout, @NonNull JSONObject jSONObject, FalcoSpan falcoSpan);

    public abstract boolean j(DXRecyclerLayout dXRecyclerLayout, @NonNull JSONObject jSONObject, FalcoSpan falcoSpan);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(DXRecyclerLayout dXRecyclerLayout) {
        dXRecyclerLayout.refresh(false, "all", -1, 0, null, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(DXRecyclerLayout dXRecyclerLayout, String str, int i, int i2, String str2, boolean z) {
        dXRecyclerLayout.refresh(false, str, i, i2, str2, z);
    }

    public void m(DXRecyclerLayout dXRecyclerLayout, int i, String str) {
        dXRecyclerLayout.trackError(i, str);
    }

    public boolean n(DXRecyclerLayout dXRecyclerLayout, JSONObject jSONObject, FalcoSpan falcoSpan) {
        return false;
    }

    public abstract boolean o(DXRecyclerLayout dXRecyclerLayout, JSONObject jSONObject, boolean z, FalcoSpan falcoSpan);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(DXRecyclerLayout dXRecyclerLayout, Object obj, int i, FalcoSpan falcoSpan) {
        dXRecyclerLayout.updateItemWithData(obj, i, falcoSpan);
    }

    public abstract boolean q(DXRecyclerLayout dXRecyclerLayout, JSONObject jSONObject);
}
