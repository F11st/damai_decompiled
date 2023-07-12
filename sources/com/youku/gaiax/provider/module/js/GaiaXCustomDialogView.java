package com.youku.gaiax.provider.module.js;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.LoadType;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.api.data.TrackParams;
import com.youku.gaiax.provider.R;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.info.DeviceInfoProviderProxy;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import tb.hh1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GaiaXCustomDialogView extends Dialog {
    private final GaiaX.IEventDelegate eventDelegate;
    private View mContainer;
    private final JSONObject params;
    private final GaiaX.ITrackDelegate3 trackDelegate;

    public GaiaXCustomDialogView(@NonNull Context context, JSONObject jSONObject, GaiaX.IEventDelegate iEventDelegate, GaiaX.ITrackDelegate3 iTrackDelegate3) {
        super(context);
        JSONObject jSONObject2 = new JSONObject();
        this.params = jSONObject2;
        jSONObject2.putAll(jSONObject);
        this.eventDelegate = iEventDelegate == null ? getEventDelegate() : iEventDelegate;
        this.trackDelegate = iTrackDelegate3 == null ? getTrackDelegate() : iTrackDelegate3;
    }

    private GaiaX.Params.Builder getHeightBuilder(GaiaX.Params.Builder builder) {
        float floatValue = this.params.getFloat("height") == null ? 0.0f : this.params.getFloat("height").floatValue();
        return floatValue != 0.0f ? builder.height(floatValue) : builder;
    }

    private JSONObject getTemplateData() {
        JSONObject jSONObject = this.params.getJSONObject("templateData");
        return jSONObject != null ? jSONObject : new JSONObject();
    }

    public static Map<String, String> getTrackParams(@NonNull JSONObject jSONObject) {
        return new HashMap();
    }

    private int getWidth() {
        int intValue = this.params.getIntValue("width");
        return intValue != 0 ? intValue : DeviceInfoProviderProxy.getWindowWidth();
    }

    private void initDialogFeature() {
        boolean booleanValue = this.params.getBoolean("dismissWhenTap") != null ? this.params.getBoolean("dismissWhenTap").booleanValue() : true;
        requestWindowFeature(1);
        setCanceledOnTouchOutside(booleanValue);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    private GaiaX.Params.Builder initGaiaXBuilder() {
        String string = this.params.getString("templateId");
        String string2 = this.params.getString(hh1.DIMEN_BIZ);
        if (string2 == null || string == null) {
            return null;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.custom_dialog_layout, (ViewGroup) null, false);
        this.mContainer = inflate;
        setContentView(inflate);
        return getHeightBuilder(new GaiaX.Params.Builder().templateId(string).templateBiz(string2).container(this.mContainer).width(getWidth()).data(getTemplateData()).mode(LoadType.SYNC_NORMAL));
    }

    protected void doEvent(@NonNull EventParams eventParams) {
        if (eventParams.getData() != null) {
            Action action = new Action();
            action.setActionType(1);
            action.setActionUrl(eventParams.getData().getString("jumpUrl"));
            action.setTrackInfo((TrackInfo) eventParams.getData().getObject("trackInfo", TrackInfo.class));
            if (action.getTrackInfo() != null) {
                UserTrackProviderProxy.click(action.getTrackInfo(), true);
            }
            NavProviderProxy.getProxy().toUri(AppInfoProviderProxy.getAppContext(), action);
        }
    }

    protected void doTrack(@NonNull TrackParams trackParams) {
        Map<String, String> trackParams2;
        if (trackParams.getView() == null || trackParams.getData() == null || (trackParams2 = getTrackParams(trackParams.getData())) == null || !TextUtils.isEmpty(trackParams2.get("arg1"))) {
            return;
        }
        trackParams2.put("arg1", trackParams2.get("spm") + "");
    }

    public GaiaX.IEventDelegate getEventDelegate() {
        return new GaiaX.IEventDelegate() { // from class: com.youku.gaiax.provider.module.js.GaiaXCustomDialogView.1
            @Override // com.youku.gaiax.GaiaX.IEventDelegate
            public void onEvent(@NotNull EventParams eventParams) {
                Log.d("GaiaXCustomDialogView", "onEvent: ");
                GaiaXCustomDialogView.this.doEvent(eventParams);
            }
        };
    }

    public GaiaX.ITrackDelegate3 getTrackDelegate() {
        return new GaiaX.ITrackDelegate3() { // from class: com.youku.gaiax.provider.module.js.GaiaXCustomDialogView.2
            @Override // com.youku.gaiax.GaiaX.ITrackDelegate3
            public void onTrack(@NotNull TrackParams trackParams) {
                GaiaXCustomDialogView.this.doTrack(trackParams);
            }
        };
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.params.isEmpty()) {
            return;
        }
        initDialogFeature();
        GaiaX.Params build = initGaiaXBuilder().build();
        build.setTrackDelegate3(this.trackDelegate);
        build.setEventDelegate(this.eventDelegate);
        GaiaX.Companion.getInstance().bindView(build);
    }
}
