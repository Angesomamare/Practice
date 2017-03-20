


     </div>

  </body>

</html>

     <br>
     <div class="container">

        <script type="text/javascript"
                src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

        <script type="text/javascript">
         function displayTime() {
          $.ajax({
           url : 'getTime',
           success : function(data) {
            $('#result').html(data);
           }
          });
         }
        </script>

        <script type="text/javascript">
         var intervalId = 0;
         intervalId = setInterval(displayTime, 1000);
        </script>

        <div align="center">
         <%--<br> <br> ${message} <br> <br>--%>
         <div id="result"></div>
        </div>

     </div> <!-- /container -->