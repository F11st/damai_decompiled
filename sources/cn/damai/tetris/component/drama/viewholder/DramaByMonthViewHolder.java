package cn.damai.tetris.component.drama.viewholder;

import android.annotation.SuppressLint;
import android.app.Application;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.component.drama.bean.DramaMonthBean;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import cn.damai.tetris.component.drama.bean.DramaWrapBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.cb2;
import tb.m62;
import tb.mg;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DramaByMonthViewHolder extends BaseViewHolder<DramaWrapBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;
    private DramaListV1RecyAdapter c;
    private MonthTabAdapter d;
    private RecyclerView e;
    private mg f;
    private boolean g;
    private DramaWrapBean h;
    private List<DramaMonthBean> i;
    private HashMap<Integer, DramaMonthBean> j;
    private OnDramaByMonthClickListener k;
    private RecyclerView l;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnDramaByMonthClickListener {
        void expose(View view, DramaV1Bean dramaV1Bean, int i);

        void onAllClick(String str);

        void onDramaClick(DramaV1Bean dramaV1Bean, int i);

        void onTabClick(DramaMonthBean dramaMonthBean, int i);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.drama.viewholder.DramaByMonthViewHolder$a */
    /* loaded from: classes7.dex */
    public class C1830a implements OnItemClickListener<DramaMonthBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1830a() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: a */
        public void onItemClick(DramaMonthBean dramaMonthBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "282913315")) {
                ipChange.ipc$dispatch("282913315", new Object[]{this, dramaMonthBean, Integer.valueOf(i)});
                return;
            }
            DramaByMonthViewHolder.this.g = false;
            if (DramaByMonthViewHolder.this.d.f(dramaMonthBean)) {
                if (DramaByMonthViewHolder.this.k != null) {
                    DramaByMonthViewHolder.this.k.onTabClick(dramaMonthBean, i);
                }
                int i2 = dramaMonthBean.headPosInTotalList;
                RecyclerView.LayoutManager layoutManager = DramaByMonthViewHolder.this.e.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, DramaByMonthViewHolder.this.b);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.drama.viewholder.DramaByMonthViewHolder$b */
    /* loaded from: classes7.dex */
    public class C1831b implements OnItemBindListener<DramaV1Bean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1831b() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(View view, DramaV1Bean dramaV1Bean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-466060934")) {
                ipChange.ipc$dispatch("-466060934", new Object[]{this, view, dramaV1Bean, Integer.valueOf(i)});
            } else if (DramaByMonthViewHolder.this.k != null) {
                DramaByMonthViewHolder.this.k.expose(view, dramaV1Bean, i);
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(DramaV1Bean dramaV1Bean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1112147055")) {
                ipChange.ipc$dispatch("1112147055", new Object[]{this, dramaV1Bean, Integer.valueOf(i)});
            } else if (DramaByMonthViewHolder.this.k != null) {
                DramaByMonthViewHolder.this.k.onDramaClick(dramaV1Bean, i);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.drama.viewholder.DramaByMonthViewHolder$c */
    /* loaded from: classes16.dex */
    public class View$OnTouchListenerC1832c implements View.OnTouchListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnTouchListenerC1832c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1406911273")) {
                return ((Boolean) ipChange.ipc$dispatch("1406911273", new Object[]{this, view, motionEvent})).booleanValue();
            }
            DramaByMonthViewHolder.this.g = true;
            return false;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.drama.viewholder.DramaByMonthViewHolder$d */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1833d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        View$OnClickListenerC1833d(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-808221027")) {
                ipChange.ipc$dispatch("-808221027", new Object[]{this, view});
            } else if (DramaByMonthViewHolder.this.k != null) {
                DramaByMonthViewHolder.this.k.onAllClick(this.a);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public DramaByMonthViewHolder(View view, OnDramaByMonthClickListener onDramaByMonthClickListener) {
        super(view);
        this.g = true;
        this.j = new HashMap<>();
        this.k = onDramaByMonthClickListener;
        Application a = mu0.a();
        this.b = m62.a(a, 21.0f);
        this.a = m62.a(a, 12.0f);
        this.f = new mg(view.findViewById(R$id.card_title_layout));
        this.l = (RecyclerView) view.findViewById(R$id.dbm_tab_recycler);
        this.e = (RecyclerView) view.findViewById(R$id.dbm_drama_recycler);
        MonthTabAdapter monthTabAdapter = new MonthTabAdapter(new C1830a());
        this.d = monthTabAdapter;
        this.l.setAdapter(monthTabAdapter);
        this.l.setLayoutManager(new LinearLayoutManager(a, 0, false));
        DramaListV1RecyAdapter dramaListV1RecyAdapter = new DramaListV1RecyAdapter(new C1831b());
        this.c = dramaListV1RecyAdapter;
        this.e.setAdapter(dramaListV1RecyAdapter);
        this.e.setLayoutManager(new LinearLayoutManager(a, 0, false));
        this.e.setOnTouchListener(new View$OnTouchListenerC1832c());
        j();
        l();
    }

    private void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1889685677")) {
            ipChange.ipc$dispatch("1889685677", new Object[]{this});
        } else {
            this.e.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.tetris.component.drama.viewholder.DramaByMonthViewHolder.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2047928799")) {
                        ipChange2.ipc$dispatch("2047928799", new Object[]{this, rect, view, recyclerView, state});
                        return;
                    }
                    int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                    RecyclerView.Adapter adapter = recyclerView.getAdapter();
                    if (adapter != null) {
                        boolean z = adapter.getItemCount() - 1 == childAdapterPosition;
                        if (childAdapterPosition == 0) {
                            rect.left = DramaByMonthViewHolder.this.b;
                        } else {
                            rect.left = 0;
                        }
                        if (z) {
                            rect.right = DramaByMonthViewHolder.this.b;
                        } else {
                            rect.right = DramaByMonthViewHolder.this.a;
                        }
                    }
                }
            });
        }
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1376211434")) {
            ipChange.ipc$dispatch("1376211434", new Object[]{this});
            return;
        }
        this.j.clear();
        if (cb2.d(this.i)) {
            return;
        }
        int i = 0;
        for (DramaMonthBean dramaMonthBean : this.i) {
            List<DramaV1Bean> list = dramaMonthBean.content;
            if (!cb2.d(list)) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.j.put(Integer.valueOf(i), dramaMonthBean);
                    i++;
                }
            }
        }
    }

    private void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1996523153")) {
            ipChange.ipc$dispatch("-1996523153", new Object[]{this});
        } else {
            this.e.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.tetris.component.drama.viewholder.DramaByMonthViewHolder.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-487928263")) {
                        ipChange2.ipc$dispatch("-487928263", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    } else {
                        DramaByMonthViewHolder.this.n(recyclerView, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(RecyclerView recyclerView, int i) {
        View childAt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-741098548")) {
            ipChange.ipc$dispatch("-741098548", new Object[]{this, recyclerView, Integer.valueOf(i)});
        } else if (!this.g || i == 0 || (childAt = recyclerView.getChildAt(0)) == null) {
        } else {
            this.d.f(this.j.get(Integer.valueOf(recyclerView.getChildAdapterPosition(childAt))));
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
    /* renamed from: m */
    public void a(DramaWrapBean dramaWrapBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-233222252")) {
            ipChange.ipc$dispatch("-233222252", new Object[]{this, dramaWrapBean, Integer.valueOf(i)});
        } else if (dramaWrapBean == null) {
        } else {
            this.h = dramaWrapBean;
            dramaWrapBean.utParamsInset();
            List<DramaMonthBean> list = this.h.result;
            this.i = list;
            if (cb2.d(list)) {
                this.e.setVisibility(8);
                this.l.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                this.l.setVisibility(0);
                this.h.computeScrollPos();
                k();
                this.d.e(this.i, !cb2.d(this.i) ? this.i.get(0) : null);
                this.c.c(this.h.getTotalList());
                this.e.post(new Runnable() { // from class: cn.damai.tetris.component.drama.viewholder.DramaByMonthViewHolder.6
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "699201684")) {
                            ipChange2.ipc$dispatch("699201684", new Object[]{this});
                            return;
                        }
                        DramaByMonthViewHolder dramaByMonthViewHolder = DramaByMonthViewHolder.this;
                        dramaByMonthViewHolder.n(dramaByMonthViewHolder.e, -1);
                    }
                });
            }
            CardTitleBean cardTitleBean = this.h.mTitleBean;
            this.f.h(cardTitleBean);
            if (cardTitleBean != null && cardTitleBean.hasUrl()) {
                this.f.a(new View$OnClickListenerC1833d(cardTitleBean.url));
            } else {
                this.f.a(null);
            }
        }
    }
}
