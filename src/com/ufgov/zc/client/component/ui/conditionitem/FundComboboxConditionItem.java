package com.ufgov.zc.client.component.ui.conditionitem;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import javax.swing.JComponent;import com.ufgov.zc.client.component.element.FundComboBox;public class FundComboboxConditionItem extends AbstractSearchConditionItem {  private String compoId;  public FundComboboxConditionItem(String displayName) {    init(displayName);  }  public FundComboboxConditionItem(String displayName, String compoId) {    this.compoId = compoId;    init(displayName);  }  public FundComboBox fundComboBox;  protected JComponent createEditorComponent() {    if (fundComboBox == null) {      fundComboBox = new FundComboBox(compoId);      fundComboBox.initComboBox();      fundComboBox.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          fireSearch();          fireValueChanged();        }      });    }    return fundComboBox;  }  public void setValue(Object value) {    fundComboBox.setSelectedItem(value);  }  @Override  public Object getValue() {    return fundComboBox.getSelectedItem();  }  public void setControlLevel(int level) {    fundComboBox.setCtrlLevelNum(level);    fundComboBox.initComboBox();  }}