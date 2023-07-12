package cn.damai.mine.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class PageData<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    public T data;
    public String errorCode;
    public String errorMsg;
    public boolean hasMore;
    public final boolean isFirstPage;
    public final boolean success = false;

    public PageData(boolean z, boolean z2, T t) {
        this.isFirstPage = z;
        this.hasMore = z2;
        this.data = t;
    }

    public static <T> PageData<T> fail(boolean z, String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2029815764") ? (PageData) ipChange.ipc$dispatch("-2029815764", new Object[]{Boolean.valueOf(z), str, str2}) : new PageData<>(z, str, str2);
    }

    public static <T> PageData<T> success(boolean z, boolean z2, T t) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-25178711") ? (PageData) ipChange.ipc$dispatch("-25178711", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), t}) : new PageData<>(z, z2, t);
    }

    public PageData(boolean z, String str, String str2) {
        this.isFirstPage = z;
        this.errorCode = str;
        this.errorMsg = str2;
    }
}
