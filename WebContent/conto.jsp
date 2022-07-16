<%@page import="org.apache.openjpa.jdbc.kernel.JDBCStoreQuery"%>
<%@page import="it.data.ContoCorrente"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Da utilizzare per se stessi -->
<!-- <link rel="stylesheet" href="css/bootstrap.css">-->
<!-- Da utilizzare per correggere -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<title>Conto</title>
</head>

<body>
<%@ page isELIgnored="false" %>
<%ContoCorrente conto=(ContoCorrente)session.getAttribute("Conto");
 String operazione=(String)session.getAttribute("Operazione"); 
 Float quantita=(Float)session.getAttribute("Quantita");%>
<div class="container d-flex flex-column justify-content-center align-items-center text-center mt-5"> 
<div class="text-center fw-bold">Operazione di  <%if(operazione.equals("saldo")){%>
Controllo Conto Corrente
<%}else if(operazione.equals("versamento")){%>
Versamento, Quantitativo:  <%=quantita%> €
<%}else if(operazione.equals("prelievo")){%>
Prelievo, Quantitativo: <%=quantita%> €
<%} else if(operazione.equals("sbagliato")){%>
Ops!!! Qualcosa è andato storto, controlla se il tuo Pin è corretto <br> 
o il numero Conto è giusto, oppure se la quantita del prelevamento immessa è superiore al tuo saldo;
<%} %>
</div>
<div class="card" style="width: 40rem;">
  <div class="card-body">
    <h3 class="card-title">Conto di: <%=conto.getInstestatario()%></h3>
    <p class="card-text">Saldo del conto: <%=conto.getSaldo()%> € <br>
    Pin del conto: <%=conto.getPin()%>
    </p>
    
  </div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>