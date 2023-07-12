package com.alibaba.gaiax.render.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.render.view.basic.GXIImageView;
import com.alibaba.gaiax.render.view.basic.GXIconFont;
import com.alibaba.gaiax.render.view.basic.GXShadowLayout;
import com.alibaba.gaiax.render.view.basic.GXText;
import com.alibaba.gaiax.render.view.basic.GXView;
import com.alibaba.gaiax.render.view.container.GXContainer;
import com.alibaba.gaiax.render.view.container.GXContainerViewAdapter;
import com.alibaba.gaiax.render.view.container.slider.GXSliderView;
import com.alibaba.gaiax.template.GXStyleConvert;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.core.Constants;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ds0;
import tb.er0;
import tb.hr0;
import tb.hs0;
import tb.jr0;
import tb.l81;
import tb.ls0;
import tb.mq0;
import tb.nq0;
import tb.os0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class GXViewExtKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (viewGroup.getChildAt(i) instanceof GXShadowLayout) {
                    return true;
                }
                if (i == childCount) {
                    break;
                }
                i = i2;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View view, boolean z) {
        ViewParent parent = view.getParent();
        if (parent == null) {
            return;
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).setClipChildren(z);
        }
        if (!(parent instanceof View) || (parent instanceof RecyclerView)) {
            return;
        }
        d((View) parent, z);
    }

    public static final void e(@NotNull View view, @Nullable ls0 ls0Var) {
        ds0 i;
        b41.i(view, "<this>");
        float[] fArr = null;
        hr0 e = ls0Var == null ? null : ls0Var.e();
        mq0 c = ls0Var == null ? null : ls0Var.c();
        if (e != null) {
            if (!(view instanceof GXText)) {
                view.setBackground(e.a(view.getContext()));
            }
        } else if (c != null) {
            view.setBackground(c.b(view.getContext()));
        } else {
            view.getBackground();
            view.setBackground(null);
        }
        if ((view.getBackground() instanceof nq0) || (view.getBackground() instanceof jr0)) {
            Drawable background = view.getBackground();
            Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            if (ls0Var != null && (i = ls0Var.i()) != null) {
                fArr = i.e();
            }
            gradientDrawable.setCornerRadii(fArr);
        }
    }

    public static final void f(@NotNull View view, @Nullable Integer num) {
        b41.i(view, "<this>");
        if (num == null) {
            return;
        }
        view.setVisibility(num.intValue());
    }

    public static final void g(@NotNull GXText gXText, @Nullable hr0 hr0Var) {
        b41.i(gXText, "<this>");
        if (hr0Var != null) {
            gXText.setTextColor(-16777216);
            gXText.getPaint().setShader(hr0Var.c(gXText));
        }
    }

    public static final void h(@NotNull GXText gXText, @NotNull ls0 ls0Var) {
        b41.i(gXText, "<this>");
        b41.i(ls0Var, "style");
        if (ls0Var.u() != null) {
            gXText.setTypeface(ls0Var.u());
        } else if (ls0Var.I() != null) {
            gXText.setTypeface(ls0Var.I());
        } else {
            gXText.setTypeface(null);
        }
        if ((gXText instanceof GXIconFont) && ls0Var.u() == null) {
            GXRegisterCenter.b d = GXRegisterCenter.Companion.a().d();
            boolean z = false;
            if (d != null && d.h()) {
                z = true;
            }
            if (z) {
                Typeface n = GXStyleConvert.Companion.a().n("iconfont");
                if (n == null) {
                    return;
                }
                ((GXIconFont) gXText).setTypeface(n);
                return;
            }
            throw new IllegalArgumentException("GXIconFont view must have font family property");
        }
    }

    public static final void i(@NotNull GXText gXText, @NotNull ls0 ls0Var) {
        b41.i(gXText, "<this>");
        b41.i(ls0Var, "style");
        Integer C = ls0Var.C();
        if (C != null) {
            v(gXText, C.intValue() | 16);
        } else {
            v(gXText, 19);
        }
    }

    public static final void j(@NotNull GXText gXText, @NotNull ls0 ls0Var) {
        b41.i(gXText, "<this>");
        b41.i(ls0Var, "style");
        if (ls0Var.G() == null) {
            gXText.setEllipsize(null);
        } else {
            gXText.setEllipsize(ls0Var.G());
        }
    }

    public static final void k(@NotNull View view, @NotNull os0 os0Var, @NotNull er0 er0Var, @Nullable l81 l81Var) {
        boolean m;
        b41.i(view, "<this>");
        b41.i(os0Var, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(er0Var, Constants.CONFIG);
        final int e = er0Var.e();
        final int a = er0Var.a(os0Var);
        final boolean k = er0Var.k();
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            GXContainerViewAdapter gXContainerViewAdapter = adapter instanceof GXContainerViewAdapter ? (GXContainerViewAdapter) adapter : null;
            if (gXContainerViewAdapter == null) {
                m = false;
            } else {
                m = gXContainerViewAdapter.m(l81Var == null ? 0.0f : l81Var.e());
            }
            if (recyclerView.getLayoutManager() != null && !m) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                ((GridLayoutManager) layoutManager).setSpanCount(a);
                return;
            }
            recyclerView.setLayoutManager(null);
            final Context context = recyclerView.getContext();
            recyclerView.setLayoutManager(new GridLayoutManager(e, k, a, context) { // from class: com.alibaba.gaiax.render.view.GXViewExtKt$setGridContainerDirection$target$1
                final /* synthetic */ int a;
                final /* synthetic */ boolean b;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(context, a, e, false);
                    this.a = e;
                    this.b = k;
                }

                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public boolean canScrollHorizontally() {
                    return false;
                }

                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public boolean canScrollVertically() {
                    return this.a == 1 && this.b;
                }
            });
        }
    }

    public static final void l(@NotNull View view, @NotNull final Rect rect, final int i, final int i2) {
        b41.i(view, "<this>");
        b41.i(rect, Constants.Name.PADDING);
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getItemDecorationCount() > 0) {
                recyclerView.removeItemDecorationAt(0);
            }
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.alibaba.gaiax.render.view.GXViewExtKt$setGridContainerItemSpacingAndRowSpacing$decoration$1
                /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                private final void a(float r15, float r16, android.graphics.Rect r17, int r18, int r19, android.graphics.Rect r20, int r21, int r22) {
                    /*
                        Method dump skipped, instructions count: 208
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.alibaba.gaiax.render.view.GXViewExtKt$setGridContainerItemSpacingAndRowSpacing$decoration$1.a(float, float, android.graphics.Rect, int, int, android.graphics.Rect, int, int):void");
                }

                private final void b(float f, Rect rect2, int i3, int i4, Rect rect3, int i5, int i6) {
                    float f2;
                    float f3;
                    float f4 = i4 - 1;
                    int i7 = rect2.left;
                    int i8 = rect2.right;
                    float f5 = ((f * f4) + (i7 + i8)) / i4;
                    int i9 = i5 % i4;
                    int i10 = rect2.top;
                    float f6 = i10;
                    int i11 = rect2.bottom;
                    float f7 = i11;
                    if (i7 == 0 && i8 == 0 && i10 == 0 && i11 == 0) {
                        f2 = (i9 * f5) / f4;
                    } else if (i4 != 1) {
                        f2 = ((i9 * ((f5 - i7) - i8)) / f4) + ((i7 + i8) / 2);
                    } else {
                        f2 = i7;
                        f3 = i8;
                        rect3.left = (int) f2;
                        rect3.top = (int) f6;
                        rect3.right = (int) f3;
                        rect3.bottom = (int) f7;
                    }
                    f3 = f5 - f2;
                    rect3.left = (int) f2;
                    rect3.top = (int) f6;
                    rect3.right = (int) f3;
                    rect3.bottom = (int) f7;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(@NotNull Rect rect2, @NotNull View view2, @NotNull RecyclerView recyclerView2, @NotNull RecyclerView.State state) {
                    b41.i(rect2, "outRect");
                    b41.i(view2, "view");
                    b41.i(recyclerView2, "parent");
                    b41.i(state, "state");
                    super.getItemOffsets(rect2, view2, recyclerView2, state);
                    RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                    Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                    int childAdapterPosition = recyclerView2.getChildAdapterPosition(view2);
                    RecyclerView.Adapter adapter = recyclerView2.getAdapter();
                    int itemCount = adapter == null ? 0 : adapter.getItemCount();
                    int spanCount = gridLayoutManager.getSpanCount();
                    int orientation = gridLayoutManager.getOrientation();
                    int i3 = recyclerView2.getLayoutParams().height;
                    int i4 = view2.getLayoutParams().height;
                    if (orientation == 1 && (itemCount * 1.0f) / spanCount <= 1.0f && i4 > 0 && i3 > 0) {
                        int i5 = (int) ((i3 - i4) / 2.0f);
                        Rect rect3 = rect;
                        b(i, new Rect(rect3.left, i5, rect3.right, i5), orientation, spanCount, rect2, childAdapterPosition, itemCount);
                        return;
                    }
                    a(i, i2, rect, orientation, spanCount, rect2, childAdapterPosition, itemCount);
                }
            });
        }
    }

    public static final void m(@NotNull View view, @Nullable Integer num, @Nullable Integer num2) {
        b41.i(view, "<this>");
        if (num == null) {
            if (num2 == null) {
                return;
            }
            view.setVisibility(num2.intValue());
        } else if (num.intValue() == 0 && num2 != null && num2.intValue() == 4) {
            view.setVisibility(num2.intValue());
        } else if (num.intValue() == 0 && num2 != null && num2.intValue() == 0) {
            view.setVisibility(num2.intValue());
        } else {
            view.setVisibility(num.intValue());
        }
    }

    public static final void n(@NotNull View view, final int i) {
        b41.i(view, "<this>");
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getItemDecorationCount() > 0) {
                return;
            }
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.alibaba.gaiax.render.view.GXViewExtKt$setHorizontalScrollContainerLineSpacing$decoration$1
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(@NotNull Rect rect, @NotNull View view2, @NotNull RecyclerView recyclerView2, @NotNull RecyclerView.State state) {
                    b41.i(rect, "outRect");
                    b41.i(view2, "view");
                    b41.i(recyclerView2, "parent");
                    b41.i(state, "state");
                    super.getItemOffsets(rect, view2, recyclerView2, state);
                    if (recyclerView2.getAdapter() != null) {
                        int childLayoutPosition = recyclerView2.getChildLayoutPosition(view2);
                        RecyclerView.Adapter adapter = recyclerView2.getAdapter();
                        b41.f(adapter);
                        if (childLayoutPosition != adapter.getItemCount() - 1) {
                            rect.right = i;
                        }
                    }
                }
            });
        }
    }

    public static final void o(@NotNull View view, final int i, final int i2, final int i3) {
        b41.i(view, "<this>");
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getItemDecorationCount() > 0) {
                return;
            }
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.alibaba.gaiax.render.view.GXViewExtKt$setHorizontalScrollContainerLineSpacing$decoration$2
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(@NotNull Rect rect, @NotNull View view2, @NotNull RecyclerView recyclerView2, @NotNull RecyclerView.State state) {
                    b41.i(rect, "outRect");
                    b41.i(view2, "view");
                    b41.i(recyclerView2, "parent");
                    b41.i(state, "state");
                    super.getItemOffsets(rect, view2, recyclerView2, state);
                    if (recyclerView2.getAdapter() != null) {
                        int childLayoutPosition = recyclerView2.getChildLayoutPosition(view2);
                        if (childLayoutPosition == 0) {
                            rect.left = i;
                            rect.right = i3;
                            return;
                        }
                        RecyclerView.Adapter adapter = recyclerView2.getAdapter();
                        b41.f(adapter);
                        if (childLayoutPosition == adapter.getItemCount() - 1) {
                            rect.right = i2;
                        } else {
                            rect.right = i3;
                        }
                    }
                }
            });
        }
    }

    public static final void p(@NotNull View view, @Nullable Float f) {
        b41.i(view, "<this>");
        if (f == null) {
            return;
        }
        f.floatValue();
        view.setAlpha(f.floatValue());
    }

    public static final void q(@NotNull final View view, @Nullable Boolean bool) {
        b41.i(view, "<this>");
        final boolean booleanValue = bool == null ? true : bool.booleanValue();
        if (view instanceof ViewGroup) {
            if (!booleanValue) {
                ((ViewGroup) view).setClipChildren(false);
                view.post(new Runnable() { // from class: com.alibaba.gaiax.render.view.GXViewExtKt$setOverflow$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean c;
                        ViewParent parent = ((ViewGroup) view).getParent();
                        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                        if (viewGroup != null) {
                            viewGroup.setClipChildren(booleanValue);
                        }
                        View view2 = view;
                        if (view2 instanceof GXIRootView) {
                            c = GXViewExtKt.c((ViewGroup) view2);
                            if (c) {
                                GXViewExtKt.d(view, booleanValue);
                            }
                        }
                    }
                });
                return;
            }
            ((ViewGroup) view).setClipChildren(booleanValue);
        }
    }

    public static final void r(@NotNull View view, @Nullable ls0 ls0Var) {
        ds0 i;
        hs0 k;
        mq0 g;
        ds0 i2;
        b41.i(view, "<this>");
        float[] fArr = null;
        float[] e = (ls0Var == null || (i = ls0Var.i()) == null) ? null : i.e();
        Float valueOf = (ls0Var == null || (k = ls0Var.k()) == null) ? null : Float.valueOf(k.c());
        Integer valueOf2 = (ls0Var == null || (g = ls0Var.g()) == null) ? null : Integer.valueOf(g.c(view.getContext()));
        if (ls0Var != null && (i2 = ls0Var.i()) != null) {
            fArr = i2.e();
        }
        if (view instanceof GXIRoundCorner) {
            int i3 = 0;
            if (view instanceof GXView) {
                if (fArr != null) {
                    ((GXIRoundCorner) view).setRoundCornerRadius(fArr);
                }
                if (valueOf2 == null || valueOf == null) {
                    return;
                }
                GXIRoundCorner gXIRoundCorner = (GXIRoundCorner) view;
                int intValue = valueOf2.intValue();
                float floatValue = valueOf.floatValue();
                if (e == null) {
                    e = new float[8];
                    while (i3 < 8) {
                        e[i3] = 0.0f;
                        i3++;
                    }
                }
                gXIRoundCorner.setRoundCornerBorder(intValue, floatValue, e);
            } else if (view instanceof GXText) {
                if (fArr != null) {
                    ((GXIRoundCorner) view).setRoundCornerRadius(fArr);
                }
                if (valueOf2 == null || valueOf == null) {
                    return;
                }
                GXIRoundCorner gXIRoundCorner2 = (GXIRoundCorner) view;
                int intValue2 = valueOf2.intValue();
                float floatValue2 = valueOf.floatValue();
                if (e == null) {
                    e = new float[8];
                    while (i3 < 8) {
                        e[i3] = 0.0f;
                        i3++;
                    }
                }
                gXIRoundCorner2.setRoundCornerBorder(intValue2, floatValue2, e);
            } else if (view instanceof GXIImageView) {
                if (fArr != null) {
                    ((GXIRoundCorner) view).setRoundCornerRadius(fArr);
                }
                if (valueOf2 == null || valueOf == null) {
                    return;
                }
                GXIRoundCorner gXIRoundCorner3 = (GXIRoundCorner) view;
                int intValue3 = valueOf2.intValue();
                float floatValue3 = valueOf.floatValue();
                if (e == null) {
                    e = new float[8];
                    while (i3 < 8) {
                        e[i3] = 0.0f;
                        i3++;
                    }
                }
                gXIRoundCorner3.setRoundCornerBorder(intValue3, floatValue3, e);
            } else if (view instanceof GXContainer) {
                if (fArr != null) {
                    ((GXIRoundCorner) view).setRoundCornerRadius(fArr);
                }
                if (valueOf2 == null || valueOf == null) {
                    return;
                }
                GXIRoundCorner gXIRoundCorner4 = (GXIRoundCorner) view;
                int intValue4 = valueOf2.intValue();
                float floatValue4 = valueOf.floatValue();
                if (e == null) {
                    e = new float[8];
                    while (i3 < 8) {
                        e[i3] = 0.0f;
                        i3++;
                    }
                }
                gXIRoundCorner4.setRoundCornerBorder(intValue4, floatValue4, e);
            } else if (view instanceof GXSliderView) {
                if (fArr != null) {
                    ((GXIRoundCorner) view).setRoundCornerRadius(fArr);
                }
                if (valueOf2 == null || valueOf == null) {
                    return;
                }
                GXIRoundCorner gXIRoundCorner5 = (GXIRoundCorner) view;
                int intValue5 = valueOf2.intValue();
                float floatValue5 = valueOf.floatValue();
                if (e == null) {
                    e = new float[8];
                    while (i3 < 8) {
                        e[i3] = 0.0f;
                        i3++;
                    }
                }
                gXIRoundCorner5.setRoundCornerBorder(intValue5, floatValue5, e);
            }
        }
    }

    public static final void s(@NotNull View view, int i, @Nullable l81 l81Var) {
        boolean m;
        b41.i(view, "<this>");
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            GXContainerViewAdapter gXContainerViewAdapter = adapter instanceof GXContainerViewAdapter ? (GXContainerViewAdapter) adapter : null;
            if (gXContainerViewAdapter == null) {
                m = false;
            } else {
                m = gXContainerViewAdapter.m(l81Var == null ? 0.0f : l81Var.e());
            }
            if (recyclerView.getLayoutManager() == null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), i, false));
            } else if (m) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                recyclerView.setLayoutManager(null);
                recyclerView.setLayoutManager(linearLayoutManager);
                linearLayoutManager.setOrientation(i);
            }
        }
    }

    public static final void t(@NotNull View view, @NotNull Rect rect) {
        b41.i(view, "<this>");
        b41.i(rect, Constants.Name.PADDING);
        if (view instanceof RecyclerView) {
            view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public static final void u(@NotNull View view) {
        b41.i(view, "<this>");
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                final int itemCount = adapter == null ? 1 : adapter.getItemCount();
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                final int spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
                RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                Objects.requireNonNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                ((GridLayoutManager) layoutManager2).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.alibaba.gaiax.render.view.GXViewExtKt$setSpanSizeLookup$1
                    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                    public int getSpanSize(int i) {
                        if (itemCount - 1 == i) {
                            return spanCount;
                        }
                        return 1;
                    }
                });
            }
        }
    }

    public static final void v(@NotNull GXText gXText, int i) {
        b41.i(gXText, "<this>");
        gXText.setGravity(i);
    }

    public static final void w(@NotNull GXText gXText, @Nullable Typeface typeface) {
        b41.i(gXText, "<this>");
        gXText.setTypeface(typeface);
    }

    public static final void x(@NotNull GXText gXText, float f) {
        b41.i(gXText, "<this>");
        int fontMetricsInt = gXText.getPaint().getFontMetricsInt(null);
        if (((int) f) != fontMetricsInt) {
            gXText.setLineSpacing(f - fontMetricsInt, 1.0f);
        }
    }

    public static final void y(@NotNull View view, final int i) {
        b41.i(view, "<this>");
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getItemDecorationCount() > 0) {
                return;
            }
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.alibaba.gaiax.render.view.GXViewExtKt$setVerticalScrollContainerLineSpacing$decoration$1
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(@NotNull Rect rect, @NotNull View view2, @NotNull RecyclerView recyclerView2, @NotNull RecyclerView.State state) {
                    b41.i(rect, "outRect");
                    b41.i(view2, "view");
                    b41.i(recyclerView2, "parent");
                    b41.i(state, "state");
                    super.getItemOffsets(rect, view2, recyclerView2, state);
                    if (recyclerView2.getAdapter() != null) {
                        int childLayoutPosition = recyclerView2.getChildLayoutPosition(view2);
                        RecyclerView.Adapter adapter = recyclerView2.getAdapter();
                        b41.f(adapter);
                        if (childLayoutPosition != adapter.getItemCount() - 1) {
                            rect.bottom = i;
                        }
                    }
                }
            });
        }
    }
}
