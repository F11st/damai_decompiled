package tb;

import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class vo0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private ArrayList<Image> b;

    public vo0(String str) {
        this.a = str;
    }

    public void a(Image image) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1225290211")) {
            ipChange.ipc$dispatch("-1225290211", new Object[]{this, image});
        } else if (image == null || !wh2.i(image.getPath())) {
        } else {
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            this.b.add(image);
        }
    }

    public ArrayList<Image> b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1749541843") ? (ArrayList) ipChange.ipc$dispatch("1749541843", new Object[]{this}) : this.b;
    }

    public String c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "768721114") ? (String) ipChange.ipc$dispatch("768721114", new Object[]{this}) : this.a;
    }

    public void d(ArrayList<Image> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1343461155")) {
            ipChange.ipc$dispatch("-1343461155", new Object[]{this, arrayList});
        } else {
            this.b = arrayList;
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "866414953")) {
            return (String) ipChange.ipc$dispatch("866414953", new Object[]{this});
        }
        return "Folder{name='" + this.a + "', images=" + this.b + '}';
    }

    public vo0(String str, ArrayList<Image> arrayList) {
        this.a = str;
        this.b = arrayList;
    }
}
