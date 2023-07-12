package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailShareBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.gw1;
import tb.pp2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailShareViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OrderDetailShareBean a;

        a(OrderDetailShareBean orderDetailShareBean) {
            this.a = orderDetailShareBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-785046009")) {
                ipChange.ipc$dispatch("-785046009", new Object[]{this, view});
                return;
            }
            c.e().x(pp2.u().x1(this.a.projectId));
            Bundle bundle = new Bundle();
            bundle.putString("imageUrl", this.a.projectImage);
            bundle.putString("uniqueIdent", this.a.projectId);
            bundle.putString("projectName", this.a.projectName);
            bundle.putString("mainMessage", this.a.projectName);
            bundle.putString("subMessage", this.a.cityAndTime);
            bundle.putString("channel", "3");
            bundle.putString("sceneType", "2");
            bundle.putString("producturl", gw1.productUrl + this.a.projectId + "&from=appshare");
            bundle.putString("fromWhere", GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL);
            DMNav.from(OrderDetailShareViewHolder.this.a).withExtras(bundle).toUri(NavUri.b("fissionshare"));
        }
    }

    public OrderDetailShareViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_detail_share_item, (ViewGroup) null));
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
        this.a = context;
        this.itemView.setLayoutParams(layoutParams);
    }

    public void b(OrderDetailShareBean orderDetailShareBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1497951626")) {
            ipChange.ipc$dispatch("-1497951626", new Object[]{this, orderDetailShareBean});
        } else if (orderDetailShareBean == null) {
        } else {
            pp2.u().L1(this.itemView, orderDetailShareBean.projectId);
            this.itemView.setOnClickListener(new a(orderDetailShareBean));
        }
    }
}
