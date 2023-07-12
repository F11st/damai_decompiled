package com.youku.gaiax.provider.module.js;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.youku.arch.v3.token.DimenStrategyTokenManager;
import com.youku.gaiax.impl.utils.GaiaXUiExecutor;
import com.youku.gaiax.js.api.GaiaXBaseModule;
import com.youku.gaiax.js.api.annotation.GaiaXSyncMethod;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0007R\u0016\u0010\u0013\u001a\u00020\u00068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/provider/module/js/GaiaXOneArchModule;", "Lcom/youku/gaiax/js/api/GaiaXBaseModule;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View;", "view", "", "behavior", "", "targetIndex", "Ltb/wt2;", "launchScrollWithBehavior", "Lcom/alibaba/fastjson/JSONObject;", "params", "refresh", "args", "scrollTo", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXOneArchModule extends GaiaXBaseModule {
    /* JADX INFO: Access modifiers changed from: private */
    public final void launchScrollWithBehavior(RecyclerView recyclerView, View view, String str, int i) {
        if (b41.d(str, "smooth")) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null && layoutManager.canScrollVertically()) {
                int top = view.getTop();
                DimenStrategyTokenManager companion = DimenStrategyTokenManager.Companion.getInstance();
                Context context = recyclerView.getContext();
                b41.h(context, "recyclerView.context");
                Integer token = companion.getToken(context, "pic_margin_right");
                b41.f(token);
                recyclerView.smoothScrollBy(0, top - token.intValue());
                return;
            }
            int left = view.getLeft();
            DimenStrategyTokenManager companion2 = DimenStrategyTokenManager.Companion.getInstance();
            Context context2 = recyclerView.getContext();
            b41.h(context2, "recyclerView.context");
            Integer token2 = companion2.getToken(context2, "pic_margin_left");
            b41.f(token2);
            recyclerView.smoothScrollBy(left - token2.intValue(), 0);
        } else if (b41.d(str, "instant")) {
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            Objects.requireNonNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager2).scrollToPositionWithOffset(i, 0);
        }
    }

    @Override // com.youku.gaiax.js.api.IGaiaXModule
    @NotNull
    public String getName() {
        return "OneArch";
    }

    @GaiaXSyncMethod
    public final void refresh(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "params");
        String string = jSONObject.getString("templateId");
        Long l = jSONObject.getLong("instanceId");
        String string2 = jSONObject.getString("type");
        Boolean bool = jSONObject.getBoolean("resetOffset");
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        Boolean bool2 = jSONObject.getBoolean("noRequest");
        boolean booleanValue2 = bool2 == null ? false : bool2.booleanValue();
        if (string2 != null) {
            if (string2.equals("card")) {
                JSDelegate companion = JSDelegate.Companion.getInstance();
                b41.h(l, "componentId");
                long longValue = l.longValue();
                b41.h(string, "templateId");
                companion.refreshCard(longValue, string, booleanValue2);
            } else if (string2.equals("page")) {
                JSDelegate companion2 = JSDelegate.Companion.getInstance();
                b41.h(l, "componentId");
                long longValue2 = l.longValue();
                b41.h(string, "templateId");
                companion2.refreshPage(longValue2, string, booleanValue, booleanValue2);
            } else if (string2.equals("component")) {
                JSDelegate companion3 = JSDelegate.Companion.getInstance();
                b41.h(l, "componentId");
                long longValue3 = l.longValue();
                b41.h(string, "templateId");
                companion3.refreshComponent(longValue3, string);
            }
        }
    }

    @GaiaXSyncMethod
    public final void scrollTo(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "args");
        String string = jSONObject.getString("templateId");
        String string2 = jSONObject.getString("instanceId");
        JSONObject jSONObject2 = jSONObject.getJSONObject("params");
        final int intValue = jSONObject2.containsKey("itemIndex") ? jSONObject2.getIntValue("itemIndex") : 0;
        final String string3 = jSONObject2.containsKey("behavior") ? jSONObject2.getString("behavior") : "smooth";
        final String string4 = jSONObject2.containsKey("position") ? jSONObject2.getString("position") : "none";
        Log.d("GXJSOneArchModule", "scrollTo() called with templateId:" + ((Object) string) + " and instanceId:" + ((Object) string2) + " and itemIndex:" + intValue + " and behavior: " + ((Object) string3) + " and position: " + ((Object) string4));
        JSDelegate companion = JSDelegate.Companion.getInstance();
        b41.h(string, "templateId");
        b41.h(string2, "instanceId");
        View templateView = companion.getTemplateView(string, Long.parseLong(string2));
        if (templateView == null || !(templateView instanceof RecyclerView)) {
            return;
        }
        final RecyclerView recyclerView = (RecyclerView) templateView;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        final View findViewByPosition = layoutManager == null ? null : layoutManager.findViewByPosition(intValue);
        GaiaXUiExecutor.INSTANCE.action(new Function0<wt2>() { // from class: com.youku.gaiax.provider.module.js.GaiaXOneArchModule$scrollTo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                String str2;
                if (findViewByPosition == null || (str = string4) == null) {
                    return;
                }
                switch (str.hashCode()) {
                    case -1383228885:
                        str2 = "bottom";
                        break;
                    case -465209349:
                        str2 = "center-vertically";
                        break;
                    case 115029:
                        if (str.equals("top")) {
                            GaiaXOneArchModule gaiaXOneArchModule = this;
                            RecyclerView recyclerView2 = recyclerView;
                            View view = findViewByPosition;
                            String str3 = string3;
                            b41.h(str3, "behavior");
                            gaiaXOneArchModule.launchScrollWithBehavior(recyclerView2, view, str3, intValue);
                            return;
                        }
                        return;
                    case 3317767:
                        if (str.equals("left")) {
                            GaiaXOneArchModule gaiaXOneArchModule2 = this;
                            RecyclerView recyclerView3 = recyclerView;
                            View view2 = findViewByPosition;
                            String str4 = string3;
                            b41.h(str4, "behavior");
                            gaiaXOneArchModule2.launchScrollWithBehavior(recyclerView3, view2, str4, intValue);
                            return;
                        }
                        return;
                    case 3387192:
                        if (str.equals("none")) {
                            GaiaXOneArchModule gaiaXOneArchModule3 = this;
                            RecyclerView recyclerView4 = recyclerView;
                            View view3 = findViewByPosition;
                            String str5 = string3;
                            b41.h(str5, "behavior");
                            gaiaXOneArchModule3.launchScrollWithBehavior(recyclerView4, view3, str5, intValue);
                            return;
                        }
                        return;
                    case 108511772:
                        str2 = "right";
                        break;
                    case 269046314:
                        str2 = "centered-horizontally";
                        break;
                    default:
                        return;
                }
                str.equals(str2);
            }
        });
    }
}
