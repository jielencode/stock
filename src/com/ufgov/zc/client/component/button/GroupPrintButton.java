package com.ufgov.zc.client.component.button;public class GroupPrintButton extends FuncButton {  /**   *   */  private static final long serialVersionUID = -2564446291342163428L;  public GroupPrintButton() {    super();  }  protected void init() {    this.funcId = "fgroupprint";    this.defaultText = "打印";    this.iconName = "print.gif";    super.init();  }}