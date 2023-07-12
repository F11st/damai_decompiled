package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public final class TicketExtServiceBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String iconUrl;
    @Nullable
    private String note;
    @Nullable
    private String orderDetailSource;
    @Nullable
    private String orderId;
    @Nullable
    private String subNote;
    @Nullable
    private String title;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static final class OrderDetailSource {
        @NotNull
        public static final String DETAIL_CARD_ARROW_JUMP_TYPE = "0";
        @NotNull
        public static final OrderDetailSource INSTANCE = new OrderDetailSource();

        private OrderDetailSource() {
        }
    }

    @Nullable
    public final String getIconUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1693836744") ? (String) ipChange.ipc$dispatch("1693836744", new Object[]{this}) : this.iconUrl;
    }

    @Nullable
    public final String getNote() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "914876758") ? (String) ipChange.ipc$dispatch("914876758", new Object[]{this}) : this.note;
    }

    @Nullable
    public final String getOrderDetailSource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1176608524") ? (String) ipChange.ipc$dispatch("1176608524", new Object[]{this}) : this.orderDetailSource;
    }

    @Nullable
    public final String getOrderId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-975003365") ? (String) ipChange.ipc$dispatch("-975003365", new Object[]{this}) : this.orderId;
    }

    @Nullable
    public final String getSubNote() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-894898204") ? (String) ipChange.ipc$dispatch("-894898204", new Object[]{this}) : this.subNote;
    }

    @Nullable
    public final String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-548759894") ? (String) ipChange.ipc$dispatch("-548759894", new Object[]{this}) : this.title;
    }

    public final boolean isHideArrowProhibitJump() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1439287668") ? ((Boolean) ipChange.ipc$dispatch("-1439287668", new Object[]{this})).booleanValue() : b41.d("0", this.orderDetailSource);
    }

    public final void setIconUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-646922066")) {
            ipChange.ipc$dispatch("-646922066", new Object[]{this, str});
        } else {
            this.iconUrl = str;
        }
    }

    public final void setNote(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1996348344")) {
            ipChange.ipc$dispatch("-1996348344", new Object[]{this, str});
        } else {
            this.note = str;
        }
    }

    public final void setOrderDetailSource(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1168846614")) {
            ipChange.ipc$dispatch("-1168846614", new Object[]{this, str});
        } else {
            this.orderDetailSource = str;
        }
    }

    public final void setOrderId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1776586821")) {
            ipChange.ipc$dispatch("-1776586821", new Object[]{this, str});
        } else {
            this.orderId = str;
        }
    }

    public final void setSubNote(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "706673170")) {
            ipChange.ipc$dispatch("706673170", new Object[]{this, str});
        } else {
            this.subNote = str;
        }
    }

    public final void setTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1635287284")) {
            ipChange.ipc$dispatch("-1635287284", new Object[]{this, str});
        } else {
            this.title = str;
        }
    }
}
