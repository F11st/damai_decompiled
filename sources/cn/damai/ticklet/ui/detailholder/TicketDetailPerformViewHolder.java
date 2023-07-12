package cn.damai.ticklet.ui.detailholder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import cn.damai.member.R$id;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.inteface.TickletPerformCallBack;
import cn.damai.ticklet.inteface.TickletTicketCallback;
import cn.damai.ticklet.ui.activity.TicketDeatilActivity;
import cn.damai.ticklet.view.TickletDetailPerformTicketView;
import cn.damai.uikit.view.FrameLayoutGradientView;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import java.io.Serializable;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class TicketDetailPerformViewHolder extends BaseViewHolder<Object> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String PERFORM_TICKET_DATA = "performTicketData";
    private boolean isInited;
    @NotNull
    private final FrameLayoutGradientView maskBg;
    @NotNull
    private final TickletDetailPerformTicketView performTicketView;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketDetailPerformViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        View findViewById = view.findViewById(R$id.ticklet_detail_kernel);
        b41.h(findViewById, "itemView.findViewById(R.id.ticklet_detail_kernel)");
        this.performTicketView = (TickletDetailPerformTicketView) findViewById;
        View findViewById2 = view.findViewById(R$id.color_mask_bg);
        b41.h(findViewById2, "itemView.findViewById(R.id.color_mask_bg)");
        this.maskBg = (FrameLayoutGradientView) findViewById2;
    }

    private final void setBgView(TicketDeatilResult ticketDeatilResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1088178509")) {
            ipChange.ipc$dispatch("-1088178509", new Object[]{this, ticketDeatilResult});
            return;
        }
        this.maskBg.setColors(ticketDeatilResult.getBgGradientColors());
        this.maskBg.setPosition(ticketDeatilResult.getBgGradientPostions());
    }

    private final void updatePerformTicket(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "355323187")) {
            ipChange.ipc$dispatch("355323187", new Object[]{this, iItem});
            return;
        }
        Bundle bundle = iItem.getPageContext().getBundle();
        Serializable serializable = bundle != null ? bundle.getSerializable(PERFORM_TICKET_DATA) : null;
        TicketDeatilResult ticketDeatilResult = serializable instanceof TicketDeatilResult ? serializable : null;
        if (ticketDeatilResult != null) {
            this.performTicketView.update(ticketDeatilResult);
            setBgView(ticketDeatilResult);
        }
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "944799570")) {
            ipChange.ipc$dispatch("944799570", new Object[]{this, iItem});
            return;
        }
        b41.i(iItem, "item");
        if (!this.isInited) {
            this.isInited = true;
            Activity activity = iItem.getPageContext().getActivity();
            TicketDeatilActivity ticketDeatilActivity = activity instanceof TicketDeatilActivity ? (TicketDeatilActivity) activity : null;
            if (ticketDeatilActivity != null) {
                setCallback(ticketDeatilActivity, ticketDeatilActivity);
            }
            EventDispatcher eventDispatcher = iItem.getPageContext().getEventDispatcher();
            if (eventDispatcher != null) {
                eventDispatcher.dispatchEvent("EventBus://business/notification/LoadTicketExt", null);
            }
        }
        updatePerformTicket(iItem);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1911839850")) {
            return ((Boolean) ipChange.ipc$dispatch("-1911839850", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "601762450")) {
            return ((Boolean) ipChange.ipc$dispatch("601762450", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.youku.arch.v3.adapter.VBaseHolder, com.youku.arch.v3.event.EventHandler
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IItem<ItemValue> data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-611362908")) {
            return ((Boolean) ipChange.ipc$dispatch("-611362908", new Object[]{this, str, map})).booleanValue();
        }
        b41.i(str, "type");
        if (b41.d(str, "EventBus://business/notification/RefreshPerform") && (data = getData()) != null) {
            updatePerformTicket(data);
        }
        return super.onMessage(str, map);
    }

    public final void setCallback(@Nullable TickletTicketCallback tickletTicketCallback, @Nullable TickletPerformCallBack<?> tickletPerformCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-900293507")) {
            ipChange.ipc$dispatch("-900293507", new Object[]{this, tickletTicketCallback, tickletPerformCallBack});
        } else {
            this.performTicketView.setCallback(tickletTicketCallback, tickletPerformCallBack);
        }
    }
}
