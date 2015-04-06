<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="toets.Auto" %>
<%@page import="toets.AutoLijst" %>
<%@ page import="java.util.ArrayList" %>
<%

 AutoLijst al = new AutoLijst();
 ArrayList<Auto> autolijst = al.getLijst();
 AutoLijst selectie = new AutoLijst();
 String fout = "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Toets jsp  -  Oussama Ouali</title>
<link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body background="http://www.crazymonkeydefense.com/wp-content/uploads/2013/10/Grey-background-for-site11.jpg">
<div id = "container">
<label>Kies merk:</label>
 <form action = "#" method = "get">
		   <select  name = "merk" id="merk">
		   		<option value = "alle"> alle merken </option>
		   		<option value = "Ford"> ford</option>
		   		<option value = "Opel"> Opel </option>
		   		<option value = "Subaru"> Subaru</option>
		   		<option value = "Mercedes"> Mercedes </option>
		   		<option value = "Ferrari"> Ferarri </option>
		   		<option value = "Citroen"> citroen </option>
		   		<option value = "Mini"> Mini </option>
		   </select>
		   <label>Minimale prijs</label>
		   <input type = "text" name = "minprijs" >
		   <label>Maximale prijs</label>
		   <input type = "text" name = "maxprijs" >
		   <input type = "submit" value= "knop" name="knop">
			</form>
					  
			<%
			int minprijs = 0;
	 		int maxprijs = Integer.MAX_VALUE;
			
		 	if (request.getParameter ("knop") != null) {
		 		
		 		try{
		 		
		 		if (!request.getParameter("minprijs").equals ("") || request.getParameter("minprijs") == null ) {
		 	          minprijs = Integer.parseInt(request.getParameter("minprijs"));
		 	    }  
		 	         
		 		else {
		 	        	minprijs = 0;
		 	         }
		 	         
		 	   if (!request.getParameter("maxprijs").equals ("") || request.getParameter("maxprijs") == null ) {
		 	          maxprijs = Integer.parseInt(request.getParameter("maxprijs"));;
		 	         }      
		 	   
		 	   
		 	         else {
		 	        	maxprijs = Integer.MAX_VALUE;
		 	         }
		 		}
		 		
		  	   
				  catch(NumberFormatException e){
				
					  fout = "Voer een geldig getal in!";
				  }
		 		
		 		finally{
		 			
		 		}
		 	   
		 	   
         	
         	 for( Auto auto: al.getFilter(request.getParameter("merk"), minprijs, maxprijs))
         	 {%>
        	  <div class="autokader">
           <img src="<%=auto.getFoto()%>" alt="<%=auto.getMerk()%> <%= auto.getType()%>">
           <p class="merktype"><%=auto.getMerk()%> <%= auto.getType()%></p>
           <p class="prijs">&euro; <%=auto.getPrijsFormat() %></p>
          </div>
          
          <%} %>
	<%} 
		 	else{%>
		 		<div id="autoselectie"> 
		 		<%for(Auto auto : autolijst){%>
		 		<div class="autokader">
		 			<img src="<%=auto.getFoto()%>" alt="FordFiesta">
		 			<p class="merktype"><%=auto.getMerk()%> <%= auto.getType()%></p>
		 			<p class="prijs">&euro; <%=auto.getPrijsFormat() %></p>
		 			</div>     
		 			<%}
		 		}%>
		 		<img class = "image" src = "http://2.bp.blogspot.com/_7FyvP0F3FmQ/TEbcauGrxqI/AAAAAAAAMig/3Q4PDGN0-U4/s1600/Afbeelding+27.png">
		 			</div> 
		 	</div>
	        
         <p style = "color:red;"><%=fout %></p>
</body>

</html>

