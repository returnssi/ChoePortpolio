    $(document).ready(function(){        
        getBoardList();
    });
 
    function getBoardList(){
        
        $.ajax({            
            type:"GET",
            url:"/board/getBoardList",
            dataType:"JSON",
            success : function(obj) {
                getBoardListCallback(obj);                
            },           
            error : function(xhr, status, error) {}
         });
    }
    
    function getBoardListCallback(obj){
        
        var list = obj;
        var listLen = obj.length;
        
        console.log(list);
        console.log(listLen);
        
        var str = "";
        
        if(listLen >  0){
            
            for(var a=0; a<listLen; a++){
                
                var boardSeq        = list[a].board_seq; 
                var boardReRef         = list[a].board_re_ref; 
                var boardReLev         = list[a].board_re_lev; 
                var boardReSeq         = list[a].board_re_seq; 
                var boardWriter     = list[a].board_writer; 
                var boardSubject     = list[a].board_subject; 
                var boardContent     = list[a].board_content; 
                var boardHits         = list[a].board_hits;
                var delYn             = list[a].del_yn; 
                var insUserId         = list[a].ins_user_id;
                var insDate         = list[a].ins_date; 
                var updUserId         = list[a].upd_user_id;
                var updDate         = list[a].upd_date;
                
                str += "<tr>";
                str += "<td>"+ boardSeq +"</td>";
                str += "<td>"+ boardSubject +"</td>";
                str += "<td>"+ boardHits +"</td>";
                str += "<td>"+ boardWriter +"</td>";                
                str += "</tr>";
                
            } 
            
        } else {
            
            str += "<tr colspan='4'>";
            str += "<td>등록된 글이 존재하지 않습니다.</td>";
            str += "<tr>";
        }
        
        $("#tbody").html(str);
    }