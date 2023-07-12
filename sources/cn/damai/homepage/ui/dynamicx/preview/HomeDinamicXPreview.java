package cn.damai.homepage.ui.dynamicx.preview;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.C6387n;
import com.taobao.android.preview.DXTemplatePreviewActivity;
import tb.lu;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class HomeDinamicXPreview implements DXTemplatePreviewActivity.DXPreviewInterface {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.taobao.android.preview.DXTemplatePreviewActivity.DXPreviewInterface
    public void previewEngineDidInitialized(C6387n c6387n) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-820565282")) {
            ipChange.ipc$dispatch("-820565282", new Object[]{this, c6387n});
        } else {
            c6387n.m(lu.DX_DMHOMETAGVIEW, new lu.C9422a());
        }
    }
}
