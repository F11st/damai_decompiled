package tb;

import cn.damai.common.image.C0504a;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.lazyimg.TaskListener;
import cn.damai.commonbusiness.lazyimg.view.GifCareImageView;
import cn.damai.uikit.image.IImageLoader;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class di0 extends d21<GifCareImageView> {
    private static transient /* synthetic */ IpChange $ipChange;
    private IImageLoader.ImageTicket c;

    /* compiled from: Taobao */
    /* renamed from: tb.di0$a */
    /* loaded from: classes4.dex */
    public class C9043a implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TaskListener a;

        C9043a(TaskListener taskListener) {
            this.a = taskListener;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.C2496b c2496b) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "664579458")) {
                ipChange.ipc$dispatch("664579458", new Object[]{this, c2496b});
                return;
            }
            di0.this.b().setImageDrawable(c2496b.a);
            this.a.onTaskLoadFinish(di0.this);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.di0$b */
    /* loaded from: classes4.dex */
    public class C9044b implements IImageLoader.IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TaskListener a;

        C9044b(TaskListener taskListener) {
            this.a = taskListener;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
        public void onFail(IImageLoader.C2495a c2495a) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1634875243")) {
                ipChange.ipc$dispatch("1634875243", new Object[]{this, c2495a});
            } else {
                this.a.onTaskLoadFinish(di0.this);
            }
        }
    }

    public di0(GifCareImageView gifCareImageView, String str) {
        super(gifCareImageView, str);
    }

    @Override // tb.d21
    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "618734578")) {
            ipChange.ipc$dispatch("618734578", new Object[]{this});
            return;
        }
        try {
            IImageLoader.ImageTicket imageTicket = this.c;
            if (imageTicket != null) {
                imageTicket.cancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tb.d21
    public void e(TaskListener taskListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "116389715")) {
            ipChange.ipc$dispatch("116389715", new Object[]{this, taskListener});
        } else if (d()) {
        } else {
            if (this.b != null) {
                int a = (int) (((int) (((DisplayMetrics.getwidthPixels(m62.b(mu0.a())) - (m62.a(mu0.a(), 21.0f) * 2)) - m62.a(mu0.a(), 12.0f)) / 2.0f)) * 1.3333334f);
                int i = a > 800 ? 800 : a;
                this.c = C0504a.b().load(this.b, i, i, new C9043a(taskListener), new C9044b(taskListener));
                return;
            }
            taskListener.onTaskLoadFinish(this);
        }
    }

    @Override // tb.d21
    public void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175665993")) {
            ipChange.ipc$dispatch("-1175665993", new Object[]{this});
            return;
        }
        GifCareImageView b = b();
        if (b == null) {
            return;
        }
        if (d()) {
            b.setImageDrawable(new vx2());
        } else {
            b.setImageDrawable(mu0.a().getResources().getDrawable(R$drawable.uikit_default_image_bg_gradient));
        }
    }
}
