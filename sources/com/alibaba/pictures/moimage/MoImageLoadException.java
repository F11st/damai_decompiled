package com.alibaba.pictures.moimage;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/alibaba/pictures/moimage/MoImageLoadException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "tag", "Ljava/lang/Object;", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "", "throwable", "<init>", "(Ljava/lang/Throwable;)V", "", "msg", "(Ljava/lang/String;)V", "moimage_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class MoImageLoadException extends Exception {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Object tag;

    public MoImageLoadException(@Nullable Throwable th) {
        super(th);
    }

    @Nullable
    public final Object getTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1652778662") ? ipChange.ipc$dispatch("-1652778662", new Object[]{this}) : this.tag;
    }

    public final void setTag(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2126216128")) {
            ipChange.ipc$dispatch("2126216128", new Object[]{this, obj});
        } else {
            this.tag = obj;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoImageLoadException(@NotNull String str) {
        super(str);
        b41.i(str, "msg");
    }
}
