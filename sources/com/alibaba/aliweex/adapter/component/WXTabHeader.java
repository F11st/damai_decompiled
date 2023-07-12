package com.alibaba.aliweex.adapter.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.alibaba.aliweex.adapter.view.Elevator;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.utils.WXJsonUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.ud0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXTabHeader extends WXVContainer {
    private WXVContainer mContainer;
    private boolean mDataChanged;
    public Elevator mElevator;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class a implements Elevator.IWATabHeaderChanged {
        a() {
        }

        @Override // com.alibaba.aliweex.adapter.view.Elevator.IWATabHeaderChanged
        public void changed() {
            WXTabHeader.this.invalidate();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class b implements Elevator.ElevatorOnClicklistener {
        b() {
        }

        @Override // com.alibaba.aliweex.adapter.view.Elevator.ElevatorOnClicklistener
        public void OnClick(ud0 ud0Var) {
            HashMap hashMap = new HashMap();
            hashMap.put("index", ud0Var.a() + "");
            WXLogUtils.d("updateAttrs", "click:" + ud0Var.a());
            WXTabHeader.this.getInstance().fireEvent(WXTabHeader.this.getRef(), "select", hashMap);
        }
    }

    public WXTabHeader(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mContainer = wXVContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    public void invalidate() {
        WXVContainer wXVContainer = this.mContainer;
        if (wXVContainer == null || wXVContainer.getHostView() == 0) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.mContainer.getHostView();
        viewGroup.invalidate(getHostView().getLeft(), getHostView().getTop(), getHostView().getRight(), viewGroup.getScrollY() + getHostView().getHeight());
    }

    private void refreshList(String str) {
        Elevator elevator = this.mElevator;
        if (elevator == null) {
            return;
        }
        elevator.v((int) getLayoutHeight());
        try {
            List<String> list = WXJsonUtils.getList(str, String.class);
            if (list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (String str2 : list) {
                    arrayList.add(new ud0(str2));
                }
                this.mElevator.r(arrayList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(String str) {
        super.addEvent(str);
        if (getEvents() == null || !getEvents().contains("select")) {
            return;
        }
        getEvents().add(str);
        this.mElevator.p(new b());
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent
    public void bindData(WXComponent wXComponent) {
        super.bindData(wXComponent);
        this.mElevator.n();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected View initComponentHostView(@NonNull Context context) {
        Elevator elevator = new Elevator(context);
        this.mElevator = elevator;
        elevator.q(new a());
        return this.mElevator.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onFinishLayout() {
        super.bindData(this);
        this.mElevator.n();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    @WXComponentProp(name = "backgroundColor")
    public void setBackgroundColor(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            return;
        }
        this.mElevator.o(str);
    }

    @WXComponentProp(name = "data")
    public void setData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mDataChanged = true;
        refreshList(str);
    }

    @WXComponentProp(name = WXTabbar.SELECT_INDEX)
    public void setSelectedIndex(String str) {
        if (str == null || !TextUtils.isDigitsOnly(str.trim())) {
            return;
        }
        int parseInt = Integer.parseInt(str.trim());
        if (parseInt >= 0) {
            this.mElevator.s(parseInt);
        }
        WXLogUtils.d("updateAttrs", "" + parseInt);
    }

    @WXComponentProp(name = "textColor")
    public void setTextColor(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            return;
        }
        this.mElevator.t(str);
    }

    @WXComponentProp(name = "textHighlightColor")
    public void setTextHighlightColor(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            return;
        }
        this.mElevator.u(str);
    }
}
