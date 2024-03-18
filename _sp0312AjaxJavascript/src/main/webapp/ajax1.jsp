<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Todo List</h1>
    <input id="todoInput" type="text" placeholder="할 일을 넣으세요">
    <button id="addButton">Add</button> 
    <ul id="todoList">
        <!--할 일 목록 추가-->

    </ul>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(function(){
        	//alert('hello');
        	$.ajax({
        		url:'GetTodos',
        		method:'Get',
        		success:function(data){
        			console.log(data);
        			addItem(data); //0313 추가
        		}
        		
        		
        	});
        });
        
        //function  addItem(data) {
        	//const list = $('#todoList');
       
		//	const item = $('<li></li>').text(data);
			//const removeButton = $('<button></button>').text('삭제');
			//removeButton.click(function)(){
				//$.ajax({
					//url: 'RemoveTodo', //서버에서 할 일을 삭제하는 엔드포인트  ,서블렛요청이름(서블렛클래스이름 아님)
					//method: 'POST',
					//data: { text :data },  //자바스크립트의 객체
					//success : function(){
						//item.remove();
					//}
				//});
			//}
			     //item.append(removeButton);
			//item.append(removeButton);
			//list.append(item);
		//}
        function addItem(data) {
            const list = $('#todoList');
            const item = $('<li></li>').text(data);
            const removeButton = $('<button></button>').text('삭제');
            
            removeButton.click(function() { // 오류 수정: 함수 선언이 올바르게 수정되었습니다.
                $.ajax({
                    url: 'RemoveTodo', // 서버에서 할 일을 삭제하는 엔드포인트
                    method: 'POST',
                    data: { text: data }, // JavaScript 객체 형식으로 전달해야 합니다.
                    success: function() { // 'success'가 올바르게 표기되었습니다.
                        item.remove();
                    }
                });
            });
          //item.append(removeButton);
            item.append(removeButton);
            list.append(item);
        }
    </script>
</body>
</html>