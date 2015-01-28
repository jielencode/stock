package com.ufgov.zc.client.sf.dataflow.nodebusiness;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import com.ufgov.zc.client.common.ListCursor;
import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.sf.charge.SfChargeEditPanel;
import com.ufgov.zc.client.sf.charge.SfChargeListPanel;
import com.ufgov.zc.client.sf.dataflow.ISfFlowNodeBusiness;
import com.ufgov.zc.client.sf.dataflow.SfDataFowPanel;
import com.ufgov.zc.client.sf.dataflow.SfFlowNode;
import com.ufgov.zc.client.sf.util.SfUtil;
import com.ufgov.zc.common.sf.model.SfCharge;
import com.ufgov.zc.common.sf.model.SfEntrust;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.SfElementConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;

public class SfChargeNodeBusiness implements ISfFlowNodeBusiness {


  String compoId="SF_CHARGE";
  @Override
  public void excute(SfDataFowPanel flowPanel, SfFlowNode node, SfEntrust entrust, RequestMeta meta) {
    // TODO Auto-generated method stub
    JComponent component=flowPanel.getTabComponent(compoId);
    if(component!=null){
      flowPanel.setSelectedTab(compoId);
    }else{
      List<SfCharge> billLst=getDataLst(entrust.getEntrustId(),meta);
      if(billLst==null || billLst.size()==0){
        List<SfCharge> lst=new ArrayList<SfCharge>();
        SfCharge e=new SfCharge();
        e.setEntrustCode(entrust.getCode());
        e.setEntrustId(entrust.getEntrustId());
        e.setName(entrust.getName()+ "鉴定费用");
        ListCursor lstCursor=new ListCursor(lst, -1);
        lstCursor.getDataList().add(e);
        lstCursor.setCurrentObject(e);
        SfChargeEditPanel editPanel=new SfChargeEditPanel(flowPanel.getParentDlg(), lstCursor, null, null);
        flowPanel.addTab(editPanel, compoId);
      }else{
        if(billLst.size()==1){//加载编辑界面
          List<SfCharge> lst=new ArrayList<SfCharge>();
          ListCursor lstCursor=new ListCursor(lst, -1);
          lstCursor.getDataList().addAll(billLst);
          SfCharge e=billLst.get(0);
          lstCursor.setCurrentObject(e);
          SfChargeEditPanel editPanel=new SfChargeEditPanel(flowPanel.getParentDlg(), lstCursor, null, null);
          flowPanel.addTab(editPanel, compoId);
        }else{//加载列表界面          
          SfChargeListPanel listPanel=new SfChargeListPanel(entrust);
          flowPanel.addTab(listPanel, compoId);
        }
      }
      flowPanel.setSelectedTab(compoId);
    }
  }
  private List<SfCharge> getDataLst(BigDecimal entrustId,RequestMeta meta) {
    // TODO Auto-generated method stub
    IZcEbBaseServiceDelegate zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class,"zcEbBaseServiceDelegate");
    ElementConditionDto dto=new ElementConditionDto();
    dto.setDattr1(""+entrustId.intValue());
    List<SfCharge> billLst = zcEbBaseServiceDelegate.queryDataForList("com.ufgov.zc.server.sf.dao.SfChargeMapper.selectMainDataLst", dto, meta);    
    return billLst;
  }

  @Override
  public boolean isEnable(SfEntrust entrust,RequestMeta meta) {
    // TODO Auto-generated method stub
    if(!isEnougthCondition(entrust)){
      return false;
    }
    List evalst=getDataLst(entrust.getEntrustId(),meta);
    if(evalst!=null && evalst.size()>0){
      if(SfUtil.haveFunc(compoId, entrust, SfElementConstants.FUNC_WATCH) ){
        return true;
      }      
    }else{
      if(SfUtil.canNew(compoId, entrust)){
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
    if(SfElementConstants.VAL_Y.equals(entrust.getIsAccept())){
      return true;
    }
    return false;
  }
}
