package com.alient.onearch.adapter.component.footer.v2;

import android.app.Activity;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.footer.v2.GenericFooterContract;
import com.alient.onearch.adapter.style.StyleConstant;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.style.Style;
import com.youku.arch.v3.style.StyleUtil;
import com.youku.arch.v3.util.ColorUtil;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \"2\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006:\u0001\"B3\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b \u0010!J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0016\u0010\r\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/alient/onearch/adapter/component/footer/v2/GenericFooterPresent;", "Lcom/alient/onearch/adapter/view/AbsPresenter;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/footer/v2/GenericFooterModel;", "Lcom/alient/onearch/adapter/component/footer/v2/GenericFooterView;", "Lcom/alient/onearch/adapter/component/footer/v2/GenericFooterContract$Presenter;", "", "expend", "Ltb/wt2;", "setExpend", "isExpend", "item", UCCore.LEGACY_EVENT_INIT, "enableAutoExposeTrack", "Landroid/view/View;", "view", "onItemClick", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "targetComponent", "Lcom/youku/arch/v3/IComponent;", "", "displayCount", "Ljava/lang/Integer;", "", "mClassName", "vClassName", "renderView", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", Constants.CONFIG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "Companion", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class GenericFooterPresent extends AbsPresenter<GenericItem<ItemValue>, GenericFooterModel, GenericFooterView> implements GenericFooterContract.Presenter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String KEY_COLLAPSE_CONTENT = "collapse_content";
    @NotNull
    public static final String KEY_EXPEND_CONTENT = "expend_content";
    @NotNull
    public static final String KEY_EXPEND_STATE = "expend_state";
    @Nullable
    private Integer displayCount;
    @Nullable
    private IComponent<ComponentValue> targetComponent;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/alient/onearch/adapter/component/footer/v2/GenericFooterPresent$Companion;", "", "", "KEY_COLLAPSE_CONTENT", "Ljava/lang/String;", "KEY_EXPEND_CONTENT", "KEY_EXPEND_STATE", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericFooterPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    private final boolean isExpend() {
        Boolean bool;
        JSONObject rawJson = ((GenericItem) getItem()).getComponent().getProperty().getRawJson();
        if (rawJson == null || (bool = rawJson.getBoolean(KEY_EXPEND_STATE)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private final void setExpend(boolean z) {
        JSONObject rawJson = ((GenericItem) getItem()).getComponent().getProperty().getRawJson();
        if (rawJson == null) {
            return;
        }
        rawJson.put(KEY_EXPEND_STATE, (Object) Boolean.valueOf(z));
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        return false;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public void onItemClick(@NotNull View view) {
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter;
        String string;
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter2;
        Integer num;
        String string2;
        b41.i(view, "view");
        super.onItemClick(view);
        if (getItemAction() != null) {
            Action itemAction = getItemAction();
            String actionUrl = itemAction == null ? null : itemAction.getActionUrl();
            if (!(actionUrl == null || actionUrl.length() == 0)) {
                return;
            }
        }
        if (isExpend()) {
            setExpend(false);
            JSONObject data = ((GenericItem) getItem()).getProperty().getData();
            if (data != null && (string2 = data.getString(KEY_EXPEND_CONTENT)) != null) {
                ((GenericFooterView) getView()).renderFooter(string2);
            }
            IComponent<ComponentValue> iComponent = this.targetComponent;
            if (iComponent == null || (adapter2 = iComponent.getAdapter()) == null || (num = this.displayCount) == null) {
                return;
            }
            int intValue = num.intValue();
            adapter2.getRenderCount().set(intValue);
            adapter2.notifyItemRangeRemoved(intValue, iComponent.getChildCount() - intValue);
            return;
        }
        setExpend(true);
        JSONObject data2 = ((GenericItem) getItem()).getProperty().getData();
        if (data2 != null && (string = data2.getString(KEY_COLLAPSE_CONTENT)) != null) {
            ((GenericFooterView) getView()).renderFooter(string);
        }
        IComponent<ComponentValue> iComponent2 = this.targetComponent;
        if (iComponent2 == null || (adapter = iComponent2.getAdapter()) == null) {
            return;
        }
        int i = adapter.getRenderCount().get();
        adapter.getRenderCount().set(iComponent2.getChildCount());
        adapter.notifyItemRangeRemoved(i, iComponent2.getChildCount() - i);
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        String string;
        JSONObject data;
        b41.i(genericItem, "item");
        super.init((GenericFooterPresent) genericItem);
        Integer footerHeight = ((GenericFooterModel) getModel()).getFooterHeight();
        if (footerHeight != null) {
            ((GenericFooterView) getView()).renderHeight(footerHeight.intValue());
        }
        JSONObject data2 = genericItem.getProperty().getData();
        if (data2 != null) {
            if (isExpend()) {
                String string2 = data2.getString(KEY_COLLAPSE_CONTENT);
                if (string2 != null) {
                    ((GenericFooterView) getView()).renderFooter(string2);
                }
            } else {
                String string3 = data2.getString(KEY_EXPEND_CONTENT);
                if (string3 != null) {
                    ((GenericFooterView) getView()).renderFooter(string3);
                }
            }
            StyleUtil styleUtil = StyleUtil.INSTANCE;
            boolean z = false;
            if (styleUtil.hasStyle(genericItem.getComponent().getProperty().getStyle(), StyleConstant.FOOTER_BG_COLOR)) {
                Activity activity = genericItem.getPageContext().getActivity();
                if (activity != null) {
                    String hexString = Integer.toHexString(styleUtil.getColor(activity, genericItem.getComponent().getProperty().getStyle(), StyleConstant.FOOTER_BG_COLOR, R.C4040color.white));
                    ((GenericFooterView) getView()).renderBackground(ColorUtil.parseColorSafely(hexString), ColorUtil.parseColorSafely(hexString));
                }
            } else if (styleUtil.hasStyle(genericItem.getComponent().getProperty().getStyle(), StyleConstant.FOOTER_BG_START_COLOR)) {
                Activity activity2 = genericItem.getPageContext().getActivity();
                if (activity2 != null) {
                    Style style = genericItem.getComponent().getProperty().getStyle();
                    int i = R.C4040color.white;
                    ((GenericFooterView) getView()).renderBackground(ColorUtil.parseColorSafely(Integer.toHexString(styleUtil.getColor(activity2, style, StyleConstant.FOOTER_BG_START_COLOR, i))), ColorUtil.parseColorSafely(Integer.toHexString(styleUtil.getColor(activity2, genericItem.getComponent().getProperty().getStyle(), StyleConstant.FOOTER_BG_END_COLOR, i))));
                }
            } else {
                String string4 = data2.getString(StyleConstant.FOOTER_BG_START_COLOR);
                String string5 = data2.getString(StyleConstant.FOOTER_BG_END_COLOR);
                if (!(string4 == null || string4.length() == 0)) {
                    if (!(string5 == null || string5.length() == 0)) {
                        ((GenericFooterView) getView()).renderBackground(ColorUtil.parseColorSafely(string4), ColorUtil.parseColorSafely(string5));
                    }
                }
            }
            if (styleUtil.hasStyle(genericItem.getComponent().getProperty().getStyle(), StyleConstant.FOOTER_TEXT_COLOR)) {
                Activity activity3 = genericItem.getPageContext().getActivity();
                if (activity3 != null) {
                    ((GenericFooterView) getView()).renderFooterTextColor(ColorUtil.parseColorSafely(Integer.toHexString(styleUtil.getColor(activity3, genericItem.getComponent().getProperty().getStyle(), StyleConstant.FOOTER_TEXT_COLOR, R.C4040color.black))));
                }
            } else {
                String string6 = data2.getString(StyleConstant.FOOTER_TEXT_COLOR);
                if (!(!((string6 == null || string6.length() == 0) ? true : true))) {
                    string6 = null;
                }
                if (string6 != null) {
                    ((GenericFooterView) getView()).renderFooterTextColor(ColorUtil.parseColorSafely(string6));
                }
            }
        }
        JSONObject rawJson = genericItem.getComponent().getProperty().getRawJson();
        if (rawJson == null || (string = rawJson.getString("type")) == null) {
            return;
        }
        for (IComponent<ComponentValue> iComponent : genericItem.getComponent().getModule().getComponents()) {
            if (b41.d(String.valueOf(iComponent.getType()), string)) {
                this.targetComponent = iComponent;
                ComponentValue property = iComponent.getProperty();
                this.displayCount = (property == null || (data = property.getData()) == null) ? null : Integer.valueOf(data.getIntValue(com.youku.arch.v3.data.Constants.DISPLAY_NUM));
            }
        }
    }
}
