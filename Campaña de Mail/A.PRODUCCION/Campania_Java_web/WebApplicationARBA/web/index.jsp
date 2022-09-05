<%-- 
    Document   : index
    Created on : 11 may. 2022, 14:32:07
    Author     : oscar.avendano
--%>


<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="estilo.css">
</head>

<body>

    <header>
    </header>
   
    <form action ="index.jsp"  method="post" >
    

        <section class="prueba">
            <nav class="c-navbar">
                <div class="etiqueta">

                    <p class="o-navbar"> ARBA 
                    <span class="o-logo__claim">Agencia de recaudación provincia de buenos aires</span>
                </p>
                </div>
            </nav>
        </section>


        <section class="Section_1"> <!--la etiqueta section tiene uso como: contenedor general en el uso del Display:flex; -->

            <div  id="top">    

                <div id="opcionesImpustos">
                  
                    <select class="Tamaño-Letra" id="select" name = "impuestoTipo">
                        <option value="1">Impuesto Automotor</option>
                        <option value="2">Impuesto a las Embarcaciones</option>
                        <option value="3">Impuesto Urbano Edificado</option>
                        <option value="4">Impuesto Urbano Baldío</option>
                        <option value="5">Impuesto Rural</option>
                        <option value="6">Impuesto Complementario</option>
                    </select> <br><br>

                    <input type="date" class="Tamaño-Letra" id="fechas" name ="fecha">
                </div>


                <div id="ChBox">

                    <label class="Tamaño-Letra"><input type="checkbox" id="cbox1" value="conAnual" name= "conAnual">Con Anual</label>
                    <label class="Tamaño-Letra"><input type="checkbox" checked="checked" id="cbox2" value="conCabecera" name= "conCabecera">Con Cabecera</label>
                    <label class="Tamaño-Letra"><input type="checkbox" id="cbox3" value="diferenciar mails" name= "diferenciarMails" >diferenciar mails</label><br>
                    <label class="Tamaño-Letra"><input type="checkbox" id="cbox4" value="correccion Mayusculas" name= "correccionMayusculas">Correccion Mayusculas (Razón Social)</label><br><br>

                    <input type="text" id="Subscripciones" name="Subscripciones" value="10"><label for="CantidadSubscripciones" class="Tamaño-Letra" >  Cantidad de Subscripciones</label><br>
                    <input type="number" id="Corte" name="Corte" value="10"><label for="name" class="Tamaño-Letra">  Cortar c/  </label>

                </div>

            </div> 

        </section>   
        
        <section class = "section_2">  

            <div id="middle">

                <div   class="LocalRed">
                    <div id="centrado">    
                        <input type="radio" class="Tamaño-Letra" name="drone" value="A carpeta Local" checked>
                        <label for="huey" class="Tamaño-Letra">A carpeta Local</label><br><br>
                        <input type="radio" class="Tamaño-Letra" name="drone" value="A Red">
                        <label for="dewey" class="Tamaño-Letra">A Red</label>
                    </div>    
                </div>


                <div id="ArchivoDi">   
                            
                  <input type="file" accept=".txt" class="Tamaño-Letra" class="boton" id="PATH" name="path" style= "background-color: rgb(174, 231, 235) "><br><br> 
                        
                </div>
                
                <button class="Tamaño-Letra"  type="submit" onclick="limpiarInputfile(ArchivoDi)"  class="botonGenerar"> Limpiar File </button> <br>


            <div id="centrado"> 
              <label class="Tamaño-Letra">Asignar URL:</label>
              <input type="text" id="name" name="URLtextManual"  size="80" class="Tamaño-Letra"  value=""><br><br>
            </div>
                
        <%@ page import = "Logica.Proceso"%>
        
        <% 
            
            Proceso Proc = new Proceso(); 

            String Impuesto = request.getParameter("impuestoTipo"); 
            String cantSubscrip = request.getParameter("Subscripciones");
            String cortarCada = request.getParameter("Corte");
            String Fecha = request.getParameter("fecha");
            String CheckAnual= request.getParameter("conAnual");
            String CheckCabecera= request.getParameter("conCabecera");
            String ChecDiferenciar= request.getParameter("diferenciarMails");
            String CheckMayus= request.getParameter("correccionMayusculas");
            String Radio= request.getParameter("drone");
            String Path = request.getParameter("path"); 
            String url ="";

           if (Path == null ) {Path = ""; }

                ///Impuesto:URL
                if (Path == ""){}else{
                
                    Proc.ImpuestoComboBox(Impuesto);
                    url  =  Proc.GetURL();

                   ///si se selecciona una nueva URL, esta debe tomarse. 

                    String asignar = request.getParameter("URLtextManual");

                    if (asignar != ""){
                      url = asignar;
                    }

                   if (cantSubscrip == null ) {cantSubscrip = "0"; }
                   if (CheckAnual == null ) {CheckAnual = ""; }
                   if (CheckCabecera == null ) {CheckCabecera = ""; }
                   if (ChecDiferenciar == null ) {ChecDiferenciar = ""; }
                   if (CheckMayus == null ) {CheckMayus = ""; }
                   if (Radio == null ) {Radio = ""; }
                   
              

            Proc.Generar(cantSubscrip,cortarCada,Fecha, CheckAnual, CheckCabecera, ChecDiferenciar, CheckMayus, Radio, url, Path);

            }

           %>  
          
           <!--<input type="text" id="name" name="URLtext"  size="80" class="Tamaño-Letra"  value=" impuesto: <%= Impuesto%>"><br><br>-->
           
          

                  <div class="LocalRed">
                    <div id="centrado"> 
                        <label for="name" class="Tamaño-Letra"id="url">URL</label>
                        <input type="text" id="name" name="URLtext"  size="80" class="Tamaño-Letra"  value=<%= url%>><br><br>          
                    </div>
                </div>        

  
           <div class="botongenerarDiv">

             <button class="Tamaño-Letra"  type="submit"  onclick="Checkeo()" class="botonGenerar"> Generar </button>

           </div><br>

           </div><br>
        </section><!--  2  -->
    </form> 
                
                
    <section class ="section_3">      

        <div id="bottom">
        
            <div   class="barras">
                <br>
                <label for="file" id="barrita" class="Tamaño-Letra">Subscripciones Leidas:</label>

                <progress id="file" class="Tamaño-Letra"max="100" value="70"> 70% </progress><br><br><br>

                <label for="file" id="barrita" class="Tamaño-Letra">Mail Generados:</label>

                <progress id="file"  class="Tamaño-Letra"max="100" value="70"> 70% </progress>

            </div><br><br>     

            <div id="Resultados">
                <label for="name" class="Tamaño-Letra">Subscripciones leidas</label>
                <input type="text" id="name" class="Tamaño-Letra"name="name"  />
                <label for="name" class="Tamaño-Letra">De</label>
                <input type="text" id="name" class="Tamaño-Letra" name="name" value ="<%= cantSubscrip%> "/> 
            </div> 

        </div>

    </section>
    
    <footer>

    </footer>
</body>

<script>
    
    Archivo = document.getElementById("PATH");

    function Checkeo(){
     if(Archivo.value == ""){alert("No se seleccionó Archivo");}
    
    }

    function limpiarInputfile(id) {
        var input = $('#' + id);
        var clon = input.clone();  // Crear un clon del elemento original
        input.replaceWith(clon);   // sustituir el original por el clon
        alert("limpiar");
    }

</script>


<!-- Sector pruebas 
                 
                 <input type="text" id="name" name="URLtext"  size="80" class="Tamaño-Letra"  value="cantidad: <%= cantSubscrip %>"><br><br>
                <input type="text" id="name" name="URLtext"  size="80" class="Tamaño-Letra"  value=" cortar cada:  <%= cortarCada %>"><br><br>
     
                <input type="text" id="name" name="URLtext"  size="80" class="Tamaño-Letra"  value="fecha:  <%=  Fecha%>"><br><br>
                <input type="text" id="name" name="URLtext"  size="80" class="Tamaño-Letra"  value="anual: <%=  CheckAnual%>"><br><br>
                <input type="text" id="name" name="URLtext"  size="80" class="Tamaño-Letra"  value="cabecera:  <%=  CheckCabecera%>"><br><br>
                <input type="text" id="name" name="URLtext"  size="80" class="Tamaño-Letra"  value="Diferenciar: <%=  ChecDiferenciar%>"><br><br>
                <input type="text" id="name" name="URLtext"  size="80" class="Tamaño-Letra"  value="matusculas: <%=  CheckMayus%>"><br><br>
             
///////////////////////////-->  



</html>

