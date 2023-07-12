package com.ali.user.mobile.config;

import com.ali.user.mobile.service.ServiceConstants;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BeanConfig extends AbstractBeanConfig {
    private static volatile AbstractBeanConfig beanConfig;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.config.AbstractBeanConfig
    public void init() {
        super.init();
        this.beanMap.put(ServiceConstants.ServiceInterface.RPC_SERVICE, "com.ali.user.mobile.rpc.impl.MtopRpcServiceImpl");
        this.beanMap.put(ServiceConstants.ServiceInterface.NAV_SERVICE, "com.ali.user.mobile.navigation.NavigatorServiceImpl");
        this.beanMap.put(ServiceConstants.ServiceInterface.UI_SERVICE, "com.ali.user.mobile.ui.UIServiceImpl");
        this.beanMap.put(ServiceConstants.ServiceInterface.FACE_SERVICE, "com.taobao.android.identity.face.FaceComponent");
        this.beanMap.put(ServiceConstants.ServiceInterface.SNS_SERVICE, "com.ali.user.mobile.sns.SNSServiceImpl");
        this.beanMap.put(ServiceConstants.ServiceInterface.MEMBER_CENTER_SERVICE, "com.taobao.android.membercenter.MemberCenterServiceImpl");
        this.beanMap.put(ServiceConstants.ServiceInterface.FINGER_PRINT_SERVICE, "com.taobao.android.identity.fingerprint.FingerPrintComponent");
        this.beanMap.put(ServiceConstants.ServiceInterface.SNS_BIN_SERVICE, "com.taobao.android.sns4android.bind.SNSBind");
        this.beanMap.put(ServiceConstants.ServiceInterface.USER_TRACE_SERVICE, ServiceConstants.ServiceInstance.USER_TRACE_INSTANCE);
        this.beanMap.put(ServiceConstants.ServiceInterface.NUM_AUTH_SERVICE, "com.ali.user.number.auth.NumAuthComponent");
        this.beanMap.put(ServiceConstants.ServiceInterface.HUAWEI_SERIVICE, ServiceConstants.ServiceInstance.HUAWEI_INSTANCE);
        this.beanMap.put(ServiceConstants.ServiceInterface.LOGIN_SERVICE, "com.ali.user.mobile.login.LoginServiceImpl");
    }
}
