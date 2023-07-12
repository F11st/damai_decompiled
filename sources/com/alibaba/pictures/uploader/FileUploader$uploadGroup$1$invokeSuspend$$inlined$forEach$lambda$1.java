package com.alibaba.pictures.uploader;

import com.alibaba.pictures.uploader.FileUploader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uploader.export.C7361a;
import com.uploader.export.IUploaderManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.i32;
import tb.id;
import tb.qu2;
import tb.su2;
import tb.uu2;
import tb.wt2;
import tb.wu2;
import tb.xu2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/alibaba/pictures/uploader/FileUploader$uploadGroup$1$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.alibaba.pictures.uploader.FileUploader$uploadGroup$1$2$1", f = "FileUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class FileUploader$uploadGroup$1$invokeSuspend$$inlined$forEach$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wt2>, Object> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ CoroutineScope $this_launch$inlined;
    final /* synthetic */ wu2 $uploadTask;
    int label;
    final /* synthetic */ FileUploader$uploadGroup$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileUploader$uploadGroup$1$invokeSuspend$$inlined$forEach$lambda$1(wu2 wu2Var, Continuation continuation, FileUploader$uploadGroup$1 fileUploader$uploadGroup$1, CoroutineScope coroutineScope) {
        super(2, continuation);
        this.$uploadTask = wu2Var;
        this.this$0 = fileUploader$uploadGroup$1;
        this.$this_launch$inlined = coroutineScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-315361343")) {
            return (Continuation) ipChange.ipc$dispatch("-315361343", new Object[]{this, obj, continuation});
        }
        b41.i(continuation, "completion");
        return new FileUploader$uploadGroup$1$invokeSuspend$$inlined$forEach$lambda$1(this.$uploadTask, continuation, this.this$0, this.$this_launch$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super wt2> continuation) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "477984573") ? ipChange.ipc$dispatch("477984573", new Object[]{this, coroutineScope, continuation}) : ((FileUploader$uploadGroup$1$invokeSuspend$$inlined$forEach$lambda$1) create(coroutineScope, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Boolean bool;
        FileUploader.HandlerC3646b handlerC3646b;
        qu2 qu2Var;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2069884741")) {
            return ipChange.ipc$dispatch("2069884741", new Object[]{this, obj});
        }
        C8234b.d();
        if (this.label == 0) {
            i32.b(obj);
            String str = null;
            this.$uploadTask.a().e(su2.a(this.$uploadTask.a().a(), null));
            bool = this.this$0.this$0.h;
            if (b41.d(bool, id.a(true))) {
                FileUploader.C3645a c3645a = FileUploader.Companion;
                if (c3645a.f() != null) {
                    c3645a.h("startUpLoadGroup---处理压缩原链接：" + this.$uploadTask.a().a() + "，要压缩链接=" + this.$uploadTask.a().a() + '+' + System.currentTimeMillis());
                    uu2 a = this.$uploadTask.a();
                    IImageCompressor f = c3645a.f();
                    if (f != null) {
                        String a2 = this.$uploadTask.a().a();
                        qu2Var = this.this$0.this$0.i;
                        str = f.compress(a2, qu2Var);
                    }
                    a.e(str);
                    this.$uploadTask.a().k(UploadStatus.RESIZE);
                    c3645a.h("startUpLoadGroup---处理压缩完成=" + this.$uploadTask.a().a() + '+' + System.currentTimeMillis());
                }
            }
            wu2 wu2Var = this.$uploadTask;
            FileUploader.C3645a c3645a2 = FileUploader.Companion;
            c3645a2.h("startUpLoadGroup---ARUS-uploadAsync=" + this.$uploadTask.a().a() + '+' + System.currentTimeMillis());
            IUploaderManager a3 = C7361a.a();
            xu2 xu2Var = new xu2(this.this$0.this$0);
            handlerC3646b = this.this$0.this$0.j;
            a3.uploadAsync(wu2Var, xu2Var, handlerC3646b);
            return wt2.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
