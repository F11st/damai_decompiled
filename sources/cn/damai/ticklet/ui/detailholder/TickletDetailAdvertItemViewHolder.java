package cn.damai.ticklet.ui.detailholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TicketExtAdBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.py2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletDetailAdvertItemViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private ImageView b;

    public TickletDetailAdvertItemViewHolder(View view) {
        super(view);
        a(view.getContext());
    }

    private void a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-309411228")) {
            ipChange.ipc$dispatch("-309411228", new Object[]{this, context});
            return;
        }
        this.a = context;
        this.b = (ImageView) this.itemView.findViewById(R$id.ticklet_detail_advert_item_image);
    }

    public void b(TicketExtAdBean ticketExtAdBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-497127812")) {
            ipChange.ipc$dispatch("-497127812", new Object[]{this, ticketExtAdBean});
        } else if (ticketExtAdBean == null || TextUtils.isEmpty(ticketExtAdBean.picUrl)) {
        } else {
            if (!TextUtils.isEmpty(ticketExtAdBean.picUrl)) {
                this.b.setVisibility(0);
                py2.q(this.a, this.b, ticketExtAdBean.picUrl, R$drawable.uikit_default_image_bg_grey);
                return;
            }
            this.b.setVisibility(8);
        }
    }

    public TickletDetailAdvertItemViewHolder(Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.ticklet_detail_advert_module_item_view, (ViewGroup) null));
        a(context);
    }
}
