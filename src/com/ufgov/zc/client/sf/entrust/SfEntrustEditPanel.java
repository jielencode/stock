package com.ufgov.zc.client.sf.entrust;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.DefaultKeyboardFocusManager;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import org.apache.log4j.Logger;

import com.ufgov.smartclient.common.UIUtilities;
import com.ufgov.smartclient.component.table.fixedtable.JPageableFixedTable;
import com.ufgov.zc.client.common.AsOptionMeta;
import com.ufgov.zc.client.common.BillElementMeta;
import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.ListCursor;
import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.common.WorkEnv;
import com.ufgov.zc.client.common.converter.sf.SfEntrustToTableModelConverter;
import com.ufgov.zc.client.component.AsValComboBox;
import com.ufgov.zc.client.component.GkBaseDialog;
import com.ufgov.zc.client.component.GkCommentDialog;
import com.ufgov.zc.client.component.GkCommentUntreadDialog;
import com.ufgov.zc.client.component.JFuncToolBar;
import com.ufgov.zc.client.component.JTablePanel;
import com.ufgov.zc.client.component.button.AddButton;
import com.ufgov.zc.client.component.button.CallbackButton;
import com.ufgov.zc.client.component.button.DeleteButton;
import com.ufgov.zc.client.component.button.EditButton;
import com.ufgov.zc.client.component.button.ExitButton;
import com.ufgov.zc.client.component.button.FuncButton;
import com.ufgov.zc.client.component.button.ImportButton;
import com.ufgov.zc.client.component.button.NextButton;
import com.ufgov.zc.client.component.button.PreviousButton;
import com.ufgov.zc.client.component.button.PrintButton;
import com.ufgov.zc.client.component.button.SaveButton;
import com.ufgov.zc.client.component.button.SaveSendButton;
import com.ufgov.zc.client.component.button.SendButton;
import com.ufgov.zc.client.component.button.SendGkButton;
import com.ufgov.zc.client.component.button.SubaddButton;
import com.ufgov.zc.client.component.button.SubdelButton;
import com.ufgov.zc.client.component.button.SubinsertButton;
import com.ufgov.zc.client.component.button.SuggestAuditPassButton;
import com.ufgov.zc.client.component.button.TraceButton;
import com.ufgov.zc.client.component.button.UnauditButton;
import com.ufgov.zc.client.component.button.UntreadButton;
import com.ufgov.zc.client.component.sf.fieldeditor.SfEntrustorNewFieldEditor;
import com.ufgov.zc.client.component.sf.fieldeditor.SfJdTargetNewFieldEditor;
import com.ufgov.zc.client.component.table.celleditor.MoneyCellEditor;
import com.ufgov.zc.client.component.table.celleditor.TextCellEditor;
import com.ufgov.zc.client.component.table.cellrenderer.NumberCellRenderer;
import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;
import com.ufgov.zc.client.component.zc.fieldeditor.AsValFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.AutoNumFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.DateFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.ForeignEntityFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.IntFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.NewLineFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextAreaFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.zc.client.sf.component.JClosableTabbedPane;
import com.ufgov.zc.client.sf.dataflow.SfDataFlowDialog;
import com.ufgov.zc.client.sf.entrustor.SfEntrustorHandler;
import com.ufgov.zc.client.sf.jdtarget.SfJdTargethandler;
import com.ufgov.zc.client.sf.util.SfJdPersonSelectHandler;
import com.ufgov.zc.client.util.SwingUtil;
import com.ufgov.zc.client.zc.ButtonStatus;
import com.ufgov.zc.client.zc.ZcUtil;
import com.ufgov.zc.common.sf.model.SfEntrust;
import com.ufgov.zc.common.sf.model.SfEntrustor;
import com.ufgov.zc.common.sf.model.SfJdPerson;
import com.ufgov.zc.common.sf.model.SfJdTarget;
import com.ufgov.zc.common.sf.model.SfMaterials;
import com.ufgov.zc.common.sf.model.SfReceipt;
import com.ufgov.zc.common.sf.publish.ISfEntrustServiceDelegate;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.SfElementConstants;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.util.DigestUtil;
import com.ufgov.zc.common.system.util.ObjectUtil;
import com.ufgov.zc.common.zc.model.ZcBaseBill;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;

public class SfEntrustEditPanel extends AbstractMainSubEditPanel {
 

  /**
   * 
   */
  private static final long serialVersionUID = -251257356778588783L;

  private static final Logger logger = Logger.getLogger(SfEntrustEditPanel.class);

  protected String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

  protected RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private static String compoId = "SF_ENTRUST";

  protected FuncButton saveButton = new SaveButton();

  protected FuncButton addButton = new AddButton();

  protected FuncButton editButton = new EditButton();

  private FuncButton traceButton = new TraceButton();

  protected FuncButton callbackButton = new CallbackButton();

  protected FuncButton deleteButton = new DeleteButton();

  private FuncButton previousButton = new PreviousButton();

  private FuncButton nextButton = new NextButton();

  private FuncButton exitButton = new ExitButton();

  private FuncButton saveAndSendButton = new SaveSendButton();

  protected FuncButton sendButton = new SendButton();

  public FuncButton printButton = new PrintButton();

  public FuncButton importButton = new ImportButton();

  //送国库
  private FuncButton sendGkButton = new SendGkButton();

  // 工作流填写意见审核通过
  protected FuncButton suggestPassButton = new SuggestAuditPassButton();

  // 工作流销审
  protected FuncButton unAuditButton = new UnauditButton();

  // 工作流退回
  protected FuncButton unTreadButton = new UntreadButton();

  protected ListCursor<SfEntrust> listCursor;

  private SfEntrust oldentrust;

  public SfEntrustListPanel listPanel;

  protected SfEntrustEditPanel self = this;

  protected GkBaseDialog parent;

  private ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();

  private BillElementMeta mainBillElementMeta = BillElementMeta.getBillElementMetaWithoutNd(compoId);

  private ElementConditionDto eaccDto = new ElementConditionDto();  

  protected JTablePanel materialsTablePanel = new JTablePanel();

  protected IZcEbBaseServiceDelegate zcEbBaseServiceDelegate ;
  
  private ISfEntrustServiceDelegate sfEntrustServiceDelegate ;
  
  public SfEntrustEditPanel(GkBaseDialog parent, ListCursor listCursor, String tabStatus, SfEntrustListPanel listPanel) {
    // TODO Auto-generated constructor stub
    super(SfEntrustEditPanel.class, BillElementMeta.getBillElementMetaWithoutNd(compoId));
    zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class,"zcEbBaseServiceDelegate");
     sfEntrustServiceDelegate = (ISfEntrustServiceDelegate) ServiceFactory.create(ISfEntrustServiceDelegate.class,"sfEntrustServiceDelegate");
      
    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate(compoId),
      TitledBorder.CENTER, TitledBorder.TOP,new Font("宋体", Font.BOLD, 15), Color.BLUE));
    
    this.listCursor = listCursor;

    this.listPanel = listPanel;

    this.parent = parent;

    this.colCount = 3;

    init();

    requestMeta.setCompoId(getCompoId());

    refreshData();
    
    setButtonStatus();

    updateFieldEditorsEditable();
  }

  private void refreshData() {
    // TODO Auto-generated method stub

    SfEntrust entrust = (SfEntrust) listCursor.getCurrentObject();

    if (entrust != null && !"".equals(ZcUtil.safeString(entrust.getCode()))) {//列表页面双击进入

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

      entrust = sfEntrustServiceDelegate.selectByPrimaryKey(entrust.getEntrustId(), this.requestMeta);

      listCursor.setCurrentObject(entrust);
      this.setEditingObject(entrust);
    } else {//新增按钮进入

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;

      entrust = new SfEntrust();
      setDefaultValue(entrust);
      listCursor.getDataList().add(entrust);

      listCursor.setCurrentObject(entrust);

      this.setEditingObject(entrust);

    }
    refreshSubData();
    setOldObject();

    setButtonStatus();

    updateFieldEditorsEditable();

  }


  private void setDefaultValue(SfEntrust entrust) {
    // TODO Auto-generated method stub

    entrust.setStatus(ZcSettingConstants.WF_STATUS_DRAFT);
    entrust.setNd(this.requestMeta.getSvNd());
    entrust.setInputDate(this.requestMeta.getSysDate());
    entrust.setInputor(requestMeta.getSvUserID());
    entrust.setAcceptDate(requestMeta.getSysDate());
    entrust.setAcceptor(requestMeta.getSvUserID());
    entrust.setJdCompany(AsOptionMeta.getOptVal(SfElementConstants.OPT_SF_JD_COMPANY_NAME));//天津市开平司法鉴定中心
    entrust.setWtDate(requestMeta.getSysDate());
    entrust.setIsCxjd("N");
  }

  private void refreshSubData() {
    // TODO Auto-generated method stub
    SfEntrust entrust = (SfEntrust) listCursor.getCurrentObject();
    materialsTablePanel.setTableModel(SfEntrustToTableModelConverter.convertMaterialsTableData(entrust.getMaterials()));
    ZcUtil.translateColName(materialsTablePanel.getTable(), SfEntrustToTableModelConverter.getMaterialInfo());
    setTablePorperty();
  }
  private void setTablePorperty() {
    JPageableFixedTable table=materialsTablePanel.getTable();
    table.setDefaultEditor(String.class, new TextCellEditor());
    SwingUtil.setTableCellEditor(table, SfMaterials.COL_QUANTITY, new MoneyCellEditor(false));
    SwingUtil.setTableCellRenderer(table, SfMaterials.COL_QUANTITY, new NumberCellRenderer());
  }
  protected void updateFieldEditorsEditable() {

      for (AbstractFieldEditor editor : fieldEditors) {
        if (pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT) || pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW)) {
          if ("code".equals(editor.getFieldName())
              ||"status".equals(editor.getFieldName())
              ||"inputor".equals(editor.getFieldName())
              ||"inputDate".equals(editor.getFieldName())
            ){
            editor.setEnabled(false);            
          }else{
            editor.setEnabled(true);
          }
        } else {
          editor.setEnabled(false);
        }
      }
  }

 

  protected void setButtonStatus() {
    SfEntrust entrust = (SfEntrust) listCursor.getCurrentObject();
    setButtonStatus(entrust, requestMeta, this.listCursor);
    
  }

  public void setButtonStatusWithoutWf() {

    super.setButtonStatusWithoutWf();
    if (this.btnStatusList.size() == 0) {

      ButtonStatus bs = new ButtonStatus();

      bs.setButton(this.addButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.editButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.WF_STATUS_DRAFT);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.saveButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.exitButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_ALL);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.sendButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.suggestPassButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.callbackButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.unAuditButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.unTreadButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      bs = new ButtonStatus();

      bs.setButton(this.printButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.sendGkButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_AUDITED);

      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.importButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);
      btnStatusList.add(bs);

    }

    SfEntrust entrust = (SfEntrust) this.listCursor.getCurrentObject();
     
    ZcUtil.setButtonEnable(this.btnStatusList, entrust.getStatus(), this.pageStatus, getCompoId(), entrust.getProcessInstId());

  }

  protected void setOldObject() {

    oldentrust = (SfEntrust) ObjectUtil.deepCopy(listCursor.getCurrentObject());

  }

 
 

  public String getCompoId() {
    // TODO Auto-generated method stub
    return compoId;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#initToolBar(com.ufgov.zc.client.component.JFuncToolBar)
   */
  @Override
  public void initToolBar(JFuncToolBar toolBar) {
    // TODO Auto-generated method stub

    toolBar.setModuleCode("SF");

    toolBar.setCompoId(getCompoId());

    toolBar.add(editButton);

    toolBar.add(saveButton);

    toolBar.add(sendButton);

//    toolBar.add(saveAndSendButton);

    toolBar.add(suggestPassButton);

//    toolBar.add(sendGkButton);

    toolBar.add(unAuditButton);

    toolBar.add(unTreadButton);

    toolBar.add(callbackButton);

    toolBar.add(deleteButton);

//    toolBar.add(importButton);

    toolBar.add(printButton);

    toolBar.add(traceButton);

//    toolBar.add(previousButton);

//    toolBar.add(nextButton);

    toolBar.add(exitButton);


    editButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doEdit();

      }

    });



    previousButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doPrevious();

      }

    });

    nextButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doNext();

      }

    });

    exitButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doExit();

      }

    });

    saveButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        doSave();

      }

    });

    deleteButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        doDelete();

      }

    });

     
    printButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doPrintButton();

      }

    });

    sendButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doSend();
      }
    });
    
    suggestPassButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doSuggestPass();
      }
    });
    
    callbackButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doCallback();
      }
    });
    
    unTreadButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doUnTread();
      }
    });
    
    unAuditButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doUnAudit();
      }
    });
    
    traceButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doTrace();
      }
    });
  }

 

  protected void doPrevious() {

    if (isDataChanged()) {

      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);

      if (num == JOptionPane.YES_OPTION) {

        if (!doSave()) {

          return;

        }

      } else {

        listCursor.setCurrentObject(oldentrust);

      }

    }

    listCursor.previous();

    refreshData();

  }

  protected void doNext() {

    if (isDataChanged()) {

      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);

      if (num == JOptionPane.YES_OPTION) {

        if (!doSave()) {

          return;

        }

      } else {

        listCursor.setCurrentObject(oldentrust);

      }

    }

    listCursor.next();

    refreshData();

  }

  public boolean doSave() {

    if (!isDataChanged()) {

      JOptionPane.showMessageDialog(this, "数据没有发生改变，不用保存.", "提示", JOptionPane.INFORMATION_MESSAGE);

      return true;

    }

    if (!checkBeforeSave()) {

      return false;

    }

    boolean success = true;

    String errorInfo = "";

    SfEntrust entrust= (SfEntrust) this.listCursor.getCurrentObject();

    try {

      requestMeta.setFuncId(saveButton.getFuncId());

//      System.out.println("before=" + inData.getCoCode() + inData.getCoName());

      entrust = sfEntrustServiceDelegate.saveFN(entrust, this.requestMeta);

      listCursor.setCurrentObject(entrust);

    } catch (Exception e) {

      logger.error(e.getMessage(), e);

      success = false;

      errorInfo += e.getMessage();

    }

    if (success) {

      JOptionPane.showMessageDialog(this, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      refreshListPanel();
        refreshData();
        updateDataFlowDialog();
        
    } else {

      JOptionPane.showMessageDialog(this, "保存失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

    return success;

  }
  
  private void refreshListPanel(){
    if(listPanel!=null){
      listPanel.refreshCurrentTabData();
    }
  }
  /**
   * 更新数据流界面
   */
  private void updateDataFlowDialog() {
    // TODO Auto-generated method stub
    SfEntrust entrust= (SfEntrust) this.listCursor.getCurrentObject();
    if(listPanel!=null && listPanel.getParent() instanceof JClosableTabbedPane){
      return;
    }
    if(parent instanceof SfEntrustDialog){//新增的委托书，创建数据流界面
      SfDataFlowDialog d=new SfDataFlowDialog(compoId, entrust, listPanel);
      parent.dispose();
    }else{
      SfDataFlowDialog d=(SfDataFlowDialog) parent;
      d.refresh(entrust.getEntrustId());
    }
  }

  /**

   * 保存前校验

   * @param cpApply

   * @return

   */

  protected boolean checkBeforeSave() {
    List mainNotNullList = mainBillElementMeta.getNotNullBillElement();
    SfEntrust entrust = (SfEntrust) this.listCursor.getCurrentObject();
    StringBuilder errorInfo = new StringBuilder();
    String mainValidateInfo = ZcUtil.validateBillElementNull(entrust, mainNotNullList);     
    if (mainValidateInfo.length() != 0) {
      errorInfo.append("\n").append(mainValidateInfo.toString()).append("\n");
    }

   
    
    if (errorInfo.length() != 0) {
      JOptionPane.showMessageDialog(this, errorInfo.toString(), "提示", JOptionPane.WARNING_MESSAGE);
      return false;
    }
    return true;
  }
  
  protected void doDelete() {

    requestMeta.setFuncId(deleteButton.getFuncId());

    SfEntrust entrust = (SfEntrust) this.listCursor.getCurrentObject();

    
    int num = JOptionPane.showConfirmDialog(this, "是否删除当前单据", "删除确认", 0);

    if (num == JOptionPane.YES_OPTION) {

      boolean success = true;

      String errorInfo = "";

      try {

        requestMeta.setFuncId(deleteButton.getFuncId());

        sfEntrustServiceDelegate.deleteByPrimaryKeyFN(entrust.getEntrustId(), requestMeta);

      } catch (Exception e) {

        logger.error(e.getMessage(), e);

        success = false;

        errorInfo += e.getMessage();

      }

      if (success) {

        this.listCursor.removeCurrentObject();

        JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);       
        refreshListPanel();
        doExit();
      } else {

        JOptionPane.showMessageDialog(this, "删除失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

      }

    }

  }

 
  public boolean isDataChanged() {

    if (!this.saveButton.isVisible() || !saveButton.isEnabled()) {
      return false;
    }

    return !DigestUtil.digest(oldentrust).equals(DigestUtil.digest(listCursor.getCurrentObject()));

  }


  private void doPrintButton() {

  }

  private void doEdit() {

    this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;

    updateFieldEditorsEditable();

    setButtonStatus();

  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#createFieldEditors()
   */
  @Override
  public List<AbstractFieldEditor> createFieldEditors() {

    List<AbstractFieldEditor> editorList = new ArrayList<AbstractFieldEditor>();

    AutoNumFieldEditor code = new AutoNumFieldEditor(LangTransMeta.translate(SfEntrust.COL_CODE), "code");
    TextFieldEditor name = new TextFieldEditor(LangTransMeta.translate(SfEntrust.COL_NAME), "name");
    AsValFieldEditor status = new AsValFieldEditor(LangTransMeta.translate(SfEntrust.COL_STATUS), "status",SfEntrust.SF_VS_ENTRUST_STATUS);
    SfEntrustorHandler entrustorHandler=new SfEntrustorHandler() {      
      @Override
      public void excute(List selectedDatas) {
        // TODO Auto-generated method stub
        for (Object obj : selectedDatas) {
          SfEntrust currentBill = (SfEntrust) listCursor.getCurrentObject();
          currentBill.setEntrustor((SfEntrustor)obj);
          setEditingObject(currentBill);
        }
      }
      public void afterClear(){
        SfEntrust currentBill = (SfEntrust) listCursor.getCurrentObject();
        currentBill.setEntrustor(new SfEntrustor());
        setEditingObject(currentBill);
      }
    };
    SfEntrustorNewFieldEditor entrustor = new SfEntrustorNewFieldEditor(entrustorHandler.getSqlId(), 20, entrustorHandler, entrustorHandler.getColumNames(), LangTransMeta.translate(SfEntrust.COL_ENTRUSTOR_NAME),"entrustor.name");
    TextFieldEditor  entrustorAddress= new TextFieldEditor(LangTransMeta.translate(SfEntrustor.ADDRESS), "entrustor.address");
    TextFieldEditor  entrustorLinkMan= new TextFieldEditor(LangTransMeta.translate(SfEntrustor.LINK_MAN), "entrustor.linkMan");
    TextFieldEditor  entrustorTel= new TextFieldEditor(LangTransMeta.translate(SfEntrustor.LINK_TEL), "entrustor.linkTel");

    DateFieldEditor wtDate = new DateFieldEditor(LangTransMeta.translate(SfEntrust.COL_WT_DATE), "wtDate");
    
    TextFieldEditor  sjr= new TextFieldEditor(LangTransMeta.translate(SfEntrust.COL_SJR), "sjr");
    TextFieldEditor  sjrTel= new TextFieldEditor(LangTransMeta.translate(SfEntrust.COL_SJR_TEL), "sjrTel");
    TextFieldEditor  sjrZjType= new TextFieldEditor(LangTransMeta.translate(SfEntrust.COL_SJR_ZJ_TYPE), "sjrZjType");
    TextFieldEditor  sjrZjCode= new TextFieldEditor(LangTransMeta.translate(SfEntrust.COL_SJR_ZJ_CODE), "sjrZjCode");

    final ElementConditionDto majorPersonDto = new ElementConditionDto();
    AsValFieldEditor majorCode = new AsValFieldEditor(LangTransMeta.translate(SfEntrust.COL_MAJOR_NAME), "majorCode","SF_VS_MAJOR"){
      @Override
      protected void afterChange(AsValComboBox field) {
        if(field.getSelectedAsVal()==null || pageStatus.equals(ZcSettingConstants.PAGE_STATUS_BROWSE)){
          majorPersonDto.setDattr1(null);
          return;
        }
        String valId = field.getSelectedAsVal().getValId();
        majorPersonDto.setDattr1(valId);
      }
    };
    
    AsValFieldEditor jdOrg = new AsValFieldEditor(LangTransMeta.translate(SfEntrust.COL_JD_ORG), "jdOrg",SfElementConstants.VS_SF_ORG);
    
    SfJdPersonSelectHandler jdFzrHandler = new SfJdPersonSelectHandler() {      
      @Override
      public void excute(List selectedDatas) {
        // TODO Auto-generated method stub
        if(selectedDatas!=null && selectedDatas.size()>0){
          SfEntrust cur=listCursor.getCurrentObject();
          SfJdPerson user=(SfJdPerson) selectedDatas.get(0);
          cur.setJdFzr(user.getAccount());
          cur.setJdFzrName(user.getName());
          setEditingObject(cur);
        }
      }
      public void afterClear(){
        SfEntrust currentBill = (SfEntrust) listCursor.getCurrentObject();
        currentBill.setJdFzr(null);
        setEditingObject(currentBill);
      }
      
      public boolean beforeSelect(ElementConditionDto dto){
        SfEntrust currentBill = (SfEntrust) listCursor.getCurrentObject();
        if(currentBill.getMajorCode()==null || currentBill.getMajorCode().trim().length()==0){
          JOptionPane.showMessageDialog(self, "请先选择"+LangTransMeta.translate(SfEntrust.COL_MAJOR_NAME)+"！", "提示", JOptionPane.INFORMATION_MESSAGE);
          return false;
        }
        return true;
      }
    };

    majorPersonDto.setNd(requestMeta.getSvNd());
    majorPersonDto.setCoCode(requestMeta.getSvCoCode());
    ForeignEntityFieldEditor jdFzr = new ForeignEntityFieldEditor(jdFzrHandler.getSqlId(), majorPersonDto, 20,jdFzrHandler, jdFzrHandler.getColumNames(), LangTransMeta.translate(SfEntrust.COL_JD_FZR),"jdFzrName");
        
    TextAreaFieldEditor jdHistory=new TextAreaFieldEditor(LangTransMeta.translate(SfEntrust.COL_JD_HISTORY), "jdHistory", 500, 3, 5);
    TextAreaFieldEditor jdRequire=new TextAreaFieldEditor(LangTransMeta.translate(SfEntrust.COL_JD_REQUIRE), "jdRequire", 1000, 4, 5);
    TextAreaFieldEditor remark=new TextAreaFieldEditor(LangTransMeta.translate(SfEntrust.COL_REMARK), "remark", 100, 2, 5);
    AsValFieldEditor isCxjd = new AsValFieldEditor(LangTransMeta.translate(SfEntrust.COL_IS_CXJD), "isCxjd","VS_Y/N");
    TextAreaFieldEditor brief=new TextAreaFieldEditor(LangTransMeta.translate(SfEntrust.COL_BRIEF), "brief", 100, 3, 5);
    TextFieldEditor  inputor= new TextFieldEditor(LangTransMeta.translate(SfEntrust.COL_INPUTOR), "inputorName");
    DateFieldEditor inputDate = new DateFieldEditor(LangTransMeta.translate(SfEntrust.COL_INPUT_DATE), "inputDate");    
    TextFieldEditor  acceptor= new TextFieldEditor(LangTransMeta.translate(SfEntrust.COL_ACCEPTOR), "acceptorName");
    DateFieldEditor acceptDate = new DateFieldEditor(LangTransMeta.translate(SfEntrust.COL_ACCEPT_DATE), "acceptDate"); 
    AsValFieldEditor isAccept = new AsValFieldEditor(LangTransMeta.translate(SfEntrust.COL_IS_ACCEPT), "isAccept","VS_Y/N");
    TextAreaFieldEditor notAcceptReason=new TextAreaFieldEditor(LangTransMeta.translate(SfEntrust.COL_NOT_ACCEPT_REASON), "notAcceptReason", 100, 3, 5);
    IntFieldEditor nd=new IntFieldEditor(LangTransMeta.translate(SfEntrust.COL_ND), "nd");
    SfJdTargethandler targetHandler=new SfJdTargethandler() {      
      @Override
      public void excute(List selectedDatas) {
        // TODO Auto-generated method stub
        for (Object obj : selectedDatas) {
          SfEntrust currentBill = (SfEntrust) listCursor.getCurrentObject();
          currentBill.setJdTarget((SfJdTarget)obj);
          setEditingObject(currentBill);
        }        
      }
      public void afterClear(){
        SfEntrust currentBill = (SfEntrust) listCursor.getCurrentObject();
        currentBill.setJdTarget(new SfJdTarget());
        setEditingObject(currentBill);
      }
    };
    SfJdTargetNewFieldEditor jdTarget=new SfJdTargetNewFieldEditor(targetHandler.getSqlId(), 20, targetHandler, targetHandler.getColumNames(), LangTransMeta.translate(SfJdTarget.COL_NAME), "jdTarget.name");
    IntFieldEditor  jdTargetAge= new IntFieldEditor(LangTransMeta.translate(SfJdTarget.COL_AGE), "jdTarget.age");
    AsValFieldEditor jdTargetSex = new AsValFieldEditor(LangTransMeta.translate(SfJdTarget.COL_SEX), "jdTarget.sex",SfElementConstants.VS_SEX);
    TextFieldEditor  jdTargetIdName= new TextFieldEditor(LangTransMeta.translate(SfJdTarget.COL_ID_NAME), "jdTarget.idName");
    TextFieldEditor  jdTargetIdCode= new TextFieldEditor(LangTransMeta.translate(SfJdTarget.COL_ID_CODE), "jdTarget.idCode");
    TextFieldEditor  jdTargetPhone= new TextFieldEditor(LangTransMeta.translate(SfJdTarget.COL_PHONE), "jdTarget.phone");
    TextFieldEditor  jdTargetAddress= new TextFieldEditor(LangTransMeta.translate(SfJdTarget.COL_ADDRESS), "jdTarget.address");

    editorList.add(new NewLineFieldEditor());
    
    editorList.add(code);
    editorList.add(name);
    editorList.add(isAccept);

    editorList.add(entrustor);
    editorList.add(wtDate);
    editorList.add(status);

    editorList.add(sjr);
    editorList.add(sjrTel);
    editorList.add(nd);
    
    editorList.add(sjrZjType);
    editorList.add(sjrZjCode);
    editorList.add(new NewLineFieldEditor());

    editorList.add(majorCode);
//    editorList.add(jdOrg);
    editorList.add(jdFzr);

    editorList.add(jdRequire);
    
    editorList.add(brief);
    
    editorList.add(acceptor);
    editorList.add(acceptDate);
    editorList.add(new NewLineFieldEditor());
    
    editorList.add(notAcceptReason);

    editorList.add(jdTarget);
    editorList.add(jdTargetAge);
    editorList.add(jdTargetSex);
     
    editorList.add(remark);
    
    editorList.add(isCxjd);
    editorList.add(new NewLineFieldEditor());
    editorList.add(jdHistory);
    
    return editorList;

  }
  protected void init() {

    this.initToolBar(toolBar);

    this.setLayout(new BorderLayout());

    this.add(toolBar, BorderLayout.NORTH);

    if (this.billClass != null && this.eleMeta != null) {

      initFieldEditorPanel(this.billClass, this.eleMeta);

    } else {

      initFieldEditorPanel();

    }

    workPanel.setLayout(new BorderLayout());

    workPanel.add(fieldEditorPanel, BorderLayout.NORTH);

    JComponent tabTable = createSubBillPanel();

    if (tabTable != null) {

      workPanel.add(tabTable, BorderLayout.CENTER);

    }

    JScrollPane js=new JScrollPane(workPanel);
    this.add(js, BorderLayout.CENTER);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#createSubBillPanel()
   */
  @Override
  public JComponent createSubBillPanel() {

    JTabbedPane itemTabPane = new JTabbedPane();

    materialsTablePanel.init();

    materialsTablePanel.setPanelId(this.getClass().getName() + "_materialTablePanel");

    materialsTablePanel.getSearchBar().setVisible(false);

    materialsTablePanel.setTablePreferencesKey(this.getClass().getName() + "__materialTable");

    materialsTablePanel.getTable().setShowCheckedColumn(true);

    materialsTablePanel.getTable().getTableRowHeader().setPreferredSize(new Dimension(60, 0));

    itemTabPane.addTab("送检材料", materialsTablePanel);

    JFuncToolBar materialBtnBar = new JFuncToolBar();

    FuncButton addBtn2 = new SubaddButton(false);

    JButton insertBtn2 = new SubinsertButton(false);

    JButton delBtn2 = new SubdelButton(false);

    materialBtnBar.add(addBtn2);

    materialBtnBar.add(insertBtn2);

    materialBtnBar.add(delBtn2);

    materialsTablePanel.add(materialBtnBar, BorderLayout.SOUTH);

    addBtn2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        SfMaterials item = new SfMaterials();
        setMaterialDefaultValue(item);
        int rowNum = addSub(materialsTablePanel, item);
        materialsTablePanel.getTable().setRowSelectionInterval(rowNum, rowNum);
      }
    });

    insertBtn2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        SfMaterials item = new SfMaterials();
        setMaterialDefaultValue(item);
        int rowNum = insertSub(materialsTablePanel, item);
        materialsTablePanel.getTable().setRowSelectionInterval(rowNum, rowNum);
      }
    });

    delBtn2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        deleteSub(materialsTablePanel);
      }
    });
    itemTabPane.setMinimumSize(new Dimension(240, 300));    
    return itemTabPane;
  }


  protected void setMaterialDefaultValue(SfMaterials item) {
    // TODO Auto-generated method stub
    item.setTempId(""+System.currentTimeMillis());
    SfEntrust e=listCursor.getCurrentObject();
    item.setEntrustId(e.getEntrustId());
  }

  public void doExit() {
    // TODO Auto-generated method stub

    if (isDataChanged()) {

      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);

      if (num == JOptionPane.YES_OPTION) {

        if (!doSave()) {

          return;

        }

      }

    }
    if(this.parent instanceof SfDataFlowDialog){
      ((SfDataFlowDialog)parent).removeTab(this, compoId);
    }else{
      this.parent.dispose();
    }
  }

  /**
   * 送审
   */
  protected void doSend() {

    boolean success = true;
    SfEntrust bill=this.listCursor.getCurrentObject();
    
    if(bill.getJdFzr()==null){
      JOptionPane.showMessageDialog(this, "请指定鉴定负责人.", "提示", JOptionPane.INFORMATION_MESSAGE);
      return;      
    }
    
    SfEntrust afterSaveBill = null;

    if (this.isDataChanged()) {
      JOptionPane.showMessageDialog(this, "数据发生改变，请先保存.", "提示", JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    try {
      requestMeta.setFuncId(this.sendButton.getFuncId());
      SfEntrust qx = (SfEntrust) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());
      qx.setAuditorId(WorkEnv.getInstance().getCurrUserId());
      afterSaveBill = sfEntrustServiceDelegate.newCommitFN(qx, requestMeta);
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
      success = false;
      UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());
    }

    if (success) {
      this.listCursor.setCurrentObject(afterSaveBill);
      JOptionPane.showMessageDialog(this, "送审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
      refreshListPanel();
      refreshData();
      updateDataFlowDialog();
    }
  }
  /**
   * 审核
   */
  protected void doSuggestPass() {
    if (!checkBeforeSave()) {
      return;
    }
    SfEntrust qx = (SfEntrust) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());
    requestMeta.setFuncId(this.suggestPassButton.getFuncId());
    GkCommentDialog commentDialog = new GkCommentDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),ModalityType.APPLICATION_MODAL);
    if (commentDialog.cancel) {
      return;
    }
    boolean success = true;
    String errorInfo = "";
    try {
      qx.setComment(commentDialog.getComment());
      qx.setAuditorId(WorkEnv.getInstance().getCurrUserId());
      qx = sfEntrustServiceDelegate.auditFN(qx, requestMeta);
    } catch (Exception e) {
      success = false;
      logger.error(e.getMessage(), e);
      errorInfo += e.getMessage();
    }
    if (success) {
      JOptionPane.showMessageDialog(this, "审核成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
      refreshListPanel();
      refreshData();
      updateDataFlowDialog();
    } else {
      JOptionPane.showMessageDialog(this, "审核失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);
    }
  }

 /**
  * 销审
  */
  protected void doUnAudit() {
    SfEntrust qx = (SfEntrust) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());
    boolean success = true;
    SfEntrust afterSaveBill = null;
    String errorInfo = "";
    int i = JOptionPane.showConfirmDialog(this, "是否确定消审？", "确认", JOptionPane.INFORMATION_MESSAGE);
    if (i != 0) {
      return;
    }
    try {
      requestMeta.setFuncId(unAuditButton.getFuncId());
      qx.setAuditorId(WorkEnv.getInstance().getCurrUserId());
      afterSaveBill = sfEntrustServiceDelegate.unAuditFN(qx, requestMeta);
    } catch (Exception e) {
      success = false;
      logger.error(e.getMessage(), e);
      errorInfo += e.getMessage();
    }
    if (success) {
      this.listCursor.setCurrentObject(afterSaveBill);
      JOptionPane.showMessageDialog(this, "销审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
      refreshListPanel();
      refreshData();
      updateDataFlowDialog();
    } else {
      JOptionPane.showMessageDialog(this, "销审失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);
    }
  }
 /**
  * 退回
  */
  protected void doUnTread() {
    GkCommentUntreadDialog commentDialog = new GkCommentUntreadDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),ModalityType.APPLICATION_MODAL);
    if (commentDialog.cancel) {
      return;
    }
    boolean success = true;
    SfEntrust afterSaveBill = null;
    String errorInfo = "";
    try {
      requestMeta.setFuncId(unTreadButton.getFuncId());
      SfEntrust qx = (SfEntrust) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());
      qx.setAuditorId(WorkEnv.getInstance().getCurrUserId());
      qx.setComment(commentDialog.getComment());
      afterSaveBill = sfEntrustServiceDelegate.untreadFN(qx, requestMeta);
    } catch (Exception e) {
      success = false;
      logger.error(e.getMessage(), e);
      errorInfo += e.getMessage();
    }
    if (success) {
      this.listCursor.setCurrentObject(afterSaveBill);
      JOptionPane.showMessageDialog(this, "退回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
      refreshListPanel();
      refreshData();
      updateDataFlowDialog();
    } else {
      JOptionPane.showMessageDialog(this, "退回失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);
    }
  }

 /**
  * 收回
  */
  protected void doCallback() {
    boolean success = true;
    SfEntrust afterSaveBill = null;
    String errorInfo = "";
    try {
      requestMeta.setFuncId(this.callbackButton.getFuncId());
      SfEntrust qx = (SfEntrust) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());
      qx.setAuditorId(WorkEnv.getInstance().getCurrUserId());
      afterSaveBill = sfEntrustServiceDelegate.callbackFN(qx, requestMeta);
    } catch (Exception e) {
      success = false;
      logger.error(e.getMessage(), e);
      errorInfo += e.getMessage();
    }

    if (success) {
      JOptionPane.showMessageDialog(this, "收回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
      refreshListPanel();
      refreshData();
      updateDataFlowDialog();
    } else {
      JOptionPane.showMessageDialog(this, "收回失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);
    }
  }

  /*
   * 流程跟踪
   */
  private void doTrace() {
    ZcBaseBill bean = (ZcBaseBill) this.listCursor.getCurrentObject();
    if (bean == null) {
      return;
    }
    ZcUtil.showTraceDialog(bean, compoId);
  }

}
