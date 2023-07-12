package com.alibaba.pictures.share.weiboshare;

import android.graphics.Bitmap;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.openapi.IWBAPI;
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
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.alibaba.pictures.share.weiboshare.WeiboShareActivity$sendMultiMessage$1", f = "WeiboShareActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class WeiboShareActivity$sendMultiMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wt2>, Object> {
    private static transient /* synthetic */ IpChange $ipChange;
    int label;
    final /* synthetic */ WeiboShareActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeiboShareActivity$sendMultiMessage$1(WeiboShareActivity weiboShareActivity, Continuation continuation) {
        super(2, continuation);
        this.this$0 = weiboShareActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883809383")) {
            return (Continuation) ipChange.ipc$dispatch("883809383", new Object[]{this, obj, continuation});
        }
        b41.i(continuation, "completion");
        return new WeiboShareActivity$sendMultiMessage$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super wt2> continuation) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-557272861") ? ipChange.ipc$dispatch("-557272861", new Object[]{this, coroutineScope, continuation}) : ((WeiboShareActivity$sendMultiMessage$1) create(coroutineScope, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ShareContent shareContent;
        TextObject textObj;
        ImageObject imageObj;
        Bitmap bitmap;
        boolean checkBitmap;
        TextObject textObj2;
        ImageObject imageObj2;
        Bitmap bitmap2;
        boolean checkBitmap2;
        WebpageObject webpageObj;
        TextObject textObj3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1525137057")) {
            return ipChange.ipc$dispatch("-1525137057", new Object[]{this, obj});
        }
        C8234b.d();
        if (this.label == 0) {
            i32.b(obj);
            WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
            shareContent = this.this$0.shareParams;
            Integer c = shareContent != null ? id.c(shareContent.getShareType()) : null;
            if ((c != null && c.intValue() == 3) || (c != null && c.intValue() == 2)) {
                imageObj2 = this.this$0.getImageObj();
                weiboMultiMessage.imageObject = imageObj2;
                WeiboShareActivity weiboShareActivity = this.this$0;
                bitmap2 = weiboShareActivity.shareBmp;
                checkBitmap2 = weiboShareActivity.checkBitmap(bitmap2);
                if (!checkBitmap2) {
                    webpageObj = this.this$0.getWebpageObj();
                    weiboMultiMessage.mediaObject = webpageObj;
                    textObj3 = this.this$0.getTextObj();
                    weiboMultiMessage.textObject = textObj3;
                } else {
                    this.this$0.finish();
                    return wt2.INSTANCE;
                }
            } else if (c != null && c.intValue() == 1) {
                imageObj = this.this$0.getImageObj();
                weiboMultiMessage.imageObject = imageObj;
                WeiboShareActivity weiboShareActivity2 = this.this$0;
                bitmap = weiboShareActivity2.shareBmp;
                checkBitmap = weiboShareActivity2.checkBitmap(bitmap);
                if (!checkBitmap) {
                    textObj2 = this.this$0.getTextObj();
                    weiboMultiMessage.textObject = textObj2;
                } else {
                    this.this$0.finish();
                    return wt2.INSTANCE;
                }
            } else if (c != null && c.intValue() == 0) {
                textObj = this.this$0.getTextObj();
                weiboMultiMessage.textObject = textObj;
            }
            IWBAPI c2 = ShareManager.INSTANCE.c();
            if (c2 != null) {
                c2.shareMessage(this.this$0, weiboMultiMessage, false);
            }
            this.this$0.finish();
            return wt2.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
