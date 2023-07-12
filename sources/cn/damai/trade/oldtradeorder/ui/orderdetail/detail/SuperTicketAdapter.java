package cn.damai.trade.oldtradeorder.ui.orderdetail.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.damai.commonbusiness.seatbiz.orderdetail.bean.SuperTickt;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SuperTicketAdapter extends BaseAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private LayoutInflater mInflater;
    private List<SuperTickt> superTicketList;

    public SuperTicketAdapter(LayoutInflater layoutInflater, List<SuperTickt> list) {
        this.superTicketList = list;
        this.mInflater = layoutInflater;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1837733046") ? ((Integer) ipChange.ipc$dispatch("1837733046", new Object[]{this})).intValue() : this.superTicketList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1746580876") ? ipChange.ipc$dispatch("-1746580876", new Object[]{this, Integer.valueOf(i)}) : this.superTicketList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-679888851") ? ((Long) ipChange.ipc$dispatch("-679888851", new Object[]{this, Integer.valueOf(i)})).longValue() : i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1709867005")) {
            return (View) ipChange.ipc$dispatch("-1709867005", new Object[]{this, Integer.valueOf(i), view, viewGroup});
        }
        View inflate = this.mInflater.inflate(R$layout.order_new_detail_item, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R$id.order_new_detail_item_ticket_number_tv);
        TextView textView2 = (TextView) inflate.findViewById(R$id.order_new_detail_item_ticket_code_tv);
        TextView textView3 = (TextView) inflate.findViewById(R$id.order_new_detail_item_number_tv);
        SuperTickt superTickt = this.superTicketList.get(i);
        if (superTickt != null) {
            String str = superTickt.ticketNo;
            if (str != null && !str.equals("")) {
                textView.setText(superTickt.ticketNo + jn1.BRACKET_START_STR + superTickt.ticketAmount + "元)");
            }
            String str2 = superTickt.verifyNo;
            if (str2 != null && !str2.equals("")) {
                textView2.setText(superTickt.verifyNo);
            }
            textView3.setText((i + 1) + "");
        }
        return inflate;
    }

    public void setSuperTicktList(List<SuperTickt> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-264301565")) {
            ipChange.ipc$dispatch("-264301565", new Object[]{this, list});
        } else {
            this.superTicketList = list;
        }
    }
}
