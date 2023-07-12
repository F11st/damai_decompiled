package tb;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout;
import com.taobao.android.dinamicx.widget.DXSectionLayout;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.manager.datasource.DXDataSourceLruManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class by extends zx {
    List<Object> e;
    List f;
    Map<Integer, List<Integer>> g;
    Map<Integer, Integer> h;

    public by(DXDataSourceLruManager dXDataSourceLruManager) {
        super(dXDataSourceLruManager);
        this.f = new JSONArray();
        this.h = new HashMap();
        this.g = new HashMap();
    }

    private void k(int i, int i2) {
        List<Integer> list = this.g.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList<>();
            this.g.put(Integer.valueOf(i), list);
        }
        if (list.indexOf(Integer.valueOf(i2)) == -1) {
            list.add(Integer.valueOf(i2));
        }
        this.h.put(Integer.valueOf(i2), Integer.valueOf(i));
    }

    @Override // tb.zx
    public List<DXWidgetNode> c(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, @NonNull JSONObject jSONObject, List<Object> list, List<DXWidgetNode> list2, int i, int i2, FalcoSpan falcoSpan) {
        List<DXTemplateWidgetNode> list3 = null;
        for (int i3 = 0; i3 < list2.size(); i3++) {
            list3 = j(dXAbsContainerBaseLayout, list2.get(i3), jSONObject, list, i, i2, falcoSpan);
            if (list3 != null && list3.size() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list3);
                return arrayList;
            }
        }
        if (list3 == null) {
            h00 h00Var = new h00();
            h00Var.setDXRuntimeContext(dXAbsContainerBaseLayout.getDXRuntimeContext().cloneWithWidgetNode(h00Var));
            h00Var.setVisibility(2);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(h00Var);
            return arrayList2;
        }
        return null;
    }

    @Override // tb.zx
    public ArrayList<DXWidgetNode> d(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, List<Object> list, List<DXWidgetNode> list2, int i, int i2, FalcoSpan falcoSpan) {
        this.e = list;
        ArrayList<DXWidgetNode> arrayList = new ArrayList<>();
        if (list2 != null && !list2.isEmpty() && list != null && !list.isEmpty()) {
            for (int i3 = i; i3 < i2; i3++) {
                Object obj = list.get(i3);
                int size = this.f.size();
                List<DXTemplateWidgetNode> list3 = null;
                int i4 = 0;
                while (i4 < list2.size()) {
                    int i5 = i4;
                    list3 = j(dXAbsContainerBaseLayout, list2.get(i4), obj, list, i3, size, falcoSpan);
                    if (list3 != null) {
                        break;
                    }
                    i4 = i5 + 1;
                }
                if (list3 != null && list3.size() != 0) {
                    arrayList.addAll(list3);
                } else {
                    h00 h00Var = new h00();
                    h00Var.setDXRuntimeContext(dXAbsContainerBaseLayout.getDXRuntimeContext().cloneWithWidgetNode(h00Var));
                    h00Var.setVisibility(2);
                    arrayList.add(h00Var);
                    this.f.add(list);
                }
            }
        }
        return arrayList;
    }

    protected List<DXTemplateWidgetNode> j(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, DXWidgetNode dXWidgetNode, Object obj, List<Object> list, int i, int i2, FalcoSpan falcoSpan) {
        DXTemplateWidgetNode a;
        if ((dXWidgetNode instanceof DXSectionLayout) && q00.a(dXWidgetNode, dXWidgetNode.getDXRuntimeContext()) && dXWidgetNode.getChildrenCount() > 0) {
            ArrayList arrayList = new ArrayList();
            int i3 = i2;
            for (DXWidgetNode dXWidgetNode2 : dXWidgetNode.getChildren()) {
                if ((dXWidgetNode2 instanceof DXTemplateWidgetNode) && (a = a(dXAbsContainerBaseLayout, dXWidgetNode2, obj, list, i3, falcoSpan, true)) != null) {
                    this.f.add(obj);
                    k(i, i3);
                    i3++;
                    arrayList.add(a);
                }
            }
            return arrayList;
        }
        return null;
    }
}
