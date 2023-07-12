package tb;

import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class e00 extends dt {
    @Override // tb.dt
    public void a(DXWidgetNode dXWidgetNode, DXWidgetNode dXWidgetNode2) {
        if (dXWidgetNode == dXWidgetNode2 || dXWidgetNode2 == null) {
            return;
        }
        if (dXWidgetNode == null) {
            c(dXWidgetNode2.getWRView());
            return;
        }
        int childrenCount = dXWidgetNode2.getChildrenCount();
        int childrenCount2 = dXWidgetNode.getChildrenCount();
        if (childrenCount == 0 && childrenCount2 == 0) {
            return;
        }
        if (childrenCount != 0 || childrenCount2 <= 0) {
            if (childrenCount > 0 && childrenCount2 == 0) {
                b(dXWidgetNode2.getWRView());
                return;
            }
            HashMap hashMap = new HashMap(childrenCount2);
            for (int i = 0; i < dXWidgetNode.getChildrenCount(); i++) {
                hashMap.put(Integer.valueOf(dXWidgetNode.getChildAt(i).getAutoId()), Integer.valueOf(i));
            }
            ArrayList arrayList = new ArrayList(childrenCount2);
            for (int i2 = 0; i2 < childrenCount2; i2++) {
                arrayList.add(-1);
            }
            int i3 = 0;
            for (int i4 = 0; i4 < dXWidgetNode2.getChildrenCount(); i4++) {
                DXWidgetNode childAt = dXWidgetNode2.getChildAt(i4);
                int autoId = childAt.getAutoId();
                if (!hashMap.containsKey(Integer.valueOf(autoId))) {
                    c(childAt.getWRView());
                } else {
                    arrayList.set(((Integer) hashMap.get(Integer.valueOf(autoId))).intValue(), Integer.valueOf(i3));
                }
                i3++;
            }
            for (int i5 = 0; i5 < childrenCount2; i5++) {
                int intValue = ((Integer) arrayList.get(i5)).intValue();
                DXWidgetNode childAt2 = dXWidgetNode.getChildAt(i5);
                if (intValue != -1) {
                    DXWidgetNode childAt3 = dXWidgetNode2.getChildAt(intValue);
                    if (childAt2 != null && wt.g0(childAt2.getDXRuntimeContext()) && childAt3.getClass() != childAt2.getClass()) {
                        c(childAt3.getWRView());
                    } else {
                        childAt2.setWRView(childAt3.getWRView());
                        if (childAt2.getWRView() != null && childAt2.getWRView().get() != null) {
                            childAt2.getWRView().get().setTag(DXWidgetNode.TAG_WIDGET_NODE, childAt2);
                        }
                        if (childAt2.getChildrenCount() > 0 || childAt3.getChildrenCount() > 0) {
                            a(childAt2, childAt3);
                        }
                    }
                }
            }
        }
    }
}
