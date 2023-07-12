package com.alient.gaiax.container.render;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alient.gaiax.container.event.GaiaXEventDispatcher;
import com.alient.gaiax.container.render.GenericGaiaxContract;
import com.alient.gaiax.container.util.DisplayUtil;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.taobao.weex.common.Constants;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.event.FragmentEvent;
import com.youku.arch.v3.event.ViewHolderEvent;
import com.youku.arch.v3.util.ViewUtil;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 -2\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006:\u0001-B3\u0012\u0006\u0010%\u001a\u00020\n\u0012\u0006\u0010&\u001a\u00020\n\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010*\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b+\u0010,J0\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J&\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\n2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0016J$\u0010\u001b\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001aH\u0016J\u0016\u0010\u001d\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006."}, d2 = {"Lcom/alient/gaiax/container/render/GenericGaiaxPresenter;", "Lcom/alient/onearch/adapter/view/AbsPresenter;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/gaiax/container/render/GenericGaiaxModel;", "Lcom/alient/gaiax/container/render/GenericGaiaxView;", "Lcom/alient/gaiax/container/render/GenericGaiaxContract$Presenter;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "", "", "data", "paramName", "", "getDimenId", "item", "Ltb/wt2;", UCCore.LEGACY_EVENT_INIT, "type", "params", "", "onMessage", "Landroid/view/View;", "view", "eventName", "Lcom/alibaba/fastjson/JSONObject;", "processEvent", "Lcom/youku/arch/v3/IItem;", "measureWidth", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "componentConfig", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "getComponentConfig", "()Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "setComponentConfig", "(Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;)V", "mClassName", "vClassName", "renderView", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", Constants.CONFIG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "Companion", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class GenericGaiaxPresenter extends AbsPresenter<GenericItem<ItemValue>, GenericGaiaxModel, GenericGaiaxView> implements GenericGaiaxContract.Presenter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String GAIAX_RECYCLER_VIEW_ITEM_EVENT_NAME = "eventName";
    @NotNull
    public static final String GAIAX_RECYCLER_VIEW_ITEM_EVENT_VALUE = "item";
    @Nullable
    private ComponentConfigBean.ComponentBean componentConfig;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/alient/gaiax/container/render/GenericGaiaxPresenter$Companion;", "", "", "GAIAX_RECYCLER_VIEW_ITEM_EVENT_NAME", "Ljava/lang/String;", "GAIAX_RECYCLER_VIEW_ITEM_EVENT_VALUE", "<init>", "()V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericGaiaxPresenter(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    private final int getDimenId(Context context, Map<String, ? extends Object> map, String str) {
        if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), com.youku.arch.v3.data.Constants.DIMEN);
        }
        return 0;
    }

    @Nullable
    public final ComponentConfigBean.ComponentBean getComponentConfig() {
        return this.componentConfig;
    }

    public int measureWidth(@NotNull IItem<ItemValue> iItem) {
        ComponentConfigBean.ComponentBean.LayoutBean layout;
        HashMap<String, Object> params;
        b41.i(iItem, "item");
        Activity activity = iItem.getPageContext().getActivity();
        int i = 0;
        if (!(activity != null)) {
            activity = null;
        }
        if (activity == null) {
            return 0;
        }
        ComponentConfigBean.ComponentBean componentConfig = getComponentConfig();
        if (componentConfig != null && (layout = componentConfig.getLayout()) != null && (params = layout.getParams()) != null) {
            int dimenId = getDimenId(activity, params, "itemWidth");
            if (dimenId != 0) {
                i = activity.getResources().getDimensionPixelSize(dimenId);
            } else {
                i = DisplayUtil.INSTANCE.getDisplayWidthInPx(activity);
                Object obj = params.get("screenAverage");
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                if (num != null) {
                    i /= num.intValue();
                }
                Object obj2 = params.get("span");
                r2 = obj2 instanceof Integer ? (Integer) obj2 : null;
                if (r2 != null) {
                    int intValue = r2.intValue();
                    int dimenId2 = getDimenId(activity, params, com.youku.arch.v3.data.Constants.GAP);
                    if (dimenId2 != 0) {
                        i -= activity.getResources().getDimensionPixelSize(dimenId2) * (intValue - 1);
                    }
                    int dimenId3 = getDimenId(activity, params, Constants.Name.MARGIN_LEFT);
                    if (dimenId3 != 0) {
                        i -= activity.getResources().getDimensionPixelSize(dimenId3);
                    }
                    int dimenId4 = getDimenId(activity, params, Constants.Name.MARGIN_RIGHT);
                    if (dimenId4 != 0) {
                        i -= activity.getResources().getDimensionPixelSize(dimenId4);
                    }
                    i /= intValue;
                }
            }
            r2 = params;
        }
        return r2 == null ? DisplayUtil.INSTANCE.getDisplayWidthInPx(activity) : i;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        boolean q;
        boolean q2;
        boolean q3;
        b41.i(str, "type");
        q = o.q(FragmentEvent.ON_FRAGMENT_RESUME, str, true);
        if (q) {
            Object obj = map == null ? null : map.get("state");
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            if (bool != null) {
                if (bool.booleanValue()) {
                    ((GenericGaiaxView) getView()).viewVisible();
                } else {
                    ((GenericGaiaxView) getView()).viewInvisible();
                }
            }
        } else {
            q2 = o.q(ViewHolderEvent.ON_VIEW_ATTACHED_TO_WINDOW, str, true);
            if (q2) {
                ((GenericGaiaxView) getView()).viewVisible();
            } else {
                q3 = o.q(ViewHolderEvent.ON_VIEW_DETACHED_FROM_WINDOW, str, true);
                if (q3) {
                    ((GenericGaiaxView) getView()).viewInvisible();
                }
            }
        }
        return super.onMessage(str, map);
    }

    @Override // com.alient.gaiax.container.render.GenericGaiaxContract.Presenter
    public void processEvent(@Nullable View view, @NotNull String str, @Nullable JSONObject jSONObject) {
        String pageName;
        b41.i(str, "eventName");
        Activity activity = ((GenericItem) getItem()).getPageContext().getActivity();
        if (activity == null || (pageName = ((GenericItem) getItem()).getPageContext().getPageName()) == null) {
            return;
        }
        GaiaXEventDispatcher.Companion.getInstance().dispatch(view, activity, pageName, str, ((GenericItem) getItem()).getProperty().getData(), getActions(), jSONObject == null ? null : jSONObject.getInnerMap());
    }

    public final void setComponentConfig(@Nullable ComponentConfigBean.ComponentBean componentBean) {
        this.componentConfig = componentBean;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c7, code lost:
        tb.b41.h(r5, tb.hh1.DIMEN_BIZ);
        tb.b41.h(r6, "templateId");
        tb.b41.h(r7, "version");
        ((com.alient.gaiax.container.render.GenericGaiaxView) getView()).renderGaiax(r5, r6, r7, measureWidth(r11), r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:?, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void init(@org.jetbrains.annotations.NotNull com.youku.arch.v3.core.item.GenericItem<com.youku.arch.v3.core.ItemValue> r11) {
        /*
            r10 = this;
            java.lang.String r0 = "templateId"
            java.lang.String r1 = "bizId"
            java.lang.String r2 = "item"
            tb.b41.i(r11, r2)
            super.init(r11)
            com.youku.arch.v3.core.IContext r2 = r11.getPageContext()
            android.app.Activity r2 = r2.getActivity()
            r3 = 0
            if (r2 != 0) goto L18
            goto L51
        L18:
            com.youku.arch.v3.core.IContext r4 = r11.getPageContext()
            com.youku.arch.v3.core.ConfigManager r4 = r4.getConfigManager()
            if (r4 != 0) goto L23
            goto L51
        L23:
            java.lang.String r5 = "component_config_file"
            java.lang.String r4 = r4.getPathConfig(r5)
            if (r4 != 0) goto L2c
            goto L51
        L2c:
            com.youku.arch.v3.view.config.ComponentConfigBean$ComponentBean r5 = r10.getComponentConfig()
            if (r5 != 0) goto L51
            com.youku.arch.v3.view.config.ComponentConfigManager$Companion r5 = com.youku.arch.v3.view.config.ComponentConfigManager.Companion
            com.youku.arch.v3.view.config.ComponentConfigManager r5 = r5.getInstance()
            android.util.SparseArray r2 = r5.getComponentConfigs(r2, r4)
            if (r2 != 0) goto L40
            r2 = r3
            goto L4e
        L40:
            com.youku.arch.v3.IComponent r4 = r11.getComponent()
            int r4 = r4.getType()
            java.lang.Object r2 = r2.get(r4)
            com.youku.arch.v3.view.config.ComponentConfigBean$ComponentBean r2 = (com.youku.arch.v3.view.config.ComponentConfigBean.ComponentBean) r2
        L4e:
            r10.setComponentConfig(r2)
        L51:
            com.youku.arch.v3.core.ItemValue r2 = r11.getProperty()
            java.util.List r2 = r2.getRenders()
            if (r2 != 0) goto L5d
            goto Le8
        L5d:
            java.lang.Object r2 = kotlin.collections.k.P(r2)
            com.youku.arch.v3.core.Render r2 = (com.youku.arch.v3.core.Render) r2
            if (r2 != 0) goto L67
            goto Le8
        L67:
            java.lang.String r2 = r2.url     // Catch: java.lang.Exception -> Le1
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch: java.lang.Exception -> Le1
            java.lang.String r5 = r2.getQueryParameter(r1)     // Catch: java.lang.Exception -> Le1
            java.lang.String r6 = r2.getQueryParameter(r0)     // Catch: java.lang.Exception -> Le1
            java.lang.String r4 = "templateVersion"
            java.lang.String r7 = r2.getQueryParameter(r4)     // Catch: java.lang.Exception -> Le1
            com.youku.arch.v3.core.ItemValue r2 = r11.getProperty()     // Catch: java.lang.Exception -> Le1
            com.alibaba.fastjson.JSONObject r2 = r2.getData()     // Catch: java.lang.Exception -> Le1
            r4 = 1
            r8 = 0
            if (r2 == 0) goto L89
            r9 = 1
            goto L8a
        L89:
            r9 = 0
        L8a:
            if (r9 == 0) goto L8e
            r9 = r2
            goto L8f
        L8e:
            r9 = r3
        L8f:
            if (r9 != 0) goto L92
            goto Le8
        L92:
            java.lang.String r2 = "isLastChild"
            boolean r3 = r10.isLastChild()     // Catch: java.lang.Exception -> Le1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch: java.lang.Exception -> Le1
            r9.put(r2, r3)     // Catch: java.lang.Exception -> Le1
            if (r5 == 0) goto Laa
            int r2 = r5.length()     // Catch: java.lang.Exception -> Le1
            if (r2 != 0) goto La8
            goto Laa
        La8:
            r2 = 0
            goto Lab
        Laa:
            r2 = 1
        Lab:
            if (r2 != 0) goto Le8
            if (r6 == 0) goto Lb8
            int r2 = r6.length()     // Catch: java.lang.Exception -> Le1
            if (r2 != 0) goto Lb6
            goto Lb8
        Lb6:
            r2 = 0
            goto Lb9
        Lb8:
            r2 = 1
        Lb9:
            if (r2 != 0) goto Le8
            if (r7 == 0) goto Lc5
            int r2 = r7.length()     // Catch: java.lang.Exception -> Le1
            if (r2 != 0) goto Lc4
            goto Lc5
        Lc4:
            r4 = 0
        Lc5:
            if (r4 != 0) goto Le8
            com.youku.arch.v3.view.IContract$View r2 = r10.getView()     // Catch: java.lang.Exception -> Le1
            r4 = r2
            com.alient.gaiax.container.render.GenericGaiaxView r4 = (com.alient.gaiax.container.render.GenericGaiaxView) r4     // Catch: java.lang.Exception -> Le1
            tb.b41.h(r5, r1)     // Catch: java.lang.Exception -> Le1
            tb.b41.h(r6, r0)     // Catch: java.lang.Exception -> Le1
            java.lang.String r0 = "version"
            tb.b41.h(r7, r0)     // Catch: java.lang.Exception -> Le1
            int r8 = r10.measureWidth(r11)     // Catch: java.lang.Exception -> Le1
            r4.renderGaiax(r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> Le1
            goto Le8
        Le1:
            r11 = move-exception
            boolean r0 = com.youku.middlewareservice.provider.info.AppInfoProviderProxy.isDebuggable()
            if (r0 != 0) goto Le9
        Le8:
            return
        Le9:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alient.gaiax.container.render.GenericGaiaxPresenter.init(com.youku.arch.v3.core.item.GenericItem):void");
    }
}
