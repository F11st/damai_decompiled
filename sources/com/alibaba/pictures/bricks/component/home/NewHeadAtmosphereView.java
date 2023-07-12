package com.alibaba.pictures.bricks.component.home;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.HeadAtmosphereBean;
import com.alibaba.pictures.bricks.component.home.NewHeadAtmosphereContract;
import com.alibaba.pictures.bricks.component.home.NewHeadAtmosphereView;
import com.alibaba.pictures.bricks.view.SafeLottieAnimationView;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.r8;
import tb.s8;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class NewHeadAtmosphereView extends AbsView<GenericItem<ItemValue>, NewHeadAtmosphereModel, NewHeadAtmospherePresent> implements NewHeadAtmosphereContract.View, View.OnAttachStateChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isHasClickArea;
    @NotNull
    private final View itemView;
    @Nullable
    private Activity mActivity;
    private View mClickView;
    @Nullable
    private HeadAtmosphereBean mCurBean;
    @Nullable
    private State mCurState;
    @Nullable
    private EventBus mEventBus;
    private View mHeadLayout;
    private ImageView mImgView;
    @Nullable
    private Boolean mIsLargeScreen;
    private final int mLayoutRid;
    private SafeLottieAnimationView mLottieView;
    @Nullable
    private RecyclerView mRecyclerView;
    @NotNull
    private final NewHeadAtmosphereView$mScrollListener$1 mScrollListener;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.home.NewHeadAtmosphereView$a */
    /* loaded from: classes7.dex */
    public /* synthetic */ class C3461a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.LOTTIE_SUCCESS.ordinal()] = 1;
            iArr[State.PIC_SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.alibaba.pictures.bricks.component.home.NewHeadAtmosphereView$mScrollListener$1] */
    public NewHeadAtmosphereView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        this.mLayoutRid = R$layout.bricks_new_component_head_atmosphere;
        this.mLottieView = (SafeLottieAnimationView) view.findViewById(R$id.bricks_head_atmosphere_lottie);
        this.mImgView = (ImageView) view.findViewById(R$id.bricks_head_atmosphere_pic);
        this.mClickView = view.findViewById(R$id.bricks_head_atmosphere_click_area);
        this.mHeadLayout = view.findViewById(R$id.bricks_head_layout);
        SafeLottieAnimationView safeLottieAnimationView = this.mLottieView;
        safeLottieAnimationView.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() { // from class: tb.ck1
            @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
            public final void onCompositionLoaded(C2821a c2821a) {
                NewHeadAtmosphereView.m126lambda4$lambda0(NewHeadAtmosphereView.this, c2821a);
            }
        });
        safeLottieAnimationView.setFailureListener(new LottieListener() { // from class: tb.bk1
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                NewHeadAtmosphereView.m127lambda4$lambda2(NewHeadAtmosphereView.this, (Throwable) obj);
            }
        });
        safeLottieAnimationView.setDrawFailListener(new SafeLottieAnimationView.OnLottieDrawFailListener() { // from class: tb.dk1
            @Override // com.alibaba.pictures.bricks.view.SafeLottieAnimationView.OnLottieDrawFailListener
            public final void onDrawLottieFail(Throwable th, int i) {
                NewHeadAtmosphereView.m128lambda4$lambda3(NewHeadAtmosphereView.this, th, i);
            }
        });
        view.addOnAttachStateChangeListener(this);
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.alibaba.pictures.bricks.component.home.NewHeadAtmosphereView$mScrollListener$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1901684790")) {
                    ipChange.ipc$dispatch("1901684790", new Object[]{this, recyclerView, Integer.valueOf(i)});
                    return;
                }
                b41.i(recyclerView, "recyclerView");
                NewHeadAtmosphereView.this.scrollChanged(recyclerView, i);
            }
        };
    }

    private final void dispatchStateEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2003043937")) {
            ipChange.ipc$dispatch("-2003043937", new Object[]{this});
            return;
        }
        EventBus eventBus = this.mEventBus;
        if (eventBus != null) {
            Event event = new Event(r8.KEY_EVENT_ATMOSPHERE_STATE);
            event.data = new StateAtmo(this.mCurState, this.mCurBean);
            eventBus.post(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-4$lambda-0  reason: not valid java name */
    public static final void m126lambda4$lambda0(NewHeadAtmosphereView newHeadAtmosphereView, C2821a c2821a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "414205287")) {
            ipChange.ipc$dispatch("414205287", new Object[]{newHeadAtmosphereView, c2821a});
            return;
        }
        b41.i(newHeadAtmosphereView, "this$0");
        newHeadAtmosphereView.showViewHeight(State.LOTTIE_SUCCESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-4$lambda-2  reason: not valid java name */
    public static final void m127lambda4$lambda2(NewHeadAtmosphereView newHeadAtmosphereView, Throwable th) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1995368531")) {
            ipChange.ipc$dispatch("-1995368531", new Object[]{newHeadAtmosphereView, th});
            return;
        }
        b41.i(newHeadAtmosphereView, "this$0");
        th.printStackTrace();
        r8 r8Var = r8.INSTANCE;
        HeadAtmosphereBean headAtmosphereBean = newHeadAtmosphereView.mCurBean;
        r8Var.f(headAtmosphereBean, "2", "Atmosphere Fail setAnimationFromUrl :" + th.getMessage());
        newHeadAtmosphereView.showViewHeight(State.INIT);
        HeadAtmosphereBean headAtmosphereBean2 = newHeadAtmosphereView.mCurBean;
        if (headAtmosphereBean2 == null || (str = headAtmosphereBean2.backgroundPic) == null) {
            return;
        }
        newHeadAtmosphereView.loadStaticPicAtmosphere(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-4$lambda-3  reason: not valid java name */
    public static final void m128lambda4$lambda3(NewHeadAtmosphereView newHeadAtmosphereView, Throwable th, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741103019")) {
            ipChange.ipc$dispatch("-1741103019", new Object[]{newHeadAtmosphereView, th, Integer.valueOf(i)});
            return;
        }
        b41.i(newHeadAtmosphereView, "this$0");
        if (i < 4) {
            th.printStackTrace();
            r8 r8Var = r8.INSTANCE;
            HeadAtmosphereBean headAtmosphereBean = newHeadAtmosphereView.mCurBean;
            r8Var.f(headAtmosphereBean, "1", "Atmosphere Fail Lottie onDraw :" + th.getMessage());
        }
    }

    private final void loadStaticPicAtmosphere(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1461275398")) {
            ipChange.ipc$dispatch("-1461275398", new Object[]{this, str});
        } else {
            ImageLoaderProviderProxy.load(str, new IImageSuccListener() { // from class: tb.fk1
                @Override // com.alient.oneservice.image.IImageSuccListener
                public final void onSuccess(SuccessEvent successEvent) {
                    NewHeadAtmosphereView.m129loadStaticPicAtmosphere$lambda7(NewHeadAtmosphereView.this, successEvent);
                }
            }, new IImageFailListener() { // from class: tb.ek1
                @Override // com.alient.oneservice.image.IImageFailListener
                public final void onFail(FailEvent failEvent) {
                    NewHeadAtmosphereView.m130loadStaticPicAtmosphere$lambda8(NewHeadAtmosphereView.this, failEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadStaticPicAtmosphere$lambda-7  reason: not valid java name */
    public static final void m129loadStaticPicAtmosphere$lambda7(NewHeadAtmosphereView newHeadAtmosphereView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1548878719")) {
            ipChange.ipc$dispatch("1548878719", new Object[]{newHeadAtmosphereView, successEvent});
            return;
        }
        b41.i(newHeadAtmosphereView, "this$0");
        Drawable drawable = successEvent.drawable;
        if (drawable != null) {
            newHeadAtmosphereView.mImgView.setImageDrawable(drawable);
            newHeadAtmosphereView.showViewHeight(State.PIC_SUCCESS);
            return;
        }
        newHeadAtmosphereView.showViewHeight(State.INIT);
        r8.INSTANCE.f(newHeadAtmosphereView.mCurBean, "3", "Atmosphere Fail pic load none drawable");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadStaticPicAtmosphere$lambda-8  reason: not valid java name */
    public static final void m130loadStaticPicAtmosphere$lambda8(NewHeadAtmosphereView newHeadAtmosphereView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1832996863")) {
            ipChange.ipc$dispatch("1832996863", new Object[]{newHeadAtmosphereView, failEvent});
            return;
        }
        b41.i(newHeadAtmosphereView, "this$0");
        newHeadAtmosphereView.showViewHeight(State.INIT);
        r8 r8Var = r8.INSTANCE;
        HeadAtmosphereBean headAtmosphereBean = newHeadAtmosphereView.mCurBean;
        r8Var.f(headAtmosphereBean, "3", "Atmosphere Fail pic load code=: " + failEvent.resultCode);
    }

    private final void showViewHeight(State state) {
        int b;
        int c;
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "-665378479")) {
            ipChange.ipc$dispatch("-665378479", new Object[]{this, state});
            return;
        }
        this.mCurState = state;
        dispatchStateEvent();
        int i2 = C3461a.$EnumSwitchMapping$0[state.ordinal()];
        if (i2 == 1) {
            this.mLottieView.setVisibility(0);
            this.mImgView.setVisibility(8);
        } else if (i2 != 2) {
            this.mLottieView.setVisibility(8);
            this.mImgView.setVisibility(8);
        } else {
            this.mLottieView.setVisibility(8);
            this.mImgView.setVisibility(0);
        }
        Activity activity = this.mActivity;
        if (activity != null) {
            s8 a = r8.INSTANCE.a(activity);
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            if (layoutParams != null) {
                b41.h(layoutParams, "layoutParams");
                int i3 = layoutParams.height;
                if (state == State.INIT) {
                    if (this.isHasClickArea) {
                        i = a.b();
                    } else {
                        b = a.b();
                        c = a.c();
                        i = b + c;
                    }
                } else if (state == State.LOTTIE_SUCCESS || state == State.PIC_SUCCESS) {
                    b = a.b();
                    c = a.c();
                    i = b + c;
                }
                int a2 = (a.a() - a.d()) - i;
                double c2 = a.c() * 0.2d;
                if (a2 < 0 && Math.abs(a2) <= c2) {
                    this.mHeadLayout.scrollTo(0, -a2);
                } else {
                    this.mHeadLayout.scrollTo(0, 0);
                }
                if (i3 != i) {
                    layoutParams.height = i;
                    this.itemView.requestLayout();
                }
            }
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.NewHeadAtmosphereContract.View
    public void bindView(@Nullable RecyclerView recyclerView, boolean z, @NotNull Activity activity, @Nullable EventBus eventBus, @Nullable HeadAtmosphereBean headAtmosphereBean) {
        State state;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2000485353")) {
            ipChange.ipc$dispatch("2000485353", new Object[]{this, recyclerView, Boolean.valueOf(z), activity, eventBus, headAtmosphereBean});
            return;
        }
        b41.i(activity, "activity");
        Boolean bool = this.mIsLargeScreen;
        this.mIsLargeScreen = Boolean.valueOf(z);
        this.mActivity = activity;
        this.mEventBus = eventBus;
        this.mRecyclerView = recyclerView;
        r8.INSTANCE.e(this.itemView);
        if (headAtmosphereBean != null && headAtmosphereBean.isValid()) {
            if (State.Companion.a(this.mCurState) && b41.d(headAtmosphereBean, this.mCurBean)) {
                this.mCurBean = headAtmosphereBean;
                if (!b41.d(Boolean.valueOf(z), bool) && (state = this.mCurState) != null) {
                    showViewHeight(state);
                }
                dispatchStateEvent();
                return;
            }
            this.mCurBean = headAtmosphereBean;
            this.isHasClickArea = headAtmosphereBean.isShowPlaceholderHeight();
            showViewHeight(State.INIT);
            if (headAtmosphereBean.isLottieAtmosphere()) {
                this.mLottieView.setAnimationFromUrl(headAtmosphereBean.lottie);
                return;
            } else if (headAtmosphereBean.isPicAtmosphere()) {
                loadStaticPicAtmosphere(headAtmosphereBean.backgroundPic);
                return;
            } else {
                return;
            }
        }
        showViewHeight(State.INVALID);
        this.mCurBean = null;
        dispatchStateEvent();
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1904272284") ? (View) ipChange.ipc$dispatch("1904272284", new Object[]{this}) : this.itemView;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1669362685")) {
            ipChange.ipc$dispatch("-1669362685", new Object[]{this, view});
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this.mScrollListener);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2111235136")) {
            ipChange.ipc$dispatch("-2111235136", new Object[]{this, view});
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.mScrollListener);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.NewHeadAtmosphereContract.View
    public void scrollChanged(@NotNull RecyclerView recyclerView, int i) {
        SafeLottieAnimationView safeLottieAnimationView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1509825267")) {
            ipChange.ipc$dispatch("-1509825267", new Object[]{this, recyclerView, Integer.valueOf(i)});
            return;
        }
        b41.i(recyclerView, "recyclerView");
        if (State.LOTTIE_SUCCESS != this.mCurState || (safeLottieAnimationView = this.mLottieView) == null) {
            return;
        }
        try {
            if (safeLottieAnimationView.isAttachedToWindow()) {
                if (safeLottieAnimationView.getVisibility() == 0) {
                    if (i == 0) {
                        if (!safeLottieAnimationView.isAnimating()) {
                            safeLottieAnimationView.resumeAnimation();
                        }
                    } else if (safeLottieAnimationView.isAnimating()) {
                        safeLottieAnimationView.pauseAnimation();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
