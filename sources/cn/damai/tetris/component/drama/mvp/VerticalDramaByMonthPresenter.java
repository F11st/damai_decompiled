package cn.damai.tetris.component.drama.mvp;

import android.text.TextUtils;
import android.view.View;
import cn.damai.tetris.component.drama.bean.DramaMonthBean;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import cn.damai.tetris.component.drama.mvp.VerticalDramaByMonthContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.Point;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.d23;
import tb.i40;
import tb.ja;
import tb.xc0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VerticalDramaByMonthPresenter extends BasePresenter<VerticalDramaByMonthModel, VerticalDramaByMonthView, BaseSection> implements VerticalDramaByMonthContract.Presenter<VerticalDramaByMonthModel, VerticalDramaByMonthView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int tabIndex;

    public VerticalDramaByMonthPresenter(VerticalDramaByMonthView verticalDramaByMonthView, String str, ja jaVar) {
        super(verticalDramaByMonthView, str, jaVar);
    }

    private void itemExpose(View view, int i, String str, HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "213445887")) {
            ipChange.ipc$dispatch("213445887", new Object[]{this, view, Integer.valueOf(i), str, hashMap});
            return;
        }
        String trackPointFromModel = getTrackPointFromModel(Point.TRACK_B);
        if (TextUtils.isEmpty(trackPointFromModel)) {
            trackPointFromModel = i40.PAGE_NAME_DRAMA_COMMING;
        }
        String str2 = trackPointFromModel;
        String trackPointFromModel2 = getTrackPointFromModel(Point.TRACK_C);
        if (TextUtils.isEmpty(trackPointFromModel2)) {
            trackPointFromModel2 = "tab_";
        }
        userTrack(TrackType.expose, view, str2, trackPointFromModel2 + i, str, hashMap, false);
    }

    private void userClick(int i, String str, HashMap<String, String> hashMap, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1655576687")) {
            ipChange.ipc$dispatch("-1655576687", new Object[]{this, Integer.valueOf(i), str, hashMap, Boolean.valueOf(z)});
            return;
        }
        String trackPointFromModel = getTrackPointFromModel(Point.TRACK_B);
        if (TextUtils.isEmpty(trackPointFromModel)) {
            trackPointFromModel = i40.PAGE_NAME_DRAMA_COMMING;
        }
        String str2 = trackPointFromModel;
        String trackPointFromModel2 = getTrackPointFromModel(Point.TRACK_C);
        if (TextUtils.isEmpty(trackPointFromModel2)) {
            trackPointFromModel2 = "tab_";
        }
        userTrack(TrackType.click, null, str2, trackPointFromModel2 + i, str, hashMap, z);
    }

    @Override // cn.damai.tetris.component.drama.mvp.VerticalDramaByMonthContract.Presenter
    public void exposeItem(View view, DramaV1Bean dramaV1Bean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1136308515")) {
            ipChange.ipc$dispatch("1136308515", new Object[]{this, view, dramaV1Bean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> g = d23.g();
        g.put("titlelabel", dramaV1Bean.tempLabelName);
        int i2 = this.tabIndex;
        itemExpose(view, i2, "item_" + i, g);
    }

    @Override // cn.damai.tetris.component.drama.mvp.VerticalDramaByMonthContract.Presenter
    public void itemClick(VerticalDramaByMonthContract.View view, DramaV1Bean dramaV1Bean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-482962430")) {
            ipChange.ipc$dispatch("-482962430", new Object[]{this, view, dramaV1Bean, Integer.valueOf(i)});
            return;
        }
        xc0.b(getContext(), dramaV1Bean);
        String str = "item_" + i;
        HashMap<String, String> g = d23.g();
        g.put("titlelabel", dramaV1Bean.tempLabelName);
        userClick(this.tabIndex, str, g, true);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1036858227")) {
            ipChange.ipc$dispatch("-1036858227", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.component.drama.mvp.VerticalDramaByMonthContract.Presenter
    public void utFocusClick(VerticalDramaByMonthContract.View view, DramaV1Bean dramaV1Bean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "529382718")) {
            ipChange.ipc$dispatch("529382718", new Object[]{this, view, dramaV1Bean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> g = d23.g();
        g.put("repertoire_id", dramaV1Bean.id);
        g.put("status", dramaV1Bean.focus ? "0" : "1");
        userClick(this.tabIndex, "favorite", g, false);
    }

    @Override // cn.damai.tetris.component.drama.mvp.VerticalDramaByMonthContract.Presenter
    public void utShowAllClick(VerticalDramaByMonthContract.View view, DramaMonthBean dramaMonthBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1712910791")) {
            ipChange.ipc$dispatch("1712910791", new Object[]{this, view, dramaMonthBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> g = d23.g();
        g.put("titlelabel", dramaMonthBean.labelName);
        userClick(this.tabIndex, "expand", g, false);
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(VerticalDramaByMonthModel verticalDramaByMonthModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1196846291")) {
            ipChange.ipc$dispatch("-1196846291", new Object[]{this, verticalDramaByMonthModel});
            return;
        }
        ISection section = getSection();
        if (section != null) {
            Object extra = section.getExtra();
            if (extra instanceof DramaMonthBean) {
                String sectionId = section.getSectionId();
                DramaMonthBean dramaMonthBean = (DramaMonthBean) extra;
                this.tabIndex = dramaMonthBean.tabIndex;
                getView().setData(dramaMonthBean, sectionId, 0);
            }
        }
    }
}
