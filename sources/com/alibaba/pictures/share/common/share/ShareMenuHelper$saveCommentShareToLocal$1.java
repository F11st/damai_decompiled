package com.alibaba.pictures.share.common.share;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareService;
import com.alibaba.pictures.share.common.ui.dialog.DialogHelper;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.alibaba.wireless.security.SecExceptionCode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.C8658e;
import kotlinx.coroutines.C8659f;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a13;
import tb.b41;
import tb.da0;
import tb.i32;
import tb.uc1;
import tb.wb2;
import tb.wt2;
import tb.yb2;
import tb.yd1;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.alibaba.pictures.share.common.share.ShareMenuHelper$saveCommentShareToLocal$1", f = "ShareMenuHelper.kt", i = {}, l = {SecExceptionCode.SEC_ERROR_STA_STORE_KEY_NOT_EXSITED}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class ShareMenuHelper$saveCommentShareToLocal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wt2>, Object> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Bitmap $bmp;
    final /* synthetic */ Ref$ObjectRef $dialog;
    final /* synthetic */ Ref$ObjectRef $fileName;
    int label;
    final /* synthetic */ ShareMenuHelper this$0;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "com.alibaba.pictures.share.common.share.ShareMenuHelper$saveCommentShareToLocal$1$1", f = "ShareMenuHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.alibaba.pictures.share.common.share.ShareMenuHelper$saveCommentShareToLocal$1$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wt2>, Object> {
        private static transient /* synthetic */ IpChange $ipChange;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-828961969")) {
                return (Continuation) ipChange.ipc$dispatch("-828961969", new Object[]{this, obj, continuation});
            }
            b41.i(continuation, "completion");
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super wt2> continuation) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1888865227") ? ipChange.ipc$dispatch("1888865227", new Object[]{this, coroutineScope, continuation}) : ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(wt2.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r7v7, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-881924233")) {
                return ipChange.ipc$dispatch("-881924233", new Object[]{this, obj});
            }
            C8234b.d();
            if (this.label == 0) {
                i32.b(obj);
                ShareMenuHelper$saveCommentShareToLocal$1 shareMenuHelper$saveCommentShareToLocal$1 = ShareMenuHelper$saveCommentShareToLocal$1.this;
                Ref$ObjectRef ref$ObjectRef = shareMenuHelper$saveCommentShareToLocal$1.$fileName;
                ContentResolver contentResolver = ((FragmentActivity) shareMenuHelper$saveCommentShareToLocal$1.this$0.o()).getContentResolver();
                b41.h(contentResolver, "context.contentResolver");
                Bitmap bitmap = ShareMenuHelper$saveCommentShareToLocal$1.this.$bmp;
                StringBuilder sb = new StringBuilder();
                ShareManager shareManager = ShareManager.INSTANCE;
                sb.append(shareManager.b().d());
                sb.append("图片");
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                ShareManager.C3629a b = shareManager.b();
                sb3.append(b != null ? b.d() : null);
                sb3.append("图片");
                ref$ObjectRef.element = a13.a(contentResolver, bitmap, sb2, sb3.toString());
                return wt2.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "com.alibaba.pictures.share.common.share.ShareMenuHelper$saveCommentShareToLocal$1$2", f = "ShareMenuHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.alibaba.pictures.share.common.share.ShareMenuHelper$saveCommentShareToLocal$1$2  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wt2>, Object> {
        private static transient /* synthetic */ IpChange $ipChange;
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1638449426")) {
                return (Continuation) ipChange.ipc$dispatch("-1638449426", new Object[]{this, obj, continuation});
            }
            b41.i(continuation, "completion");
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super wt2> continuation) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-624602134") ? ipChange.ipc$dispatch("-624602134", new Object[]{this, coroutineScope, continuation}) : ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(wt2.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-188531528")) {
                return ipChange.ipc$dispatch("-188531528", new Object[]{this, obj});
            }
            C8234b.d();
            if (this.label == 0) {
                i32.b(obj);
                ((DialogHelper) ShareMenuHelper$saveCommentShareToLocal$1.this.$dialog.element).c();
                if (!TextUtils.isEmpty((String) ShareMenuHelper$saveCommentShareToLocal$1.this.$fileName.element)) {
                    ShareMenuHelper$saveCommentShareToLocal$1.this.this$0.o().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(yd1.c(ShareMenuHelper$saveCommentShareToLocal$1.this.this$0.o(), (String) ShareMenuHelper$saveCommentShareToLocal$1.this.$fileName.element)))));
                    ShareUtil.n("已保存到图库");
                    yb2.b(yb2.INSTANCE, "ShareMenu_SaveLocal_Success", null, null, 6, null);
                    ShareService.ShareActionListener a = wb2.INSTANCE.a();
                    if (a != null) {
                        a.onComplete(ShareChannel.SAVELOCAL);
                    }
                } else {
                    ShareUtil.n("照片保存失败");
                    yb2.b(yb2.INSTANCE, "ShareMenu_SaveLocal_Failed", null, null, 6, null);
                    ShareService.ShareActionListener a2 = wb2.INSTANCE.a();
                    if (a2 != null) {
                        a2.onException(ShareChannel.SAVELOCAL, new ShareException(""));
                    }
                }
                return wt2.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareMenuHelper$saveCommentShareToLocal$1(ShareMenuHelper shareMenuHelper, Ref$ObjectRef ref$ObjectRef, Bitmap bitmap, Ref$ObjectRef ref$ObjectRef2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = shareMenuHelper;
        this.$fileName = ref$ObjectRef;
        this.$bmp = bitmap;
        this.$dialog = ref$ObjectRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1108152196")) {
            return (Continuation) ipChange.ipc$dispatch("-1108152196", new Object[]{this, obj, continuation});
        }
        b41.i(continuation, "completion");
        return new ShareMenuHelper$saveCommentShareToLocal$1(this.this$0, this.$fileName, this.$bmp, this.$dialog, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super wt2> continuation) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "563037816") ? ipChange.ipc$dispatch("563037816", new Object[]{this, coroutineScope, continuation}) : ((ShareMenuHelper$saveCommentShareToLocal$1) create(coroutineScope, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1358386922")) {
            return ipChange.ipc$dispatch("1358386922", new Object[]{this, obj});
        }
        d = C8234b.d();
        int i = this.label;
        if (i == 0) {
            i32.b(obj);
            C8659f.b(null, new AnonymousClass1(null), 1, null);
            uc1 c = da0.c();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
            this.label = 1;
            if (C8658e.e(c, anonymousClass2, this) == d) {
                return d;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i32.b(obj);
        }
        return wt2.INSTANCE;
    }
}
