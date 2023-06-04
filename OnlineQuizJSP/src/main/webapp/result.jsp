<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<html>


<jsp:include page="header.jsp"></jsp:include>

<%
String islogin=(String)session.getAttribute("islogin");
if(islogin==null){
request.setAttribute("notlogin_msg","Sorry,Please do Login first");

%>
<jsp:forward page="index.jsp"></jsp:forward>
<%
}
%>




             <% 
					if(request.getAttribute("notlogin_msg")!=null){
					out.print("<font size='2' color='red' m>");
					out.print(request.getAttribute("notlogin_msg"));
					out.print("</font>");
					}
					%>
				<% 
					if(request.getAttribute("Error")!=null){
					out.print("<font size='2' color='red' >");
					out.print(request.getAttribute("Error"));
					out.print("</font>");
					}
					%>
					<%
					
					if(request.getAttribute("finished")!=null){
					   out.print("<font size='2' color='navy'>");
                   out.print("<B>");
					out.print(request.getAttribute("finished"));
					  out.print("<B>");
   						out.print("</font>");
					}
				
					%>
					<%int result =(Integer)request.getAttribute("total");
					System.out.println("result="+result); %>
            	<div class="calendar_box">
            	
                	<div class="calendar_box_content">
               
                		<h1>Welcome to my Site</h1>
           
                	<form action="view.jsp">
                	<p>
                	<font style="color: navy;"><B>Your <%= result %> questions are correct</B></font><BR/>           
                	</p>
					</form>
				
					

                     
    
                </div>
                
  
	<div id="footer">
    
    </div>
</div>
</body></html>

