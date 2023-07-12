package cn.damai.ticklet.ui.detailholder;

import android.os.Bundle;
import android.view.View;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.page.GenericFragment;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.fq1;
import tb.un2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class TicketExtOrderViewHolder extends TicketExtServiceViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketExtOrderViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
    }

    private final void goOrderPage(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1298194835")) {
            ipChange.ipc$dispatch("1298194835", new Object[]{this, str, str2, str3, str4});
        } else if (b41.d("0", str4)) {
        } else {
            C0529c.e().x(C0528b.getInstance().e(un2.TICKLET_DETAIL_PAGE, "ticket_info", "orderinfo", un2.k().t(str2, str), Boolean.TRUE));
            if (!(str3 == null || str3.length() == 0)) {
                if (str4 != null && str4.length() != 0) {
                    z = false;
                }
                if (!z) {
                    fq1.a(getContext(), str3, str4, str2);
                    return;
                }
            }
            fq1.a(getContext(), null, str4, str2);
        }
    }

    @Override // cn.damai.ticklet.ui.detailholder.TicketExtServiceViewHolder, com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1102835759")) {
            ipChange.ipc$dispatch("1102835759", new Object[]{this, iItem});
            return;
        }
        b41.i(iItem, "item");
        super.bindData(iItem);
        if (getValue().isHideArrowProhibitJump()) {
            getArrowView().setVisibility(8);
        }
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377829210")) {
            return ((Boolean) ipChange.ipc$dispatch("-1377829210", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2053705625")) {
            return ((Boolean) ipChange.ipc$dispatch("2053705625", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1020379409")) {
            return ((Boolean) ipChange.ipc$dispatch("-1020379409", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public void onItemClick(@NotNull View view) {
        IContext pageContext;
        GenericFragment fragment;
        Bundle arguments;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-85648408")) {
            ipChange.ipc$dispatch("-85648408", new Object[]{this, view});
            return;
        }
        b41.i(view, "view");
        super.onItemClick(view);
        IItem<ItemValue> data = getData();
        if (data == null || (pageContext = data.getPageContext()) == null || (fragment = pageContext.getFragment()) == null || (arguments = fragment.getArguments()) == null) {
            return;
        }
        goOrderPage(arguments.getString(TicketDetailExtFragment.PERFORM_ID), arguments.getString("projectId"), getValue().getOrderId(), getValue().getOrderDetailSource());
    }
}
