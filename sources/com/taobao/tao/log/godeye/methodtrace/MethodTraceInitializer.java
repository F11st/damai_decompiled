package com.taobao.tao.log.godeye.methodtrace;

import android.app.Application;
import com.taobao.tao.log.godeye.api.control.IGodeye;
import com.taobao.tao.log.godeye.api.plugin.IPluginInitializerContextAware;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MethodTraceInitializer implements IPluginInitializerContextAware {
    static Application sApplication;
    public static IGodeye sGodeye;

    @Override // com.taobao.tao.log.godeye.api.plugin.IPluginInitializerContextAware
    public void init(Application application, IGodeye iGodeye) {
        sApplication = application;
        sGodeye = iGodeye;
        iGodeye.registerCommandController(new MethodTraceController());
    }
}
