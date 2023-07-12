package cn.damai.common.image;

import android.content.Context;
import android.widget.ImageView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMImageStrategyConfig;
import cn.damai.uikit.image.IImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.image.ImageStrategyConfig;
import com.taobao.tao.util.ImageStrategyDecider;
import tb.ur1;
import tb.wr;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class a implements IImageLoader {
    private static transient /* synthetic */ IpChange $ipChange;
    private static a c;
    private Context a;
    private ur1 b;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.image.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0023a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IImageLoader.IImageFailListener a;

        C0023a(a aVar, IImageLoader.IImageFailListener iImageFailListener) {
            this.a = iImageFailListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1979809483")) {
                ipChange.ipc$dispatch("-1979809483", new Object[]{this, dVar});
                return;
            }
            IImageLoader.a aVar = new IImageLoader.a();
            aVar.a = dVar.a;
            this.a.onFail(aVar);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IImageLoader.IImageSuccListener a;

        b(a aVar, IImageLoader.IImageSuccListener iImageSuccListener) {
            this.a = iImageSuccListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1691879670")) {
                ipChange.ipc$dispatch("-1691879670", new Object[]{this, eVar});
                return;
            }
            IImageLoader.b bVar = new IImageLoader.b();
            bVar.b = eVar.b;
            bVar.a = eVar.a;
            this.a.onSuccess(bVar);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IImageLoader.IImageFailListener a;

        c(a aVar, IImageLoader.IImageFailListener iImageFailListener) {
            this.a = iImageFailListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-18234825")) {
                ipChange.ipc$dispatch("-18234825", new Object[]{this, dVar});
            } else if (this.a == null) {
            } else {
                IImageLoader.a aVar = new IImageLoader.a();
                aVar.a = dVar.a;
                this.a.onFail(aVar);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IImageLoader.IImageSuccListener a;

        d(a aVar, IImageLoader.IImageSuccListener iImageSuccListener) {
            this.a = iImageSuccListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1386933900")) {
                ipChange.ipc$dispatch("1386933900", new Object[]{this, eVar});
            } else if (this.a == null) {
            } else {
                IImageLoader.b bVar = new IImageLoader.b();
                bVar.b = eVar.b;
                bVar.a = eVar.a;
                this.a.onSuccess(bVar);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class e implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IImageLoader.IImageFailListener a;

        e(a aVar, IImageLoader.IImageFailListener iImageFailListener) {
            this.a = iImageFailListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1943339833")) {
                ipChange.ipc$dispatch("1943339833", new Object[]{this, dVar});
            } else if (this.a == null) {
            } else {
                IImageLoader.a aVar = new IImageLoader.a();
                aVar.a = dVar.a;
                this.a.onFail(aVar);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class f implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IImageLoader.IImageSuccListener a;

        f(a aVar, IImageLoader.IImageSuccListener iImageSuccListener) {
            this.a = iImageSuccListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "170780174")) {
                ipChange.ipc$dispatch("170780174", new Object[]{this, eVar});
            } else if (this.a == null) {
            } else {
                IImageLoader.b bVar = new IImageLoader.b();
                bVar.b = eVar.b;
                bVar.a = eVar.a;
                this.a.onSuccess(bVar);
            }
        }
    }

    private a() {
        if (this.b == null) {
            this.b = ur1.o();
        }
    }

    public static synchronized a b() {
        synchronized (a.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-334887559")) {
                return (a) ipChange.ipc$dispatch("-334887559", new Object[0]);
            }
            if (c == null) {
                c = new a();
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
            ImageStrategyConfig.b b2 = ImageStrategyConfig.o(dMImageStrategyConfig.i).b(dMImageStrategyConfig.a);
            DMImageStrategyConfig.DMImageQuality dMImageQuality = dMImageStrategyConfig.j;
            if (dMImageQuality != null) {
                b2.c(wr.a(dMImageQuality));
            }
            DMImageStrategyConfig.DMImageSizeLimitType dMImageSizeLimitType = dMImageStrategyConfig.k;
            if (dMImageSizeLimitType != null) {
                b2.d(wr.b(dMImageSizeLimitType));
            }
            return new DMImageCreator().l(this.b.s(ImageStrategyDecider.decideUrl(str, Integer.valueOf(dMImageStrategyConfig.h), Integer.valueOf(dMImageStrategyConfig.g), b2.a())));
        }
        return new DMImageCreator().l(this.b.s(str));
    }

    public DMImageCreator e(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1559250943") ? (DMImageCreator) ipChange.ipc$dispatch("-1559250943", new Object[]{this, str}) : f(str, -1, -1);
    }

    public DMImageCreator f(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1295852257") ? (DMImageCreator) ipChange.ipc$dispatch("1295852257", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)}) : g(str, cn.damai.common.image.b.b(str, i, i2));
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
            return new DMImageCreator().l(this.b.s(cn.damai.common.image.b.c(str, dMImageStrategyConfig)));
        }
        return new DMImageCreator().l(this.b.s(str));
    }

    public synchronized a h(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1569429806")) {
            return (a) ipChange.ipc$dispatch("-1569429806", new Object[]{this, context});
        }
        if (this.a == null) {
            this.a = context.getApplicationContext();
        }
        cn.damai.uikit.image.a.b(c);
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
        DMImageCreator f2 = f(str, i2, i3);
        if (i > 0) {
            f2 = f2.i(i);
        }
        f2.n(new b(this, iImageSuccListener)).e(new C0023a(this, iImageFailListener)).f();
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
        DMImageCreator e2 = e(str);
        if (i > 0) {
            e2 = e2.i(i);
        }
        if (i2 > 0) {
            e2 = e2.c(i2);
        }
        return e2.g(imageView);
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
        return f(str, i, i2).n(new d(this, iImageSuccListener)).e(new c(this, iImageFailListener)).f();
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
        DMImageCreator f2 = f(str, i3, i4);
        if (i > 0) {
            f2 = f2.i(i);
        }
        if (i2 > 0) {
            f2 = f2.c(i2);
        }
        return f2.n(new f(this, iImageSuccListener)).e(new e(this, iImageFailListener)).f();
    }
}
