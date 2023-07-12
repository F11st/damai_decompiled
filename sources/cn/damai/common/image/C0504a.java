package cn.damai.common.image;

import android.content.Context;
import android.widget.ImageView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMImageStrategyConfig;
import cn.damai.uikit.image.C2497a;
import cn.damai.uikit.image.IImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.image.ImageStrategyConfig;
import com.taobao.tao.util.ImageStrategyDecider;
import tb.ur1;
import tb.wr;

/* compiled from: Taobao */
/* renamed from: cn.damai.common.image.a */
/* loaded from: classes4.dex */
public class C0504a implements IImageLoader {
    private static transient /* synthetic */ IpChange $ipChange;
    private static C0504a c;
    private Context a;
    private ur1 b;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.image.a$a */
    /* loaded from: classes4.dex */
    public class C0505a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IImageLoader.IImageFailListener a;

        C0505a(C0504a c0504a, IImageLoader.IImageFailListener iImageFailListener) {
            this.a = iImageFailListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1979809483")) {
                ipChange.ipc$dispatch("-1979809483", new Object[]{this, c0501d});
                return;
            }
            IImageLoader.C2495a c2495a = new IImageLoader.C2495a();
            c2495a.a = c0501d.a;
            this.a.onFail(c2495a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.image.a$b */
    /* loaded from: classes4.dex */
    public class C0506b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IImageLoader.IImageSuccListener a;

        C0506b(C0504a c0504a, IImageLoader.IImageSuccListener iImageSuccListener) {
            this.a = iImageSuccListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1691879670")) {
                ipChange.ipc$dispatch("-1691879670", new Object[]{this, c0502e});
                return;
            }
            IImageLoader.C2496b c2496b = new IImageLoader.C2496b();
            c2496b.b = c0502e.b;
            c2496b.a = c0502e.a;
            this.a.onSuccess(c2496b);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.image.a$c */
    /* loaded from: classes4.dex */
    public class C0507c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IImageLoader.IImageFailListener a;

        C0507c(C0504a c0504a, IImageLoader.IImageFailListener iImageFailListener) {
            this.a = iImageFailListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-18234825")) {
                ipChange.ipc$dispatch("-18234825", new Object[]{this, c0501d});
            } else if (this.a == null) {
            } else {
                IImageLoader.C2495a c2495a = new IImageLoader.C2495a();
                c2495a.a = c0501d.a;
                this.a.onFail(c2495a);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.image.a$d */
    /* loaded from: classes4.dex */
    public class C0508d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IImageLoader.IImageSuccListener a;

        C0508d(C0504a c0504a, IImageLoader.IImageSuccListener iImageSuccListener) {
            this.a = iImageSuccListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1386933900")) {
                ipChange.ipc$dispatch("1386933900", new Object[]{this, c0502e});
            } else if (this.a == null) {
            } else {
                IImageLoader.C2496b c2496b = new IImageLoader.C2496b();
                c2496b.b = c0502e.b;
                c2496b.a = c0502e.a;
                this.a.onSuccess(c2496b);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.image.a$e */
    /* loaded from: classes4.dex */
    public class C0509e implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IImageLoader.IImageFailListener a;

        C0509e(C0504a c0504a, IImageLoader.IImageFailListener iImageFailListener) {
            this.a = iImageFailListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1943339833")) {
                ipChange.ipc$dispatch("1943339833", new Object[]{this, c0501d});
            } else if (this.a == null) {
            } else {
                IImageLoader.C2495a c2495a = new IImageLoader.C2495a();
                c2495a.a = c0501d.a;
                this.a.onFail(c2495a);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.image.a$f */
    /* loaded from: classes4.dex */
    public class C0510f implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IImageLoader.IImageSuccListener a;

        C0510f(C0504a c0504a, IImageLoader.IImageSuccListener iImageSuccListener) {
            this.a = iImageSuccListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "170780174")) {
                ipChange.ipc$dispatch("170780174", new Object[]{this, c0502e});
            } else if (this.a == null) {
            } else {
                IImageLoader.C2496b c2496b = new IImageLoader.C2496b();
                c2496b.b = c0502e.b;
                c2496b.a = c0502e.a;
                this.a.onSuccess(c2496b);
            }
        }
    }

    private C0504a() {
        if (this.b == null) {
            this.b = ur1.o();
        }
    }

    public static synchronized C0504a b() {
        synchronized (C0504a.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-334887559")) {
                return (C0504a) ipChange.ipc$dispatch("-334887559", new Object[0]);
            }
            if (c == null) {
                c = new C0504a();
            }
            return c;
        }
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1002405263")) {
            ipChange.ipc$dispatch("-1002405263", new Object[]{this});
        } else {
            this.b.e();
        }
    }

    public DMImageCreator c(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "365683269") ? (DMImageCreator) ipChange.ipc$dispatch("365683269", new Object[]{this, str}) : d(str, null);
    }

    public DMImageCreator d(String str, DMImageStrategyConfig dMImageStrategyConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-672081888")) {
            return (DMImageCreator) ipChange.ipc$dispatch("-672081888", new Object[]{this, str, dMImageStrategyConfig});
        }
        if (dMImageStrategyConfig != null) {
            ImageStrategyConfig.C6898b b = ImageStrategyConfig.o(dMImageStrategyConfig.i).b(dMImageStrategyConfig.a);
            DMImageStrategyConfig.DMImageQuality dMImageQuality = dMImageStrategyConfig.j;
            if (dMImageQuality != null) {
                b.c(wr.a(dMImageQuality));
            }
            DMImageStrategyConfig.DMImageSizeLimitType dMImageSizeLimitType = dMImageStrategyConfig.k;
            if (dMImageSizeLimitType != null) {
                b.d(wr.b(dMImageSizeLimitType));
            }
            return new DMImageCreator().l(this.b.s(ImageStrategyDecider.decideUrl(str, Integer.valueOf(dMImageStrategyConfig.h), Integer.valueOf(dMImageStrategyConfig.g), b.a())));
        }
        return new DMImageCreator().l(this.b.s(str));
    }

    public DMImageCreator e(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1559250943") ? (DMImageCreator) ipChange.ipc$dispatch("-1559250943", new Object[]{this, str}) : f(str, -1, -1);
    }

    public DMImageCreator f(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1295852257") ? (DMImageCreator) ipChange.ipc$dispatch("1295852257", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)}) : g(str, C0511b.b(str, i, i2));
    }

    public DMImageCreator g(String str, DMImageStrategyConfig dMImageStrategyConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "674178020")) {
            return (DMImageCreator) ipChange.ipc$dispatch("674178020", new Object[]{this, str, dMImageStrategyConfig});
        }
        if (dMImageStrategyConfig != null) {
            if (dMImageStrategyConfig.j != null) {
                dMImageStrategyConfig.f = true;
            }
            return new DMImageCreator().l(this.b.s(C0511b.c(str, dMImageStrategyConfig)));
        }
        return new DMImageCreator().l(this.b.s(str));
    }

    public synchronized C0504a h(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1569429806")) {
            return (C0504a) ipChange.ipc$dispatch("-1569429806", new Object[]{this, context});
        }
        if (this.a == null) {
            this.a = context.getApplicationContext();
        }
        C2497a.b(c);
        return this;
    }

    @Override // cn.damai.uikit.image.IImageLoader
    public void load(String str, int i, int i2, int i3, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1423755578")) {
            ipChange.ipc$dispatch("-1423755578", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iImageSuccListener, iImageFailListener});
            return;
        }
        if (i2 == 0) {
            i2 = -1;
        }
        if (i3 == 0) {
            i3 = -1;
        }
        DMImageCreator f = f(str, i2, i3);
        if (i > 0) {
            f = f.i(i);
        }
        f.n(new C0506b(this, iImageSuccListener)).e(new C0505a(this, iImageFailListener)).f();
    }

    @Override // cn.damai.uikit.image.IImageLoader
    public IImageLoader.ImageTicket loadinto(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-940210448") ? (IImageLoader.ImageTicket) ipChange.ipc$dispatch("-940210448", new Object[]{this, str, imageView}) : e(str).g(imageView);
    }

    @Override // cn.damai.uikit.image.IImageLoader
    public IImageLoader.ImageTicket loadinto(String str, ImageView imageView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1917601136")) {
            return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("-1917601136", new Object[]{this, str, imageView, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        DMImageCreator e = e(str);
        if (i > 0) {
            e = e.i(i);
        }
        if (i2 > 0) {
            e = e.c(i2);
        }
        return e.g(imageView);
    }

    @Override // cn.damai.uikit.image.IImageLoader
    public void load(String str, int i, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1834079002")) {
            ipChange.ipc$dispatch("-1834079002", new Object[]{this, str, Integer.valueOf(i), iImageSuccListener, iImageFailListener});
        } else {
            load(str, i, -1, -1, iImageSuccListener, iImageFailListener);
        }
    }

    @Override // cn.damai.uikit.image.IImageLoader
    public IImageLoader.ImageTicket load(String str, int i, int i2, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1982805726")) {
            return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("-1982805726", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), iImageSuccListener, iImageFailListener});
        }
        if (i <= 0) {
            i = -1;
        }
        if (i2 <= 0) {
            i2 = -1;
        }
        return f(str, i, i2).n(new C0508d(this, iImageSuccListener)).e(new C0507c(this, iImageFailListener)).f();
    }

    @Override // cn.damai.uikit.image.IImageLoader
    public IImageLoader.ImageTicket load(String str, int i, int i2, int i3, int i4, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "498746178")) {
            return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("498746178", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iImageSuccListener, iImageFailListener});
        }
        if (i3 <= 0) {
            i3 = -1;
        }
        if (i4 <= 0) {
            i4 = -1;
        }
        DMImageCreator f = f(str, i3, i4);
        if (i > 0) {
            f = f.i(i);
        }
        if (i2 > 0) {
            f = f.c(i2);
        }
        return f.n(new C0510f(this, iImageSuccListener)).e(new C0509e(this, iImageFailListener)).f();
    }
}
