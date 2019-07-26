<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<script type="text/javascript">
   
    function find(url)
    { 
    	
    	document.getElementById("name").value="";
    	document.getElementById("pwd").value="";
    	
    	$.ajax({
    		type:"post",
    		url:url,
    		datatype:"json",
    		success:function(data){
    			data = eval("("+data+ ")");
    			var html = "";
    			//删除表格第一行的内容
    			$("table tr:not(:first)").remove();
    			for(var i = 0 ; i<data.length;i++)
    				{
    				   html+="<tr id="+i+">";  //<tr id=0> <td></td>val</td>val<td>del</td><td>update</td></tr>
    				       $.each(data[i],function(j,val){
    				    	   html+="<td>"+val+"</td>";
    				    	 if(j =='id')
    				    		 {
    				    	 html+="<td> <a href='javascript:void(0)' onclick=del('deleServlet?id="+val+"')>删除</a></td>";
    				    	 html+="<td> <a href='javascript:void(0)' onclick=update('updateServlet?id="+val+"')>更新</a></td>";
    				    		 }
    				       });
    				       html+="</tr>";
    				    
    				}
    			  $("#first").after(function(){
    				 return html; 
    			  });
    			
    		}
    		
    	});
    }

    function del(url)
    {
    	url="deleServlet?id=101";
    	uri = url.substr(0,11);
    	val = url.substr(15);
    	location.href=url;
    	$.ajax({
    		url:uri,
    		data:{"id":val},
    		datatype:"json",
    		success:function( data)
    		{
    			
    		}
    	})
    	
    }
    
    
   function addUser(url)
   {
	   var name =	document.getElementById("name").value;
	   var pwd = 	document.getElementById("pwd").value
	   $.ajax({
		   type:"post",
		   url:url,
		   data:{
			   "name":name,
			   "pwd":pwd
		   },
		   datatype:"json",
		   success:function(data){
			   $("p").html(data)
			   find("findAll");
		   }
	   });
	
	  
   }

</script>
</head>
<body onload="find('findAll')">
    <input type="text" id="id" hidden="hidden">
     用户名<input type="text" id="name">
  密&nbsp;&nbsp;码<input type="password" id="pwd">
  <input type="button" value="新增" onclick="addUser('AddServlet')"> 
    <input type="button" value="更新" onclick="updateUser()"> 
      <input type="button" value="删除" onclick="deleteUser()"> 
      <p></p>
      <hr>
      <h1>用户页面显示</h1>
      <table>
       <tr id="first">
         <td>ID</td>
         <td>用户名</td>
         <td>密码</td>
         <td>删除</td>
         <td>更新</td>
       </tr>
      
      </table>
</body>
</html>