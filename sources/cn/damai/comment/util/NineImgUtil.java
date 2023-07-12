package cn.damai.comment.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import cn.damai.comment.bean.CommentImageInfoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.CommentsVideoBean;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.uikit.view.NineGridlayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.yr2;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class NineImgUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface OnClickExtraListener {
        void onExtraLister(int i);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.comment.util.NineImgUtil$a */
    /* loaded from: classes13.dex */
    public class View$OnClickListenerC0452a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnClickExtraListener a;
        final /* synthetic */ ArrayList b;
        final /* synthetic */ Context c;
        final /* synthetic */ ArrayList d;

        View$OnClickListenerC0452a(OnClickExtraListener onClickExtraListener, ArrayList arrayList, Context context, ArrayList arrayList2) {
            this.a = onClickExtraListener;
            this.b = arrayList;
            this.c = context;
            this.d = arrayList2;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onClick(android.view.View r13) {
            /*
                r12 = this;
                com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.comment.util.NineImgUtil.View$OnClickListenerC0452a.$ipChange
                java.lang.String r1 = "1154850604"
                boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L17
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r2[r4] = r12
                r2[r3] = r13
                r0.ipc$dispatch(r1, r2)
                return
            L17:
                java.lang.Object r0 = r13.getTag()
                if (r0 != 0) goto L1e
                return
            L1e:
                java.lang.Object r0 = r13.getTag()
                if (r0 == 0) goto L43
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> L3f
                r0.<init>()     // Catch: java.lang.NumberFormatException -> L3f
                java.lang.Object r13 = r13.getTag()     // Catch: java.lang.NumberFormatException -> L3f
                r0.append(r13)     // Catch: java.lang.NumberFormatException -> L3f
                java.lang.String r13 = ""
                r0.append(r13)     // Catch: java.lang.NumberFormatException -> L3f
                java.lang.String r13 = r0.toString()     // Catch: java.lang.NumberFormatException -> L3f
                int r13 = java.lang.Integer.parseInt(r13)     // Catch: java.lang.NumberFormatException -> L3f
                r11 = r13
                goto L44
            L3f:
                r13 = move-exception
                r13.printStackTrace()
            L43:
                r11 = 0
            L44:
                cn.damai.comment.util.NineImgUtil$OnClickExtraListener r13 = r12.a
                if (r13 == 0) goto L4b
                r13.onExtraLister(r11)
            L4b:
                java.util.ArrayList r13 = r12.b
                int r13 = r13.size()
                if (r13 != r3) goto L5c
                java.util.ArrayList r13 = r12.b
                java.lang.Object r13 = r13.get(r4)
                if (r13 != 0) goto L5c
                r4 = 1
            L5c:
                if (r11 != 0) goto L6e
                if (r4 == 0) goto L6e
                cn.damai.common.util.ToastUtil r13 = cn.damai.common.util.ToastUtil.a()
                android.app.Application r0 = tb.mu0.a()
                java.lang.String r1 = "该视频还在处理中哦~"
                r13.j(r0, r1)
                goto L91
            L6e:
                if (r4 == 0) goto L84
                cn.damai.comment.util.NineImgUtil r2 = cn.damai.comment.util.NineImgUtil.this
                android.content.Context r13 = r12.c
                r4 = 0
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.util.ArrayList r7 = r12.d
                int r8 = r11 + (-1)
                r3 = r13
                r2.d(r3, r4, r6, r7, r8)
                goto L91
            L84:
                cn.damai.comment.util.NineImgUtil r5 = cn.damai.comment.util.NineImgUtil.this
                android.content.Context r6 = r12.c
                r7 = 0
                java.util.ArrayList r9 = r12.b
                java.util.ArrayList r10 = r12.d
                r5.d(r6, r7, r9, r10, r11)
            L91:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.damai.comment.util.NineImgUtil.View$OnClickListenerC0452a.onClick(android.view.View):void");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.comment.util.NineImgUtil$b */
    /* loaded from: classes13.dex */
    private static class C0453b {
        private static final NineImgUtil a = new NineImgUtil();
    }

    public static final NineImgUtil a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-962867247") ? (NineImgUtil) ipChange.ipc$dispatch("-962867247", new Object[0]) : C0453b.a;
    }

    public void b(Context context, int i, boolean z, NineGridlayout nineGridlayout, CommentsItemBean commentsItemBean, List<CommentImageInfoBean> list, OnClickExtraListener onClickExtraListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1715990146")) {
            ipChange.ipc$dispatch("1715990146", new Object[]{this, context, Integer.valueOf(i), Boolean.valueOf(z), nineGridlayout, commentsItemBean, list, onClickExtraListener});
        } else {
            c(context, i, z, false, nineGridlayout, commentsItemBean, list, onClickExtraListener, null);
        }
    }

    public void c(Context context, int i, boolean z, boolean z2, NineGridlayout nineGridlayout, CommentsItemBean commentsItemBean, List<CommentImageInfoBean> list, OnClickExtraListener onClickExtraListener, Integer num) {
        List<CommentImageInfoBean> list2 = list;
        IpChange ipChange = $ipChange;
        int i2 = 9;
        if (AndroidInstantRuntime.support(ipChange, "-1964292349")) {
            ipChange.ipc$dispatch("-1964292349", new Object[]{this, context, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), nineGridlayout, commentsItemBean, list2, onClickExtraListener, num});
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if ((list2 != null && list.size() > 0) || (commentsItemBean != null && commentsItemBean.getVideoDO() != null)) {
            if (commentsItemBean != null && commentsItemBean.getVideoDO() != null) {
                CommentsVideoBean videoDO = commentsItemBean.getVideoDO();
                if (videoDO.isVideoStatusUnReview()) {
                    NineGridlayout.Image image = new NineGridlayout.Image("VIDEO_UNDER_REVIEW_URL");
                    image.setShowPlay(true);
                    arrayList.add(image);
                    arrayList2.add(null);
                } else if (!TextUtils.isEmpty(videoDO.getCoverUrl()) && !TextUtils.isEmpty(videoDO.getUrl())) {
                    NineGridlayout.Image image2 = new NineGridlayout.Image(videoDO.getCoverUrl() + "?x-oss-process=image/resize,m_fill,h_400,w_400,limit_0");
                    image2.setShowPlay(true);
                    arrayList.add(image2);
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.setPicUrl(videoDO.getCoverUrl());
                    videoInfo.setVideoUrl(videoDO.getUrl());
                    videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
                    videoInfo.setSourceLabel(videoDO.getSourceLabel());
                    arrayList2.add(videoInfo);
                }
                i2 = 8;
            }
            if (list2 != null && list.size() > 0) {
                if (list.size() > i2) {
                    list2 = list2.subList(0, i2);
                }
                for (CommentImageInfoBean commentImageInfoBean : list2) {
                    NineGridlayout.Image image3 = new NineGridlayout.Image(commentImageInfoBean.url + "?x-oss-process=image/resize,m_fill,h_400,w_400,limit_0");
                    PicInfo picInfo = new PicInfo();
                    picInfo.setPicUrl(commentImageInfoBean.url);
                    arrayList3.add(picInfo);
                    arrayList.add(image3);
                }
            }
            if (arrayList.size() > 0) {
                nineGridlayout.setHandleSinglePic(z2);
                nineGridlayout.setRadius(num == null ? yr2.a(context, 6.0f) : num.intValue());
                nineGridlayout.setGap(yr2.a(context, 3.0f));
                nineGridlayout.setTotalWidth(i);
                nineGridlayout.setAutoShrink(z);
                nineGridlayout.updateImages(arrayList);
                nineGridlayout.setListener(new View$OnClickListenerC0452a(onClickExtraListener, arrayList2, context, arrayList3));
                return;
            }
            nineGridlayout.setVisibility(8);
            return;
        }
        nineGridlayout.setVisibility(8);
    }

    public void d(Context context, long j, ArrayList<VideoInfo> arrayList, ArrayList<PicInfo> arrayList2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-783796437")) {
            ipChange.ipc$dispatch("-783796437", new Object[]{this, context, Long.valueOf(j), arrayList, arrayList2, Integer.valueOf(i)});
        } else if (context == null) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("projectId", String.valueOf(j));
            bundle.putParcelableArrayList("video_info", arrayList);
            bundle.putParcelableArrayList("pic_info", arrayList2);
            bundle.putInt("position", i);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b("videobrowse"));
        }
    }
}
