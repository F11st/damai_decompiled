package cn.damai.search.bean.youku;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.search.bean.youku.ArtificialProxy;
import cn.damai.search.bean.youku.SearchResultBeanYouKu;
import cn.damai.tetris.component.discover.bean.NoteBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.cs;
import tb.g82;
import tb.jm1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchNoteBean implements ArtificialProxy {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public String imgUrl;
    public int index;
    public boolean isShowVideoTag;
    public CharSequence title;

    public SearchNoteBean() {
    }

    public static List<ArtificialProxy> transfer(List<SearchResultBeanYouKu.ListBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1449388545")) {
            return (List) ipChange.ipc$dispatch("1449388545", new Object[]{list});
        }
        if (cb2.d(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            SearchNoteBean searchNoteBean = new SearchNoteBean(list.get(i), i);
            if (searchNoteBean.isValid()) {
                arrayList.add(searchNoteBean);
            }
        }
        return arrayList;
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1591088135") ? (String) ipChange.ipc$dispatch("1591088135", new Object[]{this}) : this.id;
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public String getImgUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2018355560") ? (String) ipChange.ipc$dispatch("-2018355560", new Object[]{this}) : this.imgUrl;
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public CharSequence getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2103414404") ? (CharSequence) ipChange.ipc$dispatch("-2103414404", new Object[]{this}) : this.title;
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public PageSpec getToPageSpec() {
        Bundle bundle;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "272592733")) {
            return (PageSpec) ipChange.ipc$dispatch("272592733", new Object[]{this});
        }
        String str = null;
        if (TextUtils.isEmpty(this.id)) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putString("contentId", this.id);
            str = new Uri.Builder().scheme("damai").authority(cs.DISCOVER_CONTENT_DETAIL).build().toString();
            bundle = bundle2;
        }
        return new PageSpec(str, bundle);
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public ArtificialProxy.Type getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1636834568") ? (ArtificialProxy.Type) ipChange.ipc$dispatch("1636834568", new Object[]{this}) : ArtificialProxy.Type.NOTE;
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public int index() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1953499061") ? ((Integer) ipChange.ipc$dispatch("-1953499061", new Object[]{this})).intValue() : this.index;
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public boolean isShowVideoTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-265856802") ? ((Boolean) ipChange.ipc$dispatch("-265856802", new Object[]{this})).booleanValue() : this.isShowVideoTag;
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "974391036") ? ((Boolean) ipChange.ipc$dispatch("974391036", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.id);
    }

    public SearchNoteBean(String str, String str2, CharSequence charSequence, int i, boolean z) {
        this.imgUrl = str;
        this.id = str2;
        this.title = charSequence;
        this.index = i;
        this.isShowVideoTag = z;
    }

    public SearchNoteBean(SearchResultBeanYouKu.ListBean listBean, int i) {
        if (listBean == null) {
            return;
        }
        NoteBean a = g82.a(listBean, i);
        this.id = listBean.id;
        String str = listBean.content_image;
        this.imgUrl = str;
        if (TextUtils.isEmpty(str)) {
            this.imgUrl = a.pic;
            String videoCoverUrl = a.getVideoCoverUrl();
            if (!TextUtils.isEmpty(videoCoverUrl)) {
                this.imgUrl = videoCoverUrl;
            }
        }
        if (TextUtils.isEmpty(this.id)) {
            this.id = a.id;
        }
        this.title = a.content;
        this.isShowVideoTag = a.isShowVideoIcon();
        this.index = jm1.j(listBean.idx, 0);
    }
}
