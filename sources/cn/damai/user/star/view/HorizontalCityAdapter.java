package cn.damai.user.star.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.user.star.bean.TourProjects;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class HorizontalCityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<TourProjects> b;
    private View.OnClickListener c;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class CityHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        public View a;
        private View b;
        private View c;
        private TextView d;
        private TextView e;
        private TextView f;
        private Context g;

        public CityHolder(HorizontalCityAdapter horizontalCityAdapter, LayoutInflater layoutInflater) {
            super(layoutInflater.inflate(R$layout.mine_starindex_fragment_perform_cityitem, (ViewGroup) null));
            this.g = layoutInflater.getContext();
            this.a = this.itemView.findViewById(R$id.layout_left);
            this.b = this.itemView.findViewById(R$id.layout_right);
            this.c = this.itemView.findViewById(R$id.layout_bg);
            this.d = (TextView) this.itemView.findViewById(R$id.tv_city);
            this.e = (TextView) this.itemView.findViewById(R$id.tv_time);
            this.f = (TextView) this.itemView.findViewById(R$id.btn_buy);
        }

        public void a(TourProjects tourProjects, boolean z, boolean z2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1211713607")) {
                ipChange.ipc$dispatch("1211713607", new Object[]{this, tourProjects, Boolean.valueOf(z), Boolean.valueOf(z2)});
            } else if (tourProjects == null) {
            } else {
                this.a.setVisibility(8);
                if (z2) {
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(8);
                }
                this.d.setText(tourProjects.cityName);
                this.e.setText(tourProjects.showTime);
                this.f.setVisibility(0);
                this.f.setText(tourProjects.buttonText);
                TextPaint paint = this.f.getPaint();
                if (tourProjects.status == 2) {
                    while (paint != null && paint.measureText(tourProjects.buttonText) > t60.a(this.g, 60.0f) && paint.getTextSize() > t60.a(this.g, 4.0f)) {
                        paint.setTextSize(paint.getTextSize() - t60.a(this.g, 1.0f));
                    }
                } else {
                    paint.setTextSize(t60.a(this.g, 13.0f));
                }
                int i = tourProjects.status;
                if (i == 1) {
                    this.f.setBackgroundResource(R$drawable.mine_starindex_fragment_xunyan_bg_blue);
                    this.f.setTextColor(Color.parseColor("#FF30AEFF"));
                } else if (i != 2) {
                    this.f.setBackgroundResource(R$drawable.mine_starindex_fragment_xunyan_bg_bluebg);
                    this.f.setTextColor(this.g.getResources().getColor(R$color.color_white));
                } else {
                    this.f.setBackgroundResource(R$drawable.mine_starindex_fragment_xunyan_bg_fen);
                    this.f.setTextColor(this.g.getResources().getColor(R$color.color_white));
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2088909300")) {
            return ((Integer) ipChange.ipc$dispatch("2088909300", new Object[]{this})).intValue();
        }
        List<TourProjects> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-971988347")) {
            ipChange.ipc$dispatch("-971988347", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        if (viewHolder != null) {
            TourProjects tourProjects = this.b.get(i);
            tourProjects.index = i;
            if (i == 0) {
                ((CityHolder) viewHolder).a(tourProjects, true, false);
            } else if (i == this.b.size() - 1) {
                ((CityHolder) viewHolder).a(tourProjects, false, true);
            } else {
                ((CityHolder) viewHolder).a(tourProjects, false, false);
            }
            CityHolder cityHolder = (CityHolder) viewHolder;
            cityHolder.itemView.setTag(tourProjects);
            cityHolder.itemView.setOnClickListener(this.c);
        }
        if (i == 0) {
            ((CityHolder) viewHolder).a.setVisibility(0);
        } else {
            ((CityHolder) viewHolder).a.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "968345873") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("968345873", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new CityHolder(this, LayoutInflater.from(this.a));
    }
}
