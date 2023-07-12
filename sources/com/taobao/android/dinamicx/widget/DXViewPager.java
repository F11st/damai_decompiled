package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.view.DXNativeViewPagerView;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.WaterfallLayout;
import com.taobao.android.dinamicx.widget.recycler.nested.DXNestedScrollerView;
import com.taobao.android.dinamicx.widget.viewpager.LazyViewPagerAdapter;
import com.taobao.android.dinamicx.widget.viewpager.ViewPagerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.az;
import tb.hy;
import tb.nz;
import tb.q20;
import tb.ry;
import tb.wt;
import tb.y00;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXViewPager extends DXAbsContainerBaseLayout {
    public static final long DXVIEWPAGER_DATASOURCE = -5948810534719014123L;
    public static final long DXVIEWPAGER_ENABLELAZYLOAD = 4265396554456303765L;
    public static final int DXVIEWPAGER_ENABLELAZYLOAD_TRUE = 1;
    public static final long DXVIEWPAGER_ONCREATE = 5288680013941347641L;
    public static final long DXVIEWPAGER_ONTABCHANGED = -7836695228328867158L;
    public static final long DXVIEWPAGER_SCROLLENABLED = -8352681166307095225L;
    public static final int DXVIEWPAGER_SCROLLENABLED_TRUE = 1;
    public static final long DXVIEWPAGER_SELECTED = 6456471229575806289L;
    public static final long DXVIEWPAGER_VIEWPAGER = -4553855868367056749L;
    private int currentSelect;
    private int currentState;
    private JSONArray dataSource;
    private DXTabHeaderLayoutWidgetNode dxTabHeaderLayoutWidgetNode;
    private JSONArray exportMethods;
    private int selected;
    private WeakReference<ViewPager> viewPagerRef;
    private int scrollEnabled = 1;
    private boolean enableLazyLoad = false;
    private int preSelect = -1;
    private int samplingRate = 3;
    private int samplingCount = 0;
    private SparseBooleanArray hasSelectedMap = new SparseBooleanArray();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements ViewPager.OnPageChangeListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        private void a(float f) {
            hy hyVar = new hy(5288751146867425108L);
            HashMap hashMap = new HashMap();
            hashMap.put("percent", az.H(f));
            hyVar.d(hashMap);
            DXViewPager.this.postEvent(hyVar);
        }

        private void b() {
            JSONObject jSONObject = (DXViewPager.this.dataSource == null || DXViewPager.this.currentSelect >= DXViewPager.this.dataSource.size()) ? null : DXViewPager.this.dataSource.getJSONObject(DXViewPager.this.currentSelect);
            boolean z = DXViewPager.this.hasSelectedMap.get(DXViewPager.this.currentSelect);
            if (!z) {
                DXViewPager.this.hasSelectedMap.put(DXViewPager.this.currentSelect, true);
            }
            DXViewPager.this.postEvent(new q20(DXViewPager.this.currentSelect, DXViewPager.this.preSelect, jSONObject, !z));
            DXViewPager dXViewPager = DXViewPager.this;
            dXViewPager.preSelect = dXViewPager.currentSelect;
            DXViewPager.this.samplingCount = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0 && DXViewPager.this.currentSelect != DXViewPager.this.preSelect) {
                b();
            }
            DXViewPager.this.currentState = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (f <= 0.0f || DXViewPager.access$108(DXViewPager.this) % DXViewPager.this.samplingRate != 0) {
                return;
            }
            a((f + i) / this.a);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            DXRecyclerLayout dXRecyclerLayout;
            WaterfallLayout waterfallLayout;
            RecyclerView e;
            if (i >= DXViewPager.this.getItemWidgetNodes().size()) {
                return;
            }
            DXViewPager dXViewPager = DXViewPager.this;
            dXViewPager.processExpos(dXViewPager.currentSelect, i);
            DXViewPager.this.currentSelect = i;
            if (DXViewPager.this.currentSelect == DXViewPager.this.preSelect || !wt.d0()) {
                if (DXViewPager.this.currentState == 0 && DXViewPager.this.currentSelect != DXViewPager.this.preSelect) {
                    b();
                }
            } else {
                b();
            }
            DXNestedScrollerView dxNestedScrollerView = DXViewPager.this.dXRuntimeContext.getRootView().getDxNestedScrollerView();
            if (dxNestedScrollerView == null || (dXRecyclerLayout = (DXRecyclerLayout) DXViewPager.this.getItemWidgetNodes().get(i)) == null || (waterfallLayout = dXRecyclerLayout.getWaterfallLayout()) == null || (e = waterfallLayout.e()) == null) {
                return;
            }
            dxNestedScrollerView.setCurrentChild(e);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new DXViewPager();
        }
    }

    static /* synthetic */ int access$108(DXViewPager dXViewPager) {
        int i = dXViewPager.samplingCount;
        dXViewPager.samplingCount = i + 1;
        return i;
    }

    private ViewPagerAdapter createAdapter(Context context) {
        if (this.enableLazyLoad) {
            return new LazyViewPagerAdapter(this, getItemWidgetNodes(), context);
        }
        return new ViewPagerAdapter(this, getItemWidgetNodes(), context);
    }

    private void prepareViewPager(ViewPager viewPager) {
        viewPager.setOffscreenPageLimit(99);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processExpos(int i, int i2) {
        if (getItemWidgetNodes() == null || getItemWidgetNodes().size() == 0) {
            return;
        }
        int size = getItemWidgetNodes().size();
        if (i >= 0 && i < size) {
            DXWidgetNode dXWidgetNode = getItemWidgetNodes().get(i);
            if (dXWidgetNode instanceof DXRecyclerLayout) {
                ((DXRecyclerLayout) dXWidgetNode).triggerStayTime();
            }
        }
        if (i2 < 0 || i2 >= size) {
            return;
        }
        final DXWidgetNode dXWidgetNode2 = getItemWidgetNodes().get(i2);
        if (dXWidgetNode2 instanceof DXRecyclerLayout) {
            ((DXRecyclerLayout) dXWidgetNode2).triggerExposure();
            y00.n(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXViewPager.4
                @Override // java.lang.Runnable
                public void run() {
                    DXWidgetNode dXWidgetNode3 = dXWidgetNode2;
                    if (dXWidgetNode3 == null) {
                        return;
                    }
                    ((DXRecyclerLayout) dXWidgetNode3).resumeStayTime();
                }
            }, 300L);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXViewPager();
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public JSONArray exportMethods() {
        if (this.exportMethods == null) {
            this.exportMethods = new JSONArray() { // from class: com.taobao.android.dinamicx.widget.DXViewPager.5
                {
                    add("changeTo");
                }
            };
            this.exportMethods.addAll(super.exportMethods());
        }
        return this.exportMethods;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f
    public ArrayList<DXWidgetNode> generateWidgetNodeByData(int i, JSONArray jSONArray, List<DXWidgetNode> list) {
        boolean z;
        Iterator<DXWidgetNode> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next() instanceof DXTemplateWidgetNode) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            ArrayList<DXWidgetNode> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.size(); i2++) {
                Object obj = jSONArray.get(i2);
                for (DXWidgetNode dXWidgetNode : list) {
                    DXRuntimeContext cloneWithWidgetNode = dXWidgetNode.getDXRuntimeContext().cloneWithWidgetNode(dXWidgetNode);
                    cloneWithWidgetNode.setSubData(obj);
                    cloneWithWidgetNode.setSubdataIndex(i2);
                    HashMap hashMap = new HashMap();
                    cloneWithWidgetNode.setEnv(hashMap);
                    hashMap.put("i", az.J(i2));
                    JSONArray jSONArray2 = this.dataSource;
                    if (jSONArray2 instanceof JSONArray) {
                        hashMap.put("dataSource", az.E(jSONArray2));
                    } else {
                        cloneWithWidgetNode.getDataProxy();
                    }
                    DXWidgetNode c = g.c(dXWidgetNode, cloneWithWidgetNode, false);
                    c.setParentWidget(this);
                    arrayList.add(c);
                }
            }
            return arrayList;
        }
        ArrayList<DXWidgetNode> arrayList2 = new ArrayList<>();
        if (!list.isEmpty() && jSONArray != null && !jSONArray.isEmpty()) {
            for (int i3 = 0; i3 < jSONArray.size(); i3++) {
                Object obj2 = jSONArray.get(i3);
                DXWidgetNode dXWidgetNode2 = null;
                for (int i4 = 0; i4 < list.size() && (dXWidgetNode2 = deepCopyChildForTemplate(list.get(i4), obj2, i3, null)) == null; i4++) {
                }
                if (dXWidgetNode2 == null) {
                    dXWidgetNode2 = new DXWidgetNode();
                    dXWidgetNode2.setDXRuntimeContext(getDXRuntimeContext().cloneWithWidgetNode(this));
                    dXWidgetNode2.setVisibility(2);
                }
                arrayList2.add(dXWidgetNode2);
            }
        }
        return arrayList2;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout
    public List<DXWidgetNode> getItemWidgetNodes() {
        return super.getItemWidgetNodes();
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.IDXNodePropProvider
    public Object getNodePropByKey(String str) {
        if ("selected".equals(str)) {
            return Integer.valueOf(this.selected);
        }
        return super.getNodePropByKey(str);
    }

    public ViewPager getViewPager() {
        WeakReference<ViewPager> weakReference = this.viewPagerRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public JSONObject invokeRefMethod(String str, final JSONArray jSONArray) {
        str.hashCode();
        if (!str.equals("changeTo")) {
            return super.invokeRefMethod(str, jSONArray);
        }
        if (jSONArray != null && !jSONArray.isEmpty()) {
            y00.m(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXViewPager.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = true;
                    int i = -1;
                    try {
                        i = jSONArray.getIntValue(0);
                        if (jSONArray.size() > 1) {
                            z = jSONArray.getBooleanValue(1);
                        }
                    } catch (Throwable th) {
                        ry.b(th);
                    }
                    if (i < 0 || DXViewPager.this.viewPagerRef == null || DXViewPager.this.viewPagerRef.get() == null) {
                        return;
                    }
                    ((ViewPager) DXViewPager.this.viewPagerRef.get()).setCurrentItem(i, z);
                }
            });
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        nz.g("shandian", "VP onBeforeBindChildData");
        if (this.originWidgetNodes == null) {
            ArrayList<DXWidgetNode> arrayList = new ArrayList<>();
            this.originWidgetNodes = arrayList;
            arrayList.addAll(getChildren());
        }
        if (this.dataSource == null) {
            this.dataSource = new JSONArray();
        }
        Iterator<DXWidgetNode> it = this.originWidgetNodes.iterator();
        while (it.hasNext()) {
            bindContext(it.next());
        }
        ArrayList<DXWidgetNode> generateWidgetNodeByData = generateWidgetNodeByData(0, this.dataSource, this.originWidgetNodes);
        setItemWidgetNodes(generateWidgetNodeByData);
        removeAllChild();
        Iterator<DXWidgetNode> it2 = generateWidgetNodeByData.iterator();
        while (it2.hasNext()) {
            addChild(it2.next(), false);
        }
        setDisableFlatten(true);
        if (generateWidgetNodeByData.size() == 0) {
            trackError(com.taobao.android.dinamicx.e.DX_ERROR_CODE_RECYCLER_LAYOUT_231001, "生成的子节点为空，或者数量为 0");
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode == null || !(dXWidgetNode instanceof DXViewPager)) {
            return;
        }
        super.onClone(dXWidgetNode, z);
        DXViewPager dXViewPager = (DXViewPager) dXWidgetNode;
        this.dataSource = dXViewPager.dataSource;
        this.selected = dXViewPager.selected;
        this.hasSelectedMap = dXViewPager.hasSelectedMap;
        this.dxTabHeaderLayoutWidgetNode = dXViewPager.dxTabHeaderLayoutWidgetNode;
        this.exportMethods = dXViewPager.exportMethods;
        this.viewPagerRef = dXViewPager.viewPagerRef;
        this.currentSelect = dXViewPager.currentSelect;
        this.preSelect = dXViewPager.preSelect;
        this.currentState = dXViewPager.currentState;
        this.samplingRate = dXViewPager.samplingRate;
        this.samplingCount = dXViewPager.samplingCount;
        this.scrollEnabled = dXViewPager.scrollEnabled;
        this.enableLazyLoad = dXViewPager.enableLazyLoad;
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    protected View onCreateView(Context context) {
        postEvent(new hy(5288680013941347641L));
        DXNativeViewPagerView dXNativeViewPagerView = new DXNativeViewPagerView(context);
        prepareViewPager(dXNativeViewPagerView);
        this.viewPagerRef = new WeakReference<>(dXNativeViewPagerView);
        if (getDXRuntimeContext().getRootView().getDxNestedScrollerView() != null) {
            getDXRuntimeContext().getRootView().getDxNestedScrollerView().clearChildList();
        }
        return dXNativeViewPagerView;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    protected void onMeasure(int i, int i2) {
        if (DXWidgetNode.DXMeasureSpec.a(i2) != 1073741824) {
            super.onMeasure(i, DXWidgetNode.DXMeasureSpec.c(getDXRuntimeContext().getRealRootExpandWidget().getMeasuredHeight(), 1073741824));
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    protected void onRenderView(Context context, View view) {
        if (view instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) view;
            if (viewPager instanceof DXNativeViewPagerView) {
                ((DXNativeViewPagerView) viewPager).setScrollable(this.scrollEnabled == 1);
            }
            this.viewPagerRef = new WeakReference<>(viewPager);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter == null) {
                viewPager.setAdapter(createAdapter(context));
            } else if (adapter.getCount() != getItemWidgetNodes().size()) {
                viewPager.setAdapter(createAdapter(context));
            } else if (adapter instanceof ViewPagerAdapter) {
                ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) adapter;
                viewPagerAdapter.c(getItemWidgetNodes());
                adapter.notifyDataSetChanged();
                viewPagerAdapter.b(this);
            }
            if (this.currentSelect == 0) {
                this.hasSelectedMap.put(0, true);
            }
            this.preSelect = this.currentSelect;
            int size = getItemWidgetNodes() != null ? getItemWidgetNodes().size() : 0;
            viewPager.clearOnPageChangeListeners();
            viewPager.addOnPageChangeListener(new a(size - 1));
            DXTabHeaderLayoutWidgetNode dXTabHeaderLayoutWidgetNode = this.dxTabHeaderLayoutWidgetNode;
            if (dXTabHeaderLayoutWidgetNode != null) {
                dXTabHeaderLayoutWidgetNode.bindViewPager(this);
            }
            y00.n(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXViewPager.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DXWidgetNode dXWidgetNode = DXViewPager.this.getItemWidgetNodes().get(DXViewPager.this.currentSelect);
                        if (dXWidgetNode == null || !(dXWidgetNode instanceof DXRecyclerLayout)) {
                            return;
                        }
                        RecyclerView recyclerView = ((DXRecyclerLayout) dXWidgetNode).getRecyclerView();
                        DXNestedScrollerView dxNestedScrollerView = DXViewPager.this.getDXRuntimeContext().getRootView().getDxNestedScrollerView();
                        if (dxNestedScrollerView == null || dxNestedScrollerView.getmChildList() == recyclerView) {
                            return;
                        }
                        dxNestedScrollerView.setCurrentChild(recyclerView);
                    } catch (Throwable th) {
                        ry.b(th);
                    }
                }
            }, 100L);
            viewPager.setCurrentItem(this.currentSelect, false);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == 6456471229575806289L) {
            this.selected = i;
            this.currentSelect = i;
        } else if (j == -8352681166307095225L) {
            this.scrollEnabled = i;
        } else if (j == DXVIEWPAGER_ENABLELAZYLOAD) {
            this.enableLazyLoad = i == 1;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    protected void onSetListAttribute(long j, JSONArray jSONArray) {
        if (j == -5948810534719014123L) {
            this.dataSource = jSONArray;
            this.propertyInitFlag |= 2;
            return;
        }
        super.onSetListAttribute(j, jSONArray);
    }

    public void resetHasSelectedMap() {
        SparseBooleanArray sparseBooleanArray = this.hasSelectedMap;
        if (sparseBooleanArray == null) {
            return;
        }
        sparseBooleanArray.clear();
        this.hasSelectedMap.put(this.currentSelect, true);
    }

    public void setCurrentItem(int i, boolean z) {
        View nativeView = getDXRuntimeContext().getNativeView();
        if (nativeView instanceof ViewPager) {
            ((ViewPager) nativeView).setCurrentItem(i, z);
        }
    }

    public void setScrollable(boolean z) {
        WeakReference<View> wRView;
        KeyEvent.Callback viewPager = getViewPager();
        if (viewPager == null && (wRView = getWRView()) != null) {
            viewPager = (View) wRView.get();
        }
        if (viewPager instanceof DXNativeViewPagerView) {
            ((DXNativeViewPagerView) viewPager).setScrollable(z);
        }
    }

    public void setTabLayoutWidget(DXTabHeaderLayoutWidgetNode dXTabHeaderLayoutWidgetNode) {
        this.dxTabHeaderLayoutWidgetNode = dXTabHeaderLayoutWidgetNode;
    }

    public void trackError(int i, String str) {
        trackError(i, str, "DX_VIEWPAGER", "DX_VIEWPAGER_ERROR");
    }
}
