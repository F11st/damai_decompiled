package cn.damai.tetris.component.discover.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.discover.bean.ContentShareInfo;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.mvp.BigNoteContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;
import tb.C9548pb;
import tb.cs;
import tb.d23;
import tb.ja;
import tb.jm1;
import tb.nb2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BigNotePresenter extends BasePresenter<BigNoteModel, BigNoteView, BaseSection> implements BigNoteContract.Presenter<BigNoteModel, BigNoteView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.discover.mvp.BigNotePresenter$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1806a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1806a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-986812942")) {
                ipChange.ipc$dispatch("-986812942", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            try {
                if (BigNotePresenter.this.getModel().getBean().contentInfo.id != null) {
                    bundle.putString("targetId", BigNotePresenter.this.getModel().getBean().contentInfo.id);
                }
                bundle.putInt("targetType", jm1.j(BigNotePresenter.this.getModel().getBean().subType, 1));
                bundle.putInt("type", 5);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            DMNav.from(BigNotePresenter.this.getContext().getActivity()).withExtras(bundle).toUri(NavUri.b("report"));
            ShareManager.E().C();
        }
    }

    public BigNotePresenter(BigNoteView bigNoteView, String str, ja jaVar) {
        super(bigNoteView, str, jaVar);
    }

    private View addShareView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-804811675")) {
            return (View) ipChange.ipc$dispatch("-804811675", new Object[]{this, Boolean.valueOf(z)});
        }
        LinearLayout linearLayout = new LinearLayout(getContext().getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.addView(nb2.g(getContext().getActivity(), new View$OnClickListenerC1806a()));
        return linearLayout;
    }

    public static void fillMap(boolean z, TrackInfo trackInfo, Map<String, String> map, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1326513623")) {
            ipChange.ipc$dispatch("1326513623", new Object[]{Boolean.valueOf(z), trackInfo, map, str, str2});
        } else if (trackInfo == null || map == null) {
        } else {
            String string = trackInfo.getString("usercode");
            String string2 = trackInfo.getString("titlelabel");
            putMap("city", trackInfo.getString("city"), map);
            putMap("titlelabel", string2, map);
            putMap("usercode", string, map);
            if (z) {
                putMap(C9548pb.PRE_CONTENT_ID, str2, map);
                putMap(C9548pb.PRE_CONTENT_TYPE, str, map);
            }
        }
    }

    public static boolean isTrackInfoValid(TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "612815190") ? ((Boolean) ipChange.ipc$dispatch("612815190", new Object[]{trackInfo})).booleanValue() : (trackInfo == null || TextUtils.isEmpty(trackInfo.trackB) || TextUtils.isEmpty(trackInfo.trackC)) ? false : true;
    }

    public static void putMap(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1093126090")) {
            ipChange.ipc$dispatch("1093126090", new Object[]{str, str2, map});
        } else if (map == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
        } else {
            map.put(str, str2);
        }
    }

    @Override // cn.damai.tetris.component.discover.mvp.BigNoteContract.Presenter
    public void OnPraiseViewClick(boolean z, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1361322291")) {
            ipChange.ipc$dispatch("1361322291", new Object[]{this, Boolean.valueOf(z), str, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("item_id", str);
        f.put("content_typ", "note");
        f.put("quanziid", getModel().getTrackInfo().getArgsMap().get(C9548pb.CNT_CONTENT_ID));
        TrackType trackType = TrackType.click;
        String str2 = ((BigNoteModel) this.mModel).getTrackInfo().trackB;
        userTrack(trackType, null, str2, "item_" + i, "likesbtn", f, false);
    }

    @Override // cn.damai.tetris.component.discover.mvp.BigNoteContract.Presenter
    public void dnaOnClickReport(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "19763105")) {
            ipChange.ipc$dispatch("19763105", new Object[]{this, str, str2, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("quanziid", getModel().getTrackInfo().getArgsMap().get(C9548pb.CNT_CONTENT_ID));
        putMap(C9548pb.PUBLISHER_ID, str2, f);
        putMap("item_id", str, f);
        TrackType trackType = TrackType.click;
        String str3 = this.mTrackInfo.trackB;
        userTrack(trackType, null, str3, "item_" + i, "DNAshow", f, true);
    }

    @Override // cn.damai.tetris.component.discover.mvp.BigNoteContract.Presenter
    public void exposeNote(View view, NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1190359880")) {
            ipChange.ipc$dispatch("1190359880", new Object[]{this, view, noteBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("content_id", noteBean.id);
        f.put("index", String.valueOf(i));
        f.put("quanziid", getModel().getTrackInfo().getArgsMap().get(C9548pb.CNT_CONTENT_ID));
        TrackType trackType = TrackType.expose;
        userTrack(trackType, view, "HotQuanzi", "content", "item_" + i, f, false);
    }

    @Override // cn.damai.tetris.component.discover.mvp.BigNoteContract.Presenter
    public void itemClick(BigNoteContract.View view, NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1934319234")) {
            ipChange.ipc$dispatch("1934319234", new Object[]{this, view, noteBean, Integer.valueOf(i)});
        } else if (noteBean == null || getContext() == null) {
        } else {
            if (isTrackInfoValid(this.mTrackInfo)) {
                HashMap hashMap = new HashMap();
                if (this.mTrackInfo.getArgsMap() != null) {
                    hashMap.putAll(this.mTrackInfo.getArgsMap());
                }
                putMap("quanziid", getModel().getTrackInfo().getArgsMap().get(C9548pb.CNT_CONTENT_ID), hashMap);
                putMap("alg", noteBean.alg, hashMap);
                putMap(C9548pb.PUBLISHER_ID, noteBean.baseUserDO.havanaIdStr, hashMap);
                putMap("item_id", noteBean.id, hashMap);
                putMap("index", "" + i, hashMap);
                fillMap(false, this.mTrackInfo, hashMap, noteBean.getCardType(), noteBean.id);
                userTrack(TrackType.click, view.getRootView(), this.mTrackInfo.trackB, "recommend", "item", hashMap, true);
            }
            Activity activity = getContext().getActivity();
            Bundle bundle = new Bundle();
            bundle.putString("contentId", noteBean.id);
            bundle.putFloat("picWhRatio", noteBean.localPicWhRatio);
            NavProxy.from(activity).withExtras(bundle).toUri(INavUri.page(cs.DISCOVER_CONTENT_DETAIL));
        }
    }

    @Override // cn.damai.tetris.component.discover.mvp.BigNoteContract.Presenter
    public void likeOnClickReport(boolean z, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2012133355")) {
            ipChange.ipc$dispatch("-2012133355", new Object[]{this, Boolean.valueOf(z), str, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("item_id", str);
        f.put("statue", z ? "0" : "1");
        f.put("content_typ", "note");
        f.put("quanziid", getModel().getTrackInfo().getArgsMap().get(C9548pb.CNT_CONTENT_ID));
        TrackType trackType = TrackType.click;
        String str2 = ((BigNoteModel) this.mModel).getTrackInfo().trackB;
        userTrack(trackType, null, str2, "item_" + i, "favorite", f, false);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1869232975")) {
            ipChange.ipc$dispatch("-1869232975", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.component.discover.mvp.BigNoteContract.Presenter
    public void shareClick(ContentShareInfo contentShareInfo, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "920850879")) {
            ipChange.ipc$dispatch("920850879", new Object[]{this, contentShareInfo, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("quanziid", getModel().getTrackInfo().getArgsMap().get(C9548pb.CNT_CONTENT_ID));
        f.put("item_id", getModel().getBean().contentInfo.id);
        TrackType trackType = TrackType.click;
        String str = ((BigNoteModel) this.mModel).getTrackInfo().trackB;
        userTrack(trackType, null, str, "item_" + i, "share", f, false);
        View addShareView = addShareView(getModel().getBean().mySelf);
        Bundle bundle = new Bundle();
        bundle.putString("imageurl", contentShareInfo.shareImage);
        bundle.putString("title", contentShareInfo.shareTitle);
        bundle.putString("message", contentShareInfo.shareSubTitle);
        bundle.putString("producturl", contentShareInfo.shareUrl);
        bundle.putBoolean("showGenerateImage", false);
        bundle.putString("shareType", "chat_h5");
        ShareManager.E().T(getContext().getActivity(), bundle, getContext().getActivity().getWindow().getDecorView());
        ShareManager.E().e0(addShareView);
        ShareManager.E().l0();
    }

    @Override // cn.damai.tetris.component.discover.mvp.BigNoteContract.Presenter
    public void userOnClickReport(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2104469963")) {
            ipChange.ipc$dispatch("2104469963", new Object[]{this, str, str2, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("quanziid", getModel().getTrackInfo().getArgsMap().get(C9548pb.CNT_CONTENT_ID));
        putMap(C9548pb.PUBLISHER_ID, str2, f);
        putMap("item_id", str, f);
        TrackType trackType = TrackType.click;
        String str3 = this.mTrackInfo.trackB;
        userTrack(trackType, null, str3, "item_" + i, "avatar", f, true);
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(BigNoteModel bigNoteModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "785959973")) {
            ipChange.ipc$dispatch("785959973", new Object[]{this, bigNoteModel});
            return;
        }
        NoteBean bean = bigNoteModel.getBean();
        this.mTrackInfo = bigNoteModel.getTrackInfo();
        BigNoteView view = getView();
        view.setData(bean, bean.pos);
        if (isTrackInfoValid(this.mTrackInfo)) {
            HashMap hashMap = new HashMap();
            if (this.mTrackInfo.getArgsMap() != null) {
                hashMap.putAll(this.mTrackInfo.getArgsMap());
            }
            putMap("alg", bean.alg, hashMap);
            fillMap(true, this.mTrackInfo, hashMap, bean.getCardType(), bean.id);
            TrackType trackType = TrackType.expose;
            View rootView = view.getRootView();
            String str = this.mTrackInfo.trackB;
            userTrack(trackType, rootView, str, "recommend", "item" + bean.pos, hashMap, true);
        }
    }
}
