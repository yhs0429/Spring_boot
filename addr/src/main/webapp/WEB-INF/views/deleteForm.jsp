<%@ page contentType="text/html; charset=UTF-8" %> 
 
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
  <style type="text/css">
   #red{
   	color : red;
   }
  </style>
</head>
<body>
<div class="container">
<h1 class="col-sm-offset-2 col-sm-10">삭제</h1>
<form class="form-horizontal" 
      action="/addr/delete"
      method="post"
      >
 <input type="hidden" name="addressnum" value="<%=request.getParameter("addressnum") %>">
  
	<p id="red" class="col-sm-offset-2 col-sm-6">삭제하면 복구할 수 없습니다.</p>
  
   <div class="form-group">
   <div class="col-sm-offset-2 col-sm-5">
    <button class="btn">삭제</button>
    <button type="reset" class="btn" onclick="location.href='/addr/list'">취소</button>
   </div>
 </div>
</form>
</div>
</body> 
</html> 