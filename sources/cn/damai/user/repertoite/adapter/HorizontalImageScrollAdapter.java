package cn.damai.user.repertoite.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.user.C0529c;
import cn.damai.homepage.R$drawable;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.user.repertoite.bean.RepertoireDetailDataBean;
import cn.damai.user.repertoite.ui.GalleryImagesActivity;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.C9826vr;
import tb.t60;
import tb.u12;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class HorizontalImageScrollAdapter extends RecyclerView.Adapter<C2696c> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean> a;
    private Context c;
    private String d;
    private String e;
    private boolean f;
    int g;
    private ArrayList<String> b = new ArrayList<>();
    int h = 97;
    int i = SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.repertoite.adapter.HorizontalImageScrollAdapter$a */
    /* loaded from: classes9.dex */
    public class C2692a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean a;
        final /* synthetic */ C2696c b;
        final /* synthetic */ int c;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.user.repertoite.adapter.HorizontalImageScrollAdapter$a$a */
        /* loaded from: classes17.dex */
        public class View$OnClickListenerC2693a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC2693a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "760745028")) {
                    ipChange.ipc$dispatch("760745028", new Object[]{this, view});
                    return;
                }
                Intent intent = new Intent(HorizontalImageScrollAdapter.this.c, GalleryImagesActivity.class);
                intent.putExtra("images", HorizontalImageScrollAdapter.this.b);
                intent.putExtra("location", C2692a.this.c);
                if (HorizontalImageScrollAdapter.this.c == null || ((Activity) HorizontalImageScrollAdapter.this.c).isFinishing()) {
                    return;
                }
                HorizontalImageScrollAdapter.this.c.startActivity(intent);
            }
        }

        C2692a(RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean picInfosBean, C2696c c2696c, int i) {
            this.a = picInfosBean;
            this.b = c2696c;
            this.c = i;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "313019305")) {
                ipChange.ipc$dispatch("313019305", new Object[]{this, c0501d});
                return;
            }
            if (this.a.getWidth() == null || this.a.getHeight() == null || Double.valueOf(this.a.getWidth()).doubleValue() <= 0.0d || Double.valueOf(this.a.getHeight()).doubleValue() <= 0.0d) {
                HorizontalImageScrollAdapter horizontalImageScrollAdapter = HorizontalImageScrollAdapter.this;
                int i = (horizontalImageScrollAdapter.g * horizontalImageScrollAdapter.h) / horizontalImageScrollAdapter.i;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.a.getLayoutParams();
                layoutParams.width = i;
                HorizontalImageScrollAdapter horizontalImageScrollAdapter2 = HorizontalImageScrollAdapter.this;
                layoutParams.height = horizontalImageScrollAdapter2.g;
                if (this.c == 0) {
                    layoutParams.leftMargin = t60.a(horizontalImageScrollAdapter2.c, 18.0f);
                } else {
                    layoutParams.leftMargin = t60.a(horizontalImageScrollAdapter2.c, 6.0f);
                }
                if (this.c == HorizontalImageScrollAdapter.this.a.size() - 1) {
                    layoutParams.rightMargin = t60.a(HorizontalImageScrollAdapter.this.c, 18.0f);
                } else {
                    layoutParams.rightMargin = 0;
                }
                this.b.a.setLayoutParams(layoutParams);
            }
            this.b.a.setImageResource(R$drawable.uikit_default_image_bg_gradient);
            this.b.a.setOnClickListener(new View$OnClickListenerC2693a());
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.repertoite.adapter.HorizontalImageScrollAdapter$b */
    /* loaded from: classes9.dex */
    public class C2694b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean a;
        final /* synthetic */ C2696c b;
        final /* synthetic */ int c;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.user.repertoite.adapter.HorizontalImageScrollAdapter$b$a */
        /* loaded from: classes17.dex */
        public class View$OnClickListenerC2695a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC2695a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1808741371")) {
                    ipChange.ipc$dispatch("-1808741371", new Object[]{this, view});
                    return;
                }
                Intent intent = new Intent(HorizontalImageScrollAdapter.this.c, GalleryImagesActivity.class);
                intent.putExtra("images", HorizontalImageScrollAdapter.this.b);
                intent.putExtra("location", C2694b.this.c);
                if (HorizontalImageScrollAdapter.this.c == null || ((Activity) HorizontalImageScrollAdapter.this.c).isFinishing()) {
                    return;
                }
                HorizontalImageScrollAdapter.this.c.startActivity(intent);
                C0529c.e().x(u12.h().o(HorizontalImageScrollAdapter.this.d, HorizontalImageScrollAdapter.this.e, HorizontalImageScrollAdapter.this.f, C2694b.this.c));
            }
        }

        C2694b(RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean picInfosBean, C2696c c2696c, int i) {
            this.a = picInfosBean;
            this.b = c2696c;
            this.c = i;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-467330434")) {
                ipChange.ipc$dispatch("-467330434", new Object[]{this, c0502e});
                return;
            }
            Drawable drawable = c0502e.a;
            if (drawable != null) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (this.a.getWidth() == null || this.a.getHeight() == null || Double.valueOf(this.a.getWidth()).doubleValue() <= 0.0d || Double.valueOf(this.a.getHeight()).doubleValue() <= 0.0d) {
                    int width = (HorizontalImageScrollAdapter.this.g * bitmap.getWidth()) / bitmap.getHeight();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.a.getLayoutParams();
                    layoutParams.width = width;
                    HorizontalImageScrollAdapter horizontalImageScrollAdapter = HorizontalImageScrollAdapter.this;
                    layoutParams.height = horizontalImageScrollAdapter.g;
                    if (this.c == 0) {
                        layoutParams.leftMargin = t60.a(horizontalImageScrollAdapter.c, 18.0f);
                    } else {
                        layoutParams.leftMargin = t60.a(horizontalImageScrollAdapter.c, 6.0f);
                    }
                    if (this.c == HorizontalImageScrollAdapter.this.a.size() - 1) {
                        layoutParams.rightMargin = t60.a(HorizontalImageScrollAdapter.this.c, 18.0f);
                    } else {
                        layoutParams.rightMargin = 0;
                    }
                    this.b.a.setLayoutParams(layoutParams);
                }
                this.b.a.setImageBitmap(bitmap);
                this.b.a.setOnClickListener(new View$OnClickListenerC2695a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.repertoite.adapter.HorizontalImageScrollAdapter$c */
    /* loaded from: classes9.dex */
    public class C2696c extends RecyclerView.ViewHolder {
        private ImageView a;

        public C2696c(HorizontalImageScrollAdapter horizontalImageScrollAdapter, View view, ImageView imageView) {
            super(view);
            this.a = imageView;
        }
    }

    public HorizontalImageScrollAdapter(Context context, String str, String str2, boolean z) {
        this.d = "";
        this.e = "";
        this.g = t60.a(context, 129.0f);
        DisplayMetrics.getwidthPixels(t60.b(context));
        this.c = context;
        this.d = str;
        this.e = str2;
        this.f = z;
        k();
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-498514186")) {
            ipChange.ipc$dispatch("-498514186", new Object[]{this});
            return;
        }
        List<RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean> list = this.a;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.b.clear();
        for (int i = 0; i < this.a.size(); i++) {
            this.b.add(this.a.get(i).getPicUrl());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(C2696c c2696c, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1699739103")) {
            ipChange.ipc$dispatch("-1699739103", new Object[]{this, c2696c, Integer.valueOf(i)});
            return;
        }
        RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean picInfosBean = this.a.get(i);
        if (picInfosBean.getWidth() != null && picInfosBean.getHeight() != null && Double.valueOf(picInfosBean.getWidth()).doubleValue() > 0.0d && Double.valueOf(picInfosBean.getHeight()).doubleValue() > 0.0d) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c2696c.a.getLayoutParams();
            layoutParams.width = (int) ((this.g * Double.valueOf(picInfosBean.getWidth()).doubleValue()) / Double.valueOf(picInfosBean.getHeight()).doubleValue());
            layoutParams.height = this.g;
            if (i == 0) {
                layoutParams.leftMargin = t60.a(this.c, 18.0f);
            } else {
                layoutParams.leftMargin = t60.a(this.c, 6.0f);
            }
            if (i == this.a.size() - 1) {
                layoutParams.rightMargin = t60.a(this.c, 18.0f);
            } else {
                layoutParams.rightMargin = 0;
            }
            c2696c.a.setLayoutParams(layoutParams);
        }
        if (c2696c.a.getTag() instanceof C9826vr) {
            ((C9826vr) c2696c.a.getTag()).cancel();
        }
        c2696c.a.setOnClickListener(null);
        c2696c.a.setTag(C0504a.b().c(picInfosBean.getPicUrl()).i(R$drawable.uikit_default_image_bg_gradient).n(new C2694b(picInfosBean, c2696c, i)).e(new C2692a(picInfosBean, c2696c, i)).f());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-102996314")) {
            return ((Integer) ipChange.ipc$dispatch("-102996314", new Object[]{this})).intValue();
        }
        List<RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public C2696c onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-9529355")) {
            return (C2696c) ipChange.ipc$dispatch("-9529355", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        RoundImageView roundImageView = new RoundImageView(viewGroup.getContext());
        roundImageView.setBorderRadius(3);
        roundImageView.setType(1);
        relativeLayout.addView(roundImageView);
        return new C2696c(this, relativeLayout, roundImageView);
    }

    public void i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1573202887")) {
            ipChange.ipc$dispatch("1573202887", new Object[]{this, str});
        } else {
            this.d = str;
        }
    }

    public void j(List<RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1370771364")) {
            ipChange.ipc$dispatch("1370771364", new Object[]{this, list});
            return;
        }
        this.a = list;
        k();
    }

    public HorizontalImageScrollAdapter(Context context, String str, String str2, boolean z, List<RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean> list) {
        this.d = "";
        this.e = "";
        this.g = t60.a(context, 129.0f);
        DisplayMetrics.getwidthPixels(t60.b(context));
        this.c = context;
        this.d = str;
        this.a = list;
        this.e = str2;
        this.f = z;
        k();
    }
}
