package cn.damai.discover.content.view;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.discover.content.ui.viewholder.OnFollowStatusChangeListener;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$raw;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Calendar;
import java.util.Date;
import tb.jm1;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class Wanna2SeePanel implements OnFollowStatusChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private LottieAnimationView b;
    private TextView c;
    private View d;
    private Handler g;
    private boolean e = false;
    private boolean f = false;
    private String h = "想看";
    private Runnable i = new Runnable() { // from class: cn.damai.discover.content.view.Wanna2SeePanel.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-953551040")) {
                ipChange.ipc$dispatch("-953551040", new Object[]{this});
            } else {
                Wanna2SeePanel.this.i();
            }
        }
    };

    public Wanna2SeePanel(Activity activity) {
        this.a = activity;
        this.d = activity.findViewById(R$id.content_detail_wanna_2_see_guide);
        this.b = (LottieAnimationView) activity.findViewById(R$id.content_detail_wanna_2_see_icon);
        this.c = (TextView) activity.findViewById(R$id.content_detail_wanna_2_see_text);
    }

    private boolean c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "216135361")) {
            return ((Boolean) ipChange.ipc$dispatch("216135361", new Object[]{this})).booleanValue();
        }
        Activity activity = this.a;
        return (activity == null || activity.isFinishing()) ? false : true;
    }

    private static boolean d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1495842086")) {
            return ((Boolean) ipChange.ipc$dispatch("1495842086", new Object[0])).booleanValue();
        }
        String B = z20.B("sp_last_time_show_guide");
        if (TextUtils.isEmpty(B)) {
            return false;
        }
        long j = 0;
        try {
            j = Long.parseLong(B);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(j));
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    private static void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "443772617")) {
            ipChange.ipc$dispatch("443772617", new Object[0]);
            return;
        }
        z20.T("sp_last_time_show_guide", System.currentTimeMillis() + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "984714521")) {
            ipChange.ipc$dispatch("984714521", new Object[]{this});
        } else if (!c() || this.f || this.e) {
        } else {
            this.e = true;
            this.d.setVisibility(0);
            this.d.postDelayed(new Runnable() { // from class: cn.damai.discover.content.view.Wanna2SeePanel.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1346578050")) {
                        ipChange2.ipc$dispatch("-1346578050", new Object[]{this});
                    } else {
                        Wanna2SeePanel.this.d.setVisibility(8);
                    }
                }
            }, 3000L);
            f();
        }
    }

    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "827552067")) {
            ipChange.ipc$dispatch("827552067", new Object[]{this});
            return;
        }
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacks(this.i);
        }
    }

    @Override // cn.damai.discover.content.ui.viewholder.OnFollowStatusChangeListener
    public void followStatusChanged(boolean z, int i, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1310979358")) {
            ipChange.ipc$dispatch("1310979358", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2)});
            return;
        }
        this.f = z;
        this.b.setAnimation(z ? R$raw.lottie_favourite_click : R$raw.lottie_favorite_cancel);
        this.b.setProgress(1.0f);
        if (z2) {
            this.b.playAnimation();
        } else {
            this.b.setProgress(1.0f);
        }
        this.c.setText(i > 0 ? jm1.g(i) : this.h);
    }

    public void g(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2135889976")) {
            ipChange.ipc$dispatch("-2135889976", new Object[]{this, recyclerView});
        } else if (recyclerView == null || d() || this.g != null) {
        } else {
            this.g = new Handler(Looper.getMainLooper());
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.discover.content.view.Wanna2SeePanel.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                    View childAt;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2002894403")) {
                        ipChange2.ipc$dispatch("-2002894403", new Object[]{this, recyclerView2, Integer.valueOf(i)});
                    } else if (i != 0 || (childAt = recyclerView2.getChildAt(0)) == null || childAt.findViewById(R$id.note_stroke_layout) == null) {
                    } else {
                        Wanna2SeePanel.this.i();
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-693150270")) {
                        ipChange2.ipc$dispatch("-693150270", new Object[]{this, recyclerView2, Integer.valueOf(i), Integer.valueOf(i2)});
                    }
                }
            });
            this.g.postDelayed(this.i, 10000L);
        }
    }

    public void h(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1229412857")) {
            ipChange.ipc$dispatch("1229412857", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        String str = z ? "想玩" : "想看";
        this.h = str;
        TextView textView = this.c;
        if (i > 0) {
            str = jm1.g(i);
        }
        textView.setText(str);
    }
}
