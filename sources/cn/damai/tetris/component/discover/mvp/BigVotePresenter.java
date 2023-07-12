package cn.damai.tetris.component.discover.mvp;

import android.text.TextUtils;
import android.view.View;
import cn.damai.commonbusiness.discover.bean.VoteBean;
import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.tetris.component.discover.mvp.BigVoteContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.ut.TrackType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.HashMap;
import java.util.Map;
import tb.cb2;
import tb.d23;
import tb.ja;
import tb.pb;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BigVotePresenter extends BasePresenter<BigVoteModel, BigVoteView, BaseSection> implements BigVoteContract.Presenter<BigVoteModel, BigVoteView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public BigVotePresenter(BigVoteView bigVoteView, String str, ja jaVar) {
        super(bigVoteView, str, jaVar);
    }

    public void addCommonMap(HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1801197177")) {
            ipChange.ipc$dispatch("-1801197177", new Object[]{this, hashMap});
        } else if (getModel() == null || getModel().getTrackInfo() == null) {
        } else {
            Map<String, String> argsMap = getModel().getTrackInfo().getArgsMap();
            if (cb2.f(argsMap)) {
                return;
            }
            String str = argsMap.get(pb.CNT_CONTENT_ID);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            hashMap.put("quanziid", str);
        }
    }

    @Override // cn.damai.tetris.component.discover.mvp.BigVoteContract.Presenter
    public void itemClick(VoteInfoBean voteInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1781644677")) {
            ipChange.ipc$dispatch("1781644677", new Object[]{this, voteInfoBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1013380793")) {
            ipChange.ipc$dispatch("1013380793", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
    public void ut4CancelVoteClick(VoteInfoBean voteInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1114899826")) {
            ipChange.ipc$dispatch("1114899826", new Object[]{this, voteInfoBean});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("titlelabel", "推荐");
        f.put("id", voteInfoBean.id);
        addCommonMap(f);
        userTrack(TrackType.click, null, getModel().getTrackInfo().trackB, "vote_cancel", "dbtn", f, false);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
    public void ut4VoteCardExposure(View view, VoteInfoBean voteInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-388173628")) {
            ipChange.ipc$dispatch("-388173628", new Object[]{this, view, voteInfoBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("titlelabel", "推荐");
        f.put("InteractionId", voteInfoBean.id);
        addCommonMap(f);
        TrackType trackType = TrackType.expose;
        String str = getModel().getTrackInfo().trackB;
        userTrack(trackType, view, str, "recommend", "dvote_" + i, f, true);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
    public void ut4VoteClick(VoteInfoBean voteInfoBean, VoteBean voteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "440170040")) {
            ipChange.ipc$dispatch("440170040", new Object[]{this, voteInfoBean, voteBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("titlelabel", "推荐");
        f.put("id", voteInfoBean.id);
        f.put(Preloader.KEY_SESSION, voteBean.posInVoteList + "");
        f.put("index", i + "");
        addCommonMap(f);
        TrackType trackType = TrackType.click;
        String str = getModel().getTrackInfo().trackB;
        userTrack(trackType, null, str, "recommend", "dvote_" + i, f, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // cn.damai.tetris.core.BasePresenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void init(cn.damai.tetris.component.discover.mvp.BigVoteModel r6) {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.tetris.component.discover.mvp.BigVotePresenter.$ipChange
            java.lang.String r1 = "2099208725"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L17
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r5
            r2[r3] = r6
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            cn.damai.tetris.v2.structure.section.ISection r0 = r5.getSection()
            if (r0 == 0) goto L33
            java.lang.Object r0 = r0.getExtra()
            boolean r1 = r0 instanceof cn.damai.commonbusiness.discover.bean.VoteInfoBean
            if (r1 == 0) goto L33
            cn.damai.commonbusiness.discover.bean.VoteInfoBean r0 = (cn.damai.commonbusiness.discover.bean.VoteInfoBean) r0
            cn.damai.tetris.core.IView r1 = r5.getView()
            cn.damai.tetris.component.discover.mvp.BigVoteView r1 = (cn.damai.tetris.component.discover.mvp.BigVoteView) r1
            int r2 = r0.posInFeedList
            r1.setData(r0, r2)
            goto L34
        L33:
            r3 = 0
        L34:
            if (r3 != 0) goto L45
            cn.damai.commonbusiness.discover.bean.VoteInfoBean r6 = r6.getBean()
            cn.damai.tetris.core.IView r0 = r5.getView()
            cn.damai.tetris.component.discover.mvp.BigVoteView r0 = (cn.damai.tetris.component.discover.mvp.BigVoteView) r0
            int r1 = r6.posInFeedList
            r0.setData(r6, r1)
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.tetris.component.discover.mvp.BigVotePresenter.init(cn.damai.tetris.component.discover.mvp.BigVoteModel):void");
    }
}
