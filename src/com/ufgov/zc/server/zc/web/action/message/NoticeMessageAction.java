package com.ufgov.zc.server.zc.web.action.message;import java.io.PrintWriter;import java.util.HashMap;import java.util.List;import java.util.Map;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import net.sf.json.JSONArray;import org.apache.commons.logging.Log;import org.apache.commons.logging.LogFactory;import org.apache.struts.action.ActionForm;import org.apache.struts.action.ActionForward;import org.apache.struts.action.ActionMapping;import org.springframework.web.struts.ActionSupport;import com.ufgov.zc.server.system.SpringContext;import com.ufgov.zc.server.zc.service.IZcEbBaseService;public class NoticeMessageAction extends ActionSupport {  private final static Log log = LogFactory.getLog(NoticeMessageAction.class);  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {    //request.setCharacterEncoding("utf-8");    response.setContentType("text/html;charset=UTF-8");    PrintWriter out = response.getWriter();    String forward = "success";    IZcEbBaseService baseService = (IZcEbBaseService) SpringContext.getBean("zcEbBaseService");    Map parameter = new HashMap();    parameter.put("userId", request.getParameter("userId"));    List list = baseService.queryDataForList("WfCurrentTask.getWfCurrentTaskCountByUserId", parameter);    out.println(JSONArray.fromObject(list));    out.flush();    out.close();    return null;  }}