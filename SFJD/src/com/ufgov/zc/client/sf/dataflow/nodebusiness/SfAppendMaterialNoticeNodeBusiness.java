package com.ufgov.zc.client.sf.dataflow.nodebusiness;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import com.ufgov.zc.client.common.ListCursor;
import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.sf.appendmaterialnotice.SfAppendMaterialNoticeEditPanel;
import com.ufgov.zc.client.sf.appendmaterialnotice.SfAppendMaterialNoticeListPanel;
import com.ufgov.zc.client.sf.dataflow.ISfFlowNodeBusiness;
import com.ufgov.zc.client.sf.dataflow.SfDataFowPanel;
import com.ufgov.zc.client.sf.dataflow.SfFlowNode;
import com.ufgov.zc.client.sf.util.SfUtil;
import com.ufgov.zc.common.sf.model.SfAppendMaterialNotice;
import com.ufgov.zc.common.sf.model.SfEntrust;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.SfElementConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;

public class SfAppendMaterialNoticeNodeBusiness implements ISfFlowNodeBusiness {

  String compoId = "SF_APPEND_MATERIAL_NOTICE";

  @Override
  public void excute(SfDataFowPanel flowPanel, SfFlowNode node, SfEntrust entrust, RequestMeta meta) {
    // TODO Auto-generated method stub
    JComponent component = flowPanel.getTabComponent(compoId);
    if (component != null) {
      flowPanel.setSelectedTab(compoId, component);
    } else {
      List<SfAppendMaterialNotice> billLst = getDataLst(entrust.getEntrustId(), meta);
      if (billLst == null || billLst.size() == 0) {
        List<SfAppendMaterialNotice> lst = new ArrayList<SfAppendMaterialNotice>();
        ListCursor lstCursor = new ListCursor(lst, -1);
        SfAppendMaterialNotice agreement = new SfAppendMaterialNotice();
        agreement.setEntrustCode(entrust.getCode());
        agreement.setEntrustId(entrust.getEntrustId());
        lstCursor.getDataList().add(agreement);
        lstCursor.setCurrentObject(agreement);
        SfAppendMaterialNoticeEditPanel editPanel = new SfAppendMaterialNoticeEditPanel(flowPanel.getParentDlg(), lstCursor, null, null);
        flowPanel.addTab(editPanel, compoId);
        //editPanel.refreshWordPanel();
      } else {
        if (billLst.size() == 1) {//加载编辑界面
          List<SfAppendMaterialNotice> lst = new ArrayList<SfAppendMaterialNotice>();
          ListCursor lstCursor = new ListCursor(lst, -1);
          lstCursor.getDataList().addAll(billLst);
          SfAppendMaterialNotice e = billLst.get(0);
          lstCursor.setCurrentObject(e);
          SfAppendMaterialNoticeEditPanel editPanel = new SfAppendMaterialNoticeEditPanel(flowPanel.getParentDlg(), lstCursor, null, null);
          flowPanel.addTab(editPanel, compoId);
          //editPanel.refreshWordPanel();
        } else {//加载列表界面          
          SfAppendMaterialNoticeListPanel listPanel = new SfAppendMaterialNoticeListPanel(entrust);
          flowPanel.addTab(listPanel, compoId);
          flowPanel.setSelectedTab(compoId);
        }
      }
    }
  }

  private List<SfAppendMaterialNotice> getDataLst(BigDecimal entrustId, RequestMeta meta) {
    // TODO Auto-generated method stub
    IZcEbBaseServiceDelegate zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class,
      "zcEbBaseServiceDelegate");
    ElementConditionDto dto = new ElementConditionDto();
    dto.setDattr1("" + entrustId.intValue());
    List<SfAppendMaterialNotice> evalst = zcEbBaseServiceDelegate.queryDataForList(
      "com.ufgov.zc.server.sf.dao.SfAppendMaterialNoticeMapper.selectMainDataLst", dto, meta);
    return evalst;
  }

  @Override
  public boolean isEnable(SfEntrust entrust, RequestMeta meta) {
    // TODO Auto-generated method stub
    if (!isEnougthCondition(entrust)) {
      return false;
    }
    List evalst = getDataLst(entrust.getEntrustId(), meta);
    if (evalst != null && evalst.size() > 0) {
      if (SfUtil.haveFunc(compoId, entrust, SfElementConstants.FUNC_WATCH, meta)) {
        return true;
      }
    } else {
      if (SfUtil.canNew(compoId, entrust, meta)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 检查其业务前提条件是否满足
   * @param entrust
   * @return
   */
  private boolean isEnougthCondition(SfEntrust entrust) {
    // TODO Auto-generated method stub
    if (SfElementConstants.VAL_Y.equals(entrust.getIsAccept())) {
      return true;
    }
    return false;
  }

}
