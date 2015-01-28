package com.ufgov.zc.client.component.setting.jj;import java.awt.BorderLayout;import java.awt.Container;import java.awt.Dialog;import java.awt.Window;import javax.swing.JTabbedPane;import com.ufgov.zc.client.component.GkBaseDialog;import com.ufgov.zc.client.component.setting.OptionTab;import com.ufgov.zc.client.component.setting.SysOptionTab;public class JjOptionDialog extends GkBaseDialog {  private JTabbedPane tabPane = new JTabbedPane();  public JjOptionDialog(Window window) {    super(window, Dialog.ModalityType.APPLICATION_MODAL);    setTitle("系统选项");    init();    this.setSize(660, 500);    this.setVisible(true);  }  public void init() {    Container container = this.getContentPane();    container.setLayout(new BorderLayout());    OptionTab ot = new SysOptionTab(this);    tabPane.addTab(ot.getTabName(), ot);    ot = new JjOptionTab(this);    tabPane.addTab(ot.getTabName(), ot);    tabPane.setSelectedIndex(1);    container.add(tabPane, BorderLayout.CENTER);  }  public static void main(String[] args) {    new JjOptionDialog(null);  }}