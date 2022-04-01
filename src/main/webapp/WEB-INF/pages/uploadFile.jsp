<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>from upload</title>
</head>
<body>
	<form action="uploadfile.controller" method="post"
		enctype="multipart/form-data">
		<p>Please Select picture to upload</p>
		<input type="file" name="myFiles" />
		<button type="submit" value="upload">Upload</button>
	</form>
</body>
</html>