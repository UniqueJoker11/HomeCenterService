/**
 * Created by ASUS on 2015/4/24.
 */
$(function(){
    //获取所有的悄悄话内容
    initWhisperInfoList();
    function initWhisperInfoList(){
        $.post("getWhisperInfo.action",function(data){
          if(data.isSuccess&&data.retsultData.length!=0){
              var showContent="";
              for(var i=0;i<data.retsultData.length;i++){
                  showContent+="<ul class=\"arrow_box\">"
                      +"<div class=\"sy\">"
                      +"<p>"+data.retsultData[i].whisper_content+"</p>"
                      +"</div>"
                      +"<span class=\"dateview\">"+data.retsultData[i].create_time+"</span>"
                  +"</ul>"
              }
              $("#whisperList").html(showContent);
          }
        });
    }
})