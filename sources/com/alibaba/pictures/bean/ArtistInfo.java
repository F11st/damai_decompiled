package com.alibaba.pictures.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<TextInfo> fansCountInfoList;
    public String fansTips;
    public String headPic;
    public String id;
    private boolean isSplit = false;
    public String name;
    public List<TextInfo> sellCountInfoList;
    public String showVipTag;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class TextInfo implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        public static final String NUM_TYPE = "NUM";
        public static final String TEXT_TYPE = "TEXT";
        public String value;
        public String valueType;

        public boolean isNumStyle() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "53666864") ? ((Boolean) ipChange.ipc$dispatch("53666864", new Object[]{this})).booleanValue() : "NUM".equalsIgnoreCase(this.valueType);
        }
    }

    private List<TextInfo> getNewList(List<TextInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-952350834")) {
            return (List) ipChange.ipc$dispatch("-952350834", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        if (cb2.g(list)) {
            for (TextInfo textInfo : list) {
                String str = textInfo.value;
                if (textInfo.isNumStyle() && !TextUtils.isEmpty(str) && str.length() >= 2) {
                    boolean endsWith = str.endsWith("万");
                    boolean endsWith2 = str.endsWith("场");
                    if (!endsWith && !endsWith2) {
                        arrayList.add(textInfo);
                    } else {
                        String substring = str.substring(0, str.length() - 1);
                        TextInfo textInfo2 = new TextInfo();
                        textInfo2.value = substring;
                        textInfo2.valueType = "NUM";
                        arrayList.add(textInfo2);
                        TextInfo textInfo3 = new TextInfo();
                        textInfo3.value = endsWith ? "万" : "场";
                        textInfo3.valueType = "TEXT";
                        arrayList.add(textInfo3);
                    }
                } else {
                    arrayList.add(textInfo);
                }
            }
        }
        return arrayList;
    }

    public boolean isShowVipTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-771760592") ? ((Boolean) ipChange.ipc$dispatch("-771760592", new Object[]{this})).booleanValue() : "true".equalsIgnoreCase(this.showVipTag);
    }

    public void splitTextInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1756185701")) {
            ipChange.ipc$dispatch("1756185701", new Object[]{this});
        } else if (this.isSplit) {
        } else {
            this.isSplit = true;
            this.fansCountInfoList = getNewList(this.fansCountInfoList);
            this.sellCountInfoList = getNewList(this.sellCountInfoList);
        }
    }
}
