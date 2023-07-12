package tb;

import androidx.annotation.Nullable;
import cn.damai.tetris.core.IContext;
import cn.damai.tetris.v2.adpater.VBaseViewHolder;
import cn.damai.tetris.v2.common.Addressable;
import cn.damai.tetris.v2.common.ContainerArg;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.common.OnChildAttachStateChangeListener;
import cn.damai.tetris.v2.componentplugin.SectionSensitive;
import cn.damai.tetris.v2.structure.container.ContainerProperty;
import cn.damai.tetris.v2.structure.container.IContainer;
import cn.damai.tetris.v2.structure.container.Value;
import cn.damai.tetris.v2.structure.container.ValueTarget;
import cn.damai.tetris.v2.structure.layer.ILayer;
import cn.damai.tetris.v2.structure.module.IModule;
import cn.damai.tetris.v2.structure.section.ISection;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class nt0 implements IContainer {
    private static transient /* synthetic */ IpChange $ipChange;
    private final IContext a;
    private DelegateAdapter b;
    private List<DelegateAdapter.Adapter> c;
    private List<IModule> d;
    private List<IModule> e;
    private oi f;
    private ni g;
    private ContainerProperty h;
    private SectionSensitive i;
    private ContainerArg j;
    private List<DelegateAdapter.Adapter> k;
    private HashMap<String, Value> l = new HashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements OnChildAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // cn.damai.tetris.v2.common.OnChildAttachStateChangeListener
        public void onChildAdded(Addressable addressable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-98992180")) {
                ipChange.ipc$dispatch("-98992180", new Object[]{this, addressable});
            } else if (this.a) {
                nt0.this.updateContentAdapter();
            }
        }

        @Override // cn.damai.tetris.v2.common.OnChildAttachStateChangeListener
        public void onChildRemoved(Addressable addressable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1339541844")) {
                ipChange.ipc$dispatch("-1339541844", new Object[]{this, addressable});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements OnChildAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IModule a;

        b(IModule iModule) {
            this.a = iModule;
        }

        @Override // cn.damai.tetris.v2.common.OnChildAttachStateChangeListener
        public void onChildAdded(Addressable addressable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2029611285")) {
                ipChange.ipc$dispatch("-2029611285", new Object[]{this, addressable});
            }
        }

        @Override // cn.damai.tetris.v2.common.OnChildAttachStateChangeListener
        public void onChildRemoved(Addressable addressable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1238629877")) {
                ipChange.ipc$dispatch("-1238629877", new Object[]{this, addressable});
                return;
            }
            List<DelegateAdapter.Adapter> adapterList = this.a.getAdapterList();
            if (adapterList != null) {
                for (DelegateAdapter.Adapter adapter : adapterList) {
                    if (adapter != null && adapter.getItemCount() > 0) {
                        adapter.notifyItemRangeRemoved(0, adapter.getItemCount());
                    }
                }
                nt0.this.updateContentAdapter();
            }
        }
    }

    public nt0(IContext iContext, SectionSensitive sectionSensitive) {
        this.a = iContext;
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        this.e = Collections.unmodifiableList(arrayList);
        this.c = new ArrayList();
        this.f = new oi();
        this.g = new ni();
        this.i = sectionSensitive;
    }

    private List<DelegateAdapter.Adapter> a(List<IModule> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2046348753")) {
            return (List) ipChange.ipc$dispatch("-2046348753", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (IModule iModule : list) {
                if (iModule != null) {
                    arrayList.addAll(iModule.getAdapterList());
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private void b(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2131935850")) {
            ipChange.ipc$dispatch("2131935850", new Object[]{this, jSONObject});
        } else if (jSONObject == null) {
            jb1.a("GenericContainer", "Config is null!");
        }
    }

    @Override // cn.damai.tetris.v2.structure.container.IModuleManager
    public void addModule(int i, IModule iModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "978024972")) {
            ipChange.ipc$dispatch("978024972", new Object[]{this, Integer.valueOf(i), iModule});
        } else {
            addModule(i, iModule, (OnChildAttachStateChangeListener) null);
        }
    }

    @Override // cn.damai.tetris.v2.structure.container.IContainer
    public void addSectionList(List<Node> list, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "133932280")) {
            ipChange.ipc$dispatch("133932280", new Object[]{this, list, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else if (list == null || list.isEmpty() || this.d.isEmpty()) {
        } else {
            List<IModule> list2 = this.d;
            IModule iModule = z ? list2.get(list2.size() - 1) : list2.get(0);
            if (iModule != null) {
                iModule.addSectionList(list, z, z2);
                if (z2) {
                    return;
                }
                this.f.c();
                updateContentAdapter();
            }
        }
    }

    @Override // cn.damai.tetris.v2.structure.container.IContainer
    public void addSubAdapters(List<DelegateAdapter.Adapter> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1313147241")) {
            ipChange.ipc$dispatch("-1313147241", new Object[]{this, list});
        } else {
            this.k = list;
        }
    }

    @Override // cn.damai.tetris.v2.structure.container.IModuleManager
    public synchronized void clearModuleList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902166486")) {
            ipChange.ipc$dispatch("-902166486", new Object[]{this});
            return;
        }
        this.f.c();
        this.g.onChildRemoved(null);
        this.d.clear();
        sectionListClear();
    }

    @Override // cn.damai.tetris.v2.structure.container.IModuleManager
    public IModule createModule(Node node) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-825341811") ? (IModule) ipChange.ipc$dispatch("-825341811", new Object[]{this, node}) : new ut0(this.a, node, this.f);
    }

    @Override // cn.damai.tetris.v2.structure.container.IModuleManager
    public void createModuleList(List<Node> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-131387532")) {
            ipChange.ipc$dispatch("-131387532", new Object[]{this, list});
        } else if (list == null) {
            jb1.a("GenericContainer", "Children is null!");
        } else {
            int size = this.d.size();
            for (Node node : list) {
                if (node != null) {
                    addModule(size, createModule(node));
                    size++;
                } else {
                    jb1.a("GenericContainer", "Child is null!");
                }
            }
        }
    }

    @Override // cn.damai.tetris.v2.structure.container.IContainer
    public List<DelegateAdapter.Adapter> getChildAdapters() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-215620696")) {
            return (List) ipChange.ipc$dispatch("-215620696", new Object[]{this});
        }
        if (this.f.b()) {
            return a(this.d);
        }
        return this.c;
    }

    @Override // cn.damai.tetris.v2.structure.container.IContainer
    @Nullable
    public ContainerArg getContainerArg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "685420462") ? (ContainerArg) ipChange.ipc$dispatch("685420462", new Object[]{this}) : this.j;
    }

    @Override // cn.damai.tetris.v2.structure.container.IContainer
    public <T> T getContainerValue(String str, ValueTarget<T> valueTarget) {
        Value value;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1271025858")) {
            return (T) ipChange.ipc$dispatch("-1271025858", new Object[]{this, str, valueTarget});
        }
        if (this.l.containsKey(str) && (value = this.l.get(str)) != null && value.objClass == valueTarget.getValueClass()) {
            return value.obj;
        }
        return valueTarget.getDefault();
    }

    @Override // cn.damai.tetris.v2.structure.container.IContainer
    public DelegateAdapter getContentAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1552934316") ? (DelegateAdapter) ipChange.ipc$dispatch("1552934316", new Object[]{this}) : this.b;
    }

    @Override // cn.damai.tetris.v2.common.Addressable
    public ho getCoordinate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2144734834") ? (ho) ipChange.ipc$dispatch("-2144734834", new Object[]{this}) : new ho(-2, -2, -2);
    }

    @Override // cn.damai.tetris.v2.common.Addressable
    public int getIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2134809824")) {
            return ((Integer) ipChange.ipc$dispatch("2134809824", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // cn.damai.tetris.v2.structure.container.IContainer
    public List<ILayer> getLayerList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-213287369")) {
            return (List) ipChange.ipc$dispatch("-213287369", new Object[]{this});
        }
        if (this.d.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (IModule iModule : this.d) {
                List<ILayer> layerList = iModule.getLayerList();
                if (layerList != null && layerList.size() > 0) {
                    arrayList.addAll(layerList);
                }
            }
            return arrayList;
        }
        return null;
    }

    @Override // cn.damai.tetris.v2.structure.container.IModuleManager
    public List<IModule> getModuleList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1394784410") ? (List) ipChange.ipc$dispatch("-1394784410", new Object[]{this}) : this.e;
    }

    @Override // cn.damai.tetris.v2.structure.container.IContainer
    public ContainerProperty getProperty() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2063744763") ? (ContainerProperty) ipChange.ipc$dispatch("2063744763", new Object[]{this}) : this.h;
    }

    @Override // cn.damai.tetris.v2.structure.container.IContainer
    public void init(Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-730488902")) {
            ipChange.ipc$dispatch("-730488902", new Object[]{this, node});
        } else if (node == null) {
            jb1.a("GenericContainer", "Node is null!");
        } else {
            b(node.data);
            clearModuleList();
            createModuleList(node.children);
            updateContentAdapter();
        }
    }

    @Override // cn.damai.tetris.v2.structure.container.IContainer
    public void removeContainerValue(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1509083521")) {
            ipChange.ipc$dispatch("-1509083521", new Object[]{this, str});
        } else {
            this.l.remove(str);
        }
    }

    @Override // cn.damai.tetris.v2.structure.container.IModuleManager
    public void removeModule(IModule iModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1107694590")) {
            ipChange.ipc$dispatch("-1107694590", new Object[]{this, iModule});
        } else {
            removeModule(iModule, (OnChildAttachStateChangeListener) null);
        }
    }

    @Override // cn.damai.tetris.v2.structure.container.IModuleManager
    public void replaceModule(int i, IModule iModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306423143")) {
            ipChange.ipc$dispatch("-1306423143", new Object[]{this, Integer.valueOf(i), iModule});
        }
    }

    @Override // cn.damai.tetris.v2.structure.container.IContainer
    public <T> void saveContainerValue(String str, Class<T> cls, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2080710707")) {
            ipChange.ipc$dispatch("2080710707", new Object[]{this, str, cls, t});
        } else {
            this.l.put(str, new Value(cls, t));
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.SectionSensitive
    public void sectionBindViewHolder(ISection iSection, VBaseViewHolder vBaseViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "197369098")) {
            ipChange.ipc$dispatch("197369098", new Object[]{this, iSection, vBaseViewHolder});
            return;
        }
        SectionSensitive sectionSensitive = this.i;
        if (sectionSensitive != null) {
            sectionSensitive.sectionBindViewHolder(iSection, vBaseViewHolder);
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.SectionSensitive
    public void sectionChanged(ISection iSection, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2037999737")) {
            ipChange.ipc$dispatch("-2037999737", new Object[]{this, iSection, Boolean.valueOf(z)});
            return;
        }
        SectionSensitive sectionSensitive = this.i;
        if (sectionSensitive != null) {
            sectionSensitive.sectionChanged(iSection, z);
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.SectionSensitive
    public void sectionListChanged(List<ISection> list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-314122197")) {
            ipChange.ipc$dispatch("-314122197", new Object[]{this, list, Boolean.valueOf(z)});
            return;
        }
        SectionSensitive sectionSensitive = this.i;
        if (sectionSensitive != null) {
            sectionSensitive.sectionListChanged(list, z);
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.SectionSensitive
    public void sectionListClear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2046197153")) {
            ipChange.ipc$dispatch("-2046197153", new Object[]{this});
            return;
        }
        SectionSensitive sectionSensitive = this.i;
        if (sectionSensitive != null) {
            sectionSensitive.sectionListClear();
        }
    }

    @Override // cn.damai.tetris.v2.structure.container.IContainer
    public void setContainerArg(ContainerArg containerArg) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-615193288")) {
            ipChange.ipc$dispatch("-615193288", new Object[]{this, containerArg});
        } else {
            this.j = containerArg;
        }
    }

    @Override // cn.damai.tetris.v2.structure.container.IContainer
    public void setContentAdapter(DelegateAdapter delegateAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-991114434")) {
            ipChange.ipc$dispatch("-991114434", new Object[]{this, delegateAdapter});
        } else {
            this.b = delegateAdapter;
        }
    }

    @Override // cn.damai.tetris.v2.common.Addressable
    public void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-991349718")) {
            ipChange.ipc$dispatch("-991349718", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.tetris.v2.structure.container.IContainer
    public void updateContentAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1422714518")) {
            ipChange.ipc$dispatch("-1422714518", new Object[]{this});
        } else if (this.b != null) {
            this.c = getChildAdapters();
            if (this.f.b()) {
                this.f.a();
            }
            this.b.setAdapters(this.c);
            DelegateAdapter delegateAdapter = this.b;
            delegateAdapter.addAdapters(delegateAdapter.getAdaptersCount(), this.k);
            this.b.notifyDataSetChanged();
        }
    }

    @Override // cn.damai.tetris.v2.structure.container.IModuleManager
    public void addModule(int i, IModule iModule, OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-14904260")) {
            ipChange.ipc$dispatch("-14904260", new Object[]{this, Integer.valueOf(i), iModule, onChildAttachStateChangeListener});
            return;
        }
        jb1.a("GenericContainer", "addModule  index is " + i + ", old module list size " + this.d.size());
        this.f.c();
        iModule.setIndex(i);
        this.d.add(i, iModule);
        this.g.onChildAdded(iModule);
        if (onChildAttachStateChangeListener != null) {
            onChildAttachStateChangeListener.onChildAdded(iModule);
        }
    }

    @Override // cn.damai.tetris.v2.structure.container.IModuleManager
    public void removeModule(IModule iModule, OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "850116914")) {
            ipChange.ipc$dispatch("850116914", new Object[]{this, iModule, onChildAttachStateChangeListener});
            return;
        }
        jb1.a("GenericContainer", "removeModule  index is " + iModule.getIndex() + ", adapter size " + this.c.size() + ", module size " + this.d.size());
        this.f.c();
        this.d.remove(iModule);
        this.g.onChildRemoved(iModule);
        if (onChildAttachStateChangeListener != null) {
            onChildAttachStateChangeListener.onChildRemoved(iModule);
        }
    }

    @Override // cn.damai.tetris.v2.structure.container.IModuleManager
    public void addModule(int i, IModule iModule, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "254048840")) {
            ipChange.ipc$dispatch("254048840", new Object[]{this, Integer.valueOf(i), iModule, Boolean.valueOf(z)});
        } else {
            addModule(i, iModule, new a(z));
        }
    }

    @Override // cn.damai.tetris.v2.structure.container.IModuleManager
    public void removeModule(IModule iModule, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "21251858")) {
            ipChange.ipc$dispatch("21251858", new Object[]{this, iModule, Boolean.valueOf(z)});
        } else {
            removeModule(iModule, new b(iModule));
        }
    }
}
