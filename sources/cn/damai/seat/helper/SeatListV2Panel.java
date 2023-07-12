package cn.damai.seat.helper;

import android.app.Activity;
import android.graphics.Rect;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.ShortTag;
import cn.damai.seat.R$drawable;
import cn.damai.seat.R$id;
import cn.damai.seat.R$layout;
import cn.damai.seat.adapter.SeatHorizontalListAdapter;
import cn.damai.seat.bean.ItemSeatV2;
import cn.damai.seat.listener.OnSeatRemoveListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.cb2;
import tb.g92;
import tb.m62;
import tb.o92;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SeatListV2Panel extends cn.damai.seat.helper.a implements OnSeatRemoveListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private SeatHorizontalListAdapter b;
    private RecyclerView c;
    private OnSeatRemoveListener d;
    private int e;
    private int f;
    private View g;
    private View h;
    private View i;
    private LinearLayout j;
    private ImageView k;
    private TbParams l;
    List<ShortTag> m;
    boolean n;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-226092986")) {
                ipChange.ipc$dispatch("-226092986", new Object[]{this, view});
                return;
            }
            SeatListV2Panel seatListV2Panel = SeatListV2Panel.this;
            seatListV2Panel.m(seatListV2Panel.m, !seatListV2Panel.n);
            SeatListV2Panel.this.k();
        }
    }

    public SeatListV2Panel(Activity activity, View view, View view2, OnSeatRemoveListener onSeatRemoveListener) {
        super(activity);
        this.n = false;
        this.h = view;
        this.d = onSeatRemoveListener;
        this.g = view2;
        this.b = new SeatHorizontalListAdapter(this.a, this);
        this.c = (RecyclerView) view.findViewById(R$id.seat_selected_horizontal_list);
        this.i = view.findViewById(R$id.seat_selected_info_bottom);
        this.j = (LinearLayout) view.findViewById(R$id.seat_selected_info_bottomlist);
        this.k = (ImageView) view.findViewById(R$id.seat_selected_info_arrow);
        this.i.setOnClickListener(new a());
        this.e = m62.a(this.a, 3.0f);
        this.f = m62.a(this.a, 18.0f);
        this.c.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.seat.helper.SeatListV2Panel.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view3, RecyclerView recyclerView, RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2034982773")) {
                    ipChange.ipc$dispatch("-2034982773", new Object[]{this, rect, view3, recyclerView, state});
                    return;
                }
                ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
                if (layoutParams instanceof RecyclerView.LayoutParams) {
                    int itemCount = SeatListV2Panel.this.b.getItemCount();
                    int viewAdapterPosition = ((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition();
                    int i = SeatListV2Panel.this.e;
                    int i2 = SeatListV2Panel.this.e;
                    boolean z = viewAdapterPosition == 0;
                    boolean z2 = viewAdapterPosition == itemCount - 1;
                    if (z) {
                        i += SeatListV2Panel.this.f;
                    }
                    if (z2) {
                        i2 += SeatListV2Panel.this.f;
                    }
                    rect.set(i, 0, i2, 0);
                }
            }
        });
        this.c.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
        this.c.setAdapter(this.b);
    }

    private void h(List<ShortTag> list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1302416154")) {
            ipChange.ipc$dispatch("1302416154", new Object[]{this, list, Boolean.valueOf(z)});
            return;
        }
        this.j.removeAllViews();
        for (ShortTag shortTag : list) {
            View inflate = LayoutInflater.from(this.h.getContext()).inflate(R$layout.ll_seat_promotion_item, (ViewGroup) null);
            ((TextView) inflate.findViewById(R$id.item_seat_promotion_tag)).setText(shortTag.promotionTag);
            final TextView textView = (TextView) inflate.findViewById(R$id.item_promotion_content);
            textView.setText(shortTag.promotionContent);
            if (z) {
                textView.setMaxLines(Integer.MAX_VALUE);
            } else {
                textView.setMaxLines(1);
                textView.post(new Runnable() { // from class: cn.damai.seat.helper.SeatListV2Panel.4
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        int lineCount;
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1543072377")) {
                            ipChange2.ipc$dispatch("-1543072377", new Object[]{this});
                            return;
                        }
                        Layout layout = textView.getLayout();
                        if (layout == null || (lineCount = layout.getLineCount()) <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                            return;
                        }
                        SeatListV2Panel.this.j();
                    }
                });
            }
            this.j.addView(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678924168")) {
            ipChange.ipc$dispatch("-678924168", new Object[]{this});
            return;
        }
        this.k.setVisibility(0);
        this.n = false;
        this.k.setImageDrawable(this.h.getContext().getDrawable(R$drawable.trade_seat_grey_arrow_up));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1765283691")) {
            ipChange.ipc$dispatch("1765283691", new Object[]{this});
            return;
        }
        c.e().x(o92.l().m(this.l.itemId + "", this.l.performId + ""));
    }

    private void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1278476915")) {
            ipChange.ipc$dispatch("1278476915", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", this.l.itemId + "");
        hashMap.put("titlelabel", this.l.performId + "");
        c.e().G(this.j, "layer", "discountinfor", "seatselect", hashMap);
    }

    public void i(TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-106079284")) {
            ipChange.ipc$dispatch("-106079284", new Object[]{this, tbParams});
        } else {
            this.l = tbParams;
        }
    }

    public void m(List<ShortTag> list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2018798868")) {
            ipChange.ipc$dispatch("2018798868", new Object[]{this, list, Boolean.valueOf(z)});
        } else if (list != null && list.size() > 0 && list.get(0) != null) {
            this.i.setVisibility(0);
            l();
            this.m = list;
            if (!z) {
                if (list.size() > 1) {
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
            }
            if (z) {
                this.n = true;
                this.k.setImageDrawable(this.h.getContext().getDrawable(R$drawable.trade_seat_grey_arrow_down));
                h(list, true);
                return;
            }
            this.n = false;
            this.k.setImageDrawable(this.h.getContext().getDrawable(R$drawable.trade_seat_grey_arrow_up));
            h(list.subList(0, 1), false);
        } else {
            this.i.setVisibility(8);
        }
    }

    public void n(g92 g92Var, List<ItemSeatV2> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1170702806")) {
            ipChange.ipc$dispatch("-1170702806", new Object[]{this, g92Var, list});
            return;
        }
        SeatHorizontalListAdapter seatHorizontalListAdapter = this.b;
        if (seatHorizontalListAdapter != null) {
            seatHorizontalListAdapter.f(g92Var);
            boolean z = wh2.e(list) > this.b.getItemCount();
            this.b.g(list);
            boolean z2 = !cb2.d(list);
            this.h.setVisibility(z2 ? 0 : 8);
            View view = this.g;
            if (view != null) {
                view.setVisibility(z2 ? 4 : 0);
            }
            if (z2 && z) {
                this.c.post(new Runnable() { // from class: cn.damai.seat.helper.SeatListV2Panel.3
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1346558872")) {
                            ipChange2.ipc$dispatch("-1346558872", new Object[]{this});
                        } else if (!SeatListV2Panel.this.a() || SeatListV2Panel.this.b.getItemCount() <= 0) {
                        } else {
                            SeatListV2Panel.this.c.smoothScrollToPosition(0);
                        }
                    }
                });
            }
        }
    }

    @Override // cn.damai.seat.listener.OnSeatRemoveListener
    public void onSeatRemove(SeatNew seatNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1217971787")) {
            ipChange.ipc$dispatch("-1217971787", new Object[]{this, seatNew});
            return;
        }
        OnSeatRemoveListener onSeatRemoveListener = this.d;
        if (onSeatRemoveListener == null || seatNew == null) {
            return;
        }
        onSeatRemoveListener.onSeatRemove(seatNew);
    }
}
