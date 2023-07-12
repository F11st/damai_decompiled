package com.alibaba.gaiax.render.view.container.slider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hs0;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eB\u001b\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001d\u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016J#\u0010\u000e\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/slider/GXSliderDefaultIndicatorView;", "Lcom/alibaba/gaiax/render/view/container/slider/GXSliderBaseIndicatorView;", "Ltb/wt2;", "initView", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", AdUtConstants.XAD_UT_ARG_COUNT, "setIndicatorCount", "index", "updateSelectedIndex", "selectedColor", "unselectedColor", "setIndicatorColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "indicatorCount", "I", "lastIndex", "currentIndex", "Ljava/lang/Integer;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "a", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public final class GXSliderDefaultIndicatorView extends GXSliderBaseIndicatorView {
    @NotNull
    public static final a Companion = new a(null);
    private static final float INDICATOR_HEIGHT;
    private static final float INDICATOR_NORMAL_WIDTH;
    private static final float INDICATOR_SELECTED_WIDTH;
    private static final float INDICATOR_SPACING;
    private int currentIndex;
    private int indicatorCount;
    private int lastIndex;
    @NotNull
    private final Paint paint;
    @Nullable
    private Integer selectedColor;
    @Nullable
    private Integer unselectedColor;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    static {
        hs0.b bVar = hs0.Companion;
        INDICATOR_SPACING = bVar.e(5.0f);
        INDICATOR_NORMAL_WIDTH = bVar.e(8.0f);
        INDICATOR_SELECTED_WIDTH = bVar.e(8.0f);
        INDICATOR_HEIGHT = bVar.e(8.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXSliderDefaultIndicatorView(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.paint = new Paint();
        initView();
    }

    private final void initView() {
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(1.0f);
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        float f;
        float f2;
        int i = this.indicatorCount;
        if (i <= 0) {
            return;
        }
        float f3 = 0.0f;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 == this.currentIndex) {
                Integer num = this.selectedColor;
                if (num != null) {
                    this.paint.setColor(num.intValue());
                    wt2 wt2Var = wt2.INSTANCE;
                }
                if (canvas != null) {
                    canvas.drawRect(f3, 0.0f, f3 + INDICATOR_SELECTED_WIDTH, INDICATOR_HEIGHT, this.paint);
                }
                f = INDICATOR_SELECTED_WIDTH;
                f2 = INDICATOR_SPACING;
            } else {
                Integer num2 = this.unselectedColor;
                if (num2 != null) {
                    this.paint.setColor(num2.intValue());
                    wt2 wt2Var2 = wt2.INSTANCE;
                }
                if (canvas != null) {
                    canvas.drawRect(f3, 0.0f, f3 + INDICATOR_NORMAL_WIDTH, INDICATOR_HEIGHT, this.paint);
                }
                f = INDICATOR_NORMAL_WIDTH;
                f2 = INDICATOR_SPACING;
            }
            f3 += f + f2;
            if (i3 >= i) {
                return;
            }
            i2 = i3;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.indicatorCount;
        setMeasuredDimension((int) (((i3 - 1) * INDICATOR_NORMAL_WIDTH) + INDICATOR_SELECTED_WIDTH + ((i3 - 1) * INDICATOR_SPACING)), (int) INDICATOR_HEIGHT);
    }

    @Override // com.alibaba.gaiax.render.view.container.slider.GXSliderBaseIndicatorView
    public void setIndicatorColor(@Nullable Integer num, @Nullable Integer num2) {
        this.selectedColor = num;
        this.unselectedColor = num2;
    }

    @Override // com.alibaba.gaiax.render.view.container.slider.GXSliderBaseIndicatorView
    public void setIndicatorCount(int i) {
        this.indicatorCount = i;
    }

    @Override // com.alibaba.gaiax.render.view.container.slider.GXSliderBaseIndicatorView
    public void updateSelectedIndex(int i) {
        this.lastIndex = this.currentIndex;
        this.currentIndex = i;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXSliderDefaultIndicatorView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.paint = new Paint();
        initView();
    }
}
