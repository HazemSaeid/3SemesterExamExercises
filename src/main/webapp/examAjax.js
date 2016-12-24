/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    $("#svg2").click(function(event){
        var country = event.target;
        var url = "http://restcountries.eu/rest/v1/alpha?codes=" + country.id;
        $.get( url, function(data){
        $(country).css("fill","red");
        $("#svg2").click(function() {
            $(country).css("fill","#c0c0c0");
        });
//        console.log(data[0].name);
        $("#info").html("");
            for(var k in data[0]) {
                
           console.log(data[0][k]);
           $("#info").append("<tr><td>" + k + "</td><td>" + data[0][k] + "</td></tr>");
           
 
            
            }
        });
    });
});
