package com.ufgov.zc.client.component;import java.awt.Component;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import javax.swing.JMenuItem;public abstract class ConditionSettingPopupMenu extends JPopupMenuEx {  JMenuItem defaultValueSettingMenuItem = new JMenuItem("设置默认值");  JMenuItem conditionSettingMenuItem = new JMenuItem("设置查询条件");  public ConditionSettingPopupMenu(Component target) {    super(target);    defaultValueSettingMenuItem.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        openDefaultValueDialog();      }    });    //    this.add(defaultValueSettingMenuItem);    conditionSettingMenuItem.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        openSearchDialog();      }    });    this.add(conditionSettingMenuItem);  }  public abstract void openDefaultValueDialog();  public abstract void openSearchDialog();}