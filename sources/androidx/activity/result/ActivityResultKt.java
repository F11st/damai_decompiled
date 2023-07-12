package androidx.activity.result;

import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\u0002\u001a\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0000H\u0086\u0002¨\u0006\u0005"}, d2 = {"Landroidx/activity/result/ActivityResult;", "", "component1", "Landroid/content/Intent;", "component2", "activity-ktx_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes12.dex */
public final class ActivityResultKt {
    public static final int component1(@NotNull ActivityResult activityResult) {
        b41.i(activityResult, "$this$component1");
        return activityResult.getResultCode();
    }

    @Nullable
    public static final Intent component2(@NotNull ActivityResult activityResult) {
        b41.i(activityResult, "$this$component2");
        return activityResult.getData();
    }
}
