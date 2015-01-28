package com.ufgov.zc.client.component.table.codecelleditor;import java.awt.Component;import javax.swing.JTable;import javax.swing.table.TableCellEditor;import com.ufgov.zc.client.component.element.OutlayTreeSelectField;import com.ufgov.zc.client.component.table.GkAbstractCellEditor;import com.ufgov.zc.common.commonbiz.model.Outlay;public class OutlayCellEditor extends GkAbstractCellEditor implements TableCellEditor {  private static final long serialVersionUID = -1014964575090820890L;  private OutlayTreeSelectField editorComponent = new OutlayTreeSelectField();  public OutlayCellEditor() {  }  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,  int column) {    editorComponent.setValueByCode((String) value);    return editorComponent;  }  public Object getCellEditorValue() {    String code = null;    Outlay value = editorComponent.getOutlay();    if (value != null) {      code = value.getCode();    }    return code;  }  public void setRandomEdit(boolean randomEdit) {    editorComponent.setRandomEdit(randomEdit);  }  public void setCtrlLevelNum(int ctrlLevelNum) {    editorComponent.setCtrlLevelNum(ctrlLevelNum);  }  public void setPrefix(String prefix) {    editorComponent.setPrefix(prefix);  }}