package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(12);
    _jspx_dependants.add("/include/jsp_headers.jsp");
    _jspx_dependants.add("/include/html_headers.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/tlds/struts-html-el.tld");
    _jspx_dependants.add("/WEB-INF/tlds/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/tlds/struts-bean-el.tld");
    _jspx_dependants.add("/WEB-INF/tlds/struts-logic.tld");
    _jspx_dependants.add("/WEB-INF/tlds/struts-logic-el.tld");
    _jspx_dependants.add("/WEB-INF/tlds/struts-tiles.tld");
    _jspx_dependants.add("/WEB-INF/tlds/struts-nested.tld");
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
    _jspx_dependants.add("/WEB-INF/tlds/jade.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fhtml_0026_005flocale;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fjade_005fmenu_0026_005frepository_005fname_005fdisplayer_005fnobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fhtml_005fhtml_0026_005flocale = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fjade_005fmenu_0026_005frepository_005fname_005fdisplayer_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fhtml_005fhtml_0026_005flocale.release();
    _005fjspx_005ftagPool_005fjade_005fmenu_0026_005frepository_005fname_005fdisplayer_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_html_005fhtml_005f0(_jspx_page_context))
        return;
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_html_005fhtml_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:html
    org.apache.struts.taglib.html.HtmlTag _jspx_th_html_005fhtml_005f0 = (org.apache.struts.taglib.html.HtmlTag) _005fjspx_005ftagPool_005fhtml_005fhtml_0026_005flocale.get(org.apache.struts.taglib.html.HtmlTag.class);
    _jspx_th_html_005fhtml_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005fhtml_005f0.setParent(null);
    _jspx_th_html_005fhtml_005f0.setLocale(true);
    int _jspx_eval_html_005fhtml_005f0 = _jspx_th_html_005fhtml_005f0.doStartTag();
    if (_jspx_eval_html_005fhtml_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("<head>\t\r\n");
        out.write("<link rel=\"stylesheet\" href=\"style/common.css\" type=\"text/css\"/>\r\n");
        out.write("<link rel=\"stylesheet\" href=\"style/input_date.css\" type=\"text/css\"/>\r\n");
        out.write("<script type=\"text/javascript\" src=\"style/common.js\"></script>\r\n");
        out.write("<script type=\"text/javascript\" src=\"style/tag.js\"></script>\r\n");
        out.write("<script type=\"text/javascript\" src=\"style/input_date.js\"></script>\r\n");
        out.write("<script type=\"text/javascript\" src=\"style/meizz_date.js\"></script>\r\n");
        out.write("<link rel=\"stylesheet\" type=\"text/css\"  href=\"style/tabs.css\" /> ");
        out.write("\r\n");
        out.write("</head>\r\n");
        out.write("<body>\r\n");
        out.write("you are welcome!\r\n");
        out.write(" ");
        if (_jspx_meth_jade_005fmenu_005f0(_jspx_th_html_005fhtml_005f0, _jspx_page_context))
          return true;
        out.write("  \r\n");
        out.write("</body>\r\n");
        int evalDoAfterBody = _jspx_th_html_005fhtml_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_html_005fhtml_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fhtml_0026_005flocale.reuse(_jspx_th_html_005fhtml_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fhtml_0026_005flocale.reuse(_jspx_th_html_005fhtml_005f0);
    return false;
  }

  private boolean _jspx_meth_jade_005fmenu_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fhtml_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  jade:menu
    jade.core.taglib.MenuDisplayerTag _jspx_th_jade_005fmenu_005f0 = (jade.core.taglib.MenuDisplayerTag) _005fjspx_005ftagPool_005fjade_005fmenu_0026_005frepository_005fname_005fdisplayer_005fnobody.get(jade.core.taglib.MenuDisplayerTag.class);
    _jspx_th_jade_005fmenu_005f0.setPageContext(_jspx_page_context);
    _jspx_th_jade_005fmenu_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fhtml_005f0);
    _jspx_th_jade_005fmenu_005f0.setName("Top");
    _jspx_th_jade_005fmenu_005f0.setRepository("repository");
    _jspx_th_jade_005fmenu_005f0.setDisplayer("TabbedMenuDisplayer");
    int _jspx_eval_jade_005fmenu_005f0 = _jspx_th_jade_005fmenu_005f0.doStartTag();
    if (_jspx_th_jade_005fmenu_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fjade_005fmenu_0026_005frepository_005fname_005fdisplayer_005fnobody.reuse(_jspx_th_jade_005fmenu_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fjade_005fmenu_0026_005frepository_005fname_005fdisplayer_005fnobody.reuse(_jspx_th_jade_005fmenu_005f0);
    return false;
  }
}
