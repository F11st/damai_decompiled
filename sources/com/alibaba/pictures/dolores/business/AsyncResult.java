package com.alibaba.pictures.dolores.business;

import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamic.property.DAttrConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.dc0;
import tb.ec0;
import tb.hz1;
import tb.jl2;
import tb.mh0;
import tb.rq;
import tb.sw0;
import tb.vi2;
import tb.wi2;
import tb.wt2;
import tb.zf2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\t¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J!\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0002J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0017J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001dJ\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010#J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010&J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010*\u001a\u0004\u0018\u00010)JA\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u000023\u00100\u001a/\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050,j\b\u0012\u0004\u0012\u00028\u0000`/J9\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002+\u00104\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\n\u0018\u00010,j\u0004\u0018\u0001`3JT\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002F\u00109\u001aB\u0012\u0013\u0012\u00110\n¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0005\u0018\u000106j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`8J?\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u000021\u0010<\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u00050,j\b\u0012\u0004\u0012\u00028\u0000`;J9\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002+\u0010?\u001a'\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u00050,j\b\u0012\u0004\u0012\u00028\u0000`>J?\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u000021\u0010C\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u00050,j\b\u0012\u0004\u0012\u00028\u0000`BJ\u001e\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\u0010G\u001a\f\u0012\u0004\u0012\u00020\u00050Ej\u0002`FJ\u0016\u0010I\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003J\u0010\u0010J\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u001f\u0010K\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\bK\u0010\u000eJ\u0014\u0010L\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fJ\u0015\u0010M\u001a\u00020\u00052\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0004\bM\u0010\u0012J\u0014\u0010N\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fJ\u0006\u0010O\u001a\u00020\u0005R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010PR\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010QRG\u00100\u001a3\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010,j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010RR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010SR;\u00104\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\n\u0018\u00010,j\u0004\u0018\u0001`38\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010RR\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010TRV\u00109\u001aB\u0012\u0013\u0012\u00110\n¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0005\u0018\u000106j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`88\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010UR\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010VRE\u0010<\u001a1\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0005\u0018\u00010,j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010RR\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010WR?\u0010?\u001a+\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0005\u0018\u00010,j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010RR\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010XRE\u0010C\u001a1\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u0005\u0018\u00010,j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010RR\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010YR$\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010Ej\u0004\u0018\u0001`F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010ZR*\u0010\\\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR,\u0010c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR,\u0010j\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010i8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR*\u0010q\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010p8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR*\u0010x\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010w8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R/\u0010\u007f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010~8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R4\u0010\u0086\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0085\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001¨\u0006\u008e\u0001"}, d2 = {"Lcom/alibaba/pictures/dolores/business/AsyncResult;", "BizResponse", "Lcom/alibaba/pictures/dolores/business/Result;", "Lcom/alibaba/pictures/dolores/request/DoloresRequest;", "request", "Ltb/wt2;", "onInnerStart", "", "oriResponse", "onInnerReceiveOriResponse", "", "isHit", "response", "onInnerHitCache", "(ZLjava/lang/Object;)V", "Ltb/dc0;", "onInnerSuccessNull", "onInnerSuccess", "(Ljava/lang/Object;)V", "onInnerFail", "onInnerFinish", "dispatchOnOri", "(Ljava/lang/Boolean;)Lcom/alibaba/pictures/dolores/business/AsyncResult;", "Lcom/alibaba/pictures/dolores/business/StartAction;", "startAction", "doOnStart", "Lcom/alibaba/pictures/dolores/business/OriReceiveAction;", "oriReceiveAction", "doOnReceiveOri", "Lcom/alibaba/pictures/dolores/business/HitCacheAction;", "hitCacheAction", "doOnHitCache", "Lcom/alibaba/pictures/dolores/business/SuccessNullAction;", "successNullAction", "doOnSuccessNull", "Lcom/alibaba/pictures/dolores/business/SuccessAction;", "successAction", "doOnSuccess", "Lcom/alibaba/pictures/dolores/business/FailAction;", "failAction", "doOnFail", "Lcom/alibaba/pictures/dolores/business/FinishAction;", "finishAction", "doOnFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lcom/alibaba/pictures/dolores/business/StartFuc;", "startFuc", "doOnKTStart", "mtopResponse", "Lcom/alibaba/pictures/dolores/business/OriReceiveFuc;", "oriReceiveFuc", "doOnKTReceiveOri", "Lkotlin/Function2;", "bizResponse", "Lcom/alibaba/pictures/dolores/business/HitCacheFuc;", "hitCacheFuc", "doOnKTHitCache", "Lcom/alibaba/pictures/dolores/business/SuccessNullFuc;", "successNullFuc", "doOnKTSuccessNull", "Lcom/alibaba/pictures/dolores/business/SuccessFuc;", "successFuc", "doOnKTSuccess", "failResponse", "Lcom/alibaba/pictures/dolores/business/FailFuc;", "failFuc", "doOnKTFail", "Lkotlin/Function0;", "Lcom/alibaba/pictures/dolores/business/FinishFuc;", "finishFuc", "doOnKTFinish", "onStart", "onReceiveOriResponse", "onHitCache", "onSuccessNull", "onSuccess", "onFail", DAttrConstant.VIEW_EVENT_FINISH, "Ljava/lang/Boolean;", "Lcom/alibaba/pictures/dolores/business/StartAction;", "Lkotlin/jvm/functions/Function1;", "Lcom/alibaba/pictures/dolores/business/OriReceiveAction;", "Lcom/alibaba/pictures/dolores/business/HitCacheAction;", "Lkotlin/jvm/functions/Function2;", "Lcom/alibaba/pictures/dolores/business/SuccessNullAction;", "Lcom/alibaba/pictures/dolores/business/SuccessAction;", "Lcom/alibaba/pictures/dolores/business/FailAction;", "Lcom/alibaba/pictures/dolores/business/FinishAction;", "Lkotlin/jvm/functions/Function0;", "Ltb/zf2;", "startEvent", "Ltb/zf2;", "getStartEvent", "()Ltb/zf2;", "setStartEvent", "(Ltb/zf2;)V", "Ltb/hz1;", "receiveOriResponseEvent", "Ltb/hz1;", "getReceiveOriResponseEvent", "()Ltb/hz1;", "setReceiveOriResponseEvent", "(Ltb/hz1;)V", "Ltb/sw0;", "hitCacheEvent", "Ltb/sw0;", "getHitCacheEvent", "()Ltb/sw0;", "setHitCacheEvent", "(Ltb/sw0;)V", "Ltb/wi2;", "successNullEvent", "Ltb/wi2;", "getSuccessNullEvent", "()Ltb/wi2;", "setSuccessNullEvent", "(Ltb/wi2;)V", "Ltb/vi2;", "successEvent", "Ltb/vi2;", "getSuccessEvent", "()Ltb/vi2;", "setSuccessEvent", "(Ltb/vi2;)V", "Ltb/mh0;", "failEvent", "Ltb/mh0;", "getFailEvent", "()Ltb/mh0;", "setFailEvent", "(Ltb/mh0;)V", "Ltb/jl2;", "taskFinishEvent", "Ltb/jl2;", "getTaskFinishEvent", "()Ltb/jl2;", "setTaskFinishEvent", "(Ltb/jl2;)V", "<init>", "()V", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class AsyncResult<BizResponse> extends Result<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Boolean dispatchOnOri = Boolean.FALSE;
    private FailAction<BizResponse> failAction;
    @Nullable
    private mh0<BizResponse> failEvent;
    private Function1<? super dc0<BizResponse>, wt2> failFuc;
    private FinishAction finishAction;
    private Function0<wt2> finishFuc;
    private HitCacheAction<BizResponse> hitCacheAction;
    @Nullable
    private sw0<BizResponse> hitCacheEvent;
    private Function2<? super Boolean, ? super BizResponse, wt2> hitCacheFuc;
    private OriReceiveAction oriReceiveAction;
    private Function1<Object, Boolean> oriReceiveFuc;
    @Nullable
    private hz1<Object> receiveOriResponseEvent;
    private StartAction<BizResponse> startAction;
    @Nullable
    private zf2<BizResponse> startEvent;
    private Function1<? super DoloresRequest<BizResponse>, wt2> startFuc;
    private SuccessAction<BizResponse> successAction;
    @Nullable
    private vi2<BizResponse> successEvent;
    private Function1<? super BizResponse, wt2> successFuc;
    private SuccessNullAction<BizResponse> successNullAction;
    @Nullable
    private wi2<BizResponse> successNullEvent;
    private Function1<? super dc0<BizResponse>, wt2> successNullFuc;
    @Nullable
    private jl2<Object> taskFinishEvent;

    public static /* synthetic */ AsyncResult dispatchOnOri$default(AsyncResult asyncResult, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = Boolean.TRUE;
        }
        return asyncResult.dispatchOnOri(bool);
    }

    public final void onInnerFail(dc0<BizResponse> dc0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-215368562")) {
            ipChange.ipc$dispatch("-215368562", new Object[]{this, dc0Var});
            return;
        }
        Function1<? super dc0<BizResponse>, wt2> function1 = this.failFuc;
        if (function1 == null && this.failAction == null) {
            this.failEvent = new mh0<>(dc0Var);
            return;
        }
        if (function1 != null) {
            function1.invoke(dc0Var);
        }
        FailAction<BizResponse> failAction = this.failAction;
        if (failAction != null) {
            failAction.onFail(dc0Var);
        }
    }

    public final void onInnerFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "220764227")) {
            ipChange.ipc$dispatch("220764227", new Object[]{this});
            return;
        }
        Function0<wt2> function0 = this.finishFuc;
        if (function0 == null && this.finishAction == null) {
            this.taskFinishEvent = new jl2<>(null);
            return;
        }
        if (function0 != null) {
            function0.invoke();
        }
        FinishAction finishAction = this.finishAction;
        if (finishAction != null) {
            finishAction.onFinish();
        }
    }

    public final void onInnerHitCache(boolean z, BizResponse bizresponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1355969257")) {
            ipChange.ipc$dispatch("1355969257", new Object[]{this, Boolean.valueOf(z), bizresponse});
            return;
        }
        Function2<? super Boolean, ? super BizResponse, wt2> function2 = this.hitCacheFuc;
        if (function2 == null && this.hitCacheAction == null) {
            sw0<BizResponse> sw0Var = new sw0<>(bizresponse);
            sw0Var.c(Boolean.valueOf(z));
            wt2 wt2Var = wt2.INSTANCE;
            this.hitCacheEvent = sw0Var;
            return;
        }
        if (function2 != null) {
            function2.invoke(Boolean.valueOf(z), bizresponse);
        }
        HitCacheAction<BizResponse> hitCacheAction = this.hitCacheAction;
        if (hitCacheAction != null) {
            hitCacheAction.onHitCache(z, bizresponse);
        }
    }

    public final void onInnerReceiveOriResponse(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-969952594")) {
            ipChange.ipc$dispatch("-969952594", new Object[]{this, obj});
            return;
        }
        Function1<Object, Boolean> function1 = this.oriReceiveFuc;
        if (function1 == null && this.oriReceiveAction == null) {
            this.receiveOriResponseEvent = new hz1<>(obj);
            return;
        }
        if (function1 != null) {
            function1.invoke(obj);
        }
        OriReceiveAction oriReceiveAction = this.oriReceiveAction;
        if (oriReceiveAction != null) {
            oriReceiveAction.onReceiveOriRes(obj);
        }
    }

    public final void onInnerStart(DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "857071868")) {
            ipChange.ipc$dispatch("857071868", new Object[]{this, doloresRequest});
            return;
        }
        Function1<? super DoloresRequest<BizResponse>, wt2> function1 = this.startFuc;
        if (function1 == null && this.startAction == null) {
            this.startEvent = new zf2<>(doloresRequest);
            return;
        }
        if (function1 != null) {
            function1.invoke(doloresRequest);
        }
        StartAction<BizResponse> startAction = this.startAction;
        if (startAction != null) {
            startAction.onRequestStart(doloresRequest);
        }
    }

    public final void onInnerSuccess(BizResponse bizresponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "521920525")) {
            ipChange.ipc$dispatch("521920525", new Object[]{this, bizresponse});
            return;
        }
        Function1<? super BizResponse, wt2> function1 = this.successFuc;
        if (function1 == null && this.successAction == null) {
            this.successEvent = new vi2<>(bizresponse);
            return;
        }
        if (function1 != null) {
            function1.invoke(bizresponse);
        }
        SuccessAction<BizResponse> successAction = this.successAction;
        if (successAction != null) {
            successAction.onSuccess(bizresponse);
        }
    }

    public final void onInnerSuccessNull(dc0<BizResponse> dc0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-488946436")) {
            ipChange.ipc$dispatch("-488946436", new Object[]{this, dc0Var});
            return;
        }
        rq.a("AsyncResult", "onSuccess-dispatchOnOri=" + this.dispatchOnOri);
        Function1<? super dc0<BizResponse>, wt2> function1 = this.successNullFuc;
        if (function1 == null && this.successNullAction == null) {
            this.successNullEvent = new wi2<>(dc0Var);
            return;
        }
        if (function1 != null) {
            function1.invoke(dc0Var);
        }
        SuccessNullAction<BizResponse> successNullAction = this.successNullAction;
        if (successNullAction != null) {
            successNullAction.onSuccess(dc0Var);
        }
    }

    @NotNull
    public final AsyncResult<BizResponse> dispatchOnOri(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "43187998")) {
            return (AsyncResult) ipChange.ipc$dispatch("43187998", new Object[]{this, bool});
        }
        this.dispatchOnOri = bool;
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnFail(@Nullable FailAction<BizResponse> failAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-998515480")) {
            return (AsyncResult) ipChange.ipc$dispatch("-998515480", new Object[]{this, failAction});
        }
        rq.a("AsyncResult", "doOnFail");
        this.failAction = failAction;
        mh0<BizResponse> mh0Var = this.failEvent;
        if (mh0Var != null) {
            if (failAction != null) {
                b41.f(mh0Var);
                failAction.onFail(mh0Var.a());
            }
            this.failEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnFinish(@Nullable FinishAction finishAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-144226242")) {
            return (AsyncResult) ipChange.ipc$dispatch("-144226242", new Object[]{this, finishAction});
        }
        rq.a("AsyncResult", "doOnFinish");
        this.finishAction = finishAction;
        if (this.taskFinishEvent != null) {
            if (finishAction != null) {
                finishAction.onFinish();
            }
            this.taskFinishEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnHitCache(@Nullable HitCacheAction<BizResponse> hitCacheAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "508447750")) {
            return (AsyncResult) ipChange.ipc$dispatch("508447750", new Object[]{this, hitCacheAction});
        }
        rq.a("AsyncResult", "doOnHitCache");
        this.hitCacheAction = hitCacheAction;
        sw0<BizResponse> sw0Var = this.hitCacheEvent;
        if (sw0Var != null) {
            if (hitCacheAction != null) {
                b41.f(sw0Var);
                boolean d = b41.d(sw0Var.b(), Boolean.TRUE);
                sw0<BizResponse> sw0Var2 = this.hitCacheEvent;
                b41.f(sw0Var2);
                hitCacheAction.onHitCache(d, sw0Var2.a());
            }
            this.hitCacheEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnKTFail(@NotNull Function1<? super dc0<BizResponse>, wt2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "841902819")) {
            return (AsyncResult) ipChange.ipc$dispatch("841902819", new Object[]{this, function1});
        }
        b41.i(function1, "failFuc");
        rq.a("AsyncResult", "doOnKTFail");
        this.failFuc = function1;
        mh0<BizResponse> mh0Var = this.failEvent;
        if (mh0Var != null) {
            if (function1 != null) {
                b41.f(mh0Var);
                function1.invoke(mh0Var.a());
            }
            this.failEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnKTFinish(@NotNull Function0<wt2> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1500788561")) {
            return (AsyncResult) ipChange.ipc$dispatch("-1500788561", new Object[]{this, function0});
        }
        b41.i(function0, "finishFuc");
        rq.a("AsyncResult", "doOnKTFinish");
        this.finishFuc = function0;
        if (this.taskFinishEvent != null) {
            if (function0 != null) {
                function0.invoke();
            }
            this.taskFinishEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnKTHitCache(@Nullable Function2<? super Boolean, ? super BizResponse, wt2> function2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-865445103")) {
            return (AsyncResult) ipChange.ipc$dispatch("-865445103", new Object[]{this, function2});
        }
        rq.a("AsyncResult", "doOnKTHitCache");
        this.hitCacheFuc = function2;
        sw0<BizResponse> sw0Var = this.hitCacheEvent;
        if (sw0Var != null) {
            if (function2 != null) {
                b41.f(sw0Var);
                Boolean valueOf = Boolean.valueOf(b41.d(sw0Var.b(), Boolean.TRUE));
                sw0<BizResponse> sw0Var2 = this.hitCacheEvent;
                b41.f(sw0Var2);
                function2.invoke(valueOf, (BizResponse) sw0Var2.a());
            }
            this.hitCacheEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnKTReceiveOri(@Nullable Function1<Object, Boolean> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951124898")) {
            return (AsyncResult) ipChange.ipc$dispatch("-1951124898", new Object[]{this, function1});
        }
        rq.a("AsyncResult", "doOnKTReceiveOri");
        this.oriReceiveFuc = function1;
        hz1<Object> hz1Var = this.receiveOriResponseEvent;
        if (hz1Var != null) {
            if (function1 != null) {
                b41.f(hz1Var);
                function1.invoke(hz1Var.a());
            }
            this.receiveOriResponseEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnKTStart(@NotNull Function1<? super DoloresRequest<BizResponse>, wt2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-98144235")) {
            return (AsyncResult) ipChange.ipc$dispatch("-98144235", new Object[]{this, function1});
        }
        b41.i(function1, "startFuc");
        rq.a("AsyncResult", "doOnKTStart");
        this.startFuc = function1;
        zf2<BizResponse> zf2Var = this.startEvent;
        if (zf2Var != null) {
            if (function1 != null) {
                b41.f(zf2Var);
                function1.invoke(zf2Var.a());
            }
            this.startEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnKTSuccess(@NotNull Function1<? super BizResponse, wt2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "239440980")) {
            return (AsyncResult) ipChange.ipc$dispatch("239440980", new Object[]{this, function1});
        }
        b41.i(function1, "successFuc");
        rq.a("AsyncResult", "doOnKTSuccess");
        this.successFuc = function1;
        vi2<BizResponse> vi2Var = this.successEvent;
        if (vi2Var != null) {
            if (function1 != null) {
                b41.f(vi2Var);
                function1.invoke((BizResponse) vi2Var.a());
            }
            this.successEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnKTSuccessNull(@NotNull Function1<? super dc0<BizResponse>, wt2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-529597171")) {
            return (AsyncResult) ipChange.ipc$dispatch("-529597171", new Object[]{this, function1});
        }
        b41.i(function1, "successNullFuc");
        rq.a("AsyncResult", "doOnKTSuccessNull");
        this.successNullFuc = function1;
        wi2<BizResponse> wi2Var = this.successNullEvent;
        if (wi2Var != null) {
            if (function1 != null) {
                b41.f(wi2Var);
                function1.invoke(wi2Var.a());
            }
            this.successNullEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnReceiveOri(@Nullable OriReceiveAction oriReceiveAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-423747324")) {
            return (AsyncResult) ipChange.ipc$dispatch("-423747324", new Object[]{this, oriReceiveAction});
        }
        rq.a("AsyncResult", "doOnReceiveOri");
        this.oriReceiveAction = oriReceiveAction;
        hz1<Object> hz1Var = this.receiveOriResponseEvent;
        if (hz1Var != null) {
            if (oriReceiveAction != null) {
                b41.f(hz1Var);
                oriReceiveAction.onReceiveOriRes(hz1Var.a());
            }
            this.receiveOriResponseEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnStart(@Nullable StartAction<BizResponse> startAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "870163070")) {
            return (AsyncResult) ipChange.ipc$dispatch("870163070", new Object[]{this, startAction});
        }
        rq.a("AsyncResult", "doOnStart");
        this.startAction = startAction;
        zf2<BizResponse> zf2Var = this.startEvent;
        if (zf2Var != null) {
            if (startAction != null) {
                b41.f(zf2Var);
                startAction.onRequestStart(zf2Var.a());
            }
            this.startEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnSuccess(@Nullable SuccessAction<BizResponse> successAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-535368226")) {
            return (AsyncResult) ipChange.ipc$dispatch("-535368226", new Object[]{this, successAction});
        }
        rq.a("AsyncResult", "doOnSuccess");
        this.successAction = successAction;
        vi2<BizResponse> vi2Var = this.successEvent;
        if (vi2Var != null) {
            if (successAction != null) {
                b41.f(vi2Var);
                successAction.onSuccess(vi2Var.a());
            }
            this.successEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnSuccessNull(@NotNull SuccessNullAction<BizResponse> successNullAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "665585470")) {
            return (AsyncResult) ipChange.ipc$dispatch("665585470", new Object[]{this, successNullAction});
        }
        b41.i(successNullAction, "successNullAction");
        rq.a("AsyncResult", "doOnSuccessNull");
        this.successNullAction = successNullAction;
        wi2<BizResponse> wi2Var = this.successNullEvent;
        if (wi2Var != null) {
            if (successNullAction != null) {
                b41.f(wi2Var);
                successNullAction.onSuccess(wi2Var.a());
            }
            this.successNullEvent = null;
        }
        return this;
    }

    @Nullable
    public final mh0<BizResponse> getFailEvent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2098543173") ? (mh0) ipChange.ipc$dispatch("2098543173", new Object[]{this}) : this.failEvent;
    }

    @Nullable
    public final sw0<BizResponse> getHitCacheEvent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1725203371") ? (sw0) ipChange.ipc$dispatch("-1725203371", new Object[]{this}) : this.hitCacheEvent;
    }

    @Nullable
    public final hz1<Object> getReceiveOriResponseEvent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1337424081") ? (hz1) ipChange.ipc$dispatch("1337424081", new Object[]{this}) : this.receiveOriResponseEvent;
    }

    @Nullable
    public final zf2<BizResponse> getStartEvent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "834305653") ? (zf2) ipChange.ipc$dispatch("834305653", new Object[]{this}) : this.startEvent;
    }

    @Nullable
    public final vi2<BizResponse> getSuccessEvent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1261955819") ? (vi2) ipChange.ipc$dispatch("-1261955819", new Object[]{this}) : this.successEvent;
    }

    @Nullable
    public final wi2<BizResponse> getSuccessNullEvent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1990716555") ? (wi2) ipChange.ipc$dispatch("-1990716555", new Object[]{this}) : this.successNullEvent;
    }

    @Nullable
    public final jl2<Object> getTaskFinishEvent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-907595527") ? (jl2) ipChange.ipc$dispatch("-907595527", new Object[]{this}) : this.taskFinishEvent;
    }

    public final void onFail(@NotNull final dc0<BizResponse> dc0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2128889382")) {
            ipChange.ipc$dispatch("2128889382", new Object[]{this, dc0Var});
            return;
        }
        b41.i(dc0Var, "response");
        rq.a("AsyncResult", "onFail-dispatchOnOri=" + this.dispatchOnOri);
        if (b41.d(this.dispatchOnOri, Boolean.TRUE)) {
            onInnerFail(dc0Var);
        } else {
            ec0.INSTANCE.a(new Runnable() { // from class: com.alibaba.pictures.dolores.business.AsyncResult$onFail$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public final void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1789693604")) {
                        ipChange2.ipc$dispatch("-1789693604", new Object[]{this});
                    } else {
                        AsyncResult.this.onInnerFail(dc0Var);
                    }
                }
            });
        }
    }

    public final void onFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1273503829")) {
            ipChange.ipc$dispatch("-1273503829", new Object[]{this});
            return;
        }
        rq.a("AsyncResult", "onFinish-dispatchOnOri=" + this.dispatchOnOri);
        if (b41.d(this.dispatchOnOri, Boolean.TRUE)) {
            onInnerFinish();
        } else {
            ec0.INSTANCE.a(new Runnable() { // from class: com.alibaba.pictures.dolores.business.AsyncResult$onFinish$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public final void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1508407431")) {
                        ipChange2.ipc$dispatch("1508407431", new Object[]{this});
                    } else {
                        AsyncResult.this.onInnerFinish();
                    }
                }
            });
        }
    }

    public final void onHitCache(final boolean z, @Nullable final BizResponse bizresponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1650023553")) {
            ipChange.ipc$dispatch("1650023553", new Object[]{this, Boolean.valueOf(z), bizresponse});
            return;
        }
        rq.a("AsyncResult", "onHitCache-dispatchOnOri=" + this.dispatchOnOri);
        if (b41.d(this.dispatchOnOri, Boolean.TRUE)) {
            onInnerHitCache(z, bizresponse);
        } else {
            ec0.INSTANCE.a(new Runnable() { // from class: com.alibaba.pictures.dolores.business.AsyncResult$onHitCache$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public final void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "390734763")) {
                        ipChange2.ipc$dispatch("390734763", new Object[]{this});
                    } else {
                        AsyncResult.this.onInnerHitCache(z, bizresponse);
                    }
                }
            });
        }
    }

    public final void onReceiveOriResponse(@Nullable final Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-285600746")) {
            ipChange.ipc$dispatch("-285600746", new Object[]{this, obj});
            return;
        }
        rq.a("AsyncResult", "onReceiveOriResponse-dispatchOnOri=" + this.dispatchOnOri);
        if (b41.d(this.dispatchOnOri, Boolean.TRUE)) {
            onInnerReceiveOriResponse(obj);
        } else {
            ec0.INSTANCE.a(new Runnable() { // from class: com.alibaba.pictures.dolores.business.AsyncResult$onReceiveOriResponse$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public final void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1582338922")) {
                        ipChange2.ipc$dispatch("-1582338922", new Object[]{this});
                    } else {
                        AsyncResult.this.onInnerReceiveOriResponse(obj);
                    }
                }
            });
        }
    }

    public final void onStart(@Nullable final DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "932693092")) {
            ipChange.ipc$dispatch("932693092", new Object[]{this, doloresRequest});
            return;
        }
        rq.a("AsyncResult", "onStart-dispatchOnOri=" + this.dispatchOnOri);
        if (b41.d(this.dispatchOnOri, Boolean.TRUE)) {
            onInnerStart(doloresRequest);
        } else {
            ec0.INSTANCE.a(new Runnable() { // from class: com.alibaba.pictures.dolores.business.AsyncResult$onStart$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public final void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2086788054")) {
                        ipChange2.ipc$dispatch("2086788054", new Object[]{this});
                    } else {
                        AsyncResult.this.onInnerStart(doloresRequest);
                    }
                }
            });
        }
    }

    public final void onSuccess(final BizResponse bizresponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-671068251")) {
            ipChange.ipc$dispatch("-671068251", new Object[]{this, bizresponse});
            return;
        }
        rq.a("AsyncResult", "onSuccess-dispatchOnOri=" + this.dispatchOnOri);
        if (b41.d(this.dispatchOnOri, Boolean.TRUE)) {
            onInnerSuccess(bizresponse);
        } else {
            ec0.INSTANCE.a(new Runnable() { // from class: com.alibaba.pictures.dolores.business.AsyncResult$onSuccess$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public final void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2002596309")) {
                        ipChange2.ipc$dispatch("2002596309", new Object[]{this});
                    } else {
                        AsyncResult.this.onInnerSuccess(bizresponse);
                    }
                }
            });
        }
    }

    public final boolean onSuccessNull(@NotNull final dc0<BizResponse> dc0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1063829400")) {
            return ((Boolean) ipChange.ipc$dispatch("-1063829400", new Object[]{this, dc0Var})).booleanValue();
        }
        b41.i(dc0Var, "response");
        rq.a("AsyncResult", "onSuccess-dispatchOnOri=" + this.dispatchOnOri);
        if (this.successNullFuc == null && this.successNullAction == null) {
            return false;
        }
        if (b41.d(this.dispatchOnOri, Boolean.TRUE)) {
            onInnerSuccessNull(dc0Var);
        } else {
            ec0.INSTANCE.a(new Runnable() { // from class: com.alibaba.pictures.dolores.business.AsyncResult$onSuccessNull$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public final void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1954550734")) {
                        ipChange2.ipc$dispatch("1954550734", new Object[]{this});
                    } else {
                        AsyncResult.this.onInnerSuccessNull(dc0Var);
                    }
                }
            });
        }
        return true;
    }

    public final void setFailEvent(@Nullable mh0<BizResponse> mh0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1386909627")) {
            ipChange.ipc$dispatch("1386909627", new Object[]{this, mh0Var});
        } else {
            this.failEvent = mh0Var;
        }
    }

    public final void setHitCacheEvent(@Nullable sw0<BizResponse> sw0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-790221093")) {
            ipChange.ipc$dispatch("-790221093", new Object[]{this, sw0Var});
        } else {
            this.hitCacheEvent = sw0Var;
        }
    }

    public final void setReceiveOriResponseEvent(@Nullable hz1<Object> hz1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-271166917")) {
            ipChange.ipc$dispatch("-271166917", new Object[]{this, hz1Var});
        } else {
            this.receiveOriResponseEvent = hz1Var;
        }
    }

    public final void setStartEvent(@Nullable zf2<BizResponse> zf2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "88918961")) {
            ipChange.ipc$dispatch("88918961", new Object[]{this, zf2Var});
        } else {
            this.startEvent = zf2Var;
        }
    }

    public final void setSuccessEvent(@Nullable vi2<BizResponse> vi2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1489235789")) {
            ipChange.ipc$dispatch("-1489235789", new Object[]{this, vi2Var});
        } else {
            this.successEvent = vi2Var;
        }
    }

    public final void setSuccessNullEvent(@Nullable wi2<BizResponse> wi2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1516833279")) {
            ipChange.ipc$dispatch("-1516833279", new Object[]{this, wi2Var});
        } else {
            this.successNullEvent = wi2Var;
        }
    }

    public final void setTaskFinishEvent(@Nullable jl2<Object> jl2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "198769339")) {
            ipChange.ipc$dispatch("198769339", new Object[]{this, jl2Var});
        } else {
            this.taskFinishEvent = jl2Var;
        }
    }
}
