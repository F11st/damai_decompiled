package cn.damai.tetris.component.star.content.base;

import android.text.TextUtils;
import android.util.Pair;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.tetris.component.star.content.base.ContentBaseContract;
import cn.damai.tetris.component.star.content.base.bean.ContentFreeRootBean;
import cn.damai.tetris.component.star.content.base.bean.ContentItemBean;
import cn.damai.tetris.componentplugin.OnBizListener;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.request.TetrisRequest;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.cb2;
import tb.m61;
import tb.xl2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ContentBaseModel extends AbsModel implements ContentBaseContract.Model<BaseNode> {
    private static transient /* synthetic */ IpChange $ipChange;
    List<ContentItemBean> itemList;
    ContentFreeRootBean rootBean;

    /* JADX INFO: Access modifiers changed from: private */
    public void appendData(ContentFreeRootBean contentFreeRootBean, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "10525009")) {
            ipChange.ipc$dispatch("10525009", new Object[]{this, contentFreeRootBean, str});
        } else if (contentFreeRootBean == null) {
        } else {
            if (xl2.DM_BASE_CONTENT_VIP.equalsIgnoreCase(str) && contentFreeRootBean.getContents() != null && contentFreeRootBean.getContents().size() > 0) {
                this.rootBean.setButton(null);
            }
            this.rootBean.setArtistVip(contentFreeRootBean.getArtistVip());
            this.rootBean.setHasNext(contentFreeRootBean.getHasNext());
            this.rootBean.setType(contentFreeRootBean.getType());
            this.itemList.addAll(contentFreeRootBean.getContents());
            this.rootBean.setContents(this.itemList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ContentFreeRootBean getRootBean(BaseResponse baseResponse, String str) {
        ContentFreeRootBean contentFreeRootBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175036790")) {
            return (ContentFreeRootBean) ipChange.ipc$dispatch("-1175036790", new Object[]{this, baseResponse, str});
        }
        if (baseResponse != null && !TextUtils.isEmpty(str)) {
            ArrayList<BaseLayer> arrayList = baseResponse.layers;
            if (!cb2.d(arrayList)) {
                Iterator<BaseLayer> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    List<BaseSection> sections = it.next().getSections();
                    if (!cb2.d(sections)) {
                        for (BaseSection baseSection : sections) {
                            if (TextUtils.equals(baseSection.getComponentId(), str)) {
                                NodeData item = baseSection.getItem();
                                if (item == null || (contentFreeRootBean = (ContentFreeRootBean) m61.d(item, ContentFreeRootBean.class)) == null) {
                                    break;
                                }
                                return contentFreeRootBean;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return null;
    }

    @Override // cn.damai.tetris.component.star.content.base.ContentBaseContract.Model
    public ContentFreeRootBean allData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-603904862") ? (ContentFreeRootBean) ipChange.ipc$dispatch("-603904862", new Object[]{this}) : this.rootBean;
    }

    @Override // cn.damai.tetris.component.star.content.base.ContentBaseContract.Model
    public boolean hasNext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2108934005") ? ((Boolean) ipChange.ipc$dispatch("2108934005", new Object[]{this})).booleanValue() : this.rootBean.getHasNext();
    }

    @Override // cn.damai.tetris.component.star.content.base.ContentBaseContract.Model
    public List<ContentItemBean> listData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-242068637") ? (List) ipChange.ipc$dispatch("-242068637", new Object[]{this}) : this.itemList;
    }

    @Override // cn.damai.tetris.component.star.content.base.ContentBaseContract.Model
    public void load(final OnBizListener<Pair<BaseResponse, ContentFreeRootBean>> onBizListener, final String str, TetrisRequest tetrisRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1026874959")) {
            ipChange.ipc$dispatch("1026874959", new Object[]{this, onBizListener, str, tetrisRequest});
        } else {
            tetrisRequest.request(new DMMtopRequestListener<BaseResponse>(BaseResponse.class) { // from class: cn.damai.tetris.component.star.content.base.ContentBaseModel.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str2, String str3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "616758064")) {
                        ipChange2.ipc$dispatch("616758064", new Object[]{this, str2, str3});
                    } else {
                        onBizListener.onFail(str2, str3);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(BaseResponse baseResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1029180504")) {
                        ipChange2.ipc$dispatch("1029180504", new Object[]{this, baseResponse});
                        return;
                    }
                    ContentFreeRootBean rootBean = ContentBaseModel.this.getRootBean(baseResponse, str);
                    ContentBaseModel.this.appendData(rootBean, str);
                    onBizListener.onSuccess(new Pair(baseResponse, rootBean));
                }
            });
        }
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-16048765")) {
            ipChange.ipc$dispatch("-16048765", new Object[]{this, baseNode});
            return;
        }
        try {
            if (baseNode.getItem() != null) {
                ContentFreeRootBean contentFreeRootBean = (ContentFreeRootBean) JSON.parseObject(baseNode.getItem().toJSONString(), ContentFreeRootBean.class);
                this.rootBean = contentFreeRootBean;
                List<ContentItemBean> contents = contentFreeRootBean.getContents();
                this.itemList = contents;
                this.rootBean.setContents(contents);
                List<ContentItemBean> list = this.itemList;
                if (list == null || list.size() <= 0) {
                    return;
                }
                this.rootBean.setButton(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
