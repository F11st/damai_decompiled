package cn.damai.search.v2.bean;

import cn.damai.search.bean.InputInfoProvider;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class InputInfo implements InputInfoProvider, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public int enterType;
    public String inputText;

    public InputInfo(String str, int i) {
        this.inputText = str;
        this.enterType = i;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-270679810")) {
            return ((Boolean) ipChange.ipc$dispatch("-270679810", new Object[]{this, obj})).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InputInfo inputInfo = (InputInfo) obj;
        return this.enterType == inputInfo.enterType && this.inputText.equals(inputInfo.inputText);
    }

    @Override // cn.damai.search.bean.InputInfoProvider
    public String getInput() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1207794583") ? (String) ipChange.ipc$dispatch("1207794583", new Object[]{this}) : this.inputText;
    }

    @Override // cn.damai.search.bean.InputInfoProvider
    public String getType4Ut() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1810662842")) {
            return (String) ipChange.ipc$dispatch("-1810662842", new Object[]{this});
        }
        switch (this.enterType) {
            case 19:
                return "2";
            case 20:
                return "4";
            case 21:
                return "1";
            case 22:
                return "3";
            default:
                return "0";
        }
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "576155829") ? ((Integer) ipChange.ipc$dispatch("576155829", new Object[]{this})).intValue() : this.inputText.hashCode() + this.enterType;
    }
}
