package com.alibaba.gaiax.render.view.container.slider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fB\u001b\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000e\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J#\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/slider/GXSliderBaseIndicatorView;", "Landroid/view/View;", "", AdUtConstants.XAD_UT_ARG_COUNT, "Ltb/wt2;", "setIndicatorCount", "index", "updateSelectedIndex", "selectedColor", "unselectedColor", "setIndicatorColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public abstract class GXSliderBaseIndicatorView extends View {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXSliderBaseIndicatorView(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public abstract void setIndicatorColor(@Nullable Integer num, @Nullable Integer num2);

    public abstract void setIndicatorCount(int i);

    public abstract void updateSelectedIndex(int i);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXSliderBaseIndicatorView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }
}
