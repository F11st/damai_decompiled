package anet.channel.strategy;

import anet.channel.entity.ConnType;
import anet.channel.statist.AmdcResultStat;
import anet.channel.strategy.b;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import tb.lw2;
import tb.x6;
import tb.ym;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class StrategyEntity implements Serializable {
    private static final String TAG = "awcn.StrategyEntity";
    private static final long serialVersionUID = 5740869364580937958L;
    private transient AmdcResultStat amdcResultStat;
    private boolean containsStaticIp;
    private transient Comparator<IPConnStrategy> defaultComparator;
    private Map<Integer, ConnHistoryItem> historyItemMap;
    private List<IPConnStrategy> ipStrategyList;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface Predicate<T> {
        boolean apply(T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements Predicate<IPConnStrategy> {
        final /* synthetic */ b.c a;
        final /* synthetic */ String b;
        final /* synthetic */ ConnProtocol c;

        a(StrategyEntity strategyEntity, b.c cVar, String str, ConnProtocol connProtocol) {
            this.a = cVar;
            this.b = str;
            this.c = connProtocol;
        }

        @Override // anet.channel.strategy.StrategyEntity.Predicate
        /* renamed from: a */
        public boolean apply(IPConnStrategy iPConnStrategy) {
            return iPConnStrategy.getPort() == this.a.a && iPConnStrategy.getIp().equals(this.b) && iPConnStrategy.protocol.equals(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements Comparator<IPConnStrategy> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(IPConnStrategy iPConnStrategy, IPConnStrategy iPConnStrategy2) {
            int i;
            int i2;
            ConnHistoryItem connHistoryItem = (ConnHistoryItem) StrategyEntity.this.historyItemMap.get(Integer.valueOf(iPConnStrategy.getUniqueId()));
            ConnHistoryItem connHistoryItem2 = (ConnHistoryItem) StrategyEntity.this.historyItemMap.get(Integer.valueOf(iPConnStrategy2.getUniqueId()));
            if (connHistoryItem == null) {
                connHistoryItem = new ConnHistoryItem();
                StrategyEntity.this.historyItemMap.put(Integer.valueOf(iPConnStrategy.getUniqueId()), connHistoryItem);
            }
            if (connHistoryItem2 == null) {
                connHistoryItem2 = new ConnHistoryItem();
                StrategyEntity.this.historyItemMap.put(Integer.valueOf(iPConnStrategy2.getUniqueId()), connHistoryItem2);
            }
            int countFail = connHistoryItem.countFail();
            int countFail2 = connHistoryItem2.countFail();
            if (countFail != countFail2) {
                return countFail - countFail2;
            }
            if (iPConnStrategy.ipType != iPConnStrategy2.ipType) {
                i = iPConnStrategy.ipType;
                i2 = iPConnStrategy2.ipType;
            } else {
                i = iPConnStrategy.protocol.isHttp;
                i2 = iPConnStrategy2.protocol.isHttp;
            }
            return i - i2;
        }
    }

    public StrategyEntity() {
        this.ipStrategyList = new ArrayList();
        this.historyItemMap = new SerialLruCache(40);
        this.containsStaticIp = false;
        this.defaultComparator = null;
        this.amdcResultStat = new AmdcResultStat();
    }

    private static <T> int find(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null) {
            return -1;
        }
        int i = 0;
        Iterator<T> it = collection.iterator();
        while (it.hasNext() && !predicate.apply(it.next())) {
            i++;
        }
        if (i == collection.size()) {
            return -1;
        }
        return i;
    }

    private Comparator getDefaultComparator() {
        if (this.defaultComparator == null) {
            this.defaultComparator = new b();
        }
        return this.defaultComparator;
    }

    private void handleUpdate(String str, int i, b.c cVar) {
        ConnProtocol valueOf = ConnProtocol.valueOf(cVar);
        int find = find(this.ipStrategyList, new a(this, cVar, str, valueOf));
        if (find != -1) {
            IPConnStrategy iPConnStrategy = this.ipStrategyList.get(find);
            iPConnStrategy.cto = cVar.c;
            iPConnStrategy.rto = cVar.d;
            iPConnStrategy.heartbeat = cVar.f;
            iPConnStrategy.ipType = i;
            iPConnStrategy.ipSource = 0;
            iPConnStrategy.isToRemove = false;
            if (this.historyItemMap.containsKey(Integer.valueOf(iPConnStrategy.getUniqueId()))) {
                return;
            }
            this.historyItemMap.put(Integer.valueOf(iPConnStrategy.getUniqueId()), new ConnHistoryItem());
            return;
        }
        IPConnStrategy create = IPConnStrategy.create(str, cVar);
        if (create != null) {
            create.ipType = i;
            create.ipSource = 0;
            if (!this.historyItemMap.containsKey(Integer.valueOf(create.getUniqueId()))) {
                this.historyItemMap.put(Integer.valueOf(create.getUniqueId()), new ConnHistoryItem());
            }
            this.ipStrategyList.add(create);
        }
        if (lw2.d(str)) {
            this.amdcResultStat.isContainIpv6 = true;
        }
        if (ConnType.HTTP3.equals(valueOf.protocol) || ConnType.HTTP3_PLAIN.equals(valueOf.protocol)) {
            this.amdcResultStat.isContainHttp3 = true;
        }
    }

    public void checkInit() {
        if (this.ipStrategyList == null) {
            this.ipStrategyList = new ArrayList();
        }
        if (this.historyItemMap == null) {
            this.historyItemMap = new SerialLruCache(40);
        }
        Iterator<Map.Entry<Integer, ConnHistoryItem>> it = this.historyItemMap.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().isExpire()) {
                it.remove();
            }
        }
        for (IPConnStrategy iPConnStrategy : this.ipStrategyList) {
            if (!this.historyItemMap.containsKey(Integer.valueOf(iPConnStrategy.getUniqueId()))) {
                this.historyItemMap.put(Integer.valueOf(iPConnStrategy.getUniqueId()), new ConnHistoryItem());
            }
        }
        Collections.sort(this.ipStrategyList, getDefaultComparator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<Integer, ConnHistoryItem> getHistoryItemMap() {
        return this.historyItemMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<IPConnStrategy> getIpStrategyList() {
        return this.ipStrategyList;
    }

    public List<IConnStrategy> getStrategyList() {
        if (this.ipStrategyList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        LinkedList linkedList = null;
        for (IPConnStrategy iPConnStrategy : this.ipStrategyList) {
            ConnHistoryItem connHistoryItem = this.historyItemMap.get(Integer.valueOf(iPConnStrategy.getUniqueId()));
            if (connHistoryItem != null && connHistoryItem.shouldBan()) {
                ALog.f(TAG, "strategy ban!", null, "strategy", iPConnStrategy);
            } else {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(iPConnStrategy);
            }
        }
        return linkedList == null ? Collections.EMPTY_LIST : linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isContainsStaticIp() {
        return this.containsStaticIp;
    }

    public void notifyConnEvent(IConnStrategy iConnStrategy, ym ymVar) {
        try {
            if (!(iConnStrategy instanceof IPConnStrategy) || this.ipStrategyList.indexOf(iConnStrategy) == -1) {
                return;
            }
            IPConnStrategy iPConnStrategy = (IPConnStrategy) iConnStrategy;
            iPConnStrategy.status = ymVar.a ? 1 : 0;
            this.historyItemMap.get(Integer.valueOf(iPConnStrategy.getUniqueId())).update(ymVar.a);
            Collections.sort(this.ipStrategyList, this.defaultComparator);
        } catch (Exception unused) {
        }
    }

    public boolean shouldRefresh() {
        boolean z = true;
        boolean z2 = true;
        for (IPConnStrategy iPConnStrategy : this.ipStrategyList) {
            if (!this.historyItemMap.get(Integer.valueOf(iPConnStrategy.getUniqueId())).latestFail()) {
                if (iPConnStrategy.ipType == 0) {
                    z = false;
                }
                z2 = false;
            }
        }
        return (this.containsStaticIp && z) || z2;
    }

    public String toString() {
        return new ArrayList(this.ipStrategyList).toString();
    }

    public void update(b.d dVar) {
        for (IPConnStrategy iPConnStrategy : this.ipStrategyList) {
            iPConnStrategy.isToRemove = true;
        }
        this.amdcResultStat = new AmdcResultStat();
        int i = 0;
        while (true) {
            b.i[] iVarArr = dVar.k;
            if (i >= iVarArr.length) {
                break;
            }
            boolean z = iVarArr[i].c;
            b.C0015b[] c0015bArr = iVarArr[i].a;
            if (c0015bArr != null && c0015bArr.length != 0) {
                for (int i2 = 0; i2 < c0015bArr.length; i2++) {
                    b.c[] cVarArr = c0015bArr[i2].b;
                    String[] strArr = c0015bArr[i2].a;
                    if (cVarArr != null && cVarArr.length != 0 && strArr != null && strArr.length != 0) {
                        for (b.c cVar : cVarArr) {
                            for (String str : strArr) {
                                handleUpdate(str, !z ? 1 : 0, cVar);
                            }
                        }
                    }
                }
                if (z) {
                    this.containsStaticIp = true;
                }
            }
            i++;
        }
        ListIterator<IPConnStrategy> listIterator = this.ipStrategyList.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().isToRemove) {
                listIterator.remove();
            }
        }
        try {
            Collections.sort(this.ipStrategyList, getDefaultComparator());
        } catch (Exception e) {
            this.amdcResultStat.code = -100;
            ALog.d(TAG, "strategy sort error!", null, e, new Object[0]);
        }
        AmdcResultStat amdcResultStat = this.amdcResultStat;
        amdcResultStat.host = dVar.a;
        amdcResultStat.trace = TAG;
        ALog.c(TAG, amdcResultStat.toString(), null, new Object[0]);
        x6.b().commitStat(this.amdcResultStat);
    }

    StrategyEntity(List<IPConnStrategy> list) {
        this.ipStrategyList = new ArrayList();
        this.historyItemMap = new SerialLruCache(40);
        this.containsStaticIp = false;
        this.defaultComparator = null;
        this.amdcResultStat = new AmdcResultStat();
        this.ipStrategyList = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StrategyEntity(List<IPConnStrategy> list, Map<Integer, ConnHistoryItem> map, boolean z) {
        this.ipStrategyList = new ArrayList();
        this.historyItemMap = new SerialLruCache(40);
        this.containsStaticIp = false;
        this.defaultComparator = null;
        this.amdcResultStat = new AmdcResultStat();
        this.ipStrategyList = list;
        this.historyItemMap = map;
        this.containsStaticIp = z;
    }
}
