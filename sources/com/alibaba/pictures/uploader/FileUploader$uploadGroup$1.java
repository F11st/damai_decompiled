package com.alibaba.pictures.uploader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.i32;
import tb.pi0;
import tb.uu2;
import tb.wt2;
import tb.wu2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.alibaba.pictures.uploader.FileUploader$uploadGroup$1", f = "FileUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class FileUploader$uploadGroup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wt2>, Object> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ List $filePathGroup;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FileUploader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileUploader$uploadGroup$1(FileUploader fileUploader, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = fileUploader;
        this.$filePathGroup = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "562779912")) {
            return (Continuation) ipChange.ipc$dispatch("562779912", new Object[]{this, obj, continuation});
        }
        b41.i(continuation, "completion");
        FileUploader$uploadGroup$1 fileUploader$uploadGroup$1 = new FileUploader$uploadGroup$1(this.this$0, this.$filePathGroup, continuation);
        fileUploader$uploadGroup$1.L$0 = obj;
        return fileUploader$uploadGroup$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super wt2> continuation) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-436291836") ? ipChange.ipc$dispatch("-436291836", new Object[]{this, coroutineScope, continuation}) : ((FileUploader$uploadGroup$1) create(coroutineScope, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ArrayList<wu2> arrayList;
        ArrayList arrayList2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-364329506")) {
            return ipChange.ipc$dispatch("-364329506", new Object[]{this, obj});
        }
        b.d();
        if (this.label == 0) {
            i32.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            for (String str : this.$filePathGroup) {
                uu2 uu2Var = new uu2();
                uu2Var.k(UploadStatus.INIT);
                uu2Var.h(str);
                uu2Var.e(pi0.INSTANCE.a(FileUploader.Companion.b(), str));
                uu2Var.g(0L);
                wu2 wu2Var = new wu2(uu2Var, this.this$0.r());
                arrayList2 = this.this$0.b;
                arrayList2.add(wu2Var);
                this.this$0.a.add(uu2Var);
            }
            arrayList = this.this$0.b;
            for (wu2 wu2Var2 : arrayList) {
                g.b(coroutineScope, null, null, new FileUploader$uploadGroup$1$invokeSuspend$$inlined$forEach$lambda$1(wu2Var2, null, this, coroutineScope), 3, null);
            }
            FileUploader.Companion.h("任务开启完毕！");
            return wt2.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
