package com.ufgov.zc.client.sf.outinfo;

import java.util.List;

import javax.swing.table.TableModel;

import com.ufgov.zc.client.common.MyTableModel;
import com.ufgov.zc.common.sf.model.SfOutInfoType;
import com.ufgov.zc.common.zc.foreignentity.IForeignEntityHandler;

public abstract class OutInfoTypeHandler  implements IForeignEntityHandler {

  private boolean isMultipleSelect;
  private String sqlId = "com.ufgov.zc.server.sf.dao.SfOutInfoTypeMapper.selectMainDataLst";
  private String columNames[] = {"编号","名称"};
  public OutInfoTypeHandler() {
    this(false);
  }

  public OutInfoTypeHandler(boolean isMultipleSelect) {
    this.isMultipleSelect = isMultipleSelect;
  }

  @SuppressWarnings("unchecked")
  public abstract void excute(List selectedDatas);

  @SuppressWarnings("unchecked")
  public TableModel createTableModel(List showDatas) {

    Object data[][] = new Object[showDatas.size()][columNames.length];
    for (int i = 0; i < showDatas.size(); i++) {
      SfOutInfoType rowData = (SfOutInfoType) showDatas.get(i);
      int col = 0;
      data[i][col++] = rowData.getOutInfoTypeCode();
      data[i][col++] = rowData.getOutInfoTypeName();
    }

    MyTableModel model = new MyTableModel(data, columNames) {
      private static final long serialVersionUID = 5069824753340617654L;
      public boolean isCellEditable(int row, int colum) {
        return false;
      }
    };
    return model;
  }

  public boolean isMultipleSelect() {
    return this.isMultipleSelect;
  }

  public String[] getColumNames() {
    return columNames;
  }

  public void setColumNames(String[] columNames) {
    this.columNames = columNames;
  }

  public String getSqlId() {
    return sqlId;
  }

  public void setSqlId(String sqlId) {
    this.sqlId = sqlId;
  }
}