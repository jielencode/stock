/** * ZcEbOpenBidServiceDelegate.java * com.ufgov.gk.server.zc.publish.impl * Administrator * 2010-5-22 */package com.ufgov.zc.server.zc.publish.impl;import java.util.List;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.zc.model.ZcEbOpenBid;import com.ufgov.zc.common.zc.publish.IZcEbOpenBidServiceDelegate;import com.ufgov.zc.server.zc.service.IZcEbOpenBidService;/** * @author Administrator * */public class ZcEbOpenBidServiceDelegate implements IZcEbOpenBidServiceDelegate {  private IZcEbOpenBidService zcEbOpenBidService;  public IZcEbOpenBidService getZcEbOpenBidService() {    return this.zcEbOpenBidService;  }  public void setZcEbOpenBidService(IZcEbOpenBidService zcEbOpenBidService) {    this.zcEbOpenBidService = zcEbOpenBidService;  }  public List getZcEbOpenBid(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {    return this.zcEbOpenBidService.getZcEbOpenBid(elementConditionDto, requestMeta);  }  public ZcEbOpenBid saveFN(ZcEbOpenBid openBid, RequestMeta requestMeta) {    return this.zcEbOpenBidService.save(openBid, requestMeta);  }}