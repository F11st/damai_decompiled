package com.alient.onearch.adapter.view;

import android.view.View;
import com.alient.onearch.adapter.view.AbsView;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.IContract;
import com.youku.arch.v3.view.IContract.Model;
import com.youku.arch.v3.view.IContract.Presenter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0004*\u0014\b\u0002\u0010\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bB\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "I", "Lcom/youku/arch/v3/view/IContract$Model;", "M", "Lcom/youku/arch/v3/view/IContract$Presenter;", "P", "Lcom/youku/arch/v3/view/AbsView;", "Landroid/view/View;", "renderView", "Landroid/view/View;", "getRenderView", "()Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class AbsView<I extends IItem<ItemValue>, M extends IContract.Model<I>, P extends IContract.Presenter<I, M>> extends com.youku.arch.v3.view.AbsView<I, M, P> {
    @Nullable
    private final View renderView;

    public AbsView(@Nullable View view) {
        super(view);
        this.renderView = view;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: tb.h1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AbsView.m206_init_$lambda0(AbsView.this, view2);
                }
            });
        }
        if (view == null) {
            return;
        }
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: tb.i1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean m207_init_$lambda1;
                m207_init_$lambda1 = AbsView.m207_init_$lambda1(AbsView.this, view2);
                return m207_init_$lambda1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m206_init_$lambda0(AbsView absView, View view) {
        b41.i(absView, "this$0");
        P presenter = absView.getPresenter();
        AbsPresenter absPresenter = presenter instanceof AbsPresenter ? (AbsPresenter) presenter : null;
        if (absPresenter == null) {
            return;
        }
        absPresenter.itemClick(absView.getRenderView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final boolean m207_init_$lambda1(AbsView absView, View view) {
        b41.i(absView, "this$0");
        P presenter = absView.getPresenter();
        AbsPresenter absPresenter = presenter instanceof AbsPresenter ? (AbsPresenter) presenter : null;
        if (absPresenter == null) {
            return true;
        }
        absPresenter.itemLongClick(absView.getRenderView());
        return true;
    }

    @Override // com.youku.arch.v3.view.AbsView, com.youku.arch.v3.view.IContract.View
    @Nullable
    public final View getRenderView() {
        return this.renderView;
    }
}
