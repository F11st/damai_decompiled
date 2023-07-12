package cn.damai.mine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.net.LogisticsDetailResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class LogisticsDetailAdatper extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<LogisticsDetailResponse.TransitStepInfosBean> b;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private View a;
        private LinearLayout b;
        private View c;
        private View d;
        private TextView e;
        private TextView f;

        public ViewHolder(LogisticsDetailAdatper logisticsDetailAdatper, View view) {
            super(view);
            this.a = view.findViewById(R$id.v_line);
            this.b = (LinearLayout) view.findViewById(R$id.ll_height);
            this.c = view.findViewById(R$id.v_big_cicrle);
            this.d = view.findViewById(R$id.v_small_cicrle);
            this.e = (TextView) view.findViewById(R$id.tv_trackInfo);
            this.f = (TextView) view.findViewById(R$id.tv_track_time);
        }
    }

    public LogisticsDetailAdatper(Context context, List<LogisticsDetailResponse.TransitStepInfosBean> list) {
        this.a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-12943425")) {
            ipChange.ipc$dispatch("-12943425", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        LogisticsDetailResponse.TransitStepInfosBean transitStepInfosBean = this.b.get(i);
        viewHolder.e.setText(transitStepInfosBean.getTrackInfo());
        viewHolder.f.setText(transitStepInfosBean.getTrackTime());
        if (i == 0) {
            viewHolder.c.setVisibility(0);
            viewHolder.c.setBackgroundResource(R$drawable.shape_cicrle_ff1268);
            viewHolder.d.setBackgroundResource(R$drawable.shape_cicrle_white);
            TextView textView = viewHolder.e;
            Context context = this.a;
            int i2 = R$color.color_111111;
            textView.setTextColor(ContextCompat.getColor(context, i2));
            viewHolder.f.setTextColor(ContextCompat.getColor(this.a, i2));
        } else {
            viewHolder.c.setVisibility(8);
            viewHolder.d.setBackgroundResource(R$drawable.shape_cicrle_eeeeee);
            viewHolder.e.setTextColor(ContextCompat.getColor(this.a, R$color.color_888888));
            viewHolder.f.setTextColor(ContextCompat.getColor(this.a, R$color.color_aaaaaa));
        }
        viewHolder.b.post(new Runnable() { // from class: cn.damai.mine.adapter.LogisticsDetailAdatper.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1948258439")) {
                    ipChange2.ipc$dispatch("-1948258439", new Object[]{this});
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewHolder.a.getLayoutParams();
                int i3 = i;
                if (i3 == 0) {
                    if (LogisticsDetailAdatper.this.b.size() > 1) {
                        layoutParams.topMargin = t60.a(LogisticsDetailAdatper.this.a, 30.0f);
                        layoutParams.height = viewHolder.b.getHeight() - layoutParams.topMargin;
                    } else {
                        layoutParams.height = 0;
                    }
                } else if (i3 == LogisticsDetailAdatper.this.b.size() - 1) {
                    layoutParams.topMargin = 0;
                    layoutParams.height = t60.a(LogisticsDetailAdatper.this.a, 27.0f);
                } else {
                    layoutParams.topMargin = 0;
                    layoutParams.height = viewHolder.b.getHeight();
                }
                viewHolder.a.setLayoutParams(layoutParams);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1972581033") ? (ViewHolder) ipChange.ipc$dispatch("-1972581033", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder(this, LayoutInflater.from(this.a).inflate(R$layout.logistics_detail_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-187977274")) {
            return ((Integer) ipChange.ipc$dispatch("-187977274", new Object[]{this})).intValue();
        }
        List<LogisticsDetailResponse.TransitStepInfosBean> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
