package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.custom.ExpandState;
import cn.damai.ultron.utils.DmUltronConstants;
import cn.damai.ultron.view.adapter.DmBuyerViewAdapter;
import cn.damai.ultron.view.bean.DmViewerBean;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.imp.DMComponent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class nb0 extends j1 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final IViewHolderCreator CREATOR = new b();
    private RecyclerView c;
    private DmBuyerViewAdapter d;
    private LinearLayout e;
    private TextView f;
    private ExpandState g;
    private Context h;
    private db0 i;
    private int j;
    View.OnClickListener k;
    private boolean l;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1679230883")) {
                ipChange.ipc$dispatch("-1679230883", new Object[]{this, view});
            } else if (nb0.this.g == ExpandState.EXPAND) {
                nb0.this.l();
                nb0.this.d.f(nb0.this.g);
                nb0.this.d.notifyDataSetChanged();
                cn.damai.common.user.c.e().x(kb0.u().q(nb0.this.h));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class b implements IViewHolderCreator {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator
        public j1 create(ay2 ay2Var) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1399881899") ? (j1) ipChange.ipc$dispatch("-1399881899", new Object[]{this, ay2Var}) : new nb0(ay2Var);
        }
    }

    public nb0(ay2 ay2Var) {
        super(ay2Var);
        this.g = ExpandState.HIDE;
        this.j = 2;
        this.k = new a();
        this.l = true;
    }

    private void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "535478142")) {
            ipChange.ipc$dispatch("535478142", new Object[]{this});
            return;
        }
        this.g = ExpandState.HIDE;
        this.e.setVisibility(8);
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1940597155")) {
            ipChange.ipc$dispatch("1940597155", new Object[]{this});
            return;
        }
        this.g = ExpandState.EXPAND;
        this.e.setVisibility(0);
        this.f.setText("展开全部");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1627104415")) {
            ipChange.ipc$dispatch("-1627104415", new Object[]{this});
            return;
        }
        this.g = ExpandState.PICKUP;
        this.e.setVisibility(8);
    }

    private void m(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1784663718")) {
            ipChange.ipc$dispatch("1784663718", new Object[]{this, Integer.valueOf(i)});
        } else if (i <= this.j) {
            j();
        } else if (this.g == ExpandState.PICKUP) {
            l();
        } else {
            k();
        }
    }

    @Override // tb.j1
    protected void d(@NonNull IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-687381541")) {
            ipChange.ipc$dispatch("-687381541", new Object[]{this, iDMComponent});
        } else if (iDMComponent != null && (iDMComponent instanceof DMComponent)) {
            try {
                db0 db0Var = new db0((DMComponent) iDMComponent);
                this.i = db0Var;
                int e = wh2.e(db0Var.e());
                int b2 = this.i.b();
                this.j = e;
                m(e);
                DmBuyerViewAdapter dmBuyerViewAdapter = new DmBuyerViewAdapter(this.h);
                this.d = dmBuyerViewAdapter;
                dmBuyerViewAdapter.h(this.i);
                this.d.g(b2);
                this.d.e(this.j);
                this.d.f(this.g);
                this.c.setAdapter(this.d);
                String[] b3 = x8.Companion.b(ua0.b(this.h) + "", this.h);
                if (!this.l || b3.length <= 0 || e <= 0) {
                    return;
                }
                this.l = false;
                List<DmViewerBean> e2 = this.i.e();
                HashMap hashMap = new HashMap();
                int i = 0;
                for (String str : b3) {
                    if (!TextUtils.isEmpty(str) && i < b2) {
                        Iterator<DmViewerBean> it = e2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                DmViewerBean next = it.next();
                                if (!next.isDisabled() && str.equals(next.viewerId)) {
                                    next.isUsed = "true";
                                    hashMap.put(next.viewerId, next);
                                    this.i.a(next, hashMap.size());
                                    i++;
                                    break;
                                }
                            }
                        }
                    }
                }
                this.i.g(hashMap);
                xr.c(DmUltronConstants.REFRESH_CONTACT_COMPONENT_DATA, this.i.c());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // tb.j1
    protected View e(@Nullable ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "167583712")) {
            return (View) ipChange.ipc$dispatch("167583712", new Object[]{this, viewGroup});
        }
        Context l = this.a.l();
        this.h = l;
        View inflate = LayoutInflater.from(l).inflate(R$layout.ultron_ticket_buyer, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R$id.recycler_main);
        this.c = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.h));
        this.e = (LinearLayout) inflate.findViewById(R$id.ll_expend);
        this.f = (TextView) inflate.findViewById(R$id.tv_expend);
        this.e.setVisibility(8);
        this.e.setOnClickListener(this.k);
        return inflate;
    }
}
