package cn.damai.uikit.image;

import android.util.Log;
import android.widget.ImageView;
import cn.damai.uikit.image.IImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;
    static IImageLoader a;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.image.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0089a implements IImageLoader {
        private static transient /* synthetic */ IpChange $ipChange;

        C0089a() {
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public void load(String str, int i, int i2, int i3, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1849060418")) {
                ipChange.ipc$dispatch("1849060418", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iImageSuccListener, iImageFailListener});
            } else {
                Log.e("DefaultLoader", "loadinto error, please init ImageLoaderProxy by ImageLoaderProxy.initLoaderImpl()");
            }
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public IImageLoader.ImageTicket loadinto(String str, ImageView imageView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1699721972")) {
                return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("1699721972", new Object[]{this, str, imageView});
            }
            Log.e("DefaultLoader", "loadinto error, please init ImageLoaderProxy by ImageLoaderProxy.initLoaderImpl()");
            return null;
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public void load(String str, int i, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-221736606")) {
                ipChange.ipc$dispatch("-221736606", new Object[]{this, str, Integer.valueOf(i), iImageSuccListener, iImageFailListener});
            } else {
                Log.e("DefaultLoader", "loadinto error, please init ImageLoaderProxy by ImageLoaderProxy.initLoaderImpl()");
            }
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public IImageLoader.ImageTicket loadinto(String str, ImageView imageView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1026749844")) {
                return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("1026749844", new Object[]{this, str, imageView, Integer.valueOf(i), Integer.valueOf(i2)});
            }
            Log.e("DefaultLoader", "loadinto error,please init ImageLoaderProxy by ImageLoaderProxy.initLoaderImpl()");
            return null;
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public IImageLoader.ImageTicket load(String str, int i, int i2, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1076343514")) {
                return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("-1076343514", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), iImageSuccListener, iImageFailListener});
            }
            Log.e("DefaultLoader", "loadinto error, please init ImageLoaderProxy by ImageLoaderProxy.initLoaderImpl()");
            return null;
        }

        @Override // cn.damai.uikit.image.IImageLoader
        public IImageLoader.ImageTicket load(String str, int i, int i2, int i3, int i4, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-269429178")) {
                return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("-269429178", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iImageSuccListener, iImageFailListener});
            }
            Log.e("DefaultLoader", "loadinto error, please init ImageLoaderProxy by ImageLoaderProxy.initLoaderImpl()");
            return null;
        }
    }

    public static IImageLoader a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1923379985")) {
            return (IImageLoader) ipChange.ipc$dispatch("1923379985", new Object[0]);
        }
        if (a == null) {
            a = new C0089a();
        }
        return a;
    }

    public static void b(IImageLoader iImageLoader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1605784682")) {
            ipChange.ipc$dispatch("1605784682", new Object[]{iImageLoader});
        } else {
            a = iImageLoader;
        }
    }
}
