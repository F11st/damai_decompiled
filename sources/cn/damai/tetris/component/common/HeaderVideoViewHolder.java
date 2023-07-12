package cn.damai.tetris.component.common;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.home.adapter.HeaderVideoAdapter;
import cn.damai.tetris.component.home.bean.ArtistHeadBean;
import cn.damai.tetris.component.home.bean.HomePageVideoBean;
import cn.damai.tetris.component.home.viewholder.VideoViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;
import tb.m62;
import tb.mu0;
import tb.qx2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HeaderVideoViewHolder extends VideoViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    ObjectAnimator animator2;
    ObjectAnimator animatorUser;
    int userIndex;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.common.HeaderVideoViewHolder$a */
    /* loaded from: classes16.dex */
    public class C1801a implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private boolean a = false;
        final /* synthetic */ List b;

        C1801a(List list) {
            this.b = list;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-566923554")) {
                ipChange.ipc$dispatch("-566923554", new Object[]{this, animator});
                return;
            }
            this.a = true;
            Log.d("animationx", " ===== 1 cancel : " + this.a);
            ObjectAnimator objectAnimator = HeaderVideoViewHolder.this.animator2;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-253794031")) {
                ipChange.ipc$dispatch("-253794031", new Object[]{this, animator});
                return;
            }
            Log.d("animationx", " ===== 1 end : " + this.a);
            if (this.a) {
                return;
            }
            ArtistHeadBean artistHeadBean = (ArtistHeadBean) cb2.b(this.b, HeaderVideoViewHolder.this.userIndex);
            if (artistHeadBean != null) {
                ((TextView) ((VideoViewHolder) HeaderVideoViewHolder.this).userAvatar.findViewById(R$id.user_head_single_name)).setText(artistHeadBean.name);
                HeaderVideoViewHolder headerVideoViewHolder = HeaderVideoViewHolder.this;
                headerVideoViewHolder.loadHead(artistHeadBean.headPic, (ImageView) ((VideoViewHolder) headerVideoViewHolder).userAvatar.findViewById(R$id.user_head_single)).f();
            }
            HeaderVideoViewHolder headerVideoViewHolder2 = HeaderVideoViewHolder.this;
            int i = headerVideoViewHolder2.userIndex + 1;
            headerVideoViewHolder2.userIndex = i;
            if (i >= this.b.size()) {
                HeaderVideoViewHolder.this.userIndex = 0;
            }
            HeaderVideoViewHolder.this.animator2.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1746652061")) {
                ipChange.ipc$dispatch("1746652061", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-527329750")) {
                ipChange.ipc$dispatch("-527329750", new Object[]{this, animator});
                return;
            }
            this.a = false;
            Log.d("animationx", " ===== 1 start : " + this.a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.common.HeaderVideoViewHolder$b */
    /* loaded from: classes16.dex */
    public class C1802b implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private boolean a = false;

        C1802b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "202246461")) {
                ipChange.ipc$dispatch("202246461", new Object[]{this, animator});
                return;
            }
            this.a = true;
            Log.d("animationx", " ===== 2 cancel : ");
            HeaderVideoViewHolder.this.animatorUser.cancel();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-261553390")) {
                ipChange.ipc$dispatch("-261553390", new Object[]{this, animator});
                return;
            }
            Log.d("animationx", " ===== 2 end : " + this.a);
            if (this.a) {
                return;
            }
            HeaderVideoViewHolder.this.animatorUser.setStartDelay(3000L);
            HeaderVideoViewHolder.this.animatorUser.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1779145220")) {
                ipChange.ipc$dispatch("-1779145220", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "605860843")) {
                ipChange.ipc$dispatch("605860843", new Object[]{this, animator});
                return;
            }
            this.a = false;
            Log.d("animationx", " ===== 2 start : " + this.a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.common.HeaderVideoViewHolder$c */
    /* loaded from: classes7.dex */
    public class C1803c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        C1803c(HeaderVideoViewHolder headerVideoViewHolder, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "193376675")) {
                ipChange.ipc$dispatch("193376675", new Object[]{this, c0502e});
                return;
            }
            Bitmap bitmap = c0502e.b;
            if (bitmap != null) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    public HeaderVideoViewHolder(View view) {
        super(view);
        this.userIndex = 1;
        this.animatorUser = new ObjectAnimator();
        this.animator2 = new ObjectAnimator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DMImageCreator loadHead(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "844676403")) {
            return (DMImageCreator) ipChange.ipc$dispatch("844676403", new Object[]{this, str, imageView});
        }
        int a = m62.a(mu0.a(), 35.0f);
        imageView.setImageBitmap(null);
        return C0504a.b().f(str, a, a).n(new C1803c(this, imageView));
    }

    private void rotateOnYCoordinate(View view, List<ArtistHeadBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1638220499")) {
            ipChange.ipc$dispatch("-1638220499", new Object[]{this, view, list});
            return;
        }
        Log.d("animationx", " ===== rotateOnYCoordinate : " + this.mIndex);
        ObjectAnimator objectAnimator = this.animatorUser;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.animator2.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotationY", 0.0f, 90.0f);
        this.animatorUser = ofFloat;
        ofFloat.setDuration(500L);
        this.animatorUser.addListener(new C1801a(list));
        this.animatorUser.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "rotationY", -90.0f, 0.0f);
        this.animator2 = ofFloat2;
        ofFloat2.setDuration(500L);
        this.animator2.addListener(new C1802b());
    }

    @Override // cn.damai.tetris.component.home.viewholder.VideoViewHolder
    public void fixVideoHeight() {
        View findViewById;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1258182800")) {
            ipChange.ipc$dispatch("1258182800", new Object[]{this});
            return;
        }
        int a = (m62.a(mu0.a(), 270.0f) - qx2.c()) - m62.a(mu0.a(), 9.0f);
        int i = a >= 0 ? a : 0;
        View view = this.itemView;
        if (view == null || (findViewById = view.findViewById(R$id.homepage_video_cover)) == null || findViewById.getLayoutParams() == null) {
            return;
        }
        findViewById.getLayoutParams().height = i;
        findViewById.requestLayout();
    }

    @Override // cn.damai.tetris.component.home.viewholder.VideoViewHolder
    public void getVideoAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2130720003")) {
            ipChange.ipc$dispatch("2130720003", new Object[]{this});
        } else {
            this.mAdapter = new HeaderVideoAdapter();
        }
    }

    @Override // cn.damai.tetris.component.home.viewholder.VideoViewHolder
    public void initUserHeaderPic(HomePageVideoBean.HomePageVideoItem homePageVideoItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1670819353")) {
            ipChange.ipc$dispatch("1670819353", new Object[]{this, homePageVideoItem});
        } else if (this.userAvatar == null || homePageVideoItem == null) {
        } else {
            List<ArtistHeadBean> list = homePageVideoItem.artistVOS;
            ArtistHeadBean artistHeadBean = (ArtistHeadBean) cb2.b(list, 0);
            if (artistHeadBean != null) {
                this.userAvatar.setVisibility(0);
                this.userAvatar.setClickable(true);
                ((TextView) this.userAvatar.findViewById(R$id.user_head_single_name)).setText(artistHeadBean.name);
                loadHead(artistHeadBean.headPic, (ImageView) this.userAvatar.findViewById(R$id.user_head_single)).f();
                if (list.size() > 1) {
                    this.userIndex = 1;
                    rotateOnYCoordinate(this.userAvatar, list);
                    return;
                }
                this.userAvatar.setVisibility(8);
                ObjectAnimator objectAnimator = this.animatorUser;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                    this.animator2.cancel();
                }
                this.userAvatar.setVisibility(0);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.userAvatar, "rotationY", 0.0f);
                ofFloat.setDuration(1L);
                ofFloat.start();
                return;
            }
            this.userAvatar.setVisibility(8);
            ObjectAnimator objectAnimator2 = this.animatorUser;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
                this.animator2.cancel();
            }
        }
    }

    @Override // cn.damai.tetris.component.home.viewholder.VideoViewHolder, cn.damai.tetris.mvp.CommonViewHolder
    public void setMessage(int i, Object obj) {
        ObjectAnimator objectAnimator;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-882670937")) {
            ipChange.ipc$dispatch("-882670937", new Object[]{this, Integer.valueOf(i), obj});
            return;
        }
        super.setMessage(i, obj);
        if (i == 11004 && (objectAnimator = this.animatorUser) != null) {
            objectAnimator.cancel();
            this.animator2.cancel();
        }
    }
}
