package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class BaseSetupTask<RETURN_TYPE extends BaseSetupTask<RETURN_TYPE, CALLBACK_TYPE>, CALLBACK_TYPE extends BaseSetupTask<RETURN_TYPE, CALLBACK_TYPE>> extends UCSubSetupTask<RETURN_TYPE, CALLBACK_TYPE> {
    public BaseSetupTask(UCAsyncTask uCAsyncTask) {
        super(uCAsyncTask);
    }

    public String getInitType() {
        return (String) getOption(UCCore.OPTION_BUSINESS_INIT_TYPE);
    }

    public RETURN_TYPE setAsDefault() {
        return this;
    }

    @Override // com.uc.webview.export.internal.setup.UCSubSetupTask
    public /* bridge */ /* synthetic */ UCSubSetupTask setOptions(ConcurrentHashMap concurrentHashMap) {
        return setOptions((ConcurrentHashMap<String, Object>) concurrentHashMap);
    }

    public BaseSetupTask() {
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask
    public final RETURN_TYPE onEvent(String str, ValueCallback<CALLBACK_TYPE> valueCallback) {
        return (RETURN_TYPE) super.onEvent(str, (ValueCallback) valueCallback);
    }

    @Override // com.uc.webview.export.internal.setup.UCSubSetupTask
    public final RETURN_TYPE setOptions(ConcurrentHashMap<String, Object> concurrentHashMap) {
        super.setOptions(concurrentHashMap);
        return this;
    }

    @Override // com.uc.webview.export.internal.setup.UCSubSetupTask
    public final RETURN_TYPE setup(String str, Object obj) {
        return (RETURN_TYPE) super.setup(str, obj);
    }
}
