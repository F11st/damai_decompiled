package tb;

import androidx.annotation.NonNull;
import com.alibaba.android.onescheduler.IGroupPriorityInterceptor;
import com.alibaba.android.onescheduler.Priority;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class dd2 implements IGroupPriorityInterceptor {
    @Override // com.alibaba.android.onescheduler.IGroupPriorityInterceptor
    @NonNull
    public Priority intercept(String str) {
        return Priority.NORMAL;
    }
}
