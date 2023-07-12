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
import mtopsdk.framework.filter.duplex.CheckAuthDuplexFilter;
import mtopsdk.framework.filter.duplex.CheckSessionDuplexFilter;
import mtopsdk.framework.filter.duplex.FCDuplexFilter;
import mtopsdk.mtop.protocol.builder.impl.OpenProtocolParamBuilderImpl;
import mtopsdk.mtop.protocol.converter.impl.OpenNetworkConverter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OpenFilterManagerImpl extends AbstractFilterManager {
    public OpenFilterManagerImpl() {
        CheckSessionDuplexFilter checkSessionDuplexFilter = new CheckSessionDuplexFilter();
        CheckAuthDuplexFilter checkAuthDuplexFilter = new CheckAuthDuplexFilter();
        FCDuplexFilter fCDuplexFilter = new FCDuplexFilter();
        addBefore(new CheckRequestParamBeforeFilter());
        addBefore(checkSessionDuplexFilter);
        addBefore(checkAuthDuplexFilter);
        addBefore(new ProtocolParamBuilderBeforeFilter(new OpenProtocolParamBuilderImpl()));
        addBefore(new NetworkConvertBeforeFilter(new OpenNetworkConverter()));
        addBefore(fCDuplexFilter);
        addBefore(new ExecuteCallBeforeFilter());
        addAfter(new NetworkErrorAfterFilter());
        addAfter(fCDuplexFilter);
        addAfter(new BusinessErrorAfterFilter());
        addAfter(new TimeCalibrationAfterFilter());
        addAfter(checkSessionDuplexFilter);
        addAfter(checkAuthDuplexFilter);
        addAfter(new ErrorCodeMappingAfterFilter());
        addAfter(new ExecuteCallbackAfterFilter());
    }
}
