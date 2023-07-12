package mtopsdk.framework.manager.impl;

import java.util.LinkedList;
import java.util.List;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.framework.filter.IBeforeFilter;
import mtopsdk.framework.manager.FilterManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class AbstractFilterManager implements FilterManager {
    private static final String TAG = "mtopsdk.AbstractFilterManager";
    protected final List<IBeforeFilter> beforeFilters = new LinkedList();
    protected final List<IAfterFilter> afterFilters = new LinkedList();

    @Override // mtopsdk.framework.manager.FilterManager
    public void addAfter(IAfterFilter iAfterFilter) {
        this.afterFilters.add(iAfterFilter);
    }

    @Override // mtopsdk.framework.manager.FilterManager
    public void addBefore(IBeforeFilter iBeforeFilter) {
        this.beforeFilters.add(iBeforeFilter);
    }

    @Override // mtopsdk.framework.manager.FilterManager
    public void callback(String str, MtopContext mtopContext) {
        boolean isBlank = StringUtils.isBlank(str);
        for (IAfterFilter iAfterFilter : this.afterFilters) {
            if (!isBlank) {
                if (str.equals(iAfterFilter.getName())) {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                        String str2 = mtopContext.seqNo;
                        TBSdkLog.i(TAG, str2, "[callback]jump to afterFilter:" + str);
                    }
                    isBlank = true;
                } else {
                    continue;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            String doAfter = iAfterFilter.doAfter(mtopContext);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                String str3 = mtopContext.seqNo;
                TBSdkLog.d(TAG, str3, "[callback]execute AfterFilter: " + iAfterFilter.getName() + ",time(ms)= " + (System.currentTimeMillis() - currentTimeMillis));
            }
            if (doAfter == null || "STOP".equals(doAfter)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    String str4 = mtopContext.seqNo;
                    TBSdkLog.i(TAG, str4, "[callback]execute AfterFilter: " + iAfterFilter.getName() + ",result=" + doAfter);
                    return;
                }
                return;
            }
        }
    }

    @Override // mtopsdk.framework.manager.FilterManager
    public void start(String str, MtopContext mtopContext) {
        boolean isBlank = StringUtils.isBlank(str);
        for (IBeforeFilter iBeforeFilter : this.beforeFilters) {
            if (!isBlank) {
                if (str.equals(iBeforeFilter.getName())) {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                        String str2 = mtopContext.seqNo;
                        TBSdkLog.i(TAG, str2, "[start]jump to beforeFilter:" + str);
                    }
                    isBlank = true;
                } else {
                    continue;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            String doBefore = iBeforeFilter.doBefore(mtopContext);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                String str3 = mtopContext.seqNo;
                TBSdkLog.d(TAG, str3, "[start]execute BeforeFilter: " + iBeforeFilter.getName() + ",time(ms)= " + (System.currentTimeMillis() - currentTimeMillis));
            }
            if (doBefore == null || "STOP".equals(doBefore)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    String str4 = mtopContext.seqNo;
                    TBSdkLog.i(TAG, str4, "[start]execute BeforeFilter: " + iBeforeFilter.getName() + ",result=" + doBefore);
                    return;
                }
                return;
            }
        }
    }
}
