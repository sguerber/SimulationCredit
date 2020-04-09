<%@ page import="com.mycompany.model.CreditModel" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	CreditModel monModel = (CreditModel) request.getAttribute("monModel");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html:charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form method="post" action="ControleurServlet">
			<table>
				<tr>
					<td>Montant: </td>
					<td><input name='montant' type='text' value='${monModel.getMontant()}'/></td>
					<td></td>
				</tr>
				<tr>
					<td>Durée: </td>
					<td><input name='duree' type='text' value='${monModel.getDuree()}'/></td>
					<td></td>
				</tr>
				<tr>
					<td>Taux: </td>
					<td><input name='taux' type='text' value='${monModel.getTaux()}'/></td>
					<td></td>
				</tr>
				<tr>
					<td><input name="Calculer" type='submit'/></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<table>
			<tr>
				<td>Mensualité: </td>
				<td> ${monModel.getMensualite()}</td>
			</tr>
		</table>
	</div>
</body>
</html>