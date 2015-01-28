package com.ufgov.zc.server.zc.web.action.merchandise;import java.util.List;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import javax.servlet.http.HttpSession;import org.apache.commons.logging.Log;import org.apache.commons.logging.LogFactory;import org.apache.struts.action.ActionForm;import org.apache.struts.action.ActionForward;import org.apache.struts.action.ActionMapping;import org.springframework.web.struts.ActionSupport;import com.ufgov.zc.server.zc.service.IMerCatalogueService;import com.ufgov.zc.server.zc.web.form.SpForm;public class SearchCataloguePropAction extends ActionSupport {  private final static Log log = LogFactory.getLog(SearchCataloguePropAction.class);  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,  HttpServletResponse response) throws Exception {    SpForm spForm = (SpForm) form;    String forward = "success";    try {      HttpSession session = request.getSession();      //			response.setContentType("text/xml; charset=UTF-8");      //			PrintWriter out = response.getWriter();      //			out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");      //			out.println("<options>");      IMerCatalogueService merCatalogueService = (IMerCatalogueService) this.getWebApplicationContext().getBean("merCatalogueService");      //获取品目列表      List catalogueList = merCatalogueService.getCatalogueForMenuGoods();      spForm.setCatalogueList(catalogueList);      //request.setAttribute("catalogueList", catalogueList);      //获取批次列表      List zcXyghZbjgList = merCatalogueService.getZcXyghZbjgList();      spForm.setZcXyghZbjgList(zcXyghZbjgList);      String key = request.getParameter("key");      //获取品目属性列表      List catalogueProp = merCatalogueService.getCataloguePeopForID(key);      spForm.setZcCatalogueProp(catalogueProp);      session.setAttribute("spForm", spForm);      session.setAttribute("ZcCatalogueProp", spForm.getZcCatalogueProp());      //			if (!catalogueProp.isEmpty()) {      //				for (Iterator iterator = catalogueProp.iterator(); iterator      //						.hasNext();) {      //					ZcBCatalogueProp zcBCatalogueProp = (ZcBCatalogueProp) iterator.next();      //					out.println("<value>" + zcBCatalogueProp.getZcCataPropEnName() + "</value>");      //					out.println("<text>" + zcBCatalogueProp.getZcCataPropChName() + "</text>");      //				}      //			}      //			out.println("</options>");      //			out.flush();      //			out.close();    } catch (Exception e) {      log.error(e);      throw e;    }    return mapping.findForward(forward);  }}