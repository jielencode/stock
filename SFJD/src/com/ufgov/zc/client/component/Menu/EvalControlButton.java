/**   * @(#) project: ZFCG* @(#) file: EvalControlButton.java* * Copyright 2011 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.client.component.Menu;/*** @ClassName: EvalControlButton* @Description: TODO(这里用一句话描述这个类的作用)* @date: 2011-6-9 上午10:59:00* @version: V1.0 * @since: 1.0* @author: fanpl* @modify: */public class EvalControlButton extends FuncMenuButton {  private static final long serialVersionUID = 8176162602374543497L;  public EvalControlButton() {    super();  }  @Override  protected void init() {    this.funcCtrl = true;    this.funcId = "fevalControl";    this.defaultText = "评标控制";    this.iconName = "send.jpg";    super.init();  }}