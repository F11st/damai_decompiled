package tb;

import androidx.annotation.NonNull;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.manager.datasource.DXDataSourceLruManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ay extends zx {
    public ay(DXDataSourceLruManager dXDataSourceLruManager) {
        super(dXDataSourceLruManager);
    }

    @Override // tb.zx
    public DXWidgetNode b(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, @NonNull Object obj, List<Object> list, List<DXWidgetNode> list2, int i, FalcoSpan falcoSpan) {
        DXTemplateWidgetNode dXTemplateWidgetNode = null;
        if (list2 != null && !list2.isEmpty()) {
            for (int i2 = 0; i2 < list2.size() && (dXTemplateWidgetNode = a(dXAbsContainerBaseLayout, list2.get(i2), obj, list, i, falcoSpan, false)) == null; i2++) {
            }
        }
        if (dXTemplateWidgetNode == null) {
            h00 h00Var = new h00();
            h00Var.setDXRuntimeContext(dXAbsContainerBaseLayout.getDXRuntimeContext().cloneWithWidgetNode(dXAbsContainerBaseLayout));
            h00Var.setVisibility(2);
            return h00Var;
        }
        return dXTemplateWidgetNode;
    }

    @Override // tb.zx
    public ArrayList<DXWidgetNode> d(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, List<Object> list, List<DXWidgetNode> list2, int i, int i2, FalcoSpan falcoSpan) {
        ArrayList<DXWidgetNode> arrayList = new ArrayList<>();
        if (list2 != null && !list2.isEmpty() && list != null && !list.isEmpty()) {
            for (int i3 = i; i3 < i2; i3++) {
                Object obj = list.get(i3);
                DXTemplateWidgetNode dXTemplateWidgetNode = null;
                for (int i4 = 0; i4 < list2.size() && (dXTemplateWidgetNode = a(dXAbsContainerBaseLayout, list2.get(i4), obj, list, i3, falcoSpan, false)) == null; i4++) {
                }
                if (dXTemplateWidgetNode == null) {
                    h00 h00Var = new h00();
                    h00Var.setDXRuntimeContext(dXAbsContainerBaseLayout.getDXRuntimeContext().cloneWithWidgetNode(h00Var));
                    h00Var.setVisibility(2);
                    arrayList.add(h00Var);
                } else {
                    arrayList.add(dXTemplateWidgetNode);
                }
            }
        }
        return arrayList;
    }
}
