<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
</head>
<body>
	<form action="" method="post">
		<p>
			<label for="editor1">Editor 1:</label>
			<textarea cols="80" id="editor1" name="editor1" rows="10"></textarea>
		</p>
		<p>
			<input type="submit" value="Submit" />
		</p>
	</form>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>
	<script type="text/javascript">//<![CDATA[
		CKEDITOR.replace('editor1', {
		    filebrowserBrowseUrl: '${pageContext.request.contextPath}/editor/browser',
		    filebrowserUploadUrl: '${pageContext.request.contextPath}/editor/upload',
		    skin : 'moonocolor'
		});
		CKEDITOR.on('dialogDefinition', function( ev )
		{
		   var dialogName = ev.data.name;  
		   var dialogDefinition = ev.data.definition;
		   switch (dialogName) {  
			   case 'image': //Image Properties dialog      
			   dialogDefinition.removeContents('Link');
			   dialogDefinition.removeContents('advanced');
			   break;
			   case 'link': //image Properties dialog          
			   dialogDefinition.removeContents('advanced');   
			   break;
		   }
		});
	//]]>
	</script>
</body>
</html>