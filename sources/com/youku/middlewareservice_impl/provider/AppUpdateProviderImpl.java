package com.youku.middlewareservice_impl.provider;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;
import com.alient.oneservice.provider.impl.OneConfig;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.update.framework.UpdateRuntime;
import com.youku.middlewareservice.provider.AppUpdateProvider;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes3.dex */
public class AppUpdateProviderImpl implements AppUpdateProvider {
    @Override // com.youku.middlewareservice.provider.AppUpdateProvider
    public void checkUpdate(Context context) {
        UpdateRuntime.execute(new Runnable() { // from class: com.youku.middlewareservice_impl.provider.AppUpdateProviderImpl.1
            @Override // java.lang.Runnable
            public void run() {
                UpdateDataSource.getInstance().startUpdate(OneConfig.CHECK_UPDATE_BACKGROUND, OneConfig.CHECK_UPDATE_SYNC);
            }
        });
    }

    @Override // com.youku.middlewareservice.provider.AppUpdateProvider
    public void startUpdateActivity(Map<String, String> map, Activity activity) {
    }
}
