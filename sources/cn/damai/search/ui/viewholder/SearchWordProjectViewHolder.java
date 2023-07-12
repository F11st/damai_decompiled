package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.TimerView;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.vr;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchWordProjectViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private Context b;
    private RoundImageView c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private TimerView g;
    private Daojishi h;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1746633878")) {
                ipChange.ipc$dispatch("1746633878", new Object[]{this, dVar});
            } else {
                SearchWordProjectViewHolder.this.d.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1836264875")) {
                ipChange.ipc$dispatch("1836264875", new Object[]{this, eVar});
            } else if (eVar == null || eVar.a == null) {
            } else {
                SearchWordProjectViewHolder.this.d.setImageDrawable(eVar.a);
                SearchWordProjectViewHolder.this.d.setVisibility(0);
            }
        }
    }

    public SearchWordProjectViewHolder(Context context, LayoutInflater layoutInflater, Daojishi daojishi) {
        super(layoutInflater.inflate(R$layout.search_list_suggest_project, (ViewGroup) null));
        this.a = 0;
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.b = context;
        this.h = daojishi;
        c(this.itemView);
    }

    private void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "432296129")) {
            ipChange.ipc$dispatch("432296129", new Object[]{this, view});
            return;
        }
        this.c = (RoundImageView) view.findViewById(R$id.iv_project_image);
        this.d = (ImageView) view.findViewById(R$id.mark);
        this.e = (TextView) view.findViewById(R$id.tv_project_name);
        this.f = (TextView) view.findViewById(R$id.tv_project_time);
        TimerView timerView = (TimerView) view.findViewById(R$id.ll_perform_timer);
        this.g = timerView;
        timerView.setVisibility(8);
    }

    private void d(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "29933986")) {
            ipChange.ipc$dispatch("29933986", new Object[]{this, Boolean.valueOf(z), str});
        } else if (!z) {
            this.d.setVisibility(8);
        } else {
            cn.damai.common.image.a.b().c(str).n(new b()).e(new a()).f();
        }
    }

    private void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-643530671")) {
            ipChange.ipc$dispatch("-643530671", new Object[]{this, str, str2});
        } else if (!TextUtils.isEmpty(str2)) {
            TextView textView = this.f;
            textView.setText(str + " | " + str2);
        } else {
            TextView textView2 = this.f;
            textView2.setText(str + " | 场馆待定");
        }
    }

    private void f(TextView textView, List<String> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1156696806")) {
            ipChange.ipc$dispatch("-1156696806", new Object[]{this, textView, list, str});
            return;
        }
        int size = list == null ? 0 : list.size();
        if (size == 0) {
            textView.setText(str);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i = 0; i < size; i++) {
            try {
                Matcher matcher = Pattern.compile(list.get(i)).matcher(str);
                while (matcher.find()) {
                    int start = matcher.start();
                    this.a = start;
                    if (start == -1) {
                        break;
                    } else if (start >= 0) {
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ContextCompat.getColor(this.b, R$color.color_FF2D79));
                        int i2 = this.a;
                        spannableStringBuilder.setSpan(foregroundColorSpan, i2, list.get(i).length() + i2, 18);
                    }
                }
            } catch (Exception unused) {
            }
        }
        textView.setGravity(16);
        textView.setText(spannableStringBuilder);
    }

    public void b(ProjectItemBean projectItemBean) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1967593139")) {
            ipChange.ipc$dispatch("-1967593139", new Object[]{this, projectItemBean});
        } else if (projectItemBean == null) {
        } else {
            if (this.c.getTag() instanceof vr) {
                ((vr) this.c.getTag()).cancel();
            }
            DMImageCreator c = cn.damai.common.image.a.b().c(projectItemBean.verticalPic);
            int i = R$drawable.uikit_default_image_bg_gradient;
            this.c.setTag(c.i(i).c(i).g(this.c));
            d(projectItemBean.isAtmospheric, projectItemBean.atmosphericPic);
            if (TextUtils.isEmpty(projectItemBean.venueCity)) {
                str = "";
            } else {
                str = "【" + projectItemBean.venueCity + "】";
            }
            List<String> list = projectItemBean.highlightWord;
            if ((list == null ? 0 : list.size()) > 0) {
                f(this.e, projectItemBean.highlightWord, str + projectItemBean.name);
            } else {
                this.e.setText(str + projectItemBean.name);
            }
            if (!projectItemBean.isLiveProject()) {
                e(projectItemBean.showTime, projectItemBean.venueName);
            } else {
                e(projectItemBean.liveStartTime, projectItemBean.venueName);
            }
            this.g.setVisibility(8);
            if (projectItemBean.isSnapUp()) {
                Daojishi daojishi = this.h;
                long j = daojishi.serverTime;
                if (j > 0) {
                    long j2 = projectItemBean.upTime;
                    if (j2 > j) {
                        long elapsedRealtime = ((j2 - daojishi.diffTime) - SystemClock.elapsedRealtime()) / 1000;
                        this.g.loadTimeData(projectItemBean.onSaleTime, projectItemBean.upTime, this.h.diffTime);
                        Daojishi daojishi2 = this.h;
                        if (daojishi2 != null && elapsedRealtime > 0) {
                            daojishi2.addTimer(this.g);
                        }
                        this.g.setVisibility(0);
                        return;
                    }
                }
            }
            Daojishi daojishi3 = this.h;
            if (daojishi3 != null) {
                daojishi3.removeTimer(this.g);
            }
        }
    }
}
