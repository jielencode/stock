/** * SubinsertButton.java * com.ufgov.gk.client.component.button * Administrator * 2010-5-18 */package com.ufgov.zc.client.component.button;/** * @author Administrator * */public class DownloadButton extends FuncButton {  /**   *    */  private static final long serialVersionUID = -4562975339140978995L;  public DownloadButton() {    this.init();  }  public DownloadButton(boolean funcCtrl) {    this.funcCtrl = funcCtrl;    this.init();  }  protected void init() {    this.funcId = "fdownload";    this.defaultText = "保存公告";    this.iconName = "import.jpg";    super.init();  }}