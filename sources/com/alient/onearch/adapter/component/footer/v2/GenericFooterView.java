package com.alient.onearch.adapter.component.footer.v2;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.footer.v2.GenericFooterContract;
import com.alient.onearch.adapter.view.AbsView;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\b\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/alient/onearch/adapter/component/footer/v2/GenericFooterView;", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/footer/v2/GenericFooterModel;", "Lcom/alient/onearch/adapter/component/footer/v2/GenericFooterPresent;", "Lcom/alient/onearch/adapter/component/footer/v2/GenericFooterContract$View;", "", WXBasicComponentType.FOOTER, "Ltb/wt2;", "renderFooter", "", "startColor", "endColor", "renderBackground", "height", "renderHeight", "color", "renderFooterTextColor", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "Landroid/widget/TextView;", "Landroid/graphics/drawable/GradientDrawable;", "gradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class GenericFooterView extends AbsView<GenericItem<ItemValue>, GenericFooterModel, GenericFooterPresent> implements GenericFooterContract.View {
    private final TextView footer;
    @NotNull
    private final GradientDrawable gradientDrawable;
    @NotNull
    private final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericFooterView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.view = view;
        this.footer = (TextView) view.findViewById(R.id.content);
        this.gradientDrawable = new GradientDrawable();
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @Override // com.alient.onearch.adapter.component.footer.v2.GenericFooterContract.View
    public void renderBackground(int i, int i2) {
        this.gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        this.gradientDrawable.setColors(new int[]{i, i2});
        this.view.setBackground(this.gradientDrawable);
    }

    public void renderFooter(@NotNull String str) {
        b41.i(str, WXBasicComponentType.FOOTER);
        if (str.length() > 0) {
            this.footer.setText(str);
        }
    }

    @Override // com.alient.onearch.adapter.component.footer.v2.GenericFooterContract.View
    public void renderFooterTextColor(int i) {
        TextView textView = this.footer;
        if (textView == null || textView.getCurrentTextColor() == i) {
            return;
        }
        textView.setTextColor(i);
    }

    @Override // com.alient.onearch.adapter.component.footer.v2.GenericFooterContract.View
    public void renderHeight(int i) {
        if (i != 0) {
            this.view.getLayoutParams().height = i;
        }
    }
}
