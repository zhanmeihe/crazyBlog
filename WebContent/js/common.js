//窗口自适应事件
(function(win,doc){
    function change(){
        doc.documentElement.style.fontSize=doc.documentElement.clientWidth/750*100+'px';
    }
    change();
    win.addEventListener('resize',change,false);
})(window,document);