package cn.damai.commonbusiness.wannasee.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.wannasee.bean.EmptyBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class UserEmptyFeedViewHolder extends BaseViewHolder<EmptyBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;

    public UserEmptyFeedViewHolder(Context context, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.item_user_center_empty_item_view, viewGroup, false));
        this.a = (TextView) this.itemView.findViewById(R$id.item_user_center_empty_tv);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
    /* renamed from: c */
    public void a(EmptyBean emptyBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1002873090")) {
            ipChange.ipc$dispatch("1002873090", new Object[]{this, emptyBean, Integer.valueOf(i)});
        } else if (emptyBean != null) {
            this.a.setText(emptyBean.emptyMsg);
        } else {
            this.a.setText("这里空空的呢～");
        }
    }
}
