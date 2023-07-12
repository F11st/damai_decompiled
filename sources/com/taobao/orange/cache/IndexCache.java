package com.taobao.orange.cache;

import android.text.TextUtils;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.OConstant;
import com.taobao.orange.OThreadFactory;
import com.taobao.orange.candidate.MultiAnalyze;
import com.taobao.orange.model.CandidateDO;
import com.taobao.orange.model.IndexDO;
import com.taobao.orange.model.NameSpaceDO;
import com.taobao.orange.util.FileUtil;
import com.taobao.orange.util.OLog;
import com.taobao.orange.util.OrangeUtils;
import com.taobao.orange.util.SPUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tb.jg1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class IndexCache {
    public static final String INDEX_STORE_NAME = "orange.index";
    private static final String TAG = "IndexCache";
    private volatile IndexDO mIndex = new IndexDO();
    public Map<String, Set<String>> candidateNamespace = new HashMap();

    private List<String> diffCache(IndexDO indexDO) {
        OLog.e(TAG, "diffCache", "diff index, baseVersion = " + indexDO.baseVersion);
        ArrayList arrayList = new ArrayList();
        Map<String, NameSpaceDO> formatMergedNamespaceMap = formatMergedNamespaceMap(this.mIndex.mergedNamespaces);
        Map<String, NameSpaceDO> formatMergedNamespaceMap2 = formatMergedNamespaceMap(indexDO.mergedNamespaces);
        List<String> list = indexDO.offlineNamespaces;
        if (list != null && list.size() > 0) {
            for (String str : indexDO.offlineNamespaces) {
                formatMergedNamespaceMap.remove(str);
            }
            arrayList.addAll(indexDO.offlineNamespaces);
        }
        for (Map.Entry<String, NameSpaceDO> entry : formatMergedNamespaceMap2.entrySet()) {
            NameSpaceDO nameSpaceDO = formatMergedNamespaceMap.get(entry.getKey());
            NameSpaceDO value = entry.getValue();
            if (nameSpaceDO == null) {
                value.hasChanged = true;
            } else {
                boolean z = !value.equals(nameSpaceDO);
                if (z && OLog.isPrintLog(2)) {
                    OLog.i(TAG, "diffCache", "compare change NameSpaceDO", OrangeUtils.formatNamespaceDO(value));
                }
                value.hasChanged = z;
            }
        }
        for (Map.Entry<String, NameSpaceDO> entry2 : formatMergedNamespaceMap.entrySet()) {
            if (!formatMergedNamespaceMap2.containsKey(entry2.getKey())) {
                formatMergedNamespaceMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        indexDO.mergedNamespaces.clear();
        indexDO.mergedNamespaces.addAll(new ArrayList(formatMergedNamespaceMap2.values()));
        this.candidateNamespace = getCandidateNamespace(indexDO);
        this.mIndex = indexDO;
        updateOrangeHeader();
        OThreadFactory.executeDisk(new Runnable() { // from class: com.taobao.orange.cache.IndexCache.2
            @Override // java.lang.Runnable
            public void run() {
                FileUtil.persistObject(IndexCache.this.mIndex, IndexCache.INDEX_STORE_NAME);
            }
        });
        OLog.e(TAG, "diffCache", "success");
        return arrayList;
    }

    private Map<String, NameSpaceDO> formatMergedNamespaceMap(List<NameSpaceDO> list) {
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (NameSpaceDO nameSpaceDO : list) {
                hashMap.put(nameSpaceDO.name, nameSpaceDO);
            }
        }
        return hashMap;
    }

    private Map<String, Set<String>> getCandidateNamespace(IndexDO indexDO) {
        if (indexDO == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (NameSpaceDO nameSpaceDO : indexDO.mergedNamespaces) {
            List<CandidateDO> list = nameSpaceDO.candidates;
            if (list != null && !list.isEmpty()) {
                for (CandidateDO candidateDO : nameSpaceDO.candidates) {
                    for (String str : MultiAnalyze.complie(candidateDO.match, false).getKeySet()) {
                        Set set = (Set) hashMap.get(str);
                        if (set == null) {
                            set = new HashSet();
                            hashMap.put(str, set);
                        }
                        set.add(nameSpaceDO.name);
                    }
                }
            }
        }
        if (OLog.isPrintLog(1)) {
            OLog.d(TAG, "getCandidateNamespace", "result", hashMap);
        }
        return hashMap;
    }

    private void updateOrangeHeader() {
        StringBuilder sb = new StringBuilder();
        sb.append("appKey");
        sb.append("=");
        sb.append(GlobalOrange.appKey);
        sb.append("&");
        sb.append("appVersion");
        sb.append("=");
        sb.append(GlobalOrange.appVersion);
        sb.append("&");
        sb.append(OConstant.KEY_CLIENTAPPINDEXVERSION);
        sb.append("=");
        sb.append(getAppIndexVersion());
        OLog.i(TAG, "updateOrangeHeader", "reqOrangeHeaderDiff", sb.toString());
        GlobalOrange.reqOrangeHeaderDiff = sb.toString();
        sb.append("&");
        sb.append(OConstant.KEY_CLIENTVERSIONINDEXVERSION);
        sb.append("=");
        sb.append(getVersionIndexVersion());
        OLog.i(TAG, "updateOrangeHeader", "reqOrangeHeader", sb.toString());
        GlobalOrange.reqOrangeHeader = sb.toString();
    }

    public List<String> cache(IndexDO indexDO) {
        if (GlobalOrange.indexDiff > 0) {
            if (!TextUtils.isEmpty(indexDO.baseVersion) && !"0".equals(indexDO.baseVersion)) {
                return diffCache(indexDO);
            }
            OLog.e(TAG, "cache", "baseVersion is empty");
        }
        Map<String, NameSpaceDO> formatMergedNamespaceMap = formatMergedNamespaceMap(this.mIndex.mergedNamespaces);
        Map<String, NameSpaceDO> formatMergedNamespaceMap2 = formatMergedNamespaceMap(indexDO.mergedNamespaces);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(formatMergedNamespaceMap.keySet());
        arrayList.removeAll(formatMergedNamespaceMap2.keySet());
        for (Map.Entry<String, NameSpaceDO> entry : formatMergedNamespaceMap2.entrySet()) {
            NameSpaceDO nameSpaceDO = formatMergedNamespaceMap.get(entry.getKey());
            NameSpaceDO value = entry.getValue();
            if (nameSpaceDO == null) {
                value.hasChanged = true;
            } else {
                boolean z = !value.equals(nameSpaceDO);
                if (z && OLog.isPrintLog(2)) {
                    OLog.i(TAG, "cache", "compare change NameSpaceDO", OrangeUtils.formatNamespaceDO(value));
                }
                value.hasChanged = z;
            }
        }
        this.candidateNamespace = getCandidateNamespace(indexDO);
        this.mIndex = indexDO;
        updateOrangeHeader();
        OThreadFactory.executeDisk(new Runnable() { // from class: com.taobao.orange.cache.IndexCache.1
            @Override // java.lang.Runnable
            public void run() {
                FileUtil.persistObject(IndexCache.this.mIndex, IndexCache.INDEX_STORE_NAME);
            }
        });
        return arrayList;
    }

    public Set<NameSpaceDO> getAllNameSpaces() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.mIndex.mergedNamespaces);
        return hashSet;
    }

    public String getAppIndexVersion() {
        return this.mIndex.appIndexVersion == null ? "0" : this.mIndex.appIndexVersion;
    }

    public String getCdnUrl() {
        if (TextUtils.isEmpty(this.mIndex.cdn)) {
            return null;
        }
        return GlobalOrange.schema + jg1.SCHEME_SLASH + this.mIndex.cdn;
    }

    public IndexDO getIndex() {
        return this.mIndex;
    }

    public NameSpaceDO getNameSpace(String str) {
        long nanoTime = System.nanoTime();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (NameSpaceDO nameSpaceDO : this.mIndex.mergedNamespaces) {
            if (str.equals(nameSpaceDO.name)) {
                OLog.d(TAG, "time (getNameSpace)", "time: " + String.valueOf((System.nanoTime() - nanoTime) / 1000));
                return nameSpaceDO;
            }
        }
        OLog.d(TAG, "time (getNameSpace)", "time: " + String.valueOf((System.nanoTime() - nanoTime) / 1000));
        return null;
    }

    public Set<NameSpaceDO> getUpdateNameSpaces(Set<String> set) {
        HashSet hashSet = new HashSet();
        for (NameSpaceDO nameSpaceDO : this.mIndex.mergedNamespaces) {
            if (nameSpaceDO.hasChanged) {
                if (NameSpaceDO.LEVEL_HIGH.equals(nameSpaceDO.loadLevel)) {
                    hashSet.add(nameSpaceDO);
                } else if (set != null && set.contains(nameSpaceDO.name)) {
                    hashSet.add(nameSpaceDO);
                }
            }
        }
        return hashSet;
    }

    public Set<NameSpaceDO> getUpdateNameSpacesByUsedList(Set<String> set) {
        Set<String> setFromSharePreference = SPUtil.getSetFromSharePreference(GlobalOrange.context, OConstant.SP_KEY_USED_LIST, new HashSet());
        setFromSharePreference.add("orange");
        HashSet hashSet = new HashSet();
        for (NameSpaceDO nameSpaceDO : this.mIndex.mergedNamespaces) {
            if (nameSpaceDO.hasChanged && (setFromSharePreference.contains(nameSpaceDO.name) || (set != null && set.contains(nameSpaceDO.name)))) {
                hashSet.add(nameSpaceDO);
            }
        }
        return hashSet;
    }

    public String getVersionIndexVersion() {
        return this.mIndex.versionIndexVersion == null ? "0" : this.mIndex.versionIndexVersion;
    }

    public void load() {
        IndexDO indexDO = (IndexDO) FileUtil.restoreObject(INDEX_STORE_NAME);
        if (indexDO != null) {
            if (OLog.isPrintLog(2)) {
                OLog.i(TAG, "load", "indexDO", OrangeUtils.formatIndexDO(indexDO));
            }
            this.candidateNamespace = getCandidateNamespace(indexDO);
            this.mIndex = indexDO;
        } else {
            OLog.w(TAG, "load fail", new Object[0]);
            try {
                FileUtil.clearCacheFile();
            } catch (Throwable th) {
                OLog.e(TAG, "load clean cache exception", th, new Object[0]);
            }
        }
        updateOrangeHeader();
    }
}
