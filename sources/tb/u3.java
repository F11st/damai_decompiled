package tb;

import android.app.Activity;
import android.os.Bundle;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.mine.listener.MultiClickUt;
import cn.damai.mine.listener.OnMultiListClickListener;
import cn.damai.tetris.component.discover.bean.NoteBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class u3 implements MultiClickUt, OnMultiListClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private MultiClickUt b;

    public u3(Activity activity, MultiClickUt multiClickUt) {
        this.a = activity;
        this.b = multiClickUt;
    }

    private boolean a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722876092")) {
            return ((Boolean) ipChange.ipc$dispatch("722876092", new Object[]{this})).booleanValue();
        }
        Activity activity = this.a;
        return (activity == null || activity.isFinishing()) ? false : true;
    }

    @Override // cn.damai.mine.listener.OnMultiListClickListener
    public void onNoteClick(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2050452106")) {
            ipChange.ipc$dispatch("-2050452106", new Object[]{this, noteBean, Integer.valueOf(i)});
        } else if (!a() || noteBean == null) {
        } else {
            utNoteClick(noteBean, i);
            Bundle bundle = new Bundle();
            bundle.putString("contentId", noteBean.id);
            bundle.putFloat("picWhRatio", noteBean.localPicWhRatio);
            DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(cs.DISCOVER_CONTENT_DETAIL));
        }
    }

    @Override // cn.damai.mine.listener.MultiClickUt
    public void utNoteClick(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1317764278")) {
            ipChange.ipc$dispatch("1317764278", new Object[]{this, noteBean, Integer.valueOf(i)});
            return;
        }
        MultiClickUt multiClickUt = this.b;
        if (multiClickUt != null) {
            multiClickUt.utNoteClick(noteBean, i);
        }
    }
}
