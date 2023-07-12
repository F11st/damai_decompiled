package cn.damai.setting.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class PermissionBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String pDesc;
    public String pName;

    public PermissionBean() {
    }

    public static List<PermissionBean> getShowList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-990356729")) {
            return (List) ipChange.ipc$dispatch("-990356729", new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PermissionBean("定位", "方便您的使用位置信息找到附近的场馆"));
        arrayList.add(new PermissionBean("相机", "帮助您使用的摄像头功能进行扫码拍照"));
        arrayList.add(new PermissionBean("通讯录", "方便您编辑通讯手机时自动填写"));
        arrayList.add(new PermissionBean("存储", "帮助您实现图片和文件的保存和读取"));
        arrayList.add(new PermissionBean("日历", "方便您将购买的演出票添加到日历提醒"));
        return arrayList;
    }

    public PermissionBean(String str, String str2) {
        this.pName = str;
        this.pDesc = str2;
    }
}
