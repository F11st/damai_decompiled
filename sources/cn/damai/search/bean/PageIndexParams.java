package cn.damai.search.bean;

import android.text.TextUtils;
import cn.damai.search.bean.youku.SearchResultBeanV2;
import cn.damai.search.helper.SearchHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class PageIndexParams implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public int mPageHomeIndex = 1;
    public int mProjectNextPageIndex = 2;
    public int mNoteNextPageIndex = 2;
    public boolean isProjectEnded = false;
    public boolean isImageTextEnd = false;
    public int mImageTextItemCount = 0;
    public int mProjectItemCount = 0;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public enum PageRequestType {
        HOME,
        NOTE_NEXT_PAGE,
        PROJECT_NEXT_PAGE,
        NONE
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class Params implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public final String categories;
        public final int pageIndex;

        public Params(int i, String str) {
            this.pageIndex = i;
            this.categories = str;
        }

        public boolean isHomeRequest() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1670119031") ? ((Boolean) ipChange.ipc$dispatch("1670119031", new Object[]{this})).booleanValue() : this.pageIndex == 1;
        }

        public boolean isNoteNextPageRequest() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1188214900") ? ((Boolean) ipChange.ipc$dispatch("-1188214900", new Object[]{this})).booleanValue() : this.pageIndex > 1 && TextUtils.equals(this.categories, "21");
        }

        public boolean isProjectNextPageRequest() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1190018857") ? ((Boolean) ipChange.ipc$dispatch("-1190018857", new Object[]{this})).booleanValue() : this.pageIndex > 1 && TextUtils.equals(this.categories, "12");
        }
    }

    public Params getHomePageParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1042764754") ? (Params) ipChange.ipc$dispatch("1042764754", new Object[]{this}) : new Params(this.mPageHomeIndex, "");
    }

    public Params getNoteNextPageParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1592678252") ? (Params) ipChange.ipc$dispatch("1592678252", new Object[]{this}) : new Params(this.mNoteNextPageIndex, "21");
    }

    public Params getProjectNextPageParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-405476035") ? (Params) ipChange.ipc$dispatch("-405476035", new Object[]{this}) : new Params(this.mProjectNextPageIndex, "12");
    }

    public PageRequestType getUiLoadMorePageType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1722278456")) {
            return (PageRequestType) ipChange.ipc$dispatch("-1722278456", new Object[]{this});
        }
        if (this.mPageHomeIndex <= 1) {
            return PageRequestType.NONE;
        }
        int i = this.mImageTextItemCount;
        if (i > 0 && !this.isImageTextEnd) {
            return PageRequestType.NOTE_NEXT_PAGE;
        }
        if (i == 0 && this.isImageTextEnd && !this.isProjectEnded) {
            return PageRequestType.PROJECT_NEXT_PAGE;
        }
        return PageRequestType.NONE;
    }

    public boolean isCanShowTabLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "314825875") ? ((Boolean) ipChange.ipc$dispatch("314825875", new Object[]{this})).booleanValue() : this.mProjectItemCount > 0 && this.mImageTextItemCount > 0;
    }

    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58137232")) {
            ipChange.ipc$dispatch("-58137232", new Object[]{this});
            return;
        }
        this.mPageHomeIndex = 1;
        this.mProjectNextPageIndex = 2;
        this.mNoteNextPageIndex = 2;
        this.isProjectEnded = false;
        this.isImageTextEnd = false;
        this.mImageTextItemCount = 0;
        this.mProjectItemCount = 0;
    }

    public void updateNextPageParams(Params params, SearchResultBeanV2 searchResultBeanV2) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "1626355908")) {
            ipChange.ipc$dispatch("1626355908", new Object[]{this, params, searchResultBeanV2});
        } else if (params == null) {
        } else {
            if (params.isHomeRequest()) {
                this.mPageHomeIndex++;
                this.isProjectEnded = searchResultBeanV2 == null || searchResultBeanV2.isEnd;
                this.isImageTextEnd = (searchResultBeanV2 == null || searchResultBeanV2.isImageTextEnd) ? true : true;
                this.mImageTextItemCount = SearchHelper.j(searchResultBeanV2);
                this.mProjectItemCount = SearchHelper.l(true, searchResultBeanV2);
            } else if (params.isNoteNextPageRequest()) {
                this.mNoteNextPageIndex++;
                this.isImageTextEnd = (searchResultBeanV2 == null || searchResultBeanV2.isImageTextEnd) ? true : true;
                this.mImageTextItemCount += SearchHelper.j(searchResultBeanV2);
            } else {
                this.mProjectNextPageIndex++;
                if (searchResultBeanV2 != null && !searchResultBeanV2.isEnd) {
                    z2 = false;
                }
                this.isProjectEnded = z2;
                this.mProjectItemCount = SearchHelper.l(false, searchResultBeanV2);
            }
        }
    }
}
