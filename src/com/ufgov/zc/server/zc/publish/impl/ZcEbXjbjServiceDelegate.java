/** * ZcEbXunJiaBaoJiaServiceDelegate.java * com.ufgov.gk.server.zc.publish.impl * Administrator * 2010-10-24 */package com.ufgov.zc.server.zc.publish.impl;import java.util.List;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.zc.model.ZcEbXunJia;import com.ufgov.zc.common.zc.model.ZcEbXunJiaBaoJia;import com.ufgov.zc.common.zc.model.ZcEbXunJiaBaoJiaDetail;import com.ufgov.zc.common.zc.publish.IZcEbXjbjServiceDelegate;import com.ufgov.zc.server.zc.service.IZcEbXjbjService;/** * @author Administrator * */public class ZcEbXjbjServiceDelegate implements IZcEbXjbjServiceDelegate {  private IZcEbXjbjService baoJiaService;  public IZcEbXjbjService getBaoJiaService() {    return baoJiaService;  }  public void setBaoJiaService(IZcEbXjbjService baoJiaService) {    this.baoJiaService = baoJiaService;  }  public boolean deleteXunJiaBaoJia(ZcEbXunJiaBaoJia xunJiaBaoJia, RequestMeta requestMeta) {    // TODO Auto-generated method stub    return this.baoJiaService.deleteXunJiaBaoJia(xunJiaBaoJia, requestMeta);  }  public List getSignupPack(ZcEbXunJiaBaoJia xunJiaBaoJia, RequestMeta requestMeta) {    // TODO Auto-generated method stub    return this.baoJiaService.getSignupPack(xunJiaBaoJia, requestMeta);  }  public List getXunJiaBaoJia(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {    // TODO Auto-generated method stub    return this.baoJiaService.getXunJiaBaoJia(elementConditionDto, requestMeta);  }  public ZcEbXunJiaBaoJia getXunJiaBaoJiaBySupplier(ZcEbXunJiaBaoJia xunJiaBaoJia, RequestMeta requestMeta) {    // TODO Auto-generated method stub    return this.baoJiaService.getXunJiaBaoJiaBySupplier(xunJiaBaoJia, requestMeta);  }  public ZcEbXunJiaBaoJia saveXunJiaBaoJia(ZcEbXunJiaBaoJia xunJiaBaoJia, RequestMeta requestMeta) {    // TODO Auto-generated method stub    return this.baoJiaService.saveXunJiaBaoJia(xunJiaBaoJia, requestMeta);  }  public String updateXunJiaBaoJia(ZcEbXunJiaBaoJia xunJiaBaoJia, RequestMeta requestMeta) {    return this.baoJiaService.updateXunJiaBaoJia(xunJiaBaoJia, requestMeta);  }  public List findTransData(ElementConditionDto dto, RequestMeta meta) {    return baoJiaService.findTransData(dto, meta);  }  public String importTransData(ZcEbXunJiaBaoJia bj, RequestMeta meta) {    return baoJiaService.importTransData(bj, meta);  }  public ZcEbXunJiaBaoJia refreshProjInfo(ZcEbXunJiaBaoJia xunJiaBaoJia, RequestMeta requestMeta) {    // TODO Auto-generated method stub    return this.baoJiaService.refreshProjInfo(xunJiaBaoJia, requestMeta);  }  public List getSignupPackNew(ZcEbXunJiaBaoJia xunJiaBaoJia, RequestMeta requestMeta) {    return this.baoJiaService.getSignupPackNew(xunJiaBaoJia);  }  public List getXunJiaBaoJiaByCondition(ElementConditionDto dto, RequestMeta requestMeta) {    // TODO Auto-generated method stub    return this.baoJiaService.getXunJiaBaoJiaByCondition(dto, requestMeta);  }     public List getXunJiaByProjLst(List projIdLst, RequestMeta meta) {    // TODO Auto-generated method stub    return baoJiaService.getXunJiaByProjLst(projIdLst, meta);  }     public String importXunjiaTransDatasFN(ZcEbXunJia bill, RequestMeta meta) {    // TODO Auto-generated method stub    return baoJiaService.importXunjiaTransDatasFN(bill, meta);  }     public List queryXjBjExportsDatas(List reportIdLst, RequestMeta meta) {    // TODO Auto-generated method stub    return baoJiaService.queryXjBjExportsDatas(reportIdLst, meta) ;  }     public String importXjBjDataFN(ZcEbXunJiaBaoJia bill, RequestMeta meta) {    // TODO Auto-generated method stub    return baoJiaService.importXjBjDataFN(bill, meta);  }}