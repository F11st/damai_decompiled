package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.aliweex.adapter.component.WXTabbar;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.C6384k;
import com.taobao.android.dinamicx.widget.viewpager.tab.DXTabItemWidgetNode;
import com.taobao.android.dinamicx.widget.viewpager.tab.view.DXTabItem;
import com.taobao.android.dinamicx.widget.viewpager.tab.view.DXTabLayout;
import com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import tb.hy;
import tb.mz;
import tb.nz;
import tb.ry;
import tb.xz;
import tb.yz;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXTabHeaderLayoutWidgetNode extends DXLinearLayoutWidgetNode {
    public static final long DXTABHEADERLAYOUT_DATASOURCE = -5948810534719014123L;
    public static final long DXTABHEADERLAYOUT_ENABLESCROLL = -8426770838617723422L;
    public static final long DXTABHEADERLAYOUT_INDICATORBOTTOMGAP = 1170909693104794716L;
    public static final long DXTABHEADERLAYOUT_INDICATORCOLOR = -5151416374116397110L;
    public static final long DXTABHEADERLAYOUT_INDICATORCOLORMAP = -9087820153495724821L;
    public static final long DXTABHEADERLAYOUT_INDICATORHEIGHT = -3761529437537503451L;
    public static final long DXTABHEADERLAYOUT_INDICATORIMAGEURL = 5400402516109499876L;
    public static final long DXTABHEADERLAYOUT_INDICATORRADIUS = -3394712782565958860L;
    public static final long DXTABHEADERLAYOUT_INDICATORWIDTH = -5149988469975039285L;
    public static final long DXTABHEADERLAYOUT_INDICATORZINDEX = -3104225124614969570L;
    public static final long DXTABHEADERLAYOUT_ITEMWIDTH = -5480582194049152328L;
    public static final long DXTABHEADERLAYOUT_ONCHANGE = 5288679823228297259L;
    public static final long DXTABHEADERLAYOUT_ONTABCLICK = 5327268914103406564L;
    public static final long DXTABHEADERLAYOUT_RELATEDCOMPONENTANIMATED = 1821589090930999503L;
    public static final long DXTABHEADERLAYOUT_RELATEDCOMPONENTID = -4472384284971071661L;
    public static final long DXTABHEADERLAYOUT_SELECTEDINDEX = 4437946449641611086L;
    public static final long DXTABHEADERLAYOUT_SHOWINDICATOR = -3765027987112450965L;
    public static final int DXTABHEADERLAYOUT_SHOWINDICATOR_FALSE = 1;
    public static final int DXTABHEADERLAYOUT_SHOWINDICATOR_TRUE = 0;
    public static final long DXTABHEADERLAYOUT_TABHEADERLAYOUT = 5297988424120091629L;
    private static final String TAG = "DXTabHeaderLayoutWidgetNode";
    private int currentIndex;
    private List<View> dxSelectedView;
    private DXViewPager dxViewPager;
    private int indicatorBottomGap;
    private int indicatorColor;
    private JSONObject indicatorColorMap;
    private JSONObject indicatorColorMapOrigin;
    private int indicatorHeight;
    private String indicatorImageUrl;
    private int indicatorRadius;
    private int indicatorWidth;
    private ArrayList<DXWidgetNode> itemNodes;
    private int itemWidth;
    private TabLayout.OnTabClickListener onTabClickListener;
    private TabLayout.OnTabSelectedListener onTabSelectedListener;
    private String relatedComponentId;
    private int selectedIndex;
    private boolean showIndicator;
    private C6384k simpleRenderPipeline;
    private List<DXTabItem> tabItemList;
    private List<View> unSelectedView;
    private boolean enableScroll = false;
    private int indicatorZIndex = 1;
    private boolean relatedComponentAnimated = false;
    private Map<Integer, Boolean> hasSelectedMap = new HashMap();

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.DXTabHeaderLayoutWidgetNode$a */
    /* loaded from: classes11.dex */
    class C6461a implements TabLayout.OnTabSelectedListener {
        final /* synthetic */ DXTabLayout a;

        C6461a(DXTabLayout dXTabLayout) {
            this.a = dXTabLayout;
        }

        @Override // com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout.OnTabSelectedListener
        public void onTabReselected(TabLayout.C6546d c6546d) {
            int d = c6546d.d();
            if (c6546d.b() == null || DXTabHeaderLayoutWidgetNode.this.dxViewPager == null) {
                return;
            }
            DXTabHeaderLayoutWidgetNode.this.dxViewPager.setCurrentItem(d, false);
        }

        @Override // com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout.OnTabSelectedListener
        public void onTabSelected(TabLayout.C6546d c6546d) {
            int i = DXTabHeaderLayoutWidgetNode.this.currentIndex;
            int d = c6546d.d();
            if (c6546d.b() == null) {
                return;
            }
            ((DXTabItem) c6546d.b()).setSelected(true);
            DXTabHeaderLayoutWidgetNode.this.currentIndex = d;
            if (DXTabHeaderLayoutWidgetNode.this.indicatorColorMap != null) {
                DXTabHeaderLayoutWidgetNode.this.renderIndicatorColor(this.a);
            }
            DXTabHeaderLayoutWidgetNode dXTabHeaderLayoutWidgetNode = DXTabHeaderLayoutWidgetNode.this;
            if (dXTabHeaderLayoutWidgetNode != null) {
                JSONArray listData = dXTabHeaderLayoutWidgetNode.getListData();
                boolean booleanValue = DXTabHeaderLayoutWidgetNode.this.hasSelectedMap.containsKey(Integer.valueOf(d)) ? ((Boolean) DXTabHeaderLayoutWidgetNode.this.hasSelectedMap.get(Integer.valueOf(d))).booleanValue() : false;
                if (!booleanValue) {
                    DXTabHeaderLayoutWidgetNode.this.hasSelectedMap.put(Integer.valueOf(d), Boolean.valueOf(!booleanValue));
                }
                dXTabHeaderLayoutWidgetNode.postEvent(new xz(d, i, (listData == null || listData.size() <= d) ? null : listData.getJSONObject(d), !booleanValue, c6546d.g()));
            }
        }

        @Override // com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout.OnTabSelectedListener
        public void onTabUnselected(TabLayout.C6546d c6546d) {
            if (c6546d.b() == null) {
                return;
            }
            ((DXTabItem) c6546d.b()).setSelected(false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.DXTabHeaderLayoutWidgetNode$b */
    /* loaded from: classes11.dex */
    class C6462b implements TabLayout.OnTabClickListener {
        C6462b() {
        }

        @Override // com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout.OnTabClickListener
        public void onTabClick(TabLayout.C6546d c6546d) {
            int d = c6546d.d();
            DXTabHeaderLayoutWidgetNode dXTabHeaderLayoutWidgetNode = DXTabHeaderLayoutWidgetNode.this;
            if (dXTabHeaderLayoutWidgetNode != null) {
                JSONArray listData = dXTabHeaderLayoutWidgetNode.getListData();
                dXTabHeaderLayoutWidgetNode.postEvent(new yz(d, DXTabHeaderLayoutWidgetNode.this.currentIndex, listData == null ? null : listData.getJSONObject(d)));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.DXTabHeaderLayoutWidgetNode$c */
    /* loaded from: classes11.dex */
    public static class C6463c implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new DXTabHeaderLayoutWidgetNode();
        }
    }

    private DXTabItemWidgetNode getFirstSelectedTabItem() {
        if (this.itemNodes == null) {
            return null;
        }
        for (int i = 0; i < this.itemNodes.size(); i++) {
            DXTabItemWidgetNode dXTabItemWidgetNode = (DXTabItemWidgetNode) this.itemNodes.get(i);
            if (dXTabItemWidgetNode.isSelected()) {
                return dXTabItemWidgetNode;
            }
        }
        return null;
    }

    private void parserIndicatorColorMap() {
        if (this.indicatorColorMapOrigin == null || this.itemNodes == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : this.indicatorColorMapOrigin.entrySet()) {
            try {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.itemNodes.size()) {
                            break;
                        } else if (key.equals(this.itemNodes.get(i).getUserId())) {
                            jSONObject.put(String.valueOf(i / 2), (Object) Integer.valueOf(Color.parseColor(String.valueOf(entry.getValue()))));
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            } catch (Exception e) {
                ry.b(e);
            }
        }
        this.indicatorColorMap = jSONObject;
    }

    private void renderIndicator(DXTabLayout dXTabLayout) {
        parserIndicatorColorMap();
        if (this.showIndicator) {
            renderIndicatorColor(dXTabLayout);
            dXTabLayout.setSelectedTabIndicatorHeight(this.indicatorHeight);
            dXTabLayout.setSelectedTabIndicatorWidth(this.indicatorWidth);
            dXTabLayout.setSelectedTabIndicatorRadius(this.indicatorRadius);
            dXTabLayout.setSelectedTabIndicatorBottomGap(this.indicatorBottomGap);
            dXTabLayout.setSelectedTabIndicatorZIndex(this.indicatorZIndex);
            return;
        }
        renderIndicatorColor(dXTabLayout);
        dXTabLayout.setSelectedTabIndicatorHeight(this.indicatorHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderIndicatorColor(DXTabLayout dXTabLayout) {
        if (this.showIndicator) {
            if (this.indicatorColorMap == null) {
                dXTabLayout.setSelectedTabIndicatorColor(this.indicatorColor);
                return;
            }
            String valueOf = String.valueOf(this.currentIndex);
            if (this.indicatorColorMap.containsKey(valueOf)) {
                dXTabLayout.setSelectedTabIndicatorColor(this.indicatorColorMap.getInteger(valueOf).intValue());
                return;
            } else {
                dXTabLayout.setSelectedTabIndicatorColor(this.indicatorColor);
                return;
            }
        }
        dXTabLayout.setSelectedTabIndicatorColor(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void renderTabItems(com.taobao.android.dinamicx.widget.viewpager.tab.view.DXTabLayout r21) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.widget.DXTabHeaderLayoutWidgetNode.renderTabItems(com.taobao.android.dinamicx.widget.viewpager.tab.view.DXTabLayout):void");
    }

    public void bindViewPager(DXViewPager dXViewPager) {
        DXTabLayout dXTabLayout = (DXTabLayout) getDXRuntimeContext().getNativeView();
        if (dXViewPager instanceof DXViewPager) {
            dXTabLayout.setupWithViewPager((ViewPager) dXViewPager.getDXRuntimeContext().getNativeView());
        }
        if (dXViewPager == null || dXViewPager.getItemWidgetNodes() == null) {
            return;
        }
        int size = dXViewPager.getItemWidgetNodes().size();
        for (int i = 0; i < size; i++) {
            TabLayout.C6546d tabAt = dXTabLayout.getTabAt(i);
            if (i == this.currentIndex) {
                if (i >= this.tabItemList.size()) {
                    break;
                }
                DXTabItem dXTabItem = this.tabItemList.get(i);
                dXTabItem.setSelected(true);
                tabAt.m(dXTabItem);
                nz.b(TAG, "bindViewPager set " + i + " view " + tabAt.b());
            } else if (i >= this.tabItemList.size()) {
                break;
            } else {
                DXTabItem dXTabItem2 = this.tabItemList.get(i);
                dXTabItem2.setSelected(false);
                tabAt.m(dXTabItem2);
                nz.b(TAG, "bindViewPager set " + i + " view " + tabAt.b());
            }
        }
        int i2 = this.currentIndex;
        if (i2 != 0) {
            this.dxViewPager.setCurrentItem(i2, false);
        } else {
            this.hasSelectedMap.put(0, Boolean.TRUE);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXTabHeaderLayoutWidgetNode();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (j == DXTABHEADERLAYOUT_ENABLESCROLL) {
            return 0;
        }
        if (j == DXTABHEADERLAYOUT_INDICATORZINDEX) {
            return 1;
        }
        if (j == DXTABHEADERLAYOUT_RELATEDCOMPONENTANIMATED) {
            return 0;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.IDXNodePropProvider
    public Object getNodePropByKey(String str) {
        if (WXTabbar.SELECT_INDEX.equals(str)) {
            return Integer.valueOf(this.currentIndex);
        }
        return super.getNodePropByKey(str);
    }

    public boolean isEnableScroll() {
        return this.enableScroll;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        if (getChildren() != null && this.originItems == null) {
            ArrayList arrayList = new ArrayList();
            this.originItems = arrayList;
            arrayList.addAll(getChildren());
        }
        if ((this.propertyInitFlag & 2) == 0) {
            return;
        }
        JSONArray jSONArray = this.listData;
        if (jSONArray != null && !jSONArray.isEmpty() && getChildren() != null) {
            new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < this.originItems.size(); i++) {
                arrayList2.add(this.originItems.get(i).deepClone(getDXRuntimeContext()));
            }
            ArrayList<DXWidgetNode> generateWidgetNodeByData = generateWidgetNodeByData(0, getListData(), arrayList2);
            this.itemNodes = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                this.itemNodes.add(arrayList2.get(i2));
            }
            for (int i3 = 0; i3 < generateWidgetNodeByData.size(); i3++) {
                this.itemNodes.add(generateWidgetNodeByData.get(i3));
            }
            removeAllChild();
            return;
        }
        removeAllChild();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode == null || !(dXWidgetNode instanceof DXTabHeaderLayoutWidgetNode)) {
            return;
        }
        super.onClone(dXWidgetNode, z);
        DXTabHeaderLayoutWidgetNode dXTabHeaderLayoutWidgetNode = (DXTabHeaderLayoutWidgetNode) dXWidgetNode;
        this.indicatorBottomGap = dXTabHeaderLayoutWidgetNode.indicatorBottomGap;
        this.indicatorColor = dXTabHeaderLayoutWidgetNode.indicatorColor;
        this.indicatorHeight = dXTabHeaderLayoutWidgetNode.indicatorHeight;
        this.indicatorImageUrl = dXTabHeaderLayoutWidgetNode.indicatorImageUrl;
        this.indicatorRadius = dXTabHeaderLayoutWidgetNode.indicatorRadius;
        this.indicatorWidth = dXTabHeaderLayoutWidgetNode.indicatorWidth;
        this.indicatorZIndex = dXTabHeaderLayoutWidgetNode.indicatorZIndex;
        this.itemWidth = dXTabHeaderLayoutWidgetNode.itemWidth;
        this.relatedComponentId = dXTabHeaderLayoutWidgetNode.relatedComponentId;
        this.relatedComponentAnimated = dXTabHeaderLayoutWidgetNode.relatedComponentAnimated;
        this.selectedIndex = dXTabHeaderLayoutWidgetNode.selectedIndex;
        this.showIndicator = dXTabHeaderLayoutWidgetNode.showIndicator;
        this.simpleRenderPipeline = dXTabHeaderLayoutWidgetNode.simpleRenderPipeline;
        this.dxSelectedView = dXTabHeaderLayoutWidgetNode.dxSelectedView;
        this.unSelectedView = dXTabHeaderLayoutWidgetNode.unSelectedView;
        this.tabItemList = dXTabHeaderLayoutWidgetNode.tabItemList;
        this.currentIndex = dXTabHeaderLayoutWidgetNode.currentIndex;
        this.hasSelectedMap = dXTabHeaderLayoutWidgetNode.hasSelectedMap;
        this.itemNodes = dXTabHeaderLayoutWidgetNode.itemNodes;
        this.onTabClickListener = dXTabHeaderLayoutWidgetNode.onTabClickListener;
        this.onTabSelectedListener = dXTabHeaderLayoutWidgetNode.onTabSelectedListener;
        this.dxViewPager = dXTabHeaderLayoutWidgetNode.dxViewPager;
        this.indicatorColorMap = dXTabHeaderLayoutWidgetNode.indicatorColorMap;
        this.indicatorColorMapOrigin = dXTabHeaderLayoutWidgetNode.indicatorColorMapOrigin;
        this.enableScroll = dXTabHeaderLayoutWidgetNode.enableScroll;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXTabLayout(context);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onEndParser() {
        super.onEndParser();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        if (this.simpleRenderPipeline == null) {
            this.simpleRenderPipeline = new C6384k(getDXRuntimeContext().getEngineContext(), 3, UUID.randomUUID().toString());
        }
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        DXWidgetNode realRootExpandWidget;
        super.onRenderView(context, view);
        if ((view instanceof DXTabLayout) && (realRootExpandWidget = getDXRuntimeContext().getRealRootExpandWidget()) != null) {
            DXTabLayout dXTabLayout = (DXTabLayout) view;
            dXTabLayout.clearOnTabClickListeners();
            dXTabLayout.clearOnTabSelectedListeners();
            dXTabLayout.setViewPagerSmoothScroll(this.relatedComponentAnimated);
            renderTabItems(dXTabLayout);
            renderIndicator(dXTabLayout);
            C6461a c6461a = new C6461a(dXTabLayout);
            this.onTabSelectedListener = c6461a;
            dXTabLayout.addOnTabSelectedListener(c6461a);
            TabLayout.OnTabClickListener onTabClickListener = this.onTabClickListener;
            if (onTabClickListener != null) {
                dXTabLayout.removeOnTabClickListener(onTabClickListener);
            }
            C6462b c6462b = new C6462b();
            this.onTabClickListener = c6462b;
            dXTabLayout.addOnTabClickListener(c6462b);
            DXViewPager dXViewPager = (DXViewPager) realRootExpandWidget.queryWidgetNodeByUserId(this.relatedComponentId);
            this.dxViewPager = dXViewPager;
            if (dXViewPager != null) {
                dXViewPager.setTabLayoutWidget(this);
                if (this.dxViewPager.getDXRuntimeContext().getNativeView() != null) {
                    nz.b(TAG, "触发重新绑定");
                    bindViewPager(this.dxViewPager);
                }
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == DXTABHEADERLAYOUT_INDICATORBOTTOMGAP) {
            if (i <= 0) {
                this.indicatorBottomGap = 0;
            } else {
                this.indicatorBottomGap = i;
            }
        } else if (j == -5151416374116397110L) {
            this.indicatorColor = i;
        } else if (j == DXTABHEADERLAYOUT_INDICATORHEIGHT) {
            if (i <= 0) {
                this.indicatorHeight = 0;
            } else {
                this.indicatorHeight = i;
            }
        } else if (j == DXTABHEADERLAYOUT_INDICATORRADIUS) {
            if (i <= 0) {
                this.indicatorRadius = 0;
            } else {
                this.indicatorRadius = i;
            }
        } else if (j == DXTABHEADERLAYOUT_INDICATORWIDTH) {
            if (i <= 0) {
                this.indicatorWidth = 0;
            } else {
                this.indicatorWidth = i;
            }
        } else if (j == -5480582194049152328L) {
            if (i <= 0) {
                this.itemWidth = 0;
            } else {
                this.itemWidth = i;
            }
        } else if (j == DXTABHEADERLAYOUT_SELECTEDINDEX) {
            if (i <= 0) {
                this.selectedIndex = 0;
            } else {
                this.selectedIndex = i;
            }
            this.currentIndex = this.selectedIndex;
        } else if (j == -3765027987112450965L) {
            this.showIndicator = i == 1;
        } else if (j == DXTABHEADERLAYOUT_ENABLESCROLL) {
            this.enableScroll = i != 0;
        } else if (j == DXTABHEADERLAYOUT_INDICATORZINDEX) {
            this.indicatorZIndex = i;
        } else if (j == DXTABHEADERLAYOUT_RELATEDCOMPONENTANIMATED) {
            this.relatedComponentAnimated = i != 0;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        if (mz.DX_PARSER_LISTDATA == j) {
            setListData(jSONArray);
            setStatFlag(2);
        }
        super.onSetListAttribute(j, jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetMapAttribute(long j, JSONObject jSONObject) {
        if (j != DXTABHEADERLAYOUT_INDICATORCOLORMAP) {
            super.onSetMapAttribute(j, jSONObject);
        } else if (jSONObject == null) {
        } else {
            this.indicatorColorMapOrigin = jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == DXTABHEADERLAYOUT_INDICATORIMAGEURL) {
            this.indicatorImageUrl = str;
        } else if (j == DXTABHEADERLAYOUT_RELATEDCOMPONENTID) {
            this.relatedComponentId = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }

    public void resetHasSelectedMap() {
        Map<Integer, Boolean> map = this.hasSelectedMap;
        if (map == null) {
            this.hasSelectedMap = new HashMap();
            return;
        }
        map.clear();
        this.hasSelectedMap.put(Integer.valueOf(this.currentIndex), Boolean.TRUE);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void sendBroadcastEvent(hy hyVar) {
        if (hyVar == null) {
            return;
        }
        if (getReferenceNode() != null && isSelfResponseEvent()) {
            postEvent(hyVar);
        }
        ArrayList<DXWidgetNode> arrayList = this.itemNodes;
        if (arrayList != null) {
            Iterator<DXWidgetNode> it = arrayList.iterator();
            while (it.hasNext()) {
                DXWidgetNode next = it.next();
                if (isChildResponseEvent()) {
                    next.sendBroadcastEvent(hyVar);
                }
            }
        }
    }

    public void setSelectTab(int i) {
        DXTabLayout dXTabLayout = (DXTabLayout) getDXRuntimeContext().getNativeView();
        if (dXTabLayout == null) {
            return;
        }
        dXTabLayout.setScrollPosition(i, 0.0f, true);
    }
}
