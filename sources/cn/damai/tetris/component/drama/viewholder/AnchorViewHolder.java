package cn.damai.tetris.component.drama.viewholder;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.tetris.component.drama.bean.AnchorBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class AnchorViewHolder extends BaseViewHolderV2<AnchorBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView c;
    private OnItemClickListener<AnchorBean> d;

    public AnchorViewHolder(ViewGroup viewGroup, OnItemClickListener<AnchorBean> onItemClickListener) {
        super(BaseViewHolder.b(mu0.a(), viewGroup, R$layout.item_tetris_anchor_item));
        this.c = (TextView) this.itemView.findViewById(R$id.anchor_name_tv);
        this.itemView.setOnClickListener(this);
        this.d = onItemClickListener;
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2
    /* renamed from: d */
    public void c(AnchorBean anchorBean, int i) {
        int parseColor;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-249289761")) {
            ipChange.ipc$dispatch("-249289761", new Object[]{this, anchorBean, Integer.valueOf(i)});
        } else if (anchorBean == null) {
        } else {
            if (anchorBean.isSelect) {
                parseColor = Color.parseColor("#FF2869");
            } else {
                parseColor = Color.parseColor("#9C9CA5");
            }
            this.c.setText(anchorBean.name);
            this.c.setTextColor(parseColor);
        }
    }

    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1643335718")) {
            ipChange.ipc$dispatch("1643335718", new Object[]{this});
            return;
        }
        T t = this.a;
        if (t != 0) {
            a((AnchorBean) t, this.b);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnItemClickListener<AnchorBean> onItemClickListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-655006019")) {
            ipChange.ipc$dispatch("-655006019", new Object[]{this, view});
            return;
        }
        T t = this.a;
        if (t == 0 || ((AnchorBean) t).isSelect || (onItemClickListener = this.d) == null) {
            return;
        }
        onItemClickListener.onItemClick((AnchorBean) t, this.b);
    }
}
