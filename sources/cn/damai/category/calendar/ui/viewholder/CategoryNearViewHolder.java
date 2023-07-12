package cn.damai.category.calendar.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CategoryNearViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private TextView b;
    private TextView c;

    public CategoryNearViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.category_list_nearby_head_new, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a = this.itemView.getContext();
        this.b = (TextView) this.itemView.findViewById(R$id.tv_project_tip);
        this.c = (TextView) this.itemView.findViewById(R$id.tv_near_tip);
    }

    public void a(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1435294487")) {
            ipChange.ipc$dispatch("-1435294487", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        if (z2) {
            this.b.setPadding(0, ScreenUtil.dip2px(this.a, 21.0f), 0, ScreenUtil.dip2px(this.a, 48.0f));
        } else {
            this.b.setPadding(0, ScreenUtil.dip2px(this.a, 48.0f), 0, ScreenUtil.dip2px(this.a, 48.0f));
        }
        if (z) {
            this.b.setText("当前城市没有更多演出啦，看看附近城市吧(^з^)-☆");
            this.c.setPadding(0, 0, 0, 0);
            return;
        }
        this.b.setText("当前城市暂时没有演出，看看附近城市吧(^з^)-☆");
        TextView textView = this.c;
        textView.setPadding(0, 0, 0, ScreenUtil.dip2px(textView.getContext(), 18.0f));
    }
}
