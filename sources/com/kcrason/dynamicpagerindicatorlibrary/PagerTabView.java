package com.kcrason.dynamicpagerindicatorlibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/kcrason/dynamicpagerindicatorlibrary/PagerTabView;", "Lcom/kcrason/dynamicpagerindicatorlibrary/BasePagerTabView;", "Landroid/widget/TextView;", "getTabTextView", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/view/View;", "onCreateTabView", "mTextView", "Landroid/widget/TextView;", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicpagerindicatorlibrary_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes10.dex */
public final class PagerTabView extends BasePagerTabView {
    private HashMap _$_findViewCache;
    private TextView mTextView;

    @JvmOverloads
    public PagerTabView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public PagerTabView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ PagerTabView(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // com.kcrason.dynamicpagerindicatorlibrary.BasePagerTabView
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.kcrason.dynamicpagerindicatorlibrary.BasePagerTabView
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // com.kcrason.dynamicpagerindicatorlibrary.IPagerTabView
    @Nullable
    public TextView getTabTextView() {
        return this.mTextView;
    }

    @Override // com.kcrason.dynamicpagerindicatorlibrary.IPagerTabView
    @NotNull
    public View onCreateTabView(@NotNull Context context) {
        b41.j(context, WPKFactory.INIT_KEY_CONTEXT);
        TextView textView = new TextView(context);
        this.mTextView = textView;
        return textView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PagerTabView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.j(context, WPKFactory.INIT_KEY_CONTEXT);
    }
}
