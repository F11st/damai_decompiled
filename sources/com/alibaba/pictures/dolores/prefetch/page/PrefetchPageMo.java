package com.alibaba.pictures.dolores.prefetch.page;

import com.alibaba.pictures.dolores.prefetch.PrefetchRequestBuilder;
import com.alibaba.wireless.security.open.securitybodysdk.ISecurityBodyPageTrack;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR>\u0010\f\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0018\u00010\tj\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0018\u0001`\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/alibaba/pictures/dolores/prefetch/page/PrefetchPageMo;", "Ljava/io/Serializable;", "", ISecurityBodyPageTrack.PAGE_ID_KEY, "Ljava/lang/String;", "getPageId", "()Ljava/lang/String;", "setPageId", "(Ljava/lang/String;)V", "Ljava/util/ArrayList;", "Lcom/alibaba/pictures/dolores/prefetch/PrefetchRequestBuilder;", "Lkotlin/collections/ArrayList;", "requestList", "Ljava/util/ArrayList;", "getRequestList", "()Ljava/util/ArrayList;", "setRequestList", "(Ljava/util/ArrayList;)V", "", "expireTime", "J", "getExpireTime", "()J", "setExpireTime", "(J)V", "<init>", "()V", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class PrefetchPageMo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private long expireTime = 3000;
    @Nullable
    private String pageId;
    @Nullable
    private ArrayList<PrefetchRequestBuilder<?>> requestList;

    public final long getExpireTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1449832697") ? ((Long) ipChange.ipc$dispatch("1449832697", new Object[]{this})).longValue() : this.expireTime;
    }

    @Nullable
    public final String getPageId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1308204217") ? (String) ipChange.ipc$dispatch("1308204217", new Object[]{this}) : this.pageId;
    }

    @Nullable
    public final ArrayList<PrefetchRequestBuilder<?>> getRequestList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "537481286") ? (ArrayList) ipChange.ipc$dispatch("537481286", new Object[]{this}) : this.requestList;
    }

    public final void setExpireTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1055018603")) {
            ipChange.ipc$dispatch("1055018603", new Object[]{this, Long.valueOf(j)});
        } else {
            this.expireTime = j;
        }
    }

    public final void setPageId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "504533061")) {
            ipChange.ipc$dispatch("504533061", new Object[]{this, str});
        } else {
            this.pageId = str;
        }
    }

    public final void setRequestList(@Nullable ArrayList<PrefetchRequestBuilder<?>> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1709501902")) {
            ipChange.ipc$dispatch("-1709501902", new Object[]{this, arrayList});
        } else {
            this.requestList = arrayList;
        }
    }
}
