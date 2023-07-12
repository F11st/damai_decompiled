package cn.damai.tetris.component.drama.viewholder;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.jm1;
import tb.yc0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DramaCardVerticalViewHolder extends BaseViewHolderV2<DramaV1Bean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView c;
    private TextView d;
    private OnItemClickListener<DramaV1Bean> e;
    private yc0 f;

    public DramaCardVerticalViewHolder(Context context, ViewGroup viewGroup, OnItemClickListener<DramaV1Bean> onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.item_tetris_drama_card, viewGroup, false));
        this.f = new yc0(this.itemView);
        View findViewById = this.itemView.findViewById(R$id.drama_inner_layout2);
        this.c = (TextView) this.itemView.findViewById(R$id.drama_title);
        this.d = (TextView) this.itemView.findViewById(R$id.drama_ipuv);
        this.e = onItemClickListener;
        findViewById.setOnClickListener(this);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2
    /* renamed from: d */
    public void c(DramaV1Bean dramaV1Bean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1145084432")) {
            ipChange.ipc$dispatch("-1145084432", new Object[]{this, dramaV1Bean, Integer.valueOf(i)});
        } else if (dramaV1Bean == null) {
        } else {
            this.f.a(dramaV1Bean.pic);
            this.c.setText(dramaV1Bean.title);
            SpannableStringBuilder e = jm1.e(dramaV1Bean.ipvuv);
            this.d.setVisibility(0);
            this.d.setText(e);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnItemClickListener<DramaV1Bean> onItemClickListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-49452773")) {
            ipChange.ipc$dispatch("-49452773", new Object[]{this, view});
            return;
        }
        T t = this.a;
        if (t == 0 || (onItemClickListener = this.e) == null) {
            return;
        }
        onItemClickListener.onItemClick((DramaV1Bean) t, this.b);
    }
}
