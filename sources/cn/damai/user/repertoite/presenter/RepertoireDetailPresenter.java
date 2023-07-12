package cn.damai.user.repertoite.presenter;

import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.message.observer.Action;
import cn.damai.user.repertoite.contract.RepertoireDetailContract;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class RepertoireDetailPresenter extends RepertoireDetailContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String COMMENT_PRAISE = "comment_praise";
    private static final String EVENT_COMMENT_DELETE = "comment_delete_success";
    private static final String EVENT_COMMENT_PUBLISH = "comment_publish_success";

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class a implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2056941864")) {
                ipChange.ipc$dispatch("2056941864", new Object[]{this, obj});
            } else {
                ((RepertoireDetailContract.View) RepertoireDetailPresenter.this.mView).onSelfPublishCommentSuccess();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class b implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1544923735")) {
                ipChange.ipc$dispatch("-1544923735", new Object[]{this, obj});
            } else {
                ((RepertoireDetailContract.View) RepertoireDetailPresenter.this.mView).onSelfPublishCommentSuccess();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class c implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-851822038")) {
                ipChange.ipc$dispatch("-851822038", new Object[]{this, obj});
            } else {
                ((RepertoireDetailContract.View) RepertoireDetailPresenter.this.mView).onPraiseViewOnClick((CommentsItemBean) obj);
            }
        }
    }

    @Override // cn.damai.common.app.base.a
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "634222890")) {
            ipChange.ipc$dispatch("634222890", new Object[]{this});
            return;
        }
        super.onStart();
        this.mDMMessage.b(EVENT_COMMENT_PUBLISH, new a());
        this.mDMMessage.b(EVENT_COMMENT_DELETE, new b());
        this.mDMMessage.b(COMMENT_PRAISE, new c());
    }
}
