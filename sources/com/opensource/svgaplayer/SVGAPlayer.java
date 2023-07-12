package com.opensource.svgaplayer;

import android.content.Context;
import android.util.AttributeSet;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/opensource/svgaplayer/SVGAPlayer;", "Lcom/opensource/svgaplayer/SVGAImageView;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes10.dex */
public final class SVGAPlayer extends SVGAImageView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAPlayer(@NotNull Context context) {
        super(context);
        b41.j(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAPlayer(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.j(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.j(attributeSet, TemplateDom.KEY_ATTRS);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAPlayer(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.j(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.j(attributeSet, TemplateDom.KEY_ATTRS);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAPlayer(@NotNull Context context, @NotNull AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        b41.j(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.j(attributeSet, TemplateDom.KEY_ATTRS);
    }
}
