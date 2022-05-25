// 타이핑 효과 시작
$(document).ready(function() {
    var text = document.getElementById("typeStyle");

    var typewriter = new Typewriter(text, {
        loop: true
    });

    typewriter.typeString("I'm Developer!")
        .pauseFor(50)
        .deleteAll()
        .typeString('저는 개발자입니다.')
        .pauseFor(50)
        // .deleteChars()
        .deleteAll()
        .typeString('<strong>혁신을 이룹니다.</strong>')
        .pauseFor(50)
        .start();
        // 타이핑 효과 끝
        // 버튼 보이기
        
        //보이기
        setTimeout(function showBtn() {
            const element = document.getElementById('show');
            element.style.display = 'block';
          }, 10000);

          setTimeout(function showBtn() {
            const element = document.getElementById('smalltitle');
            element.style.display = 'none';
          }, 10000);

});
