package com.taobao.orange.candidate;

import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import com.taobao.orange.ConfigCenter;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.OCandidate;
import com.taobao.orange.OConstant;
import com.taobao.orange.util.OLog;
import com.taobao.orange.util.SPUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MultiAnalyze {
    private static final String JOINER_CHAR = "&";
    private static final String TAG = "MultiAnalyze";
    public static Map<String, OCandidate> candidateMap = new ConcurrentHashMap();
    public List<UnitAnalyze> unitAnalyzes = new ArrayList();

    private MultiAnalyze(String str, boolean z) {
        for (String str2 : str.split("&")) {
            this.unitAnalyzes.add(UnitAnalyze.complie(str2));
        }
        if (z && OLog.isPrintLog(0)) {
            OLog.v(TAG, "parse start", "unitAnalyzes", this.unitAnalyzes);
        }
    }

    public static void addCandidate(OCandidate... oCandidateArr) {
        addCandidate(true, oCandidateArr);
    }

    public static MultiAnalyze complie(String str, boolean z) {
        return new MultiAnalyze(str, z);
    }

    public static void initBuildInCandidates() {
        OCandidate[] oCandidateArr = {new OCandidate("app_ver", GlobalOrange.appVersion, VersionCompare.class), new OCandidate(OConstant.CANDIDATE_OSVER, String.valueOf(Build.VERSION.SDK_INT), IntCompare.class), new OCandidate(OConstant.CANDIDATE_MANUFACTURER, String.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER()), StringCompare.class), new OCandidate(OConstant.CANDIDATE_BRAND, String.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND()), StringCompare.class), new OCandidate(OConstant.CANDIDATE_MODEL, String.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL()), StringCompare.class), new OCandidate("did_hash", GlobalOrange.deviceId, HashCompare.class)};
        OLog.d(TAG, "initBuildInCandidates", new Object[0]);
        int intValue = ((Integer) SPUtil.getFromSharePreference(GlobalOrange.context, "enableChangeVersion", 0)).intValue();
        if (intValue > 0) {
            initLocalEnvironment();
        }
        addCandidate(intValue == 0, oCandidateArr);
    }

    private static void initLocalEnvironment() {
        String str = (String) SPUtil.getFromSharePreference(GlobalOrange.context, "osVersion", "");
        if (TextUtils.isEmpty((String) SPUtil.getFromSharePreference(GlobalOrange.context, "appVersion", ""))) {
            SPUtil.saveToSharePreference(GlobalOrange.context, "appVersion", GlobalOrange.appVersion);
        }
        if (TextUtils.isEmpty(str)) {
            SPUtil.saveToSharePreference(GlobalOrange.context, "osVersion", String.valueOf(Build.VERSION.SDK_INT));
        }
    }

    public Set<String> getKeySet() {
        HashSet hashSet = new HashSet();
        for (UnitAnalyze unitAnalyze : this.unitAnalyzes) {
            hashSet.add(unitAnalyze.key);
        }
        return hashSet;
    }

    public boolean match() throws RemoteException {
        for (UnitAnalyze unitAnalyze : this.unitAnalyzes) {
            OCandidate oCandidate = candidateMap.get(unitAnalyze.key);
            if (oCandidate == null) {
                if (OLog.isPrintLog(3)) {
                    OLog.w(TAG, "match fail", "key", unitAnalyze.key, "reason", "no found local Candidate");
                }
                return false;
            } else if (!unitAnalyze.match(oCandidate.getClientVal(), oCandidate.getCompare())) {
                return false;
            }
        }
        return true;
    }

    public static void addCandidate(boolean z, OCandidate... oCandidateArr) {
        HashSet hashSet = new HashSet();
        for (OCandidate oCandidate : oCandidateArr) {
            if (OLog.isPrintLog(1)) {
                OLog.d(TAG, "addCandidate", "candidate", oCandidate);
            }
            String key = oCandidate.getKey();
            OCandidate oCandidate2 = candidateMap.get(key);
            if (oCandidate2 != null && oCandidate2.compare(oCandidate)) {
                OLog.w(TAG, "addCandidate exist same", new Object[0]);
                return;
            }
            if (oCandidate2 != null) {
                OLog.w(TAG, "addCandidate", "update baseCandidate", oCandidate2);
            }
            candidateMap.put(key, oCandidate);
            hashSet.add(key);
        }
        ConfigCenter.getInstance().rematchNamespace(hashSet, z);
    }
}
