package mtopsdk.framework.manager.impl;

import mtopsdk.framework.filter.after.AntiAttackAfterFilter;
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
import mtopsdk.framework.filter.duplex.CheckSessionDuplexFilter;
import mtopsdk.framework.filter.duplex.FlowLimitDuplexFilter;
import mtopsdk.mtop.protocol.builder.impl.ProductProtocolParamBuilderImpl;
import mtopsdk.mtop.protocol.converter.impl.ProductNetworkConverter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ProductFilterManagerImpl extends AbstractFilterManager {
    public ProductFilterManagerImpl() {
        CheckSessionDuplexFilter checkSessionDuplexFilter = new CheckSessionDuplexFilter();
        CacheDuplexFilter cacheDuplexFilter = new CacheDuplexFilter();
        FlowLimitDuplexFilter flowLimitDuplexFilter = new FlowLimitDuplexFilter();
        AppConfigDuplexFilter appConfigDuplexFilter = new AppConfigDuplexFilter();
        addBefore(new CheckRequestParamBeforeFilter());
        addBefore(checkSessionDuplexFilter);
        addBefore(appConfigDuplexFilter);
        addBefore(new ProtocolParamBuilderBeforeFilter(new ProductProtocolParamBuilderImpl()));
        addBefore(new NetworkConvertBeforeFilter(new ProductNetworkConverter()));
        addBefore(cacheDuplexFilter);
        addBefore(flowLimitDuplexFilter);
        addBefore(new ExecuteCallBeforeFilter());
        addAfter(new NetworkErrorAfterFilter());
        addAfter(appConfigDuplexFilter);
        addAfter(new AntiAttackAfterFilter());
        addAfter(flowLimitDuplexFilter);
        addAfter(new BusinessErrorAfterFilter());
        addAfter(new TimeCalibrationAfterFilter());
        addAfter(checkSessionDuplexFilter);
        addAfter(new ErrorCodeMappingAfterFilter());
        addAfter(new ExecuteCallbackAfterFilter());
        addAfter(cacheDuplexFilter);
    }
}
