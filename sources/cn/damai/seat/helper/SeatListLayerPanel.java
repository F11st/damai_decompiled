package cn.damai.seat.helper;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketMainUiModel;
import cn.damai.seat.R$id;
import cn.damai.seat.adapter.SeatListDetailV2Adapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;
import tb.m62;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SeatListLayerPanel extends cn.damai.seat.helper.a implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ViewStub b;
    private a c;
    private List<TicketMainUiModel> d;
    private View e;
    private SeatListDetailV2Adapter f;
    private int g;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnPanelStateListener {
        void onExpandChanged(boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class a implements OnPanelStateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private OnPanelStateListener a;

        public a(OnPanelStateListener onPanelStateListener) {
            this.a = onPanelStateListener;
        }

        @Override // cn.damai.seat.helper.SeatListLayerPanel.OnPanelStateListener
        public void onExpandChanged(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2132591689")) {
                ipChange.ipc$dispatch("-2132591689", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            OnPanelStateListener onPanelStateListener = this.a;
            if (onPanelStateListener != null) {
                onPanelStateListener.onExpandChanged(z);
            }
        }
    }

    public SeatListLayerPanel(Activity activity, ViewStub viewStub, OnPanelStateListener onPanelStateListener) {
        super(activity);
        this.b = viewStub;
        this.c = new a(onPanelStateListener);
        this.g = m62.a(activity, 18.0f);
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "803325915")) {
            ipChange.ipc$dispatch("803325915", new Object[]{this});
        } else if (this.e == null) {
            View inflate = this.b.inflate();
            this.e = inflate;
            inflate.setVisibility(8);
            RecyclerView recyclerView = (RecyclerView) this.e.findViewById(R$id.seat_list_detail_v2_lv);
            View findViewById = this.e.findViewById(R$id.seat_list_v2_close);
            this.e.setOnClickListener(this);
            findViewById.setOnClickListener(this);
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.seat.helper.SeatListLayerPanel.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView2, RecyclerView.State state) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1381747591")) {
                        ipChange2.ipc$dispatch("1381747591", new Object[]{this, rect, view, recyclerView2, state});
                    } else if (view.findViewById(R$id.model_title) != null) {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (!(layoutParams instanceof RecyclerView.LayoutParams) || ((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition() == 0) {
                            return;
                        }
                        rect.set(0, SeatListLayerPanel.this.g, 0, 0);
                    }
                }
            });
            recyclerView.setLayoutManager(new LinearLayoutManager(this.a, 1, false));
            SeatListDetailV2Adapter seatListDetailV2Adapter = new SeatListDetailV2Adapter(this.a);
            this.f = seatListDetailV2Adapter;
            recyclerView.setAdapter(seatListDetailV2Adapter);
        }
    }

    private boolean e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "55428320") ? ((Boolean) ipChange.ipc$dispatch("55428320", new Object[]{this})).booleanValue() : !cb2.d(this.d);
    }

    private boolean f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "157424942") ? ((Boolean) ipChange.ipc$dispatch("157424942", new Object[]{this})).booleanValue() : a() && this.e != null;
    }

    private void g(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "392356566")) {
            ipChange.ipc$dispatch("392356566", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        View view = this.e;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
            this.c.onExpandChanged(z);
        }
    }

    public boolean d() {
        View view;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "335837157") ? ((Boolean) ipChange.ipc$dispatch("335837157", new Object[]{this})).booleanValue() : f() && (view = this.e) != null && view.isShown();
    }

    public void h(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1538477357")) {
            ipChange.ipc$dispatch("-1538477357", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            if (f() && e()) {
                g(true);
            }
        } else if (f()) {
            g(false);
        }
    }

    public void i(List<TicketMainUiModel> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-107683251")) {
            ipChange.ipc$dispatch("-107683251", new Object[]{this, list});
            return;
        }
        this.d = list;
        if (!cb2.d(list)) {
            c();
        }
        if (f()) {
            this.f.c(list);
        }
        if (cb2.d(list)) {
            g(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-679554890")) {
            ipChange.ipc$dispatch("-679554890", new Object[]{this, view});
        } else {
            h(false);
        }
    }
}
