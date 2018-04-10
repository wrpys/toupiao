package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Sqlcon;

public class Bzjs_mod extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    response.setContentType("text/html");
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("GB2312");
    PrintWriter out = response.getWriter();
    String content_info = request.getParameter("content_info").trim();
    System.out.println(content_info);
    Connection conn = null;
    PreparedStatement stat = null;
    try
    {
      conn = Sqlcon.getConnection();
      stat = conn.prepareStatement(" update T_web set  content_info = '" + content_info + "'");

      stat.executeUpdate();
      out.print("<script language=\"JavaScript\">alert(\"ÐÞ¸Ä³É¹¦ !\"); window.location.href='admin/bzjs/bzjs_xg.jsp'; </script>");
    }
    catch (Exception e)
    {
      out.println(e);
      try
      {
        stat.close();
        conn.close();
      }
      catch (SQLException e1)
      {
        e1.printStackTrace();
      }
    }
    finally
    {
      try
      {
        stat.close();
        conn.close();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }	
}