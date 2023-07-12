package cn.damai.tetris.component.rank;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.rank.bean.RankItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cz1;
import tb.fp2;
import tb.xw1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankItemHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private cz1 a;
    private xw1 b;
    private fp2 c;
    private LinearLayout d;

    public RankItemHolder(Context context, View view) {
        super(view);
        b(context);
    }

    private void b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-68032518")) {
            ipChange.ipc$dispatch("-68032518", new Object[]{this, context});
            return;
        }
        LayoutInflater from = LayoutInflater.from(context);
        this.d = (LinearLayout) this.itemView.findViewById(R$id.layout_container);
        View inflate = from.inflate(R$layout.rank_rank_component, (ViewGroup) null);
        View inflate2 = from.inflate(R$layout.rank_project_component, (ViewGroup) null);
        View inflate3 = from.inflate(R$layout.category_star_jour_layout, (ViewGroup) null);
        this.a = new cz1(inflate);
        this.b = new xw1(inflate2);
        this.c = new fp2(inflate3);
        this.d.removeAllViews();
        this.d.addView(inflate);
        this.d.addView(inflate2);
        this.d.addView(inflate3);
        inflate3.setPadding(0, 0, 0, 0);
    }

    public void a(int i, int i2, RankItemBean rankItemBean) {
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-939840920")) {
            ipChange.ipc$dispatch("-939840920", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), rankItemBean});
        } else if (rankItemBean == null) {
        } else {
            this.a.a(rankItemBean.order, rankItemBean.trend, rankItemBean.ipvuv, rankItemBean.itemStar, rankItemBean.itemScore, rankItemBean.type);
            if (rankItemBean.type == 99) {
                this.b.b(rankItemBean.headPic, "", rankItemBean.name, rankItemBean.subHead, rankItemBean.price, rankItemBean.followStatus, "", "");
            } else {
                String str = rankItemBean.cityName;
                if (!TextUtils.isEmpty(rankItemBean.venueName)) {
                    str = rankItemBean.cityName + " | " + rankItemBean.venueName;
                }
                this.b.b(rankItemBean.headPic, rankItemBean.categoryName, rankItemBean.name, rankItemBean.showTime, rankItemBean.price, rankItemBean.followStatus, str, rankItemBean.extraInfo);
            }
            String[] strArr = rankItemBean.tourCities;
            if (strArr != null && strArr.length > 0) {
                this.c.b(true);
                StringBuilder sb = new StringBuilder();
                int i4 = 0;
                while (true) {
                    String[] strArr2 = rankItemBean.tourCities;
                    if (i3 < strArr2.length) {
                        if (!TextUtils.isEmpty(strArr2[i3])) {
                            i4++;
                            String[] strArr3 = rankItemBean.tourCities;
                            if (i3 == strArr3.length - 1) {
                                sb.append(strArr3[i3]);
                            } else {
                                sb.append(rankItemBean.tourCities[i3] + " | ");
                            }
                        }
                        i3++;
                    } else {
                        this.c.a(i4, sb.toString());
                        return;
                    }
                }
            } else {
                this.c.b(false);
            }
        }
    }
}
