// If absolute URL from the remote server is provided, configure the CORS
// header on that server.

let query = window.location.search;
let param = new URLSearchParams(query);
let pdfViewer = param.get('pdfViewer');

console.log(pdfViewer);


var url = '../resources/files/'+pdfViewer+'.pdf';


if(pdfViewer==="clientside"){
    pdfViewer = "클라이언트 사이드 (Client Side)";
}else if(pdfViewer==="cloudcomputing"){
    pdfViewer = "클라우드 컴퓨팅 (Cloud Computing)";
}else if(pdfViewer==="Datastructure"){
    pdfViewer = "데이터베이스 설계 (Database Design)";
}else if(pdfViewer==="java"){
    pdfViewer = "자바 프로그래밍 (JAVA)";
}else if(pdfViewer==="MobileAppDEV"){
    pdfViewer = "모바일앱개발 (Mobile App DEV)";
}else if(pdfViewer==="serverside"){
    pdfViewer = "서버 사이드 프로그래밍 (Server Side Programming)";
}else if(pdfViewer==="system"){
    pdfViewer = "시스템 분석 및 설계 (System Analysis and Design)";
}

document.getElementById('filePath').innerHTML=pdfViewer;



// Loaded via <script> tag, create shortcut to access PDF.js exports.
var pdfjsLib = window['pdfjs-dist/build/pdf'];

// The workerSrc property shall be specified.

pdfjsLib.GlobalWorkerOptions.workerSrc = '//mozilla.github.io/pdf.js/build/pdf.worker.js';

var pdfDoc = null,
    pageNum = 1,
    pageRendering = false,
    pageNumPending = null,
    scale = 0.8,
    canvas = document.getElementById('the-canvas'),
    ctx = canvas.getContext('2d');

/**
 * Get page info from document, resize canvas accordingly, and render page.
 * @param num Page number.
 */
function renderPage(num) {
  pageRendering = true;
  // Using promise to fetch the page
  pdfDoc.getPage(num).then(function(page) {
    var viewport = page.getViewport({scale: scale});
    canvas.height = viewport.height;
    canvas.width = viewport.width;

    // Render PDF page into canvas context
    var renderContext = {
      canvasContext: ctx,
      viewport: viewport
    };
    var renderTask = page.render(renderContext);

    // Wait for rendering to finish
    renderTask.promise.then(function() {
      pageRendering = false;
      if (pageNumPending !== null) {
        // New page rendering is pending
        renderPage(pageNumPending);
        pageNumPending = null;
      }
    });
  });

  // Update page counters
  document.getElementById('page_num').textContent = num;
}

/**
 * If another page rendering in progress, waits until the rendering is
 * finised. Otherwise, executes rendering immediately.
 */
function queueRenderPage(num) {
  if (pageRendering) {
    pageNumPending = num;
  } else {
    renderPage(num);
  }
}

/**
 * Displays previous page.
 */
function onPrevPage() {
  if (pageNum <= 1) {
    return;
  }
  pageNum--;
  queueRenderPage(pageNum);

  if(pageNum===1){
    document.getElementById("prev").hide();
  }else if(pageNum>2){
    document.getElementById("prev").show();
  }
}
document.getElementById('prev').addEventListener('click', onPrevPage);


/**
 * Displays next page.
 */
function onNextPage() {
  if (pageNum >= pdfDoc.numPages) {
    return;
  }
  pageNum++;
  queueRenderPage(pageNum);
}
document.getElementById('next').addEventListener('click', onNextPage);

/**
 * Asynchronously downloads PDF.
 */
pdfjsLib.getDocument(url).promise.then(function(pdfDoc_) {
  pdfDoc = pdfDoc_;
  document.getElementById('page_count').textContent = pdfDoc.numPages;

  // Initial/first page rendering
  renderPage(pageNum);
});


