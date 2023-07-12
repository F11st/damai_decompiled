package tb;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.servicenotice.ServiceNote;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectItemDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.StatusNotice;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.AbstractC2379a;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener;
import cn.damai.uikit.flowlayout.FlowLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class mi2 extends AbstractC2379a implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final View e;
    private final TextView f;
    private final TextView g;
    private final FlowLayout h;
    private final TextView i;
    private final View j;

    public mi2(Activity activity, long j, View view, OnHeadClickListener onHeadClickListener) {
        super(activity, j, view, onHeadClickListener);
        this.e = this.c.findViewById(R$id.notification_ui);
        this.f = (TextView) this.c.findViewById(R$id.notification_bar_prefix_text_tv);
        this.g = (TextView) this.c.findViewById(R$id.project_notification_content_tv);
        FlowLayout flowLayout = (FlowLayout) this.c.findViewById(R$id.project_service_flow_layout);
        this.h = flowLayout;
        this.i = (TextView) this.c.findViewById(R$id.project_service_tv);
        this.j = this.c.findViewById(R$id.service_arrow);
        flowLayout.setSingleLine(true);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.AbstractC2379a
    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1101600047") ? ((Integer) ipChange.ipc$dispatch("-1101600047", new Object[]{this})).intValue() : R$id.header_service_etc_ui;
    }

    public void d(ProjectItemDataBean projectItemDataBean, ProjectStaticDataBean projectStaticDataBean) {
        boolean z;
        boolean z2;
        IpChange ipChange = $ipChange;
        boolean z3 = true;
        if (AndroidInstantRuntime.support(ipChange, "838529519")) {
            ipChange.ipc$dispatch("838529519", new Object[]{this, projectItemDataBean, projectStaticDataBean});
            return;
        }
        StatusNotice j = yb.j(projectItemDataBean);
        if (j != null) {
            String notice = j.getNotice();
            String prefixText = j.getPrefixText();
            z2 = !TextUtils.isEmpty(notice);
            z = j.isHasPopup();
            this.e.setVisibility(z2 ? 0 : 8);
            this.g.setText(notice);
            c(this.f, prefixText);
        } else {
            z = false;
            z2 = false;
        }
        List<ServiceNote> i = yb.i(projectStaticDataBean);
        if (!cb2.d(i)) {
            this.h.removeAllViews();
            this.h.setVisibility(0);
            this.i.setVisibility(0);
            for (ServiceNote serviceNote : i) {
                View inflate = LayoutInflater.from(this.a).inflate(R$layout.item_service_tag, (ViewGroup) this.h, false);
                TextView textView = (TextView) inflate.findViewById(R$id.service_support);
                TextView textView2 = (TextView) inflate.findViewById(R$id.service_tv);
                if (serviceNote.isSupport()) {
                    textView.setText(b(R$string.iconfont_duihaomian_));
                    textView.setTextColor(Color.parseColor("#8C709BFF"));
                } else {
                    textView.setText(b(R$string.iconfont_guanbiyuan_));
                    textView.setTextColor(Color.parseColor("#8CFE2757"));
                }
                textView2.setText(serviceNote.tagName);
                this.h.addView(inflate);
            }
            z2 = true;
        } else {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            z3 = z;
        }
        this.j.setVisibility(z3 ? 0 : 8);
        this.c.setOnClickListener(z3 ? this : null);
        this.c.setVisibility(z2 ? 0 : 8);
        pp2.u().h2(this.c, String.valueOf(this.b));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-139050646")) {
            ipChange.ipc$dispatch("-139050646", new Object[]{this, view});
        } else {
            this.d.onServiceEtcClick();
        }
    }
}
