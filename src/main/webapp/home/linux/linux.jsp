<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//CN">
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<html>
<% 
	String urlRoot = "http://localhost:8080" + request.getContextPath(); 
%>
  <head>
 	  <link rel= "Shortcut Icon" href= "<%=urlRoot%>/image/favicon.ico" type="image/x-icon" >
  	  <link rel=stylesheet href="<%=urlRoot%>/css/base.css">
  	  <link rel=stylesheet href="<%=urlRoot%>/css/contents/contents.css">
      <title>Linux</title>
  </head>
  <script type="text/javascript" src="<%=urlRoot%>/js/lib/jquery-2.0.3.js"></script>
  <body>
  	<h2>linux启动流程</h2>
  	<div class=contents_p>
1、读取MBR的信息，启动Boot Manager ，Windows使用NTLDR作为Boot Manager，如果您的系统中安装多个版本的Windows，您就需要在NTLDR中选择您要进入的系统。Linux通常使用功能强大，配置灵活的GRUB作为Boot Manager，将在启动管理章节中向您介绍它的使用方式。
2、加载系统内核，启动init进程 ，init进程是Linux的根进程，所有的系统进程都是它的子进程。
3、init进程读取“/etc/inittab”文件中的信息，并进入预设的运行级别，按顺序运行该运行级别对应文件夹下的脚本。脚本通常以“start”参数启动，并指向一个系统中的程序。 通常情况下，“/etc/rcS.d/”目录下的启动脚本首先被执行，然后是“/etc/rcN.d/”目录。例如您设定的运行级别为3,那么它对应的启动目录为“/etc/rc3.d/”。
4、根据“/etc/rcS.d/”文件夹中对应的脚本启动Xwindow服务器“xorg”，Xwindow为Linux下的图形用户界面系统。
5、启动登录管理器，等待用户登录 ，Ubuntu系统默认使用GDM作为登录管理器，您在登录管理器界面中输入用户名和密码后，便可以登录系统。
 	</div>
 </body>
  <script type="text/javascript">
  </script>
</html>