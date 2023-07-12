package tb;

import cn.damai.commonbusiness.lazyimg.TaskListener;
import cn.damai.commonbusiness.lazyimg.view.GifCareImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public abstract class d21<T extends GifCareImageView> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String VIDEO_UNDER_REVIEW_URL = "VIDEO_UNDER_REVIEW_URL";
    protected final T a;
    protected final String b;

    public d21(T t, String str) {
        this.a = t;
        this.b = str;
    }

    public abstract void a();

    public T b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1744970712") ? (T) ipChange.ipc$dispatch("1744970712", new Object[]{this}) : this.a;
    }

    public boolean c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1825874848") ? ((Boolean) ipChange.ipc$dispatch("1825874848", new Object[]{this})).booleanValue() : this.a != null;
    }

    public boolean d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140318530")) {
            return ((Boolean) ipChange.ipc$dispatch("1140318530", new Object[]{this})).booleanValue();
        }
        String str = this.b;
        return str != null && str.contains("VIDEO_UNDER_REVIEW_URL");
    }

    public abstract void e(TaskListener taskListener);

    public abstract void f();

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-197905328")) {
            return (String) ipChange.ipc$dispatch("-197905328", new Object[]{this});
        }
        return this.a.hashCode() + " " + this.b;
    }
}
