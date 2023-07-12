package cn.damai.commonbusiness.scriptmurder.bean;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.bean.BottomAction;
import com.alibaba.pictures.bricks.view.BottomActionDialog;
import com.alient.gaiax.container.event.EventDelegate;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ap2;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class GaiaXEventTelephone implements EventDelegate {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String GAIAX_MAP_EVENT = "map";
    @NotNull
    public static final String GAIAX_TELEPHONES_EVENT = "telephones";
    @NotNull
    public static final String GAIAX_TELEPHONE_EVENT = "telephone";
    @Nullable
    private Activity activity;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public GaiaXEventTelephone(@Nullable Activity activity) {
        this.activity = activity;
    }

    private final void openDialActivity(View view, String str, JSONObject jSONObject, Map<String, ? extends Action> map, Map<String, ? extends Object> map2) {
        ArrayList<BottomAction> arrayList;
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1138253229")) {
            ipChange.ipc$dispatch("1138253229", new Object[]{this, view, str, jSONObject, map, map2});
            return;
        }
        final Activity activity = this.activity;
        if (activity != null) {
            Action action = null;
            Action action2 = map != null ? map.get(str) : null;
            if (action2 == null) {
                action2 = map != null ? map.get("telephone") : null;
            }
            if (action2 != null) {
                action = action2;
                arrayList = ap2.INSTANCE.a(action2.getActionUrl());
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                if (arrayList.isEmpty()) {
                    return;
                }
                if (action != null && (trackInfo = action.getTrackInfo()) != null) {
                    b41.h(trackInfo, "trackInfo");
                    if (view != null) {
                        UserTrackProviderProxy.click(view, trackInfo, true);
                    }
                }
                new BottomActionDialog(activity, arrayList, new BottomActionDialog.OnActionListener() { // from class: cn.damai.commonbusiness.scriptmurder.bean.GaiaXEventTelephone$openDialActivity$1$2$2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.alibaba.pictures.bricks.view.BottomActionDialog.OnActionListener
                    public void onClick(@NotNull BottomAction bottomAction, @NotNull View view2, @NotNull Dialog dialog) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-2143709695")) {
                            ipChange2.ipc$dispatch("-2143709695", new Object[]{this, bottomAction, view2, dialog});
                            return;
                        }
                        b41.i(bottomAction, "action");
                        b41.i(view2, "v");
                        b41.i(dialog, "dialog");
                        dialog.dismiss();
                        ap2.INSTANCE.h(activity, bottomAction.getExtra());
                    }
                }, 0, 8, null).show();
            }
        }
    }

    @Nullable
    public final Activity getActivity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-374688635") ? (Activity) ipChange.ipc$dispatch("-374688635", new Object[]{this}) : this.activity;
    }

    @Override // com.alient.gaiax.container.event.EventDelegate
    public void onEvent(@Nullable View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject, @Nullable Map<String, ? extends Action> map, @Nullable Map<String, ? extends Object> map2) {
        Action action;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1710815325")) {
            ipChange.ipc$dispatch("-1710815325", new Object[]{this, view, context, str, jSONObject, map, map2});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "eventName");
        Activity activity = this.activity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (!b41.d(GAIAX_TELEPHONES_EVENT, str) && !b41.d("telephone", str)) {
            if (!b41.d("map", str) || map == null || (action = map.get(str)) == null) {
                return;
            }
            TrackInfo trackInfo = action.getTrackInfo();
            if (trackInfo != null) {
                b41.h(trackInfo, "trackInfo");
                if (view != null) {
                    UserTrackProviderProxy.click(view, trackInfo, true);
                }
            }
            NavProviderProxy.getProxy().toUri(activity, action);
            return;
        }
        openDialActivity(view, str, jSONObject, map, map2);
    }

    public final void setActivity(@Nullable Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1170768503")) {
            ipChange.ipc$dispatch("-1170768503", new Object[]{this, activity});
        } else {
            this.activity = activity;
        }
    }
}
