package com.youku.live.dago.widgetlib.view.management;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dago.widgetlib.view.management.LiveManageDialog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class BanSpeakDialog extends LiveManageDialog {
    private static transient /* synthetic */ IpChange $ipChange;

    public BanSpeakDialog(Context context, LiveManageController liveManageController) {
        super(context, liveManageController);
    }

    @Override // com.youku.live.dago.widgetlib.view.management.LiveManageDialog
    public List<LiveManageDialog.DialogItemEntry> getDialogItems() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373234462")) {
            return (List) ipChange.ipc$dispatch("373234462", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LiveManageDialog.DialogItemEntry() { // from class: com.youku.live.dago.widgetlib.view.management.BanSpeakDialog.1
            {
                this.itemName = "10分钟";
                this.listener = new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.view.management.BanSpeakDialog.1.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1266639050")) {
                            ipChange2.ipc$dispatch("-1266639050", new Object[]{this, view});
                            return;
                        }
                        BanSpeakDialog.this.dismiss();
                        LiveManageController liveManageController = BanSpeakDialog.this.mLiveManageController;
                        if (liveManageController != null) {
                            liveManageController.requestUserBanSpeak(1);
                        }
                    }
                };
            }
        });
        arrayList.add(new LiveManageDialog.DialogItemEntry() { // from class: com.youku.live.dago.widgetlib.view.management.BanSpeakDialog.2
            {
                this.itemName = "30分钟";
                this.listener = new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.view.management.BanSpeakDialog.2.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "458841847")) {
                            ipChange2.ipc$dispatch("458841847", new Object[]{this, view});
                            return;
                        }
                        BanSpeakDialog.this.dismiss();
                        LiveManageController liveManageController = BanSpeakDialog.this.mLiveManageController;
                        if (liveManageController != null) {
                            liveManageController.requestUserBanSpeak(2);
                        }
                    }
                };
            }
        });
        arrayList.add(new LiveManageDialog.DialogItemEntry() { // from class: com.youku.live.dago.widgetlib.view.management.BanSpeakDialog.3
            {
                this.itemName = "1小时";
                this.listener = new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.view.management.BanSpeakDialog.3.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-2110644552")) {
                            ipChange2.ipc$dispatch("-2110644552", new Object[]{this, view});
                            return;
                        }
                        BanSpeakDialog.this.dismiss();
                        LiveManageController liveManageController = BanSpeakDialog.this.mLiveManageController;
                        if (liveManageController != null) {
                            liveManageController.requestUserBanSpeak(3);
                        }
                    }
                };
            }
        });
        arrayList.add(new LiveManageDialog.DialogItemEntry() { // from class: com.youku.live.dago.widgetlib.view.management.BanSpeakDialog.4
            {
                this.itemName = "1天";
                this.listener = new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.view.management.BanSpeakDialog.4.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-385163655")) {
                            ipChange2.ipc$dispatch("-385163655", new Object[]{this, view});
                            return;
                        }
                        BanSpeakDialog.this.dismiss();
                        LiveManageController liveManageController = BanSpeakDialog.this.mLiveManageController;
                        if (liveManageController != null) {
                            liveManageController.requestUserBanSpeak(4);
                        }
                    }
                };
            }
        });
        return arrayList;
    }

    @Override // com.youku.live.dago.widgetlib.view.management.LiveManageDialog
    public String getDialogTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1848942001") ? (String) ipChange.ipc$dispatch("-1848942001", new Object[]{this}) : "禁言时间";
    }

    @Override // com.youku.live.dago.widgetlib.view.management.LiveManageDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1943890564")) {
            ipChange.ipc$dispatch("1943890564", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        if (AppContextUtils.getApp().getResources().getConfiguration().orientation == 2) {
            setListViewHeight(UIUtil.dip2px(150));
        }
    }
}
