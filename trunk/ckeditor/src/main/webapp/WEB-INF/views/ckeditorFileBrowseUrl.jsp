<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ckeditorFileBrowserBrowseUrl</title>
<script type="text/javascript">
	function selectFile(link){
		window.opener.CKEDITOR.tools.callFunction(1, link);
		window.close();
	}
</script>
</head>
<body>
	<h1>ckeditorFileBrowserBrowseUrl</h1>
	<img ondblclick="selectFile('http://t2.gstatic.com/images?q=tbn:ANd9GcTiscMfxBPE7N9GsQwwIfE4EMc-TMObxph5aM2RtaXTr093fjHefg')" alt="Google" src="http://t2.gstatic.com/images?q=tbn:ANd9GcTiscMfxBPE7N9GsQwwIfE4EMc-TMObxph5aM2RtaXTr093fjHefg">
</body>
</html>