package tb;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.poplayer.view.PopLayerImageView;
import cn.damai.commonbusiness.poplayer.view.h5.PopLayerWebView;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.norm.IFaceAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.nav.Nav;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ir implements IFaceAdapter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static class b implements Nav.NavHooker {
        private static transient /* synthetic */ IpChange $ipChange;

        private b() {
        }

        @Override // com.taobao.android.nav.Nav.NavHooker
        public boolean hook(Context context, Intent intent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-36669314")) {
                return ((Boolean) ipChange.ipc$dispatch("-36669314", new Object[]{this, context, intent})).booleanValue();
            }
            try {
                String dataString = intent.getDataString();
                if (dataString.startsWith(PopLayer.SCHEMA)) {
                    Intent intent2 = new Intent(PopLayer.ACTION_POP);
                    intent2.putExtra("event", dataString);
                    intent2.putExtra("param", dataString);
                    LocalBroadcastManager.getInstance(context).sendBroadcast(intent2);
                    return false;
                }
                return true;
            } catch (Throwable unused) {
                return true;
            }
        }
    }

    @Override // com.alibaba.poplayer.norm.IFaceAdapter
    public long getCurrentTimeStamp(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565464547")) {
            return ((Long) ipChange.ipc$dispatch("-565464547", new Object[]{this, context})).longValue();
        }
        if (dt1.a) {
            return System.currentTimeMillis();
        }
        return System.currentTimeMillis();
    }

    @Override // com.alibaba.poplayer.norm.IFaceAdapter
    public void navToUrl(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-178363477")) {
            ipChange.ipc$dispatch("-178363477", new Object[]{this, context, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            DMNav.from(context).toUri(str);
        }
    }

    @Override // com.alibaba.poplayer.norm.IFaceAdapter
    public void registerNavPreprocessor(Context context, PopLayer popLayer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1861339186")) {
            ipChange.ipc$dispatch("-1861339186", new Object[]{this, context, popLayer});
        } else {
            Nav.registerHooker(new b());
        }
    }

    @Override // com.alibaba.poplayer.norm.IFaceAdapter
    public void registerTrackViewTypes(Context context, PopLayer popLayer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1961742071")) {
            ipChange.ipc$dispatch("1961742071", new Object[]{this, context, popLayer});
            return;
        }
        popLayer.registerViewType(PopLayerWebView.class);
        popLayer.registerViewType(PopLayerImageView.class);
    }
}
