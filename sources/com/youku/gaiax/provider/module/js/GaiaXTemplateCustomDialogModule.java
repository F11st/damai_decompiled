package com.youku.gaiax.provider.module.js;

import android.app.Dialog;
import android.content.DialogInterface;
import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.alient.oneservice.appconfig.AppConfigProviderProxy;
import com.youku.gaiax.impl.utils.GaiaXUiExecutor;
import com.youku.gaiax.js.api.GaiaXBaseModule;
import com.youku.gaiax.js.api.IGaiaXCallback;
import com.youku.gaiax.js.api.annotation.GaiaXAsyncMethod;
import com.youku.gaiax.js.utils.Log;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class GaiaXTemplateCustomDialogModule extends GaiaXBaseModule {
    Map<String, Dialog> mDialogList = new HashMap();

    @GaiaXAsyncMethod
    public void dismissCustomDialog(String str, IGaiaXCallback iGaiaXCallback) {
        Dialog dialog = this.mDialogList.get(str);
        if (dialog != null) {
            dialog.dismiss();
            this.mDialogList.remove(str);
            iGaiaXCallback.invoke(null);
        }
    }

    @Override // com.youku.gaiax.js.api.IGaiaXModule
    public String getName() {
        return "BuildIn";
    }

    @GaiaXAsyncMethod
    public void showCustomDialog(final JSONObject jSONObject, final IGaiaXCallback iGaiaXCallback) {
        boolean isDebuggable;
        RuntimeException runtimeException;
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("showCustomDialog() called with data" + jSONObject.toString());
        }
        try {
            final String string = jSONObject.getString("identifierId");
            GaiaXUiExecutor.INSTANCE.action(new Runnable() { // from class: com.youku.gaiax.provider.module.js.GaiaXTemplateCustomDialogModule.1
                @Override // java.lang.Runnable
                public void run() {
                    GaiaXCustomDialogView gaiaXCustomDialogView = new GaiaXCustomDialogView(AppConfigProviderProxy.topActivity(), jSONObject, null, null);
                    if (GaiaXTemplateCustomDialogModule.this.mDialogList.get(string) == null) {
                        GaiaXTemplateCustomDialogModule.this.mDialogList.put(string, gaiaXCustomDialogView);
                        gaiaXCustomDialogView.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.youku.gaiax.provider.module.js.GaiaXTemplateCustomDialogModule.1.1
                            @Override // android.content.DialogInterface.OnDismissListener
                            public void onDismiss(DialogInterface dialogInterface) {
                                iGaiaXCallback.invoke(null);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                GaiaXTemplateCustomDialogModule.this.mDialogList.remove(string);
                            }
                        });
                        gaiaXCustomDialogView.show();
                    }
                }
            });
        } finally {
            if (!isDebuggable) {
            }
        }
    }
}
