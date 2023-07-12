package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultCallerLauncher$resultContract$2;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import com.taobao.aranger.constant.Constants;
import com.taobao.weex.bridge.WXBridgeManager;
import com.xiaomi.mipush.sdk.MiPushClient;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B1\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0004H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u000bH\u0016R)\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u000b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R%\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0010R\u0019\u0010\u0019\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Landroidx/activity/result/ActivityResultCallerLauncher;", "I", "O", "Landroidx/activity/result/ActivityResultLauncher;", "Ltb/wt2;", Constants.VOID, "Landroidx/core/app/ActivityOptionsCompat;", WXBridgeManager.OPTIONS, "launch", "(Ltb/wt2;Landroidx/core/app/ActivityOptionsCompat;)V", MiPushClient.COMMAND_UNREGISTER, "Landroidx/activity/result/contract/ActivityResultContract;", "getContract", "resultContract$delegate", "Lkotlin/Lazy;", "getResultContract", "()Landroidx/activity/result/contract/ActivityResultContract;", "resultContract", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "callerContract", "Landroidx/activity/result/contract/ActivityResultContract;", "getCallerContract", "input", "Ljava/lang/Object;", "getInput", "()Ljava/lang/Object;", "<init>", "(Landroidx/activity/result/ActivityResultLauncher;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;)V", "activity-ktx_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<wt2> {
    @NotNull
    private final ActivityResultContract<I, O> callerContract;
    private final I input;
    @NotNull
    private final ActivityResultLauncher<I> launcher;
    @NotNull
    private final Lazy resultContract$delegate;

    public ActivityResultCallerLauncher(@NotNull ActivityResultLauncher<I> activityResultLauncher, @NotNull ActivityResultContract<I, O> activityResultContract, I i) {
        Lazy b;
        b41.i(activityResultLauncher, "launcher");
        b41.i(activityResultContract, "callerContract");
        this.launcher = activityResultLauncher;
        this.callerContract = activityResultContract;
        this.input = i;
        b = b.b(new Function0<ActivityResultCallerLauncher$resultContract$2.AnonymousClass1>() { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AnonymousClass1 invoke() {
                return new ActivityResultContract<wt2, O>() { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2.1
                    @Override // androidx.activity.result.contract.ActivityResultContract
                    public O parseResult(int i2, @Nullable Intent intent) {
                        return (O) ActivityResultCallerLauncher.this.getCallerContract().parseResult(i2, intent);
                    }

                    @Override // androidx.activity.result.contract.ActivityResultContract
                    @NotNull
                    public Intent createIntent(@NotNull Context context, @Nullable wt2 wt2Var) {
                        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
                        Intent createIntent = ActivityResultCallerLauncher.this.getCallerContract().createIntent(context, ActivityResultCallerLauncher.this.getInput());
                        b41.h(createIntent, "callerContract.createIntent(context, input)");
                        return createIntent;
                    }
                };
            }
        });
        this.resultContract$delegate = b;
    }

    @NotNull
    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    @NotNull
    public ActivityResultContract<wt2, ?> getContract() {
        return (ActivityResultContract<wt2, O>) getResultContract();
    }

    public final I getInput() {
        return this.input;
    }

    @NotNull
    public final ActivityResultLauncher<I> getLauncher() {
        return this.launcher;
    }

    @NotNull
    public final ActivityResultContract<wt2, O> getResultContract() {
        return (ActivityResultContract) this.resultContract$delegate.getValue();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.launcher.unregister();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(@Nullable wt2 wt2Var, @Nullable ActivityOptionsCompat activityOptionsCompat) {
        this.launcher.launch(this.input, activityOptionsCompat);
    }
}
