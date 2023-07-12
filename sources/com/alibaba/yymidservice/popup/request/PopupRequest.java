package com.alibaba.yymidservice.popup.request;

import android.app.Activity;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.popup.request.bean.PopupDetailBean;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import com.alibaba.yymidservice.popup.request.requestparam.PopupRequestParam;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsKt;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a23;
import tb.b41;
import tb.ct1;
import tb.dc0;
import tb.lt1;
import tb.pt1;
import tb.rb0;
import tb.wt2;
import tb.yh0;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class PopupRequest {
    @NotNull
    public static final PopupRequest INSTANCE = new PopupRequest();

    private PopupRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String str, ArrayList<PopupDetailBean> arrayList) {
        PopupDetailBean.PopupItem popupItem;
        JSONObject jSONObject;
        if (str == null || str.length() == 0) {
            return;
        }
        List t0 = str != null ? StringsKt__StringsKt.t0(str, new String[]{"."}, false, 0, 6, null) : null;
        if ((t0 == null || t0.isEmpty()) || t0.size() <= 1) {
            return;
        }
        String str2 = (String) t0.get(0);
        String str3 = (String) t0.get(1);
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<PopupDetailBean> it = arrayList.iterator();
        while (it.hasNext()) {
            PopupDetailBean next = it.next();
            Object obj = (next == null || (popupItem = next.item) == null || (jSONObject = popupItem.value) == null) ? null : jSONObject.get("action");
            Map map = obj instanceof Map ? (Map) obj : null;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    Object obj2 = ((JSONObject) entry.getValue()).get("trackInfo");
                    JSONObject jSONObject2 = obj2 instanceof JSONObject ? (JSONObject) obj2 : null;
                    if (jSONObject2 != null) {
                        jSONObject2.put((JSONObject) "spma", str2);
                        jSONObject2.put((JSONObject) "spmb", str3);
                    }
                }
            }
        }
    }

    @JvmOverloads
    public final void b(@NotNull final Activity activity, @NotNull final String str, @NotNull final String str2, @Nullable final ArrayList<String> arrayList, @Nullable final JSONObject jSONObject, @Nullable final PopupListener popupListener) {
        b41.i(activity, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "comboCityId");
        b41.i(str2, "sceneType");
        rb0.C9647a c9647a = rb0.Companion;
        PopupRequestParam popupRequestParam = new PopupRequestParam();
        popupRequestParam.setComboCityId(str);
        popupRequestParam.setSceneType(str2);
        popupRequestParam.setEventType(arrayList);
        popupRequestParam.setArgs(jSONObject);
        c9647a.b(popupRequestParam).c(activity).a().doOnKTSuccess(new Function1<PopupResponseBean, wt2>() { // from class: com.alibaba.yymidservice.popup.request.PopupRequest$tryPopupRequest$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(PopupResponseBean popupResponseBean) {
                invoke2(popupResponseBean);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PopupResponseBean popupResponseBean) {
                b41.i(popupResponseBean, AdvanceSetting.NETWORK_TYPE);
                PopupRequest popupRequest = PopupRequest.INSTANCE;
                popupRequest.c(popupResponseBean.spmab, popupResponseBean.show);
                popupRequest.c(popupResponseBean.spmab, popupResponseBean.trigger);
                ct1.C9015a c9015a = ct1.Companion;
                c9015a.a().l(popupResponseBean.sceneTypes);
                lt1.C9421a c9421a = lt1.Companion;
                c9421a.a().o().compareAndSet(false, true);
                HashMap hashMap = new HashMap();
                hashMap.put("sceneType", str2.toString());
                hashMap.put("sceneTypes", yh0.INSTANCE.e(popupResponseBean.sceneTypes));
                String simpleName = activity.getClass().getSimpleName();
                b41.h(simpleName, "context::class.java.simpleName");
                pt1.g(simpleName, AgooConstants.MESSAGE_POPUP, "request_success", hashMap);
                c9015a.a().d().put(c9421a.a().c(activity, str2, arrayList), popupResponseBean);
                c9015a.a().j(c9421a.a().c(activity, str2, arrayList), popupResponseBean.trigger);
                PopupListener popupListener2 = popupListener;
                if (popupListener2 != null) {
                    popupListener2.onSuccess(popupResponseBean);
                }
            }
        }).doOnKTFail(new Function1<dc0<PopupResponseBean>, wt2>() { // from class: com.alibaba.yymidservice.popup.request.PopupRequest$tryPopupRequest$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(dc0<PopupResponseBean> dc0Var) {
                invoke2(dc0Var);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull dc0<PopupResponseBean> dc0Var) {
                b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                lt1.Companion.a().o().compareAndSet(false, false);
                String ttid = AppInfoProviderProxy.getTTID();
                a23 a23Var = a23.INSTANCE;
                String str3 = new PopupRequestParam().API_NAME;
                String e = dc0Var.e();
                String f = dc0Var.f();
                a23Var.a(a23Var.b(str3, "弹窗请求", e, f, "comboChannel :  " + ttid + "  comboCityId : " + str + " sceneType: " + str2 + "  eventType：" + arrayList + " args : " + jSONObject), "-106", "弹窗请求");
                HashMap hashMap = new HashMap();
                String f2 = dc0Var.f();
                if (f2 == null) {
                    f2 = "错误描述为空";
                }
                hashMap.put("message", f2);
                String e2 = dc0Var.e();
                if (e2 == null) {
                    e2 = "错误码为空";
                }
                hashMap.put("code", e2);
                String simpleName = activity.getClass().getSimpleName();
                b41.h(simpleName, "context::class.java.simpleName");
                pt1.g(simpleName, AgooConstants.MESSAGE_POPUP, "request_fail", hashMap);
                PopupListener popupListener2 = popupListener;
                if (popupListener2 != null) {
                    popupListener2.onFail(String.valueOf(dc0Var.e()), dc0Var.f());
                }
            }
        }).doOnKTFinish(new Function0<wt2>() { // from class: com.alibaba.yymidservice.popup.request.PopupRequest$tryPopupRequest$4
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        });
    }
}
