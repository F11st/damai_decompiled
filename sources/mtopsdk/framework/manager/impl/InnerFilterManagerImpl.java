package mtopsdk.framework.manager.impl;

import mtopsdk.framework.filter.after.BusinessErrorAfterFilter;
import mtopsdk.framework.filter.after.ErrorCodeMappingAfterFilter;
import mtopsdk.framework.filter.after.ExecuteCallbackAfterFilter;
import mtopsdk.framework.filter.after.NetworkErrorAfterFilter;
import mtopsdk.framework.filter.after.TimeCalibrationAfterFilter;
import mtopsdk.framework.filter.before.CheckRequestParamBeforeFilter;
import mtopsdk.framework.filter.before.ExecuteCallBeforeFilter;
import mtopsdk.framework.filter.before.NetworkConvertBeforeFilter;
import mtopsdk.framework.filter.before.ProtocolParamBuilderBeforeFilter;
import mtopsdk.framework.filter.duplex.AppConfigDuplexFilter;
import mtopsdk.framework.filter.duplex.CacheDuplexFilter;
import mtopsdk.framework.filter.duplex.CheckAuthDuplexFilter;
import mtopsdk.framework.filter.duplex.CheckSessionDuplexFilter;
import mtopsdk.framework.filter.duplex.FCDuplexFilter;
import mtopsdk.framework.filter.duplex.PrefetchDuplexFilter;
import mtopsdk.mtop.protocol.builder.impl.InnerProtocolParamBuilderImpl;
import mtopsdk.mtop.protocol.converter.impl.InnerNetworkConverter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class InnerFilterManagerImpl extends AbstractFilterManager {
    public InnerFilterManagerImpl() {
        CheckSessionDuplexFilter checkSessionDuplexFilter = new CheckSessionDuplexFilter();
        CheckAuthDuplexFilter checkAuthDuplexFilter = new CheckAuthDuplexFilter();
        CacheDuplexFilter cacheDuplexFilter = new CacheDuplexFilter();
        AppConfigDuplexFilter appConfigDuplexFilter = new AppConfigDuplexFilter();
        FCDuplexFilter fCDuplexFilter = new FCDuplexFilter();
        PrefetchDuplexFilter prefetchDuplexFilter = new PrefetchDuplexFilter();
        addBefore(new CheckRequestParamBeforeFilter());
        addBefore(checkSessionDuplexFilter);
        addBefore(checkAuthDuplexFilter);
        addBefore(appConfigDuplexFilter);
        addBefore(prefetchDuplexFilter);
        addBefore(new ProtocolParamBuilderBeforeFilter(new InnerProtocolParamBuilderImpl()));
        addBefore(new NetworkConvertBeforeFilter(new InnerNetworkConverter()));
        addBefore(cacheDuplexFilter);
        addBefore(fCDuplexFilter);
        addBefore(new ExecuteCallBeforeFilter());
        addAfter(new NetworkErrorAfterFilter());
        addAfter(appConfigDuplexFilter);
        addAfter(fCDuplexFilter);
        addAfter(new BusinessErrorAfterFilter());
        addAfter(new TimeCalibrationAfterFilter());
        addAfter(checkSessionDuplexFilter);
        addAfter(checkAuthDuplexFilter);
        addAfter(new ErrorCodeMappingAfterFilter());
        addAfter(prefetchDuplexFilter);
        addAfter(new ExecuteCallbackAfterFilter());
        addAfter(cacheDuplexFilter);
    }
}
