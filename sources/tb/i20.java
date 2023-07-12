package tb;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.videoc.core.IDXVideoFinder;
import com.taobao.android.dinamicx.videoc.core.listener.IDXVideoListener;
import com.taobao.android.dinamicx.view.DXRootNativeFrameLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class i20 implements IDXVideoFinder<by2, IDXVideoListener> {
    @NonNull
    private final Map<String, List<Class<? extends DXWidgetNode>>> a;

    public i20(@NonNull Map<String, List<Class<? extends DXWidgetNode>>> map) {
        this.a = map;
    }

    private View a(View view, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (cls.isInstance(view)) {
                return view;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View a = a(viewGroup.getChildAt(i), clsArr);
                if (a != null) {
                    return a;
                }
            }
            return null;
        }
        return null;
    }

    private List<IDXVideoListener> b(@NonNull DXWidgetNode dXWidgetNode, @NonNull String str) {
        ArrayList arrayList = new ArrayList();
        if (e(dXWidgetNode, str)) {
            if (wt.J0(dXWidgetNode.getDXRuntimeContext().getBizType()) && dXWidgetNode.isFlatten()) {
                DXWidgetNode referenceNode = dXWidgetNode.getReferenceNode();
                if (referenceNode != null) {
                    arrayList.add((IDXVideoListener) referenceNode);
                }
            } else {
                arrayList.add((IDXVideoListener) dXWidgetNode);
            }
        }
        List<DXWidgetNode> children = dXWidgetNode.getChildren();
        if (children == null) {
            return arrayList;
        }
        for (DXWidgetNode dXWidgetNode2 : children) {
            arrayList.addAll(b(dXWidgetNode2, str));
        }
        return arrayList;
    }

    private DXWidgetNode d(@NonNull View view) {
        if (view instanceof DXRootView) {
            return ((DXRootView) view).getFlattenWidgetNode();
        }
        Object tag = view.getTag(DXWidgetNode.TAG_WIDGET_NODE);
        if (tag instanceof DXWidgetNode) {
            return (DXWidgetNode) tag;
        }
        return null;
    }

    private boolean e(Object obj, @NonNull String str) {
        List<Class<? extends DXWidgetNode>> list = this.a.get(str);
        if ((obj instanceof IDXVideoListener) && list != null) {
            for (Class<? extends DXWidgetNode> cls : list) {
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoFinder
    @Nullable
    /* renamed from: c */
    public List<IDXVideoListener> findVideos(@NonNull by2 by2Var, @NonNull String str) {
        View a;
        DXWidgetNode d;
        View c = by2Var.c();
        if (c == null || (a = a(c, new Class[]{DXRootView.class, DXRootNativeFrameLayout.class})) == null || (d = d(a)) == null) {
            return null;
        }
        return b(d, str);
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoFinder
    public Collection<String> scenes() {
        return this.a.keySet();
    }
}
