package com.ufgov.zc.client.component.zc.fieldeditor;import javax.swing.JComponent;import com.ufgov.zc.client.component.FileUploader;import com.ufgov.zc.client.component.event.ValueChangeEvent;import com.ufgov.zc.client.component.event.ValueChangeListener;import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;import com.ufgov.zc.common.system.util.BeanUtil;import com.ufgov.zc.common.zc.model.ZcBaseBill;public class FileFieldEditor extends AbstractFieldEditor {  private static final long serialVersionUID = 530635732275237298L;  private FileUploader field;  private String fileId;  private String fieldBlobId;  //标识不是直接打开，而是下载的本地。下载招标文件采用此种方式。  private boolean isDownLoadFile;  public FileFieldEditor(String name, String fieldName, String fieldBlobId) {    this.fieldBlobId = fieldBlobId;    this.fieldName = fieldName;    init(name);  }  public FileFieldEditor(String name, String fieldName, String fieldBlobId, boolean isDownLoadFile) {    this.fieldBlobId = fieldBlobId;    this.fieldName = fieldName;    this.isDownLoadFile = isDownLoadFile;    init(name);  }  public void setEnabled(boolean enabled) {    field.setEditable(enabled);    //    this.field.setFileId(this.fileId, enabled);  }    public void setDownButtonEnabled(boolean enabled){	  field.setDownloadFileButton(enabled);	  field.setButtonEnable();  }  public Object getValue() {    return field.getFileId();  }  public void setValue(Object value) {    if (value == null) {      field.setFileId(null);      this.fileId = null;    } else {      this.fileId = (String) BeanUtil.get(fieldBlobId, value);      field.setFileId(this.fileId);      field.getFileId();    }  }  protected JComponent createEditorComponent() {    if (isDownLoadFile) {      field = new FileUploader(true, true);    } else {      field = new FileUploader();    }    field.addValueChangeListener(new ValueChangeListener() {      public void valueChanged(ValueChangeEvent e) {        ZcBaseBill bill = (ZcBaseBill) getEditObject();        if (bill != null) {          BeanUtil.set(fieldName, field.getFileName(), bill);          BeanUtil.set(fieldBlobId, field.getFileId(), bill);        }        fireEditSynced();      }    });    return field;  }}