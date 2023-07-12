package com.youku.live.livesdk.wkit.widget.base;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class LiveBaseWidget extends BaseWidget implements IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<String> mDataHandlerKeyList;

    private List<String> getDHKeyList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-238646687")) {
            return (List) ipChange.ipc$dispatch("-238646687", new Object[]{this});
        }
        if (this.mDataHandlerKeyList == null) {
            synchronized (this) {
                if (this.mDataHandlerKeyList == null) {
                    this.mDataHandlerKeyList = new LinkedList();
                }
            }
        }
        return this.mDataHandlerKeyList;
    }

    public void addDataListener(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2122793900")) {
            ipChange.ipc$dispatch("2122793900", new Object[]{this, str});
            return;
        }
        getDHKeyList().add(str);
        getEngineInstance().addDataHandler(str, this);
    }

    protected void clearDataHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1902620842")) {
            ipChange.ipc$dispatch("-1902620842", new Object[]{this});
            return;
        }
        List<String> list = this.mDataHandlerKeyList;
        IEngineInstance engineInstance = getEngineInstance();
        this.mDataHandlerKeyList = null;
        if (list == null || engineInstance == null) {
            return;
        }
        for (String str : list) {
            if (str != null) {
                engineInstance.removeDataHandler(str, this);
            }
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol.IWidget, com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-599712185")) {
            ipChange.ipc$dispatch("-599712185", new Object[]{this});
            return;
        }
        clearDataHandler();
        super.destroy();
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-197973928")) {
            ipChange.ipc$dispatch("-197973928", new Object[]{this, str, obj, obj2});
        }
    }

    protected boolean setDataHandler(String[] strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1586119272")) {
            return ((Boolean) ipChange.ipc$dispatch("-1586119272", new Object[]{this, strArr})).booleanValue();
        }
        List<String> dHKeyList = getDHKeyList();
        IEngineInstance engineInstance = getEngineInstance();
        if (dHKeyList == null || strArr == null || engineInstance == null) {
            return false;
        }
        for (String str : strArr) {
            if (str != null) {
                dHKeyList.add(str);
                engineInstance.addDataHandler(str, this);
            }
        }
        return true;
    }

    protected boolean setDataHandler(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-365498208")) {
            return ((Boolean) ipChange.ipc$dispatch("-365498208", new Object[]{this, list})).booleanValue();
        }
        List<String> dHKeyList = getDHKeyList();
        IEngineInstance engineInstance = getEngineInstance();
        if (dHKeyList == null || list == null || engineInstance == null) {
            return false;
        }
        dHKeyList.addAll(list);
        for (String str : list) {
            if (str != null) {
                engineInstance.addDataHandler(str, this);
            }
        }
        return true;
    }
}
