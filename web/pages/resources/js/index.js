/**
 * Created by joker on 14-9-19.
 */
$(function(){
    //添加访问记录
    addNetAccessRecord();
    function addNetAccessRecord(){
        $.post("addNewAccessTime.action",null,function(data){
            console.log(data);
           var result=data.isSuccess;
            if(!result){
                addNetAccessRecord();
            }
        });
    }
});
