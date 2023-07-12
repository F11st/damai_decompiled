package cn.damai.category.ranksquare.ui.viewholder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RankSquareLocalTitleViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;

    public RankSquareLocalTitleViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.rank_square_local_title_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        b(this.itemView);
    }

    private void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1792733328")) {
            ipChange.ipc$dispatch("1792733328", new Object[]{this, view});
            return;
        }
        this.a = view.findViewById(R$id.grey_line);
        this.b = (TextView) view.findViewById(R$id.tv_name);
    }

    public void a(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "500186575")) {
            ipChange.ipc$dispatch("500186575", new Object[]{this, str, Integer.valueOf(i)});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.b.setText(str);
            this.a.setVisibility(i == 0 ? 8 : 0);
        }
    }
}
