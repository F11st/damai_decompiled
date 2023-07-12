package cn.damai.user.userhome.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.user.userhome.bean.UserDynamicContentBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UserDynamicLabelViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private TextView b;

    public UserDynamicLabelViewHolder(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.layout_dynamic_label, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
        this.a = context;
        TextView textView = (TextView) this.itemView.findViewById(R$id.tv_label);
        this.b = textView;
        textView.setOnClickListener(onClickListener);
    }

    public void a(UserDynamicContentBean userDynamicContentBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-987652486")) {
            ipChange.ipc$dispatch("-987652486", new Object[]{this, userDynamicContentBean, Integer.valueOf(i)});
        } else if (userDynamicContentBean != null) {
            userDynamicContentBean.pos = i;
            TextView textView = this.b;
            textView.setText(userDynamicContentBean.labelName + " " + userDynamicContentBean.count);
            if (userDynamicContentBean.isSelect) {
                this.b.setTextColor(ContextCompat.getColor(this.a, R$color.color_ff2d79));
            } else {
                this.b.setTextColor(ContextCompat.getColor(this.a, R$color.color_333333));
            }
            this.b.setTag(userDynamicContentBean);
        }
    }
}
