package tb;

import android.text.TextUtils;
import android.util.LruCache;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.template.download.DXTemplatePackageInfo;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class q10 {
    private ConcurrentHashMap<String, JSONObject> a;
    private final Map<String, Map<String, LinkedList<DXTemplateItem>>> b;
    private final DXLongSparseArray<b> c;
    private final Map<String, Set<Long>> d;
    private final LruCache<String, Integer> e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class b {
        Map<String, LinkedList<DXTemplateItem>> a;

        private b(q10 q10Var) {
            this.a = new HashMap();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class c {
        private static final q10 a = new q10();
    }

    private DXTemplateItem b(String str, DXTemplateItem dXTemplateItem) {
        JSONObject jSONObject = this.a.get(str);
        if (jSONObject != null && !jSONObject.isEmpty()) {
            return d(str, dXTemplateItem, jSONObject);
        }
        return c(str, dXTemplateItem);
    }

    private DXTemplateItem c(String str, DXTemplateItem dXTemplateItem) {
        StringBuilder sb = new StringBuilder(dz.c().a());
        sb.append(str);
        sb.append(r10.DIR);
        sb.append(dXTemplateItem.name);
        long a2 = r10.a(com.taobao.android.dinamicx.template.download.b.a(sb.toString()));
        if (a2 < 0) {
            return null;
        }
        DXTemplateItem dXTemplateItem2 = new DXTemplateItem();
        dXTemplateItem2.name = dXTemplateItem.name;
        dXTemplateItem2.version = a2;
        sb.append(r10.DIR);
        sb.append(a2);
        String sb2 = sb.toString();
        String[] a3 = com.taobao.android.dinamicx.template.download.b.a(sb2);
        if (a3 != null) {
            HashMap hashMap = new HashMap();
            for (String str2 : a3) {
                hashMap.put(str2, sb2 + r10.DIR + str2);
            }
            String str3 = hashMap.get(r10.DX_MAIN_TEMPLATE_NAME);
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            hashMap.remove(r10.DX_MAIN_TEMPLATE_NAME);
            dXTemplateItem2.isPreset = true;
            DXTemplatePackageInfo dXTemplatePackageInfo = new DXTemplatePackageInfo();
            dXTemplateItem2.packageInfo = dXTemplatePackageInfo;
            dXTemplatePackageInfo.subFilePathDict = hashMap.isEmpty() ? null : hashMap;
            dXTemplateItem2.packageInfo.mainFilePath = str3;
        }
        return dXTemplateItem2;
    }

    private DXTemplateItem d(String str, DXTemplateItem dXTemplateItem, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject(dXTemplateItem.name);
        if (jSONObject2 != null && !jSONObject2.isEmpty()) {
            long longValue = jSONObject2.getLongValue("version");
            if (longValue <= 0) {
                if (DinamicXEngine.x()) {
                    nz.u("DXTemplateInfoManager", str + '|' + dXTemplateItem.name + "内置索引文件版本号非数字或版本号小于1");
                }
                return null;
            }
            String string = jSONObject2.getString(r10.DX_MAIN_TEMPLATE_NAME);
            if (TextUtils.isEmpty(string)) {
                if (DinamicXEngine.x()) {
                    nz.u("DXTemplateInfoManager", str + '|' + dXTemplateItem.name + "内置索引文件缺少主模板路径");
                }
                return null;
            }
            DXTemplateItem dXTemplateItem2 = new DXTemplateItem();
            dXTemplateItem2.name = dXTemplateItem.name;
            dXTemplateItem2.version = longValue;
            dXTemplateItem2.isPreset = true;
            DXTemplatePackageInfo dXTemplatePackageInfo = new DXTemplatePackageInfo();
            dXTemplateItem2.packageInfo = dXTemplatePackageInfo;
            dXTemplatePackageInfo.mainFilePath = string;
            JSONObject jSONObject3 = jSONObject2.getJSONObject("other");
            if (jSONObject3 != null && !jSONObject3.isEmpty()) {
                dXTemplateItem2.packageInfo.subFilePathDict = new HashMap();
                for (String str2 : jSONObject3.keySet()) {
                    dXTemplateItem2.packageInfo.subFilePathDict.put(str2, jSONObject3.getString(str2));
                }
            }
            return dXTemplateItem2;
        }
        if (DinamicXEngine.x()) {
            nz.i("DXTemplateInfoManager", str + '|' + dXTemplateItem.name + "无内置");
        }
        return null;
    }

    public static q10 f() {
        return c.a;
    }

    private boolean j(String str, long j, DXTemplateItem dXTemplateItem) {
        return j != 0 && r10.c(str, dXTemplateItem);
    }

    private void o(String str, DXTemplateItem dXTemplateItem) {
        synchronized (this.b) {
            Map<String, LinkedList<DXTemplateItem>> map = this.b.get(str);
            if (map == null) {
                map = new HashMap<>();
                this.b.put(str, map);
            }
            if (map.get(dXTemplateItem.name) == null) {
                LinkedList<DXTemplateItem> e = o10.b().e(str, dXTemplateItem);
                DXTemplateItem b2 = b(str, dXTemplateItem);
                if (b2 != null) {
                    i(e, b2);
                }
                map.put(dXTemplateItem.name, e);
            }
        }
    }

    private void p(String str, long j, DXTemplateItem dXTemplateItem) {
        LinkedList<DXTemplateItem> linkedList;
        synchronized (this.c) {
            b bVar = this.c.get(j);
            if (bVar == null) {
                bVar = new b();
                this.c.put(j, bVar);
            }
            linkedList = bVar.a.get(dXTemplateItem.name);
            if (linkedList == null) {
                Map<String, LinkedList<DXTemplateItem>> map = this.b.get(str);
                if (map == null || map.get(dXTemplateItem.name) == null) {
                    o(str, dXTemplateItem);
                }
                Map<String, LinkedList<DXTemplateItem>> map2 = this.b.get(str);
                if (map2 != null) {
                    LinkedList<DXTemplateItem> linkedList2 = map2.get(dXTemplateItem.name);
                    if (linkedList2 == null) {
                        bVar.a.put(dXTemplateItem.name, new LinkedList<>());
                    } else {
                        bVar.a.put(dXTemplateItem.name, new LinkedList<>(linkedList2));
                    }
                }
            }
        }
        if (linkedList == null) {
            synchronized (this.d) {
                String str2 = str + dXTemplateItem.name;
                Set<Long> set = this.d.get(str2);
                if (set == null) {
                    HashSet hashSet = new HashSet();
                    hashSet.add(Long.valueOf(j));
                    this.d.put(str2, hashSet);
                } else {
                    set.add(Long.valueOf(j));
                }
            }
        }
    }

    private int q(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int a(String str, long j, DXTemplateItem dXTemplateItem) {
        if (j(str, j, dXTemplateItem)) {
            p(str, j, dXTemplateItem);
            LinkedList<DXTemplateItem> linkedList = this.c.get(j).a.get(dXTemplateItem.name);
            int size = linkedList.size();
            Iterator<DXTemplateItem> descendingIterator = linkedList.descendingIterator();
            while (descendingIterator.hasNext()) {
                DXTemplateItem next = descendingIterator.next();
                if (dXTemplateItem.version == next.version) {
                    if (next.isPreset) {
                        if (DinamicXEngine.x()) {
                            nz.i("DXTemplateInfoManager", str + '|' + dXTemplateItem.name + "内置被降级，无法再降级");
                        }
                        descendingIterator.remove();
                        return 2;
                    }
                    if (size == 1 && DinamicXEngine.x()) {
                        nz.i("DXTemplateInfoManager", str + '|' + dXTemplateItem.name + "无内置情况，无法再降级");
                    }
                    descendingIterator.remove();
                    return 1;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DXTemplateItem e(String str, long j, DXTemplateItem dXTemplateItem) {
        Collection<String> collection;
        if (j(str, j, dXTemplateItem)) {
            p(str, j, dXTemplateItem);
            synchronized (this.c) {
                LinkedList<DXTemplateItem> linkedList = this.c.get(j).a.get(dXTemplateItem.name);
                if (linkedList != null) {
                    if (linkedList.size() == 0) {
                        return null;
                    }
                    long j2 = -1;
                    Iterator<DXTemplateItem> descendingIterator = linkedList.descendingIterator();
                    while (descendingIterator.hasNext()) {
                        DXTemplateItem next = descendingIterator.next();
                        long j3 = next.version;
                        long j4 = dXTemplateItem.version;
                        if (j3 != j4) {
                            if (next.isPreset) {
                                j2 = j3;
                            }
                            if (j3 >= j4) {
                                next = null;
                            } else if (j3 < j2) {
                                return null;
                            }
                        }
                        if (next != null && ((collection = dXTemplateItem.skipVersions) == null || !collection.contains(String.valueOf(next.version)))) {
                            return next;
                        }
                    }
                }
            }
        }
        return null;
    }

    public DXTemplatePackageInfo g(String str, DXTemplateItem dXTemplateItem) {
        LinkedList<DXTemplateItem> linkedList;
        if (r10.c(str, dXTemplateItem)) {
            synchronized (this.b) {
                Map<String, LinkedList<DXTemplateItem>> map = this.b.get(str);
                if (map == null || map.get(dXTemplateItem.name) == null) {
                    o(str, dXTemplateItem);
                }
                Map<String, LinkedList<DXTemplateItem>> map2 = this.b.get(str);
                if (map2 != null && (linkedList = map2.get(dXTemplateItem.name)) != null) {
                    if (linkedList.size() == 0) {
                        return null;
                    }
                    Iterator<DXTemplateItem> descendingIterator = linkedList.descendingIterator();
                    while (descendingIterator.hasNext()) {
                        DXTemplateItem next = descendingIterator.next();
                        if (next.version == dXTemplateItem.version) {
                            return next.packageInfo;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DXTemplateItem h(String str, long j, DXTemplateItem dXTemplateItem) {
        Collection<String> collection;
        if (j(str, j, dXTemplateItem)) {
            p(str, j, dXTemplateItem);
            synchronized (this.c) {
                Iterator<DXTemplateItem> descendingIterator = this.c.get(j).a.get(dXTemplateItem.name).descendingIterator();
                while (descendingIterator.hasNext()) {
                    DXTemplateItem next = descendingIterator.next();
                    long j2 = next.version;
                    long j3 = dXTemplateItem.version;
                    if (j2 != j3 && (!next.isPreset || j2 >= j3)) {
                        next = null;
                    }
                    if (next != null && ((collection = dXTemplateItem.skipVersions) == null || !collection.contains(String.valueOf(next.version)))) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    boolean i(LinkedList<DXTemplateItem> linkedList, DXTemplateItem dXTemplateItem) {
        if (linkedList == null || dXTemplateItem == null) {
            return false;
        }
        long j = dXTemplateItem.version;
        int size = linkedList.size();
        if (size == 0) {
            linkedList.add(dXTemplateItem);
            return true;
        } else if (j > linkedList.getLast().version) {
            linkedList.add(dXTemplateItem);
            return true;
        } else {
            Iterator<DXTemplateItem> descendingIterator = linkedList.descendingIterator();
            descendingIterator.next();
            int i = size - 2;
            while (descendingIterator.hasNext()) {
                if (descendingIterator.next().version < j) {
                    linkedList.add(i + 1, dXTemplateItem);
                    return true;
                }
                i--;
            }
            linkedList.addFirst(dXTemplateItem);
            return true;
        }
    }

    public boolean k(String str, DXTemplateItem dXTemplateItem) {
        if (r10.c(str, dXTemplateItem)) {
            String str2 = str + dXTemplateItem.getIdentifier();
            synchronized (this.e) {
                int q = q(this.e.get(str2));
                if (q == -1) {
                    return false;
                }
                if (q == 0) {
                    Map<String, LinkedList<DXTemplateItem>> map = this.b.get(str);
                    if (map == null || map.get(dXTemplateItem.name) == null) {
                        o(str, dXTemplateItem);
                    }
                    Map<String, LinkedList<DXTemplateItem>> map2 = this.b.get(str);
                    if (map2 != null) {
                        LinkedList<DXTemplateItem> linkedList = map2.get(dXTemplateItem.name);
                        if (linkedList != null && !linkedList.isEmpty()) {
                            Iterator<DXTemplateItem> it = linkedList.iterator();
                            while (it.hasNext()) {
                                DXTemplateItem next = it.next();
                                if (next.version == dXTemplateItem.version) {
                                    if (next.isPreset) {
                                        dXTemplateItem.isPreset = true;
                                        this.e.put(str2, 2);
                                    } else {
                                        dXTemplateItem.isPreset = false;
                                        this.e.put(str2, 1);
                                    }
                                    return true;
                                }
                            }
                            this.e.put(str2, -1);
                            return false;
                        }
                        this.e.put(str2, -1);
                        return false;
                    }
                    this.e.put(str2, -1);
                    return false;
                } else if (q == 1) {
                    dXTemplateItem.isPreset = false;
                    return true;
                } else if (q == 2) {
                    dXTemplateItem.isPreset = true;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean l(String str) {
        return !TextUtils.isEmpty(str) && this.a.get(str) == null;
    }

    public void m(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        this.a.put(str, jSONObject);
    }

    public void n(String str, DXTemplateItem dXTemplateItem) {
        LinkedList<DXTemplateItem> linkedList;
        if (r10.c(str, dXTemplateItem)) {
            synchronized (this.b) {
                Map<String, LinkedList<DXTemplateItem>> map = this.b.get(str);
                if (map == null || map.get(dXTemplateItem.name) == null) {
                    o(str, dXTemplateItem);
                }
                Map<String, LinkedList<DXTemplateItem>> map2 = this.b.get(str);
                if (map2 != null) {
                    LinkedList<DXTemplateItem> linkedList2 = map2.get(dXTemplateItem.name);
                    if (linkedList2 == null) {
                        map2.put(dXTemplateItem.name, new LinkedList<>());
                    } else {
                        linkedList2.remove(dXTemplateItem);
                    }
                }
            }
            synchronized (this.e) {
                this.e.put(str + dXTemplateItem.getIdentifier(), -1);
            }
            HashSet<Long> hashSet = null;
            synchronized (this.d) {
                Set<Long> set = this.d.get(str + dXTemplateItem.name);
                if (set != null && !set.isEmpty()) {
                    hashSet = new HashSet(set);
                }
            }
            if (hashSet != null && !hashSet.isEmpty()) {
                synchronized (this.c) {
                    for (Long l : hashSet) {
                        b bVar = this.c.get(l.longValue());
                        if (bVar != null && (linkedList = bVar.a.get(dXTemplateItem.name)) != null) {
                            linkedList.remove(dXTemplateItem);
                        }
                    }
                }
            }
            o10.b().a(str, dXTemplateItem);
        }
    }

    public void r(String str, long j, DXTemplateItem dXTemplateItem) {
        if (j(str, j, dXTemplateItem)) {
            synchronized (this.b) {
                Map<String, LinkedList<DXTemplateItem>> map = this.b.get(str);
                if (map == null || map.get(dXTemplateItem.name) == null) {
                    o(str, dXTemplateItem);
                }
                Map<String, LinkedList<DXTemplateItem>> map2 = this.b.get(str);
                if (map2 != null) {
                    LinkedList<DXTemplateItem> linkedList = map2.get(dXTemplateItem.name);
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                        map2.put(dXTemplateItem.name, linkedList);
                    }
                    if (!i(linkedList, dXTemplateItem)) {
                        return;
                    }
                }
                synchronized (this.e) {
                    this.e.put(str + dXTemplateItem.getIdentifier(), 1);
                }
                HashSet<Long> hashSet = null;
                synchronized (this.d) {
                    Set<Long> set = this.d.get(str + dXTemplateItem.name);
                    if (set != null && !set.isEmpty()) {
                        hashSet = new HashSet(set);
                    }
                }
                if (hashSet == null || hashSet.isEmpty()) {
                    return;
                }
                synchronized (this.c) {
                    for (Long l : hashSet) {
                        b bVar = this.c.get(l.longValue());
                        if (bVar != null) {
                            i(bVar.a.get(dXTemplateItem.name), dXTemplateItem);
                        }
                    }
                }
            }
        }
    }

    private q10() {
        this.a = new ConcurrentHashMap<>();
        this.b = new HashMap();
        this.c = new DXLongSparseArray<>();
        this.d = new HashMap();
        this.e = new LruCache<>(100);
    }
}
