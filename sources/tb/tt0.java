package tb;

import cn.damai.tetris.core.IContext;
import cn.damai.tetris.v2.adpater.VBaseAdapter;
import cn.damai.tetris.v2.common.Addressable;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.common.OnChildAttachStateChangeListener;
import cn.damai.tetris.v2.structure.container.IContainer;
import cn.damai.tetris.v2.structure.layer.ILayer;
import cn.damai.tetris.v2.structure.layer.LayerProperty;
import cn.damai.tetris.v2.structure.module.IModule;
import cn.damai.tetris.v2.structure.section.ISection;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class tt0 implements ILayer {
    private static transient /* synthetic */ IpChange $ipChange;
    private final IContext a;
    private LayerProperty b;
    private DelegateAdapter.Adapter c;
    private o3 d;
    private List<ISection> e;
    private List<ISection> f;
    private String g;
    private JSONObject h;
    private IModule i;
    private int j = -1;
    private ni k = new ni();
    private String l;
    private String m;

    /* compiled from: Taobao */
    /* renamed from: tb.tt0$a */
    /* loaded from: classes7.dex */
    public class C9732a implements OnChildAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ int b;

        C9732a(boolean z, int i) {
            this.a = z;
            this.b = i;
        }

        @Override // cn.damai.tetris.v2.common.OnChildAttachStateChangeListener
        public void onChildAdded(Addressable addressable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2072260020")) {
                ipChange.ipc$dispatch("-2072260020", new Object[]{this, addressable});
            } else if (this.a) {
                if (tt0.this.c != null) {
                    tt0.this.c.notifyItemInserted(this.b);
                }
                if (tt0.this.getContainer() != null) {
                    tt0.this.getContainer().updateContentAdapter();
                }
            }
        }

        @Override // cn.damai.tetris.v2.common.OnChildAttachStateChangeListener
        public void onChildRemoved(Addressable addressable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "725608748")) {
                ipChange.ipc$dispatch("725608748", new Object[]{this, addressable});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.tt0$b */
    /* loaded from: classes7.dex */
    public class C9733b implements OnChildAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ ISection b;

        C9733b(boolean z, ISection iSection) {
            this.a = z;
            this.b = iSection;
        }

        @Override // cn.damai.tetris.v2.common.OnChildAttachStateChangeListener
        public void onChildAdded(Addressable addressable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "292088171")) {
                ipChange.ipc$dispatch("292088171", new Object[]{this, addressable});
            }
        }

        @Override // cn.damai.tetris.v2.common.OnChildAttachStateChangeListener
        public void onChildRemoved(Addressable addressable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "826520715")) {
                ipChange.ipc$dispatch("826520715", new Object[]{this, addressable});
            } else if (!this.a || tt0.this.c == null) {
            } else {
                tt0.this.c.notifyItemRemoved(this.b.getIndex());
            }
        }
    }

    public tt0(IContext iContext, Node node) {
        this.a = iContext;
        this.d = new o3(iContext.getActivity());
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        this.f = Collections.unmodifiableList(arrayList);
        if (node != null) {
            d(node.data);
            createSectionList(node.children, false);
            return;
        }
        jb1.a("GenericLayer", "Node is null when construct!");
    }

    private void d(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-867896086")) {
            ipChange.ipc$dispatch("-867896086", new Object[]{this, jSONObject});
        } else if (jSONObject == null) {
            jb1.a("GenericLayer", "Config is null when initProperties!");
        } else {
            if (jSONObject.containsKey(Constants.LAYOUT_TYPE)) {
                this.g = jSONObject.getString(Constants.LAYOUT_TYPE);
            }
            if (jSONObject.containsKey("layoutParams")) {
                this.h = jSONObject.getJSONObject("layoutParams");
            }
            if (jSONObject.containsKey("layer_server_cid")) {
                this.l = jSONObject.getString("layer_server_cid");
            }
            if (jSONObject.containsKey("key_layer_id")) {
                this.m = jSONObject.getString("key_layer_id");
            }
        }
    }

    @Override // cn.damai.tetris.v2.structure.layer.ISectionManager
    public void addSection(int i, ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1272001897")) {
            ipChange.ipc$dispatch("1272001897", new Object[]{this, Integer.valueOf(i), iSection});
        } else {
            addSection(i, iSection, (OnChildAttachStateChangeListener) null);
        }
    }

    @Override // cn.damai.tetris.v2.structure.layer.ISectionManager
    public void addSectionListEnd(List<Node> list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "903714043")) {
            ipChange.ipc$dispatch("903714043", new Object[]{this, list, Boolean.valueOf(z)});
        } else if (list == null) {
            jb1.a("GenericLayer", "Children is null when addSectionListEnd!");
        } else {
            ArrayList arrayList = new ArrayList();
            for (Node node : list) {
                if (node != null) {
                    arrayList.add(createSection(node));
                } else {
                    jb1.a("GenericLayer", "Child is null!");
                }
            }
            if (arrayList.size() == 0) {
                return;
            }
            this.k.b(true);
            DelegateAdapter.Adapter adapter = this.c;
            if (adapter == null || !(adapter instanceof VBaseAdapter)) {
                return;
            }
            VBaseAdapter vBaseAdapter = (VBaseAdapter) adapter;
            int itemCount = vBaseAdapter.getItemCount();
            vBaseAdapter.a(arrayList);
            if (z) {
                this.c.notifyItemRangeInserted(itemCount, arrayList.size());
            }
        }
    }

    @Override // cn.damai.tetris.v2.structure.layer.ISectionManager
    public void addSectionListHead(List<Node> list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1109370588")) {
            ipChange.ipc$dispatch("1109370588", new Object[]{this, list, Boolean.valueOf(z)});
        } else if (list == null) {
            jb1.a("GenericLayer", "Children is null when addSectionListHead!");
        } else {
            ArrayList arrayList = new ArrayList();
            for (Node node : list) {
                if (node != null) {
                    arrayList.add(createSection(node));
                } else {
                    jb1.a("GenericLayer", "Child is null!");
                }
            }
            this.k.b(true);
            DelegateAdapter.Adapter adapter = this.c;
            if (adapter == null || !(adapter instanceof VBaseAdapter)) {
                return;
            }
            ((VBaseAdapter) adapter).b(arrayList);
            if (z) {
                this.c.notifyItemRangeInserted(0, arrayList.size());
            }
        }
    }

    public VBaseAdapter b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1228734365")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("1228734365", new Object[]{this});
        }
        IContext iContext = this.a;
        if (iContext != null) {
            IContainer container = iContext.getContainer();
            nm<Map<String, Object>> nmVar = new nm<>(this.a);
            String str = this.g;
            if (str == null) {
                str = "default";
            }
            nmVar.e(str);
            HashMap hashMap = new HashMap();
            hashMap.put("data", this.e);
            JSONObject jSONObject = this.h;
            if (jSONObject != null) {
                hashMap.putAll(jSONObject);
            }
            nmVar.d(hashMap);
            VBaseAdapter create = this.d.create(nmVar);
            create.j(container);
            return create;
        }
        return null;
    }

    public String c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "639667708") ? (String) ipChange.ipc$dispatch("639667708", new Object[]{this}) : this.l;
    }

    @Override // cn.damai.tetris.v2.structure.layer.ISectionManager
    public void clearSectionList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1441369421")) {
            ipChange.ipc$dispatch("-1441369421", new Object[]{this});
            return;
        }
        IContainer container = getContainer();
        if (this.e.size() > 0 && container != null) {
            container.sectionListChanged(this.e, false);
        }
        this.e.clear();
    }

    @Override // cn.damai.tetris.v2.structure.layer.ISectionManager
    public ISection createSection(Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1896559728")) {
            return (ISection) ipChange.ipc$dispatch("1896559728", new Object[]{this, node});
        }
        vt0 vt0Var = new vt0(this.a, node);
        vt0Var.setLayer(this);
        return vt0Var;
    }

    @Override // cn.damai.tetris.v2.structure.layer.ISectionManager
    public void createSectionList(List<Node> list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1424741577")) {
            ipChange.ipc$dispatch("1424741577", new Object[]{this, list, Boolean.valueOf(z)});
        } else if (list == null) {
            jb1.a("GenericLayer", "Children is null when createSections!");
        } else {
            int size = this.e.size();
            for (Node node : list) {
                if (node != null) {
                    addSection(size, createSection(node));
                    size++;
                } else {
                    jb1.a("GenericLayer", "Child is null!");
                }
            }
            DelegateAdapter.Adapter adapter = this.c;
            if (adapter == null || !(adapter instanceof VBaseAdapter)) {
                return;
            }
            ((VBaseAdapter) adapter).g(this.e.size());
            if (z) {
                this.c.notifyDataSetChanged();
            }
        }
    }

    @Override // cn.damai.tetris.v2.structure.layer.ILayer
    public synchronized DelegateAdapter.Adapter getAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "735737212")) {
            return (DelegateAdapter.Adapter) ipChange.ipc$dispatch("735737212", new Object[]{this});
        }
        if (this.c == null) {
            this.c = b();
        }
        return this.c;
    }

    @Override // cn.damai.tetris.v2.structure.layer.ILayer
    public int getChildCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-675758485") ? ((Integer) ipChange.ipc$dispatch("-675758485", new Object[]{this})).intValue() : this.e.size();
    }

    @Override // cn.damai.tetris.v2.structure.layer.ILayer
    public IContainer getContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-616835051")) {
            return (IContainer) ipChange.ipc$dispatch("-616835051", new Object[]{this});
        }
        IContext iContext = this.a;
        if (iContext == null) {
            return null;
        }
        return iContext.getContainer();
    }

    @Override // cn.damai.tetris.v2.common.Addressable
    public ho getCoordinate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-458445042")) {
            return (ho) ipChange.ipc$dispatch("-458445042", new Object[]{this});
        }
        return new ho(getModule() == null ? -1 : getModule().getIndex(), getIndex(), -2);
    }

    @Override // cn.damai.tetris.v2.common.Addressable
    public int getIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1730266528")) {
            return ((Integer) ipChange.ipc$dispatch("-1730266528", new Object[]{this})).intValue();
        }
        IModule iModule = this.i;
        if (iModule != null) {
            iModule.updateChildIndex();
        }
        return this.j;
    }

    @Override // cn.damai.tetris.v2.structure.layer.ILayer
    public String getLayerId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "696332493") ? (String) ipChange.ipc$dispatch("696332493", new Object[]{this}) : this.m;
    }

    @Override // cn.damai.tetris.v2.structure.layer.ILayer
    public IModule getModule() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "496134026") ? (IModule) ipChange.ipc$dispatch("496134026", new Object[]{this}) : this.i;
    }

    @Override // cn.damai.tetris.v2.structure.layer.ILayer
    public LayerProperty getProperty() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1622398501") ? (LayerProperty) ipChange.ipc$dispatch("-1622398501", new Object[]{this}) : this.b;
    }

    @Override // cn.damai.tetris.v2.structure.layer.ISectionManager
    public List<ISection> getSectionList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-801858101") ? (List) ipChange.ipc$dispatch("-801858101", new Object[]{this}) : this.f;
    }

    @Override // cn.damai.tetris.v2.structure.layer.ISectionManager
    public void removeSection(ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1892479673")) {
            ipChange.ipc$dispatch("-1892479673", new Object[]{this, iSection});
        } else {
            removeSection(iSection, (OnChildAttachStateChangeListener) null);
        }
    }

    @Override // cn.damai.tetris.v2.common.Addressable
    public void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-549632342")) {
            ipChange.ipc$dispatch("-549632342", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.j = i;
        }
    }

    @Override // cn.damai.tetris.v2.structure.layer.ILayer
    public void setModule(IModule iModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "501483912")) {
            ipChange.ipc$dispatch("501483912", new Object[]{this, iModule});
        } else {
            this.i = iModule;
        }
    }

    @Override // cn.damai.tetris.v2.structure.layer.ISectionManager
    public void updateChildIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31714282")) {
            ipChange.ipc$dispatch("31714282", new Object[]{this});
        } else if (this.k.a()) {
            this.k.c(this.e);
        }
    }

    @Override // cn.damai.tetris.v2.structure.layer.ISectionManager
    public void updateSectionList(List<Node> list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734443868")) {
            ipChange.ipc$dispatch("1734443868", new Object[]{this, list, Boolean.valueOf(z)});
        } else if (list == null) {
            jb1.a("GenericLayer", "Children is null when createSections!");
        } else if (z) {
            int size = this.e.size();
            createSectionList(list, false);
            DelegateAdapter.Adapter adapter = this.c;
            if (adapter != null) {
                if (adapter instanceof VBaseAdapter) {
                    ((VBaseAdapter) adapter).g(this.e.size());
                }
                this.c.notifyItemRangeInserted(size, this.e.size());
            }
        } else {
            clearSectionList();
            createSectionList(list, false);
            DelegateAdapter.Adapter adapter2 = this.c;
            if (adapter2 != null) {
                if (adapter2 instanceof VBaseAdapter) {
                    ((VBaseAdapter) adapter2).g(this.e.size());
                }
                this.c.notifyItemRangeChanged(0, this.e.size());
            }
        }
    }

    @Override // cn.damai.tetris.v2.structure.layer.ISectionManager
    public void addSection(int i, ISection iSection, OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1675944423")) {
            ipChange.ipc$dispatch("-1675944423", new Object[]{this, Integer.valueOf(i), iSection, onChildAttachStateChangeListener});
            return;
        }
        this.e.add(i, iSection);
        iSection.setIndex(i);
        this.k.onChildAdded(iSection);
        IContainer container = getContainer();
        if (container != null) {
            container.sectionChanged(iSection, true);
        }
        if (onChildAttachStateChangeListener != null) {
            onChildAttachStateChangeListener.onChildAdded(iSection);
        }
    }

    @Override // cn.damai.tetris.v2.structure.layer.ISectionManager
    public void removeSection(ISection iSection, OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1412848393")) {
            ipChange.ipc$dispatch("-1412848393", new Object[]{this, iSection, onChildAttachStateChangeListener});
            return;
        }
        this.e.remove(iSection);
        this.k.onChildRemoved(iSection);
        IContainer container = getContainer();
        if (container != null) {
            container.sectionChanged(iSection, false);
        }
        if (onChildAttachStateChangeListener != null) {
            onChildAttachStateChangeListener.onChildRemoved(iSection);
        }
    }

    @Override // cn.damai.tetris.v2.structure.layer.ISectionManager
    public void removeSection(ISection iSection, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462718061")) {
            ipChange.ipc$dispatch("1462718061", new Object[]{this, iSection, Boolean.valueOf(z)});
        } else {
            removeSection(iSection, new C9733b(z, iSection));
        }
    }

    @Override // cn.damai.tetris.v2.structure.layer.ISectionManager
    public void addSection(int i, ISection iSection, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "777398923")) {
            ipChange.ipc$dispatch("777398923", new Object[]{this, Integer.valueOf(i), iSection, Boolean.valueOf(z)});
        } else {
            addSection(i, iSection, new C9732a(z, i));
        }
    }
}
