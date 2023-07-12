package tb;

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
    /* loaded from: classes4.dex */
    public class a implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TaskListener a;

        a(TaskListener taskListener) {
            this.a = taskListener;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.b bVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "664579458")) {
                ipChange.ipc$dispatch("664579458", new Object[]{this, bVar});
                return;
            }
            di0.this.b().setImageDrawable(bVar.a);
            this.a.onTaskLoadFinish(di0.this);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b implements IImageLoader.IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TaskListener a;

        b(TaskListener taskListener) {
            this.a = taskListener;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
        public void onFail(IImageLoader.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1634875243")) {
                ipChange.ipc$dispatch("1634875243", new Object[]{this, aVar});
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
                int a2 = (int) (((int) (((DisplayMetrics.getwidthPixels(m62.b(mu0.a())) - (m62.a(mu0.a(), 21.0f) * 2)) - m62.a(mu0.a(), 12.0f)) / 2.0f)) * 1.3333334f);
                int i = a2 > 800 ? 800 : a2;
                this.c = cn.damai.common.image.a.b().load(this.b, i, i, new a(taskListener), new b(taskListener));
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
        GifCareImageView b2 = b();
        if (b2 == null) {
            return;
        }
        if (d()) {
            b2.setImageDrawable(new vx2());
        } else {
            b2.setImageDrawable(mu0.a().getResources().getDrawable(R$drawable.uikit_default_image_bg_gradient));
        }
    }
}
