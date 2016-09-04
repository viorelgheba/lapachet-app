<!DOCTYPE html>
<html lang="en">

    <head>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">

        <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
        <script><#include "jquery.serializejson.js"></script>
    </head>

    <body>
        <div class="container">
            <div id="navbar" class="navbar navbar-default ace-save-state">
                <div class="navbar-header pull-left">
                    <a class="navbar-brand" href="#">
                        <small>
                        <i class="fa fa-leaf"></i>
                            LaPachet
                        </small>
                    </a>
                </div>
            </div>

            <div class="col-md-2">
                <#include "menu.ftl">
            </div>

            <div class="col-md-2"></div>
            <div class="col-md-6">
                <h1>TITLE</h1>

            </div>
        </div>
        <div id='loadingmessage' style='display:none'>
            <!--<img src='/loading.gif'/>-->
        </div>
    </body>

</html>
