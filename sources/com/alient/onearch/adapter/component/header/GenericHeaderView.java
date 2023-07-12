package com.alient.onearch.adapter.component.header;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.util.Patterns;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.header.GenericHeaderContract;
import com.alient.onearch.adapter.component.header.GenericHeaderView;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.kg1;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B\u000f\u0012\u0006\u0010'\u001a\u00020)¢\u0006\u0004\b8\u00109J(\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0012\u0010\u001c\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010 \u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u001c\u0010!\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J\b\u0010#\u001a\u00020\u0011H\u0016J\b\u0010$\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020\u0011H\u0016J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016R\u0019\u0010'\u001a\u00020)8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010*\u001a\u0004\b+\u0010,R\u0018\u0010\u0016\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010-R\u0018\u0010.\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010-R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00103R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/alient/onearch/adapter/component/header/GenericHeaderView;", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/header/GenericHeaderModel;", "Lcom/alient/onearch/adapter/component/header/GenericHeaderPresent;", "Lcom/alient/onearch/adapter/component/header/GenericHeaderContract$View;", "", "leftTop", "rightTop", "leftBottom", "rightBottom", "", "getCornerRadii", "", "startColor", "endColor", "Ltb/wt2;", "renderBackground", "height", "renderHeight", "", "title", "renderTitle", "color", "renderTitleTextColor", "renderTitleRightTextColor", "url", "renderTitleRightImage", "text", "Lcom/alient/oneservice/nav/Action;", "action", "renderBtnOne", "renderBtnTwo", "hideBtnOne", "hideBtnTwo", "showRightArrow", "hideRightArrow", "Landroid/widget/TextView;", "view", "rightBtnClick", "Landroid/view/View;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Landroid/widget/TextView;", "rightArrow", "btnOne", "btnTwo", "Landroid/widget/ImageView;", "titleImage", "Landroid/widget/ImageView;", OneArchConstants.LayoutKey.TITLE_RIGHT_IMAGE, "Landroid/graphics/drawable/GradientDrawable;", "gradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class GenericHeaderView extends AbsView<GenericItem<ItemValue>, GenericHeaderModel, GenericHeaderPresent> implements GenericHeaderContract.View {
    @Nullable
    private final TextView btnOne;
    @Nullable
    private final TextView btnTwo;
    @NotNull
    private final GradientDrawable gradientDrawable;
    @Nullable
    private final View rightArrow;
    @Nullable
    private final TextView title;
    @Nullable
    private final ImageView titleImage;
    @Nullable
    private final ImageView titleRightImage;
    @NotNull
    private final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericHeaderView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.view = view;
        this.title = (TextView) view.findViewById(R.id.title);
        this.rightArrow = view.findViewById(R.id.right_arrow);
        this.btnOne = (TextView) view.findViewById(R.id.action_one);
        this.btnTwo = (TextView) view.findViewById(R.id.action_two);
        this.titleImage = (ImageView) view.findViewById(R.id.title_image);
        this.titleRightImage = (ImageView) view.findViewById(R.id.title_right_image);
        this.gradientDrawable = new GradientDrawable();
    }

    private final float[] getCornerRadii(float f, float f2, float f3, float f4) {
        return new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderBtnOne$lambda-6$lambda-5$lambda-4  reason: not valid java name */
    public static final void m197renderBtnOne$lambda6$lambda5$lambda4(GenericHeaderView genericHeaderView, TextView textView, Action action, View view) {
        b41.i(genericHeaderView, "this$0");
        b41.i(textView, "$this_apply");
        genericHeaderView.rightBtnClick(textView, action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderBtnTwo$lambda-9$lambda-8$lambda-7  reason: not valid java name */
    public static final void m198renderBtnTwo$lambda9$lambda8$lambda7(GenericHeaderView genericHeaderView, TextView textView, Action action, View view) {
        b41.i(genericHeaderView, "this$0");
        b41.i(textView, "$this_apply");
        genericHeaderView.rightBtnClick(textView, action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderTitle$lambda-1  reason: not valid java name */
    public static final void m199renderTitle$lambda1(GenericHeaderView genericHeaderView, SuccessEvent successEvent) {
        b41.i(genericHeaderView, "this$0");
        if ((successEvent == null ? null : successEvent.bitmap) != null) {
            ImageView imageView = genericHeaderView.titleImage;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = genericHeaderView.titleImage;
            if (imageView2 == null) {
                return;
            }
            imageView2.setImageBitmap(successEvent.bitmap);
            return;
        }
        ImageView imageView3 = genericHeaderView.titleImage;
        if (imageView3 != null) {
            imageView3.setImageBitmap(null);
        }
        ImageView imageView4 = genericHeaderView.titleImage;
        if (imageView4 == null) {
            return;
        }
        imageView4.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderTitle$lambda-2  reason: not valid java name */
    public static final void m200renderTitle$lambda2(GenericHeaderView genericHeaderView, FailEvent failEvent) {
        b41.i(genericHeaderView, "this$0");
        ImageView imageView = genericHeaderView.titleImage;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        ImageView imageView2 = genericHeaderView.titleImage;
        if (imageView2 == null) {
            return;
        }
        imageView2.setVisibility(8);
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void hideBtnOne() {
        TextView textView = this.btnOne;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void hideBtnTwo() {
        TextView textView = this.btnTwo;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void hideRightArrow() {
        View view = this.rightArrow;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void renderBackground(int i, int i2) {
        this.gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        this.gradientDrawable.setColors(new int[]{i, i2});
        Integer headerCorner = ((GenericHeaderModel) ((GenericHeaderPresent) getPresenter()).getModel()).getHeaderCorner();
        if (headerCorner != null) {
            float intValue = headerCorner.intValue();
            this.gradientDrawable.setCornerRadii(getCornerRadii(intValue, intValue, 0.0f, 0.0f));
        }
        this.view.setBackground(this.gradientDrawable);
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void renderBtnOne(@Nullable String str, @Nullable final Action action) {
        final TextView textView = this.btnOne;
        if (textView == null) {
            return;
        }
        textView.setText(str);
        textView.setVisibility(0);
        if (action == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: tb.qt0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GenericHeaderView.m197renderBtnOne$lambda6$lambda5$lambda4(GenericHeaderView.this, textView, action, view);
            }
        });
        UserTrackProviderProxy.expose(textView, action.getTrackInfo());
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void renderBtnTwo(@Nullable String str, @Nullable final Action action) {
        final TextView textView = this.btnTwo;
        if (textView == null) {
            return;
        }
        textView.setText(str);
        textView.setVisibility(0);
        if (action == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: tb.pt0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GenericHeaderView.m198renderBtnTwo$lambda9$lambda8$lambda7(GenericHeaderView.this, textView, action, view);
            }
        });
        UserTrackProviderProxy.expose(textView, action.getTrackInfo());
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void renderHeight(int i) {
        if (i != 0) {
            this.view.getLayoutParams().height = i;
        }
    }

    public void renderTitle(@Nullable String str) {
        if (Patterns.WEB_URL.matcher(str).matches()) {
            TextView textView = this.title;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageLoaderProviderProxy.getProxy().load(str, new IImageSuccListener() { // from class: tb.st0
                @Override // com.alient.oneservice.image.IImageSuccListener
                public final void onSuccess(SuccessEvent successEvent) {
                    GenericHeaderView.m199renderTitle$lambda1(GenericHeaderView.this, successEvent);
                }
            }, new IImageFailListener() { // from class: tb.rt0
                @Override // com.alient.oneservice.image.IImageFailListener
                public final void onFail(FailEvent failEvent) {
                    GenericHeaderView.m200renderTitle$lambda2(GenericHeaderView.this, failEvent);
                }
            });
            return;
        }
        ImageView imageView = this.titleImage;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.titleImage;
        if (imageView2 != null) {
            imageView2.setImageBitmap(null);
        }
        TextView textView2 = this.title;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.title;
        TextPaint paint = textView3 != null ? textView3.getPaint() : null;
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        TextView textView4 = this.title;
        if (textView4 == null) {
            return;
        }
        textView4.setText(str);
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void renderTitleRightImage(@Nullable String str) {
        ImageView imageView = this.titleRightImage;
        if (imageView == null) {
            return;
        }
        if (str == null || str.length() == 0) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setVisibility(0);
        kg1.C9357a c9357a = kg1.Companion;
        Context context = getView().getContext();
        b41.h(context, "view.context");
        c9357a.a(context).j(str).g(imageView);
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void renderTitleRightTextColor(int i) {
        TextView textView = this.btnOne;
        if (textView != null) {
            textView.setTextColor(i);
        }
        TextView textView2 = this.btnTwo;
        if (textView2 == null) {
            return;
        }
        textView2.setTextColor(i);
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void renderTitleTextColor(int i) {
        TextView textView = this.title;
        if (textView == null) {
            return;
        }
        textView.setTextColor(i);
    }

    public void rightBtnClick(@NotNull TextView textView, @NotNull Action action) {
        b41.i(textView, "view");
        b41.i(action, "action");
        NavProviderProxy.toUri(textView.getContext(), action);
        UserTrackProviderProxy.click(textView, action.getTrackInfo(), true);
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void showRightArrow() {
        View view = this.rightArrow;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }
}
