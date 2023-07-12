package cn.damai.onearch.component.evaluate;

import android.app.Activity;
import android.view.View;
import cn.damai.comment.bean.CommentTargetDataBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.commonbusiness.scriptmurder.shopdetail.ShopDetailActivity;
import cn.damai.evaluate.ui.item.EvaluateItemDataBinder;
import cn.damai.onearch.component.evaluate.OneEvaluate;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.al;
import tb.b41;
import tb.cl;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class OneEvaluatePresent extends AbsPresenter<GenericItem<ItemValue>, OneEvaluateModel, OneEvaluateView> implements OneEvaluate.Present, EvaluateItemDataBinder.EvaluateItemUTReportListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private EvaluateItemDataBinder mEvaluateBinder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneEvaluatePresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    private final void ensureBinderObj(GenericItem<ItemValue> genericItem) {
        IContext pageContext;
        Activity activity;
        IContext pageContext2;
        Activity activity2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-885563332")) {
            ipChange.ipc$dispatch("-885563332", new Object[]{this, genericItem});
        } else if (this.mEvaluateBinder == null) {
            int sceneType = getSceneType((genericItem == null || (pageContext2 = genericItem.getPageContext()) == null || (activity2 = pageContext2.getActivity()) == null) ? null : activity2.getClass().getName());
            if (genericItem == null || (pageContext = genericItem.getPageContext()) == null || (activity = pageContext.getActivity()) == null) {
                return;
            }
            this.mEvaluateBinder = new EvaluateItemDataBinder(activity, sceneType);
        }
    }

    private final int getSceneType(String str) {
        boolean K;
        boolean K2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "708268916")) {
            return ((Integer) ipChange.ipc$dispatch("708268916", new Object[]{this, str})).intValue();
        }
        if (str == null) {
            return 0;
        }
        K = StringsKt__StringsKt.K(str, "ScriptDetailActivity", false, 2, null);
        if (K) {
            return 2;
        }
        K2 = StringsKt__StringsKt.K(str, ShopDetailActivity.TAG, false, 2, null);
        return K2 ? 1 : 0;
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportImageInfoClickEvent(boolean z, @Nullable CommentsItemBean commentsItemBean, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2073697027")) {
            ipChange.ipc$dispatch("-2073697027", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportItemClickEvent(boolean z, @Nullable CommentsItemBean commentsItemBean, int i) {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-626354630")) {
            ipChange.ipc$dispatch("-626354630", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            return;
        }
        Action itemAction = getItemAction();
        if (itemAction == null || (trackInfo = itemAction.getTrackInfo()) == null) {
            return;
        }
        UserTrackProviderProxy.click(((OneEvaluateView) getView()).getRenderView(), trackInfo, true);
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportMoreInfoClickEvent(boolean z, @Nullable CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923162154")) {
            ipChange.ipc$dispatch("923162154", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportPraiseViewClickEvent(boolean z, @Nullable CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "449522700")) {
            ipChange.ipc$dispatch("449522700", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportReplyClickEvent(boolean z, @Nullable CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-31018011")) {
            ipChange.ipc$dispatch("-31018011", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportSyncCircleClickEvent(boolean z, @Nullable CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-149740606")) {
            ipChange.ipc$dispatch("-149740606", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportTransferClickEvent(boolean z, @Nullable CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1518694686")) {
            ipChange.ipc$dispatch("-1518694686", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportUserInfoClickEvent(boolean z, @Nullable CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-88841228")) {
            ipChange.ipc$dispatch("-88841228", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1530544729")) {
            ipChange.ipc$dispatch("1530544729", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((OneEvaluatePresent) genericItem);
        ensureBinderObj(genericItem);
        CommentsItemBean evaluate = ((OneEvaluateModel) getModel()).getEvaluate();
        al alVar = new al(0);
        alVar.q(evaluate);
        CommentTargetDataBean targetDataDO = evaluate.getTargetDataDO();
        if (targetDataDO != null) {
            alVar.v(cl.b(targetDataDO.getTargetId()));
            alVar.w(targetDataDO.getTargetImg());
            alVar.x(targetDataDO.getTargetName());
            alVar.t(targetDataDO.getTargetCityName());
            alVar.y(targetDataDO.getTargetShowTime());
        }
        EvaluateItemDataBinder evaluateItemDataBinder = this.mEvaluateBinder;
        if (evaluateItemDataBinder != null) {
            evaluateItemDataBinder.r(this);
            evaluateItemDataBinder.j(((OneEvaluateView) getView()).getEvaluateHolder(), alVar, genericItem.getIndex(), genericItem.getComponent().getChildCount());
        }
        Action itemAction = getItemAction();
        if (itemAction == null || (trackInfo = itemAction.getTrackInfo()) == null) {
            return;
        }
        UserTrackProviderProxy.expose(((OneEvaluateView) getView()).getRenderView(), trackInfo);
    }
}
