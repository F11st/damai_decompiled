package com.taobao.android.dinamic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamic.DViewGenerator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tb.a90;
import tb.f90;
import tb.iy2;
import tb.s80;
import tb.v80;
import tb.x80;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DLoopLinearLayout extends DLinearLayout {
    private static final String TAG = "DLoopLinearLayout";
    final C6352a recycledPool;
    private Map<Integer, C6353b> templateViews;
    private int viewTypeFlag;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.view.DLoopLinearLayout$a */
    /* loaded from: classes12.dex */
    public static class C6352a {
        private SparseArray<ArrayList<View>> a = new SparseArray<>();
        private SparseIntArray b = new SparseIntArray();

        private ArrayList<View> b(int i) {
            ArrayList<View> arrayList = this.a.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.a.put(i, arrayList);
                if (this.b.indexOfKey(i) < 0) {
                    this.b.put(i, 10);
                }
            }
            return arrayList;
        }

        public View a(int i) {
            ArrayList<View> arrayList = this.a.get(i);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            int size = arrayList.size() - 1;
            View view = arrayList.get(size);
            arrayList.remove(size);
            return view;
        }

        public void c(int i, View view) {
            ArrayList<View> b = b(i);
            if (this.b.get(i) <= b.size()) {
                return;
            }
            b.add(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.view.DLoopLinearLayout$b */
    /* loaded from: classes12.dex */
    public class C6353b {
        int a;
        View b;
        String c;
        String d;

        C6353b(DLoopLinearLayout dLoopLinearLayout) {
        }
    }

    public DLoopLinearLayout(Context context) {
        super(context);
        this.viewTypeFlag = 0;
        this.templateViews = new LinkedHashMap();
        this.recycledPool = new C6352a();
    }

    private void addViewInfo(View view) {
        for (Map.Entry<Integer, C6353b> entry : this.templateViews.entrySet()) {
            if (view == entry.getValue().b) {
                return;
            }
        }
        x80 c = f90.c(view);
        C6353b c6353b = new C6353b(this);
        c6353b.b = view;
        c6353b.a = this.viewTypeFlag;
        c6353b.d = c.a;
        if (c.b.containsKey("dFilter")) {
            c6353b.c = String.valueOf(c.b.get("dFilter"));
        } else {
            c6353b.c = c.c.get("dFilter");
        }
        this.templateViews.put(Integer.valueOf(c6353b.a), c6353b);
        view.setTag(a90.VIEW_TYPE_KEY, Integer.valueOf(c6353b.a));
        this.viewTypeFlag++;
    }

    private Object getBindData(Object obj) {
        if (obj instanceof String) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", obj);
            return jSONObject;
        }
        return obj;
    }

    private View getCacheView(int i) {
        return this.recycledPool.a(i);
    }

    private boolean isViewGroup(View view) {
        if (view instanceof DLoopLinearLayout) {
            return false;
        }
        return (view instanceof DLinearLayout) || (view instanceof DFrameLayout);
    }

    private void recursiveViewTree(View view, ArrayList<View> arrayList) {
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            x80 x80Var = (x80) childAt.getTag(a90.PROPERTY_KEY);
            if (x80Var != null && (!x80Var.c.isEmpty() || !x80Var.d.isEmpty())) {
                arrayList.remove(childAt);
            }
            if (isViewGroup(childAt)) {
                recursiveViewTree(childAt, arrayList);
            }
        }
    }

    private void recyleView(int i) {
        if (i >= super.getChildCount()) {
            return;
        }
        View childAt = super.getChildAt(i);
        super.removeViewAt(i);
        Integer num = (Integer) childAt.getTag(a90.VIEW_TYPE_KEY);
        if (num == null) {
            return;
        }
        this.recycledPool.c(num.intValue(), childAt);
    }

    private void removeBindList(View view) {
        ArrayList<View> arrayList = (ArrayList) getTag(a90.TAG_DINAMIC_BIND_DATA_LIST);
        x80 x80Var = (x80) view.getTag(a90.PROPERTY_KEY);
        if (!x80Var.c.isEmpty() || !x80Var.d.isEmpty()) {
            arrayList.remove(view);
        }
        if (isViewGroup(view)) {
            recursiveViewTree(view, arrayList);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        addViewInfo(view);
        removeBindList(view);
    }

    public void bindChildView(v80 v80Var, List list) {
        if (this.templateViews.size() != 0 && list != null && list.size() != 0) {
            if (getChildCount() > list.size()) {
                int childCount = getChildCount();
                while (true) {
                    childCount--;
                    if (childCount < list.size()) {
                        break;
                    }
                    recyleView(childCount);
                }
            }
            DViewGenerator o = DViewGenerator.o(v80Var.c());
            Object a = v80Var.a();
            for (int i = 0; i < list.size(); i++) {
                v80Var.f(getBindData(list.get(i)));
                int itemViewType = getItemViewType(v80Var);
                if (itemViewType == -1) {
                    super.addView(new CompatibleView(getContext(), "no view match data"), i);
                } else {
                    View view = null;
                    if (i < getChildCount()) {
                        View childAt = getChildAt(i);
                        Integer num = (Integer) childAt.getTag(a90.VIEW_TYPE_KEY);
                        if (num == null || itemViewType != num.intValue()) {
                            recyleView(i);
                        } else {
                            view = childAt;
                        }
                    }
                    if (view == null) {
                        view = getCacheView(itemViewType);
                        if (view == null) {
                            iy2 i2 = o.i(this.templateViews.get(Integer.valueOf(itemViewType)).b, getContext(), v80Var);
                            View d = i2.d();
                            d.setTag(a90.TAG_ROOT_VIEW_RESULT, i2);
                            d.setTag(a90.VIEW_TYPE_KEY, Integer.valueOf(itemViewType));
                            view = d;
                        }
                        super.addView(view, i, view.getLayoutParams());
                    }
                    iy2 iy2Var = (iy2) view.getTag(a90.TAG_ROOT_VIEW_RESULT);
                    if (iy2Var != null) {
                        o.f(iy2Var.a(), v80Var);
                    }
                }
            }
            v80Var.f(a);
            return;
        }
        for (int childCount2 = getChildCount() - 1; childCount2 >= 0; childCount2--) {
            recyleView(childCount2);
        }
    }

    public void bindListData(v80 v80Var, List list) {
        bindChildView(v80Var, list);
    }

    public Map<Integer, C6353b> cloneTemplateViews() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.templateViews);
        return linkedHashMap;
    }

    public int getItemViewType(v80 v80Var) {
        for (Map.Entry<Integer, C6353b> entry : this.templateViews.entrySet()) {
            C6353b value = entry.getValue();
            String str = value.c;
            if (str == null) {
                if (this.templateViews.size() == 1) {
                    return value.a;
                }
            } else if ("true".equals(str)) {
                return value.a;
            } else {
                Object a = s80.a(value.c, value.d, v80Var);
                if (a != null && (((a instanceof Boolean) && ((Boolean) a).booleanValue()) || ((a instanceof String) && "true".equals(a.toString())))) {
                    return value.a;
                }
            }
        }
        return -1;
    }

    public void setTemplateViews(Map<Integer, C6353b> map) {
        this.templateViews = map;
    }

    public DLoopLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.viewTypeFlag = 0;
        this.templateViews = new LinkedHashMap();
        this.recycledPool = new C6352a();
    }

    public DLoopLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.viewTypeFlag = 0;
        this.templateViews = new LinkedHashMap();
        this.recycledPool = new C6352a();
    }
}
