package tb;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import cn.damai.commonbusiness.contacts.bean.IdCardTypes;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.commonbusiness.servicenotice.ServiceNote;
import cn.damai.trade.R$drawable;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.ItemPics;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.MarketingStallBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDynamicExtDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectItemDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectPicAndVideo;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticItemBaseBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.StatusNotice;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.TagBean;
import cn.damai.uikit.view.AvatarRecyclerView;
import com.ali.user.mobile.ui.WebConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class yb {
    private static transient /* synthetic */ IpChange $ipChange;

    public static CharSequence a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "691691425")) {
            return (CharSequence) ipChange.ipc$dispatch("691691425", new Object[]{str});
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            Matcher matcher = Pattern.compile("\\d+%").matcher(str);
            if (matcher.find()) {
                int start = matcher.start(0);
                int end = matcher.end(0);
                if (start >= 0 && end > start) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF8F3F")), start, end, 33);
                    return spannableStringBuilder;
                }
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static ArrayList<IdCardTypes> b(ProjectStaticDataBean projectStaticDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-574295629")) {
            return (ArrayList) ipChange.ipc$dispatch("-574295629", new Object[]{projectStaticDataBean});
        }
        ArrayList<IdCardTypes> arrayList = new ArrayList<>();
        if (projectStaticDataBean.realName.getCredentialNames() != null) {
            for (int i = 0; i < projectStaticDataBean.realName.getCredentialNames().size(); i++) {
                IdCardTypes idCardTypes = new IdCardTypes();
                idCardTypes.id = Integer.parseInt(projectStaticDataBean.realName.getCredentialNames().get(i).getId());
                idCardTypes.name = projectStaticDataBean.realName.getCredentialNames().get(i).getName();
                arrayList.add(idCardTypes);
            }
            return arrayList;
        }
        return null;
    }

    public static ProjectStaticItemBaseBean c(ProjectStaticDataBean projectStaticDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1652624062")) {
            return (ProjectStaticItemBaseBean) ipChange.ipc$dispatch("-1652624062", new Object[]{projectStaticDataBean});
        }
        if (projectStaticDataBean != null) {
            return projectStaticDataBean.getItemBase();
        }
        return null;
    }

    public static MarketingStallBean d(ProjectItemDataBean projectItemDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652247032")) {
            return (MarketingStallBean) ipChange.ipc$dispatch("652247032", new Object[]{projectItemDataBean});
        }
        if (projectItemDataBean != null) {
            return projectItemDataBean.getMarketingStall();
        }
        return null;
    }

    public static ArrayList<PicInfo> e(ProjectDynamicExtDataBean projectDynamicExtDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1621860343")) {
            return (ArrayList) ipChange.ipc$dispatch("1621860343", new Object[]{projectDynamicExtDataBean});
        }
        if (projectDynamicExtDataBean == null || projectDynamicExtDataBean.getIpCard() == null || projectDynamicExtDataBean.getIpCard().getMoments() == null) {
            return null;
        }
        return projectDynamicExtDataBean.getIpCard().getMoments().getPicVOList();
    }

    public static List<PicInfo> f(ProjectStaticDataBean projectStaticDataBean) {
        ProjectStaticItemBaseBean itemBase;
        ItemPics itemPics;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1241018011")) {
            return (List) ipChange.ipc$dispatch("1241018011", new Object[]{projectStaticDataBean});
        }
        if (projectStaticDataBean == null || (itemBase = projectStaticDataBean.getItemBase()) == null || (itemPics = itemBase.getItemPics()) == null) {
            return null;
        }
        return itemPics.itemPicList;
    }

    public static List<ProjectPicAndVideo> g(ProjectDynamicExtDataBean projectDynamicExtDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "641083460")) {
            return (List) ipChange.ipc$dispatch("641083460", new Object[]{projectDynamicExtDataBean});
        }
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        if (projectDynamicExtDataBean != null && projectDynamicExtDataBean.getIpCard() != null && projectDynamicExtDataBean.getIpCard().getMoments() != null) {
            ArrayList<VideoInfo> videoVOList = projectDynamicExtDataBean.getIpCard().getMoments().getVideoVOList();
            for (int i = 0; i < wh2.e(videoVOList); i++) {
                ProjectPicAndVideo projectPicAndVideo = new ProjectPicAndVideo();
                projectPicAndVideo.url = videoVOList.get(i).getPicUrl();
                projectPicAndVideo.isPlayIcon = true;
                projectPicAndVideo.videoInfo = videoVOList.get(i);
                arrayList.add(projectPicAndVideo);
            }
            ArrayList<PicInfo> picVOList = projectDynamicExtDataBean.getIpCard().getMoments().getPicVOList();
            for (int i2 = 0; i2 < wh2.e(picVOList); i2++) {
                ProjectPicAndVideo projectPicAndVideo2 = new ProjectPicAndVideo();
                projectPicAndVideo2.url = picVOList.get(i2).getPicUrl();
                arrayList.add(projectPicAndVideo2);
            }
        }
        return arrayList;
    }

    public static String h(ProjectStaticDataBean projectStaticDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-399968000")) {
            return (String) ipChange.ipc$dispatch("-399968000", new Object[]{projectStaticDataBean});
        }
        List<PicInfo> f = f(projectStaticDataBean);
        if (cb2.d(f)) {
            return null;
        }
        return f.get(0).getPicUrl();
    }

    public static List<ServiceNote> i(ProjectStaticDataBean projectStaticDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2100202881")) {
            return (List) ipChange.ipc$dispatch("-2100202881", new Object[]{projectStaticDataBean});
        }
        ProjectStaticItemBaseBean c = c(projectStaticDataBean);
        if (c != null) {
            return c.getServiceNotes();
        }
        return null;
    }

    public static StatusNotice j(ProjectItemDataBean projectItemDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "476803060")) {
            return (StatusNotice) ipChange.ipc$dispatch("476803060", new Object[]{projectItemDataBean});
        }
        if (projectItemDataBean != null) {
            return projectItemDataBean.getStatusNotice();
        }
        return null;
    }

    public static List<TagBean> k(ProjectStaticDataBean projectStaticDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "551577821")) {
            return (List) ipChange.ipc$dispatch("551577821", new Object[]{projectStaticDataBean});
        }
        if (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (projectStaticDataBean.getItemBase().getGeneralAgent() != null) {
            int generalType = projectStaticDataBean.getItemBase().getGeneralAgent().getGeneralType();
            if (generalType == 2) {
                arrayList.add(new TagBean(TagBean.TYPE_IMAGE, R$drawable.project_agent_con, 189, 58));
            } else if (generalType == 3) {
                arrayList.add(new TagBean(TagBean.TYPE_IMAGE, R$drawable.project_agent_all_con, WebConstant.OPEN_WEB_LOGIN_IV_REQCODE, 58));
            }
        }
        if (projectStaticDataBean.getItemBase().getShowTag() != null) {
            List<String> showTag = projectStaticDataBean.getItemBase().getShowTag();
            if (!cb2.d(showTag)) {
                for (int i = 0; i < showTag.size(); i++) {
                    arrayList.add(new TagBean(TagBean.TYPE_TEXT, showTag.get(i)));
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<VideoInfo> l(ProjectDynamicExtDataBean projectDynamicExtDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-612731455")) {
            return (ArrayList) ipChange.ipc$dispatch("-612731455", new Object[]{projectDynamicExtDataBean});
        }
        if (projectDynamicExtDataBean == null || projectDynamicExtDataBean.getIpCard() == null || projectDynamicExtDataBean.getIpCard().getMoments() == null) {
            return null;
        }
        return projectDynamicExtDataBean.getIpCard().getMoments().getVideoVOList();
    }

    public static boolean m(ProjectDynamicExtDataBean projectDynamicExtDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-479688527")) {
            return ((Boolean) ipChange.ipc$dispatch("-479688527", new Object[]{projectDynamicExtDataBean})).booleanValue();
        }
        ArrayList<VideoInfo> l = l(projectDynamicExtDataBean);
        return (l == null || l.isEmpty()) ? false : true;
    }

    public static CharSequence n(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1037904445")) {
            return (CharSequence) ipChange.ipc$dispatch("1037904445", new Object[]{str, Integer.valueOf(i)});
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        ArrayList arrayList = new ArrayList(2);
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == 165) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        int size = arrayList.size();
        if (size > 0) {
            SpannableString spannableString = new SpannableString(str);
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) arrayList.get(i3)).intValue();
                spannableString.setSpan(new AbsoluteSizeSpan(i, true), intValue, intValue + 1, 33);
            }
            return spannableString;
        }
        return str;
    }

    public static List<AvatarRecyclerView.AvatarItem> o(List<String> list, int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-883725655")) {
            return (List) ipChange.ipc$dispatch("-883725655", new Object[]{list, Integer.valueOf(i)});
        }
        if (cb2.d(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            arrayList.add(new AvatarRecyclerView.b(str));
            i2++;
            if (i2 >= i) {
                break;
            }
        }
        if (arrayList.size() > 0) {
            Collections.reverse(arrayList);
        }
        return arrayList;
    }
}
