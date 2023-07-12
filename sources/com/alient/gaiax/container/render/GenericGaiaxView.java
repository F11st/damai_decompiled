package com.alient.gaiax.container.render;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alient.gaiax.container.gaiax.GaiaXBuilder;
import com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider;
import com.alient.gaiax.container.render.GenericGaiaxContract;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.onearch.adapter.view.GenericViewCard;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.view.AbsPresenter;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.api.data.EventParams;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hh1;
import tb.jn1;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0015¢\u0006\u0004\b \u0010!J0\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/alient/gaiax/container/render/GenericGaiaxView;", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/gaiax/container/render/GenericGaiaxModel;", "Lcom/alient/gaiax/container/render/GenericGaiaxPresenter;", "Lcom/alient/gaiax/container/render/GenericGaiaxContract$View;", "", hh1.DIMEN_BIZ, "templateId", "version", "", "width", "Lcom/alibaba/fastjson/JSONObject;", "data", "Ltb/wt2;", "renderGaiax", "viewVisible", "viewInvisible", "Lcom/youku/gaiax/GaiaX$Params;", "targetParams", "Landroid/view/View;", "targetView", "doViewUpdated", "doViewInjected", "type", "", "onCustomMessage", "view", "Landroid/view/View;", "params", "Lcom/youku/gaiax/GaiaX$Params;", "<init>", "(Landroid/view/View;)V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class GenericGaiaxView extends AbsView<GenericItem<ItemValue>, GenericGaiaxModel, GenericGaiaxPresenter> implements GenericGaiaxContract.View {
    @Nullable
    private GaiaX.Params params;
    @NotNull
    private final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericGaiaxView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.view = view;
    }

    public void doViewInjected(@NotNull GaiaX.Params params, @NotNull View view) {
        b41.i(params, "targetParams");
        b41.i(view, "targetView");
        Log.d("GaiaxViewHolder", b41.r("doViewInjected targetView=", view));
    }

    public void doViewUpdated(@NotNull GaiaX.Params params, @NotNull View view) {
        b41.i(params, "targetParams");
        b41.i(view, "targetView");
        Log.d("GaiaxViewHolder", b41.r("doViewUpdated targetView=", view));
    }

    public final boolean onCustomMessage(@NotNull String str, @Nullable JSONObject jSONObject) {
        b41.i(str, "type");
        Log.e(AbsPresenter.TAG, "onMessage() called with: this = [" + this + jn1.ARRAY_END);
        if (b41.d("GAIAX_JS_REFRESH_PAGE", str)) {
            return false;
        }
        b41.d("GAIAX_JS_REFRESH_CARD", str);
        return false;
    }

    @Override // com.alient.gaiax.container.render.GenericGaiaxContract.View
    public void renderGaiax(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull JSONObject jSONObject) {
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        b41.i(jSONObject, "data");
        GaiaXBuilder gaiaXBuilder = new GaiaXBuilder();
        View view = this.view;
        Context context = view.getContext();
        b41.h(context, "view.context");
        final Context context2 = this.view.getContext();
        this.params = GaiaXBuilder.renderGaiaX$default(gaiaXBuilder, view, context, str, str2, str3, "", jSONObject, i, -1, new PictureGaiaXEventProvider(context2) { // from class: com.alient.gaiax.container.render.GenericGaiaxView$renderGaiax$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(context2);
                b41.h(context2, WPKFactory.INIT_KEY_CONTEXT);
            }

            @Override // com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
            public void doViewInjectedFun(@NotNull GaiaX.Params params, @NotNull View view2) {
                b41.i(params, "targetParams");
                b41.i(view2, "targetView");
                GenericGaiaxView.this.doViewInjected(params, view2);
            }

            @Override // com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
            public void doViewUpdatedFun(@NotNull GaiaX.Params params, @NotNull View view2) {
                b41.i(params, "targetParams");
                b41.i(view2, "targetView");
                GenericGaiaxView.this.doViewUpdated(params, view2);
            }

            @Override // com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
            public void onGaiaXEvent(@NotNull EventParams eventParams, @Nullable JSONObject jSONObject2, int i2) {
                b41.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
                JSONObject data = eventParams.getData();
                Object obj = data == null ? null : data.get("eventName");
                String str4 = obj instanceof String ? (String) obj : null;
                if (str4 == null) {
                    return;
                }
                ((GenericGaiaxPresenter) GenericGaiaxView.this.getPresenter()).processEvent(eventParams.getView(), str4, eventParams.getData());
            }

            @Override // com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
            public void onItemViewClick(@NotNull View view2, @Nullable JSONObject jSONObject2, int i2) {
                View view3;
                b41.i(view2, "itemView");
                GenericViewCard viewCard = ((GenericGaiaxPresenter) GenericGaiaxView.this.getPresenter()).getViewCard();
                view3 = GenericGaiaxView.this.view;
                viewCard.onItemClick(view3);
            }

            @Override // com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
            public boolean onMessage(@NotNull String str4, @Nullable JSONObject jSONObject2) {
                b41.i(str4, "type");
                return GenericGaiaxView.this.onCustomMessage(str4, jSONObject2);
            }
        }, false, false, null, 7168, null);
    }

    @Override // com.alient.gaiax.container.render.GenericGaiaxContract.View
    public void viewInvisible() {
        GaiaX.Params params = this.params;
        if (params == null) {
            return;
        }
        GaiaX.Companion.getInstance().invisibleView(params);
    }

    @Override // com.alient.gaiax.container.render.GenericGaiaxContract.View
    public void viewVisible() {
        GaiaX.Params params = this.params;
        if (params == null) {
            return;
        }
        GaiaX.Companion.getInstance().visibleView(params);
    }
}
