/**   * @(#) project: ZFCG* @(#) file: ConformityBidMenuItem.java* * Copyright 2011 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.client.component.Menu;/*** @ClassName: ConformityBidMenuItem* @Description: TODO(这里用一句话描述这个类的作用)* @date: 2011-6-9 上午11:12:40* @version: V1.0 * @since: 1.0* @author: fanpl* @modify: */public class ConformityBidMenuItem extends FuncMenuItem {  private static final long serialVersionUID = 4054640434388046008L;  public ConformityBidMenuItem() {    super();  }  @Override  protected void init() {    this.funcId = "fconformityBid";    this.defaultText = "符合性评标";    super.init();  }}