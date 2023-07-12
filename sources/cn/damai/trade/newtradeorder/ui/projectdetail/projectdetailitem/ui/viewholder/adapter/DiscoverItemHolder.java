package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.a;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.InFieldCommentsBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DiscoverItemHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private View b;
    private ImageView c;
    private ImageView d;
    private TextView e;
    private ImageView f;
    private TextView g;
    private View h;

    public DiscoverItemHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.project_item_discover_item_layout, (ViewGroup) null));
        layoutInflater.getContext();
        this.a = this.itemView.findViewById(R$id.left_view);
        this.b = this.itemView.findViewById(R$id.right_view);
        this.c = (ImageView) this.itemView.findViewById(R$id.image_pic);
        this.d = (ImageView) this.itemView.findViewById(R$id.image_video);
        this.e = (TextView) this.itemView.findViewById(R$id.tv_title);
        this.f = (ImageView) this.itemView.findViewById(R$id.image_head);
        this.g = (TextView) this.itemView.findViewById(R$id.tv_desc);
        this.h = this.itemView.findViewById(R$id.image_head_layout);
    }

    public void a(InFieldCommentsBean inFieldCommentsBean, int i, int i2, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "926829623")) {
            ipChange.ipc$dispatch("926829623", new Object[]{this, inFieldCommentsBean, Integer.valueOf(i), Integer.valueOf(i2), onClickListener});
            return;
        }
        if (i == 0) {
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
        if (i == i2 - 1) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
        ImageView imageView = this.c;
        int i3 = R$drawable.uikit_default_image_bg_grey;
        imageView.setImageResource(i3);
        a.b().e(inFieldCommentsBean.picUrl).c(i3).g(this.c);
        if (inFieldCommentsBean.isTypeGROUP()) {
            this.h.setVisibility(8);
            this.g.setText("攻略中提到了本演出");
            this.d.setVisibility(8);
        } else if (inFieldCommentsBean.isTypeStrategy() || inFieldCommentsBean.isCanDowngradeToStrategy()) {
            this.h.setVisibility(0);
            ImageView imageView2 = this.f;
            int i4 = R$drawable.uikit_user_default_icon_trans_white;
            imageView2.setImageResource(i4);
            a.b().e(inFieldCommentsBean.userPic).c(i4).g(this.f);
            this.g.setText(inFieldCommentsBean.nickName);
            if (!TextUtils.isEmpty(inFieldCommentsBean.showVideoIcon) && inFieldCommentsBean.showVideoIcon.equals("true")) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
        this.e.setVisibility(8);
        if (!TextUtils.isEmpty(inFieldCommentsBean.comment)) {
            this.e.setVisibility(0);
            this.e.setText(inFieldCommentsBean.comment);
        }
        this.itemView.setTag(inFieldCommentsBean);
        this.itemView.setOnClickListener(onClickListener);
    }
}
