package com.alibaba.pictures.bricks.component.project;

import android.app.Activity;
import android.view.View;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.bricks.component.project.DMProjectViewHolder;
import com.alibaba.pictures.bricks.component.project.bean.DMProjectItemBean;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.EventHandler;
import org.jetbrains.annotations.Nullable;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class DMProjectPresent extends AbsPresenter<IItem<ItemValue>, DMProjectModel, DMProjectView> implements DMProjectContract$Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    public DMProjectPresent(@Nullable String str, @Nullable String str2, @Nullable View view, @Nullable EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.youku.arch.v3.DomainObject, com.youku.arch.v3.IItem] */
    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@Nullable IItem<ItemValue> iItem) {
        DMProjectItemBean value;
        DMProjectView dMProjectView;
        DMProjectViewHolder fetchViewHolder;
        IContext pageContext;
        Activity activity;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1945489078")) {
            ipChange.ipc$dispatch("1945489078", new Object[]{this, iItem});
            return;
        }
        super.init(iItem);
        DMProjectModel dMProjectModel = (DMProjectModel) getModel();
        if (dMProjectModel == null || (value = dMProjectModel.getValue()) == null || (dMProjectView = (DMProjectView) getView()) == null || (fetchViewHolder = dMProjectView.fetchViewHolder()) == null) {
            return;
        }
        DMProjectViewHolder.i(fetchViewHolder, value, DMProjectViewHolder.PageType.SEARCH_PAGE, false, 4, null);
        ?? item = getItem();
        if (item != 0 && (pageContext = item.getPageContext()) != null && (activity = pageContext.getActivity()) != null) {
            s60 s60Var = s60.INSTANCE;
            fetchViewHolder.o(s60Var.b(activity, 63), s60Var.b(activity, 84));
        }
        String str = value.comboDispatchId;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            fetchViewHolder.itemView.setBackgroundResource(R$drawable.bricks_item_normal_card_bg_r6);
        } else {
            fetchViewHolder.itemView.setBackgroundResource(R$drawable.bricks_item_top_card_bg_r6);
        }
    }
}
