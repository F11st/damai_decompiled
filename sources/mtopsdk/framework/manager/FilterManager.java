package mtopsdk.framework.manager;

import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.framework.filter.IBeforeFilter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface FilterManager {
    void addAfter(IAfterFilter iAfterFilter);

    void addBefore(IBeforeFilter iBeforeFilter);

    void callback(String str, MtopContext mtopContext);

    void start(String str, MtopContext mtopContext);
}
