package cn.damai.user.brand;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.DMRatingBar;
import cn.damai.user.brand.bean.BrandCommentInfoDO;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AutoScrollAdapter extends RecyclerView.Adapter<C2663a> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final List<BrandCommentInfoDO> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.brand.AutoScrollAdapter$a */
    /* loaded from: classes9.dex */
    public class C2663a extends RecyclerView.ViewHolder {
        TextView a;
        DMRatingBar b;
        TextView c;
        TextView d;

        public C2663a(AutoScrollAdapter autoScrollAdapter, View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.brand_talk_item_name);
            this.c = (TextView) view.findViewById(R$id.brand_talk_item_score);
            this.d = (TextView) view.findViewById(R$id.brand_talk_item_content);
            this.b = (DMRatingBar) view.findViewById(R$id.evaluate_grade_view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C2663a c2663a, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1947606586")) {
            ipChange.ipc$dispatch("-1947606586", new Object[]{this, c2663a, Integer.valueOf(i)});
            return;
        }
        List<BrandCommentInfoDO> list = this.a;
        BrandCommentInfoDO brandCommentInfoDO = list.get(i % list.size());
        c2663a.a.setText(brandCommentInfoDO.fromUserName);
        if (wh2.j(brandCommentInfoDO.valueDesc)) {
            c2663a.c.setVisibility(8);
        } else {
            c2663a.c.setVisibility(0);
            c2663a.c.setText(brandCommentInfoDO.valueDesc);
        }
        c2663a.d.setText(brandCommentInfoDO.content);
        float f = 0.0f;
        try {
            f = Float.parseFloat(brandCommentInfoDO.score);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        c2663a.b.setStarMark(f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public C2663a onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2103724688") ? (C2663a) ipChange.ipc$dispatch("-2103724688", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new C2663a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.brand_talk_listitem, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1390681644")) {
            return ((Integer) ipChange.ipc$dispatch("1390681644", new Object[]{this})).intValue();
        }
        return Integer.MAX_VALUE;
    }
}
