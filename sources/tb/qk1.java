package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.common.AppConfig;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.bean.GridBean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.uikit.view.NineGridView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class qk1 extends NineGridView.AbstractC2586a<View$OnClickListenerC9607a> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<GridBean> b = new ArrayList();
    private Context c;
    private OnItemBindListener<GridBean> d;

    /* compiled from: Taobao */
    /* renamed from: tb.qk1$a */
    /* loaded from: classes4.dex */
    public static class View$OnClickListenerC9607a extends NineGridView.C2588c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private ImageView c;
        private View d;
        private TextView e;
        private TextView f;
        private TextView g;
        private GridBean h;
        private int i;
        private OnItemBindListener<GridBean> j;

        public View$OnClickListenerC9607a(View view, OnItemBindListener<GridBean> onItemBindListener) {
            super(view);
            this.d = view.findViewById(R$id.item_nine_one_play_top_right);
            this.e = (TextView) view.findViewById(R$id.item_nine_one_video_status);
            this.c = (ImageView) view.findViewById(R$id.item_nine_one_img);
            this.f = (TextView) view.findViewById(R$id.item_nine_one_pic_num);
            this.g = (TextView) view.findViewById(R$id.item_nine_video_time);
            this.j = onItemBindListener;
            view.setOnClickListener(this);
        }

        public void a(GridBean gridBean, int i) {
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-779020227")) {
                ipChange.ipc$dispatch("-779020227", new Object[]{this, gridBean, Integer.valueOf(i)});
            } else if (gridBean == null) {
            } else {
                boolean z = gridBean.itemCount == 1;
                ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                if (z) {
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                } else {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                this.c.requestLayout();
                this.h = gridBean;
                this.i = i;
                this.e.setVisibility(8);
                this.d.setVisibility(8);
                if (gridBean.countRightBottomTag > 0) {
                    this.f.setVisibility(0);
                    this.f.setText(jn1.PLUS + gridBean.countRightBottomTag);
                } else {
                    this.f.setVisibility(8);
                }
                boolean z2 = (this.f.getVisibility() == 0 || TextUtils.isEmpty(gridBean.formatVideoTime)) ? false : true;
                this.g.setVisibility(z2 ? 0 : 8);
                if (z2) {
                    this.g.setText(gridBean.formatVideoTime);
                    int a = l62.a(mu0.a(), z ? 8.0f : 6.0f);
                    this.g.setPadding(a, a, a, a);
                }
                int i2 = gridBean.type;
                if (i2 == 273) {
                    this.e.setVisibility(0);
                    this.e.setText("视频处理中");
                    this.d.setVisibility(0);
                    this.c.setImageResource(R$drawable.bg_video_under_review_deafult);
                    str = null;
                } else if (i2 != 274) {
                    str = gridBean.picUrl;
                } else {
                    this.d.setVisibility(0);
                    str = gridBean.picUrl;
                }
                Object tag = this.c.getTag();
                if (tag instanceof C9826vr) {
                    ((C9826vr) tag).cancel();
                }
                this.c.setTag(null);
                if (!TextUtils.isEmpty(str)) {
                    int a2 = gridBean.itemCount > 1 ? 400 : l62.a(mu0.a(), 321.0f);
                    DMImageCreator f = C0504a.b().f(str, a2, a2);
                    this.c.setTag(f.i(cn.damai.uikit.R$drawable.uikit_default_image_bg_grey).g(this.c));
                    if (AppConfig.v()) {
                        try {
                            Field declaredField = DMImageCreator.class.getDeclaredField("phenixCreator");
                            declaredField.setAccessible(true);
                            String R = ((wr1) declaredField.get(f)).R();
                            cb1.c("NineGridLoad", "nineGridChildCount=" + gridBean.itemCount);
                            cb1.c("NineGridLoad", "realLoadUrl=" + R);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                OnItemBindListener<GridBean> onItemBindListener = this.j;
                if (onItemBindListener != null) {
                    onItemBindListener.exposeItem(this.a, this.h, this.i);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemBindListener<GridBean> onItemBindListener;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1840157923")) {
                ipChange.ipc$dispatch("-1840157923", new Object[]{this, view});
                return;
            }
            GridBean gridBean = this.h;
            if (gridBean == null || (onItemBindListener = this.j) == null) {
                return;
            }
            onItemBindListener.onItemClick(gridBean, this.i);
        }
    }

    public qk1(Context context, OnItemBindListener<GridBean> onItemBindListener) {
        this.c = context;
        this.d = onItemBindListener;
    }

    @Override // cn.damai.uikit.view.NineGridView.AbstractC2586a
    public int e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-760239428") ? ((Integer) ipChange.ipc$dispatch("-760239428", new Object[]{this})).intValue() : this.b.size();
    }

    @Override // cn.damai.uikit.view.NineGridView.AbstractC2586a
    /* renamed from: h */
    public void b(View$OnClickListenerC9607a view$OnClickListenerC9607a, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2105897042")) {
            ipChange.ipc$dispatch("2105897042", new Object[]{this, view$OnClickListenerC9607a, Integer.valueOf(i)});
        } else {
            view$OnClickListenerC9607a.a(this.b.get(i), i);
        }
    }

    @Override // cn.damai.uikit.view.NineGridView.AbstractC2586a
    /* renamed from: i */
    public View$OnClickListenerC9607a c(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "87853208") ? (View$OnClickListenerC9607a) ipChange.ipc$dispatch("87853208", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new View$OnClickListenerC9607a(LayoutInflater.from(this.c).inflate(R$layout.item_nine_single_item, viewGroup, false), this.d);
    }

    public void j(List<GridBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "633429655")) {
            ipChange.ipc$dispatch("633429655", new Object[]{this, list});
            return;
        }
        this.b.clear();
        if (!cb2.d(list)) {
            this.b.addAll(list);
        }
        GridBean.ensureItemCountMemberVar(this.b);
        g();
    }
}
