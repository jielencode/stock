/**   * @(#) project: ZFCG* @(#) file: RejectBidMenuItem.java* * Copyright 2011 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.client.component.Menu;/*** @ClassName: RejectBidMenuItem* @Description: TODO(这里用一句话描述这个类的作用)* @date: 2011-6-9 上午11:09:12* @version: V1.0 * @since: 1.0* @author: fanpl* @modify: */public class RejectBidMenuItem extends FuncMenuItem {  private static final long serialVersionUID = 4054640434388046008L;  public RejectBidMenuItem() {    super();  }  @Override  protected void init() {    this.funcId = "frejectBid";    this.defaultText = "废标";    super.init();  }}