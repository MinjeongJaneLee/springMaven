/**
 * 시스템 공통 Javascript 라이브러리
 */
var cfn = {};
cfn.maskShow = function () {
    var maskHtml = '';
    maskHtml += '<div class="md-bd-mask">';
    maskHtml += '<div>';
    maskHtml += '<img src="'+CONTEXT_PATH+'/img/spinners/spinner_danger.gif" alt="loading"/>';
    maskHtml += '</div>';
    maskHtml += '</div>';
    $("body").addClass('md-bd-mask-body').prepend(maskHtml);
};
cfn.maskHide = function () {
    $("body").removeClass('md-bd-mask-body');
    $(".md-bd-mask").remove();
};
cfn.openPopup = function (title, uri, width, height, scroll) {
    if( scroll == undefined)
        scroll = 'yes';

    var nLeft  = screen.width/2 - width/2 ;
    var nTop  = screen.height/2 - height/2 ;
    if( scroll == null ) scroll = "no";
    var opt = ',toolbar=no,menubar=no,location=no,status=no,resizable=no,scrollbars=' + scroll;
    var winName = window.open(uri, title, 'left=' + nLeft + ',top=' +  nTop + ',width=' + width + ',height=' + height + opt );

    if(!winName){
        alert('팝업차단을 해제해주세요.');
        return;
    }

    winName.focus();
};
cfn.setNavSelection = function () {
    var locck = $('.page_check').attr('data');
    if( locck == undefined )
        return;

    $('.menu_section a').each(function(){
        var url = $(this).attr('href');
        if(url == 'javascript:;')
            url = $(this).attr('data-url');

        var limatch = url.match(locck);

        if(limatch){
            $(this).closest('.padding>li').addClass('current_section');
            $(this).addClass('on');
        }
    });
};
cfn.setNavSelection();
cfn.logout = function (logoutUrl) {
    if (confirm('로그아웃 하시겠습니까?')) {
        location.href = logoutUrl;
    }
};