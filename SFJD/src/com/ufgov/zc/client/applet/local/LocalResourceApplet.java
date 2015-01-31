/**
 * 
 */
package com.ufgov.zc.client.applet.local;

import java.applet.Applet;
import java.awt.Window;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.swing.JApplet;

/**
 * @author Administrator
 *
 */
public class LocalResourceApplet extends MyBaseApplet {

  private static final Logger LOG = Logger.getLogger("LocalResourceApplet");

  private static boolean haveLoadJar = false;

  private static String oldTorken = "";

  private final String[] paramNames = new String[] { "panelClassName", "token", "clientIP", "transDate", "userId", "coCode", "orgCode", "orgPoCode",
    "poCode", "webRoot", "webIp", "accountId", "empCode", "empName", "urlArray" };

  private Window appletWindow;

  private Map parameterInfo = new HashMap();

  /**
   * 
   */
  private static final long serialVersionUID = 1401479333821197886L;

  public void init() {
    super.init();
    try {
      initAppletParameters();
      if (oldTorken == null || !oldTorken.equals((String) parameterInfo.get("token"))) {
        oldTorken = (String) parameterInfo.get("token");
        downloadResource();
        loadLocalJars();
      }
      initApplet();
    } catch (Exception e) {
      e.printStackTrace();
      LOG.info(e.getMessage());
    }
  }

  private void loadLocalJars() throws Exception {
    // TODO Auto-generated method stub

    ClassLoaderUtil lu = new ClassLoaderUtil();
    lu.loadJarPath(DownLoadManager.localJarUrl);

    haveLoadJar = true;
  }

  private void initApplet() throws Exception {
    // TODO Auto-generated method stub
    String className = "com.ufgov.zc.client.applet.LocalResouceAppletUtil";
    try {
      Class c = Class.forName(className);
      Method m[] = c.getDeclaredMethods();

      Object obj = c.newInstance();

      Object[] args = new Object[] { (Applet) this };
      final Class[] argsClass = new Class[args.length];
      for (int i = 0, j = args.length; i < j; i++) {
        argsClass[i] = args[i].getClass();
      }
      Method method = c.getMethod("initApplet", JApplet.class);
      method.invoke(obj, args);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      throw e;
    }
  }

  private void downloadResource() {
    // TODO Auto-generated method stub
    DownLoadManager.downResource((String) parameterInfo.get("webRoot"), (String) parameterInfo.get("token"));

  }

  private void initAppletParameters() {
    for (int i = 0; i < paramNames.length; i++) {
      parameterInfo.put(paramNames[i], this.getParameter(paramNames[i]));
      //      System.out.println(paramNames[i] + "=" + this.getParameter(paramNames[i]));
    }
    this.setProps(parameterInfo);
  }

  public static void main(String[] args) {
    LocalResourceApplet a = new LocalResourceApplet();
    try {
      a.initApplet();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
