package cn.damai.videobrowse;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.videobrowse.fragment.ImageFragment;
import cn.damai.videobrowse.fragment.VideoFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class VideoImageAdapter extends FragmentStatePagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<PicInfo> a;
    private List<VideoInfo> b;
    private int c;
    private int d;
    private String e;

    public VideoImageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    private Fragment a(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-479911609") ? (Fragment) ipChange.ipc$dispatch("-479911609", new Object[]{this, Integer.valueOf(i)}) : ImageFragment.getInstance(this.a.get(i - this.c).getPicUrl());
    }

    private Fragment b(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1859648985") ? (Fragment) ipChange.ipc$dispatch("-1859648985", new Object[]{this, Integer.valueOf(i)}) : VideoFragment.getInstance(this.e, this.b.get(i));
    }

    private Fragment c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1243374653")) {
            return (Fragment) ipChange.ipc$dispatch("1243374653", new Object[]{this, Integer.valueOf(i)});
        }
        int d = d(i);
        if (d == 0) {
            return b(i);
        }
        if (d == 1) {
            return a(i);
        }
        return null;
    }

    private int d(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2005468274")) {
            return ((Integer) ipChange.ipc$dispatch("-2005468274", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (i < this.c) {
            return 0;
        }
        return (this.d <= 0 || i >= getCount()) ? -1 : 1;
    }

    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-393482313")) {
            ipChange.ipc$dispatch("-393482313", new Object[]{this});
            return;
        }
        List<VideoInfo> list = this.b;
        if (list != null && !list.isEmpty()) {
            this.c = this.b.size();
        } else {
            this.c = 0;
        }
        List<PicInfo> list2 = this.a;
        if (list2 != null && !list2.isEmpty()) {
            this.d = this.a.size();
        } else {
            this.d = 0;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1329940359") ? ((Integer) ipChange.ipc$dispatch("-1329940359", new Object[]{this})).intValue() : this.c + this.d;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-588472915") ? (Fragment) ipChange.ipc$dispatch("-588472915", new Object[]{this, Integer.valueOf(i)}) : c(i);
    }

    public VideoImageAdapter(FragmentManager fragmentManager, String str, List<VideoInfo> list, List<PicInfo> list2) {
        this(fragmentManager);
        this.b = list;
        this.a = list2;
        this.e = str;
        e();
    }
}
