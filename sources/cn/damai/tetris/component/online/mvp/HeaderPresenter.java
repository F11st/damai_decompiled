package cn.damai.tetris.component.online.mvp;

import android.text.TextUtils;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.uikit.nav.NavProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.ja;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HeaderPresenter extends BasePresenter<HeaderContract$Model, HeaderView, BaseSection> implements HeaderContract$Presenter<HeaderContract$Model, HeaderView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    public ja mContext;
    public TrackInfo mTrackInfo;
    public HeaderView mView;

    public HeaderPresenter(HeaderView headerView, String str, ja jaVar) {
        super(headerView, str, jaVar);
        this.mView = headerView;
        this.mContext = jaVar;
    }

    @Override // cn.damai.tetris.component.online.mvp.HeaderContract$Presenter
    public void btnClick(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "981610551")) {
            ipChange.ipc$dispatch("981610551", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            NavProxy.from(this.mContext.getActivity()).toUri(str);
            HashMap hashMap = new HashMap();
            String d = z20.d();
            if (!TextUtils.isEmpty(d)) {
                hashMap.put("city", d);
            }
            hashMap.put("titlelabel", "即将开演");
            userTrackClick("gotosee", hashMap, true);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "85137398")) {
            ipChange.ipc$dispatch("85137398", new Object[]{this, Integer.valueOf(i), obj});
        } else if (this.mView == null || this.mContext.getActivity() == null) {
        } else {
            switch (i) {
                case 11001:
                    break;
                case 11002:
                    this.mView.videoPlay();
                    return;
                case 11003:
                    this.mView.videoStop();
                    return;
                case 11004:
                    this.mView.videoDestory();
                    break;
                default:
                    return;
            }
            if (obj instanceof Boolean) {
                if (((Boolean) obj).booleanValue()) {
                    this.mView.videoPlay();
                } else {
                    this.mView.videoStop();
                }
            }
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(HeaderContract$Model headerContract$Model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-78365731")) {
            ipChange.ipc$dispatch("-78365731", new Object[]{this, headerContract$Model});
            return;
        }
        this.mTrackInfo = headerContract$Model.getTrackInfo();
        getView().setData(headerContract$Model.getTopBean());
        if (headerContract$Model.getTopBean() != null) {
            HashMap hashMap = new HashMap();
            String d = z20.d();
            if (!TextUtils.isEmpty(d)) {
                hashMap.put("city", d);
            }
            hashMap.put("titlelabel", "即将开演");
            userTrackExpose(this.mView.getView(), "gotosee", hashMap, false);
        }
    }
}
