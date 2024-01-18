<#ftl encoding="utf-8">
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body>
        <form class="w3-container" action="" method="post">
            <label><h2>Domanda</h2></label>
            <textarea class="w3-input w3-border"  name="content" rows="4" cols="50" ></textarea>
            <input class="w3-button w3-teal w3-margin" type="submit" value="Invia"/>
            <a href=""><img src="https://www.creativefabrica.com/wp-content/uploads/2021/06/16/Refresh-icon-template-design-vector-Graphics-13455853-1-580x387.jpg" height="60"/></a>
        </form>



        <ul class="w3-ul w3-border">
            <#list questions as q>
               <li>
                    <#if (q.resolved)>
                        <a href="?id=${q.id}&cmd=cancella"><button class="w3-button w3-circle w3-red">X</button></a> 
                        <a href="?id=${q.id}&cmd=derisolvi"><button class="w3-button w3-circle w3-brown">Δ</button></a>
                        <p class="w3-text-green">${q.content}</p>

                        <#else>
                        <a href="?id=${q.id}&cmd=cancella"><button class="w3-button w3-circle w3-red">X</button></a> 
                        <a href="?id=${q.id}&cmd=risolvi"><button class="w3-button w3-circle w3-teal">V</button></a>
                        <p>${q.content}</p>
                    </#if>
                </li>
            </#list>
        </ul>
    </body>
</html>